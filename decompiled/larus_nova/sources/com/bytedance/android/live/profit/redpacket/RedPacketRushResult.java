package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.livesdk.chatroom.model.o1;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class RedPacketRushResult {

    public static final class a extends RedPacketRushResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f88564a = null;

        static {
            f88564a = new a();
        }

        public a() {
        }
    }

    public static final class b extends RedPacketRushResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final py.k f88565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<m1> f88566b;

        public b(String r100, py.k r101, com.bytedance.android.live.revenue.common.u0 r102, String r103, List r104) {
            Intrinsics.checkNotNullParameter(r100, "voucherName");
            Intrinsics.checkNotNullParameter(r102, "voucherExpiredTime");
            Intrinsics.checkNotNullParameter(r103, "dressId");
            Intrinsics.checkNotNullParameter(r104, "vouchers");
            this.f88565a = r101;
            this.f88566b = r104;
        }
    }

    public static final class c extends RedPacketRushResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f88567a = null;

        static {
            f88567a = new c();
        }

        public c() {
        }
    }

    public static final class d extends RedPacketRushResult {
        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "dressId");
        }
    }

    public static final class e extends RedPacketRushResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f88568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final py.k f88569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f88570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o1.b f88571d;

        public e(int r100, String r101, py.k r102, long r103, o1.b r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "rewardName");
            Intrinsics.checkNotNullParameter(r105, "dressId");
            this.f88568a = r100;
            this.f88569b = r102;
            this.f88570c = r103;
            this.f88571d = r104;
        }
    }

    public RedPacketRushResult() {
    }
}
