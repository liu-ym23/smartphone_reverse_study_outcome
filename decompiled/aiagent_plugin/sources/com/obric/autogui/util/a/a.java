package com.obric.autogui.util.a;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.app.ActivityCompat;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f.c;
import d.h.b.o;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: ImageSaveUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31494a = null;

    static {
        f31494a = new a();
    }

    public static /* synthetic */ void lambda$0G6r8W9SFJKYJYUkb1AAFxClO6c(String r0, Uri r1) {
        a(r0, r1);
    }

    private a() {
    }

    public final void a(Activity r3) {
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
        o.e(r2, "activity");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        if (androidx.core.content.a.b((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.aiagent.plugin"), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L9;
        ActivityCompat.requestPermissions(r2, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 101);
        return;
    }

    public final boolean a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        if (androidx.core.content.a.b(r1, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean a(a r1, Context r2, File r3, boolean r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = true;
    L6:
        return r1.a(r7, r3, r4);
    }

    public final boolean a(Context r9, File r10, boolean r11) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r10, "imageFile");
        ContentValues r12 = new ContentValues();
        r12.put("_display_name", r10.getName());
        a r1 = f31494a;
        String r2 = r10.getName();
        o.c(r2, "getName(...)");
        r12.put("mime_type", r1.a(r2));
        if (Build.VERSION.SDK_INT < 29) goto L5;
        r12.put("relative_path", Environment.DIRECTORY_DCIM);
    L5:
        ContentResolver r3 = r8.getContentResolver();
        Uri r13 = ZeusProviderTransform.insert(r3, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r12, "com.obric.aiagent.plugin");
        if (r13 != null) goto L39;
        return true;
    L39:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r3.openOutputStream(r13), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        OutputStream r5 = (OutputStream) ZeusTransformUtils.preCheckCast(r4, OutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (r5 == null) goto L26;
        Closeable r14 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r10), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        FileInputStream r0 = (FileInputStream) ZeusTransformUtils.preCheckCast(r14, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        byte[] r6 = new byte[4096];     // Catch: Throwable -> L21
    L13:
        int r7 = r0.read(r6);     // Catch: Throwable -> L21
        if (r7 == (-1)) goto L16;
        r5.write(r6, 0, r7);     // Catch: Throwable -> L21
        goto L13
    L16:
        x r15 = x.f38692a;     // Catch: Throwable -> L21
        c.a(r14, null);     // Catch: Throwable -> L29
        a r16 = f31494a;     // Catch: Throwable -> L29
        r16.a(r8, r13);     // Catch: Throwable -> L29
        if (r11 == false) goto L26;
        r16.b(r8, r13);     // Catch: Throwable -> L29
        goto L26
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        c.a(r14, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L26:
        x r17 = x.f38692a;     // Catch: Throwable -> L29
        c.a(r4, null);     // Catch: Exception -> L34
        return true;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        c.a(r4, th);     // Catch: Exception -> L34
        throw th;     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public final boolean a(Context r11, Bitmap r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        o.e(r12, "bitmap");
        File r0 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Screenshots");
        if (r0.exists() == false) goto L5;
    L8:
        File r4 = new File(r0, "Screenshot_" + new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US).format(Long.valueOf(System.currentTimeMillis())) + ".png");
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r4), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19 Exception -> L21
        FileOutputStream r6 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r2, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        r12.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream) ZeusTransformUtils.preCheckCast(r6, OutputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        r6.flush();     // Catch: Throwable -> L14
        x r1 = x.f38692a;     // Catch: Throwable -> L14
        c.a(r2, null);     // Catch: Throwable -> L19 Exception -> L21
        MediaScannerConnection.scanFile(r13, new String[]{r4.getAbsolutePath()}, new String[]{"image/png"}, $$Lambda$a$0G6r8W9SFJKYJYUkb1AAFxClO6c.INSTANCE);     // Catch: Throwable -> L19 Exception -> L21
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "Screenshot saved to: " + r4.getAbsolutePath());     // Catch: Throwable -> L19 Exception -> L21
        r12.recycle();
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        c.a(r2, th);     // Catch: Throwable -> L19 Exception -> L21
        throw th;     // Catch: Throwable -> L19 Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        r12.recycle();
        return false;
    L19:
        th = move-exception;
        r12.recycle();
        throw th;
    L5:
        if (r0.mkdirs() == true) goto L8;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "Failed to create screenshot directory");
        return false;
    }

    private static final void a(String r4, Uri r5) {
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(f31494a), "Scanned " + r4 + ", uri: " + r5);
    }

    private final String a(String r3) {
        if (d.o.o.c(r3, ".jpg", true) == false) goto L5;
        return "image/jpeg";
    L5:
        if (d.o.o.c(r3, ".jpeg", true) == false) goto L8;
        return "image/jpeg";
    L8:
        if (d.o.o.c(r3, ".png", true) == false) goto L11;
        return "image/png";
    L11:
        if (d.o.o.c(r3, ".gif", true) == false) goto L16;
        return "image/gif";
    L16:
        return "image/jpeg";
    }

    private final void a(Context r2, Uri r3) {
        MediaScannerConnection.scanFile((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), new String[]{String.valueOf(r3.getPath())}, null, null);
    }

    private final void b(Context r3, Uri r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Intent r5 = new Intent("android.intent.action.VIEW");
        r5.setDataAndType(r4, "image/*");
        r5.addFlags(268435456);
        r5.addFlags(1);
        ZeusTransformUtils.startActivity(r2, Intent.createChooser(r5, null), "com.obric.aiagent.plugin");
    }
}
