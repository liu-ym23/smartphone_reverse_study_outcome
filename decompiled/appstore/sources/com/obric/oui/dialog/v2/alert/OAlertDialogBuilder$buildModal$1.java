package com.obric.oui.dialog.v2.alert;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OAlertDialogBuilder$buildModal$1 extends Lambda implements Function1<CharSequence, Unit> {
    final /* synthetic */ OAlertDialogModal $dialogModal;
    final /* synthetic */ OAlertDialogBuilder this$0;

    public OAlertDialogBuilder$buildModal$1(OAlertDialogModal r10, OAlertDialogBuilder r11) {
        this.$dialogModal = r10;
        this.this$0 = r11;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CharSequence r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull CharSequence r10) {
        q.g(r10, "it");
        this.$dialogModal.setMessage(r10);
        if (OAlertDialogBuilder.n(this.this$0) == false) goto L6;
        this.$dialogModal.v();
        return;
    }
}
