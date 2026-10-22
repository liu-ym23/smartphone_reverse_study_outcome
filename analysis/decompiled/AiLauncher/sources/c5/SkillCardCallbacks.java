package c5;

import android.view.View;
import c5.x;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.SkillItem;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b \u0010\u001eR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b!\u0010\u001eR)\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b%\u0010\u001eR!\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lc5/l;", "", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/agent/skill/SkillItem;", "LY8/t;", "onCardClick", "onInstall", "onCancel", "onRetry", "Lkotlin/Function2;", "", "onToggle", "Lc5/x$c;", "onGroupHeaderClick", "Lkotlin/Function0;", "Landroid/view/View;", "provideEssentialSlotView", "<init>", "(Lp9/l;Lp9/l;Lp9/l;Lp9/l;Lp9/p;Lp9/l;Lp9/a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lp9/l;", Const.INTENT_KEY_PKGNAME, "()Lp9/l;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "e", "Lp9/p;", "f", "()Lp9/p;", "c", "Lp9/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lp9/a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: c5.l, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SkillCardCallbacks {
    private final InterfaceC5074l<SkillItem, Y8.t> onCancel;
    private final InterfaceC5074l<SkillItem, Y8.t> onCardClick;
    private final InterfaceC5074l<x.GroupHeader, Y8.t> onGroupHeaderClick;
    private final InterfaceC5074l<SkillItem, Y8.t> onInstall;
    private final InterfaceC5074l<SkillItem, Y8.t> onRetry;
    private final p9.p<SkillItem, Boolean, Y8.t> onToggle;
    private final InterfaceC5063a<View> provideEssentialSlotView;

    /* JADX WARN: Multi-variable type inference failed */
    public SkillCardCallbacks(InterfaceC5074l<? super SkillItem, Y8.t> onCardClick, InterfaceC5074l<? super SkillItem, Y8.t> onInstall, InterfaceC5074l<? super SkillItem, Y8.t> onCancel, InterfaceC5074l<? super SkillItem, Y8.t> onRetry, p9.p<? super SkillItem, ? super Boolean, Y8.t> onToggle, InterfaceC5074l<? super x.GroupHeader, Y8.t> interfaceC5074l, InterfaceC5063a<? extends View> interfaceC5063a) {
        kotlin.jvm.internal.p.i(onCardClick, "onCardClick");
        kotlin.jvm.internal.p.i(onInstall, "onInstall");
        kotlin.jvm.internal.p.i(onCancel, "onCancel");
        kotlin.jvm.internal.p.i(onRetry, "onRetry");
        kotlin.jvm.internal.p.i(onToggle, "onToggle");
        this.onCardClick = onCardClick;
        this.onInstall = onInstall;
        this.onCancel = onCancel;
        this.onRetry = onRetry;
        this.onToggle = onToggle;
        this.onGroupHeaderClick = interfaceC5074l;
        this.provideEssentialSlotView = interfaceC5063a;
    }

    public final InterfaceC5074l<SkillItem, Y8.t> a() {
        return this.onCancel;
    }

    public final InterfaceC5074l<SkillItem, Y8.t> b() {
        return this.onCardClick;
    }

    public final InterfaceC5074l<x.GroupHeader, Y8.t> c() {
        return this.onGroupHeaderClick;
    }

    public final InterfaceC5074l<SkillItem, Y8.t> d() {
        return this.onInstall;
    }

    public final InterfaceC5074l<SkillItem, Y8.t> e() {
        return this.onRetry;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillCardCallbacks)) {
            return false;
        }
        SkillCardCallbacks skillCardCallbacks = (SkillCardCallbacks) other;
        return kotlin.jvm.internal.p.d(this.onCardClick, skillCardCallbacks.onCardClick) && kotlin.jvm.internal.p.d(this.onInstall, skillCardCallbacks.onInstall) && kotlin.jvm.internal.p.d(this.onCancel, skillCardCallbacks.onCancel) && kotlin.jvm.internal.p.d(this.onRetry, skillCardCallbacks.onRetry) && kotlin.jvm.internal.p.d(this.onToggle, skillCardCallbacks.onToggle) && kotlin.jvm.internal.p.d(this.onGroupHeaderClick, skillCardCallbacks.onGroupHeaderClick) && kotlin.jvm.internal.p.d(this.provideEssentialSlotView, skillCardCallbacks.provideEssentialSlotView);
    }

    public final p9.p<SkillItem, Boolean, Y8.t> f() {
        return this.onToggle;
    }

    public final InterfaceC5063a<View> g() {
        return this.provideEssentialSlotView;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.onCardClick.hashCode() * 31) + this.onInstall.hashCode()) * 31) + this.onCancel.hashCode()) * 31) + this.onRetry.hashCode()) * 31) + this.onToggle.hashCode()) * 31;
        InterfaceC5074l<x.GroupHeader, Y8.t> interfaceC5074l = this.onGroupHeaderClick;
        int iHashCode2 = (iHashCode + (interfaceC5074l == null ? 0 : interfaceC5074l.hashCode())) * 31;
        InterfaceC5063a<View> interfaceC5063a = this.provideEssentialSlotView;
        return iHashCode2 + (interfaceC5063a != null ? interfaceC5063a.hashCode() : 0);
    }

    public String toString() {
        return "SkillCardCallbacks(onCardClick=" + this.onCardClick + ", onInstall=" + this.onInstall + ", onCancel=" + this.onCancel + ", onRetry=" + this.onRetry + ", onToggle=" + this.onToggle + ", onGroupHeaderClick=" + this.onGroupHeaderClick + ", provideEssentialSlotView=" + this.provideEssentialSlotView + ")";
    }

    public /* synthetic */ SkillCardCallbacks(InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, InterfaceC5074l interfaceC5074l3, InterfaceC5074l interfaceC5074l4, p9.p pVar, InterfaceC5074l interfaceC5074l5, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this(interfaceC5074l, interfaceC5074l2, interfaceC5074l3, interfaceC5074l4, pVar, (i10 & 32) != 0 ? null : interfaceC5074l5, (i10 & 64) != 0 ? null : interfaceC5063a);
    }
}
