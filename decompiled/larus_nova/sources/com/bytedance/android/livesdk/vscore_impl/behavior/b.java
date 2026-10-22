package com.bytedance.android.livesdk.vscore_impl.behavior;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.view.VSLinkedAvatarContainer;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.MultiCameraLinkedRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.MultiCameraBasicInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import ev1.q;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vr1.i;
import vr1.l;
import vr1.u;
import vr1.w;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f159525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f159526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f159527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f159528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f159529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f159530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f159531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VSLinkedAvatarContainer f159532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SimpleDraweeView f159533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f159534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DataCenter f159535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f159536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f159537m;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f159538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f159539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f159540c;

        public a(b r100, DataCenter r101, View r102) {
            this.f159538a = r100;
            this.f159539b = r101;
            this.f159540c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() == 6) goto L8;
            return;
        L8:
            if (RoomKt.hasMultiCamera(lu2.c.f(this.f159539b)) == false) goto L12;
            this.f159538a.onClick(this.f159540c);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a() {
        if (lu2.b.b(this.f159535k) == true) goto L5;
    L292:
        View r100 = this.f159525a;
        if (r100 == null) goto L295;
        UtilityKotlinExtentionsKt.t(r100);
    L295:
        y3.m(this.f159535k).i(ToolbarButton.MULTI_CAMERA_LINKED_ROOM.extended());
        return;
    L5:
        if (this.f159535k != null) goto L8;
    L23:
        boolean r101 = false;
    L24:
        if (r101 == true) goto L292;
        ALogger.i("MultiCameraLinkedRoomBehavior", "updateView show   ");
        DataCenter r102 = this.f159535k;
        IRoom r103 = null;
        if (r102 == null) goto L28;
        IRoom r104 = lu2.c.f(r102);
    L30:
        if (RoomKt.hasMultiCamera(r104) == false) goto L156;
        DataCenter r105 = this.f159535k;
        if (r105 == null) goto L271;
        View r106 = this.f159525a;
        if (r106 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.j(r106);
    L37:
        ViewGroup r107 = this.f159530f;
        if (r107 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r107);
    L40:
        ViewGroup r108 = this.f159526b;
        if (r108 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.j(r108);
    L43:
        EpisodeExtraInfo r109 = lu2.c.a(lu2.c.f(r105));
        if (r109 == null) goto L46;
        MultiCameraBasicInfo r110 = r109.getMultiCameraBasicInfo();
    L48:
        if (PadConfigUtils.c() == false) goto L52;
        if (e5.n() == false) goto L52;
    L53:
        TextView r111 = this.f159527c;
        if (r111 == null) goto L57;
        UtilityKotlinExtentionsKt.t(r111);
    L57:
        if (this.f159537m == true) goto L72;
        if (r110 == null) goto L65;
        k r112 = r110.getIconPad();
        if (r112 == null) goto L65;
        if (r112.isValid() != true) goto L65;
        ImageUtil.loadImage(this.f159528d, r110.getIconPad(), 0);
    L65:
        if (q.f474230d.getValue().booleanValue() == false) goto L69;
        HSImageView r113 = this.f159528d;
        if (r113 == null) goto L72;
        r113.setActualImageResource(R.drawable.live_toolbar_ic_v2_multicamera_static);
        goto L72
    L69:
        HSImageView r114 = this.f159528d;
        if (r114 == null) goto L72;
        r114.setActualImageResource(R.drawable.ttlive_multicamera_toolbar_portrait38);
    L72:
        View r115 = this.f159525a;
        if (r115 == null) goto L75;
        a1.n(r115, 0);
    L75:
        View r116 = this.f159525a;
        if (r116 == null) goto L78;
        a1.m(r116, UtilityKotlinExtentionsKt.i(8));
    L78:
        View r117 = this.f159525a;
        if (r117 == null) goto L81;
        r117.setPadding(0, 0, 0, 0);
    L81:
        HSImageView r118 = this.f159528d;
        if (r118 == null) goto L84;
        a1.p(r118, UtilityKotlinExtentionsKt.i(38));
        a1.k(r118, UtilityKotlinExtentionsKt.i(38));
    L84:
        ImageView r119 = this.f159529e;
        if (r119 == null) goto L87;
        r119.setTranslationX(UtilityKotlinExtentionsKt.h(9));
    L87:
        ImageView r120 = this.f159529e;
        if (r120 == null) goto L130;
        r120.setTranslationY(UtilityKotlinExtentionsKt.h(1));
    L130:
        DataCenter r121 = this.f159535k;
        if (r121 == null) goto L133;
        IRoom r122 = lu2.c.f(r121);
    L135:
        if (lu2.b.j(r122) == false) goto L149;
        ImageView r123 = this.f159529e;
        if (r123 == null) goto L139;
        r123.setImageResource(R.drawable.ttlive_vs_paid_camera);
    L139:
        ou2.a r124 = ou2.c.a(r105);
        if ((r124 instanceof MultiCameraLinkedRoomContext) == true) goto L142;
        r124 = null;
    L142:
        MultiCameraLinkedRoomContext r125 = (MultiCameraLinkedRoomContext) r124;
        if (r125 == null) goto L152;
        m<Boolean> r126 = r125.getOpenPanelFromUser();
        if (r126 == null) goto L152;
        Disposable r127 = i80.a.a(r126, new MultiCameraLinkedRoomBehavior$showMultiCamera$3(this));
        if (r127 == null) goto L152;
        RxUtilKt.c(r127, this.f159536l);
    L152:
        SimpleDraweeView r128 = this.f159533i;
        if (r128 == null) goto L271;
        r128.setController(null);
        goto L271
    L149:
        ImageView r129 = this.f159529e;
        if (r129 == null) goto L152;
        UtilityKotlinExtentionsKt.t(r129);
        goto L152
    L133:
        r122 = null;
    L52:
        if (h.d(r105, true) == true) goto L53;
        IRoom r130 = lu2.c.f(r105);
        if (RoomKt.hasMultiCamera(r130) == true) goto L93;
    L96:
        EpisodeExtraInfo r131 = lu2.c.a(r130);
        if (r131 == null) goto L99;
        String r132 = r131.getCameraInfosTableTitle();
    L100:
        TextView r133 = this.f159527c;
        if (r133 == null) goto L106;
        if (r132 != null) goto L105;
        r132 = s1.B(R.string.ttlive_vs_camera_text_default);
    L105:
        r133.setText(r132);
    L106:
        TextView r134 = this.f159527c;
        if (r134 == null) goto L109;
        com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.j(r134);
    L109:
        if (r110 == null) goto L115;
        k r135 = r110.getIcon();
        if (r135 == null) goto L115;
        if (r135.isValid() != true) goto L115;
        ImageUtil.loadImage(this.f159528d, r110.getIcon(), 0);
    L118:
        HSImageView r136 = this.f159528d;
        if (r136 == null) goto L121;
        a1.p(r136, UtilityKotlinExtentionsKt.i(36));
        a1.k(r136, UtilityKotlinExtentionsKt.i(36));
    L121:
        View r137 = this.f159525a;
        if (r137 == null) goto L124;
        r137.setPadding(UtilityKotlinExtentionsKt.i(0), 0, UtilityKotlinExtentionsKt.i(8), 0);
    L124:
        ImageView r138 = this.f159529e;
        if (r138 == null) goto L127;
        r138.setTranslationX(UtilityKotlinExtentionsKt.h(17));
    L127:
        ImageView r139 = this.f159529e;
        if (r139 == null) goto L130;
        r139.setTranslationY(UtilityKotlinExtentionsKt.h(3));
    L115:
        HSImageView r140 = this.f159528d;
        if (r140 == null) goto L118;
        r140.setActualImageResource(R.drawable.ttlive_icon_multi_camera);
    L99:
        r132 = null;
        goto L100
    L93:
        if (lu2.c.b(r130) == false) goto L96;
        if (r110 == null) goto L99;
        r132 = r110.getName();
        goto L100
    L46:
        r110 = null;
    L271:
        TextView r141 = this.f159527c;
        if (r141 == null) goto L274;
        r141.setTypeface(Typeface.DEFAULT);
    L274:
        TextView r142 = this.f159534j;
        if (r142 == null) goto L277;
        r142.setTypeface(Typeface.DEFAULT);
    L277:
        y3.m(this.f159535k).c(ToolbarButton.MULTI_CAMERA_LINKED_ROOM.extended());
        DataCenter r143 = this.f159535k;
        if (r143 == null) goto L280;
        r103 = lu2.c.f(r143);
    L280:
        boolean r144 = RoomKt.hasMultiCamera(r103);
        if (r144 == false) goto L283;
        String r145 = "livesdk_more_machine_icon_show";
    L284:
        if (r144 == false) goto L286;
        Map<String, String> r146 = new LinkedHashMap();
    L287:
        if (r144 == true) goto L291;
        Map<String, String> r147 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(this.f159535k);
        if (r147 == null) goto L291;
        r146.putAll(r147);
    L291:
        r.l().n(this.f159535k, r145, r146);
        return;
    L286:
        r146 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("vs_icon_type", "only_relevant_live")});
        goto L287
    L283:
        r145 = "livesdk_relevant_live_icon_show";
        goto L284
    L156:
        if (this.f159535k == null) goto L271;
        View r148 = this.f159525a;
        if (r148 == null) goto L161;
        com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.j(r148);
    L161:
        ViewGroup r149 = this.f159530f;
        if (r149 == null) goto L164;
        com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.j(r149);
    L164:
        ViewGroup r150 = this.f159526b;
        if (r150 == null) goto L168;
        UtilityKotlinExtentionsKt.t(r150);
    L168:
        if (PadConfigUtils.c() == true) goto L170;
    L171:
        u r151 = r.u(this.f159535k, null, 2);
        if (r151 == null) goto L177;
        m<Boolean> r152 = r151.A();
        if (r152 == null) goto L177;
        if (r152.getValue().booleanValue() != true) goto L177;
    L181:
        TextView r153 = this.f159534j;
        if (r153 == null) goto L184;
        UtilityKotlinExtentionsKt.t(r153);
    L184:
        ImageView r154 = this.f159531g;
        if (r154 == null) goto L187;
        r154.setImageResource(R.drawable.ttlive_vs_linked_room_toolbar_icon38);
    L187:
        View r155 = this.f159525a;
        if (r155 == null) goto L190;
        r155.setPadding(0, 0, 0, 0);
    L190:
        VSLinkedAvatarContainer r156 = this.f159532h;
        if (r156 == null) goto L193;
        float r157 = 0;
        r156.setCenterX(UtilityKotlinExtentionsKt.h(r157));
        r156.setCenterY(UtilityKotlinExtentionsKt.h(r157));
        r156.setRadius(UtilityKotlinExtentionsKt.h(r157));
    L193:
        ImageView r158 = this.f159531g;
        if (r158 == null) goto L196;
        a1.p(r158, UtilityKotlinExtentionsKt.i(36));
        a1.k(r158, UtilityKotlinExtentionsKt.i(36));
    L196:
        SimpleDraweeView r159 = this.f159533i;
        if (r159 == null) goto L199;
        a1.n(r159, UtilityKotlinExtentionsKt.i(6));
        a1.l(r159, UtilityKotlinExtentionsKt.i(9));
    L199:
        View r160 = this.f159525a;
        if (r160 == null) goto L202;
        a1.n(r160, 0);
    L202:
        View r161 = this.f159525a;
        if (r161 == null) goto L205;
        a1.m(r161, UtilityKotlinExtentionsKt.i(8));
    L205:
        View r162 = this.f159525a;
        if (r162 == null) goto L208;
        r162.setPadding(0, 0, 0, 0);
    L208:
        View r163 = this.f159525a;
        if (r163 == null) goto L268;
        r163.setBackgroundColor(0);
    L268:
        SimpleDraweeView r164 = this.f159533i;
        if (r164 == null) goto L271;
        PipelineDraweeControllerBuilder r165 = Fresco.newDraweeControllerBuilder();
        Object r166 = pm1.h.f529822d.c(i.class);
        Intrinsics.checkNotNull(r166);
        r164.setController(r165.setUri(((i) r166).Q("/vs/ttlive_vs_linked_room_living.webp")).setAutoPlayAnimations(true).build());
    L177:
        DataCenter r167 = this.f159535k;
        if (r167 != null) goto L180;
    L211:
        DataCenter r168 = this.f159535k;
        if (r168 == null) goto L218;
        IRoom r169 = lu2.c.f(r168);
        if (r169 == null) goto L218;
        EpisodeExtraInfo r170 = lu2.c.a(r169);
        if (r170 == null) goto L218;
        VSLinkedRoomInfo r171 = r170.getVsLinkedRoomInfo();
    L219:
        DataCenter r172 = this.f159535k;
        if (r172 == null) goto L222;
        lu2.c.f(r172);
    L222:
        TextView r173 = this.f159534j;
        if (r173 == null) goto L235;
        if (r171 == null) goto L227;
        String r174 = r171.getTitle();
        if (r174 == null) goto L227;
    L229:
        if (r174.length() != 0) goto L231;
        boolean r175 = true;
    L232:
        if (r175 == false) goto L234;
        r174 = s1.B(R.string.ttlive_linked_rooms);
    L234:
        r173.setText(r174);
        goto L235
    L231:
        r175 = false;
    L227:
        r174 = "";
    L235:
        TextView r176 = this.f159534j;
        if (r176 == null) goto L238;
        com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt.j(r176);
    L238:
        if (r171 == null) goto L248;
        List<VSLinkedRoomNode> r177 = r171.getRooms();
        if (r177 == null) goto L248;
        VSLinkedRoomNode r178 = (VSLinkedRoomNode) ListProtector.get(r177, 0);
        if (r178 == null) goto L248;
        IBaseUser r179 = r178.getOwner();
        if (r179 == null) goto L248;
        k r180 = r179.getAvatarMedium();
        if (r180 == null) goto L248;
        ImageUtil.loadRoundImage(this.f159531g, r180);
    L248:
        View r181 = this.f159525a;
        if (r181 == null) goto L252;
        r181.setPadding(UtilityKotlinExtentionsKt.i(0), 0, UtilityKotlinExtentionsKt.i(8), 0);
    L252:
        if (com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.c(this.f159535k) == false) goto L259;
        View r182 = this.f159525a;
        if (r182 == null) goto L256;
        r182.setBackgroundResource(R.drawable.ttlive_bg_linked_rooms_toolbar_landscape);
    L256:
        View r183 = this.f159525a;
        if (r183 == null) goto L259;
        r183.setPadding(UtilityKotlinExtentionsKt.i(8), 0, UtilityKotlinExtentionsKt.i(8), 0);
    L259:
        ImageView r184 = this.f159531g;
        if (r184 == null) goto L262;
        a1.p(r184, UtilityKotlinExtentionsKt.i(20));
        a1.k(r184, UtilityKotlinExtentionsKt.i(20));
    L262:
        VSLinkedAvatarContainer r185 = this.f159532h;
        if (r185 == null) goto L265;
        float r186 = 15;
        r185.setCenterX(UtilityKotlinExtentionsKt.h(r186));
        r185.setCenterY(UtilityKotlinExtentionsKt.h(r186));
        r185.setRadius(UtilityKotlinExtentionsKt.h(6));
    L265:
        SimpleDraweeView r187 = this.f159533i;
        if (r187 == null) goto L268;
        a1.n(r187, UtilityKotlinExtentionsKt.i(0));
        a1.l(r187, UtilityKotlinExtentionsKt.i(0));
    L218:
        r171 = null;
        goto L219
    L180:
        if (h.d(r167, true) != true) goto L211;
    L170:
        if (e5.n() == true) goto L181;
    L28:
        r104 = null;
        goto L30
    L8:
        if (PadConfigUtils.c() == true) goto L10;
    L12:
        boolean r188 = false;
    L14:
        if (gb2.a.c(this.f159535k, true) == false) goto L17;
        if (r188 == true) goto L17;
        boolean r189 = true;
    L18:
        ALogger.i("MultiLinked", "hidePortraitToolbar = iPortrait " + r189 + "  && ugcStyleShowElement = " + com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.d(this.f159535k) + ' ');
        if (r189 == false) goto L23;
        if (com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.d(this.f159535k) == false) goto L23;
        r101 = true;
    L17:
        r189 = false;
        goto L18
    L10:
        if (e5.n() == false) goto L12;
        r188 = true;
        goto L14
    }

    public b() {
        this.f159536l = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(s r100) {
        if (r100 == null) goto L22;
        DataCenter r101 = this.f159535k;
        if (r101 == null) goto L6;
        IRoom r102 = lu2.c.f(r101);
    L8:
        if (RoomKt.hasMultiCamera(r102) == true) goto L11;
        return;
    L11:
        if (PadConfigUtils.c() == true) goto L13;
    L14:
        u r103 = r.u(this.f159535k, null, 2);
        if (r103 == null) goto L23;
        m<Boolean> r104 = r103.A();
        if (r104 != null) goto L19;
        return;
    L19:
        if (r104.getValue().booleanValue() != true) goto L25;
    L20:
        Object r105 = pm1.h.f529822d.c(w.class);
        Intrinsics.checkNotNull(r105);
        ((w) r105).a(this.f159528d, r100, Integer.valueOf(R.drawable.ttlive_vs_linked_room_toolbar_icon38), new com.bytedance.android.livesdk.vscore_impl.behavior.a(this));
        return;
    L25:
        return;
    L23:
        return;
    L13:
        if (e5.n() == true) goto L20;
    L6:
        r102 = null;
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        IRoom r101 = null;
        if (r100 == null) goto L5;
        Context r102 = r100.getContext();
    L6:
        DataCenter r103 = this.f159535k;
        if (r102 == null) goto L39;
        if (r103 != null) goto L10;
        return;
    L10:
        if (g.d(r103).F0(PaidInteractEntry.CONTROL_ENTRY_MULTI_CAMERA_PANEL) == true) goto L12;
        return;
    L12:
        pm1.h r104 = pm1.h.f529822d;
        Object r105 = r104.c(l.class);
        Intrinsics.checkNotNull(r105);
        if (((l) r105).a() == true) goto L15;
    L18:
        com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.a.a(r103);
        DataCenter r106 = this.f159535k;
        if (r106 == null) goto L21;
        r101 = lu2.c.f(r106);
    L21:
        boolean r107 = RoomKt.hasMultiCamera(r101);
        if (r107 == false) goto L24;
        final String r108 = "livesdk_more_machine_icon_click";
    L25:
        if (r107 == false) goto L27;
        final Map r109 = new LinkedHashMap();
    L28:
        if (r107 == true) goto L32;
        Map<String, String> r110 = com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util.e.a(this.f159535k);
        if (r110 == null) goto L32;
        r109.putAll(r110);
    L32:
        j<com.bytedance.android.livesdk.chatroom.l> r111 = r.l().h(this.f159535k);
        if (r111 == null) goto L35;
        r111.c(new MultiCameraLinkedRoomBehavior$logClick$2(r108, r109));
    L35:
        nm1.a r112 = (nm1.a) r104.c(nm1.a.class);
        if (r112 == null) goto L41;
        r112.a(r102, r103);
        return;
    L41:
        return;
    L27:
        r109 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("vs_icon_type", "only_relevant_live")});
        goto L28
    L24:
        r108 = "livesdk_relevant_live_icon_click";
        goto L25
    L15:
        if (RoomKt.hasMultiCamera(lu2.c.f(r103)) == false) goto L18;
        f2.c("连麦状态下不支持切换多机位", 0);
        return;
    L39:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f159536l.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f159525a = r100.findViewById(R.id.container);
        this.f159526b = (ViewGroup) r100.findViewById(R.id.camera_container);
        this.f159527c = (TextView) r100.findViewById(R.id.camera_text);
        this.f159528d = (HSImageView) r100.findViewById(R.id.camera_icon);
        this.f159529e = (ImageView) r100.findViewById(R.id.paid_tips);
        this.f159530f = (ViewGroup) r100.findViewById(R.id.linked_room_container);
        this.f159534j = (TextView) r100.findViewById(R.id.linked_room_text);
        this.f159531g = (ImageView) r100.findViewById(R.id.linked_image);
        this.f159533i = (SimpleDraweeView) r100.findViewById(R.id.living_view);
        this.f159532h = (VSLinkedAvatarContainer) r100.findViewById(R.id.linked_image_container);
        this.f159535k = r101;
        int r102 = lu2.b.f510827a;
        r3.c(r100, lu2.b.g(lu2.c.f(r101)), true);
        r3.n(this.f159527c);
        r3.n(this.f159534j);
        a();
        ou2.a r103 = ou2.c.a(this.f159535k);
        if (r103 == null) goto L11;
        com.bytedance.live.datacontext.k<Object> r104 = r103.getDataChanged();
        if (r104 == null) goto L11;
        PublishSubject r105 = r104.onEvent();
        if (r105 == null) goto L11;
        Disposable r106 = r105.subscribe(new c(this));
        if (r106 == null) goto L11;
        RxUtilKt.c(r106, this.f159536l);
    L11:
        ou2.a r107 = ou2.c.a(this.f159535k);
        if ((r107 instanceof MultiCameraLinkedRoomContext) == true) goto L14;
        r107 = null;
    L14:
        MultiCameraLinkedRoomContext r108 = (MultiCameraLinkedRoomContext) r107;
        if (r108 == null) goto L24;
        m<Integer> r109 = r108.getPortraitStyle();
        if (r109 == null) goto L24;
        Observable<Integer> r110 = r109.a();
        if (r110 == null) goto L24;
        Disposable r111 = r110.subscribe(new d(this));
        if (r111 == null) goto L24;
        RxUtilKt.c(r111, this.f159536l);
    L24:
        if (PadConfigUtils.c() == false) goto L26;
        RxUtilKt.c(xs2.b.a().b(com.bytedance.android.livesdk.event.f.class).subscribe(new e(this)), this.f159536l);
    L26:
        int r112 = com.bytedance.android.livesdk.vscore_impl.component.tabs.u.f160005a;
        if (com.bytedance.android.livesdk.vscore_impl.component.tabs.u.a(this.f159535k) == false) goto L40;
        ou2.a r113 = ou2.c.a(this.f159535k);
        if ((r113 instanceof MultiCameraLinkedRoomContext) == true) goto L31;
        r113 = null;
    L31:
        MultiCameraLinkedRoomContext r114 = (MultiCameraLinkedRoomContext) r113;
        if (r114 == null) goto L40;
        m<Boolean> r115 = r114.getHideByUgcMultiTabFilter();
        if (r115 == null) goto L40;
        Observable<Boolean> r116 = r115.a();
        if (r116 == null) goto L40;
        Disposable r117 = r116.subscribe(new f(this));
        if (r117 == null) goto L40;
        RxUtilKt.c(r117, this.f159536l);
    L40:
        u r118 = r.u(r101, null, 2);
        if (r118 == null) goto L50;
        m<Integer> r119 = r118.J0();
        if (r119 == null) goto L51;
        Observable<Integer> r120 = r119.a();
        if (r120 == null) goto L52;
        Disposable r121 = r120.subscribe(new a(this, r101, r100));
        if (r121 == null) goto L53;
        RxUtilKt.c(r121, this.f159536l);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    }
}
