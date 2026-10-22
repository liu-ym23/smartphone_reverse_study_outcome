package com.obric.oui.sectiontitlebar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "sectionText", "", "setSectionDes", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "a", "Lkotlin/Lazy;", "getSectionDes", "()Landroid/widget/TextView;", "sectionDes", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public final class OSectionSupportiveText extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f16545a;

    @JvmOverloads
    public OSectionSupportiveText(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final TextView getSectionDes() {
        Object r10 = this.f16545a.getValue();
        q.f(r10, "<get-sectionDes>(...)");
        return (TextView) r10;
    }

    public final void setSectionDes(@NotNull String r10) {
        q.g(r10, "sectionText");
        getSectionDes().setText(r10);
    }

    @JvmOverloads
    public OSectionSupportiveText(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSectionSupportiveText(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSectionSupportiveText(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f16545a = b.b(new OSectionSupportiveText$sectionDes$2(this));
        LayoutInflater.from(r10).inflate(R$layout.o_view_section_supportive_text, this, true);
        int[] r13 = R$styleable.OSectionSupportiveText;
        q.f(r13, "OSectionSupportiveText");
        TypedArray r14 = r10.obtainStyledAttributes(r11, r13, r12, 0);
        q.f(r14, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        String r15 = r14.getString(R$styleable.OSectionSupportiveText_section_des_text);
        getSectionDes().setText(r15);
        r14.recycle();
    }
}
