package g5;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MessageQueue f19919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f19920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f19921c;

    static {
    }

    public static MessageQueue a() {
        if (f19919a != null) goto L11;
        if (Looper.getMainLooper() == null) goto L11;
        Looper r10 = Looper.getMainLooper();
        if (r10 != Looper.myLooper()) goto L9;
        f19919a = Looper.myQueue();
        goto L11
    L9:
        f19919a = r10.getQueue();
    L11:
        return f19919a;
    }

    public static Message b(MessageQueue r10) {
        Field r11 = f19920b;
        if (r11 != null) goto L12;
        Field r12 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");     // Catch: Exception -> L6
        f19920b = r12;     // Catch: Exception -> L6
        r12.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f19920b.get(r10);
    L6:
        return null;
    L12:
        return (Message) r11.get(r10);
    L9:
        return null;
    }

    public static Message c(Message r10) {
        Field r11 = f19921c;
        if (r11 != null) goto L12;
        Field r12 = Class.forName("android.os.Message").getDeclaredField("next");     // Catch: Exception -> L6
        f19921c = r12;     // Catch: Exception -> L6
        r12.setAccessible(true);     // Catch: Exception -> L6
        return (Message) f19921c.get(r10);
    L6:
        return null;
    L12:
        return (Message) r11.get(r10);
    L9:
        return null;
    }
}
