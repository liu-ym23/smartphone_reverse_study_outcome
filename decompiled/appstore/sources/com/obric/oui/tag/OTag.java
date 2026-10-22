package com.obric.oui.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use OTextTag")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/tag/OTag;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "I", "getTagSize$annotations", "()V", "tagSize", "", "b", "Z", "bordered", "c", "borderColor", "d", "bgStartColor", "e", "bgEndColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTag extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f17243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17244e;

    @JvmOverloads
    public OTag(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }

    @JvmOverloads
    public OTag(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OTag(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OTag(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        TypedArray r13 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OTag, 0, 0);
        this.f17240a = r13.getInteger(R$styleable.OTag_oui_size, 0);     // Catch: Throwable -> L18
        this.f17241b = r13.getBoolean(R$styleable.OTag_oui_bordered, false);     // Catch: Throwable -> L18
        this.f17242c = r13.getColor(R$styleable.OTag_oui_borderColor, 0);     // Catch: Throwable -> L18
        this.f17243d = r13.getColor(R$styleable.OTag_oui_bgGradientStartColor, 0);     // Catch: Throwable -> L18
        this.f17244e = r13.getColor(R$styleable.OTag_oui_bgGradientEndColor, 0);     // Catch: Throwable -> L18
        r13.recycle();
        int r14 = this.f17240a;
        if (r14 == 0) goto L9;
        if (r14 == 2) goto L8;
        int r15 = f.r(this, 1);
        int r16 = f.r(this, 3);
    L10:
        setPadding(r16, r15, r16, r15);
        if (this.f17243d != 0) goto L13;
    L15:
        GradientDrawable r17 = new GradientDrawable();
    L16:
        r17.setCornerRadius(f.r(this, 2));
        setBackground(r17);
        return;
    L13:
        if (this.f17244e == 0) goto L15;
        r17 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{this.f17243d, this.f17244e});
        goto L16
    L8:
        r15 = f.r(this, 2);
        r16 = f.r(this, 4);
        goto L10
    L9:
        r16 = f.r(this, 3);
        r15 = f.r(this, 1);
    L18:
        th = move-exception;
        r13.recycle();
        throw th;
    }
}
