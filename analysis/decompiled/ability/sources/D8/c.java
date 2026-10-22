package D8;

import H8.m;

/* loaded from: classes4.dex */
public final class c extends d {
    public final m[] c;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(int i, m[] mVarArr) {
        if (mVarArr == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter 'enumEntries' of kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField.bitWidth must not be null");
        }
        int i6 = 1;
        int length = mVarArr.length - 1;
        if (length != 0) {
            for (int i10 = 31; i10 >= 0; i10--) {
                if (((1 << i10) & length) != 0) {
                    i6 = 1 + i10;
                }
            }
            throw new IllegalStateException("Empty enum: " + mVarArr.getClass());
        }
        super(i, i6);
        this.c = mVarArr;
    }

    public final Object c(int i) {
        int i6 = (1 << this.b) - 1;
        int i10 = this.f408a;
        int i11 = (i & (i6 << i10)) >> i10;
        for (m mVar : this.c) {
            if (mVar.getNumber() == i11) {
                return mVar;
            }
        }
        return null;
    }
}
