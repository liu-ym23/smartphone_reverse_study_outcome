package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/o5;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser$annotations", "()V", "user", "", "getStartTime", "()Ljava/lang/Long;", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "getEndTime", "getEndTime$annotations", "endTime", "getCount", "getCount$annotations", "count", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o5 extends vh7.c<o5> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "count")
    Long getCount();

    @FieldName(name = "end_time")
    Long getEndTime();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    Long getStartTime();

    @FieldName(name = "user")
    IBaseUser getUser();
}
