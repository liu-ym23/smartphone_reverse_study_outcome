package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R2\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0006\u001a\u0004\b \u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IHeadBubble;", "Lvh7/c;", "", "getType", "()I", "getType$annotations", "()V", "type", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRollTips", "()Ljava/util/List;", "getRollTips$annotations", "rollTips", "Lpy/k;", "getIcon", "()Lpy/k;", "getIcon$annotations", "icon", "", "getRollAfterMs", "()J", "getRollAfterMs$annotations", "rollAfterMs", "getCouponMateId", "getCouponMateId$annotations", "couponMateId", "getEtType", "()Ljava/lang/String;", "getEtType$annotations", "etType", "getExtra", "getExtra$annotations", "extra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IHeadBubble extends c<IHeadBubble> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "coupon_mate_id")
        public static /* synthetic */ void getCouponMateId$annotations() {
        }

        @FieldName(name = "et_type")
        public static /* synthetic */ void getEtType$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "roll_after_ms")
        public static /* synthetic */ void getRollAfterMs$annotations() {
        }

        @FieldName(name = "roll_tips")
        public static /* synthetic */ void getRollTips$annotations() {
        }

        @FieldName(name = "type")
        public static /* synthetic */ void getType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "coupon_mate_id")
    long getCouponMateId();

    @FieldName(name = "et_type")
    String getEtType();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "roll_after_ms")
    long getRollAfterMs();

    @FieldName(name = "roll_tips")
    List<String> getRollTips();

    @FieldName(name = "type")
    int getType();
}
