package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/chat/view/M8;", "", "Landroid/view/ViewGroup;", "host", "<init>", "(Landroid/view/ViewGroup;)V", "LY8/t;", "c", "()V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Landroid/view/ViewGroup;", "Landroid/widget/FrameLayout;", "maskView", "Landroid/widget/FrameLayout;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class M8 {
    private static final a Companion = new a(null);

    @Deprecated
    public static final float RING_PADDING_DP = 8.0f;

    @Deprecated
    public static final int SCRIM_COLOR = 855638016;

    @Deprecated
    public static final int SPINNER_SIZE_DP = 60;
    private ViewGroup host;
    private FrameLayout maskView;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/M8$a;", "", "<init>", "()V", "", "SCRIM_COLOR", "I", "SPINNER_SIZE_DP", "", "RING_PADDING_DP", "F", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public M8(ViewGroup viewGroup) {
        this.host = viewGroup;
    }

    public final void a() {
        FrameLayout frameLayout = this.maskView;
        if (frameLayout == null) {
            return;
        }
        this.maskView = null;
        ViewGroup viewGroup = this.host;
        if (viewGroup != null) {
            viewGroup.removeView(frameLayout);
        }
    }

    public final void b() {
        a();
        this.host = null;
    }

    public final void c() {
        ViewGroup viewGroup;
        if (this.maskView == null && (viewGroup = this.host) != null) {
            Context context = viewGroup.getContext();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(SCRIM_COLOR);
            frameLayout.setClickable(true);
            kotlin.jvm.internal.p.f(context);
            com.stepos.agentframework.uikit.IndeterminateSpinnerView indeterminateSpinnerView = new com.stepos.agentframework.uikit.IndeterminateSpinnerView(context, null, 0, 6, null);
            indeterminateSpinnerView.setBackgroundCircleColor(androidx.core.content.a.c(context, R$color.popup_rename_bg));
            indeterminateSpinnerView.setColor(androidx.core.content.a.c(context, R$color.rename_btn_confirm_text));
            indeterminateSpinnerView.setRingPaddingDp(8.0f);
            int i10 = (int) (60 * context.getResources().getDisplayMetrics().density);
            frameLayout.addView(indeterminateSpinnerView, new FrameLayout.LayoutParams(i10, i10, 17));
            viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            this.maskView = frameLayout;
        }
    }
}
