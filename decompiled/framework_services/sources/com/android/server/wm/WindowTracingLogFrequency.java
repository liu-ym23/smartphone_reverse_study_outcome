package com.android.server.wm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.SOURCE)
@interface WindowTracingLogFrequency {
    public static final int FRAME = 0;
    public static final int SINGLE_DUMP = 2;
    public static final int TRANSACTION = 1;
}
