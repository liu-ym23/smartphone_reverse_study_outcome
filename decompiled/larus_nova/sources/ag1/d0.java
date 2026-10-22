package ag1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.j2;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.room.BackendData;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 implements zn0.e<com.bytedance.android.live.network.response.e<BackendData>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f3276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f3277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f3278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f3279f;

    @Override // zn0.e
    public final void onComplete() {
        ALogger.e("RoomManager", "CHUNK onComplete");
        if (j2.f65330a.getValue().disable_backend_monitor == true) goto L6;
        this.f3277d.put("room_id", String.valueOf(this.f3279f));
        this.f3277d.put("chunk_count", String.valueOf(this.f3274a));
        this.f3277d.put("all_chunk_arrive_time", String.valueOf(System.currentTimeMillis() - this.f3278e));
        j0.l().sendLog("livesdk_backend_chunk_time", this.f3277d, new Object[0]);
    L6:
        if (this.f3275b == false) goto L9;
        ALogger.e("RoomManager", "backend_chunk_all_fail");
        BackendData r100 = new BackendData();
        r100.setApiAllFailure(true);
        this.f3276c.invoke(r100, -1);
        return;
    L9:
        this.f3276c.invoke(new BackendData(), Integer.valueOf(this.f3274a + 1));
    }

    @Override // zn0.e
    public final void onFailed(Throwable r100) {
        ALogger.e("RoomManager", "CHUNK onFailed:" + r100.toString());
        if (this.f3276c == null) goto L6;
        BackendData r101 = new BackendData();
        r101.setApiAllFailure(true);
        this.f3276c.invoke(r101, -1);
        return;
    }

    public d0(Function2 r100, Map r101, long r102, long r103) {
        this.f3276c = r100;
        this.f3277d = r101;
        this.f3278e = r102;
        this.f3279f = r103;
        this.f3274a = 0;
        this.f3275b = true;
    }
}
