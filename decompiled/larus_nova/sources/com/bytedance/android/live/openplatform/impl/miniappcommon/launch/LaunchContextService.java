package com.bytedance.android.live.openplatform.impl.miniappcommon.launch;

import am2.n;
import am2.x;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.ContextServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.DownloadConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import ko0.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@ContextServiceImpl(audienceService = "com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService", liveAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.launch.LiveAnchorLaunchContextService", previewAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.launch.PreviewAnchorLaunchContextService")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J*\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/launch/LaunchContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "", "", PlayerResolution.SDKKEY.ORIGIN, "getMergedAdParams", "schema", "Lko0/b;", "launchParams", "Lkotlin/Function0;", "", "onSuccess", "openMiniApp", "getLaunchSchema", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LaunchContextService extends OpenPlatformContextService {
    public static final a Companion = null;
    public static final String TAG = "LaunchContextService";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LaunchContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
    }

    private final Map<String, String> getMergedAdParams(Map<String, String> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(r100);
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("aid", n.f().a());
        r102.put("cid", n.f().c());
        String r103 = n.f().d();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(new JSONObject(r103));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = null;
    L10:
        JSONObject r106 = (JSONObject) r105;
        Object r107 = "";
        if (r106 == null) goto L14;
        String r108 = r106.optString(DownloadConstants.KEY_EXTRA_CLICK_ID);
        if (r108 == null) goto L14;
    L15:
        r102.put(DownloadConstants.KEY_EXTRA_CLICK_ID, r108);
        r102.put("log_extra", r103);
        LinkedHashMap r109 = new LinkedHashMap();
        Iterator r110 = r102.entrySet().iterator();
    L17:
        if (r110.hasNext() == false) goto L21;
        Map.Entry r111 = (Map.Entry) r110.next();
        if (r2.a((String) r111.getValue()) == false) goto L17;
        r109.put(r111.getKey(), r111.getValue());
        goto L17
    L21:
        r101.putAll(r109);
        if (r101.isEmpty() == true) goto L24;
        LinkedHashMap r112 = new LinkedHashMap();
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L28
        Object r114 = Result.m9449constructorimpl(m.g(r101).toString());     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r114) == true) goto L34;
        r107 = r114;
    L34:
        r112.put("ad_params", r107);
        Iterator r115 = r101.entrySet().iterator();
    L36:
        if (r115.hasNext() == false) goto L53;
        Map.Entry r116 = (Map.Entry) r115.next();
        String r117 = (String) r116.getKey();
        int r118 = r117.hashCode();
        if (r118 != 96572) goto L40;
        if (r117.equals("aid") == false) goto L36;
        r112.put("aid", r116.getValue());
        r112.put(BdpAppEventConstant.PARAMS_ADID, r116.getValue());
        goto L36
    L40:
        if (r118 != 98494) goto L42;
        if (r117.equals("cid") == false) goto L36;
        r112.put("cid", r116.getValue());
        r112.put("creativeid", r116.getValue());
        goto L36
    L42:
        if (r118 != 860524707) goto L36;
        if (r117.equals(DownloadConstants.KEY_EXTRA_CLICK_ID) == false) goto L36;
        r112.put(DownloadConstants.KEY_EXTRA_CLICK_ID, r116.getValue());
        goto L36
    L53:
        return r112;
    L28:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L24:
        return MapsKt.emptyMap();
    L14:
        r108 = "";
    L5:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final String getLaunchSchema(String r100, b r110) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r110, "launchParams");
        SchemaInfo.f83978s.getClass();
        SchemaInfo r101 = SchemaInfo.b.b(r100);
        SchemaInfo.a r102 = new SchemaInfo.a(r100);
        r102.f(SchemaInfo.LaunchMode.HOST_STACK);
        String r103 = r110.f504345a;
        Intrinsics.checkNotNullParameter(r103, "scene");
        r102.f83997a.put("scene", r103);
        String r104 = r110.f504346b;
        Intrinsics.checkNotNullParameter(r104, "launchFrom");
        r102.b("launch_from", r104);
        String r105 = r110.f504347c;
        Intrinsics.checkNotNullParameter(r105, "location");
        r102.b("location", r105);
        r102.b("entrance_form", r110.f504348d);
        r102.b("enter_from_merge", r110.f504349e);
        r102.b(BdpAppEventConstant.PARAMS_ENTER_POSITION, r110.f504350f);
        r102.b("room_id", String.valueOf(getOpenPlatformContext().getRoomId()));
        String r106 = com.bytedance.android.live.openplatform.impl.base.utils.n.a();
        boolean r107 = false;
        if (r106.length() <= 0) goto L5;
        boolean r108 = true;
    L6:
        Object r109 = null;
        if (r108 == true) goto L10;
        r106 = null;
    L10:
        if (r106 != null) goto L12;
        r106 = "natural";
    L12:
        r102.b(BdpAppEventConstant.PARAMS_IS_AD_CHANNEL, r106);
        r102.b(BdpAppEventConstant.PARAMS_LIVE_ENTER_METHOD, l0.a("enter_method", u.l().c(x.class)));
        r102.b(BdpAppEventConstant.PARAMS_LIVE_ACTION_TYPE, l0.a("action_type", u.l().c(x.class)));
        Iterator<Map.Entry<String, String>> r111 = r110.f504351g.entrySet().iterator();
    L14:
        if (r111.hasNext() == false) goto L16;
        Map.Entry<String, String> r112 = r111.next();
        r102.b(r112.getKey(), r112.getValue());
        goto L14
    L16:
        int r113 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r113 != 0) goto L19;
        r102.b(BdpAppEventConstant.PARAMS_LIVE_CATEGORY, "single");
    L27:
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L29;
        r102.b(BdpAppEventConstant.PARAMS_IF_MP_LIVE_PROJECTION, "1");
    L29:
        String r114 = r110.f504352h;
        if (StringsKt.isBlank(r114) == false) goto L34;
        if (r101 == null) goto L33;
        r114 = r101.f();
        goto L34
    L33:
        r114 = null;
    L34:
        if (r114 == null) goto L64;
        if (r114.length() <= 0) goto L38;
        r107 = true;
    L38:
        if (r107 == true) goto L41;
        r114 = null;
    L41:
        if (r114 == null) goto L64;
        LinkedHashMap r115 = new LinkedHashMap();
        r115.put(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID, String.valueOf(getOpenPlatformContext().getRoomId()));
        r115.putAll(r110.f504353i);
        if (de0.f120026a.getValue().o() == true) goto L76;
    L58:
        if (r101 == null) goto L62;
        Map r116 = (Map) r101.f83988j.getValue();
        if (r116 == null) goto L62;
        r115.putAll(r116);
    L62:
        r102.h(r114, r115);
        goto L64
    L76:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L52
        Object r118 = r115.get("ad_params");     // Catch: Throwable -> L52
        if (r2.a((String) r118) == false) goto L47;
        r109 = r118;
    L47:
        String r119 = (String) r109;     // Catch: Throwable -> L52
        if (r119 != null) goto L50;
        r119 = SliceInitService.DEFAULT_SWITCH;
    L50:
        Object r120 = Result.m9449constructorimpl(m.h(new JSONObject(r119)));     // Catch: Throwable -> L52
    L54:
        LinkedHashMap r121 = new LinkedHashMap();
        if (Result.m9455isFailureimpl(r120) == false) goto L57;
        r120 = r121;
    L57:
        r115.putAll(getMergedAdParams((Map) r120));
    L52:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L64:
        if (r110.f504356l == false) goto L66;
        r102.e("forceColdBoot", "1");
    L66:
        Iterator<Map.Entry<String, String>> r123 = r110.f504354j.entrySet().iterator();
    L68:
        if (r123.hasNext() == false) goto L70;
        Map.Entry<String, String> r124 = r123.next();
        r102.e(r124.getKey(), r124.getValue());
        goto L68
    L70:
        SchemaInfo r125 = r102.c();
        if (r125 == null) goto L74;
        String r126 = r125.h();
        if (r126 == null) goto L74;
        return r126;
    L74:
        return "";
    L19:
        if (r113 != 8) goto L21;
        r102.b(BdpAppEventConstant.PARAMS_LIVE_CATEGORY, "1v6");
        goto L27
    L21:
        if (r113 != 12) goto L27;
        r102.b(BdpAppEventConstant.PARAMS_LIVE_CATEGORY, "party");
        goto L27
    L5:
        r108 = false;
        goto L6
    }

    public void openMiniApp(String r100, b r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "launchParams");
        ((CommonLaunchContextService) getOpenPlatformContext().getService(CommonLaunchContextService.class)).openMicroApp(getLaunchSchema(r100, r101), null, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openMiniApp$default(LaunchContextService r100, String r101, b r102, Function0 r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        r100.openMiniApp(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMiniApp");
    }
}
