package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class X implements W {

    /* renamed from: a, reason: collision with root package name */
    public final int f3645a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3646b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Y f3647c;

    public X(Y y4, int i4) {
        this.f3647c = y4;
        this.f3645a = i4;
    }

    @Override // androidx.fragment.app.W
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        Y y4 = this.f3647c;
        D d4 = y4.f3685x;
        int i4 = this.f3645a;
        if (d4 == null || i4 >= 0 || !d4.getChildFragmentManager().M(-1, 0)) {
            return y4.N(arrayList, arrayList2, i4, this.f3646b);
        }
        return false;
    }
}
