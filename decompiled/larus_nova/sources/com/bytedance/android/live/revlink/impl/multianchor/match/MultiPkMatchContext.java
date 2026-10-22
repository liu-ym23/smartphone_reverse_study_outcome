package com.bytedance.android.live.revlink.impl.multianchor.match;

import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u0011R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u0019R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u0011R!\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\t\u001a\u0004\b%\u0010&R!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/match/MultiPkMatchContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/link/model/b0;", "currentAutoMatchInfo", "", "isLastStatusMatching", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/a;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/c;", "matchStatus$delegate", "getMatchStatus", "()Lcom/bytedance/live/datacontext/m;", "matchStatus", "lastMatchStatus$delegate", "getLastMatchStatus", "lastMatchStatus", "Lcom/bytedance/live/datacontext/n;", "selfAutoMatchInfo$delegate", "getSelfAutoMatchInfo", "()Lcom/bytedance/live/datacontext/n;", "selfAutoMatchInfo", "passiveAutoMatchInfo$delegate", "getPassiveAutoMatchInfo", "passiveAutoMatchInfo", "", "countDownTime$delegate", "getCountDownTime", "countDownTime", "Lcom/bytedance/live/datacontext/k;", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/d;", "matchSuccessEvent$delegate", "getMatchSuccessEvent", "()Lcom/bytedance/live/datacontext/k;", "matchSuccessEvent", "", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "battleAttachedInfo", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiPkMatchContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p battleAttachedInfo$delegate;
    private final p countDownTime$delegate;
    private final p lastMatchStatus$delegate;
    private final p matchStatus$delegate;
    private final p matchSuccessEvent$delegate;
    private final p passiveAutoMatchInfo$delegate;
    private final p selfAutoMatchInfo$delegate;
    private final p service$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "matchStatus", "getMatchStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "lastMatchStatus", "getLastMatchStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "selfAutoMatchInfo", "getSelfAutoMatchInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "passiveAutoMatchInfo", "getPassiveAutoMatchInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "countDownTime", "getCountDownTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "matchSuccessEvent", "getMatchSuccessEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(MultiPkMatchContext.class, "battleAttachedInfo", "getBattleAttachedInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
    }

    public final com.bytedance.live.datacontext.n<String> getBattleAttachedInfo() {
        return (com.bytedance.live.datacontext.n) this.battleAttachedInfo$delegate.a(this, $$delegatedProperties[7]);
    }

    public final com.bytedance.live.datacontext.m<Long> getCountDownTime() {
        return (com.bytedance.live.datacontext.m) this.countDownTime$delegate.a(this, $$delegatedProperties[5]);
    }

    public final com.bytedance.live.datacontext.m<c> getLastMatchStatus() {
        return (com.bytedance.live.datacontext.m) this.lastMatchStatus$delegate.a(this, $$delegatedProperties[2]);
    }

    public final com.bytedance.live.datacontext.m<c> getMatchStatus() {
        return (com.bytedance.live.datacontext.m) this.matchStatus$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.k<d> getMatchSuccessEvent() {
        return (com.bytedance.live.datacontext.k) this.matchSuccessEvent$delegate.a(this, $$delegatedProperties[6]);
    }

    public final com.bytedance.live.datacontext.n<b0> getPassiveAutoMatchInfo() {
        return (com.bytedance.live.datacontext.n) this.passiveAutoMatchInfo$delegate.a(this, $$delegatedProperties[4]);
    }

    public final com.bytedance.live.datacontext.n<b0> getSelfAutoMatchInfo() {
        return (com.bytedance.live.datacontext.n) this.selfAutoMatchInfo$delegate.a(this, $$delegatedProperties[3]);
    }

    public final com.bytedance.live.datacontext.j<a> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public MultiPkMatchContext() {
        this.service$delegate = ConstantKt.c(this);
        this.matchStatus$delegate = q.d(this, new c.C1460c());
        this.lastMatchStatus$delegate = q.d(this, new c.C1460c());
        this.selfAutoMatchInfo$delegate = q.c(this);
        this.passiveAutoMatchInfo$delegate = q.c(this);
        this.countDownTime$delegate = q.d(this, -1L);
        this.matchSuccessEvent$delegate = com.bytedance.live.datacontext.e.a(this, MultiPkMatchContext$matchSuccessEvent$2.INSTANCE);
        this.battleAttachedInfo$delegate = q.c(this);
    }

    public final b0 currentAutoMatchInfo() {
        if (getMatchStatus().getValue().f94384d == false) goto L7;
        return getPassiveAutoMatchInfo().getValue();
    L7:
        return getSelfAutoMatchInfo().getValue();
    }

    public final boolean isLastStatusMatching() {
        return getLastMatchStatus().getValue().f94381a;
    }
}
