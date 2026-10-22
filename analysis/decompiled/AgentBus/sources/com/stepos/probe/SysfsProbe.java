package com.stepos.probe;

import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.util.Log;
import c6.d;
import c7.j;
import c7.p;
import d7.n;
import d7.s;
import d7.t;
import d7.z;
import ga.r;
import ib.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import m.x;
import n7.l;
import q7.k;
import w7.e0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003!\"#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\r\u0010\u000bJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\b¢\u0006\u0004\b\u0011\u0010\u000bJ%\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00120\b¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\b¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0007J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/stepos/probe/SysfsProbe;", "", "<init>", "()V", "", "path", "tryRead", "(Ljava/lang/String;)Ljava/lang/String;", "", "Lc7/j;", "enumeratePowerSupplies", "()Ljava/util/List;", "Lcom/stepos/probe/SysfsProbe$SysfsEntry;", "discoverPowerSupplyEntries", "diagnosePowerSupplyAccess", "()Ljava/lang/String;", "", "enumerateCpuClusters", "Lc7/p;", "enumerateThermalZones", "pkg", "findPidByPackage", "(Ljava/lang/String;)Ljava/lang/Integer;", "Lcom/stepos/probe/SysfsProbe$ReadResult;", "probeMatrix", "readRaw", "", "readCpuJiffies", "()[J", "readTimed", "(Ljava/lang/String;)Lcom/stepos/probe/SysfsProbe$ReadResult;", "TAG", "Ljava/lang/String;", "Unit", "SysfsEntry", "ReadResult", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SysfsProbe {
    public static final SysfsProbe INSTANCE = new SysfsProbe();
    private static final String TAG = "clawbench_probe_v1";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/stepos/probe/SysfsProbe$ReadResult;", "", "path", "", "raw", "costUs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getPath", "()Ljava/lang/String;", "getRaw", "getCostUs", "()J", "ok", "", "getOk", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ReadResult {
        private final long costUs;
        private final String path;
        private final String raw;

        public ReadResult(String str, String str2, long j2) {
            k.e(str, "path");
            this.path = str;
            this.raw = str2;
            this.costUs = j2;
        }

        public static /* synthetic */ ReadResult copy$default(ReadResult readResult, String str, String str2, long j2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = readResult.path;
            }
            if ((i2 & 2) != 0) {
                str2 = readResult.raw;
            }
            if ((i2 & 4) != 0) {
                j2 = readResult.costUs;
            }
            return readResult.copy(str, str2, j2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: component2, reason: from getter */
        public final String getRaw() {
            return this.raw;
        }

        /* renamed from: component3, reason: from getter */
        public final long getCostUs() {
            return this.costUs;
        }

        public final ReadResult copy(String path, String raw, long costUs) {
            k.e(path, "path");
            return new ReadResult(path, raw, costUs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReadResult)) {
                return false;
            }
            ReadResult readResult = (ReadResult) other;
            return k.a(this.path, readResult.path) && k.a(this.raw, readResult.raw) && this.costUs == readResult.costUs;
        }

        public final long getCostUs() {
            return this.costUs;
        }

        public final boolean getOk() {
            return this.raw != null;
        }

        public final String getPath() {
            return this.path;
        }

        public final String getRaw() {
            return this.raw;
        }

        public int hashCode() {
            int iHashCode = this.path.hashCode() * 31;
            String str = this.raw;
            return Long.hashCode(this.costUs) + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
        }

        public String toString() {
            String str = this.path;
            String str2 = this.raw;
            long j2 = this.costUs;
            StringBuilder sbP = a1.a.p("ReadResult(path=", str, ", raw=", str2, ", costUs=");
            sbP.append(j2);
            sbP.append(")");
            return sbP.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/probe/SysfsProbe$SysfsEntry;", "", "path", "", "desc", "unit", "Lcom/stepos/probe/SysfsProbe$Unit;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/probe/SysfsProbe$Unit;)V", "getPath", "()Ljava/lang/String;", "getDesc", "getUnit", "()Lcom/stepos/probe/SysfsProbe$Unit;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class SysfsEntry {
        private final String desc;
        private final String path;
        private final Unit unit;

        public SysfsEntry(String str, String str2, Unit unit) {
            k.e(str, "path");
            k.e(str2, "desc");
            k.e(unit, "unit");
            this.path = str;
            this.desc = str2;
            this.unit = unit;
        }

        public static /* synthetic */ SysfsEntry copy$default(SysfsEntry sysfsEntry, String str, String str2, Unit unit, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sysfsEntry.path;
            }
            if ((i2 & 2) != 0) {
                str2 = sysfsEntry.desc;
            }
            if ((i2 & 4) != 0) {
                unit = sysfsEntry.unit;
            }
            return sysfsEntry.copy(str, str2, unit);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: component2, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        /* renamed from: component3, reason: from getter */
        public final Unit getUnit() {
            return this.unit;
        }

        public final SysfsEntry copy(String path, String desc, Unit unit) {
            k.e(path, "path");
            k.e(desc, "desc");
            k.e(unit, "unit");
            return new SysfsEntry(path, desc, unit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SysfsEntry)) {
                return false;
            }
            SysfsEntry sysfsEntry = (SysfsEntry) other;
            return k.a(this.path, sysfsEntry.path) && k.a(this.desc, sysfsEntry.desc) && this.unit == sysfsEntry.unit;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getPath() {
            return this.path;
        }

        public final Unit getUnit() {
            return this.unit;
        }

        public int hashCode() {
            return this.unit.hashCode() + x.g(this.desc, this.path.hashCode() * 31, 31);
        }

        public String toString() {
            String str = this.path;
            String str2 = this.desc;
            Unit unit = this.unit;
            StringBuilder sbP = a1.a.p("SysfsEntry(path=", str, ", desc=", str2, ", unit=");
            sbP.append(unit);
            sbP.append(")");
            return sbP.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/probe/SysfsProbe$Unit;", "", "<init>", "(Ljava/lang/String;I)V", "TEMP_TENTH", "MICRO_RAW", "KHZ", "RAW", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Unit {
        private static final /* synthetic */ j7.a $ENTRIES;
        private static final /* synthetic */ Unit[] $VALUES;
        public static final Unit TEMP_TENTH = new Unit("TEMP_TENTH", 0);
        public static final Unit MICRO_RAW = new Unit("MICRO_RAW", 1);
        public static final Unit KHZ = new Unit("KHZ", 2);
        public static final Unit RAW = new Unit("RAW", 3);

        private static final /* synthetic */ Unit[] $values() {
            return new Unit[]{TEMP_TENTH, MICRO_RAW, KHZ, RAW};
        }

        static {
            Unit[] unitArr$values = $values();
            $VALUES = unitArr$values;
            $ENTRIES = e0.s(unitArr$values);
        }

        private Unit(String str, int i2) {
        }

        public static j7.a getEntries() {
            return $ENTRIES;
        }

        public static Unit valueOf(String str) {
            return (Unit) Enum.valueOf(Unit.class, str);
        }

        public static Unit[] values() {
            return (Unit[]) $VALUES.clone();
        }
    }

    private SysfsProbe() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence diagnosePowerSupplyAccess$lambda$0(File file) {
        String name = file.getName();
        k.d(name, "getName(...)");
        return name;
    }

    private final String tryRead(String path) {
        try {
            return l.N(new File(path));
        } catch (Exception unused) {
            return null;
        }
    }

    public final String diagnosePowerSupplyAccess() throws ErrnoException {
        String strO0;
        String strO02;
        StringBuilder sb2 = new StringBuilder("=== File API ===\n");
        File file = new File("/sys/class/power_supply/");
        sb2.append("exists=" + file.exists());
        sb2.append('\n');
        sb2.append("isDirectory=" + file.isDirectory());
        sb2.append('\n');
        sb2.append("canRead=" + file.canRead());
        sb2.append('\n');
        sb2.append("canExecute=" + file.canExecute());
        sb2.append('\n');
        String[] list = file.list();
        String str = "null";
        if (list == null || (strO0 = n.o0(list, ",", null, null, null, 62)) == null) {
            strO0 = "null";
        }
        sb2.append("list()=".concat(strO0));
        sb2.append('\n');
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (strO02 = n.o0(fileArrListFiles, ",", null, null, new d(1), 30)) != null) {
            str = strO02;
        }
        sb2.append("listFiles()=".concat(str));
        sb2.append("\n\n=== Os.stat (raw syscall) ===\n");
        for (String str2 : s.u0("/sys/class/power_supply/", "/sys/class/power_supply/battery", "/sys/class/power_supply/battery/type", "/sys/class/power_supply/battery/uevent", "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq")) {
            try {
                StructStat structStatStat = Os.stat(str2);
                int i2 = structStatStat.st_mode;
                c.o(8);
                String string = Integer.toString(i2, 8);
                k.d(string, "toString(...)");
                sb2.append("OK " + str2 + " mode=" + string + " uid=" + structStatStat.st_uid + " gid=" + structStatStat.st_gid);
                sb2.append('\n');
            } catch (Exception e10) {
                String simpleName = e10.getClass().getSimpleName();
                String message = e10.getMessage();
                StringBuilder sbP = a1.a.p("FAIL ", str2, " ", simpleName, ": ");
                sbP.append(message);
                sb2.append(sbP.toString());
                sb2.append('\n');
            }
        }
        sb2.append("\n=== direct path (skip symlink) ===\n");
        for (String str3 : s.u0("/sys/devices/platform/soc/soc:pmic-glink/soc:pmic-glink:battery-charger/power_supply/battery/current_now", "/sys/devices/platform/soc/soc:pmic-glink/soc:pmic-glink:battery-charger/power_supply/battery/type")) {
            String strTryRead = INSTANCE.tryRead(str3);
            sb2.append(str3 + " → " + (strTryRead != null ? ga.k.L0(30, strTryRead) : "<null>"));
            sb2.append('\n');
        }
        sb2.append("\n=== process ===\n");
        sb2.append("myUid=" + Process.myUid() + " (system=1000)");
        sb2.append('\n');
        sb2.append("myPid=" + Process.myPid());
        sb2.append('\n');
        String string2 = sb2.toString();
        k.d(string2, "toString(...)");
        return string2;
    }

    public final List<SysfsEntry> discoverPowerSupplyEntries() {
        String[] list = new File("/sys/class/power_supply/").list();
        if (list == null) {
            return z.f2978f;
        }
        ArrayList arrayList = new ArrayList();
        Unit unit = Unit.TEMP_TENTH;
        p pVar = new p("temp", "温度 (×10 °C)", unit);
        Unit unit2 = Unit.MICRO_RAW;
        p pVar2 = new p("current_now", "瞬时电流 (μA)", unit2);
        p pVar3 = new p("voltage_now", "瞬时电压 (μV)", unit2);
        p pVar4 = new p("voltage_oc", "开路电压 (μV)", unit2);
        p pVar5 = new p("current_avg", "平均电流 (μA)", unit2);
        p pVar6 = new p("power_now", "瞬时功率 (μW)", unit2);
        p pVar7 = new p("power_avg", "平均功率 (μW)", unit2);
        p pVar8 = new p("charge_now", "累积电荷 (μAh, 单调)", unit2);
        p pVar9 = new p("charge_counter", "电荷计数 (μAh)", unit2);
        p pVar10 = new p("charge_full", "满电电荷 (μAh)", unit2);
        p pVar11 = new p("charge_full_design", "设计电荷 (μAh)", unit2);
        Unit unit3 = Unit.RAW;
        List<p> listU0 = s.u0(pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8, pVar9, pVar10, pVar11, new p("capacity", "电量百分比 (%)", unit3), new p("cycle_count", "循环次数", unit3), new p("temp", "电池温度 (×10 °C)", unit));
        String[] strArr = list;
        if (strArr.length != 0) {
            Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
            k.d(objArrCopyOf, "copyOf(...)");
            strArr = (Comparable[]) objArrCopyOf;
            if (strArr.length > 1) {
                Arrays.sort(strArr);
            }
        }
        for (String str : n.S(strArr)) {
            for (p pVar12 : listU0) {
                String str2 = (String) pVar12.f1982f;
                String str3 = (String) pVar12.f1983g;
                Unit unit4 = (Unit) pVar12.f1984h;
                String strK = a1.a.k("/sys/class/power_supply/", str, "/", str2);
                if (INSTANCE.tryRead(strK) != null) {
                    arrayList.add(new SysfsEntry(strK, x.l(str, "/", str2, " — ", str3), unit4));
                }
            }
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (hashSet.add(((SysfsEntry) next).getPath())) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public final List<Integer> enumerateCpuClusters() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 16; i2++) {
            if (new File(a1.a.f(i2, "/sys/devices/system/cpu/cpu", "/cpufreq")).isDirectory()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public final List<j> enumeratePowerSupplies() {
        String[] list = new File("/sys/class/power_supply/").list();
        if (list == null) {
            return z.f2978f;
        }
        String[] strArr = list;
        if (strArr.length != 0) {
            Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
            k.d(objArrCopyOf, "copyOf(...)");
            strArr = (Comparable[]) objArrCopyOf;
            if (strArr.length > 1) {
                Arrays.sort(strArr);
            }
        }
        List<String> listS = n.S(strArr);
        ArrayList arrayList = new ArrayList(t.A0(listS, 10));
        for (String str : listS) {
            String raw = INSTANCE.readRaw("/sys/class/power_supply/" + str + "/type");
            if (raw == null) {
                raw = "?";
            }
            arrayList.add(new j(str, raw));
        }
        return arrayList;
    }

    public final List<p> enumerateThermalZones() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 32; i2++) {
            String raw = readRaw("/sys/class/thermal/thermal_zone" + i2 + "/type");
            if (raw != null) {
                String raw2 = readRaw("/sys/class/thermal/thermal_zone" + i2 + "/temp");
                if (raw2 == null) {
                    raw2 = "?";
                }
                arrayList.add(new p(Integer.valueOf(i2), ga.k.N0(raw).toString(), ga.k.N0(raw2).toString()));
            }
        }
        return arrayList;
    }

    public final Integer findPidByPackage(String pkg) {
        k.e(pkg, "pkg");
        String[] list = new File("/proc").list();
        if (list == null) {
            return null;
        }
        for (String str : list) {
            k.b(str);
            Integer numI0 = r.i0(str);
            if (numI0 != null) {
                try {
                    String string = ga.k.N0(ga.k.I0(l.N(new File("/proc/" + numI0.intValue() + "/cmdline")), (char) 0)).toString();
                    if (k.a(string, pkg) || r.g0(string, pkg.concat(":"), false)) {
                        return numI0;
                    }
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public final List<ReadResult> probeMatrix() {
        ArrayList arrayList = new ArrayList();
        List<Integer> listEnumerateCpuClusters = enumerateCpuClusters();
        Iterator<T> it = listEnumerateCpuClusters.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            SysfsProbe sysfsProbe = INSTANCE;
            arrayList.add(sysfsProbe.readTimed("/sys/devices/system/cpu/cpu" + iIntValue + "/cpufreq/scaling_cur_freq"));
            arrayList.add(sysfsProbe.readTimed("/sys/devices/system/cpu/cpu" + iIntValue + "/cpufreq/stats/time_in_state"));
        }
        Integer num = (Integer) d7.r.P0(listEnumerateCpuClusters);
        if (num != null) {
            int iIntValue2 = num.intValue();
            for (int i2 = 0; i2 < 3; i2++) {
                SysfsProbe sysfsProbe2 = INSTANCE;
                arrayList.add(sysfsProbe2.readTimed("/sys/devices/system/cpu/cpu" + iIntValue2 + "/cpuidle/state" + i2 + "/name"));
                arrayList.add(sysfsProbe2.readTimed("/sys/devices/system/cpu/cpu" + iIntValue2 + "/cpuidle/state" + i2 + "/time"));
            }
        }
        String[] list = new File("/sys/class/devfreq/").list();
        List listW0 = list != null ? n.w0(list) : z.f2978f;
        if (listW0.isEmpty()) {
            arrayList.add(new ReadResult("/sys/class/devfreq/*", "<no devfreq nodes>", 0L));
        } else {
            for (String str : d7.r.i1(listW0)) {
                arrayList.add(INSTANCE.readTimed("/sys/class/devfreq/" + str + "/cur_freq"));
            }
        }
        Iterator it2 = s.u0("/proc/meminfo", "/proc/vmstat", "/proc/self/smaps_rollup", "/proc/self/stat", "/proc/net/dev", "/proc/diskstats").iterator();
        while (it2.hasNext()) {
            arrayList.add(INSTANCE.readTimed((String) it2.next()));
        }
        String[] list2 = new File("/sys/block/").list();
        if (list2 != null) {
            for (String str2 : d7.r.i1(n.w0(list2))) {
                arrayList.add(INSTANCE.readTimed("/sys/block/" + str2 + "/stat"));
            }
        }
        return arrayList;
    }

    public final long[] readCpuJiffies() {
        Object next;
        List listS;
        try {
            ga.d dVar = new ga.d(l.N(new File("/proc/stat")));
            while (true) {
                if (!dVar.hasNext()) {
                    next = null;
                    break;
                }
                next = dVar.next();
                if (r.g0((String) next, "cpu ", false)) {
                    break;
                }
            }
            String str = (String) next;
            if (str == null) {
                return null;
            }
            String string = ga.k.N0(str).toString();
            Pattern patternCompile = Pattern.compile("\\s+");
            k.d(patternCompile, "compile(...)");
            k.e(string, "input");
            ga.k.B0(0);
            Matcher matcher = patternCompile.matcher(string);
            if (matcher.find()) {
                ArrayList arrayList = new ArrayList(10);
                int iEnd = 0;
                do {
                    arrayList.add(string.subSequence(iEnd, matcher.start()).toString());
                    iEnd = matcher.end();
                } while (matcher.find());
                arrayList.add(string.subSequence(iEnd, string.length()).toString());
                listS = arrayList;
            } else {
                listS = a.a.S(string.toString());
            }
            List listK0 = d7.r.K0(listS, 1);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = listK0.iterator();
            while (it.hasNext()) {
                Long lJ0 = r.j0((String) it.next());
                if (lJ0 != null) {
                    arrayList2.add(lJ0);
                }
            }
            if (arrayList2.size() < 5) {
                return null;
            }
            long jLongValue = ((Number) arrayList2.get(4)).longValue() + ((Number) arrayList2.get(3)).longValue();
            Iterator it2 = arrayList2.iterator();
            long jLongValue2 = 0;
            while (it2.hasNext()) {
                jLongValue2 += ((Number) it2.next()).longValue();
            }
            return new long[]{jLongValue2 - jLongValue, jLongValue2};
        } catch (Exception unused) {
            return null;
        }
    }

    public final String readRaw(String path) {
        k.e(path, "path");
        try {
            return ga.k.N0(l.N(new File(path))).toString();
        } catch (Exception e10) {
            Log.w(TAG, "read fail: " + path + " — " + e10.getMessage());
            return null;
        }
    }

    public final ReadResult readTimed(String path) {
        k.e(path, "path");
        return new ReadResult(path, readRaw(path), (System.nanoTime() - System.nanoTime()) / 1000);
    }
}
