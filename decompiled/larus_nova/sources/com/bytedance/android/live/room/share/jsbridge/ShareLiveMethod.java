package com.bytedance.android.live.room.share.jsbridge;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.screenrotation.api.IMiddlewareScreenRotateService;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener;
import com.bytedance.android.livehostapi.business.depend.share.LiveAnnouncementShareConfig;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.q3;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j40.a1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.k6;
import w20.se;

/* JADX INFO: loaded from: classes47.dex */
public final class ShareLiveMethod extends k6<se, ShareLiveResultModel> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f100264i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f100265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CallContext f100266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Room f100267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f100268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f100269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveAnnouncementShareConfig f100270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<String, String> f100271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f100272h;

    public static final class a {
    }

    public static final class b extends SimpleShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLiveMethod f100273a;

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback
        public final void onChannelShare(String r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            this.f100273a.l().onChannelShare(r100);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onFail(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f100273a.l().onFail(r100);
            ALogger.e("ShareLiveMethod", r100);
        }

        public b(ShareLiveMethod r100, ShareParams.Builder r101) {
            this.f100273a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onSuccess(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "shareType");
            onSuccessWithExtra(r100, r101, null);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallbackWithExtra
        public final void onSuccessWithExtra(String r100, String r110, Map<String, ? extends List<String>> r111) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r110, "shareType");
            this.f100273a.l().onSuccessWithExtra(r100, r110, r111);
            if (com.bytedance.android.live.room.share.util.d.a(r100, r111) == false) goto L5;
            return;
        L5:
            ShareLiveMethod r101 = this.f100273a;
            Room r102 = r101.f100267c;
            List<String> r103 = null;
            if (r102 == null) goto L8;
            Long r104 = Long.valueOf(r102.getRoomId());
        L9:
            Room r105 = this.f100273a.f100267c;
            if (r105 != null) goto L12;
            String r106 = "";
        L15:
            ShareLiveMethod.k(r101, r104, r100, 1, r106);
            ShareLiveMethod r107 = this.f100273a;
            if (r107.f100269e == true) goto L18;
            ShareLiveMethod.j(r107, r107.f100267c, r100, r110, r107.f100268d);
            return;
        L18:
            if (r107.f100270f == null) goto L47;
            HashMap r112 = new HashMap();
            HashMap<String, String> r108 = r107.f100271g;
            if (r108 == null) goto L23;
            r112.putAll(r108);
        L23:
            r112.put("platform", r100);
            if (r111 == null) goto L33;
            List<String> r109 = r111.get("to_user_ids");
            if (r109 == null) goto L33;
            if ((!r109.isEmpty()) == true) goto L31;
            r109 = null;
        L31:
            if (r109 == null) goto L33;
            r112.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r109.toString());
            r112.put("to_user_cnt", String.valueOf(r109.size()));
            r112.put("platform", "single_chat");
            j0.l().sendLog("livesdk_prelive_share_success", r112, new Object[0]);
        L33:
            if (r111 == null) goto L43;
            List<String> r113 = r111.get("conversation_ids");
            if (r113 != null) goto L37;
            return;
        L37:
            if ((true ^ r113.isEmpty()) == false) goto L39;
            r103 = r113;
        L39:
            if (r103 == null) goto L45;
            r112.remove(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID);
            r112.remove("to_user_cnt");
            r112.put("chat_group_id", r103.toString());
            r112.put("platform", "group_chat");
            j0.l().sendLog("livesdk_prelive_share_success", r112, new Object[0]);
            return;
        L45:
            return;
        L43:
            return;
        L47:
            return;
        L12:
            if (r105 == null) goto L14;
            r106 = r105.getLabels();
            goto L15
        L14:
            r106 = null;
            goto L15
        L8:
            r104 = null;
            goto L9
        }
    }

    public static final class c implements IShareDialogListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLiveMethod f100274a;

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener
        public final void onShareDialogShow() {
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener
        public final void onShareDialogDismiss() {
            this.f100274a.l().onDialogDismiss();
        }

        public c(ShareLiveMethod r100) {
            this.f100274a = r100;
        }
    }

    public static final class d extends LiveWebShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLiveMethod f100275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveWebShareParams f100276b;

        @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
        public final void onRefresh() {
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
        public final void onDialogDismiss() {
            this.f100275a.l().onDialogDismiss();
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
        public final void onPreShare() {
            UseReturnDataCallbackHandler r100 = this.f100275a.l();
            r100.getClass();
            r100.f100286a = UseReturnDataCallbackHandler.SelectType.IM_USER_ING;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback, com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback
        public final void onChannelShare(String r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            this.f100275a.l().onChannelShare(r100);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback
        public final void onContactSelect(boolean r100) {
            this.f100275a.l().onContactSelect(r100);
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onFail(Throwable r100) {
            this.f100275a.l().onFail(r100);
            ALogger.e("ShareLiveMethod", r100);
        }

        public d(ShareLiveMethod r100, LiveWebShareParams r101) {
            this.f100275a = r100;
            this.f100276b = r101;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onSuccess(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "shareType");
            this.f100275a.l().onSuccess(r100, r101);
            if ((!Intrinsics.areEqual(r100, "chat_merge")) == false) goto L19;
            ShareLiveMethod r102 = this.f100275a;
            String r103 = null;
            if (this.f100276b.isLiveShare() == false) goto L10;
            Room r104 = this.f100275a.f100267c;
            if (r104 == null) goto L9;
            long r105 = r104.getRoomId();
        L11:
            Long r106 = Long.valueOf(r105);
        L12:
            Room r107 = this.f100275a.f100267c;
            if (r107 != null) goto L15;
            r103 = "";
        L17:
            ShareLiveMethod.k(r102, r106, r100, 1, r103);
            ShareLiveMethod r108 = this.f100275a;
            ShareLiveMethod.j(r108, r108.f100267c, r100, r101, r108.f100268d);
            return;
        L15:
            if (r107 == null) goto L17;
            r103 = r107.getLabels();
            goto L17
        L9:
            r106 = null;
            goto L12
        L10:
            r105 = 0;
            goto L11
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallbackWithExtra
        public final void onSuccessWithExtra(String r100, String r101, Map<String, ? extends List<String>> r102) {
            Intrinsics.checkNotNullParameter(r100, "platform");
            Intrinsics.checkNotNullParameter(r101, "shareType");
            this.f100275a.l().onSuccessWithExtra(r100, r101, r102);
            if (com.bytedance.android.live.room.share.util.d.a(r100, r102) == false) goto L5;
            return;
        L5:
            ShareLiveMethod r103 = this.f100275a;
            String r104 = null;
            if (this.f100276b.isLiveShare() == false) goto L11;
            Room r105 = this.f100275a.f100267c;
            if (r105 == null) goto L10;
            long r106 = r105.getRoomId();
        L12:
            Long r107 = Long.valueOf(r106);
        L13:
            Room r108 = this.f100275a.f100267c;
            if (r108 != null) goto L16;
            r104 = "";
        L18:
            ShareLiveMethod.k(r103, r107, r100, 1, r104);
            ShareLiveMethod r109 = this.f100275a;
            ShareLiveMethod.j(r109, r109.f100267c, r100, r101, r109.f100268d);
            return;
        L16:
            if (r108 == null) goto L18;
            r104 = r108.getLabels();
            goto L18
        L10:
            r107 = null;
            goto L13
        L11:
            r106 = 0;
            goto L12
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLiveMethod f100277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveWebShareParams f100278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ShareParams.Builder f100279c;

        public e(ShareLiveMethod r100, LiveWebShareParams r101, ShareParams.Builder r102) {
            this.f100277a = r100;
            this.f100278b = r101;
            this.f100279c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
            this.f100277a.m(this.f100278b.getNeedPoster(), this.f100279c);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareLiveMethod f100280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveWebShareParams f100281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ShareParams.Builder f100282c;

        public f(ShareLiveMethod r100, LiveWebShareParams r101, ShareParams.Builder r102) {
            this.f100280a = r100;
            this.f100281b = r101;
            this.f100282c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
            this.f100280a.m(this.f100281b.getNeedPoster(), this.f100282c);
        }
    }

    static {
    }

    public final UseReturnDataCallbackHandler l() {
        return (UseReturnDataCallbackHandler) this.f100272h.getValue();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f100265a;
        if (r100 == null) goto L7;
        if (r100 == null) goto L8;
        r100.dispose();
        return;
    L8:
        return;
    }

    public ShareLiveMethod() {
        this.f100266b = getCallContext();
        this.f100268d = "";
        this.f100272h = LazyKt.lazy(new ShareLiveMethod$useReturnDataCallbackHandler$2(this));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r310, CallContext r311) {
        se r100 = (se) r310;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r311, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f100266b = r311;
        LiveWebShareParams r101 = (LiveWebShareParams) JsonUtil.parse(String.valueOf(r100.a()), LiveWebShareParams.class);
        Integer r102 = null;
        if (r101 != null) goto L5;
    L11:
        if (r101 == null) goto L13;
        boolean r103 = r101.isPreLive();
    L14:
        this.f100269e = r103;
        if (r101 == null) goto L17;
        r101.setUseReturnData(true);
    L17:
        if (r101 == null) goto L19;
        r101.setHybridView(r311.f249269d);
    L19:
        Room r104 = o3.f().getCurrentRoom();
        if ((r104 instanceof Room) == true) goto L22;
        r104 = null;
    L22:
        this.f100267c = r104;
        ShareParams.Builder r105 = ShareParams.builder();
        if (r101 == null) goto L32;
        String r106 = r101.getUrlExtra();
        if (r106 == null) goto L32;
        if (r2.a(r106) == true) goto L30;
        r106 = null;
    L30:
        if (r106 == null) goto L32;
        Map<String, String> r107 = JsonUtil.jsonObjectToMap(new JSONObject(r106));
    L33:
        long r108 = 0;
        if (r101 != null) goto L36;
    L76:
        if (r101 != null) goto L78;
    L101:
        this.f100268d = "URL";
        if (r101 == null) goto L104;
        String r109 = r101.getUrl();
    L105:
        Uri.Builder r110 = UriProtector.parse(String.valueOf(r109)).buildUpon();
        if (r101 == null) goto L108;
        String r111 = r101.getUrl();
    L109:
        p(r110, r111, r107);
        ShareParams.Builder r112 = ShareParams.builder();
        if (r101 == null) goto L112;
        String r113 = r101.getTitle();
    L113:
        ShareParams.Builder r114 = r112.setTitle(String.valueOf(r113));
        if (r101 == null) goto L116;
        String r115 = r101.getDesc();
    L117:
        ShareParams.Builder r116 = r114.setDescription(String.valueOf(r115));
        if (r101 == null) goto L120;
        String r117 = r101.getImage();
    L121:
        ShareParams.Builder r118 = r116.setImageUrl(String.valueOf(r117));
        if (r110 == null) goto L124;
        String r119 = r110.toString();
    L125:
        ShareParams.Builder r120 = r118.setUrl(r119);
        if (r101 != null) goto L128;
    L130:
        boolean r121 = false;
    L131:
        ShareParams.Builder r122 = r120.setIsHalfScreen(r121);
        if (r101 != null) goto L134;
    L136:
        boolean r123 = false;
    L137:
        r105 = r122.setHideDim(r123);
    L138:
        a1 r124 = a1.f497165a;
        if (r124.getValue().p() == false) goto L141;
    L144:
        boolean r125 = true;
    L145:
        if (r125 == false) goto L147;
        r105.setEnableLandscapeOpt(true);
    L147:
        Room r126 = this.f100267c;
        if (r126 != null) goto L150;
    L152:
        if (r125 == false) goto L159;
        Context r127 = this.f100266b.getContext();
        if ((r127 instanceof Activity) == true) goto L157;
        r127 = null;
    L157:
        if (e5.g((Activity) r127) == false) goto L159;
        r105.setEnableMatchRoomDialogAnim(true);
    L159:
        if (r101 == null) goto L161;
        r102 = r101.getLiveShareType();
    L161:
        int r128 = ShareLiveMethodType.SHARE_DIALOG.getValue();
        if (r102 != null) goto L165;
    L167:
        int r129 = ShareLiveMethodType.CHAT_DIALOG.getValue();
        if (r102 != null) goto L171;
    L183:
        int r130 = ShareLiveMethodType.THIRD_DIALOG.getValue();
        if (r102 != null) goto L187;
    L202:
        if (r101 == null) goto L213;
        o(r101, r105);
        return;
    L213:
        return;
    L187:
        if (r102.intValue() != r130) goto L202;
        if (TextUtils.isEmpty(r101.getPlatform()) == false) goto L191;
        l().onFail(new Throwable("platform is null"));
        return;
    L191:
        ILiveMiddlewareShareService r131 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        ShareParams.Builder r132 = r105.setPlatform(r101.getPlatform()).setIsHalfScreen(r101.isHalfScreen());
        if (r101.getRoomId() != 0) goto L196;
        Room r133 = this.f100267c;
        if (r133 == null) goto L197;
        r108 = r133.getRoomId();
    L197:
        ShareParams r134 = r132.setRoomIdWithChain(r108).build();
        Context r135 = this.f100266b.getContext();
        if (r135 == null) goto L201;
        r131.share(new i81.a(null, (Activity) r135, null, r134, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIRECT, new h(this, r101));
        return;
    L201:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L196:
        r108 = r101.getRoomId();
        goto L197
    L171:
        if (r102.intValue() != r129) goto L183;
        ILiveMiddlewareShareService r136 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        ShareParams.Builder r137 = r105.setPlatform("chat_merge").setIsHalfScreen(r101.isHalfScreen());
        if (r101.getRoomId() != 0) goto L177;
        Room r138 = this.f100267c;
        if (r138 == null) goto L178;
        r108 = r138.getRoomId();
    L178:
        ShareParams r139 = r137.setRoomIdWithChain(r108).build();
        Context r140 = this.f100266b.getContext();
        if (r140 == null) goto L182;
        r136.share(new i81.a(null, (Activity) r140, null, r139, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIRECT, new g(this, r101));
        return;
    L182:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L177:
        r108 = r101.getRoomId();
        goto L178
    L165:
        if (r102.intValue() != r128) goto L167;
        o(r101, r105);
        return;
    L150:
        if (r126.isReplay != true) goto L152;
        r105.setEnableLandscapePlayerOpt(true);
        goto L152
    L141:
        if (r124.getValue().o() == true) goto L144;
        r125 = false;
        goto L145
    L134:
        if (r101.getHideDim() != true) goto L136;
        r123 = true;
        goto L137
    L128:
        if (r101.isHalfScreen() != true) goto L130;
        r121 = true;
        goto L131
    L124:
        r119 = null;
        goto L125
    L120:
        r117 = null;
        goto L121
    L116:
        r115 = null;
        goto L117
    L112:
        r113 = null;
        goto L113
    L108:
        r111 = null;
        goto L109
    L104:
        r109 = null;
        goto L105
    L78:
        if (r101.isLiveShare() != true) goto L101;
        this.f100268d = "live";
        HashMap r141 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r142 = j0.l().c(x.class);
        if (r142 == null) goto L82;
        r141.putAll(r142.getMap());
    L82:
        com.bytedance.android.livesdk.log.filter.o r143 = j0.l().c(Room.class);
        if (r142 == null) goto L85;
        r141.putAll(r143.getMap());
    L85:
        Room r144 = this.f100267c;
        if (r144 == null) goto L88;
        String r145 = r144.getShareUrl();
    L89:
        Uri.Builder r146 = UriProtector.parse(String.valueOf(r145)).buildUpon();
        Room r147 = this.f100267c;
        if (r147 == null) goto L92;
        String r148 = r147.getShareUrl();
    L93:
        p(r146, r148, r107);
        Room r149 = this.f100267c;
        if (r149 != null) goto L96;
        l().onFail(new Throwable("room is null"));
        return;
    L96:
        ShareParams.Builder r150 = ShareParams.buildUponRoom(r149).setLogV3Params(r141);
        if (r146 == null) goto L99;
        String r151 = r146.toString();
    L100:
        r105 = r150.setUrl(r151);
        goto L138
    L99:
        r151 = null;
        goto L100
    L92:
        r148 = null;
        goto L93
    L88:
        r145 = null;
        goto L89
    L36:
        if (r101.isPreLive() != true) goto L76;
        HashMap<String, Object> r152 = r101.getShareExtraParams();
        if (r152 == null) goto L42;
        Object r153 = r152.get("announcement");
        if (r153 == null) goto L42;
        String r154 = r153.toString();
    L43:
        HashMap<String, Object> r155 = r101.getShareExtraParams();
        if (r155 == null) goto L51;
        Object r156 = r155.get("im_info");
        if (r156 == null) goto L51;
        String r157 = r156.toString();
        if (r157 == null) goto L51;
        String r158 = r157;
    L52:
        this.f100271g = r101.getTrackParams();
        ALogger.d("announce_im_info", r158);
        if (r154 != null) goto L55;
    L72:
        ShareParams.Builder r159 = null;
    L73:
        if (r159 == null) goto L75;
        r105 = r159;
        goto L138
    L75:
        finishWithFailure();
        goto L138
    L55:
        if ((!StringsKt.isBlank(r154)) == false) goto L57;
        String r160 = r154;
    L58:
        if (r160 == null) goto L72;
        LiveAnnouncementShareConfig r161 = (LiveAnnouncementShareConfig) JsonUtil.parseObject(r160, LiveAnnouncementShareConfig.class);     // Catch: JsonParseException -> L61
    L63:
        if (r161 == null) goto L72;
        this.f100270f = r161;
        ImageModel r162 = new ImageModel("", CollectionsKt.listOf(r161.getAvatarUrl()));
        User r163 = new User();
        r163.setIdStr(r161.anchorIdStr());
        r163.setIdString(String.valueOf(r161.getAnchorId()));
        r163.setAvatarThumbKt(r162);
        r163._avatarMedium = r162;
        r163._avatarLarge = r162;
        ShareParams.Builder r164 = ShareParams.buildUponUser(r163).setShareSubScene(ShareSubScene.LiveAnnouncement);
        HashMap<String, String> r165 = new HashMap();
        r165.put("announcement", r154);
        r165.put("bitmap_compress_format", String.valueOf(Bitmap.CompressFormat.PNG.ordinal()));
        if ((!StringsKt.isBlank(r158)) == false) goto L67;
        r165.put("im_info", r158);
    L67:
        Unit r166 = Unit.INSTANCE;
        r159 = r164.setExtraParams(r165).setLogExtraParams(this.f100271g);
        if (r159 == null) goto L70;
        r159.setShareScene(ShareScene.PRE_LIVE);
    L70:
        if (r159 == null) goto L73;
        r159.setRoomId(0);
    L61:
        e = move-exception;
        finishWithFailure(e);
        r161 = null;
        goto L63
    L57:
        r160 = null;
    L51:
        r158 = "";
    L42:
        r154 = null;
    L32:
        r107 = null;
        goto L33
    L13:
        r103 = false;
        goto L14
    L5:
        if (r101.getUgShare() != true) goto L11;
        Context r167 = r311.getContext();
        ILiveMiddlewareShareService r168 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        Intrinsics.checkNotNullParameter(r167, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.live.room.share.jsbridge.e r169 = new com.bytedance.android.live.room.share.jsbridge.e(this);
        JsonObject r170 = r100.a();
        if (r170 == null) goto L9;
        JSONObject r210 = tv5.a.c(r170);
    L10:
        r168.share(new i81.a(r167, null, null, null, null, null, null, null, null, null, null, Boolean.FALSE, null, r210, r169, null, false), "ShareLiveMethod", LiveShareType.SHARE_JSB, null);
        return;
    L9:
        r210 = new JSONObject(String.valueOf(r100.a()));
        goto L10
    }

    public final void m(boolean r210, ShareParams.Builder r211) {
        Room r100 = this.f100267c;
        Context r101 = null;
        if (r100 == null) goto L5;
        LiveMode r102 = r100.getStreamType();
    L7:
        if (r102 != LiveMode.MEDIA) goto L9;
        Boolean r103 = q3.f121027a.getValue();
    L10:
        ShareParams.Builder r104 = r211.setEnablePromotion(r103.booleanValue()).setShareDialogListener(new c(this));
        Room r105 = this.f100267c;
        if (r105 == null) goto L15;
        ALogger.d("ShareLiveMethod", "room not null,start build upon visibility param");
        MiddlewareRoomContext.a r106 = MiddlewareRoomContext.Companion;
        long r107 = Long.valueOf(r105.getRoomId()).longValue();
        r106.getClass();
        MiddlewareRoomContext r108 = MiddlewareRoomContext.a.a(null, r107);
        if (r108 == null) goto L15;
        o0.a(r108, r104);
    L15:
        ILiveMiddlewareShareService r109 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        ShareParams r110 = r104.build();
        Context r111 = this.f100266b.getContext();
        if ((r111 instanceof Activity) == false) goto L19;
        r101 = r111;
    L19:
        r109.share(new i81.a(null, (Activity) r101, null, r110, null, null, null, null, null, null, null, Boolean.valueOf(r210), null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIALOG, new b(this, r211));
        return;
    L9:
        r103 = Boolean.TRUE;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public final void n(LiveWebShareParams r210, ShareParams.Builder r211) {
        ILiveMiddlewareShareService r100 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        LiveMode r101 = null;
        if (r210 == null) goto L5;
        String r102 = r210.getTitle();
    L6:
        ShareParams.Builder r103 = r211.setTitle(String.valueOf(r102));
        if (r210 == null) goto L9;
        String r104 = r210.getDesc();
    L10:
        ShareParams.Builder r105 = r103.setDescription(String.valueOf(r104));
        if (r210 == null) goto L13;
        String r106 = r210.getImage();
    L14:
        ShareParams.Builder r107 = r105.setImageUrl(String.valueOf(r106));
        Room r108 = this.f100267c;
        if (r108 == null) goto L18;
        r101 = r108.getStreamType();
    L18:
        if (r101 != LiveMode.MEDIA) goto L20;
        Boolean r109 = q3.f121027a.getValue();
    L21:
        ShareParams.Builder r110 = r107.setEnablePromotion(r109.booleanValue()).setRoomIdWithChain(r210.getRoomId());
        r210.setTitle(String.valueOf(r210.getTitle()));
        r210.setDesc(String.valueOf(r210.getDesc()));
        r210.setImage(String.valueOf(r210.getImage()));
        Unit r111 = Unit.INSTANCE;
        ShareParams r112 = r110.setLiveWebShareParams(r210).build();
        Context r113 = this.f100266b.getContext();
        if (r113 == null) goto L26;
        r100.share(new i81.a(null, (Activity) r113, null, r112, null, null, null, null, null, null, null, Boolean.valueOf(r210.getNeedPoster()), null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIALOG, new d(this, r210));
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L20:
        r109 = Boolean.TRUE;
        goto L21
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void o(LiveWebShareParams r100, ShareParams.Builder r101) {
        if (r100.isPreLive() == false) goto L12;
        if (r100.getNeedLogin() == true) goto L7;
    L9:
        m(r100.getNeedPoster(), r101);
        return;
    L7:
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isLogin() == true) goto L9;
        ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().login(this.f100266b.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(new e(this, r100, r101));
        return;
    L12:
        if (r100.isLiveShare() == true) goto L25;
        if (TextUtils.isEmpty(r100.getUrl()) == true) goto L25;
        IMiddlewareScreenRotateService r102 = (IMiddlewareScreenRotateService) jc1.k.f(IMiddlewareScreenRotateService.class);
        if (r102 == null) goto L23;
        Context r103 = this.f100266b.getContext();
        if ((r103 instanceof Activity) == true) goto L21;
        r103 = null;
    L21:
        if (e5.g((Activity) r103) == false) goto L23;
        r102.rotation().b(com.bytedance.android.live.room.api.screenrotation.rotate.f.b.f99141a, new ShareLiveMethod$shareDialog$2(this, r100, r101));
        return;
    L23:
        n(r100, r101);
        return;
    L25:
        if (this.f100267c != null) goto L27;
        finishWithFailure();
        return;
    L27:
        if (r100.getNeedLogin() == true) goto L29;
    L31:
        m(r100.getNeedPoster(), r101);
        return;
    L29:
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isLogin() == true) goto L31;
        ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().login(this.f100266b.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(new f(this, r100, r101));
    }

    public static void p(Uri.Builder r100, String r101, Map r102) {
        if (r100 == null) goto L10;
        IMiddlewareUserService r103 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r103 == null) goto L8;
        com.bytedance.android.livesdk.user.e r104 = r103.user();
        if (r104 == null) goto L8;
        String r105 = r104.n();
    L9:
        r100.appendQueryParameter("share_ht_uid", r105);
    L8:
        r105 = null;
    L10:
        if (r101 == null) goto L18;
        if (r102 == null) goto L24;
        Iterator r106 = r102.entrySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L25;
        Map.Entry r107 = (Map.Entry) r106.next();
        if (r100 == null) goto L14;
        r100.appendQueryParameter((String) r107.getKey(), (String) r107.getValue());
        goto L14
    L25:
        return;
    L24:
        return;
    }

    public static final void j(ShareLiveMethod r100, Room r101, String r102, String r103, String r104) {
        r100.getClass();
        HashMap r105 = new HashMap();
        r105.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r102);
        r105.put("is_pyramid_sale", "0");
        r105.put("share_type", r103);
        if (r101 == null) goto L5;
        r105.put("log_pb", r101.getLog_pb());
    L5:
        r105.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r104);
        j0 r106 = j0.l();
        x r107 = new x();
        r107.f4354f = "click";
        r107.f4350b = "H5";
        r106.sendLog("share", r105, new Object[]{r107, Room.class});
    }

    public static final void k(ShareLiveMethod r100, Long r101, String r102, Integer r110, String r111) {
        r100.getClass();
        int r103 = com.bytedance.android.live.room.share.util.d.b(r102);
        IService r104 = jc1.k.f(IMiddlewareRoomService.class);
        Intrinsics.checkNotNull(r104);
        com.bytedance.android.live.room.q r105 = ((IMiddlewareRoomService) r104).roomInteractService();
        com.bytedance.android.live.room.share.jsbridge.f r106 = com.bytedance.android.live.room.share.jsbridge.f.f100294a;
        Intrinsics.checkNotNull(r101);
        long r107 = r101.longValue();
        Intrinsics.checkNotNull(r110);
        com.bytedance.android.livesdk.module.d r108 = (com.bytedance.android.livesdk.module.d) r105;
        r100.f100265a = r108.a(r106, r107, r103, r110.intValue(), r111);
    }
}
