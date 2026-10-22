package com.bytedance.applet.model.menu;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applet/model/menu/SystemAction;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DELETE", "SHARE", OpenNetMethod.REPORT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SystemAction extends Enum<SystemAction> {
    public static final SystemAction DELETE = null;
    public static final SystemAction REPORT = null;
    public static final SystemAction SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SystemAction[] f192158a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f192159b = null;
    private final String value;

    public static EnumEntries<SystemAction> getEntries() {
        return f192159b;
    }

    static {
        SystemAction r100 = new SystemAction("DELETE", 0, "delete");
        DELETE = r100;
        SystemAction r101 = new SystemAction("SHARE", 1, "share");
        SHARE = r101;
        SystemAction r102 = new SystemAction(OpenNetMethod.REPORT, 2, "report");
        REPORT = r102;
        SystemAction[] r103 = {r100, r101, r102};
        f192158a = r103;
        f192159b = EnumEntriesKt.enumEntries(r103);
    }

    public static SystemAction[] values() {
        return (SystemAction[]) f192158a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static SystemAction valueOf(String r100) {
        return (SystemAction) r27.a.a(SystemAction.class, r100);
    }

    public SystemAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
