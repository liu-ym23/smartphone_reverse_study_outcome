package com.bytedance.ai.monitor.timeline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/monitor/timeline/WidgetFrom;", "", "from", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "NEW", "HISTORY", "MIXTURE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WidgetFrom extends Enum<WidgetFrom> {
    public static final WidgetFrom HISTORY = null;
    public static final WidgetFrom MIXTURE = null;
    public static final WidgetFrom NEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidgetFrom[] f37209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37210b = null;
    private final String from;

    public static EnumEntries<WidgetFrom> getEntries() {
        return f37210b;
    }

    static {
        WidgetFrom r100 = new WidgetFrom("NEW", 0, "new");
        NEW = r100;
        WidgetFrom r101 = new WidgetFrom("HISTORY", 1, "history");
        HISTORY = r101;
        WidgetFrom r102 = new WidgetFrom("MIXTURE", 2, "mixture");
        MIXTURE = r102;
        WidgetFrom[] r103 = {r100, r101, r102};
        f37209a = r103;
        f37210b = EnumEntriesKt.enumEntries(r103);
    }

    public static WidgetFrom[] values() {
        return (WidgetFrom[]) f37209a.clone();
    }

    public final String getFrom() {
        return this.from;
    }

    public static WidgetFrom valueOf(String r100) {
        return (WidgetFrom) a.a(WidgetFrom.class, r100);
    }

    public WidgetFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.from = r102;
    }
}
