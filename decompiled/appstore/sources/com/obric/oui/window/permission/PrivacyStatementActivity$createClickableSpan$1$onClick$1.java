package com.obric.oui.window.permission;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementActivity$createClickableSpan$1$onClick$1 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ PrivacyStatementActivity.LinkClickListener $linkClickListener;
    final /* synthetic */ String $title;
    final /* synthetic */ String $url;
    final /* synthetic */ PrivacyStatementActivity this$0;

    public PrivacyStatementActivity$createClickableSpan$1$onClick$1(PrivacyStatementActivity r10, String r11, PrivacyStatementActivity.LinkClickListener r12, String r13) {
        this.this$0 = r10;
        this.$url = r11;
        this.$linkClickListener = r12;
        this.$title = r13;
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
        r10.dismiss();
        PrivacyStatementActivity.S(this.this$0, true);
        String r12 = this.$url;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length() == 0) goto L16;
        PrivacyStatementActivity.LinkClickListener r13 = this.$linkClickListener;
        if (r13 != null) goto L10;
        Unit r14 = null;
    L11:
        if (r14 != null) goto L15;
        PrivacyStatementActivity.Q(this.this$0, this.$url, this.$title);
        return;
    L15:
        return;
    L10:
        r13.onLinkClick(this.$url, this.this$0);
        r14 = Unit.f21064a;
        goto L11
    }
}
