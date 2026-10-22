package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SelectKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3 f21715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f21716b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f21717c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f21718d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b0 f21719e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b0 f21720f = null;

    static {
        f21715a = SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1.INSTANCE;
        f21716b = new b0("STATE_REG");
        f21717c = new b0("STATE_COMPLETED");
        f21718d = new b0("STATE_CANCELLED");
        f21719e = new b0("NO_RESULT");
        f21720f = new b0("PARAM_CLAUSE_0");
    }

    public static final TrySelectDetailedResult a(int r10) {
        if (r10 == 0) goto L15;
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L17;
        if (r10 != 3) goto L11;
        return TrySelectDetailedResult.ALREADY_SELECTED;
    L11:
        throw new IllegalStateException(("Unexpected internal result: " + r10).toString());
    L17:
        return TrySelectDetailedResult.CANCELLED;
    L18:
        return TrySelectDetailedResult.REREGISTER;
    L15:
        return TrySelectDetailedResult.SUCCESSFUL;
    }

    public static final /* synthetic */ TrySelectDetailedResult b(int r10) {
        return a(r10);
    }

    public static final /* synthetic */ Function3 c() {
        return f21715a;
    }

    public static final /* synthetic */ b0 d() {
        return f21719e;
    }

    public static final /* synthetic */ b0 e() {
        return f21718d;
    }

    public static final /* synthetic */ b0 f() {
        return f21717c;
    }

    public static final /* synthetic */ b0 g() {
        return f21716b;
    }

    public static final /* synthetic */ boolean h(CancellableContinuation r10, Function1 r11) {
        return j(r10, r11);
    }

    public static final b0 i() {
        return f21720f;
    }

    public static final boolean j(CancellableContinuation r10, Function1 r11) {
        Object r12 = r10.tryResume(Unit.f21064a, null, r11);
        if (r12 != null) goto L6;
        return false;
    L6:
        r10.completeResume(r12);
        return true;
    }
}
