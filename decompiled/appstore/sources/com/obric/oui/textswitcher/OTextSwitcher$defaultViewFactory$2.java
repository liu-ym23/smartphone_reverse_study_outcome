package com.obric.oui.textswitcher;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ViewSwitcher;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ViewSwitcher$ViewFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OTextSwitcher$defaultViewFactory$2 extends Lambda implements Function0<ViewSwitcher.ViewFactory> {
    final /* synthetic */ Context $context;
    final /* synthetic */ OTextSwitcher this$0;

    public OTextSwitcher$defaultViewFactory$2(Context r10, OTextSwitcher r11) {
        this.$context = r10;
        this.this$0 = r11;
        super(0);
    }

    public static /* synthetic */ View a(Context r10, OTextSwitcher r11) {
        return m27invoke$lambda4(r10, r11);
    }

    /* JADX INFO: renamed from: invoke$lambda-4, reason: not valid java name */
    private static final View m27invoke$lambda4(Context r10, OTextSwitcher r11) {
        q.g(r10, "$context");
        q.g(r11, "this$0");
        OTextView r12 = new OTextView(r10, null, 0, null, 14, null);
        OTextSwitcher.a(r11);
        r12.setGravity(16);
        r12.setSingleLine(true);
        OTextSwitcher.a(r11);
        r12.setEllipsize(TextUtils.TruncateAt.END);
        return r12;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewSwitcher.ViewFactory invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewSwitcher.ViewFactory invoke() {
        final Context r10 = this.$context;
        final OTextSwitcher r11 = this.this$0;
        return new a(r10, r11);
    }
}
