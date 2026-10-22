package com.bytedance.android.shopping.anchorv3.dualstream;

import com.bytedance.android.shopping.anchorv3.dualstream.model.DualStreamState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AnchorV3DualStreamActivity$initSubscribe$2 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new AnchorV3DualStreamActivity$initSubscribe$2();
    }

    public AnchorV3DualStreamActivity$initSubscribe$2() {
        super(DualStreamState.class, "surveyV2", "getSurveyV2()Lcom/bytedance/android/ec/model/response/PromotionProductCommentSurveyDTO;", 0);
    }

    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public Object get(Object r100) {
        return ((DualStreamState) r100).f165096g;
    }
}
