package com.ttnet.org.chromium.base.metrics;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface JSONVerbosityLevel {
    public static final int JSON_VERBOSITY_LEVEL_FULL = 0;
    public static final int JSON_VERBOSITY_LEVEL_OMIT_BUCKETS = 1;
}
