package bt2;

import com.bytedance.android.livesdk.room.LiveScope;
import com.bytedance.android.livesdk.room.state.LiveSdkState;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes11.dex */
public final class d extends com.bytedance.android.livesdk.room.a<a, LiveSdkState, b<?>> {
    @Override // com.bytedance.android.livesdk.room.a
    public final void initState() {
        setInit(true);
    }

    @Override // com.bytedance.android.livesdk.room.a
    public final LiveScope getCurrentScope() {
        return LiveScope.LIVE;
    }

    public d(a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
    }

    @Override // com.bytedance.android.livesdk.room.a
    public final List handlerState(ts2.b r100, String r101, List r102) {
        LiveSdkState r103 = (LiveSdkState) r100;
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r101, "nodeName");
        int r104 = c.f20528a[r103.ordinal()];
        if (r104 != 1) goto L5;
        ArrayList r105 = new ArrayList();
        if (r102 == null) goto L28;
        Iterator r106 = r102.iterator();
    L26:
        if (r106.hasNext() == false) goto L28;
        b r107 = (b) r106.next();
        qs2.a<a> r108 = getMLiveEnterRoomMonitor();
        String r109 = Reflection.getOrCreateKotlinClass(r107.getClass()).getSimpleName();
        Intrinsics.checkNotNull(r109);
        r108.d(r101, r109);
        Intrinsics.checkNotNullParameter(getMContext(), "sdkContext");
        qs2.a<a> r110 = getMLiveEnterRoomMonitor();
        String r111 = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        Intrinsics.checkNotNull(r111);
        r110.f(r101, r111);
    L28:
        return r105;
    L5:
        if (r104 != 2) goto L7;
        r105 = new ArrayList();
        if (r102 == null) goto L28;
        Iterator r112 = r102.iterator();
    L20:
        if (r112.hasNext() == false) goto L28;
        b r113 = (b) r112.next();
        qs2.a<a> r114 = getMLiveEnterRoomMonitor();
        String r115 = Reflection.getOrCreateKotlinClass(r113.getClass()).getSimpleName();
        Intrinsics.checkNotNull(r115);
        r114.d(r101, r115);
        Intrinsics.checkNotNullParameter(getMContext(), "sdkContext");
        qs2.a<a> r116 = getMLiveEnterRoomMonitor();
        String r117 = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        Intrinsics.checkNotNull(r117);
        r116.f(r101, r117);
        goto L20
    L7:
        if (r104 != 3) goto L15;
        r105 = new ArrayList();
        if (r102 == null) goto L28;
        Iterator r118 = r102.iterator();
    L12:
        if (r118.hasNext() == false) goto L28;
        b r119 = (b) r118.next();
        qs2.a<a> r120 = getMLiveEnterRoomMonitor();
        String r121 = Reflection.getOrCreateKotlinClass(r119.getClass()).getSimpleName();
        Intrinsics.checkNotNull(r121);
        r120.d(r101, r121);
        Intrinsics.checkNotNullParameter(getMContext(), "sdkContext");
        qs2.a<a> r122 = getMLiveEnterRoomMonitor();
        String r123 = Reflection.getOrCreateKotlinClass(b.class).getSimpleName();
        Intrinsics.checkNotNull(r123);
        r122.f(r101, r123);
        goto L12
    L15:
        throw new NoWhenBranchMatchedException();
    }
}
