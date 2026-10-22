package com.stepos.deepbinder.client.cache;

import I4.l;
import android.content.ComponentName;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCThreadCaller;
import com.stepos.deepbinder.core.utils.IPCUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/deepbinder/client/cache/ListenerCache$contentObserver$1", "Landroid/database/ContentObserver;", "", "selfChange", "Landroid/net/Uri;", "uri", "LC7/r;", "onChange", "(ZLandroid/net/Uri;)V", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListenerCache$contentObserver$1 extends ContentObserver {
    public ListenerCache$contentObserver$1(Handler handler) {
        super(handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onChange$lambda$2$lambda$1$lambda$0(ProviderStateListener providerStateListener, ComponentName componentName) {
        try {
            providerStateListener.onProviderStart(componentName);
        } catch (Throwable th) {
            IPCLog.INSTANCE.w("ListenerCache", "[onChange][onProcessStart] exception: " + th, new Object[0]);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, @Nullable Uri uri) throws UnsupportedEncodingException {
        super.onChange(selfChange, uri);
        if (uri != null) {
            try {
                ComponentName componentNameQueryComponentNameFromAuthority = IPCUtils.INSTANCE.queryComponentNameFromAuthority(URLDecoder.decode(uri.toString(), "utf-8"));
                if (componentNameQueryComponentNameFromAuthority == null) {
                    IPCLog.INSTANCE.w("ListenerCache", "[onChange] uri is not valid", new Object[0]);
                    return;
                }
                Iterator it = ListenerCache.stateListeners.iterator();
                while (it.hasNext()) {
                    IPCThreadCaller.INSTANCE.post(true, false, new l(21, (ProviderStateListener) it.next(), componentNameQueryComponentNameFromAuthority));
                }
            } catch (Exception e) {
                IPCLog.INSTANCE.w("ListenerCache", "[onChange] exception: " + e, new Object[0]);
            }
        }
    }
}
