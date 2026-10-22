package c7b;

import android.view.View;
import com.ss.android.lark.chatbase.view.post.PostChatView;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PostChatView f22675a;

    public d(PostChatView r100) {
        this.f22675a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        View.OnLongClickListener r101 = this.f22675a.f416937j;
        if (r101 == null) goto L7;
        r101.onLongClick(r100);
        return true;
    L7:
        return true;
    }
}
