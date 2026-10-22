package com.bytedance.android.live.revenue.platform.container.impl.core;

import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.android.live.revenue.platform.container.impl.z;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface g {
    public static final a D0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set<NotifyServiceCenterStateRequest.State> f91201a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Set<NotifyServiceCenterStateRequest.State> f91202b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f91203c = null;

        public a() {
        }

        static {
            f91203c = new a();
            NotifyServiceCenterStateRequest.State r100 = NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED;
            f91201a = SetsKt.setOf(r100);
            f91202b = SetsKt.setOf(new NotifyServiceCenterStateRequest.State[]{NotifyServiceCenterStateRequest.State.STARTED, r100});
        }

        public static Set a(CenterServiceType r100) {
            Intrinsics.checkNotNullParameter(r100, "centerServiceType");
            int r101 = f.f91200a[r100.ordinal()];
            if (r101 == 1) goto L16;
            if (r101 == 2) goto L19;
            if (r101 == 3) goto L18;
            if (r101 != 4) goto L12;
            return SetsKt.setOf(new NotifyServiceCenterStateRequest.State[]{NotifyServiceCenterStateRequest.State.STOPPED, NotifyServiceCenterStateRequest.State.PRE_STARTED, NotifyServiceCenterStateRequest.State.STARTED, NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED});
        L12:
            throw new NoWhenBranchMatchedException();
        L18:
            return SetsKt.setOf(new NotifyServiceCenterStateRequest.State[]{NotifyServiceCenterStateRequest.State.PRE_STARTED, NotifyServiceCenterStateRequest.State.STARTED, NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED});
        L19:
            return f91201a;
        L16:
            return f91202b;
        }
    }

    public static final class b {
        public static /* synthetic */ Observable a(g r100, Set r101, String r102, String r103, z r110) {
            return r100.K(r101, r102, r103, r110, false);
        }
    }

    static {
        D0 = a.f91203c;
    }

    void E();

    void I(List r100, RevenueJsDriver r101);

    Observable K(Set r100, String r101, String r102, z r103, boolean r104);

    void L0(RevenueJsDriver r100);

    NotifyServiceCenterStateRequest.State b0();

    void w0(List r100, RevenueJsDriver r101);
}
