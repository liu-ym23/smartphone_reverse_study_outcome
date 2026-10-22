package com.bytedance.android.livesdk.module;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.live.browser.webview.fragment.o;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.i2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.VcdAuthorizationSource;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IVideoContext;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.authorize.AuthorizeGuideService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.p;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ek;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.y0;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.shopping.ICommerceFlashData;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.subjects.SingleSubject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nH\u0002JD\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J.\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0003\u001a\u00020\u001dH\u0016J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J(\u0010+\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010*\u001a\u00020)H\u0016J(\u0010,\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010*\u001a\u00020)H\u0016J>\u00102\u001a\u0004\u0018\u0001012\b\u0010'\u001a\u0004\u0018\u00010-2\b\u0010\u0012\u001a\u0004\u0018\u00010.2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00100\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u00010\nH\u0016J<\u00102\u001a\u0004\u0018\u0001012\b\u0010'\u001a\u0004\u0018\u00010-2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00100\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u0016J>\u00108\u001a\u0004\u0018\u0001072\b\u0010'\u001a\u0004\u0018\u00010-2\b\u0010\u0012\u001a\u0004\u0018\u00010.2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00100\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/module/UserService;", "Lcom/bytedance/android/live/user/IUserService;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "", "isDailyToast", "", "showAuthToast", "Landroid/net/Uri;", "uri", "", "url", "fallbackScheme", "getUri", "httpUri", "secUid", "userId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "event", "enterLiveSource", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/net/Uri$Builder;", "getUriBuilder", "fallback", "getFallbackScheme", "getSecUid", "Lcom/bytedance/android/livesdk/user/f;", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "Lcom/bytedance/android/live/user/VcdAuthorizationSource;", "source", "Lio/reactivex/Single;", "ensureVcdAuthorized", "showAuthorizeGuideDialogAfterSwitchToPortrait", "Lcom/bytedance/android/live/user/a;", "resumeShowAuthorizeGuideDialogAfterSwitchedToPortrait", PerfLog.PARAM_KEY_CONTEXT_ID, "content", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$AuthorizeCallback;", "callback", "showVcdContentGrant", "showVcdRelationshipGrant", "Landroid/content/Context;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "", "orientation", "Landroidx/fragment/app/DialogFragment;", "showLynxProfileDialog", "showAuthOrDailyToast", "openID", "", "getAuthToastTimeWithID", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "showLynxProfileDialogNew", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class UserService implements IUserService {

    public static final class a implements IMiddlewareHostBusiness.AuthorizeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserService f153955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMiddlewareHostBusiness.AuthorizeCallback f153956b;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onAuthorized() {
            IUser r100 = this.f153955a.user().b();
            r100.setVcdAdversaryAuthorizeState(true, r100.isVcdAdversaryRelationAuthorized());
            this.f153956b.onAuthorized();
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onDisauthorized() {
            this.f153956b.onDisauthorized();
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onInterrupted() {
            this.f153956b.onInterrupted();
        }

        public a(UserService r100, IMiddlewareHostBusiness.AuthorizeCallback r101) {
            this.f153955a = r100;
            this.f153956b = r101;
        }
    }

    public static final class b implements IMiddlewareHostBusiness.AuthorizeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserService f153957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IMiddlewareHostBusiness.AuthorizeCallback f153958b;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onAuthorized() {
            IUser r100 = this.f153957a.user().b();
            r100.setVcdAdversaryAuthorizeState(r100.isVcdAdversaryContentAuthorized(), true);
            this.f153958b.onAuthorized();
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onDisauthorized() {
            this.f153958b.onDisauthorized();
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AuthorizeCallback
        public final void onInterrupted() {
            this.f153958b.onInterrupted();
        }

        public b(UserService r100, IMiddlewareHostBusiness.AuthorizeCallback r101) {
            this.f153957a = r100;
            this.f153958b = r101;
        }
    }

    public UserService() {
        jc1.k.l(IMiddlewareUserService.class, this);
    }

    @Override // com.bytedance.android.live.user.IUserService, com.bytedance.android.live.user.IMiddlewareUserService
    public com.bytedance.android.livesdk.user.f user() {
        com.bytedance.android.livesdk.service.h r100 = TTLiveSDKContext.getHostService();
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.user.f r101 = ((com.bytedance.android.livesdk.service.f) r100).h();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new y0();
    }

    @Override // com.bytedance.android.live.user.IMiddlewareUserService
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.user.e user() {
        return user();
    }

    @Override // com.bytedance.android.live.user.IUserServiceForSaas
    public long getAuthToastTimeWithID(String r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        String r101 = com.bytedance.android.livesdk.sharedpref.b.f158189o1.getValue().get(r100);
        if (r101 != null) goto L8;
        return 0;
    L8:
        return CastLongProtector.parseLong(r101);
    }

    @Override // com.bytedance.android.live.user.IUserService, com.bytedance.android.live.user.IMiddlewareUserService
    public Single<com.bytedance.android.live.user.a> resumeShowAuthorizeGuideDialogAfterSwitchedToPortrait(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        VcdAuthorizationSource r101 = AuthorizeGuideService.f104092a;
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        if (r100.getRequestedOrientation() == 1) goto L5;
    L14:
        return null;
    L5:
        if (tb1.c.f545229a == false) goto L14;
        VcdAuthorizationSource r102 = AuthorizeGuideService.f104092a;
        if (r102 == null) goto L14;
        SingleSubject<Boolean> r103 = AuthorizeGuideService.f104093b;
        if (r103 == null) goto L14;
        return AuthorizeGuideService.c(r103, r100).map(new com.bytedance.android.livesdk.authorize.b(r102));
    }

    @Override // com.bytedance.android.live.user.IUserServiceForSaas
    public void showAuthOrDailyToast(boolean r110) {
        if (user().isLogin() == false) goto L21;
        String r100 = user().n();
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L23;
        com.bytedance.android.livesdk.sharedpref.e<HashMap<String, String>> r102 = com.bytedance.android.livesdk.sharedpref.b.f158189o1;
        HashMap<String, String> r103 = r102.getValue();
        IUser r104 = user().b();
        long r105 = getAuthToastTimeWithID(r104.getIdString());
        IVideoContext r106 = TTLiveSDK.hostService().videoContext();
        if (r106 == null) goto L16;
        long r107 = r106.getAuthToastTimeWithId(r104.getIdString());
    L17:
        ALogger.d("AuthToast", "lastTimeForVideo:" + r107 + " lastTimeForLive:" + r105);
        if (TimeUtils.isToday(Math.max(r105, r107)) == true) goto L22;
        ALogger.d("AuthToast", "showAuthToast :id: " + r104.getUserId() + "  isDailyToast:" + r110);
        r103.put(r104.getIdString(), String.valueOf(System.currentTimeMillis()));
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        showAuthToast(r104, r110);
        return;
    L22:
        return;
    L16:
        r107 = -1;
        goto L17
    L23:
        return;
    L7:
        if (r100.length() == 0) goto L10;
        r101 = false;
        goto L11
    }

    private final String getSecUid(UserProfileEvent r100, String r101) {
        String r102 = r100.secUserId;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        return r100.secUserId;
    L12:
        return user().a(r101);
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }

    private final void showAuthToast(IBaseUser r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r102 = r100.getNickName();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.length() <= 2) goto L11;
        r102 = String.valueOf(r102.charAt(0)) + "*" + r102.charAt(r102.length() - 1);
    L17:
        if (r101 == false) goto L19;
        String r103 = LiveConfigSettingKeys.LIVE_AUTH_TIP_FORMAT_V2.getValue();
    L21:
        if (TextUtils.isEmpty(r103) == false) goto L23;
        return;
    L23:
        if (StringsKt.contains$default(r103, "%s", false, 2, null) == false) goto L27;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        f2.c(String.format(r103, Arrays.copyOf(new Object[]{r102}, 1)), 0);
        return;
    L27:
        return;
    L19:
        r103 = LiveConfigSettingKeys.LIVE_AUTH_TIP_FORMAT.getValue();
        goto L21
    L11:
        if (r102.length() != 2) goto L14;
        r102 = String.valueOf(r102.charAt(0)) + "*";
        goto L17
    L14:
        if (r102.length() == 1) goto L17;
        r102 = "*";
        goto L17
    }

    @Override // com.bytedance.android.live.user.IUserService, com.bytedance.android.live.user.IMiddlewareUserService
    public Single<Boolean> ensureVcdAuthorized(FragmentActivity r100, VcdAuthorizationSource r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "source");
        VcdAuthorizationSource r102 = AuthorizeGuideService.f104092a;
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "source");
        if (tb1.c.f545229a == false) goto L23;
        p.f114578b.getClass();
        Room r103 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r103 == null) goto L22;
        User r104 = r103.mo8271getOwner();
        if (r104 == null) goto L22;
        if (r104.isVcdAdversaryContentAuthorized() != true) goto L22;
        if (AuthorizeGuideService.f104093b == null) goto L16;
        return Single.just(Boolean.FALSE);
    L16:
        if (((IUserService) jc1.k.n(IUserService.class)).user().b().isVcdAdversaryContentAuthorized() == false) goto L26;
        if (r101 == VcdAuthorizationSource.LINK_IN_ROOM) goto L26;
        return Single.just(Boolean.TRUE);
    L26:
        return AuthorizeGuideService.c(AuthorizeGuideService.b(r101), r100);
    L22:
        return Single.just(Boolean.TRUE);
    L23:
        return Single.just(Boolean.TRUE);
    }

    @Override // com.bytedance.android.live.user.IUserService, com.bytedance.android.live.user.IMiddlewareUserService
    public boolean showAuthorizeGuideDialogAfterSwitchToPortrait(FragmentActivity r100, VcdAuthorizationSource r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "source");
        VcdAuthorizationSource r102 = AuthorizeGuideService.f104092a;
        Intrinsics.checkNotNullParameter(r100, "fragmentActivity");
        Intrinsics.checkNotNullParameter(r101, "source");
        if (e5.j(r100) == true) goto L5;
    L23:
        return false;
    L5:
        if (tb1.c.f545229a == false) goto L23;
        Room r103 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r103 == null) goto L23;
        User r104 = r103.mo8271getOwner();
        if (r104 == null) goto L23;
        if (r104.isVcdAdversaryContentAuthorized() != true) goto L23;
        if (AuthorizeGuideService.f104093b != null) goto L23;
        if (((IUserService) jc1.k.n(IUserService.class)).user().b().isVcdAdversaryContentAuthorized() == true) goto L20;
    L22:
        AuthorizeGuideService.b(r101);
        u.f153431h = "0";
        j0.f153362d = "0";
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.a("ttlive_room_exit", "showAuthorizeGuide cause to hide interaction");
        xs2.b.a().post(new HorizontalPlayEvent(1));
        return true;
    L20:
        if (r101 == VcdAuthorizationSource.LINK_IN_ROOM) goto L22;
        goto L22
    }

    private final Uri getUri(Uri r100, String r101, String r102) {
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();
    L4:
        if (r104.hasNext() == false) goto L13;
        String r105 = r104.next();
        if (Intrinsics.areEqual("url", r105) == true) goto L7;
        if (Intrinsics.areEqual("fallback_url", r105) == true) goto L10;
        r103.appendQueryParameter(r105, UriProtector.getQueryParameter(r100, r105));
        goto L4
    L10:
        r103.appendQueryParameter(r105, r102);
        goto L4
    L7:
        r103.appendQueryParameter(r105, r101);
        goto L4
    L13:
        return r103.build();
    }

    private final String getFallbackScheme(String r100, String r101, String r102, UserProfileEvent r103) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon().appendQueryParameter("sec_user_id", r101).appendQueryParameter("user_id", r102).appendQueryParameter("interact_log_label", r103.interactLogLabel).appendQueryParameter("event_module", r103.mEventModule).appendQueryParameter("source", r103.mSource).appendQueryParameter("click_user_position", r103.mClickUserPosition).appendQueryParameter("report_source", r103.mReportSource).appendQueryParameter("report_type_for_log", r103.mReportTypeForLog).appendQueryParameter("commont_report_model", GsonProtectorUtils.toJson(GsonHelper.getDefault(), r103.mCommentReportModel));
        if (r103.getShowSendGift() == false) goto L7;
        String r105 = "1";
    L11:
        return r104.appendQueryParameter(ek.GIFT_SCENE, r105).build().toString();
    L7:
        r105 = "0";
        goto L11
    L9:
        return "";
    }

    @Override // com.bytedance.android.live.user.IUserService, com.bytedance.android.live.user.IMiddlewareUserService
    public void showVcdContentGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ((IHostBusiness) jc1.k.n(IHostBusiness.class)).showVcdContentGrant(r100, r101, r102, new a(this, r103));
    }

    @Override // com.bytedance.android.live.user.IUserService, com.bytedance.android.live.user.IMiddlewareUserService
    public void showVcdRelationshipGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ((IHostBusiness) jc1.k.n(IHostBusiness.class)).showVcdRelationshipGrant(r100, r101, r102, new b(this, r103));
    }

    public static /* synthetic */ void showAuthToast$default(UserService r100, IBaseUser r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        r100.showAuthToast(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAuthToast");
    }

    public final DialogFragment showLynxProfileDialog(Context r110, IRoom r111, String r112, UserProfileEvent r113, int r210, DataCenter r211) {
        Intrinsics.checkNotNullParameter(r112, "enterLiveSource");
        Intrinsics.checkNotNullParameter(r113, "event");
        Intrinsics.checkNotNullParameter(r211, "dataCenter");
        if (r110 != null) goto L5;
        return null;
    L5:
        if (r111 != null) goto L7;
        return null;
    L7:
        ss0.b r100 = rs0.y0.f539091a.getValue();
        if (r100 != null) goto L10;
    L39:
        return null;
    L10:
        if (r100.a() == false) goto L39;
        if (e5.f(r210) == false) goto L15;
        String r101 = r100.b();
    L16:
        IBaseUser r102 = r113.user;
        if (r102 != null) goto L19;
        String r103 = r113.getUserIdStr();
    L20:
        String r104 = r103;
        Uri r114 = UriProtector.parse(r101);     // Catch: Exception -> L37
        String r105 = UriProtector.getQueryParameter(r114, "url");     // Catch: Exception -> L37
        String r106 = UriProtector.getQueryParameter(r114, "fallback_url");     // Catch: Exception -> L37
        String r107 = getSecUid(r113, r104);     // Catch: Exception -> L37
        String r115 = getFallbackScheme(r106, r107, r104, r113);     // Catch: Exception -> L37
        Uri r108 = UriProtector.parse(r105);     // Catch: Exception -> L37
        String r116 = r108.getPath();     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r116);     // Catch: Exception -> L37
        String r109 = String.valueOf(getUriBuilder(r108, r107, r104, r111, r113, r112, r211));     // Catch: Exception -> L40
        Uri r117 = getUri(r114, r109, r115);     // Catch: Exception -> L40
        o r118 = ((IBrowserService) jc1.k.n(IBrowserService.class)).buildLynxDialog(r109, r115, null).setHeight(i2.c(r117, "height", 400));     // Catch: Exception -> L40
        r118.f64386a = i2.c(r117, "width", (int) s1.G(s1.y()));     // Catch: Exception -> L40
        r118.f64388c = i2.c(r117, GXTemplateKey.FLEXBOX_MARGIN, 0);     // Catch: Exception -> L40
        if (i2.c(r117, "landscape_custom_height", 0) != 1) goto L26;
        boolean r119 = true;
    L27:
        r118.f64398m = r119;     // Catch: Exception -> L40
        r118.f64394i = 80;     // Catch: Exception -> L40
        if (i2.c(r117, AppConstants.BUNDLE_PULL_DOWN_CLOSE, 0) != 1) goto L30;
        boolean r120 = true;
    L31:
        r118.B = r120;     // Catch: Exception -> L40
        r118.H = i2.c(r117, "lynx_thread", 0);     // Catch: Exception -> L40
        if (i2.c(r117, "show_dim", 1) != 1) goto L34;
        boolean r121 = true;
    L35:
        r118.f64401p = r121;     // Catch: Exception -> L40
        r118.f64402q = true;     // Catch: Exception -> L40
        return r118.build();
    L34:
        r121 = false;
        goto L35
    L30:
        r120 = false;
        goto L31
    L26:
        r119 = false;
    L38:
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_fallback", 1, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "profile"), TuplesKt.to("path", r116)}));
    L37:
        r116 = "";
        goto L38
    L19:
        r103 = r102.getIdString();
        goto L20
    L15:
        r101 = r100.c();
        goto L16
    }

    @Override // com.bytedance.android.live.user.IUserService
    public HybridDialog showLynxProfileDialogNew(Context r210, Room r211, String r212, UserProfileEvent r213, int r214, DataCenter r215) {
        String r100 = "type";
        Intrinsics.checkNotNullParameter(r212, "enterLiveSource");
        Intrinsics.checkNotNullParameter(r213, "event");
        Intrinsics.checkNotNullParameter(r215, "dataCenter");
        if (r210 != null) goto L5;
        return null;
    L5:
        if (r211 != null) goto L7;
        return null;
    L7:
        ss0.b r101 = rs0.y0.f539091a.getValue();
        if (r101 == null) goto L56;
        if (r101.a() == false) goto L56;
        if (e5.f(r214) == false) goto L15;
        String r102 = r101.b();
    L16:
        IBaseUser r103 = r213.user;
        if (r103 != null) goto L19;
        String r104 = r213.getUserIdStr();
    L65:
        Uri r105 = UriProtector.parse(r102);     // Catch: Exception -> L51
        String r106 = UriProtector.getQueryParameter(r105, "url");     // Catch: Exception -> L50
        String r107 = UriProtector.getQueryParameter(r105, "fallback_url");     // Catch: Exception -> L50
        String r108 = getSecUid(r213, r104);     // Catch: Exception -> L50
        String r109 = getFallbackScheme(r107, r108, r104, r213);     // Catch: Exception -> L50
        Uri r110 = UriProtector.parse(r106);     // Catch: Exception -> L50
        String r111 = r110.getPath();     // Catch: Exception -> L50
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L50
        r100 = "type";
        String r112 = String.valueOf(getUriBuilder(r110, r108, r104, r211, r213, r212, r215));     // Catch: Exception -> L47
        Uri r113 = getUri(r105, r112, r109);     // Catch: Exception -> L47
        String r114 = ((IBrowserService) jc1.k.n(IBrowserService.class)).getRenderUrlByH5Service(r112);     // Catch: Exception -> L47
        IBrowserService r115 = (IBrowserService) jc1.k.n(IBrowserService.class);     // Catch: Exception -> L47
        char r116 = 0;
        Uri.Builder r117 = x6.a.c(r114).appendQueryParameter(r100, "popup").appendQueryParameter("height", String.valueOf(i2.c(r113, "height", 400))).appendQueryParameter("width", String.valueOf(i2.c(r113, "width", (int) s1.G(s1.y())))).appendQueryParameter(GXTemplateKey.FLEXBOX_MARGIN, String.valueOf(i2.c(r113, GXTemplateKey.FLEXBOX_MARGIN, 0)));     // Catch: Exception -> L58
        String r118 = "1";
        if (i2.c(r113, "landscape_custom_height", 0) != 1) goto L30;
        String r119 = "1";
    L31:
        Uri.Builder r120 = r117.appendQueryParameter("landscape_custom_height", r119).appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom");     // Catch: Exception -> L47
        if (i2.c(r113, AppConstants.BUNDLE_PULL_DOWN_CLOSE, 0) != 1) goto L34;
        String r121 = "1";
    L35:
        Uri.Builder r122 = r120.appendQueryParameter(AppConstants.BUNDLE_PULL_DOWN_CLOSE, r121);     // Catch: Exception -> L47
        if (i2.c(r113, "lynx_thread", 0) != 1) goto L38;
        String r123 = "1";
    L39:
        Uri.Builder r124 = r122.appendQueryParameter("lynx_thread", r123);     // Catch: Exception -> L47
        if (i2.c(r113, "show_dim", 1) == 1) goto L43;
        r118 = "0";
    L43:
        Uri r125 = r124.appendQueryParameter("show_dim", r118).build();     // Catch: Exception -> L47
        r116 = 0;
        HybridDialog r126 = null;
        return r115.showHybridDialog(r210, r125, null);
    L49:
        String r127 = r111;
    L53:
        Pair[] r128 = new Pair[2];
        r128[r116] = TuplesKt.to(r100, "profile");
        r128[1] = TuplesKt.to("path", r127);
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_fallback", 1, MapsKt.mapOf(r128));
        return r126;
    L38:
        r123 = "0";
        goto L39
    L34:
        r121 = "0";
        goto L35
    L30:
        r119 = "0";
    L48:
        r126 = null;
    L47:
        r116 = 0;
    L50:
        r116 = 0;
        r126 = null;
    L52:
        r127 = "";
    L51:
        r126 = null;
        r116 = 0;
        goto L52
    L19:
        r104 = r103.getIdString();
        goto L65
    L15:
        r102 = r101.c();
    L56:
        return null;
    }

    @Override // com.bytedance.android.live.user.IUserService
    public DialogFragment showLynxProfileDialog(Context r110, Room r111, String r112, UserProfileEvent r113, int r210, DataCenter r211) {
        Intrinsics.checkNotNullParameter(r112, "enterLiveSource");
        Intrinsics.checkNotNullParameter(r113, "event");
        Intrinsics.checkNotNullParameter(r211, "dataCenter");
        if (r110 != null) goto L5;
        return null;
    L5:
        if (r111 != null) goto L7;
        return null;
    L7:
        ss0.b r100 = rs0.y0.f539091a.getValue();
        if (r100 != null) goto L10;
    L39:
        return null;
    L10:
        if (r100.a() == false) goto L39;
        if (e5.f(r210) == false) goto L15;
        String r101 = r100.b();
    L16:
        IBaseUser r102 = r113.user;
        if (r102 != null) goto L19;
        String r103 = r113.getUserIdStr();
    L20:
        String r104 = r103;
        Uri r114 = UriProtector.parse(r101);     // Catch: Exception -> L37
        String r105 = UriProtector.getQueryParameter(r114, "url");     // Catch: Exception -> L37
        String r106 = UriProtector.getQueryParameter(r114, "fallback_url");     // Catch: Exception -> L37
        String r107 = getSecUid(r113, r104);     // Catch: Exception -> L37
        String r115 = getFallbackScheme(r106, r107, r104, r113);     // Catch: Exception -> L37
        Uri r108 = UriProtector.parse(r105);     // Catch: Exception -> L37
        String r116 = r108.getPath();     // Catch: Exception -> L37
        Intrinsics.checkNotNull(r116);     // Catch: Exception -> L37
        String r109 = String.valueOf(getUriBuilder(r108, r107, r104, r111, r113, r112, r211));     // Catch: Exception -> L40
        Uri r117 = getUri(r114, r109, r115);     // Catch: Exception -> L40
        o r118 = ((IBrowserService) jc1.k.n(IBrowserService.class)).buildLynxDialog(r109, r115, null).setHeight(i2.c(r117, "height", 400));     // Catch: Exception -> L40
        r118.f64386a = i2.c(r117, "width", (int) s1.G(s1.y()));     // Catch: Exception -> L40
        r118.f64388c = i2.c(r117, GXTemplateKey.FLEXBOX_MARGIN, 0);     // Catch: Exception -> L40
        if (i2.c(r117, "landscape_custom_height", 0) != 1) goto L26;
        boolean r119 = true;
    L27:
        r118.f64398m = r119;     // Catch: Exception -> L40
        r118.f64394i = 80;     // Catch: Exception -> L40
        if (i2.c(r117, AppConstants.BUNDLE_PULL_DOWN_CLOSE, 0) != 1) goto L30;
        boolean r120 = true;
    L31:
        r118.B = r120;     // Catch: Exception -> L40
        r118.H = i2.c(r117, "lynx_thread", 0);     // Catch: Exception -> L40
        if (i2.c(r117, "show_dim", 1) != 1) goto L34;
        boolean r121 = true;
    L35:
        r118.f64401p = r121;     // Catch: Exception -> L40
        r118.f64402q = true;     // Catch: Exception -> L40
        return r118.build();
    L34:
        r121 = false;
        goto L35
    L30:
        r120 = false;
        goto L31
    L26:
        r119 = false;
    L38:
        LiveSlardarMonitor.monitorStatus("ttlive_lynx_fallback", 1, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "profile"), TuplesKt.to("path", r116)}));
    L37:
        r116 = "";
        goto L38
    L19:
        r103 = r102.getIdString();
        goto L20
    L15:
        r101 = r100.c();
        goto L16
    }

    private final Uri.Builder getUriBuilder(Uri r100, String r101, String r110, IRoom r111, UserProfileEvent r112, String r113, DataCenter r114) {
        Uri.Builder r102 = r100.buildUpon().appendQueryParameter("sec_target_uid", r101).appendQueryParameter("target_uid", r110);
        IBaseUser r103 = r111.getOwner();
        if (r103 == null) goto L6;
        String r104 = r103.getIdString();
        if (r104 == null) goto L6;
    L7:
        Uri.Builder r105 = r102.appendQueryParameter("anchor_id", r104).appendQueryParameter("sec_anchor_id", user().a(r111.getAnchorId())).appendQueryParameter("current_room_id", String.valueOf(r111.getId())).appendQueryParameter("interact_log_label", r112.interactLogLabel).appendQueryParameter("enter_live_source", r113).appendQueryParameter("report_type", r112.mReportTypeForLog).appendQueryParameter("guest_user_id", ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal().a());
        String r106 = r112.mSource;
        if (r106 == null) goto L14;
        r105.appendQueryParameter("from_source", r106);
        if (u.l().c(am2.c.class) == null) goto L14;
        if (u.l().c(am2.c.class).getMap() == null) goto L14;
        u.l().c(am2.c.class).c("click_user_position", r112.mSource);
    L14:
        String r107 = r112.mReportSource;
        if (r107 == null) goto L17;
        r105.appendQueryParameter("report_source", r107);
    L17:
        String r108 = r112.mReportTypeForLog;
        if (r108 == null) goto L20;
        r105.appendQueryParameter("report_type", r108);
    L20:
        String r109 = UtilsKt.h(GsonProtectorUtils.toJsonTree(GsonHelper.get(), r112.mCommentReportModel));
        if (TextUtils.isEmpty(r109) == true) goto L23;
        r105.appendQueryParameter("comment_report_model", r109);
    L23:
        User r115 = new User();
        boolean r116 = ((Boolean) r114.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        r115.setIdStr(r110);
        String r117 = "2";
        if (((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().u(r116, r115.getIdString()) == false) goto L27;
        String r118 = "1";
    L30:
        r105.appendQueryParameter("video_talk_online_user_type", r118);
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().a(r110) == false) goto L33;
        String r119 = "1";
    L34:
        r105.appendQueryParameter("user_in_multi_anchor_link", r119);
        y r120 = null;
        ICommerceFlashData r121 = (ICommerceFlashData) r114.get("data_commerce_flash_info", null);
        boolean r122 = true;
        if (r121 != null) goto L37;
    L41:
        int r123 = 0;
        int r124 = 0;
    L42:
        r105.appendQueryParameter("ec_direct_splash", String.valueOf(r124));
        r105.appendQueryParameter("ec_direct_dot", String.valueOf(r123));
        if (((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).R(r116, r115) == false) goto L45;
        String r125 = "1";
    L71:
        r105.appendQueryParameter("interact_user_type", r125);
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService().B(r110) == false) goto L75;
        r117 = "1";
    L78:
        r105.appendQueryParameter("audio_talk_type", r117);
        r105.appendQueryParameter(ek.GIFT_SCENE, String.valueOf(r112.showSendGift ? 1 : 0));
        return r105;
    L75:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkService().p(r115) == true) goto L78;
        r117 = "0";
        goto L78
    L45:
        ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).getClass();
        if (r116 == false) goto L50;
        com.bytedance.android.live.liveinteract.plantform.base.d.f75487j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r126 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r126 == null) goto L53;
        r120 = r126.getLinkUserCenter();
    L53:
        if (r120 != null) goto L55;
    L67:
        r122 = false;
    L68:
        if (r122 == false) goto L70;
        r125 = "2";
        goto L71
    L70:
        r125 = "0";
        goto L71
    L55:
        if (Lists.isEmpty(r120.f76319f) == true) goto L67;
        Iterator<ILinkPlayerInfoBridge> r127 = r120.f76319f.iterator();
    L59:
        if (r127.hasNext() == false) goto L67;
        ILinkPlayerInfoBridge r128 = r127.next();
        if (r128 == null) goto L59;
        if (r128.getUser() == null) goto L59;
        if (r128.getUser().getIdString().equals(r115.getIdString()) == false) goto L59;
    L50:
        com.bytedance.android.live.liveinteract.plantform.base.c.f75485i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r129 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r129 == null) goto L53;
        r120 = r129.getLinkUserCenter();
        goto L53
    L37:
        if (r121.hasAuth() == false) goto L41;
        if (r121.isOpen() == false) goto L41;
        r123 = !com.bytedance.android.livesdk.sharedpref.b.f158167k.getValue().booleanValue() ? 1 : 0;
        r124 = 1;
        goto L42
    L33:
        r119 = "0";
        goto L34
    L27:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().I(r116, r115) == false) goto L29;
        r118 = "2";
        goto L30
    L29:
        r118 = "0";
    L6:
        r104 = "";
        goto L7
    }
}
