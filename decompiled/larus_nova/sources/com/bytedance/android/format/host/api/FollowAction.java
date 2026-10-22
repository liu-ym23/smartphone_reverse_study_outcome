package com.bytedance.android.format.host.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/host/api/FollowAction;", "", "", "action", "I", "getAction", "()I", "FOLLOW", "UNFOLLOW", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FollowAction extends Enum<FollowAction> {
    public static final FollowAction FOLLOW = null;
    public static final FollowAction UNFOLLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FollowAction[] f51323a = null;
    private final int action;

    static {
        FollowAction r100 = new FollowAction("FOLLOW", 0, 1);
        FOLLOW = r100;
        FollowAction r101 = new FollowAction("UNFOLLOW", 1, 0);
        UNFOLLOW = r101;
        f51323a = new FollowAction[]{r100, r101};
    }

    public static FollowAction valueOf(String r100) {
        return (FollowAction) a.a(FollowAction.class, r100);
    }

    public static FollowAction[] values() {
        return (FollowAction[]) f51323a.clone();
    }

    public final int getAction() {
        return this.action;
    }

    public FollowAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.action = r102;
    }
}
