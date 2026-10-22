package com.bytedance.android.gamecp.business.gamedetail.base;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/ComponentCriteria;", "Ljava/io/Serializable;", "()V", "extra", "", "id", "offset", "", "Ljava/lang/Integer;", "size", "tabList", "", "toString", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentCriteria implements Serializable {

    @SerializedName("extra")
    public String extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("component_id")
    public String f53477id;

    @SerializedName("offset")
    public Integer offset;

    @SerializedName("size")
    public Integer size;

    @SerializedName("required_nodes")
    public List<String> tabList;

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public ComponentCriteria() {
        this.f53477id = "";
        this.extra = "";
        this.offset = 0;
        this.size = 0;
    }
}
