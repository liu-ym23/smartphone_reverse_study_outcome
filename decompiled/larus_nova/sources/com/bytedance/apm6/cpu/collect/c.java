package com.bytedance.apm6.cpu.collect;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.apm.util.n;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends pu3.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CpuCacheItem.CpuDataType f190789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aq7.c.a f190790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f190791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f190792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f190793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f190794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f190795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f190796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f190797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f190798k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<n<String, Double>> f190799l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f190800a = null;

        static {
            int[] r100 = new int[CpuCacheItem.CpuDataType.values().length];
            f190800a = r100;
            r100[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f190800a[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f190800a[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // nu3.c
    public final boolean isValid() {
        return true;
    }

    @Override // pu3.a
    public final JSONObject c() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L14
        r100.put("process_name", com.bytedance.apm.d.c());     // Catch: Throwable -> L14
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, com.bytedance.apm.d.k());     // Catch: Throwable -> L14
        r100.put("scene", this.f190791d);     // Catch: Throwable -> L14
        int r101 = a.f190800a[this.f190789b.ordinal()];     // Catch: Throwable -> L14
        if (r101 != 1) goto L6;
        r100.put("data_type", "mix");     // Catch: Throwable -> L14
    L13:
        return r100;
    L6:
        if (r101 != 2) goto L8;
        r100.put("data_type", "back");     // Catch: Throwable -> L14
        goto L13
    L8:
        if (r101 != 3) goto L13;
        r100.put("data_type", NewBroadcastMonitor.CAPTURE.FRONT);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.getLocalizedMessage();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pu3.a
    public final JSONObject d() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L35
        List<n<String, Double>> r101 = this.f190799l;     // Catch: Throwable -> L35
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L24;
        Iterator r103 = ((ArrayList) this.f190799l).iterator();     // Catch: Throwable -> L35
    L11:
        if (r103.hasNext() == false) goto L34;
        n r104 = (n) r103.next();     // Catch: Throwable -> L35
        if (r104 == null) goto L11;
        F r105 = r104.f190676a;     // Catch: Throwable -> L35
        if (r105 == 0) goto L11;
        if (((String) r105).isEmpty() == true) goto L11;
        S r106 = r104.f190677b;     // Catch: Throwable -> L35
        if (r106 == 0) goto L11;
        if (((Double) r106).doubleValue() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L11;
        r100.put((String) r104.f190676a, r104.f190677b);     // Catch: Throwable -> L35
    L34:
        return r100;
    L24:
        double r107 = this.f190792e;     // Catch: Throwable -> L35
        if (r107 > (-1.0d)) goto L27;
    L29:
        double r108 = this.f190794g;     // Catch: Throwable -> L35
        if (r108 <= (-1.0d)) goto L34;
        if (this.f190795h <= (-1.0d)) goto L34;
        r100.put("app_stat_speed", r108);     // Catch: Throwable -> L35
        r100.put("app_max_stat_speed", this.f190795h);     // Catch: Throwable -> L35
        goto L34
    L27:
        if (this.f190793f <= (-1.0d)) goto L29;
        r100.put("app_usage_rate", r107);     // Catch: Throwable -> L35
        r100.put("app_max_usage_rate", this.f190793f);     // Catch: Throwable -> L35
        goto L29
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L7;
        r102 = true;
    L35:
        th = move-exception;
        th.getLocalizedMessage();
        return null;
    }

    @Override // pu3.a
    public final String f() {
        List<n<String, Double>> r100 = this.f190799l;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return "cpu_thread";
    L11:
        return "cpu";
    L5:
        if (((ArrayList) r100).isEmpty() == true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // pu3.a
    public final JSONObject e() {
        JSONObject r100 = ou3.a.a().b();     // Catch: Throwable -> L9
        r100.put("is_auto_sample", this.f190797j);     // Catch: Throwable -> L9
        if (this.f190790c == null) goto L5;
        r100.put("network_type", NetworkUtils.getNetworkTypeFast(com.bytedance.apm.d.getContext()));     // Catch: Throwable -> L9
        r100.put("battery_level", this.f190790c.f15916c);     // Catch: Throwable -> L9
        r100.put("cpu_hardware", this.f190790c.f15914a);     // Catch: Throwable -> L9
        r100.put("is_charging", this.f190790c.f15915b);     // Catch: Throwable -> L9
        r100.put("power_save_mode", this.f190790c.f15918e);     // Catch: Throwable -> L9
        r100.put("thermal_status", this.f190790c.f15917d);     // Catch: Throwable -> L9
        r100.put("battery_thermal", this.f190790c.f15919f);     // Catch: Throwable -> L9
        r100.put("is_normal_sample_state", this.f190798k);     // Catch: Throwable -> L9
    L5:
        float r101 = this.f190796i;     // Catch: Throwable -> L9
        if (r101 <= 0.0f) goto L8;
        r100.put(IPerformanceManager.Battery.battery_current, r101);     // Catch: Throwable -> L9
    L8:
        return r100;
    L9:
        th = move-exception;
        th.getLocalizedMessage();
        return null;
    }

    public c(CpuCacheItem.CpuDataType r100, String r101, List<n<String, Double>> r102, aq7.c.a r103) {
        this.f190792e = -1.0d;
        this.f190793f = -1.0d;
        this.f190794g = -1.0d;
        this.f190795h = -1.0d;
        this.f190796i = -1.0f;
        this.f190797j = true;
        this.f190798k = true;
        this.f190799l = new ArrayList(r102);
        this.f190789b = r100;
        this.f190791d = r101;
        this.f190790c = r103;
    }

    public c(CpuCacheItem.CpuDataType r100, String r101, double r102, double r103, double r104, double r110, aq7.c.a r111) {
        this.f190792e = -1.0d;
        this.f190793f = -1.0d;
        this.f190794g = -1.0d;
        this.f190795h = -1.0d;
        this.f190796i = -1.0f;
        this.f190797j = true;
        this.f190798k = true;
        this.f190789b = r100;
        this.f190791d = r101;
        this.f190792e = r102;
        this.f190793f = r103;
        this.f190794g = r104;
        this.f190795h = r110;
        this.f190790c = r111;
    }
}
