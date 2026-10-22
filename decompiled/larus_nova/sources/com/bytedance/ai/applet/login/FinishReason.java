package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/login/FinishReason;", "", "description", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "USER_REJECTED_ON_CARD", "USER_REJECTED_PRIVACY", "USER_REJECTED_LOGIN", "USER_REJECTED_COMBINED", "SUCCESS", "BIZ_FAILED", "TIMEOUT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FinishReason extends Enum<FinishReason> {
    public static final FinishReason BIZ_FAILED = null;
    public static final FinishReason SUCCESS = null;
    public static final FinishReason TIMEOUT = null;
    public static final FinishReason USER_REJECTED_COMBINED = null;
    public static final FinishReason USER_REJECTED_LOGIN = null;
    public static final FinishReason USER_REJECTED_ON_CARD = null;
    public static final FinishReason USER_REJECTED_PRIVACY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FinishReason[] f34721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34722b = null;
    private final String description;

    public static EnumEntries<FinishReason> getEntries() {
        return f34722b;
    }

    static {
        FinishReason r100 = new FinishReason("USER_REJECTED_ON_CARD", 0, "User rejected on native card");
        USER_REJECTED_ON_CARD = r100;
        FinishReason r101 = new FinishReason("USER_REJECTED_PRIVACY", 1, "User rejected in privacy dialog");
        USER_REJECTED_PRIVACY = r101;
        FinishReason r102 = new FinishReason("USER_REJECTED_LOGIN", 2, "User rejected in login dialog");
        USER_REJECTED_LOGIN = r102;
        FinishReason r103 = new FinishReason("USER_REJECTED_COMBINED", 3, "User rejected in combined dialog");
        USER_REJECTED_COMBINED = r103;
        FinishReason r104 = new FinishReason("SUCCESS", 4, "Login success");
        SUCCESS = r104;
        FinishReason r105 = new FinishReason("BIZ_FAILED", 5, "Business login failed");
        BIZ_FAILED = r105;
        FinishReason r110 = new FinishReason("TIMEOUT", 6, "Process timeout");
        TIMEOUT = r110;
        FinishReason[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f34721a = r111;
        f34722b = EnumEntriesKt.enumEntries(r111);
    }

    public static FinishReason[] values() {
        return (FinishReason[]) f34721a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public static FinishReason valueOf(String r100) {
        return (FinishReason) r27.a.a(FinishReason.class, r100);
    }

    public FinishReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
