package com.stepos.motionkit;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/motionkit/SurfacePresentation;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "SURFACE_VIEW", "TEXTURE_VIEW", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurfacePresentation {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ SurfacePresentation[] $VALUES;
    public static final SurfacePresentation SURFACE_VIEW = new SurfacePresentation("SURFACE_VIEW", 0);
    public static final SurfacePresentation TEXTURE_VIEW = new SurfacePresentation("TEXTURE_VIEW", 1);

    private static final /* synthetic */ SurfacePresentation[] $values() {
        return new SurfacePresentation[]{SURFACE_VIEW, TEXTURE_VIEW};
    }

    static {
        SurfacePresentation[] surfacePresentationArr$values = $values();
        $VALUES = surfacePresentationArr$values;
        $ENTRIES = kotlin.enums.a.a(surfacePresentationArr$values);
    }

    private SurfacePresentation(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static SurfacePresentation valueOf(String str) {
        return (SurfacePresentation) Enum.valueOf(SurfacePresentation.class, str);
    }

    public static SurfacePresentation[] values() {
        return (SurfacePresentation[]) $VALUES.clone();
    }
}
