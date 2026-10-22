package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class k0 {

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("ranks")
    private List<a> ranks;

    public static class a {

        @SerializedName("anchor")
        private User anchor;

        @SerializedName("fansclub")
        private C1619a fansclub;

        @SerializedName("rank")
        private int rank;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.model.k0$a$a, reason: collision with other inner class name */
        public static class C1619a {

            @SerializedName("auto_renewal")
            private int autoRenewal;

            @SerializedName(IAllianceService.CONTENT_TYPE_BADGE)
            private C1620a badge;

            @SerializedName("intimacy")
            private int intimacy;

            @SerializedName("level")
            private int level;

            @SerializedName("status")
            private int status;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.model.k0$a$a$a, reason: collision with other inner class name */
            public static class C1620a {

                @SerializedName("icon")
                private ImageModel imageModel;

                @SerializedName("title")
                private String title;

                public C1620a() {
                }
            }

            public C1619a() {
            }
        }

        public a() {
        }
    }

    public k0() {
    }
}
