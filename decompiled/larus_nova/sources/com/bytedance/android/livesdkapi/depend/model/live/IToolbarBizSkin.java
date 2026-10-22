package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.e;
import py.k;
import vh7.c;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IToolbarBizSkin;", "Lvh7/c;", "Lpy/e;", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "()V", "icon", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IToolbarBizSkin extends c<IToolbarBizSkin>, e {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "icon")
    k getIcon();

    /* synthetic */ k getSkinImg();
}
