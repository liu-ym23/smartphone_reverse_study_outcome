package com.stepos.ailauncher.sheet.internal;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.R$dimen;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u001c\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/L;", "", "Landroid/view/View;", "host", "panel", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "", "remaining", "LY8/t;", Const.INTENT_KEY_UMID, "(F)V", "c", "()V", "Landroid/view/View;", "Landroid/view/ViewOutlineProvider;", "kotlin.jvm.PlatformType", "savedProvider", "Landroid/view/ViewOutlineProvider;", "", "savedClip", "Z", "Landroid/graphics/Rect;", "rect", "Landroid/graphics/Rect;", "radius", "F", "corner", "gap", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L {
    private final float corner;
    private final float gap;
    private final View host;
    private final View panel;
    private float radius;
    private final Rect rect;
    private final boolean savedClip;
    private final ViewOutlineProvider savedProvider;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/sheet/internal/L$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(L.this.rect, L.this.radius);
        }
    }

    public L(View host, View panel) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(panel, "panel");
        this.host = host;
        this.panel = panel;
        this.savedProvider = host.getOutlineProvider();
        this.savedClip = host.getClipToOutline();
        this.rect = new Rect();
        this.corner = host.getResources().getDimension(R$dimen.ail_sheet_corner);
        this.gap = host.getResources().getDimension(R$dimen.ail_sheet_enter_bottom_gap);
        host.setOutlineProvider(new a());
        host.setClipToOutline(true);
    }

    public final void c() {
        this.host.setOutlineProvider(this.savedProvider);
        this.host.setClipToOutline(this.savedClip);
        this.host.invalidateOutline();
    }

    public final void d(float remaining) {
        float fM = C5685n.m(remaining / 0.2f, 0.0f, 1.0f);
        float width = (this.panel.getWidth() * this.panel.getScaleX()) + this.panel.getX() + (this.panel.getPivotX() * (1.0f - this.panel.getScaleX()));
        int iCeil = (int) Math.ceil(r0);
        int iF = C5685n.f((int) Math.floor(width), iCeil + 1);
        this.radius = C5685n.i(this.corner * fM, (iF - iCeil) / 2.0f);
        this.rect.set(iCeil, -((int) Math.ceil(r2)), iF, (int) Math.floor(this.host.getHeight() - (this.gap * fM)));
        this.host.invalidateOutline();
    }
}
