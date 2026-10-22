package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.keyframes.model.KFImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "text", "", KFImage.FEATURES_JSON_FIELD, "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DeepFeedAiContainerView$checkViewState$2 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ InFeedProductV2 $data;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.h $dfContext;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.i $parentAbility;
    final /* synthetic */ DeepFeedAiContainerView this$0;

    public DeepFeedAiContainerView$checkViewState$2(DeepFeedAiContainerView r100, com.bytedance.android.shopping.deepfeed.action.h r101, InFeedProductV2 r102, com.bytedance.android.shopping.deepfeed.action.i r103) {
        this.this$0 = r100;
        this.$dfContext = r101;
        this.$data = r102;
        this.$parentAbility = r103;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, KFImage.FEATURES_JSON_FIELD);
        this.$dfContext.m();
        this.$parentAbility.z1(new com.bytedance.android.shopping.deepfeed.action.a.C2588a(r100, r101, true));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, List<? extends String> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
