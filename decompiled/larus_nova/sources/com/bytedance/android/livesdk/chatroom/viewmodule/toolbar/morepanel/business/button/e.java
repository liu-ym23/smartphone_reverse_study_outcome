package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import am2.j;
import am2.x;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.t;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.ext.ChangeIconThemeHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.z3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorBacktrackBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAudioCommentBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarShakeMatchBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.n2;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.config.setting.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdk.room.placeholder.behavior.p;
import com.bytedance.android.livesdk.utils.g3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.m;

/* JADX INFO: loaded from: classes8.dex */
public abstract class e implements s<lp1.a>, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f116519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lp1.a f116520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f116521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jp1.b f116522d;

    public final boolean c() {
        return z.e(this.f116522d.getDataCenter(), false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final void j() {
        lp1.a r100 = this.f116520b;
        if (r100 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r101 = r100.getButton();
        if (r101 == null) goto L9;
        s<Object> r102 = r101.f115919k;
        if (r102 == null) goto L9;
        r102.j();
    L9:
        this.f116519a.clear();
    }

    public e(jp1.b r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f116522d = r100;
        this.f116519a = new CompositeDisposable();
        this.f116521c = 0.64f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        lp1.a r100 = null;
        String r101 = null;
        if (r110 == null) goto L5;
        Object r102 = r110.getTag();
    L7:
        if ((r102 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == true) goto L9;
        r102 = null;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r103 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r102;
        if (r103 == null) goto L12;
        ExtendedToolbarButton r104 = r103.f115921m;
    L13:
        x3 r105 = this.f116522d.getToolbarManager();
        if (r104 == null) goto L143;
        DataCenter r106 = this.f116522d.getDataCenter();
        if (r106 == null) goto L18;
        m r107 = (m) r106.get("data_broadcast_pause_state", null);
    L20:
        if (r107 == null) goto L25;
        int r108 = r107.f571877a;
        if (r108 == 1) goto L24;
        if (r108 != 2) goto L25;
    L24:
        boolean r109 = true;
    L26:
        if (r109 == false) goto L32;
        if (r105 == null) goto L32;
        if (r105.x(r104) != true) goto L32;
        f2.b(R.string.ttlive_broadcast_voluntary_pause_feature_enable_toast, 0);
        return;
    L32:
        if (r105 == null) goto L34;
        c0.b r111 = r105.s(r104);
    L35:
        if (r105 != null) goto L37;
    L42:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r112 = r103.f115918j;
        if (r112 != null) goto L45;
    L53:
        if (r111 != null) goto L55;
        return;
    L55:
        if (c4.a(c()) == false) goto L62;
        if (r110 == null) goto L58;
        View r113 = r110.findViewById(R.id.red_dot);
    L60:
        if ((r113 instanceof RedDotView) == false) goto L62;
        ((RedDotView) r113).l();
        goto L62
    L58:
        r113 = null;
    L62:
        r111.onClick(r110);
        b4.c.f115769a.b(r104.f());
        h r114 = (h) this;
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r111, "behavior");
        lp1.a r115 = r114.f116520b;
        if (r115 == null) goto L65;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r116 = r115.getButton();
    L66:
        if (r116 != null) goto L69;
    L97:
        lp1.a r117 = r114.f116520b;
        if (r117 == null) goto L103;
        k r118 = (k) r114.f116522d.b();
        if (r118 == null) goto L103;
        r118.checkClickEffectButton(r117);
    L103:
        if ((r104 instanceof ExtendedToolbarButton.d) == false) goto L106;
        r114.d();
        return;
    L106:
        if ((r111 instanceof ToolbarAnchorBacktrackBehavior) == false) goto L111;
        if (((ToolbarAnchorBacktrackBehavior) r111).f116923d == false) goto L146;
        r114.d();
        return;
    L146:
        return;
    L111:
        if ((r111 instanceof ToolbarAnchorRecordBehavior) == false) goto L116;
        if (((ToolbarAnchorRecordBehavior) r111).f116932e == false) goto L148;
        r114.d();
        return;
    L148:
        return;
    L116:
        if ((r111 instanceof ToolbarShakeMatchBehavior) == false) goto L119;
        ToolbarShakeMatchBehavior r119 = (ToolbarShakeMatchBehavior) r111;
        return;
    L119:
        if ((r111 instanceof n2) == false) goto L122;
        n2 r120 = (n2) r111;
        return;
    L122:
        if ((r111 instanceof p) == false) goto L124;
        return;
    L124:
        if ((r104 instanceof ExtendedToolbarButton.b) == false) goto L138;
        ToolbarButton r121 = ((ExtendedToolbarButton.b) r104).f115626i;
        if (r121 == ToolbarButton.REVERSE_CAMERA) goto L138;
        if (r121 == ToolbarButton.REVERSE_MIRROR) goto L138;
        if (r121 == ToolbarButton.AUDIO_TOGGLE) goto L138;
        if (r121 == ToolbarButton.WATCH_LATER) goto L138;
        if ((r111 instanceof ToolbarAudioCommentBehavior) == true) goto L136;
    L139:
        r114.d();
        return;
    L136:
        if (((ToolbarAudioCommentBehavior) r111).f116960d == true) goto L139;
    L138:
        if ((r104 instanceof ExtendedToolbarButton.c) == true) goto L139;
        return;
    L69:
        if (r116.f115920l.length() <= 0) goto L71;
        boolean r122 = true;
    L72:
        if (r122 == false) goto L74;
        String r123 = r116.f115920l;
    L75:
        HashMap r124 = new HashMap();
        r124.put("icon_type", r123);
        j.c r125 = j.a().f4291b;
        if (r125 != null) goto L78;
        int r126 = -1;
    L79:
        r124.put("net_quality", String.valueOf(r126));
        lp1.a r127 = r114.f116520b;
        if (r127 != null) goto L82;
    L86:
        IUserService r128 = (IUserService) jc1.k.f(IUserService.class);
        if (r128 == null) goto L95;
        com.bytedance.android.livesdk.user.f r129 = r128.user();
        if (r129 == null) goto L95;
        IUser r130 = r129.b();
        if (r130 == null) goto L95;
        py.d r131 = r130.getUserHonor();
        if (r131 == null) goto L95;
        int r132 = r131.getLevel();
    L96:
        r124.put("privilege_level", String.valueOf(r132));
        u.l().sendLog("livesdk_more_function_panel_icon_click", r124, new Object[]{x.class, Room.class});
    L95:
        r132 = 0;
        goto L96
    L82:
        if (r127.a() == false) goto L84;
        r100 = r127;
    L84:
        if (r100 == null) goto L86;
        r124.put("bubble_type", r100.getButton().f115920l);
        goto L86
    L78:
        r126 = r125.getNetQuality();
        goto L79
    L74:
        r123 = r116.f115914f;
        goto L75
    L71:
        r122 = false;
        goto L72
    L65:
        r116 = null;
        goto L66
    L45:
        if (r112.a() != true) goto L53;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r133 = r103.f115918j;
        if (r133 == null) goto L50;
        r101 = r133.f115931b;
    L50:
        if (TextUtils.isEmpty(r101) == true) goto L142;
        f2.c(r101, 0);
        return;
    L142:
        return;
    L37:
        if (r105.x(r104) != true) goto L42;
        String r134 = r105.u(r104);
        if (TextUtils.isEmpty(r134) == true) goto L141;
        f2.c(r134, 0);
        return;
    L141:
        return;
    L34:
        r111 = null;
    L25:
        r109 = false;
        goto L26
    L18:
        r107 = null;
        goto L20
    L143:
        return;
    L12:
        r104 = null;
        goto L13
    L5:
        r102 = null;
        goto L7
    }

    public static void a(View r100, lp1.a r101) {
        if (((List) ChangeIconThemeHelper.f116587a.getValue()).contains(Long.valueOf(r101.getButton().f115915g)) == true) goto L5;
        boolean r102 = true;
        if (r101.getButton().f115917i != 1) goto L36;
        Intrinsics.checkNotNullParameter(r101, "buttonModel");
        ExtendedToolbarButton r103 = r101.getButton().f115921m;
        if (r103.f115623e == true) goto L16;
    L26:
        boolean r104 = false;
    L27:
        if (r104 == true) goto L30;
        r103 = null;
    L30:
        if (r103 != null) goto L33;
        r102 = false;
    L33:
        if (r102 == true) goto L36;
        return;
    L16:
        if ((r103 instanceof ExtendedToolbarButton.b) == true) goto L18;
        ExtendedToolbarButton r105 = null;
    L19:
        ExtendedToolbarButton.b r106 = (ExtendedToolbarButton.b) r105;
        if (r106 == null) goto L22;
        ToolbarButton r107 = r106.f115626i;
    L24:
        if (r107 != ToolbarButton.KTV_GROUP) goto L26;
        r104 = true;
        goto L27
    L22:
        r107 = null;
        goto L24
    L18:
        r105 = r103;
    L36:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L38;
        int r108 = (int) 4279638051L;
    L39:
        if (r100 == null) goto L49;
        Drawable r109 = r100.getBackground();
        if (r109 == null) goto L50;
        Drawable r110 = r109.mutate();
        if (r110 == null) goto L51;
        r110.setColorFilter(r108, PorterDuff.Mode.SRC_ATOP);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L38:
        r108 = -1;
        goto L39
    L5:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == true) goto L7;
        return;
    L7:
        if (r101.getButton().f115915g != ToolbarButton.VS_INTERACTIVE.getId()) goto L47;
        if (r100 == null) goto L48;
        r100.setBackgroundResource(R.drawable.ttlive_ic_vs_interactive_switch_light_theme);
        return;
    L48:
        return;
    }

    public final void b(final lp1.a r110, View r111, int r210) {
        Intrinsics.checkNotNullParameter(r110, "buttonModel");
        Intrinsics.checkNotNullParameter(r111, "itemView");
        this.f116520b = r110;
        final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r100 = r110.getButton();
        s<Object> r101 = r100.f115919k;
        if (r101 == null) goto L6;
        r101.o(this.f116522d.c(), r100, r111, r210);
        return;
    L6:
        Context r102 = r111.getContext();
        x3 r103 = this.f116522d.getToolbarManager();
        View r104 = r111.findViewById(R.id.icon);
        final View r105 = r111.findViewById(R.id.vIconBg);
        TextView r106 = (TextView) r111.findViewById(R.id.name);
        View r112 = r111.findViewById(R.id.red_dot);
        View r113 = r111.findViewById(R.id.action_area);
        TextView r114 = (TextView) r111.findViewById(R.id.icon_description);
        if (r105 != null) goto L9;
    L13:
        if (r105 != null) goto L15;
    L19:
        if (r104 == null) goto L21;
        r104.setBackgroundResource(r100.f115910b);
    L21:
        ExtendedToolbarButton r115 = r100.f115921m;
        if ((r115 instanceof ExtendedToolbarButton.b) == true) goto L24;
        r115 = null;
    L24:
        ExtendedToolbarButton.b r116 = (ExtendedToolbarButton.b) r115;
        if (r116 == null) goto L27;
        ToolbarButton r117 = r116.f115626i;
    L29:
        if (r117 != ToolbarButton.AUDIENCE_RESOLUTION) goto L31;
        boolean r118 = true;
    L32:
        if (r106 == null) goto L35;
        r106.setText(r100.f115914f);
    L35:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L37;
        int r119 = 2132154403;
    L38:
        if (r106 == null) goto L40;
        r106.setTextColor(r119);
    L40:
        if (r106 == null) goto L46;
        if (r118 == false) goto L43;
        View.AccessibilityDelegate r120 = new b(r100);
    L44:
        r106.setAccessibilityDelegate(r120);
        goto L46
    L43:
        r120 = t.f66402a;
    L46:
        if (o.b() == false) goto L52;
        if (s1.y() >= s1.f(360.0f)) goto L52;
        if (r106 == null) goto L52;
        r106.setTextSize(1, 10.0f);
    L52:
        if (r100.f115909a == false) goto L63;
        List<String> r121 = r100.f115911c;
        if (r121 == null) goto L63;
        if ((!r121.isEmpty()) != true) goto L63;
        CompositeDisposable r122 = this.f116519a;
        List<String> r123 = r100.f115911c;
        if (r123 == null) goto L61;
        String r124 = (String) ListProtector.get(r123, 0);
        if (r124 == null) goto L61;
    L62:
        r122.add(g3.a(r124).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(c.f116514a).onErrorComplete().subscribe(new d(this, r104, r102, r110)));
    L61:
        r124 = "";
    L63:
        if (r114 != null) goto L65;
    L67:
        if (r114 == null) goto L70;
        UtilityKotlinExtentionsKt.t(r114);
    L70:
        if (r100.f115912d == false) goto L79;
        ImageView r107 = new ImageView(r104.getContext());
        if (r100.f115913e == false) goto L74;
        int r125 = R.drawable.ttlive_ic_toolbar_switch_on;
    L75:
        r107.setBackgroundResource(r125);
        LiveViewStub r126 = (LiveViewStub) r111.findViewById(R.id.icon_switch);
        if (r126 == null) goto L79;
        r126.a(r107);
        goto L79
    L74:
        r125 = R.drawable.ttlive_ic_toolbar_switch_off;
    L79:
        if (r113 == null) goto L81;
        r113.setAlpha(1.0f);
    L81:
        if (r103 == null) goto L85;
        boolean r127 = true;
        if (r103.x(r100.f115921m) != true) goto L86;
    L90:
        if (r104 == null) goto L92;
        r104.setAlpha(this.f116521c);
    L92:
        if (r106 == null) goto L94;
        r106.setAlpha(this.f116521c);
    L94:
        if (r112 == null) goto L96;
        r112.setAlpha(0.0f);
    L96:
        boolean r128 = true;
    L109:
        if (c4.a(c()) == false) goto L116;
        if ((r112 instanceof RedDotView) == false) goto L116;
        RedDotDelegate r129 = r100.f115921m.f115621c;
        if (r129 == null) goto L116;
        ((RedDotView) r112).n(r129, Boolean.FALSE);
    L116:
        if (r104 == null) goto L146;
        ExtendedToolbarButton r130 = r100.f115921m;
        if (r112 == null) goto L146;
        if (TextUtils.isEmpty(r130.f()) == true) goto L146;
        if (c4.a(c()) == true) goto L125;
        boolean r131 = b4.c.f115769a.d(r130, this.f116522d.getToolbarManager());
    L129:
        if (r131 == false) goto L131;
        int r108 = 0;
    L132:
        r112.setVisibility(r108);
        if ((r130 instanceof ExtendedToolbarButton.c) == true) goto L135;
    L141:
        DataCenter r109 = this.f116522d.getDataCenter();
        if (r109 == null) goto L146;
        if (z.h(r109) != true) goto L146;
        r112.setVisibility(8);
        goto L146
    L135:
        if (((ExtendedToolbarButton.c) r130).f115636r == true) goto L137;
    L139:
        int r132 = 8;
    L140:
        r112.setVisibility(r132);
        goto L141
    L137:
        if (h3.a(r130.f()) == true) goto L139;
        r132 = 0;
        goto L140
    L131:
        r108 = 8;
        goto L132
    L125:
        if ((r112 instanceof RedDotView) == false) goto L127;
        r131 = ((RedDotView) r112).j();
        goto L129
    L127:
        r131 = false;
    L146:
        r111.setTag(r100);
        if (r103 == null) goto L151;
        Map<ExtendedToolbarButton, View> r133 = r103.f116829c;
        if (r133 == null) goto L151;
        View r134 = (View) ((HashMap) r133).put(r100.f115921m, r111);
    L151:
        if (r103 == null) goto L153;
        r103.D(r100.f115921m, r111);
    L153:
        r111.setOnClickListener(this);
        DataCenter r135 = this.f116522d.getDataCenter();
        if (r135 == null) goto L156;
        Long r136 = (Long) r135.get("data_anchor_current_game_id", -1L);
    L157:
        ExtendedToolbarButton r137 = r100.f115921m;
        if ((r137 instanceof ExtendedToolbarButton.c) == true) goto L160;
        r137 = null;
    L160:
        ExtendedToolbarButton.c r138 = (ExtendedToolbarButton.c) r137;
        if (r138 == null) goto L163;
        Long r139 = Long.valueOf(r138.f115631m);
    L164:
        boolean r140 = Intrinsics.areEqual(r136, r139);
        int r141 = z3.f116864a;
        z3.b(this.f116522d.getDataCenter(), r100, r140, r128, r210);
        a(r104, r110);
        View r142 = r111.findViewById(R.id.viewCenterAnchor);
        MoreMixSharePanelUtils r143 = MoreMixSharePanelUtils.INSTANCE;
        boolean r144 = c();
        DataCenter r145 = this.f116522d.getDataCenter();
        if (r145 == null) goto L167;
        boolean r146 = z.m(r145, true);
    L169:
        if (r143.isMoreMixShareMode(r144, r146) == false) goto L199;
        if (r105 == null) goto L174;
        r105.setBackgroundResource(R.drawable.ttlive_bg_more_panel_button_mix_share);
    L174:
        if (r105 == null) goto L176;
        a1.p(r105, UtilityKotlinExtentionsKt.i(56));
    L176:
        if (r105 == null) goto L178;
        a1.k(r105, UtilityKotlinExtentionsKt.i(56));
    L178:
        if (r142 == null) goto L180;
        a1.p(r142, UtilityKotlinExtentionsKt.i(56));
    L180:
        if (r142 == null) goto L182;
        a1.k(r142, UtilityKotlinExtentionsKt.i(56));
    L182:
        if (r128 == true) goto L186;
        if (r104 == null) goto L186;
        r104.setAlpha(1.0f);
    L186:
        if (r104 == null) goto L188;
        a1.p(r104, UtilityKotlinExtentionsKt.i(36));
    L188:
        if (r104 == null) goto L190;
        a1.k(r104, UtilityKotlinExtentionsKt.i(36));
    L190:
        if (r114 == null) goto L192;
        a1.p(r114, UtilityKotlinExtentionsKt.i(36));
    L192:
        if (r106 == null) goto L194;
        r106.setTextColor(s1.h(R.color.ttlive_color_161823));
    L194:
        if (r106 == null) goto L197;
        r106.setTextSize(1, 12.0f);
    L197:
        if (r106 == null) goto L199;
        a1.o(r106, UtilityKotlinExtentionsKt.i(8));
    L199:
        final k r147 = (k) this.f116522d.b();
        if (r147 != null) goto L202;
        return;
    L202:
        if (r110.b() == true) goto L204;
    L206:
        boolean r148 = false;
    L207:
        if (r148 == true) goto L210;
        r147 = null;
    L210:
        if (r147 == null) goto L214;
        r147.showGuideEffect(400, new ButtonViewBinder$bindData$$inlined$also$lambda$1(r147, r100, r110, r105));
        return;
    L214:
        return;
    L204:
        if (r110.a() == true) goto L206;
        r148 = true;
        goto L207
    L167:
        r146 = true;
        goto L169
    L163:
        r139 = null;
        goto L164
    L156:
        r136 = null;
    L86:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r149 = r100.f115918j;
        if (r149 == null) goto L98;
        if (r149.a() == r127) goto L90;
    L98:
        if (r110.e() != ElementType.Basic) goto L101;
        if (r104 == null) goto L103;
        r104.setAlpha(0.72f);
    L103:
        if (r106 == null) goto L105;
        r106.setAlpha(1.0f);
    L105:
        if (r112 == null) goto L107;
        r112.setAlpha(1.0f);
    L107:
        r128 = false;
        goto L109
    L101:
        if (r104 == null) goto L103;
        r104.setAlpha(1.0f);
        goto L103
    L85:
        r127 = true;
        goto L86
    L65:
        if (TextUtils.isEmpty(r100.f115916h) == true) goto L67;
        UtilityKotlinExtentionsKt.w(r114);
        r114.setText(r100.f115916h);
        goto L70
    L37:
        r119 = Integer.MAX_VALUE;
        goto L38
    L31:
        r118 = false;
        goto L32
    L27:
        r117 = null;
        goto L29
    L15:
        if (r110.e() != ElementType.Basic) goto L17;
        int r150 = 4;
    L18:
        r105.setVisibility(r150);
        goto L19
    L17:
        r150 = 0;
        goto L18
    L9:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L11;
        int r151 = R.drawable.ttlive_bg_more_panel_button_light;
    L12:
        r105.setBackgroundResource(r151);
        goto L13
    L11:
        r151 = R.drawable.ttlive_bg_more_panel_button_daynight;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final /* bridge */ /* synthetic */ void o(WeakReference r100, lp1.a r101, View r102, int r103) {
        b(r101, r102, r103);
    }
}
