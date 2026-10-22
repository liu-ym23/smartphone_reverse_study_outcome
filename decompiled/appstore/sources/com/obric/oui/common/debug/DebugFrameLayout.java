package com.obric.oui.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12963a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f12963a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DebugFrameLayout(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        int r15 = r13 - r11;
        d r16 = d.f24779a;
        r16.a("DebugFrameLayout onLayout", "Layout left: " + r11 + ", top: " + r12 + ", right: " + r13 + ", bottom: " + r14);
        StringBuilder r17 = new StringBuilder();
        r17.append("Layout width: ");
        r17.append(r15);
        r17.append(", height: ");
        r17.append(r14 - r12);
        r16.a("DebugFrameLayout onLayout", r17.toString());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r12 = View.MeasureSpec.getMode(r10);
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = View.MeasureSpec.getMode(r11);
        int r15 = View.MeasureSpec.getSize(r11);
        int r16 = getMeasuredWidth();
        int r17 = getMeasuredHeight();
        String r18 = "AT_MOST";
        if (r12 == Integer.MIN_VALUE) goto L9;
        if (r12 == 0) goto L8;
        if (r12 == 1073741824) goto L7;
        String r19 = "UNKNOWN";
    L10:
        if (r14 == Integer.MIN_VALUE) goto L16;
        if (r14 == 0) goto L15;
        if (r14 == 1073741824) goto L14;
        r18 = "UNKNOWN";
        goto L16
    L14:
        r18 = "EXACTLY";
        goto L16
    L15:
        r18 = "UNSPECIFIED";
    L16:
        d r20 = d.f24779a;
        r20.a("DebugFrameLayout onMeasure", "Width mode: " + r19 + ", width size: " + r13 + ", measured width: " + r16);
        r20.a("DebugFrameLayout onMeasure", "Height mode: " + r18 + ", height size: " + r15 + ", measured height: " + r17);
        return;
    L7:
        r19 = "EXACTLY";
        goto L10
    L8:
        r19 = "UNSPECIFIED";
        goto L10
    L9:
        r19 = "AT_MOST";
        goto L10
    }

    public /* synthetic */ DebugFrameLayout(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public DebugFrameLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
    }
}
