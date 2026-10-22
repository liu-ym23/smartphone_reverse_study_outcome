package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastAnnounceService;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdkapi.announcement.AnnounceChoosePage;
import com.bytedance.android.livesdkapi.announcement.AnnounceCommand;
import com.bytedance.android.livesdkapi.announcement.AnnounceCommandCallback;
import com.bytedance.android.livesdkapi.announcement.AnnounceSettingPage;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceBaseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceChooseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceSettingConfig;
import com.bytedance.android.livesdkapi.announcement.OpenSharePanelConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoRef;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openTimeSchedule")
public final class j9 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f63479b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/j9$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "enterFrom", "b", "", "enterFromType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "style", "I", "e", "()I", "enablePublishVideo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "extra", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("enable_publish_video")
        private final int enablePublishVideo;

        @SerializedName("enter_from")
        private final String enterFrom;

        @SerializedName("enter_from_type")
        private final Integer enterFromType;

        @SerializedName("extra")
        private final Map<String, String> extra;

        @SerializedName("style")
        private final int style;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L18;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.enterFromType, r101.enterFromType) == true) goto L12;
            return false;
        L12:
            if (this.style == r101.style) goto L14;
            return false;
        L14:
            if (this.enablePublishVideo == r101.enablePublishVideo) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.enterFrom;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.enterFromType;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (((((r106 + r108) * 31) + this.style) * 31) + this.enablePublishVideo) * 31;
            Map<String, String> r110 = this.extra;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Param(type=" + this.type + ", enterFrom=" + this.enterFrom + ", enterFromType=" + this.enterFromType + ", style=" + this.style + ", enablePublishVideo=" + this.enablePublishVideo + ", extra=" + this.extra + ")";
        }

        public final int a() {
            return this.enablePublishVideo;
        }

        public final String b() {
            return this.enterFrom;
        }

        public final Integer c() {
            return this.enterFromType;
        }

        public final Map<String, String> d() {
            return this.extra;
        }

        public final int e() {
            return this.style;
        }

        public final String getType() {
            return this.type;
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(null, "enterFrom");
            this.type = r100;
            this.enterFrom = null;
            this.enterFromType = null;
            this.style = 0;
            this.enablePublishVideo = 0;
            this.extra = null;
        }
    }

    public static final class b implements IAnnouncementService.SettingDialogCloseAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j9 f63480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallContext f63481b;

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.SettingDialogCloseAction
        public final void onDismiss() {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onDismiss(this);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.SettingDialogCloseAction
        public final void onAnnouncementSwitchChange(boolean r100) {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onAnnouncementSwitchChange(this, r100);
        }

        public b(j9 r100, CallContext r101) {
            this.f63480a = r100;
            this.f63481b = r101;
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.SettingDialogCloseAction
        public final void onAnnouncementSubmit(boolean r100, AnnouncementInfo r101, com.bytedance.android.livesdk.announce.b r102) {
            if (r100 == false) goto L14;
            if (r101 == null) goto L6;
            String r103 = r101.content;
            if (r103 == null) goto L6;
        L7:
            if (r101 == null) goto L11;
            boolean r104 = true;
            if (r101.switchStatus != true) goto L11;
        L12:
            j9.k(this.f63480a, this.f63481b, r103, r104);
            j9.j(this.f63480a, r103, r104);
            return;
        L11:
            r104 = false;
        L6:
            r103 = "";
            goto L7
        }
    }

    public static final class c implements nz.y {
        public c() {
        }
    }

    public static final class d implements IAnnouncementService.SettingDialogCloseAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j9 f63482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallContext f63483b;

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.SettingDialogCloseAction
        public final void onDismiss() {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onDismiss(this);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.SettingDialogCloseAction
        public final void onAnnouncementSwitchChange(boolean r100) {
            IAnnouncementService.SettingDialogCloseAction.DefaultImpls.onAnnouncementSwitchChange(this, r100);
        }

        public d(j9 r100, CallContext r101) {
            this.f63482a = r100;
            this.f63483b = r101;
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.SettingDialogCloseAction
        public final void onAnnouncementSubmit(boolean r100, AnnouncementInfo r101, com.bytedance.android.livesdk.announce.b r102) {
            if (r100 == false) goto L14;
            if (r101 == null) goto L6;
            String r103 = r101.content;
            if (r103 == null) goto L6;
        L7:
            if (r101 == null) goto L11;
            boolean r104 = true;
            if (r101.switchStatus != true) goto L11;
        L12:
            j9.k(this.f63482a, this.f63483b, r103, r104);
            j9.j(this.f63482a, r103, r104);
            return;
        L11:
            r104 = false;
        L6:
            r103 = "";
            goto L7
        }
    }

    public static final class e implements nz.y {
        public e() {
        }
    }

    public static final class f implements IAnnouncementService.AnnouncementDialogCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j9 f63484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallContext f63485b;

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onJustDismiss() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onJustDismiss(this);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onOuterDeleteStickOrExtension() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onOuterDeleteStickOrExtension(this);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onAnnnounceListChanged(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onAnnnounceListChanged(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackData(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackData(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackFE(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            if (r100.equals(IAnnouncementService.CloseAction.CREATE_SUCCESS) == false) goto L6;
            j9.k(this.f63484a, this.f63485b, "", true);
            j9.j(this.f63484a, "", true);
            return;
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackFansGroup(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackFansGroup(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackLiveStart(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackLiveStart(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackOtherPlace(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackOtherPlace(this, r100);
        }

        public f(j9 r100, CallContext r101) {
            this.f63484a = r100;
            this.f63485b = r101;
        }
    }

    public static final class g implements AnnounceCommandCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j9 f63486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallContext f63487b;

        @Override // com.bytedance.android.livesdkapi.announcement.AnnounceCommandCallback
        public final void onCommand(AnnounceCommand r100) {
            Intrinsics.checkNotNullParameter(r100, "command");
            if ((r100 instanceof AnnounceSettingPage.CreateSuccess) == false) goto L6;
            j9 r101 = this.f63486a;
            AnnounceSettingPage.CreateSuccess r102 = (AnnounceSettingPage.CreateSuccess) r100;
            String r103 = String.valueOf(r102.getAppointmentId());
            String r104 = String.valueOf(r102.getTimestamp());
            r101.getClass();
            JSONObject r105 = new JSONObject();
            r105.put("announcementID", r103);
            r105.put("latestLiveTimestamp", r104);
            r101.finishWithResult(r105);
        L14:
            j9.k(this.f63486a, this.f63487b, "", true);
            j9.j(this.f63486a, "", true);
            return;
        L6:
            if ((r100 instanceof AnnounceSettingPage.ClosePageWithoutCreate) == false) goto L9;
            j9 r106 = this.f63486a;
            r106.getClass();
            JSONObject r107 = new JSONObject();
            r107.put("announcementID", "");
            r106.finishWithResult(r107);
            goto L14
        L9:
            if ((r100 instanceof AnnounceChoosePage.LinkResult) == false) goto L12;
            j9 r108 = this.f63486a;
            AnnounceChoosePage.LinkResult r109 = (AnnounceChoosePage.LinkResult) r100;
            String r110 = r109.getAppointmentId();
            String r111 = r109.getTimeStamp();
            r108.getClass();
            JSONObject r112 = new JSONObject();
            r112.put("announcementID", r110);
            r112.put("latestLiveTimestamp", r111);
            r108.finishWithResult(r112);
            goto L14
        L12:
            if ((r100 instanceof AnnounceSettingPage.CreateFailed) == false) goto L14;
            j9 r113 = this.f63486a;
            r113.getClass();
            JSONObject r114 = new JSONObject();
            r114.put("result", "create_failed");
            r113.finishWithResult(r114);
            goto L14
        }

        public g(j9 r100, CallContext r101) {
            this.f63486a = r100;
            this.f63487b = r101;
        }
    }

    public static final class h implements IAnnouncementService.AnnouncementDialogCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j9 f63488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CallContext f63489b;

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onJustDismiss() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onJustDismiss(this);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onOuterDeleteStickOrExtension() {
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onOuterDeleteStickOrExtension(this);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onAnnnounceListChanged(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onAnnnounceListChanged(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackData(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackData(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackFE(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            j9.k(this.f63488a, this.f63489b, "", true);
            j9.j(this.f63488a, "", true);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackFansGroup(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "returnsInfo");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackFansGroup(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackLiveStart(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackLiveStart(this, r100);
        }

        @Override // com.bytedance.android.livesdkapi.announcement.IAnnouncementService.AnnouncementDialogCallback
        public final void onBackOtherPlace(IAnnouncementService.CloseAction r100) {
            Intrinsics.checkNotNullParameter(r100, "closeAction");
            IAnnouncementService.AnnouncementDialogCallback.DefaultImpls.onBackOtherPlace(this, r100);
        }

        public h(j9 r100, CallContext r101) {
            this.f63488a = r100;
            this.f63489b = r101;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public j9() {
        this.f63478a = "announcement_id";
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final /* bridge */ /* synthetic */ void invoke(a r100, CallContext r101) {
        l(r100, r101);
    }

    public final void l(a r210, CallContext r211) {
        Intrinsics.checkNotNullParameter(r210, "p0");
        Intrinsics.checkNotNullParameter(r211, "p1");
        IAnnouncementService r100 = (IAnnouncementService) jc1.k.f(IAnnouncementService.class);
        String r101 = r210.getType();
        String r102 = null;
        Disposable r103 = null;
        switch(r101.hashCode()) {
            case -1352294148: goto L68;
            case -347231239: goto L54;
            case -122153707: goto L44;
            case -121879484: goto L24;
            case 3322014: goto L17;
            case 403708324: goto L6;
            default: goto L92;
        };
    L92:
        return;
    L6:
        if (r101.equals("share_panel") == false) goto L77;
        Map<String, String> r104 = r210.d();
        if (r104 == null) goto L10;
        String r105 = r104.get(this.f63478a);
    L11:
        IBroadcastAnnounceService r106 = (IBroadcastAnnounceService) jc1.k.f(IBroadcastAnnounceService.class);
        if (r105 == null) goto L78;
        if (r106 == null) goto L15;
        r103 = r106.openSharePanel(new OpenSharePanelConfig(r105, r211.getContext()));
    L15:
        this.f63479b = r103;
        return;
    L78:
        return;
    L10:
        r105 = null;
        goto L11
    L77:
        return;
    L17:
        if (r101.equals("list") == false) goto L80;
        IAnnouncementService r107 = (IAnnouncementService) jc1.k.n(IAnnouncementService.class);
        Context r108 = r211.getContext();
        Integer r109 = r210.c();
        if (r109 == null) goto L21;
        int r110 = r109.intValue();
    L22:
        r107.openAnnouncementChooseDialogOpt(new OpenAnnounceChooseConfig(r108, r110, null, new g(this, r211), null, null, null, r210.d(), 68, null));
        return;
    L21:
        r110 = OpenAnnounceBaseConfig.Companion.getFeTrendHomePage();
        goto L22
    L80:
        return;
    L24:
        if (r101.equals("setting_opt") == false) goto L82;
        Map<String, String> r111 = r210.d();
        if (r111 == null) goto L29;
        r102 = r111.get(this.f63478a);
    L29:
        if (r102 != null) goto L75;
    L34:
        long r112 = 0;
    L36:
        if (r112 == 0) goto L42;
        IAnnouncementService r113 = (IAnnouncementService) jc1.k.n(IAnnouncementService.class);
        Context r114 = r211.getContext();
        Integer r115 = r210.c();
        if (r115 == null) goto L40;
        int r116 = r115.intValue();
    L41:
        r113.openAnnouncementCreateDialogOpt(new OpenAnnounceSettingConfig(r114, r116, new h(this, r211), null, Long.valueOf(r112), false, false, null, VideoRef.VALUE_VIDEO_REF_CATEGORY, null));
        return;
    L40:
        r116 = OpenAnnounceBaseConfig.Companion.getFeTrendHomePage();
        goto L41
    L42:
        com.bytedance.android.live.core.utils.f2.c("打开失败", 0);
        return;
    L75:
        r112 = CastLongProtector.parseLong(r102);     // Catch: Exception -> L33
    L82:
        return;
    L44:
        if (r101.equals("settingView") == false) goto L85;
        Intrinsics.checkNotNull(r100);
        if (r100.enable() == false) goto L52;
        Context r117 = r211.getContext();
        if (r210.e() != 1) goto L50;
        boolean r118 = true;
    L51:
        IAnnouncementService.DefaultImpls.openAnnouncementSettingDialog$default(r100, r117, r118, false, null, r210.b(), false, new d(this, r211), 40, null);
        return;
    L50:
        r118 = false;
        goto L51
    L52:
        ((IBroadcastService) jc1.k.n(IBroadcastService.class)).openForenoticeDialog(r211.getContext(), false, false, null, new e(), 1, r210.b());
        return;
    L85:
        return;
    L54:
        if (r101.equals("switchView") == false) goto L88;
        Intrinsics.checkNotNull(r100);
        if (r100.enable() == false) goto L66;
        Context r119 = r211.getContext();
        if (r210.e() != 1) goto L60;
        boolean r120 = true;
    L61:
        String r121 = r210.b();
        if (r210.a() != 1) goto L64;
        boolean r122 = true;
    L65:
        r100.openAnnouncementSettingDialog(r119, r120, false, r121, "center", r122, new b(this, r211));
        return;
    L64:
        r122 = false;
        goto L65
    L60:
        r120 = false;
        goto L61
    L66:
        ((IBroadcastService) jc1.k.n(IBroadcastService.class)).openForenoticeDialog(r211.getContext(), false, true, null, new c(), 1, r210.b());
        return;
    L88:
        return;
    L68:
        if (r101.equals("create") == false) goto L91;
        IAnnouncementService r123 = (IAnnouncementService) jc1.k.n(IAnnouncementService.class);
        Context r124 = r211.getContext();
        Integer r125 = r210.c();
        if (r125 == null) goto L72;
        int r126 = r125.intValue();
    L73:
        r123.openAnnouncementCreateDialogOpt(new OpenAnnounceSettingConfig(r124, r126, new f(this, r211), null, null, false, false, null, VideoRef.VALUE_VIDEO_REF_CATEGORY, null));
        return;
    L72:
        r126 = OpenAnnounceBaseConfig.Companion.getFeTrendHomePage();
        goto L73
    }

    public static final void j(j9 r100, String r101, boolean r102) {
        r100.getClass();
        JSONObject r103 = new JSONObject();
        r103.put("timeText", r101);
        r103.put("masterSwitch", r102 ? 1 : 0);
        r100.finishWithResult(r103);
    }

    public static final void k(j9 r100, CallContext r101, String r102, boolean r103) {
        r100.getClass();
        JSONObject r104 = new JSONObject();
        r104.put("timeText", r102);
        r104.put("masterSwitch", r103 ? 1 : 0);
        Unit r105 = Unit.INSTANCE;
        r101.b("H5_openTimeSchedule", r104);
    }
}
