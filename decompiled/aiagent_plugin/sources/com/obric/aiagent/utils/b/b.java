package com.obric.aiagent.utils.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: LocalMediaMetadataExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22315a = null;

    /* JADX INFO: compiled from: LocalMediaMetadataExtractor.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f22316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f22317b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f22316a, r6.f22316a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f22317b, r6.f22317b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f22316a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.f22317b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "LocalVideoSize(width=" + this.f22316a + ", height=" + this.f22317b + ')';
        }

        public a(Integer r1, Integer r2) {
            this.f22316a = r1;
            this.f22317b = r2;
        }

        public final Integer a() {
            return this.f22316a;
        }

        public final Integer b() {
            return this.f22317b;
        }
    }

    static {
        f22315a = new b();
    }

    private b() {
    }

    public final com.obric.aiagent.utils.b.a a(File r3) {
        o.e(r3, "file");
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r3.getAbsolutePath(), r0);
        int r1 = r0.outWidth;
        int r2 = r0.outHeight;
        if (r1 <= 0) goto L11;
        if (r2 > 0) goto L7;
        return null;
    L7:
        if (b(r3) == false) goto L10;
        return new com.obric.aiagent.utils.b.a(r2, r1);
    L10:
        return new com.obric.aiagent.utils.b.a(r1, r2);
    L11:
        return null;
    }

    public final e a(File r5, File r6, c r7) {
        o.e(r5, "videoFile");
        o.e(r7, "coverFormat");
        MediaMetadataRetriever r0 = new MediaMetadataRetriever();
        r0.setDataSource(r5.getAbsolutePath());     // Catch: Throwable -> L31
        Integer r8 = a(r0.extractMetadata(18));     // Catch: Throwable -> L31
        Integer r1 = a(r0.extractMetadata(19));     // Catch: Throwable -> L31
        Long r2 = b(r0.extractMetadata(9));     // Catch: Throwable -> L31
        String r3 = r0.extractMetadata(24);     // Catch: Throwable -> L31
        if (r3 == null) goto L8;
        Integer r4 = d.o.o.d(r3);     // Catch: Throwable -> L31
        if (r4 == null) goto L8;
        int r9 = r4.intValue();     // Catch: Throwable -> L31
    L9:
        a r10 = a(r8, r1, r9);     // Catch: Throwable -> L31
        e r11 = null;
        if (r6 == null) goto L20;
        b r12 = f22315a;     // Catch: Throwable -> L31
        n.a r13 = n.f38560a;     // Catch: Throwable -> L14
        Object r14 = n.f(r12.a(r0, r6, r7));     // Catch: Throwable -> L14
    L17:
        if (n.b(r14) == false) goto L19;
        r14 = null;
    L19:
        d r15 = (d) ZeusTransformUtils.preCheckCast(r14, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
    L22:
        if (r10.a() == null) goto L24;
    L28:
        r11 = new e(r10.a(), r10.b(), r2, r15);     // Catch: Throwable -> L31
    L29:
        r0.release();
        return r11;
    L24:
        if (r10.b() != null) goto L28;
        if (r2 != null) goto L28;
        if (r15 != null) goto L28;
    L14:
        th = move-exception;
        n.a r16 = n.f38560a;     // Catch: Throwable -> L31
        r14 = n.f(d.o.a(th));     // Catch: Throwable -> L31
        goto L17
    L20:
        r15 = null;
    L8:
        r9 = 0;
    L31:
        th = move-exception;
        r0.release();
        throw th;
    }

    private final boolean b(File r4) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = n.f(Integer.valueOf(new androidx.exifinterface.media.a(r4.getAbsolutePath()).a("Orientation", 0)));     // Catch: Throwable -> L5
    L8:
        if (n.b(r5) == false) goto L10;
        r5 = 0;
    L10:
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r6 != 6) goto L13;
    L14:
        return true;
    L13:
        if (r6 == 8) goto L14;
        return false;
    L5:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L8
    }

    private final a a(Integer r1, Integer r2, int r3) {
        if (r3 != 90) goto L5;
    L6:
        if (r1 == null) goto L10;
        if (r2 == null) goto L10;
        return new a(r2, r1);
    L10:
        return new a(r1, r2);
    L5:
        if (r3 != 270) goto L10;
        goto L6
    }

    private final d a(MediaMetadataRetriever r7, File r8, c r9) {
        Bitmap r10 = r7.getFrameAtTime(0);
        if (r10 != null) goto L27;
        return null;
    L27:
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r8), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        FileOutputStream r2 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r1, FileOutputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r10.compress(r9.a(), r9.c(), (OutputStream) ZeusTransformUtils.preCheckCast(r2, OutputStream.class, "com.obric.aiagent.plugin")) == true) goto L11;
        d.f.c.a(r1, null);     // Catch: Throwable -> L20
        r10.recycle();
        return null;
    L11:
        x r6 = x.f38692a;     // Catch: Throwable -> L15
        d.f.c.a(r1, null);     // Catch: Throwable -> L20
        d r11 = new d(r8, r9.b(), r10.getWidth(), r10.getHeight());     // Catch: Throwable -> L20
        r10.recycle();
        return r11;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.f.c.a(r1, th);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    private final Integer a(String r3) {
        if (r3 == null) goto L13;
        Integer r4 = d.o.o.d(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return null;
    L12:
        return r4;
    L9:
        r0 = false;
        goto L10
    L13:
        return null;
    }

    private final Long b(String r5) {
        if (r5 == null) goto L13;
        Long r6 = d.o.o.e(r5);
        if (r6 != null) goto L7;
        return null;
    L7:
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
        return null;
    L12:
        return r6;
    L9:
        r0 = false;
        goto L10
    L13:
        return null;
    }
}
