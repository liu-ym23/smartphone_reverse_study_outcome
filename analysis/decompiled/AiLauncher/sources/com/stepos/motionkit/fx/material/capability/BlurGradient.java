package com.stepos.motionkit.fx.material.capability;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "", "mode", "", "<init>", "(Ljava/lang/String;II)V", "getMode", "()I", ModelFlowMeta.PLAN_NONE, "TOP_TO_BOTTOM", "BOTTOM_TO_TOP", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BlurGradient {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ BlurGradient[] $VALUES;
    private final int mode;
    public static final BlurGradient NONE = new BlurGradient(ModelFlowMeta.PLAN_NONE, 0, 0);
    public static final BlurGradient TOP_TO_BOTTOM = new BlurGradient("TOP_TO_BOTTOM", 1, 1);
    public static final BlurGradient BOTTOM_TO_TOP = new BlurGradient("BOTTOM_TO_TOP", 2, 2);
    public static final BlurGradient LEFT_TO_RIGHT = new BlurGradient("LEFT_TO_RIGHT", 3, 3);
    public static final BlurGradient RIGHT_TO_LEFT = new BlurGradient("RIGHT_TO_LEFT", 4, 4);

    private static final /* synthetic */ BlurGradient[] $values() {
        return new BlurGradient[]{NONE, TOP_TO_BOTTOM, BOTTOM_TO_TOP, LEFT_TO_RIGHT, RIGHT_TO_LEFT};
    }

    static {
        BlurGradient[] blurGradientArr$values = $values();
        $VALUES = blurGradientArr$values;
        $ENTRIES = a.a(blurGradientArr$values);
    }

    private BlurGradient(String str, int i10, int i11) {
        this.mode = i11;
    }

    public static InterfaceC4149a<BlurGradient> getEntries() {
        return $ENTRIES;
    }

    public static BlurGradient valueOf(String str) {
        return (BlurGradient) Enum.valueOf(BlurGradient.class, str);
    }

    public static BlurGradient[] values() {
        return (BlurGradient[]) $VALUES.clone();
    }

    public final int getMode() {
        return this.mode;
    }
}
