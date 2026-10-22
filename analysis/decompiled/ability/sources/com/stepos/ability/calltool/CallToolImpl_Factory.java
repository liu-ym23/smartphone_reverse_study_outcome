package com.stepos.ability.calltool;

import com.stepos.ability.net.INet;
import com.stepos.ability.report.IReportManager;
import com.stepos.ability.tracelogger.ITraceLogger;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class CallToolImpl_Factory implements InterfaceC2137b {
    private final InterfaceC2137b iNetProvider;
    private final InterfaceC2137b iReportManagerProvider;
    private final InterfaceC2137b traceLoggerProvider;

    private CallToolImpl_Factory(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3) {
        this.iNetProvider = interfaceC2137b;
        this.iReportManagerProvider = interfaceC2137b2;
        this.traceLoggerProvider = interfaceC2137b3;
    }

    public static CallToolImpl_Factory create(InterfaceC2137b interfaceC2137b, InterfaceC2137b interfaceC2137b2, InterfaceC2137b interfaceC2137b3) {
        return new CallToolImpl_Factory(interfaceC2137b, interfaceC2137b2, interfaceC2137b3);
    }

    public static CallToolImpl newInstance(INet iNet, IReportManager iReportManager, ITraceLogger iTraceLogger) {
        return new CallToolImpl(iNet, iReportManager, iTraceLogger);
    }

    @Override // javax.inject.Provider
    public CallToolImpl get() {
        return newInstance((INet) this.iNetProvider.get(), (IReportManager) this.iReportManagerProvider.get(), (ITraceLogger) this.traceLoggerProvider.get());
    }
}
