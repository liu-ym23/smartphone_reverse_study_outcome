package com.bytedance.android.live.saas.middleware.npth;

import com.bytedance.crash.ICrashCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthParam;", "", "params", "Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;", "javaCrash", "", "nativeCrash", "anr", "crashCallback", "Lcom/bytedance/crash/ICrashCallback;", "(Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;ZZZLcom/bytedance/crash/ICrashCallback;)V", "getAnr", "()Z", "setAnr", "(Z)V", "getCrashCallback", "()Lcom/bytedance/crash/ICrashCallback;", "setCrashCallback", "(Lcom/bytedance/crash/ICrashCallback;)V", "getJavaCrash", "setJavaCrash", "getNativeCrash", "setNativeCrash", "getParams", "()Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;", "setParams", "(Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NpthParam {
    private boolean anr;
    private ICrashCallback crashCallback;
    private boolean javaCrash;
    private boolean nativeCrash;
    private DefaultNpthParams params;

    public static /* synthetic */ NpthParam copy$default(NpthParam r100, DefaultNpthParams r101, boolean r102, boolean r103, boolean r104, ICrashCallback r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.params;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.javaCrash;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.nativeCrash;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.anr;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.crashCallback;
    L17:
        DefaultNpthParams r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final DefaultNpthParams component1() {
        return this.params;
    }

    public final boolean component2() {
        return this.javaCrash;
    }

    public final boolean component3() {
        return this.nativeCrash;
    }

    public final boolean component4() {
        return this.anr;
    }

    public final ICrashCallback component5() {
        return this.crashCallback;
    }

    public final NpthParam copy(DefaultNpthParams r100, boolean r101, boolean r110, boolean r111, ICrashCallback r112) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "crashCallback");
        return new NpthParam(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NpthParam) == false) goto L16;
        NpthParam r101 = (NpthParam) r100;
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L8;
        return false;
    L8:
        if (this.javaCrash == r101.javaCrash) goto L10;
        return false;
    L10:
        if (this.nativeCrash == r101.nativeCrash) goto L12;
        return false;
    L12:
        if (this.anr == r101.anr) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.crashCallback, r101.crashCallback) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        DefaultNpthParams r100 = this.params;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.javaCrash;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.nativeCrash;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.anr;
        if (r111 == true) goto L16;
        r105 = r111;
    L16:
        int r112 = (r110 + r105) * 31;
        ICrashCallback r113 = this.crashCallback;
        if (r113 == null) goto L20;
        r101 = r113.hashCode();
    L20:
        return r112 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "NpthParam(params=" + this.params + ", javaCrash=" + this.javaCrash + ", nativeCrash=" + this.nativeCrash + ", anr=" + this.anr + ", crashCallback=" + this.crashCallback + ")";
    }

    public final boolean getAnr() {
        return this.anr;
    }

    public final ICrashCallback getCrashCallback() {
        return this.crashCallback;
    }

    public final boolean getJavaCrash() {
        return this.javaCrash;
    }

    public final boolean getNativeCrash() {
        return this.nativeCrash;
    }

    public final DefaultNpthParams getParams() {
        return this.params;
    }

    public final void setAnr(boolean r100) {
        this.anr = r100;
    }

    public final void setCrashCallback(ICrashCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.crashCallback = r100;
    }

    public final void setJavaCrash(boolean r100) {
        this.javaCrash = r100;
    }

    public final void setNativeCrash(boolean r100) {
        this.nativeCrash = r100;
    }

    public final void setParams(DefaultNpthParams r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.params = r100;
    }

    public NpthParam(DefaultNpthParams r100, boolean r101, boolean r102, boolean r103, ICrashCallback r104) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r104, "crashCallback");
        this.params = r100;
        this.javaCrash = r101;
        this.nativeCrash = r102;
        this.anr = r103;
        this.crashCallback = r104;
    }

    public /* synthetic */ NpthParam(DefaultNpthParams r100, boolean r101, boolean r110, boolean r111, ICrashCallback r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r113 & 4) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r113 & 8) == 0) goto L13;
        boolean r104 = true;
    L14:
        this(r100, r102, r103, r104, r112);
        return;
    L13:
        r104 = r111;
        goto L14
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
