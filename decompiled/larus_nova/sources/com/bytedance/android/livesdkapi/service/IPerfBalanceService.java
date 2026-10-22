package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH&J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000eH&J@\u0010\u000f\u001a\u00020\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00100\u0012H&J@\u0010\u0018\u001a\u00020\u001026\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00100\u0012H&J+\u0010\u001c\u001a\u00020\u00102!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00100\u001eH&J+\u0010 \u001a\u00020\u00102!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00100\u001eH&J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0013H&¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IPerfBalanceService;", "Lcom/bytedance/android/live/base/IService;", "getHeartEffect", "", "getSpeedEffect", "getTimeEffect", "isAnchorScene", "", "registerAtomicAbility", "label", "", "type", "ability", "Lcom/bytedance/android/livesdkapi/service/LevelAbility;", "Lcom/bytedance/android/livesdkapi/service/StrategyAbility;", "subscribeNotify", "", "notifyObserver", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "curNotifyLevel", "scene", "subscribePerfCode", "perfCodeObserver", "perfCode", "riskCode", "subscribeProcess", "processObserver", "Lkotlin/Function1;", "processCode", "subscribeUserSceneChanged", "userSceneObserver", "isAnchor", "updateFastModePermission", "state", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPerfBalanceService extends IService {
    float getHeartEffect();

    float getSpeedEffect();

    float getTimeEffect();

    boolean isAnchorScene();

    boolean registerAtomicAbility(String r100, String r101, LevelAbility r102);

    boolean registerAtomicAbility(String r100, String r101, StrategyAbility r102);

    void subscribeNotify(Function2<? super Integer, ? super String, Unit> r100);

    void subscribePerfCode(Function2<? super Integer, ? super Integer, Unit> r100);

    void subscribeProcess(Function1<? super Integer, Unit> r100);

    void subscribeUserSceneChanged(Function1<? super Boolean, Unit> r100);

    void updateFastModePermission(int r100);
}
