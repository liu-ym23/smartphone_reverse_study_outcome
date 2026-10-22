package org.tensorflow.lite.task.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class TaskJniUtils {
    private static final String TAG = "TaskJniUtils";

    public interface a {
        long a();
    }

    public interface b<T> {
        long a(int r1, long r2, long r4, T r6);
    }

    static {
    }

    private static native long createProtoBaseOptions(int r0, int r1);

    public static <T> long a(Context r2, b<T> r3, String r4, String r5, final T r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        final b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        final AssetFileDescriptor r9 = r7.getAssets().openFd(r5);
        long r10 = a(new AnonymousClass1(r8, r9, r6), r4);     // Catch: Throwable -> L7
        if (r9 == null) goto L6;
        r9.close();
    L6:
        return r10;
    L7:
        th = move-exception;
        if (r9 != null) goto L14;
    L13:
        throw th;
    L14:
        r9.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public static long a(a r2, String r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        a(r3);
        return r4.a();
    L5:
        e = move-exception;
        String r5 = "Error getting native address of native library: " + r3;
        a(TAG, r5, e);
        throw new IllegalStateException(r5, e);
    }

    public static void a(String r3) {
        System.loadLibrary(r3);     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        String r4 = "Error loading native library: " + r3;
        a(TAG, r4, e);
        throw new UnsatisfiedLinkError(r4);
    }

    public static long a(c r2, int r3) {
        int r0 = r2.a().a().a();
        if (r3 != (-1)) goto L6;
        r3 = r2.b();
    L6:
        return createProtoBaseOptions(r0, r3);
    }

    private TaskJniUtils() {
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
