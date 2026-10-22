package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(30)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0004\b\t\u0010\u0014\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/selection/OActionSheetButton;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "a", "()V", "", "str", "setText", "(Ljava/lang/String;)V", "", "color", "setTextColor", "(I)V", "Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/text/OTextView;", "getTvTitle", "()Lcom/obric/oui/text/OTextView;", "setTvTitle", "(Lcom/obric/oui/text/OTextView;)V", "getTvTitle$annotations", "tvTitle", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OActionSheetButton extends OUIFrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16729b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OTextView f16730a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f16729b = new a(null);
    }

    public OActionSheetButton(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11, 0, null, 12, null);
        a();
    }

    private final void a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R$layout.o_listitem_button, this);
        ViewParent r10 = (ViewGroup) findViewById(R$id.ll_root);
        c r11 = c.f24796a;
        if (r10 != null) goto L6;
    L4:
        r10 = null;
    L7:
        IOUIAlpha r12 = (IOUIAlpha) r10;
        if (r12 == null) goto L11;
        r12.setChangeAlphaWhenPress(false);
    L11:
        View r13 = findViewById(R$id.tv_content_title);
        q.f(r13, "findViewById(R.id.tv_content_title)");
        setTvTitle((OTextView) r13);
        setRadius((int) getResources().getDimension(R$dimen.oui_r_l3_rect));
        setChangeAlphaWhenDisable(false);
        return;
    L6:
        if ((r10 instanceof IOUIAlpha) == false) goto L4;
        goto L4
    }

    public static /* synthetic */ void getTvTitle$annotations() {
    }

    @NotNull
    public final OTextView getTvTitle() {
        OTextView r10 = this.f16730a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        q.y("tvTitle");
        return null;
    }

    public final void setText(@NotNull String r10) {
        q.g(r10, "str");
        getTvTitle().setText(r10);
    }

    public final void setTextColor(@ColorInt int r10) {
        getTvTitle().setTextColor(r10);
    }

    public final void setTvTitle(@NotNull OTextView r10) {
        q.g(r10, "<set-?>");
        this.f16730a = r10;
    }
}
