package com.bytedance.android.live.liveinteract.revenue.game.layer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.videotalk.quickinteract.QuickInteractTask;
import com.bytedance.android.livesdk.message.model.rm;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jg0.d;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;
import tf0.p;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends jg0.a<MultiLinkFoldButtonViewBinder.a> implements d<MultiLinkFoldButtonViewBinder.a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f78341m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MultiLinkFoldButtonViewBinder.a f78342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f78343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f78344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HSImageView f78345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f78346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f78347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f78348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MultiLinkFoldButtonViewBinder.a f78349l;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.game.layer.a$a, reason: collision with other inner class name */
    public static final class C1219a {
    }

    static {
    }

    @Override // jg0.c
    public final int o() {
        return R.layout.ttlive_layer_multilink_game_function;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkGameFunctionLayer.name();
    }

    public final void s() {
        if (n() != 0) goto L62;
        LinkMicGameContext.a r100 = LinkMicGameContext.Companion;
        LinkMicGameContext r101 = r100.getContext();
        Object r102 = null;
        if (r101 == null) goto L7;
        List<rm.b> r103 = r101.getGameScores();
    L9:
        if (r100.e() == false) goto L43;
        if (r103 == null) goto L43;
        if ((!r103.isEmpty()) == false) goto L43;
        Iterator<T> r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L31;
        Object r105 = r104.next();
        String r106 = ((rm.b) r105).joinUid;
        MultiLinkFoldButtonViewBinder.a r107 = this.f78349l;
        if (r107 == null) goto L27;
        MultiLinkFirstUserViewBinder.a r108 = r107.f75929q;
        if (r108 == null) goto L27;
        e r109 = r108.f75934k;
        if (r109 == null) goto L27;
        ILinkPlayerInfoBridge r110 = r109.f23724a;
        if (r110 == null) goto L27;
        IBaseUser r111 = r110.getUser();
        if (r111 == null) goto L27;
        String r112 = r111.getIdString();
    L29:
        if (Intrinsics.areEqual(r106, r112) == false) goto L15;
        r102 = r105;
    L27:
        r112 = null;
    L31:
        rm.b r113 = (rm.b) r102;
        if (r113 != null) goto L34;
    L39:
        TextView r114 = this.f78347j;
        if (r114 == null) goto L42;
        r114.setText("观战中");
    L42:
        this.f78348k = true;
    L59:
        TextView r115 = this.f78347j;
        if (r115 == null) goto L69;
        r115.setVisibility(0);
        return;
    L69:
        return;
    L34:
        if (r113.joinGame == false) goto L39;
        TextView r116 = this.f78347j;
        if (r116 == null) goto L42;
        r116.setText(r113.score);
    L43:
        TextView r117 = this.f78347j;
        if (r117 == null) goto L58;
        MultiLinkFoldButtonViewBinder.a r118 = this.f78349l;
        if (r118 == null) goto L56;
        MultiLinkFirstUserViewBinder.a r119 = r118.f75929q;
        if (r119 == null) goto L56;
        e r120 = r119.f75934k;
        if (r120 == null) goto L56;
        ILinkPlayerInfoBridge r121 = r120.f23724a;
        if (r121 == null) goto L56;
        String r122 = r121.getFanTicketDisplayStr();
        if (r122 == null) goto L56;
    L57:
        r117.setText(r122);
    L56:
        r122 = "";
    L58:
        this.f78348k = false;
        goto L59
    L7:
        r103 = null;
        goto L9
    L62:
        TextView r123 = this.f78347j;
        if (r123 == null) goto L71;
        r123.setVisibility(8);
        return;
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.a(r100);
        this.f78343f = (TextView) q().findViewById(R.id.tv_fold_status);
        this.f78345h = (HSImageView) q().findViewById(R.id.ttlive_guest_avatar);
        this.f78346i = q().findViewById(R.id.ttlive_guest_identification);
        this.f78347j = (TextView) q().findViewById(R.id.ttlive_guest_ticket_num);
        this.f78344g = (TextView) q().findViewById(R.id.ttlive_empty_tips);
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (LinkFeedTypeConstant.Companion.isDouyinFullScreen(n()) == false) goto L5;
        return;
    L5:
        if (n() == 0) goto L14;
        TextView r101 = this.f78343f;
        if (r101 == null) goto L9;
        r101.setTextSize(6.0f);
    L9:
        TextView r102 = this.f78344g;
        if (r102 == null) goto L15;
        r102.setTextSize(6.0f);
        return;
    L15:
        return;
    }

    public final void r(final MultiLinkFoldButtonViewBinder.a r110) {
        Intrinsics.checkNotNullParameter(r110, "itemData");
        this.f78349l = r110;
        this.f78342e = r110;
        MultiLinkFirstUserViewBinder.a r100 = r110.f75929q;
        if (r100 == null) goto L46;
        e r101 = r100.f75934k;
        if (r101 == null) goto L25;
        ILinkPlayerInfoBridge r102 = r101.f23724a;
        if (r102 == null) goto L25;
        if (r102.isAnonymous() != true) goto L25;
        PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder();
        e r104 = r100.f75934k;
        if (r104 == null) goto L21;
        ILinkPlayerInfoBridge r105 = r104.f23724a;
        if (r105 == null) goto L21;
        IBaseUser r106 = r105.getUser();
        if (r106 == null) goto L21;
        k r107 = r106.getAvatarMedium();
        if (r107 == null) goto L21;
        List<String> r108 = r107.getUrls();
        if (r108 == null) goto L21;
        String r109 = (String) CollectionsKt.firstOrNull(r108);
    L22:
        AbstractDraweeController r111 = r103.setUri(r109).setControllerListener(new b(this)).build();
        HSImageView r112 = this.f78345h;
        if (r112 == null) goto L39;
        r112.setController(r111);
    L39:
        e r113 = r100.f75934k;
        if (r113 == null) goto L44;
        ILinkPlayerInfoBridge r114 = r113.f23724a;
        if (r114 == null) goto L44;
        Integer r115 = Integer.valueOf(r114.getSilenceStatus());
    L45:
        t(r115.intValue());
        s();
    L44:
        r115 = null;
    L21:
        r109 = null;
    L25:
        HSImageView r116 = this.f78345h;
        if (r116 == null) goto L30;
        Drawable r117 = r116.getBackground();
        if (r117 == null) goto L30;
        r117.setAlpha(1);
    L30:
        HSImageView r118 = this.f78345h;
        e r119 = r100.f75934k;
        if (r119 == null) goto L37;
        ILinkPlayerInfoBridge r120 = r119.f23724a;
        if (r120 == null) goto L37;
        IBaseUser r121 = r120.getUser();
        if (r121 == null) goto L37;
        k r122 = r121.getAvatarMedium();
    L38:
        ImageUtil.loadRoundImageAntiFlink(r118, r122, 0);
    L37:
        r122 = null;
    L46:
        MultiLinkFoldButtonViewBinder.a r123 = this.f78342e;
        if (r123 != null) goto L49;
    L53:
        TextView r124 = this.f78343f;
        if (r124 == null) goto L57;
        r124.setVisibility(8);
    L57:
        if (r110.f75923k == true) goto L59;
        TextView r125 = this.f78343f;
        if (r125 == null) goto L76;
        StringCompanionObject r126 = StringCompanionObject.INSTANCE;
        r125.setText(String.format("%s人连线", Arrays.copyOf(new Object[]{Integer.valueOf(r110.f75925m)}, 1)));
    L76:
        q().setOnClickListener(null);
        TextView r127 = this.f78343f;
        if (r127 == null) goto L79;
        r127.setCompoundDrawables(null, null, null, null);
    L79:
        MultiLinkFoldButtonViewBinder.a r128 = this.f78342e;
        if (r128 != null) goto L82;
    L112:
        TextView r129 = this.f78344g;
        if (r129 == null) goto L118;
        r129.setVisibility(8);
        return;
    L118:
        return;
    L82:
        if (r128.f75927o != true) goto L112;
        TextView r130 = this.f78344g;
        if (r130 == null) goto L86;
        r130.setVisibility(0);
    L86:
        final MultiLinkNormalEmptyViewBinder.a r131 = r110.f75928p;
        if (n() != 0) goto L91;
        TextView r132 = this.f78344g;
        if (r132 == null) goto L91;
        r132.setOnClickListener(x0.a(new MultiLinkGameFunctionLayer$updateEmptyView$1(this, r131)));
    L91:
        TextView r133 = this.f78344g;
        if (r133 != null) goto L94;
    L109:
        TextView r134 = this.f78344g;
        if (r134 == null) goto L116;
        Drawable r135 = s1.m(R.drawable.ttlive_icon_apply_plus_new_v2);
        r135.setBounds(0, 0, r135.getMinimumWidth(), r135.getMinimumHeight());
        Unit r136 = Unit.INSTANCE;
        r134.setCompoundDrawables(r135, null, null, null);
        return;
    L116:
        return;
    L94:
        if (gh0.a.d() == false) goto L96;
        String r137 = s1.B(R.string.ttlive_live_radio_interact_invite_link);
    L108:
        r133.setText(r137);
        goto L109
    L96:
        if (r131 != null) goto L98;
    L100:
        if (r131 == null) goto L105;
        if (r131.h() != true) goto L105;
        r137 = s1.B(R.string.ttlive_live_radio_interact_invite_link);
    L105:
        if (vm2.d.f0() != 0) goto L107;
        r137 = s1.B(R.string.ttlive_live_interact_apply);
        goto L108
    L107:
        r137 = s1.B(R.string.ttlive_live_radio_interact_waiting);
        goto L108
    L98:
        if (r131.g() != true) goto L100;
        r137 = s1.B(R.string.ttlive_live_radio_interact_paid_link);
        goto L108
    L59:
        if (r110.f75924l == false) goto L66;
        TextView r138 = this.f78343f;
        if (r138 == null) goto L63;
        StringCompanionObject r139 = StringCompanionObject.INSTANCE;
        r138.setText(String.format("%s人连线", Arrays.copyOf(new Object[]{Integer.valueOf(r110.f75925m)}, 1)));
    L63:
        TextView r140 = this.f78343f;
        if (r140 == null) goto L72;
        Drawable r141 = s1.m(R.drawable.ttlive_ic_arrowforward_mic_seat_pop);
        r141.setBounds(0, 0, r141.getMinimumWidth(), r141.getMinimumHeight());
        Unit r142 = Unit.INSTANCE;
        r140.setCompoundDrawables(r141, null, null, null);
    L72:
        ViewGroup r143 = q();
        Function1<View, Unit> r144 = new MultiLinkGameFunctionLayer$updateFoldButton$3(this, r110);
        Intrinsics.checkNotNullParameter(r144, SendEventContainerMethodParamModel.EventKinds.onClick);
        r143.setOnClickListener(new w0(r144, 1000));
        goto L79
    L66:
        TextView r145 = this.f78343f;
        if (r145 == null) goto L69;
        StringCompanionObject r146 = StringCompanionObject.INSTANCE;
        r145.setText(String.format("%s人连线", Arrays.copyOf(new Object[]{Integer.valueOf(r110.f75925m)}, 1)));
    L69:
        TextView r147 = this.f78343f;
        if (r147 == null) goto L72;
        Drawable r148 = s1.m(R.drawable.ttlive_ic_arrowforward_mic_seat_stash);
        r148.setBounds(0, 0, r148.getMinimumWidth(), r148.getMinimumHeight());
        Unit r149 = Unit.INSTANCE;
        r147.setCompoundDrawables(r148, null, null, null);
        goto L72
    L49:
        if (r123.f75926n != true) goto L53;
        TextView r150 = this.f78343f;
        if (r150 == null) goto L57;
        r150.setVisibility(0);
        goto L57
    }

    public final void t(int r100) {
        if (r100 == 0) goto L12;
        View r101 = this.f78346i;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        View r102 = this.f78346i;
        if ((r102 instanceof ImageView) == true) goto L9;
        r102 = null;
    L9:
        ImageView r103 = (ImageView) r102;
        if (r103 == null) goto L16;
        r103.setImageResource(R.drawable.ttlive_icon_video_silence);
        return;
    L16:
        return;
    L12:
        View r104 = this.f78346i;
        if (r104 == null) goto L18;
        r104.setVisibility(8);
        return;
    }

    public a(MicSeatScene r100, xg0.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "linkSeatAbilityProvider");
        super(r100, r101);
    }

    @Override // jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r100, int r101) {
        r((MultiLinkFoldButtonViewBinder.a) r100);
    }

    @Override // jg0.d
    public final void e(int r100, p r101, Object r102) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (Intrinsics.areEqual(r101, ti0.a.f545991b) == false) goto L6;
        s();
        return;
    }

    @Override // jg0.f
    public final void k(Object r100, int r101, Bundle r102) {
        MultiLinkFoldButtonViewBinder.a r103 = (MultiLinkFoldButtonViewBinder.a) r100;
        Intrinsics.checkNotNullParameter(r103, "itemData");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        this.f78349l = r103;
        Iterator<String> r104 = r102.keySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L71;
        String r105 = r104.next();
        if (r105 == null) goto L4;
        int r106 = r105.hashCode();
        if (r106 != (-2108878291)) goto L11;
        if (r105.equals("payload_key_fan_ticket_str_update") == false) goto L4;
        MultiLinkFirstUserViewBinder.a r107 = r103.f75929q;
        Object r108 = null;
        if (r107 == null) goto L33;
        e r109 = r107.f75934k;
        if (r109 == null) goto L33;
        Map<String, Object> r110 = r109.f23727d;
        if (r110 == null) goto L33;
        Object r111 = r110.remove("EXT_KEY_QUICK_INTERACT_MESSAGE");
    L35:
        if ((r111 instanceof QuickInteractTask) == false) goto L38;
        r108 = r111;
    L38:
        QuickInteractTask r112 = (QuickInteractTask) r108;
        if (r112 == null) goto L86;
        ALogger.d("MultiLinkGameFunctionLayer", "updateFanTicketStr, task: " + r112);
        String r113 = r112.f79479b;
        if (r113 != null) goto L43;
        return;
    L43:
        if (n() == 0) goto L45;
        TextView r114 = this.f78347j;
        if (r114 == null) goto L68;
        r114.setVisibility(8);
    L68:
        TextView r115 = this.f78347j;
        if (r115 == null) goto L88;
        r115.setText(r113);
        return;
    L88:
        return;
    L45:
        if (this.f78348k == false) goto L49;
        TextView r116 = this.f78347j;
        if (r116 == null) goto L68;
        r116.setVisibility(0);
        goto L68
    L49:
        MultiLinkFoldButtonViewBinder.a r117 = this.f78349l;
        if (r117 == null) goto L62;
        MultiLinkFirstUserViewBinder.a r118 = r117.f75929q;
        if (r118 == null) goto L62;
        e r119 = r118.f75934k;
        if (r119 == null) goto L62;
        ILinkPlayerInfoBridge r120 = r119.f23724a;
        if (r120 == null) goto L62;
        if (r120.isOpenSendGift() != true) goto L62;
        TextView r121 = this.f78347j;
        if (r121 == null) goto L68;
        r121.setVisibility(0);
    L62:
        TextView r122 = this.f78347j;
        if (r122 == null) goto L68;
        r122.setVisibility(8);
        goto L68
    L86:
        return;
    L33:
        r111 = null;
        goto L35
    L11:
        if (r106 != 2021952839) goto L4;
        if (r105.equals("payload_key_silence_status_update") == false) goto L4;
        MultiLinkFirstUserViewBinder.a r123 = r103.f75929q;
        if (r123 == null) goto L22;
        e r124 = r123.f75934k;
        if (r124 == null) goto L22;
        ILinkPlayerInfoBridge r125 = r124.f23724a;
        if (r125 == null) goto L22;
        int r126 = r125.getSilenceStatus();
    L23:
        t(r126);
        return;
    L22:
        r126 = -1;
        goto L23
    L71:
        r(r103);
    }
}
