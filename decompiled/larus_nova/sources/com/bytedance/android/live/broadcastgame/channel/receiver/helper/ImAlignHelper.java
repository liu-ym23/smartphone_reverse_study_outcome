package com.bytedance.android.live.broadcastgame.channel.receiver.helper;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.broadcastgame.api.channel.DelayType;
import com.bytedance.android.live.broadcastgame.api.model.k;
import com.bytedance.android.live.broadcastgame.opengame.message.b0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ImAlignHelper {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f59569e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f59570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<k, Unit> f59573d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f59574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<b, Unit> f59575b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f59574a, r101.f59574a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f59575b, r101.f59575b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            k r100 = this.f59574a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Function1<b, Unit> r104 = this.f59575b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Entry(message=" + this.f59574a + ", runAction=" + this.f59575b + ")";
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f59575b.invoke(this);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(b0 r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "runAction");
            this.f59574a = r100;
            this.f59575b = r101;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImAlignHelper(Function1<? super k, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "dispatch");
        this.f59573d = r100;
        this.f59570a = new Handler(Looper.getMainLooper());
        this.f59571b = LazyKt.lazy(ImAlignHelper$cale$2.INSTANCE);
        this.f59572c = LazyKt.lazy(ImAlignHelper$queue$2.INSTANCE);
    }

    public final void a(b0 r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if (r110.b() != DelayType.NO_DELAY.getValue()) goto L5;
    L21:
        this.f59573d.invoke(r110);
        return;
    L5:
        if (r110.f60191b == 0) goto L21;
        b r100 = new b(r110, new ImAlignHelper$addMessage$entry$1(this));
        com.bytedance.android.live.broadcastgame.channel.receiver.helper.a r101 = (com.bytedance.android.live.broadcastgame.channel.receiver.helper.a) this.f59571b.getValue();
        long r102 = r110.f60191b;
        if (r102 <= 0) goto L15;
        long r103 = r101.f59580c;
        if (r103 <= 0) goto L15;
        if (r101.f59579b <= 0) goto L15;
        long r104 = Math.max(com.bytedance.android.live.broadcastgame.channel.receiver.helper.a.f59577e, Math.min(com.bytedance.android.live.broadcastgame.channel.receiver.helper.a.f59576d, (r102 - r103) - (System.currentTimeMillis() - r101.f59579b)));
        r101.f59578a = r104;
    L17:
        if (v.a() == false) goto L19;
        ALogger.i("AAM.ImAlignHelper", "delay " + r104);
    L19:
        this.f59570a.postDelayed(r100, r104);
        ((PriorityQueue) this.f59572c.getValue()).offer(r100);
        return;
    L15:
        r104 = r101.f59578a;
        goto L17
    }
}
