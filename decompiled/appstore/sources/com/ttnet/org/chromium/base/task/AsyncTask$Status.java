package com.ttnet.org.chromium.base.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AsyncTask$Status {
    public static final int FINISHED = 2;
    public static final int PENDING = 0;
    public static final int RUNNING = 1;
}
