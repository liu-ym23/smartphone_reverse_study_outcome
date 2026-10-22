package com.stepos.ability.tracelogger;

import android.content.Context;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class TraceLogger_Factory implements InterfaceC2137b {
    private final InterfaceC2137b contextProvider;

    private TraceLogger_Factory(InterfaceC2137b interfaceC2137b) {
        this.contextProvider = interfaceC2137b;
    }

    public static TraceLogger_Factory create(InterfaceC2137b interfaceC2137b) {
        return new TraceLogger_Factory(interfaceC2137b);
    }

    public static TraceLogger newInstance(Context context) {
        return new TraceLogger(context);
    }

    @Override // javax.inject.Provider
    public TraceLogger get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
