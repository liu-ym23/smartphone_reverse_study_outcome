package com.obric.memorydata.sdk.awareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: GeoFenceStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum GeoFenceStatus extends Enum<GeoFenceStatus> {
    private static final /* synthetic */ d.d.a $ENTRIES = null;
    private static final /* synthetic */ GeoFenceStatus[] $VALUES = null;
    public static final a Companion = null;
    public static final GeoFenceStatus INSIDE = null;
    public static final GeoFenceStatus OUTSIDE = null;
    public static final GeoFenceStatus UNKNOWN = null;
    private final int value;

    /* JADX INFO: compiled from: GeoFenceStatus.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ GeoFenceStatus[] $values() {
        return new GeoFenceStatus[]{UNKNOWN, INSIDE, OUTSIDE};
    }

    public static d.d.a<GeoFenceStatus> getEntries() {
        return $ENTRIES;
    }

    private GeoFenceStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        UNKNOWN = new GeoFenceStatus("UNKNOWN", 0, -1);
        INSIDE = new GeoFenceStatus("INSIDE", 1, 1);
        OUTSIDE = new GeoFenceStatus("OUTSIDE", 2, 0);
        GeoFenceStatus[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        Companion = new a(null);
    }

    public static GeoFenceStatus valueOf(String r2) {
        return (GeoFenceStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoFenceStatus.class, r2), GeoFenceStatus.class, "com.obric.aiagent.plugin");
    }

    public static GeoFenceStatus[] values() {
        return (GeoFenceStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GeoFenceStatus[].class, "com.obric.aiagent.plugin");
    }
}
