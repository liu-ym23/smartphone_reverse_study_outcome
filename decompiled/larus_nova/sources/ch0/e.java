package ch0;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILinkPlayerInfoBridge f23724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f23725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f23726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f23727d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "LinkUserMergeData(linkPlayerInfo=" + this.f23724a + ", rtcUserInfo=" + this.f23725b + ", seiLinkerInfo=" + this.f23726c + ", extInfos=" + this.f23727d + ")";
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public /* synthetic */ e(ILinkPlayerInfoBridge r100) {
        this(r100, null, null, new HashMap());
    }

    public final boolean b(ILinkPlayerInfoBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return this.f23724a.isEqual(r100);
    }

    public final boolean c(h r100) {
        h r101 = this.f23725b;
        if (r101 != r100) goto L6;
        return true;
    L6:
        if (r101 == null) goto L40;
        if (r100 == null) goto L40;
        View r102 = null;
        if (r101 == null) goto L11;
        String r103 = r101.f23733a;
    L13:
        if ((!Intrinsics.areEqual(r103, r100.f23733a)) == false) goto L15;
        return false;
    L15:
        h r104 = this.f23725b;
        if (r104 != null) goto L18;
    L39:
        return false;
    L18:
        if (r104.f23737e != r100.f23737e) goto L39;
        if (r104 == null) goto L39;
        if (r104.f23736d != r100.f23736d) goto L39;
        if (r104 == null) goto L39;
        if (r104.f23735c != r100.f23735c) goto L39;
        if (r104 == null) goto L31;
        r102 = r104.f23734b;
    L31:
        if ((!Intrinsics.areEqual(r102, r100.f23734b)) == false) goto L33;
        return false;
    L33:
        h r105 = this.f23725b;
        if (r105 == null) goto L39;
        if (r105.f23739g != r100.f23739g) goto L39;
        return true;
    L11:
        r103 = null;
    L40:
        if (r101 != null) goto L43;
        if (r100 != null) goto L43;
        return true;
    L43:
        return false;
    }

    public final boolean d(j r100) {
        j r101 = this.f23726c;
        if (r101 != r100) goto L6;
        return true;
    L6:
        if (r101 == null) goto L33;
        if (r100 == null) goto L33;
        if (r101 == null) goto L10;
        String r102 = r101.f23744a;
    L12:
        if ((!Intrinsics.areEqual(r102, r100.f23744a)) == false) goto L14;
        return false;
    L14:
        j r103 = this.f23726c;
        if (r103 != null) goto L17;
    L32:
        return false;
    L17:
        if (r103.f23745b != r100.f23745b) goto L32;
        if (r103 == null) goto L32;
        if (r103.f23746c != r100.f23746c) goto L32;
        if (r103 == null) goto L32;
        if (r103.f23747d != r100.f23747d) goto L32;
        if (r103 == null) goto L32;
        if (r103.f23748e != r100.f23748e) goto L32;
        return true;
    L10:
        r102 = null;
    L33:
        if (r101 != null) goto L36;
        if (r100 != null) goto L36;
        return true;
    L36:
        return false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(e.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        e r102 = (e) r100;
        if (b(r102.f23724a) == true) goto L17;
        return false;
    L17:
        if (c(r102.f23725b) == true) goto L20;
        return false;
    L20:
        if (d(r102.f23726c) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.datamerge.entity.LinkUserMergeData");
    L8:
        r101 = null;
        goto L10
    }

    public e(ILinkPlayerInfoBridge r100, h r101, j r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "linkPlayerInfo");
        Intrinsics.checkNotNullParameter(r103, "extInfos");
        this.f23724a = r100;
        this.f23725b = r101;
        this.f23726c = r102;
        this.f23727d = r103;
    }

    public static e a(e r100, ILinkPlayerInfoBridge r101, h r102, j r103, Map r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f23724a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f23725b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f23726c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.f23727d;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "linkPlayerInfo");
        Intrinsics.checkNotNullParameter(r104, "extInfos");
        return new e(r101, r102, r103, r104);
    }
}
