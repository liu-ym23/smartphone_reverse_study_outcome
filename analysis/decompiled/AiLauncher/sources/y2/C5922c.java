package y2;

import com.google.android.gms.internal.mlkit_common.zzaf;

/* renamed from: y2.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5922c extends N {

    /* renamed from: c, reason: collision with root package name */
    public final zzaf f43821c;

    public C5922c(zzaf zzafVar, int i10) {
        super(zzafVar.size(), i10);
        this.f43821c = zzafVar;
    }

    @Override // y2.N
    public final Object a(int i10) {
        return this.f43821c.get(i10);
    }
}
