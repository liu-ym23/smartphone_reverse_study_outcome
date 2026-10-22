package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSFreeViewRange;", "Lvh7/c;", "", "getStartTime", "()J", "setStartTime", "(J)V", "getStartTime$annotations", "()V", DyPayConstant.KEY_START_TIME, "getEndTime", "setEndTime", "getEndTime$annotations", "endTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVSFreeViewRange extends c<IVSFreeViewRange> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "end_time")
        public static /* synthetic */ void getEndTime$annotations() {
        }

        @FieldName(name = ILoadStallMonitor.START_TIME)
        public static /* synthetic */ void getStartTime$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "end_time")
    long getEndTime();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();

    @FieldName(name = "end_time#setter")
    void setEndTime(long r100);

    @FieldName(name = "start_time#setter")
    void setStartTime(long r100);
}
