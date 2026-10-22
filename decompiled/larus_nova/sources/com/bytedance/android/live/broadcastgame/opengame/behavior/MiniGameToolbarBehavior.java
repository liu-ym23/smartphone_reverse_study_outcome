package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.network.AudienceGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.n0;
import com.bytedance.android.live.broadcastgame.xplay.f1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.oz0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class MiniGameToolbarBehavior implements y {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f59731f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f59732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f59733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f59734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f59735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f59736e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/broadcastgame/opengame/behavior/MiniGameToolbarBehavior$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/g;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends com.bytedance.android.live.broadcastgame.opengame.network.g>> {
        public b() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y
    public final void onShow() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y
    public final void yl() {
    }

    public final void a() {
        ALogger.d("MiniGameToolbarAnim", "runDefaultIconAnim");
        int r100 = f1.f62074a;
        String r101 = f1.b(XplayScene.Video, false, true);
        if (r101 == null) goto L6;
        HSImageView r102 = this.f59735d;
        MiniGameToolbarBehavior$runDefaultIconAnim$1 r103 = MiniGameToolbarBehavior$runDefaultIconAnim$1.INSTANCE;
        b(r102, r101, true, Boolean.FALSE, 0, r103);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y
    public final boolean b80() {
        return y3.m(this.f59733b).n(ToolbarButton.OPEN_PLATFORM_MINI_GAME);
    }

    public MiniGameToolbarBehavior() {
        this.f59736e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r110) {
        StringBuilder r100 = new StringBuilder("toolbar onShow pre=");
        Object r101 = null;
        if (r110 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r110.f116204n);
    L6:
        r100.append(r102);
        ALogger.d("MiniGameToolbarAnim", r100.toString());
        Integer r103 = Integer.valueOf(R.drawable.ttlive_ic_mini_game2);
        int r104 = f1.f62074a;
        boolean r105 = false;
        Pair r106 = TuplesKt.to(r103, f1.b(XplayScene.Video, false, false));
        int r107 = ((Number) r106.component1()).intValue();
        String r108 = (String) r106.component2();
        if (r108 != null) goto L9;
    L14:
        HSImageView r109 = this.f59734c;
        if (r109 == null) goto L17;
        r109.setActualImageResource(r107);
    L17:
        boolean r111 = true;
        if (oz0.f120943a.getValue().booleanValue() == false) goto L24;
        if (r110 == null) goto L24;
        if (r110.f116204n != true) goto L24;
        ALogger.d("MiniGameToolbarAnim", "toolbar onShow skip");
        return;
    L24:
        DataCenter r112 = this.f59733b;
        if (r112 == null) goto L27;
        Boolean r113 = (Boolean) r112.get("revenue_interact", Boolean.FALSE);
    L29:
        if (Intrinsics.areEqual(r113, Boolean.TRUE) == false) goto L35;
        HashMap<String, String> r114 = new HashMap();
        r114.put("user_type", "user");
        ILinkServiceExternal r115 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r115 == null) goto L35;
        lc0.a r116 = r115.getControlService();
        if (r116 == null) goto L35;
        r116.d("livesdk_cohost_game_operate_icon_show", r114);
    L35:
        if (r110 == null) goto L101;
        String r117 = r110.f116194d;
        if (r117 == null) goto L102;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L45
        com.bytedance.android.live.broadcastgame.opengame.network.g r119 = (com.bytedance.android.live.broadcastgame.opengame.network.g) CollectionsKt.firstOrNull((List) GsonHelper.get().fromJson(r117, new b().getType()));     // Catch: Throwable -> L45
        Gson r120 = GsonHelper.get();     // Catch: Throwable -> L45
        if (r119 == null) goto L42;
        String r121 = r119.entrances;     // Catch: Throwable -> L45
        if (r121 == null) goto L42;
    L43:
        Object r122 = Result.m9449constructorimpl((com.bytedance.android.live.broadcastgame.opengame.network.l) r120.fromJson(r121, com.bytedance.android.live.broadcastgame.opengame.network.l.class));     // Catch: Throwable -> L45
    L48:
        if (Result.m9455isFailureimpl(r122) == false) goto L50;
        r122 = null;
    L50:
        com.bytedance.android.live.broadcastgame.opengame.network.l r123 = (com.bytedance.android.live.broadcastgame.opengame.network.l) r122;
        if (r123 == null) goto L98;
    L65:
        if (r123 != null) goto L68;
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo is null");
        a();
        return;
    L68:
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType:" + r123.visionType);
        int r124 = r123.visionType;
        int r125 = n0.f60299a;
        if (r124 != 1) goto L79;
        if (r123.visionIcon.length() == 0) goto L74;
        r111 = false;
    L74:
        if (r111 == false) goto L76;
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType is DIRECT but visionIcon is empty");
        a();
        return;
    L76:
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType is DIRECT and visionIcon is not empty");
        b(this.f59735d, r123.visionIcon, true, Boolean.FALSE, 0, MiniGameToolbarBehavior$onShow$4$2.INSTANCE);
        return;
    L79:
        if (r124 != 2) goto L94;
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo visionType is REQUEST");
        long r126 = 0;
        RoomContext r127 = RoomContext.a.c(RoomContext.Companion, this.f59733b, 0, 2);
        if (r127 == null) goto L87;
        com.bytedance.live.datacontext.m<Room> r128 = r127.getRoom();
        if (r128 == null) goto L87;
        Room r129 = r128.getValue();
        if (r129 == null) goto L87;
        r126 = r129.f162599id;
    L87:
        String r130 = r123.appId;
        if (r130.length() != 0) goto L90;
        r105 = true;
    L90:
        if (r105 == false) goto L92;
        r130 = r123.elemId;
    L92:
        ALogger.d("MiniGameToolbarAnim", "runConfigIconAnim appId: " + r130 + ", roomId: " + r126);
        com.bytedance.revenue.platform.api.core.rx.f.a(((AudienceGameNetApi) com.bytedance.android.live.network.c.b().e(AudienceGameNetApi.class)).getEntranceVision(r130, r126).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new t(this), new u(this)), this.f59736e);
        return;
    L94:
        ALogger.d("MiniGameToolbarAnim", "entranceVisionInfo is unknown");
        return;
    L98:
        List<com.bytedance.android.live.broadcastgame.opengame.network.l> r131 = ((com.bytedance.android.live.broadcastgame.opengame.network.h) GsonHelper.get().fromJson(r117, com.bytedance.android.live.broadcastgame.opengame.network.h.class)).entrances;     // Catch: Throwable -> L58
        if (r131 == null) goto L55;
        com.bytedance.android.live.broadcastgame.opengame.network.l r132 = (com.bytedance.android.live.broadcastgame.opengame.network.l) CollectionsKt.firstOrNull(r131);     // Catch: Throwable -> L58
    L56:
        Object r133 = Result.m9449constructorimpl(r132);     // Catch: Throwable -> L58
    L61:
        if (Result.m9455isFailureimpl(r133) == true) goto L64;
        r101 = r133;
    L64:
        r123 = (com.bytedance.android.live.broadcastgame.opengame.network.l) r101;
        goto L65
    L55:
        r132 = null;
    L58:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L42:
        r121 = "";
    L45:
        th = move-exception;
        Result.Companion r135 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    L102:
        return;
    L101:
        return;
    L27:
        r113 = null;
        goto L29
    L9:
        if (r2.a(r108) == true) goto L12;
        r108 = null;
    L12:
        if (r108 == null) goto L14;
        a1.n(this.f59734c, r108);
        goto L17
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, com.bytedance.android.live.broadcastgame.opengame.behavior.MiniGameToolbarBehavior$onCommand$$inlined$let$lambda$1] */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        if ((r100 instanceof pp1.i) == false) goto L21;
        Object r101 = ((pp1.i) r100).f530189a;
        if ((r101 instanceof Pair) == false) goto L22;
        if (r101 == null) goto L20;
        Object r102 = ((Pair) r101).getFirst();
        if ((r102 instanceof Boolean) == true) goto L10;
        r102 = null;
    L10:
        Boolean r103 = (Boolean) r102;
        if (r103 != null) goto L13;
        return;
    L13:
        if (r103.booleanValue() == false) goto L15;
        String r104 = "https://p1-webcast.douyinpic.com/obj/live-android/ttlive_card_small_card_anim_show.webp";
    L16:
        ?? r105 = new MiniGameToolbarBehavior$onCommand$$inlined$let$lambda$1(this, r100);
        final Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = r105;
        HSImageView r107 = this.f59732a;
        if (r107 == null) goto L24;
        PipelineDraweeControllerBuilder r108 = Fresco.newDraweeControllerBuilder().setUri(r104).setAutoPlayAnimations(false);
        MiniGameToolbarBehavior$runAnimation$1 r109 = MiniGameToolbarBehavior$runAnimation$1.INSTANCE;
        Function0<Unit> r110 = new MiniGameToolbarBehavior$runAnimation$2(r106);
        r107.setController(r108.setControllerListener(new s(new MiniGameToolbarBehavior$runAnimation$3(r106), r109, r110, false, new MiniGameToolbarBehavior$runAnimation$4(r106))).build());
        return;
    L24:
        return;
    L15:
        r104 = "https://p1-webcast.douyinpic.com/obj/live-android/ttlive_card_small_card_anim_hide.webp";
        goto L16
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<*, *>");
    L22:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        xs2.b.a().post(new com.bytedance.android.live.broadcastgame.api.openplatform.f("from_toolbar"));
        DataCenter r101 = this.f59733b;
        if (r101 == null) goto L5;
        Boolean r102 = (Boolean) r101.get("revenue_interact", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L14;
        HashMap<String, String> r103 = new HashMap();
        r103.put("user_type", "user");
        ILinkServiceExternal r104 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r104 == null) goto L15;
        lc0.a r105 = r104.getControlService();
        if (r105 == null) goto L16;
        r105.d("livesdk_cohost_game_operate_icon_click", r103);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f59736e.dispose();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        ALogger.d("MiniGameToolbarAnim", "toolbar onLoad");
        this.f59733b = r101;
        this.f59734c = (HSImageView) r100.findViewById(R.id.open_platform_static_icon);
        this.f59735d = (HSImageView) r100.findViewById(R.id.open_platform_enter_joystick_animation);
        this.f59732a = (HSImageView) r100.findViewById(R.id.open_platform_small_card_animation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(final HSImageView r110, final String r111, final boolean r112, final Boolean r113, final Integer r114, Function0<Unit> r210) {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = r210;
        if (r110 == null) goto L6;
        r110.getHierarchy().setPlaceholderImage(R.drawable.ttlive_ic_mini_game2);
        r110.getHierarchy().setFailureImage(R.drawable.ttlive_ic_mini_game2);
        PipelineDraweeControllerBuilder r115 = Fresco.newDraweeControllerBuilder().setUri(r111).setAutoPlayAnimations(false).setImageOriginListener(new MiniGameToolbarBehavior$runEnterAnimation$2(this));
        MiniGameToolbarBehavior$runEnterAnimation$3 r116 = MiniGameToolbarBehavior$runEnterAnimation$3.INSTANCE;
        Function0<Unit> r117 = new MiniGameToolbarBehavior$runEnterAnimation$4(this, r113, r114, r110, r111, r112, r100);
        MiniGameToolbarBehavior$runEnterAnimation$5 r101 = MiniGameToolbarBehavior$runEnterAnimation$5.INSTANCE;
        r110.setController(r115.setControllerListener(new s(new MiniGameToolbarBehavior$runEnterAnimation$6(r100), r116, r117, r112, r101)).build());
        return;
    }
}
