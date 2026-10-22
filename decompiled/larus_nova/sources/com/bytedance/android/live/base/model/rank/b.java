package com.bytedance.android.live.base.model.rank;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.ranklist.RanklistWebcastHotResponse.ResponseData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/rank/b;", "", "", "Lcom/bytedance/android/live/base/model/rank/a;", "ranks", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setRanks", "(Ljava/util/List;)V", "", "topImageUrl", "Ljava/lang/String;", "getTopImageUrl", "()Ljava/lang/String;", "setTopImageUrl", "(Ljava/lang/String;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("ranks")
    protected List<a> ranks;

    @SerializedName("top_image_url")
    protected String topImageUrl;

    public b() {
    }

    public b(g r100) {
        this.ranks = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.ranks.add(new a(r100));
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.topImageUrl = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final List<a> a() {
        return this.ranks;
    }
}
