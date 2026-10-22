package com.stepos.ability.report;

import t4.c;
import y7.InterfaceC2137b;

/* loaded from: classes3.dex */
public final class ReportManager_Factory implements InterfaceC2137b {
    public static ReportManager_Factory create() {
        return c.f6658a;
    }

    public static ReportManager newInstance() {
        return new ReportManager();
    }

    @Override // javax.inject.Provider
    public ReportManager get() {
        return newInstance();
    }
}
