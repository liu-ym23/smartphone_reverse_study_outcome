package com.bytedance.ai.applet.render.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/applet/render/core/RenderType;", "", "type", "", "canReuse", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getType", "()Ljava/lang/String;", "getCanReuse", "()Z", "WEB", "LYNX", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType LYNX = null;
    public static final RenderType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderType[] f34953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34954b = null;
    private final boolean canReuse;
    private final String type;

    public static EnumEntries<RenderType> getEntries() {
        return f34954b;
    }

    static {
        RenderType r100 = new RenderType("WEB", 0, "webview", false);
        WEB = r100;
        RenderType r101 = new RenderType("LYNX", 1, "lynx", true);
        LYNX = r101;
        RenderType[] r102 = {r100, r101};
        f34953a = r102;
        f34954b = EnumEntriesKt.enumEntries(r102);
    }

    public static RenderType[] values() {
        return (RenderType[]) f34953a.clone();
    }

    public final boolean getCanReuse() {
        return this.canReuse;
    }

    public final String getType() {
        return this.type;
    }

    public static RenderType valueOf(String r100) {
        return (RenderType) a.a(RenderType.class, r100);
    }

    public RenderType(String r100, int r101, String r102, boolean r103) {
        super(r100, r101);
        this.type = r102;
        this.canReuse = r103;
    }
}
