package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/CommonGirdleStructV2Slogan;", "Ljava/io/Serializable;", "", "type", "Ljava/lang/Long;", "getType", "()Ljava/lang/Long;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "pic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CommonGirdleStructV2Slogan implements Serializable {
    public static final a Companion = null;
    public static final long TYPE_PIC = 2;
    public static final long TYPE_TEXT = 1;

    /* JADX INFO: renamed from: pic, reason: collision with root package name */
    @SerializedName("pic")
    private final ECUrlModel f47930pic;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final Long type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommonGirdleStructV2Slogan() {
    }

    public final ECUrlModel getPic() {
        return this.f47930pic;
    }

    public final String getText() {
        return this.text;
    }

    public final Long getType() {
        return this.type;
    }
}
