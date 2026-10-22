package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IOptions;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getDefaultQuality", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "setDefaultQuality", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;)V", "getDefaultQuality$annotations", "()V", "defaultQuality", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getQualityList", "()Ljava/util/List;", "getQualityList$annotations", "qualityList", "", "getVPassDefault", "()Z", "setVPassDefault", "(Z)V", "getVPassDefault$annotations", "vPassDefault", "", "getQualityStrategy", "()Ljava/lang/String;", "setQualityStrategy", "(Ljava/lang/String;)V", "getQualityStrategy$annotations", "qualityStrategy", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IOptions extends c<IOptions> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "default_quality")
        public static /* synthetic */ void getDefaultQuality$annotations() {
        }

        @FieldName(name = "qualities")
        public static /* synthetic */ void getQualityList$annotations() {
        }

        @FieldName(name = "quality_strategy")
        public static /* synthetic */ void getQualityStrategy$annotations() {
        }

        @FieldName(name = "vpass_default")
        public static /* synthetic */ void getVPassDefault$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "default_quality")
    IQuality getDefaultQuality();

    @FieldName(name = "qualities")
    List<IQuality> getQualityList();

    @FieldName(name = "quality_strategy")
    String getQualityStrategy();

    @FieldName(name = "vpass_default")
    boolean getVPassDefault();

    @FieldName(name = "default_quality#setter")
    void setDefaultQuality(IQuality r100);

    @FieldName(name = "quality_strategy#setter")
    void setQualityStrategy(String r100);

    @FieldName(name = "vpass_default#setter")
    void setVPassDefault(boolean r100);
}
