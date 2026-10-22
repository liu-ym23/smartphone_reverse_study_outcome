package android.ss.com.vboost.h;

import android.ss.com.vboost.utils.LogUtil;
import android.ss.com.vboost.utils.RomUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.sva.sdk.data.SettingsDAO;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4635a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f4636b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4637a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4638b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4639c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4640d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f4641e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4642f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ a[] f4643g = null;

        static {
            a r100 = new a("UNINITED", 0, 0);
            f4637a = r100;
            a r101 = new a("QCOM", 1, 1);
            f4638b = r101;
            a r102 = new a("MTK", 2, 2);
            f4639c = r102;
            a r103 = new a("CHRY", 3, 3);
            f4640d = r103;
            a r104 = new a("SAMSUNG", 4, 4);
            f4641e = r104;
            a r105 = new a("UNKNOWN", 5, 5);
            f4642f = r105;
            f4643g = new a[]{r100, r101, r102, r103, r104, r105};
        }

        private a(String r100, int r101, int r102) {
            super(r100, r101);
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f4643g.clone();
        }
    }

    static {
        f4636b = a.f4637a;
    }

    public static int a() {
        int r100 = Runtime.getRuntime().availableProcessors();
        RandomAccessFile r101 = new RandomAccessFile("/sys/devices/system/cpu/possible", "r");     // Catch: Throwable -> L9 IOException -> L11
        String r102 = r101.readLine();     // Catch: Throwable -> L9 IOException -> L11
        r101.close();     // Catch: Throwable -> L9 IOException -> L11
        if (r102 == null) goto L13;
        String[] r103 = r102.split("-");     // Catch: Throwable -> L9 IOException -> L11
        if (r103.length != 2) goto L13;
        r100 = CastIntegerProtector.parseInt(r103[1]) + 1;
    L13:
        if (r100 > 0) goto L18;
        return 8;
    L18:
        return r100;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static int a(int r100) {
        return a("/sys/devices/system/cpu/cpu" + r100 + "/cpufreq/cpuinfo_max_freq");
    }

    private static int a(String r100) {
        if (r100 != null) goto L11;
    L9:
        return -1;
    L11:
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L5 IOException -> L7
        String r102 = r101.readLine();     // Catch: Throwable -> L5 IOException -> L7
        r101.close();     // Catch: Throwable -> L5 IOException -> L7
        return CastIntegerProtector.parseInt(r102);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static a b() {
        if (f4636b != a.f4637a) goto L5;
        String r100 = RomUtils.getSystemProperty(SettingsDAO.HARDWARE);
        if (r100 != null) goto L10;
    L8:
        a r101 = a.f4642f;
    L34:
        f4636b = r101;
        LogUtil.debug(f4635a, "hardware platform type: " + r101);
        return r101;
    L10:
        if (r100.startsWith("qcom") == false) goto L12;
    L33:
        r101 = a.f4638b;
        goto L34
    L12:
        if (r100.startsWith("msm") == true) goto L33;
        if (r100.startsWith("qsc") == true) goto L33;
        if (r100.startsWith("sdm") == true) goto L33;
        if (r100.startsWith("mt") == false) goto L22;
        r101 = a.f4639c;
        goto L34
    L22:
        if (r100.startsWith("kirin") == false) goto L24;
    L32:
        r101 = a.f4640d;
        goto L34
    L24:
        if (r100.startsWith("hi") == true) goto L32;
        String r102 = RomUtils.getSystemProperty("ro.hardware.egl");
        if (r102 != null) goto L29;
    L31:
        LogUtil.warn(f4635a, "Unknown hardware platform!");
        goto L8
    L29:
        if (r102.toLowerCase().equals("adreno") == false) goto L31;
    L5:
        return f4636b;
    }

    public static int c() {
        File[] r100 = new File("/sys/devices/system/cpu/cpufreq").listFiles();
        int r101 = 2;
        if (r100 != null) goto L5;
    L15:
        LogUtil.debug(f4635a, "number of cluster:" + r101);
        return r101;
    L5:
        if (r100.length <= 0) goto L15;
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r102) goto L12;
        if (r100[r103].getName().startsWith("policy") == false) goto L11;
        r104 = r104 + 1;
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        if (r104 == 0) goto L15;
        r101 = r104;
        goto L15
    }
}
