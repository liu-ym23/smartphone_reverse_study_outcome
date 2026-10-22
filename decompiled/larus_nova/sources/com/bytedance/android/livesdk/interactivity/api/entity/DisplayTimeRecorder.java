package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.utils.MaxSizeList;
import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class DisplayTimeRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f133121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f133122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MaxSizeList<b> f133123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<i, g, h> f133124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f133125e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f133126f;

    public interface a {
        void a(int r100);

        void b(b r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f133127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f133128b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f133127a == r101.f133127a) goto L8;
            return false;
        L8:
            if (this.f133128b == r101.f133128b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f133127a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f133128b;
            return r101 + ((int) (r102 ^ (r102 >>> 32)));
        }

        public final String toString() {
            return "TimeRecord(startTime=" + this.f133127a + ", endTime=" + this.f133128b + ")";
        }

        public b(long r100, long r101) {
            this.f133127a = r100;
            this.f133128b = r101;
        }
    }

    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine<i, g, h> r101 = this.f133124d;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }

    public DisplayTimeRecorder(t r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f133125e = r100;
        this.f133126f = r101;
        this.f133123c = new MaxSizeList(10);
        StateMachine.a r102 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<i, g, h>, Unit> r103 = new DisplayTimeRecorder$stateMachine$1(this);
        r102.getClass();
        this.f133124d = StateMachine.a.a(r103);
    }
}
