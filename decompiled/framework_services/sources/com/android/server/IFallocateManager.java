package com.android.server;

import android.os.DebugSmtEx;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface IFallocateManager {
    public static final long DELETE_FALLOCATE_MAX_USABLE_SPACE = 419430400;
    public static final long DELETE_FALLOCATE_MIN_USABLE_SPACE = 209715200;
    public static final long FALLOCATE_USABLE_SPACE = 1073741824;

    default void fallocateOrRelease(File file) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
