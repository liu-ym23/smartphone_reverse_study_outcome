package com.bytedance.android.live.revlink.impl.multianchor.profit;

import androidx.lifecycle.LiveData;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.livesdk.link.model.b8;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.e8;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.bytedance.live.kmp.util.e;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0006J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R!\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010%R-\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120*0\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010 R*\u00100\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R!\u00108\u001a\b\u0012\u0004\u0012\u00020\r0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u001e\u001a\u0004\b7\u0010%R'\u0010<\u001a\u0012\u0012\u0004\u0012\u00020:09j\b\u0012\u0004\u0012\u00020:`;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/profit/ProfitInteractionDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "currentLinkTimestamp", "", "currentScoreShowStatus", "", "hasDataInitialized", "Lcom/bytedance/android/livesdk/link/model/c8;", "message", "", "initData", "canShowScore", "", "userId", "getScoreByUserId", "getSelfShowScoreSetting", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Lcom/bytedance/android/livesdk/link/model/b8;", "getProfitInteractionInfoByUserId", "getLogString", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "pkBaseService", "attachToDynamicContext", "detachfromDynamicContext", "Lcom/bytedance/android/live/link/data/RevPkState;", "pkState", "onPkStateChange", "Lcom/bytedance/live/datacontext/n;", "currentMessage$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentMessage", "()Lcom/bytedance/live/datacontext/n;", "currentMessage", "Lcom/bytedance/live/datacontext/m;", "linkStartTimeStamp$delegate", "getLinkStartTimeStamp", "()Lcom/bytedance/live/datacontext/m;", "linkStartTimeStamp", "scoreShowStatus$delegate", "getScoreShowStatus", "scoreShowStatus", "", "multiAnchorData$delegate", "getMultiAnchorData", "multiAnchorData", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/revenue/platform/api/core/rx/Disposable;", "timerDiposable", "Lio/reactivex/disposables/Disposable;", "getTimerDiposable", "()Lio/reactivex/disposables/Disposable;", "setTimerDiposable", "(Lio/reactivex/disposables/Disposable;)V", "linkRecordTime$delegate", "getLinkRecordTime", "linkRecordTime", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$c;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "pkStateObserver", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "getPkStateObserver", "()Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ProfitInteractionDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p currentMessage$delegate;
    private final p linkRecordTime$delegate;
    private final p linkStartTimeStamp$delegate;
    private final p multiAnchorData$delegate;
    private final Observer<PkBaseStateMachine.c> pkStateObserver;
    private final p scoreShowStatus$delegate;
    private Disposable timerDiposable;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProfitInteractionDataContext f94608a;

        public a(ProfitInteractionDataContext r100) {
            this.f94608a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            Disposable r100 = this.f94608a.getTimerDiposable();
            if (r100 == null) goto L6;
            r100.dispose();
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProfitInteractionDataContext f94609a;

        public b(ProfitInteractionDataContext r100) {
            this.f94609a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f94609a.getLinkRecordTime().setValue(String.valueOf((e.a() - this.f94609a.getLinkStartTimeStamp().getValue().longValue()) / ((long) 1000)));
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ProfitInteractionDataContext.class, "currentMessage", "getCurrentMessage()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ProfitInteractionDataContext.class, "linkStartTimeStamp", "getLinkStartTimeStamp()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ProfitInteractionDataContext.class, "scoreShowStatus", "getScoreShowStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ProfitInteractionDataContext.class, "multiAnchorData", "getMultiAnchorData()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ProfitInteractionDataContext.class, "linkRecordTime", "getLinkRecordTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final n<c8> getCurrentMessage() {
        return (n) this.currentMessage$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<String> getLinkRecordTime() {
        return (m) this.linkRecordTime$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Long> getLinkStartTimeStamp() {
        return (m) this.linkStartTimeStamp$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<Map<String, b8>> getMultiAnchorData() {
        return (n) this.multiAnchorData$delegate.a(this, $$delegatedProperties[3]);
    }

    public final m<Integer> getScoreShowStatus() {
        return (m) this.scoreShowStatus$delegate.a(this, $$delegatedProperties[2]);
    }

    public final boolean canShowScore() {
        if (v41.b.f553047f.a() == true) goto L6;
        return false;
    L6:
        if (hasDataInitialized() == true) goto L8;
        return false;
    L8:
        if (c.a(getScoreShowStatus().getValue().intValue()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final String getLogString() {
        StringBuilder r100 = new StringBuilder("ProfitInteractionDataContext{scoreShowStatus:");
        r100.append(getScoreShowStatus().getValue().intValue());
        r100.append(",multiAnchorData:");
        Map<String, b8> r101 = getMultiAnchorData().getValue();
        if (r101 == null) goto L5;
        String r102 = ef2.a.b(r101);
    L6:
        r100.append(r102);
        r100.append(",linkStartTimeStamp:");
        r100.append(getLinkStartTimeStamp().getValue().longValue());
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public ProfitInteractionDataContext() {
        this.currentMessage$delegate = q.c(this);
        this.linkStartTimeStamp$delegate = q.d(this, 0L);
        this.scoreShowStatus$delegate = q.d(this, 0);
        this.multiAnchorData$delegate = q.c(this);
        this.linkRecordTime$delegate = q.d(this, "0");
        this.pkStateObserver = new ProfitInteractionDataContext$pkStateObserver$1(this);
        getOnCleared().subscribe(new a(this));
    }

    public final long currentLinkTimestamp() {
        return getLinkStartTimeStamp().getValue().longValue();
    }

    public final int currentScoreShowStatus() {
        return getScoreShowStatus().getValue().intValue();
    }

    public final boolean hasDataInitialized() {
        if (getCurrentMessage().getValue() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Observer<PkBaseStateMachine.c> getPkStateObserver() {
        return this.pkStateObserver;
    }

    public final Disposable getTimerDiposable() {
        return this.timerDiposable;
    }

    public final void attachToDynamicContext(com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100) {
        if (r100 == null) goto L7;
        LiveData<PkBaseStateMachine.c> r101 = r100.getPkBaseState();
        if (r101 == null) goto L8;
        x.e(r101, this.pkStateObserver);
        return;
    L8:
        return;
    }

    public final void detachfromDynamicContext(com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r100) {
        if (r100 == null) goto L6;
        LiveData<PkBaseStateMachine.c> r101 = r100.getPkBaseState();
        if (r101 == null) goto L6;
        r101.removeObserver(this.pkStateObserver);
    L6:
        Disposable r102 = this.timerDiposable;
        if (r102 == null) goto L10;
        r102.dispose();
        return;
    }

    public final b8 getProfitInteractionInfoByUserId(String r100) {
        if (hasDataInitialized() == false) goto L10;
        if (r100 == null) goto L12;
        Map<String, b8> r101 = getMultiAnchorData().getValue();
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.get(r100);
    L12:
        return null;
    L10:
        return null;
    }

    public final String getScoreByUserId(String r100) {
        if (hasDataInitialized() == false) goto L13;
        if (r100 == null) goto L15;
        Map<String, b8> r101 = getMultiAnchorData().getValue();
        if (r101 == null) goto L9;
        b8 r102 = r101.get(r100);
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.getScoreStr();
    L9:
        r102 = null;
        goto L10
    L15:
        return null;
    L13:
        return null;
    }

    public final Boolean getSelfShowScoreSetting(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Map<String, b8> r101 = getMultiAnchorData().getValue();
        if (r101 == null) goto L5;
        b8 r102 = r101.get(r100);
    L6:
        if (r102 == null) goto L11;
        e8 r103 = r102.getSetting();
        if (r103 != null) goto L10;
        return null;
    L10:
        return Boolean.valueOf(r103.getHideInteractionScore());
    L11:
        return null;
    L5:
        r102 = null;
        goto L6
    }

    public final void initData(c8 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        getCurrentMessage().setValue(r100);
        getLinkStartTimeStamp().setValue(Long.valueOf(r100.getLinkStartTime()));
        n<Map<String, b8>> r101 = getMultiAnchorData();
        Map<String, b8> r102 = r100.getAnchorInfoMap();
        if (r102 == null) goto L5;
        Map<String, b8> r103 = MapsKt.toMap(r102);
    L6:
        r101.setValue(r103);
        getScoreShowStatus().setValue(Integer.valueOf(r100.getInteractionScoreStatus()));
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void onPkStateChange(RevPkState r110) {
        Intrinsics.checkNotNullParameter(r110, "pkState");
        Disposable r100 = this.timerDiposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        long r101 = 1000;
        getLinkRecordTime().setValue(String.valueOf((e.a() - getLinkStartTimeStamp().getValue().longValue()) / r101));
        if (r110 != RevPkState.FINISHED) goto L8;
    L9:
        l r111 = l.f267516a;
        int r112 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        this.timerDiposable = Observable.interval(0, r101, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    L8:
        if (r110 == RevPkState.DISABLE) goto L9;
    }

    public final void setTimerDiposable(Disposable r100) {
        this.timerDiposable = r100;
    }
}
