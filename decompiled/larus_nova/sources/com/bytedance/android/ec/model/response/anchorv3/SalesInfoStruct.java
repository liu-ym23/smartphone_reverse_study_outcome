package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/SalesInfoStruct;", "Ljava/io/Serializable;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SalesInfoStruct implements Serializable {
    public static final a Companion = null;
    public static final String REPEAT = "repeat";
    public static final int REPEAT_TYPE = 1;
    public static final String SALES = "sales";
    public static final int SALES_TYPE = 0;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final Integer type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SalesInfoStruct() {
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getType() {
        return this.type;
    }
}
