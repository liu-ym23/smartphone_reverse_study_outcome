package com.bytedance.android.gamecp.business.comment.edit;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.gamecp.base.network.exception.ApiServerException;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.business.api.edit.GameCommentEditApi;
import com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel;
import com.bytedance.android.gamecp.business.comment.edit.upload.CommentImgUploadCenter;
import com.bytedance.android.gamecp.common.utils.GameCPSafeConvertUtils;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.gamecp.host_api.model.ImageModelLive;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.alog.middleware.ALogService;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b!\u0018\u00002\u00020\u00012\u00020\u0002:\u0001rB\u0007¢\u0006\u0004\bp\u0010qJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002JR\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00120\u001c2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0019j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015`\u001aH\u0002J\u001a\u0010 \u001a\u00020\t2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001eH\u0002J&\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00122\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00170!j\b\u0012\u0004\u0012\u00020\u0017`\"H\u0002J\b\u0010&\u001a\u00020\tH\u0002J\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010!j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\"J\u0010\u0010*\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010(J\u0010\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010+J\u0010\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010.J6\u00106\u001a\u00020\t2\u0006\u00102\u001a\u00020\u00152\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u0002002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J&\u00108\u001a\u00020\t2\u0006\u0010/\u001a\u00020.2\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u00170!j\b\u0012\u0004\u0012\u00020\u0017`\"J\u000e\u0010:\u001a\u00020\t2\u0006\u00109\u001a\u00020\u0017J$\u0010>\u001a\u00020\t2\u0006\u0010<\u001a\u00020;2\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t\u0018\u00010=J\b\u0010?\u001a\u00020\tH\u0014J\t\u0010@\u001a\u00020\tH\u0096\u0001J\u0011\u0010C\u001a\u00020\t2\u0006\u0010B\u001a\u00020AH\u0096\u0001J\r\u0010D\u001a\u00020\t*\u00020AH\u0096\u0001R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020+0E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR-\u0010P\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00170!j\b\u0012\u0004\u0012\u00020\u0017`\"0E8\u0006¢\u0006\f\n\u0004\bP\u0010G\u001a\u0004\bQ\u0010IR!\u0010U\u001a\b\u0012\u0004\u0012\u00020R0E8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010L\u001a\u0004\bT\u0010IR$\u0010V\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010\\\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010h\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010c\u001a\u0004\bi\u0010e\"\u0004\bj\u0010gR$\u0010k\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010c\u001a\u0004\bl\u0010e\"\u0004\bm\u0010gR\u0016\u0010n\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010]R\u0016\u0010o\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010]¨\u0006s"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/edit/CommentEditViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/bytedance/android/gamecp/business/comment/data/o;", "commentInfo", "Lds/b;", "commentSourceInfo", "Lcom/bytedance/android/gamecp/business/comment/data/GamePromoteCommentViewModel$f;", "listener", "", "uploadComment", "Lcom/bytedance/android/gamecp/base/network/response/h;", "Lcom/bytedance/android/gamecp/business/comment/data/q;", "response", "onCommentSuc", "", "error", LynxVideoManagerLite.EVENT_ON_ERROR, "", "Lcom/bytedance/android/gamecp/host_api/model/ImageModel;", "imageModelList", "", "deliverImage", "Lcom/bytedance/android/gamecp/base/core/service/depend/w;", "uploadList", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "uploadResult", "Lkotlin/Pair;", "onUploadResult", "Lkotlin/Function0;", "block", "withImageSelectUpdate", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mediaModelList", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "getImageModelList", "clearSelectImage", "getSelectImage", "Landroid/os/Bundle;", "arguments", "parseArgs", "Lcom/bytedance/android/gamecp/business/comment/edit/v;", "entranceInfo", "initData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "checkIsLogin", "inputContext", "", "inputScore", "showDeviceSeries", "makeComment", "originalList", "uploadImage", "removeMediaModel", "removeSelectedImage", "", "startCount", "Lkotlin/Function1;", "commitScore", "onCleared", "dispose", "Lio/reactivex/disposables/Disposable;", "d", "remove", "autoDispose", "Landroidx/lifecycle/MutableLiveData;", "commentEntranceInfo", "Landroidx/lifecycle/MutableLiveData;", "getCommentEntranceInfo", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/gamecp/business/comment/edit/upload/CommentImgUploadCenter;", "commentImgUploadCenter$delegate", "Lkotlin/Lazy;", "getCommentImgUploadCenter", "()Lcom/bytedance/android/gamecp/business/comment/edit/upload/CommentImgUploadCenter;", "commentImgUploadCenter", "imageList", "getImageList", "Lcom/bytedance/android/gamecp/business/comment/edit/CommentEditViewModel$LoadingStatus;", "loadingStatus$delegate", "getLoadingStatus", "loadingStatus", "currentPercent", "Ljava/lang/Integer;", "getCurrentPercent", "()Ljava/lang/Integer;", "setCurrentPercent", "(Ljava/lang/Integer;)V", "enterFromPortrait", "Z", "getEnterFromPortrait", "()Z", "setEnterFromPortrait", "(Z)V", "gameId", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "enterWay", "getEnterWay", "setEnterWay", "enterPage", "getEnterPage", "setEnterPage", "isRequesting", "isInNetworkRequest", "<init>", "()V", "LoadingStatus", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentEditViewModel extends ViewModel {
    private final /* synthetic */ com.bytedance.android.gamecp.common.utils.rxutils.a $$delegate_0;
    private final MutableLiveData<v> commentEntranceInfo;
    private final Lazy commentImgUploadCenter$delegate;
    private Integer currentPercent;
    private boolean enterFromPortrait;
    private String enterPage;
    private String enterWay;
    private String gameId;
    private final MutableLiveData<ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w>> imageList;
    private boolean isInNetworkRequest;
    private boolean isRequesting;
    private final Lazy loadingStatus$delegate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/edit/CommentEditViewModel$LoadingStatus;", "", "LOADING", "ERROR", "SUCCESS", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LoadingStatus extends Enum<LoadingStatus> {
        public static final LoadingStatus ERROR = null;
        public static final LoadingStatus LOADING = null;
        public static final LoadingStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadingStatus[] f52062a = null;

        static {
            LoadingStatus r100 = new LoadingStatus("LOADING", 0);
            LOADING = r100;
            LoadingStatus r101 = new LoadingStatus("ERROR", 1);
            ERROR = r101;
            LoadingStatus r102 = new LoadingStatus("SUCCESS", 2);
            SUCCESS = r102;
            f52062a = new LoadingStatus[]{r100, r101, r102};
        }

        public static LoadingStatus valueOf(String r100) {
            return (LoadingStatus) r27.a.a(LoadingStatus.class, r100);
        }

        public static LoadingStatus[] values() {
            return (LoadingStatus[]) f52062a.clone();
        }

        public LoadingStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentEditViewModel f52063a;

        public a(CommentEditViewModel r100) {
            this.f52063a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f52063a.getCommentEntranceInfo().postValue(new v(this.f52063a.getGameId(), "", ((ds.a) ((com.bytedance.android.gamecp.base.network.response.i) r100).data).commentEntranceInfo));
            CommentEditViewModel.access$setRequesting$p(this.f52063a, false);
            this.f52063a.getLoadingStatus().postValue(LoadingStatus.SUCCESS);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentEditViewModel f52064a;

        public b(CommentEditViewModel r100) {
            this.f52064a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = ((Throwable) r100).getMessage();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            yr.c.b("CommentEditViewModel", r101);
            CommentEditViewModel.access$setRequesting$p(this.f52064a, false);
            this.f52064a.getLoadingStatus().postValue(LoadingStatus.ERROR);
        }
    }

    public static final class c implements GamePromoteCommentViewModel.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentEditViewModel f52065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel.f f52066b;

        @Override // com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel.f
        public final void onFail() {
            GamePromoteCommentViewModel.f r100 = this.f52066b;
            if (r100 == null) goto L6;
            r100.onFail();
            return;
        }

        public c(CommentEditViewModel r100, GamePromoteCommentViewModel.f r101) {
            this.f52065a = r100;
            this.f52066b = r101;
        }

        @Override // com.bytedance.android.gamecp.business.comment.data.GamePromoteCommentViewModel.f
        public final void a(com.bytedance.android.gamecp.business.comment.data.b r100, long r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            r100.f52035a = 8;
            com.bytedance.android.gamecp.business.comment.data.o r102 = r100.evaluationInfo;
            if (r102 == null) goto L7;
            r102.isOwnEvaluation = Boolean.TRUE;
        L7:
            jv.a.a().b(new w(this.f52065a.getGameId(), r100));
            GamePromoteCommentViewModel.f r103 = this.f52066b;
            if (r103 == null) goto L11;
            r103.a(r100, r101);
            return;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentEditViewModel f52067a;

        public d(CommentEditViewModel r100) {
            this.f52067a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            CommentEditViewModel.access$setInNetworkRequest$p(this.f52067a, false);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentEditViewModel f52068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel.f f52069b;

        public e(CommentEditViewModel r100, GamePromoteCommentViewModel.f r101) {
            this.f52068a = r100;
            this.f52069b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.gamecp.base.network.response.h r101 = (com.bytedance.android.gamecp.base.network.response.h) r100;
            if (r101 != null) goto L5;
            return;
        L5:
            if (((com.bytedance.android.gamecp.business.comment.data.q) r101.data).auditToast.length() <= 0) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == false) goto L10;
            ToastUtil.b(((com.bytedance.android.gamecp.business.comment.data.q) r101.data).auditToast, 0);
        L10:
            int r103 = ((com.bytedance.android.gamecp.business.comment.data.q) r101.data).auditStatus;
            if (r103 != 0) goto L13;
        L20:
            CommentEditViewModel.access$onCommentSuc(this.f52068a, r101, this.f52069b);
            return;
        L13:
            if (r103 != 2) goto L15;
            GamePromoteCommentViewModel.f r104 = this.f52069b;
            if (r104 == null) goto L23;
            r104.onFail();
            return;
        L23:
            return;
        L15:
            if (r103 == 3) goto L20;
            return;
        L7:
            r102 = false;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentEditViewModel f52070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GamePromoteCommentViewModel.f f52071b;

        public f(CommentEditViewModel r100, GamePromoteCommentViewModel.f r101) {
            this.f52070a = r100;
            this.f52071b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (r101 == null) goto L5;
            CommentEditViewModel.access$onError(this.f52070a, r101);
        L5:
            GamePromoteCommentViewModel.f r102 = this.f52071b;
            if (r102 == null) goto L9;
            r102.onFail();
            return;
        }
    }

    private final CommentImgUploadCenter getCommentImgUploadCenter() {
        return (CommentImgUploadCenter) this.commentImgUploadCenter$delegate.getValue();
    }

    public final MutableLiveData<LoadingStatus> getLoadingStatus() {
        return (MutableLiveData) this.loadingStatus$delegate.getValue();
    }

    private final void clearSelectImage() {
        withImageSelectUpdate(new AnonymousClass1(this));
    }

    public void dispose() {
        this.$$delegate_0.f57286a.clear();
    }

    public final ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w> getSelectImage() {
        return this.imageList.getValue();
    }

    public CommentEditViewModel() {
        this.$$delegate_0 = new com.bytedance.android.gamecp.common.utils.rxutils.a();
        this.commentEntranceInfo = new MutableLiveData();
        this.commentImgUploadCenter$delegate = LazyKt.lazy(CommentEditViewModel$commentImgUploadCenter$2.INSTANCE);
        MutableLiveData<ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w>> r100 = new MutableLiveData();
        r100.postValue(new ArrayList());
        Unit r101 = Unit.INSTANCE;
        this.imageList = r100;
        this.loadingStatus$delegate = LazyKt.lazy(CommentEditViewModel$loadingStatus$2.INSTANCE);
        this.enterFromPortrait = true;
        this.gameId = "";
        this.enterWay = "";
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        clearSelectImage();
        dispose();
        super.onCleared();
    }

    public final MutableLiveData<v> getCommentEntranceInfo() {
        return this.commentEntranceInfo;
    }

    public final Integer getCurrentPercent() {
        return this.currentPercent;
    }

    public final boolean getEnterFromPortrait() {
        return this.enterFromPortrait;
    }

    public final String getEnterPage() {
        return this.enterPage;
    }

    public final String getEnterWay() {
        return this.enterWay;
    }

    public final String getGameId() {
        return this.gameId;
    }

    public final MutableLiveData<ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w>> getImageList() {
        return this.imageList;
    }

    public static final /* synthetic */ boolean access$isInNetworkRequest$p(CommentEditViewModel r100) {
        return r100.isInNetworkRequest;
    }

    public static final /* synthetic */ boolean access$isRequesting$p(CommentEditViewModel r100) {
        return r100.isRequesting;
    }

    private final String deliverImage(List<? extends ImageModel> r100) {
        JSONArray r101 = new JSONArray();
        if (r100 == null) goto L9;
        Iterator<? extends ImageModel> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        ImageModel r103 = r102.next();
        JSONObject r104 = new JSONObject();
        r104.put("uri", r103.getUri());
        r104.put("width", r103.getWidth());
        r104.put("height", r103.getHeight());
        r101.put(r104);
    L9:
        return r101.toString();
    }

    private final List<ImageModelLive> getImageModelList(ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w> r110) {
        ArrayList r100 = new ArrayList();
        Iterator<com.bytedance.android.gamecp.base.core.service.depend.w> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        com.bytedance.android.gamecp.base.core.service.depend.w r101 = r111.next();
        ImageModelLive r102 = new ImageModelLive();
        r102.setUri(r101.f51417g);
        r102.setWidth(r101.f51426p);
        r102.setHeight(r101.f51427q);
        r100.add(r102);
        goto L4
    L6:
        StringBuilder r112 = new StringBuilder("评论带图片 ");
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r103.add(((ImageModelLive) r104.next()).getUri());
        goto L8
    L10:
        r112.append(CollectionsKt.joinToString$default(r103, null, null, null, 0, null, AnonymousClass2.INSTANCE, 31, null));
        yr.c.e("CommentEditorDialogV2", r112.toString());
        return r100;
    }

    private final void onError(Throwable r100) {
        if ((r100 instanceof ApiServerException) == false) goto L5;
        ToastUtil.b(((ApiServerException) r100).getPrompt(), 0);
    L5:
        ALogService.statcktraceSafely(6, GamePromoteCommentViewModel.TAG, r100.getStackTrace());
    }

    private final void withImageSelectUpdate(Function0<Unit> r100) {
        if (r100 == null) goto L4;
        Unit r101 = r100.invoke();
    L4:
        MutableLiveData<ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w>> r102 = this.imageList;
        r102.postValue(r102.getValue());
    }

    public void autoDispose(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        com.bytedance.android.gamecp.common.utils.rxutils.a r101 = this.$$delegate_0;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        r101.f57286a.add(r100);
    }

    public final boolean checkIsLogin(Context r100) {
        if (com.bytedance.android.gamecp.host_api.a.b().getUserService().user().isLogin() == true) goto L6;
        autoDispose(com.bytedance.android.gamecp.host_api.a.b().getUserService().user().c(r100, new com.bytedance.android.gamecp.host_api.model.user.c(new com.bytedance.android.gamecp.host_api.model.user.c.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(hv.d.f487274b, hv.d.f487273a));
        ToastUtil.b(y0.i(R.string.ttlive_game_promote_login_to_comment), 0);
        return false;
    L6:
        return true;
    }

    public final void initData(v r100) {
        if (r100 != null) goto L4;
    L7:
        if (r100 == null) goto L10;
        return;
    L10:
        if (this.isRequesting == false) goto L12;
        return;
    L12:
        this.isRequesting = true;
        getLoadingStatus().postValue(LoadingStatus.LOADING);
        Disposable r101 = ((GameCommentEditApi) bs.e.a().b(GameCommentEditApi.class)).getCommentEditLimit(this.gameId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), new b(this));
        if (r101 == null) goto L16;
        autoDispose(r101);
        return;
    L16:
        return;
    L4:
        if (StringsKt.isBlank(this.gameId) == false) goto L6;
        this.gameId = r100.f52197a;
    L6:
        this.commentEntranceInfo.postValue(r100);
        getLoadingStatus().postValue(LoadingStatus.SUCCESS);
        goto L7
    }

    public final void parseArgs(Bundle r100) {
        if (r100 == null) goto L4;
        int r101 = com.bytedance.android.gamecp.business.gamedetail.f.f55299a;
        Integer r102 = com.bytedance.android.gamecp.business.gamedetail.f.a(r100, "rating", 0);
    L5:
        this.currentPercent = r102;
        if (r100 == null) goto L13;
        int r103 = com.bytedance.android.gamecp.business.gamedetail.f.f55299a;
        Boolean r104 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r100, "$this$getBooleanSafe");
        Intrinsics.checkNotNullParameter("enter_from_portrait", "key");
        int r105 = GameCPSafeConvertUtils.f57158a;
        Boolean r106 = GameCPSafeConvertUtils.b(r100.get("enter_from_portrait"));
        if (r106 == null) goto L11;
        r104 = r106;
    L11:
        if (r104 == null) goto L13;
        boolean r107 = r104.booleanValue();
    L14:
        this.enterFromPortrait = r107;
        String r108 = "";
        if (r100 == null) goto L18;
        String r109 = com.bytedance.android.gamecp.business.gamedetail.f.b(r100, "game_id");
        if (r109 == null) goto L18;
    L19:
        this.gameId = r109;
        if (r100 == null) goto L25;
        String r110 = com.bytedance.android.gamecp.business.gamedetail.f.b(r100, "enter_way");
        if (r110 == null) goto L25;
        r108 = r110;
    L25:
        this.enterWay = r108;
        return;
    L18:
        r109 = "";
    L13:
        r107 = true;
        goto L14
    L4:
        r102 = null;
        goto L5
    }

    public void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
        com.bytedance.android.gamecp.common.utils.rxutils.a r101 = this.$$delegate_0;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "d");
        r101.f57286a.remove(r100);
    }

    public final void removeSelectedImage(com.bytedance.android.gamecp.base.core.service.depend.w r100) {
        Intrinsics.checkNotNullParameter(r100, "removeMediaModel");
        ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w> r101 = this.imageList.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r100.f51413c;
        Iterator<com.bytedance.android.gamecp.base.core.service.depend.w> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        com.bytedance.android.gamecp.base.core.service.depend.w r104 = r103.next();
        int r105 = r104.f51413c;
        if (r105 <= r102) goto L7;
        r104.f51413c = r105 - 1;
        goto L7
    L11:
        r101.remove(r100);
        String r106 = r100.f51415e;
        if (r106 == null) goto L21;
        CommentImgUploadCenter r107 = getCommentImgUploadCenter();
        monitor-enter(r107);
        Intrinsics.checkNotNullParameter(r106, "path");     // Catch: Throwable -> L18
        r107.f52178a.remove(r106);     // Catch: Throwable -> L18
        monitor-exit(r107);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void setCurrentPercent(Integer r100) {
        this.currentPercent = r100;
    }

    public final void setEnterFromPortrait(boolean r100) {
        this.enterFromPortrait = r100;
    }

    public final void setEnterPage(String r100) {
        this.enterPage = r100;
    }

    public final void setEnterWay(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterWay = r100;
    }

    public final void setGameId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameId = r100;
    }

    public static final /* synthetic */ void access$onError(CommentEditViewModel r100, Throwable r101) {
        r100.onError(r101);
    }

    public static final /* synthetic */ void access$setInNetworkRequest$p(CommentEditViewModel r100, boolean r101) {
        r100.isInNetworkRequest = r101;
    }

    public static final /* synthetic */ void access$setRequesting$p(CommentEditViewModel r100, boolean r101) {
        r100.isRequesting = r101;
    }

    public static final /* synthetic */ void access$withImageSelectUpdate(CommentEditViewModel r100, Function0 r101) {
        r100.withImageSelectUpdate(r101);
    }

    private final void onCommentSuc(com.bytedance.android.gamecp.base.network.response.h<com.bytedance.android.gamecp.business.comment.data.q> r100, GamePromoteCommentViewModel.f r101) {
        HashSet<String> r102 = es.a.f473675a;
        es.a.a(this.gameId);
        List<? extends com.bytedance.android.gamecp.business.comment.data.b> r103 = r100.data.userDetailList;
        com.bytedance.android.gamecp.business.comment.data.b r104 = null;
        if (r103 != null) goto L5;
    L10:
        if (r101 == null) goto L13;
        r101.a(r104, r100.data.evaluationId);
        return;
    L13:
        return;
    L5:
        if ((!r103.isEmpty()) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L10;
        r104 = (com.bytedance.android.gamecp.business.comment.data.b) ListProtector.get(r103, 0);
        goto L10
    }

    private final Pair<List<com.bytedance.android.gamecp.base.core.service.depend.w>, List<com.bytedance.android.gamecp.base.core.service.depend.w>> onUploadResult(List<? extends com.bytedance.android.gamecp.base.core.service.depend.w> r100, LinkedHashMap<String, String> r101) {
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        com.bytedance.android.gamecp.base.core.service.depend.w r106 = (com.bytedance.android.gamecp.base.core.service.depend.w) r105;
        String r107 = r106.f51415e;
        if (r101 == null) goto L14;
        boolean r108 = r101.containsKey(r107);
        if (r108 == false) goto L10;
        r106.f51417g = r101.get(r106.f51415e);
    L11:
        if (r108 == false) goto L4;
        r103.add(r105);
        goto L4
    L10:
        r102.add(r106);
        goto L11
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L16:
        return TuplesKt.to(r103, r102);
    }

    public final void commitScore(int r100, final Function1<? super String, Unit> r101) {
        int r102 = com.bytedance.android.gamecp.business.comment.edit.help.g.f52154a;
        String r103 = this.gameId;
        v r104 = this.commentEntranceInfo.getValue();
        if (r104 == null) goto L6;
        String r105 = r104.f52198b;
        if (r105 == null) goto L6;
    L7:
        Disposable r106 = com.bytedance.android.gamecp.business.comment.edit.help.g.a(r103, r100, r105, new C98671(r101));
        if (r106 == null) goto L11;
        autoDispose(r106);
        return;
    L11:
        return;
    L6:
        r105 = "";
        goto L7
    }

    public final void uploadImage(Context r100, ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "originalList");
        final ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L13;
        Object r105 = r103.next();
        String r106 = ((com.bytedance.android.gamecp.base.core.service.depend.w) r105).f51415e;
        if (r106 != null) goto L8;
    L9:
        r104 = true;
    L11:
        if ((!r104) == false) goto L3;
        r102.add(r105);
        goto L3
    L8:
        if (r106.length() != 0) goto L11;
    L13:
        System.currentTimeMillis();
        CommentImgUploadCenter r107 = getCommentImgUploadCenter();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r102.iterator();
    L15:
        if (r109.hasNext() == false) goto L19;
        String r110 = ((com.bytedance.android.gamecp.base.core.service.depend.w) r109.next()).f51415e;
        if (r110 == null) goto L15;
        r108.add(r110);
        goto L15
    L19:
        r107.b(r108, r100, false, new C98682(this, r102));
    }

    public static final /* synthetic */ void access$onCommentSuc(CommentEditViewModel r100, com.bytedance.android.gamecp.base.network.response.h r101, GamePromoteCommentViewModel.f r102) {
        r100.onCommentSuc(r101, r102);
    }

    public static final /* synthetic */ Pair access$onUploadResult(CommentEditViewModel r100, List r101, LinkedHashMap r102) {
        return r100.onUploadResult(r101, r102);
    }

    private final void uploadComment(com.bytedance.android.gamecp.business.comment.data.o r110, ds.b r111, GamePromoteCommentViewModel.f r112) {
        if (this.isInNetworkRequest == false) goto L5;
        return;
    L5:
        this.isInNetworkRequest = true;
        String r100 = deliverImage(r110.imageList);
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if (r111 == null) goto L9;
        String r113 = e1.a(r111);     // Catch: Throwable -> L12
    L10:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r114) == true) goto L18;
        r101 = r114;
    L18:
        Observable<com.bytedance.android.gamecp.base.network.response.h<com.bytedance.android.gamecp.business.comment.data.q>> r115 = ((GamePromoteApi) bs.e.a().b(GamePromoteApi.class)).makeComment(r110.gameId, Double.valueOf(r110.score), r110.content, Long.valueOf(r110.submitTime), r100, r110.deviceSeries, (String) r101);
        hv.b r116 = hv.d.f487273a;
        Disposable r117 = r115.compose(new hv.a()).doFinally(new d(this)).subscribe(new e(this, r112), new f(this, r112));
        if (r117 == null) goto L24;
        autoDispose(r117);
        return;
    L24:
        return;
    L9:
        r113 = null;
    L12:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void withImageSelectUpdate$default(CommentEditViewModel r100, Function0 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        r100.withImageSelectUpdate(r101);
    }

    public final void makeComment(String r100, double r101, boolean r102, ds.b r103, GamePromoteCommentViewModel.f r104) {
        Intrinsics.checkNotNullParameter(r100, "inputContext");
        com.bytedance.android.gamecp.business.comment.data.o r105 = new com.bytedance.android.gamecp.business.comment.data.o();
        r105.content = r100;
        r105.gameId = this.gameId;
        r105.score = r101;
        r105.submitTime = System.currentTimeMillis() / ((long) 1000);
        ArrayList<com.bytedance.android.gamecp.base.core.service.depend.w> r106 = getSelectImage();
        if (r106 != null) goto L5;
        r106 = new ArrayList();
    L5:
        r105.imageList = getImageModelList(r106);
        if (r102 == false) goto L15;
        v r107 = this.commentEntranceInfo.getValue();
        if (r107 == null) goto L13;
        com.bytedance.android.gamecp.business.comment.data.d r108 = r107.f52199c;
        if (r108 == null) goto L13;
        String r109 = r108.deviceSeries;
        if (r109 == null) goto L13;
    L14:
        r105.deviceSeries = r109;
    L13:
        r109 = "";
    L15:
        uploadComment(r105, r103, new c(this, r104));
    }

    public static /* synthetic */ void uploadComment$default(CommentEditViewModel r100, com.bytedance.android.gamecp.business.comment.data.o r101, ds.b r102, GamePromoteCommentViewModel.f r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.uploadComment(r101, r102, r103);
    }

    public static /* synthetic */ void makeComment$default(CommentEditViewModel r100, String r110, double r111, boolean r112, ds.b r113, GamePromoteCommentViewModel.f r114, int r115, Object r116) {
        if ((r115 & 8) == 0) goto L5;
        ds.b r101 = null;
    L7:
        if ((r115 & 16) == 0) goto L9;
        GamePromoteCommentViewModel.f r102 = null;
    L10:
        r100.makeComment(r110, r111, r112, r101, r102);
        return;
    L9:
        r102 = r114;
        goto L10
    L5:
        r101 = r113;
        goto L7
    }
}
