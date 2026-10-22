package com.bytedance.android.annie.monitor.common.timing.jsb;

import android.os.Looper;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/os/Looper;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
public final class GetPerfTimingMethod$mainLooper$2 extends Lambda implements Function0<Looper> {
    public static final GetPerfTimingMethod$mainLooper$2 INSTANCE = null;

    static {
        INSTANCE = new GetPerfTimingMethod$mainLooper$2();
    }

    public GetPerfTimingMethod$mainLooper$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Looper invoke() {
        return Looper.getMainLooper();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Looper invoke() {
        return invoke();
    }
}
