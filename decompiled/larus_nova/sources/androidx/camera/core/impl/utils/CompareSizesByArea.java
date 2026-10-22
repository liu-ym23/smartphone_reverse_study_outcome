package androidx.camera.core.impl.utils;

import android.util.Size;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class CompareSizesByArea implements Comparator<Size> {
    private boolean mReverse;

    public CompareSizesByArea() {
        this(false);
    }

    public CompareSizesByArea(boolean r100) {
        this.mReverse = r100;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Size r100, Size r101) {
        int r102 = Long.signum((((long) r100.getWidth()) * ((long) r100.getHeight())) - (((long) r101.getWidth()) * ((long) r101.getHeight())));
        if (this.mReverse == true) goto L5;
        return r102;
    L5:
        return r102 * (-1);
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Size r100, Size r101) {
        return compare2(r100, r101);
    }
}
