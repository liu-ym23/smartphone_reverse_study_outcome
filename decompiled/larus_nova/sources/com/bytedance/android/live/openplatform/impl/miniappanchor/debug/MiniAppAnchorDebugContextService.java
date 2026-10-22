package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.api.utils.h;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.debug.MiniAppDebugContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.launch.LaunchContextService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.message.model.wc;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0007\b\tB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/debug/MiniAppAnchorDebugContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/debug/MiniAppDebugContextService;", "Lcom/bytedance/android/live/broadcastgame/api/opengame/qrcode/IQRCodeService$b;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppAnchorDebugContextService extends MiniAppDebugContextService implements IQRCodeService.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f84349f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f84350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f84351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OpenPlatformDebugFloatBall f84352e;

    public static final class a {
    }

    public interface b {
        void onError(Throwable r100);

        void onSuccess(String r100);
    }

    public final class c extends ro0.b<wc> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MessageType f84353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ MiniAppAnchorDebugContextService f84354e;

        @Override // ro0.b
        public final MessageType a() {
            return this.f84353d;
        }

        public c(MiniAppAnchorDebugContextService r100) {
            this.f84354e = r100;
            int r101 = MiniAppAnchorDebugContextService.f84349f;
            super(r100.getOpenPlatformContext());
            this.f84353d = MessageType.INTERACT_OPEN_DEVELOP_MESSAGE;
        }

        @Override // ro0.b
        public final void b(tlc.d r110) {
            wc r111 = (wc) r110;
            Intrinsics.checkNotNullParameter(r111, "message");
            int r100 = qo0.a.f534145a;
            qo0.a.a("MiniAppAnchorDebugContextService", "收到调试 IM：\n" + r111);
            MiniAppAnchorDebugContextService r101 = this.f84354e;
            r101.f84351d = true;
            Disposable r102 = r101.f84350c;
            if (r102 == null) goto L5;
            r102.dispose();
        L5:
            MiniAppAnchorDebugContextService r103 = this.f84354e;
            r111.getClass();
            r103.getClass();
            if (this.f84354e.f(this.f538752b.getRoomId(), this.f84354e.f85015b, r111.G(), r111.H(), r111.E()) == false) goto L16;
            MiniAppAnchorDebugContextService r112 = this.f84354e;
            r112.getClass();
            int r104 = OpenPlatformDebugFloatBall.f84358b;
            Context r105 = r112.getOpenPlatformContext().getContext();
            OpenPlatformContext r106 = r112.getOpenPlatformContext();
            if (r106 == null) goto L15;
            ViewGroup r107 = ((AnchorMiniAppContext) r106).getContainerView();
            if (r107 == null) goto L13;
            Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r107, "rootView");
            Intrinsics.checkNotNullParameter(r112, "listener");
            OpenPlatformDebugFloatBall r108 = new OpenPlatformDebugFloatBall(r107, r105, r112);
            UtilityKotlinExtentionsKt.w(r108);
            Unit r109 = Unit.INSTANCE;
            r112.f84352e = r108;
            qo0.a.a("MiniAppAnchorDebugContextService", "执行 createDebugFloatBall()，显示调试悬浮球");
        L13:
            this.f84354e.k();
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext");
        L16:
            UtilityKotlinExtentionsKt.s(0, false, false, MiniAppAnchorDebugContextService$OpenDevelopMessageListener$onReceiveMessage$1.INSTANCE, 7);
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniAppAnchorDebugContextService f84355a;

        public d(MiniAppAnchorDebugContextService r100) {
            this.f84355a = r100;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.debug.MiniAppAnchorDebugContextService.b
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            f2.c(s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.debug.MiniAppAnchorDebugContextService.b
        public final void onSuccess(String r110) {
            Intrinsics.checkNotNullParameter(r110, "httpsLink");
            int r100 = qo0.a.f534145a;
            qo0.a.a("MiniAppAnchorDebugContextService", "访问短链，重定向后的 url : " + r110);
            MiniAppAnchorDebugContextService r101 = this.f84355a;
            int r102 = MiniAppAnchorDebugContextService.f84349f;
            r101.getClass();
            boolean r103 = false;
            if (r110.length() != 0) goto L5;
            boolean r104 = true;
        L7:
            if (r104 == true) goto L27;
            String r105 = UriProtector.parse(r110).getEncodedQuery();
            if (r105 != null) goto L12;
        L15:
            boolean r106 = true;
        L16:
            if (r106 == true) goto L27;
            String r111 = UriProtector.getQueryParameter(UriProtector.parse(r110), BdpAppEventConstant.PARAMS_TECH_TYPE);
            if (r111 == null) goto L21;
            Integer r112 = Integer.valueOf(CastIntegerProtector.parseInt(r111));
        L22:
            if (r112 == null) goto L27;
            if (r112.intValue() != 1) goto L27;
            String r113 = UriProtector.parse(AppConstants.SCHEME_SNSSDK + ((IHostContext) k.n(IHostContext.class)).appId() + "://live_open_platform?").buildUpon().appendQueryParameter("timor_schema", AppConstants.SCHEME_SNSSDK + ((IHostContext) k.n(IHostContext.class)).appId() + "://microapp?" + r105).appendQueryParameter("enter_from", "IDE").appendQueryParameter("open_type", "developer_debug").build().toString();
        L28:
            qo0.a.a("MiniAppAnchorDebugContextService", "url 适配为长链后 : " + r113);
            MiniAppAnchorDebugContextService r107 = this.f84355a;
            r107.getClass();
            if (r113.length() != 0) goto L31;
            boolean r108 = true;
        L32:
            if (r108 == true) goto L56;
            Uri r114 = UriProtector.parse(r113);
            String r109 = UriProtector.getQueryParameter(r114, "timor_schema");
            String r115 = UriProtector.getQueryParameter(r114, "open_type");
            String r116 = UriProtector.getQueryParameter(r114, "enter_from");
            if (r109 != null) goto L37;
        L40:
            boolean r117 = true;
        L41:
            if (r117 == true) goto L56;
            if (r115 != null) goto L44;
        L47:
            boolean r118 = true;
        L48:
            if (r118 == true) goto L56;
            if (r116 != null) goto L51;
        L52:
            r103 = true;
        L53:
            if (r103 == true) goto L56;
            int r119 = r107.i(r109);
        L57:
            r107.j(r119);
            qo0.a.a("MiniAppAnchorDebugContextService", "完成扫码校验，schema = " + this.f84355a.f85014a);
            return;
        L51:
            if (r116.length() != 0) goto L53;
        L44:
            if (r115.length() == 0) goto L47;
            r118 = false;
            goto L48
        L37:
            if (r109.length() == 0) goto L40;
            r117 = false;
        L56:
            r119 = 101;
            goto L57
        L31:
            r108 = false;
            goto L32
        L21:
            r112 = null;
            goto L22
        L12:
            if (r105.length() == 0) goto L15;
            r106 = false;
        L27:
            r113 = "";
            goto L28
        L5:
            r104 = false;
            goto L7
        }
    }

    static {
    }

    public final void k() {
        qo0.a.a("MiniAppAnchorDebugContextService", "执行 startDebug()");
        LaunchContextService.openMiniApp$default((LaunchContextService) getOpenPlatformContext().getService(LaunchContextService.class), this.f85014a, new ko0.b(LaunchParamConstant$Scene.f83955a, "scan", "anchor", null, null, null, null, null, null, false, false, null, 16376), null, 4, null);
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f84350c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f84350c = null;
        OpenPlatformDebugFloatBall r101 = this.f84352e;
        if (r101 == null) goto L15;
        OpenPlatformContext r102 = getOpenPlatformContext();
        if (r102 == null) goto L14;
        ViewGroup r103 = ((AnchorMiniAppContext) r102).getContainerView();
        if (r103 == null) goto L12;
        r103.removeView(r101);
    L12:
        UtilityKotlinExtentionsKt.t(r101);
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.context.AnchorMiniAppContext");
    L15:
        this.f84352e = null;
    }

    public MiniAppAnchorDebugContextService(OpenPlatformContext r100) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        super(r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService.b
    public final boolean b(int r100) {
        f2.c(s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
        int r101 = qo0.a.f534145a;
        qo0.a.b("MiniAppAnchorDebugContextService", "", new Throwable("扫码错误，errorType = " + r100));
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService.b
    public final boolean c(final String r100) {
        int r101 = qo0.a.f534145a;
        qo0.a.a("MiniAppAnchorDebugContextService", "扫码结果 : " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        f2.c(s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
    L15:
        return false;
    L12:
        if (h.d(r100) == false) goto L14;
        j(i(r100));
        goto L15
    L14:
        final d r103 = new d(this);
        ThreadPoolHelper.c().execute(new MiniAppAnchorDebugContextService$getDeepLink$1(r100, r103));
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        int r101 = qo0.a.f534145a;
        qo0.a.a("MiniAppAnchorDebugContextService", "增加调试参数，原 schema ：".concat(r100));
        SchemaInfo.b r102 = SchemaInfo.f83978s;
        r102.getClass();
        SchemaInfo r103 = SchemaInfo.b.b(r100);
        if (r103 != null) goto L5;
        return r100;
    L5:
        SchemaInfo.a r104 = new SchemaInfo.a(r100);
        String r105 = r103.a();
        if (r103.f83979a != SchemaInfo.Host.MICROAPP) goto L38;
        boolean r106 = Intrinsics.areEqual(r105, this.f85015b);
        boolean r107 = true;
        if ((!r106) == true) goto L38;
        SchemaInfo r108 = SchemaInfo.b.b(this.f85014a);
        if (r108 != null) goto L13;
        return r100;
    L13:
        SchemaInfo.VersionType r109 = (SchemaInfo.VersionType) r108.f83981c.getValue();
        Intrinsics.checkNotNullParameter(r109, "versionType");
        r104.f83997a.put("version_type", r109.name());
        JSONObject r110 = r108.f83992n;
        if (r110 != SchemaInfo.f83975p) goto L17;
        r107 = false;
    L17:
        if (r107 == true) goto L21;
        r110 = null;
    L21:
        if (r110 != null) goto L23;
        r110 = SchemaInfo.b.a(r102, r108.c(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT));
        r108.f83992n = r110;
    L23:
        if (r110 != null) goto L25;
        return r100;
    L25:
        Intrinsics.checkNotNullParameter(r110, AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT);
        r104.f83997a.put(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT, SchemaInfo.b.c(r110));
        String r111 = r108.c("ide_inspect_version");
        if (r111 != null) goto L28;
        return r100;
    L28:
        r104.e("ide_inspect_version", r111);
        String r112 = r108.c("ide_config");
        if (r112 != null) goto L31;
        return r100;
    L31:
        r104.e("ide_config", r112);
        SchemaInfo r113 = r104.c();
        if (r113 == null) goto L37;
        String r114 = r113.h();
        if (r114 == null) goto L37;
        r100 = r114;
    L37:
        qo0.a.a("MiniAppAnchorDebugContextService", "增加调试参数，增加参数后的 schema ：".concat(r100));
    L38:
        return r100;
    }

    public final int i(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return 101;
    L9:
        SchemaInfo.f83978s.getClass();
        SchemaInfo r102 = SchemaInfo.b.b(r100);
        if (r102 == null) goto L12;
        String r103 = r102.a();
    L13:
        String r104 = "";
        if ((!Intrinsics.areEqual(this.f85015b, "")) == true) goto L16;
    L24:
        return 102;
    L16:
        if (Intrinsics.areEqual(r103, this.f85015b) == false) goto L24;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f85014a = r100;
        SchemaInfo r105 = SchemaInfo.b.b(r100);
        if (r105 == null) goto L23;
        String r106 = r105.c("url");
        if (r106 == null) goto L23;
        r104 = r106;
    L23:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        return 1;
    L12:
        r103 = null;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public final void j(int r100) {
        if (r100 != 1) goto L5;
        k();
        return;
    L5:
        if (r100 == 102) goto L7;
        f2.c(s1.B(R.string.ttlive_open_game_debug_invalid_qrcode_error), 0);
        return;
    L7:
        f2.c(s1.B(R.string.ttlive_open_game_debug_appid_error), 0);
    }

    public static final void g(MiniAppAnchorDebugContextService r100, Context r101) {
        r100.getClass();
        x0.d r102 = new x0.d();
        r102.f162243b = r101;
        r102.f162242a = 4;
        r102.f162244c = "提示";
        r102.f162245d = "无法唤起调试工具, 请尝试重新开播";
        f r103 = f.f84366a;
        x0.c[] r104 = r102.f162248g;
        x0.c r105 = r104[0];
        if (r105 != null) goto L5;
        r105 = new x0.c();
        r104[0] = r105;
    L5:
        r105.f162239a = "确定";
        r105.f162240b = r103;
        x0.b.g(new x0(r102.f162243b, r102));
    }
}
