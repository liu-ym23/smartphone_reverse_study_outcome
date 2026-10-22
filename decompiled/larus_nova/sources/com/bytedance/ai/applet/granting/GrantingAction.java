package com.bytedance.ai.applet.granting;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/granting/GrantingAction;", "", "<init>", "(Ljava/lang/String;I)V", "AGREED", "REJECTED", "DISMISSED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GrantingAction extends Enum<GrantingAction> {
    public static final GrantingAction AGREED = null;
    public static final GrantingAction DISMISSED = null;
    public static final GrantingAction REJECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GrantingAction[] f34632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34633b = null;

    public static EnumEntries<GrantingAction> getEntries() {
        return f34633b;
    }

    static {
        GrantingAction r100 = new GrantingAction("AGREED", 0);
        AGREED = r100;
        GrantingAction r101 = new GrantingAction("REJECTED", 1);
        REJECTED = r101;
        GrantingAction r102 = new GrantingAction("DISMISSED", 2);
        DISMISSED = r102;
        GrantingAction[] r103 = {r100, r101, r102};
        f34632a = r103;
        f34633b = EnumEntriesKt.enumEntries(r103);
    }

    public static GrantingAction[] values() {
        return (GrantingAction[]) f34632a.clone();
    }

    public static GrantingAction valueOf(String r100) {
        return (GrantingAction) a.a(GrantingAction.class, r100);
    }

    public GrantingAction(String r100, int r101) {
        super(r100, r101);
    }
}
