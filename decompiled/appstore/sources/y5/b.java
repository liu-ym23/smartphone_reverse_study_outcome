package y5;

import android.os.IBinder;
import com.bytedance.platform.godzilla.common.Logger;
import d6.d;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class b extends w5.c {

    public static final class a extends w5.b {
        public a() {
        }

        @Override // w5.b
        public Object a(Object r10, Method r11, Object[] r12, Object r13) {
            StackTraceElement[] r14 = Thread.currentThread().getStackTrace();
            int r15 = r14.length;
            int r16 = 0;
        L3:
            if (r16 >= r15) goto L10;
            if (r14[r16].getMethodName().contains("getSharedPreferences") == true) goto L6;
            r16 = r16 + 1;
            goto L3
        L6:
            Logger.a("IMountServiceProxy", "IsUserKeyUnlocked method is called，hint getSharedPreferences，return true。");
            return Boolean.TRUE;
        L10:
            return super.a(r10, r11, r12, r13);
        }

        @Override // w5.b
        public Object b(Object r10, Method r11, Object[] r12) {
            Logger.a("IMountServiceProxy", "IsUserKeyUnlocked method is called.");
            return null;
        }
    }

    static {
        w5.c.c("isUserKeyUnlocked", new a());
    }

    public b() {
    }

    public void i() {
        y5.a r10 = new y5.a("mount", this);
        r10.i();
        h(d.a(Class.forName("android.os.storage.IStorageManager$Stub"), "asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r10.e()}));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.c("IMountServiceProxy", "Hook proxy MountService Failed!!!");
        e.printStackTrace();
    }
}
