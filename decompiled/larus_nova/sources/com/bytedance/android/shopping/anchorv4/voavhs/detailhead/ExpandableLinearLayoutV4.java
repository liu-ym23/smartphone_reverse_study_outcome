package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.utils.LargeFontModeUtil;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u001e\u001f !B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0007\u001a\u00020\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "", "orientation", "", "setOrientation", "getMaxItemCount", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;", ce.f26391f, "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;", "getStateChangeListener", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;", "setStateChangeListener", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$c;)V", "stateChangeListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;", "onBottomViewAttachListener", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;", "getOnBottomViewAttachListener", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;", "setOnBottomViewAttachListener", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/ExpandableLinearLayoutV4$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExpandableLinearLayoutV4 extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f168202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f168203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f168204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f168205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f168206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f168207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f168208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f168209h;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        void a(d r100);
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f168210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f168211b;

        public static final class a extends d {
            public a() {
                super(R.string.expand, R.drawable.ec_commerce_ic_arrow_down);
            }
        }

        public static final class b extends d {
            public b() {
                super(R.string.collapsed, R.drawable.ec_commerce_ic_arrow_up);
            }
        }

        public static final class c extends d {
            public c() {
                super(R.string.more_params, R.drawable.ec_shop_card_enter_shop_arrow);
            }
        }

        public d(int r100, int r101) {
            this.f168210a = r100;
            this.f168211b = r101;
        }
    }

    static {
    }

    public ExpandableLinearLayoutV4(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ExpandableLinearLayoutV4(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final b getOnBottomViewAttachListener() {
        return null;
    }

    public final void setOnBottomViewAttachListener(b r100) {
    }

    public final void b() {
        List<View> r100 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        TextView r103 = (TextView) ((View) r102.next()).findViewById(R.id.tv_title);
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r105 = r101.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        r104.add(Integer.valueOf(((TextView) r105.next()).getMeasuredWidth()));
        goto L10
    L12:
        Integer r106 = (Integer) CollectionsKt.maxOrNull(r104);
        if (r106 == null) goto L18;
        int r107 = r106.intValue();
        Iterator r108 = r101.iterator();
    L16:
        if (r108.hasNext() == false) goto L18;
        TextView r109 = (TextView) r108.next();
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        r110.width = r107;
        Unit r111 = Unit.INSTANCE;
        r109.setLayoutParams(r110);
    L18:
        int r112 = getChildCount() - 1;
        int r113 = this.f168202a;
    L19:
        if (r113 >= r112) goto L21;
        getChildAt(r113).setVisibility(8);
        r113 = r113 + 1;
        goto L19
    }

    public final int getMaxItemCount() {
        return this.f168202a;
    }

    public final c getStateChangeListener() {
        return this.f168208g;
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (this.f168203b == true) goto L5;
        addView(r100);
    L6:
        int r101 = getChildCount();
        int r102 = this.f168202a;
        if (r101 > r102) goto L9;
        return;
    L9:
        if ((r101 - r102) != 1) goto L16;
        if (r101 > r102) goto L12;
        return;
    L12:
        if (this.f168203b == true) goto L18;
        addView(c(this.f168209h));
        this.f168203b = true;
        return;
    L18:
        return;
    L16:
        return;
    L5:
        addView(r100, getChildCount() - 1);
        goto L6
    }

    public final View c(boolean r100) {
        View r101 = this.f168204c;
        if (r101 == null) goto L5;
        return r101;
    L5:
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.ec_commerce_anchor_v3_expandable_bottom_layout_v4c, this, false);
        this.f168204c = r102;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L8;
        TextView r104 = (TextView) r102.findViewById(R.id.tv_title_v4);
    L9:
        this.f168205d = r104;
        View r105 = this.f168204c;
        if (r105 == null) goto L12;
        ImageView r106 = (ImageView) r105.findViewById(R.id.iv_arrow_v4);
    L13:
        this.f168206e = r106;
        View r107 = this.f168204c;
        if (r107 == null) goto L16;
        r107.setOnClickListener(this);
    L16:
        View r108 = this.f168204c;
        if (r108 == null) goto L23;
        if (ViewCompat.isAttachedToWindow(r108) == false) goto L21;
        getOnBottomViewAttachListener();
        goto L23
    L21:
        r108.addOnAttachStateChangeListener(new s(r108, this));
    L23:
        if (r100 == false) goto L40;
        TextView r109 = this.f168205d;
        if (r109 == null) goto L27;
        r109.setTextSize(14.0f);
    L27:
        View r110 = this.f168204c;
        if (r110 == null) goto L36;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r103 = r111;
    L33:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r103;
        if (r112 == null) goto L36;
        r112.topMargin = com.bytedance.android.shopping.extensions.b.b(5);
        r110.setLayoutParams(r112);
    L36:
        ImageView r113 = this.f168206e;
        if (r113 == null) goto L40;
        r113.setImageResource(R.drawable.ec_pdp_detail_opt_arrow);
    L40:
        if (LargeFontModeUtil.a() <= 1.0f) goto L46;
        TextView r114 = this.f168205d;
        if (((Number) LargeFontModeUtil.f187028a.getValue()).floatValue() <= 1.0d) goto L46;
        if (r114 == null) goto L46;
        r114.getTextSize();
        r114.setTextSize(1, (float) (((double) 14.0f) * 1.15d));
    L46:
        return this.f168204c;
    L12:
        r106 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        d r101 = this.f168207f;
        if ((r101 instanceof d.b) == false) goto L9;
        int r102 = getChildCount() - 1;
        int r103 = this.f168202a;
    L5:
        if (r103 >= r102) goto L7;
        getChildAt(r103).setVisibility(8);
        r103 = r103 + 1;
        goto L5
    L7:
        r101 = new d.a();
    L16:
        this.f168207f = r101;
        if ((r101 instanceof d.c) == true) goto L25;
        TextView r104 = this.f168205d;
        if (r104 == null) goto L22;
        r104.setText(r101.f168210a);
    L22:
        ImageView r105 = this.f168206e;
        if (r105 == null) goto L25;
        r105.setImageResource(r101.f168211b);
    L25:
        c r106 = this.f168208g;
        if (r106 == null) goto L33;
        r106.a(this.f168207f);
        return;
    L33:
        return;
    L9:
        if ((r101 instanceof d.a) == false) goto L15;
        int r107 = this.f168202a;
        int r108 = getChildCount();
    L11:
        if (r107 >= r108) goto L13;
        getChildAt(r107).setVisibility(0);
        r107 = r107 + 1;
        goto L11
    L13:
        r101 = new d.b();
        goto L16
    L15:
        if ((r101 instanceof d.c) == true) goto L16;
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

    public final void setStateChangeListener(c r100) {
        this.f168208g = r100;
    }

    public ExpandableLinearLayoutV4(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168207f = new d.c();
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.maxItemCount});
        this.f168202a = r103.getInt(0, 5);
        r103.recycle();
        setOrientation(1);
    }

    public /* synthetic */ ExpandableLinearLayoutV4(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (getChildCount() > this.f168202a) goto L5;
        return;
    L5:
        if (this.f168203b == true) goto L9;
        addView(c(this.f168209h));
        this.f168203b = true;
        return;
    }
}
