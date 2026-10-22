package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillUsageExampleAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cn {
    public static final /* synthetic */ void a(View r2, TextView r3, String r4, d.h.a.b r5) {
        b(r2, r3, r4, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: lambda$g71XC-QlyKNs0bTrfABLRJwmkOA, reason: not valid java name */
    public static /* synthetic */ void m341lambda$g71XCQlyKNs0bTrfABLRJwmkOA(d.h.a.b r0, e r1, View r2) {
        a(r0, r1, r2);
    }

    public static final void a(ViewGroup r10, List<String> r11, d.h.a.b<? super e, d.x> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r13, "examples");
        r10.removeAllViews();
        LayoutInflater r0 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r2 = (int) ((ZeusTransformUtils.getResources(r10, "com.obric.aiagent.plugin").getDisplayMetrics().density * 8.0f) + 0.5f);
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r4 = 0;
    L4:
        if (r15.hasNext() == false) goto L17;
        Object r5 = r15.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        d.a.p.c();
    L8:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        View r8 = ZeusTransformUtils.inflate(r0, ZeusTransformUtils.mapRes(R.layout.item_skill_usage_example, "layout", "item_skill_usage_example"), r10, false, "com.obric.aiagent.plugin");
        if (r4 <= 0) goto L16;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r9, ViewGroup.MarginLayoutParams.class) == false) goto L13;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L14:
        if (r16 == null) goto L16;
        r16.topMargin = r2;
        goto L16
    L13:
        r16 = null;
    L16:
        d.h.b.o.a(r8);
        View r17 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.example_text, DbHelper.COL_ID, "example_text"));
        d.h.b.o.c(r17, "findViewById(...)");
        b(r8, (TextView) ZeusTransformUtils.preCheckCast(r17, TextView.class, "com.obric.aiagent.plugin"), r7, r14);
        r10.addView(r8);
        r4 = r6;
        goto L4
    }

    private static final void b(View r8, TextView r9, String r10, d.h.a.b<? super e, d.x> r11) {
        final d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        final e r13 = cq.f20769a.a(r10);
        SpannableString r0 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r13.a(), CharSequence.class, "com.obric.aiagent.plugin"));
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        d.l.j r3 = (d.l.j) ZeusTransformUtils.preCheckCast(r2.next(), d.l.j.class, "com.obric.aiagent.plugin");
        r0.setSpan(new ForegroundColorSpan(a(r9, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"))), r3.a(), r3.b() + 1, 33);
        goto L4
    L6:
        r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r12 == null) goto L9;
        r8.setOnClickListener(new $$Lambda$cn$g71XCQlyKNs0bTrfABLRJwmkOA(r12, r13));
        return;
    L9:
        r8.setOnClickListener(null);
    }

    private static final void a(d.h.a.b r1, e r2, View r3) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r2);
    }

    private static final int a(TextView r3, int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getColor(r4, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme());
    L6:
        return ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getColor(r4);
    }
}
