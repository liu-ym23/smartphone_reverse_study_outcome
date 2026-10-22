package com.obric.memorydata.sdk.screencapture.rule;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.Gson;
import com.obric.memorydata.sdk.accessibility.AccessibilityCondition;
import com.obric.memorydata.sdk.screencapture.event.AppAccessibilityEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppAccessibilityEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppAccessibilityEventRule extends ScreenEventRule {
    public static final CREATOR CREATOR = null;
    private final List<String> activityNameWhiteList;
    private final b conditionMatchRule;
    private final List<AccessibilityCondition> conditions;
    private final ScreenEvent.a eventType;
    private JSONObject extras;
    private final String id;
    private final long matchTimeout;
    private final String maxVersion;
    private final String minVersion;
    private final String packageName;
    private final boolean pollCheck;
    private final List<AccessibilityCondition> resetConditions;
    private boolean resetWhenMatched;

    /* JADX INFO: compiled from: AppAccessibilityEventRule.kt */
    public static final class CREATOR implements Parcelable.Creator<AppAccessibilityEventRule> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppAccessibilityEventRule createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppAccessibilityEventRule[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppAccessibilityEventRule createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = new Gson().fromJson(r2.readString(), AppAccessibilityEventRule.class);
            o.c(r1, "fromJson(...)");
            return (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r1, AppAccessibilityEventRule.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppAccessibilityEventRule[] newArray(int r1) {
            return new AppAccessibilityEventRule[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ AppAccessibilityEventRule copy$default(AppAccessibilityEventRule r13, String r14, String r15, String r16, String r17, List r18, b r19, List r20, boolean r21, List r22, long r23, boolean r25, int r26, Object r27) {
        List<AccessibilityCondition> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        List<AccessibilityCondition> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        if ((r26 & 1) == 0) goto L5;
        String r5 = r13.id;
    L7:
        if ((r26 & 2) == 0) goto L9;
        String r6 = r13.packageName;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r7 = r13.minVersion;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r8 = r13.maxVersion;
    L19:
        if ((r26 & 16) == 0) goto L22;
        r2 = r13.conditions;
    L22:
        if ((r26 & 32) == 0) goto L24;
        b r9 = r13.conditionMatchRule;
    L26:
        if ((r26 & 64) == 0) goto L29;
        r4 = r13.resetConditions;
    L29:
        if ((r26 & 128) == 0) goto L31;
        boolean r10 = r13.pollCheck;
    L33:
        if ((r26 & 256) == 0) goto L36;
        r3 = r13.activityNameWhiteList;
    L36:
        if ((r26 & 512) == 0) goto L38;
        long r11 = r13.matchTimeout;
    L40:
        if ((r26 & 1024) == 0) goto L42;
        boolean r1 = r13.resetWhenMatched;
    L44:
        return r13.copy(r5, r6, r7, r8, r2, r9, r4, r10, r3, r11, r1);
    L42:
        r1 = r25;
        goto L44
    L38:
        r11 = r23;
        goto L40
    L31:
        r10 = r21;
        goto L33
    L24:
        r9 = r19;
        goto L26
    L17:
        r8 = r17;
        goto L19
    L13:
        r7 = r16;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r5 = r14;
        goto L7
    }

    public final String component1() {
        return this.id;
    }

    public final long component10() {
        return this.matchTimeout;
    }

    public final boolean component11() {
        return this.resetWhenMatched;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.minVersion;
    }

    public final String component4() {
        return this.maxVersion;
    }

    public final List<AccessibilityCondition> component5() {
        return this.conditions;
    }

    public final b component6() {
        return this.conditionMatchRule;
    }

    public final List<AccessibilityCondition> component7() {
        return this.resetConditions;
    }

    public final boolean component8() {
        return this.pollCheck;
    }

    public final List<String> component9() {
        return this.activityNameWhiteList;
    }

    public final AppAccessibilityEventRule copy(String r16, String r17, String r18, String r19, List<AccessibilityCondition> r20, b r21, List<AccessibilityCondition> r22, boolean r23, List<String> r24, long r25, boolean r27) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        o.e(r16, DbHelper.COL_ID);
        o.e(r17, "packageName");
        o.e(r7, "conditions");
        o.e(r21, "conditionMatchRule");
        o.e(r9, "resetConditions");
        o.e(r11, "activityNameWhiteList");
        return new AppAccessibilityEventRule(r16, r17, r18, r19, r7, r21, r9, r23, r11, r25, r27);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AppAccessibilityEventRule.class) == true) goto L8;
        return false;
    L8:
        AppAccessibilityEventRule r10 = (AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r9, AppAccessibilityEventRule.class, "com.obric.aiagent.plugin");
        if (o.a(this.id, r10.id) == true) goto L12;
        return false;
    L12:
        if (o.a(this.packageName, r10.packageName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.minVersion, r10.minVersion) == true) goto L18;
        return false;
    L18:
        if (o.a(this.maxVersion, r10.maxVersion) == true) goto L21;
        return false;
    L21:
        if (o.a(this.conditions, r10.conditions) == true) goto L24;
        return false;
    L24:
        if (this.conditionMatchRule == r10.conditionMatchRule) goto L27;
        return false;
    L27:
        if (o.a(this.resetConditions, r10.resetConditions) == true) goto L30;
        return false;
    L30:
        if (this.pollCheck == r10.pollCheck) goto L33;
        return false;
    L33:
        if (o.a(this.activityNameWhiteList, r10.activityNameWhiteList) == true) goto L36;
        return false;
    L36:
        if (this.matchTimeout == r10.matchTimeout) goto L39;
        return false;
    L39:
        if (this.resetWhenMatched == r10.resetWhenMatched) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.packageName.hashCode()) * 31;
        String r1 = this.minVersion;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.maxVersion;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((((((((r4 + r2) * 31) + this.conditions.hashCode()) * 31) + this.conditionMatchRule.hashCode()) * 31) + this.resetConditions.hashCode()) * 31) + Boolean.hashCode(this.pollCheck)) * 31) + this.activityNameWhiteList.hashCode()) * 31) + Long.hashCode(this.matchTimeout)) * 31) + Boolean.hashCode(this.resetWhenMatched);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AppAccessibilityEventRule(id=").append(this.id).append(", packageName=").append(this.packageName).append(", minVersion=").append(this.minVersion).append(", maxVersion=").append(this.maxVersion).append(", conditions=").append(this.conditions).append(", conditionMatchRule=").append(this.conditionMatchRule).append(", resetConditions=").append(this.resetConditions).append(", pollCheck=").append(this.pollCheck).append(", activityNameWhiteList=").append(this.activityNameWhiteList).append(", matchTimeout=").append(this.matchTimeout).append(", resetWhenMatched=").append(this.resetWhenMatched).append(')');
        return r0.toString();
    }

    public final String getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getMinVersion() {
        return this.minVersion;
    }

    public final String getMaxVersion() {
        return this.maxVersion;
    }

    public final List<AccessibilityCondition> getConditions() {
        return this.conditions;
    }

    public final b getConditionMatchRule() {
        return this.conditionMatchRule;
    }

    public /* synthetic */ AppAccessibilityEventRule(String r17, String r18, String r19, String r20, List r21, b r22, List r23, boolean r24, List r25, long r26, boolean r28, int r29, h r30) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        if ((r29 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r29 & 8) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r29 & 64) == 0) goto L13;
        r1 = p.b();
    L13:
        List r10 = r1;
        if ((r29 & 128) == 0) goto L16;
        boolean r11 = false;
    L18:
        if ((r29 & 256) == 0) goto L20;
        List r12 = p.b();
    L22:
        if ((r29 & 512) == 0) goto L24;
        long r13 = 300000;
    L26:
        if ((r29 & 1024) == 0) goto L28;
        boolean r15 = false;
    L29:
        this(r17, r18, r6, r7, r8, r22, r10, r11, r12, r13, r15);
        return;
    L28:
        r15 = r28;
        goto L29
    L24:
        r13 = r26;
        goto L26
    L20:
        r12 = r2;
        goto L22
    L16:
        r11 = r24;
        goto L18
    L9:
        r7 = r20;
        goto L11
    L5:
        r6 = r19;
        goto L7
    }

    public final List<AccessibilityCondition> getResetConditions() {
        return this.resetConditions;
    }

    public final boolean getPollCheck() {
        return this.pollCheck;
    }

    public final List<String> getActivityNameWhiteList() {
        return this.activityNameWhiteList;
    }

    public final long getMatchTimeout() {
        return this.matchTimeout;
    }

    public final boolean getResetWhenMatched() {
        return this.resetWhenMatched;
    }

    public final void setResetWhenMatched(boolean r1) {
        this.resetWhenMatched = r1;
    }

    public AppAccessibilityEventRule(String r3, String r4, String r5, String r6, List<AccessibilityCondition> r7, b r8, List<AccessibilityCondition> r9, boolean r10, List<String> r11, long r12, boolean r14) {
        List<AccessibilityCondition> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<AccessibilityCondition> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r3, DbHelper.COL_ID);
        o.e(r4, "packageName");
        o.e(r13, "conditions");
        o.e(r8, "conditionMatchRule");
        o.e(r15, "resetConditions");
        o.e(r16, "activityNameWhiteList");
        this.id = r3;
        this.packageName = r4;
        this.minVersion = r5;
        this.maxVersion = r6;
        this.conditions = r13;
        this.conditionMatchRule = r8;
        this.resetConditions = r15;
        this.pollCheck = r10;
        this.activityNameWhiteList = r16;
        this.matchTimeout = r12;
        this.resetWhenMatched = r14;
        this.eventType = ScreenEvent.a.f33865d;
    }

    public final JSONObject getExtras() {
        return this.extras;
    }

    public final void setExtras(JSONObject r1) {
        this.extras = r1;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public boolean isMatch(ScreenEvent r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "event");
        if (ZeusTransformUtils.instanceOf(r3, AppAccessibilityEvent.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (isFilter$memoryDataSDK_obricRelease(r3.getPackageName(), r5) == true) goto L9;
        if (o.a(((AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r3, AppAccessibilityEvent.class, "com.obric.aiagent.plugin")).getAccessibilityRule().id, this.id) == false) goto L9;
        return true;
    }
}
