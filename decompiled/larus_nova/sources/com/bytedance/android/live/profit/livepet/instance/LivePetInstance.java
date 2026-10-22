package com.bytedance.android.live.profit.livepet.instance;

import android.net.Uri;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.live.revenue.common.x0;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class LivePetInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.common.reactive.c f87871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ru0.b f87872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u0 f87873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f87874d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/livepet/instance/LivePetInstance$State;", "", "Uninitialized", "Created", "Loading", "LoadCompleted", "LoadFailed", "Destroyed", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum State extends Enum<State> {
        public static final State Created = null;
        public static final State Destroyed = null;
        public static final State LoadCompleted = null;
        public static final State LoadFailed = null;
        public static final State Loading = null;
        public static final State Uninitialized = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f87875a = null;

        static {
            State r100 = new State("Uninitialized", 0);
            Uninitialized = r100;
            State r101 = new State("Created", 1);
            Created = r101;
            State r102 = new State("Loading", 2);
            Loading = r102;
            State r103 = new State("LoadCompleted", 3);
            LoadCompleted = r103;
            State r104 = new State("LoadFailed", 4);
            LoadFailed = r104;
            State r105 = new State("Destroyed", 5);
            Destroyed = r105;
            f87875a = new State[]{r100, r101, r102, r103, r104, r105};
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f87875a.clone();
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final State a() {
        return (State) this.f87871a.f90981b;
    }

    public final Uri b() {
        String r100 = this.f87874d.f87885b;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        x0 r101 = new x0(r100);
        x0 r102 = r101.d("url");
        qu0.a.c r103 = qu0.b.f534836c.b(this.f87874d.f87884a);
        if (r103 == null) goto L8;
        LivePetInstance$appendUrlParams$petConfig$1 r104 = LivePetInstance$appendUrlParams$petConfig$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r104, "factory");
        qu0.a.c r105 = r104.invoke(r103.f90911a.deepCopy());
    L9:
        if (r105 == null) goto L22;
        r105.f534833b.b(r105, qu0.a.c.f534832c[0], null);
        Iterator r106 = CollectionsKt.toList(r105.f90911a.entrySet()).iterator();
    L12:
        if (r106.hasNext() == false) goto L22;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getKey();
        JsonElement r109 = (JsonElement) r107.getValue();
        Intrinsics.checkNotNullParameter(r109, "$this$convertToString");
        if ((r109 instanceof JsonNull) == false) goto L17;
        String r110 = null;
    L20:
        r102.b(r108, r110);
        goto L12
    L17:
        if ((r109 instanceof JsonPrimitive) == false) goto L19;
        r110 = r109.getAsString();
        goto L20
    L19:
        r110 = r109.toString();
    L22:
        return r101.c();
    L8:
        r105 = null;
        goto L9
    }

    public LivePetInstance(c r100) {
        Intrinsics.checkNotNullParameter(r100, "loadParams");
        this.f87874d = r100;
        this.f87871a = new com.bytedance.android.live.revenue.common.reactive.c(State.Uninitialized);
        this.f87873c = u0.f90999f;
    }
}
