package F8;

import java.util.Arrays;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class f extends D8.a {
    public static final f g;
    public static final f h;
    public final boolean f;

    static {
        f fVar = new f(false, new int[]{2, 0, 0});
        g = fVar;
        int i = fVar.c;
        int i6 = fVar.b;
        h = (i6 == 1 && i == 9) ? new f(false, new int[]{2, 0, 0}) : new f(false, new int[]{i6, i + 1, 0});
        new f(false, new int[0]);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(boolean z10, int[] versionArray) {
        super(Arrays.copyOf(versionArray, versionArray.length));
        k.f(versionArray, "versionArray");
        this.f = z10;
    }

    public final boolean b(f metadataVersionFromLanguageVersion) {
        k.f(metadataVersionFromLanguageVersion, "metadataVersionFromLanguageVersion");
        f fVar = g;
        int i = this.c;
        int i6 = this.b;
        if (i6 == 2 && i == 0 && fVar.b == 1 && fVar.c == 8) {
            return true;
        }
        if (!this.f) {
            fVar = h;
        }
        int i10 = fVar.b;
        int i11 = metadataVersionFromLanguageVersion.b;
        if (i10 > i11 || (i10 >= i11 && fVar.c > metadataVersionFromLanguageVersion.c)) {
            metadataVersionFromLanguageVersion = fVar;
        }
        boolean z10 = false;
        if ((i6 == 1 && i == 0) || i6 == 0) {
            return false;
        }
        int i12 = metadataVersionFromLanguageVersion.b;
        if (i6 > i12 || (i6 >= i12 && i > metadataVersionFromLanguageVersion.c)) {
            z10 = true;
        }
        return !z10;
    }
}
