package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/ECExpandableTextView;", "Landroid/widget/FrameLayout;", "", "text", "", "setContentText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECExpandableTextView extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f172422n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f172423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f172424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f172425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f172426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f172427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f172428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f172429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f172430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f172431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f172432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f172433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f172434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f172435m;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECExpandableTextView f172436a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ECExpandableTextView r100 = this.f172436a;
            int r101 = ECExpandableTextView.f172422n;
            r100.a();
            this.f172436a.f172423a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public a(ECExpandableTextView r100) {
            this.f172436a = r100;
        }
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECExpandableTextView f172437a;

        public c(ECExpandableTextView r100) {
            this.f172437a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ECExpandableTextView r101 = this.f172437a;
            boolean r102 = false;
            if (r101.f172435m == false) goto L5;
            r101.f172424b.setVisibility(8);
            r101.f172425c.setVisibility(0);
            r101.f172423a.setMaxLines(Integer.MAX_VALUE);
            r101.f172423a.setMaxHeight(r101.f172430h);
            r101.setContentText(r101.f172432j);
            r101.f172423a.post(new com.bytedance.android.shopping.commentfeed.widget.b(r101));
        L6:
            r101.f172435m = r102;
            return;
        L5:
            r101.f172424b.setVisibility(0);
            r101.f172425c.setVisibility(8);
            r101.f172423a.setHeight(-2);
            r101.f172423a.setMaxLines(r101.f172426d);
            r101.f172423a.setVerticalScrollBarEnabled(false);
            r101.f172423a.setMovementMethod(null);
            r101.setContentText(r101.f172432j);
            r101.a();
            r102 = true;
            goto L6
        }
    }

    static {
    }

    public ECExpandableTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECExpandableTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f172432j) == false) goto L5;
        return;
    L5:
        if (this.f172426d <= 1) goto L23;
        Layout r100 = this.f172423a.getLayout();
        if (r100 == null) goto L9;
        int r101 = r100.getEllipsisCount(this.f172423a.getLineCount() - 1);
    L11:
        if (r101 <= 0) goto L17;
        this.f172435m = true;
        int r102 = this.f172423a.getLayout().getLineStart(this.f172426d - 1);     // Catch: Exception -> L15
        b(r102, this.f172423a.getLayout().getEllipsisStart(this.f172426d - 1) + r102);     // Catch: Exception -> L15
        this.f172424b.setVisibility(0);     // Catch: Exception -> L15
    L18:
        this.f172425c.setVisibility(8);
        return;
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        this.f172424b.setVisibility(4);
        goto L18
    L17:
        this.f172424b.setVisibility(4);
        goto L18
    L9:
        r101 = 0;
        goto L11
    }

    public final void setContentText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f172423a.setText(r100);
        this.f172432j = r100;
        this.f172435m = false;
    }

    public final void b(int r100, int r101) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (r101 >= this.f172432j.length()) goto L20;
        if (r101 <= r100) goto L21;
        StringBuilder r102 = new StringBuilder();
        String r103 = this.f172432j;
        if (r103 == null) goto L18;
        r102.append(r103.substring(r100, r101));
        r102.append("...");
        if ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.f172423a.getPaint().measureText(r102.toString())) >= this.f172424b.getWidth()) goto L12;
        b(r100, r101 - 1);
        return;
    L12:
        TextView r104 = this.f172423a;
        StringBuilder r105 = new StringBuilder();
        String r106 = this.f172432j;
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

    public ECExpandableTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f172426d = 4;
        this.f172427e = ColorProtector.parseColor("#161623");
        this.f172428f = UIUtils.dip2Px(r100, 15.0f);
        this.f172429g = UIUtils.dip2Px(r100, 12.0f);
        this.f172430h = com.bytedance.android.shopping.extensions.b.b(220);
        this.f172431i = this.f172427e;
        this.f172432j = "";
        this.f172433k = th.a.f(r100).getString(R.string.shopping_tv_expanded);
        this.f172434l = th.a.f(r100).getString(R.string.shopping_tv_collapsed);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ec_expandable_textview_layout, this);
        TextView r104 = (TextView) r103.findViewById(R.id.ec_tv_expand_text_content);
        this.f172423a = r104;
        TextView r105 = (TextView) r103.findViewById(R.id.ec_expand_text_status_btn);
        this.f172424b = r105;
        TextView r106 = (TextView) r103.findViewById(R.id.ec_collapsed_text_status_btn);
        this.f172425c = r106;
        TypedArray r107 = r100.obtainStyledAttributes(r101, new int[]{R.attr.collapsed_content, R.attr.content_maxHeight, R.attr.content_text_maxLine, R.attr.content_textcolor, R.attr.content_textsize, R.attr.enable_big_big_opt, R.attr.expandable_status_textcolor, R.attr.expandable_status_textsize, R.attr.expanded_content});
        this.f172427e = r107.getColor(3, this.f172427e);
        this.f172428f = r107.getDimension(4, this.f172428f);
        this.f172431i = r107.getColor(6, this.f172427e);
        this.f172429g = r107.getDimension(7, this.f172429g);
        String r108 = r107.getString(8);
        if (r108 != null) goto L5;
        r108 = this.f172433k;
    L5:
        this.f172433k = r108;
        String r109 = r107.getString(0);
        if (r109 != null) goto L8;
        r109 = this.f172434l;
    L8:
        this.f172434l = r109;
        this.f172426d = r107.getInt(2, 4);
        this.f172430h = (int) r107.getDimension(1, this.f172430h);
        r107.recycle();
        r104.setTextSize(0, this.f172428f);
        r104.setTextColor(this.f172427e);
        r104.setMaxLines(this.f172426d);
        r105.setTextSize(0, this.f172429g);
        r105.setTextColor(this.f172431i);
        r106.setTextSize(0, this.f172429g);
        r106.setTextColor(this.f172431i);
        r105.setText(this.f172434l);
        r106.setText(this.f172433k);
        r104.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        c r110 = new c(this);
        r105.setOnClickListener(r110);
        r106.setOnClickListener(r110);
    }

    public /* synthetic */ ECExpandableTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
