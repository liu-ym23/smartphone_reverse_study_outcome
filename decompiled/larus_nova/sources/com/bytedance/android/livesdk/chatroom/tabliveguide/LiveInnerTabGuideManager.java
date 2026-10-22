package com.bytedance.android.livesdk.chatroom.tabliveguide;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.smartclient.ILiveSmartClientManager;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.utils.f5;
import com.bytedance.android.livesdk.utils.z4;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.PaidLiveTypeModifyData;
import com.bytedance.android.livesdkapi.depend.message.PreviewUserBlockMessage;
import com.bytedance.android.livesdkapi.depend.message.WebcastPaidLiveTypeModifyMessage;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001B\u0018\u0000 O2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\bM\u0010NJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J&\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\u001e\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nJ\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\"R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010(R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00106\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010<\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u0016\u0010?\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00102R\u0016\u0010@\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00102R\u0016\u0010A\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00102R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/tabliveguide/LiveInnerTabGuideManager;", "Lcom/bytedance/live/datacontext/DataContext;", "", "roomId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "registerMessage", "unRegisterMessage", "removePitayaObserver", "", "toastStr", "onMessage", "Landroid/os/Bundle;", "args", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "", "insertPosition", UploadTypeInf.TIMER, "requestFeedInnerCard", "Lcom/bytedance/android/livesdk/chatroom/tabliveguide/b;", "getInnerCardData", "insertInnerCard", "removeInnerCardItem", "Landroidx/lifecycle/LifecycleOwner;", "lifeCycleOwner", LynxVideoManagerLite.EVENT_ON_FIRST_FRAME, "stopTimer", "onPageSelected", "onPageUnSelected", "clickArea", "anchorId", "logCardClick", "", "getCommonMobParams", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPlayFragment$LiveRoomListener;", "liveRoomListener", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRoomPlayFragment$LiveRoomListener;", "insertRoomIndex", "I", "getInsertRoomIndex", "()I", "setInsertRoomIndex", "(I)V", "Lio/reactivex/disposables/Disposable;", "timeDisposable", "Lio/reactivex/disposables/Disposable;", "", "hasTimer", "Z", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedItem", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "enterFromMerge", "Ljava/lang/String;", "getEnterFromMerge", "()Ljava/lang/String;", "setEnterFromMerge", "(Ljava/lang/String;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "hasInsert", "needRemoveFromMsg", "isShowing", "com/bytedance/android/livesdk/chatroom/tabliveguide/LiveInnerTabGuideManager$c", "messageListener", "Lcom/bytedance/android/livesdk/chatroom/tabliveguide/LiveInnerTabGuideManager$c;", "Lvlc/d;", "messageManager", "Lvlc/d;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "result", "Lcom/bytedance/android/livesdk/chatroom/tabliveguide/b;", "<init>", "()V", "Companion", "b", "livesdkshell_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerTabGuideManager extends DataContext {
    public static final b Companion = null;
    private static final String TAG = "LiveInnerTabGuideManager";

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f111647cd;
    private String enterFromMerge;
    private String enterMethod;
    private FeedItem feedItem;
    private boolean hasInsert;
    private boolean hasTimer;
    private int insertRoomIndex;
    private boolean isShowing;
    private ILiveRoomPlayFragment.LiveRoomListener liveRoomListener;
    private final c messageListener;
    private vlc.d messageManager;
    private boolean needRemoveFromMsg;
    private com.bytedance.android.livesdk.chatroom.tabliveguide.b result;
    private Disposable timeDisposable;
    private int timer;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabGuideManager f111648a;

        public a(LiveInnerTabGuideManager r100) {
            this.f111648a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            LiveInnerTabGuideManager.access$unRegisterMessage(this.f111648a);
            LiveInnerTabGuideManager.access$removePitayaObserver(this.f111648a);
            LiveInnerTabGuideManager.access$getCd$p(this.f111648a).clear();
        }
    }

    public static final class b {
        public static LiveInnerTabGuideManager a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(LiveInnerTabGuideManager.TAG);
            if ((r100 instanceof LiveInnerTabGuideManager) == true) goto L6;
            r100 = null;
        L6:
            return (LiveInnerTabGuideManager) r100;
        }

        public b() {
        }
    }

    public static final class c implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabGuideManager f111649a;

        public c(LiveInnerTabGuideManager r100) {
            this.f111649a = r100;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            Long r101 = null;
            if ((r100 instanceof WebcastPaidLiveTypeModifyMessage) == false) goto L22;
            FeedItem r102 = LiveInnerTabGuideManager.access$getFeedItem$p(this.f111649a);
            if (r102 == null) goto L9;
            Room r103 = r102.getRoom();
            if (r103 == null) goto L9;
            r101 = Long.valueOf(r103.f162599id);
        L9:
            WebcastPaidLiveTypeModifyMessage r104 = (WebcastPaidLiveTypeModifyMessage) r100;
            long r105 = r104.getRoomId();
            if (r101 != null) goto L13;
            return;
        L13:
            if (r101.longValue() != r105) goto L43;
            PaidLiveTypeModifyData r106 = r104.paidLiveModifyData;
            if (r106 == null) goto L44;
            PrivilegeInfo r107 = r106.data;
            if (r107 != null) goto L19;
            return;
        L19:
            if (r107.paidLiveType != 101) goto L46;
            LiveInnerTabGuideManager.access$onMessage(this.f111649a, "主播已切换为会员直播，下滑可查看更多");
            return;
        L46:
            return;
        L44:
            return;
        L43:
            return;
        L22:
            if ((r100 instanceof ControlMessage) == false) goto L30;
            ControlMessage r108 = (ControlMessage) r100;
            if (r108.getAction() != 3) goto L27;
            LiveInnerTabGuideManager.access$onMessage(this.f111649a, "当前直播关播，下滑可看更多");
        L27:
            if (r108.getAction() != 4) goto L48;
            LiveInnerTabGuideManager.access$onMessage(this.f111649a, "房间被封禁，下滑可查看更多");
            return;
        L48:
            return;
        L30:
            if ((r100 instanceof PreviewUserBlockMessage) == false) goto L50;
            FeedItem r109 = LiveInnerTabGuideManager.access$getFeedItem$p(this.f111649a);
            if (r109 == null) goto L36;
            Room r110 = r109.getRoom();
            if (r110 == null) goto L36;
            r101 = Long.valueOf(r110.f162599id);
        L36:
            long r111 = ((PreviewUserBlockMessage) r100).baseMessage.roomId;
            if (r101 != null) goto L40;
            return;
        L40:
            if (r111 != r101.longValue()) goto L51;
            LiveInnerTabGuideManager.access$onMessage(this.f111649a, "直播间异常，下滑可查看更多");
            return;
        L51:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabGuideManager f111650a;

        public d(LiveInnerTabGuideManager r100) {
            this.f111650a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            ILiveRoomPlayFragment.LiveRoomListener r102 = LiveInnerTabGuideManager.access$getLiveRoomListener$p(this.f111650a);
            if (r102 == null) goto L6;
            r102.playNext(false);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveInnerTabGuideManager f111651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f111652b;

        public e(LiveInnerTabGuideManager r100, Fragment r101) {
            this.f111651a = r100;
            this.f111652b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.chatroom.tabliveguide.b r101 = (com.bytedance.android.livesdk.chatroom.tabliveguide.b) r100;
            if (r101 == null) goto L26;
            com.bytedance.android.livesdk.chatroom.tabliveguide.a r102 = r101.a();
            if (r102 == null) goto L27;
            com.bytedance.android.livesdk.chatroom.tabliveguide.c r103 = r102.c();
            if (r103 == null) goto L28;
            List<FeedItem> r104 = r103.a();
            if (r104 != null) goto L11;
            return;
        L11:
            if (r104.size() < 2) goto L30;
            LiveInnerTabGuideManager.access$setResult$p(this.f111651a, r101);
            List<FeedItem> r105 = r101.a().c().a();
            if (r105 == null) goto L20;
            FeedItem r106 = (FeedItem) ListProtector.get(r105, 0);
            if (r106 == null) goto L20;
            Room r107 = r106.getRoom();
            if (r107 == null) goto L20;
            long r108 = r107.getRoomId();
        L21:
            Room r109 = new Room();
            r109.f162599id = r108;
            LiveInnerTabGuideManager r110 = this.f111651a;
            FeedItem.Companion.getClass();
            FeedItem r111 = new FeedItem();
            r111.type = 100001;
            r111.setItem(r109);
            LiveInnerTabGuideManager.access$setFeedItem$p(r110, r111);
            FeedItem r112 = LiveInnerTabGuideManager.access$getFeedItem$p(this.f111651a);
            if (r112 == null) goto L24;
            r112.setRoom(r109);
        L24:
            LiveInnerTabGuideManager.access$registerMessage(this.f111651a, r108, this.f111652b.getContext());
            this.f111651a.insertInnerCard();
            return;
        L20:
            r108 = 0;
            goto L21
        L30:
            return;
        L28:
            return;
        L27:
            return;
        }
    }

    static {
        Companion = new b();
    }

    public final void onPageSelected() {
        this.isShowing = true;
    }

    public final void onPageUnSelected() {
        this.isShowing = false;
    }

    private final void removePitayaObserver() {
        IHostBusiness r100 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r100 == null) goto L8;
        ILiveSmartClientManager r101 = r100.getLiveSmartClientManager();
        if (r101 == null) goto L9;
        r101.cancelObserve("live_inner_card_matched");
        return;
    L9:
        return;
    }

    private final void unRegisterMessage() {
        vlc.d r100 = this.messageManager;
        if (r100 == null) goto L5;
        r100.removeMessageListener(this.messageListener);
    L5:
        vlc.d r101 = this.messageManager;
        if (r101 == null) goto L8;
        r101.r(false);
    L8:
        vlc.d r102 = this.messageManager;
        if (r102 == null) goto L11;
        r102.release();
    L11:
        this.messageManager = null;
    }

    public final Map<String, String> getCommonMobParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("enter_from_merge", this.enterFromMerge);
        r100.put("enter_method", this.enterMethod);
        r100.put("action_type", "draw");
        com.bytedance.android.livesdk.chatroom.tabliveguide.b r101 = this.result;
        if (r101 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.tabliveguide.a r102 = r101.a();
        if (r102 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.tabliveguide.c r103 = r102.c();
        if (r103 == null) goto L14;
        List<FeedItem> r104 = r103.a();
        if (r104 == null) goto L14;
        FeedItem r105 = (FeedItem) ListProtector.get(r104, 0);
        if (r105 == null) goto L14;
        String r106 = r105.resId;
        if (r106 == null) goto L14;
    L15:
        r100.put("request_id", r106);
        return r100;
    L14:
        r106 = "";
        goto L15
    }

    public final void insertInnerCard() {
        if (this.hasInsert == false) goto L5;
        return;
    L5:
        if (this.needRemoveFromMsg == false) goto L7;
        return;
    L7:
        if (this.insertRoomIndex <= 0) goto L26;
        FeedItem r100 = this.feedItem;
        if (r100 == null) goto L28;
        if (r100 == null) goto L15;
        Room r101 = r100.getRoom();
        if (r101 == null) goto L15;
        long r102 = r101.f162599id;
    L16:
        ILiveRoomPlayFragment.LiveRoomListener r103 = this.liveRoomListener;
        if (r103 == null) goto L27;
        FeedItem r104 = this.feedItem;
        if (r104 == null) goto L21;
        Room r105 = r104.getRoom();
    L22:
        Bundle r106 = new Bundle();
        r106.putLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, r102);
        Unit r107 = Unit.INSTANCE;
        r103.insertFeedItem(r104, r105, r106, Long.valueOf(r102), this.insertRoomIndex, new AnonymousClass2(this));
        return;
    L21:
        r105 = null;
        goto L22
    L27:
        return;
    L15:
        r102 = 0;
        goto L16
    L28:
        return;
    }

    public final void removeInnerCardItem() {
        FeedItem r100 = this.feedItem;
        if (r100 == null) goto L7;
        ILiveRoomPlayFragment.LiveRoomListener r101 = this.liveRoomListener;
        if (r101 == null) goto L7;
        r101.removeFeedItem(r100);
    L7:
        removePitayaObserver();
    }

    public final void stopTimer() {
        Disposable r100 = this.timeDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.timeDisposable = null;
    }

    public LiveInnerTabGuideManager() {
        this.insertRoomIndex = -1;
        this.timer = 6;
        this.enterFromMerge = "";
        this.enterMethod = "";
        this.messageListener = new c(this);
        CompositeDisposable r100 = new CompositeDisposable();
        this.f111647cd = r100;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r100);
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final com.bytedance.android.livesdk.chatroom.tabliveguide.b getInnerCardData() {
        return this.result;
    }

    public final int getInsertRoomIndex() {
        return this.insertRoomIndex;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(LiveInnerTabGuideManager r100) {
        return r100.f111647cd;
    }

    public static final /* synthetic */ FeedItem access$getFeedItem$p(LiveInnerTabGuideManager r100) {
        return r100.feedItem;
    }

    public static final /* synthetic */ boolean access$getHasInsert$p(LiveInnerTabGuideManager r100) {
        return r100.hasInsert;
    }

    public static final /* synthetic */ ILiveRoomPlayFragment.LiveRoomListener access$getLiveRoomListener$p(LiveInnerTabGuideManager r100) {
        return r100.liveRoomListener;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.chatroom.tabliveguide.b access$getResult$p(LiveInnerTabGuideManager r100) {
        return r100.result;
    }

    public static final /* synthetic */ void access$removePitayaObserver(LiveInnerTabGuideManager r100) {
        r100.removePitayaObserver();
    }

    public static final /* synthetic */ void access$unRegisterMessage(LiveInnerTabGuideManager r100) {
        r100.unRegisterMessage();
    }

    private final void onMessage(String r100) {
        this.needRemoveFromMsg = true;
        if (this.isShowing == false) goto L5;
        f2.c(r100, 0);
    L5:
        removeInnerCardItem();
    }

    public final void onFirstFrame(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeCycleOwner");
        if (this.hasTimer == true) goto L6;
        this.hasTimer = true;
        this.timeDisposable = ((ObservableSubscribeProxy) Observable.just(Boolean.TRUE).delay(this.timer, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r100))).subscribe(new d(this));
        return;
    }

    public final void setEnterFromMerge(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromMerge = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setInsertRoomIndex(int r100) {
        this.insertRoomIndex = r100;
    }

    public static final /* synthetic */ void access$onMessage(LiveInnerTabGuideManager r100, String r101) {
        r100.onMessage(r101);
    }

    public static final /* synthetic */ void access$setFeedItem$p(LiveInnerTabGuideManager r100, FeedItem r101) {
        r100.feedItem = r101;
    }

    public static final /* synthetic */ void access$setHasInsert$p(LiveInnerTabGuideManager r100, boolean r101) {
        r100.hasInsert = r101;
    }

    public static final /* synthetic */ void access$setLiveRoomListener$p(LiveInnerTabGuideManager r100, ILiveRoomPlayFragment.LiveRoomListener r101) {
        r100.liveRoomListener = r101;
    }

    public static final /* synthetic */ void access$setResult$p(LiveInnerTabGuideManager r100, com.bytedance.android.livesdk.chatroom.tabliveguide.b r101) {
        r100.result = r101;
    }

    private final void registerMessage(long r100, Context r101) {
        if (r101 == null) goto L13;
        unRegisterMessage();
        f5 r102 = z4.b("inner_card", r100, r101, new LinkedHashMap());
        this.messageManager = r102;
        r102.addMessageListener(MessageType.PAID_LIVE_TYPE_MODIFY_MESSAGE.getWsMethod(), this.messageListener);
        vlc.d r103 = this.messageManager;
        if (r103 == null) goto L6;
        r103.addMessageListener(MessageType.CONTROL.getWsMethod(), this.messageListener);
    L6:
        vlc.d r104 = this.messageManager;
        if (r104 == null) goto L9;
        r104.addMessageListener(MessageType.PREVIEW_USER_BLOCK_MESSAGE.getWsMethod(), this.messageListener);
    L9:
        vlc.d r105 = this.messageManager;
        if (r105 == null) goto L14;
        r105.startMessage();
        return;
    L14:
        return;
    }

    public static final /* synthetic */ void access$registerMessage(LiveInnerTabGuideManager r100, long r101, Context r102) {
        r100.registerMessage(r101, r102);
    }

    public final void logCardClick(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "clickArea");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        com.bytedance.android.livesdk.log.g r103 = u.l();
        Map<String, String> r104 = getCommonMobParams();
        r104.put("room_id", r101);
        r104.put("anchor_id", r102);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r100);
        r104.put("guide_scene", "live_feed");
        r104.put("guide_position", String.valueOf(this.insertRoomIndex + 1));
        Unit r105 = Unit.INSTANCE;
        r103.sendLog("livesdk_tablive_guide_click", r104, new Object[0]);
    }

    public final void requestFeedInnerCard(Bundle r100, Fragment r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        this.insertRoomIndex = r102;
        this.timer = r110;
        String r103 = r100.getString("enter_from_merge");
        String r111 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        this.enterFromMerge = r103;
        String r104 = r100.getString("enter_method");
        if (r104 == null) goto L9;
        r111 = r104;
    L9:
        this.enterMethod = r111;
        RxUtilKt.c(((FeedInnerCardApi) com.bytedance.android.live.network.c.b().e(FeedInnerCardApi.class)).getFeedInnerCardResponse("homepage_tablive_often_watch_top", this.enterFromMerge + '-' + this.enterMethod, 1, 1, "inner_card").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r101)), this.f111647cd);
    }
}
