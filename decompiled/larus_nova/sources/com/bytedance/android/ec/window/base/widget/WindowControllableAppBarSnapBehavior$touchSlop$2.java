package com.bytedance.android.ec.window.base.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.core.view.ViewConfigurationCompat;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class WindowControllableAppBarSnapBehavior$touchSlop$2 extends Lambda implements Function0<Integer> {
    public static final WindowControllableAppBarSnapBehavior$touchSlop$2 INSTANCE = null;

    static {
        INSTANCE = new WindowControllableAppBarSnapBehavior$touchSlop$2();
    }

    public WindowControllableAppBarSnapBehavior$touchSlop$2() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        Context r100 = ECAppInfoService.f48114e.getApplicationContext();
        Intrinsics.checkNotNull(r100);
        return ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r100));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}
