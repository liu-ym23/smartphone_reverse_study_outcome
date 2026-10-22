package com.ttnet.org.chromium.base.library_loader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
@interface LibraryLoader$LoadState {
    public static final int LOADED = 2;
    public static final int MAIN_DEX_LOADED = 1;
    public static final int NOT_LOADED = 0;
}
