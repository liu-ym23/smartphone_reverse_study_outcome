package com.stepos.motionkit;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/motionkit/SurfaceRendererType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "AGSL", "GLES", "VULKAN", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurfaceRendererType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ SurfaceRendererType[] $VALUES;
    public static final SurfaceRendererType AGSL = new SurfaceRendererType("AGSL", 0);
    public static final SurfaceRendererType GLES = new SurfaceRendererType("GLES", 1);
    public static final SurfaceRendererType VULKAN = new SurfaceRendererType("VULKAN", 2);

    private static final /* synthetic */ SurfaceRendererType[] $values() {
        return new SurfaceRendererType[]{AGSL, GLES, VULKAN};
    }

    static {
        SurfaceRendererType[] surfaceRendererTypeArr$values = $values();
        $VALUES = surfaceRendererTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(surfaceRendererTypeArr$values);
    }

    private SurfaceRendererType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static SurfaceRendererType valueOf(String str) {
        return (SurfaceRendererType) Enum.valueOf(SurfaceRendererType.class, str);
    }

    public static SurfaceRendererType[] values() {
        return (SurfaceRendererType[]) $VALUES.clone();
    }
}
