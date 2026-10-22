package com.android.ttcjpaysdk.integrated.sign.counter.activity;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterLaunchArgs;", "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "getSceneType", "()Ljava/lang/String;", "getSessionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignCounterLaunchArgs {
    public static final Companion Companion = null;
    public static final String EXTRA_SCENE_TYPE = "sceneType";
    public static final String EXTRA_SESSION_ID = "sessionId";
    public static final String SCENE_INTEGRATED_SIGN = "integrated_sign";
    public static final String SCENE_SIGN_PRE_ROUTE = "pre_sign_and_consult";
    private final String sceneType;
    private final String sessionId;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterLaunchArgs$Companion;", "", "()V", "EXTRA_SCENE_TYPE", "", "EXTRA_SESSION_ID", "SCENE_INTEGRATED_SIGN", "SCENE_SIGN_PRE_ROUTE", "fromIntent", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterLaunchArgs;", "intent", "Landroid/content/Intent;", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final SignCounterLaunchArgs fromIntent(Intent r100) {
            if (r100 == null) goto L5;
            String r101 = r100.getStringExtra(SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
            if (r101 == null) goto L5;
        L6:
            if (r100 == null) goto L8;
            String r102 = r100.getStringExtra("sessionId");
        L10:
            return new SignCounterLaunchArgs(r101, r102);
        L8:
            r102 = null;
        L5:
            r101 = SignCounterLaunchArgs.SCENE_INTEGRATED_SIGN;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ SignCounterLaunchArgs copy$default(SignCounterLaunchArgs r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.sceneType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.sessionId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.sceneType;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final SignCounterLaunchArgs copy(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, EXTRA_SCENE_TYPE);
        return new SignCounterLaunchArgs(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SignCounterLaunchArgs) == true) goto L8;
        return false;
    L8:
        SignCounterLaunchArgs r101 = (SignCounterLaunchArgs) r100;
        if (Intrinsics.areEqual(this.sceneType, r101.sceneType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.sceneType.hashCode() * 31;
        String r101 = this.sessionId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "SignCounterLaunchArgs(sceneType=" + this.sceneType + ", sessionId=" + this.sessionId + ')';
    }

    public final String getSceneType() {
        return this.sceneType;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public SignCounterLaunchArgs(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, EXTRA_SCENE_TYPE);
        this.sceneType = r100;
        this.sessionId = r101;
    }
}
