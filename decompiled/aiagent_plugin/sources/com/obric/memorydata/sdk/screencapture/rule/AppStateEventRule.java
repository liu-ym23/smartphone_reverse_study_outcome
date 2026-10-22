package com.obric.memorydata.sdk.screencapture.rule;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.memorydata.sdk.screencapture.event.AppStateEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AppStateEventRule.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppStateEventRule extends ScreenEventRule {
    public static final CREATOR CREATOR = null;
    private final AppStateEvent.a appState;
    private final ScreenEvent.a eventType;

    /* JADX INFO: compiled from: AppStateEventRule.kt */
    public static final class CREATOR implements Parcelable.Creator<AppStateEventRule> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppStateEventRule createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppStateEventRule[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppStateEventRule createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = new Gson().fromJson(r2.readString(), AppStateEventRule.class);
            o.c(r1, "fromJson(...)");
            return (AppStateEventRule) ZeusTransformUtils.preCheckCast(r1, AppStateEventRule.class, "com.obric.aiagent.plugin");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppStateEventRule[] newArray(int r1) {
            return new AppStateEventRule[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppStateEventRule() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AppStateEventRule copy$default(AppStateEventRule r0, AppStateEvent.a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.appState;
    L6:
        return r0.copy(r1);
    }

    public final AppStateEvent.a component1() {
        return this.appState;
    }

    public final AppStateEventRule copy(AppStateEvent.a r1) {
        return new AppStateEventRule(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppStateEventRule.class) == true) goto L8;
        return false;
    L8:
        AppStateEventRule r6 = (AppStateEventRule) ZeusTransformUtils.preCheckCast(r5, AppStateEventRule.class, "com.obric.aiagent.plugin");
        if (this.appState == r6.appState) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        AppStateEvent.a r0 = this.appState;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "AppStateEventRule(appState=" + this.appState + ')';
    }

    public AppStateEventRule(AppStateEvent.a r1) {
        this.appState = r1;
        this.eventType = ScreenEvent.a.f33864c;
    }

    public /* synthetic */ AppStateEventRule(AppStateEvent.a r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final AppStateEvent.a getAppState() {
        return this.appState;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    @Override // com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule
    public boolean isMatch(ScreenEvent r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "event");
        if (ZeusTransformUtils.instanceOf(r3, AppStateEvent.class) == true) goto L5;
    L11:
        return false;
    L5:
        if (isFilter$memoryDataSDK_obricRelease(r3.getPackageName(), r5) == true) goto L11;
        AppStateEvent.a r2 = this.appState;
        if (r2 != null) goto L9;
    L10:
        return true;
    L9:
        if (r2 != ((AppStateEvent) ZeusTransformUtils.preCheckCast(r3, AppStateEvent.class, "com.obric.aiagent.plugin")).getState()) goto L11;
        goto L10
    }
}
