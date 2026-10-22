package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LensFacingCameraFilter implements CameraFilter {
    private final int mLensFacing;

    @Override // androidx.camera.core.CameraFilter
    public final /* synthetic */ Identifier getIdentifier() {
        return CameraFilter.CC.$default$getIdentifier(this);
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }

    public LensFacingCameraFilter(int r100) {
        this.mLensFacing = r100;
    }

    @Override // androidx.camera.core.CameraFilter
    public List<CameraInfo> filter(List<CameraInfo> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<CameraInfo> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        CameraInfo r103 = r102.next();
        Preconditions.checkArgument(r103 instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
        if (r103.getLensFacing() != this.mLensFacing) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }
}
