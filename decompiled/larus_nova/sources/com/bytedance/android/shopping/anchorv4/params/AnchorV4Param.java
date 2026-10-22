package com.bytedance.android.shopping.anchorv4.params;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/params/AnchorV4Param;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/shopping/anchorv4/params/V4NativeParams;", "component2", "sessionId", "nativeParams", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/anchorv4/params/V4NativeParams;", "getNativeParams", "()Lcom/bytedance/android/shopping/anchorv4/params/V4NativeParams;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/params/V4NativeParams;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4Param implements Serializable {
    public static final a Companion = null;
    private final V4NativeParams nativeParams;
    private final String sessionId;

    public static final class a {
        public a() {
        }

        public static AnchorV4Param a(String r100, V4NativeParams r101) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter(r101, "nativeParams");
            return new AnchorV4Param(r100, r101);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ AnchorV4Param copy$default(AnchorV4Param r100, String r101, V4NativeParams r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.sessionId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.nativeParams;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final V4NativeParams component2() {
        return this.nativeParams;
    }

    public final AnchorV4Param copy(String r100, V4NativeParams r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "nativeParams");
        return new AnchorV4Param(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4Param) == false) goto L10;
        AnchorV4Param r101 = (AnchorV4Param) r100;
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nativeParams, r101.nativeParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.sessionId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        V4NativeParams r104 = this.nativeParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4Param(sessionId=" + this.sessionId + ", nativeParams=" + this.nativeParams + ")";
    }

    public final V4NativeParams getNativeParams() {
        return this.nativeParams;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public AnchorV4Param(String r100, V4NativeParams r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "nativeParams");
        this.sessionId = r100;
        this.nativeParams = r101;
    }
}
