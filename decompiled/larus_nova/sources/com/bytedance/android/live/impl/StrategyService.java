package com.bytedance.android.live.impl;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.h5;
import com.bytedance.android.live.impl.monitor.StrategyTeaLogHelper;
import com.bytedance.android.live.impl.strategy.Strategy;
import com.bytedance.android.live.strategy.api.CombineInfo;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.live.v3.StrategyManagerV3;
import com.bytedance.android.livesdk.c3;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J;\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u000fJ5\u0010\u0007\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/impl/StrategyService;", "Lcom/bytedance/android/live/strategy/api/IStrategyService;", "()V", "ebableV3", "", "getEbableV3", "()Z", "getFactor", "Landroidx/lifecycle/LiveData;", ExifInterface.GPS_DIRECTION_TRUE, "faName", "", "default", "sendTeaLog", "useCache", "(Ljava/lang/String;Ljava/lang/Object;ZZ)Landroidx/lifecycle/LiveData;", "anchorId", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)Ljava/lang/Object;", "getShotStrategy", "Lcom/bytedance/android/live/strategy/api/CombineInfo;", "init", "", "isSmartSDKInit", "isStrategyFactor", "releaseCache", "sendLog", "value", "livestrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StrategyService implements IStrategyService {
    private final boolean ebableV3;

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public void init() {
        if (this.ebableV3 == false) goto L5;
        StrategyManagerV3.f102580t.g();
        return;
    L5:
        StrategyManager.f69051s.g();
    }

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public boolean isSmartSDKInit() {
        if (this.ebableV3 == false) goto L6;
        StrategyManagerV3.f102580t.getClass();
        return StrategyManagerV3.f102571k;
    L6:
        StrategyManager.f69051s.getClass();
        return StrategyManager.f69042j;
    }

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public void releaseCache() {
        if (h5.f65316a.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (this.ebableV3 == false) goto L7;
        StrategyManagerV3.f102580t.getClass();
        ((ConcurrentHashMap) StrategyManagerV3.f102564d).keySet().retainAll(StrategyManagerV3.f102568h);
        ((ArrayList) StrategyManagerV3.f102570j).clear();
        return;
    L7:
        StrategyManager.f69051s.getClass();
        ((ConcurrentHashMap) StrategyManager.f69036d).keySet().retainAll(StrategyManager.f69040h);
        ((ArrayList) StrategyManager.f69041i).clear();
    }

    public StrategyService() {
        this.ebableV3 = c3.f104412a.getValue().getEnable_v3();
        if (k.h(IStrategyService.class) == true) goto L6;
        k.l(IStrategyService.class, this);
        return;
    }

    public final boolean getEbableV3() {
        return this.ebableV3;
    }

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public CombineInfo getShotStrategy(String r110) {
        Intrinsics.checkNotNullParameter(r110, "faName");
        if (this.ebableV3 == false) goto L24;
        StrategyManagerV3.f102580t.getClass();
        Intrinsics.checkNotNullParameter(r110, "faName");
        if (StrategyManagerV3.f102571k == false) goto L23;
        String r100 = StrategyTeaLogHelper.b(r110);
        Strategy r101 = StrategyManagerV3.f102561a;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L9:
        if (r101 == null) goto L23;
        CopyOnWriteArrayList<CombineInfo> r102 = r101.getCombineStrategys();
        if (r102 == null) goto L23;
        Iterator<T> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L23;
        CombineInfo r104 = (CombineInfo) r103.next();
        if (r104 == null) goto L14;
        String r105 = r104.getCombineId();
        if (r105 == null) goto L14;
        if (r105.equals(r100) != true) goto L14;
        return r104;
    L23:
        return new CombineInfo(null, null, null, null, null, null, null, null, 255, null);
    L24:
        StrategyManager.f69051s.getClass();
        Intrinsics.checkNotNullParameter(r110, "faName");
        if (StrategyManager.f69042j == false) goto L43;
        String r106 = StrategyTeaLogHelper.b(r110);
        Strategy r107 = StrategyManager.f69033a;
        if (r107 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException(BdpAppEventConstant.PARAMS_STRATEGY_NAME);
    L29:
        if (r107 == null) goto L43;
        CopyOnWriteArrayList<CombineInfo> r108 = r107.getCombineStrategys();
        if (r108 == null) goto L43;
        Iterator<T> r109 = r108.iterator();
    L34:
        if (r109.hasNext() == false) goto L43;
        CombineInfo r111 = (CombineInfo) r109.next();
        if (r111 == null) goto L34;
        String r112 = r111.getCombineId();
        if (r112 == null) goto L34;
        if (r112.equals(r106) != true) goto L34;
        return r111;
    L43:
        return new CombineInfo(null, null, null, null, null, null, null, null, 255, null);
    }

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public boolean isStrategyFactor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        if (this.ebableV3 == false) goto L8;
        StrategyManagerV3.f102580t.getClass();
        Intrinsics.checkNotNullParameter(r100, "faName");
        if (StrategyManagerV3.f102574n == true) goto L7;
        return false;
    L7:
        return StrategyManagerV3.f102565e.contains(r100);
    L8:
        StrategyManager.f69051s.getClass();
        Intrinsics.checkNotNullParameter(r100, "faName");
        if (StrategyManager.f69045m == true) goto L11;
        return false;
    L11:
        return StrategyManager.f69037e.contains(r100);
    }

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public void sendLog(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        Intrinsics.checkNotNullParameter(r101, "value");
        HashMap r102 = new HashMap();
        r102.put("faName", r100);
        r102.put("value", r101);
        IRoomContextService r103 = (IRoomContextService) k.f(IRoomContextService.class);
        Class<?> r104 = null;
        if (r103 == null) goto L7;
        o r105 = IRoomContextService.a.a(r103, null, 0, 3);
        if (r105 == null) goto L7;
        r104 = r105.Q2();
    L7:
        j0.l().sendLog("livesdk_strategy_fa_monitor", r102, new Object[]{r104});
    }

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public <T> LiveData<T> getFactor(String r100, T r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "faName");
    L9:
        e = move-exception;
        ALogger.i("strategy_tag", e.getMessage());
        StrategyMutableLiveData r104 = new StrategyMutableLiveData();
        r104.setValue(r101);
        return r104;
    L4:
        if (this.ebableV3 == false) goto L8;
        return StrategyManagerV3.f102580t.d(r100, r101, r102, r103);
    L8:
        return StrategyManager.f69051s.d(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.strategy.api.IStrategyService
    public <T> T getFactor(String r100, T r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "faName");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
    L9:
        e = move-exception;
        ALogger.i("strategy_tag", e.getMessage());
        return r101;
    L4:
        if (this.ebableV3 == false) goto L8;
        return (T) StrategyManagerV3.f102580t.e(r100, r102, r101);
    L8:
        return (T) StrategyManager.f69051s.e(r100, r102, r101);
    }
}
