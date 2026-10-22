package com.bytedance.android.shopping.commentv3.uitree.p008float;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.commentv3.base.BaseCommentLogic;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends BaseCommentLogic<c> {
    @Override // com.bytedance.android.shopping.commentv3.base.e
    public final void a() {
        c r100 = this.f172659c;
        if (r100 == null) goto L11;
        Fragment r101 = r100.f172675b;
        if (r101 == null) goto L13;
        com.bytedance.android.shopping.commentv3.data.b r102 = this.f172660d;
        if (r102 == null) goto L12;
        a r103 = new a(this);
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r103, "observer");
        CommentDataCenter r104 = r102.f172743h;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r101, "owner");
        Intrinsics.checkNotNullParameter(r103, "observer");
        r104.f172713r.e(r101, r103);
        return;
    L12:
        return;
    L13:
        return;
    }

    public b() {
    }
}
