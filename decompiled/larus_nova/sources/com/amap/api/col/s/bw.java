package com.amap.api.col.s;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public final class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26354a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f26355b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f26356c = null;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f26354a = bs.c("SYmFja3Vwcw");
        f26355b = bs.c("SLmFkaXU");
        f26356c = bs.c("JIw");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_amap_api_col_s_bw_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static String a(Context r100) {
        StorageManager r101 = (StorageManager) r100.getSystemService("storage");
        Class r102 = INVOKESTATIC_com_amap_api_col_s_bw_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(bs.c("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));     // Catch: Throwable -> L11
        Method r103 = r101.getClass().getMethod(bs.c("FZ2V0Vm9sdW1lTGlzdA"), new Class[0]);     // Catch: Throwable -> L11
        Method r104 = r102.getMethod(bs.c("ZZ2V0UGF0aA"), new Class[0]);     // Catch: Throwable -> L11
        Method r105 = r102.getMethod(bs.c("AaXNSZW1vdmFibGUK"), new Class[0]);     // Catch: Throwable -> L11
        Object r106 = r103.invoke(r101, new Object[0]);     // Catch: Throwable -> L11
        int r107 = Array.getLength(r106);     // Catch: Throwable -> L11
        int r108 = 0;
    L4:
        if (r108 >= r107) goto L9;
        Object r109 = Array.get(r106, r108);     // Catch: Throwable -> L11
        String r110 = (String) r104.invoke(r109, new Object[0]);     // Catch: Throwable -> L11
        if (((Boolean) r105.invoke(r109, new Object[0])).booleanValue() == false) goto L7;
        r108 = r108 + 1;
        goto L4
    L7:
        return r110;
    L9:
        return null;
    L12:
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    private static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static synchronized void a(Context r100, String r101, String r102) {
        monitor-enter(bw.class);
        String r103 = a(r100);     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r103) == false) goto L8;
        monitor-exit(bw.class);
        return;
    L8:
        String r104 = r101 + f26356c + r102;     // Catch: Throwable -> L38
        PolarisFileWrapper r105 = new PolarisFileWrapper(r103 + File.separator + f26354a);     // Catch: Throwable -> L38
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105, f26355b);     // Catch: Throwable -> L38
        FileLock r107 = null;
    L28:
        FileChannel r108 = null;
        RandomAccessFile r109 = null;
    L29:
        if (r107 != null) goto L50;
    L33:
        if (r108 != null) goto L44;
    L35:
        a(r109);     // Catch: Throwable -> L38
        monitor-exit(bw.class);
        return;
    L44:
        r108.close();     // Catch: IOException -> L43 Throwable -> L38
        goto L35
    L50:
        r107.release();     // Catch: IOException -> L32 Throwable -> L38
        goto L33
    L11:
        if (r105.exists() == true) goto L13;
    L14:
        r105.mkdirs();     // Catch: Throwable -> L28
    L15:
        r106.createNewFile();     // Catch: Throwable -> L28
        r109 = new RandomAccessFile(r106, "rws");     // Catch: Throwable -> L28
        r108 = r109.getChannel();     // Catch: Throwable -> L27
        r107 = r108.tryLock();     // Catch: Throwable -> L26
        if (r107 == null) goto L20;
        r108.write(ByteBuffer.wrap(r104.getBytes("UTF-8")));     // Catch: Throwable -> L26
    L20:
        if (r107 != null) goto L57;
    L55:
        r108.close();     // Catch: IOException -> L42 Throwable -> L38
    L23:
        a(r109);     // Catch: Throwable -> L38
        monitor-exit(bw.class);
        return;
    L57:
        r107.release();     // Catch: IOException -> L41 Throwable -> L38
    L27:
        r108 = null;
        goto L29
    L13:
        if (r105.isDirectory() == false) goto L15;
    L38:
        th = move-exception;
        throw th;
    }
}
