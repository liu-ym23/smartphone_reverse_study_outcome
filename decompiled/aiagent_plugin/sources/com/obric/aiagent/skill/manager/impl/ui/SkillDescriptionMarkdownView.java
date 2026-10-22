package com.obric.aiagent.skill.manager.impl.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.markdown.OMarkdownView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: SkillDescriptionMarkdownView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillDescriptionMarkdownView extends FrameLayout {
    private static final a Companion = null;

    @Deprecated
    public static final int MARKDOWN_END_SAFETY_INSET_DP = 4;
    private int lastContentHeight;
    private final OMarkdownView markdownView;
    private d.h.a.a<d.x> onContentHeightChanged;

    /* JADX INFO: compiled from: SkillDescriptionMarkdownView.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final com.obric.oui.markdown.d a(Context r31) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r31, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r0, "context");
            String r14 = com.obric.oui.markdown.e.a(r0, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
            String r1 = com.obric.oui.markdown.e.a(r0, ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"));
            com.obric.oui.markdown.d r27 = new com.obric.oui.markdown.d(r0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, false, 0, 0, 0, 8388606, null);
            HashMap<String, Object> r2 = r27.b();
            Float r3 = Float.valueOf(14.0f);
            r2.put("fontSize", r3);
            r2.put("lineHeight", 22);
            r2.put("paragraphSpace", 8);
            r2.put("color", r14);
            HashMap<String, Object> r4 = r27.c();
            r4.put("fontSize", Float.valueOf(18.0f));
            r4.put("lineHeight", 26);
            r4.put("paragraphSpace", 8);
            r4.put("color", r14);
            HashMap<String, Object> r5 = r27.d();
            r5.put("fontSize", Float.valueOf(16.0f));
            r5.put("lineHeight", 24);
            r5.put("paragraphSpace", 8);
            r5.put("color", r14);
            HashMap<String, Object> r6 = r27.e();
            r6.put("fontSize", Float.valueOf(15.0f));
            r6.put("lineHeight", 22);
            r6.put("paragraphSpace", 6);
            r6.put("color", r14);
            HashMap<String, Object> r7 = r27.f();
            r7.put("fontSize", r3);
            r7.put("lineHeight", 22);
            r7.put("paragraphSpace", 6);
            r7.put("color", r14);
            HashMap<String, Object> r8 = r27.g();
            r8.put("fontSize", r3);
            r8.put("lineHeight", 22);
            r8.put("paragraphSpace", 6);
            r8.put("color", r14);
            HashMap<String, Object> r9 = r27.h();
            r9.put("fontSize", r3);
            r9.put("lineHeight", 22);
            r9.put("paragraphSpace", 6);
            r9.put("color", r14);
            r27.i().put("color", r14);
            HashMap<String, Object> r10 = r27.k();
            r10.put("fontSize", Float.valueOf(13.0f));
            r10.put("lineHeight", 20);
            r10.put("paragraphSpace", 6);
            r10.put("color", r1);
            r27.j().put("fontSize", r3);
            HashMap<String, Object> r11 = r27.m();
            r11.put("paragraphSpace", 4);
            r11.put("marginBottom", 6);
            r11.put("markColor", r14);
            r11.put("markMarginLeft", 8);
            r11.put("markMarginRight", 8);
            HashMap<String, Object> r12 = r27.l();
            r12.put("paragraphSpace", 4);
            r12.put("marginBottom", 6);
            r12.put("indent", 20);
            return r27;
        }
    }

    /* JADX INFO: compiled from: SkillDescriptionMarkdownView.kt */
    public static final class b implements OMarkdownView.a {
        @Override // com.obric.oui.markdown.OMarkdownView.a
        public Drawable a(String r1) {
            d.h.b.o.e(r1, "url");
            return null;
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public boolean a() {
            return true;
        }

        b() {
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void a(int r1, int r2, int r3) {
            OMarkdownView.a.C0959a.a(this, r1, r2, r3);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void b() {
            OMarkdownView.a.C0959a.b(this);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void b(String r1) {
            OMarkdownView.a.C0959a.b(this, r1);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void c() {
            OMarkdownView.a.C0959a.a(this);
        }

        @Override // com.obric.oui.markdown.OMarkdownView.a
        public void c(String r1) {
            OMarkdownView.a.C0959a.a(this, r1);
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkillDescriptionMarkdownView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void lambda$2oBPSGO7oZcysxaQ2CnQzVm8bi0(SkillDescriptionMarkdownView r0) {
        onLayout$lambda$1(r0);
    }

    public /* synthetic */ SkillDescriptionMarkdownView(Context r2, AttributeSet r3, int r4, d.h.b.h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public SkillDescriptionMarkdownView(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        super(r7, r8);
        OMarkdownView r9 = new OMarkdownView(r7, null, 2, null);
        r9.setPaddingRelative(0, 0, d.i.a.a(4 * ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getDisplayMetrics().density), 0);
        r9.setClipToPadding(false);
        r9.setClipChildren(false);
        r9.setOverScrollMode(2);
        r9.setVerticalScrollBarEnabled(false);
        r9.setHorizontalScrollBarEnabled(false);
        r9.setNestedScrollingEnabled(false);
        r9.setFocusable(false);
        r9.enableTextSelection(false);
        r9.setDelegate((OMarkdownView.a) ZeusTransformUtils.preCheckCast(new b(), OMarkdownView.a.class, "com.obric.aiagent.plugin"));
        r9.setStyle(Companion.a(r7));
        this.markdownView = r9;
        this.lastContentHeight = -1;
        addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public final d.h.a.a<d.x> getOnContentHeightChanged$impl_release() {
        return this.onContentHeightChanged;
    }

    public final void setOnContentHeightChanged$impl_release(d.h.a.a<d.x> r3) {
        this.onContentHeightChanged = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void setMarkdownContent$impl_release(String r3) {
        d.h.b.o.e(r3, "content");
        this.lastContentHeight = -1;
        this.markdownView.scrollTo(0, 0);
        this.markdownView.setMarkdownContent(r3);
        this.markdownView.requestLayout();
        requestLayout();
    }

    public final void clearMarkdownContent$impl_release() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.markdownView.getMarkdownText(), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.lastContentHeight = -1;
        this.markdownView.scrollTo(0, 0);
        this.markdownView.setMarkdownContent("");
        this.markdownView.requestLayout();
        requestLayout();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r6, int r7) {
        int r0 = FrameLayout.getChildMeasureSpec(r6, getPaddingLeft() + getPaddingRight(), -1);
        this.markdownView.measure(r0, View.MeasureSpec.makeMeasureSpec(0, 0));
        int r1 = (d.l.n.c(this.markdownView.getContentHeight(), this.markdownView.getMeasuredHeight()) + getPaddingTop()) + getPaddingBottom();
        int r8 = FrameLayout.resolveSize((this.markdownView.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight(), r6);
        int r9 = FrameLayout.resolveSize(r1, r7);
        int r2 = d.l.n.c((r9 - getPaddingTop()) - getPaddingBottom(), 0);
        this.markdownView.measure(r0, View.MeasureSpec.makeMeasureSpec(r2, 1073741824));
        setMeasuredDimension(r8, r9);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = this.markdownView.getContentHeight();
        if (r6 != this.lastContentHeight) goto L5;
        return;
    L5:
        this.lastContentHeight = r6;
        post(new $$Lambda$SkillDescriptionMarkdownView$2oBPSGO7oZcysxaQ2CnQzVm8bi0(this));
    }

    private static final void onLayout$lambda$1(SkillDescriptionMarkdownView r0) {
        d.h.a.a<d.x> r1 = r0.onContentHeightChanged;
        if (r1 == null) goto L6;
        r1.invoke();
        return;
    }
}
