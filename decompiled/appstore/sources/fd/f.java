package fd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.o;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f19662g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PopupWindow f19665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f19666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f19667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f19668f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f19662g = new a(null);
    }

    public f(Context r10) {
        q.g(r10, "context");
        this.f19663a = r10;
        this.f19664b = "OIndexPopupWindowLayout";
        View r11 = LayoutInflater.from(r10).inflate(R$layout.o_index_scrollbar_popup_circle, null);
        this.f19666d = r11.findViewById(R$id.popup_container);
        this.f19668f = (ImageView) r11.findViewById(R$id.popup_img);
        TextView r12 = (TextView) r11.findViewById(R$id.popup_text);
        this.f19667e = r12;
        if (r12 == null) goto L6;
        d(r12.getCurrentTextColor());
    L6:
        View r13 = this.f19666d;
        if ((r13 instanceof OUILinearLayout) == false) goto L13;
        if (r13 == null) goto L13;
        OUILinearLayout r14 = (OUILinearLayout) r13;
        r14.setEnableShadowWidthRadius(true);
        if (o.e(r10) == false) goto L13;
        GradientDrawable r15 = new GradientDrawable();
        r15.setShape(1);
        r15.setSize(tc.f.r(r13, 48), tc.f.r(r13, 48));
        r15.setColor(0);
        r14.setBackground(r15);
        r14.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        o.l(r13, MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!td.i.a(r13))), false, null, 6, null);
    L13:
        this.f19665c = new PopupWindow(r11, -2, -2, false);
    }

    public final void a() {
        PopupWindow r10 = this.f19665c;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.isShowing() != true) goto L12;
        PopupWindow r11 = this.f19665c;
        if (r11 == null) goto L14;
        r11.dismiss();
        return;
    L14:
        return;
    }

    public final boolean b() {
        PopupWindow r10 = this.f19665c;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.isShowing() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final void c(View r10, String r11, Bitmap r12, int r13, int r14, int r15) {
        q.g(r10, "anchorView");
        q.g(r11, "letter");
        if (r12 != null) goto L16;
        TextView r16 = this.f19667e;
        if (r16 == null) goto L8;
        r16.setText(r11);
    L8:
        ImageView r17 = this.f19668f;
        if (r17 == null) goto L12;
        r17.setVisibility(8);
    L12:
        TextView r18 = this.f19667e;
        if (r18 == null) goto L28;
        r18.setVisibility(0);
    L28:
        PopupWindow r19 = this.f19665c;
        if (r19 != null) goto L32;
        L.j(this.f19664b, "showPopup skipped: popupWindow is null.");
        return;
    L32:
        View r20 = r19.getContentView();
        if (r20 != null) goto L37;
        L.j(this.f19664b, "showPopup skipped: contentView is null.");
        return;
    L37:
        if (r10.isAttachedToWindow() == true) goto L40;
        L.j(this.f19664b, "showPopup skipped: anchorView is not attached to window.");
        return;
    L40:
        int r21 = bg.h.d(r14 - (r20.getMeasuredHeight() / 2), r15);
        if (r19.isShowing() == true) goto L43;
        r19.setElevation(tc.f.q(r10, 45.0f));
        r19.showAtLocation(r10, 0, r13, r21);
        r20.setElevation(0.0f);
        return;
    L43:
        r19.update(r13, r21, -2, -2);
        return;
    L16:
        TextView r22 = this.f19667e;
        if (r22 == null) goto L20;
        r22.setVisibility(8);
    L20:
        ImageView r23 = this.f19668f;
        if (r23 == null) goto L24;
        r23.setVisibility(0);
    L24:
        ImageView r24 = this.f19668f;
        if (r24 == null) goto L28;
        r24.setImageBitmap(r12);
        goto L28
    }

    public final void d(int r10) {
        ImageView r11 = this.f19668f;
        if (r11 == null) goto L7;
        r11.setColorFilter(r10, PorterDuff.Mode.SRC_IN);
        return;
    }
}
