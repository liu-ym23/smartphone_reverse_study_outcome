package com.fasterxml.jackson.databind.cfg;

/* loaded from: classes2.dex */
public interface ConfigFeature {
    boolean enabledByDefault();

    boolean enabledIn(int i10);

    int getMask();
}
