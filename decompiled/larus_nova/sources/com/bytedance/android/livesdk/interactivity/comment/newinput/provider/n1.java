package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class n1 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o1.a f135935a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n1 f135936a;

        public a(n1 r100) {
            this.f135936a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f135936a.f135935a.f135513b.J();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public n1(o1.a r100) {
        this.f135935a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (r100 == null) goto L5;
        String r101 = r100.toString();
        if (r101 == null) goto L5;
    L6:
        BaseCommentGiftGuideView r102 = this.f135935a.f135944e.f135941c;
        if (r102 == null) goto L10;
        r102.a(r101);
        r102.b(new a(this));
        return;
    L10:
        return;
    L5:
        r101 = "";
        goto L6
    }
}
