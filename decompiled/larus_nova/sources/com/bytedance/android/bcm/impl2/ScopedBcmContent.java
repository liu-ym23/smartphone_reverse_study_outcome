package com.bytedance.android.bcm.impl2;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl2.model.BcmAllowMode;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004J.\u0010\u0010\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/bcm/impl2/ScopedBcmContent;", "Ljava/io/Serializable;", "", "scope", "", "", "params", "", "mergePageParams", "mergeUnitParams", "", ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, "Lcom/bytedance/android/bcm/impl2/model/BcmAllowMode;", "mode", "Lkotlin/Pair;", "Lcom/bytedance/android/bcm/api/model/BcmParams;", "snapshot", "copy", "", "isEmpty", "<init>", "()V", "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class ScopedBcmContent implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Map<String, ScopedBcmParams> f41884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Map<String, ScopedBcmParams> f41885b;

    public final ScopedBcmContent copy() {
        ScopedBcmContent r100 = new ScopedBcmContent();
        Iterator r101 = ((ConcurrentHashMap) r100.f41884a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r102 = (Map.Entry) r101.next();
        r100.mergePageParams((String) r102.getKey(), ((ScopedBcmParams) r102.getValue()).toMap());
        goto L4
    L6:
        Iterator r103 = ((ConcurrentHashMap) r100.f41885b).entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r100.mergeUnitParams((String) r104.getKey(), ((ScopedBcmParams) r104.getValue()).toMap());
        goto L8
    L10:
        return r100;
    }

    public final boolean isEmpty() {
        if (((ConcurrentHashMap) this.f41884a).isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentHashMap) this.f41885b).isEmpty() == false) goto L7;
        return true;
    }

    public ScopedBcmContent() {
        this.f41884a = new ConcurrentHashMap();
        this.f41885b = new ConcurrentHashMap();
    }

    public final void mergePageParams(String r100, Map<String, ? extends Object> r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) this.f41884a;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new ScopedBcmParams(r100);
        r102.put(r100, r103);
    L5:
        ((ScopedBcmParams) r103).merge(r101);
    }

    public final void mergeUnitParams(String r100, Map<String, ? extends Object> r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) this.f41885b;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = new ScopedBcmParams(r100);
        r102.put(r100, r103);
    L5:
        ((ScopedBcmParams) r103).merge(r101);
    }

    public final Pair<BcmParams, BcmParams> snapshot(List<String> r100, BcmAllowMode r101) {
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        BcmParams r102 = new BcmParams();
        BcmParams r103 = new BcmParams();
        Iterator<T> r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L16;
        String r105 = (String) r104.next();
        ScopedBcmParams r106 = (ScopedBcmParams) ((ConcurrentHashMap) this.f41884a).get(r105);
        if (r106 == null) goto L12;
        r102.merge(r106.toMap(r101));
    L12:
        ScopedBcmParams r107 = (ScopedBcmParams) ((ConcurrentHashMap) this.f41885b).get(r105);
        if (r107 == null) goto L8;
        r103.merge(r107.toMap(r101));
        goto L8
    L16:
        return TuplesKt.to(r102, r103);
    }
}
