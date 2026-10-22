package com.bytedance.android.gamecp.live_impl.animation;

import android.os.SystemClock;
import com.bytedance.android.gamecp.host_api.model.introducecard.g;
import com.bytedance.android.gamecp.live_impl.GamePromoteDataContext;
import com.bytedance.android.gamecp.live_impl.animation.task.ShowCardAnimationActionTask;
import com.bytedance.android.gamecp.live_impl.preview.CardAnimationControllerPreView;
import com.bytedance.android.gamecp.live_impl.utils.IntroduceCardDataUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class CardAnimationEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f57762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f57763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f57764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f57765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f57766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f57767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f57768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f57769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f57770i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f57771j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f57772k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f57773l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f57774m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<Unit> f57775n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f57776o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f57777p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f57778q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f57779r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f57780s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f57781t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f57782u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.android.gamecp.live_impl.animation.task.a f57783v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CardAnimationControllerPreView f57784w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/animation/CardAnimationEvent$State;", "", "EVENT_START", "ENQUEUE", "DEQUEUE", "ANIMATION_TASK_START", "ANIMATION_TASK_END", "EVENT_END", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State ANIMATION_TASK_END = null;
        public static final State ANIMATION_TASK_START = null;
        public static final State DEQUEUE = null;
        public static final State ENQUEUE = null;
        public static final State EVENT_END = null;
        public static final State EVENT_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f57785a = null;

        static {
            State r100 = new State("EVENT_START", 0);
            EVENT_START = r100;
            State r101 = new State("ENQUEUE", 1);
            ENQUEUE = r101;
            State r102 = new State("DEQUEUE", 2);
            DEQUEUE = r102;
            State r103 = new State("ANIMATION_TASK_START", 3);
            ANIMATION_TASK_START = r103;
            State r104 = new State("ANIMATION_TASK_END", 4);
            ANIMATION_TASK_END = r104;
            State r105 = new State("EVENT_END", 5);
            EVENT_END = r105;
            f57785a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f57785a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final String a() {
        int r100 = IntroduceCardDataUtils.f58020a;
        if (IntroduceCardDataUtils.f(this.f57776o) == false) goto L5;
        return "enter";
    L5:
        return "live";
    }

    public final int getType() {
        return this.f57764c;
    }

    public CardAnimationEvent(CardAnimationControllerPreView r100) {
        Intrinsics.checkNotNullParameter(r100, "contrller");
        this.f57784w = r100;
        State r101 = State.EVENT_START;
        b(r101);
        this.f57762a = r101;
        this.f57763b = "";
        this.f57766e = 10;
        this.f57774m = "android";
        this.f57776o = "";
        this.f57777p = "";
        this.f57778q = "";
        this.f57779r = true;
    }

    public final void b(State r100) {
        int r101 = f.f57805a[r100.ordinal()];
        boolean r102 = false;
        if (r101 != 4) goto L5;
        this.f57770i = SystemClock.elapsedRealtime();
        Logger.i("game-promote", "讲解卡动画 初始化并执行：task_init = " + this.f57782u + ",isShow = " + this.f57765d + ",needAnimation = " + this.f57766e);
        if (this.f57782u == false) goto L14;
    L25:
        com.bytedance.android.gamecp.live_impl.animation.task.a r103 = this.f57783v;
        if (r103 == null) goto L33;
        Function0<Unit> r104 = r103.f57812d;
        if (r104 == null) goto L30;
        Unit r105 = r104.invoke();
    L30:
        r103.a();
        return;
    L33:
        return;
    L14:
        if (this.f57765d == false) goto L16;
        com.bytedance.android.gamecp.live_impl.animation.task.a r106 = new ShowCardAnimationActionTask(this.f57766e, new CardAnimationEvent$initTask$1(this), this.f57784w);
    L17:
        this.f57783v = r106;
        GamePromoteDataContext r107 = this.f57784w.f57899g;
        if (r107 == null) goto L24;
        m<Boolean> r108 = r107.getInDegradeScene();
        if (r108 == null) goto L24;
        Boolean r109 = r108.getValue();
        if (r109 == null) goto L24;
        r102 = r109.booleanValue();
    L24:
        r106.f57811c = r102;
        this.f57782u = true;
        goto L25
    L16:
        r106 = new com.bytedance.android.gamecp.live_impl.animation.task.f(this.f57766e, new CardAnimationEvent$initTask$2(this), this.f57784w);
        goto L17
    L5:
        if (r101 != 6) goto L34;
        Function0<Unit> r110 = this.f57775n;
        if (r110 == null) goto L10;
        Unit r111 = r110.invoke();
    L10:
        this.f57783v = null;
        this.f57782u = false;
        return;
    }

    public final void c(State r100) {
        Intrinsics.checkNotNullParameter(r100, "nextState");
        if (this.f57762a.compareTo(r100) < 0) goto L5;
    L6:
        LocalTestManager.a(new Class[]{uv.a.class});
    L7:
        com.bytedance.android.gamecp.live_impl.preview.f r101 = this.f57784w.f57914v;
        State r102 = this.f57762a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "event");
        Intrinsics.checkNotNullParameter(r102, "lastState");
        Intrinsics.checkNotNullParameter(r100, "curState");
        Iterator<T> r103 = r101.f57928a.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        ow.a r104 = (ow.a) ((WeakReference) r103.next()).get();
        if (r104 == null) goto L9;
        r104.a(this, r102, r100);
        goto L9
    L13:
        this.f57762a = r100;
        b(r100);
        return;
    L5:
        if ((r100.ordinal() - this.f57762a.ordinal()) <= 1) goto L7;
        goto L6
    }
}
