package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/address/g0;", "", "", "", "cacheFirstList", "Ljava/util/List;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<String> f43690a;

    @SerializedName("cache_first_btm_list")
    private final List<String> cacheFirstList;

    public g0() {
        this(null);
    }

    public final Set<String> a() {
        if (this.f43690a != null) goto L12;
        LinkedHashSet r100 = new LinkedHashSet();
        List<String> r101 = this.cacheFirstList;
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r100.add((String) r102.next());
    L10:
        Unit r103 = Unit.INSTANCE;
        this.f43690a = r100;
    L12:
        return this.f43690a;
    }

    public g0(Object r100) {
        this.cacheFirstList = null;
    }
}
