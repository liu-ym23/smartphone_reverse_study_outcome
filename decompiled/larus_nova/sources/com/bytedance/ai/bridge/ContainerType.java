package com.bytedance.ai.bridge;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.pia.core.metrics.ErrorType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/ContainerType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "WIDGET", "PAGE", "WORKER", "EMBED_WEB_VIEW", UserProfileEvent.POSITION_NONE, "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType EMBED_WEB_VIEW = null;
    public static final ContainerType NONE = null;
    public static final ContainerType PAGE = null;
    public static final ContainerType WIDGET = null;
    public static final ContainerType WORKER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f35225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35226b = null;
    private final String typeName;

    public static EnumEntries<ContainerType> getEntries() {
        return f35226b;
    }

    static {
        ContainerType r100 = new ContainerType("WIDGET", 0, "widget");
        WIDGET = r100;
        ContainerType r101 = new ContainerType("PAGE", 1, "page");
        PAGE = r101;
        ContainerType r102 = new ContainerType("WORKER", 2, ErrorType.WORKER);
        WORKER = r102;
        ContainerType r103 = new ContainerType("EMBED_WEB_VIEW", 3, "embed_webview");
        EMBED_WEB_VIEW = r103;
        ContainerType r104 = new ContainerType(UserProfileEvent.POSITION_NONE, 4, "unknown");
        NONE = r104;
        ContainerType[] r105 = {r100, r101, r102, r103, r104};
        f35225a = r105;
        f35226b = EnumEntriesKt.enumEntries(r105);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f35225a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) a.a(ContainerType.class, r100);
    }

    public ContainerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
