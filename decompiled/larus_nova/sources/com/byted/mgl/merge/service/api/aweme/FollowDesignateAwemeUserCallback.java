package com.byted.mgl.merge.service.api.aweme;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/FollowDesignateAwemeUserCallback;", "", "onFailure", "", "errCode", "", "onSuccess", "Companion", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface FollowDesignateAwemeUserCallback {
    public static final int CODE_FOLLOW_FAIL = 3;
    public static final int CODE_UID_INVALID = 1;
    public static final int CODE_USER_QUERY_FAIL = 2;
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/FollowDesignateAwemeUserCallback$Companion;", "", "()V", "CODE_FOLLOW_FAIL", "", "CODE_UID_INVALID", "CODE_USER_QUERY_FAIL", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int CODE_FOLLOW_FAIL = 3;
        public static final int CODE_UID_INVALID = 1;
        public static final int CODE_USER_QUERY_FAIL = 2;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onFailure(int r100);

    void onSuccess();
}
