package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/format/model/w;", "", "", "icon", "Ljava/lang/String;", "getIcon", "()Ljava/lang/String;", "headerText", "getHeaderText", "", "Lcom/bytedance/android/format/model/s;", "entitys", "Ljava/util/List;", "getEntitys", "()Ljava/util/List;", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("entitys")
    private final List<s> entitys;

    @SerializedName("text")
    private final String headerText;

    @SerializedName("icon")
    private final String icon;

    public w() {
    }
}
