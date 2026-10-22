package bc3;

import android.view.ViewGroup;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentImageVH;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentVideoVH;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f18576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommentImageVH f18577b;

    public a(ViewGroup.LayoutParams r100, CommentImageVH r101) {
        this.f18576a = r100;
        this.f18577b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup.LayoutParams r100 = this.f18576a;     // Catch: Throwable -> L4
        r100.height = this.f18577b.f172383b.getHeight() - CommentVideoVH.f172388d;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
