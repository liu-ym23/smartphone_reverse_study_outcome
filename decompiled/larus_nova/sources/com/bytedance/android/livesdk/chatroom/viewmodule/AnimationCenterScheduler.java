package com.bytedance.android.livesdk.chatroom.viewmodule;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.iw0;
import com.bytedance.android.livesdk.config.j11;
import com.bytedance.android.livesdk.config.pd;
import com.bytedance.android.livesdk.room.Task.execute.ExecutorHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.utils.TimeConsumingFuncUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b2\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0014R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/AnimationCenterScheduler;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/IAnimationScheduler;", "", "time", "", "onSchedule", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/c;", "listener", "logAnimationOnce", "it", "", "isSameListener", "Lkotlin/Function0;", "", "info", "logDebugInfo", "onToolbarLoaded", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/a;", "requestAnimationAtOnce", "enable", "enableShowAnim", "registerListener", "unRegisterListener", "onCleared", "TAG", "Ljava/lang/String;", "Ljava/util/PriorityQueue;", "list", "Ljava/util/PriorityQueue;", "autoStart", "Z", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/chatroom/viewmodel/d;", "Lkotlin/collections/ArrayList;", "observerList", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/x2;", "scheduler", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/x2;", "mutex", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "enableAnim", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationCenterScheduler extends ViewModel implements IAnimationScheduler {
    private final String TAG;
    private boolean autoStart;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f114833cd;
    private final DataCenter dataCenter;
    private boolean enableAnim;
    private final PriorityQueue<com.bytedance.android.livesdk.chatroom.viewmodel.c> list;
    private boolean mutex;
    private final ArrayList<com.bytedance.android.livesdk.chatroom.viewmodel.d> observerList;
    private x2 scheduler;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.AnimationCenterScheduler$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass1(AnimationCenterScheduler r100) {
            super(1, r100, AnimationCenterScheduler.class, "onSchedule", "onSchedule(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
            invoke(r100.longValue());
            return Unit.INSTANCE;
        }

        public final void invoke(long r100) {
            AnimationCenterScheduler.access$onSchedule((AnimationCenterScheduler) this.receiver, r100);
        }
    }

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f114834a = null;

        static {
            f114834a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            com.bytedance.android.livesdk.chatroom.viewmodel.c r102 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r100;
            com.bytedance.android.livesdk.chatroom.viewmodel.c r103 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r101;
            int r104 = 0;
            if (r103 == null) goto L7;
            com.bytedance.android.livesdk.chatroom.viewmodel.a r105 = r103.getInfo();
            if (r105 == null) goto L7;
            int r106 = r105.f114772a;
        L8:
            if (r102 == null) goto L13;
            com.bytedance.android.livesdk.chatroom.viewmodel.a r107 = r102.getInfo();
            if (r107 == null) goto L13;
            r104 = r107.f114772a;
        L13:
            return r106 - r104;
        L7:
            r106 = 0;
            goto L8
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f114835a;

        public b(Map r100) {
            this.f114835a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_toolbar_icon_motion", this.f114835a, new Object[]{am2.x.class, IRoom.class});     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimationCenterScheduler f114836a;

        public c(AnimationCenterScheduler r100) {
            this.f114836a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            if (AnimationCenterScheduler.access$getList$p(this.f114836a).size() <= 0) goto L7;
            AnimationCenterScheduler.access$logDebugInfo(this.f114836a, AnimationCenterScheduler$onToolbarLoaded$1$1.INSTANCE);
            x2 r102 = AnimationCenterScheduler.access$getScheduler$p(this.f114836a);
            if (r102 == null) goto L7;
            r102.a();
        L7:
            AnimationCenterScheduler.access$setAutoStart$p(this.f114836a, true);
        }
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        logDebugInfo(C100121.INSTANCE);
        this.observerList.clear();
        this.list.clear();
        this.f114833cd.dispose();
        x2 r100 = this.scheduler;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void onToolbarLoaded() {
        IAnimationScheduler.M0.getClass();
        Integer r100 = iw0.f120484a.getValue();
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L7:
        if (r102 != 1) goto L9;
        r101 = true;
    L9:
        this.mutex = r101;
        RxUtilKt.c(Observable.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this)), this.f114833cd);
        return;
    L5:
        r102 = 0;
        goto L7
    }

    public final DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public AnimationCenterScheduler(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.dataCenter = r100;
        this.TAG = "AnimationCenterScheduler";
        this.list = new PriorityQueue(10, a.f114834a);
        this.observerList = new ArrayList();
        this.f114833cd = new CompositeDisposable();
        this.enableAnim = true;
        IAnimationScheduler.M0.getClass();
        j11 r101 = pd.f120969a.getValue();     // Catch: Exception -> L7
        if (r101 == null) goto L9;
        long r102 = r101.interval;     // Catch: Exception -> L7
    L11:
        if (r102 > 0) goto L13;
        r102 = 10000;
    L13:
        this.scheduler = new f1(new AnonymousClass1(this), r102);
        return;
    L9:
        r102 = 5000;
    L7:
        e = move-exception;
        SafetyGuard.a(null, e, "live animation center setting interval error.");
        goto L9
    }

    public static final /* synthetic */ boolean access$getAutoStart$p(AnimationCenterScheduler r100) {
        return r100.autoStart;
    }

    public static final /* synthetic */ PriorityQueue access$getList$p(AnimationCenterScheduler r100) {
        return r100.list;
    }

    public static final /* synthetic */ x2 access$getScheduler$p(AnimationCenterScheduler r100) {
        return r100.scheduler;
    }

    private final void logAnimationOnce(com.bytedance.android.livesdk.chatroom.viewmodel.c r110) {
        TimeConsumingFuncUtils r100 = TimeConsumingFuncUtils.INSTANCE;
        String r101 = "";
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r102 = null;
        if (r100.asyncToolbarAnim() == true) goto L5;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r103 = y3.m(this.dataCenter);
        if ((r103 instanceof x3) == false) goto L25;
        r102 = r103;
    L25:
        x3 r104 = (x3) r102;
        if (r104 != null) goto L28;
        return;
    L28:
        ExtendedToolbarButton r111 = r110.c().extended();
        int r105 = r104.v(r111);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        String r106 = com.bytedance.android.livesdk.chatroom.utils.o1.a(r105);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        Object r112 = com.bytedance.android.livesdk.chatroom.utils.o1.f114565a.get(r111);
        if ((r112 instanceof String) == false) goto L31;
        String r113 = (String) r112;
    L32:
        if (r113 == null) goto L35;
        r101 = r113;
    L35:
        Map<String, String> r114 = MapsKt.mapOf(new Pair[]{TuplesKt.to("icon_type", r101), TuplesKt.to("icon_order", r106)});
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_toolbar_icon_motion", r114, new Object[]{am2.x.class, IRoom.class});
        return;
    L31:
        r113 = "";
        goto L32
    L5:
        if (r100.enableReport() == false) goto L37;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r107 = y3.m(this.dataCenter);
        if ((r107 instanceof x3) == false) goto L10;
        r102 = r107;
    L10:
        x3 r108 = (x3) r102;
        if (r108 != null) goto L13;
        return;
    L13:
        ExtendedToolbarButton r115 = r110.c().extended();
        int r109 = r108.v(r115);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        String r116 = com.bytedance.android.livesdk.chatroom.utils.o1.a(r109);
        com.bytedance.android.livesdk.chatroom.utils.o1.d().getClass();
        Object r117 = com.bytedance.android.livesdk.chatroom.utils.o1.f114565a.get(r115);
        if ((r117 instanceof String) == false) goto L16;
        String r118 = (String) r117;
    L17:
        if (r118 == null) goto L20;
        r101 = r118;
    L20:
        Map r119 = MapsKt.mapOf(new Pair[]{TuplesKt.to("icon_type", r101), TuplesKt.to("icon_order", r116)});
        Lazy r120 = ExecutorHelper.f157599a;
        b r121 = new b(r119);
        Intrinsics.checkNotNullParameter(r121, "runnable");
        ((ExecutorService) ExecutorHelper.f157599a.getValue()).execute(new com.bytedance.android.livesdk.room.Task.execute.a(r121));
        return;
    L16:
        r118 = "";
        goto L17
    }

    private final void logDebugInfo(Function0<String> r100) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d(this.TAG, r100.invoke());
        return;
    }

    private final void onSchedule(long r100) {
        com.bytedance.android.livesdk.chatroom.viewmodel.c r101 = null;
        PriorityQueue<com.bytedance.android.livesdk.chatroom.viewmodel.c> r102 = null;
        if (this.enableAnim == true) goto L11;
        PriorityQueue<com.bytedance.android.livesdk.chatroom.viewmodel.c> r103 = this.list;
        if ((!r103.isEmpty()) == false) goto L7;
        r102 = r103;
    L7:
        if (r102 == null) goto L36;
        r102.clear();
        return;
    L36:
        return;
    L11:
        if (this.list.size() != 0) goto L16;
        logDebugInfo(AnonymousClass2.INSTANCE);
        x2 r104 = this.scheduler;
        if (r104 == null) goto L16;
        r104.b();
    L16:
        if (this.mutex == false) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.c r105 = this.list.peek();
        if (r105 != null) goto L20;
        return;
    L20:
        if (r105.a(r100) == false) goto L38;
        logDebugInfo(AnimationCenterScheduler$onSchedule$3$1.INSTANCE);
        logAnimationOnce(r105);
        return;
    L38:
        return;
    L22:
        Iterator<T> r106 = this.list.iterator();
    L24:
        if (r106.hasNext() == false) goto L28;
        final com.bytedance.android.livesdk.chatroom.viewmodel.c r107 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r106.next();
        if (r107.a(r100) == false) goto L24;
        logDebugInfo(new AnimationCenterScheduler$onSchedule$4$1$1(r107));
        logAnimationOnce(r107);
        r101 = r107;
    L28:
        if (r101 != null) goto L30;
        return;
    L30:
        if (r101.b() != true) goto L41;
        unRegisterListener(r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void enableShowAnim(boolean r100) {
        this.enableAnim = r100;
        if (r100 == true) goto L6;
        this.list.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void registerListener(final com.bytedance.android.livesdk.chatroom.viewmodel.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if ((!Intrinsics.areEqual(r100.getInfo(), com.bytedance.android.livesdk.chatroom.viewmodel.a.d.f114776b)) == false) goto L7;
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == true) goto L7;
        return;
    L7:
        logDebugInfo(new C100131(r100));
        SkinLoader.f114373c.getClass();
        Object r101 = null;
        if (SkinLoader.a.b() == false) goto L18;
        Iterator<T> r102 = this.list.iterator();
    L11:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        if (isSameListener((com.bytedance.android.livesdk.chatroom.viewmodel.c) r103, r100) == false) goto L11;
        r101 = r103;
    L15:
        com.bytedance.android.livesdk.chatroom.viewmodel.c r104 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r101;
        if (r104 == null) goto L27;
        this.list.remove(r104);
    L27:
        this.list.add(r100);
        if (this.autoStart == false) goto L32;
        logDebugInfo(AnonymousClass6.INSTANCE);
        x2 r105 = this.scheduler;
        if (r105 == null) goto L32;
        r105.a();
    L32:
        Iterator<T> r106 = this.observerList.iterator();
    L34:
        if (r106.hasNext() == false) goto L36;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.d) r106.next()).b();
        goto L34
    L36:
        return;
    L18:
        Iterator<T> r107 = this.list.iterator();
    L20:
        if (r107.hasNext() == false) goto L24;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.viewmodel.c) r108).getInfo(), r100.getInfo()) == false) goto L20;
        r101 = r108;
    L24:
        com.bytedance.android.livesdk.chatroom.viewmodel.c r109 = (com.bytedance.android.livesdk.chatroom.viewmodel.c) r101;
        if (r109 == null) goto L27;
        this.list.remove(r109);
        goto L27
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void requestAnimationAtOnce(com.bytedance.android.livesdk.chatroom.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        com.bytedance.android.livesdk.chatroom.viewmodel.c r101 = this.list.peek();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101.getInfo(), r100) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L14;
        logDebugInfo(AnimationCenterScheduler$requestAnimationAtOnce$2$1.INSTANCE);
        if (r101.a(-1) == false) goto L15;
        logAnimationOnce(r101);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler
    public void unRegisterListener(final com.bytedance.android.livesdk.chatroom.viewmodel.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        logDebugInfo(new C100141(r100));
        if (this.list.remove(r100) == false) goto L8;
        Iterator<T> r101 = this.observerList.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.d) r101.next()).a();
        goto L6
    L10:
        return;
    }

    public static final /* synthetic */ void access$logDebugInfo(AnimationCenterScheduler r100, Function0 r101) {
        r100.logDebugInfo(r101);
    }

    public static final /* synthetic */ void access$onSchedule(AnimationCenterScheduler r100, long r101) {
        r100.onSchedule(r101);
    }

    public static final /* synthetic */ void access$setAutoStart$p(AnimationCenterScheduler r100, boolean r101) {
        r100.autoStart = r101;
    }

    public static final /* synthetic */ void access$setScheduler$p(AnimationCenterScheduler r100, x2 r101) {
        r100.scheduler = r101;
    }

    private final boolean isSameListener(com.bytedance.android.livesdk.chatroom.viewmodel.c r100, com.bytedance.android.livesdk.chatroom.viewmodel.c r101) {
        if (r101.c() != r100.c()) goto L5;
        return true;
    L5:
        return false;
    }
}
