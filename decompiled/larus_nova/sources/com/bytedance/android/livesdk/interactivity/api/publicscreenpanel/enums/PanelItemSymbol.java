package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemSymbol;", "", "", "id", "J", "getId", "()J", "priority", "getPriority", "setPriority", "(J)V", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", "area", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", "getArea", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;", "setArea", "(Lcom/bytedance/android/livesdk/interactivity/api/publicscreenpanel/enums/PanelItemShowArea;)V", "OPEN_PROFILE_SYMBOL", "REPLY", "PIN_COMMENT_SYMBOL", "SECRET_CHAT", "REPLY_AND_PIN_SYMBOL", "PIN_ROOMMESSAGE", "MARK_USER", "LINK_MIC", "OPEN_VIDEO_SYMBOL", "OPEN_MICROAPP_SYMBOL", "PUBLIC_SCREEN_HELPER", "PUBLIC_SCREEN_STYLE_SYMBOL", "COMMENT_CONTROL_MODE", "CREATE_CHAT_CHANNEL", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelItemSymbol extends Enum<PanelItemSymbol> {
    public static final PanelItemSymbol COMMENT_CONTROL_MODE = null;
    public static final PanelItemSymbol CREATE_CHAT_CHANNEL = null;
    public static final PanelItemSymbol LINK_MIC = null;
    public static final PanelItemSymbol MARK_USER = null;
    public static final PanelItemSymbol OPEN_MICROAPP_SYMBOL = null;
    public static final PanelItemSymbol OPEN_PROFILE_SYMBOL = null;
    public static final PanelItemSymbol OPEN_VIDEO_SYMBOL = null;
    public static final PanelItemSymbol PIN_COMMENT_SYMBOL = null;
    public static final PanelItemSymbol PIN_ROOMMESSAGE = null;
    public static final PanelItemSymbol PUBLIC_SCREEN_HELPER = null;
    public static final PanelItemSymbol PUBLIC_SCREEN_STYLE_SYMBOL = null;
    public static final PanelItemSymbol REPLY = null;
    public static final PanelItemSymbol REPLY_AND_PIN_SYMBOL = null;
    public static final PanelItemSymbol SECRET_CHAT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelItemSymbol[] f133745a = null;
    private PanelItemShowArea area;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f133746id;
    private long priority;

    public static PanelItemSymbol valueOf(String r100) {
        return (PanelItemSymbol) a.a(PanelItemSymbol.class, r100);
    }

    public static PanelItemSymbol[] values() {
        return (PanelItemSymbol[]) f133745a.clone();
    }

    static {
        PanelItemShowArea r110 = PanelItemShowArea.TOP;
        PanelItemSymbol r100 = new PanelItemSymbol("OPEN_PROFILE_SYMBOL", 0, 1, 1000, r110);
        OPEN_PROFILE_SYMBOL = r100;
        PanelItemSymbol r101 = new PanelItemSymbol("REPLY", 1, 2, 900, r110);
        REPLY = r101;
        PanelItemSymbol r102 = new PanelItemSymbol("PIN_COMMENT_SYMBOL", 2, 3, 800, r110);
        PIN_COMMENT_SYMBOL = r102;
        PanelItemSymbol r103 = new PanelItemSymbol("SECRET_CHAT", 3, 4, 700, r110);
        SECRET_CHAT = r103;
        PanelItemShowArea r104 = PanelItemShowArea.MIDDLE;
        PanelItemSymbol r105 = new PanelItemSymbol("REPLY_AND_PIN_SYMBOL", 4, 101, 1000, r104);
        REPLY_AND_PIN_SYMBOL = r105;
        PanelItemSymbol r106 = new PanelItemSymbol("PIN_ROOMMESSAGE", 5, 102, 900, r104);
        PIN_ROOMMESSAGE = r106;
        PanelItemSymbol r107 = new PanelItemSymbol("MARK_USER", 6, 103, 800, r104);
        MARK_USER = r107;
        PanelItemSymbol r108 = new PanelItemSymbol("LINK_MIC", 7, 104, 700, r104);
        LINK_MIC = r108;
        PanelItemSymbol r109 = new PanelItemSymbol("OPEN_VIDEO_SYMBOL", 8, 105, 600, r104);
        OPEN_VIDEO_SYMBOL = r109;
        PanelItemSymbol r111 = new PanelItemSymbol("OPEN_MICROAPP_SYMBOL", 9, 106, 500, r104);
        OPEN_MICROAPP_SYMBOL = r111;
        PanelItemSymbol r112 = new PanelItemSymbol("PUBLIC_SCREEN_HELPER", 10, 107, 950, r104);
        PUBLIC_SCREEN_HELPER = r112;
        PanelItemShowArea r113 = PanelItemShowArea.BOTTOM;
        PanelItemSymbol r114 = new PanelItemSymbol("PUBLIC_SCREEN_STYLE_SYMBOL", 11, 201, 1000, r113);
        PUBLIC_SCREEN_STYLE_SYMBOL = r114;
        PanelItemSymbol r115 = new PanelItemSymbol("COMMENT_CONTROL_MODE", 12, 202, 900, r113);
        COMMENT_CONTROL_MODE = r115;
        PanelItemSymbol r116 = new PanelItemSymbol("CREATE_CHAT_CHANNEL", 13, 203, 1100, r113);
        CREATE_CHAT_CHANNEL = r116;
        f133745a = new PanelItemSymbol[]{r100, r101, r102, r103, r105, r106, r107, r108, r109, r111, r112, r114, r115, r116};
    }

    public final PanelItemShowArea getArea() {
        return this.area;
    }

    public final long getId() {
        return this.f133746id;
    }

    public final long getPriority() {
        return this.priority;
    }

    public final void setArea(PanelItemShowArea r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.area = r100;
    }

    public final void setPriority(long r100) {
        this.priority = r100;
    }

    public PanelItemSymbol(String r100, int r101, long r102, long r103, PanelItemShowArea r104) {
        super(r100, r101);
        this.f133746id = r102;
        this.priority = r103;
        this.area = r104;
    }
}
