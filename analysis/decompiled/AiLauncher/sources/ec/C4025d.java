package ec;

import android.os.Build;
import ec.AbstractC4023b;

/* renamed from: ec.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4025d implements AbstractC4023b.InterfaceC0400b {
    @Override // ec.AbstractC4023b.InterfaceC0400b
    public String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // ec.AbstractC4023b.InterfaceC0400b
    public void b(String str) {
        System.load(str);
    }

    @Override // ec.AbstractC4023b.InterfaceC0400b
    public String c(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // ec.AbstractC4023b.InterfaceC0400b
    public void h(String str) {
        System.loadLibrary(str);
    }

    @Override // ec.AbstractC4023b.InterfaceC0400b
    public String[] a() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        if (!AbstractC4026e.a(str)) {
            return new String[]{Build.CPU_ABI, str};
        }
        return new String[]{Build.CPU_ABI};
    }
}
