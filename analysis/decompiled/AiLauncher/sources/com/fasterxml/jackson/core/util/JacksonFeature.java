package com.fasterxml.jackson.core.util;

/* loaded from: classes.dex */
public interface JacksonFeature {
    boolean enabledByDefault();

    boolean enabledIn(int i10);

    int getMask();
}
