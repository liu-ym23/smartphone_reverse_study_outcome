package e0;

import B0.g;
import androidx.lifecycle.n0;
import com.google.android.gms.common.internal.f;
import q.m;

/* renamed from: e0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0549b extends n0 {

    /* renamed from: b, reason: collision with root package name */
    public static final f f12497b = new f();

    /* renamed from: a, reason: collision with root package name */
    public final m f12498a = new m();

    @Override // androidx.lifecycle.n0
    public final void onCleared() {
        super.onCleared();
        m mVar = this.f12498a;
        int i4 = mVar.f13973c;
        if (i4 > 0) {
            g.y(mVar.f13972b[0]);
            throw null;
        }
        Object[] objArr = mVar.f13972b;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        mVar.f13973c = 0;
    }
}
