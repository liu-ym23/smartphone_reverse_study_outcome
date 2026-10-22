package com.obric.oui.window.permission;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementDialog$builder$2 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ c this$0;

    public PrivacyStatementDialog$builder$2(c r10) {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo0invoke(DialogInterface r10, Integer r11) {
        invoke(r10, r11.intValue());
        return Unit.f21064a;
    }

    public final void invoke(@NotNull DialogInterface r10, int r11) {
        q.g(r10, "dialog");
        Function0 r12 = c.b(null);
        if (r12 == null) goto L6;
        r12.invoke();
    L6:
        r10.dismiss();
    }
}
