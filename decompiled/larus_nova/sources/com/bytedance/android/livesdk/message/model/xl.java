package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/xl;", "", "", "mTaskId", "I", "mTaskType", "mRewardType", "", "rewardAmount", "J", "getRewardAmount", "()J", "setRewardAmount", "(J)V", "", "mTitle", "Ljava/lang/String;", "mSubTitle", "mIconUrl", "mBgPicUrl", AppConstants.BUNDLE_TIP, "getTip", "()Ljava/lang/String;", "setTip", "(Ljava/lang/String;)V", "finishSound", "getFinishSound", "setFinishSound", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class xl implements vh7.h {

    @SerializedName("finish_sound")
    protected String finishSound;

    @SerializedName("bg_pic_url")
    public String mBgPicUrl;

    @SerializedName("icon_url")
    public String mIconUrl;

    @SerializedName("reward_type")
    public int mRewardType;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public String mSubTitle;

    @SerializedName("task_id")
    public int mTaskId;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    public int mTaskType;

    @SerializedName("title")
    public String mTitle;

    @SerializedName("reward_amount")
    protected long rewardAmount;

    @SerializedName(AppConstants.BUNDLE_TIP)
    protected String tip;

    public static final class a {
    }

    static {
    }

    public xl() {
        this.tip = "";
        this.finishSound = "";
    }

    public xl(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.finishSound = am3.h.c(r100);
        goto L3
    L8:
        this.tip = am3.h.c(r100);
        goto L3
    L9:
        this.rewardAmount = r100.i();
        goto L3
    L10:
        this.mBgPicUrl = am3.h.c(r100);
        goto L3
    L11:
        this.mIconUrl = am3.h.c(r100);
        goto L3
    L12:
        this.mSubTitle = am3.h.c(r100);
        goto L3
    L13:
        this.mTitle = am3.h.c(r100);
        goto L3
    L14:
        this.mRewardType = r100.i();
        goto L3
    L15:
        this.mTaskType = r100.i();
        goto L3
    L16:
        this.mTaskId = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.tip != null) goto L21;
        this.tip = "";
    L21:
        if (this.finishSound != null) goto L48;
        this.finishSound = "";
        return;
    }
}
