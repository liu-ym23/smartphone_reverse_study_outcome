package com.bytedance.android.live.profit.lottery;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class LotteryPluginStore implements com.bytedance.android.scope.o, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f87987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Object, n> f87988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LotteryContext f87989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LotteryRepository f87990d;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.lottery.LotteryPluginStore$onStart$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/profit/lottery/Lottery;", "Lkotlin/ParameterName;", "name", "lottery", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Lottery, Boolean> {
        public AnonymousClass1(LotteryPluginStore r100) {
            super(1, r100, LotteryPluginStore.class, "interceptNewLottery", "interceptNewLottery(Lcom/bytedance/android/live/profit/lottery/Lottery;)Z", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Lottery r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            Collection r101 = ((LinkedHashMap) ((LotteryPluginStore) this.receiver).f87988b).values();
            if ((r101 instanceof Collection) == true) goto L5;
        L7:
            Iterator r102 = r101.iterator();
        L9:
            if (r102.hasNext() == false) goto L13;
            if (((n) r102.next()).c(r100) == false) goto L9;
            return true;
        L13:
            return false;
        L5:
            if (r101.isEmpty() == false) goto L7;
            goto L7
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Lottery r100) {
            return Boolean.valueOf(invoke2(r100));
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f87987a = true;
        Iterator r100 = ((LinkedHashMap) this.f87988b).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((n) r100.next()).onUnload();
        goto L4
    L6:
        ((LinkedHashMap) this.f87988b).clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        LotteryRepository r100 = this.f87990d;
        r100.f88004m = new AnonymousClass1(this);
    }

    @Override // com.bytedance.android.live.profit.lottery.o
    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        Class<?> r101 = r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "uniqueId");
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        if (this.f87987a == false) goto L6;
        return;
    L6:
        if (this.f87988b.containsKey(r101) == true) goto L11;
        this.f87988b.put(r101, r100);
        r100.a(this.f87989c);
        return;
    }

    public LotteryPluginStore(LotteryContext r100, LotteryRepository r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lotteryRepository");
        this.f87989c = r100;
        this.f87990d = r101;
        this.f87988b = new LinkedHashMap();
    }
}
