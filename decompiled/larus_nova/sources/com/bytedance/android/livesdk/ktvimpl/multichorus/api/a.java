package com.bytedance.android.livesdk.ktvimpl.multichorus.api;

import am3.g;
import com.bytedance.android.live.ktv.common.model.bean.d;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/multichorus/api/a;", "", "", "Lcom/bytedance/android/live/ktv/common/model/bean/d;", "songWaitingUserList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "hasMore", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "nextCursor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "totalCount", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("has_more")
    protected Boolean hasMore;

    @SerializedName("next_cursor")
    protected String nextCursor;

    @SerializedName("users")
    protected List<d> songWaitingUserList;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    protected Long totalCount;

    public a() {
        this.hasMore = Boolean.FALSE;
    }

    public final Boolean a() {
        return this.hasMore;
    }

    public final String b() {
        return this.nextCursor;
    }

    public final List<d> c() {
        return this.songWaitingUserList;
    }

    public final Long d() {
        return this.totalCount;
    }

    public a(g r100) {
        this.songWaitingUserList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.songWaitingUserList.add(new d(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.hasMore = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.nextCursor = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.totalCount = Long.valueOf(r100.j());
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.hasMore != null) goto L37;
        this.hasMore = Boolean.FALSE;
        return;
    }
}
