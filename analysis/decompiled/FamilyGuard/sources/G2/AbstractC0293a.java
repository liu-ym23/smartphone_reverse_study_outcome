package G2;

import android.content.Intent;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import f2.C0702g;

/* renamed from: G2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0293a implements u {

    /* renamed from: a, reason: collision with root package name */
    private v f1888a;

    /* renamed from: b, reason: collision with root package name */
    private F2.z f1889b;

    /* renamed from: G2.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0029a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1890a;

        static {
            int[] iArr = new int[F2.z.values().length];
            f1890a = iArr;
            try {
                iArr[F2.z.GUIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1890a[F2.z.INIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1890a[F2.z.INIT_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1890a[F2.z.INIT_PARENT_PHONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1890a[F2.z.INIT_MINOR_AND_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1890a[F2.z.VERIFY_PASSWORD_TO_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1890a[F2.z.VERIFY_PASSWORD_TO_RESET_PASSWORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1890a[F2.z.RESET_PASSWORD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1890a[F2.z.VERIFY_PHONE_TO_RESET_PASSWORD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1890a[F2.z.VERIFY_PHONE_TO_RESET_PHONE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1890a[F2.z.RESET_PHONE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1890a[F2.z.MINOR_MODE_ON.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1890a[F2.z.MINOR_MODE_OFF.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1890a[F2.z.VERIFY_PASSWORD_TO_INIT_PARENT_PHONE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1890a[F2.z.VERIFY_PASSWORD_TO_START_HOME.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public AbstractC0293a(F2.z zVar, v vVar) {
        this.f1888a = vVar;
        this.f1889b = zVar;
    }

    public static String j(F2.z zVar) {
        switch (C0029a.f1890a[zVar.ordinal()]) {
            case 1:
                return "GUIDE";
            case 2:
                return "INIT";
            case 3:
                return "INIT_PASSWORD";
            case 4:
                return "INIT_PARENT_PHONE";
            case 5:
                return "INIT_MINOR_AND_START";
            case 6:
                return "VERIFY_PASSWORD_TO_START";
            case 7:
                return "VERIFY_PASSWORD_TO_RESET_PASSWORD";
            case 8:
                return "RESET_PASSWORD";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                return "VERIFY_PHONE_TO_RESET_PASSWORD";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                return "VERIFY_PHONE_TO_RESET_PHONE";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                return "RESET_PHONE";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                return "MINOR_MODE_ON";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                return "MINOR_MODE_OFF";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return "VERIFY_PASSWORD_TO_INIT_PARENT_PHONE";
            case 15:
                return "VERIFY_PASSWORD_TO_START_HOME";
            default:
                return "UNKNOWN";
        }
    }

    public static String l(int i5) {
        switch (i5) {
            case 1:
                return "GUIDE_STATE_CLICK_START_OPERATE";
            case 2:
                return "INIT_MINOR_OPERATE";
            case 3:
                return "MINOR_ON_STATE_TURN_OFF_OPERATE";
            case 4:
                return "MINOR_OFF_STATE_TURN_ON_OPERATE";
            case 5:
                return "VERIFY_PASSWORD_TO_RESET_OPERATE";
            case 6:
                return "VERIFY_PHONE_TO_RESET_PHONE_OPERATE";
            case 7:
                return "TASK_MOVE_TO_FRONT_OPERATE";
            case 8:
                return "LAUNCHER_TASK_MOVE_TO_FRONT_OPERATE";
            default:
                return "UNKNOWN";
        }
    }

    @Override // G2.u
    public boolean a(stepos.support.v7.app.d dVar, int i5, int i6, Intent intent) {
        C0702g.b("BaseMinorState", "handle() called with: requestCode = [" + i5 + "], resultCode = [" + i6 + "], data = [" + intent + "]");
        if (i6 != 0 || i5 != 4) {
            return false;
        }
        dVar.finish();
        return true;
    }

    @Override // G2.u
    public boolean b() {
        return false;
    }

    @Override // G2.u
    public boolean c() {
        return true;
    }

    @Override // G2.u
    public void d(stepos.support.v7.app.d dVar) {
        C0702g.b("BaseMinorState", "onAttach() called with: state = [" + this + "]");
    }

    @Override // G2.u
    public boolean f() {
        return false;
    }

    @Override // G2.u
    public void g(stepos.support.v7.app.d dVar, u uVar) {
        C0702g.b("BaseMinorState", getClass().getSimpleName() + " onExit() called with: activity = [" + dVar + "], to = [" + uVar + "]");
    }

    @Override // G2.u
    public F2.z getId() {
        return this.f1889b;
    }

    @Override // G2.u
    public void h(stepos.support.v7.app.d dVar, u uVar) {
        C0702g.b("BaseMinorState", getClass().getSimpleName() + " onEnter() called with: from = [" + uVar + "]");
    }

    @Override // G2.u
    public boolean i(stepos.support.v7.app.d dVar, int i5) {
        u uVarF;
        C0702g.b("BaseMinorState", "handleOperation operation = " + i5);
        if (i5 != 7 || this.f1888a.l() || (uVarF = this.f1888a.f()) == null || uVarF.getId().ordinal() < F2.z.INIT_MINOR_AND_START.ordinal() || !I2.b.a(dVar)) {
            return false;
        }
        this.f1888a.q(F2.z.VERIFY_PASSWORD_TO_START);
        return true;
    }

    public v k() {
        return this.f1888a;
    }

    protected boolean m(int i5) {
        if (i5 != 9) {
            return false;
        }
        k().q(F2.z.MINOR_MODE_ON);
        return true;
    }

    public String toString() {
        return j(getId());
    }
}
