package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lu83/b;", AbsMethodDelegate.TAG_INVOKE, "()Lu83/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class AnchorV4KolFeedVH$1$onViewAttachedToWindow$1$1 extends Lambda implements Function0<u83.b> {
    final /* synthetic */ Fragment $feedFragment;

    public AnchorV4KolFeedVH$1$onViewAttachedToWindow$1$1(Fragment r100) {
        this.$feedFragment = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final u83.b invoke2() {
        ActivityResultCaller r100 = this.$feedFragment;
        if ((r100 instanceof u83.b) == true) goto L6;
        r100 = null;
    L6:
        return (u83.b) r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ u83.b invoke() {
        return invoke2();
    }
}
