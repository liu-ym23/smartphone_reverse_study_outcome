package com.bytedance.android.shopping.api.ultimate;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B7\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyOrderExParams;", "Ljava/io/Serializable;", "queryParams", "", "", "megaObjectJsonString", "cjInfo", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getCjInfo", "()Ljava/lang/String;", "getMegaObjectJsonString", "getQueryParams", "()Ljava/util/Map;", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class UltimateBuyOrderExParams implements Serializable {

    @SerializedName(a.KEY_CJ_INFO)
    private final String cjInfo;

    @SerializedName("mega_object")
    private final String megaObjectJsonString;

    @SerializedName("query_params")
    private final Map<String, String> queryParams;

    public UltimateBuyOrderExParams() {
        this(null, null, null, 7, null);
    }

    public final String getCjInfo() {
        return this.cjInfo;
    }

    public final String getMegaObjectJsonString() {
        return this.megaObjectJsonString;
    }

    public final Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    public UltimateBuyOrderExParams(Map<String, String> r100, String r101, String r102) {
        this.queryParams = r100;
        this.megaObjectJsonString = r101;
        this.cjInfo = r102;
    }

    public /* synthetic */ UltimateBuyOrderExParams(Map r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
