package com.stepos.probe;

import android.util.Log;
import c7.j;
import c7.p;
import c7.r;
import d7.z;
import g7.d;
import i7.e;
import i7.i;
import ia.b0;
import ia.d0;
import ia.f1;
import ia.g1;
import ia.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import p7.n;
import q7.k;
import w7.e0;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004`\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\r0\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u0015J\u001d\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\u0003R\u0014\u0010\"\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010(R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010(R(\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00062"}, d2 = {"Lcom/stepos/probe/PowerCollector;", "", "<init>", "()V", "", "readCpuPct", "()Ljava/lang/Integer;", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "readTemps", "()Ljava/util/LinkedHashMap;", "", "Lc7/j;", "classifyThermalZones", "()Ljava/util/List;", "", "readPowerUW", "()Ljava/lang/Double;", "", "readCharging", "()Z", "currentEnergyUwh", "()I", "sampleCount", "isRunning", "Lia/b0;", "scope", "", "intervalMs", "Lc7/r;", "start", "(Lia/b0;J)V", "stop", "TAG", "Ljava/lang/String;", "BATT", "energyUWh", "D", "lastNs", "J", "Lia/g1;", "job", "Lia/g1;", "samples", "I", "lastBusy", "lastTotal", "thermalTargets", "Ljava/util/List;", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PowerCollector {
    private static final String BATT = "/sys/class/power_supply/battery";
    private static final String TAG = "clawbench_power";
    private static volatile double energyUWh;
    private static g1 job;
    private static long lastNs;
    private static volatile int samples;
    public static final PowerCollector INSTANCE = new PowerCollector();
    private static long lastBusy = -1;
    private static long lastTotal = -1;
    private static List<j> thermalTargets = z.f2978f;

    @e(c = "com.stepos.probe.PowerCollector$start$1", f = "PowerCollector.kt", l = {94}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lia/b0;", "Lc7/r;", "<anonymous>", "(Lia/b0;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.stepos.probe.PowerCollector$start$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements n {
        final /* synthetic */ List<Integer> $cpus;
        final /* synthetic */ long $intervalMs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j2, List<Integer> list, d dVar) {
            super(2, dVar);
            this.$intervalMs = j2;
            this.$cpus = list;
        }

        @Override // i7.a
        public final d create(Object obj, d dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$intervalMs, this.$cpus, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // p7.n
        public final Object invoke(b0 b0Var, d dVar) {
            return ((AnonymousClass1) create(b0Var, dVar)).invokeSuspend(r.f1986a);
        }

        @Override // i7.a
        public final Object invokeSuspend(Object obj) {
            b0 b0Var;
            Integer num;
            Integer numI0;
            h7.a aVar = h7.a.f4212f;
            int i2 = this.label;
            if (i2 == 0) {
                e0.N(obj);
                b0 b0Var2 = (b0) this.L$0;
                Log.i(PowerCollector.TAG, "PowerCollector start interval=" + this.$intervalMs + "ms window=" + ReleaseBuckets.INSTANCE.getWindowMs() + "ms cpus=" + this.$cpus + " thermal=" + PowerCollector.thermalTargets);
                b0Var = b0Var2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (b0) this.L$0;
                e0.N(obj);
            }
            while (d0.q(b0Var)) {
                PowerCollector powerCollector = PowerCollector.INSTANCE;
                Double powerUW = powerCollector.readPowerUW();
                long jNanoTime = System.nanoTime();
                if (powerUW != null) {
                    PowerCollector.energyUWh = (powerUW.doubleValue() * ((jNanoTime - PowerCollector.lastNs) / 3.6E12d)) + PowerCollector.energyUWh;
                    num = new Integer((int) (powerUW.doubleValue() / 1000));
                    PerfettoSink perfettoSink = PerfettoSink.INSTANCE;
                    perfettoSink.emit("power_now_mw", num.intValue());
                    perfettoSink.emit("energy_total_uwh", (int) PowerCollector.energyUWh);
                } else {
                    num = null;
                }
                Integer num2 = num;
                PowerCollector.lastNs = jNanoTime;
                boolean charging = powerCollector.readCharging();
                Integer cpuPct = powerCollector.readCpuPct();
                if (cpuPct != null) {
                    PerfettoSink.INSTANCE.emit("cpu_pct", cpuPct.intValue());
                }
                Iterator<T> it = this.$cpus.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    String raw = SysfsProbe.INSTANCE.readRaw("/sys/devices/system/cpu/cpu" + iIntValue + "/cpufreq/scaling_cur_freq");
                    if (raw != null && (numI0 = ga.r.i0(raw)) != null) {
                        int iIntValue2 = numI0.intValue();
                        PerfettoSink.INSTANCE.emit("cpu" + iIntValue + "_freq_khz", iIntValue2);
                    }
                }
                LinkedHashMap temps = PowerCollector.INSTANCE.readTemps();
                Integer num3 = (Integer) temps.get("battery");
                if (num3 != null) {
                    PerfettoSink.INSTANCE.emit("batt_temp_c", num3.intValue());
                }
                ReleaseBuckets.INSTANCE.addSample(num2, (int) PowerCollector.energyUWh, cpuPct, temps, charging);
                PowerCollector.samples++;
                long j2 = this.$intervalMs;
                this.L$0 = b0Var;
                this.label = 1;
                if (d0.g(j2, this) == aVar) {
                    return aVar;
                }
            }
            return r.f1986a;
        }
    }

    private PowerCollector() {
    }

    private final List<j> classifyThermalZones() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (p pVar : SysfsProbe.INSTANCE.enumerateThermalZones()) {
            int iIntValue = ((Number) pVar.f1982f).intValue();
            String lowerCase = ((String) pVar.f1983g).toLowerCase(Locale.ROOT);
            k.d(lowerCase, "toLowerCase(...)");
            if (ga.k.k0(lowerCase, "cpu", false) && !linkedHashMap.containsKey("cpu")) {
                linkedHashMap.put("cpu", Integer.valueOf(iIntValue));
            } else if ((ga.k.k0(lowerCase, "npu", false) || ga.k.k0(lowerCase, "nsp", false)) && !linkedHashMap.containsKey("npu")) {
                linkedHashMap.put("npu", Integer.valueOf(iIntValue));
            } else if (ga.k.k0(lowerCase, "gpu", false) && !linkedHashMap.containsKey("gpu")) {
                linkedHashMap.put("gpu", Integer.valueOf(iIntValue));
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new j(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean readCharging() {
        if (SysfsProbe.INSTANCE.readRaw("/sys/class/power_supply/battery/status") == null) {
            return false;
        }
        return !r1.equalsIgnoreCase("Discharging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer readCpuPct() {
        long[] cpuJiffies = SysfsProbe.INSTANCE.readCpuJiffies();
        Integer numValueOf = null;
        if (cpuJiffies == null) {
            return null;
        }
        long j2 = cpuJiffies[0];
        long j4 = cpuJiffies[1];
        long j10 = lastTotal;
        if (j10 >= 0 && j4 > j10) {
            numValueOf = Integer.valueOf(nb.i.k((int) (((j2 - lastBusy) * 100.0d) / (j4 - j10)), 0, 100));
        }
        lastBusy = j2;
        lastTotal = j4;
        return numValueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Double readPowerUW() {
        Long lJ0;
        Long lJ02;
        SysfsProbe sysfsProbe = SysfsProbe.INSTANCE;
        String raw = sysfsProbe.readRaw("/sys/class/power_supply/battery/current_now");
        if (raw != null && (lJ0 = ga.r.j0(raw)) != null) {
            long jLongValue = lJ0.longValue();
            String raw2 = sysfsProbe.readRaw("/sys/class/power_supply/battery/voltage_now");
            if (raw2 != null && (lJ02 = ga.r.j0(raw2)) != null) {
                return Double.valueOf(Math.abs((jLongValue * lJ02.longValue()) / 1000000.0d));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkedHashMap<String, Integer> readTemps() {
        Integer numI0;
        Integer numI02;
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        String raw = SysfsProbe.INSTANCE.readRaw("/sys/class/power_supply/battery/temp");
        if (raw != null && (numI02 = ga.r.i0(raw)) != null) {
            linkedHashMap.put("battery", Integer.valueOf(numI02.intValue() / 10));
        }
        for (j jVar : thermalTargets) {
            String str = (String) jVar.f1973f;
            int iIntValue = ((Number) jVar.f1974g).intValue();
            String raw2 = SysfsProbe.INSTANCE.readRaw("/sys/class/thermal/thermal_zone" + iIntValue + "/temp");
            if (raw2 != null && (numI0 = ga.r.i0(raw2)) != null) {
                linkedHashMap.put(str, Integer.valueOf(numI0.intValue() / 1000));
            }
        }
        return linkedHashMap;
    }

    public final int currentEnergyUwh() {
        return (int) energyUWh;
    }

    public final boolean isRunning() {
        g1 g1Var = job;
        return g1Var != null && g1Var.b();
    }

    public final int sampleCount() {
        return samples;
    }

    public final void start(b0 scope, long intervalMs) {
        k.e(scope, "scope");
        if (isRunning()) {
            return;
        }
        energyUWh = 0.0d;
        samples = 0;
        lastNs = System.nanoTime();
        lastBusy = -1L;
        lastTotal = -1L;
        thermalTargets = classifyThermalZones();
        List<Integer> listEnumerateCpuClusters = SysfsProbe.INSTANCE.enumerateCpuClusters();
        ReleaseBuckets.INSTANCE.start();
        pa.e eVar = n0.f4982a;
        job = d0.s(scope, pa.d.f8556h, null, new AnonymousClass1(intervalMs, listEnumerateCpuClusters, null), 2);
    }

    public final void stop() {
        g1 g1Var = job;
        if (g1Var != null) {
            f1.cancel$default(g1Var, (CancellationException) null, 1, (Object) null);
        }
        job = null;
        ReleaseBuckets.INSTANCE.stop();
        Log.i(TAG, "PowerCollector stop, samples=" + samples + " energy=" + ((int) energyUWh) + "μWh");
    }
}
