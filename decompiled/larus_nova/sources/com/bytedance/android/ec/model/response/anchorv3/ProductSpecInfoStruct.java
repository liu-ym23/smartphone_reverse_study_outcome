package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087D¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012RB\u0010\u0015\u001a.\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0016j\u0016\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u0001`\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ProductSpecInfoStruct;", "Ljava/io/Serializable;", "()V", "num", "", "getNum", "()Ljava/lang/Long;", "Ljava/lang/Long;", "specList", "", "Lcom/bytedance/android/ec/model/response/anchorv3/SpecDetail;", "getSpecList", "()Ljava/util/List;", "specSeqs", "", "getSpecSeqs", "specTitle", "getSpecTitle", "()Ljava/lang/String;", "totalSpec", "getTotalSpec", "totalSpecList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getTotalSpecList", "()Ljava/util/HashMap;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductSpecInfoStruct implements Serializable {

    @SerializedName("num")
    private final Long num;

    @SerializedName("spec_list")
    private final List<SpecDetail> specList;

    @SerializedName("spec_seqs")
    private final List<String> specSeqs;

    @SerializedName("spec_title")
    private final String specTitle;

    @SerializedName("total_spec")
    private final String totalSpec;

    @SerializedName("total_spec_list")
    private final HashMap<String, List<SpecDetail>> totalSpecList;

    public ProductSpecInfoStruct() {
        this.num = 0L;
    }

    public final Long getNum() {
        return this.num;
    }

    public final List<SpecDetail> getSpecList() {
        return this.specList;
    }

    public final List<String> getSpecSeqs() {
        return this.specSeqs;
    }

    public final String getSpecTitle() {
        return this.specTitle;
    }

    public final String getTotalSpec() {
        return this.totalSpec;
    }

    public final HashMap<String, List<SpecDetail>> getTotalSpecList() {
        return this.totalSpecList;
    }
}
