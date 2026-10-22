package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.AppAccessibilityEventRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppAccessiblityEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppAccessibilityEvent extends ScreenEvent {
    private final AppAccessibilityEventRule accessibilityRule;
    private final ScreenEvent.a eventType;

    public static /* synthetic */ AppAccessibilityEvent copy$default(AppAccessibilityEvent r0, AppAccessibilityEventRule r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.accessibilityRule;
    L6:
        return r0.copy(r1);
    }

    public final AppAccessibilityEventRule component1() {
        return this.accessibilityRule;
    }

    public final AppAccessibilityEvent copy(AppAccessibilityEventRule r1) {
        o.e(r1, "accessibilityRule");
        return new AppAccessibilityEvent(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppAccessibilityEvent.class) == true) goto L8;
        return false;
    L8:
        AppAccessibilityEvent r6 = (AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r5, AppAccessibilityEvent.class, "com.obric.aiagent.plugin");
        if (o.a(this.accessibilityRule, r6.accessibilityRule) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.accessibilityRule.hashCode();
    }

    public String toString() {
        return "AppAccessibilityEvent(accessibilityRule=" + this.accessibilityRule + ')';
    }

    public final AppAccessibilityEventRule getAccessibilityRule() {
        return this.accessibilityRule;
    }

    public AppAccessibilityEvent(AppAccessibilityEventRule r2) {
        o.e(r2, "accessibilityRule");
        super(null);
        this.accessibilityRule = r2;
        this.eventType = ScreenEvent.a.f33865d;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    public AppAccessibilityEvent(Parcel r3) {
        o.e(r3, "parcel");
        Parcelable r4 = r3.readParcelable(ScreenEvent.class.getClassLoader());
        o.a(r4);
        this((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r4, AppAccessibilityEventRule.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        super.writeToParcel(r3, r4);
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.accessibilityRule, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }
}
