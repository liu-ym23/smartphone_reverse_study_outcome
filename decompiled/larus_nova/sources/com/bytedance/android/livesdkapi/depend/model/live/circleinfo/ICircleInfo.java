package com.bytedance.android.livesdkapi.depend.model.live.circleinfo;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;", "Lvh7/c;", "", "getCircleId", "()J", "setCircleId", "(J)V", "getCircleId$annotations", "()V", "circleId", "", "getCircleName", "()Ljava/lang/String;", "setCircleName", "(Ljava/lang/String;)V", "getCircleName$annotations", "circleName", "Lpy/k;", "getCircleCover", "()Lpy/k;", "setCircleCover", "(Lpy/k;)V", "getCircleCover$annotations", "circleCover", "getCircleDesc", "setCircleDesc", "getCircleDesc$annotations", "circleDesc", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ICircleInfo extends c<ICircleInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "cover_img")
        public static /* synthetic */ void getCircleCover$annotations() {
        }

        @FieldName(name = "description")
        public static /* synthetic */ void getCircleDesc$annotations() {
        }

        @FieldName(name = "id")
        public static /* synthetic */ void getCircleId$annotations() {
        }

        @FieldName(name = "name")
        public static /* synthetic */ void getCircleName$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "cover_img")
    k getCircleCover();

    @FieldName(name = "description")
    String getCircleDesc();

    @FieldName(name = "id")
    long getCircleId();

    @FieldName(name = "name")
    String getCircleName();

    @FieldName(name = "cover_img#setter")
    void setCircleCover(k r100);

    @FieldName(name = "description#setter")
    void setCircleDesc(String r100);

    @FieldName(name = "id#setter")
    void setCircleId(long r100);

    @FieldName(name = "name#setter")
    void setCircleName(String r100);
}
