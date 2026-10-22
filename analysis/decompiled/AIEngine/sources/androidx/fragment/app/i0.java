package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2144a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2145b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2146c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2147d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2148e;

    public i0(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f2144a = i10;
        this.f2145b = arrayList;
        this.f2146c = arrayList2;
        this.f2147d = arrayList3;
        this.f2148e = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i10 = 0; i10 < this.f2144a; i10++) {
            View view = (View) this.f2145b.get(i10);
            String str = (String) this.f2146c.get(i10);
            WeakHashMap<View, v0.h0> weakHashMap = v0.e0.f13274a;
            e0.d.l(view, str);
            e0.d.l((View) this.f2147d.get(i10), (String) this.f2148e.get(i10));
        }
    }
}
