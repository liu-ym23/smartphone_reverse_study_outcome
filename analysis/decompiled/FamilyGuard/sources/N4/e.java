package N4;

import N4.c;
import android.os.Build;

/* loaded from: classes.dex */
final class e implements c.b {
    e() {
    }

    @Override // N4.c.b
    public String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !f.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // N4.c.b
    public void b(String str) {
        System.load(str);
    }

    @Override // N4.c.b
    public String c(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // N4.c.b
    public void d(String str) {
        System.loadLibrary(str);
    }

    @Override // N4.c.b
    public String e(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }
}
