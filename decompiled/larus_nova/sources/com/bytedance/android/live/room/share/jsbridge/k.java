package com.bytedance.android.live.room.share.jsbridge;

import am2.x;
import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.q3;
import com.bytedance.android.livesdk.config.vh1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.tencent.open.SocialConstants;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "sharePanel")
public final class k extends com.bytedance.ies.web.jsbridge2.f<LiveWebShareParams, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y6.d f100301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f100302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CallContext f100303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f100304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f100305e;

    public class a extends com.bytedance.android.livesdk.user.h<IBaseUser> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f100306a;

        public a(k r100) {
            this.f100306a = r100;
        }

        @Override // com.bytedance.android.livesdk.user.h, io.reactivex.Observer
        public final void onNext(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
            k r102 = this.f100306a;
            r102.m(r102.f100304d);
        }
    }

    public class b extends SimpleShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Room f100307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f100308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f100309c;

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onFail(Throwable r100) {
            ALogger.e(ShareConstants.KEY_FROM_METHOD_SHARE_PANEL, r100);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onSuccess(String r110, String r111) {
            k.j(this.f100309c, this.f100307a.getId(), r110, this.f100307a.getLabels());
            k.k(this.f100309c, this.f100307a, r110, r111, "live", null);
            k.l(this.f100309c, r110, r111, this.f100308b);
        }

        public b(k r100, Room r101, Map r102) {
            this.f100309c = r100;
            this.f100307a = r101;
            this.f100308b = r102;
        }
    }

    public class c implements IShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Room f100310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f100311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f100312c;

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final boolean interceptReportAction(IShareParams r100) {
            return false;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final /* synthetic */ void onShareUiDismiss() {
            IShareCallback.CC.$default$onShareUiDismiss(this);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final /* synthetic */ void onShareUiShow() {
            IShareCallback.CC.$default$onShareUiShow(this);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onFail(Throwable r100) {
            ALogger.e(ShareConstants.KEY_FROM_METHOD_SHARE_PANEL, r100);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onSuccess(String r110, String r111) {
            k.j(this.f100312c, this.f100310a.getId(), r110, this.f100310a.getLabels());
            k.k(this.f100312c, this.f100310a, r110, r111, "live", null);
            k.l(this.f100312c, r110, r111, this.f100311b);
        }

        public c(k r100, Room r101, Map r102) {
            this.f100312c = r100;
            this.f100310a = r101;
            this.f100311b = r102;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f100302b;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f100301a = null;
    }

    public k(y6.d r100) {
        this.f100305e = new a(this);
        this.f100301a = r100;
    }

    public final void m(Map<String, String> r100) {
        if (r100 != null) goto L5;
        r100 = new HashMap();
    L5:
        Room r101 = o3.f().getCurrentRoom();
        com.bytedance.android.livesdk.log.filter.o r102 = j0.l().c(x.class);
        if (r102 == null) goto L8;
        r100.putAll(r102.getMap());
    L8:
        com.bytedance.android.livesdk.log.filter.o r103 = j0.l().c(Room.class);
        if (r102 == null) goto L11;
        r100.putAll(r103.getMap());
    L11:
        ShareParams.Builder r104 = ShareParams.buildUponRoom(r101).setLogV3Params(r100);
        if (r101 != null) goto L14;
    L16:
        boolean r105 = true;
    L17:
        ShareParams.Builder r106 = r104.setEnablePromotion(r105);
        if (r101 == null) goto L22;
        ALogger.d(ShareConstants.KEY_FROM_METHOD_SHARE_PANEL, "room not null,start build upon visibility param");
        MiddlewareRoomContext.a r107 = MiddlewareRoomContext.Companion;
        long r108 = r101.getRoomId();
        r107.getClass();
        MiddlewareRoomContext r109 = MiddlewareRoomContext.a.a(null, r108);
        if (r109 == null) goto L22;
        o0.a(r109, r106);
    L22:
        i81.a.C6239a r110 = new i81.a.C6239a();
        IShareCallback r111 = new b(this, r101, r100);
        if (vh1.f121451a.getValue().booleanValue() == false) goto L25;
        r111 = new c(this, r101, r100);
    L25:
        ILiveMiddlewareShareService r112 = (ILiveMiddlewareShareService) jc1.k.f(ILiveMiddlewareShareService.class);
        r110.f488564d = r106.build();
        r110.f488562b = (Activity) this.f100303c.getContext();
        r112.share(r110.a(), ShareConstants.KEY_FROM_METHOD_SHARE_PANEL, LiveShareType.SHARE_DIALOG, r111);
        finishWithSuccess();
        return;
    L14:
        if (r101.getStreamType() != LiveMode.MEDIA) goto L16;
        r105 = q3.f121027a.getValue().booleanValue();
        goto L17
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(LiveWebShareParams r110, CallContext r111) throws Exception {
        LiveWebShareParams r112 = r110;
        l r100 = new l(this);
        int r101 = UseReturnDataCallbackHandler.f100285c;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r100, "action");
        if (r112.getUseReturnData() == false) goto L5;
        LiveWebShareCallback r102 = new UseReturnDataCallbackHandler(r100);
    L6:
        this.f100303c = r111;
        Room r103 = o3.f().getCurrentRoom();
        HashMap<String, String> r104 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r105 = j0.l().c(x.class);
        if (r105 == null) goto L9;
        r104.putAll(r105.getMap());
    L9:
        com.bytedance.android.livesdk.log.filter.o r106 = j0.l().c(Room.class);
        if (r105 == null) goto L13;
        r104.putAll(r106.getMap());
    L13:
        if (r112.getLogParams() == null) goto L15;
        r104.putAll(r112.getLogParams());
    L15:
        HashMap<String, String> r107 = new HashMap();
        IMiddlewareUserService r108 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r108 == null) goto L22;
        com.bytedance.android.livesdk.user.e r109 = r108.user();
        if (r109 == null) goto L22;
        String r113 = r109.n();
        if (TextUtils.isEmpty(r113) == true) goto L22;
        r107.put("from_user_id", r113);
    L22:
        String r114 = r104.get("content_type");
        if (TextUtils.isEmpty(r114) == true) goto L26;
        r107.put("content_type", r114);
    L26:
        if (TextUtils.isEmpty(r112.getUrl()) == true) goto L43;
        this.f100301a.w1();
        String r115 = r112.getTitle();
        String r116 = r112.getDesc();
        String r117 = r112.getImage();
        String r118 = r112.getUrl();
        Intrinsics.checkNotNullParameter(r115, "title");
        Intrinsics.checkNotNullParameter(r116, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r117, "image");
        Intrinsics.checkNotNullParameter(r118, "url");
        if (TextUtils.isEmpty(r118) == true) goto L58;
        Uri.Builder r119 = UriProtector.parse(r118).buildUpon();
        r119.appendQueryParameter("share_ht_uid", ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().n());
        ShareParams.Builder r120 = ShareParams.builder().setTitle(r115).setDescription(r116).setImageUrl(r117).setUrl(r119.toString()).setLogV3Params(r104).setLogExtraParams(r104).setExtraParams(r107);
        if (r103 != null) goto L33;
    L35:
        boolean r121 = true;
    L36:
        ShareParams.Builder r122 = r120.setEnablePromotion(r121).setRoomIdWithChain(r112.getRoomId());
        if (TextUtils.isEmpty(r112.getPlatform()) == true) goto L39;
        LiveWebShareParams r123 = r112;
    L40:
        ShareParams.Builder r124 = r122.setLiveWebShareParams(r123);
        r124.getExtras().putString(ShareConstants.KEY_FROM_METHOD, ShareConstants.KEY_FROM_METHOD_SHARE_PANEL);
        i81.a.C6239a r125 = new i81.a.C6239a();
        ILiveMiddlewareShareService r126 = (ILiveMiddlewareShareService) jc1.k.f(ILiveMiddlewareShareService.class);
        r125.f488564d = r124.build();
        r125.f488562b = (Activity) r111.getContext();
        r126.share(r125.a(), ShareConstants.KEY_FROM_METHOD_SHARE_PANEL, LiveShareType.SHARE_DIALOG, new m(this, r102, r103, r112, r104));
        if (r112.getUseReturnData() == true) goto L53;
        finishWithSuccess();
        return;
    L53:
        return;
    L39:
        r123 = null;
        goto L40
    L33:
        if (r103.getStreamType() != LiveMode.MEDIA) goto L35;
        r121 = q3.f121027a.getValue().booleanValue();
        goto L36
    L58:
        return;
    L43:
        if (r103 != null) goto L45;
        finishWithFailure();
        return;
    L45:
        if (r112.getNeedLogin() == true) goto L47;
        m(r104);
        return;
    L47:
        if (((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().isLogin() == true) goto L49;
        this.f100304d = r104;
        ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().login(r111.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(this.f100305e);
        return;
    L49:
        m(r104);
        return;
    L5:
        r102 = new LiveWebShareCallback();
        goto L6
    }

    public static void j(k r100, long r101, String r110, String r111) {
        r100.getClass();
        int r102 = com.bytedance.android.live.room.share.util.d.b(r110);
        com.bytedance.android.live.room.q r112 = ((IMiddlewareRoomService) jc1.k.f(IMiddlewareRoomService.class)).roomInteractService();
        com.bytedance.android.livesdk.module.d r103 = (com.bytedance.android.livesdk.module.d) r112;
        r100.f100302b = r103.a(new j(), r101, r102, 1, r111);
    }

    public static void l(k r100, String r101, String r102, Map r103) {
        r100.getClass();
        HashMap r104 = new HashMap();
        if (r103 == null) goto L5;
        r104.putAll(r103);
    L5:
        r104.put("share_type", r102);
        r104.put("platform", r101);
        j0.l().sendLog("share_all_theme", r104, new Object[0]);
    }

    public static void k(k r100, Room r101, String r102, String r103, String r104, LiveWebShareParams r105) {
        r100.getClass();
        HashMap r106 = new HashMap();
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r102);
        r106.put("is_pyramid_sale", "0");
        r106.put("share_type", r103);
        if (r101 == null) goto L5;
        r106.put("log_pb", r101.getLog_pb());
    L5:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r104);
        if (r105 == null) goto L21;
        String r107 = r105.getCustomParams();
        HashMap r108 = new HashMap();
        if (TextUtils.isEmpty(r107) == true) goto L20;
        if (r101 != null) goto L24;
    L11:
        JSONObject r109 = new JSONObject(r107).optJSONObject("local_life_params");     // Catch: Exception -> L23
        if (r109 == null) goto L20;
        String r110 = r109.optString("share_info");     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r110) == true) goto L20;
        Map<String, String> r111 = ((ILiveMiddlewareShareService) jc1.k.f(ILiveMiddlewareShareService.class)).getLocalLifeShareParams(r110);     // Catch: Exception -> L23
        if (r111.isEmpty() == true) goto L20;
        r108.putAll(r111);     // Catch: Exception -> L23
        goto L20
    L24:
        r108.put("life_share_id", r101.lifeShareId);     // Catch: Exception -> L23
    L20:
        r106.putAll(r108);
    L21:
        j0 r112 = j0.l();
        x r113 = new x();
        r113.f4354f = "click";
        r113.f4350b = "H5";
        r112.sendLog("share", r106, new Object[]{r113, Room.class});
    }
}
