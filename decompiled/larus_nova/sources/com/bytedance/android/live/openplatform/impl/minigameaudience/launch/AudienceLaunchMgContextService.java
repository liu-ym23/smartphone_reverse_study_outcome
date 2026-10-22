package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import am2.n;
import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.AudienceMiniGameAppLogContextService;
import com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.CandyToolbarContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.launch.LaunchMgContextService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livesdk.config.a90;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/launch/AudienceLaunchMgContextService;", "Lcom/bytedance/android/live/openplatform/impl/minigamecommon/launch/LaunchMgContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLaunchMgContextService extends LaunchMgContextService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f85297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CompositeDisposable f85298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f85299d;

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        this.f85297b = 0;
        IHostLiveOpenPlatform r100 = TTLiveSDK.hostService().hostOpenPlatform();
        JSONObject r101 = new JSONObject();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(r101.put("event", LiveCommonConstants.REASON_ON_DEDTROY));     // Catch: Throwable -> L5
    L7:
        Unit r103 = Unit.INSTANCE;
        r100.dispatchMiniGameEvent("live_room_lifecycle_event", r101);
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public AudienceLaunchMgContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
        this.f85296a = "AudienceLaunchMgContextService";
        this.f85299d = !a90.f119771a.getValue().booleanValue();
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigamecommon.launch.LaunchMgContextService
    public final Map<String, String> f(HashMap<String, String> r100) {
        Map<String, String> r101 = super.f(r100);
        fr0.b.a r102 = ((CandyToolbarContextService) getOpenPlatformContext().getService(CandyToolbarContextService.class)).f85312b;
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = r102.i();
        if (r104 == null) goto L6;
    L7:
        r101.put("task_id", r104);
        if (r102 == null) goto L13;
        String r105 = r102.h();
        if (r105 == null) goto L13;
        r103 = r105;
    L13:
        r101.put(BdpAppEventConstant.PARAMS_MP_NAME, r103);
        String r106 = null;
        if (r102 == null) goto L16;
        Integer r107 = Integer.valueOf(r102.e());
    L17:
        boolean r108 = true;
        if (r107 != null) goto L21;
    L23:
        if (r107 != null) goto L26;
    L28:
        r101.put(IPerformanceManager.Params.is_anchor, "0");
        r101.put("ad_id", n.f().a());
        DataCenter r109 = getOpenPlatformContext().getDataCenter();
        if (r109 == null) goto L31;
        Boolean r110 = (Boolean) r109.get("enter_from_dou_plus", Boolean.FALSE);
    L33:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == false) goto L35;
        r101.put("if_dou", "1");
    L36:
        String r111 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        if ((!StringsKt.isBlank(r111)) == true) goto L40;
        r111 = null;
    L40:
        String r112 = "natural";
        if (r111 != null) goto L43;
        r111 = "natural";
    L43:
        r101.put("is_other_channel", r111);
        String r113 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        if ((!StringsKt.isBlank(r113)) == true) goto L47;
        r113 = null;
    L47:
        if (r113 == null) goto L50;
        r112 = r113;
    L50:
        r101.put(BdpAppEventConstant.PARAMS_IS_AD_CHANNEL, r112);
        r101.putAll(com.bytedance.android.live.openplatform.impl.base.utils.n.b());
        if (r102 == null) goto L67;
        String r114 = r102.b();
        if (r114 == null) goto L67;
        if (r114.length() <= 0) goto L57;
        boolean r115 = true;
    L58:
        if (r115 == true) goto L60;
    L62:
        r108 = false;
    L63:
        if (r108 == false) goto L65;
        r106 = r114;
    L65:
        if (r106 == null) goto L67;
        String r116 = r101.put(EventConstants.ExtraJson.KEY_DOWNLOAD_CLICK_ID_NATURE, r106);
        goto L67
    L60:
        if (r101.containsKey(DownloadConstants.KEY_EXTRA_CLICK_ID) == true) goto L62;
    L57:
        r115 = false;
    L67:
        AudienceMiniGameAppLogContextService r117 = (AudienceMiniGameAppLogContextService) getOpenPlatformContext().getService(AudienceMiniGameAppLogContextService.class);
        r101.putAll(r117.g());
        HashMap<String, String> r118 = r117.f();
        if (r118 == null) goto L70;
        r101.putAll(r118);
    L70:
        return r101;
    L35:
        r101.put("if_dou", "0");
        goto L36
    L31:
        r110 = null;
        goto L33
    L26:
        if (r107.intValue() != 2) goto L28;
        r101.put(BdpAppEventConstant.PARAMS_GAME_TYPE, "game_station");
        goto L28
    L21:
        if (r107.intValue() != 1) goto L23;
        r101.put(BdpAppEventConstant.PARAMS_GAME_TYPE, BdpAppEventConstant.MICRO_GAME);
        goto L28
    L16:
        r107 = null;
    L6:
        r104 = "";
        goto L7
    }

    public static void j(final AudienceLaunchMgContextService r100, final MountedMiniGameSource r101, final HashMap r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "source");
        final Function1 r103 = null;
        Function0<Unit> r104 = new AudienceLaunchMgContextService$openMiniGame$1(r100, r102, r101, r103);
        if (((IUserService) k.n(IUserService.class)).user().isLogin() == true) goto L5;
        com.bytedance.android.livesdk.user.f r105 = ((IUserService) k.n(IUserService.class)).user();
        Context r106 = r100.getOpenPlatformContext().getContext();
        l.a r107 = new l.a();
        r107.f158685a = s1.B(R.string.ttlive_core_login_dialog_message);
        r107.f158688d = "open_platform";
        r107.f158687c = -1;
        r100.autoDispose(r105.login(r106, new l(r107)).subscribe(new a(r100, r104), new b(r100)));
        return;
    L5:
        r104.invoke();
    }
}
