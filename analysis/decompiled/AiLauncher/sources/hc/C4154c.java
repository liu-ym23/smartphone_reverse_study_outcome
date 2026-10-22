package hc;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: hc.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4154c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f32986a;

    static {
        HashMap<String, String> map = new HashMap<>();
        f32986a = map;
        map.put("x86", "x86");
        map.put("i386", "x86");
        map.put("i486", "x86");
        map.put("i586", "x86");
        map.put("i686", "x86");
        map.put("pentium", "x86");
        map.put("x86_64", "x86_64");
        map.put("amd64", "x86_64");
        map.put("em64t", "x86_64");
        map.put("universal", "x86_64");
        map.put("ia64", "ia64");
        map.put("ia64w", "ia64");
        map.put("ia64_32", "ia64_32");
        map.put("ia64n", "ia64_32");
        map.put("ppc", "ppc");
        map.put("power", "ppc");
        map.put("powerpc", "ppc");
        map.put("power_pc", "ppc");
        map.put("power_rs", "ppc");
        map.put("ppc64", "ppc64");
        map.put("power64", "ppc64");
        map.put("powerpc64", "ppc64");
        map.put("power_pc64", "ppc64");
        map.put("power_rs64", "ppc64");
        map.put("aarch64", "arm64");
    }

    public static String a() {
        String property = System.getProperty("os.arch");
        if (e()) {
            return "android-arm";
        }
        if (property.startsWith("arm")) {
            property = g();
        } else {
            String lowerCase = property.toLowerCase(Locale.US);
            HashMap<String, String> map = f32986a;
            if (map.containsKey(lowerCase)) {
                return map.get(lowerCase);
            }
        }
        return h(property);
    }

    public static String b() {
        try {
            Process processExec = Runtime.getRuntime().exec("uname -m");
            processExec.waitFor();
            InputStream inputStream = processExec.getInputStream();
            try {
                return f(inputStream);
            } finally {
                inputStream.close();
            }
        } catch (Throwable th) {
            System.err.println("Error while running uname -m: " + th.getMessage());
            return "unknown";
        }
    }

    public static String c() {
        return d() + "/" + a();
    }

    public static String d() {
        return i(System.getProperty("os.name"));
    }

    public static boolean e() {
        return System.getProperty("java.runtime.name", "").toLowerCase().contains(UxipConstants.f30662a);
    }

    public static String f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[32];
        while (true) {
            int i10 = inputStream.read(bArr, 0, 32);
            if (i10 < 0) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr, 0, i10);
        }
    }

    public static String g() {
        if (System.getProperty("os.name").contains("Linux")) {
            String strB = b();
            if (strB.startsWith("armv6")) {
                return "armv6";
            }
            if (strB.startsWith("armv7")) {
                return "armv7";
            }
            if (strB.startsWith("armv5")) {
                return "arm";
            }
            if (strB.equals("aarch64")) {
                return "arm64";
            }
            String property = System.getProperty("sun.arch.abi");
            if (property != null && property.startsWith("gnueabihf")) {
                return "armv7";
            }
        }
        return "arm";
    }

    public static String h(String str) {
        return str.replaceAll("\\W", "");
    }

    public static String i(String str) {
        return str.contains("Windows") ? "Windows" : (str.contains("Mac") || str.contains("Darwin")) ? "Mac" : str.contains("Linux") ? "Linux" : str.contains("AIX") ? "AIX" : str.replaceAll("\\W", "");
    }
}
