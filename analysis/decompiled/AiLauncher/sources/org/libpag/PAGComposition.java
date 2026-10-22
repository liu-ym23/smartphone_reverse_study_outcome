package org.libpag;

import gc.AbstractC4115a;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class PAGComposition extends PAGLayer {
    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    public PAGComposition(long j10) {
        super(j10);
    }

    public static native PAGComposition Make(int i10, int i11);

    private static native void nativeInit();

    public native void addLayer(PAGLayer pAGLayer);

    public native void addLayerAt(PAGLayer pAGLayer, int i10);

    public native ByteBuffer audioBytes();

    public native PAGMarker[] audioMarkers();

    public native long audioStartTime();

    public native boolean contains(PAGLayer pAGLayer);

    public native PAGLayer getLayerAt(int i10);

    public native int getLayerIndex(PAGLayer pAGLayer);

    public native PAGLayer[] getLayersByName(String str);

    public native PAGLayer[] getLayersUnderPoint(float f10, float f11);

    public native int height();

    public native int numChildren();

    public native void removeAllLayers();

    public native PAGLayer removeLayer(PAGLayer pAGLayer);

    public native PAGLayer removeLayerAt(int i10);

    public native void setContentSize(int i10, int i11);

    public native void setLayerIndex(PAGLayer pAGLayer, int i10);

    public native void swapLayer(PAGLayer pAGLayer, PAGLayer pAGLayer2);

    public native void swapLayerAt(int i10, int i11);

    public native int width();
}
