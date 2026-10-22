package com.bytedance.apm.launch;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.bytedance.monitor.util.ActivityThreadUtils;
import com.bytedance.monitor.util.FieldUtils;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LaunchSceneHelper {
    private static final String TAG = "LaunchSceneHelper";

    public LaunchSceneHelper() {
    }

    public static Intent getFirstComponentIntent() {
        MessageQueue r0 = (MessageQueue) FieldUtils.readField(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L31
        monitor-enter(r0);     // Catch: Throwable -> L31
        Message r1 = (Message) FieldUtils.readField(r0, "mMessages");     // Catch: Throwable -> L28
        if (r1 != null) goto L7;
    L14:
        Field r2 = FieldUtils.getField(Message.class, "next");     // Catch: Throwable -> L28
        r2.setAccessible(true);     // Catch: Throwable -> L28
    L15:
        if (r1 == null) goto L26;
        r1 = (Message) FieldUtils.readField(r2, r1);     // Catch: Throwable -> L28
        if (r1 == null) goto L15;
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L15;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L15;
        Intent r3 = getComponentIntent(r1);     // Catch: Throwable -> L28
        if (r3 == null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r3;
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return null;
    L7:
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L14;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L14;
        Intent r4 = getComponentIntent(r1);     // Catch: Throwable -> L28
        if (r4 == null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r4;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Intent getFirstActivityIntent() {
        MessageQueue r0 = (MessageQueue) FieldUtils.readField(Looper.getMainLooper(), "mQueue");     // Catch: Throwable -> L39
        monitor-enter(r0);     // Catch: Throwable -> L39
        Message r1 = (Message) FieldUtils.readField(r0, "mMessages");     // Catch: Throwable -> L36
        if (r1 != null) goto L7;
    L18:
        Field r4 = FieldUtils.getField(Message.class, "next");     // Catch: Throwable -> L36
        r4.setAccessible(true);     // Catch: Throwable -> L36
    L19:
        if (r1 == null) goto L34;
        r1 = (Message) FieldUtils.readField(r4, r1);     // Catch: Throwable -> L36
        if (r1 == null) goto L19;
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L19;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L19;
        int r5 = r1.what;     // Catch: Throwable -> L36
        if (r5 == 100) goto L30;
        if (r5 != 159) goto L19;
    L30:
        Intent r6 = getComponentIntent(r1);     // Catch: Throwable -> L36
        if (r6 == null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r6;
    L34:
        monitor-exit(r0);     // Catch: Throwable -> L36
        return null;
    L7:
        if (r1.getTarget() != ActivityThreadUtils.getHInActivityThread()) goto L18;
        if (ActivityThreadUtils.isMessageNeedInterrupt(r1) == false) goto L18;
        int r7 = r1.what;     // Catch: Throwable -> L36
        if (r7 == 100) goto L14;
        if (r7 != 159) goto L18;
    L14:
        Intent r8 = getComponentIntent(r1);     // Catch: Throwable -> L36
        if (r8 == null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L36
        return r8;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static Intent getComponentIntent(Message r2) {
        int r0 = r2.what;
        if (r0 == 100) goto L16;
        if (r0 == 121) goto L14;
        if (r0 == 159) goto L16;
        switch(r0) {
            case 113: goto L12;
            case 114: goto L14;
            case 115: goto L14;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return getReceiverComponentIntent(r2);
    L14:
        return getServiceComponentIntent(r2);
    L16:
        return getActivityComponentIntent(r2);
    }

    static Intent getActivityComponentIntent(Message r3) {
        Object r0 = r3.obj;
        if (r3.what != 159) goto L25;
        List r4 = (List) FieldUtils.readField(r0, "mActivityCallbacks");     // Catch: IllegalAccessException -> L15
        if (r4 == null) goto L26;
        int r1 = 0;
    L8:
        if (r1 >= r4.size()) goto L27;
        Object r2 = r4.get(r1);     // Catch: IllegalAccessException -> L15
        if (r2 == null) goto L14;
        Intent r5 = (Intent) FieldUtils.readField(r2, "mIntent");     // Catch: IllegalAccessException -> L15
        if (r5 == null) goto L14;
        return r5;
    L14:
        r1 = r1 + 1;
        goto L8
    L27:
        return null;
    L26:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L25:
        return null;
    }

    static Intent getServiceComponentIntent(Message r2) {
        if (r2.what != 114) goto L5;
    L11:
        String r0 = MemorySourceLinkType.INTENT;
    L13:
        if (r0.isEmpty() == false) goto L15;
        return null;
    L15:
        if (r2.obj == null) goto L25;
        return (Intent) FieldUtils.readField(r2.obj, r0);
    L18:
        th = move-exception;
        th.printStackTrace();
        return null;
    L25:
        return null;
    L5:
        if (r2.what == 121) goto L11;
        if (r2.what != 115) goto L10;
        r0 = "args";
        goto L13
    L10:
        r0 = "";
        goto L13
    }

    static Intent getReceiverComponentIntent(Message r2) {
        if (r2.what != 113) goto L5;
        String r0 = MemorySourceLinkType.INTENT;
    L7:
        if (r0.isEmpty() == false) goto L9;
        return null;
    L9:
        if (r2.obj == null) goto L19;
        return (Intent) FieldUtils.readField(r2.obj, r0);
    L12:
        th = move-exception;
        th.printStackTrace();
        return null;
    L19:
        return null;
    L5:
        r0 = "";
        goto L7
    }
}
