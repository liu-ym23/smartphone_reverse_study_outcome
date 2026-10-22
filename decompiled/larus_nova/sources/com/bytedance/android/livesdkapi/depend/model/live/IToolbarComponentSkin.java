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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R6\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R6\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IToolbarComponentSkin;", "Lvh7/c;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IToolbarBizSkin;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getVertical", "()Ljava/util/Map;", "getVertical$annotations", "()V", "vertical", "getLandscape", "getLandscape$annotations", "landscape", "getGeneral", "getGeneral$annotations", "general", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IToolbarComponentSkin extends c<IToolbarComponentSkin> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "general")
        public static /* synthetic */ void getGeneral$annotations() {
        }

        @FieldName(name = "landscape")
        public static /* synthetic */ void getLandscape$annotations() {
        }

        @FieldName(name = "vertical")
        public static /* synthetic */ void getVertical$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "general")
    Map<String, IToolbarBizSkin> getGeneral();

    @FieldName(name = "landscape")
    Map<String, IToolbarBizSkin> getLandscape();

    @FieldName(name = "vertical")
    Map<String, IToolbarBizSkin> getVertical();
}
