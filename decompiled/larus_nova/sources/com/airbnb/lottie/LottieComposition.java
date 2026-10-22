package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LottieComposition {
    private Rect bounds;
    private SparseArrayCompat<m0.d> characters;
    private float endFrame;
    public String errorReportResId;
    private Map<String, m0.c> fonts;
    private float frameRate;
    private Map<String, h> images;
    private boolean isBitmapReady;
    private LongSparseArray<Layer> layerMap;
    private List<Layer> layers;
    private boolean needPolyfill;

    /* JADX INFO: renamed from: nm, reason: collision with root package name */
    private String f24690nm;
    private final n performanceTracker;
    private Map<String, List<Layer>> precomps;
    private float startFrame;
    private final HashSet<String> warnings;

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> r100 = this.warnings;
        return new ArrayList(Arrays.asList(r100.toArray(new String[r100.size()])));
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> r101 = this.layers.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(r101.next().a("\t"));
        goto L4
    L7:
        return r100.toString();
    }

    public LottieComposition() {
        this.performanceTracker = new n();
        this.warnings = new HashSet();
        this.errorReportResId = "";
    }

    public float getDuration() {
        return (long) ((getDurationFrames() / this.frameRate) * 1000.0f);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public SparseArrayCompat<m0.d> getCharacters() {
        return this.characters;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public Map<String, m0.c> getFonts() {
        return this.fonts;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public Map<String, h> getImages() {
        return this.images;
    }

    public List<Layer> getLayers() {
        return this.layers;
    }

    public String getNM() {
        return this.f24690nm;
    }

    public n getPerformanceTracker() {
        return this.performanceTracker;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public boolean isBitmapReady() {
        return this.isBitmapReady;
    }

    public boolean isNeedPolyfill() {
        return this.needPolyfill;
    }

    public void addWarning(String r100) {
        this.warnings.add(r100);
    }

    public List<Layer> getPrecomps(String r100) {
        return this.precomps.get(r100);
    }

    public Layer layerModelForId(long r100) {
        return this.layerMap.get(r100);
    }

    public void setBitmapReady(boolean r100) {
        this.isBitmapReady = r100;
    }

    public void setNM(String r100) {
        this.f24690nm = r100;
    }

    public void setNeedPolyfill(boolean r100) {
        this.needPolyfill = r100;
    }

    public void setPerformanceTrackingEnabled(boolean r100) {
        this.performanceTracker.f24917b = r100;
    }

    public void init(Rect r100, float r101, float r102, float r103, List<Layer> r104, LongSparseArray<Layer> r105, Map<String, List<Layer>> r106, Map<String, h> r107, SparseArrayCompat<m0.d> r108, Map<String, m0.c> r110) {
        this.bounds = r100;
        this.startFrame = r101;
        this.endFrame = r102;
        this.frameRate = r103;
        this.layers = r104;
        this.layerMap = r105;
        this.precomps = r106;
        this.images = r107;
        this.characters = r108;
        this.fonts = r110;
    }
}
