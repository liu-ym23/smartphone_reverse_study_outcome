package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\b\tB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/widget/SortBarView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SortBarView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f189863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f189864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f189865c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f189866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function3<Long, Boolean, String, Unit> f189867b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, Function3<? super Long, ? super Boolean, ? super String, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "func");
            this.f189866a = r100;
            this.f189867b = r101;
        }
    }

    public final class b extends LinearLayout {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f189868g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f189869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f189870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f189871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f189872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f189873e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ SortBarView f189874f;

        public final void a(boolean r100, boolean r101) {
            if (r100 == true) goto L8;
            this.f189869a.setTypeface(Typeface.DEFAULT);
            this.f189869a.setTextColor(this.f189874f.f189865c);
            this.f189871c = false;
            com.bytedance.android.shopping.extensions.f.e(this.f189869a, 400);
            k r102 = this.f189870b;
            if (r102 == null) goto L37;
            r102.b(r102.getAscending(), true);
            return;
        L37:
            return;
        L8:
            com.bytedance.android.shopping.extensions.f.e(this.f189869a, 400);
            this.f189869a.setTextColor(this.f189874f.f189864b);
            if (this.f189871c == false) goto L18;
            k r103 = this.f189870b;
            if (r103 == null) goto L32;
            r103.b(true ^ r103.f190054c, false);
            if (r101 == false) goto L32;
            Iterator<T> r104 = this.f189874f.f189863a.iterator();
        L16:
            if (r104.hasNext() == false) goto L32;
            ((a) r104.next()).f189867b.invoke(Long.valueOf(this.f189872d), Boolean.valueOf(r103.getAscending()), this.f189873e);
        L32:
            this.f189871c = r100;
            return;
        L18:
            k r105 = this.f189870b;
            if (r105 == null) goto L27;
            if (r105 == null) goto L32;
            r105.b(r105.getAscending(), false);
            if (r101 == false) goto L32;
            Iterator<T> r106 = this.f189874f.f189863a.iterator();
        L25:
            if (r106.hasNext() == false) goto L32;
            ((a) r106.next()).f189867b.invoke(Long.valueOf(this.f189872d), Boolean.valueOf(r105.getAscending()), this.f189873e);
            goto L25
        L27:
            if (r101 == false) goto L32;
            Iterator<T> r107 = this.f189874f.f189863a.iterator();
        L30:
            if (r107.hasNext() == false) goto L32;
            ((a) r107.next()).f189867b.invoke(Long.valueOf(this.f189872d), null, this.f189873e);
            goto L30
        }

        public b(SortBarView r100, long r101, String r102, boolean r103, boolean r104, Context r110) {
            Intrinsics.checkNotNullParameter(r102, "title");
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f189874f = r100;
            super(r110);
            this.f189872d = r101;
            this.f189873e = r102;
            setGravity(17);
            ViewGroup.LayoutParams r105 = new LinearLayout.LayoutParams(-2, -1);
            setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(3), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(3));
            Unit r106 = Unit.INSTANCE;
            setLayoutParams(r105);
            setOrientation(0);
            TextView r107 = new TextView(r110);
            r107.setText(r102);
            r107.setTextSize(1, 14.0f);
            this.f189869a = r107;
            addView(r107, new LinearLayout.LayoutParams(-2, -2));
            if (r103 == false) goto L6;
            k r108 = new k(r104, r110);
            this.f189870b = r108;
            LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(7), -2);
            r109.setMargins(com.bytedance.android.shopping.extensions.b.b(6), com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d)), 0, 0);
            addView(r108, r109);
            return;
        }
    }

    public SortBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setOrientation(0);
        this.f189863a = new ArrayList();
        this.f189864b = (int) 4294909001L;
        this.f189865c = (int) 2568362019L;
    }

    public final void a(String r100, Function3<? super Long, ? super Boolean, ? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "cb");
        Iterator r102 = ((ArrayList) this.f189863a).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((a) r103).f189866a, r100) == false) goto L4;
    L9:
        a r104 = (a) r103;
        if (r104 == null) goto L12;
        ((ArrayList) this.f189863a).remove(r104);
    L12:
        List<a> r105 = this.f189863a;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new a(r100, r101));
        return;
    L8:
        r103 = null;
        goto L9
    }
}
