package com.obric.oui.window.permission;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.button.OButton;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", Style.KEY_WIDTH, "", Style.KEY_HEIGHT, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementActivity$createSingleButton$1 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
    final /* synthetic */ Function1<View, Unit> $onClickListener;
    final /* synthetic */ String $text;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivacyStatementActivity$createSingleButton$1(String r10, Function1<? super View, Unit> r11) {
        this.$text = r10;
        this.$onClickListener = r11;
        super(3);
    }

    public static /* synthetic */ void a(Function1 r10, View r11) {
        m29invoke$lambda1$lambda0(r10, r11);
    }

    /* JADX INFO: renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
    private static final void m29invoke$lambda1$lambda0(Function1 r10, View r11) {
        r10.invoke(r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ OButton invoke(Context r10, Integer r11, Integer r12) {
        return invoke(r10, r11.intValue(), r12.intValue());
    }

    @NotNull
    public final OButton invoke(@NotNull Context r10, int r11, int r12) {
        q.g(r10, "styledContext");
        OButton r13 = new OButton(r10, null, 0, 0, null, 28, null);
        String r14 = this.$text;
        final Function1<View, Unit> r15 = this.$onClickListener;
        r13.setText(r14);
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
        if (r15 != null) goto L5;
        View.OnClickListener r16 = null;
    L6:
        r13.setOnClickListener(r16);
        return r13;
    L5:
        r16 = new b(r15);
        goto L6
    }
}
