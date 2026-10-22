package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R6\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTabFrame;", "Lvh7/c;", "", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "getBackgroundColor$annotations", "()V", "backgroundColor", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTab;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTabs", "()Ljava/util/List;", "setTabs", "(Ljava/util/List;)V", "getTabs$annotations", "tabs", "getColor", "setColor", "getColor$annotations", "color", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IMatchTabFrame extends c<IMatchTabFrame> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "background_color")
        public static /* synthetic */ void getBackgroundColor$annotations() {
        }

        @FieldName(name = "color")
        public static /* synthetic */ void getColor$annotations() {
        }

        @FieldName(name = "tabs")
        public static /* synthetic */ void getTabs$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "background_color")
    String getBackgroundColor();

    @FieldName(name = "color")
    String getColor();

    @FieldName(name = "tabs")
    List<IMatchTab> getTabs();

    @FieldName(name = "background_color#setter")
    void setBackgroundColor(String r100);

    @FieldName(name = "color#setter")
    void setColor(String r100);

    @FieldName(name = "tabs#setter")
    void setTabs(List<? extends IMatchTab> r100);
}
