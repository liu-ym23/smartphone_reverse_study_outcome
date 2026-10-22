package com.bytedance.android.live.user.api.permission;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/user/api/permission/PermissionChangeType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "ADD", "DELETE", "liveuser-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PermissionChangeType extends Enum<PermissionChangeType> {
    public static final PermissionChangeType ADD = null;
    public static final PermissionChangeType DELETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionChangeType[] f102511a = null;
    private final String desc;
    private final String type;

    static {
        PermissionChangeType r100 = new PermissionChangeType("ADD", 0, "add", "新增");
        ADD = r100;
        PermissionChangeType r101 = new PermissionChangeType("DELETE", 1, "delete", "删除");
        DELETE = r101;
        f102511a = new PermissionChangeType[]{r100, r101};
    }

    public static PermissionChangeType valueOf(String r100) {
        return (PermissionChangeType) a.a(PermissionChangeType.class, r100);
    }

    public static PermissionChangeType[] values() {
        return (PermissionChangeType[]) f102511a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getType() {
        return this.type;
    }

    public PermissionChangeType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.desc = r103;
    }
}
