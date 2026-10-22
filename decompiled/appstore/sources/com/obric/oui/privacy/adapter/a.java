package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.e;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends RecyclerView.t {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final C0205a f16380w = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OCardListItem f16381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinearLayout f16382v;

    /* JADX INFO: renamed from: com.obric.oui.privacy.adapter.a$a, reason: collision with other inner class name */
    public static final class C0205a {
        public /* synthetic */ C0205a(DefaultConstructorMarker r10) {
            this();
        }

        public final a a(Context r10) {
            q.g(r10, "context");
            OCardListItem r11 = new OCardListItem(r10, null, 0, 6, null);
            r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r11.E(false);
            r11.D(false);
            r11.B(false);
            return new a(r11);
        }

        public C0205a() {
        }
    }

    static {
        f16380w = new C0205a(null);
    }

    public a(OCardListItem r10) {
        q.g(r10, "cardListItem");
        super(r10);
        this.f16381u = r10;
        r10.setCardType(2);
        OCardListItem.s(r10, 0, false, 2, null);
        LinearLayout r11 = new LinearLayout(r10.getContext());
        r11.setOrientation(1);
        r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f16382v = r11;
        r10.setCustomStartView(r11);
        r10.C(true);
    }

    public final void O(e.a r22) {
        q.g(r22, "item");
        Context r10 = this.f16381u.getContext();
        this.f16382v.removeAllViews();
        OTextView r11 = new OTextView(new ContextThemeWrapper(r10, R$style.Body_1_Regular), null, 0, null, 14, null);
        r11.setIncludeFontPadding(true);
        r11.setTextColor(ContextCompat.b(r10, R$color.oui_basic_text_1));
        r11.setText(r22.a());
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams(-1, -2);
        q.f(r10, "context");
        r12.setMargins(f.b(r10, 12), f.b(r10, 8), f.b(r10, 12), f.b(r10, 8));
        r11.setLayoutParams(r12);
        this.f16382v.addView(r11);
        Iterator r13 = r22.b().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        String r14 = (String) r13.next();
        LinearLayout r15 = new LinearLayout(r10);
        r15.setOrientation(0);
        r15.setGravity(48);
        r15.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r16 = new LinearLayout(r10);
        r16.setPadding(f.r(r16, 4), f.r(r16, 4), 0, 0);
        r16.setGravity(17);
        r16.setLayoutParams(new LinearLayout.LayoutParams(f.r(r16, 24), f.r(r16, 20)));
        View r17 = new View(r10);
        int r18 = f.p(r17, 3.43d);
        r17.setLayoutParams(new LinearLayout.LayoutParams(r18, r18));
        GradientDrawable r19 = new GradientDrawable();
        r19.setShape(1);
        r19.setColor(ContextCompat.b(r10, R$color.oui_basic_text_3b));
        r17.setBackground(r19);
        r16.addView(r17);
        r15.addView(r16);
        OTextView r20 = new OTextView(new ContextThemeWrapper(r10, R$style.Subtitle_2_Regular), null, 0, null, 14, null);
        r20.setIncludeFontPadding(true);
        r20.setTextColor(ContextCompat.b(r10, R$color.oui_basic_text_3));
        r20.setText(r14);
        r20.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r20.setPadding(0, f.r(r20, 4), 0, f.r(r20, 4));
        r15.addView(r20);
        this.f16382v.addView(r15);
        goto L4
    }
}
