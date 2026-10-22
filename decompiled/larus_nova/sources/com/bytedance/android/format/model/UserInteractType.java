package com.bytedance.android.format.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/UserInteractType;", "", "", "value", "I", "getValue", "()I", "UserInteractType_Like", "UserInteractType_MultiLike", "UserInteractType_Share", "UserInteractType_Stay", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UserInteractType extends Enum<UserInteractType> {
    public static final UserInteractType UserInteractType_Like = null;
    public static final UserInteractType UserInteractType_MultiLike = null;
    public static final UserInteractType UserInteractType_Share = null;
    public static final UserInteractType UserInteractType_Stay = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserInteractType[] f51344a = null;
    private final int value;

    static {
        UserInteractType r100 = new UserInteractType("UserInteractType_Like", 0, 1);
        UserInteractType_Like = r100;
        UserInteractType r101 = new UserInteractType("UserInteractType_MultiLike", 1, 2);
        UserInteractType_MultiLike = r101;
        UserInteractType r102 = new UserInteractType("UserInteractType_Share", 2, 3);
        UserInteractType_Share = r102;
        UserInteractType r103 = new UserInteractType("UserInteractType_Stay", 3, 4);
        UserInteractType_Stay = r103;
        f51344a = new UserInteractType[]{r100, r101, r102, r103};
    }

    public static UserInteractType valueOf(String r100) {
        return (UserInteractType) r27.a.a(UserInteractType.class, r100);
    }

    public static UserInteractType[] values() {
        return (UserInteractType[]) f51344a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UserInteractType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
