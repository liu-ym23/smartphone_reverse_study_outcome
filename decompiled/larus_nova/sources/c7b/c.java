package c7b;

import androidx.constraintlayout.widget.ConstraintSet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.chatbase.view.post.PostChatView;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f22673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PostChatView f22674b;

    public final void a() {
        boolean r100 = true;
        int r101 = 0;
        if (this.f22673a == false) goto L11;
        if (this.f22674b.f416931d.getVisibility() == 0) goto L7;
    L14:
        if (r100 == true) goto L16;
        return;
    L16:
        ConstraintSet r102 = new ConstraintSet();
        r102.clone(this.f22674b);
        if (this.f22673a == false) goto L19;
        int r103 = 0;
    L20:
        r102.setVisibility(R.id.post_show_more, r103);
        if (this.f22673a == true) goto L23;
    L25:
        r101 = 8;
    L26:
        r102.setVisibility(R.id.post_show_more_text, r101);
        r102.applyTo(this.f22674b);
        return;
    L23:
        if (this.f22674b.f416950w == false) goto L25;
    L19:
        r103 = 8;
        goto L20
    L7:
        if (this.f22674b.f416932e.getVisibility() != 0) goto L14;
    L9:
        r100 = false;
        goto L14
    L11:
        if (this.f22674b.f416931d.getVisibility() != 8) goto L14;
        if (this.f22674b.f416932e.getVisibility() == 8) goto L9;
        goto L9
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

    public c(PostChatView r100, boolean r101) {
        this.f22674b = r100;
        this.f22673a = r101;
    }
}
