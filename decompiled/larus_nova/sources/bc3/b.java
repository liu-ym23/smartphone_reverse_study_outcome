package bc3;

import android.view.View;
import com.bytedance.android.shopping.commentfeed.viewholder.CommentVideoVHNew;
import com.bytedance.android.shopping.commentfeed.widget.VideoPlaySeekBar;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentVideoVHNew f18578a;

    public b(CommentVideoVHNew r100) {
        this.f18578a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPlaySeekBar r100 = this.f18578a.f172397g;     // Catch: Throwable -> L9
        Object r101 = r100.getParent();     // Catch: Throwable -> L9
        if ((r101 instanceof View) == true) goto L5;
        r101 = null;
    L5:
        View r102 = (View) r101;     // Catch: Throwable -> L9
        if (r102 == null) goto L12;
        r102.setOnTouchListener(new com.bytedance.android.shopping.commentfeed.widget.c(r100));     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
