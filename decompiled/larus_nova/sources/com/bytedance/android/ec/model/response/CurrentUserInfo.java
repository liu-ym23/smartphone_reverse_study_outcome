package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/CurrentUserInfo;", "Ljava/io/Serializable;", "", "userName", "Ljava/lang/String;", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "userPic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getUserPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setUserPic", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class CurrentUserInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("user_id")
    private long userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private String userName;

    @SerializedName("user_pic")
    private ECUrlModel userPic;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CurrentUserInfo() {
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final ECUrlModel getUserPic() {
        return this.userPic;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }

    public final void setUserName(String r100) {
        this.userName = r100;
    }

    public final void setUserPic(ECUrlModel r100) {
        this.userPic = r100;
    }
}
