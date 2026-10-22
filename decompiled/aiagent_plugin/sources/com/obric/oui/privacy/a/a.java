package com.obric.oui.privacy.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.d;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;

/* JADX INFO: compiled from: PrivacyPermissionViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends RecyclerView.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0981a f36082a = null;
    private final OCardListItem s;
    private final LinearLayout t;

    /* JADX INFO: renamed from: com.obric.oui.privacy.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PrivacyPermissionViewHolder.kt */
    public static final class C0981a {
        public /* synthetic */ C0981a(h r1) {
            this();
        }

        private C0981a() {
        }

        public final a a(Context r7) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            OCardListItem r6 = new OCardListItem(r1, null, 0, 6, null);
            r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r6.showIcon(false);
            r6.showDivider(false);
            r6.showCustomEnd(false);
            return new a(r6);
        }
    }

    static {
        f36082a = new C0981a(null);
    }

    public a(OCardListItem r7) {
        o.e(r7, "cardListItem");
        super((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        this.s = r7;
        r7.setCardType(2);
        OCardListItem.setCardPosition$default(r7, 0, false, 2, null);
        LinearLayout r0 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setOrientation(1);
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.t = r0;
        r7.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        r7.showCustomStart(true);
    }

    public final void a(d.a r24) {
        o.e(r24, "item");
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        this.t.removeAllViews();
        OTextView r4 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r1, ZeusTransformUtils.mapRes(R.style.Body_1_Regular, "style", "Body_1_Regular")), Context.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null);
        r4.setIncludeFontPadding(true);
        r4.setTextColor(androidx.core.content.a.c(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r24.a(), CharSequence.class, "com.obric.aiagent.plugin"));
        int r8 = -1;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-1, -2);
        o.c(r1, "context");
        r6.setMargins(g.a(r1, 12), g.a(r1, 8), g.a(r1, 12), g.a(r1, 8));
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.t.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r24.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        LinearLayout r7 = new LinearLayout(r1);
        r7.setOrientation(0);
        r7.setGravity(48);
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r8, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        LinearLayout r11 = new LinearLayout(r1);
        r11.setPadding(g.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 4), g.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 4), 0, 0);
        r11.setGravity(17);
        r11.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(g.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 24), g.a((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"), 20)), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        View r9 = new View(r1);
        int r13 = g.a(r9, 3.43d);
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(r13, r13), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(1);
        r14.setColor(androidx.core.content.a.c(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, "color", "oui_basic_text_3b")));
        r9.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r14, Drawable.class, "com.obric.aiagent.plugin"));
        r11.addView(r9);
        r7.addView((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.aiagent.plugin"));
        OTextView r10 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r1, ZeusTransformUtils.mapRes(R.style.Subtitle_2_Regular, "style", "Subtitle_2_Regular")), Context.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null);
        r10.setIncludeFontPadding(true);
        r10.setTextColor(androidx.core.content.a.c(r1, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        r10.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(0, -2, 1.0f), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r10.setPadding(0, g.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), 4), 0, g.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), 4));
        r7.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        this.t.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin"));
        r8 = -1;
        goto L4
    }
}
