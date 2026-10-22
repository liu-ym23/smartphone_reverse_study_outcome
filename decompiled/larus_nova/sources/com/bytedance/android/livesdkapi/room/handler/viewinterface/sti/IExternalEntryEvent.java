package com.bytedance.android.livesdkapi.room.handler.viewinterface.sti;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/sti/IExternalEntryEvent;", "", "(Ljava/lang/String;I)V", "Start", "End", "Skip", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IExternalEntryEvent extends Enum<IExternalEntryEvent> {
    private static final /* synthetic */ IExternalEntryEvent[] $VALUES = null;
    public static final IExternalEntryEvent End = null;
    public static final IExternalEntryEvent Skip = null;
    public static final IExternalEntryEvent Start = null;

    static {
        IExternalEntryEvent r100 = new IExternalEntryEvent("Start", 0);
        Start = r100;
        IExternalEntryEvent r101 = new IExternalEntryEvent("End", 1);
        End = r101;
        IExternalEntryEvent r102 = new IExternalEntryEvent("Skip", 2);
        Skip = r102;
        $VALUES = new IExternalEntryEvent[]{r100, r101, r102};
    }

    public static IExternalEntryEvent valueOf(String r100) {
        return (IExternalEntryEvent) a.a(IExternalEntryEvent.class, r100);
    }

    public static IExternalEntryEvent[] values() {
        return (IExternalEntryEvent[]) $VALUES.clone();
    }

    private IExternalEntryEvent(String r100, int r101) {
        super(r100, r101);
    }
}
