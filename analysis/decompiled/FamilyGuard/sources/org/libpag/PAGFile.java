package org.libpag;

import android.content.res.AssetManager;

/* loaded from: classes.dex */
public class PAGFile extends PAGComposition {
    static {
        P4.a.a("pag");
        nativeInit();
    }

    private PAGFile(long j5) {
        super(j5);
    }

    public static PAGFile Load(String str) {
        return LoadFromPath(str);
    }

    private static native PAGFile LoadFromAssets(AssetManager assetManager, String str);

    private static native PAGFile LoadFromBytes(byte[] bArr, int i5);

    private static native PAGFile LoadFromPath(String str);

    public static native int MaxSupportedTagLevel();

    private static final native void nativeInit();

    public native PAGFile copyOriginal();

    public native int[] getEditableIndices(int i5);

    public native PAGLayer[] getLayersByEditableIndex(int i5, int i6);

    public native PAGText getTextData(int i5);

    public native void nativeReplaceImage(int i5, long j5);

    public native void nativeReplaceImageByName(String str, long j5);

    public native int numImages();

    public native int numTexts();

    public native int numVideos();

    public native String path();

    public void replaceImage(int i5, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImage(i5, 0L);
        } else {
            nativeReplaceImage(i5, pAGImage.nativeContext);
        }
    }

    public void replaceImageByName(String str, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImageByName(str, 0L);
        } else {
            nativeReplaceImageByName(str, pAGImage.nativeContext);
        }
    }

    public native void replaceText(int i5, PAGText pAGText);

    public native void setDuration(long j5);

    public native void setTimeStretchMode(int i5);

    public native int tagLevel();

    public native int timeStretchMode();

    public static PAGFile Load(byte[] bArr) {
        return LoadFromBytes(bArr, bArr.length);
    }

    public static PAGFile Load(AssetManager assetManager, String str) {
        return LoadFromAssets(assetManager, str);
    }
}
