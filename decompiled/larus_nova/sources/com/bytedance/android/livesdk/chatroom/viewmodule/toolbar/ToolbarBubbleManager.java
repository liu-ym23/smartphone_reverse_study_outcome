package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant$ConditionType;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 A*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002BCB\u0007¢\u0006\u0004\b?\u0010@J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\b\u0010\n\u001a\u00020\bH\u0014J=\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J.\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0001\u0010 2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016J5\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R \u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R8\u00105\u001a&\u0012\f\u0012\n 3*\u0004\u0018\u00010\u001b0\u001b 3*\u0012\u0012\f\u0012\n 3*\u0004\u0018\u00010\u001b0\u001b\u0018\u000104028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010=\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager;", "CMD", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager$BubbleInfo;", "info", "", "checkCanShowBubble", "", "observeBubbleState", "onCleared", "command", "", "priority", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/z;", "bubble", "Lkotlin/Function0;", "onClickButtonArea", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0$b;", "addBubble", "(Ljava/lang/Object;ILcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/z;Lkotlin/jvm/functions/Function0;)Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0$b;", "onClickBubbleArea", "addBubbleLocal", "dismissBubble", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/b0;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "addStrategy", "", "holder", "lock", "unlock", "tryStartNextBubble", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/view/View;", "anchorView", "createToolbarBubble", "(Ljava/lang/Object;Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/z;Lkotlin/jvm/functions/Function0;)Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0$b;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/util/PriorityQueue;", "queue", "Ljava/util/PriorityQueue;", "", "strategies", "Ljava/util/List;", "", "kotlin.jvm.PlatformType", "", "lockSet", "Ljava/util/Set;", "Lcom/bytedance/android/livesdk/log/b;", "logger", "Lcom/bytedance/android/livesdk/log/b;", "getCurrentBubble", "()Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager$BubbleInfo;", "currentBubble", "isCleared", "()Z", "<init>", "()V", "Companion", "BubbleInfo", "b", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarBubbleManager<CMD> extends ViewModel implements a0<CMD> {
    public static final b Companion = null;
    public static final long SHOW_TIMEOUT = 10;
    public static final String TAG = "ToolbarBubbleManager";

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f115707cd;
    private final Set<Object> lockSet;
    private final com.bytedance.android.livesdk.log.b logger;
    private final PriorityQueue<BubbleInfo<CMD>> queue;
    private final List<b0> strategies;

    public static final class BubbleInfo<CMD> implements a0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f115708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PropertyOwner<State> f115709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PropertyOwner f115710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CMD f115711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f115712e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final z<CMD> f115713f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final w f115714g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final com.bytedance.android.livesdk.popup.manager.c f115715h;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarBubbleManager$BubbleInfo$State;", "", PickerReporterConstants.KEY.TARGET, "", "isAtLeast", "", "level", "I", "getLevel", "()I", "PENDING", "SHOW_REQUESTED", "SHOWING", "DISMISSED", "liveroom-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum State extends Enum<State> {
            public static final State DISMISSED = null;
            public static final State PENDING = null;
            public static final State SHOWING = null;
            public static final State SHOW_REQUESTED = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ State[] f115716a = null;
            private final int level;

            static {
                State r100 = new State("PENDING", 0, 0);
                PENDING = r100;
                State r101 = new State("SHOW_REQUESTED", 1, 1);
                SHOW_REQUESTED = r101;
                State r102 = new State("SHOWING", 2, 2);
                SHOWING = r102;
                State r103 = new State("DISMISSED", 3, 3);
                DISMISSED = r103;
                f115716a = new State[]{r100, r101, r102, r103};
            }

            public static State valueOf(String r100) {
                return (State) r27.a.a(State.class, r100);
            }

            public static State[] values() {
                return (State[]) f115716a.clone();
            }

            public final int getLevel() {
                return this.level;
            }

            public final boolean isAtLeast(State r100) {
                Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
                if (this.level < r100.level) goto L5;
                return true;
            L5:
                return false;
            }

            public State(String r100, int r101, int r102) {
                super(r100, r101);
                this.level = r102;
            }
        }

        public final String toString() {
            return this.f115708a + "(state=" + this.f115709b.f64752a + ", command=" + this.f115711d + ", bubble=" + this.f115713f + ')';
        }

        public final boolean a(State r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            if (this.f115709b.f64752a.isAtLeast(r100) == false) goto L6;
            return false;
        L6:
            this.f115709b.a(r100);
            int r101 = t2.f116783a[r100.ordinal()];
            if (r101 != 1) goto L9;
            this.f115713f.a(this.f115711d, this.f115714g, this.f115715h);
        L13:
            return true;
        L9:
            if (r101 != 2) goto L13;
            this.f115713f.dismiss();
            goto L13
        }

        public BubbleInfo(CMD r100, int r101, z<CMD> r102, w r103, com.bytedance.android.livesdk.popup.manager.c r104) {
            Intrinsics.checkNotNullParameter(r102, "bubble");
            Intrinsics.checkNotNullParameter(r103, "clickCallback");
            Intrinsics.checkNotNullParameter(r104, "livePopupCallback");
            this.f115711d = r100;
            this.f115712e = r101;
            this.f115713f = r102;
            this.f115714g = r103;
            this.f115715h = r104;
            this.f115708a = "BubbleInfo@" + com.bytedance.android.live.core.utils.z0.c(this);
            PropertyOwner<State> r105 = new PropertyOwner(State.PENDING);
            this.f115709b = r105;
            this.f115710c = r105;
        }
    }

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((BubbleInfo) r101).f115712e), Integer.valueOf(((BubbleInfo) r100).f115712e));
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f115717a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void b() {
            this.f115717a.invoke();
        }

        public c(Function0 r100) {
            this.f115717a = r100;
        }
    }

    public static final class d implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f115718a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void b() {
            this.f115718a.invoke();
        }

        public d(Function0 r100) {
            this.f115718a = r100;
        }
    }

    public static final class e implements com.bytedance.android.livesdk.popup.manager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f115719a;

        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void waiting() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void a() {
            BubbleInfo r100 = (BubbleInfo) this.f115719a.element;
            Intrinsics.checkNotNull(r100);
            r100.a(BubbleInfo.State.DISMISSED);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void b() {
            BubbleInfo r100 = (BubbleInfo) this.f115719a.element;
            Intrinsics.checkNotNull(r100);
            r100.a(BubbleInfo.State.SHOWING);
        }

        public e(Ref.ObjectRef r100) {
            this.f115719a = r100;
        }
    }

    public static final class f implements com.bytedance.android.livesdk.popup.manager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f115720a;

        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void waiting() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void a() {
            BubbleInfo r100 = (BubbleInfo) this.f115720a.element;
            Intrinsics.checkNotNull(r100);
            r100.a(BubbleInfo.State.DISMISSED);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void b() {
            BubbleInfo r100 = (BubbleInfo) this.f115720a.element;
            Intrinsics.checkNotNull(r100);
            r100.a(BubbleInfo.State.SHOWING);
        }

        public f(Ref.ObjectRef r100) {
            this.f115720a = r100;
        }
    }

    public static final class g implements w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f115721a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void b() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.w
        public final void a() {
            this.f115721a.invoke();
        }

        public g(Function0 r100) {
            this.f115721a = r100;
        }
    }

    public static final class h implements com.bytedance.android.livesdk.popup.manager.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f115722a;

        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void waiting() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void a() {
            BubbleInfo r100 = (BubbleInfo) this.f115722a.element;
            Intrinsics.checkNotNull(r100);
            r100.a(BubbleInfo.State.DISMISSED);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.livesdk.popup.manager.c
        public final void b() {
            BubbleInfo r100 = (BubbleInfo) this.f115722a.element;
            Intrinsics.checkNotNull(r100);
            r100.a(BubbleInfo.State.SHOWING);
        }

        public h(Ref.ObjectRef r100) {
            this.f115722a = r100;
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarBubbleManager f115723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BubbleInfo f115724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f115725c;

        public i(ToolbarBubbleManager r100, BubbleInfo r101, Ref.BooleanRef r102) {
            this.f115723a = r100;
            this.f115724b = r101;
            this.f115725c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BubbleInfo.State r101 = (BubbleInfo.State) r100;
            ToolbarBubbleManager.access$getLogger$p(this.f115723a).b(this.f115724b.f115708a + ' ' + ((BubbleInfo.State) this.f115724b.f115710c.f64752a));
            if (r101 == null) goto L28;
            int r102 = u2.f116786a[r101.ordinal()];
            if (r102 != 1) goto L8;
            ToolbarBubbleManager.access$getQueue$p(this.f115723a).remove(this.f115724b);
            if (this.f115725c.element == false) goto L23;
            Iterator<T> r103 = ToolbarBubbleManager.access$getStrategies$p(this.f115723a).iterator();
        L21:
            if (r103.hasNext() == false) goto L23;
            ((b0) r103.next()).e(this.f115724b);
        L23:
            this.f115723a.tryStartNextBubble();
            return;
        L8:
            if (r102 != 2) goto L10;
            RxUtilKt.c(RxUtilKt.h(Observable.timer(10, TimeUnit.SECONDS)).takeUntil(this.f115724b.f115710c.filter(v2.f116814a)).subscribe(new w2(this)), ToolbarBubbleManager.access$getCd$p(this.f115723a));
            return;
        L10:
            if (r102 != 3) goto L29;
            this.f115725c.element = true;
            xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant$ConditionType.SHOW_BUBBLE));
            Iterator<T> r104 = ToolbarBubbleManager.access$getStrategies$p(this.f115723a).iterator();
        L14:
            if (r104.hasNext() == false) goto L30;
            ((b0) r104.next()).d(this.f115724b);
            goto L14
        L30:
            return;
        L29:
            return;
        }
    }

    static {
        Companion = new b();
    }

    private final BubbleInfo<CMD> getCurrentBubble() {
        return this.queue.peek();
    }

    public final boolean isCleared() {
        return this.f115707cd.isDisposed();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.f115707cd.dispose();
        Iterator<T> r100 = this.queue.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((BubbleInfo) r100.next()).a(BubbleInfo.State.DISMISSED);
        goto L4
    L6:
        this.queue.clear();
        Iterator<T> r101 = this.strategies.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((b0) r101.next()).c(this);
        goto L8
    L10:
        this.strategies.clear();
        this.lockSet.clear();
        this.logger.b("onCleared");
    }

    public ToolbarBubbleManager() {
        this.f115707cd = new CompositeDisposable();
        this.queue = new PriorityQueue(11, new a());
        this.strategies = new ArrayList();
        this.lockSet = Collections.newSetFromMap(new WeakHashMap());
        com.bytedance.android.livesdk.log.b r100 = new com.bytedance.android.livesdk.log.b(TAG, "[" + com.bytedance.android.live.core.utils.z0.c(this) + ']');
        this.logger = r100;
        r100.b(IVKService.ResponseConstants.CREATED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public void tryStartNextBubble() {
        if (isCleared() == false) goto L5;
        return;
    L5:
        BubbleInfo<CMD> r100 = getCurrentBubble();
        if (r100 != null) goto L9;
        return;
    L9:
        if (((BubbleInfo.State) r100.f115710c.f64752a) == BubbleInfo.State.PENDING) goto L11;
        return;
    L11:
        if (checkCanShowBubble(r100) == false) goto L15;
        r100.a(BubbleInfo.State.SHOW_REQUESTED);
        return;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(ToolbarBubbleManager r100) {
        return r100.f115707cd;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.log.b access$getLogger$p(ToolbarBubbleManager r100) {
        return r100.logger;
    }

    public static final /* synthetic */ PriorityQueue access$getQueue$p(ToolbarBubbleManager r100) {
        return r100.queue;
    }

    public static final /* synthetic */ List access$getStrategies$p(ToolbarBubbleManager r100) {
        return r100.strategies;
    }

    private final boolean checkCanShowBubble(BubbleInfo<CMD> r100) {
        List<b0> r101 = this.strategies;
        boolean r102 = true;
        String r103 = "";
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r104 = r101.iterator();
    L9:
        if (r104.hasNext() == false) goto L6;
        b0 r105 = (b0) r104.next();
        boolean r106 = !r105.a(r100);
        if (r106 == false) goto L13;
        r103 = "strategy " + r105;
    L13:
        if (r106 == false) goto L9;
        boolean r107 = true;
    L15:
        int r108 = this.lockSet.size();
        if (r107 == true) goto L19;
        if (r108 != 0) goto L19;
    L20:
        if (r102 == true) goto L22;
        this.logger.b("cannot show bubble, blockSource=" + r103 + ", lockCount=" + r108);
    L22:
        return r102;
    L19:
        r102 = false;
    L6:
        r107 = false;
        goto L15
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L6
    }

    private final void observeBubbleState(BubbleInfo<CMD> r100) {
        Ref.BooleanRef r101 = new Ref.BooleanRef();
        r101.element = false;
        RxUtilKt.c(r100.f115710c.subscribe(new i(this, r100, r101)), this.f115707cd);
    }

    public void addStrategy(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        if (isCleared() == false) goto L5;
        return;
    L5:
        this.strategies.add(r100);
        r100.b(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public boolean dismissBubble(a0.b r100) {
        if ((r100 instanceof BubbleInfo) == true) goto L5;
        r100 = null;
    L5:
        BubbleInfo<CMD> r101 = (BubbleInfo) r100;
        if (r101 != null) goto L8;
        r101 = getCurrentBubble();
    L8:
        if (r101 != null) goto L11;
        return false;
    L11:
        this.logger.b("dismissBubble: " + r101);
        return r101.a(BubbleInfo.State.DISMISSED);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public void lock(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.logger.b("lock: " + r100);
        this.lockSet.add(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public void unlock(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.logger.b("unlock: " + r100);
        this.lockSet.remove(r100);
        tryStartNextBubble();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBubbleManager$BubbleInfo] */
    public a0.b addBubble(CMD r100, z<CMD> r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "bubble");
        Intrinsics.checkNotNullParameter(r111, "onClickButtonArea");
        if (isCleared() == false) goto L5;
        return null;
    L5:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        r101.element = new BubbleInfo(r100, 0, r110, new d(r111), new f(r101));
        this.logger.b("addBubble: " + ((BubbleInfo) r101.element));
        observeBubbleState((BubbleInfo) r101.element);
        this.queue.add((BubbleInfo) r101.element);
        tryStartNextBubble();
        return (BubbleInfo) r101.element;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public <T> z<T> createToolbarBubble(DataCenter r100, Context r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "anchorView");
        return new q2(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBubbleManager$BubbleInfo] */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public a0.b addBubble(CMD r100, int r110, z<CMD> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r111, "bubble");
        Intrinsics.checkNotNullParameter(r112, "onClickButtonArea");
        if (isCleared() == false) goto L5;
        return null;
    L5:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        r101.element = new BubbleInfo(r100, r110, r111, new c(r112), new e(r101));
        this.logger.b("addBubble: " + ((BubbleInfo) r101.element));
        observeBubbleState((BubbleInfo) r101.element);
        this.queue.add((BubbleInfo) r101.element);
        tryStartNextBubble();
        return (BubbleInfo) r101.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBubbleManager$BubbleInfo] */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0
    public a0.b addBubbleLocal(CMD r100, int r110, z<CMD> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r111, "bubble");
        Intrinsics.checkNotNullParameter(r112, "onClickBubbleArea");
        if (isCleared() == false) goto L5;
        return null;
    L5:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        r101.element = new BubbleInfo(r100, r110, r111, new g(r112), new h(r101));
        this.logger.b("addBubble: " + ((BubbleInfo) r101.element));
        observeBubbleState((BubbleInfo) r101.element);
        this.queue.add((BubbleInfo) r101.element);
        tryStartNextBubble();
        return (BubbleInfo) r101.element;
    }
}
