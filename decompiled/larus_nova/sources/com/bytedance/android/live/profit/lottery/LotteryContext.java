package com.bytedance.android.live.profit.lottery;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bA\u00107R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000eR!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u000eR!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u000eR!\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\u000eR!\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\u000eR!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\u000eR!\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\u000eR!\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0006\u001a\u0004\b1\u0010\u000eR'\u00108\u001a\b\u0012\u0004\u0012\u0002030\u00108VX\u0097\u0084\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0006\u0012\u0004\b6\u00107\u001a\u0004\b5\u0010\u0014R!\u0010<\u001a\b\u0012\u0004\u0012\u0002090\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0006\u001a\u0004\b;\u0010\u000eR\u0014\u0010@\u001a\u00020=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/profit/lottery/i;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/profit/lottery/Lottery;", "currentLottery$delegate", "Lcom/bytedance/live/datacontext/p;", "getCurrentLottery", "()Lcom/bytedance/live/datacontext/n;", "currentLottery", "Lcom/bytedance/live/datacontext/k;", "", "lotteryInfoSyncData$delegate", "getLotteryInfoSyncData", "()Lcom/bytedance/live/datacontext/k;", "lotteryInfoSyncData", "Lcom/bytedance/live/datacontext/m;", "", "hasLotteryPermission$delegate", "getHasLotteryPermission", "()Lcom/bytedance/live/datacontext/m;", "hasLotteryPermission", "", "onSubmit$delegate", "getOnSubmit", "onSubmit", "onDismissIcon$delegate", "getOnDismissIcon", "onDismissIcon", "onToolbarButtonClick$delegate", "getOnToolbarButtonClick", "onToolbarButtonClick", "", "onIconClick$delegate", "getOnIconClick", "onIconClick", "Lcom/bytedance/android/live/profit/lottery/LotteryState$b;", "onFinish$delegate", "getOnFinish", "onFinish", "Lcom/bytedance/android/live/profit/lottery/LotteryState$d;", "onRefresh$delegate", "getOnRefresh", com.alipay.sdk.m.x.d.f25926p, "Lcom/bytedance/android/live/profit/lottery/LotteryState$e;", "onReject$delegate", "getOnReject", "onReject", "onHidePanel$delegate", "getOnHidePanel", "onHidePanel", "Lcom/bytedance/android/live/profit/lottery/ParticipateStatus;", "curCandidateState$delegate", "getCurCandidateState", "getCurCandidateState$annotations", "()V", "curCandidateState", "Lorg/json/JSONObject;", "onPopupSchemaFailed$delegate", "getOnPopupSchemaFailed", "onPopupSchemaFailed", "", "getLotteryPluginStore", "()Ljava/lang/Void;", "lotteryPluginStore", "<init>", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LotteryContext extends DataContext implements i {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final com.bytedance.live.datacontext.p curCandidateState$delegate;
    private final com.bytedance.live.datacontext.p currentLottery$delegate;
    private final com.bytedance.live.datacontext.p hasLotteryPermission$delegate;
    private final com.bytedance.live.datacontext.p lotteryInfoSyncData$delegate;
    private final com.bytedance.live.datacontext.p onDismissIcon$delegate;
    private final com.bytedance.live.datacontext.p onFinish$delegate;
    private final com.bytedance.live.datacontext.p onHidePanel$delegate;
    private final com.bytedance.live.datacontext.p onIconClick$delegate;
    private final com.bytedance.live.datacontext.p onPopupSchemaFailed$delegate;
    private final com.bytedance.live.datacontext.p onRefresh$delegate;
    private final com.bytedance.live.datacontext.p onReject$delegate;
    private final com.bytedance.live.datacontext.p onSubmit$delegate;
    private final com.bytedance.live.datacontext.p onToolbarButtonClick$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "currentLottery", "getCurrentLottery()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "lotteryInfoSyncData", "getLotteryInfoSyncData()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "hasLotteryPermission", "getHasLotteryPermission()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onSubmit", "getOnSubmit()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onDismissIcon", "getOnDismissIcon()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onToolbarButtonClick", "getOnToolbarButtonClick()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onIconClick", "getOnIconClick()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onFinish", "getOnFinish()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, com.alipay.sdk.m.x.d.f25926p, "getOnRefresh()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onReject", "getOnReject()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onHidePanel", "getOnHidePanel()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "curCandidateState", "getCurCandidateState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LotteryContext.class, "onPopupSchemaFailed", "getOnPopupSchemaFailed()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    @Deprecated(message = "福袋内部请从LotteryRepository读取")
    public static /* synthetic */ void getCurCandidateState$annotations() {
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public com.bytedance.live.datacontext.m<ParticipateStatus> getCurCandidateState() {
        return (com.bytedance.live.datacontext.m) this.curCandidateState$delegate.a(this, $$delegatedProperties[11]);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public com.bytedance.live.datacontext.n<Lottery> getCurrentLottery() {
        return (com.bytedance.live.datacontext.n) this.currentLottery$delegate.a(this, $$delegatedProperties[0]);
    }

    public com.bytedance.live.datacontext.m<Boolean> getHasLotteryPermission() {
        return (com.bytedance.live.datacontext.m) this.hasLotteryPermission$delegate.a(this, $$delegatedProperties[2]);
    }

    public com.bytedance.live.datacontext.k<Object> getLotteryInfoSyncData() {
        return (com.bytedance.live.datacontext.k) this.lotteryInfoSyncData$delegate.a(this, $$delegatedProperties[1]);
    }

    public com.bytedance.live.datacontext.k<Object> getOnDismissIcon() {
        return (com.bytedance.live.datacontext.k) this.onDismissIcon$delegate.a(this, $$delegatedProperties[4]);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public com.bytedance.live.datacontext.k<LotteryState.b> getOnFinish() {
        return (com.bytedance.live.datacontext.k) this.onFinish$delegate.a(this, $$delegatedProperties[7]);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public com.bytedance.live.datacontext.k<Unit> getOnHidePanel() {
        return (com.bytedance.live.datacontext.k) this.onHidePanel$delegate.a(this, $$delegatedProperties[10]);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public com.bytedance.live.datacontext.k<Integer> getOnIconClick() {
        return (com.bytedance.live.datacontext.k) this.onIconClick$delegate.a(this, $$delegatedProperties[6]);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public com.bytedance.live.datacontext.k<JSONObject> getOnPopupSchemaFailed() {
        return (com.bytedance.live.datacontext.k) this.onPopupSchemaFailed$delegate.a(this, $$delegatedProperties[12]);
    }

    public com.bytedance.live.datacontext.k<LotteryState.d> getOnRefresh() {
        return (com.bytedance.live.datacontext.k) this.onRefresh$delegate.a(this, $$delegatedProperties[8]);
    }

    public com.bytedance.live.datacontext.k<LotteryState.e> getOnReject() {
        return (com.bytedance.live.datacontext.k) this.onReject$delegate.a(this, $$delegatedProperties[9]);
    }

    public com.bytedance.live.datacontext.k<Unit> getOnSubmit() {
        return (com.bytedance.live.datacontext.k) this.onSubmit$delegate.a(this, $$delegatedProperties[3]);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public com.bytedance.live.datacontext.k<Unit> getOnToolbarButtonClick() {
        return (com.bytedance.live.datacontext.k) this.onToolbarButtonClick$delegate.a(this, $$delegatedProperties[5]);
    }

    /* JADX INFO: renamed from: getLotteryPluginStore, reason: collision with other method in class */
    public Void m8186getLotteryPluginStore() {
        throw new NotImplementedError("Should not be used by Lottery implementation");
    }

    public LotteryContext() {
        this.currentLottery$delegate = com.bytedance.live.datacontext.q.c(this);
        this.lotteryInfoSyncData$delegate = com.bytedance.live.datacontext.e.b(this);
        this.hasLotteryPermission$delegate = com.bytedance.live.datacontext.q.d(this, Boolean.FALSE);
        this.onSubmit$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onDismissIcon$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onToolbarButtonClick$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onIconClick$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onFinish$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onRefresh$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onReject$delegate = com.bytedance.live.datacontext.e.b(this);
        this.onHidePanel$delegate = com.bytedance.live.datacontext.e.b(this);
        this.curCandidateState$delegate = com.bytedance.live.datacontext.q.d(this, ParticipateStatus.NOTPARTICIPATED);
        this.onPopupSchemaFailed$delegate = com.bytedance.live.datacontext.e.b(this);
    }

    @Override // com.bytedance.android.live.profit.lottery.i
    public /* bridge */ /* synthetic */ o getLotteryPluginStore() {
        return (o) m8186getLotteryPluginStore();
    }
}
