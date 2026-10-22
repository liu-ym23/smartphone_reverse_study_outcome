package com.stepos.deepbinder.client.cache;

import Z8.F;
import android.content.ComponentName;
import android.net.Uri;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCThreadCaller;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/deepbinder/client/cache/ListenerCache;", "", "<init>", "()V", "getInstance", "()Lcom/stepos/deepbinder/client/cache/ListenerCache;", "Landroid/content/ComponentName;", "componentName", "LY8/t;", "notifyProcessDisconnect", "(Landroid/content/ComponentName;)V", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "listener", "registerProcessStateListener", "(Lcom/stepos/deepbinder/client/api/ProviderStateListener;)V", "Landroid/net/Uri;", "uri", "registerProviderObserver", "(Landroid/net/Uri;)V", "unRegisterProcessStateListener", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "stateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "uriSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "com/stepos/deepbinder/client/cache/ListenerCache$contentObserver$1", "contentObserver", "Lcom/stepos/deepbinder/client/cache/ListenerCache$contentObserver$1;", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListenerCache {
    private static final String TAG = "ListenerCache";
    public static final ListenerCache INSTANCE = new ListenerCache();
    private static final CopyOnWriteArrayList<ProviderStateListener> stateListeners = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArraySet<Uri> uriSet = new CopyOnWriteArraySet<>();
    private static final ListenerCache$contentObserver$1 contentObserver = new ListenerCache$contentObserver$1(IPCThreadCaller.INSTANCE.getSchedulerHandler());

    private ListenerCache() {
    }

    public final ListenerCache getInstance() {
        return this;
    }

    public final void notifyProcessDisconnect(ComponentName componentName) {
        p.i(componentName, "componentName");
        Iterator it = F.V0(stateListeners).iterator();
        while (it.hasNext()) {
            try {
                ((ProviderStateListener) it.next()).onProviderStop(componentName);
            } catch (Exception e10) {
                IPCLog.INSTANCE.e(TAG, "[onReceive][onProcessStop] exception: " + e10, new Object[0]);
            }
        }
    }

    public final void registerProcessStateListener(ProviderStateListener listener) {
        p.i(listener, "listener");
        stateListeners.add(listener);
    }

    public final void registerProviderObserver(Uri uri) {
        p.i(uri, "uri");
        CopyOnWriteArraySet<Uri> copyOnWriteArraySet = uriSet;
        if (copyOnWriteArraySet.contains(uri)) {
            return;
        }
        try {
            DeepBinderClient.INSTANCE.getContext().getContentResolver().registerContentObserver(uri, false, contentObserver);
            copyOnWriteArraySet.add(uri);
        } catch (Exception e10) {
            IPCLog.INSTANCE.w(TAG, "[registerProviderObserver] exception: " + e10, new Object[0]);
        }
    }

    public final void unRegisterProcessStateListener(ProviderStateListener listener) {
        p.i(listener, "listener");
        CopyOnWriteArrayList<ProviderStateListener> copyOnWriteArrayList = stateListeners;
        copyOnWriteArrayList.remove(listener);
        if (copyOnWriteArrayList.isEmpty()) {
            uriSet.clear();
        }
    }
}
