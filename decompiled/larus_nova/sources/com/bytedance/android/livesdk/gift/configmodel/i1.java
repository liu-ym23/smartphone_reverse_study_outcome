package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/i1;", "", "", "ohrEnable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setOhrEnable", "(Z)V", "", "", "pageTypes", "Ljava/util/List;", "b", "()Ljava/util/List;", "setPageTypes", "(Ljava/util/List;)V", "sortType", "I", "d", "()I", "setSortType", "(I)V", "rowCount", "c", "setRowCount", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i1 {

    @SerializedName("ohr_enable")
    private boolean ohrEnable;

    @SerializedName("page_types")
    private List<Integer> pageTypes;

    @SerializedName("row_count")
    private int rowCount;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE)
    private int sortType;

    public i1() {
        this.pageTypes = new ArrayList();
    }

    public final boolean a() {
        return this.ohrEnable;
    }

    public final List<Integer> b() {
        return this.pageTypes;
    }

    public final int c() {
        return this.rowCount;
    }

    public final int d() {
        return this.sortType;
    }
}
