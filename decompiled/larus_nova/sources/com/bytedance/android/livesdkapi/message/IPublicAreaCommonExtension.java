package com.bytedance.android.livesdkapi.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommonExtension;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "", "getNeedFilterDisplay", "()Z", "setNeedFilterDisplay", "(Z)V", "getNeedFilterDisplay$annotations", "()V", "needFilterDisplay", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IPublicAreaCommonExtension extends e<IPublicAreaCommon>, IPublicAreaCommon {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "need_filter_display")
        public static /* synthetic */ void getNeedFilterDisplay$annotations() {
        }
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon, vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon, vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "need_filter_display")
    boolean getNeedFilterDisplay();

    @FieldName(name = "need_filter_display#setter")
    void setNeedFilterDisplay(boolean r100);
}
