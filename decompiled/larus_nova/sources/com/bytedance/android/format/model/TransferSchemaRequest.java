package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R:\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/format/model/TransferSchemaRequest;", "Ljava/io/Serializable;", "()V", "extra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExtra", "()Ljava/util/HashMap;", "setExtra", "(Ljava/util/HashMap;)V", "oldSchema", "getOldSchema", "()Ljava/lang/String;", "setOldSchema", "(Ljava/lang/String;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransferSchemaRequest implements Serializable {

    @SerializedName("extra")
    private HashMap<String, String> extra;

    @SerializedName("old_schema")
    private String oldSchema;

    public TransferSchemaRequest() {
        this.oldSchema = "";
        this.extra = new HashMap();
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final String getOldSchema() {
        return this.oldSchema;
    }

    public final void setExtra(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void setOldSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.oldSchema = r100;
    }
}
