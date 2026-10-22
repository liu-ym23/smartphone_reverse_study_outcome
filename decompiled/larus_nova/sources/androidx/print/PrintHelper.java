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
import android.print.PrintManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes17.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT = false;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION = false;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions;
    final Object mLock;
    int mOrientation;
    int mScaleMode;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    public class PrintBitmapAdapter extends PrintDocumentAdapter {
        private PrintAttributes mAttributes;
        private final Bitmap mBitmap;
        private final OnPrintFinishCallback mCallback;
        private final int mFittingMode;
        private final String mJobName;
        final /* synthetic */ PrintHelper this$0;

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            OnPrintFinishCallback r100 = this.mCallback;
            if (r100 == null) goto L6;
            r100.onFinish();
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r100, ParcelFileDescriptor r101, CancellationSignal r110, PrintDocumentAdapter.WriteResultCallback r111) {
            this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, r101, r110, r111);
        }

        public PrintBitmapAdapter(PrintHelper r100, String r101, int r102, Bitmap r103, OnPrintFinishCallback r104) {
            this.this$0 = r100;
            this.mJobName = r101;
            this.mFittingMode = r102;
            this.mBitmap = r103;
            this.mCallback = r104;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes r100, PrintAttributes r101, CancellationSignal r102, PrintDocumentAdapter.LayoutResultCallback r103, Bundle r104) {
            this.mAttributes = r101;
            r103.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !r101.equals(r100));
        }
    }

    public class PrintUriAdapter extends PrintDocumentAdapter {
        PrintAttributes mAttributes;
        Bitmap mBitmap;
        final OnPrintFinishCallback mCallback;
        final int mFittingMode;
        final Uri mImageFile;
        final String mJobName;
        AsyncTask<Uri, Boolean, Bitmap> mLoadBitmap;
        final /* synthetic */ PrintHelper this$0;

        public void cancelLoad() {
            Object r100 = this.this$0.mLock;
            monitor-enter(r100);
            BitmapFactory.Options r101 = this.this$0.mDecodeOptions;     // Catch: Throwable -> L12
            if (r101 != null) goto L7;
        L10:
            monitor-exit(r100);     // Catch: Throwable -> L12
            return;
        L7:
            if (Build.VERSION.SDK_INT >= 24) goto L9;
            r101.requestCancelDecode();     // Catch: Throwable -> L12
        L9:
            this.this$0.mDecodeOptions = null;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            cancelLoad();
            AsyncTask<Uri, Boolean, Bitmap> r100 = this.mLoadBitmap;
            if (r100 == null) goto L5;
            r100.cancel(true);
        L5:
            OnPrintFinishCallback r101 = this.mCallback;
            if (r101 == null) goto L8;
            r101.onFinish();
        L8:
            Bitmap r102 = this.mBitmap;
            if (r102 == null) goto L12;
            r102.recycle();
            this.mBitmap = null;
            return;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] r100, ParcelFileDescriptor r101, CancellationSignal r110, PrintDocumentAdapter.WriteResultCallback r111) {
            this.this$0.writeBitmap(this.mAttributes, this.mFittingMode, this.mBitmap, r101, r110, r111);
        }

        public PrintUriAdapter(PrintHelper r100, String r101, Uri r102, OnPrintFinishCallback r103, int r104) {
            this.this$0 = r100;
            this.mJobName = r101;
            this.mImageFile = r102;
            this.mCallback = r103;
            this.mFittingMode = r104;
            this.mBitmap = null;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(final PrintAttributes r100, final PrintAttributes r101, final CancellationSignal r102, final PrintDocumentAdapter.LayoutResultCallback r110, Bundle r111) {
            monitor-enter(this);
            this.mAttributes = r101;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r102.isCanceled() == false) goto L10;
            r110.onLayoutCancelled();
            return;
        L10:
            if (this.mBitmap == null) goto L13;
            r110.onLayoutFinished(new PrintDocumentInfo.Builder(this.mJobName).setContentType(1).setPageCount(1).build(), !r101.equals(r100));
            return;
        L13:
            this.mLoadBitmap = new AnonymousClass1(this, r102, r101, r100, r110).execute1(new Uri[0]);
            return;
        L15:
            th = move-exception;
            throw th;
        }
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    static {
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = false;
        if (r100 <= 23) goto L5;
        boolean r102 = true;
    L6:
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = r102;
        if (r100 == 23) goto L9;
        r101 = true;
    L9:
        IS_MIN_MARGINS_HANDLING_CORRECT = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public int getOrientation() {
        int r100 = this.mOrientation;
        if (r100 != 0) goto L6;
        return 1;
    L6:
        return r100;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    public PrintHelper(Context r100) {
        this.mDecodeOptions = null;
        this.mLock = new Object();
        this.mScaleMode = 2;
        this.mColorMode = 2;
        this.mOrientation = 1;
        this.mContext = r100;
    }

    private static PrintAttributes.Builder copyAttributes(PrintAttributes r100) {
        PrintAttributes.Builder r101 = new PrintAttributes.Builder().setMediaSize(r100.getMediaSize()).setResolution(r100.getResolution()).setMinMargins(r100.getMinMargins());
        if (r100.getColorMode() == 0) goto L6;
        r101.setColorMode(r100.getColorMode());
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
    L10:
        return r101;
    L8:
        if (r100.getDuplexMode() == 0) goto L10;
        r101.setDuplexMode(r100.getDuplexMode());
        goto L10
    }

    public static boolean isPortrait(Bitmap r100) {
        if (r100.getWidth() > r100.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    public Bitmap loadConstrainedBitmap(Uri r100) throws FileNotFoundException {
        if (r100 == null) goto L44;
        if (this.mContext == null) goto L44;
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        loadBitmap(r100, r101);
        int r102 = r101.outWidth;
        int r103 = r101.outHeight;
        if (r102 <= 0) goto L42;
        if (r103 <= 0) goto L42;
        int r104 = Math.max(r102, r103);
        int r105 = 1;
    L11:
        if (r104 <= 3500) goto L13;
        r104 = r104 >>> 1;
        r105 = r105 << 1;
        goto L11
    L13:
        if (r105 <= 0) goto L42;
        if ((Math.min(r102, r103) / r105) <= 0) goto L42;
        Object r106 = this.mLock;
        monitor-enter(r106);
        BitmapFactory.Options r107 = new BitmapFactory.Options();     // Catch: Throwable -> L39
        this.mDecodeOptions = r107;     // Catch: Throwable -> L39
        r107.inMutable = true;     // Catch: Throwable -> L39
        r107.inSampleSize = r105;     // Catch: Throwable -> L39
        monitor-exit(r106);     // Catch: Throwable -> L39
        Bitmap r108 = loadBitmap(r100, r107);     // Catch: Throwable -> L30
        Object r109 = this.mLock;
        monitor-enter(r109);
        this.mDecodeOptions = null;     // Catch: Throwable -> L27
        monitor-exit(r109);     // Catch: Throwable -> L27
        return r108;
    L27:
        th = move-exception;
        throw th;
    L30:
        th = move-exception;
        monitor-enter(this.mLock);
        this.mDecodeOptions = null;     // Catch: Throwable -> L36
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

    public void setColorMode(int r100) {
        this.mColorMode = r100;
    }

    public void setOrientation(int r100) {
        this.mOrientation = r100;
    }

    public void setScaleMode(int r100) {
        this.mScaleMode = r100;
    }

    public static Bitmap convertBitmapForColorMode(Bitmap r100, int r101) {
        if (r101 == 1) goto L5;
        return r100;
    L5:
        Bitmap r102 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r103 = new Canvas(r102);
        Paint r104 = new Paint();
        ColorMatrix r105 = new ColorMatrix();
        r105.setSaturation(0.0f);
        r104.setColorFilter(new ColorMatrixColorFilter(r105));
        r103.drawBitmap(r100, 0.0f, 0.0f, r104);
        r103.setBitmap(null);
        return r102;
    }

    private Bitmap loadBitmap(Uri r100, BitmapFactory.Options r101) throws FileNotFoundException {
        if (r100 == null) goto L18;
        Context r102 = this.mContext;
        if (r102 == null) goto L18;
        InputStream r103 = null;
        InputStream r104 = r102.getContentResolver().openInputStream(r100);     // Catch: Throwable -> L13
        Bitmap r105 = BitmapFactory.decodeStream(r104, null, r101);     // Catch: Throwable -> L11
        if (r104 != null) goto L21;
    L10:
        return r105;
    L21:
        r104.close();     // Catch: IOException -> L19
    L11:
        th = th;
        r103 = r104;
    L14:
        if (r103 != null) goto L23;
    L16:
        throw th;
    L23:
        r103.close();     // Catch: IOException -> L20
    L13:
        th = th;
    L18:
        throw new IllegalArgumentException("bad argument to loadBitmap");
    }

    public void printBitmap(String r100, Bitmap r101) {
        printBitmap(r100, r101, null);
    }

    public void printBitmap(String r100, Uri r101) throws FileNotFoundException {
        printBitmap(r100, r101, null);
    }

    public void printBitmap(String r100, Uri r101, OnPrintFinishCallback r110) throws FileNotFoundException {
        PrintUriAdapter r102 = new PrintUriAdapter(this, r100, r101, r110, this.mScaleMode);
        PrintManager r103 = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder r111 = new PrintAttributes.Builder();
        r111.setColorMode(this.mColorMode);
        int r104 = this.mOrientation;
        if (r104 == 1) goto L9;
        if (r104 == 0) goto L9;
        if (r104 != 2) goto L10;
        r111.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
    L10:
        r103.print(r100, r102, r111.build());
        return;
    L9:
        r111.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        goto L10
    }

    public void printBitmap(String r110, Bitmap r111, OnPrintFinishCallback r112) {
        if (r111 != null) goto L4;
        return;
    L4:
        PrintManager r100 = (PrintManager) this.mContext.getSystemService("print");
        if (isPortrait(r111) == false) goto L7;
        PrintAttributes.MediaSize r101 = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    L8:
        PrintAttributes r102 = new PrintAttributes.Builder().setMediaSize(r101).setColorMode(this.mColorMode).build();
        r100.print(r110, new PrintBitmapAdapter(this, r110, this.mScaleMode, r111, r112), r102);
        return;
    L7:
        r101 = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
        goto L8
    }

    public static Matrix getMatrix(int r100, int r101, RectF r102, int r103) {
        Matrix r104 = new Matrix();
        float r105 = r100;
        float r106 = r102.width() / r105;
        if (r103 != 2) goto L5;
        float r107 = Math.max(r106, r102.height() / r101);
    L6:
        r104.postScale(r107, r107);
        r104.postTranslate((r102.width() - (r105 * r107)) / 2.0f, (r102.height() - (r101 * r107)) / 2.0f);
        return r104;
    L5:
        r107 = Math.min(r106, r102.height() / r101);
        goto L6
    }

    public void writeBitmap(final PrintAttributes r110, final int r111, final Bitmap r112, final ParcelFileDescriptor r113, final CancellationSignal r114, final PrintDocumentAdapter.WriteResultCallback r115) {
        if (IS_MIN_MARGINS_HANDLING_CORRECT == false) goto L5;
        final PrintAttributes r100 = r110;
    L6:
        new AnonymousClass1(this, r114, r100, r112, r110, r111, r113, r115).execute1(new Void[0]);
        return;
    L5:
        r100 = copyAttributes(r110).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        goto L6
    }
}
