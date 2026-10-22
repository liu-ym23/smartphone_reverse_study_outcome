package com.airbnb.lottie;

import android.util.Log;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class PerformanceTracker {
    private boolean enabled = false;
    private final Set<FrameListener> frameListeners = new androidx.collection.b();
    private final Map<String, MeanCalculator> layerRenderTimes = new HashMap();
    private final Comparator<B0.d<String, Float>> floatComparator = new Comparator<B0.d<String, Float>>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        public int compare(B0.d<String, Float> dVar, B0.d<String, Float> dVar2) {
            float fFloatValue = dVar.f1412b.floatValue();
            float fFloatValue2 = dVar2.f1412b.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public interface FrameListener {
        void onFrameRendered(float f10);
    }

    public void addFrameListener(FrameListener frameListener) {
        this.frameListeners.add(frameListener);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public List<B0.d<String, Float>> getSortedRenderTimes() {
        if (!this.enabled) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(this.layerRenderTimes.size());
        for (Map.Entry<String, MeanCalculator> entry : this.layerRenderTimes.entrySet()) {
            arrayList.add(new B0.d(entry.getKey(), Float.valueOf(entry.getValue().getMean())));
        }
        Collections.sort(arrayList, this.floatComparator);
        return arrayList;
    }

    public void logRenderTimes() {
        if (this.enabled) {
            List<B0.d<String, Float>> sortedRenderTimes = getSortedRenderTimes();
            Log.d(L.TAG, "Render times:");
            for (int i10 = 0; i10 < sortedRenderTimes.size(); i10++) {
                B0.d<String, Float> dVar = sortedRenderTimes.get(i10);
                Log.d(L.TAG, String.format("\t\t%30s:%.2f", dVar.f1411a, dVar.f1412b));
            }
        }
    }

    public void recordRenderTime(String str, float f10) {
        if (this.enabled) {
            MeanCalculator meanCalculator = this.layerRenderTimes.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                this.layerRenderTimes.put(str, meanCalculator);
            }
            meanCalculator.add(f10);
            if (str.equals("__container")) {
                Iterator<FrameListener> it = this.frameListeners.iterator();
                while (it.hasNext()) {
                    it.next().onFrameRendered(f10);
                }
            }
        }
    }

    public void removeFrameListener(FrameListener frameListener) {
        this.frameListeners.remove(frameListener);
    }

    public void setEnabled(boolean z10) {
        this.enabled = z10;
    }
}
