package com.stepos.ailauncher.chat.view;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class ChatHistoryView$showDeleteConfirmDialog$4$1 extends FunctionReferenceImpl implements InterfaceC5074l<Boolean, Y8.t> {
    public ChatHistoryView$showDeleteConfirmDialog$4$1(Object obj) {
        super(1, obj, ChatHistoryView.class, "handleSessionMutationResult", "handleSessionMutationResult(Z)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(Boolean bool) {
        l(bool.booleanValue());
        return Y8.t.f7040a;
    }

    public final void l(boolean z10) {
        ((ChatHistoryView) this.receiver).g1(z10);
    }
}
