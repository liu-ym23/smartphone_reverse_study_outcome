package cc3;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.ec.model.k f23228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentNodeVO f23230c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f23228a, r101.f23228a) == true) goto L8;
        return false;
    L8:
        if (this.f23229b == r101.f23229b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23230c, r101.f23230c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        com.bytedance.android.ec.model.k r100 = this.f23228a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f23229b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        CommentNodeVO r107 = this.f23230c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentGalleryModel(mediaModel=" + this.f23228a + ", isFromAppendComment=" + this.f23229b + ", comment=" + this.f23230c + ")";
    }

    public c(b r100, boolean r101, CommentNodeVO r102) {
        Intrinsics.checkNotNullParameter(r100, "mediaModel");
        Intrinsics.checkNotNullParameter(r102, "comment");
        this.f23228a = r100;
        this.f23229b = r101;
        this.f23230c = r102;
    }
}
