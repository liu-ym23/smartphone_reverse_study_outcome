package bpc;

import android.view.View;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileView f20005a;

    public c(FileView r100) {
        this.f20005a = r100;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        this.f20005a.performLongClick();
        return true;
    }
}
