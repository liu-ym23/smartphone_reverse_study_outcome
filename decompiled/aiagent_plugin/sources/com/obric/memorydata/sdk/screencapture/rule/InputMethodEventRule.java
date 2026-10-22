package com.obric.memorydata.sdk.screencapture.rule;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.memorydata.sdk.screencapture.event.InputMethodEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: InputMethodEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InputMethodEventRule extends ScreenEventRule {
    public static final CREATOR CREATOR = null;
    private final ScreenEvent.a eventType;
    private final Boolean visible;

    /* JADX INFO: compiled from: InputMethodEventRule.kt */
    public static final class CREATOR implements Parcelable.Creator<InputMethodEventRule> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InputMethodEventRule createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InputMethodEventRule[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodEventRule createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = new Gson().fromJson(r2.readString(), InputMethodEventRule.class);
            o.c(r1, "fromJson(...)");
            return (InputMethodEventRule) ZeusTransformUtils.preCheckCast(r1, InputMethodEventRule.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodEventRule[] newArray(int r1) {
            return new InputMethodEventRule[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InputMethodEventRule() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InputMethodEventRule copy$default(InputMethodEventRule r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        return r0.copy(r1);
    }

    public final Boolean component1() {
        return this.visible;
    }

    public final InputMethodEventRule copy(Boolean r1) {
        return new InputMethodEventRule(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InputMethodEventRule.class) == true) goto L8;
        return false;
    L8:
        InputMethodEventRule r6 = (InputMethodEventRule) ZeusTransformUtils.preCheckCast(r5, InputMethodEventRule.class, "com.obric.aiagent.plugin");
        if (o.a(this.visible, r6.visible) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.visible;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "InputMethodEventRule(visible=" + this.visible + ')';
    }

    public InputMethodEventRule(Boolean r1) {
        this.visible = r1;
        this.eventType = ScreenEvent.a.f33863b;
    }

    public /* synthetic */ InputMethodEventRule(Boolean r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final Boolean getVisible() {
        return this.visible;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public boolean isMatch(ScreenEvent r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "event");
        if (ZeusTransformUtils.instanceOf(r3, InputMethodEvent.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (isFilter$memoryDataSDK_obricRelease(r3.getPackageName(), r5) == true) goto L11;
        Boolean r2 = this.visible;
        if (r2 != null) goto L9;
    L10:
        return true;
    L9:
        if (o.a(r2, Boolean.valueOf(((InputMethodEvent) ZeusTransformUtils.preCheckCast(r3, InputMethodEvent.class, "com.obric.aiagent.plugin")).getVisible())) == false) goto L11;
        goto L10
    }
}
