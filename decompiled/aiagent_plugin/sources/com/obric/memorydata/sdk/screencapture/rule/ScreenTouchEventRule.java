package com.obric.memorydata.sdk.screencapture.rule;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ScreenTouchEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ScreenTouchEventRule extends ScreenEventRule {
    public static final CREATOR CREATOR = null;
    public static final int OPTION_IGNORE_WHEN_NOTIFICATION_SHOWN = 1;
    public static final int OPTION_NONE = 0;
    private final ScreenEvent.a eventType;
    private final int options;
    private final List<ScreenTouchEvent.b> targetActions;

    /* JADX INFO: compiled from: ScreenTouchEventRule.kt */
    public static final class CREATOR implements Parcelable.Creator<ScreenTouchEventRule> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenTouchEventRule createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScreenTouchEventRule[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScreenTouchEventRule createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = new Gson().fromJson(r2.readString(), ScreenTouchEventRule.class);
            o.c(r1, "fromJson(...)");
            return (ScreenTouchEventRule) ZeusTransformUtils.preCheckCast(r1, ScreenTouchEventRule.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScreenTouchEventRule[] newArray(int r1) {
            return new ScreenTouchEventRule[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenTouchEventRule() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ScreenTouchEventRule copy$default(ScreenTouchEventRule r1, List r2, int r3, int r4, Object r5) {
        List<ScreenTouchEvent.b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.targetActions;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.options;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<ScreenTouchEvent.b> component1() {
        return this.targetActions;
    }

    public final int component2() {
        return this.options;
    }

    public final ScreenTouchEventRule copy(List<? extends ScreenTouchEvent.b> r2, int r3) {
        return new ScreenTouchEventRule((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenTouchEventRule.class) == true) goto L8;
        return false;
    L8:
        ScreenTouchEventRule r6 = (ScreenTouchEventRule) ZeusTransformUtils.preCheckCast(r5, ScreenTouchEventRule.class, "com.obric.aiagent.plugin");
        if (o.a(this.targetActions, r6.targetActions) == true) goto L12;
        return false;
    L12:
        if (this.options == r6.options) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<ScreenTouchEvent.b> r0 = this.targetActions;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Integer.hashCode(this.options);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ScreenTouchEventRule(targetActions=" + this.targetActions + ", options=" + this.options + ')';
    }

    public /* synthetic */ ScreenTouchEventRule(List r2, int r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r6, r3);
    }

    public final List<ScreenTouchEvent.b> getTargetActions() {
        return this.targetActions;
    }

    public final int getOptions() {
        return this.options;
    }

    public ScreenTouchEventRule(List<? extends ScreenTouchEvent.b> r3, int r4) {
        this.targetActions = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.options = r4;
        this.eventType = ScreenEvent.a.f33862a;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public boolean isMatch(ScreenEvent r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "event");
        if (ZeusTransformUtils.instanceOf(r4, ScreenTouchEvent.class) == true) goto L6;
        return false;
    L6:
        if (isFilter$memoryDataSDK_obricRelease(r4.getPackageName(), r6) == false) goto L8;
        return false;
    L8:
        List<ScreenTouchEvent.b> r3 = this.targetActions;
        if (r3 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        if (r3.contains(((ScreenTouchEvent) ZeusTransformUtils.preCheckCast(r4, ScreenTouchEvent.class, "com.obric.aiagent.plugin")).getAction()) == true) goto L14;
        r7 = false;
        goto L15
    }

    public final boolean matchScrollAction(String r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "eventPkg");
        if (isFilter$memoryDataSDK_obricRelease(r3, r5) == false) goto L5;
        return false;
    L5:
        List<ScreenTouchEvent.b> r6 = this.targetActions;
        if (r6 != null) goto L8;
    L11:
        return true;
    L8:
        if (r6.contains(ScreenTouchEvent.b.f33875d) == true) goto L11;
        if (this.targetActions.contains(ScreenTouchEvent.b.f33876e) == true) goto L11;
        return false;
    }

    public final boolean hasOption(int r1) {
        if ((this.options & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
