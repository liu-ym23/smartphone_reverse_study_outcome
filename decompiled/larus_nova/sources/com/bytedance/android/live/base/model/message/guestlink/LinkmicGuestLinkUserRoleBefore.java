package com.bytedance.android.live.base.model.message.guestlink;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/LinkmicGuestLinkUserRoleBefore;", "", "", "value", "I", "getValue", "()I", "LinkmicGuestLinkUserRoleBefore_Audience", "LinkmicGuestLinkUserRoleBefore_Anchor", "LinkmicGuestLinkUserRoleBefore_Guest", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicGuestLinkUserRoleBefore extends Enum<LinkmicGuestLinkUserRoleBefore> {
    public static final LinkmicGuestLinkUserRoleBefore LinkmicGuestLinkUserRoleBefore_Anchor = null;
    public static final LinkmicGuestLinkUserRoleBefore LinkmicGuestLinkUserRoleBefore_Audience = null;
    public static final LinkmicGuestLinkUserRoleBefore LinkmicGuestLinkUserRoleBefore_Guest = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicGuestLinkUserRoleBefore[] f58885a = null;
    private final int value;

    static {
        LinkmicGuestLinkUserRoleBefore r100 = new LinkmicGuestLinkUserRoleBefore("LinkmicGuestLinkUserRoleBefore_Audience", 0, 0);
        LinkmicGuestLinkUserRoleBefore_Audience = r100;
        LinkmicGuestLinkUserRoleBefore r101 = new LinkmicGuestLinkUserRoleBefore("LinkmicGuestLinkUserRoleBefore_Anchor", 1, 1);
        LinkmicGuestLinkUserRoleBefore_Anchor = r101;
        LinkmicGuestLinkUserRoleBefore r102 = new LinkmicGuestLinkUserRoleBefore("LinkmicGuestLinkUserRoleBefore_Guest", 2, 2);
        LinkmicGuestLinkUserRoleBefore_Guest = r102;
        f58885a = new LinkmicGuestLinkUserRoleBefore[]{r100, r101, r102};
    }

    public static LinkmicGuestLinkUserRoleBefore valueOf(String r100) {
        return (LinkmicGuestLinkUserRoleBefore) r27.a.a(LinkmicGuestLinkUserRoleBefore.class, r100);
    }

    public static LinkmicGuestLinkUserRoleBefore[] values() {
        return (LinkmicGuestLinkUserRoleBefore[]) f58885a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicGuestLinkUserRoleBefore(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
