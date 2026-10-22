package ag1;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.room.BackendData;
import com.bytedance.android.livesdkapi.model.ErrorBackendGeneratedData;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements zn0.e<com.bytedance.android.live.network.response.e<BackendData>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Handler f3270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Map f3271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f3272f;

    @Override // zn0.e
    public final void onComplete() {
        ALogger.e("RoomManager", "CHUNK onComplete");
        this.f3271e.put("room_id", String.valueOf(this.f3269c));
        this.f3271e.put("chunk_count", String.valueOf(this.f3267a));
        this.f3271e.put("all_chunk_arrive_time", String.valueOf(System.currentTimeMillis() - this.f3272f));
        j0.l().sendLog("livesdk_backend_chunk_time", this.f3271e, new Object[0]);
        if (this.f3268b == false) goto L6;
        ALogger.e("RoomManager", "backend_chunk_all_fail");
        Message r100 = this.f3270d.obtainMessage(43);
        r100.obj = new ErrorBackendGeneratedData();
        this.f3270d.sendMessage(r100);
        return;
    L6:
        Message r101 = this.f3270d.obtainMessage(42);
        r101.obj = Integer.valueOf(this.f3267a + 1);
        this.f3270d.sendMessage(r101);
    }

    @Override // zn0.e
    public final void onFailed(Throwable r100) {
        ALogger.e("RoomManager", "CHUNK onFailed:" + r100.toString());
        Message r101 = this.f3270d.obtainMessage(43);
        r101.obj = new ErrorBackendGeneratedData();
        this.f3270d.sendMessage(r101);
    }

    public c0(long r100, Handler r101, Map r102, long r103) {
        this.f3269c = r100;
        this.f3270d = r101;
        this.f3271e = r102;
        this.f3272f = r103;
        this.f3267a = 0;
        this.f3268b = true;
    }
}
