package com.bytedance.android.live.broadcast.api.model;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.AudienceResolutionPickerDialog;
import com.bytedance.android.livesdk.chatroom.ui.i8;
import com.bytedance.android.livesdk.chatroom.ui.l5;
import com.bytedance.android.livesdk.config.bv;
import com.bytedance.android.livesdk.config.qw0;
import com.bytedance.android.livesdk.config.ui;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class AnchorVideoResolutionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Pair<Integer, Integer>> f59009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Disposable f59010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f59011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final NextLiveData<String> f59012d = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H'J,\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/AnchorVideoResolutionManager$ResolutionApi;", "", "changeResolution", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/live/broadcast/api/model/AnchorResolutionInfo;", "params", "", "", "queryRecommendResolution", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ResolutionApi {
        @FormUrlEncoded
        @POST("/webcast/room/change_resolution/")
        Observable<Response<AnchorResolutionInfo>> changeResolution(@FieldMap Map<String, String> r100);

        @FormUrlEncoded
        @POST("/webcast/room/recommend_resolution/")
        Observable<Response<AnchorResolutionInfo>> queryRecommendResolution(@FieldMap Map<String, String> r100);
    }

    public static final class a {
        public a() {
        }
    }

    public AnchorVideoResolutionManager() {
    }

    static {
        f59009a = MapsKt.mapOf(new Pair[]{TuplesKt.to(PlayerResolution.SDKKEY.LD, new Pair(540, 960)), TuplesKt.to(PlayerResolution.SDKKEY.SD, new Pair(540, 960)), TuplesKt.to(PlayerResolution.SDKKEY.HD, new Pair(720, 1280)), TuplesKt.to(PlayerResolution.SDKKEY.UHD, new Pair(1080, Integer.valueOf(TECameraUtils.CAPTURE_NORMAL)))});
        new HashMap();
        f59011c = "";
        f59012d = new NextLiveData();
    }

    public static List b() {
        return ((IResolutionInfoService) va1.b.a.f553922a.a(IResolutionInfoService.class)).f5();
    }

    public static i8 c() {
        return ((IResolutionInfoService) va1.b.a.f553922a.a(IResolutionInfoService.class)).L3();
    }

    public static String d() {
        return ((IResolutionInfoService) va1.b.a.f553922a.a(IResolutionInfoService.class)).w0();
    }

    public static LiveMode e() {
        return ((IResolutionInfoService) va1.b.a.f553922a.a(IResolutionInfoService.class)).K1();
    }

    public static final void a(String r100) {
        com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r101 = com.bytedance.android.livesdk.sharedpref.b.f158175l2;
        Map<String, String> r102 = r101.getValue();
        r102.put(e().name(), r100);
        Unit r103 = Unit.INSTANCE;
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r100 = "empty";
    L8:
        IFeatureService r105 = (IFeatureService) jc1.k.f(IFeatureService.class);
        if (r105 == null) goto L13;
        z90.a r106 = r105.getFeatureManager();
        if (r106 == null) goto L13;
        r106.i("memory_broadcast_resolution_key", r100, FeatureType.MONITOR);
    L13:
        long r107 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e<Long> r108 = b6.Z;
        Long r109 = Long.valueOf(r107);
        r108.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r108, r109);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static RoomCreateInfo.p.a f(String r100) {
        Iterator r101 = b().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((RoomCreateInfo.p.a) r102).key, r100) == false) goto L4;
    L10:
        return (RoomCreateInfo.p.a) r102;
    L8:
        r102 = null;
        goto L10
    }

    public static String g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        RoomCreateInfo.p.a r101 = f(r100);
        if (r101 == null) goto L6;
        String r102 = r101.text;
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("anchor_resolution", r100);
    }

    @JvmStatic
    public static final void i(Room r100) {
        Intrinsics.checkNotNullParameter("anchor_change", "reason");
        if (r100 != null) goto L5;
        return;
    L5:
        NextLiveData<String> r101 = ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.f553922a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt();
        com.bytedance.android.livesdk.log.g r102 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r103 = new Pair[6];
        r103[0] = TuplesKt.to("definition", r101.getValue());
        r103[1] = TuplesKt.to("definition_reason", "anchor_change");
        StreamUrl r104 = r100.getStreamUrl();
        if (r104 == null) goto L12;
        IStreamUrlExtra r105 = r104.getExtra();
        if (r105 == null) goto L12;
        if (r105.isEnableH265() != true) goto L12;
        String r106 = "265";
    L13:
        r103[2] = TuplesKt.to("encoding_format", r106);
        LiveMode r107 = r100.getStreamType();
        int r108 = com.bytedance.android.live.core.utils.h1.f66189a;
        r103[3] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r107));
        r103[4] = TuplesKt.to(IPerformanceManager.Params.is_anchor, "1");
        r103[5] = TuplesKt.to("anchor_id", r100.getOwnerUserIdString());
        r102.sendLog("performance_definition_monitor", MapsKt.mapOf(r103), new Object[]{Room.class});
        return;
    L12:
        r106 = "264";
        goto L13
    }

    public static void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        f59011c = r100;
        Iterator r101 = b().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((RoomCreateInfo.p.a) r102).key, r100) == false) goto L4;
    L9:
        RoomCreateInfo.p.a r103 = (RoomCreateInfo.p.a) r102;
        if (r103 == null) goto L17;
        va1.b r104 = va1.b.a.f553922a;
        IMiddlewareAnchorVideoResolutionManager r105 = (IMiddlewareAnchorVideoResolutionManager) r104.a(IMiddlewareAnchorVideoResolutionManager.class);
        if (r105 == null) goto L16;
        NextLiveData<String> r106 = r105.getCurrResolutionTxt();
        if (r106 == null) goto L16;
        r106.setValue(r103.text);
    L16:
        h(e().name() + " update currentResolutionText : " + ((IMiddlewareAnchorVideoResolutionManager) r104.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt().getValue());
    L17:
        f59012d.setValue(r100);
        return;
    L8:
        r102 = null;
        goto L9
    }

    @JvmStatic
    public static final void l(final Context r110, final Room r111) {
        if (b().isEmpty() == true) goto L43;
        if (r110 == null) goto L43;
        ALogger.i("anchor_resolution", "showResolutionPicker");
        if (bv.f119901a.getValue().a() == false) goto L11;
        IBroadcastService r100 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r100 == null) goto L11;
        r100.getLiveByteCastSinkService();
    L11:
        List r101 = b();
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L12:
        final boolean r104 = true;
        if (r103.hasNext() == false) goto L25;
        RoomCreateInfo.p.a r105 = (RoomCreateInfo.p.a) r103.next();
        boolean r106 = Intrinsics.areEqual(r105.key, f59011c);
        String r107 = r105.text;
        if (r106 == false) goto L17;
        String r108 = "selected";
    L18:
        String r112 = r108;
        if (r111 != null) goto L21;
    L23:
        boolean r113 = false;
    L24:
        r102.add(new l5(r107, "", 0, r112, r113, null, null, r105.key, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION));
        goto L12
    L21:
        if (r111.isMergeVSRoom() != true) goto L23;
        r113 = true;
        goto L24
    L17:
        r108 = "unselected";
        goto L18
    L25:
        Iterator r109 = b().iterator();
    L27:
        if (r109.hasNext() == false) goto L29;
        j("livesdk_anchor_definition_setting_show", r111, ((RoomCreateInfo.p.a) r109.next()).text, "");
        goto L27
    L29:
        AudienceResolutionPickerDialog r114 = new AudienceResolutionPickerDialog(r110, r102, e(), new AnchorVideoResolutionManager$showResolutionPicker$2(r111, r104, r110));
        if (e() != LiveMode.SCREEN_RECORD) goto L35;
        if (ui.f121376a.getValue().a() == false) goto L35;
        r114.Z0(c(), d(), AnchorVideoResolutionManager$showResolutionPicker$3$1.INSTANCE, AnchorVideoResolutionManager$showResolutionPicker$3$2.INSTANCE, AnchorVideoResolutionManager$showResolutionPicker$3$3.INSTANCE, AnchorVideoResolutionManager$showResolutionPicker$3$4.INSTANCE, null, null);
    L37:
        r114.N = AnchorVideoResolutionManager$showResolutionPicker$3$9.INSTANCE;
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L46;
        DialogLancet.handleBlockedDialogShow(r114);
        return;
    L46:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L41:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        return;
    L35:
        if (e() != LiveMode.VIDEO) goto L37;
        qw0.f121088a.getValue().a();
    L43:
        h("showResolutionPicker failed");
    }

    public static void j(String r110, Room r111, String r112, String r210) {
        NextLiveData<String> r100 = ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.f553922a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt();
        com.bytedance.android.livesdk.log.g r101 = com.bytedance.android.livesdk.log.u.l();
        Pair[] r102 = new Pair[8];
        LiveMode r103 = e();
        int r104 = com.bytedance.android.live.core.utils.h1.f66189a;
        r102[0] = TuplesKt.to("live_type", com.bytedance.android.live.core.utils.i1.a(r103));
        IUserService r105 = (IUserService) jc1.k.f(IUserService.class);
        String r106 = null;
        if (r105 == null) goto L7;
        com.bytedance.android.livesdk.user.f r107 = r105.user();
        if (r107 == null) goto L7;
        String r108 = r107.n();
    L8:
        r102[1] = TuplesKt.to("anchor_id", r108);
        if (r111 == null) goto L11;
        String r109 = "live_take_detail";
    L12:
        r102[2] = TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r109);
        r102[3] = TuplesKt.to("show_type", "icon");
        r102[4] = TuplesKt.to("definition", r112);
        String r113 = r100.getValue();
        if (r113 == null) goto L17;
        List r114 = StringsKt.split$default(r113, new String[]{" "}, false, 0, 6, null);
        if (r114 == null) goto L17;
        String r115 = (String) ListProtector.get(r114, 0);
    L18:
        r102[5] = TuplesKt.to("old_resolution", r115);
        if (r112 == null) goto L23;
        List r116 = StringsKt.split$default(r112, new String[]{" "}, false, 0, 6, null);
        if (r116 == null) goto L23;
        r106 = (String) ListProtector.get(r116, 0);
    L23:
        r102[6] = TuplesKt.to("new_resolution", r106);
        r102[7] = TuplesKt.to("if_use_recommend_image", r210);
        r101.sendLog(r110, MapsKt.mapOf(r102), new Object[]{Room.class});
        return;
    L17:
        r115 = null;
        goto L18
    L11:
        r109 = "live_take_page";
    L7:
        r108 = null;
        goto L8
    }
}
