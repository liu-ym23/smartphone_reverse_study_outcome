package com.bytedance.android.gamecp.business.gamedetail.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class MessageQueueUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f55621a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f55622b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f55623c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MessageQueueUtil f55624d = null;

    public MessageQueueUtil() {
    }

    static {
        f55624d = new MessageQueueUtil();
        f55621a = LazyKt.lazy(MessageQueueUtil$handler$2.INSTANCE);
        f55622b = LazyKt.lazy(MessageQueueUtil$postSyncBarrier$2.INSTANCE);
        f55623c = LazyKt.lazy(MessageQueueUtil$removeSyncBarrier$2.INSTANCE);
    }

    public static int b() {
        if (Build.VERSION.SDK_INT >= 23) goto L20;
    L18:
        return -1;
    L20:
        Method r100 = (Method) f55622b.getValue();     // Catch: Exception -> L17
        Object r101 = null;
        if (r100 == null) goto L8;
        Object r102 = r100.invoke(Looper.getMainLooper().getQueue(), new Object[]{0L});     // Catch: Exception -> L17
    L10:
        if ((r102 instanceof Integer) == false) goto L13;
        r101 = r102;
    L13:
        Integer r103 = (Integer) r101;     // Catch: Exception -> L17
        if (r103 == null) goto L18;
        return r103.intValue();
    L8:
        r102 = null;
    L17:
        LocalTestManager.a(new Class[]{uv.a.class});
        goto L18
    }

    public static void c(int r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return;
    L11:
        Method r101 = (Method) f55623c.getValue();     // Catch: Exception -> L9
        if (r101 == null) goto L14;
        r101.invoke(Looper.getMainLooper().getQueue(), new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        LocalTestManager.a(new Class[]{uv.a.class});
    }

    public final void a(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Message r101 = Message.obtain((Handler) f55621a.getValue(), new j(r100));
        r101.obj = this;
        r101.setAsynchronous(true);     // Catch: NoSuchMethodError -> L5
    L6:
        ((Handler) f55621a.getValue()).sendMessageDelayed(r101, 50);
        return;
    L5:
        LocalTestManager.a(new Class[]{uv.a.class});
        goto L6
    }
}
