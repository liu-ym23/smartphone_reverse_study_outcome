package com.bytedance.android.livesdkapi.service.floatwindow.platform;

import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.ILiveBizWindowAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.model.LiveBizWindowAbilityEnv;
import com.bytedance.android.livesdkapi.service.vs.IPaidInRoomFloatWindowAbilityCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u0004\u0018\u00010\rJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0018\u0010 \u001a\u00020\u001b2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0\fH\u0002J\u0006\u0010#\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/LiveBizWindowAbilityCenter;", "", "abilityEnv", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;", "(Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/model/LiveBizWindowAbilityEnv;)V", "ecHostService", "Lcom/bytedance/android/livesdkapi/service/IHostCommerceServiceLive;", "getEcHostService", "()Lcom/bytedance/android/livesdkapi/service/IHostCommerceServiceLive;", "ecHostService$delegate", "Lkotlin/Lazy;", "layoutAbilityList", "", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLayoutAbility;", "logAbilityList", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowLogAbility;", "paidLiveInRoom", "Lcom/bytedance/android/livesdkapi/service/vs/IPaidInRoomFloatWindowAbilityCenter;", "getPaidLiveInRoom", "()Lcom/bytedance/android/livesdkapi/service/vs/IPaidInRoomFloatWindowAbilityCenter;", "paidLiveInRoom$delegate", "widgetAbilityList", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/AbsLiveBizWindowWidgetAbility;", "getCurLayoutAbility", "getCurLogAbility", "getCurWidgetAbility", "initAbility", "", "loadAbilityEnv", "registerLayoutAbility", "registerLogAbility", "registerWidgetAbility", "sortAbilityList", "list", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/ablity/ILiveBizWindowAbility;", "unInitAbility", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBizWindowAbilityCenter {
    private final LiveBizWindowAbilityEnv abilityEnv;
    private final Lazy ecHostService$delegate;
    private final List<AbsLiveBizWindowLayoutAbility> layoutAbilityList;
    private final List<AbsLiveBizWindowLogAbility> logAbilityList;
    private final Lazy paidLiveInRoom$delegate;
    private final List<AbsLiveBizWindowWidgetAbility> widgetAbilityList;

    private final IHostCommerceServiceLive getEcHostService() {
        return (IHostCommerceServiceLive) this.ecHostService$delegate.getValue();
    }

    private final IPaidInRoomFloatWindowAbilityCenter getPaidLiveInRoom() {
        return (IPaidInRoomFloatWindowAbilityCenter) this.paidLiveInRoom$delegate.getValue();
    }

    public final AbsLiveBizWindowLayoutAbility getCurLayoutAbility() {
        Iterator<T> r100 = this.layoutAbilityList.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((AbsLiveBizWindowLayoutAbility) r101).enable() == false) goto L4;
    L10:
        return (AbsLiveBizWindowLayoutAbility) r101;
    L8:
        r101 = null;
        goto L10
    }

    public final AbsLiveBizWindowLogAbility getCurLogAbility() {
        Iterator<T> r100 = this.logAbilityList.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((AbsLiveBizWindowLogAbility) r101).enable() == false) goto L4;
    L10:
        return (AbsLiveBizWindowLogAbility) r101;
    L8:
        r101 = null;
        goto L10
    }

    public final AbsLiveBizWindowWidgetAbility getCurWidgetAbility() {
        Iterator<T> r100 = this.widgetAbilityList.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((AbsLiveBizWindowWidgetAbility) r101).enable() == false) goto L4;
    L10:
        return (AbsLiveBizWindowWidgetAbility) r101;
    L8:
        r101 = null;
        goto L10
    }

    public final void loadAbilityEnv() {
        Iterator<T> r100 = this.layoutAbilityList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((AbsLiveBizWindowLayoutAbility) r100.next()).setAbilityEnv(this.abilityEnv);
        goto L4
    L6:
        Iterator<T> r101 = this.widgetAbilityList.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((AbsLiveBizWindowWidgetAbility) r101.next()).setAbilityEnv(this.abilityEnv);
        goto L8
    L10:
        Iterator<T> r102 = this.logAbilityList.iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((AbsLiveBizWindowLogAbility) r102.next()).setAbilityEnv(this.abilityEnv);
        goto L12
    }

    public final void unInitAbility() {
        this.layoutAbilityList.clear();
        this.widgetAbilityList.clear();
        this.logAbilityList.clear();
    }

    public final void initAbility() {
        registerLayoutAbility();
        registerWidgetAbility();
        registerLogAbility();
        loadAbilityEnv();
        sortAbilityList(this.layoutAbilityList);
        sortAbilityList(this.widgetAbilityList);
        sortAbilityList(this.logAbilityList);
    }

    public final void registerLayoutAbility() {
        IHostCommerceServiceLive r100 = getEcHostService();
        AbsLiveBizWindowLayoutAbility r101 = null;
        if (r100 == null) goto L5;
        AbsLiveBizWindowLayoutAbility r102 = r100.getLiveBizWindowLayoutAbility();
    L6:
        if (r102 == null) goto L8;
        this.layoutAbilityList.add(r102);
    L8:
        IPaidInRoomFloatWindowAbilityCenter r103 = getPaidLiveInRoom();
        if (r103 == null) goto L11;
        r101 = r103.provideWindowLayoutAbility();
    L11:
        if (r101 == null) goto L14;
        this.layoutAbilityList.add(r101);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void registerLogAbility() {
        IHostCommerceServiceLive r100 = getEcHostService();
        AbsLiveBizWindowLogAbility r101 = null;
        if (r100 == null) goto L5;
        AbsLiveBizWindowLogAbility r102 = r100.getLiveBizWindowLogAbility();
    L6:
        if (r102 == null) goto L8;
        this.logAbilityList.add(r102);
    L8:
        IPaidInRoomFloatWindowAbilityCenter r103 = getPaidLiveInRoom();
        if (r103 == null) goto L11;
        r101 = r103.provideWindowLogAbility();
    L11:
        if (r101 == null) goto L14;
        this.logAbilityList.add(r101);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void registerWidgetAbility() {
        IHostCommerceServiceLive r100 = getEcHostService();
        AbsLiveBizWindowWidgetAbility r101 = null;
        if (r100 == null) goto L5;
        AbsLiveBizWindowWidgetAbility r102 = r100.getLiveBizWindowWidgetAbility();
    L6:
        if (r102 == null) goto L8;
        this.widgetAbilityList.add(r102);
    L8:
        IPaidInRoomFloatWindowAbilityCenter r103 = getPaidLiveInRoom();
        if (r103 == null) goto L11;
        r101 = r103.provideWindowWidgetAbility();
    L11:
        if (r101 == null) goto L14;
        this.widgetAbilityList.add(r101);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public LiveBizWindowAbilityCenter(LiveBizWindowAbilityEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "abilityEnv");
        this.abilityEnv = r100;
        this.layoutAbilityList = new ArrayList();
        this.widgetAbilityList = new ArrayList();
        this.logAbilityList = new ArrayList();
        this.ecHostService$delegate = LazyKt.lazy(LiveBizWindowAbilityCenter$ecHostService$2.INSTANCE);
        this.paidLiveInRoom$delegate = LazyKt.lazy(LiveBizWindowAbilityCenter$paidLiveInRoom$2.INSTANCE);
    }

    private final void sortAbilityList(List<? extends ILiveBizWindowAbility> r100) {
        if (r100.size() <= 1) goto L6;
        CollectionsKt.sortWith(r100, new LiveBizWindowAbilityCenter$sortAbilityList$$inlined$sortByDescending$1());
        return;
    }
}
