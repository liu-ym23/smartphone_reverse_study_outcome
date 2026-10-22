package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/login/DialogAction;", "", "<init>", "(Ljava/lang/String;I)V", "AGREE", "REJECT", "CLOSE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DialogAction extends Enum<DialogAction> {
    public static final DialogAction AGREE = null;
    public static final DialogAction CLOSE = null;
    public static final DialogAction REJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogAction[] f34719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34720b = null;

    public static EnumEntries<DialogAction> getEntries() {
        return f34720b;
    }

    static {
        DialogAction r100 = new DialogAction("AGREE", 0);
        AGREE = r100;
        DialogAction r101 = new DialogAction("REJECT", 1);
        REJECT = r101;
        DialogAction r102 = new DialogAction("CLOSE", 2);
        CLOSE = r102;
        DialogAction[] r103 = {r100, r101, r102};
        f34719a = r103;
        f34720b = EnumEntriesKt.enumEntries(r103);
    }

    public static DialogAction[] values() {
        return (DialogAction[]) f34719a.clone();
    }

    public static DialogAction valueOf(String r100) {
        return (DialogAction) r27.a.a(DialogAction.class, r100);
    }

    public DialogAction(String r100, int r101) {
        super(r100, r101);
    }
}
