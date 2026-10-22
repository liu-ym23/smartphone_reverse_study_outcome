package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006RB\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\b\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPushData;", "Lvh7/c;", "", "getPushStreamLevel", "()I", "setPushStreamLevel", "(I)V", "getPushStreamLevel$annotations", "()V", "pushStreamLevel", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IResolutionParams;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getResolutionParams", "()Ljava/util/Map;", "setResolutionParams", "(Ljava/util/Map;)V", "getResolutionParams$annotations", "resolutionParams", "", "getPreSchedule", "()Z", "setPreSchedule", "(Z)V", "getPreSchedule$annotations", "preSchedule", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPushData extends c<IPushData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "pre_schedule")
        public static /* synthetic */ void getPreSchedule$annotations() {
        }

        @FieldName(name = "push_stream_level")
        public static /* synthetic */ void getPushStreamLevel$annotations() {
        }

        @FieldName(name = "resolution_params")
        public static /* synthetic */ void getResolutionParams$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "pre_schedule")
    boolean getPreSchedule();

    @FieldName(name = "push_stream_level")
    int getPushStreamLevel();

    @FieldName(name = "resolution_params")
    Map<String, IResolutionParams> getResolutionParams();

    @FieldName(name = "pre_schedule#setter")
    void setPreSchedule(boolean r100);

    @FieldName(name = "push_stream_level#setter")
    void setPushStreamLevel(int r100);

    @FieldName(name = "resolution_params#setter")
    void setResolutionParams(Map<String, ? extends IResolutionParams> r100);
}
