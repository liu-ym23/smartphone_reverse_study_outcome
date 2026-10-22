package com.bytedance.android.ecom.slice.ext.template.gecko;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ecom/slice/ext/template/gecko/j;", "", "", "name", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "url", "c", "", "num", "I", "b", "()I", "gecko_template_store_release"}, k = 1, mv = {1, 4, 0})
public final class j {

    @SerializedName("name")
    private final String name;

    @SerializedName("num")
    private final int num;

    @SerializedName("url")
    private final String url;

    public j() {
        String r100 = null;
        this(r100, r100, 7, 0);
    }

    public final String a() {
        return this.name;
    }

    public final int b() {
        return this.num;
    }

    public final String c() {
        return this.url;
    }

    public j(String r100, String r101, int r102) {
        this.name = r100;
        this.url = r101;
        this.num = r102;
    }

    public /* synthetic */ j(String r100, String r101, int r102, int r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, 0);
    }
}
