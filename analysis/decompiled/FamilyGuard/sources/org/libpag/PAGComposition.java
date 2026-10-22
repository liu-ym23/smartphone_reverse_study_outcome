package org.libpag;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class PAGComposition extends PAGLayer {
    static {
        P4.a.a("pag");
        nativeInit();
    }

    public PAGComposition(long j5) {
        super(j5);
    }

    public static native PAGComposition Make(int i5, int i6);

    private static native void nativeInit();

    public native void addLayer(PAGLayer pAGLayer);

    public native void addLayerAt(PAGLayer pAGLayer, int i5);

    public native ByteBuffer audioBytes();

    public native PAGMarker[] audioMarkers();

    public native long audioStartTime();

    public native boolean contains(PAGLayer pAGLayer);

    public native PAGLayer getLayerAt(int i5);

    public native int getLayerIndex(PAGLayer pAGLayer);

    public native PAGLayer[] getLayersByName(String str);

    public native PAGLayer[] getLayersUnderPoint(float f5, float f6);

    public native int height();

    public native int numChildren();

    public native void removeAllLayers();

    public native PAGLayer removeLayer(PAGLayer pAGLayer);

    public native PAGLayer removeLayerAt(int i5);

    public native void setContentSize(int i5, int i6);

    public native void setLayerIndex(PAGLayer pAGLayer, int i5);

    public native void swapLayer(PAGLayer pAGLayer, PAGLayer pAGLayer2);

    public native void swapLayerAt(int i5, int i6);

    public native int width();
}
