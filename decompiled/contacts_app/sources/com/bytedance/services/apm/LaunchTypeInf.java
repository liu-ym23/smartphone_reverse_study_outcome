package com.bytedance.services.apm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface LaunchTypeInf {
    public static final int FIRST_INSTALL_COLD_LAUNCH = 1;
    public static final int NOT_FIRST_INSTALL_COLD_LAUNCH = 2;
}
