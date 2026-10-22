package cl4;

import com.bytedance.dora.wlan.trace.DoraConnectionFailedReason;
import com.bytedance.dora.wlan.trace.DoraStationEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f24097a;

    public /* synthetic */ g(j r100, String r101) {
        this.f24097a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r100 = this.f24097a;
        a r101 = r100.f24102b;
        if (r101 != null) goto L5;
    L7:
        a r102 = new a();
        r100.f24102b = r102;
        r102.f24086a = UUID.randomUUID();
        r100.f24102b.getClass();
        a r103 = r100.f24102b;
        r103.f24087b = System.currentTimeMillis();
        List<DoraStationEvent> r104 = r100.f24102b.f24091f;
        ArrayList r105 = (ArrayList) r104;
        r105.add(DoraStationEvent.stationOpenCMDSending);
        r100.f24102b.f24092g = false;
        return;
    L5:
        if (r101.f24092g == true) goto L7;
        j.a(r101, false, DoraConnectionFailedReason.STATION_UN_KNOWN_ERROR);
    }
}
