package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/login/LocalFinishReason;", "", "description", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "USER_DISMISS_DIALOG", "USER_REJECTED_PRIVACY", "USER_REJECTED_LOGIN", "USER_REJECTED_COMBINED", "SUCCESS", "BIZ_FAILED", "TIMEOUT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocalFinishReason extends Enum<LocalFinishReason> {
    public static final LocalFinishReason BIZ_FAILED = null;
    public static final LocalFinishReason SUCCESS = null;
    public static final LocalFinishReason TIMEOUT = null;
    public static final LocalFinishReason USER_DISMISS_DIALOG = null;
    public static final LocalFinishReason USER_REJECTED_COMBINED = null;
    public static final LocalFinishReason USER_REJECTED_LOGIN = null;
    public static final LocalFinishReason USER_REJECTED_PRIVACY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalFinishReason[] f34723a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34724b = null;
    private final String description;

    public static EnumEntries<LocalFinishReason> getEntries() {
        return f34724b;
    }

    static {
        LocalFinishReason r100 = new LocalFinishReason("USER_DISMISS_DIALOG", 0, "User dismiss on drawer dialog");
        USER_DISMISS_DIALOG = r100;
        LocalFinishReason r101 = new LocalFinishReason("USER_REJECTED_PRIVACY", 1, "User rejected in privacy dialog");
        USER_REJECTED_PRIVACY = r101;
        LocalFinishReason r102 = new LocalFinishReason("USER_REJECTED_LOGIN", 2, "User rejected in login dialog");
        USER_REJECTED_LOGIN = r102;
        LocalFinishReason r103 = new LocalFinishReason("USER_REJECTED_COMBINED", 3, "User rejected in combined dialog");
        USER_REJECTED_COMBINED = r103;
        LocalFinishReason r104 = new LocalFinishReason("SUCCESS", 4, "Login success");
        SUCCESS = r104;
        LocalFinishReason r105 = new LocalFinishReason("BIZ_FAILED", 5, "Business login failed");
        BIZ_FAILED = r105;
        LocalFinishReason r110 = new LocalFinishReason("TIMEOUT", 6, "Process timeout");
        TIMEOUT = r110;
        LocalFinishReason[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f34723a = r111;
        f34724b = EnumEntriesKt.enumEntries(r111);
    }

    public static LocalFinishReason[] values() {
        return (LocalFinishReason[]) f34723a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public static LocalFinishReason valueOf(String r100) {
        return (LocalFinishReason) r27.a.a(LocalFinishReason.class, r100);
    }

    public LocalFinishReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
