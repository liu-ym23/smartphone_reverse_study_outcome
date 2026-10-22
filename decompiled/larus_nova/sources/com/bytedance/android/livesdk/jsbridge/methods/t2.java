package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.core.app.NotificationManagerCompat;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.android.livesdkapi.live.NotificationSettingCallBack;
import com.bytedance.android.livesdkapi.live.UGDialoOnClickCallBack;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LivePlayNotifyIntegrateConfig;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openLiveNotificationPanel")
public final class t2 extends o<v2, OpenLiveNotificationPanelResultModel> implements UGDialoOnClickCallBack {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f142201b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Pair<v2, CallContext>> f142202a;

    public static final class a {
    }

    public static final class b implements NotificationSettingCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallContext f142203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f142204b;

        @Override // com.bytedance.android.livesdkapi.live.NotificationSettingCallBack
        public final void onFailure() {
        }

        public b(CallContext r100, Object r101) {
            this.f142203a = r100;
            this.f142204b = r101;
        }

        @Override // com.bytedance.android.livesdkapi.live.NotificationSettingCallBack
        public final void onSuccess(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "anchorId");
            JSONObject r102 = new JSONObject();
            r102.put("status", r101);     // Catch: Throwable -> L5
            this.f142203a.b("H5_setLiveNotificationStatus", r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Logger.e(th.getMessage());
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pair f142205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t2 f142206b;

        public c(Pair r100, t2 r101) {
            this.f142205a = r100;
            this.f142206b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f142206b.j((v2) this.f142205a.getFirst(), (CallContext) this.f142205a.getSecond());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public t2() {
        this.f142202a = new LinkedList();
    }

    @Override // com.bytedance.android.livesdkapi.live.UGDialoOnClickCallBack
    public final void onDialog(Boolean r100) {
        f142201b = false;
        IMiddlewareLiveService r101 = (IMiddlewareLiveService) jc1.k.f(IMiddlewareLiveService.class);
        if (r101 == null) goto L6;
        r101.unRegisterUgDialog(this);
    L6:
        if (this.f142202a.isEmpty() == false) goto L8;
        return;
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.booleanValue() == true) goto L12;
        return;
    L12:
        if (this.f142202a.isEmpty() == true) goto L17;
        Pair<v2, CallContext> r102 = this.f142202a.pop();
        ThreadUtils.a().postDelayed(new c(r102, this), 1000);
        goto L12
    }

    public static void k(String r100, String r101) {
        com.bytedance.android.livesdk.log.j0.l().sendLog("live_start_notice", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("event_author_name", r101), TuplesKt.to("event_author_id", r100), TuplesKt.to("enter_from_merge", "others_homepage")}), new Object[0]);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        v2 r102 = (v2) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
    L34:
        OpenLiveNotificationPanelResultModel r103 = new OpenLiveNotificationPanelResultModel();
        r103.a(OpenLiveNotificationPanelResultModel.Code.Failed);
        Unit r104 = Unit.INSTANCE;
        finishWithResult(r103);
        return;
    L4:
        if (LivePlayNotifyIntegrateConfig.enableLiveModifyDialogClose() == true) goto L10;
        NotificationSettingBottomDialog.a r105 = new NotificationSettingBottomDialog.a();     // Catch: Throwable -> L34
        r105.f122033b = r102.b();     // Catch: Throwable -> L34
        r105.f122032a = "others_homepage";     // Catch: Throwable -> L34
        Integer r106 = r102.a();     // Catch: Throwable -> L34
        if (r106 == null) goto L8;
        Long r107 = Long.valueOf(r106.intValue());     // Catch: Throwable -> L34
    L9:
        r105.f122034c = r107;     // Catch: Throwable -> L34
        NotificationSettingBottomDialog r108 = r105.a();     // Catch: Throwable -> L34
        r108.f122024m = new u2(r101);     // Catch: Throwable -> L34
        bn2.k.e(r101.getContext(), r108);     // Catch: Throwable -> L34
        return;
    L8:
        r107 = null;
        goto L9
    L10:
        Object r109 = r102.a();     // Catch: Throwable -> L34
        if (r109 != null) goto L14;
        r109 = 0L;     // Catch: Throwable -> L34
    L14:
        if (NotificationManagerCompat.from(r101.getContext()).areNotificationsEnabled() == false) goto L16;
    L32:
        j(r102, r101);     // Catch: Throwable -> L34
        return;
    L16:
        if (LivePlayNotifyIntegrateConfig.enableSubscribeUGDialog() == false) goto L32;
        if (Intrinsics.areEqual(r109, 3) == true) goto L22;
        if (Intrinsics.areEqual(r109, 2) == false) goto L32;
    L22:
        if (f142201b == true) goto L38;
        f142201b = true;     // Catch: Throwable -> L34
        String r110 = r102.b();     // Catch: Throwable -> L34
        if (r110 == null) goto L31;
        String r111 = r102.c();     // Catch: Throwable -> L34
        if (r111 == null) goto L31;
        IMiddlewareLiveService r112 = (IMiddlewareLiveService) jc1.k.f(IMiddlewareLiveService.class);     // Catch: Throwable -> L34
        if (r112 == null) goto L30;
        r112.registerUgDialog(this);     // Catch: Throwable -> L34
    L30:
        k(r110, r111);     // Catch: Throwable -> L34
    L31:
        this.f142202a.add(new Pair(r102, r101));     // Catch: Throwable -> L34
        return;
    }

    public final void j(v2 r110, CallContext r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Number r100 = r110.a();
        if (r100 != null) goto L5;
        r100 = 0L;
    L5:
        String r101 = r110.b();
        if (r101 == null) goto L12;
        ILiveService r102 = (ILiveService) jc1.k.f(ILiveService.class);
        if (r102 == null) goto L10;
        r102.notificationSettingModify(r111.getContext(), r101, com.bytedance.android.livesdk.dislike.x.a(r100.longValue()), "others_homepage", new b(r111, r100), !LivePlayNotifyIntegrateConfig.enableSubscribeUGDialog());
    L10:
        OpenLiveNotificationPanelResultModel r112 = new OpenLiveNotificationPanelResultModel();
        r112.a(OpenLiveNotificationPanelResultModel.Code.Success);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    }
}
