package com.bytedance.android.livesdk.castscreen.api;

import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/live/datacontext/DataContext;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CastScreenDependence$createDataContextRef$castScreenViewModelRef$2 extends Lambda implements Function0<DataContext> {
    public static final CastScreenDependence$createDataContextRef$castScreenViewModelRef$2 INSTANCE = null;

    static {
        INSTANCE = new CastScreenDependence$createDataContextRef$castScreenViewModelRef$2();
    }

    public CastScreenDependence$createDataContextRef$castScreenViewModelRef$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DataContext invoke() {
        return new CastScreenViewModel();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DataContext invoke() {
        return invoke();
    }
}
