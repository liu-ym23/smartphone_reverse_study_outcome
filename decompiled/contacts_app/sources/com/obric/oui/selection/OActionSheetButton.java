package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.KtExt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OActionSheetButton.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0003J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\u0015\u001a\u00020\u0016R \u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tvTitle", "Lcom/obric/oui/text/OTextView;", "getTvTitle$annotations", "()V", "getTvTitle", "()Lcom/obric/oui/text/OTextView;", "setTvTitle", "(Lcom/obric/oui/text/OTextView;)V", "init", "", "setText", "str", "", "setTextColor", "color", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheetButton extends OUIFrameLayout {
    public static final Companion Companion = null;
    private static final String TAG = "OActionSheetButton";
    public OTextView tvTitle;

    /* JADX INFO: compiled from: OActionSheetButton.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    public /* synthetic */ OActionSheetButton(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OActionSheetButton(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, 0, null, 12, null);
        init();
    }

    public final OTextView getTvTitle() {
        OTextView r0 = this.tvTitle;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    public final void setTvTitle(OTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tvTitle = r2;
    }

    private final void init() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.o_listitem_button, this);
        ViewParent r0 = (ViewGroup) findViewById(R.id.ll_root);
        KtExt r1 = KtExt.INSTANCE;
        if (r0 != null) goto L6;
    L4:
        r0 = null;
    L7:
        IOUIAlpha r2 = (IOUIAlpha) r0;
        if (r2 == null) goto L11;
        r2.setChangeAlphaWhenPress(false);
    L11:
        View r3 = findViewById(R.id.tv_content_title);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_content_title)");
        setTvTitle((OTextView) r3);
        setRadius((int) getResources().getDimension(R.dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r0 instanceof IOUIAlpha) == false) goto L4;
        goto L4
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "str");
        getTvTitle().setText(r2);
    }

    public final void setTextColor(int r1) {
        getTvTitle().setTextColor(r1);
    }
}
