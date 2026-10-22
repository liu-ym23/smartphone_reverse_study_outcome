package com.mdisdk.capability;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/mdisdk/capability/TagWriteMode;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "CODE_POINT", "BATCH", "HASH_BOUNDARY", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TagWriteMode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ TagWriteMode[] $VALUES;
    public static final TagWriteMode CODE_POINT = new TagWriteMode("CODE_POINT", 0);
    public static final TagWriteMode BATCH = new TagWriteMode("BATCH", 1);
    public static final TagWriteMode HASH_BOUNDARY = new TagWriteMode("HASH_BOUNDARY", 2);

    private static final /* synthetic */ TagWriteMode[] $values() {
        return new TagWriteMode[]{CODE_POINT, BATCH, HASH_BOUNDARY};
    }

    static {
        TagWriteMode[] tagWriteModeArr$values = $values();
        $VALUES = tagWriteModeArr$values;
        $ENTRIES = kotlin.enums.a.a(tagWriteModeArr$values);
    }

    private TagWriteMode(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static TagWriteMode valueOf(String str) {
        return (TagWriteMode) Enum.valueOf(TagWriteMode.class, str);
    }

    public static TagWriteMode[] values() {
        return (TagWriteMode[]) $VALUES.clone();
    }
}
