package G2;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* loaded from: classes.dex */
public class y extends AbstractC0294b {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1914a;

        static {
            int[] iArr = new int[F2.z.values().length];
            f1914a = iArr;
            try {
                iArr[F2.z.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1914a[F2.z.GUIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1914a[F2.z.INIT_MINOR_AND_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1914a[F2.z.MINOR_MODE_ON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1914a[F2.z.MINOR_MODE_OFF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1914a[F2.z.INIT_PASSWORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1914a[F2.z.INIT_PARENT_PHONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1914a[F2.z.VERIFY_PASSWORD_TO_START.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1914a[F2.z.VERIFY_PHONE_TO_RESET_PASSWORD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1914a[F2.z.VERIFY_PASSWORD_TO_RESET_PASSWORD.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1914a[F2.z.VERIFY_PHONE_TO_RESET_PHONE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1914a[F2.z.VERIFY_PASSWORD_TO_INIT_PARENT_PHONE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1914a[F2.z.VERIFY_PASSWORD_TO_START_HOME.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // G2.AbstractC0294b
    protected u b(F2.z zVar, v vVar) {
        switch (a.f1914a[zVar.ordinal()]) {
            case 1:
                return new n(zVar, vVar);
            case 2:
                return new C0301i(zVar, vVar);
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
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return new H(zVar, vVar);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return new A(zVar, vVar);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return new I(zVar, vVar);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return new z(zVar, vVar);
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return new D(zVar, vVar);
            default:
                return null;
        }
    }
}
