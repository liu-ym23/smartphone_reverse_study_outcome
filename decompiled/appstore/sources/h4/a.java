package h4;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* JADX INFO: loaded from: classes.dex */
public class a implements IHeartBeatMeta {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20325b;

    /* JADX INFO: renamed from: h4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0264a {
    }

    public static class b extends a {
        public /* synthetic */ b(C0264a r10) {
            this();
        }

        @Override // h4.a, com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
        public /* bridge */ /* synthetic */ IHeartBeatMeta provideDefaultMeta() {
            return super.c();
        }

        public b() {
            super(-1, PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);
        }
    }

    public a() {
    }

    public long a() {
        return this.f20324a;
    }

    public long b() {
        return this.f20325b;
    }

    public a c() {
        return new b(null);
    }

    public void d(long r10) {
        this.f20324a = r10;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
    public /* bridge */ /* synthetic */ IHeartBeatMeta provideDefaultMeta() {
        return c();
    }

    public a(long r10, long r11) {
        this.f20324a = r10;
        this.f20325b = r11;
    }
}
