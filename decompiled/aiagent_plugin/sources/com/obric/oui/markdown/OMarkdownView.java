package com.obric.oui.markdown;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.widget.ScrollView;
import com.lynx.markdown.MarkdownView;
import com.lynx.markdown.f;
import com.obric.aiagent.plugin.R;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.aa;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: OMarkdownView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OMarkdownView extends ScrollView implements MarkdownView.b, f.a, f.b, OMarkdownActionModeCallback.a, com.obric.oui.markdown.c.b {
    private ActionMode actionMode;
    private final OMarkdownActionModeCallback actionModeCallback;
    private String currentMarkdownText;
    private a delegate;
    private boolean enableTextSelection;
    private Drawable leftSelectionCursor;
    private final f markdownLayout;
    private final com.obric.oui.markdown.c markdownResourceLoader;
    private d markdownStyle;
    private final OMarkdownContainerView markdownView;
    private Drawable rightSelectionCursor;

    /* JADX INFO: compiled from: OMarkdownView.kt */
    public interface a {

        /* JADX INFO: renamed from: com.obric.oui.markdown.OMarkdownView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OMarkdownView.kt */
        public static final class C0959a {
            public static void a(a r2) {
                a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            }

            public static void a(a r0, int r1, int r2, int r3) {
                a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r0, a.class, "com.obric.aiagent.plugin");
            }

            public static void a(a r2, String r3) {
                a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
                o.e(r3, "type");
            }

            public static void b(a r2) {
                a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            }

            public static void b(a r2, String r3) {
                a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
                o.e(r3, "link");
            }

            public static Drawable c(a r2, String r3) {
                a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
                o.e(r3, "url");
                return null;
            }

            public static boolean c(a r2) {
                a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
                return false;
            }
        }

        Drawable a(String r1);

        void a(int r1, int r2, int r3);

        boolean a();

        void b();

        void b(String r1);

        void c();

        void c(String r1);
    }

    /* JADX INFO: compiled from: OMarkdownView.kt */
    @d.c.b.a.f(b = "OMarkdownView.kt", c = {}, d = "invokeSuspend", e = "com.obric.oui.markdown.OMarkdownView$loadImage$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OMarkdownView f35431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f35432c;

        b(OMarkdownView r3, String r4, d.c.d r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f35431b = r3;
            this.f35432c = r4;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            o.e(r4, "completion");
            return new b(this.f35431b, this.f35432c, r4);
        }

        @Override // d.h.a.m
        public final Object invoke(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f35430a != 0) goto L12;
            d.o.a(r2);
            a r3 = this.f35431b.getDelegate();
            if (r3 == null) goto L10;
            Drawable r4 = r3.a(this.f35432c);
            if (r4 == null) goto L10;
            OMarkdownView.access$getMarkdownResourceLoader$p(this.f35431b).a(this.f35432c, r4);
        L10:
            return x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: OMarkdownView.kt */
    static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OMarkdownView f35433a;

        c(OMarkdownView r1) {
            this.f35433a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f35433a.requestNextMeasure();
        }
    }

    public OMarkdownView(Context r31, AttributeSet r32) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r31, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r32, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        super(r1, r3);
        this.actionModeCallback = new OMarkdownActionModeCallback((OMarkdownActionModeCallback.a) ZeusTransformUtils.preCheckCast(this, OMarkdownActionModeCallback.a.class, "com.obric.aiagent.plugin"));
        this.markdownStyle = new d(r1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, false, 0, 0, 0, 8388606, null);
        com.obric.oui.markdown.c r4 = new com.obric.oui.markdown.c(r1, (com.obric.oui.markdown.c.b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.markdown.c.b.class, "com.obric.aiagent.plugin"));
        this.markdownResourceLoader = r4;
        f r5 = new f(r1, (com.lynx.markdown.b) ZeusTransformUtils.preCheckCast(r4, com.lynx.markdown.b.class, "com.obric.aiagent.plugin"), (f.a) ZeusTransformUtils.preCheckCast(this, f.a.class, "com.obric.aiagent.plugin"), (f.b) ZeusTransformUtils.preCheckCast(this, f.b.class, "com.obric.aiagent.plugin"));
        this.markdownLayout = r5;
        OMarkdownContainerView r6 = new OMarkdownContainerView(r1, (MarkdownView.b) ZeusTransformUtils.preCheckCast(this, MarkdownView.b.class, "com.obric.aiagent.plugin"));
        this.markdownView = r6;
        this.currentMarkdownText = "";
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        r5.a((MarkdownView) ZeusTransformUtils.preCheckCast(r6, MarkdownView.class, "com.obric.aiagent.plugin"));
        setStyle(this.markdownStyle);
        addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
    }

    public /* synthetic */ OMarkdownView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.aiagent.plugin");
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ com.obric.oui.markdown.c access$getMarkdownResourceLoader$p(OMarkdownView r0) {
        return r0.markdownResourceLoader;
    }

    public final a getDelegate() {
        return this.delegate;
    }

    public final void setDelegate(a r3) {
        this.delegate = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = View.MeasureSpec.getMode(r3);
        int r6 = View.MeasureSpec.getSize(r3) - (getPaddingStart() + getPaddingEnd());
        RectF r7 = this.markdownLayout.a(View.MeasureSpec.makeMeasureSpec(r6, r5), 0);
        this.markdownView.setDimension((int) r7.width(), (int) r7.height());
    }

    @Override // com.lynx.markdown.f.b
    public void requestNextMeasure() {
        requestLayout();
    }

    @Override // com.lynx.markdown.MarkdownView.b
    public Drawable getLeftCursorDrawable(Context r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        Drawable r2 = this.leftSelectionCursor;
        o.a(r2);
        return r2;
    }

    @Override // com.lynx.markdown.MarkdownView.b
    public Drawable getRightCursorDrawable(Context r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        Drawable r2 = this.rightSelectionCursor;
        o.a(r2);
        return r2;
    }

    @Override // com.lynx.markdown.f.a
    public void onDrawStart(f r2) {
        o.e(r2, "layout");
        a r1 = this.delegate;
        if (r1 == null) goto L6;
        r1.c();
        return;
    }

    @Override // com.lynx.markdown.f.a
    public void onDrawEnd(f r2) {
        o.e(r2, "layout");
        a r1 = this.delegate;
        if (r1 == null) goto L6;
        r1.b();
        return;
    }

    @Override // com.lynx.markdown.f.a
    public void onAnimationStep(f r2, int r3, int r4, int r5) {
        o.e(r2, "layout");
        a r1 = this.delegate;
        if (r1 == null) goto L6;
        r1.a(r3, r4, r5);
        return;
    }

    @Override // com.lynx.markdown.f.a
    public void onOverflow(f r2, String r3) {
        o.e(r2, "layout");
        o.e(r3, "type");
        a r1 = this.delegate;
        if (r1 == null) goto L6;
        r1.c(r3);
        return;
    }

    @Override // com.lynx.markdown.f.a
    public void onLink(f r1, String r2, String r3) {
        o.e(r2, "link");
        o.e(r3, "content");
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.lynx.markdown.f.a
    public void onSelectionChange(f r4, int r5, int r6, boolean r7) {
        o.e(r4, "layout");
        finishActionMode();
        if (this.enableTextSelection == false) goto L14;
        if (r6 <= r5) goto L15;
        ArrayList<RectF> r8 = this.markdownView.getTextBoundingBoxes(r5, r6);
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.size() <= 0) goto L17;
        OMarkdownActionModeCallback r9 = this.actionModeCallback;
        RectF r10 = r8.get(0);
        RectF r11 = (RectF) ZeusTransformUtils.preCheckCast(r10, RectF.class, "com.obric.aiagent.plugin");
        r11.top -= getScrollY();
        r11.bottom -= getScrollY();
        if (r11.top >= 0) goto L12;
        r11.top = 0.0f;
        r11.bottom = 0.0f;
    L12:
        x r12 = x.f38692a;
        o.c(r10, "boxes[0].apply {\n       …      }\n                }");
        r9.setSelectionRect((RectF) ZeusTransformUtils.preCheckCast(r10, RectF.class, "com.obric.aiagent.plugin"));
        this.actionMode = startActionMode((ActionMode.Callback) ZeusTransformUtils.preCheckCast(this.actionModeCallback, ActionMode.Callback.class, "com.obric.aiagent.plugin"), 1);
        return;
    L17:
        return;
    L15:
        return;
    }

    @Override // com.obric.oui.markdown.c.b
    public void onImageLoaded() {
        requestNextMeasure();
    }

    @Override // com.obric.oui.markdown.c.b
    public int imageRadius() {
        float r0 = this.markdownStyle.q();
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        Resources r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin");
        o.c(r4, "context.resources");
        return (int) (r0 * r4.getDisplayMetrics().density);
    }

    @Override // com.obric.oui.markdown.c.b
    public int imageTextSpaceTop() {
        float r0 = this.markdownStyle.r();
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        Resources r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin");
        o.c(r4, "context.resources");
        return (int) (r0 * r4.getDisplayMetrics().density);
    }

    @Override // com.obric.oui.markdown.c.b
    public int imageTextSpaceBottom() {
        float r0 = this.markdownStyle.s();
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        Resources r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin");
        o.c(r4, "context.resources");
        return (int) (r0 * r4.getDisplayMetrics().density);
    }

    @Override // com.obric.oui.markdown.c.b
    public boolean useCustomImageLoader() {
        a r0 = this.delegate;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.obric.oui.markdown.c.b
    public void loadImage(String r10) {
        o.e(r10, "url");
        a r0 = this.delegate;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L9:
        if (aa.f38393b == false) goto L14;
        if (r1 == true) goto L14;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new AssertionError("Assertion failed"), Throwable.class, "com.obric.aiagent.plugin"));
    L14:
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    L5:
        if (r0.a() != true) goto L7;
        goto L7
    }

    @Override // com.obric.oui.markdown.OMarkdownActionModeCallback.a
    public void onCopy() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("clipboard");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager r1 = (ClipboardManager) ZeusTransformUtils.preCheckCast(r0, ClipboardManager.class, "com.obric.aiagent.plugin");
        String r2 = this.markdownView.getSelectedText();
        r1.setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast("Markdown Copied Text", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")));
        finishActionMode();
    }

    @Override // com.obric.oui.markdown.OMarkdownActionModeCallback.a
    public void onSelectAll() {
        OMarkdownContainerView r0 = this.markdownView;
        r0.setTextSelection(0.0f, 0.0f, r0.getWidth(), this.markdownView.getHeight());
    }

    public final void setMarkdownContent(String r3) {
        o.e(r3, "content");
        if (o.a(r3, this.currentMarkdownText) == false) goto L5;
        return;
    L5:
        this.currentMarkdownText = r3;
        this.markdownLayout.a(r3);
        if (getMeasuredHeight() <= 0) goto L8;
        return;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L15;
        postOnAnimation((Runnable) ZeusTransformUtils.preCheckCast(new c(this), Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final void setStyle(d r2) {
        o.e(r2, "style");
        this.markdownStyle = r2;
        setMarkdownStyle(r2.a());
        if (this.markdownStyle.n() == false) goto L5;
        setMarkdownAnimationType("typewriter");
        setMarkdownAnimationVelocity(this.markdownStyle.o());
        setTypewriterAutoHeight(this.markdownStyle.p());
        return;
    L5:
        setMarkdownAnimationType(OProtocolTextEffectTextView.EffectNameNone);
    }

    public final void setMarkdownStyle(HashMap<?, ?> r1) {
        this.markdownLayout.a(r1);
    }

    public final void setMarkdownAnimationType(String r1) {
        this.markdownLayout.b(r1);
    }

    public final void setMarkdownAnimationVelocity(float r1) {
        this.markdownLayout.a(r1);
    }

    public final void setContentComplete(boolean r1) {
        this.markdownLayout.a(r1);
    }

    public final void setTypewriterAutoHeight(boolean r1) {
        this.markdownLayout.b(r1);
    }

    public final void enableTextSelection(boolean r5) {
        this.enableTextSelection = r5;
        this.markdownView.setEnableTextSelection(r5);
        if (this.enableTextSelection == false) goto L6;
        this.leftSelectionCursor = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_markdown_selection_handle_left, "drawable", "o_markdown_selection_handle_left"));
        this.rightSelectionCursor = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_markdown_selection_handle_right, "drawable", "o_markdown_selection_handle_right"));
        return;
    }

    public final void setInitialAnimationStep(int r1) {
        this.markdownLayout.a(r1);
    }

    public final int getContentWidth() {
        return this.markdownView.getMeasuredWidth();
    }

    public final int getContentHeight() {
        return this.markdownView.getMeasuredHeight();
    }

    public final String getMarkdownText() {
        return this.currentMarkdownText;
    }

    public final String getParsedContent() {
        String r1 = this.markdownView.getParsedContent();
        o.c(r1, "markdownView.parsedContent");
        return r1;
    }

    public final int getMaxStep() {
        return this.markdownView.getMaxStep();
    }

    private final void finishActionMode() {
        if (isActionModeValid() == false) goto L6;
        ActionMode r0 = this.actionMode;
        o.a(r0);
        r0.finish();
        this.actionMode = (ActionMode) ZeusTransformUtils.preCheckCast(null, ActionMode.class, "com.obric.aiagent.plugin");
        return;
    }

    private final boolean isActionModeValid() {
        if (this.actionMode == null) goto L5;
        return true;
    L5:
        return false;
    }
}
