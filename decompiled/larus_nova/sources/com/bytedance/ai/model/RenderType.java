package com.bytedance.ai.model;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/model/RenderType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "WEBVIEW", "LYNX", FlowDoraWifiScene.OTHER, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType LYNX = null;
    public static final RenderType OTHER = null;
    public static final RenderType WEBVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderType[] f36770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36771b = null;
    private final String typeName;

    public static EnumEntries<RenderType> getEntries() {
        return f36771b;
    }

    static {
        RenderType r100 = new RenderType("WEBVIEW", 0, "webview");
        WEBVIEW = r100;
        RenderType r101 = new RenderType("LYNX", 1, "lynx");
        LYNX = r101;
        RenderType r102 = new RenderType(FlowDoraWifiScene.OTHER, 2, "other");
        OTHER = r102;
        RenderType[] r103 = {r100, r101, r102};
        f36770a = r103;
        f36771b = EnumEntriesKt.enumEntries(r103);
    }

    public static RenderType[] values() {
        return (RenderType[]) f36770a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static RenderType valueOf(String r100) {
        return (RenderType) r27.a.a(RenderType.class, r100);
    }

    public RenderType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
