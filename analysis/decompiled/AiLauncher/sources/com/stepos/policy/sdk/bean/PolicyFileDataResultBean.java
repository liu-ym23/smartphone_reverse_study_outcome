package com.stepos.policy.sdk.bean;

import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyFileDataResultBean;", "", "()V", QueryAlgorithmBundle.KEY_CATEGORY, "", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", Parameters.UPLOAD_REQUEST_PARAM_MD5, "getMd5", "setMd5", "policyUid", "getPolicyUid", "setPolicyUid", "version", "", "getVersion", "()J", "setVersion", "(J)V", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyFileDataResultBean {
    private long version;
    private String policyUid = "";
    private String category = "";
    private String md5 = "";

    public final String getCategory() {
        return this.category;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getPolicyUid() {
        return this.policyUid;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setCategory(String str) {
        p.i(str, "<set-?>");
        this.category = str;
    }

    public final void setMd5(String str) {
        p.i(str, "<set-?>");
        this.md5 = str;
    }

    public final void setPolicyUid(String str) {
        p.i(str, "<set-?>");
        this.policyUid = str;
    }

    public final void setVersion(long j10) {
        this.version = j10;
    }
}
