package com.obric.olog.salvage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import fa.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import kc.b;

/* JADX INFO: loaded from: classes4.dex */
public class LogCompressionProvider extends ContentProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f12221c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f12222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f12223b;

    static {
        f12221c = Pattern.compile("^[a-zA-Z0-9_./-]+$");
    }

    public LogCompressionProvider() {
    }

    public static /* synthetic */ void a(LogCompressionProvider r10, String[] r11, Uri r12, MatrixCursor r13, CountDownLatch r14) {
        r10.c(r11, r12, r13, r14);
    }

    public final boolean b() {
        Context r10 = getContext();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.checkCallingOrSelfPermission("com.obric.olog.ACCESS_LOG_COMPRESSION_PROVIDER") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final /* synthetic */ void c(String[] r10, Uri r11, MatrixCursor r12, CountDownLatch r13) {
        Context r14 = getContext();     // Catch: Throwable -> L10 Exception -> L20
        if (r14 != null) goto L26;
        r13.countDown();
        return;
    L26:
        int r15 = a.f19548a;     // Catch: Throwable -> L10 Exception -> L12
        a.class.getMethod("syncFlush", null).invoke(null, null);     // Catch: Throwable -> L10 Exception -> L12
        Thread.sleep(1000);     // Catch: Throwable -> L10 Exception -> L12
    L28:
        int r16 = re.a.f23900a;     // Catch: Throwable -> L10 Exception -> L16
        re.a.class.getMethod("syncFlush", null).invoke(null, null);     // Catch: Throwable -> L10 Exception -> L16
        Thread.sleep(1000);     // Catch: Throwable -> L10 Exception -> L16
    L18:
        b.b(r14, r10, "ologs.zip");     // Catch: Throwable -> L10 Exception -> L20
        r12.addRow(new Object[]{Uri.withAppendedPath(r11, "zip_file").toString()});     // Catch: Throwable -> L10 Exception -> L20
    L19:
        r13.countDown();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10 Exception -> L20
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10 Exception -> L20
    L10:
        th = move-exception;
        r13.countDown();
        throw th;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        goto L19
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r10, String r11, String[] r12) {
        if (b() == true) goto L6;
        return 0;
    L6:
        if ("delete_zip".equals(r11) == false) goto L16;
        Context r13 = getContext();
        if (r13 != null) goto L10;
        return 0;
    L10:
        File r14 = new File(r13.getFilesDir(), "ologs.zip");
        if (r14.exists() == false) goto L16;
        if (r14.delete() == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r10) {
        return "application/zip";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        b();
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        HandlerThread r10 = new HandlerThread("LogCompressionThread", 10);
        this.f12222a = r10;
        r10.start();
        this.f12223b = new Handler(this.f12222a.getLooper());
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri r10, String r11) {
        if (b() == false) goto L15;
        Context r12 = getContext();
        if (r12 == null) goto L13;
        File r13 = new File(r12.getFilesDir(), "ologs.zip");
        if (r13.exists() == false) goto L11;
        return ParcelFileDescriptor.open(r13, 268435456);
    L11:
        throw new FileNotFoundException("ZIP file not found: " + r13.getAbsolutePath());
    L13:
        throw new FileNotFoundException("Context is null");
    L15:
        throw new SecurityException("Caller does not have the required permission");
    }

    @Override // android.content.ContentProvider
    public Cursor query(final Uri r10, String[] r11, String r12, final String[] r13, String r14) {
        if (b() == true) goto L5;
        return null;
    L5:
        if (r13 != null) goto L7;
    L15:
        return null;
    L7:
        if (r13.length == 0) goto L15;
        final MatrixCursor r15 = new MatrixCursor(new String[]{"zip_file_uri"});
        final CountDownLatch r16 = new CountDownLatch(1);
        this.f12223b.post(new kc.a(this, r13, r10, r15, r16));
        r16.await();     // Catch: InterruptedException -> L12
    L14:
        return r15;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // android.content.ContentProvider
    public void shutdown() {
        super.shutdown();
        this.f12222a.quitSafely();
    }

    @Override // android.content.ContentProvider
    public int update(Uri r10, ContentValues r11, String r12, String[] r13) {
        b();
        return 0;
    }
}
