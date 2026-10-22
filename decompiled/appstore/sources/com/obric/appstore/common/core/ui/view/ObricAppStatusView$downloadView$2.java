package com.obric.appstore.common.core.ui.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.obric.appstore.R;
import com.obric.oui.progress.ODownloadProgressView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/obric/oui/progress/ODownloadProgressView;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ObricAppStatusView$downloadView$2 extends Lambda implements Function0<ODownloadProgressView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ObricAppStatusView this$0;

    public ObricAppStatusView$downloadView$2(ObricAppStatusView r10, Context r11) {
        this.this$0 = r10;
        this.$context = r11;
        super(0);
    }

    public static /* synthetic */ void a(ObricAppStatusView r10, View r11) {
        invoke$lambda$7(r10, r11);
    }

    private static final void invoke$lambda$7(ObricAppStatusView r10, View r11) {
        q.g(r10, "this$0");
        View.OnClickListener r12 = ObricAppStatusView.l(r10);
        if (r12 == null) goto L6;
        r12.onClick(r10);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ODownloadProgressView invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ODownloadProgressView invoke() {
        if (this.this$0.getUseForHomeCard() == true) goto L5;
        View r10 = ObricAppStatusView.k(this.this$0).f24612f.inflate();
        q.e(r10, "null cannot be cast to non-null type com.obric.oui.progress.ODownloadProgressView");
        ODownloadProgressView r11 = (ODownloadProgressView) r10;
        Context r12 = this.$context;
        r11.setPauseDrawable(r12.getDrawable(R.drawable.oui_icon_pause));
        r11.getPauseDrawable().mutate().setColorFilter(new PorterDuffColorFilter(r12.getColor(R.color.oui_accent_6_bg), PorterDuff.Mode.SRC_IN));
    L6:
        final ObricAppStatusView r13 = this.this$0;
        r11.setOnClickListener(new d(r13));
        return r11;
    L5:
        ObricAppStatusView.k(this.this$0).f24612f.setLayoutResource(R.layout.obric_app_status_download_view_homecard);
        View r14 = ObricAppStatusView.k(this.this$0).f24612f.inflate();
        q.e(r14, "null cannot be cast to non-null type com.obric.oui.progress.ODownloadProgressView");
        r11 = (ODownloadProgressView) r14;
        Context r15 = this.$context;
        Drawable r16 = r11.getDownloadDrawable().mutate();
        int r17 = R.color.oui_on_dark_text_1;
        int r18 = r15.getColor(r17);
        PorterDuff.Mode r19 = PorterDuff.Mode.SRC_IN;
        r16.setColorFilter(new PorterDuffColorFilter(r18, r19));
        r11.setPauseDrawable(r15.getDrawable(R.drawable.oui_icon_pause));
        r11.getPauseDrawable().mutate().setColorFilter(new PorterDuffColorFilter(r15.getColor(r17), r19));
        r11.getRetryDrawable().mutate().setColorFilter(new PorterDuffColorFilter(r15.getColor(r17), r19));
        r11.getProcessingDrawable().mutate().setColorFilter(new PorterDuffColorFilter(r15.getColor(r17), r19));
        goto L6
    }
}
