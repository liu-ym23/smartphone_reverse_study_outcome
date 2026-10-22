package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExplainCardTitleEditorDialog f84441a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f84442a;

        public a(o r100) {
            this.f84442a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            EditText r100 = (EditText) this.f84442a.f84441a.S90(R.id.title_edit);     // Catch: Throwable -> L10
            if (r100 == null) goto L13;
            EditText r101 = (EditText) this.f84442a.f84441a.S90(R.id.title_edit);     // Catch: Throwable -> L10
            if (r101 == null) goto L7;
            Editable r102 = r101.getText();     // Catch: Throwable -> L10
        L8:
            r100.setSelection(r102.toString().length());     // Catch: Throwable -> L10
            return;
        L7:
            r102 = null;
            goto L8
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public o(ExplainCardTitleEditorDialog r100) {
        this.f84441a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L5;
        new Handler(Looper.getMainLooper()).post(new a(this));
        return;
    }
}
