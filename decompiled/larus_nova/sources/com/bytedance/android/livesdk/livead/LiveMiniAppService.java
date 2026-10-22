package com.bytedance.android.livesdk.livead;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.CoverImageModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.business.depend.livead.IMiniAppNetworkCallback;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.DeleteStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.LiveAdAuthResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.SaveStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampInfoResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSearchRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSearchResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSelectionRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSelectionResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.StampSensitiveResponse;
import com.bytedance.android.livehostapi.business.depend.livead.model.UpdateStampRequest;
import com.bytedance.android.livehostapi.business.depend.livead.model.UploadImageResponse;
import com.bytedance.android.livesdk.config.p90;
import com.bytedance.android.livesdk.floatview.IFloatWindowManager;
import com.bytedance.android.livesdk.floatview.VideoFloatWindowManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnetuploader.uploader.api.Parameters;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J/\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fH\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0016\u0010\u001a\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fH\u0016J\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000fH\u0016J\u001e\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0016J\u001e\u0010#\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020$2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020%0\u000fH\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\bH\u0016J\u001e\u0010+\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020,2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fH\u0016J \u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020/0\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/livead/LiveMiniAppService;", "Lcom/bytedance/android/livehostapi/business/depend/livead/ILiveMiniAppService;", "()V", "miniAppShow", "", "changeLiveStreamStatus", "", "status", "", "checkSensitiveTitle", "Lio/reactivex/disposables/Disposable;", "businessType", "title", "", "callback", "Lcom/bytedance/android/livehostapi/business/depend/livead/IMiniAppNetworkCallback;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSensitiveResponse;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/livehostapi/business/depend/livead/IMiniAppNetworkCallback;)Lio/reactivex/disposables/Disposable;", "closeFloatWindow", "deleteStamp", "data", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/DeleteStampRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "getCurrentRoomInfo", "", "getMiniAppActivityState", "hasChangeCoverAuth", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/LiveAdAuthResponse;", "saveStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/SaveStampRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampInfoResponse;", "searchStamp", "request", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSearchResponse;", "selectStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionRequest;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionResponse;", "setMiniAppActivityStatue", "showing", "supportMiniApp", "updateCommerceCount", "count", "updateStamp", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/UpdateStampRequest;", "uploadImage", "filePath", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/UploadImageResponse;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveMiniAppService implements ILiveMiniAppService {
    private boolean miniAppShow;

    public static final class a<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f147608a = null;

        static {
            f147608a = new a();
        }

        public a() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            if (r101.data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147609a;

        public b(IMiniAppNetworkCallback r100) {
            this.f147609a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f147609a.onSuccess((BaseResponse) ((Response) r100).data);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147610a;

        public c(IMiniAppNetworkCallback r100) {
            this.f147610a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147610a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class d<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f147611a = null;

        static {
            f147611a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            if (r101.data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147612a;

        public e(IMiniAppNetworkCallback r100) {
            this.f147612a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f147612a.onSuccess((BaseResponse) ((Response) r100).data);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147613a;

        public f(IMiniAppNetworkCallback r100) {
            this.f147613a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147613a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147614a;

        public g(IMiniAppNetworkCallback r100) {
            this.f147614a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147614a;
            r101.onSuccess((LiveAdAuthResponse) r100);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147615a;

        public h(IMiniAppNetworkCallback r100) {
            this.f147615a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147615a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class i<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f147616a = null;

        static {
            f147616a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            if (r101.data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147617a;

        public j(IMiniAppNetworkCallback r100) {
            this.f147617a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f147617a.onSuccess((BaseResponse) ((Response) r100).data);
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147618a;

        public k(IMiniAppNetworkCallback r100) {
            this.f147618a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147618a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class l<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f147619a = null;

        static {
            f147619a = new l();
        }

        public l() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            if (r101.data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class m<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147620a;

        public m(IMiniAppNetworkCallback r100) {
            this.f147620a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f147620a.onSuccess((BaseResponse) ((Response) r100).data);
        }
    }

    public static final class n<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147621a;

        public n(IMiniAppNetworkCallback r100) {
            this.f147621a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147621a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class o<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f147622a = null;

        static {
            f147622a = new o();
        }

        public o() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            if (r101.data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class p<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147623a;

        public p(IMiniAppNetworkCallback r100) {
            this.f147623a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f147623a.onSuccess((BaseResponse) ((Response) r100).data);
        }
    }

    public static final class q<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147624a;

        public q(IMiniAppNetworkCallback r100) {
            this.f147624a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147624a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class r<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f147625a = null;

        static {
            f147625a = new r();
        }

        public r() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            if (r101.data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class s<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147626a;

        public s(IMiniAppNetworkCallback r100) {
            this.f147626a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f147626a.onSuccess((BaseResponse) ((Response) r100).data);
        }
    }

    public static final class t<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147627a;

        public t(IMiniAppNetworkCallback r100) {
            this.f147627a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147627a;
            r101.onError((Throwable) r100);
        }
    }

    public static final class u<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f147628a = null;

        static {
            f147628a = new u();
        }

        public u() {
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            if (r101.data == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class v<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147629a;

        public v(IMiniAppNetworkCallback r100) {
            this.f147629a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147629a;
            UploadImageResponse r102 = new UploadImageResponse();
            r102.setImageModel((CoverImageModel) ((Response) r100).data);
            Unit r103 = Unit.INSTANCE;
            r101.onSuccess(r102);
        }
    }

    public static final class w<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMiniAppNetworkCallback f147630a;

        public w(IMiniAppNetworkCallback r100) {
            this.f147630a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IMiniAppNetworkCallback r101 = this.f147630a;
            r101.onError((Throwable) r100);
        }
    }

    public LiveMiniAppService() {
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public void closeFloatWindow() {
        com.bytedance.android.livesdk.floatview.q r100 = VideoFloatWindowManager.f125075f;
        IFloatWindowManager.a.a(VideoFloatWindowManager.b.a(), false, 3);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Map<String, String> getCurrentRoomInfo() {
        IRoomService r100 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r100 == null) goto L5;
        Room r101 = r100.getCurrentRoom();
    L6:
        HashMap r102 = new HashMap();
        String r103 = "0";
        if (r101 != null) goto L17;
        IUserService r104 = (IUserService) jc1.k.f(IUserService.class);
        if (r104 == null) goto L16;
        com.bytedance.android.livesdk.user.f r105 = r104.user();
        if (r105 == null) goto L16;
        String r106 = r105.n();
        if (r106 == null) goto L16;
        r103 = r106;
    L16:
        r102.put("anchor_id", r103);
    L22:
        return r102;
    L17:
        String r107 = String.valueOf(r101.getId());
        if (r107 == null) goto L21;
        r103 = r107;
    L21:
        r102.put("room_id", r103);
        r102.put("anchor_id", r101.getOwnerUserIdString());
        goto L22
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.IMiddlewareLiveMiniAppService
    public boolean getMiniAppActivityState() {
        return this.miniAppShow;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public boolean supportMiniApp() {
        return tb1.c.f545229a;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public void changeLiveStreamStatus(int r100) {
        if (r100 != 0) goto L5;
        xs2.b.a().post(new h1(32));
        return;
    L5:
        if (r100 != 1) goto L9;
        xs2.b.a().post(new h1(42));
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable hasChangeCoverAuth(IMiniAppNetworkCallback<LiveAdAuthResponse> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        IHostLiveAd r101 = TTLiveSDK.hostService().hostLiveAd();
        if (r101 == null) goto L6;
        String r102 = r101.getHostDomain();
        if (r102 == null) goto L6;
    L7:
        String r103 = r102.concat(MiniAppConstants.stampCheckAuthList);
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).checkMiniappAuthList(r103).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r100), new h(r100));
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public void setMiniAppActivityStatue(boolean r100) {
        this.miniAppShow = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public void updateCommerceCount(int r100) {
        if (p90.f120961a.getValue().booleanValue() == false) goto L6;
        ((IHostCommerceServiceLive) jc1.k.n(IHostCommerceServiceLive.class)).notifyPromotionNum(r100);
        return;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable deleteStamp(DeleteStampRequest r100, IMiniAppNetworkCallback<BaseResponse> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IHostLiveAd r102 = TTLiveSDK.hostService().hostLiveAd();
        if (r102 == null) goto L6;
        String r103 = r102.getHostDomain();
        if (r103 == null) goto L6;
    L7:
        String r104 = r103.concat(MiniAppConstants.stampDelete);
        String r105 = GsonProtectorUtils.toJson(GsonHelper.get(), r100.getStamps());
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).deleteStamp(r104, String.valueOf(r100.getRoomId()), r105).filter(d.f147611a).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r101), new f(r101));
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable saveStamp(SaveStampRequest r100, IMiniAppNetworkCallback<StampInfoResponse> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = GsonProtectorUtils.toJson(GsonHelper.get(), r100.getStampInfo());
        IHostLiveAd r103 = TTLiveSDK.hostService().hostLiveAd();
        if (r103 == null) goto L6;
        String r104 = r103.getHostDomain();
        if (r104 == null) goto L6;
    L7:
        String r105 = r104.concat(MiniAppConstants.stampSaveUrl);
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).saveStamp(r105, String.valueOf(r100.getRoomId()), r102).filter(i.f147616a).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(r101), new k(r101));
    L6:
        r104 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable searchStamp(StampSearchRequest r100, IMiniAppNetworkCallback<StampSearchResponse> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        IHostLiveAd r102 = TTLiveSDK.hostService().hostLiveAd();
        if (r102 == null) goto L6;
        String r103 = r102.getHostDomain();
        if (r103 == null) goto L6;
    L7:
        String r104 = r103.concat(MiniAppConstants.searchStamp);
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).searchStamp(r104, r100.getType(), r100.getKeyword()).filter(l.f147619a).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r101), new n(r101));
    L6:
        r103 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable selectStamp(StampSelectionRequest r110, IMiniAppNetworkCallback<StampSelectionResponse> r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "callback");
        IHostLiveAd r100 = TTLiveSDK.hostService().hostLiveAd();
        if (r100 == null) goto L6;
        String r101 = r100.getHostDomain();
        if (r101 == null) goto L6;
    L7:
        String r102 = r101.concat(MiniAppConstants.stampSelectionUrl);
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).selectStamp(r102, r110.getType(), r110.getTabId(), r110.getPage(), r110.getPageSize()).filter(o.f147622a).compose(RxUtil.rxSchedulerHelper()).subscribe(new p(r111), new q(r111));
    L6:
        r101 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable updateStamp(UpdateStampRequest r100, IMiniAppNetworkCallback<BaseResponse> r110) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r110, "callback");
        IHostLiveAd r101 = TTLiveSDK.hostService().hostLiveAd();
        if (r101 == null) goto L6;
        String r102 = r101.getHostDomain();
        if (r102 == null) goto L6;
    L7:
        String r103 = r102.concat(MiniAppConstants.stampStatusUpdate);
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).updateStamp(r103, String.valueOf(r100.getRoomId()), r100.getType(), r100.getStampId(), r100.getStatus()).filter(r.f147625a).compose(RxUtil.rxSchedulerHelper()).subscribe(new s(r110), new t(r110));
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable uploadImage(String r100, IMiniAppNetworkCallback<UploadImageResponse> r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "callback");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L6;
        r101.onError(new Exception("avatar file don't exists in path " + r100));
        return null;
    L6:
        MultipartTypedOutput r103 = new MultipartTypedOutput();
        r103.addPart("file", new TypedFile(Parameters.CONTENT_TYPE_MULTIPART_FORM, r102));
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).uploadAvatar(r103).filter(u.f147628a).compose(RxUtil.rxSchedulerHelper()).subscribe(new v(r101), new w(r101));
    }

    @Override // com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService
    public Disposable checkSensitiveTitle(Integer r100, String r101, IMiniAppNetworkCallback<StampSensitiveResponse> r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        IHostLiveAd r103 = TTLiveSDK.hostService().hostLiveAd();
        if (r103 == null) goto L6;
        String r104 = r103.getHostDomain();
        if (r104 == null) goto L6;
    L7:
        String r105 = r104.concat(MiniAppConstants.stampSensitiveCheck);
        return ((ILiveMiniAppApi) com.bytedance.android.live.network.c.b().e(ILiveMiniAppApi.class)).checkStamp(r105, r100, r101).filter(a.f147608a).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r102), new c(r102));
    L6:
        r104 = "";
        goto L7
    }
}
