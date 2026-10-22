package com.baidu.platform.comapi.bmsdk.style;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BmFrameResource extends BmDrawableResource {
    private BmFrameResource() {
        super(57, nativeCreate());
    }

    private void a(List<BmBitmapResource> list, int[] iArr, int i4) {
        if (list == null || list.size() == 0) {
            return;
        }
        long[] jArr = new long[list.size()];
        Iterator<BmBitmapResource> it = list.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            jArr[i5] = it.next().getNativeInstance();
            i5++;
        }
        nativeSetBitmapResources(this.nativeInstance, jArr, i5, iArr, iArr.length, i4);
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResources(long j4, long[] jArr, int i4, int[] iArr, int i5, int i6);

    private static native long nativeSetInterval(long j4, int i4, int i5);

    private static native boolean nativeSetResIds(long j4, int[] iArr, int i4, int[] iArr2, int i5, int i6);

    public BmFrameResource(List<BmBitmapResource> list, int i4, int i5) {
        super(57, nativeCreate());
        a(list, i4, i5);
    }

    public BmFrameResource(List<BmBitmapResource> list, int[] iArr, int i4) {
        super(57, nativeCreate());
        a(list, iArr, i4);
    }

    private void a(List<BmBitmapResource> list, int i4, int i5) {
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr[i6] = i4;
        }
        a(list, iArr, i5);
    }

    public void a(int i4, int i5) {
        if (i5 < 20 || i4 <= 0) {
            return;
        }
        nativeSetInterval(this.nativeInstance, i4, i5);
    }
}
