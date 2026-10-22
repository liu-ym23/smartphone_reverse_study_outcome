package r1;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static Intent a(Message r10) {
        Object r11 = r10.obj;
        if (r10.what != 159) goto L26;
        List r12 = (List) i5.b.c(r11, "mActivityCallbacks");     // Catch: IllegalAccessException -> L14
        if (r12 == null) goto L27;
        int r13 = 0;
    L8:
        if (r13 >= r12.size()) goto L28;
        Object r14 = r12.get(r13);     // Catch: IllegalAccessException -> L14
        if (r14 == null) goto L16;
        Intent r15 = (Intent) i5.b.c(r14, "mIntent");     // Catch: IllegalAccessException -> L14
        if (r15 == null) goto L16;
        return r15;
    L16:
        r13 = r13 + 1;
        goto L8
    L28:
        return null;
    L27:
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L26:
        return null;
    }

    public static Intent b(Message r10) {
        int r11 = r10.what;
        if (r11 == 100) goto L16;
        if (r11 == 121) goto L14;
        if (r11 == 159) goto L16;
        switch(r11) {
            case 113: goto L12;
            case 114: goto L14;
            case 115: goto L14;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return d(r10);
    L14:
        return e(r10);
    L16:
        return a(r10);
    }

    public static Intent c() {
        MessageQueue r10 = (MessageQueue) i5.b.c(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L40
        monitor-enter(r10);     // Catch: Throwable -> L40
        Message r11 = (Message) i5.b.c(r10, "mMessages");     // Catch: Throwable -> L18
        if (r11 != null) goto L7;
    L20:
        Field r12 = i5.b.a(Message.class, "next");     // Catch: Throwable -> L18
        r12.setAccessible(true);     // Catch: Throwable -> L18
    L21:
        if (r11 == null) goto L36;
        r11 = (Message) i5.b.d(r12, r11);     // Catch: Throwable -> L18
        if (r11 == null) goto L21;
        if (r11.getTarget() != i5.a.f()) goto L21;
        if (i5.a.h(r11) == false) goto L21;
        int r13 = r11.what;     // Catch: Throwable -> L18
        if (r13 == 100) goto L32;
        if (r13 != 159) goto L21;
    L32:
        Intent r14 = b(r11);     // Catch: Throwable -> L18
        if (r14 == null) goto L21;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return r14;
    L36:
        monitor-exit(r10);     // Catch: Throwable -> L18
        return null;
    L7:
        if (r11.getTarget() != i5.a.f()) goto L20;
        if (i5.a.h(r11) == false) goto L20;
        int r15 = r11.what;     // Catch: Throwable -> L18
        if (r15 == 100) goto L14;
        if (r15 != 159) goto L20;
    L14:
        Intent r16 = b(r11);     // Catch: Throwable -> L18
        if (r16 == null) goto L20;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return r16;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Intent d(Message r10) {
        if (r10.what != 113) goto L5;
        String r11 = MemorySourceLinkType.INTENT;
    L7:
        if (r11.isEmpty() == true) goto L18;
        Object r12 = r10.obj;
        if (r12 == null) goto L19;
        return (Intent) i5.b.c(r12, r11);
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    L19:
        return null;
    L18:
        return null;
    L5:
        r11 = "";
        goto L7
    }

    public static Intent e(Message r10) {
        int r11 = r10.what;
        if (r11 != 114) goto L5;
    L11:
        String r12 = MemorySourceLinkType.INTENT;
    L13:
        if (r12.isEmpty() == true) goto L24;
        Object r13 = r10.obj;
        if (r13 == null) goto L25;
        return (Intent) i5.b.c(r13, r12);
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    L25:
        return null;
    L24:
        return null;
    L5:
        if (r11 == 121) goto L11;
        if (r11 != 115) goto L10;
        r12 = "args";
        goto L13
    L10:
        r12 = "";
        goto L13
    }
}
