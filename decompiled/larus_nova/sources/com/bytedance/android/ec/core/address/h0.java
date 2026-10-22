package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/address/h0;", "", "", "statPeriod", "I", "e", "()I", "setStatPeriod", "(I)V", "maxTimes", "d", "setMaxTimes", "", "Lcom/bytedance/android/ec/core/address/j0;", "_itemList", "Ljava/util/List;", "checkDistance", "b", "setCheckDistance", "", "disableCheck", "Z", "c", "()Z", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName("item_list")
    private List<j0> _itemList;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, j0> f43691a;

    @SerializedName("check_distance")
    private int checkDistance;

    @SerializedName("disable_check")
    private final boolean disableCheck;

    @SerializedName("max_times")
    private int maxTimes;

    @SerializedName("stat_period")
    private int statPeriod;

    public h0() {
        this(null);
    }

    public final Map<String, j0> a() {
        if (this.f43691a != null) goto L14;
        LinkedHashMap r100 = new LinkedHashMap();
        List<j0> r101 = this._itemList;
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        j0 r103 = (j0) r102.next();
        if (r103.a() == null) goto L8;
        r100.put(r103.a(), r103);
    L12:
        Unit r104 = Unit.INSTANCE;
        this.f43691a = r100;
    L14:
        return this.f43691a;
    }

    public final int b() {
        return this.checkDistance;
    }

    public final boolean c() {
        return this.disableCheck;
    }

    public final int d() {
        return this.maxTimes;
    }

    public final int e() {
        return this.statPeriod;
    }

    public h0(Object r100) {
        this.statPeriod = 1440;
        this.maxTimes = 3;
        this._itemList = null;
        this.checkDistance = 500;
        this.disableCheck = false;
    }
}
