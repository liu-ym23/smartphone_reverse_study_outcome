package cc3;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f23245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f23246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CommentNodeVO f23247i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L24;
        k r101 = (k) r100;
        if (this.f23239a == r101.f23239a) goto L8;
        return false;
    L8:
        if (this.f23240b == r101.f23240b) goto L10;
        return false;
    L10:
        if (this.f23241c == r101.f23241c) goto L12;
        return false;
    L12:
        if (this.f23242d == r101.f23242d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f23243e, r101.f23243e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f23244f, r101.f23244f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f23245g, r101.f23245g) == true) goto L20;
        return false;
    L20:
        if (this.f23246h == r101.f23246h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f23247i, r101.f23247i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((this.f23239a * 31) + this.f23240b) * 31) + this.f23241c) * 31) + this.f23242d) * 31;
        String r101 = this.f23243e;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f23244f;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f23245g;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (((r107 + r109) * 31) + this.f23246h) * 31;
        CommentNodeVO r111 = this.f23247i;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "GalleryCommentInfo(mediaType=" + this.f23239a + ", commentRank=" + this.f23240b + ", videoNum=" + this.f23241c + ", imageNum=" + this.f23242d + ", commentSwitchType=" + this.f23243e + ", commentId=" + this.f23244f + ", userCommentLevel=" + this.f23245g + ", contentRank=" + this.f23246h + ", commentNodeVO=" + this.f23247i + ")";
    }

    public k(int r100, int r101, int r102, int r103, String r104, String r105, String r106, int r107, CommentNodeVO r110) {
        Intrinsics.checkNotNullParameter(r104, "commentSwitchType");
        Intrinsics.checkNotNullParameter(r110, "commentNodeVO");
        this.f23239a = r100;
        this.f23240b = r101;
        this.f23241c = r102;
        this.f23242d = r103;
        this.f23243e = r104;
        this.f23244f = r105;
        this.f23245g = r106;
        this.f23246h = r107;
        this.f23247i = r110;
    }
}
