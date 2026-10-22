package com.ttnet.org.chromium.base.metrics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
@interface CachingUmaRecorder$Histogram$Type {
    public static final int BOOLEAN = 1;
    public static final int EXPONENTIAL = 2;
    public static final int LINEAR = 3;
    public static final int SPARSE = 4;
}
