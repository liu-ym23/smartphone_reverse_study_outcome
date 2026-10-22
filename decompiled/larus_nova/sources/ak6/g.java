package ak6;

import android.text.SpannableString;
import com.bytedance.live.richcontent.ResourceInfo;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpannableString f4074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ek6.e f4076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ek6.d, c> f4077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ResourceInfo> f4078e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f4074a, r101.f4074a) == true) goto L8;
        return false;
    L8:
        if (this.f4075b == r101.f4075b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f4076c, r101.f4076c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4077d, r101.f4077d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f4078e, r101.f4078e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    public final int hashCode() {
        SpannableString r100 = this.f4074a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f4075b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        ek6.e r107 = this.f4076c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        Map<ek6.d, c> r110 = this.f4077d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        List<ResourceInfo> r113 = this.f4078e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SpanRendResult(spannable=" + this.f4074a + ", isCompleted=" + this.f4075b + ", originRichContent=" + this.f4076c + ", originIndexInfo=" + this.f4077d + ", originResourceInfo=" + this.f4078e + ")";
    }

    public g(SpannableString r100, boolean r101, ek6.e r102, Map<ek6.d, c> r103, List<ResourceInfo> r104) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r102, "originRichContent");
        this.f4074a = r100;
        this.f4075b = r101;
        this.f4076c = r102;
        this.f4077d = r103;
        this.f4078e = r104;
    }
}
