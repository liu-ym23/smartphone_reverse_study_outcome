package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.d.i;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: OIndexPopupWindowController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f35318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f35319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PopupWindow f35320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f35321e;
    private TextView f;
    private ImageView g;

    /* JADX INFO: compiled from: OIndexPopupWindowController.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f35317a = new a(null);
    }

    public d(Context r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        Context r13 = ZeusTransformUtils.wrapperContext(r12, "com.obric.aiagent.plugin");
        this.f35318b = r13;
        this.f35319c = "OIndexPopupWindowLayout";
        View r0 = ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.o_index_scrollbar_popup_circle, "layout", "o_index_scrollbar_popup_circle"), null, "com.obric.aiagent.plugin");
        this.f35321e = r0.findViewById(ZeusTransformUtils.mapRes(R.id.popup_container, DbHelper.COL_ID, "popup_container"));
        this.g = (ImageView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.popup_img, DbHelper.COL_ID, "popup_img")), ImageView.class, "com.obric.aiagent.plugin");
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.popup_text, DbHelper.COL_ID, "popup_text")), TextView.class, "com.obric.aiagent.plugin");
        this.f = r2;
        if (r2 == null) goto L7;
        a(r2.getCurrentTextColor());
    L7:
        if (ZeusTransformUtils.instanceOf(this.f35321e, OUILinearLayout.class) == false) goto L14;
        View r4 = this.f35321e;
        if (r4 == null) goto L14;
        ((OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.aiagent.plugin")).setEnableShadowWidthRadius(true);
        if (k.a(r13) == false) goto L14;
        OUILinearLayout r14 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.aiagent.plugin");
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(1);
        r3.setSize(g.a(r4, 48), g.a(r4, 48));
        r3.setColor(0);
        r14.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"));
        ((OUILinearLayout) ZeusTransformUtils.preCheckCast(r4, OUILinearLayout.class, "com.obric.aiagent.plugin")).setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        k.a(r4, (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!i.a(r4))), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"), false, null, 6, null);
    L14:
        this.f35320d = new PopupWindow(r0, -2, -2, false);
    }

    public final void a(int r2, Drawable r3) {
        TextView r0 = this.f;
        if (r0 == null) goto L6;
        r0.setTextColor(r2);
    L6:
        a(r2);
        View r1 = this.f35321e;
        if (r1 == null) goto L11;
        r1.setBackground(r3);
        return;
    }

    public final void a(View r5, String r6, Bitmap r7, int r8, int r9, int r10) {
        o.e(r5, "anchorView");
        o.e(r6, "letter");
        if (r7 != null) goto L16;
        TextView r11 = this.f;
        if (r11 == null) goto L8;
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"));
    L8:
        ImageView r12 = this.g;
        if (r12 == null) goto L12;
        r12.setVisibility(8);
    L12:
        TextView r13 = this.f;
        if (r13 == null) goto L28;
        r13.setVisibility(0);
    L28:
        PopupWindow r14 = this.f35320d;
        if (r14 != null) goto L32;
        com.obric.oui.d.a.b.d(this.f35319c, "showPopup skipped: popupWindow is null.");
        return;
    L32:
        View r15 = r14.getContentView();
        if (r15 != null) goto L37;
        com.obric.oui.d.a.b.d(((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")).f35319c, "showPopup skipped: contentView is null.");
        return;
    L37:
        if (r5.isAttachedToWindow() == true) goto L40;
        com.obric.oui.d.a.b.d(this.f35319c, "showPopup skipped: anchorView is not attached to window.");
        return;
    L40:
        int r4 = n.c(r9 - (r15.getMeasuredHeight() / 2), r10);
        if (r14.isShowing() == true) goto L43;
        r14.setElevation(g.a(r5, 45.0f));
        r14.showAtLocation(r5, 0, r8, r4);
        r15.setElevation(0.0f);
        return;
    L43:
        r14.update(r8, r4, -2, -2);
        return;
    L16:
        TextView r16 = this.f;
        if (r16 == null) goto L20;
        r16.setVisibility(8);
    L20:
        ImageView r17 = this.g;
        if (r17 == null) goto L24;
        r17.setVisibility(0);
    L24:
        ImageView r18 = this.g;
        if (r18 == null) goto L28;
        r18.setImageBitmap(r7);
        goto L28
    }

    private final void a(int r2) {
        ImageView r1 = this.g;
        if (r1 == null) goto L7;
        r1.setColorFilter(r2, PorterDuff.Mode.SRC_IN);
        return;
    }

    public final void a() {
        PopupWindow r0 = this.f35320d;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L14;
        PopupWindow r3 = this.f35320d;
        if (r3 == null) goto L15;
        r3.dismiss();
        return;
    L15:
        return;
    L14:
        return;
    L6:
        if (r0.isShowing() != true) goto L8;
        r1 = true;
        goto L8
    }

    public final boolean b() {
        PopupWindow r2 = this.f35320d;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.isShowing() == true) goto L8;
        return false;
    L8:
        return true;
    }
}
