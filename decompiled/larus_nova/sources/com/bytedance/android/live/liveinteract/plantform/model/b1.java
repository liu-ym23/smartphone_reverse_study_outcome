package com.bytedance.android.live.liveinteract.plantform.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/b1;", "", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/c1;", "applyList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setApplyList", "(Ljava/util/List;)V", "", "hasMore", "Z", "c", "()Z", "setHasMore", "(Z)V", "", "totalCount", "I", ce.f26391f, "()I", "setTotalCount", "(I)V", "", "nextCursor", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setNextCursor", "(Ljava/lang/String;)V", "currentWaitingUser", "Lcom/bytedance/android/live/liveinteract/plantform/model/c1;", "b", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c1;", "setCurrentWaitingUser", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c1;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "title", "Lcom/bytedance/android/live/base/model/message/a5;", "f", "()Lcom/bytedance/android/live/base/model/message/a5;", com.alipay.sdk.m.x.d.f25925o, "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", TriggerTiming.NOW, "J", "e", "()J", "setNow", "(J)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b1 {

    @SerializedName("users")
    private List<c1> applyList;

    @SerializedName("current")
    private c1 currentWaitingUser;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("next_cursor")
    private String nextCursor;

    @SerializedName(TriggerTiming.NOW)
    private long now;

    @SerializedName("title")
    private a5 title;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    private int totalCount;

    public b1() {
        this.nextCursor = "";
    }

    public final List<c1> a() {
        return this.applyList;
    }

    public final c1 b() {
        return this.currentWaitingUser;
    }

    public final boolean c() {
        return this.hasMore;
    }

    public final String d() {
        return this.nextCursor;
    }

    public final long e() {
        return this.now;
    }

    public final a5 f() {
        return this.title;
    }

    public final int g() {
        return this.totalCount;
    }
}
