package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/n;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/a;", "accounts", "Ljava/util/List;", "getAccounts", "()Ljava/util/List;", "setAccounts", "(Ljava/util/List;)V", "", "currentAccount", "Ljava/lang/String;", "getCurrentAccount", "()Ljava/lang/String;", "setCurrentAccount", "(Ljava/lang/String;)V", "", "fansNumThreshold", "J", "getFansNumThreshold", "()J", "setFansNumThreshold", "(J)V", "subTitle", "getSubTitle", "setSubTitle", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("accounts")
    private List<a> accounts;

    @SerializedName("current_account")
    private String currentAccount;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("fans_num_threshold")
    private long fansNumThreshold;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    public n() {
        this.currentAccount = "";
        this.subTitle = "";
        this.desc = "";
    }
}
