package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.PlayConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ChatChannelAnimManager implements com.bytedance.android.livesdk.interactivity.api.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f134162e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue<a> f134163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f134164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f134165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f134166d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Disposable f134167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f134168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.android.livesdk.interactivity.api.c.a f134169c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.manager.ChatChannelAnimManager$a$a, reason: collision with other inner class name */
        public static final class C2117a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f134170a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f134171b;

            public C2117a(a r100, Function1 r101) {
                this.f134170a = r100;
                this.f134171b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Long r101 = (Long) r100;
                SafetyGuard.a(null, null, "channel anim timeout");
                ALogger.e("ChatChannelAnimManager", "anim timeout. params=" + this.f134170a.f134169c);
                this.f134171b.invoke(this.f134170a);
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f134168b, r101.f134168b) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f134169c, r101.f134169c) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            b r100 = this.f134168b;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            com.bytedance.android.livesdk.interactivity.api.c.a r104 = this.f134169c;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AnimTask(player=" + this.f134168b + ", params=" + this.f134169c + ")";
        }

        public final void a(Function1<? super a, Unit> r110) {
            Intrinsics.checkNotNullParameter(r110, "timeoutAction");
            this.f134167a = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C2117a(this, r110));
            b r111 = this.f134168b;
            com.bytedance.android.livesdk.interactivity.api.c.a r100 = this.f134169c;
            r111.getClass();
            Intrinsics.checkNotNullParameter(r100, "params");
            r111.f134179h.getClass();
            ChatChannelAnimManager.e("startPlay " + r100);
            ITextureViewPlayerController r101 = r111.f134173b;
            if (r101 != null) goto L17;
            IGiftServiceExternal r102 = (IGiftServiceExternal) jc1.k.f(IGiftServiceExternal.class);
            ITextureViewPlayerController r103 = null;
            if (r102 == null) goto L18;
            ILiveGiftPlayControllerManager r104 = r102.giftPlayControllerManager();
            if (r104 == null) goto L18;
            Object r105 = r111.f134176e;
            if ((r105 instanceof LifecycleOwner) == true) goto L11;
            r105 = null;
        L11:
            r101 = r104.createTextureViewPlayer((LifecycleOwner) r105);
            if (r101 == null) goto L18;
            r111.f134173b = r101;
            if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.f132991j == false) goto L16;
            r101.setMonitor(d.f134182a);
        L16:
            r101.setPlayerActionListener(r111.f134172a);
            r101.attachAlphaView(r111.f134177f);
        L18:
            if (r103 != null) goto L20;
            ChatChannelAnimManager.c(r111.f134179h, r111);
            return;
        L20:
            if (r111.f134174c == false) goto L22;
            r111.f134174c = false;
            r111.f134179h.d().removeCallbacks(r111.f134175d);
        L22:
            ITextureViewPlayerController.DefaultImpls.start$default(r103, r100.f132914a, false, false, false, new PlayConfig(r100.f132916c, r100.f132917d), 12, null);
            return;
        L17:
            r103 = r101;
            goto L18
        }

        public a(b r100, com.bytedance.android.livesdk.interactivity.api.c.a r101) {
            Intrinsics.checkNotNullParameter(r100, "player");
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f134168b = r100;
            this.f134169c = r101;
        }
    }

    public final class b implements com.bytedance.android.livesdk.interactivity.api.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f134172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ITextureViewPlayerController f134173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f134174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RunnableC2118b f134175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Context f134176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ViewGroup f134177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f134178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ChatChannelAnimManager f134179h;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f134180a;

            public a(b r100) {
                this.f134180a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f134180a.release();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.manager.ChatChannelAnimManager$b$b, reason: collision with other inner class name */
        public static final class RunnableC2118b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f134181a;

            public RunnableC2118b(b r100) {
                this.f134181a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ChatChannelAnimManager r100 = this.f134181a.f134179h;     // Catch: Throwable -> L6
                int r101 = ChatChannelAnimManager.f134162e;     // Catch: Throwable -> L6
                r100.getClass();     // Catch: Throwable -> L6
                ChatChannelAnimManager.e("releaseRunnable");     // Catch: Throwable -> L6
                b r102 = this.f134181a;     // Catch: Throwable -> L6
                ITextureViewPlayerController r103 = r102.f134173b;     // Catch: Throwable -> L6
                if (r103 == null) goto L9;
                r103.detachAlphaView(r102.f134177f);     // Catch: Throwable -> L6
                r103.removePlayerActionListener();     // Catch: Throwable -> L6
                r103.release();     // Catch: Throwable -> L6
                r102.f134173b = null;     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.c
        public final void release() {
            if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
            this.f134179h.d().post(new a(this));
            return;
        L5:
            this.f134179h.getClass();
            ChatChannelAnimManager.e("release " + this);
            if (this.f134174c == false) goto L8;
            this.f134174c = false;
            this.f134179h.d().removeCallbacks(this.f134175d);
        L8:
            ITextureViewPlayerController r100 = this.f134173b;
            if (r100 == null) goto L11;
            r100.detachAlphaView(this.f134177f);
            r100.removePlayerActionListener();
            r100.release();
            this.f134173b = null;
        L11:
            ChatChannelAnimManager.b(this.f134179h, this);
            ChatChannelAnimManager.c(this.f134179h, this);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.c
        public final void a(com.bytedance.android.livesdk.interactivity.api.c.a r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            ChatChannelAnimManager r101 = this.f134179h;
            a r102 = new a(this, r100);
            if (r101.f134166d == false) goto L7;
            r101.d().post(new h(r101, r102));
            return;
        }

        public b(ChatChannelAnimManager r100, Context r101, ViewGroup r102, IPlayerActionListener r103, long r104) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r103, "listener");
            this.f134179h = r100;
            this.f134176e = r101;
            this.f134177f = r102;
            this.f134178g = r104;
            this.f134172a = new f(this, r103);
            this.f134175d = new RunnableC2118b(this);
        }
    }

    public static final class c {
    }

    public static final class d implements IResultMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f134182a = null;

        public d() {
        }

        static {
            f134182a = new d();
        }

        @Override // com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor
        public final void monitor(boolean r100, String r101, int r102, int r103, String r104) {
            ALogger.i("ChatChannelAnimManager", "state=" + r100 + " playerType=" + r101 + " what=" + r102 + " errorInfo=" + r104);
        }
    }

    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f134183a = null;

        static {
            f134183a = new e();
        }

        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((a) r101).f134169c.f132915b - ((a) r100).f134169c.f132915b;
        }
    }

    static {
    }

    public final Handler d() {
        return (Handler) this.f134165c.getValue();
    }

    public ChatChannelAnimManager() {
        this.f134163a = new PriorityQueue(8, e.f134183a);
        this.f134165c = LazyKt.lazy(ChatChannelAnimManager$mainHandler$2.INSTANCE);
    }

    public static void e(String r100) {
        ALogger.i("ChatChannelAnimManager", r100);
    }

    public static final void b(ChatChannelAnimManager r100, b r101) {
        if (r100.f134166d == true) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L8;
        r100.d().post(new g(r100, r101));
        return;
    L8:
        Iterator r102 = ((PriorityQueue) r100.f134163a).iterator();
    L10:
        if (r102.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((a) r102.next()).f134168b, r101) == false) goto L10;
        r102.remove();
        goto L10
    }

    public static final void c(ChatChannelAnimManager r100, b r101) {
        a r102 = r100.f134164b;
        Object r103 = null;
        if (r102 == null) goto L11;
        if ((!Intrinsics.areEqual(r102.f134168b, r101)) == false) goto L11;
        StringBuilder r104 = new StringBuilder("tryStartNextTask failed. invoke by another player ");
        r104.append(r101);
        r104.append(". cur is ");
        a r105 = r100.f134164b;
        if (r105 == null) goto L9;
        r103 = r105.f134168b;
    L9:
        r104.append(r103);
        e(r104.toString());
        return;
    L11:
        if (r100.f134164b == null) goto L20;
        e("tryStartNextTask. end cur task");
        a r106 = r100.f134164b;
        if (r106 == null) goto L18;
        Disposable r107 = r106.f134167a;
        if (r107 == null) goto L17;
        r107.dispose();
    L17:
        r106.f134167a = null;
    L18:
        r100.f134164b = null;
    L20:
        if ((!r100.f134163a.isEmpty()) == false) goto L29;
        r100.f134164b = (a) ((PriorityQueue) r100.f134163a).poll();
        StringBuilder r108 = new StringBuilder("startNextTask: ");
        a r109 = r100.f134164b;
        if (r109 == null) goto L24;
        r103 = r109.f134169c;
    L24:
        r108.append(r103);
        e(r108.toString());
        a r110 = r100.f134164b;
        if (r110 == null) goto L30;
        r110.a(new ChatChannelAnimManager$timeoutAction$1(r100));
        return;
    L30:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.b
    public final b a(Context r100, ViewGroup r110, IPlayerActionListener r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r111, "listener");
        return new b(this, r100, r110, r111, ((long) Math.max(r112, 1)) * 1000);
    }
}
