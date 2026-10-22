package com.airbnb.lottie;

import android.graphics.Rect;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import ch.qos.logback.classic.net.SyslogAppender;
import e.EnumC0546d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class LottieComposition {
    private Rect bounds;
    private q.m characters;
    private float endFrame;
    private Map<String, J0.c> fonts;
    private float frameRate;
    private Map<String, w> images;
    private q.i layerMap;
    private List<M0.e> layers;
    private Map<String, List<M0.e>> precomps;
    private float startFrame;
    private final D performanceTracker = new D();
    private final HashSet<String> warnings = new HashSet<>();

    @RestrictTo({EnumC0546d.f12492a})
    public void addWarning(String str) {
        Log.w("LOTTIE", str);
        this.warnings.add(str);
    }

    public Rect getBounds() {
        return this.bounds;
    }

    public q.m getCharacters() {
        return this.characters;
    }

    public float getDuration() {
        return (long) ((getDurationFrames() / this.frameRate) * 1000.0f);
    }

    public float getDurationFrames() {
        return this.endFrame - this.startFrame;
    }

    @RestrictTo({EnumC0546d.f12492a})
    public float getEndFrame() {
        return this.endFrame;
    }

    public Map<String, J0.c> getFonts() {
        return this.fonts;
    }

    public float getFrameRate() {
        return this.frameRate;
    }

    public Map<String, w> getImages() {
        return this.images;
    }

    public List<M0.e> getLayers() {
        return this.layers;
    }

    public D getPerformanceTracker() {
        return this.performanceTracker;
    }

    @Nullable
    @RestrictTo({EnumC0546d.f12492a})
    public List<M0.e> getPrecomps(String str) {
        return this.precomps.get(str);
    }

    @RestrictTo({EnumC0546d.f12492a})
    public float getStartFrame() {
        return this.startFrame;
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> hashSet = this.warnings;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    public boolean hasImages() {
        return !this.images.isEmpty();
    }

    public void init(Rect rect, float f4, float f5, float f6, List<M0.e> list, q.i iVar, Map<String, List<M0.e>> map, Map<String, w> map2, q.m mVar, Map<String, J0.c> map3) {
        this.bounds = rect;
        this.startFrame = f4;
        this.endFrame = f5;
        this.frameRate = f6;
        this.layers = list;
        this.layerMap = iVar;
        this.precomps = map;
        this.images = map2;
        this.characters = mVar;
        this.fonts = map3;
    }

    @RestrictTo({EnumC0546d.f12492a})
    public M0.e layerModelForId(long j4) {
        return (M0.e) this.layerMap.d(j4);
    }

    public void setPerformanceTrackingEnabled(boolean z4) {
        this.performanceTracker.f4530a = z4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<M0.e> it = this.layers.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a(SyslogAppender.DEFAULT_STACKTRACE_PATTERN));
        }
        return sb.toString();
    }
}
