package com.bytedance.android.logsdk.collect.observer;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.logsdk.format.Spm;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;
import tw2.b;

/* JADX INFO: loaded from: classes12.dex */
public final class LifecycleLogObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<b, Byte> f162663a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/logsdk/collect/observer/LifecycleLogObserver$LIFECYCLESTATE;", "", "", "value", "I", "getValue", "()I", "CREATE", "APPEAR", "DISAPPEAR", "DESTROY", "live-logsdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LIFECYCLESTATE extends Enum<LIFECYCLESTATE> {
        public static final LIFECYCLESTATE APPEAR = null;
        public static final LIFECYCLESTATE CREATE = null;
        public static final LIFECYCLESTATE DESTROY = null;
        public static final LIFECYCLESTATE DISAPPEAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LIFECYCLESTATE[] f162664a = null;
        private final int value;

        static {
            LIFECYCLESTATE r100 = new LIFECYCLESTATE("CREATE", 0, 1);
            CREATE = r100;
            LIFECYCLESTATE r101 = new LIFECYCLESTATE("APPEAR", 1, 10);
            APPEAR = r101;
            LIFECYCLESTATE r102 = new LIFECYCLESTATE("DISAPPEAR", 2, 20);
            DISAPPEAR = r102;
            LIFECYCLESTATE r103 = new LIFECYCLESTATE("DESTROY", 3, 30);
            DESTROY = r103;
            f162664a = new LIFECYCLESTATE[]{r100, r101, r102, r103};
        }

        public static LIFECYCLESTATE valueOf(String r100) {
            return (LIFECYCLESTATE) a.a(LIFECYCLESTATE.class, r100);
        }

        public static LIFECYCLESTATE[] values() {
            return (LIFECYCLESTATE[]) f162664a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public LIFECYCLESTATE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f162663a = new WeakHashMap();
    }

    public static void a(b r100, LIFECYCLESTATE r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isIgnored() == true) goto L18;
        String r102 = r100.getSpm();
        if (r102 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r102, "") == false) goto L11;
        return;
    L11:
        HashMap r103 = new HashMap();
        Map<String, Object> r104 = r100.getPropertyParams();
        if (r104 == null) goto L14;
        r103.putAll(r104);
    L14:
        int r105 = ww2.a.f561626a;
        r103.put(NewBroadcastMonitor.STAGE.LIFECYCLE, Integer.valueOf(r101.getValue()));
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.b(r102, 1000).args(r103), NewBroadcastMonitor.STAGE.LIFECYCLE);
        return;
    }
}
