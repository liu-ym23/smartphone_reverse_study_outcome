package com.bytedance.android.shopping.anchorv3.detail.widget.expandable;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "", "orientation", "", "setOrientation", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$b;", "stateChangeListener", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$b;", "getStateChangeListener", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$b;", "setStateChangeListener", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$b;)V", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$a;", "onBottomViewAttachListener", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$a;", "getOnBottomViewAttachListener", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$a;", "setOnBottomViewAttachListener", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/expandable/ExpandableLinearLayout$a;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpandableLinearLayout extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f164915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f164916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f164917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f164918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f164919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f164920f;

    public interface a {
    }

    public interface b {
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f164921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f164922b;

        public static final class a extends c {
            public a() {
                super(R.string.expand, R.drawable.ic_arrow_down);
            }
        }

        public static final class b extends c {
            public b() {
                super(R.string.collapsed, R.drawable.ic_arrow_up);
            }
        }

        public c(int r100, int r101) {
            this.f164921a = r100;
            this.f164922b = r101;
        }
    }

    public ExpandableLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ExpandableLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final a getOnBottomViewAttachListener() {
        return null;
    }

    public final b getStateChangeListener() {
        return null;
    }

    public final void setOnBottomViewAttachListener(a r100) {
    }

    public final void setStateChangeListener(b r100) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ec_commerce_anchor_v3_expandable_bottom_layout, this, false);
        this.f164917c = r100;
        ImageView r101 = null;
        if (r100 == null) goto L5;
        TextView r102 = (TextView) r100.findViewById(R.id.tv_title);
    L6:
        this.f164918d = r102;
        View r103 = this.f164917c;
        if (r103 == null) goto L9;
        r101 = (ImageView) r103.findViewById(R.id.iv_arrow);
    L9:
        this.f164919e = r101;
        View r104 = this.f164917c;
        if (r104 == null) goto L12;
        r104.setOnClickListener(this);
    L12:
        View r105 = this.f164917c;
        if (r105 != null) goto L15;
        return;
    L15:
        if (ViewCompat.isAttachedToWindow(r105) == false) goto L17;
        getOnBottomViewAttachListener();
        return;
    L17:
        r105.addOnAttachStateChangeListener(new e63.a(r105, this));
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c r101 = this.f164920f;
        if ((r101 instanceof c.b) == false) goto L9;
        int r102 = getChildCount() - 1;
        int r103 = this.f164915a;
    L5:
        if (r103 >= r102) goto L7;
        getChildAt(r103).setVisibility(8);
        r103 = r103 + 1;
        goto L5
    L7:
        c r104 = new c.a();
    L14:
        this.f164920f = r104;
        TextView r105 = this.f164918d;
        if (r105 == null) goto L17;
        r105.setText(r104.f164921a);
    L17:
        ImageView r106 = this.f164919e;
        if (r106 == null) goto L25;
        r106.setImageResource(r104.f164922b);
        return;
    L25:
        return;
    L9:
        if ((r101 instanceof c.a) == false) goto L22;
        int r107 = this.f164915a;
        int r108 = getChildCount();
    L11:
        if (r107 >= r108) goto L13;
        getChildAt(r107).setVisibility(0);
        r107 = r107 + 1;
        goto L11
    L13:
        r104 = new c.b();
        goto L14
    L22:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r100) {
        if (r100 == 0) goto L6;
        super.setOrientation(r100);
        return;
    L6:
        throw new IllegalStateException("ExpandableLinearLayout only supports vertical orientation ");
    }

    public ExpandableLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f164920f = new c.a();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxItemCount});
        this.f164915a = r103.getInt(0, 5);
        r103.recycle();
        setOrientation(1);
    }

    public /* synthetic */ ExpandableLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (getChildCount() > this.f164915a) goto L5;
        return;
    L5:
        if (this.f164916b == true) goto L13;
        addView(this.f164917c);
        int r104 = getChildCount() - 1;
        int r105 = this.f164915a;
    L7:
        if (r105 >= r104) goto L9;
        getChildAt(r105).setVisibility(8);
        r105 = r105 + 1;
        goto L7
    L9:
        this.f164916b = true;
        return;
    }
}
