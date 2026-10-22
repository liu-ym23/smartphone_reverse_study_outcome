package com.bytedance.android.ec.adapter.api.handler.viewinterface.sti;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/handler/viewinterface/sti/IECExternalEntryEvent;", "", "Start", "End", "Skip", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IECExternalEntryEvent extends Enum<IECExternalEntryEvent> {
    public static final IECExternalEntryEvent End = null;
    public static final IECExternalEntryEvent Skip = null;
    public static final IECExternalEntryEvent Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IECExternalEntryEvent[] f42677a = null;

    static {
        IECExternalEntryEvent r100 = new IECExternalEntryEvent("Start", 0);
        Start = r100;
        IECExternalEntryEvent r101 = new IECExternalEntryEvent("End", 1);
        End = r101;
        IECExternalEntryEvent r102 = new IECExternalEntryEvent("Skip", 2);
        Skip = r102;
        f42677a = new IECExternalEntryEvent[]{r100, r101, r102};
    }

    public static IECExternalEntryEvent valueOf(String r100) {
        return (IECExternalEntryEvent) a.a(IECExternalEntryEvent.class, r100);
    }

    public static IECExternalEntryEvent[] values() {
        return (IECExternalEntryEvent[]) f42677a.clone();
    }

    public IECExternalEntryEvent(String r100, int r101) {
        super(r100, r101);
    }
}
