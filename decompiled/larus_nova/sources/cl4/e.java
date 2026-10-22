package cl4;

import com.bytedance.dora.wlan.trace.DoraConnectionFailedReason;
import com.bytedance.dora.wlan.trace.DoraStationEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f24094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f24095b;

    public /* synthetic */ e(j r100, int r101) {
        this.f24094a = r100;
        this.f24095b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final j r100 = this.f24094a;
        if (this.f24095b != 0) goto L8;
        a r101 = r100.f24102b;
        if (r101 == null) goto L7;
        r101.f24088c = System.currentTimeMillis();
        List<DoraStationEvent> r102 = r100.f24102b.f24091f;
        ArrayList r103 = (ArrayList) r102;
        r103.add(DoraStationEvent.stationOpenCMDSendSuccess);
    L7:
        r100.f24101a.postDelayed(new i(r100), 10000);
        return;
    L8:
        a r104 = r100.f24102b;
        if (r104 == null) goto L13;
        r104.f24088c = System.currentTimeMillis();
        List<DoraStationEvent> r105 = r100.f24102b.f24091f;
        ArrayList r106 = (ArrayList) r105;
        r106.add(DoraStationEvent.stationOpenCMDSendFailed);
        a r107 = r100.f24102b;
        r107.f24092g = true;
        j.a(r107, false, DoraConnectionFailedReason.STATION_OPEN_CMD_SEND_FAILED);
        return;
    }
}
