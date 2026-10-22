package com.bytedance.ai.view.input;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes43.dex */
public final class t implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatInput f37780a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public t(ChatInput r100) {
        this.f37780a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Function0<z0<FloatingChatStatus>> r101 = this.f37780a.getChatStatus();
        if (r101 == null) goto L17;
        z0<FloatingChatStatus> r102 = r101.invoke();
        if (r102 == null) goto L18;
        if (r100 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        FloatingChatStatus r104 = FloatingChatStatus.READY_TO_INPUT;
    L15:
        r102.tryEmit(r104);
        return;
    L14:
        r104 = FloatingChatStatus.READY_TO_SEND;
        goto L15
    L8:
        if (r100.length() == 0) goto L11;
        r103 = false;
        goto L12
    L18:
        return;
    }
}
