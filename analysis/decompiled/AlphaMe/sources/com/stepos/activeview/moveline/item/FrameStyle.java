package com.stepos.activeview.moveline.item;

import java.util.Set;

/* loaded from: classes.dex */
public interface FrameStyle {

    public enum PropertyValueType {
        INT,
        FLOAT,
        OTHER
    }

    Object getPropertyValue(String str);

    PropertyValueType getPropertyValueType(String str);

    Set<String> getUpdateProperties();

    void setPropertyValue(String str, Object obj);
}
