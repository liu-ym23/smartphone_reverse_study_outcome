package d9;

import java.util.Arrays;
import q7.k;

/* loaded from: classes.dex */
public final class f extends b9.a {

    /* renamed from: g, reason: collision with root package name */
    public static final f f3008g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f3009h;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3010f;

    static {
        f fVar = new f(new int[]{1, 8, 0}, false);
        f3008g = fVar;
        int i2 = fVar.f1551c;
        int i10 = fVar.f1550b;
        f3009h = (i10 == 1 && i2 == 9) ? new f(new int[]{2, 0, 0}, false) : new f(new int[]{i10, i2 + 1, 0}, false);
        new f(new int[0], false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int[] iArr, boolean z4) {
        super(Arrays.copyOf(iArr, iArr.length));
        k.e(iArr, "versionArray");
        this.f3010f = z4;
    }

    public final boolean b(f fVar) {
        k.e(fVar, "metadataVersionFromLanguageVersion");
        f fVar2 = f3008g;
        int i2 = this.f1551c;
        int i10 = this.f1550b;
        if (i10 == 2 && i2 == 0 && fVar2.f1550b == 1 && fVar2.f1551c == 8) {
            return true;
        }
        if (!this.f3010f) {
            fVar2 = f3009h;
        }
        int i11 = fVar2.f1550b;
        int i12 = fVar.f1550b;
        if (i11 > i12 || (i11 >= i12 && fVar2.f1551c > fVar.f1551c)) {
            fVar = fVar2;
        }
        boolean z4 = false;
        if ((i10 == 1 && i2 == 0) || i10 == 0) {
            return false;
        }
        int i13 = fVar.f1550b;
        if (i10 > i13 || (i10 >= i13 && i2 > fVar.f1551c)) {
            z4 = true;
        }
        return !z4;
    }
}
