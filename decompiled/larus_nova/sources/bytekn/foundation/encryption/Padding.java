package bytekn.foundation.encryption;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lbytekn/foundation/encryption/Padding;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NoPadding", "PKCS7Padding", "ANSIX923Padding", "ISO10126Padding", "ZeroPadding", "kn_common_release"}, k = 1, mv = {1, 4, 0})
public final enum Padding extends Enum<Padding> {
    public static final Padding ANSIX923Padding = null;
    public static final a Companion = null;
    public static final Padding ISO10126Padding = null;
    public static final Padding NoPadding = null;
    public static final Padding PKCS7Padding = null;
    public static final Padding ZeroPadding = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Padding[] f21755a = null;

    public static final class a {
        public a() {
        }
    }

    static {
        Padding r100 = new Padding("NoPadding", 0);
        NoPadding = r100;
        Padding r101 = new Padding("PKCS7Padding", 1);
        PKCS7Padding = r101;
        Padding r102 = new Padding("ANSIX923Padding", 2);
        ANSIX923Padding = r102;
        Padding r103 = new Padding("ISO10126Padding", 3);
        ISO10126Padding = r103;
        Padding r104 = new Padding("ZeroPadding", 4);
        ZeroPadding = r104;
        f21755a = new Padding[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static Padding valueOf(String r100) {
        return (Padding) r27.a.a(Padding.class, r100);
    }

    public static Padding[] values() {
        return (Padding[]) f21755a.clone();
    }

    public Padding(String r100, int r101) {
        super(r100, r101);
    }
}
