package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import g.l0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public TypedValue f324a;

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f325b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f326c;
    public TypedValue d;

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f327e;

    /* renamed from: f, reason: collision with root package name */
    public TypedValue f328f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f329g;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f329g = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f327e == null) {
            this.f327e = new TypedValue();
        }
        return this.f327e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f328f == null) {
            this.f328f = new TypedValue();
        }
        return this.f328f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f326c == null) {
            this.f326c = new TypedValue();
        }
        return this.f326c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.d == null) {
            this.d = new TypedValue();
        }
        return this.d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f324a == null) {
            this.f324a = new TypedValue();
        }
        return this.f324a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f325b == null) {
            this.f325b = new TypedValue();
        }
        return this.f325b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(l0 l0Var) {
    }
}
