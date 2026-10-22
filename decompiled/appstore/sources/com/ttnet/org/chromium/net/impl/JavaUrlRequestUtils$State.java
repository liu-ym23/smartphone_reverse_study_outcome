package com.ttnet.org.chromium.net.impl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface JavaUrlRequestUtils$State {
    public static final int AWAITING_FOLLOW_REDIRECT = 3;
    public static final int AWAITING_READ = 4;
    public static final int CANCELLED = 8;
    public static final int COMPLETE = 7;
    public static final int ERROR = 6;
    public static final int NOT_STARTED = 0;
    public static final int READING = 5;
    public static final int REDIRECT_RECEIVED = 2;
    public static final int STARTED = 1;
}
