package com.bytedance.android.live.room.share;

import am2.x;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.room.share.jsbridge.ShareLiveMethod;
import com.bytedance.android.live.room.share.jsbridge.i;
import com.bytedance.android.live.room.share.jsbridge.k;
import com.bytedance.android.live.room.share.jsbridge.q;
import com.bytedance.android.live.room.share.summersinging.h;
import com.bytedance.android.live.room.share.summersinging.j;
import com.bytedance.android.live.room.share.summersinging.p;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.depend.share.ICommonLiveSharePackage;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IVSPosterClickListener;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMSharePostscriptConfig;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareTitleWithConListConfig;
import com.bytedance.android.livehostapi.business.shareinter.sharelinkpanel.IInRoomMorePanelShareLinkViewSlotDelegate;
import com.bytedance.android.livesdk.chatroom.c1;
import com.bytedance.android.livesdk.chatroom.d1;
import com.bytedance.android.livesdk.chatroom.e1;
import com.bytedance.android.livesdk.chatroom.f1;
import com.bytedance.android.livesdk.chatroom.j0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.vr0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.appjump.AppJumpEntry;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.lynx.tasm.LynxError;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.SingleSubject;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.se;
import y6.d;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 {2\u00020\u0001:\u0001|B\u0007¢\u0006\u0004\by\u0010zJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J2\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J.\u0010\"\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\n2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00060 H\u0016J6\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00060 H\u0016J\u001c\u0010'\u001a\u00020&2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(H\u0016J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+H\u0016J\u001c\u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020-0+2\u0006\u00100\u001a\u00020/H\u0016J\u001c\u00104\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+2\u0006\u00103\u001a\u00020/H\u0016J\u001e\u00109\u001a\u0002082\f\u00107\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00103\u001a\u00020/H\u0016J\u001c\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;2\u0006\u0010:\u001a\u00020\u0013H\u0016J$\u0010?\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\n2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;H\u0016J\"\u0010A\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\n2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;J(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010B\u001a\u0004\u0018\u0001062\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0014\u0010K\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0+H\u0016J\u001c\u0010M\u001a\u00020&2\b\u0010B\u001a\u0004\u0018\u0001062\b\u0010L\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;2\u0006\u0010N\u001a\u00020\nH\u0016J\b\u0010P\u001a\u00020&H\u0016J\u0016\u0010R\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n\u0018\u00010QH\u0016J\u0010\u0010U\u001a\u00020\u00062\u0006\u0010T\u001a\u00020SH\u0016J\u0010\u0010X\u001a\u00020W2\u0006\u0010T\u001a\u00020VH\u0016J&\u0010[\u001a\u00020\u00062\b\u0010Y\u001a\u0004\u0018\u0001062\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0;H\u0016J\b\u0010\\\u001a\u00020&H\u0016J\u0010\u0010]\u001a\u00020G2\u0006\u0010\\\u001a\u00020&H\u0016J\u0012\u0010_\u001a\u00020&2\b\u0010^\u001a\u0004\u0018\u00010-H\u0016J\n\u0010a\u001a\u0004\u0018\u00010`H\u0016J>\u0010k\u001a\u0004\u0018\u00010G2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010c\u001a\u00020b2\u0006\u0010e\u001a\u00020d2\u0006\u0010g\u001a\u00020f2\b\u0010^\u001a\u0004\u0018\u00010h2\b\u0010j\u001a\u0004\u0018\u00010iH\u0016R\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010uR\u0014\u0010w\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010x¨\u0006}"}, d2 = {"Lcom/bytedance/android/live/room/share/LiveShareService;", "Lcom/bytedance/android/live/room/api/ILiveShareService;", "Li81/a;", "liveShareParams", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;", "shareCallback", "", "showShareDialog", "doDouyinShowShareDialog", "release", "", "sourcePage", "Lcom/bytedance/android/live/room/api/share/model/LiveShareType;", "shareType", "Lio/reactivex/Single;", "Li81/b;", "share", "url", "getShortUrl", "Lcom/bytedance/android/live/base/model/user/f;", "contactUser", "getIMContactConversationId", "conversationId", "getContactUserObjById", "Landroid/app/Activity;", "activity", "Lcom/bytedance/android/livehostapi/business/depend/share/ShareParams;", "shareParams", "promotion", "", "schemaType", "objectId", "Lkotlin/Function1;", "callback", "getQrCodeInfo", "editionUid", "getQrCodeFromUrl", "hostShareType", "", "isShareAvailable", "Lcom/bytedance/ies/web/jsbridge2/g;", "Lorg/json/JSONObject;", "getShareScreenMethod", "Lcom/bytedance/ies/web/jsbridge2/f;", "Lcom/bytedance/android/livehostapi/business/depend/share/LiveWebShareParams;", "", "getShareFullParamsMethod", "Ly6/d;", "shareInfoListener", "Li81/c;", "getShareInfoMethod", ShortVideoSegments.KEY_PROP_PROVIDER, "getSharePanelMethod", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "mContextRef", "Ln56/c;", "getShareMethod", "contact", "", "getToUserConversationId", "event", "extra", "reportLiveShareEvent", "extraMap", "logTrace", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/base/model/data/f;", "groupPhotoDetail", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lio/reactivex/disposables/Disposable;", "showGroupPhotoDialog", "Lw20/se;", "Lcom/bytedance/android/live/browser/jsbridge/base/ShareLiveResultModel;", "getShareLiveMethod", "packageName", "openInstallApp", "shareInfo", "getLocalLifeShareParams", "enableFilterBusinessAccount", "Lkotlin/Pair;", "getSharePanelMoreText", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareTitleWithConListConfig;", "config", "addShareContactsListComponent", "Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMSharePostscriptConfig;", "Lcom/bytedance/android/livehostapi/business/shareinter/ILiveIMSharePostscriptComponent;", "addSharePostscriptComponent", "ctx", "map", "cacheMob", "canBeFoundByShare", "changeCanBeFoundByShare", "liveSharePackage", "hasLocalLifeShareCoupon", "Lcom/bytedance/android/livehostapi/business/shareinter/sharelinkpanel/IInRoomMorePanelShareLinkViewSlotDelegate;", "getLocalLifeShareCouponWidget", "Landroid/view/ViewGroup;", "posterContainer", "Landroid/app/Dialog;", "dialog", "Landroidx/fragment/app/DialogFragment;", "dialogFragment", "Lcom/bytedance/android/livehostapi/business/depend/share/ICommonLiveSharePackage;", "Lcom/bytedance/android/livehostapi/business/depend/share/IVSPosterClickListener;", "vsPosterClickListener", "initVSPoster", "Lio/reactivex/subjects/SingleSubject;", "liveShareResult", "Lio/reactivex/subjects/SingleSubject;", "Lcom/bytedance/android/livehostapi/business/IHostShare;", "iHostShare$delegate", "Lkotlin/Lazy;", "getIHostShare", "()Lcom/bytedance/android/livehostapi/business/IHostShare;", "iHostShare", "Lcom/bytedance/android/livehostapi/business/depend/share/IShareCallback;", "Lcom/bytedance/android/livehostapi/business/IHostShare$ValueCallback;", "valueCallback", "Lcom/bytedance/android/livehostapi/business/IHostShare$ValueCallback;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveShareService implements ILiveShareService {
    public static final a Companion = null;
    public static final String TAG = "LiveShareService";
    private final IShareCallback callback;
    private final Lazy iHostShare$delegate;
    private SingleSubject<i81.b> liveShareResult;
    private final IHostShare.ValueCallback valueCallback;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends SimpleShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveShareService f100261a;

        public b(LiveShareService r100) {
            this.f100261a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onFail(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            if (LiveShareService.access$getLiveShareResult$p(this.f100261a) == null) goto L9;
            SingleSubject r101 = LiveShareService.access$getLiveShareResult$p(this.f100261a);
            if (r101 == null) goto L7;
            r101.onError(r100);
        L7:
            LiveShareService.access$release(this.f100261a);
            return;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
        public final void onSuccess(String r100, String r101) {
            if (LiveShareService.access$getLiveShareResult$p(this.f100261a) == null) goto L9;
            SingleSubject r102 = LiveShareService.access$getLiveShareResult$p(this.f100261a);
            if (r102 == null) goto L7;
            r102.onSuccess(new i81.b(null, null));
        L7:
            LiveShareService.access$release(this.f100261a);
            return;
        }

        @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallbackWithExtra
        public final void onSuccessWithExtra(String r100, String r101, Map<String, List<String>> r102) {
            if (LiveShareService.access$getLiveShareResult$p(this.f100261a) == null) goto L9;
            SingleSubject r103 = LiveShareService.access$getLiveShareResult$p(this.f100261a);
            if (r103 == null) goto L7;
            r103.onSuccess(new i81.b(null, r102));
        L7:
            LiveShareService.access$release(this.f100261a);
            return;
        }
    }

    public static final class c implements IHostShare.ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveShareService f100262a;

        public c(LiveShareService r100) {
            this.f100262a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.IHostShare.ValueCallback
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            if (LiveShareService.access$getLiveShareResult$p(this.f100262a) == null) goto L9;
            SingleSubject r101 = LiveShareService.access$getLiveShareResult$p(this.f100262a);
            if (r101 == null) goto L7;
            r101.onError(r100);
        L7:
            LiveShareService.access$release(this.f100262a);
            return;
        }

        @Override // com.bytedance.android.livehostapi.business.IHostShare.ValueCallback
        public final void onSucceed(String r100) {
            if (LiveShareService.access$getLiveShareResult$p(this.f100262a) == null) goto L9;
            SingleSubject r101 = LiveShareService.access$getLiveShareResult$p(this.f100262a);
            if (r101 == null) goto L7;
            r101.onSuccess(new i81.b(r100, null));
        L7:
            LiveShareService.access$release(this.f100262a);
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final IHostShare getIHostShare() {
        return (IHostShare) this.iHostShare$delegate.getValue();
    }

    private final void release() {
        this.liveShareResult = null;
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<LiveWebShareParams, Object> getShareFullParamsMethod() {
        return new com.bytedance.android.live.room.share.jsbridge.b();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<se, ShareLiveResultModel> getShareLiveMethod() {
        return new ShareLiveMethod();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public g<JSONObject, JSONObject> getShareScreenMethod() {
        return new q();
    }

    public LiveShareService() {
        this.iHostShare$delegate = LazyKt.lazy(LiveShareService$iHostShare$2.INSTANCE);
        this.callback = new b(this);
        this.valueCallback = new c(this);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean canBeFoundByShare() {
        return getIHostShare().canBeFoundByShare();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean enableFilterBusinessAccount() {
        return getIHostShare().enableFilterBusinessAccount();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public IInRoomMorePanelShareLinkViewSlotDelegate getLocalLifeShareCouponWidget() {
        return getIHostShare().getLocalLifeShareCouponWidget();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Pair<Boolean, String> getSharePanelMoreText() {
        return getIHostShare().getSharePanelMoreText();
    }

    public static final /* synthetic */ IShareCallback access$getCallback$p(LiveShareService r100) {
        return r100.callback;
    }

    public static final /* synthetic */ IHostShare access$getIHostShare$p(LiveShareService r100) {
        return r100.getIHostShare();
    }

    public static final /* synthetic */ SingleSubject access$getLiveShareResult$p(LiveShareService r100) {
        return r100.liveShareResult;
    }

    public static final /* synthetic */ void access$release(LiveShareService r100) {
        r100.release();
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void addShareContactsListComponent(LiveIMShareTitleWithConListConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        getIHostShare().addShareContactsListComponent(r100);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public ILiveIMSharePostscriptComponent addSharePostscriptComponent(LiveIMSharePostscriptConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return getIHostShare().addSharePostscriptComponent(r100);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Disposable changeCanBeFoundByShare(boolean r100) {
        return getIHostShare().changeCanBeFoundByShare(r100);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public com.bytedance.android.live.base.model.user.f getContactUserObjById(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return getIHostShare().getContactUserById(r100);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public String getIMContactConversationId(com.bytedance.android.live.base.model.user.f r100) {
        Intrinsics.checkNotNullParameter(r100, "contactUser");
        StringBuilder r101 = new StringBuilder("getIMContactConversationId: ");
        int r102 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.f115581a;
        r100.getClass();
        r101.append(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a("ContactUser{mBase=null, mType=0, isStickTop=false, mDisplayName='null', mDisplayAvatar=null, mUidString='null'}"));
        ALogger.i(TAG, r101.toString());
        return getIHostShare().getIMContactConversationId(r100);
    }

    @Override // com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public Map<String, String> getLocalLifeShareParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shareInfo");
        LinkedHashMap r101 = new LinkedHashMap();
        c1 r102 = (c1) GsonHelper.get().fromJson(r100, c1.class);     // Catch: Exception -> L31
        if (r102 != null) goto L6;
        return r101;
    L6:
        d1 r103 = r102.a();     // Catch: Exception -> L31
        if (r103 != null) goto L9;
        return r101;
    L9:
        String r104 = r103.a();     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r104) == false) goto L12;
        return r101;
    L12:
        e1 r105 = (e1) GsonHelper.get().fromJson(r104, e1.class);     // Catch: Exception -> L31
        if (r105 != null) goto L15;
        return r101;
    L15:
        f1 r106 = r105.a();     // Catch: Exception -> L31
        if (r106 != null) goto L18;
        return r101;
    L18:
        String r107 = r106.b();     // Catch: Exception -> L31
        String r108 = "";
        if (r107 != null) goto L22;
        r107 = "";
    L22:
        j0 r109 = r106.a();     // Catch: Exception -> L31
        if (r109 != null) goto L25;
        return r101;
    L25:
        String r110 = r109.a();     // Catch: Exception -> L31
        if (r110 == null) goto L29;
        r108 = r110;
    L29:
        String r111 = String.valueOf(r106.c());     // Catch: Exception -> L31
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L31
        r112.put("play_share_id", r107);     // Catch: Exception -> L31
        r112.put("share_task_fromuser_status", r111);     // Catch: Exception -> L31
        r101.put("share_task_fromuser_info", r112.toString());     // Catch: Exception -> L31
        r101.put(InstantPlayContext.PLAY_ID, r108);     // Catch: Exception -> L31
        r101.put("play_share_id", r107);     // Catch: Exception -> L31
        r101.put("share_module_status", r111);     // Catch: Exception -> L31
    L30:
        return r101;
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<i81.c, Object> getShareInfoMethod(d r100) {
        Intrinsics.checkNotNullParameter(r100, "shareInfoListener");
        return new com.bytedance.android.live.room.share.jsbridge.d(r100);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public f<LiveWebShareParams, Object> getSharePanelMethod(d r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        return new k(r100);
    }

    @Override // com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public Single<i81.b> getShortUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        ALogger.i(TAG, "getShortUrl: " + r100);
        getIHostShare().getShortUrl(r100, this.valueCallback);
        SingleSubject<i81.b> r101 = SingleSubject.create();
        this.liveShareResult = r101;
        return r101;
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Map<String, String> getToUserConversationId(com.bytedance.android.live.base.model.user.f r100) {
        Intrinsics.checkNotNullParameter(r100, "contact");
        return getIHostShare().getToUserConversationId(r100);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean hasLocalLifeShareCoupon(Object r100) {
        return getIHostShare().hasLocalLifeShareCoupon(r100);
    }

    public static final /* synthetic */ void access$setLiveShareResult$p(LiveShareService r100, SingleSubject r101) {
        r100.liveShareResult = r101;
    }

    private final void doDouyinShowShareDialog(i81.a r100, IShareCallback r101) {
        IHostShare r102 = getIHostShare();
        Activity r103 = r100.getActivity();
        ShareParams r104 = r100.f488547d;
        if (r101 != null) goto L5;
        r101 = this.callback;
    L5:
        r102.showShareDialog(r103, r104, r101);
    }

    private final void showShareDialog(i81.a r100, IShareCallback r101) {
        IHostShare r102 = getIHostShare();
        Activity r103 = r100.getActivity();
        ShareParams r104 = r100.f488547d;
        if (r101 != null) goto L5;
        r101 = this.callback;
    L5:
        r102.showNativeShareDialog(r103, r104, r101);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void cacheMob(Context r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "map");
        getIHostShare().cacheMob(r100, r101);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public n56.c getShareMethod(WeakReference<Context> r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "mContextRef");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        return new i(r100, r101);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean isShareAvailable(Activity r100, String r101) {
        ALogger.i(TAG, "isShareAvailable \n hostShareType: " + r101);
        return getIHostShare().isShareAvailable(r101, r100);
    }

    public final void logTrace(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "extraMap");
        Room r102 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoomFromRoomContext();
        int r103 = e.f64997m;
        e.a r104 = e.b.a(r100, "live_share");
        r104.f65012c = "webcast_client_community";
        com.bytedance.android.livesdk.user.f r105 = ((IUserService) jc1.k.n(IUserService.class)).user();
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.n();
    L6:
        r104.f65016g = r107;
        if (r102 == null) goto L9;
        String r108 = r102.getOwnerUserIdString();
    L10:
        r104.f65015f = r108;
        if (r102 == null) goto L13;
        String r109 = r102.getIdStr();
    L14:
        r104.f65014e = r109;
        com.bytedance.android.livesdk.user.f r110 = ((IUserService) jc1.k.n(IUserService.class)).user();
        if (r110 == null) goto L17;
        r106 = r110.n();
    L17:
        r104.f65010a = r106;
        e r111 = r104.a();
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L20
        BaseMonitor.add(r112, "message", r101.toString());     // Catch: Exception -> L20
        com.bytedance.android.live.core.monitor.trace.c.b(r111, r112);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ALogger.e(TAG, "IllegalArgumentException error: " + e.toString());
        return;
    L13:
        r109 = null;
        goto L14
    L9:
        r108 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public boolean openInstallApp(Context r100, String r101) {
        int r102 = com.bytedance.android.live.room.share.util.a.f100376a;
        Intent r103 = null;
        if (r100 != null) goto L21;
        PackageManager r104 = null;
    L8:
        if (r104 == null) goto L12;
        if (r101 != null) goto L11;
        r101 = "";
    L11:
        r103 = r104.getLaunchIntentForPackage(r101);     // Catch: Exception -> L5
    L12:
        if (r103 == null) goto L14;
        r103.addFlags(268435456);     // Catch: Exception -> L5
    L14:
        if (r103 == null) goto L19;
        if (r100 == null) goto L19;
        AppJumpEntry.c(r100, r103, TokenCert.Companion.with("bpea-screen_share_open_third_app"));     // Catch: Exception -> L5
    L5:
        e = move-exception;
        ALogger.e("LiveShareHelper", e.getMessage());
        return false;
    L19:
        return true;
    L21:
        r104 = r100.getPackageManager();     // Catch: Exception -> L5
        goto L8
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void promotion(Activity r100, ShareParams r101) {
        Intrinsics.checkNotNullParameter(r101, "shareParams");
        StringBuilder r102 = new StringBuilder("promotion: ");
        int r103 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.f115581a;
        r102.append(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a(r101.toString()));
        ALogger.i(TAG, r102.toString());
        getIHostShare().promotion(r100, r101);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void reportLiveShareEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "extra");
        u.l().sendLog(r100, r101, new Object[]{x.class, Room.class});
        logTrace(r100, r101);
    }

    public static final /* synthetic */ void access$showShareDialog(LiveShareService r100, i81.a r101, IShareCallback r102) {
        r100.showShareDialog(r101, r102);
    }

    @Override // com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public void getQrCodeInfo(int r100, String r101, Function1<? super String, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "objectId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ALogger.i(TAG, "getQrCodeInfo \n schemaType: " + r100 + " \n objectId: " + r101);
        getIHostShare().getQrCodeInfo(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Disposable showGroupPhotoDialog(Context r100, com.bytedance.android.live.base.model.data.f r101, DataCenter r102) {
        ALogger.i(TAG, "open GroupPhotoDialogFragment");
        if (r101 != null) goto L6;
        ALogger.e(TAG, "GroupPhotoJumpDetail is null");
        return null;
    L6:
        FragmentActivity r103 = ContextUtil.contextToFragmentActivity(r100);
        if (r103 == null) goto L9;
        FragmentManager r104 = r103.getSupportFragmentManager();
    L10:
        if (r104 != null) goto L15;
        FragmentActivity r105 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r105 == null) goto L14;
        r104 = r105.getSupportFragmentManager();
        goto L15
    L14:
        r104 = null;
    L15:
        if (r104 != null) goto L18;
        ALogger.e(TAG, "fragmentManager is null");
        return null;
    L18:
        int r106 = com.bytedance.android.live.room.share.summersinging.k.f100354a;
        Intrinsics.checkNotNullParameter(r101, "groupPhotoDetail");
        Observable r107 = a1.k(r101.groupPhoto).subscribeOn(Schedulers.io()).map(com.bytedance.android.live.room.share.summersinging.i.f100352a).onErrorReturn(j.f100353a);
        IUserService r108 = (IUserService) jc1.k.f(IUserService.class);
        if (r108 == null) goto L25;
        com.bytedance.android.livesdk.user.f r109 = r108.user();
        if (r109 == null) goto L25;
        IUser r110 = r109.b();
        if (r110 == null) goto L25;
        py.k r111 = r110.getAvatarThumb();
    L26:
        Observable r112 = a1.k(r111).subscribeOn(Schedulers.io()).map(com.bytedance.android.live.room.share.summersinging.g.f100350a).onErrorReturn(h.f100351a);
        ALogger.i("GroupPhotoDialogLauncher", "flavor is hotsoon, don't load qr code");
        return Observable.zip(r107, r112, Observable.just(sh6.a.f541970a), com.bytedance.android.live.room.share.summersinging.e.f100346a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorReturnItem(new p(null, null, null)).subscribe(new com.bytedance.android.live.room.share.summersinging.f(r104, r101, r102));
    L25:
        r111 = null;
        goto L26
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public void getQrCodeFromUrl(int r100, String r101, String r102, Function1<? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "objectId");
        Intrinsics.checkNotNullParameter(r102, "editionUid");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ALogger.i(TAG, "getQrCodeFromUrl \n schemaType: " + r100 + " \n objectId: " + r101 + " \n editionUid: " + r102);
        getIHostShare().getQrCodeFromUrl(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService, com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService
    public Single<i81.b> share(final i81.a r110, String r111, LiveShareType r210, IShareCallback r211) {
        final IShareCallback r100 = r211;
        Intrinsics.checkNotNullParameter(r110, "liveShareParams");
        Intrinsics.checkNotNullParameter(r111, "sourcePage");
        Intrinsics.checkNotNullParameter(r210, "shareType");
        StringBuilder r101 = new StringBuilder("liveShareParams: ");
        int r102 = com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.f115581a;
        r101.append(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a(r110.toString()));
        r101.append(" \n sourcePage: ");
        r101.append(r111);
        r101.append(" \n shareType: ");
        r101.append(r210);
        ALogger.i(TAG, r101.toString());
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("source", r111);
        ShareParams r104 = r110.f488547d;
        if (r104 == null) goto L7;
        Map<String, String> r105 = r104.getLogV3Params();
        if (r105 == null) goto L7;
        String r106 = r105.put("source", r111);
    L7:
        r103.put("live_share_type", String.valueOf(r210.ordinal()));
        ShareParams r107 = r110.f488547d;
        Object r108 = null;
        if (r107 == null) goto L10;
        LiveWebShareParams r109 = r107.getLiveWebShareParams();
    L11:
        if (r109 != null) goto L13;
        String r112 = "url";
    L14:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r112);
        if (TextUtils.isEmpty(r111) == true) goto L132;
        int r113 = com.bytedance.android.live.room.share.util.c.f100378a;
        Intrinsics.checkNotNullParameter(r210, "liveShareType");
        Intrinsics.checkNotNullParameter(r110, "liveShareParams");
        Intrinsics.checkNotNullParameter(r103, "logMap");
        switch(com.bytedance.android.live.room.share.util.b.f100377a[r210.ordinal()]) {
            case 1: goto L75;
            case 2: goto L64;
            case 3: goto L45;
            case 4: goto L45;
            case 5: goto L40;
            case 6: goto L29;
            case 7: goto L24;
            case 8: goto L19;
            default: goto L91;
        };
    L19:
        JSONObject r114 = new JSONObject();
        r114.put("report_type", r110.f488554k);
        Unit r115 = Unit.INSTANCE;
        r103.put("params_required", r114.toString());
        if (r110.getActivity() != null) goto L22;
    L23:
        ALogger.e(TAG, "Report_dialog: the input params are abnormal!");
    L90:
        boolean r116 = false;
    L92:
        if (r116 == false) goto L132;
        r103.put("result", "1");
        reportLiveShareEvent("livesdk_experience_link_share_params_check", r103);
        switch(com.bytedance.android.live.room.share.a.f100263a[r210.ordinal()]) {
            case 1: goto L129;
            case 2: goto L119;
            case 3: goto L114;
            case 4: goto L110;
            case 5: goto L102;
            case 6: goto L100;
            case 7: goto L99;
            case 8: goto L98;
            case 9: goto L97;
            default: goto L131;
        };
    L97:
        getIHostShare().showReportDialog(r110.getActivity(), r110.f488547d, r110.f488554k);
        goto L131
    L98:
        getIHostShare().shareText2FansGroup(r110.f488550g, r110.f488551h);
        goto L131
    L99:
        getIHostShare().shareVideo2FansGroups(r110.f488548e, r110.f488549f, r110.f488553j);
        goto L131
    L100:
        getIHostShare().shareActivity(r110.getContext(), r110.f488552i, this.callback);
        this.liveShareResult = SingleSubject.create();
        goto L131
    L110:
        IHostShare r117 = getIHostShare();
        Activity r118 = r110.getActivity();
        ShareParams r119 = r110.f488547d;
        if (r100 != null) goto L113;
        r100 = this.callback;
    L113:
        r117.share(r118, r119, r100);
        this.liveShareResult = SingleSubject.create();
        goto L131
    L114:
        IHostShare r120 = getIHostShare();
        Activity r121 = r110.getActivity();
        com.bytedance.android.live.base.model.user.f r122 = r110.f488546c;
        ShareParams r123 = r110.f488547d;
        if (r100 != null) goto L117;
        r100 = this.callback;
    L117:
        r120.shareLive(r121, r122, r123, r100);
        this.liveShareResult = SingleSubject.create();
        goto L131
    L129:
        getIHostShare().directJsbShare(r110.getContext(), r110.f488557n, r110.f488558o);
        goto L131
    L102:
        if (Intrinsics.areEqual(r110.f488555l, Boolean.TRUE) == true) goto L104;
    L109:
        showShareDialog(r110, r100);
        goto L131
    L104:
        if (vr0.f121473a.getValue().booleanValue() == false) goto L109;
        ShareParams r124 = r110.f488547d;
        if (r124 != null) goto L108;
        r124 = ShareParams.builder().build();
    L108:
        com.bytedance.android.live.room.share.util.a.a(r110, r124, new AnonymousClass2(this, r110, r100));
        goto L131
    L119:
        if (r110.f488560q == false) goto L124;
        ShareParams r125 = r110.f488547d;
        if (r125 != null) goto L123;
        r125 = ShareParams.builder().build();
    L123:
        com.bytedance.android.live.room.share.util.a.a(r110, r125, new AnonymousClass1(this, r110, r100));
    L128:
        this.liveShareResult = SingleSubject.create();
        goto L131
    L124:
        IHostShare r126 = getIHostShare();
        Activity r127 = r110.getActivity();
        ShareParams r128 = r110.f488547d;
        if (r100 != null) goto L127;
        r100 = this.callback;
    L127:
        r126.shareDirect(r127, r128, r100, r110.f488559p);
    L131:
        return this.liveShareResult;
    L22:
        if (TextUtils.isEmpty(r110.f488554k) == false) goto L91;
    L24:
        JSONObject r129 = new JSONObject();
        r129.put("conversation_id", r110.f488550g);
        Unit r130 = Unit.INSTANCE;
        r103.put("params_required", r129.toString());
        if (r110.f488550g != null) goto L27;
    L28:
        ALogger.e(TAG, "Share_text2FansGroups: the input params are abnormal!");
        goto L90
    L27:
        if (TextUtils.isEmpty(r110.f488551h) == false) goto L91;
    L29:
        JSONObject r131 = new JSONObject();
        r131.put("fans_group_id_list", String.valueOf(r110.f488548e));
        r131.put("video_file_path_list", String.valueOf(r110.f488549f));
        Unit r132 = Unit.INSTANCE;
        r103.put("params_required", r131.toString());
        List<String> r133 = r110.f488548e;
        if (r133 != null) goto L32;
    L33:
        List<String> r134 = r110.f488549f;
        if (r134 == null) goto L38;
        if (r134.isEmpty() != true) goto L38;
    L39:
        ALogger.e(TAG, "Share_video2FansGroups: the input params are abnormal!");
    L38:
        if (r110.f488553j != null) goto L91;
    L32:
        if (r133.isEmpty() == true) goto L39;
    L40:
        JSONObject r135 = new JSONObject();
        r135.put("activity_params", String.valueOf(r110.f488552i));
        Unit r136 = Unit.INSTANCE;
        r103.put("params_required", r135.toString());
        if (r110.getContext() != null) goto L43;
    L44:
        ALogger.e(TAG, "Share_activity: the input params are abnormal!");
        goto L90
    L43:
        if (r110.f488552i != null) goto L91;
    L45:
        JSONObject r137 = new JSONObject();
        ShareParams r138 = r110.f488547d;
        if (r138 == null) goto L48;
        LiveWebShareParams r139 = r138.getLiveWebShareParams();
    L49:
        if (r139 != null) goto L51;
        Object r140 = "1";
    L52:
        r137.put("live_web_share_params_is_null", r140);
        ShareParams r141 = r110.f488547d;
        if (r141 == null) goto L57;
        LiveWebShareParams r142 = r141.getLiveWebShareParams();
        if (r142 == null) goto L57;
        String r143 = r142.getPlatform();
    L58:
        r137.put("platform", r143);
        ShareParams r144 = r110.f488547d;
        if (r144 == null) goto L61;
        r108 = r144.getUrl();
    L61:
        r137.put("share_url", r108);
        Unit r145 = Unit.INSTANCE;
        r103.put("params_required", r137.toString());
        if (r110.getActivity() != null) goto L91;
        ALogger.e(TAG, "Share_dialog: the input params are abnormal!");
    L57:
        r143 = null;
        goto L58
    L51:
        r140 = "0";
        goto L52
    L48:
        r139 = null;
        goto L49
    L64:
        JSONObject r146 = new JSONObject();
        ShareParams r147 = r110.f488547d;
        if (r147 == null) goto L67;
        String r148 = r147.getPlatform();
    L68:
        r146.put("platform", r148);
        Unit r149 = Unit.INSTANCE;
        r103.put("params_required", r146.toString());
        if (r110.getActivity() == null) goto L74;
        ShareParams r150 = r110.f488547d;
        if (r150 == null) goto L73;
        r108 = r150.getPlatform();
    L73:
        if (r108 != null) goto L91;
    L74:
        ALogger.e(TAG, "Share_third: the input params are abnormal!");
        goto L90
    L67:
        r148 = null;
        goto L68
    L75:
        JSONObject r151 = new JSONObject();
        r151.put("contact_user", String.valueOf(r110.f488546c));
        ShareParams r152 = r110.f488547d;
        if (r152 == null) goto L80;
        IRoom r153 = r152.getRoom();
        if (r153 == null) goto L80;
        Long r154 = Long.valueOf(r153.getRoomId());
    L81:
        r151.put("room_id", r154);
        Unit r155 = Unit.INSTANCE;
        r103.put("params_required", r151.toString());
        if (r110.getActivity() != null) goto L84;
    L89:
        ALogger.e(TAG, "Share_IM: the input params are abnormal!");
        goto L90
    L84:
        if (r110.f488546c == null) goto L89;
        ShareParams r156 = r110.f488547d;
        if (r156 == null) goto L88;
        r108 = r156.getRoom();
    L88:
        if (r108 != null) goto L91;
    L80:
        r154 = null;
    L91:
        r116 = true;
    L132:
        ALogger.e(TAG, "ShareParams are abnormal!");
        r103.put("result", "0");
        reportLiveShareEvent("livesdk_experience_link_share_params_check", r103);
        return this.liveShareResult;
    L13:
        r112 = "live";
        goto L14
    L10:
        r109 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.room.api.ILiveShareService
    public Disposable initVSPoster(Activity r100, ViewGroup r110, Dialog r111, DialogFragment r112, ICommonLiveSharePackage r113, IVSPosterClickListener r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "posterContainer");
        Intrinsics.checkNotNullParameter(r111, "dialog");
        Intrinsics.checkNotNullParameter(r112, "dialogFragment");
        return getIHostShare().initVSPoster(r100, r110, r111, r112, r113, r114);
    }
}
