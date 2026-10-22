package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.model.BackendItem;
import com.bytedance.android.livesdkapi.model.ErrorBackendItem;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Class<?>, a0> f159194a;

    public final void a() {
        Iterator r100 = ((HashMap) this.f159194a).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        a0 r101 = (a0) ((Map.Entry) r100.next()).getValue();
        if (r101.f158813d == true) goto L4;
        ErrorBackendItem r102 = new ErrorBackendItem();
        ObservableEmitter<BackendItem> r103 = r101.f158811b;
        if (r103 == null) goto L4;
        r103.onNext(r102);
        r101.f158813d = true;
        goto L4
    }

    public w() {
        this.f159194a = new HashMap();
    }

    public final Observable<BackendItem> c(Class<?> r100) {
        if (this.f159194a != null) goto L5;
        this.f159194a = new HashMap();
    L5:
        a0 r101 = this.f159194a.get(r100);
        if (r101 != null) goto L9;
        r101 = new a0();
        this.f159194a.put(r100, r101);
    L9:
        return r101.f158810a;
    }

    public final void b(Class<?> r100, BackendItem r101) {
        if (this.f159194a != null) goto L5;
        this.f159194a = new HashMap();
    L5:
        a0 r102 = (a0) ((HashMap) this.f159194a).get(r100);
        if (r102 != null) goto L8;
        r102 = new a0();
        ((HashMap) this.f159194a).put(r100, r102);
    L8:
        ObservableEmitter<BackendItem> r103 = r102.f158811b;
        if (r103 == null) goto L12;
        r103.onNext(r101);
        r102.f158813d = true;
        return;
    }
}
