package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/KtvModeOrderSongDataContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$2 extends FunctionReferenceImpl implements Function0<KtvModeOrderSongDataContext> {
    public static final RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$2 INSTANCE = null;

    static {
        INSTANCE = new RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$2();
    }

    public RealTimeChorusMainViewWidget$initKSongOrderSongDataContextIfNeed$2() {
        super(0, KtvModeOrderSongDataContext.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KtvModeOrderSongDataContext invoke() {
        return new KtvModeOrderSongDataContext();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KtvModeOrderSongDataContext invoke() {
        return invoke();
    }
}
