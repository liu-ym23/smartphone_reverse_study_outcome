package bv3;

import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static long a() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L8
        String r101 = r100.readLine();     // Catch: Throwable -> L14
        r100.close();     // Catch: Throwable -> L14
        String[] r102 = r101.split(" ");     // Catch: Throwable -> L14
        long r103 = Long.parseLong(r102[13]) + Long.parseLong(r102[14]);
        r100.close();     // Catch: Throwable -> L13
    L7:
        return r103;
    L9:
        if (r100 == null) goto L24;
        r100.close();     // Catch: Throwable -> L15
        return -1;
    L25:
        return -1;
    L24:
        return -1;
    L8:
        r100 = null;
        goto L9
    }
}
