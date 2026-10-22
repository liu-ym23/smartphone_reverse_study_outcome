package com.bytedance.android.shopping.mall.homepage.card.live;

import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.common.utility.Logger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements IECLynxCardLifeCycle {
    public h() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void createViewDuration(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onFirstScreen() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onPreCreateView(boolean r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRealSuccess() {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetup(Map<String, ? extends Object> r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetupPref(com.bytedance.android.ec.hybrid.card.util.k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingUpdatePref(com.bytedance.android.ec.hybrid.card.util.k r100) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTransDataTime(long r100, long r101) {
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadStart() {
        Logger.d("puffone-NativeLiveCard.onLoadStart()", "金币Lifecycle");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
        Logger.d("puffone-NativeLiveCard.onLoadSuccess()", "金币Lifecycle");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onRuntimeReady() {
        Logger.d("puffone-NativeLiveCard.onRuntimeReady()", "金币Lifecycle");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onReceivedError(com.bytedance.lynx.service.model.b r100) {
        StringBuilder r101 = new StringBuilder("金币Lifecycle ");
        String r102 = null;
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.f264891a);
    L6:
        r101.append(r103);
        r101.append(", ");
        if (r100 == null) goto L9;
        r102 = r100.f264892b;
    L9:
        r101.append(r102);
        Logger.d("puffone-NativeLiveCard.onReceivedError()", r101.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void useCache(@IECLynxCardLifeCycle.ECLynxCardCacheType String r100) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r100, "cache");
    }

    @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
        Logger.d("puffone-NativeLiveCard.onLoadFailed()", "金币Lifecycle " + r101 + ", " + r102);
    }
}
