package com.bytedance.platform.godzilla.common;

/* JADX INFO: loaded from: classes.dex */
public interface UncaughtExceptionConsumer {
    boolean consumeUncaughtException(Thread r10, Throwable r11) throws Throwable;
}
