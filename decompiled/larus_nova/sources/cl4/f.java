package cl4;

import com.bytedance.dora.wlan.trace.DoraStationEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f24096a;

    public /* synthetic */ f(j r100) {
        this.f24096a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r100 = this.f24096a;
        a r101 = r100.f24102b;
        if (r101 == null) goto L6;
        r101.f24092g = true;
        List<DoraStationEvent> r102 = r101.f24091f;
        ArrayList r103 = (ArrayList) r102;
        r103.add(DoraStationEvent.notConnected);
        j.b(r100.f24102b, "invokeWiFiClose");
        return;
    }
}
