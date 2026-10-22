package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.view.View;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LikeEggImagePickerDialog f139961a;

    public c(LikeEggImagePickerDialog r100) {
        this.f139961a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f139961a.f139946e;
        if (r101 == null) goto L13;
        Unit r102 = r101.invoke();
    L13:
        this.f139961a.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L15;
        d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
