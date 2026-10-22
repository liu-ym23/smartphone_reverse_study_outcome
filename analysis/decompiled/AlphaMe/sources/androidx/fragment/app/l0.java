package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3780a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3781b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3782c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3783d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ArrayList f3784e;

    public l0(int i4, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f3780a = i4;
        this.f3781b = arrayList;
        this.f3782c = arrayList2;
        this.f3783d = arrayList3;
        this.f3784e = arrayList4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (int i4 = 0; i4 < this.f3780a; i4++) {
            View view = (View) this.f3781b.get(i4);
            String str = (String) this.f3782c.get(i4);
            WeakHashMap weakHashMap = K.S.f939a;
            K.J.v(view, str);
            K.J.v((View) this.f3783d.get(i4), (String) this.f3784e.get(i4));
        }
    }
}
