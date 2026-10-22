package com.stepos.activeview.moveline.item;

/* loaded from: classes.dex */
public interface TweenItem {
    FrameStyle buildFrameStyle();

    Object getPropertyValue(String str);

    boolean isUpdatable();

    void updateProperty(String str, Object obj, float f4);
}
