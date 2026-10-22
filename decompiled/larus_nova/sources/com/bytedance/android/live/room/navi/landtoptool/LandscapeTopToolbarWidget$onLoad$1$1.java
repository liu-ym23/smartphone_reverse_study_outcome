package com.bytedance.android.live.room.navi.landtoptool;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.x0;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/x0;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lzg1/x0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LandscapeTopToolbarWidget$onLoad$1$1 extends FunctionReferenceImpl implements Function1<x0, Unit> {
    public LandscapeTopToolbarWidget$onLoad$1$1(LandscapeTopToolbarWidget r100) {
        super(1, r100, LandscapeTopToolbarWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LandscapeRootViewChangeEvent;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(x0 r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        LandscapeTopToolbarWidget r101 = (LandscapeTopToolbarWidget) this.receiver;
        int r102 = LandscapeTopToolbarWidget.f99705h;
        ViewGroup r103 = r101.f99707b;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
    L5:
        UIUtils.updateLayoutMargin(r103, -3, -3, s1.f(0.0f), -3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(x0 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
