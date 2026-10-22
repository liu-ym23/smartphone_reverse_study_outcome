package i9;

import android.content.ComponentName;
import android.database.ContentObserver;
import android.net.Uri;
import androidx.appcompat.app.l;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.deepbinder.core.log.IPCLog;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.g;
import w9.e;
import x9.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<ProviderStateListener> f9578a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArraySet<Uri> f9579b = new CopyOnWriteArraySet<>();

    /* renamed from: c, reason: collision with root package name */
    public static final C0093a f9580c = new C0093a(e.f13612e.a().f13615b);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: i9.a$a, reason: collision with other inner class name */
    public static final class C0093a extends ContentObserver {
        @Override // android.database.ContentObserver
        public final void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (uri != null) {
                try {
                    ComponentName componentNameD = c.d(URLDecoder.decode(uri.toString(), "utf-8"));
                    if (componentNameD == null) {
                        IPCLog.INSTANCE.w("ListenerCache", "[onChange] uri is not valid", new Object[0]);
                        return;
                    }
                    Iterator<ProviderStateListener> it = a.f9578a.iterator();
                    while (it.hasNext()) {
                        e.f13612e.b(new l(17, it.next(), componentNameD), true, false);
                    }
                } catch (Exception e10) {
                    IPCLog.INSTANCE.w("ListenerCache", "[onChange] exception: " + e10, new Object[0]);
                }
            }
        }
    }

    public static void a(ComponentName componentName) {
        g.f(componentName, "componentName");
        Iterator it = kotlin.collections.a.F0(f9578a).iterator();
        while (it.hasNext()) {
            try {
                ((ProviderStateListener) it.next()).onProviderStop(componentName);
            } catch (Exception e10) {
                IPCLog.INSTANCE.e("ListenerCache", "[onReceive][onProcessStop] exception: " + e10, new Object[0]);
            }
        }
    }

    public static void b(Uri uri) {
        CopyOnWriteArraySet<Uri> copyOnWriteArraySet = f9579b;
        if (copyOnWriteArraySet.contains(uri)) {
            return;
        }
        try {
            DeepBinderClient.INSTANCE.getContext().getContentResolver().registerContentObserver(uri, false, f9580c);
            copyOnWriteArraySet.add(uri);
        } catch (Exception e10) {
            IPCLog.INSTANCE.w("ListenerCache", "[registerProviderObserver] exception: " + e10, new Object[0]);
        }
    }
}
