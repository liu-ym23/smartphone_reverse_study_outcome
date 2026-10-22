package com.bytedance.monitor.collector;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: LooperUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MessageQueue f8999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f9000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f9001c;

    static {
    }

    public static MessageQueue a() {
        if (f8999a != null) goto L17;
        if (Looper.getMainLooper() == null) goto L17;
        Looper r0 = Looper.getMainLooper();
        if (r0 != Looper.myLooper()) goto L10;
        f8999a = Looper.myQueue();
        goto L17
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        f8999a = r0.getQueue();
        goto L17
    L18:
        Field r1 = r0.getClass().getDeclaredField("mQueue");     // Catch: Throwable -> L14
        r1.setAccessible(true);     // Catch: Throwable -> L14
        f8999a = (MessageQueue) ZeusTransformUtils.preCheckCast(r1.get(r0), MessageQueue.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
    L17:
        return f8999a;
    }

    public static Message a(MessageQueue r4) {
        Field r0 = f9000b;
        if (r0 != null) goto L12;
        Field r1 = ZeusTransformUtils.forName("android.os.MessageQueue", "com.obric.aiagent.plugin").getDeclaredField("mMessages");     // Catch: Exception -> L6
        f9000b = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) ZeusTransformUtils.preCheckCast(f9000b.get(r4), Message.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    L12:
        return (Message) ZeusTransformUtils.preCheckCast(r0.get(r4), Message.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    public static Message a(Message r4) {
        Field r0 = f9001c;
        if (r0 != null) goto L12;
        Field r1 = ZeusTransformUtils.forName("android.os.Message", "com.obric.aiagent.plugin").getDeclaredField("next");     // Catch: Exception -> L6
        f9001c = r1;     // Catch: Exception -> L6
        r1.setAccessible(true);     // Catch: Exception -> L6
        return (Message) ZeusTransformUtils.preCheckCast(f9001c.get(r4), Message.class, "com.obric.aiagent.plugin");
    L6:
        return null;
    L12:
        return (Message) ZeusTransformUtils.preCheckCast(r0.get(r4), Message.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }
}
