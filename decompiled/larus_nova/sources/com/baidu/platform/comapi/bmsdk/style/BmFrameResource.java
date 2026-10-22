package com.baidu.platform.comapi.bmsdk.style;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BmFrameResource extends BmDrawableResource {
    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResources(long r100, long[] r101, int r102, int[] r103, int r104, int r105);

    private static native long nativeSetInterval(long r100, int r101, int r102);

    private static native boolean nativeSetResIds(long r100, int[] r101, int r102, int[] r103, int r104, int r105);

    private BmFrameResource() {
        super(57, nativeCreate());
    }

    public void a(int r100, int r101) {
        if (r101 < 20) goto L8;
        if (r100 <= 0) goto L9;
        nativeSetInterval(getNativeInstance(), r100, r101);
        return;
    L9:
        return;
    }

    public BmFrameResource(List<BmBitmapResource> r100, int r101, int r102) {
        super(57, nativeCreate());
        a(r100, r101, r102);
    }

    private void a(List<BmBitmapResource> r100, int[] r110, int r111) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L14;
        long[] r101 = new long[r100.size()];
        Iterator<BmBitmapResource> r102 = r100.iterator();
        int r103 = 0;
    L8:
        if (r102.hasNext() == false) goto L10;
        r101[r103] = r102.next().getNativeInstance();
        r103 = r103 + 1;
        goto L8
    L10:
        nativeSetBitmapResources(getNativeInstance(), r101, r103, r110, r110.length, r111);
        return;
    }

    public BmFrameResource(List<BmBitmapResource> r100, int[] r101, int r102) {
        super(57, nativeCreate());
        a(r100, r101, r102);
    }

    private void a(List<BmBitmapResource> r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L13;
        int r103 = r100.size();
        int[] r104 = new int[r103];
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L9;
        r104[r105] = r101;
        r105 = r105 + 1;
        goto L7
    L9:
        a(r100, r104, r102);
        return;
    }
}
