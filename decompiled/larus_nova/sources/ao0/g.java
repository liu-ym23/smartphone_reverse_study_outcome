package ao0;

import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.ITTNetNQEConfigHelper;
import com.bytedance.android.livesdk.config.md0;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f15712a = null;

    static {
        f15712a = md0.f120746a.getValue();
    }

    @JvmStatic
    public static final JSONObject a() {
        LinkedHashMap r100 = new LinkedHashMap();
        NetworkQuality r101 = TTNetInit.getNetworkQuality();     // Catch: Exception -> L33
        r100.put("http_rtt", Integer.valueOf(r101.httpRttMs));     // Catch: Exception -> L33
        r100.put("tcp_rtt", Integer.valueOf(r101.transportRttMs));     // Catch: Exception -> L33
        r100.put("quic_rtt", Integer.valueOf(r101.transportRttMs));     // Catch: Exception -> L33
        r100.put("downstream_throughput_kbps", Integer.valueOf(r101.downstreamThroughputKbps));     // Catch: Exception -> L33
        if (f15712a.booleanValue() == false) goto L12;
        PacketLossMetrics r102 = TTNetInit.getPacketLossRateMetrics(1);     // Catch: Exception -> L33
        r100.put("quic_send_loss_rate", Double.valueOf(r102.upstreamLossRate));     // Catch: Exception -> L33
        r100.put("quic_receive_loss_rate", Double.valueOf(r102.downstreamLossRate));     // Catch: Exception -> L33
        r100.put("net_effective_connection_type", Integer.valueOf(TTNetInit.getEffectiveConnectionType()));     // Catch: Exception -> L33
        IHostApp r103 = (IHostApp) k.f(IHostApp.class);     // Catch: Exception -> L33
        if (r103 == null) goto L10;
        ITTNetNQEConfigHelper r104 = r103.getTTNetNQEConfigHelper();     // Catch: Exception -> L33
        if (r104 == null) goto L10;
        int r105 = r104.getAverageSpeedInKBps();     // Catch: Exception -> L33
    L11:
        r100.put("video_download_speed", Integer.valueOf(r105));     // Catch: Exception -> L33
    L36:
        return new JSONObject(r100);
    L10:
        r105 = -1;
        goto L11
    L12:
        IHostApp r106 = (IHostApp) k.f(IHostApp.class);     // Catch: Exception -> L33
        Map r107 = null;
        if (r106 == null) goto L29;
        Map<String, String> r108 = r106.getNQEParams();     // Catch: Exception -> L33
        if (r108 == null) goto L29;
        LinkedHashMap r109 = new LinkedHashMap(MapsKt.mapCapacity(r108.size()));     // Catch: Exception -> L33
        Iterator<T> r110 = r108.entrySet().iterator();     // Catch: Exception -> L33
    L18:
        if (r110.hasNext() == false) goto L28;
        Object r111 = r110.next();     // Catch: Exception -> L33
        Object r112 = ((Map.Entry) r111).getKey();     // Catch: Exception -> L33
        Map.Entry r113 = (Map.Entry) r111;     // Catch: Exception -> L33
        Object r114 = StringsKt.toIntOrNull((String) r113.getValue());     // Catch: Exception -> L33
        if (r114 != null) goto L25;
        String r115 = (String) r113.getValue();     // Catch: Exception -> L33
        if (r115 == null) goto L24;
        r114 = StringsKt.toDoubleOrNull(r115);     // Catch: Exception -> L33
        goto L25
    L24:
        r114 = null;
    L25:
        if (r114 != null) goto L27;
        r114 = r113.getValue();     // Catch: Exception -> L33
    L27:
        r109.put(r112, r114);     // Catch: Exception -> L33
        goto L18
    L28:
        r107 = r109;
    L29:
        if (r107 != null) goto L31;
        r107 = MapsKt.emptyMap();     // Catch: Exception -> L33
    L31:
        r100.putAll(r107);     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }
}
