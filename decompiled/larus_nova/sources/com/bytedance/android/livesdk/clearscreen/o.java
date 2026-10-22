package com.bytedance.android.livesdk.clearscreen;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.c31;
import com.bytedance.android.livesdk.config.pg0;
import com.bytedance.android.livesdk.config.qg0;
import com.bytedance.android.livesdk.config.tp0;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes8.dex */
public final class o extends k {

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final /* synthetic */ int f119470j0 = 0;
    public final int L;
    public final int M;
    public final int N;
    public int O;
    public final float P;
    public float Q;
    public float R;
    public final int S;
    public final int T;
    public long U;
    public float V;
    public float W;
    public float X;
    public float Y;
    public final float Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final float f119471a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f119472b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f119473c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f119474d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f119475e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public q f119476f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f119477g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widget.b.h f119478h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public MotionEvent f119479i0;

    public static final class a {
        @JvmStatic
        public static o a(GestureDetectLayout r100) {
            y r101 = null;
            if (r100 == null) goto L37;
            com.bytedance.android.livesdk.widget.b.h r102 = com.bytedance.android.livesdk.widget.b.h.f161423c;
            if (r102 == null) goto L21;
            List<WeakReference<y>> r103 = r100.f160882j;
            if (r103 == null) goto L21;
            if (((ArrayList) r103).isEmpty() == true) goto L21;
            Iterator r104 = ((ArrayList) r100.f160882j).iterator();
        L13:
            if (r104.hasNext() == false) goto L21;
            WeakReference r105 = (WeakReference) r104.next();
            if (r105 == null) goto L13;
            if (r105.get() == null) goto L13;
            if (((y) r105.get()).getConfig() != r102) goto L13;
            y r106 = (y) r105.get();
        L22:
            if (r106 != null) goto L24;
            return null;
        L24:
            if ((r106 instanceof o) == false) goto L28;
            r101 = r106;
        L28:
            return (o) r101;
        L21:
            r106 = null;
            goto L22
        L37:
            return null;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void s() {
        this.O = 0;
        A();
        i0.c().post(new p(this));
        super.s();
    }

    public final void A() {
        WeakReference<View> r100 = this.f119444j;
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.get();
    L6:
        ViewGroup r103 = (ViewGroup) r102;
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.getChildCount() <= 1) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r101 = r103;
    L14:
        if (r101 == null) goto L35;
        Sequence<View> r105 = UtilityKotlinExtentionsKt.g(r101);
        if (r105 == null) goto L36;
        Iterator<View> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L37;
        View r107 = r106.next();
        if ((r107 instanceof IRenderView) == false) goto L19;
        this.V = r107.getLeft();
        this.W = r107.getTop();
        this.X = r107.getRight();
        float r108 = r107.getBottom();
        this.Y = r108;
        float r109 = 2;
        this.f119472b0 = this.Z / r109;
        float r110 = this.W;
        float r111 = r108 - r110;
        float r112 = this.f119471a0;
        if (r111 < r112) goto L24;
        this.f119473c0 = r112 / r109;
        goto L19
    L24:
        this.f119474d0 = true;
        this.f119473c0 = (r108 + r110) / r109;
        goto L19
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L11:
        r104 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void o() {
        HashMap r100 = new HashMap();
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        String r102 = "0";
        if (r101 == null) goto L10;
        com.bytedance.live.datacontext.m<Integer> r103 = r101.getCleanMode();
        if (r103 == null) goto L10;
        if (r103.getValue().intValue() != ClearScreenConst$InteractType.INTERACT_SHOW.getId()) goto L10;
        String r104 = "0";
    L11:
        r100.put("is_under_screen_clear", r104);
        IUserService r105 = (IUserService) jc1.k.f(IUserService.class);
        if (r105 == null) goto L19;
        com.bytedance.android.livesdk.user.f r106 = r105.user();
        if (r106 == null) goto L19;
        String r107 = r106.n();
        if (r107 == null) goto L19;
        r102 = r107;
    L19:
        r100.put("user_id", r102);
        ClearScreenLogUtils.f119492a.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_pitch_enlarge", r100);
        return;
    L10:
        r104 = "1";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void t() {
        super.t();
        this.f119437c = this.P;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void u() {
        super.u();
        this.Q = 1.0f;
        this.R = 1.0f;
    }

    @Override // com.bytedance.android.livesdk.widget.y
    public final f0 getConfig() {
        return this.f119478h0;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void q() {
        s();
    }

    public final boolean C(MotionEvent r100) {
        if (Intrinsics.areEqual(r100, this.f119479i0) == true) goto L23;
        Integer r101 = null;
        if (r100 == null) goto L7;
        Integer r102 = Integer.valueOf(r100.getAction());
    L8:
        MotionEvent r103 = this.f119479i0;
        if (r103 == null) goto L12;
        r101 = Integer.valueOf(r103.getAction());
    L12:
        if (Intrinsics.areEqual(r102, r101) == false) goto L21;
        if (r100 == null) goto L21;
        if (r100.getAction() != 1) goto L21;
        long r104 = r100.getEventTime();
        MotionEvent r105 = this.f119479i0;
        if (r105 == null) goto L21;
        if (r104 != r105.getEventTime()) goto L21;
        return true;
    L21:
        return false;
    L7:
        r102 = null;
        goto L8
    L23:
        return true;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k, com.bytedance.android.livesdk.widget.y
    public final boolean a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        if (this.O == 0) goto L6;
        s();
        return true;
    L6:
        super.a(r100);
        return false;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void h(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = r110.getPointerCount();
        if (r100 == 2) goto L5;
    L25:
        if (r100 == 1) goto L27;
        return;
    L27:
        if (this.f119450p == true) goto L29;
        return;
    L29:
        if (this.G == true) goto L49;
        int r101 = this.O;
        if (r101 != this.M) goto L34;
        float r102 = r110.getX();
        float r111 = r110.getY();
        super.y((r102 - this.B) + this.D, (r111 - this.C) + this.E);
        this.f119452r = true;
        return;
    L34:
        if (r101 != this.N) goto L51;
        float r103 = r110.getX();
        float r112 = r110.getY();
        float r104 = r103 - this.B;
        float r113 = r112 - this.C;
        if (this.f119452r == false) goto L38;
    L41:
        super.y(r104 + this.D, r113 + this.E);
        this.f119452r = true;
        return;
    L38:
        if (Math.abs(r104) > this.S) goto L41;
        if (Math.abs(r113) > this.S) goto L41;
        return;
    L51:
        return;
    L49:
        return;
    L5:
        if (this.f119450p == false) goto L25;
        if (this.f119449o == false) goto L25;
        if (this.G == true) goto L25;
        this.f119452r = true;
        double r105 = k.z(r110);
        double r106 = r105 - this.f119438d;
        if (r106 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        return;
    L13:
        if (this.f119451q == true) goto L18;
        float r114 = this.Q;
        if (r114 != 1.0f) goto L17;
        this.f119437c = this.P * r114;
        goto L18
    L17:
        this.f119437c = r114;
    L18:
        this.f119451q = true;
        float r115 = (float) ((((double) 1) + (r106 / ((double) s1.y()))) * ((double) this.f119437c));
        float r107 = this.f119435a;
        if (r115 <= r107) goto L21;
        this.f119438d = r105;
        this.f119437c = r107;
        x(r107);
        return;
    L21:
        float r108 = this.f119436b;
        if (r115 >= r108) goto L24;
        this.f119438d = r105;
        this.f119437c = r108;
        x(r108);
        return;
    L24:
        x(Math.max(r108, Math.min(r107, r115)));
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void i(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getPointerCount() == 2) goto L5;
        return;
    L5:
        if (this.G == true) goto L44;
        int r101 = 0;
        this.f119449o = false;
        this.O = this.M;
        k.b r102 = this.f119459y;
        if (r102 != null) goto L9;
    L11:
        this.A = this.f119459y;
    L12:
        k.b r103 = this.A;
        if (r103 == null) goto L15;
        int r104 = r103.f119461a;
    L16:
        this.B = r100.getX(r100.findPointerIndex(r104));
        k.b r105 = this.A;
        if (r105 == null) goto L19;
        r101 = r105.f119461a;
    L19:
        this.C = r100.getY(r100.findPointerIndex(r101));
        WeakReference<View> r106 = this.f119444j;
        float r107 = 0.0f;
        if (r106 == null) goto L24;
        View r108 = r106.get();
        if (r108 == null) goto L24;
        float r109 = r108.getTranslationX();
    L25:
        this.D = r109;
        WeakReference<View> r110 = this.f119444j;
        if (r110 == null) goto L30;
        View r111 = r110.get();
        if (r111 == null) goto L30;
        r107 = r111.getTranslationY();
    L30:
        this.E = r107;
        if (tp0.f121317a.getValue().booleanValue() == false) goto L45;
        WeakReference<View> r112 = this.f119445k;
        if (r112 == null) goto L37;
        View r113 = r112.get();
        if (r113 == null) goto L37;
        r113.getTranslationX();
    L37:
        WeakReference<View> r114 = this.f119445k;
        if (r114 == null) goto L46;
        View r115 = r114.get();
        if (r115 == null) goto L47;
        r115.getTranslationY();
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L24:
        r109 = 0.0f;
        goto L25
    L15:
        r104 = 0;
        goto L16
    L9:
        if (r102.f119461a != r100.getPointerId(r100.getActionIndex())) goto L11;
        this.A = this.f119460z;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void j(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        this.G = false;
        int r100 = this.O;
        if (r100 != this.N) goto L13;
        if (this.f119452r == false) goto L7;
    L11:
        this.f119450p = false;
    L25:
        if (this.f119451q == false) goto L27;
    L28:
        float r111 = qg0.f121053a.getValue().floatValue();
        if (r111 <= 0) goto L38;
        float r101 = this.Q;
        float r102 = this.R;
        if (r101 >= (r102 / r111)) goto L33;
    L36:
        s();
    L137:
        this.H = false;
        return;
    L33:
        if (r102 <= (((double) r101) + 0.5d)) goto L38;
        if (r101 < 1.1f) goto L36;
    L38:
        if (this.Q > 1.0d) goto L41;
        s();
        goto L137
    L41:
        if (this.f119474d0 == false) goto L87;
        WeakReference<View> r112 = this.f119444j;
        if (r112 == null) goto L126;
        View r113 = r112.get();
        if (r113 == null) goto L126;
        float r103 = this.X - this.V;
        float r104 = this.Y - this.W;
        float r105 = this.Q;
        float r106 = r103 * r105;
        float r107 = r105 * r104;
        float r108 = 2;
        float r109 = (r106 - this.Z) / r108;
        float r114 = r113.getTranslationX();
        float r115 = r113.getTranslationY();
        if (r106 > this.Z) goto L49;
    L54:
        r109 = r114;
    L55:
        float r116 = r107 / r108;
        float r117 = this.f119473c0;
        float r118 = r116 - r117;
        float r119 = this.f119471a0;
        float r120 = (r119 - r117) - r116;
        if (r107 <= r119) goto L64;
        if (r115 >= r120) goto L61;
    L68:
        r118 = r120;
    L71:
        if (r109 == r114) goto L73;
    L74:
        super.y(r109, r118);
        WeakReference<View> r121 = this.f119444j;
        if (r121 == null) goto L79;
        View r122 = r121.get();
        if (r122 == null) goto L79;
        float r123 = r122.getTranslationX();
    L80:
        this.D = r123;
        WeakReference<View> r124 = this.f119444j;
        if (r124 == null) goto L85;
        View r125 = r124.get();
        if (r125 == null) goto L85;
        float r126 = r125.getTranslationY();
    L86:
        this.E = r126;
    L85:
        r126 = 0.0f;
    L79:
        r123 = 0.0f;
        goto L80
    L73:
        if (r118 == r115) goto L126;
    L61:
        if (r115 > r118) goto L71;
    L69:
        r118 = r115;
        goto L71
    L64:
        if (r115 < r118) goto L71;
        if (r115 <= r120) goto L69;
    L49:
        if (r114 > r109) goto L55;
        r109 = -r109;
        if (r114 >= r109) goto L54;
    L126:
        this.O = this.N;
        this.B = 0.0f;
        this.C = 0.0f;
        t();
        if (tp0.f121317a.getValue().booleanValue() == false) goto L129;
        v(this.f119457w, this.f119458x);
    L129:
        HashMap r127 = new HashMap();
        IUserService r128 = (IUserService) jc1.k.f(IUserService.class);
        if (r128 == null) goto L135;
        com.bytedance.android.livesdk.user.f r129 = r128.user();
        if (r129 == null) goto L135;
        String r130 = r129.n();
        if (r130 == null) goto L135;
    L136:
        r127.put("user_id", r130);
        ClearScreenLogUtils.f119492a.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_pitch_enlarge_success", r127);
    L135:
        r130 = "0";
        goto L136
    L87:
        WeakReference<View> r131 = this.f119444j;
        if (r131 == null) goto L126;
        View r132 = r131.get();
        if (r132 == null) goto L126;
        float r133 = this.Q;
        float r134 = this.Z;
        float r135 = r133 * r134;
        float r136 = this.f119471a0;
        float r137 = r133 * r136;
        float r138 = 2;
        float r139 = (r135 - r134) / r138;
        float r140 = (r137 - r136) / r138;
        float r141 = r132.getTranslationX();
        float r142 = r132.getTranslationY();
        if (r135 > this.Z) goto L94;
    L99:
        r139 = r141;
    L101:
        if (r137 > this.f119471a0) goto L103;
    L108:
        r140 = r142;
    L110:
        if (r139 == r141) goto L112;
    L113:
        super.y(r139, r140);
        WeakReference<View> r143 = this.f119444j;
        if (r143 == null) goto L118;
        View r144 = r143.get();
        if (r144 == null) goto L118;
        float r145 = r144.getTranslationX();
    L119:
        this.D = r145;
        WeakReference<View> r146 = this.f119444j;
        if (r146 == null) goto L124;
        View r147 = r146.get();
        if (r147 == null) goto L124;
        float r148 = r147.getTranslationY();
    L125:
        this.E = r148;
    L124:
        r148 = 0.0f;
    L118:
        r145 = 0.0f;
        goto L119
    L112:
        if (r140 == r142) goto L126;
    L103:
        if (r142 > r140) goto L110;
        r140 = -r140;
        if (r142 >= r140) goto L108;
    L94:
        if (r141 > r139) goto L101;
        r139 = -r139;
        if (r141 >= r139) goto L99;
    L27:
        if (this.f119452r == false) goto L137;
    L7:
        if (this.f119450p == false) goto L11;
        if ((System.currentTimeMillis() - this.U) >= this.T) goto L11;
        this.f119479i0 = MotionEvent.obtain(r110);
        s();
        goto L11
    L13:
        if (r100 != this.M) goto L25;
        if (c31.f119919a.getValue().booleanValue() == false) goto L25;
        if (this.f119452r == false) goto L19;
    L23:
        this.f119450p = false;
        goto L25
    L19:
        if (this.f119450p == false) goto L23;
        if ((System.currentTimeMillis() - this.U) >= this.T) goto L23;
        s();
        goto L23
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void p(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        WeakReference<View> r101 = this.f119444j;
        float r102 = 0.0f;
        if (r101 == null) goto L7;
        View r103 = r101.get();
        if (r103 == null) goto L7;
        float r104 = r103.getTranslationX();
    L8:
        this.D = r104;
        WeakReference<View> r105 = this.f119444j;
        if (r105 == null) goto L13;
        View r106 = r105.get();
        if (r106 == null) goto L13;
        r102 = r106.getTranslationY();
    L13:
        this.E = r102;
        super.p(r100);
        return;
    L7:
        r104 = 0.0f;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void x(float r100) {
        this.Q = r100;
        this.R = Math.max(this.R, r100);
        super.x(r100);
    }

    public final void B(MotionEvent r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "gestureDetectLayout");
        MotionEvent r102 = this.f119479i0;
        if (r102 == null) goto L5;
        r102.recycle();
    L5:
        this.f119479i0 = null;
        this.f119459y = new k.b(r100);
        if (this.O != this.N) goto L19;
        d(r101);
        r(true);
        this.B = r100.getX();
        this.C = r100.getY();
        WeakReference<View> r103 = this.f119444j;
        float r104 = 0.0f;
        if (r103 == null) goto L12;
        View r105 = r103.get();
        if (r105 == null) goto L12;
        float r106 = r105.getTranslationX();
    L13:
        this.D = r106;
        WeakReference<View> r107 = this.f119444j;
        if (r107 == null) goto L18;
        View r108 = r107.get();
        if (r108 == null) goto L18;
        r104 = r108.getTranslationY();
    L18:
        this.E = r104;
        this.f119450p = true;
    L12:
        r106 = 0.0f;
    L19:
        r100.getX();
        r100.getY();
        this.U = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final boolean g(MotionEvent r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "gestureDetectLayout");
        int r102 = r100.getPointerCount();
        if (r102 == 2) goto L5;
    L96:
        if (r102 < 3) goto L102;
        this.G = true;
        if (this.f119451q == false) goto L100;
    L101:
        s();
        goto L102
    L100:
        if (this.f119452r == true) goto L101;
    L102:
        return false;
    L5:
        if (this.G == true) goto L96;
        if (this.f119451q == false) goto L9;
    L94:
        s();
        return true;
    L9:
        if (this.f119452r == true) goto L94;
        this.f119460z = new k.b(r100);
        p(r101);
        if (this.O != 0) goto L49;
        WeakReference<View> r103 = this.f119444j;
        float r104 = 0.0f;
        if (r103 == null) goto L18;
        View r105 = r103.get();
        if (r105 == null) goto L18;
        float r106 = r105.getPivotX();
    L19:
        this.f119453s = r106;
        WeakReference<View> r107 = this.f119444j;
        if (r107 == null) goto L24;
        View r108 = r107.get();
        if (r108 == null) goto L24;
        float r109 = r108.getPivotY();
    L25:
        this.f119454t = r109;
        if (tp0.f121317a.getValue().booleanValue() == false) goto L39;
        WeakReference<View> r110 = this.f119445k;
        if (r110 == null) goto L32;
        View r111 = r110.get();
        if (r111 == null) goto L32;
        float r112 = r111.getPivotX();
    L33:
        this.f119457w = r112;
        WeakReference<View> r113 = this.f119445k;
        if (r113 == null) goto L38;
        View r114 = r113.get();
        if (r114 == null) goto L38;
        r104 = r114.getPivotY();
    L38:
        this.f119458x = r104;
    L32:
        r112 = 0.0f;
    L39:
        RoomContext r115 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r115 == null) goto L47;
        com.bytedance.live.datacontext.m<Integer> r116 = r115.getCleanMode();
        if (r116 == null) goto L47;
        if (r116.getValue().intValue() != ClearScreenConst$InteractType.INTERACT_SHOW.getId()) goto L47;
        boolean r117 = false;
    L48:
        this.f119475e0 = r117;
    L47:
        r117 = true;
    L24:
        r109 = 0.0f;
    L18:
        r106 = 0.0f;
    L49:
        k.b r118 = this.f119459y;
        if (r118 == null) goto L52;
        int r119 = r118.f119462b;
    L53:
        this.f119439e = r100.getX(r119);
        k.b r120 = this.f119459y;
        if (r120 == null) goto L56;
        int r121 = r120.f119462b;
    L57:
        this.f119441g = r100.getY(r121);
        k.b r122 = this.f119460z;
        if (r122 == null) goto L60;
        int r123 = r122.f119462b;
    L61:
        this.f119440f = r100.getX(r123);
        k.b r124 = this.f119460z;
        if (r124 == null) goto L64;
        int r125 = r124.f119462b;
    L65:
        this.f119442h = r100.getY(r125);
        this.f119438d = k.z(r100);
        this.f119449o = true;
        this.f119450p = true;
        this.O = this.L;
        o();
        this.f119434J.put("live_zoom_and_lock_notify", Boolean.TRUE);
        if (pg0.f120977a.getValue().booleanValue() == true) goto L68;
    L74:
        ClearScreenLogUtils.Companion r126 = ClearScreenLogUtils.f119492a;
        HashMap r127 = new HashMap();
        r126.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_enlarge_under_screen_clear", r127);
        WeakReference<View> r128 = this.f119444j;
        if (r128 == null) goto L79;
        View r129 = r128.get();
        if (r129 == null) goto L79;
        r129.setPivotX(this.f119472b0);
    L79:
        WeakReference<View> r130 = this.f119444j;
        if (r130 == null) goto L84;
        View r131 = r130.get();
        if (r131 == null) goto L84;
        r131.setPivotY(this.f119473c0);
    L84:
        WeakReference<View> r132 = this.f119445k;
        if (r132 == null) goto L89;
        View r133 = r132.get();
        if (r133 == null) goto L89;
        r133.setPivotX(this.f119472b0);
    L89:
        WeakReference<View> r134 = this.f119445k;
        if (r134 == null) goto L102;
        View r135 = r134.get();
        if (r135 == null) goto L102;
        r135.setPivotY(this.f119473c0);
        goto L102
    L68:
        if (this.f119475e0 == true) goto L74;
        this.f119477g0 = true;
        StringBuilder r136 = new StringBuilder("hashcode = ");
        r136.append(hashCode());
        r136.append(' ');
        q r137 = this.f119476f0;
        if (r137 == null) goto L72;
        int r138 = r137.hashCode();
    L73:
        r136.append(r138);
        ALogger.i("GestureBaseBehavior", r136.toString());
        ClearScreenHelper.m(true);
        goto L74
    L72:
        r138 = 0;
        goto L73
    L64:
        r125 = 1;
        goto L65
    L60:
        r123 = 1;
        goto L61
    L56:
        r121 = 0;
        goto L57
    L52:
        r119 = 0;
        goto L53
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k, com.bytedance.android.livesdk.widget.y
    public final boolean onTouchEvent(ViewGroup r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r101, "event");
        Lazy r102 = ClearScreenHelper.f119484a;
        if (ClearScreenHelper.h(this.f119434J) == true) goto L8;
        if (k() == true) goto L8;
        return false;
    L8:
        if (f() == false) goto L11;
        return false;
    L11:
        if (r101.getPointerCount() <= 2) goto L14;
        s();
        return false;
    L14:
        RoomContext r103 = RoomContext.a.c(RoomContext.Companion, this.f119434J, 0, 2);
        if (r103 == null) goto L21;
        com.bytedance.live.datacontext.m<Room> r104 = r103.getRoom();
        if (r104 == null) goto L21;
        Room r105 = r104.getValue();
        if (r105 == null) goto L21;
        boolean r106 = r105.isVrRoom();
    L23:
        if (r106 == false) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == false) goto L73;
        return false;
    L73:
        int r108 = r101.getAction() & 255;     // Catch: IllegalArgumentException -> L50
        if (r108 == 0) goto L48;
        if (r108 == 1) goto L47;
        if (r108 != 2) goto L36;
        h(r101);     // Catch: IllegalArgumentException -> L50
    L72:
    L52:
        if (r107 == false) goto L54;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r109 = LiveVrContext.c.a();
        if (r109 == null) goto L66;
        com.bytedance.live.datacontext.m<? extends Boolean> r110 = r109.isVrSensorOpen();
        if (r110 == null) goto L66;
        Boolean r111 = r110.getValue();
        if (r111 == null) goto L66;
        boolean r112 = r111.booleanValue();
    L67:
        if (r107 == false) goto L70;
        if (r112 == true) goto L70;
        return false;
    L70:
        return true;
    L66:
        r112 = true;
        goto L67
    L54:
        if (this.f119452r == false) goto L56;
    L57:
        return true;
    L56:
        if (this.f119451q == true) goto L57;
        return false;
    L36:
        if (r108 == 3) goto L47;
        if (r108 == 5) goto L44;
        if (r108 != 6) goto L72;
        i(r101);     // Catch: IllegalArgumentException -> L50
        goto L72
    L44:
        if (g(r101, r100) == false) goto L72;
        return true;
    L47:
        j(r101);     // Catch: IllegalArgumentException -> L50
        goto L72
    L48:
        B(r101, r100);     // Catch: IllegalArgumentException -> L50
    L50:
        e = move-exception;
        ALogger.e("GestureBaseBehavior", "IllegalArgumentException error: " + e.toString());
        goto L52
    L25:
        if (VrUtils.v(this.f119434J) == true) goto L28;
        r107 = false;
    L21:
        r106 = false;
        goto L23
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void w(float r100, float r101) {
        WeakReference<View> r102 = this.f119445k;
        if (r102 == null) goto L7;
        View r103 = r102.get();
        if (r103 == null) goto L7;
        r103.setTranslationX(r100);
    L7:
        WeakReference<View> r104 = this.f119445k;
        if (r104 == null) goto L13;
        View r105 = r104.get();
        if (r105 == null) goto L14;
        r105.setTranslationY(r101);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void y(float r100, float r101) {
        super.y(r100, r101);
    }

    public o(LivePlayerView r100, DataCenter r101, Context r102, ZoomType r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "zoomType");
        super(r100, r101, r102, null, r110);
        boolean r103 = true;
        this.L = 1;
        this.M = 2;
        this.N = 3;
        this.O = 0;
        this.P = 1.0f;
        this.Q = 1.0f;
        this.R = 1.0f;
        this.S = 24;
        this.T = 400;
        this.S = ViewConfiguration.get(r102).getScaledTouchSlop();
        this.T = ViewConfiguration.getLongPressTimeout();
        WeakReference<View> r104 = this.f119444j;
        float r105 = 0.0f;
        if (r104 == null) goto L7;
        View r106 = r104.get();
        if (r106 == null) goto L7;
        float r107 = r106.getWidth();
    L8:
        this.Z = r107;
        WeakReference<View> r108 = this.f119444j;
        if (r108 == null) goto L13;
        View r109 = r108.get();
        if (r109 == null) goto L13;
        r105 = r109.getHeight();
    L13:
        this.f119471a0 = r105;
        A();
        boolean r111 = gs1.b.f482438a;
        HashMap<ClearScreenConst$InteractType, jg1.a> r112 = gs1.b.a(a0.p(this.f119434J)).g();
        if (r112 == null) goto L20;
        ClearScreenConst$InteractType r113 = ClearScreenConst$InteractType.ZOOM_MODE_CLEAR;
        if (r112.get(r113) == null) goto L20;
        int r114 = gs1.a.f482437a;
        h r115 = gs1.a.a(a0.p(this.f119434J));
        if (r115 == null) goto L20;
        r115.a(r113);
    L20:
        q r116 = new q(this);
        this.f119476f0 = r116;
        int r117 = gs1.a.f482437a;
        h r118 = gs1.a.a(a0.p(this.f119434J));
        if (r118 == null) goto L23;
        r118.b(r116);
    L23:
        RoomContext.a r119 = RoomContext.Companion;
        RoomContext r120 = RoomContext.a.c(r119, null, 0, 3);
        if (r120 == null) goto L31;
        com.bytedance.live.datacontext.m<Integer> r121 = r120.getCleanMode();
        if (r121 == null) goto L31;
        if (r121.getValue().intValue() != ClearScreenConst$InteractType.INTERACT_SHOW.getId()) goto L31;
        r103 = false;
    L31:
        this.f119475e0 = r103;
        RoomContext r122 = RoomContext.a.c(r119, null, 0, 3);
        if (r122 == null) goto L38;
        com.bytedance.live.datacontext.m<Integer> r123 = r122.getCleanMode();
        if (r123 == null) goto L38;
        Observable<Integer> r124 = r123.a();
        if (r124 == null) goto L38;
        r124.subscribe(new n(this));
    L38:
        this.f119478h0 = com.bytedance.android.livesdk.widget.b.h.f161423c;
        return;
    L7:
        r107 = 0.0f;
        goto L8
    }
}
