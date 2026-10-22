package apc;

import android.view.View;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.PlayControlBar;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends OnSingleClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayControlBar f15864a;

    public b(PlayControlBar r100) {
        this.f15864a = r100;
    }

    @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
    public final void onSingleClick(View r100) {
        PlayControlBar r101 = this.f15864a;
        if (r101.f460822i == true) goto L6;
        LKUIToast.show(r101.getContext(), R.string.Lark_Message_AudioMessageWithdrawToast);
        return;
    L6:
        if (r101.f460821h != null) goto L8;
        return;
    L8:
        if (r101.f460814a.isChecked() == false) goto L10;
        r101.f460821h.onPlay();
        return;
    L10:
        r101.f460821h.onPause();
    }
}
