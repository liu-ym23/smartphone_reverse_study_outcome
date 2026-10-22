package com.bytedance.android.livesdk.chatroom.replay.input;

import android.widget.EditText;
import com.bytedance.android.livesdk.utils.t2;
import i40.h;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayEmojiInputDialogFragment f108803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f108804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f108805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f108806d;

    public /* synthetic */ a(ReplayEmojiInputDialogFragment r100, long r101, int r102, int r103) {
        this.f108803a = r100;
        this.f108804b = r101;
        this.f108805c = r102;
        this.f108806d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReplayEmojiInputDialogFragment r100 = this.f108803a;
        long r101 = this.f108804b;
        int r102 = this.f108805c;
        int r103 = this.f108806d;
        int r104 = ReplayEmojiInputDialogFragment.H;
        if (r100.isResumed() == true) goto L5;
    L14:
        h.a("itryRestoreSoftKeyboard return");
        return;
    L5:
        if (r100.B == false) goto L14;
        if (r100.getContext() == null) goto L14;
        t2.b(r100.getContext(), r100.f108776n);
        int r105 = r102 + 1;
        EditText r106 = r100.f108776n;
        if (r106 == null) goto L16;
        if (r105 > r103) goto L18;
        r106.postDelayed(new a(r100, r101, r105, r103), r101);
        return;
    L18:
        return;
    }
}
