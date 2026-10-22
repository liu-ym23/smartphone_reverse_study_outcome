package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/ISandwichBorderInfo;", "Lvh7/c;", "", "getTop", "()D", "getTop$annotations", "()V", "top", "getBottom", "getBottom$annotations", "bottom", "getLeft", "getLeft$annotations", "left", "getRight", "getRight$annotations", "right", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ISandwichBorderInfo extends c<ISandwichBorderInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "bottom")
        public static /* synthetic */ void getBottom$annotations() {
        }

        @FieldName(name = "left")
        public static /* synthetic */ void getLeft$annotations() {
        }

        @FieldName(name = "right")
        public static /* synthetic */ void getRight$annotations() {
        }

        @FieldName(name = "top")
        public static /* synthetic */ void getTop$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "bottom")
    double getBottom();

    @FieldName(name = "left")
    double getLeft();

    @FieldName(name = "right")
    double getRight();

    @FieldName(name = "top")
    double getTop();
}
