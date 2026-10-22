package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.app.Activity;
import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.AudioComposeSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.b1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.j0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.t1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.z1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import ec2.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class g implements z62.b, z62.f, z62.d, z62.c, z62.a, z62.j, z62.e, z62.h, z62.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditText f135496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f135497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.audio.c f135498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f135499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f135500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ z62.b f135501f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ z62.f f135502g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ z62.d f135503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z62.c f135504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z62.a f135505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ z62.j f135506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ z62.e f135507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z62.h f135508m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ z62.g f135509n;

    public void A(com.bytedance.android.live.profit.privilege.model.danmu.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tabItem");
        this.f135504i.A(r100);
    }

    public void A0() {
    }

    @Override // z62.g
    public final int B() {
        return this.f135509n.B();
    }

    public abstract void B0();

    @Override // z62.b
    public final void C(com.bytedance.android.live.base.model.data.activityemoji.b r100) {
        Intrinsics.checkNotNullParameter(r100, "activityEmoji");
        this.f135501f.C(r100);
    }

    public void C0() {
    }

    @Override // z62.b
    public final int[] D() {
        return this.f135501f.D();
    }

    public abstract void D0();

    @Override // z62.b
    public final void E() {
        this.f135501f.E();
    }

    public void E0() {
    }

    @Override // z62.h
    public final void F(int r100) {
        this.f135508m.F(r100);
    }

    public void F0() {
    }

    public void G(InputDialogFragmentSwitchType r100, AbsLiveInputSecondaryFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "switchType");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
    }

    public abstract void G0();

    public boolean H() {
        return false;
    }

    public abstract void I();

    public abstract void J();

    public abstract void K();

    public abstract void L();

    public void M(boolean r100) {
    }

    public void N(boolean r100) {
    }

    public abstract void O(boolean r100);

    public void P(boolean r100) {
    }

    public abstract InputSectionType Q();

    public abstract DataCenter R();

    public abstract CommentFlowContext S();

    public abstract Fragment T();

    public x22.e U() {
        return null;
    }

    public abstract com.bytedance.android.livesdk.interactivity.comment.newinput.c V();

    public abstract int W();

    public abstract int X();

    @Override // z62.d
    public final void a(EditText r100) {
        this.f135503h.a(r100);
    }

    public abstract MeasureLinearLayout a0();

    @Override // z62.d
    public void b(BaseEmoji r100, String r101, EditText r102) {
        this.f135503h.b(r100, r101, r102);
    }

    public abstract IBaseUser b0();

    @Override // z62.b
    public final void c() {
        this.f135501f.c();
    }

    @Override // z62.e
    public final void d(boolean r100) {
        this.f135507l.d(r100);
    }

    @Override // z62.b
    public final int e() {
        return this.f135501f.e();
    }

    @Override // z62.a
    public final int f() {
        return this.f135505j.f();
    }

    @Override // z62.b
    public final void g(com.bytedance.android.livesdk.interactivity.api.emoji.a r100) {
        Intrinsics.checkNotNullParameter(r100, "emoji");
        this.f135501f.g(r100);
    }

    public abstract Activity getActivity();

    public abstract Context getContext();

    @Override // z62.c
    public final void h() {
        this.f135504i.h();
    }

    @Override // z62.h
    public final boolean i() {
        return this.f135508m.i();
    }

    @Override // z62.b
    public final void j(com.bytedance.android.livesdk.interactivity.api.emoji.a r100) {
        Intrinsics.checkNotNullParameter(r100, "emoji");
        this.f135501f.j(r100);
    }

    @Override // z62.c
    public final void k(z62.i r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f135504i.k(r100);
    }

    public abstract boolean k0();

    @Override // z62.b
    public final void l(Context r100, com.bytedance.android.live.base.model.message.h r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "activityEmoji");
        Intrinsics.checkNotNullParameter(r102, "text");
        Intrinsics.checkNotNullParameter(r103, "clickArea");
        this.f135501f.l(r100, r101, r102, r103);
    }

    public abstract boolean l0();

    @Override // z62.a
    public final boolean m() {
        return this.f135505j.m();
    }

    public abstract boolean m0();

    @Override // z62.j
    public final int n() {
        return this.f135506k.n();
    }

    public abstract boolean n0();

    @Override // z62.b
    public final void o(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_SEARCH_WORD);
        this.f135501f.o(r100, r101);
    }

    public void o0(InputDialogFragmentSwitchType r100, AbsLiveInputSecondaryFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "switchType");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
    }

    @Override // z62.g
    public final void p(z1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f135509n.p(r100);
    }

    public abstract void p0();

    @Override // z62.b
    public final void q(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_SEARCH_WORD);
        this.f135501f.q(r100, r101);
    }

    public abstract void q0(InputPanelSectionContainer.c r100);

    @Override // z62.f
    public final void r(boolean r100) {
        this.f135502g.r(r100);
    }

    public abstract void r0(TokenCert r100);

    @Override // z62.h
    public final void s(InputFunctionEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        this.f135508m.s(r100);
    }

    public void s0(String r100, long r101) {
    }

    @Override // z62.b
    public final void t(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f135501f.t(r100);
    }

    public abstract void t0();

    @Override // z62.b
    public final long u() {
        return this.f135501f.u();
    }

    public abstract void u0(int r100);

    @Override // z62.j
    public final long v() {
        return this.f135506k.v();
    }

    public abstract void v0();

    @Override // z62.b
    public final void w(TextWatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "watcher");
        this.f135501f.w(r100);
    }

    public void w0() {
    }

    @Override // z62.b
    public final void x(com.bytedance.android.live.profit.privilege.model.danmu.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tabItem");
        this.f135501f.x(r100);
    }

    public void x0() {
    }

    @Override // z62.c
    public final int y() {
        return this.f135504i.y();
    }

    public abstract void y0();

    @Override // z62.h
    public final b z() {
        return this.f135508m.z();
    }

    public abstract void z0();

    public final boolean d0() {
        if (Intrinsics.areEqual(h0.f472022a.getValue(), Boolean.FALSE) == false) goto L5;
        return false;
    L5:
        CommentFlowContext r100 = S();
        if (r100 == null) goto L10;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L10;
        CommentInputConfig.State r102 = r101.f133082u;
    L12:
        if (r102 != CommentInputConfig.State.ForceOpen) goto L15;
        return true;
    L15:
        if (r102 != CommentInputConfig.State.ForeClose) goto L17;
        return false;
    L17:
        return true;
    L10:
        r102 = null;
        goto L12
    }

    public final com.bytedance.android.livesdk.interactivity.api.quickcomment.f Y() {
        com.bytedance.android.livesdk.interactivity.api.h r100 = com.bytedance.android.livesdk.interactivity.api.i.b(R(), 1);
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r101 = r100.getQuickCommentManager();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    public final long Z() {
        DataCenter r100 = R();
        if (r100 == null) goto L7;
        IRoom r101 = a0.n(r100);
        if (r101 == null) goto L7;
        return r101.getRoomId();
    L7:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c0() {
        if (rf2.a.a() == false) goto L5;
        return false;
    L5:
        CommentFlowContext r100 = S();
        if (r100 == null) goto L10;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L10;
        CommentInputConfig.State r102 = r101.f133065d;
    L12:
        if (r102 != CommentInputConfig.State.ForceOpen) goto L15;
        return true;
    L15:
        if (r102 != CommentInputConfig.State.ForeClose) goto L17;
        return false;
    L17:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r103 = V();
        if (r103 != null) goto L20;
        return false;
    L20:
        if (r103.f135414b != true) goto L29;
        Integer r104 = (Integer) hd0.c.f().f481009b;
        if (r104 != null) goto L25;
    L26:
        return true;
    L25:
        if (r104.intValue() != 2) goto L26;
        return false;
    L29:
        return false;
    L10:
        r102 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean e0() {
        if (rf2.a.a() == false) goto L5;
        return false;
    L5:
        CommentFlowContext r100 = S();
        if (r100 == null) goto L10;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L10;
        CommentInputConfig.State r102 = r101.f133064c;
    L12:
        if (r102 != CommentInputConfig.State.ForceOpen) goto L15;
        return true;
    L15:
        if (r102 != CommentInputConfig.State.ForeClose) goto L17;
        return false;
    L17:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r103 = V();
        if (r103 == null) goto L20;
        boolean r104 = r103.f135413a;
    L21:
        if (r104 == false) goto L29;
        Integer r105 = (Integer) hd0.c.f().f481009b;
        if (r105 != null) goto L26;
    L27:
        return true;
    L26:
        if (r105.intValue() != 2) goto L27;
        return false;
    L29:
        return false;
    L20:
        r104 = false;
    L10:
        r102 = null;
        goto L12
    }

    public final boolean f0() {
        CommentFlowContext r100 = S();
        if (r100 == null) goto L7;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L7;
        CommentInputConfig.State r102 = r101.f133062a;
    L9:
        if (r102 != CommentInputConfig.State.ForceOpen) goto L13;
        return true;
    L13:
        if (r102 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r103 = V();
        if (r103 != null) goto L18;
        return false;
    L18:
        return r103.f135415c;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean g0() {
        CommentFlowContext r100 = S();
        if (r100 == null) goto L7;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L7;
        CommentInputConfig.State r102 = r101.f133083v;
    L9:
        if (r102 != CommentInputConfig.State.ForceOpen) goto L12;
        return true;
    L12:
        if (r102 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        return true;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean h0() {
        CommentFlowContext r100 = S();
        Boolean r101 = null;
        if (r100 == null) goto L7;
        CommentInputConfig r102 = r100.f133051d;
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.f133084w);
    L8:
        Boolean r104 = Boolean.FALSE;
        if (Intrinsics.areEqual(r103, r104) == false) goto L11;
        return false;
    L11:
        if (rf2.a.a() == true) goto L53;
        IRoomContextService r105 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r105 == null) goto L46;
        o r106 = IRoomContextService.a.a(r105, R(), 0, 2);
        if (r106 == null) goto L47;
        com.bytedance.live.datacontext.m<IRoom> r107 = r106.getRoom();
        if (r107 == null) goto L48;
        IRoom r108 = r107.getValue();
        if (r108 == null) goto L54;
        DataCenter r109 = R();
        if (r109 == null) goto L25;
        Boolean r110 = (Boolean) r109.get("data_is_anchor", r104);
    L26:
        Boolean r111 = Boolean.TRUE;
        boolean r112 = Intrinsics.areEqual(r110, r111);
        Boolean r113 = v22.a.f552665a;
        Intrinsics.checkNotNullParameter(r108, "room");
        IRoomAuthStatus r114 = r108.getRoomAuthStatus();
        if (r114 != null) goto L29;
    L31:
        boolean r115 = false;
    L32:
        com.bytedance.android.livesdk.interactivity.api.h r116 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r116 == null) goto L37;
        com.bytedance.live.datacontext.j<Boolean> r117 = r116.getHighlightEnable();
        if (r117 == null) goto L37;
        r101 = r117.getValue();
    L37:
        boolean r118 = Intrinsics.areEqual(r101, r111);
        if (r115 == false) goto L49;
        if (r118 == true) goto L41;
        return false;
    L41:
        if (v22.a.f552665a.booleanValue() == false) goto L51;
        if (r112 == true) goto L52;
        return true;
    L52:
        return false;
    L51:
        return false;
    L49:
        return false;
    L29:
        if (r114.isEnablePinHighlight() != true) goto L31;
        r115 = true;
        goto L32
    L25:
        r110 = null;
        goto L26
    L54:
        return false;
    L48:
        return false;
    L47:
        return false;
    L46:
        return false;
    L53:
        return false;
    L7:
        r103 = null;
        goto L8
    }

    public final boolean i0() {
        CommentFlowContext r100 = S();
        if (r100 == null) goto L7;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L7;
        CommentInputConfig.State r102 = r101.f133072k;
    L9:
        if (r102 != CommentInputConfig.State.ForceOpen) goto L13;
        return true;
    L13:
        if (r102 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        IRoomContextService r103 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r103 == null) goto L27;
        o r104 = IRoomContextService.a.a(r103, R(), 0, 2);
        if (r104 == null) goto L28;
        com.bytedance.live.datacontext.m<IRoom> r105 = r104.getRoom();
        if (r105 == null) goto L29;
        IRoom r106 = r105.getValue();
        if (r106 == null) goto L30;
        IRoomAuthStatus r107 = r106.getRoomAuthStatus();
        if (r107 != null) goto L26;
        return false;
    L26:
        return r107.isEnableInteractivtyShare();
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final boolean j0() {
        CommentFlowContext r100 = S();
        if (r100 == null) goto L7;
        CommentInputConfig r101 = r100.f133051d;
        if (r101 == null) goto L7;
        CommentInputConfig.State r102 = r101.f133066e;
    L9:
        if (r102 != CommentInputConfig.State.ForceOpen) goto L13;
        return true;
    L13:
        if (r102 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r103 = V();
        if (r103 != null) goto L18;
        return false;
    L18:
        return r103.f135417e;
    L7:
        r102 = null;
        goto L9
    }

    public g(com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r100, j0.d r101, x.a r102, DanmakuSectionProvider.c r103, AudioComposeSectionProvider.g r104, e0.d r105, d1.d r106, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r107, t1.d r110, b1.c r111, int r112) {
        z62.b r108 = r100;
        if ((r112 & 1) == 0) goto L5;
        r108 = com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.f135829g;
    L5:
        z62.f r109 = r101;
        if ((r112 & 2) == 0) goto L8;
        r109 = j0.f135894e;
    L8:
        z62.a r113 = r104;
        if ((r112 & 16) == 0) goto L11;
        r113 = AudioComposeSectionProvider.f135549v;
    L11:
        z62.e r114 = r105;
        if ((r112 & 32) == 0) goto L14;
        r114 = e0.f135865d;
    L14:
        z62.h r115 = r106;
        if ((r112 & 64) == 0) goto L17;
        r115 = d1.f135800e;
    L17:
        Object r116 = r107;
        if ((r112 & 128) == 0) goto L20;
        r116 = com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.f135760f;
    L20:
        z62.j r117 = r110;
        if ((r112 & 256) == 0) goto L23;
        r117 = t1.f135972d;
    L23:
        z62.g r118 = r111;
        if ((r112 & 512) == 0) goto L26;
        r118 = b1.f135778d;
    L26:
        Intrinsics.checkNotNullParameter(r108, "contentSectionBridge");
        Intrinsics.checkNotNullParameter(r109, "landscapeControlSectionBridge");
        Intrinsics.checkNotNullParameter(r102, "emojiSectionBridge");
        Intrinsics.checkNotNullParameter(r103, "danmakuSectionBridge");
        Intrinsics.checkNotNullParameter(r113, "audioComposeBridge");
        Intrinsics.checkNotNullParameter(r114, "inputSendSectionBridge");
        Intrinsics.checkNotNullParameter(r115, "newPortraitControlSectionBridge");
        Intrinsics.checkNotNullParameter(r116, "audioSectionBridge");
        Intrinsics.checkNotNullParameter(r117, "wordAssociateBridge");
        Intrinsics.checkNotNullParameter(r118, "mentionBridge");
        this.f135501f = r108;
        this.f135502g = r109;
        this.f135503h = r102;
        this.f135504i = r103;
        this.f135505j = r113;
        this.f135506k = r117;
        this.f135507l = r114;
        this.f135508m = r115;
        this.f135509n = r118;
    }
}
