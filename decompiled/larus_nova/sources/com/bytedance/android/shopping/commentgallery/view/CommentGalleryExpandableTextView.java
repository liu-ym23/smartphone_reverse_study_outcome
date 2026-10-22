package com.bytedance.android.shopping.commentgallery.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentgallery/view/CommentGalleryExpandableTextView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", "", "listener", "setExpandBtnClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGalleryExpandableTextView extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f172497p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f172498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f172499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f172500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f172501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f172502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f172503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f172504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f172505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f172506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f172507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f172508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f172509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f172510m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f172511n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<Unit> f172512o;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGalleryExpandableTextView f172513a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            CommentGalleryExpandableTextView r100 = this.f172513a;
            int r101 = CommentGalleryExpandableTextView.f172497p;
            r100.a();
            this.f172513a.f172498a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public a(CommentGalleryExpandableTextView r100) {
            this.f172513a = r100;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentGalleryExpandableTextView f172514a;

        public c(CommentGalleryExpandableTextView r100) {
            this.f172514a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CommentGalleryExpandableTextView r101 = this.f172514a;
            if (r101.f172510m == false) goto L5;
            r101.f172499b.setVisibility(8);
            boolean r102 = false;
            r101.f172500c.setVisibility(0);
            r101.f172498a.setMaxLines(Integer.MAX_VALUE);
            r101.f172498a.setMaxHeight(r101.f172505h);
            r101.f172498a.setText(r101.f172507j);
            r101.f172510m = false;
            r101.f172498a.post(new cc3.a(r101));
        L6:
            r101.f172510m = r102;
            Function0<Unit> r103 = this.f172514a.f172512o;
            if (r103 == null) goto L10;
            Unit r104 = r103.invoke();
            return;
        L10:
            return;
        L5:
            r101.c();
            r102 = true;
            goto L6
        }
    }

    static {
    }

    public CommentGalleryExpandableTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentGalleryExpandableTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f172507j) == false) goto L5;
        return;
    L5:
        if (this.f172501d <= 1) goto L16;
        Layout r100 = this.f172498a.getLayout();
        if (r100 == null) goto L9;
        int r101 = r100.getEllipsisCount(this.f172498a.getLineCount() - 1);
    L10:
        if (r101 <= 0) goto L12;
        this.f172510m = true;
        int r102 = this.f172498a.getLayout().getLineStart(this.f172501d - 1);
        b(r102, this.f172498a.getLayout().getEllipsisStart(this.f172501d - 1) + r102);
        this.f172499b.setVisibility(0);
    L13:
        this.f172500c.setVisibility(8);
        return;
    L12:
        this.f172499b.setVisibility(4);
        goto L13
    L9:
        r101 = 0;
        goto L10
    }

    public final void c() {
        this.f172499b.setVisibility(0);
        this.f172500c.setVisibility(8);
        this.f172498a.setHeight(-2);
        this.f172498a.setMaxLines(this.f172501d);
        this.f172498a.setVerticalScrollBarEnabled(false);
        this.f172498a.setMovementMethod(null);
        this.f172498a.setText(this.f172507j);
        this.f172510m = false;
        a();
    }

    public final void setExpandBtnClickListener(Function0<Unit> r100) {
        this.f172512o = r100;
    }

    public final void b(int r100, int r101) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (r101 >= this.f172507j.length()) goto L20;
        if (r101 <= r100) goto L21;
        StringBuilder r102 = new StringBuilder();
        String r103 = this.f172507j;
        if (r103 == null) goto L18;
        r102.append(r103.substring(r100, r101));
        r102.append("...");
        if ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.f172498a.getPaint().measureText(r102.toString())) >= this.f172499b.getWidth()) goto L12;
        b(r100, r101 - 1);
        return;
    L12:
        TextView r104 = this.f172498a;
        StringBuilder r105 = new StringBuilder();
        String r106 = this.f172507j;
        if (r106 == null) goto L16;
        r105.append(r106.substring(0, r101));
        r105.append("...");
        r104.setText(r105.toString());
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L21:
        return;
    }

    public CommentGalleryExpandableTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f172501d = 4;
        this.f172502e = ColorProtector.parseColor("#161623");
        this.f172503f = UIUtils.dip2Px(r100, 15.0f);
        this.f172504g = UIUtils.dip2Px(r100, 12.0f);
        this.f172505h = com.bytedance.android.shopping.extensions.b.b(220);
        this.f172506i = this.f172502e;
        this.f172507j = "";
        this.f172508k = th.a.f(r100).getString(R.string.shopping_tv_expanded);
        this.f172509l = th.a.f(r100).getString(R.string.shopping_tv_collapsed);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ec_comment_gallery_expandable_textview_layout, this);
        TextView r104 = (TextView) r103.findViewById(R.id.ec_tv_expand_text_content);
        this.f172498a = r104;
        TextView r105 = (TextView) r103.findViewById(R.id.ec_expand_text_status_btn);
        this.f172499b = r105;
        TextView r106 = (TextView) r103.findViewById(R.id.ec_collapsed_text_status_btn);
        this.f172500c = r106;
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.collapsed_content, R.attr.content_maxHeight, R.attr.content_text_maxLine, R.attr.content_textcolor, R.attr.content_textsize, R.attr.enable_big_big_opt, R.attr.expandable_status_textcolor, R.attr.expandable_status_textsize, R.attr.expanded_content});
        this.f172502e = r107.getColor(3, this.f172502e);
        this.f172503f = r107.getDimension(4, this.f172503f);
        this.f172506i = r107.getColor(6, this.f172502e);
        this.f172504g = r107.getDimension(7, this.f172504g);
        String r108 = r107.getString(8);
        if (r108 != null) goto L5;
        r108 = this.f172508k;
    L5:
        this.f172508k = r108;
        String r109 = r107.getString(0);
        if (r109 != null) goto L8;
        r109 = this.f172509l;
    L8:
        this.f172509l = r109;
        this.f172501d = r107.getInt(2, 4);
        this.f172505h = (int) r107.getDimension(1, this.f172505h);
        this.f172511n = r107.getBoolean(5, false);
        r107.recycle();
        r104.setTextSize(0, this.f172503f);
        r104.setTextColor(this.f172502e);
        r104.setMaxLines(this.f172501d);
        r105.setTextSize(0, this.f172504g);
        r105.setTextColor(this.f172506i);
        r106.setTextSize(0, this.f172504g);
        r106.setTextColor(this.f172506i);
        r105.setText(this.f172509l);
        r106.setText(this.f172508k);
        r104.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        if (this.f172511n == false) goto L14;
        int r110 = g1.f45599a;
        r105.setBackgroundColor(g1.a.a(r100, R.color.transparent));
        r106.setBackgroundColor(g1.a.a(r100, R.color.transparent));
        if (Build.VERSION.SDK_INT < 28) goto L13;
        r104.setLineHeight(com.bytedance.android.shopping.extensions.b.b(22));
    L13:
        r105.setPadding(0, 0, 0, 0);
        r106.setPadding(0, 0, 0, 0);
        f.e(r105, 600);
        f.e(r106, 600);
    L14:
        c r111 = new c(this);
        r105.setOnClickListener(r111);
        r106.setOnClickListener(r111);
    }

    public /* synthetic */ CommentGalleryExpandableTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
