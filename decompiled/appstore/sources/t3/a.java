package t3;

import android.os.Process;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import r3.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    static {
    }

    public static long a() {
        BufferedReader r10 = null;
        BufferedReader r11 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10
        String r12 = r11.readLine();     // Catch: Throwable -> L7
        r11.close();     // Catch: Throwable -> L7
        String[] r13 = r12.split(" ");     // Catch: Throwable -> L7
        long r14 = Long.parseLong(r13[13]) + Long.parseLong(r13[14]);
        d.b(r11);
        return r14;
    L7:
        r10 = r11;
    L8:
        d.b(r10);
        return -1;
    }
}
