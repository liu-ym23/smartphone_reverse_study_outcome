package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends x implements l {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f7929h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f7929h = kVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        w2.a(this, getContentDescription());
        setOnTouchListener(new l.b(this, this, 1));
    }

    @Override // m.l
    public final boolean a() {
        return false;
    }

    @Override // m.l
    public final boolean b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f7929h.l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i3, int i10, int i11) {
        boolean frame = super.setFrame(i, i3, i10, i11);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
