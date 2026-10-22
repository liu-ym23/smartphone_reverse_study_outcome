package androidx.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class PrintHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f2235a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f2236b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Context f2237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    BitmapFactory.Options f2238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Object f2239e;
    int f;

    private class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final a mCallback;
        private final int mFittingMode;
        private final String mJobName;
        final /* synthetic */ PrintHelper this$0;

        PrintBitmapAdapter(PrintHelper r3, String r4, int r5, Bitmap r6, a r7) {
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.mJobName = r4;
            this.mFittingMode = r5;
            this.mBitmap = r6;
            this.mCallback = r8;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes r1, PrintAttributes r2, CancellationSignal r3, PrintDocumentAdapter.LayoutResultCallback r4, Bundle r5) {
            this.mAttributes = r2;
            r4.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), true ^ r2.equals(r1));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r8, ParcelFileDescriptor r9, CancellationSignal r10, PrintDocumentAdapter.WriteResultCallback r11) {
            this.this$0.a(this.mAttributes, this.mFittingMode, this.mBitmap, r9, r10, r11);
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            a r0 = this.mCallback;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    private class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap;
        final a mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        final /* synthetic */ PrintHelper this$0;

        PrintUriAdapter(PrintHelper r3, String r4, Uri r5, a r6, int r7) {
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.mJobName = r4;
            this.mImageFile = r5;
            this.mCallback = r8;
            this.mFittingMode = r7;
            this.mBitmap = null;
        }

        /* JADX WARN: Type inference failed for: r11v3, types: [androidx.print.PrintHelper$PrintUriAdapter$1] */
        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes r7, final PrintAttributes r8, final CancellationSignal r9, final PrintDocumentAdapter.LayoutResultCallback r10, Bundle r11) {
            monitor-enter(this);
            this.mAttributes = r8;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r9.isCanceled() == false) goto L10;
            r10.onLayoutCancelled();
            return;
        L10:
            if (this.mBitmap == null) goto L13;
            r10.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), true ^ r8.equals(r7));
            return;
        L13:
            this.mLoadBitmap = new AnonymousClass1(this, r9, r8, r7, r10).execute(new Uri[0]);
            return;
        L15:
            th = move-exception;
            throw th;
        }

        void cancelLoad() {
            Object r0 = this.this$0.f2239e;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.f2238d != null) goto L7;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L7:
            if (Build.VERSION.SDK_INT >= 24) goto L9;
            this.this$0.f2238d.requestCancelDecode();     // Catch: Throwable -> L12
        L9:
            this.this$0.f2238d = null;     // Catch: Throwable -> L12
            goto L10
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> r0 = this.mLoadBitmap;
            if (r0 == null) goto L5;
            r0.cancel(true);
        L5:
            a r1 = this.mCallback;
            if (r1 == null) goto L8;
            r1.a();
        L8:
            Bitmap r2 = this.mBitmap;
            if (r2 == null) goto L12;
            r2.recycle();
            this.mBitmap = null;
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r8, ParcelFileDescriptor r9, CancellationSignal r10, PrintDocumentAdapter.WriteResultCallback r11) {
            this.this$0.a(this.mAttributes, this.mFittingMode, this.mBitmap, r9, r10, r11);
        }
    }

    public interface a {
        void a();
    }

    static {
        boolean r1 = false;
        if (Build.VERSION.SDK_INT >= 20) goto L5;
    L8:
        boolean r0 = true;
    L9:
        f2235a = r0;
        if (Build.VERSION.SDK_INT == 23) goto L12;
        r1 = true;
    L12:
        f2236b = r1;
        return;
    L5:
        if (Build.VERSION.SDK_INT > 23) goto L8;
        r0 = false;
        goto L9
    }

    static boolean a(Bitmap r1) {
        if (r1.getWidth() > r1.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    private static PrintAttributes.Builder a(PrintAttributes r3) {
        PrintAttributes.Builder r0 = new PrintAttributes.Builder().setMediaSize(r3.getMediaSize()).setResolution(r3.getResolution()).setMinMargins(r3.getMinMargins());
        if (r3.getColorMode() == 0) goto L6;
        r0.setColorMode(r3.getColorMode());
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
    L10:
        return r0;
    L8:
        if (r3.getDuplexMode() == 0) goto L10;
        r0.setDuplexMode(r3.getDuplexMode());
        goto L10
    }

    static Matrix a(int r3, int r4, RectF r5, int r6) {
        Matrix r0 = new Matrix();
        float r7 = r3;
        float r1 = r5.width() / r7;
        if (r6 != 2) goto L5;
        float r8 = Math.max(r1, r5.height() / r4);
    L6:
        r0.postScale(r8, r8);
        r0.postTranslate((r5.width() - (r7 * r8)) / 2.0f, (r5.height() - (r4 * r8)) / 2.0f);
        return r0;
    L5:
        r8 = Math.min(r1, r5.height() / r4);
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.print.PrintHelper$1] */
    void a(final PrintAttributes r12, final int r13, final Bitmap r14, final ParcelFileDescriptor r15, final CancellationSignal r16, final PrintDocumentAdapter.WriteResultCallback r17) {
        if (f2236b == false) goto L5;
        final PrintAttributes r5 = r12;
    L6:
        new AnonymousClass1(this, r16, r5, r14, r12, r13, r15, r17).execute(new Void[0]);
        return;
    L5:
        r5 = a(r12).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        goto L6
    }

    Bitmap a(Uri r8) {
        if (r8 == null) goto L44;
        if (this.f2237c == null) goto L44;
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        a(r8, r0);
        int r2 = r0.outWidth;
        int r1 = r0.outHeight;
        if (r2 <= 0) goto L42;
        if (r1 <= 0) goto L42;
        int r4 = Math.max(r2, r1);
        int r5 = 1;
    L11:
        if (r4 <= 3500) goto L13;
        r4 = r4 >>> 1;
        r5 = r5 << 1;
        goto L11
    L13:
        if (r5 <= 0) goto L42;
        if ((Math.min(r2, r1) / r5) <= 0) goto L42;
        Object r3 = this.f2239e;
        monitor-enter(r3);
        BitmapFactory.Options r6 = new BitmapFactory.Options();     // Catch: Throwable -> L39
        this.f2238d = r6;     // Catch: Throwable -> L39
        r6.inMutable = true;     // Catch: Throwable -> L39
        this.f2238d.inSampleSize = r5;     // Catch: Throwable -> L39
        BitmapFactory.Options r7 = this.f2238d;     // Catch: Throwable -> L39
        monitor-exit(r3);     // Catch: Throwable -> L39
        Bitmap r9 = a(r8, r7);     // Catch: Throwable -> L30
        Object r10 = this.f2239e;
        monitor-enter(r10);
        this.f2238d = null;     // Catch: Throwable -> L27
        monitor-exit(r10);     // Catch: Throwable -> L27
        return r9;
    L27:
        th = move-exception;
        throw th;
    L30:
        th = move-exception;
        monitor-enter(this.f2239e);
        this.f2238d = null;     // Catch: Throwable -> L36
        throw th;
    L36:
        th = move-exception;
        throw th;
    L39:
        th = move-exception;
        throw th;
    L42:
        return null;
    L44:
        throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }

    private Bitmap a(Uri r4, BitmapFactory.Options r5) {
        if (r4 == null) goto L25;
        Context r3 = this.f2237c;
        if (r3 == null) goto L25;
        InputStream r2 = null;
        InputStream r6 = r3.getContentResolver().openInputStream(r4);     // Catch: Throwable -> L17
        Bitmap r7 = BitmapFactory.decodeStream(r6, null, r5);     // Catch: Throwable -> L15
        if (r6 != null) goto L30;
    L14:
        return r7;
    L30:
        r6.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        a("PrintHelper", "close fail ", e);
    L15:
        th = th;
        r2 = r6;
    L18:
        if (r2 != null) goto L32;
    L23:
        throw th;
    L32:
        r2.close();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        a("PrintHelper", "close fail ", e);
    L17:
        th = th;
    L25:
        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    static Bitmap a(Bitmap r5, int r6) {
        if (r6 == 1) goto L5;
        return r5;
    L5:
        Bitmap r7 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r0 = new Canvas(r7);
        Paint r1 = new Paint();
        ColorMatrix r2 = new ColorMatrix();
        r2.setSaturation(0.0f);
        r1.setColorFilter(new ColorMatrixColorFilter(r2));
        r0.drawBitmap(r5, 0.0f, 0.0f, r1);
        r0.setBitmap(null);
        return r7;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
