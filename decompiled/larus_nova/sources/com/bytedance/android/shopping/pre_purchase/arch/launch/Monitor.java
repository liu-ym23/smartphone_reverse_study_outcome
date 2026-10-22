package com.bytedance.android.shopping.pre_purchase.arch.launch;

import com.bytedance.android.ec.core.event.EventActionImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class Monitor extends EventActionImpl implements d, h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f180636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f180637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f180638e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/pre_purchase/arch/launch/Monitor$State;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAILURE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State FAILURE = null;
        public static final State SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f180639a = null;
        private final String value;

        static {
            State r100 = new State("SUCCESS", 0, "success");
            SUCCESS = r100;
            State r101 = new State("FAILURE", 1, "failure");
            FAILURE = r101;
            f180639a = new State[]{r100, r101};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f180639a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public State(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChainName f180640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f180641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<c> f180642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f180643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f180644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public State f180645f;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L18;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f180640a, r101.f180640a) == true) goto L8;
            return false;
        L8:
            if (this.f180641b == r101.f180641b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f180642c, r101.f180642c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f180643d, r101.f180643d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f180644e, r101.f180644e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f180645f, r101.f180645f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            ChainName r100 = this.f180640a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            long r103 = this.f180641b;
            int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            CopyOnWriteArrayList<c> r105 = this.f180642c;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            Throwable r108 = this.f180643d;
            if (r108 == null) goto L13;
            int r109 = r108.hashCode();
        L14:
            int r110 = (r107 + r109) * 31;
            Long r111 = this.f180644e;
            if (r111 == null) goto L17;
            int r112 = r111.hashCode();
        L18:
            int r113 = (r110 + r112) * 31;
            State r114 = this.f180645f;
            if (r114 == null) goto L22;
            r101 = r114.hashCode();
        L22:
            return r113 + r101;
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ChainStats(chainName=" + this.f180640a + ", startTime=" + this.f180641b + ", stageStats=" + this.f180642c + ", error=" + this.f180643d + ", endTime=" + this.f180644e + ", state=" + this.f180645f + ")";
        }

        public a(ChainName r100) {
            long r101 = System.currentTimeMillis();
            CopyOnWriteArrayList<c> r102 = new CopyOnWriteArrayList();
            State r103 = State.FAILURE;
            Intrinsics.checkNotNullParameter(r100, "chainName");
            Intrinsics.checkNotNullParameter(r102, "stageStats");
            Intrinsics.checkNotNullParameter(r103, "state");
            this.f180640a = r100;
            this.f180641b = r101;
            this.f180642c = r102;
            this.f180643d = null;
            this.f180644e = null;
            this.f180645f = r103;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StageName f180646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f180647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f180648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public State f180649d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L14;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f180646a, r101.f180646a) == true) goto L8;
            return false;
        L8:
            if (this.f180647b == r101.f180647b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f180648c, r101.f180648c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f180649d, r101.f180649d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            StageName r100 = this.f180646a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            long r103 = this.f180647b;
            int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            Long r105 = this.f180648c;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            State r108 = this.f180649d;
            if (r108 == null) goto L14;
            r101 = r108.hashCode();
        L14:
            return r107 + r101;
        L9:
            r106 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "StageStats(stageName=" + this.f180646a + ", startTime=" + this.f180647b + ", endTime=" + this.f180648c + ", state=" + this.f180649d + ")";
        }

        public c(StageName r100, long r101) {
            State r102 = State.FAILURE;
            Intrinsics.checkNotNullParameter(r100, "stageName");
            Intrinsics.checkNotNullParameter(r102, "state");
            this.f180646a = r100;
            this.f180647b = r101;
            this.f180648c = null;
            this.f180649d = r102;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.d
    public final void c() {
        a r100 = this.f180636c;
        if (r100 == null) goto L5;
        r100.f180644e = Long.valueOf(System.currentTimeMillis());
        State r101 = State.SUCCESS;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f180645f = r101;
    L5:
        o();
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void d() {
        c r100 = this.f180637d;
        if (r100 == null) goto L5;
        r100.f180648c = Long.valueOf(System.currentTimeMillis());
    L5:
        c r101 = this.f180637d;
        if (r101 == null) goto L8;
        State r102 = State.SUCCESS;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f180649d = r102;
    L8:
        a r103 = this.f180636c;
        if (r103 == null) goto L14;
        CopyOnWriteArrayList<c> r104 = r103.f180642c;
        if (r104 == null) goto L15;
        r104.add(this.f180637d);
        return;
    L15:
        return;
    }

    public final void o() {
        LinkedHashMap r100 = new LinkedHashMap();
        a r101 = this.f180636c;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = String.valueOf(r101.f180641b);
    L6:
        r100.put("T_chain_start", r103);
        a r104 = this.f180636c;
        if (r104 == null) goto L11;
        Long r105 = r104.f180644e;
        if (r105 == null) goto L11;
        String r106 = String.valueOf(r105.longValue());
    L12:
        r100.put("T_chain_end", r106);
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r108 = this.f180638e.entrySet().iterator();
    L14:
        if (r108.hasNext() == false) goto L16;
        Map.Entry<String, String> r109 = r108.next();
        r107.put(r109.getKey(), r109.getValue());
        goto L14
    L16:
        a r110 = this.f180636c;
        if (r110 == null) goto L21;
        ChainName r111 = r110.f180640a;
        if (r111 == null) goto L21;
        String r112 = r111.getValue();
    L22:
        r107.put("name", r112);
        a r113 = this.f180636c;
        if (r113 == null) goto L27;
        State r114 = r113.f180645f;
        if (r114 == null) goto L27;
        r102 = r114.getValue();
    L27:
        r107.put("state", r102);
        a r115 = this.f180636c;
        if (r115 == null) goto L34;
        Throwable r116 = r115.f180643d;
        if (r116 == null) goto L34;
        String r117 = r116.getMessage();
        if (r117 == null) goto L34;
        r107.put("error_msg", r117);
    L34:
        LinkedHashMap r118 = new LinkedHashMap();
        a r119 = this.f180636c;
        if (r119 == null) goto L42;
        CopyOnWriteArrayList<c> r120 = r119.f180642c;
        if (r120 == null) goto L42;
        Iterator<T> r121 = r120.iterator();
    L40:
        if (r121.hasNext() == false) goto L42;
        c r122 = (c) r121.next();
        r100.put("T_" + r122.f180646a.getValue() + "_start", String.valueOf(r122.f180647b));
        r100.put("T_" + r122.f180646a.getValue() + "_end", String.valueOf(r122.f180648c));
        r118.put(r122.f180646a.getValue() + "_state", r122.f180649d.getValue());
    L42:
        r107.put("timing", com.bytedance.android.shopping.extensions.k.x(r100));
        r107.put("stage_state", com.bytedance.android.shopping.extensions.k.x(r118));
        doEventAction("ec_launcher_trace", r107, new Pair[0]);
        return;
    L21:
        r112 = null;
    L11:
        r106 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public Monitor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        ConcurrentHashMap<String, String> r101 = new ConcurrentHashMap();
        r101.put("session_id", r100);
        Unit r102 = Unit.INSTANCE;
        this.f180638e = r101;
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void h(Throwable r100) {
        c r101 = this.f180637d;
        if (r101 == null) goto L5;
        r101.f180648c = Long.valueOf(System.currentTimeMillis());
    L5:
        c r102 = this.f180637d;
        if (r102 == null) goto L8;
        State r103 = State.FAILURE;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f180649d = r103;
    L8:
        a r104 = this.f180636c;
        if (r104 == null) goto L14;
        CopyOnWriteArrayList<c> r105 = r104.f180642c;
        if (r105 == null) goto L15;
        r105.add(this.f180637d);
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.d
    public final void i(Throwable r100) {
        a r101 = this.f180636c;
        if (r101 == null) goto L5;
        r101.f180644e = Long.valueOf(System.currentTimeMillis());
        State r102 = State.FAILURE;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f180645f = r102;
        r101.f180643d = r100;
    L5:
        o();
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.d
    public final void k(ChainName r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f180636c = new a(r100);
    }

    @Override // com.bytedance.android.shopping.pre_purchase.arch.launch.h
    public final void e(StageName r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f180637d = new c(r100, System.currentTimeMillis());
        if (r101 == null) goto L10;
        Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        if (this.f180638e.containsKey(r104) == true) goto L6;
        this.f180638e.put(r104, String.valueOf(r105));
        goto L6
    L16:
        return;
    }
}
