package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IDecorationDetail;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomDecoration;", "getTextDecoration", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomDecoration;", "getTextDecoration$annotations", "()V", "textDecoration", "getImageDecoration", "getImageDecoration$annotations", "imageDecoration", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IDecorationDetail extends c<IDecorationDetail> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "image_decoration")
        public static /* synthetic */ void getImageDecoration$annotations() {
        }

        @FieldName(name = "text_decoration")
        public static /* synthetic */ void getTextDecoration$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "image_decoration")
    IRoomDecoration getImageDecoration();

    @FieldName(name = "text_decoration")
    IRoomDecoration getTextDecoration();
}
