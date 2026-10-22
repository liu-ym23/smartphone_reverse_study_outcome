package cc3;

import android.text.method.ScrollingMovementMethod;
import com.bytedance.android.shopping.commentgallery.view.CommentGalleryExpandableTextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentGalleryExpandableTextView f23226a;

    public a(CommentGalleryExpandableTextView r100) {
        this.f23226a = r100;
    }

    public final void a() {
        CommentGalleryExpandableTextView r100 = this.f23226a;
        if (r100.f172498a.getHeight() < r100.f172505h) goto L5;
        r100.f172498a.setVerticalScrollBarEnabled(true);
        r100.f172498a.setMovementMethod(ScrollingMovementMethod.getInstance());
        r100.f172498a.setText(r100.f172507j + "\n");
        return;
    L5:
        r100.f172498a.setVerticalScrollBarEnabled(false);
        r100.f172498a.setMovementMethod(null);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
