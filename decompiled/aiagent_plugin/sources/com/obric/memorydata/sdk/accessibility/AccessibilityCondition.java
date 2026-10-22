package com.obric.memorydata.sdk.accessibility;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.sdk.screencapture.rule.c;
import com.obric.memorydata.sdk.screencapture.rule.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityCondition.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AccessibilityCondition implements Parcelable {
    public static final Parcelable.Creator<AccessibilityCondition> CREATOR = null;
    private final List<String> activityList;
    private final String activityName;
    private final int eventType;
    private final String keywordMatchExpression;
    private final List<KeywordMatchRule> keywordMatchRules;
    private final c keywordsMatchRule;
    private boolean matched;
    private final boolean optional;
    private final int resetToStep;
    private final ScreenshotOption screenshotOpt;
    private final long timeThreshold;
    private final d touchRectMatchRule;
    private final List<Rect> touchRects;
    private final VisibleNodeCountCondition visibleNodeCountCondition;

    /* JADX INFO: compiled from: AccessibilityCondition.kt */
    public static final class Creator implements Parcelable.Creator<AccessibilityCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AccessibilityCondition createFromParcel(Parcel r22) {
            o.e(r22, "parcel");
            int r3 = r22.readInt();
            String r4 = r22.readString();
            List r1 = (List) ZeusTransformUtils.preCheckCast(r22.createStringArrayList(), List.class, "com.obric.aiagent.plugin");
            int r2 = r22.readInt();
            ArrayList r6 = new ArrayList(r2);
            int r8 = 0;
        L3:
            if (r8 == r2) goto L5;
            r6.add(KeywordMatchRule.CREATOR.createFromParcel(r22));
            r8 = r8 + 1;
            goto L3
        L5:
            List r7 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
            c r9 = c.valueOf(r22.readString());
            String r10 = r22.readString();
            ScreenshotOption r11 = null;
            if (r22.readInt() != 0) goto L8;
            VisibleNodeCountCondition r5 = null;
        L9:
            VisibleNodeCountCondition r12 = (VisibleNodeCountCondition) ZeusTransformUtils.preCheckCast(r5, VisibleNodeCountCondition.class, "com.obric.aiagent.plugin");
            if (r22.readInt() != 0) goto L12;
            ArrayList r13 = null;
        L15:
            List r14 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
            d r15 = d.valueOf(r22.readString());
            long r16 = r22.readLong();
            if (r22.readInt() == 0) goto L18;
            boolean r17 = true;
        L20:
            if (r22.readInt() == 0) goto L23;
            r11 = ScreenshotOption.CREATOR.createFromParcel(r22);
        L23:
            ScreenshotOption r18 = (ScreenshotOption) ZeusTransformUtils.preCheckCast(r11, ScreenshotOption.class, "com.obric.aiagent.plugin");
            int r19 = r22.readInt();
            if (r22.readInt() == 0) goto L26;
            boolean r0 = true;
        L28:
            return new AccessibilityCondition(r3, r4, r1, r7, r9, r10, r12, r14, r15, r16, r17, r18, r19, r0);
        L26:
            r0 = false;
            goto L28
        L18:
            r17 = false;
            goto L20
        L12:
            int r20 = r22.readInt();
            r13 = new ArrayList(r20);
            int r110 = 0;
        L13:
            if (r110 == r20) goto L15;
            r13.add(r22.readParcelable(AccessibilityCondition.class.getClassLoader()));
            r110 = r110 + 1;
            goto L13
        L8:
            r5 = VisibleNodeCountCondition.CREATOR.createFromParcel(r22);
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AccessibilityCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AccessibilityCondition[] newArray(int r1) {
            return new AccessibilityCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AccessibilityCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ AccessibilityCondition copy$default(AccessibilityCondition r16, int r17, String r18, List r19, List r20, c r21, String r22, VisibleNodeCountCondition r23, List r24, d r25, long r26, boolean r28, ScreenshotOption r29, int r30, boolean r31, int r32, Object r33) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        List<KeywordMatchRule> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        List<Rect> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        if ((r32 & 1) == 0) goto L5;
        int r5 = r16.eventType;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r6 = r16.activityName;
    L11:
        if ((r32 & 4) == 0) goto L14;
        r2 = r16.activityList;
    L14:
        if ((r32 & 8) == 0) goto L17;
        r4 = r16.keywordMatchRules;
    L17:
        if ((r32 & 16) == 0) goto L19;
        c r7 = r16.keywordsMatchRule;
    L21:
        if ((r32 & 32) == 0) goto L23;
        String r8 = r16.keywordMatchExpression;
    L25:
        if ((r32 & 64) == 0) goto L27;
        VisibleNodeCountCondition r9 = r16.visibleNodeCountCondition;
    L29:
        if ((r32 & 128) == 0) goto L32;
        r3 = r16.touchRects;
    L32:
        if ((r32 & 256) == 0) goto L34;
        d r10 = r16.touchRectMatchRule;
    L36:
        if ((r32 & 512) == 0) goto L38;
        long r11 = r16.timeThreshold;
    L40:
        if ((r32 & 1024) == 0) goto L42;
        boolean r13 = r16.optional;
    L44:
        if ((r32 & 2048) == 0) goto L46;
        ScreenshotOption r14 = r16.screenshotOpt;
    L48:
        if ((r32 & 4096) == 0) goto L50;
        int r15 = r16.resetToStep;
    L52:
        if ((r32 & 8192) == 0) goto L54;
        boolean r1 = r16.matched;
    L56:
        return r16.copy(r5, r6, r2, r4, r7, r8, r9, r3, r10, r11, r13, r14, r15, r1);
    L54:
        r1 = r31;
        goto L56
    L50:
        r15 = r30;
        goto L52
    L46:
        r14 = r29;
        goto L48
    L42:
        r13 = r28;
        goto L44
    L38:
        r11 = r26;
        goto L40
    L34:
        r10 = r25;
        goto L36
    L27:
        r9 = r23;
        goto L29
    L23:
        r8 = r22;
        goto L25
    L19:
        r7 = r21;
        goto L21
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }

    public final int component1() {
        return this.eventType;
    }

    public final long component10() {
        return this.timeThreshold;
    }

    public final boolean component11() {
        return this.optional;
    }

    public final ScreenshotOption component12() {
        return this.screenshotOpt;
    }

    public final int component13() {
        return this.resetToStep;
    }

    public final boolean component14() {
        return this.matched;
    }

    public final String component2() {
        return this.activityName;
    }

    public final List<String> component3() {
        return this.activityList;
    }

    public final List<KeywordMatchRule> component4() {
        return this.keywordMatchRules;
    }

    public final c component5() {
        return this.keywordsMatchRule;
    }

    public final String component6() {
        return this.keywordMatchExpression;
    }

    public final VisibleNodeCountCondition component7() {
        return this.visibleNodeCountCondition;
    }

    public final List<Rect> component8() {
        return this.touchRects;
    }

    public final d component9() {
        return this.touchRectMatchRule;
    }

    public final AccessibilityCondition copy(int r19, String r20, List<String> r21, List<KeywordMatchRule> r22, c r23, String r24, VisibleNodeCountCondition r25, List<Rect> r26, d r27, long r28, boolean r30, ScreenshotOption r31, int r32, boolean r33) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        o.e(r20, "activityName");
        o.e(r6, "keywordMatchRules");
        o.e(r23, "keywordsMatchRule");
        o.e(r27, "touchRectMatchRule");
        return new AccessibilityCondition(r19, r20, r5, r6, r23, r24, r25, r10, r27, r28, r30, r31, r32, r33);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AccessibilityCondition.class) == true) goto L8;
        return false;
    L8:
        AccessibilityCondition r10 = (AccessibilityCondition) ZeusTransformUtils.preCheckCast(r9, AccessibilityCondition.class, "com.obric.aiagent.plugin");
        if (this.eventType == r10.eventType) goto L12;
        return false;
    L12:
        if (o.a(this.activityName, r10.activityName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.activityList, r10.activityList) == true) goto L18;
        return false;
    L18:
        if (o.a(this.keywordMatchRules, r10.keywordMatchRules) == true) goto L21;
        return false;
    L21:
        if (this.keywordsMatchRule == r10.keywordsMatchRule) goto L24;
        return false;
    L24:
        if (o.a(this.keywordMatchExpression, r10.keywordMatchExpression) == true) goto L27;
        return false;
    L27:
        if (o.a(this.visibleNodeCountCondition, r10.visibleNodeCountCondition) == true) goto L30;
        return false;
    L30:
        if (o.a(this.touchRects, r10.touchRects) == true) goto L33;
        return false;
    L33:
        if (this.touchRectMatchRule == r10.touchRectMatchRule) goto L36;
        return false;
    L36:
        if (this.timeThreshold == r10.timeThreshold) goto L39;
        return false;
    L39:
        if (this.optional == r10.optional) goto L42;
        return false;
    L42:
        if (o.a(this.screenshotOpt, r10.screenshotOpt) == true) goto L45;
        return false;
    L45:
        if (this.resetToStep == r10.resetToStep) goto L48;
        return false;
    L48:
        if (this.matched == r10.matched) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.eventType) * 31) + this.activityName.hashCode()) * 31;
        List<String> r1 = this.activityList;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.keywordMatchRules.hashCode()) * 31) + this.keywordsMatchRule.hashCode()) * 31;
        String r5 = this.keywordMatchExpression;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        VisibleNodeCountCondition r8 = this.visibleNodeCountCondition;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<Rect> r11 = this.touchRects;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((((r10 + r12) * 31) + this.touchRectMatchRule.hashCode()) * 31) + Long.hashCode(this.timeThreshold)) * 31) + Boolean.hashCode(this.optional)) * 31;
        ScreenshotOption r14 = this.screenshotOpt;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((((r13 + r2) * 31) + Integer.hashCode(this.resetToStep)) * 31) + Boolean.hashCode(this.matched);
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AccessibilityCondition(eventType=").append(this.eventType).append(", activityName=").append(this.activityName).append(", activityList=").append(this.activityList).append(", keywordMatchRules=").append(this.keywordMatchRules).append(", keywordsMatchRule=").append(this.keywordsMatchRule).append(", keywordMatchExpression=").append(this.keywordMatchExpression).append(", visibleNodeCountCondition=").append(this.visibleNodeCountCondition).append(", touchRects=").append(this.touchRects).append(", touchRectMatchRule=").append(this.touchRectMatchRule).append(", timeThreshold=").append(this.timeThreshold).append(", optional=").append(this.optional).append(", screenshotOpt=");
        r0.append(this.screenshotOpt).append(", resetToStep=").append(this.resetToStep).append(", matched=").append(this.matched).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r7, int r8) {
        o.e(r7, "dest");
        r7.writeInt(this.eventType);
        r7.writeString(this.activityName);
        r7.writeStringList(this.activityList);
        List<KeywordMatchRule> r0 = this.keywordMatchRules;
        r7.writeInt(r0.size());
        Iterator<KeywordMatchRule> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((KeywordMatchRule) ZeusTransformUtils.preCheckCast(r1.next(), KeywordMatchRule.class, "com.obric.aiagent.plugin")).writeToParcel(r7, r8);
        goto L4
    L6:
        r7.writeString(this.keywordsMatchRule.name());
        r7.writeString(this.keywordMatchExpression);
        VisibleNodeCountCondition r2 = this.visibleNodeCountCondition;
        if (r2 != null) goto L9;
        r7.writeInt(0);
    L10:
        List<Rect> r3 = this.touchRects;
        if (r3 != null) goto L13;
        r7.writeInt(0);
    L17:
        r7.writeString(this.touchRectMatchRule.name());
        r7.writeLong(this.timeThreshold);
        r7.writeInt(this.optional ? 1 : 0);
        ScreenshotOption r4 = this.screenshotOpt;
        if (r4 != null) goto L20;
        r7.writeInt(0);
    L21:
        r7.writeInt(this.resetToStep);
        r7.writeInt(this.matched ? 1 : 0);
        return;
    L20:
        r7.writeInt(1);
        r4.writeToParcel(r7, r8);
        goto L21
    L13:
        r7.writeInt(1);
        r7.writeInt(r3.size());
        Iterator<Rect> r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r7.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5.next(), Parcelable.class, "com.obric.aiagent.plugin"), r8);
        goto L15
    L9:
        r7.writeInt(1);
        r2.writeToParcel(r7, r8);
        goto L10
    }

    public AccessibilityCondition(int r10, String r11, List<String> r12, List<KeywordMatchRule> r13, c r14, String r15, VisibleNodeCountCondition r16, List<Rect> r17, d r18, long r19, boolean r21, ScreenshotOption r22, int r23, boolean r24) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List<KeywordMatchRule> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        List<Rect> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        o.e(r11, "activityName");
        o.e(r6, "keywordMatchRules");
        o.e(r14, "keywordsMatchRule");
        o.e(r18, "touchRectMatchRule");
        this.eventType = r10;
        this.activityName = r11;
        this.activityList = r4;
        this.keywordMatchRules = r6;
        this.keywordsMatchRule = r14;
        this.keywordMatchExpression = r15;
        this.visibleNodeCountCondition = r16;
        this.touchRects = r5;
        this.touchRectMatchRule = r18;
        this.timeThreshold = r19;
        this.optional = r21;
        this.screenshotOpt = r22;
        this.resetToStep = r23;
        this.matched = r24;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final List<String> getActivityList() {
        return this.activityList;
    }

    public /* synthetic */ AccessibilityCondition(int r23, String r24, List r25, List r26, c r27, String r28, VisibleNodeCountCondition r29, List r30, d r31, long r32, boolean r34, ScreenshotOption r35, int r36, boolean r37, int r38, h r39) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        if ((r38 & 4) == 0) goto L5;
        List r9 = null;
    L7:
        if ((r38 & 8) == 0) goto L9;
        r3 = p.b();
    L9:
        List r10 = r3;
        if ((r38 & 16) == 0) goto L12;
        c r11 = c.f33886a;
    L14:
        if ((r38 & 32) == 0) goto L16;
        String r12 = null;
    L18:
        if ((r38 & 64) == 0) goto L20;
        VisibleNodeCountCondition r13 = null;
    L22:
        if ((r38 & 128) == 0) goto L24;
        List r14 = null;
    L26:
        if ((r38 & 256) == 0) goto L28;
        d r15 = d.f33891a;
    L30:
        if ((r38 & 512) == 0) goto L32;
        long r16 = 0;
    L34:
        if ((r38 & 1024) == 0) goto L36;
        boolean r18 = false;
    L38:
        if ((r38 & 2048) == 0) goto L40;
        ScreenshotOption r19 = null;
    L42:
        if ((r38 & 4096) == 0) goto L44;
        int r20 = -1;
    L46:
        if ((r38 & 8192) == 0) goto L48;
        boolean r21 = false;
    L49:
        this(r23, r24, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21);
        return;
    L48:
        r21 = r37;
        goto L49
    L44:
        r20 = r36;
        goto L46
    L40:
        r19 = r35;
        goto L42
    L36:
        r18 = r34;
        goto L38
    L32:
        r16 = r32;
        goto L34
    L28:
        r15 = r31;
        goto L30
    L24:
        r14 = r2;
        goto L26
    L20:
        r13 = r29;
        goto L22
    L16:
        r12 = r28;
        goto L18
    L12:
        r11 = r27;
        goto L14
    L5:
        r9 = r1;
        goto L7
    }

    public final List<KeywordMatchRule> getKeywordMatchRules() {
        return this.keywordMatchRules;
    }

    public final c getKeywordsMatchRule() {
        return this.keywordsMatchRule;
    }

    public final String getKeywordMatchExpression() {
        return this.keywordMatchExpression;
    }

    public final VisibleNodeCountCondition getVisibleNodeCountCondition() {
        return this.visibleNodeCountCondition;
    }

    public final List<Rect> getTouchRects() {
        return this.touchRects;
    }

    public final d getTouchRectMatchRule() {
        return this.touchRectMatchRule;
    }

    public final long getTimeThreshold() {
        return this.timeThreshold;
    }

    public final boolean getOptional() {
        return this.optional;
    }

    public final ScreenshotOption getScreenshotOpt() {
        return this.screenshotOpt;
    }

    public final int getResetToStep() {
        return this.resetToStep;
    }

    public final boolean getMatched() {
        return this.matched;
    }

    public final void setMatched(boolean r1) {
        this.matched = r1;
    }
}
