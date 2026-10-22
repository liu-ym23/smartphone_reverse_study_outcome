package cba;

import android.os.SystemClock;
import androidx.collection.SieveCacheKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.activation.presentation.runtime.gesture.scheduler.ObricAiKeyGestureTimeout;
import dba.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f23104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<bba.a> f23105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<yaa.a, Unit> f23106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObricAiKeyGestureState f23107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public bba.a f23108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f23109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f23110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f23111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23112i;

    public static final class a {
    }

    /* JADX INFO: renamed from: cba.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0425b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23113a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f23114b = null;

        static {
            int[] r100 = new int[ObricAiKeyGestureState.values().length];
            r100[ObricAiKeyGestureState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L40:
            r100[ObricAiKeyGestureState.FIRST_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L52:
            r100[ObricAiKeyGestureState.PRESS_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L42:
            r100[ObricAiKeyGestureState.LONG_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L44:
            r100[ObricAiKeyGestureState.FIRST_DOWN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L32:
            r100[ObricAiKeyGestureState.SECOND_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L13:
            f23113a = r100;
            int[] r101 = new int[ObricAiKeyGestureTimeout.values().length];
            r101[ObricAiKeyGestureTimeout.SINGLE_PRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L48:
            r101[ObricAiKeyGestureTimeout.PRESS_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L36:
            r101[ObricAiKeyGestureTimeout.LONG_PRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L46:
            r101[ObricAiKeyGestureTimeout.SECOND_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L34:
            r101[ObricAiKeyGestureTimeout.GESTURE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L19:
            f23114b = r101;
        }
    }

    static {
    }

    public final void f(long r100) {
        e("CANCEL", r100);
        ObricAiKeyGestureState r101 = this.f23107d;
        if (r101 != ObricAiKeyGestureState.FIRST_DOWN) goto L5;
    L6:
        c(this, ObricAiKeyGestureAction.LONG_PRESS_FAILED, r101, r100);
    L8:
        if (r101 == ObricAiKeyGestureState.IDLE) goto L10;
        c(this, ObricAiKeyGestureAction.CANCEL, r101, r100);
    L10:
        i("key_cancel");
        return;
    L5:
        if (r101 != ObricAiKeyGestureState.PRESS_START) goto L8;
        goto L6
    }

    public final void g(long r110) {
        e("DOWN", r110);
        int r100 = C0425b.f23113a[this.f23107d.ordinal()];
        boolean r101 = true;
        if (r100 != 1) goto L5;
        k(r110);
        return;
    L5:
        if (r100 != 2) goto L7;
        bba.a r102 = this.f23108e;
        if (r102 != null) goto L15;
        i("missing_config_second_down");
        return;
    L15:
        long r103 = r110 - this.f23110g;
        if (0 <= r103) goto L18;
    L20:
        r101 = false;
    L21:
        if (r101 == true) goto L23;
        FLogger.f375446a.i("ObricAiKeyGesture", "second_down_rejected: interval=" + r103 + " tap=" + r102.f18555b + " eventTime=" + r110);
        k(r110);
        return;
    L23:
        this.f23104a.b(ObricAiKeyGestureTimeout.SINGLE_PRESS);
        this.f23111h = r110;
        this.f23107d = ObricAiKeyGestureState.SECOND_DOWN;
        j(ObricAiKeyGestureTimeout.SECOND_PRESS, SystemClock.uptimeMillis(), r102.f18555b);
        return;
    L18:
        if (r103 > r102.f18555b) goto L20;
    L7:
        if (r100 != 3) goto L9;
    L11:
        FLogger.f375446a.i("ObricAiKeyGesture", "input_ignored: input=DOWN state=" + this.f23107d + " eventTime=" + r110);
        return;
    L9:
        if (r100 == 4) goto L11;
        FLogger.f375446a.i("ObricAiKeyGesture", "input_invalid: input=DOWN state=" + this.f23107d + " eventTime=" + r110);
        i("invalid_down");
    }

    public final void h(long r110) {
        e("UP", r110);
        int r100 = C0425b.f23113a[this.f23107d.ordinal()];
        boolean r101 = false;
        if (r100 != 3) goto L5;
        d(r110, false);
        return;
    L5:
        if (r100 != 4) goto L7;
        b(ObricAiKeyGestureAction.LONG_PRESS_STOP, this.f23107d, r110, a(r110, this.f23109f));
        i("long_press_stop");
        return;
    L7:
        if (r100 != 5) goto L9;
        bba.a r102 = this.f23108e;
        if (r102 != null) goto L22;
        i("missing_config_first_up");
        return;
    L22:
        ObricAiKeyGestureState r103 = this.f23107d;
        int r104 = a(r110, this.f23109f);
        long r105 = this.f23109f + r102.f18554a;
        if (r110 < r105) goto L25;
        r101 = true;
    L25:
        long r111 = SystemClock.uptimeMillis();
        FLogger.f375446a.i("ObricAiKeyGesture", "first_up_decision: duration=" + r104 + " eventTime=" + r110 + " pressStartEventTime=" + r105 + " reachedPressStart=" + r101 + " handledAt=" + r111 + " handlingDelay=" + (r111 - r110));
        this.f23104a.b(ObricAiKeyGestureTimeout.PRESS_START);
        if (r101 == false) goto L28;
        this.f23107d = ObricAiKeyGestureState.PRESS_START;
        c(this, ObricAiKeyGestureAction.PRESS_START, r103, r105);
        d(r110, true);
        return;
    L28:
        this.f23110g = r110;
        this.f23112i = r104;
        this.f23107d = ObricAiKeyGestureState.FIRST_UP;
        c(this, ObricAiKeyGestureAction.LONG_PRESS_FAILED, r103, r110);
        j(ObricAiKeyGestureTimeout.SINGLE_PRESS, r110, r102.f18555b);
        return;
    L9:
        if (r100 == 6) goto L11;
        FLogger.f375446a.i("ObricAiKeyGesture", "input_invalid: input=UP state=" + this.f23107d + " eventTime=" + r110);
        i("invalid_up");
        return;
    L11:
        bba.a r106 = this.f23108e;
        if (r106 != null) goto L14;
        i("missing_config_second_up");
        return;
    L14:
        ObricAiKeyGestureState r107 = this.f23107d;
        int r108 = a(r110, this.f23111h);
        if (r108 > r106.f18555b) goto L17;
        b(ObricAiKeyGestureAction.DOUBLE_PRESS, r107, r110, r108);
    L18:
        i("second_up");
        return;
    L17:
        FLogger.f375446a.i("ObricAiKeyGesture", "second_up_rejected: duration=" + r108 + " tap=" + r106.f18555b + " eventTime=" + r110);
        goto L18
    }

    public final void i(String r100) {
        ObricAiKeyGestureState r101 = this.f23107d;
        ObricAiKeyGestureState r102 = ObricAiKeyGestureState.IDLE;
        if (r101 == r102) goto L5;
    L6:
        FLogger.f375446a.i("ObricAiKeyGesture", "reset: reason=" + r100 + " state=" + this.f23107d + " firstDown=" + this.f23109f + " firstUp=" + this.f23110g + " secondDown=" + this.f23111h);
    L7:
        this.f23104a.a();
        this.f23107d = r102;
        this.f23108e = null;
        this.f23109f = 0;
        this.f23110g = 0;
        this.f23111h = 0;
        this.f23112i = 0;
        return;
    L5:
        if (this.f23108e == null) goto L7;
        goto L6
    }

    public final void k(long r100) {
        i("new_first_down");
        bba.a r101 = this.f23105b.invoke();
        if (r101.f18554a > 0) goto L5;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        bba.a r103 = r101;
    L16:
        if (r103 != null) goto L19;
        FLogger.f375446a.i("ObricAiKeyGesture", "start_rejected: reason=invalid_config config=" + r101);
        return;
    L19:
        this.f23108e = r103;
        this.f23109f = r100;
        this.f23107d = ObricAiKeyGestureState.FIRST_DOWN;
        FLogger.f375446a.i("ObricAiKeyGesture", "start: state=" + this.f23107d + " eventTime=" + r100 + " pressStart=" + r103.f18554a + " tap=" + r103.f18555b + " longAfterPressStart=" + r103.f18556c + " gestureTimeout=" + r103.f18557d);
        c(this, ObricAiKeyGestureAction.DOWN, ObricAiKeyGestureState.IDLE, r100);
        j(ObricAiKeyGestureTimeout.PRESS_START, r100, r103.f18554a);
        j(ObricAiKeyGestureTimeout.GESTURE, r100, r103.f18557d);
        return;
    L14:
        r103 = null;
        goto L16
    L5:
        if (r101.f18555b <= 0) goto L11;
        if (r101.f18556c <= 0) goto L11;
        if (r101.f18557d <= 0) goto L11;
        r102 = true;
        goto L12
    }

    public static int a(long r100, long r101) {
        return (int) RangesKt.coerceIn(r100 - r101, 0, SieveCacheKt.NodeLinkMask);
    }

    public final void d(long r110, boolean r111) {
        bba.a r100 = this.f23108e;
        if (r100 != null) goto L6;
        i("missing_config_press_started_up");
        return;
    L6:
        long r101 = r100.f18556c + (this.f23109f + r100.f18554a);
        if (r110 < r101) goto L9;
        boolean r102 = true;
    L10:
        if (r111 == false) goto L12;
        String r112 = "first_down_catch_up";
    L13:
        FLogger.f375446a.i("ObricAiKeyGesture", "press_started_up_decision: source=" + r112 + " duration=" + a(r110, this.f23109f) + " eventTime=" + r110 + " longPressStartEventTime=" + r101 + " reachedLongPress=" + r102);
        if (r102 == true) goto L17;
        ObricAiKeyGestureState r103 = this.f23107d;
        this.f23104a.b(ObricAiKeyGestureTimeout.LONG_PRESS);
        b(ObricAiKeyGestureAction.SHORT_PRESS, r103, r110, a(r110, this.f23109f));
        i("short_press");
        return;
    L17:
        ObricAiKeyGestureState r113 = this.f23107d;
        this.f23104a.b(ObricAiKeyGestureTimeout.LONG_PRESS);
        this.f23107d = ObricAiKeyGestureState.LONG_PRESS;
        c(this, ObricAiKeyGestureAction.LONG_PRESS_START, r113, r101);
        b(ObricAiKeyGestureAction.LONG_PRESS_STOP, this.f23107d, r110, a(r110, this.f23109f));
        i("long_press_stop");
        return;
    L12:
        r112 = "press_start_state";
        goto L13
    L9:
        r102 = false;
        goto L10
    }

    public final void e(String r100, long r101) {
        FLogger.f375446a.i("ObricAiKeyGesture", "input: input=" + r100 + " state=" + this.f23107d + " eventTime=" + r101 + " receivedAt=" + SystemClock.uptimeMillis() + " firstDown=" + this.f23109f);
    }

    public b(dba.b r100, Function0 r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "scheduler");
        Intrinsics.checkNotNullParameter(r101, "configProvider");
        Intrinsics.checkNotNullParameter(r102, "onEvent");
        this.f23104a = r100;
        this.f23105b = r101;
        this.f23106c = r102;
        this.f23107d = ObricAiKeyGestureState.IDLE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [cba.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void j(final ObricAiKeyGestureTimeout r100, long r101, long r102) {
        final long r103 = r101 + r102;
        FLogger.f375446a.i("ObricAiKeyGesture", "schedule: type=" + r100 + " state=" + this.f23107d + " sourceTime=" + r101 + " delay=" + r102 + " timeoutTime=" + r103);
        this.f23104a.c(r100, r103, new cba.a(this, r100, r103));
    }

    public static /* synthetic */ void c(b r100, ObricAiKeyGestureAction r101, ObricAiKeyGestureState r110, long r111) {
        r100.b(r101, r110, r111, a(r111, r100.f23109f));
    }

    public final void b(ObricAiKeyGestureAction r110, ObricAiKeyGestureState r111, long r112, int r113) {
        FLogger.f375446a.i("ObricAiKeyGesture", "emit: action=" + r110 + " stateBefore=" + r111 + " stateAfter=" + this.f23107d + " eventTime=" + r112 + " downTime=" + this.f23109f + " duration=" + r113 + " firstTapDuration=" + this.f23112i);
        this.f23106c.invoke(new yaa.a(r110, r111, r112, this.f23109f, r113, this.f23112i));
    }
}
