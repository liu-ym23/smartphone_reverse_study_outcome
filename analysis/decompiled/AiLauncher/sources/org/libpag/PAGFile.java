package org.libpag;

import android.content.res.AssetManager;
import android.text.TextUtils;
import gc.AbstractC4115a;

/* loaded from: classes5.dex */
public class PAGFile extends PAGComposition {

    public interface LoadListener {
        void onLoad(PAGFile pAGFile);
    }

    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    private PAGFile(long j10) {
        super(j10);
    }

    public static PAGFile Load(String str) throws Throwable {
        if (TextUtils.isEmpty(str) || !(str.startsWith("http://") || str.startsWith("https://"))) {
            return LoadFromPath(str);
        }
        byte[] bArrA = b.a(str);
        if (bArrA == null) {
            return null;
        }
        return LoadFromBytes(bArrA, bArrA.length, str);
    }

    public static void LoadAsync(final String str, final LoadListener loadListener) {
        NativeTask.Run(new Runnable() { // from class: org.libpag.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                PAGFile.a(str, loadListener);
            }
        });
    }

    private static native PAGFile LoadFromAssets(AssetManager assetManager, String str);

    private static native PAGFile LoadFromBytes(byte[] bArr, int i10, String str);

    private static native PAGFile LoadFromPath(String str);

    public static native int MaxSupportedTagLevel();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, LoadListener loadListener) throws Throwable {
        PAGFile pAGFileLoad = Load(str);
        if (loadListener != null) {
            loadListener.onLoad(pAGFileLoad);
        }
    }

    private static final native void nativeInit();

    public native PAGFile copyOriginal();

    public native int[] getEditableIndices(int i10);

    public native PAGLayer[] getLayersByEditableIndex(int i10, int i11);

    public native PAGText getTextData(int i10);

    public native void nativeReplaceImage(int i10, long j10);

    public native void nativeReplaceImageByName(String str, long j10);

    public native int numImages();

    public native int numTexts();

    public native int numVideos();

    public native String path();

    public void replaceImage(int i10, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImage(i10, 0L);
        } else {
            nativeReplaceImage(i10, pAGImage.nativeContext);
        }
    }

    public void replaceImageByName(String str, PAGImage pAGImage) {
        if (pAGImage == null) {
            nativeReplaceImageByName(str, 0L);
        } else {
            nativeReplaceImageByName(str, pAGImage.nativeContext);
        }
    }

    public native void replaceText(int i10, PAGText pAGText);

    public native void setDuration(long j10);

    public native void setTimeStretchMode(int i10);

    public native int tagLevel();

    public native int timeStretchMode();

    public static PAGFile Load(byte[] bArr) {
        return LoadFromBytes(bArr, bArr.length, "");
    }

    public static PAGFile Load(AssetManager assetManager, String str) {
        return LoadFromAssets(assetManager, str);
    }
}
