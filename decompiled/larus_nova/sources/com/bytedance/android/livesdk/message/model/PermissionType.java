package com.bytedance.android.livesdk.message.model;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/PermissionType;", "", "", "value", "I", "getValue", "()I", CancelRetainContactInfoFunctions.All, "Fans", "FansClub", "Subscribe", "Friend", "Assign", "SendAssignGift", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PermissionType extends Enum<PermissionType> {
    public static final PermissionType All = null;
    public static final PermissionType Assign = null;
    public static final PermissionType Fans = null;
    public static final PermissionType FansClub = null;
    public static final PermissionType Friend = null;
    public static final PermissionType SendAssignGift = null;
    public static final PermissionType Subscribe = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionType[] f153609a = null;
    private final int value;

    static {
        PermissionType r100 = new PermissionType(CancelRetainContactInfoFunctions.All, 0, 0);
        All = r100;
        PermissionType r101 = new PermissionType("Fans", 1, 1);
        Fans = r101;
        PermissionType r102 = new PermissionType("FansClub", 2, 2);
        FansClub = r102;
        PermissionType r103 = new PermissionType("Subscribe", 3, 3);
        Subscribe = r103;
        PermissionType r104 = new PermissionType("Friend", 4, 4);
        Friend = r104;
        PermissionType r105 = new PermissionType("Assign", 5, 5);
        Assign = r105;
        PermissionType r106 = new PermissionType("SendAssignGift", 6, 6);
        SendAssignGift = r106;
        f153609a = new PermissionType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static PermissionType valueOf(String r100) {
        return (PermissionType) r27.a.a(PermissionType.class, r100);
    }

    public static PermissionType[] values() {
        return (PermissionType[]) f153609a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PermissionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
