package com.bytedance.android.ec.core.monitor.process;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/process/ProcessDomain;", "", "LIVE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ProcessDomain extends Enum<ProcessDomain> {
    public static final ProcessDomain LIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProcessDomain[] f45191a = null;

    static {
        ProcessDomain r100 = new ProcessDomain();
        LIVE = r100;
        f45191a = new ProcessDomain[]{r100};
    }

    public static ProcessDomain valueOf(String r100) {
        return (ProcessDomain) a.a(ProcessDomain.class, r100);
    }

    public static ProcessDomain[] values() {
        return (ProcessDomain[]) f45191a.clone();
    }

    public ProcessDomain() {
        super("LIVE", 0);
    }
}
