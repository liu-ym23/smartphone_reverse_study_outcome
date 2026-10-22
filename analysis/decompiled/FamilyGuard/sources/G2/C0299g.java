package G2;

/* renamed from: G2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0299g extends AbstractC0294b {

    /* renamed from: G2.g$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1895a;

        static {
            int[] iArr = new int[F2.z.values().length];
            f1895a = iArr;
            try {
                iArr[F2.z.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1895a[F2.z.GUIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1895a[F2.z.INIT_MINOR_AND_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1895a[F2.z.MINOR_MODE_ON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1895a[F2.z.MINOR_MODE_OFF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1895a[F2.z.INIT_PASSWORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1895a[F2.z.INIT_PARENT_PHONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1895a[F2.z.VERIFY_PASSWORD_TO_START.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // G2.AbstractC0294b
    protected u b(F2.z zVar, v vVar) {
        switch (a.f1895a[zVar.ordinal()]) {
            case 1:
                return new C0298f(zVar, vVar);
            case 2:
                return new C0295c(zVar, vVar);
            case 3:
                return new j(zVar, vVar);
            case 4:
                return new t(zVar, vVar);
            case 5:
                return new o(zVar, vVar);
            case 6:
                return new x(zVar, vVar);
            case 7:
                return new k(zVar, vVar);
            case 8:
                return new F(zVar, vVar);
            default:
                return null;
        }
    }
}
