package com.bytedance.android.live;

import am2.a0;
import am2.b0;
import am2.x;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import b30.n;
import com.bytedance.android.live.api.MatchShareApi;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.helper.LiveShareHelper;
import com.bytedance.android.live.landscape.LandscapeShareActivity;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.portrait.PortraitShareActivity;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper;
import com.bytedance.android.livehostapi.business.depend.share.LiveQrCodeConfig;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SharePublishParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.chatroom.f0;
import com.bytedance.android.livesdk.chatroom.ssposter.model.TicketGenerateResponse;
import com.bytedance.android.livesdk.chatroom.ssposter.model.TicketInfo;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdk.vs.model.SearchPanelParam;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionResponseDataSingle;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.reflect.TypeToken;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;
import ry.o;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bG\u0010HJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016Jp\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u0019H\u0016JF\u0010 \u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016J0\u0010%\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020!2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0016J0\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020\f2\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0'2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0012\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0016J\u0012\u00105\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u00106\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\bH\u0016J\u0018\u00109\u001a\u00020\b2\u0006\u00100\u001a\u00020/2\u0006\u00108\u001a\u00020/H\u0016J0\u0010;\u001a\u00020\b2&\u0010:\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0019H\u0016J\u001c\u0010=\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J\u001c\u0010>\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J\u001c\u0010?\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J\u001c\u0010@\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0<H\u0016J6\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0018j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`\u00192\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010A\u001a\u00020\u000fH\u0016J\b\u0010C\u001a\u00020\fH\u0016J\b\u0010D\u001a\u00020\fH\u0016J\u0014\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f0EH\u0016¨\u0006K"}, d2 = {"Lcom/bytedance/android/live/MatchShareService;", "Lcom/bytedance/android/live/room/api/IMatchShareService;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/bytedance/android/livesdk/vs/model/MatchShareParam;", "shareParam", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "collectionItem", "", "showShareDialog", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "isLandscape", "launchMatchShare", "", "enterFrom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "collectionId", "episodeId", "contentType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logParam", "launchMatchShareByCollectionId", "", "index", "preloadCollectionJson", "roomId", "launchMatchShareByRoomId", "Landroid/app/Activity;", "showPushPanel", "ticketGenerate", "extraParams", "launchMatchTicketShare", "addRoomInfo", "", "sharePosterList", "logExtra", "logReflowExtra", "launchVsMultiPosterShare", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "logQuickShotBtnShow", "", "clickTime", "logQuickShotBtnClick", "logQuickShotShareDialogClick", "logQuickShotShareDialogShow", "logQuickRecordBtnClick", "logQuickRecordBtnShow", "logQuickRecordFinish", "logQuickRecordShareDialogClick", "recordDuration", "logQuickRecordShareDialogShow", "params", "logMatchSharePublishPageShow", "", "logQuickShotFinish", "logQuickRecordTaskFinish", "logQuickRecordTaskFinish201", "logQuickRecordAudioOpen", "enterFromMerge", "generateShareLogParams", "allowQuickRecordShare", "allowQuickShotShare", "Lkotlin/Pair;", "openPushGuideDialogForSaas", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MatchShareService implements IMatchShareService {
    public static final a Companion = null;
    public static final String TICKET_SHARE = "ticket_share";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MatchShareService f58526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f58527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f58528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Room f58529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Episode f58530e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f58531f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ HashMap f58532g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Context f58533h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f58534i;

        public b(MatchShareService r100, String r101, String r102, Room r103, Episode r104, String r105, HashMap r106, Context r107, boolean r108) {
            this.f58526a = r100;
            this.f58527b = r101;
            this.f58528c = r102;
            this.f58529d = r103;
            this.f58530e = r104;
            this.f58531f = r105;
            this.f58532g = r106;
            this.f58533h = r107;
            this.f58534i = r108;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            Response r100 = (Response) r210;
            if (r100 == null) goto L10;
            CollectionResponseDataSingle r101 = (CollectionResponseDataSingle) r100.data;
            if (r101 == null) goto L11;
            CollectionItem r102 = r101.getCollectionItem();
            if (r102 == null) goto L12;
            r102.setCollectionId(this.f58527b);
            MatchShareParam r103 = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
            r103.f159378a = this.f58528c;
            r103.f159379b = this.f58527b;
            r103.f159381d = CollectionsKt.mutableListOf(new CollectionItem[]{r102});
            r103.f159383f = this.f58529d;
            r103.f159384g = this.f58530e;
            String r104 = this.f58531f;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r103.f159390m = r104;
            HashMap<String, String> r105 = this.f58532g;
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r103.f159391n = r105;
            this.f58526a.launchMatchShare(this.f58533h, this.f58534i, r103);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f58535a = null;

        static {
            f58535a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            f2.c("分享失败", 0);
            ((Throwable) r100).printStackTrace();
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/MatchShareService$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<List<? extends CollectionItem>> {
        public d() {
        }
    }

    static {
        Companion = new a();
    }

    public MatchShareService() {
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public boolean allowQuickRecordShare() {
        int r100 = LiveShareHelper.f69012a;
        return !PadConfigUtils.c();
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public boolean allowQuickShotShare() {
        int r100 = LiveShareHelper.f69012a;
        return !PadConfigUtils.c();
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordFinish() {
        int r100 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r101 = u.l();
        x r102 = new x();
        r102.f4349a = "live";
        r102.f4353e = "other";
        r102.f4350b = "live_detail";
        r101.h("livesdk_screencap_finish", null, new Object[]{r102, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordShareDialogClick() {
        int r100 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r101 = u.l();
        Map<String, String> r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", "1")});
        x r103 = new x();
        r103.f4349a = "live";
        r103.f4353e = "click";
        r103.f4350b = "live_detail";
        r101.h("livesdk_screencap_floating_window_click", r102, new Object[]{r103, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickShotShareDialogClick() {
        int r100 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r101 = u.l();
        x r102 = new x();
        r102.f4349a = "live";
        r102.f4353e = "click";
        r102.f4350b = "live_detail";
        r101.h("livesdk_screenshot_floating_window_click", null, new Object[]{r102, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public Pair<Integer, String> openPushGuideDialogForSaas() {
        IHostService r100 = TTLiveSDK.hostService();
        Long r101 = null;
        if (r100 == null) goto L5;
        o r102 = r100.methodChannel();
    L7:
        if (r102 != null) goto L9;
    L37:
        ALogger.w("MatchShareService", "host not support");
        return TuplesKt.to(0, "host not support");
    L9:
        if (r102.m1("has_push_permission") == false) goto L37;
        if (r102.m1("show_push_permission_guide") == false) goto L37;
        StringBuilder r103 = new StringBuilder("last_push_permission_guide_");
        IHostService r104 = TTLiveSDK.hostService();
        if (r104 == null) goto L18;
        IHostUser r105 = r104.user();
        if (r105 == null) goto L18;
        r101 = Long.valueOf(r105.hostUserId());
    L18:
        r103.append(r101);
        String r106 = r103.toString();
        if (Intrinsics.areEqual(r102.Q3(), Boolean.FALSE) == false) goto L34;
        Integer r107 = LiveSettingKeys.LIVE_PUSH_PERMISSION_GUIDE_FREQ_SECONDS.getValue();
        long r108 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e r109 = new com.bytedance.android.livesdk.sharedpref.e(r106, 0L);
        if (r107.intValue() >= 0) goto L25;
        return TuplesKt.to(0, "feature offline");
    L25:
        if (r107.intValue() == 0) goto L31;
        if (r108 > (((long) r107.intValue()) + ((Number) r109.getValue()).longValue())) goto L31;
        String r110 = "throttled";
    L36:
        return TuplesKt.to(1, r110);
    L31:
        if (Intrinsics.areEqual(Boolean.TRUE, r102.Q3()) == false) goto L33;
        com.bytedance.android.livesdk.sharedpref.f.d(r109, Long.valueOf(r108));
        r110 = "showing";
        goto L36
    L33:
        r110 = "host ignores";
        goto L36
    L34:
        r110 = "already";
        goto L36
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logMatchSharePublishPageShow(HashMap<String, String> r100) {
        int r101 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r102 = u.l();
        x r103 = new x();
        r103.f4349a = "live";
        r103.f4353e = "show";
        r103.f4350b = "live_detail";
        r102.h("livesdk_content_publish_page_show", r100, new Object[]{r103, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordAudioOpen(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = jl0.a.f499522a;
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.android.livesdk.log.g r102 = u.l();
        x r103 = new x();
        r103.f4349a = "live";
        r103.f4353e = "other";
        r103.f4350b = "live_detail";
        r102.h("livesdk_screenrecord_audio_open", r100, new Object[]{r103, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordBtnClick(long r100) {
        int r101 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r102 = u.l();
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", "1"), TuplesKt.to("click_time", String.valueOf(r100))});
        x r104 = new x();
        r104.f4349a = "live";
        r104.f4353e = "click";
        r104.f4350b = "live_detail";
        r102.h("livesdk_screencap_icon_click", r103, new Object[]{r104, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordBtnShow(DataCenter r100) {
        int r101 = jl0.a.f499522a;
        if (r100 == null) goto L6;
        new f0(r100).a("livesdk_screencap_icon_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", "1")}));
        return;
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordTaskFinish(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = jl0.a.f499522a;
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.android.livesdk.log.g r102 = u.l();
        x r103 = new x();
        r103.f4349a = "live";
        r103.f4353e = "other";
        r103.f4350b = "live_detail";
        r102.h("livesdk_screenrecord_finish", r100, new Object[]{r103, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordTaskFinish201(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = jl0.a.f499522a;
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.android.livesdk.log.g r102 = u.l();
        x r103 = new x();
        r103.f4349a = "live";
        r103.f4353e = "other";
        r103.f4350b = "live_detail";
        r102.h("livesdk_screenrecord_finish_201", r100, new Object[]{r103, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickShotBtnClick(long r100) {
        int r101 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r102 = u.l();
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r100))});
        x r104 = new x();
        r104.f4349a = "live";
        r104.f4353e = "click";
        r104.f4350b = "live_detail";
        r102.h("livesdk_screenshot_icon_click", r103, new Object[]{r104, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickShotBtnShow(DataCenter r100) {
        int r101 = jl0.a.f499522a;
        if (r100 == null) goto L6;
        new f0(r100).a("livesdk_screenshot_icon_show", null);
        return;
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickShotFinish(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = jl0.a.f499522a;
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.android.livesdk.log.g r102 = u.l();
        x r103 = new x();
        r103.f4349a = "live";
        r103.f4353e = "other";
        r103.f4350b = "live_detail";
        r102.h("livesdk_screenshot_finish", r100, new Object[]{r103, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickShotShareDialogShow(long r100) {
        int r101 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r102 = u.l();
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_time", String.valueOf(r100)), TuplesKt.to("start_duration", String.valueOf(System.currentTimeMillis() - r100))});
        x r104 = new x();
        r104.f4349a = "live";
        r104.f4353e = "show";
        r104.f4350b = "live_detail";
        r102.h("livesdk_screenshot_floating_window_show", r103, new Object[]{r104, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public HashMap<String, String> generateShareLogParams(DataCenter r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        int r102 = jl0.a.f499522a;
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        HashMap<String, String> r103 = new HashMap();
        Room r104 = null;
        if (r100 == null) goto L5;
        r104 = (Room) r100.get("data_room", null);
    L5:
        r103.put("enter_from_merge", r101);
        String r105 = "";
        if (r104 == null) goto L9;
        String r106 = r104.getOwnerUserIdString();
        if (r106 == null) goto L9;
    L10:
        r103.put("anchor_id", r106);
        if (r104 == null) goto L14;
        String r107 = r104.getIdStr();
        if (r107 == null) goto L14;
    L15:
        r103.put("room_id", r107);
        IHostService r108 = TTLiveSDK.hostService();
        if (r108 == null) goto L22;
        IHostUser r109 = r108.user();
        if (r109 == null) goto L22;
        String r110 = r109.getCurUserId();
        if (r110 == null) goto L22;
        r105 = r110;
    L22:
        r103.put("user_id", r105);
        if (r104 == null) goto L25;
        String r111 = "live";
    L26:
        r103.put(IPerformanceManager.Params.room_type, r111);
        if (r104 == null) goto L32;
        r103.putAll(u.l().c(Room.class).getMap());
        Map<String, String> r112 = u.l().c(x.class).getMap();
        if (r112 == null) goto L31;
        r103.putAll(r112);
    L31:
        int r113 = ju2.f.M;
        ju2.f r114 = ju2.f.a.a(r104);
        r114.f500453n = z.m(r100, true) ? 1 : 0;
        r103.putAll(r114.b());
    L48:
        return r103;
    L32:
        if (r100 == null) goto L48;
        nm1.h r115 = pm1.f.f();
        if (r115 == null) goto L39;
        Map<String, String> r116 = r115.d(r100, a0.class);
        if (r116 == null) goto L39;
        Map<? extends String, ? extends String> r117 = MapsKt.toMutableMap(r116);
        if (r117 == null) goto L39;
    L40:
        r103.putAll(r117);
        nm1.h r118 = pm1.f.f();
        if (r118 == null) goto L46;
        Map<String, String> r119 = r118.d(r100, b0.class);
        if (r119 == null) goto L46;
        Map<? extends String, ? extends String> r120 = MapsKt.toMutableMap(r119);
        if (r120 == null) goto L46;
    L47:
        r103.putAll(r120);
    L46:
        r120 = new LinkedHashMap();
    L39:
        r117 = new LinkedHashMap();
        goto L40
    L25:
        r111 = "replay";
    L14:
        r107 = "";
    L9:
        r106 = "";
        goto L10
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void logQuickRecordShareDialogShow(long r100, long r110) {
        int r101 = jl0.a.f499522a;
        com.bytedance.android.livesdk.log.g r102 = u.l();
        Map<String, String> r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_sjb", "1"), TuplesKt.to("click_time", String.valueOf(r100)), TuplesKt.to("record_duration", String.valueOf(r110)), TuplesKt.to("show_share_dialog_duration", String.valueOf(System.currentTimeMillis() - r100))});
        x r111 = new x();
        r111.f4349a = "live";
        r111.f4353e = "show";
        r111.f4350b = "live_detail";
        r102.h("livesdk_screencap_floating_window_show", r103, new Object[]{r111, Room.class});
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void launchMatchShare(Context r100, boolean r101, MatchShareParam r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "shareParam");
        int r103 = com.bytedance.android.live.c.f64424a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "shareParam");
        if (r101 == false) goto L5;
        Class r104 = LandscapeShareActivity.class;
    L6:
        Intent r105 = new Intent(r100, r104);
        f.f68988a = r102;
        Context r106 = null;
        if (r101 == false) goto L16;
        if ((r100 instanceof Activity) == false) goto L12;
        r106 = r100;
    L12:
        Activity r107 = (Activity) r106;
        if (r107 == null) goto L22;
        r107.overridePendingTransition(R.anim.ttlive_vs_share_come_from_right, 0);
    L22:
        r100.startActivity(r105);
        return;
    L16:
        if ((r100 instanceof Activity) == false) goto L19;
        r106 = r100;
    L19:
        Activity r108 = (Activity) r106;
        if (r108 == null) goto L22;
        r108.overridePendingTransition(R.anim.ttlive_vs_share_come_from_bottom, 0);
        goto L22
    L5:
        r104 = PortraitShareActivity.class;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void showShareDialog(FragmentActivity r100, MatchShareParam r101, CollectionItem r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "shareParam");
        Intrinsics.checkNotNullParameter(r102, "collectionItem");
        LiveShareHelper.b(r100, r101, r102, new HashMap());
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void launchVsMultiPosterShare(boolean r100, List<String> r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "sharePosterList");
        Intrinsics.checkNotNullParameter(r102, "logExtra");
        Intrinsics.checkNotNullParameter(r103, "logReflowExtra");
        xs2.b.a().post(new n(r100, r101, r102, r103));
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void launchMatchTicketShare(Activity r310, boolean r311, String r312, String r313, String r314) {
        String r100 = "is_vs";
        String r110 = "";
        Intrinsics.checkNotNullParameter(r310, "activity");
        Intrinsics.checkNotNullParameter(r312, "enterFrom");
        Intrinsics.checkNotNullParameter(r313, "ticketGenerate");
        Intrinsics.checkNotNullParameter(r314, "extraParams");
        ILiveService r101 = TTLiveService.getLiveService();
        if (r101 == null) goto L5;
        ILiveQrCodeShareHelper r102 = r101.getQrCodeShareHelper(4);
    L6:
        if (r102 == null) goto L8;
        Object r111 = r102.setTicketJson(r313);
    L9:
        LiveQrCodeConfig r103 = new LiveQrCodeConfig();
        HashMap<String, String> r104 = new HashMap();
        u.l().c(x.class).a(r104);
        boolean r105 = r111 instanceof TicketGenerateResponse;
        if (r105 == true) goto L12;
        Object r106 = null;
    L13:
        TicketGenerateResponse r107 = (TicketGenerateResponse) r106;
        if (r107 != null) goto L16;
        r100 = "is_vs";
    L55:
        if (((IHostBusiness) k.n(IHostBusiness.class)).isHotsoonR() == false) goto L60;
        ILiveService r108 = TTLiveService.getLiveService();
        if (r108 == null) goto L128;
        r108.showDefaultNotificationSettingDialog(r310, "after_live_reservation");
        return;
    L128:
        return;
    L60:
        r103.setPanelType(4);
        if ((r102 instanceof IQrCodeShareHelper) == true) goto L63;
        ILiveQrCodeShareHelper r109 = null;
    L64:
        IQrCodeShareHelper r112 = (IQrCodeShareHelper) r109;
        if (r112 == null) goto L67;
        r103.setQrCodeShareHelper(r112);
    L67:
        ALogger.d(TICKET_SHARE, "ticketGenerate: " + r313 + ", extraParams: " + r314);
        r104.put("token_form", "pic");
        r104.put("share_type", "pic");
        r104.put("content_type", "live_booking");
        r104.put("sjb_content_type", "live_booking");
        IUserService r113 = (IUserService) k.f(IUserService.class);
        if (r113 == null) goto L73;
        com.bytedance.android.livesdk.user.f r114 = r113.user();
        if (r114 == null) goto L73;
        String r115 = r114.n();
        if (r115 == null) goto L73;
    L74:
        r104.put("from_user_id", r115);
        JSONObject r116 = new JSONObject(r314);     // Catch: Throwable -> L77
        r104.put("booking_anchor_id", r116.optString("booking_anchor_id", ""));     // Catch: Throwable -> L77
        r104.put("enter_from_merge", r116.optString("enter_from_merge", ""));     // Catch: Throwable -> L77
        r104.put("enter_method", r116.optString("enter_method", ""));     // Catch: Throwable -> L77
        r104.put("vs_episode_sub_type", r116.optString("vs_episode_sub_type", ""));     // Catch: Throwable -> L77
        String r117 = r100;
        r104.put(r117, r116.optString(r117, "1"));     // Catch: Throwable -> L77
        r104.put("vs_season_id", r116.optString("vs_season_id", ""));     // Catch: Throwable -> L77
        r104.put("vs_episode_id", r116.optString("vs_episode_id", ""));     // Catch: Throwable -> L77
        r104.put(IPerformanceManager.Params.room_type, r116.optString(IPerformanceManager.Params.room_type, "live"));     // Catch: Throwable -> L77
        r104.put("room_id", r116.optString("room_id", ""));     // Catch: Throwable -> L77
        r104.put("author_id", r116.optString("author_id", ""));     // Catch: Throwable -> L77
        String r118 = r104.put(ILiveRoomPlayFragmentConstant.EXTRA_LYNX_CARD_ORDER, r116.optString(ILiveRoomPlayFragmentConstant.EXTRA_LYNX_CARD_ORDER, ""));     // Catch: Throwable -> L77
        String r119 = "shareTicket";
    L79:
        ShareParams.Builder r120 = ShareParams.builder();
        ShareParams.Builder r121 = r120.setShareSubScene(ShareSubScene.LiveMatchTicket).setEnterFrom("live_booking").setLiveQrCodeConfig(r103).setActivityInfo(r104).setExtraParams(r104).setLogExtraParams(r104);
        SharePublishParam r122 = new SharePublishParam();
        JSONObject r123 = new JSONObject(r314);     // Catch: Throwable -> L82
        r122.setActivityVideoType(r123.optInt("activity_video_type"));     // Catch: Throwable -> L82
        r122.setPublishJumpTitle(r123.optString("jump_title"));     // Catch: Throwable -> L82
    L84:
        if (r102 == null) goto L87;
        String r124 = r102.getRelatedReviewContent();
        if (r124 == null) goto L87;
    L88:
        r122.setRelatedReviewContent(r124);
        if (r105 == true) goto L91;
        Object r125 = null;
    L92:
        TicketGenerateResponse r126 = (TicketGenerateResponse) r125;
        if (r126 == null) goto L98;
        TicketInfo r127 = r126.getTicketInfo();
        if (r127 == null) goto L98;
        String r128 = r127.getSchema();
        if (r128 == null) goto L98;
    L99:
        r122.setPublishJumpScheme(r128);
        if (r105 == true) goto L102;
        Object r129 = null;
    L103:
        TicketGenerateResponse r130 = (TicketGenerateResponse) r129;
        if (r130 == null) goto L110;
        List<String> r131 = r130.getMusicIdStrList();
        if (r131 == null) goto L110;
        List<String> r132 = r131;
        if ((!r132.isEmpty()) == false) goto L111;
        r110 = (String) CollectionsKt.random(r132, Random.Default);
    L111:
        r122.setMusicId(String.valueOf(r110));
        r122.setShowOutsitePushAuthPanel(r311);
        r122.setShareTicketExtraJson(r314);
        Unit r133 = Unit.INSTANCE;
        r121.setSharePublishParam(r122);
        if (r105 == false) goto L122;
        TicketGenerateResponse r134 = (TicketGenerateResponse) r111;
        TicketInfo r135 = r134.getTicketInfo();
        if (r135 == null) goto L116;
        String r136 = r135.getShareScene();
    L117:
        ShareParams.Builder r137 = r120.setShareSceneConfigName(r136);
        TicketInfo r138 = r134.getTicketInfo();
        if (r138 == null) goto L120;
        String r139 = r138.getSchema();
    L121:
        r137.setUrl(r139);
        goto L122
    L120:
        r139 = null;
        goto L121
    L116:
        r136 = null;
    L122:
        ((ILiveShareService) k.n(ILiveShareService.class)).share(new i81.a(null, r310, null, r120.build(), null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), TICKET_SHARE, LiveShareType.SHARE_DIALOG, null);
        return;
    L110:
        r110 = null;
        goto L111
    L102:
        r129 = r111;
    L98:
        r128 = "";
        goto L99
    L91:
        r125 = r111;
    L87:
        r124 = "";
    L82:
        th = move-exception;
        ALogger.e(r119, th);
    L77:
        th = move-exception;
        r119 = "shareTicket";
        ALogger.e(r119, th);
    L73:
        r115 = "0";
        goto L74
    L63:
        r109 = r102;
        goto L64
    L16:
        if (r107.getTicketInfo() != null) goto L18;
    L51:
        ALogger.e(TICKET_SHARE, "ticket generate data illegal.");
        return;
    L18:
        if (r107.getTicketIdList() == null) goto L51;
        List<Long> r210 = r107.getTicketIdList();
        if (r210 == null) goto L25;
        if (r210.isEmpty() == true) goto L51;
    L25:
        TicketInfo r140 = r107.getTicketInfo();
        if (r140 == null) goto L32;
        List<ImageModel> r141 = r140.getTicketImgList();
        if (r141 == null) goto L32;
        if (r141.isEmpty() == true) goto L51;
    L32:
        TicketInfo r142 = r107.getTicketInfo();
        if (r142 == null) goto L35;
        Long r143 = r142.getContentId();
    L36:
        if (r143 == null) goto L42;
        TicketInfo r144 = r107.getTicketInfo();
        if (r144 == null) goto L40;
        Long r145 = r144.getContentId();
    L41:
        r104.put("vs_content_id", String.valueOf(r145));
        goto L42
    L40:
        r145 = null;
    L42:
        TicketGenerateResponse r146 = (TicketGenerateResponse) r111;
        if (r146 == null) goto L49;
        TicketInfo r147 = r146.getTicketInfo();
        if (r147 == null) goto L49;
        Long r148 = r147.getStageId();
        if (r148 == null) goto L49;
        long r211 = r148.longValue();
    L50:
        String r149 = r104.put("stage_id", String.valueOf(r211));
    L49:
        r211 = 0;
        goto L50
    L35:
        r143 = null;
        goto L36
    L12:
        r106 = r111;
        goto L13
    L8:
        r111 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void launchMatchShareByRoomId(Context r210, String r211, int r212, String r213, String r214, String r215, boolean r310) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "enterFrom");
        Type r100 = new d().getType();     // Catch: Exception -> L5
        List<CollectionItem> r101 = (List) GsonHelper.get().fromJson(r213, r100);     // Catch: Exception -> L5
    L6:
        if (r101 == null) goto L16;
        if (r212 >= 0) goto L9;
    L11:
        Object r102 = new CollectionItem();
    L12:
        CollectionItem r103 = (CollectionItem) r102;
        if (r103 == null) goto L16;
        String r104 = r103.getCollectionId();
        if (r104 == null) goto L16;
    L17:
        MatchShareParam r110 = new MatchShareParam(null, null, null, null, null, null, 0, null, null, null, false, 0, 65535);
        r110.f159378a = r211;
        r110.f159379b = r104;
        r110.f159381d = r101;
        r110.f159382e = null;
        Room r105 = new Room();
        if (r214 == null) goto L20;
        long r106 = CastLongProtector.parseLong(r214);
    L21:
        r105.f162599id = r106;
        Unit r107 = Unit.INSTANCE;
        r110.f159383f = r105;
        Episode r108 = new Episode();
        r108.idStr = r215;
        r110.f159384g = r108;
        r110.f159387j = new SearchPanelParam(r212, r101);
        launchMatchShare(r210, r310, r110);
        return;
    L20:
        r106 = 0;
        goto L21
    L9:
        if (r212 > CollectionsKt.getLastIndex(r101)) goto L11;
        r102 = ListProtector.get(r101, r212);
    L16:
        r104 = "";
    L5:
        r101 = new ArrayList();
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.IMatchShareService
    public void launchMatchShareByCollectionId(Context r110, String r111, Room r112, Episode r113, boolean r114, String r115, String r116, String r210, HashMap<String, String> r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r115, "collectionId");
        Intrinsics.checkNotNullParameter(r116, "episodeId");
        Intrinsics.checkNotNullParameter(r210, "contentType");
        Intrinsics.checkNotNullParameter(r211, "logParam");
        Observable<Response<CollectionResponseDataSingle>> r117 = ((MatchShareApi) com.bytedance.android.live.network.c.b().e(MatchShareApi.class)).getCollectionDataByCollectionId(r115, r116);
        if (r117 == null) goto L6;
        r117.subscribe(new b(this, r115, r111, r112, r113, r210, r211, r110, r114), c.f58535a);
        return;
    }
}
