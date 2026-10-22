package com.bytedance.android.live.base.model.message.guestlink;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/LinkmicGuestLinkUserRole;", "", "", "value", "I", "getValue", "()I", "LinkmicGuestLinkUserRole_Unknown", "LinkmicGuestLinkUserRole_Inviter", "LinkmicGuestLinkUserRole_Invitee", "LinkmicGuestLinkUserRole_MatchMaking", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicGuestLinkUserRole extends Enum<LinkmicGuestLinkUserRole> {
    public static final LinkmicGuestLinkUserRole LinkmicGuestLinkUserRole_Invitee = null;
    public static final LinkmicGuestLinkUserRole LinkmicGuestLinkUserRole_Inviter = null;
    public static final LinkmicGuestLinkUserRole LinkmicGuestLinkUserRole_MatchMaking = null;
    public static final LinkmicGuestLinkUserRole LinkmicGuestLinkUserRole_Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicGuestLinkUserRole[] f58884a = null;
    private final int value;

    static {
        LinkmicGuestLinkUserRole r100 = new LinkmicGuestLinkUserRole("LinkmicGuestLinkUserRole_Unknown", 0, 0);
        LinkmicGuestLinkUserRole_Unknown = r100;
        LinkmicGuestLinkUserRole r101 = new LinkmicGuestLinkUserRole("LinkmicGuestLinkUserRole_Inviter", 1, 1);
        LinkmicGuestLinkUserRole_Inviter = r101;
        LinkmicGuestLinkUserRole r102 = new LinkmicGuestLinkUserRole("LinkmicGuestLinkUserRole_Invitee", 2, 2);
        LinkmicGuestLinkUserRole_Invitee = r102;
        LinkmicGuestLinkUserRole r103 = new LinkmicGuestLinkUserRole("LinkmicGuestLinkUserRole_MatchMaking", 3, 3);
        LinkmicGuestLinkUserRole_MatchMaking = r103;
        f58884a = new LinkmicGuestLinkUserRole[]{r100, r101, r102, r103};
    }

    public static LinkmicGuestLinkUserRole valueOf(String r100) {
        return (LinkmicGuestLinkUserRole) r27.a.a(LinkmicGuestLinkUserRole.class, r100);
    }

    public static LinkmicGuestLinkUserRole[] values() {
        return (LinkmicGuestLinkUserRole[]) f58884a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LinkmicGuestLinkUserRole(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
