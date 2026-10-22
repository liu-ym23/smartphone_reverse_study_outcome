package com.bef.effectsdk.algorithm;

import android.graphics.Bitmap;
import com.bef.effectsdk.ResourceFinder;

/* JADX INFO: loaded from: classes39.dex */
public class RectDocDet {
    public static final int RectDocDetAngleThr = 3;
    public static final int RectDocDetIsVideoMode = 2;
    public static final int RectDocDetIsVideoTypeNo = 2;
    public static final int RectDocDetIsVideoTypeYes = 1;
    public static final int RectDocDetPreProcessMode = 1;
    public static final int RectDocDetPreprocessTypeCenterCut = 2;
    public static final int RectDocDetPreprocessTypeNN = 1;
    private ResourceFinder mFinder;
    private long mFinderHandle;
    private long mNativeHandle;

    public RectDocDet() {
    }

    private native long nativeCreate();

    private native int nativeDestroy(long r100);

    private native int nativeInit(long r100, long r101, int r102);

    private native int nativeInitWithPath(long r100, String r101, int r102);

    private native RectDocDetResult nativeProcess(long r100, Bitmap r101, int r102);

    private native int nativeSetParamF(long r100, int r101, float r102);

    private boolean isFinderHandleValid() {
        if (0 == this.mFinderHandle) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isNativeHandleValid() {
        if (0 == this.mNativeHandle) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean create() {
        this.mNativeHandle = nativeCreate();
        return isNativeHandleValid();
    }

    public void destroy() {
        if (isNativeHandleValid() == false) goto L6;
        nativeDestroy(this.mNativeHandle);
        this.mNativeHandle = 0;
    L6:
        if (this.mFinder != null) goto L8;
        return;
    L8:
        if (isFinderHandleValid() == false) goto L12;
        this.mFinder.release(this.mFinderHandle);
        this.mFinderHandle = 0;
        return;
    }

    public boolean init(ResourceFinder r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (isNativeHandleValid() == false) goto L17;
        this.mFinder = r100;
        this.mFinderHandle = r100.createNativeResourceFinder(this.mNativeHandle);
        if (isFinderHandleValid() == true) goto L12;
        destroy();
        return false;
    L12:
        if (nativeInit(this.mNativeHandle, this.mFinderHandle, r101) != 0) goto L16;
        return true;
    L16:
        return false;
    L17:
        return false;
    }

    public boolean initWithPath(String r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() != 0) goto L7;
        return false;
    L7:
        if (isNativeHandleValid() == true) goto L10;
        return false;
    L10:
        if (nativeInitWithPath(this.mNativeHandle, r100, r101) != 0) goto L15;
        return true;
    L15:
        return false;
    }

    public RectDocDetResult process(Bitmap r100, int r101) {
        if (isNativeHandleValid() == false) goto L9;
        if (r100 == null) goto L9;
        return nativeProcess(this.mNativeHandle, r100, r101);
    L9:
        return new RectDocDetResult();
    }

    public boolean setParamF(int r100, float r101) {
        if (isNativeHandleValid() == true) goto L6;
        return false;
    L6:
        if (nativeSetParamF(this.mNativeHandle, r100, r101) != 0) goto L9;
        return true;
    L9:
        return false;
    }
}
