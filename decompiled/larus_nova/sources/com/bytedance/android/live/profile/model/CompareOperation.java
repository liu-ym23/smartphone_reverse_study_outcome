package com.bytedance.android.live.profile.model;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profile/model/CompareOperation;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "Nothing", "Create", UserChangedCallback.CHANGE_TYPE_UPDATE, "Remove", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CompareOperation extends Enum<CompareOperation> {
    public static final CompareOperation Create = null;
    public static final CompareOperation Nothing = null;
    public static final CompareOperation Remove = null;
    public static final CompareOperation Update = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CompareOperation[] f86055a = null;
    private final String desc;

    static {
        CompareOperation r100 = new CompareOperation("Nothing", 0, "Nothing");
        Nothing = r100;
        CompareOperation r101 = new CompareOperation("Create", 1, "Create");
        Create = r101;
        CompareOperation r102 = new CompareOperation(UserChangedCallback.CHANGE_TYPE_UPDATE, 2, UserChangedCallback.CHANGE_TYPE_UPDATE);
        Update = r102;
        CompareOperation r103 = new CompareOperation("Remove", 3, "Remove");
        Remove = r103;
        f86055a = new CompareOperation[]{r100, r101, r102, r103};
    }

    public static CompareOperation valueOf(String r100) {
        return (CompareOperation) r27.a.a(CompareOperation.class, r100);
    }

    public static CompareOperation[] values() {
        return (CompareOperation[]) f86055a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public CompareOperation(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
