package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.livesdk.message.model.od;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/b;", "", "", "Lcom/bytedance/android/livesdk/message/model/od;", "mvList", "Ljava/util/List;", "d", "()Ljava/util/List;", "", "hasMore", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "minCursor", "J", "c", "()J", "maxCursor", "b", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b implements vh7.h {

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("max_cursor")
    protected long maxCursor;

    @SerializedName("min_cursor")
    protected long minCursor;

    @SerializedName("mv_list")
    protected List<od> mvList;

    public b() {
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final long b() {
        return this.maxCursor;
    }

    public final long c() {
        return this.minCursor;
    }

    public final List<od> d() {
        return this.mvList;
    }

    public b(am3.g r100) {
        this.mvList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.mvList.add(new od(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.hasMore = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.minCursor = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.maxCursor = r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
