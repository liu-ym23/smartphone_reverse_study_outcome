package defpackage;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.TextView;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.ui.widget.MarqueeTextView;
import com.obric.appstore.common.core.ui.view.ObricAppStatusView;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.text.OTextView;
import kotlin.jvm.internal.q;
import sa.p;
import yf.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3c = 0;

    static {
        f1a = new a();
        f2b = b.b(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()));
        f3c = b.b(TypedValue.applyDimension(1, 64, Resources.getSystem().getDisplayMetrics()));
    }

    public a() {
    }

    public final void a(int r11, p r12) {
        q.g(r12, "binding");
        int r10 = r12.f24648m.getHeight() - r12.f24648m.getMinimumHeight();
        r12.f24648m.setTranslationY(Math.abs(r11));
        float r13 = Math.min(Math.abs(Math.min(0, r11)), r10) / r10;
        NetworkImageView r14 = r12.f24641f;
        int r15 = f2b;
        int r16 = f3c;
        float r17 = r15 / r16;
        float r18 = 1;
        float r19 = r18 - r13;
        float r20 = r17 + ((r18 - r17) * r19);
        r14.setPivotX(0.0f);
        r14.setPivotY(0.0f);
        r14.setScaleX(r20);
        r14.setScaleY(r20);
        r14.setTranslationY((r12.f24654s.getTop() - r14.getTop()) * r13);
        ObricAppStatusView r110 = r12.f24646k;
        r110.setTranslationY((r12.f24653r.getTop() - r110.getTop()) * r13);
        MarqueeTextView r111 = r12.f24643h;
        int r21 = r12.f24655t.getLeft();
        r111.setTranslationX((r21 - r111.getLeft()) * r13);
        int r22 = r12.f24655t.getTop();
        r111.setTranslationY((r22 - r111.getTop()) * r13);
        float r23 = ((r18 - 0.7f) * r19) + 0.7f;
        r111.setPivotX(0.0f);
        r111.setPivotY(0.0f);
        r111.setScaleX(r23);
        r111.setScaleY(r23);
        if (r12.f24644i.getLineCount() != 1) goto L5;
        r12.f24644i.setTranslationX((r21 - r111.getLeft()) * r13);
        r12.f24644i.setTranslationY((r22 - r111.getTop()) * r13);
        float r24 = 1.4285715f - (0.42857146f * r13);
        r12.f24644i.setPivotX(0.0f);
        r12.f24644i.setPivotY(0.0f);
        r12.f24644i.setScaleX(r24);
        r12.f24644i.setScaleY(r24);
    L5:
        float r112 = r12.f24644i.getLayout().getLineWidth(0);
        if (r12.f24643h.getLineCount() == 2) goto L8;
    L12:
        r12.f24644i.setAlpha(0.0f);
        r12.f24643h.setAlpha(1.0f);
    L13:
        TextView r113 = r12.f24645j;
        r113.setTranslationX((r12.f24655t.getLeft() - r113.getLeft()) * r13);
        r113.setTranslationY((r12.f24656u.getTop() - r113.getTop()) * r13);
        OTextView r114 = r12.f24640e;
        r114.setTranslationX((r12.f24655t.getLeft() - r114.getLeft()) * r13);
        r114.setAlpha(r19);
        OChipGroup r115 = r12.f24651p;
        r115.setTranslationY((-(r16 - r15)) * r13);
        r115.setAlpha(r19);
        return;
    L8:
        if (r12.f24644i.getLineCount() != 1) goto L12;
        if ((r112 * r12.f24644i.getScaleX()) > r12.f24643h.getWidth()) goto L12;
        r12.f24644i.setAlpha(1.0f);
        r12.f24643h.setAlpha(0.0f);
        goto L13
    }
}
