package com.obric.autoaction.app.launcherpage.module.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: FirstLineItem.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24073a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f24075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f24076d;

    /* JADX INFO: compiled from: FirstLineItem.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final OTextView a(Context r8) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            o.e(r7, "context");
            OTextView r9 = new OTextView(r7, null, 0, null, 14, null);
            r9.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Subtitle_2_Regular, "style", "Subtitle_2_Regular"));
            r9.setTextColor(androidx.core.content.a.c(r7, ZeusTransformUtils.mapRes(R.color.oui_text_3, "color", "oui_text_3")));
            r9.setMaxLines(1);
            r9.setEllipsize(TextUtils.TruncateAt.END);
            r9.setGravity(16);
            return r9;
        }

        public final void a(ConstraintLayout r11, List<g> r12) {
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
            o.e(r11, "container");
            r11.removeAllViews();
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin");
            int r2 = 0;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            r11.setVisibility(8);
            return;
        L12:
            r11.setVisibility(0);
            List<Integer> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            Set<Integer> r4 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
            List<Integer> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L14:
            if (r14.hasNext() == false) goto L25;
            Object r6 = r14.next();
            int r7 = r2 + 1;
            if (r2 >= 0) goto L18;
            p.c();
        L18:
            g r8 = (g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin");
            if (r2 <= 0) goto L21;
            a r9 = g.f24073a;
            Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r10, "getContext(...)");
            View r15 = r9.b(r10);
            r15.setId(View.generateViewId());
            r11.addView(r15);
            r3.add(Integer.valueOf(r15.getId()));
            r4.add(Integer.valueOf(r15.getId()));
        L21:
            a r16 = g.f24073a;
            Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r17, "getContext(...)");
            OTextView r18 = r16.a(r17);
            r18.setId(View.generateViewId());
            g.f24073a.a(r18, r8);
            r11.addView((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.aiagent.plugin"));
            r3.add(Integer.valueOf(r18.getId()));
            if (r8.c() == false) goto L24;
            r5.add(Integer.valueOf(r18.getId()));
        L24:
            r2 = r7;
            goto L14
        L25:
            a(r11, r3, r4, r5);
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }

        private final View b(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            View r5 = new View(r3);
            r5.setBackgroundColor(androidx.core.content.a.c(r3, ZeusTransformUtils.mapRes(R.color.oui_basic_line_2, "color", "oui_basic_line_2")));
            return r5;
        }

        private final void a(OTextView r4, g r5) {
            r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.aiagent.plugin"));
            if (r5.b() == null) goto L5;
            Drawable r3 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5.b().intValue());
            r4.setCompoundDrawablePadding(d.i.a.a(TypedValue.applyDimension(1, 4, Resources.getSystem().getDisplayMetrics())));
            r4.setCompoundDrawablesWithIntrinsicBounds(r3, null, null, null);
            return;
        L5:
            r4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }

        private final void a(ConstraintLayout r12, List<Integer> r13, Set<Integer> r14, List<Integer> r15) {
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
            Set r16 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
            List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
            if (r11.isEmpty() == false) goto L5;
            return;
        L5:
            androidx.constraintlayout.widget.c r18 = new androidx.constraintlayout.widget.c();
            r18.b(r12);
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            int r3 = 0;
        L7:
            if (r1.hasNext() == false) goto L24;
            Object r4 = r1.next();
            int r6 = r3 + 1;
            if (r3 >= 0) goto L11;
            p.c();
        L11:
            int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
            if (r16.contains(Integer.valueOf(r5)) == false) goto L14;
            r18.c(r5, d.i.a.a(TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics())));
            r18.b(r5, d.i.a.a(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics())));
            float r7 = 8;
            r18.a(r5, 6, d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
            r18.a(r5, 7, d.i.a.a(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())));
        L15:
            r18.a(r5, 3, 0, 3);
            r18.a(r5, 4, 0, 4);
            if (r3 != 0) goto L18;
            r18.a(r5, 6, 0, 6);
        L20:
            if (r3 != p.b(r11)) goto L22;
            r18.a(r5, 7, 0, 7);
        L23:
            r3 = r6;
            goto L7
        L22:
            r18.a(r5, 7, ((Number) ZeusTransformUtils.preCheckCast(r11.get(r6), Number.class, "com.obric.aiagent.plugin")).intValue(), 6);
            goto L23
        L18:
            r18.a(r5, 6, ((Number) ZeusTransformUtils.preCheckCast(r11.get(r3 - 1), Number.class, "com.obric.aiagent.plugin")).intValue(), 7);
            goto L20
        L14:
            r18.c(r5, -2);
            r18.b(r5, -2);
            goto L15
        L24:
            r18.d(((Number) ZeusTransformUtils.preCheckCast(p.k(r11), Number.class, "com.obric.aiagent.plugin")).intValue(), 2);
            r18.a(((Number) ZeusTransformUtils.preCheckCast(p.k(r11), Number.class, "com.obric.aiagent.plugin")).intValue(), 0.0f);
            Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L26:
            if (r19.hasNext() == false) goto L28;
            r18.a(((Number) ZeusTransformUtils.preCheckCast(r19.next(), Number.class, "com.obric.aiagent.plugin")).intValue(), true);
            goto L26
        L28:
            r18.c(r12);
        }
    }

    static {
        f24073a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24074b, r6.f24074b) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f24075c, r6.f24075c) == true) goto L15;
        return false;
    L15:
        if (this.f24076d == r6.f24076d) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.f24074b.hashCode() * 31;
        Integer r1 = this.f24075c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.f24076d);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "FirstLineItem(text=" + this.f24074b + ", resId=" + this.f24075c + ", fillRemaining=" + this.f24076d + ')';
    }

    public g(String r2, Integer r3, boolean r4) {
        o.e(r2, "text");
        this.f24074b = r2;
        this.f24075c = r3;
        this.f24076d = r4;
    }

    public /* synthetic */ g(String r1, Integer r2, boolean r3, int r4, d.h.b.h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        this(r1, r2, r3);
    }

    public final String a() {
        return this.f24074b;
    }

    public final Integer b() {
        return this.f24075c;
    }

    public final boolean c() {
        return this.f24076d;
    }
}
