package bpc;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.widget_biz_fileview.FileView;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileView f20004a;

    public b(FileView r100) {
        this.f20004a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        this.f20004a.performClick();
    }
}
