package com.bytedance.android.livesdkapi.floatview;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/FloatWindowRevisitParam;", "", "revisitWindowsType", "", "revisitTimestamp", "", "initialPage", "isMiniWindowAutoPlay", "triggerScene", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInitialPage", "()Ljava/lang/String;", "getRevisitTimestamp", "()J", "getRevisitWindowsType", "getTriggerScene", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatWindowRevisitParam {
    private final String initialPage;
    private final String isMiniWindowAutoPlay;
    private final long revisitTimestamp;
    private final String revisitWindowsType;
    private final String triggerScene;

    public FloatWindowRevisitParam() {
        this(null, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ FloatWindowRevisitParam copy$default(FloatWindowRevisitParam r100, String r101, long r102, String r103, String r104, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.revisitWindowsType;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.revisitTimestamp;
    L8:
        long r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.initialPage;
    L11:
        String r113 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isMiniWindowAutoPlay;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.triggerScene;
    L17:
        String r107 = r101;
        return r100.copy(r107, r105, r113, r106, r110);
    }

    public final String component1() {
        return this.revisitWindowsType;
    }

    public final long component2() {
        return this.revisitTimestamp;
    }

    public final String component3() {
        return this.initialPage;
    }

    public final String component4() {
        return this.isMiniWindowAutoPlay;
    }

    public final String component5() {
        return this.triggerScene;
    }

    public final FloatWindowRevisitParam copy(String r100, long r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "revisitWindowsType");
        Intrinsics.checkNotNullParameter(r111, "initialPage");
        Intrinsics.checkNotNullParameter(r112, "isMiniWindowAutoPlay");
        Intrinsics.checkNotNullParameter(r113, "triggerScene");
        return new FloatWindowRevisitParam(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FloatWindowRevisitParam) == false) goto L16;
        FloatWindowRevisitParam r101 = (FloatWindowRevisitParam) r100;
        if (Intrinsics.areEqual(this.revisitWindowsType, r101.revisitWindowsType) == true) goto L8;
        return false;
    L8:
        if (this.revisitTimestamp == r101.revisitTimestamp) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.initialPage, r101.initialPage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isMiniWindowAutoPlay, r101.isMiniWindowAutoPlay) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.triggerScene, r101.triggerScene) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.revisitWindowsType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.revisitTimestamp;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.initialPage;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.isMiniWindowAutoPlay;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.triggerScene;
        if (r111 == null) goto L18;
        r101 = r111.hashCode();
    L18:
        return r110 + r101;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FloatWindowRevisitParam(revisitWindowsType=" + this.revisitWindowsType + ", revisitTimestamp=" + this.revisitTimestamp + ", initialPage=" + this.initialPage + ", isMiniWindowAutoPlay=" + this.isMiniWindowAutoPlay + ", triggerScene=" + this.triggerScene + ")";
    }

    public final String getInitialPage() {
        return this.initialPage;
    }

    public final long getRevisitTimestamp() {
        return this.revisitTimestamp;
    }

    public final String getRevisitWindowsType() {
        return this.revisitWindowsType;
    }

    public final String getTriggerScene() {
        return this.triggerScene;
    }

    public final String isMiniWindowAutoPlay() {
        return this.isMiniWindowAutoPlay;
    }

    public FloatWindowRevisitParam(String r100, long r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "revisitWindowsType");
        Intrinsics.checkNotNullParameter(r102, "initialPage");
        Intrinsics.checkNotNullParameter(r103, "isMiniWindowAutoPlay");
        Intrinsics.checkNotNullParameter(r104, "triggerScene");
        this.revisitWindowsType = r100;
        this.revisitTimestamp = r101;
        this.initialPage = r102;
        this.isMiniWindowAutoPlay = r103;
        this.triggerScene = r104;
    }

    public /* synthetic */ FloatWindowRevisitParam(String r100, long r101, String r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r103 = r101;
        if ((r112 & 4) == 0) goto L12;
        String r104 = "";
    L14:
        if ((r112 & 8) == 0) goto L16;
        r110 = "0";
    L16:
        String r105 = r110;
        if ((r112 & 16) == 0) goto L19;
        String r115 = "";
    L20:
        this(r114, r103, r104, r105, r115);
        return;
    L19:
        r115 = r111;
        goto L20
    L12:
        r104 = r102;
        goto L14
    L5:
        r114 = r100;
        goto L7
    }
}
