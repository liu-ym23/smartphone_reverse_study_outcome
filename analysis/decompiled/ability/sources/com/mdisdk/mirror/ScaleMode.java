package com.mdisdk.mirror;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/mdisdk/mirror/ScaleMode;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "FIT", "FILL", "CROP", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScaleMode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ScaleMode[] $VALUES;
    public static final ScaleMode FIT = new ScaleMode("FIT", 0);
    public static final ScaleMode FILL = new ScaleMode("FILL", 1);
    public static final ScaleMode CROP = new ScaleMode("CROP", 2);

    private static final /* synthetic */ ScaleMode[] $values() {
        return new ScaleMode[]{FIT, FILL, CROP};
    }

    static {
        ScaleMode[] scaleModeArr$values = $values();
        $VALUES = scaleModeArr$values;
        $ENTRIES = kotlin.enums.a.a(scaleModeArr$values);
    }

    private ScaleMode(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ScaleMode valueOf(String str) {
        return (ScaleMode) Enum.valueOf(ScaleMode.class, str);
    }

    public static ScaleMode[] values() {
        return (ScaleMode[]) $VALUES.clone();
    }
}
