package com.bytedanceos.common.ui.listener;

import android.content.ContextWrapper;
import android.os.Handler;
import com.bytedanceos.common.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class KObserverManager<K> {
    private HashMap<K, Observer> mAppObservers;
    private IKObserver mKObserver;
    private Handler mMainHandler;

    public KObserverManager(ContextWrapper r10, IKObserver<K> r11) {
        this.mMainHandler = new Handler(r10.getMainLooper());
        this.mKObserver = r11;
    }

    public static /* synthetic */ Handler access$000(KObserverManager r10) {
        return r10.mMainHandler;
    }

    public static /* synthetic */ IKObserver access$100(KObserverManager r10) {
        return r10.mKObserver;
    }

    public void add(final K r10) {
        if (this.mAppObservers != null) goto L5;
        this.mAppObservers = new HashMap();
    L5:
        Observer r11 = this.mAppObservers.get(r10);
        if (r11 != null) goto L8;
        r11 = new AnonymousClass1(this, r10);
        this.mAppObservers.put(r10, r11);
    L8:
        BaseApplication.c().b().addObserver(r11);
    }

    public void clear() {
        HashMap<K, Observer> r10 = this.mAppObservers;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<K, Observer>> r11 = r10.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<K, Observer> r12 = r11.next();
        BaseApplication.c().b().deleteObserver(r12.getValue());
        goto L7
    L9:
        this.mAppObservers.clear();
    }

    public void remove(K r10) {
        HashMap<K, Observer> r11 = this.mAppObservers;
        if (r11 != null) goto L5;
        return;
    L5:
        Observer r12 = r11.get(r10);
        if (r12 == null) goto L8;
        BaseApplication.c().b().deleteObserver(r12);
    L8:
        this.mAppObservers.remove(r10);
    }
}
