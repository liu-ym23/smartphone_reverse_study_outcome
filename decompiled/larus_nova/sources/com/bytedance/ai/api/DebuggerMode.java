package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/api/DebuggerMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ONLINE_PREVIEW", "LOCAL_DEBUG", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DebuggerMode extends Enum<DebuggerMode> {
    public static final a Companion = null;
    public static final DebuggerMode LOCAL_DEBUG = null;
    public static final DebuggerMode ONLINE_PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DebuggerMode[] f33971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f33972b = null;
    private final String value;

    public static EnumEntries<DebuggerMode> getEntries() {
        return f33972b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.api.DebuggerMode$a] */
    static {
        DebuggerMode r100 = new DebuggerMode("ONLINE_PREVIEW", 0, "online_preview");
        ONLINE_PREVIEW = r100;
        DebuggerMode r101 = new DebuggerMode("LOCAL_DEBUG", 1, "local_debug");
        LOCAL_DEBUG = r101;
        DebuggerMode[] r102 = {r100, r101};
        f33971a = r102;
        f33972b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static DebuggerMode[] values() {
        return (DebuggerMode[]) f33971a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DebuggerMode valueOf(String r100) {
        return (DebuggerMode) r27.a.a(DebuggerMode.class, r100);
    }

    public DebuggerMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
