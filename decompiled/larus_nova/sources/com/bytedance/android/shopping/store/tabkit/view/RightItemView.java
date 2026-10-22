package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.tabkit.e;
import com.bytedance.android.shopping.store.tabkit.model.f;
import com.bytedance.android.shopping.store.tabkit.model.g;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getECDraweeView", "Landroid/widget/TextView;", "getTextView", "Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;", "c", "Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;", "getOnItemClickListener", "()Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;", "setOnItemClickListener", "(Lcom/bytedance/android/shopping/store/tabkit/view/RightItemView$a;)V", "onItemClickListener", "Landroid/util/AttributeSet;", "d", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RightItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<f> f186876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<View> f186877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f186878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AttributeSet f186879d;

    public interface a {
        void a(View r100, f r101);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f186880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RightItemView f186881b;

        public b(f r100, int r101, RightItemView r102) {
            this.f186880a = r100;
            this.f186881b = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f186881b.getOnItemClickListener();
            if (r101 == null) goto L6;
            r101.a(r100, this.f186880a);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f186882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RightItemView f186883b;

        public c(f r100, int r101, RightItemView r102) {
            this.f186882a = r100;
            this.f186883b = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a r101 = this.f186883b.getOnItemClickListener();
            if (r101 == null) goto L6;
            r101.a(r100, this.f186882a);
            return;
        }
    }

    public RightItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RightItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ECDraweeView getECDraweeView() {
        Iterator<T> r100 = this.f186877b.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if ((((View) r101) instanceof ECDraweeView) == false) goto L4;
    L9:
        View r102 = (View) r101;
        if (r102 != null) goto L12;
        ECDraweeView r103 = new ECDraweeView(getContext(), null, 0, 6, null);
        r103.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.android.shopping.extensions.b.b(24), com.bytedance.android.shopping.extensions.b.b(24)));
        Object r104 = r103;
    L14:
        return (ECDraweeView) r104;
    L12:
        this.f186877b.remove(r102);
        r104 = r102;
        goto L14
    L8:
        r101 = null;
        goto L9
    }

    private final TextView getTextView() {
        Iterator<T> r100 = this.f186877b.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if ((((View) r101) instanceof TextView) == false) goto L4;
    L9:
        KeyEvent.Callback r102 = (View) r101;
        if (r102 != null) goto L12;
        r102 = new TextView(getContext());
    L14:
        return (TextView) r102;
    L12:
        this.f186877b.remove(r102);
        goto L14
    L8:
        r101 = null;
        goto L9
    }

    public final AttributeSet getAttrs() {
        return this.f186879d;
    }

    public final a getOnItemClickListener() {
        return this.f186878c;
    }

    public final void setOnItemClickListener(a r100) {
        this.f186878c = r100;
    }

    public final void a(List<f> r100, g r101) {
        this.f186876a.clear();
        if (r100 == null) goto L5;
        this.f186876a.addAll(r100);
    L5:
        this.f186877b.addAll(com.bytedance.commerce.base.view.b.a(this));
        removeAllViews();
        int r102 = 0;
        if (r101 == null) goto L10;
        Integer r103 = r101.f();
        if (r103 == null) goto L10;
        int r104 = com.bytedance.android.shopping.extensions.b.b(r103);
    L11:
        com.bytedance.android.shopping.extensions.f.d(this, r104, 2);
        Iterator<f> r105 = this.f186876a.iterator();
    L13:
        if (r105.hasNext() == false) goto L45;
        f r106 = r105.next();
        int r107 = r102 + 1;
        if (r102 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        f r108 = r106;
        if (r108.c() == null) goto L21;
        ECDraweeView r109 = getECDraweeView();
        e.d(r101, r109);
        h0 r110 = h0.f44678a;
        e.g(r109, r108.c());
        r109.setOnClickListener(new b(r108, r102, this));
        Unit r111 = Unit.INSTANCE;
        addView(r109);
    L44:
        r102 = r107;
        goto L13
    L21:
        if (r108.e() == null) goto L44;
        TextView r112 = getTextView();
        if (r101 == null) goto L27;
        Integer r113 = r101.a();
        if (r113 == null) goto L27;
        ViewExtensionsKt.h(r112, r113.intValue());
    L27:
        r112.setText(r108.e());
        if (r101 == null) goto L32;
        Integer r114 = r101.b();
        if (r114 == null) goto L32;
        int r115 = r114.intValue();
    L33:
        com.bytedance.android.shopping.extensions.f.e(r112, Integer.valueOf(r115));
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L41
        if (r101 == null) goto L38;
        String r117 = r101.g();     // Catch: Throwable -> L41
        if (r117 == null) goto L38;
    L39:
        r112.setTextColor(Color.parseColor(r117));     // Catch: Throwable -> L41
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        r112.setOnClickListener(new c(r108, r102, this));
        Unit r118 = Unit.INSTANCE;
        addView(r112);
    L38:
        r117 = "#FFFFFFFF";
    L41:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L32:
        r115 = 400;
        goto L33
    L45:
        return;
    L10:
        r104 = 0;
        goto L11
    }

    public RightItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f186879d = r101;
        this.f186876a = new ArrayList();
        this.f186877b = new ArrayList();
    }

    public /* synthetic */ RightItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
