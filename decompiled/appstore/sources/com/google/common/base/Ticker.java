package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = null;

    static {
        SYSTEM_TICKER = new AnonymousClass1();
    }

    public Ticker() {
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }

    public abstract long read();
}
