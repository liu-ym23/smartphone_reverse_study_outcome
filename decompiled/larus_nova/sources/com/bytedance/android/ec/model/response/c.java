package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/model/response/c;", "", "", "actionName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "actionParam", "b", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("action_name")
    private final String actionName;

    @SerializedName("action_param")
    private final String actionParam;

    public static final class a {
    }

    static {
    }

    public c() {
        this(null, null);
    }

    public final String a() {
        return this.actionName;
    }

    public final String b() {
        return this.actionParam;
    }

    public c(String r100, String r101) {
        this.actionName = r100;
        this.actionParam = r101;
    }
}
