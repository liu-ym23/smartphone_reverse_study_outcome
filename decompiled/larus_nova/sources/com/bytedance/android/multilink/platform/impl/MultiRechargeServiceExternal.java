package com.bytedance.android.multilink.platform.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.recharge.IMultiRechargeServiceExternal;
import com.bytedance.android.live.recharge.IRechargeServiceExternal;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.model.d;
import com.bytedance.android.livesdkapi.depend.live.IRechargeListener;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zg1.w2;
import zv0.a;
import zv0.f;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0097\u0001J\t\u0010\u000e\u001a\u00020\rH\u0097\u0001J\u0011\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u0097\u0001J\u0011\u0010\u0014\u001a\n \t*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J)\u0010\u0018\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n \t*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u00160\u0016H\u0096\u0001JA\u0010\u001d\u001a\n \t*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u0006\u001a\n \t*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u00190\u00192\u000e\u0010\u001b\u001a\n \t*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001JA\u0010\u001d\u001a\n \t*\u0004\u0018\u00010\u001c0\u001c2\u000e\u0010\u0006\u001a\n \t*\u0004\u0018\u00010\u00150\u00152\u000e\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u001e0\u001e2\u000e\u0010\u001b\u001a\n \t*\u0004\u0018\u00010\u001a0\u001aH\u0096\u0001R\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/multilink/platform/impl/MultiRechargeServiceExternal;", "Lcom/bytedance/android/live/recharge/IMultiRechargeServiceExternal;", "Lcom/bytedance/android/live/recharge/IRechargeServiceExternal;", "", "clearCurrentRechargeCacheDataObject", "", "p0", "fetchAutoExchangeStatus", "Lzv0/a;", "kotlin.jvm.PlatformType", "getCJExternalService", "Lcom/bytedance/android/live/ai/api/model/RechargeCurrentCacheData;", "getCurrentRechargeCacheDataObject", "Lcom/bytedance/android/live/recharge/exchange/IAutoExchangeService;", "getExchangeUtils", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "getRechargeJsFactory", "", "isRechargeDialogShowing", "Lzv0/f;", "rechargeCenter", "Landroid/content/Context;", "Lzg1/w2;", "p1", "showPayCancelChargePanel", "Landroid/os/Bundle;", "Lcom/bytedance/android/livesdkapi/depend/live/IRechargeListener;", "p2", "Landroidx/fragment/app/DialogFragment;", "showRechargeDialogFragment", "Lcom/bytedance/android/live/recharge/model/d;", "realService", "Lcom/bytedance/android/live/recharge/IRechargeServiceExternal;", "getRealService", "()Lcom/bytedance/android/live/recharge/IRechargeServiceExternal;", "<init>", "(Lcom/bytedance/android/live/recharge/IRechargeServiceExternal;)V", "multilink-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class MultiRechargeServiceExternal implements IMultiRechargeServiceExternal, IRechargeServiceExternal {
    private final IRechargeServiceExternal realService;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiRechargeServiceExternal() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public void clearCurrentRechargeCacheDataObject() {
        this.realService.clearCurrentRechargeCacheDataObject();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public void fetchAutoExchangeStatus(int r100) {
        this.realService.fetchAutoExchangeStatus(r100);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public a getCJExternalService() {
        return this.realService.getCJExternalService();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public RechargeCurrentCacheData getCurrentRechargeCacheDataObject() {
        return this.realService.getCurrentRechargeCacheDataObject();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public IAutoExchangeService getExchangeUtils() {
        return this.realService.getExchangeUtils();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public IJsMethodsProvideService.IFactory getRechargeJsFactory() {
        return this.realService.getRechargeJsFactory();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public boolean isRechargeDialogShowing() {
        return this.realService.isRechargeDialogShowing();
    }

    @Override // com.bytedance.android.live.recharge.IMultiRechargeServiceExternal, com.bytedance.android.live.recharge.IRechargeServiceExternal
    public f rechargeCenter() {
        return this.realService.rechargeCenter();
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public void showPayCancelChargePanel(Context r100, w2 r101) {
        this.realService.showPayCancelChargePanel(r100, r101);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public DialogFragment showRechargeDialogFragment(Context r100, Bundle r101, IRechargeListener r102) {
        return this.realService.showRechargeDialogFragment(r100, r101, r102);
    }

    @Override // com.bytedance.android.live.recharge.IRechargeServiceExternal
    public DialogFragment showRechargeDialogFragment(Context r100, d r101, IRechargeListener r102) {
        return this.realService.showRechargeDialogFragment(r100, r101, r102);
    }

    public final IRechargeServiceExternal getRealService() {
        return this.realService;
    }

    public MultiRechargeServiceExternal(IRechargeServiceExternal r100) {
        Intrinsics.checkNotNullParameter(r100, "realService");
        this.realService = r100;
    }

    public /* synthetic */ MultiRechargeServiceExternal(IRechargeServiceExternal r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = (IRechargeServiceExternal) k.n(IRechargeServiceExternal.class);
    L5:
        this(r100);
    }
}
