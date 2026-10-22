package com.stepos.motionkit;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.fx.backend.sf.SfDrawableChannel;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/motionkit/BackendHint;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "AUTO", "RUNTIME_SHADER", "SURFACE", SfDrawableChannel.TAG, "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BackendHint {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ BackendHint[] $VALUES;
    public static final BackendHint AUTO = new BackendHint("AUTO", 0);
    public static final BackendHint RUNTIME_SHADER = new BackendHint("RUNTIME_SHADER", 1);
    public static final BackendHint SURFACE = new BackendHint("SURFACE", 2);
    public static final BackendHint SF = new BackendHint(SfDrawableChannel.TAG, 3);

    private static final /* synthetic */ BackendHint[] $values() {
        return new BackendHint[]{AUTO, RUNTIME_SHADER, SURFACE, SF};
    }

    static {
        BackendHint[] backendHintArr$values = $values();
        $VALUES = backendHintArr$values;
        $ENTRIES = kotlin.enums.a.a(backendHintArr$values);
    }

    private BackendHint(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static BackendHint valueOf(String str) {
        return (BackendHint) Enum.valueOf(BackendHint.class, str);
    }

    public static BackendHint[] values() {
        return (BackendHint[]) $VALUES.clone();
    }
}
