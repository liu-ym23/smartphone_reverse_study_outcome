package androidx.camera.view.transform;

import android.content.ContentResolver;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class FileTransformFactory {
    private boolean mUsingExifOrientation;

    public FileTransformFactory() {
    }

    public boolean isUsingExifOrientation() {
        return this.mUsingExifOrientation;
    }

    public OutputTransform getOutputTransform(InputStream r100) throws IOException {
        Exif r101 = Exif.createFromInputStream(r100);
        Rect r102 = new Rect(0, 0, r101.getWidth(), r101.getHeight());
        Matrix r103 = TransformUtils.getNormalizedToBuffer(r102);
        if (this.mUsingExifOrientation == false) goto L6;
        r103.postConcat(TransformUtils.getExifTransform(r101.getOrientation(), r101.getWidth(), r101.getHeight()));
    L6:
        return new OutputTransform(r103, TransformUtils.rectToSize(r102));
    }

    public void setUsingExifOrientation(boolean r100) {
        this.mUsingExifOrientation = r100;
    }

    public OutputTransform getOutputTransform(File r100) throws IOException {
        FileInputStream r101 = new FileInputStream(r100);
        OutputTransform r102 = getOutputTransform(r101);     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public OutputTransform getOutputTransform(ContentResolver r100, Uri r101) throws IOException {
        InputStream r102 = r100.openInputStream(r101);
        OutputTransform r103 = getOutputTransform(r102);     // Catch: Throwable -> L7
        if (r102 == null) goto L6;
        r102.close();
    L6:
        return r103;
    L7:
        th = move-exception;
        if (r102 != null) goto L14;
    L13:
        throw th;
    L14:
        r102.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
