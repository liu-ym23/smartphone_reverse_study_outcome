package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.od;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/mv/b;", "", "", "Lcom/bytedance/android/livesdk/message/model/od;", "officialMVList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b implements vh7.h {

    @SerializedName("mv_list")
    protected List<od> officialMVList;

    public b() {
        this.officialMVList = null;
    }

    public final List<od> a() {
        return this.officialMVList;
    }

    public b(am3.g r100) {
        this.officialMVList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.officialMVList.add(new od(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
        if (this.officialMVList.isEmpty() == false) goto L19;
        this.officialMVList = null;
        return;
    }
}
