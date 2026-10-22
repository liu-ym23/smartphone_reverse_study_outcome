package com.obric.oui.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.common.style.Shadow;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0016\u0018\u0000  2\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0015¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/obric/oui/shadow/OShadowLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "b", "()V", "Landroid/graphics/Path;", "path", "Landroid/graphics/RectF;", "regionRect", "Lcom/obric/oui/common/style/Shadow;", "shadow", "a", "(Landroid/graphics/Canvas;Landroid/graphics/Path;Landroid/graphics/RectF;Lcom/obric/oui/common/style/Shadow;)V", "Lcom/obric/oui/common/style/Shadow;", "firstShadow", "secondShadow", "", "c", "F", "shadowCornerRadius", "d", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f16757d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Shadow f16758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Shadow f16759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16760c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f16757d = new a(null);
    }

    @JvmOverloads
    public OShadowLayout(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public final void a(Canvas r10, Path r11, RectF r12, Shadow r13) {
        int r14 = r10.save();
        RectF r15 = new RectF(r12);
        r15.offset(r13.f(), r13.g());
        r15.inset(-r13.j(), -r13.j());
        r10.clipOutPath(r11);
        float r16 = this.f16760c;
        r10.drawRoundRect(r15, r16, r16, r13.h());
        r10.restoreToCount(r14);
    }

    public final void b() {
        Math.max(Math.abs(this.f16758a.f()) + Math.abs(this.f16758a.i()), Math.abs(this.f16759b.f()) + Math.abs(this.f16759b.i()));
        Math.max(Math.abs(this.f16758a.g()) + Math.abs(this.f16758a.i()), Math.abs(this.f16759b.g()) + Math.abs(this.f16759b.i()));
    }

    @Override // android.view.View
    public void onDraw(Canvas r12) {
        q.g(r12, "canvas");
        super.onDraw(r12);
        Path r10 = new Path();
        int r11 = getChildCount();
        int r13 = Channel.UNLIMITED;
        int r14 = Integer.MIN_VALUE;
        int r15 = 0;
        int r16 = Integer.MAX_VALUE;
        int r17 = Integer.MIN_VALUE;
    L3:
        if (r15 >= r11) goto L9;
        int r18 = r15 + 1;
        View r19 = getChildAt(r15);
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if (r20 == null) goto L8;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        r13 = Math.min(r13, r19.getLeft() - r21.leftMargin);
        r16 = Math.min(r16, r19.getTop() - r21.topMargin);
        r17 = Math.max(r17, r19.getRight() + r21.rightMargin);
        r14 = Math.max(r14, r19.getBottom() + r21.bottomMargin);
        r15 = r18;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        RectF r22 = new RectF(r13, r16, r17, r14);
        float r23 = this.f16760c;
        r10.addRoundRect(r22, r23, r23, Path.Direction.CW);
        RectF r24 = new RectF();
        r10.computeBounds(r24, true);
        a(r12, r10, r24, this.f16758a);
        a(r12, r10, r24, this.f16759b);
    }

    @JvmOverloads
    public OShadowLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OShadowLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OShadowLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        Shadow r13 = Shadow.f13061i;
        this.f16758a = r13.a();
        this.f16759b = r13.a();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.OShadowLayout, r12, 0);
        q.f(r14, "context.obtainStyledAttr…wLayout, defStyleAttr, 0)");
        b[] r15 = d.a(r14.getString(R$styleable.OShadowLayout_oui_shadow));
        float r16 = r10.getResources().getDisplayMetrics().density;
        if (r15 != null) goto L5;
        Shadow r17 = this.f16758a;
        com.obric.oui.shadow.a.C0207a r18 = com.obric.oui.shadow.a.f16761g;
        r17.r(r18.a(r14, R$styleable.OShadowLayout_oui_firstShadowColor, R$styleable.OShadowLayout_oui_firstShadowRadius, R$styleable.OShadowLayout_oui_firstOffsetX, R$styleable.OShadowLayout_oui_firstOffsetY, R$styleable.OShadowLayout_oui_firstShadowSpread));
        this.f16759b.r(r18.a(r14, R$styleable.OShadowLayout_oui_secondShadowColor, R$styleable.OShadowLayout_oui_secondShadowRadius, R$styleable.OShadowLayout_oui_secondOffsetX, R$styleable.OShadowLayout_oui_secondOffsetY, R$styleable.OShadowLayout_oui_secondShadowSpread));
    L14:
        this.f16760c = r14.getDimension(R$styleable.OShadowLayout_oui_shadowCornerRadius, 0.0f);
        r14.recycle();
        setWillNotDraw(false);
        b();
        return;
    L5:
        if (r15.length != 0) goto L7;
        boolean r19 = true;
    L8:
        if (r19 == true) goto L11;
        Shadow r20 = this.f16758a;
        b r21 = r15[0];
        q.f(r21, "shadowToken[0]");
        r20.t(r21, r16);
    L11:
        if (r15.length <= 1) goto L14;
        Shadow r22 = this.f16759b;
        b r110 = r15[1];
        q.f(r110, "shadowToken[1]");
        r22.t(r110, r16);
        goto L14
    L7:
        r19 = false;
        goto L8
    }
}
