package com.stepos.launcher.assistant.slidepanel;

import android.util.Property;

/* loaded from: classes.dex */
public final class SlidingPanelLayoutProperty extends Property<SlidingPanelLayout, Integer> {
    public SlidingPanelLayoutProperty(Class<Integer> cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Integer get(SlidingPanelLayout slidingPanelLayout) {
        return Integer.valueOf(slidingPanelLayout.mPanelX);
    }

    @Override // android.util.Property
    public void set(SlidingPanelLayout slidingPanelLayout, Integer num) {
        slidingPanelLayout.setPanelX(num.intValue());
    }
}
