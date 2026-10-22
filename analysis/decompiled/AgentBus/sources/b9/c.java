package b9;

import f9.p;

/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: d, reason: collision with root package name */
    public final p[] f1554d;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(int i2, p[] pVarArr) {
        if (pVarArr == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'enumEntries' of kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField.bitWidth must not be null");
        }
        int i10 = 1;
        int length = pVarArr.length - 1;
        if (length != 0) {
            for (int i11 = 31; i11 >= 0; i11--) {
                if (((1 << i11) & length) != 0) {
                    i10 = 1 + i11;
                }
            }
            throw new IllegalStateException("Empty enum: " + pVarArr.getClass());
        }
        super(i2, i10, 0, (byte) 0);
        this.f1554d = pVarArr;
    }

    public final Object e(int i2) {
        int i10 = (1 << this.f1557c) - 1;
        int i11 = this.f1556b;
        int i12 = (i2 & (i10 << i11)) >> i11;
        for (p pVar : this.f1554d) {
            if (pVar.getNumber() == i12) {
                return pVar;
            }
        }
        return null;
    }
}
