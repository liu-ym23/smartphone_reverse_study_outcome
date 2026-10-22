package com.stepos.motionkit.fx.backend;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/motionkit/fx/backend/SurfaceRenderer;", "", "<init>", "(Ljava/lang/String;I)V", "AGSL", "GLES", "VULKAN", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SurfaceRenderer {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SurfaceRenderer[] $VALUES;
    public static final SurfaceRenderer AGSL = new SurfaceRenderer("AGSL", 0);
    public static final SurfaceRenderer GLES = new SurfaceRenderer("GLES", 1);
    public static final SurfaceRenderer VULKAN = new SurfaceRenderer("VULKAN", 2);

    private static final /* synthetic */ SurfaceRenderer[] $values() {
        return new SurfaceRenderer[]{AGSL, GLES, VULKAN};
    }

    static {
        SurfaceRenderer[] surfaceRendererArr$values = $values();
        $VALUES = surfaceRendererArr$values;
        $ENTRIES = a.a(surfaceRendererArr$values);
    }

    private SurfaceRenderer(String str, int i10) {
    }

    public static InterfaceC4149a<SurfaceRenderer> getEntries() {
        return $ENTRIES;
    }

    public static SurfaceRenderer valueOf(String str) {
        return (SurfaceRenderer) Enum.valueOf(SurfaceRenderer.class, str);
    }

    public static SurfaceRenderer[] values() {
        return (SurfaceRenderer[]) $VALUES.clone();
    }
}
