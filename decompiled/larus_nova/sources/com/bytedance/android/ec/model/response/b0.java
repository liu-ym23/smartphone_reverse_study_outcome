package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/response/b0;", "", "Lcom/bytedance/android/ec/model/response/z;", "content", "Lcom/bytedance/android/ec/model/response/z;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/z;", "setContent", "(Lcom/bytedance/android/ec/model/response/z;)V", "Lcom/bytedance/android/ec/model/response/t1;", "leftIcon", "Lcom/bytedance/android/ec/model/response/t1;", "c", "()Lcom/bytedance/android/ec/model/response/t1;", "setLeftIcon", "(Lcom/bytedance/android/ec/model/response/t1;)V", "Lcom/bytedance/android/ec/model/response/a0;", "countDown", "Lcom/bytedance/android/ec/model/response/a0;", "b", "()Lcom/bytedance/android/ec/model/response/a0;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/a0;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("content")
    private z content;

    @SerializedName("count_down")
    private a0 countDown;

    @SerializedName("left_icon")
    private t1 leftIcon;

    public b0() {
    }

    public final z a() {
        return this.content;
    }

    public final a0 b() {
        return this.countDown;
    }

    public final t1 c() {
        return this.leftIcon;
    }
}
