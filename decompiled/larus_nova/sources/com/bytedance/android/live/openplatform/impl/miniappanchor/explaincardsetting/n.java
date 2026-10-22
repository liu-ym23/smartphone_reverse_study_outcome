package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class n implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainCardTitleEditorDialog f84440a;

    public n(ExplainCardTitleEditorDialog r100) {
        this.f84440a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L5;
    L14:
        ExplainCardTitleEditorDialog r103 = this.f84440a;
        EditText r104 = (EditText) r103.S90(R.id.title_edit);
        if (r104 == null) goto L17;
        Editable r105 = r104.getText();
    L18:
        ExplainCardTitleEditorDialog.T90(r103, r105.toString());
        return true;
    L17:
        r105 = null;
        goto L18
    L5:
        if (r101 == 6) goto L14;
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.getAction() == 0) goto L10;
        return false;
    L10:
        if (r102.getKeyCode() == 66) goto L14;
        return false;
    }
}
