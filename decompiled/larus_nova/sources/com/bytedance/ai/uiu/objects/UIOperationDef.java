package com.bytedance.ai.uiu.objects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/uiu/objects/UIOperationDef;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLICK", "LONG_CLICK", "INPUT", "INPUT_GO", "SCROLL_BOTTOM", "SCROLL_NEXT", "SCROLL_PREVIOUS", "SCROLL_TOP", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UIOperationDef extends Enum<UIOperationDef> {
    public static final UIOperationDef CLICK = null;
    public static final UIOperationDef INPUT = null;
    public static final UIOperationDef INPUT_GO = null;
    public static final UIOperationDef LONG_CLICK = null;
    public static final UIOperationDef SCROLL_BOTTOM = null;
    public static final UIOperationDef SCROLL_NEXT = null;
    public static final UIOperationDef SCROLL_PREVIOUS = null;
    public static final UIOperationDef SCROLL_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UIOperationDef[] f37623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37624b = null;
    private final String value;

    public static EnumEntries<UIOperationDef> getEntries() {
        return f37624b;
    }

    static {
        UIOperationDef r100 = new UIOperationDef("CLICK", 0, "click");
        CLICK = r100;
        UIOperationDef r101 = new UIOperationDef("LONG_CLICK", 1, "longClick");
        LONG_CLICK = r101;
        UIOperationDef r102 = new UIOperationDef("INPUT", 2, "input");
        INPUT = r102;
        UIOperationDef r103 = new UIOperationDef("INPUT_GO", 3, "inputGo");
        INPUT_GO = r103;
        UIOperationDef r104 = new UIOperationDef("SCROLL_BOTTOM", 4, "scrollBottom");
        SCROLL_BOTTOM = r104;
        UIOperationDef r105 = new UIOperationDef("SCROLL_NEXT", 5, "scrollNext");
        SCROLL_NEXT = r105;
        UIOperationDef r110 = new UIOperationDef("SCROLL_PREVIOUS", 6, "scrollPrevious");
        SCROLL_PREVIOUS = r110;
        UIOperationDef r111 = new UIOperationDef("SCROLL_TOP", 7, "scrollTop");
        SCROLL_TOP = r111;
        UIOperationDef[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f37623a = r112;
        f37624b = EnumEntriesKt.enumEntries(r112);
    }

    public static UIOperationDef[] values() {
        return (UIOperationDef[]) f37623a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static UIOperationDef valueOf(String r100) {
        return (UIOperationDef) a.a(UIOperationDef.class, r100);
    }

    public UIOperationDef(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
