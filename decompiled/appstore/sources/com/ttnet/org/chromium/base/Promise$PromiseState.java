package com.ttnet.org.chromium.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
@interface Promise$PromiseState {
    public static final int FULFILLED = 1;
    public static final int REJECTED = 2;
    public static final int UNFULFILLED = 0;
}
