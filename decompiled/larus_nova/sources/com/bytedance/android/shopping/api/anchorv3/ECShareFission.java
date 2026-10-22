package com.bytedance.android.shopping.api.anchorv3;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u001f\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J!\u0010\u0007\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0002HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECShareFission;", "Ljava/io/Serializable;", "", "component1", "component2", "shareScene", "secActivityInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getShareScene", "()Ljava/lang/String;", "getSecActivityInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECShareFission implements Serializable {
    public static final a Companion = null;
    public static final String SHARE_BUTTON_BUBBLE_TIMES = "share_button_bubble_times";
    public static final String SHARE_CONTROL_TIMES = "share_control_times";
    private final String secActivityInfo;
    private final String shareScene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECShareFission() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECShareFission copy$default(ECShareFission r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.shareScene;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.secActivityInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.shareScene;
    }

    public final String component2() {
        return this.secActivityInfo;
    }

    public final ECShareFission copy(String r100, String r101) {
        return new ECShareFission(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECShareFission) == false) goto L10;
        ECShareFission r101 = (ECShareFission) r100;
        if (Intrinsics.areEqual(this.shareScene, r101.shareScene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secActivityInfo, r101.secActivityInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.shareScene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.secActivityInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECShareFission(shareScene=" + this.shareScene + ", secActivityInfo=" + this.secActivityInfo + ")";
    }

    public final String getSecActivityInfo() {
        return this.secActivityInfo;
    }

    public final String getShareScene() {
        return this.shareScene;
    }

    public ECShareFission(String r100, String r101) {
        this.shareScene = r100;
        this.secActivityInfo = r101;
    }

    public /* synthetic */ ECShareFission(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
