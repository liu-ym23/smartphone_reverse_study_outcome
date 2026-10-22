package W3;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.screenops.TriggerType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u001a\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u001b"}, d2 = {"LW3/d;", "", "LW3/c;", "rule", "Lcom/stepos/ability/screenops/TriggerType;", "triggerType", "", "activityName", "<init>", "(LW3/c;Lcom/stepos/ability/screenops/TriggerType;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "LW3/c;", Const.INTENT_KEY_PKGNAME, "()LW3/c;", "Lcom/stepos/ability/screenops/TriggerType;", "c", "()Lcom/stepos/ability/screenops/TriggerType;", "Ljava/lang/String;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: W3.d, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ScreenOpsEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final MonitorRule rule;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final TriggerType triggerType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String activityName;

    public ScreenOpsEvent(MonitorRule rule, TriggerType triggerType, String activityName) {
        p.i(rule, "rule");
        p.i(triggerType, "triggerType");
        p.i(activityName, "activityName");
        this.rule = rule;
        this.triggerType = triggerType;
        this.activityName = activityName;
    }

    /* renamed from: a, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* renamed from: b, reason: from getter */
    public final MonitorRule getRule() {
        return this.rule;
    }

    /* renamed from: c, reason: from getter */
    public final TriggerType getTriggerType() {
        return this.triggerType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenOpsEvent)) {
            return false;
        }
        ScreenOpsEvent screenOpsEvent = (ScreenOpsEvent) other;
        return p.d(this.rule, screenOpsEvent.rule) && this.triggerType == screenOpsEvent.triggerType && p.d(this.activityName, screenOpsEvent.activityName);
    }

    public int hashCode() {
        return (((this.rule.hashCode() * 31) + this.triggerType.hashCode()) * 31) + this.activityName.hashCode();
    }

    public String toString() {
        return "ScreenOpsEvent(rule=" + this.rule + ", triggerType=" + this.triggerType + ", activityName=" + this.activityName + ")";
    }
}
