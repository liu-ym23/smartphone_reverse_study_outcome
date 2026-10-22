package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class TouchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f180074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f180075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TouchIntent f180076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f180077d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/touch/TouchHelper$TouchIntent;", "", UserProfileEvent.POSITION_NONE, "DOWN_STATE", "H_MOVING_LEFT", "H_MOVING_RIGHT", "V_MOVING_DOWN", "V_MOVING_UP", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TouchIntent extends Enum<TouchIntent> {
        public static final TouchIntent DOWN_STATE = null;
        public static final TouchIntent H_MOVING_LEFT = null;
        public static final TouchIntent H_MOVING_RIGHT = null;
        public static final TouchIntent NONE = null;
        public static final TouchIntent V_MOVING_DOWN = null;
        public static final TouchIntent V_MOVING_UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TouchIntent[] f180078a = null;

        static {
            TouchIntent r100 = new TouchIntent(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            TouchIntent r101 = new TouchIntent("DOWN_STATE", 1);
            DOWN_STATE = r101;
            TouchIntent r102 = new TouchIntent("H_MOVING_LEFT", 2);
            H_MOVING_LEFT = r102;
            TouchIntent r103 = new TouchIntent("H_MOVING_RIGHT", 3);
            H_MOVING_RIGHT = r103;
            TouchIntent r104 = new TouchIntent("V_MOVING_DOWN", 4);
            V_MOVING_DOWN = r104;
            TouchIntent r105 = new TouchIntent("V_MOVING_UP", 5);
            V_MOVING_UP = r105;
            f180078a = new TouchIntent[]{r100, r101, r102, r103, r104, r105};
        }

        public static TouchIntent valueOf(String r100) {
            return (TouchIntent) r27.a.a(TouchIntent.class, r100);
        }

        public static TouchIntent[] values() {
            return (TouchIntent[]) f180078a.clone();
        }

        public TouchIntent(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TouchHelper(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f180077d = r100;
        this.f180074a = new a(r100);
        this.f180075b = new c();
        this.f180076c = TouchIntent.NONE;
    }

    public final void a(MotionEvent r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getAction() != 0) goto L6;
        this.f180074a = new a(this.f180077d);
        this.f180075b = new c();
        this.f180076c = TouchIntent.NONE;
    L6:
        if (r100.getAction() != 0) goto L9;
        a r102 = this.f180074a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        r102.f180080b = r100.getRawX();
        r102.f180081c = r100.getRawY();
        c r103 = this.f180075b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        r103.f180086c = r100.getRawX();
        r103.f180087d = r100.getRawY();
    L11:
        int r104 = r100.getAction();
        if (r104 == 0) goto L108;
        boolean r105 = true;
        if (r104 == 1) goto L85;
        if (r104 != 2) goto L17;
        TouchIntent r106 = this.f180076c;
        TouchIntent r107 = TouchIntent.DOWN_STATE;
        if (r106 != r107) goto L54;
        Lazy r108 = OrderCommonLog.f179948a;
        OrderCommonLog.a("TouchHelper", new TouchHelper$dispatchCallback$1(this));
        if (this.f180074a.a() == false) goto L37;
        a r109 = this.f180074a;
        if (r109.a() == true) goto L26;
    L28:
        r105 = false;
    L29:
        if (r105 == false) goto L33;
        this.f180076c = TouchIntent.H_MOVING_LEFT;
        if (r101 == null) goto L112;
        r101.f(this.f180074a, this.f180075b);
        return;
    L112:
        return;
    L33:
        this.f180076c = TouchIntent.H_MOVING_RIGHT;
        if (r101 == null) goto L114;
        r101.g(this.f180074a, this.f180075b);
        return;
    L114:
        return;
    L26:
        if (r109.f180082d >= r109.f180080b) goto L28;
    L37:
        if (this.f180074a.b() == false) goto L51;
        a r110 = this.f180074a;
        if (r110.b() == true) goto L41;
    L43:
        r105 = false;
    L44:
        if (r105 == false) goto L48;
        this.f180076c = TouchIntent.V_MOVING_DOWN;
        if (r101 == null) goto L116;
        r101.a(this.f180074a, this.f180075b);
        return;
    L116:
        return;
    L48:
        this.f180076c = TouchIntent.V_MOVING_UP;
        if (r101 == null) goto L118;
        r101.b(this.f180074a, this.f180075b);
        return;
    L118:
        return;
    L41:
        if (r110.f180083e <= r110.f180081c) goto L43;
    L51:
        this.f180076c = r107;
        if (r101 == null) goto L120;
        r101.c();
        return;
    L120:
        return;
    L54:
        TouchIntent r111 = TouchIntent.H_MOVING_LEFT;
        if (r106 != r111) goto L57;
    L74:
        c r112 = this.f180075b;
        if (r112.f180086c < r112.f180084a) goto L78;
        r105 = false;
    L78:
        if (r105 == false) goto L82;
        this.f180076c = r111;
        if (r101 == null) goto L127;
        r101.f(this.f180074a, r112);
        return;
    L127:
        return;
    L82:
        this.f180076c = TouchIntent.H_MOVING_RIGHT;
        if (r101 == null) goto L129;
        r101.g(this.f180074a, r112);
        return;
    L129:
        return;
    L57:
        if (r106 == TouchIntent.H_MOVING_RIGHT) goto L74;
        TouchIntent r113 = TouchIntent.V_MOVING_DOWN;
        if (r106 != r113) goto L62;
    L63:
        c r114 = this.f180075b;
        if (r114.f180087d > r114.f180085b) goto L67;
        r105 = false;
    L67:
        if (r105 == false) goto L71;
        this.f180076c = r113;
        if (r101 == null) goto L123;
        r101.a(this.f180074a, r114);
        return;
    L123:
        return;
    L71:
        this.f180076c = TouchIntent.V_MOVING_UP;
        if (r101 == null) goto L125;
        r101.b(this.f180074a, r114);
        return;
    L125:
        return;
    L62:
        if (r106 == TouchIntent.V_MOVING_UP) goto L63;
        return;
    L17:
        if (r104 == 3) goto L85;
        return;
    L85:
        TouchIntent r115 = this.f180076c;
        if (r115 != TouchIntent.DOWN_STATE) goto L94;
        this.f180076c = TouchIntent.NONE;
        if (r100.getAction() != 1) goto L91;
        if (r101 == null) goto L131;
        r101.onClick();
        return;
    L131:
        return;
    L91:
        if (r101 == null) goto L133;
        r101.onCancel();
        return;
    L133:
        return;
    L94:
        if (r115 != TouchIntent.H_MOVING_LEFT) goto L96;
    L105:
        this.f180076c = TouchIntent.NONE;
        if (r101 == null) goto L138;
        r101.e(this.f180074a, this.f180075b);
        return;
    L138:
        return;
    L96:
        if (r115 == TouchIntent.H_MOVING_RIGHT) goto L105;
        if (r115 != TouchIntent.V_MOVING_UP) goto L101;
    L102:
        this.f180076c = TouchIntent.NONE;
        if (r101 == null) goto L136;
        r101.d(this.f180074a, this.f180075b);
        return;
    L136:
        return;
    L101:
        if (r115 == TouchIntent.V_MOVING_DOWN) goto L102;
        return;
    L108:
        this.f180076c = TouchIntent.DOWN_STATE;
        if (r101 == null) goto L140;
        r101.c();
        return;
    L140:
        return;
    L9:
        if (r100.getAction() != 2) goto L11;
        a r116 = this.f180074a;
        r116.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        r116.f180082d = r100.getRawX();
        r116.f180083e = r100.getRawY();
        c r117 = this.f180075b;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        r117.f180084a = r117.f180086c;
        r117.f180085b = r117.f180087d;
        r117.f180086c = r100.getRawX();
        r117.f180087d = r100.getRawY();
        goto L11
    }
}
