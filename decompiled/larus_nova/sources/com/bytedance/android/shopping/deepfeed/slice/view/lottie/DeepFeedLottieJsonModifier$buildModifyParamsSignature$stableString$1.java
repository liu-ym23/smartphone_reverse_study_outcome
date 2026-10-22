package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "", "", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1 extends Lambda implements Function1<Map.Entry<String, String>, CharSequence> {
    public static final DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1 INSTANCE = null;

    static {
        INSTANCE = new DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1();
    }

    public DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<name for destructuring parameter 0>");
        String r101 = r100.getKey();
        String r102 = r100.getValue();
        StringBuilder r103 = new StringBuilder();
        int r104 = b.f173627a;
        if (StringsKt.startsWith$default(r101, "placeholder_", false, 2, null) == true) goto L6;
        r101 = "placeholder_" + r101;
    L6:
        r103.append(r101);
        r103.append(com.alipay.sdk.m.n.a.f25612h);
        r103.append(r102);
        return r103.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<String, String> r100) {
        return invoke2(r100);
    }
}
