package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/j1;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "maxLine", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setMaxLine", "(J)V", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tag", "Ljava/util/List;", "c", "()Ljava/util/List;", "setTag", "(Ljava/util/List;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class j1 {

    @SerializedName("max_line")
    private long maxLine;

    @SerializedName("name")
    private String name;

    @SerializedName("tag")
    private List<ECRitTag> tag;

    public j1() {
        this.maxLine = 1;
    }

    public final long a() {
        return this.maxLine;
    }

    public final String b() {
        return this.name;
    }

    public final List<ECRitTag> c() {
        return this.tag;
    }

    public final void d(String r100) {
        this.name = r100;
    }
}
