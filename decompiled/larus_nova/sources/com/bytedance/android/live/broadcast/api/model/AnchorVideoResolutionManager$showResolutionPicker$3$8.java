package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnchorVideoResolutionManager$showResolutionPicker$3$8 extends Lambda implements Function0<String> {
    public static final AnchorVideoResolutionManager$showResolutionPicker$3$8 INSTANCE = null;

    static {
        INSTANCE = new AnchorVideoResolutionManager$showResolutionPicker$3$8();
    }

    public AnchorVideoResolutionManager$showResolutionPicker$3$8() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return com.bytedance.android.livesdk.sharedpref.b.f158175l2.getValue().get(LiveMode.VIDEO.name());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
