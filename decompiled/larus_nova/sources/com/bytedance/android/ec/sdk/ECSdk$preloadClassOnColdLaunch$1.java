package com.bytedance.android.ec.sdk;

import com.bytedance.android.ec.sdk.plugin.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ec/sdk/plugin/c;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ec/sdk/plugin/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ECSdk$preloadClassOnColdLaunch$1 extends Lambda implements Function1<c, Unit> {
    public static final ECSdk$preloadClassOnColdLaunch$1 INSTANCE = null;

    static {
        INSTANCE = new ECSdk$preloadClassOnColdLaunch$1();
    }

    public ECSdk$preloadClassOnColdLaunch$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        if (r100 == null) goto L5;
        r100.b();
        return;
    }
}
