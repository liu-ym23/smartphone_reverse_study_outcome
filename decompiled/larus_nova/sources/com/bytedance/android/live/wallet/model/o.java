package com.bytedance.android.live.wallet.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class o {

    @SerializedName("antispam_data")
    a antispamData;

    @SerializedName("cert_data")
    com.bytedance.android.live.base.model.verify.c certData;

    @SerializedName("mobile_data")
    b mobileData;

    public static class a {

        @SerializedName("need_zhima_verify")
        boolean needZhimaVerify;

        @SerializedName("prompts")
        String prompts;

        public a() {
        }

        public final String a() {
            return this.prompts;
        }

        public final boolean b() {
            return this.needZhimaVerify;
        }
    }

    public static class b {

        @SerializedName("enterprise_user_type")
        int enterpriseUserType;

        @SerializedName("is_verified")
        boolean isVerified;

        @SerializedName("mobile")
        String mobile;

        public b() {
        }

        public final boolean c() {
            int r100 = this.enterpriseUserType;
            if (r100 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r100 == 3) goto L8;
            return false;
        }

        public final int a() {
            return this.enterpriseUserType;
        }

        public final boolean b() {
            return this.isVerified;
        }
    }

    public o() {
    }

    public final a a() {
        return this.antispamData;
    }

    public final com.bytedance.android.live.base.model.verify.c b() {
        return this.certData;
    }

    public final b c() {
        return this.mobileData;
    }
}
