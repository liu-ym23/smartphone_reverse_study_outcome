package com.bytedance.android.livesdk.ktvimpl.mv;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes10.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvModel f146054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f146055b;

    public e(KtvMvModel r100, y r101) {
        this.f146054a = r100;
        this.f146055b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f146054a.f145943h.remove(this.f146055b);
        int r102 = mb0.b.f512758a;
        int r103 = mb0.b.a.a(r101);
        String r104 = mb0.b.a.b(r101);
        ArrayList<Function3<l, Integer, String, Unit>> r105 = this.f146055b.f146207a;
        if (r105 == null) goto L8;
        Iterator<T> r106 = r105.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        ((Function3) r106.next()).invoke(null, Integer.valueOf(r103), r104);
    L8:
        Function3<? super String, ? super Long, ? super String, Unit> r107 = this.f146054a.f145941f;
        if (r107 == null) goto L11;
        Unit r108 = r107.invoke(null, Long.valueOf(this.f146055b.f146208b), this.f146055b.f146210d);
    L11:
        com.bytedance.android.live.ktv.common.util.g.e("requestAndNotifyAllMvInfoBySong error " + r101.getMessage());
    }
}
