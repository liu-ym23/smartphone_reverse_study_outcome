package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import com.alibaba.gaiax.model.GXScroll;
import com.bytedance.android.ec.sdk.helper.l;
import com.bytedance.android.livesdk.livecommerce.livereplay.repository.NetState;
import com.bytedance.android.livesdk.livecommerce.livereplay.utils.ECLiveReplayEventUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010J\u001a\u00020I\u0012\u0006\u0010K\u001a\u00020-\u0012\u0006\u0010L\u001a\u00020\u0018\u0012\u0006\u0010M\u001a\u00020\u0018\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010Q\u001a\u00020P\u0012\u0006\u0010R\u001a\u00020N\u0012\u0006\u0010S\u001a\u00020\u000f¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002Jh\u0010 \u001a\u00020\u00182\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182>\u0010\u001f\u001a:\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00180\u001bH\u0002J\b\u0010!\u001a\u00020\u0004H\u0016J\u0016\u0010\"\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015H\u0016J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0014J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020-H\u0016RD\u0010/\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R)\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160?0>8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010:\u001a\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006V"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardViewModel;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/AbsECScrollProductCardBaseVideModel;", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;", "fold", "", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;", "foldAnim", "changeFoldAnimState", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;", "showSimpleCard", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;", "clickSimpleCard", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;", "stateChanged", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "", "progress", "", "isFromUser", "onProgressListener", "clearDisposable", "", "Lni2/a;", "list", "", "from", RemoteMessageConst.TO, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "predicate", "binarySearchTimeIndex", "clickProductCard", "setPageTimestamp", "count", "setTotalCount", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/NetState;", "state", "setNetworkState", "onInvalidated", "onCleared", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "reportPageInfoForDebug", "Lorg/json/JSONObject;", "getEntranceInfos", "progressListener", "Lkotlin/jvm/functions/Function2;", "canAutoScrollProductCard", "Z", "isFoldAnim", "totalCount", "I", "pageTimestamp", "Ljava/util/List;", "Loi2/b;", "requestParams$delegate", "Lkotlin/Lazy;", "getRequestParams", "()Loi2/b;", "requestParams", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "pagedList$delegate", "getPagedList", "()Landroidx/lifecycle/LiveData;", "pagedList", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/utils/ECLiveReplayEventUtils;", "eventUtils", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/utils/ECLiveReplayEventUtils;", "Lml/b;", "roomInfo", "Lml/a;", "btmInfo", "entranceInfo", "pageSize", "funType", "", "ecomSceneId", "Lxk/a;", "params", "replayId", "replayStartTime", "<init>", "(Lml/b;Lml/a;Lorg/json/JSONObject;IILjava/lang/String;Lxk/a;Ljava/lang/String;J)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardViewModel extends AbsECScrollProductCardBaseVideModel {
    private boolean canAutoScrollProductCard;
    private final ECLiveReplayEventUtils eventUtils;
    private boolean isFoldAnim;
    private List<Long> pageTimestamp;
    private final Lazy pagedList$delegate;
    private final Function2<Long, Boolean, Unit> progressListener;
    private final Lazy requestParams$delegate;
    private volatile int totalCount;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<a.b, Unit> {
        public AnonymousClass1(ECScrollProductCardViewModel r100) {
            super(1, r100, ECScrollProductCardViewModel.class, "fold", "fold(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$Fold;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.b r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ECScrollProductCardViewModel.access$fold((ECScrollProductCardViewModel) this.receiver, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.b r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<a.c, Unit> {
        public AnonymousClass2(ECScrollProductCardViewModel r100) {
            super(1, r100, ECScrollProductCardViewModel.class, "changeFoldAnimState", "changeFoldAnimState(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$FoldAnim;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.c r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ECScrollProductCardViewModel.access$changeFoldAnimState((ECScrollProductCardViewModel) this.receiver, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.c r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<a.C2310a, Unit> {
        public AnonymousClass3(ECScrollProductCardViewModel r100) {
            super(1, r100, ECScrollProductCardViewModel.class, "clickSimpleCard", "clickSimpleCard(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$ClickSimpleCard;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.C2310a r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ECScrollProductCardViewModel.access$clickSimpleCard((ECScrollProductCardViewModel) this.receiver, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.C2310a r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$i;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<a.i, Unit> {
        public AnonymousClass4(ECScrollProductCardViewModel r100) {
            super(1, r100, ECScrollProductCardViewModel.class, "showSimpleCard", "showSimpleCard(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$ShowSimpleCard;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.i r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ECScrollProductCardViewModel.access$showSimpleCard((ECScrollProductCardViewModel) this.receiver, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.i r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/a$f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<a.f, Unit> {
        public AnonymousClass5(ECScrollProductCardViewModel r100) {
            super(1, r100, ECScrollProductCardViewModel.class, GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "onScrollStateChanged(Lcom/bytedance/android/livesdk/livecommerce/livereplay/viewmodel/ECScrollProductCardEvent$OnScrollStateChanged;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(a.f r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ECScrollProductCardViewModel.access$onScrollStateChanged((ECScrollProductCardViewModel) this.receiver, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.f r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModel$onProgressListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C101351 extends MutablePropertyReference0Impl {
        public C101351(ECScrollProductCardViewModel r100) {
            super(r100, ECScrollProductCardViewModel.class, "pageTimestamp", "getPageTimestamp()Ljava/util/List;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ECScrollProductCardViewModel.access$getPageTimestamp$p((ECScrollProductCardViewModel) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ECScrollProductCardViewModel.access$setPageTimestamp$p((ECScrollProductCardViewModel) this.receiver, (List) r100);
        }
    }

    private final oi2.b getRequestParams() {
        return (oi2.b) this.requestParams$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public void clickProductCard() {
        this.canAutoScrollProductCard = false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public LiveData<PagedList<ni2.a>> getPagedList() {
        return (LiveData) this.pagedList$delegate.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public JSONObject getEntranceInfos() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r101 = new JSONObject(getParams().reportParams());     // Catch: Throwable -> L14
        r101.put("ecom_scene_id", getEcomSceneId());     // Catch: Throwable -> L14
        r101.put("episode_id", getReplayId());     // Catch: Throwable -> L14
        r101.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "replay_live_card");     // Catch: Throwable -> L14
        r101.put("carrier_type", "replay_live_card");     // Catch: Throwable -> L14
        r101.put("room_id", getRoomInfo().roomId());     // Catch: Throwable -> L14
        r101.put("anchor_id", getRoomInfo().c());     // Catch: Throwable -> L14
        Map<String, String> r102 = getParams().reportParams();     // Catch: Throwable -> L14
        String r103 = r102.get("enter_from_merge");     // Catch: Throwable -> L14
        if (r103 == null) goto L6;
        r101.put("enter_from_merge", r103);     // Catch: Throwable -> L14
    L6:
        String r104 = r102.get("enter_method");     // Catch: Throwable -> L14
        if (r104 == null) goto L9;
        r101.put("enter_method", r104);     // Catch: Throwable -> L14
    L9:
        String r105 = r102.get("action_type");     // Catch: Throwable -> L14
        if (r105 == null) goto L12;
        r101.put("action_type", r105);     // Catch: Throwable -> L14
    L12:
        Object r106 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L14
    L16:
        JSONObject r107 = new JSONObject();
        if (Result.m9455isFailureimpl(r106) == false) goto L20;
        r106 = r107;
    L20:
        return (JSONObject) r106;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        clearDisposable();
        il.a.a(getHistoryMap());
        getParams().removeReplayProgressListener(this.progressListener);
    }

    private final void clearDisposable() {
        doClear();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void onInvalidated() {
        clearDisposable();
    }

    public static final /* synthetic */ ECLiveReplayEventUtils access$getEventUtils$p(ECScrollProductCardViewModel r100) {
        return r100.eventUtils;
    }

    public static final /* synthetic */ List access$getPageTimestamp$p(ECScrollProductCardViewModel r100) {
        List<Long> r101 = r100.pageTimestamp;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L5:
        return r101;
    }

    public static final /* synthetic */ oi2.b access$getRequestParams$p(ECScrollProductCardViewModel r100) {
        return r100.getRequestParams();
    }

    public static final /* synthetic */ int access$getTotalCount$p(ECScrollProductCardViewModel r100) {
        return r100.totalCount;
    }

    private final void changeFoldAnimState(a.c r100) {
        this.isFoldAnim = r100.f149368a;
    }

    private final void clickSimpleCard(final a.C2310a r110) {
        this.eventUtils.c(getRoomInfo(), r110.f149365a, getReplayId(), getParams().getEcomLiveParams(), getParams().reportParams(), null, null, null);
        long r100 = 1000;
        long r101 = getParams().getReplayProgress() / r100;
        long r102 = r110.f149365a.f519238k - getReplayStartTime();
        long r103 = r110.f149365a.f519239l - getReplayStartTime();
        setState(new C101331(r110));
        if (r102 > r101) goto L9;
        if (r103 < r101) goto L9;
        return;
    L9:
        if (r102 > 0) goto L11;
    L16:
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("[ECScrollProductCardViewModel clickSimpleCard] replayStartTime: " + getReplayStartTime() + " progress: " + r101 + " startTime: " + r102 + " endTime: " + r103 + " is error", null);
        return;
    L11:
        if (r103 <= 0) goto L16;
        if (r102 >= r103) goto L16;
        getParams().seekReplayProgress(r102 * r100);
    }

    private final void fold(a.b r100) {
        if (this.isFoldAnim == false) goto L5;
        return;
    L5:
        setState(new C101341(this));
    }

    private final void onScrollStateChanged(a.f r100) {
        if (r100.f149371a != 1) goto L6;
        this.canAutoScrollProductCard = false;
        return;
    }

    private final void showSimpleCard(a.i r110) {
        this.eventUtils.d(getRoomInfo(), r110.f149375a, getReplayId(), getParams().getEcomLiveParams(), getParams().reportParams(), null, null, null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel
    public void reportPageInfoForDebug(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        l.a(new C101381(this, r100));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a
    public void setNetworkState(NetState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100 == NetState.SUCCESS) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(this, a.d.f149369a);
        return;
    L5:
        com.bytedance.android.ec.core.arch.event.c.d(this, a.h.f149374a);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public void setPageTimestamp(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.pageTimestamp = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.AbsECScrollProductCardBaseVideModel, com.bytedance.android.livesdk.livecommerce.livereplay.repository.b
    public void setTotalCount(int r100) {
        this.totalCount = r100;
    }

    public static final /* synthetic */ void access$changeFoldAnimState(ECScrollProductCardViewModel r100, a.c r101) {
        r100.changeFoldAnimState(r101);
    }

    public static final /* synthetic */ void access$clickSimpleCard(ECScrollProductCardViewModel r100, a.C2310a r101) {
        r100.clickSimpleCard(r101);
    }

    public static final /* synthetic */ void access$fold(ECScrollProductCardViewModel r100, a.b r101) {
        r100.fold(r101);
    }

    public static final /* synthetic */ void access$onScrollStateChanged(ECScrollProductCardViewModel r100, a.f r101) {
        r100.onScrollStateChanged(r101);
    }

    public static final /* synthetic */ void access$setPageTimestamp$p(ECScrollProductCardViewModel r100, List r101) {
        r100.pageTimestamp = r101;
    }

    public static final /* synthetic */ void access$setState(ECScrollProductCardViewModel r100, Function1 r101) {
        r100.setState(r101);
    }

    public static final /* synthetic */ void access$setTotalCount$p(ECScrollProductCardViewModel r100, int r101) {
        r100.totalCount = r101;
    }

    public static final /* synthetic */ void access$showSimpleCard(ECScrollProductCardViewModel r100, a.i r101) {
        r100.showSimpleCard(r101);
    }

    private final void onProgressListener(long r110, boolean r111) {
        if (this.pageTimestamp == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return;
    L8:
        if (r111 == false) goto L11;
        this.canAutoScrollProductCard = true;
        return;
    L11:
        final long r101 = (r110 / ((long) 1000)) + getReplayStartTime();
        if (this.canAutoScrollProductCard == true) goto L14;
        return;
    L14:
        List<Long> r102 = this.pageTimestamp;
        if (r102 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L18:
        if (r101 >= ((Number) CollectionsKt.first(r102)).longValue()) goto L21;
        withState(new C101362(this));
        return;
    L21:
        List<Long> r103 = this.pageTimestamp;
        if (r103 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L24:
        long r104 = ((Number) CollectionsKt.last(r103)).longValue();
        int r105 = -1;
        if (r101 < r104) goto L30;
        List<Long> r106 = this.pageTimestamp;
        if (r106 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L29:
        int r107 = r106.size();
    L44:
        ni2.a r112 = null;
        if (r107 > 0) goto L51;
        dm.a.b r108 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c();
        StringBuilder r109 = new StringBuilder("[ECScrollProductCardViewModel onProgressListener]获取页码不正确 page: ");
        r109.append(r107);
        r109.append(" progress: ");
        r109.append(r110);
        r109.append(" replayStartTime: ");
        r109.append(getReplayStartTime());
        r109.append(" pageTimestamp: ");
        List<Long> r113 = this.pageTimestamp;
        if (r113 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L49:
        r109.append(r113);
        r108.b(r109.toString(), null);
        return;
    L51:
        final int r114 = (r107 - 1) * getPageSize();
        PagedList<ni2.a> r115 = getPagedList().getValue();
        if (r115 == null) goto L54;
        List<ni2.a> r116 = r115.snapshot();
    L55:
        if (r114 < 0) goto L67;
        if (r116 == null) goto L58;
        r105 = r116.size();
    L58:
        if (r114 >= r105) goto L67;
        if (r116 == null) goto L62;
        r112 = (ni2.a) ListProtector.get(r116, r114);
    L62:
        if (r112 != null) goto L65;
        com.bytedance.android.ec.core.arch.event.c.d(this, new a.e(r114));
        return;
    L65:
        final int r117 = binarySearchTimeIndex(r116, r114, RangesKt.coerceAtMost(r116.size(), getPageSize() + r114), new ECScrollProductCardViewModel$onProgressListener$$inlined$let$lambda$1(this, r114, r101));
        final List<ni2.a> r118 = r116;
        withState(new C101373(this, r118, r117, r101));
        return;
    L67:
        com.bytedance.android.ec.core.arch.event.c.d(this, new a.g(r114, false));
        return;
    L54:
        r116 = null;
        goto L55
    L30:
        List<Long> r119 = this.pageTimestamp;
        if (r119 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("pageTimestamp");
    L33:
        Iterator<Long> r120 = r119.iterator();
        int r121 = 0;
    L35:
        if (r120.hasNext() == false) goto L43;
        if (r120.next().longValue() <= r101) goto L39;
        boolean r122 = true;
    L40:
        if (r122 == true) goto L41;
        r121 = r121 + 1;
        goto L35
    L41:
        r107 = r121;
        goto L44
    L39:
        r122 = false;
        goto L40
    L43:
        r107 = -1;
        goto L44
    L5:
        r100 = false;
        goto L6
    }

    public static final /* synthetic */ void access$onProgressListener(ECScrollProductCardViewModel r100, long r101, boolean r102) {
        r100.onProgressListener(r101, r102);
    }

    private final int binarySearchTimeIndex(List<ni2.a> r100, int r101, int r102, Function2<? super List<ni2.a>, ? super Integer, Integer> r103) {
        int r104 = r102 - 1;
    L3:
        if (r101 > r104) goto L10;
        int r105 = ((r104 - r101) / 2) + r101;
        int r106 = r103.invoke(r100, Integer.valueOf(r105)).intValue();
        if (r106 == 0) goto L6;
        if (r106 > 0) goto L8;
        r104 = r105 - 1;
        goto L3
    L8:
        r101 = r105 + 1;
        goto L3
    L6:
        return r105;
    L10:
        return -1;
    }

    public ECScrollProductCardViewModel(final ml.b r110, ml.a r111, JSONObject r112, final int r113, int r114, String r115, final xk.a r116, final String r117, long r118) {
        Intrinsics.checkNotNullParameter(r110, "roomInfo");
        Intrinsics.checkNotNullParameter(r111, "btmInfo");
        Intrinsics.checkNotNullParameter(r112, "entranceInfo");
        Intrinsics.checkNotNullParameter(r115, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r116, "params");
        Intrinsics.checkNotNullParameter(r117, "replayId");
        super(r110, r111, r112, r113, r114, r115, r116, r117, r118);
        ECScrollProductCardViewModel$progressListener$1 r100 = new ECScrollProductCardViewModel$progressListener$1(this);
        this.progressListener = r100;
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.b.class), new AnonymousClass1(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(a.c.class), Dispatchers.getMain(), new AnonymousClass2(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.C2310a.class), new AnonymousClass3(this));
        com.bytedance.android.ec.core.arch.event.c.b(this, Reflection.getOrCreateKotlinClass(a.i.class), new AnonymousClass4(this));
        com.bytedance.android.ec.core.arch.event.c.a(this, Reflection.getOrCreateKotlinClass(a.f.class), Dispatchers.getMain(), new AnonymousClass5(this));
        r116.addReplayProgressListener(r100);
        this.canAutoScrollProductCard = true;
        this.requestParams$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ECScrollProductCardViewModel$requestParams$2(this, r110, r116, r113, r117));
        this.pagedList$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ECScrollProductCardViewModel$pagedList$2(this));
        this.eventUtils = new ECLiveReplayEventUtils(getHistoryMap());
    }
}
