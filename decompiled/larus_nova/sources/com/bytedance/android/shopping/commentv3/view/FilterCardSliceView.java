package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/FilterCardSliceView;", "Lcom/bytedance/android/shopping/commentv3/view/CommentSliceView;", "Lcom/bytedance/android/shopping/commentv3/view/FilterCardSliceView$a;", "params", "", "setConfigParams", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterCardSliceView extends CommentSliceView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f172956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f172957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f172958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f172959j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f172960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function2<? super Boolean, ? super Integer, Unit> f172961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function0<Boolean> f172962c;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f172960a == r101.f172960a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f172961b, r101.f172961b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f172962c, r101.f172962c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f172960a * 31;
            Function2<? super Boolean, ? super Integer, Unit> r101 = this.f172961b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            Function0<Boolean> r105 = this.f172962c;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "ConfigParams(foldHeight=" + this.f172960a + ", foldParamsCallback=" + this.f172961b + ", foldStatusHooker=" + this.f172962c + ")";
        }

        public a(Object r100) {
            this.f172960a = com.bytedance.android.shopping.extensions.b.b(124);
            this.f172961b = null;
            this.f172962c = null;
        }
    }

    public FilterCardSliceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FilterCardSliceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setConfigParams(a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f172957h = false;
        this.f172958i = 0;
        this.f172956g = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        boolean r102 = true;
        boolean r103 = false;
        if (getMeasuredHeight() <= this.f172958i) goto L5;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L20;
        this.f172957h = true;
        this.f172958i = getMeasuredHeight();
        if (Math.abs(getMeasuredHeight() - this.f172956g.f172960a) > this.f172959j) goto L16;
    L14:
        r102 = false;
    L17:
        Function2<? super Boolean, ? super Integer, Unit> r105 = this.f172956g.f172961b;
        if (r105 == null) goto L20;
        Unit r106 = r105.invoke(Boolean.valueOf(r102), Integer.valueOf(getMeasuredHeight()));
        goto L20
    L16:
        if (getMeasuredHeight() <= this.f172956g.f172960a) goto L14;
    L20:
        Function0<Boolean> r107 = this.f172956g.f172962c;
        if (r107 == null) goto L25;
        Boolean r108 = r107.invoke();
        if (r108 == null) goto L25;
        r103 = r108.booleanValue();
    L25:
        if (r103 == true) goto L27;
        return;
    L27:
        if (getMeasuredHeight() <= (this.f172956g.f172960a + this.f172959j)) goto L31;
        setMeasuredDimension(getMeasuredWidth(), this.f172956g.f172960a);
        return;
    L31:
        return;
    L5:
        if (getMeasuredHeight() > 0) goto L7;
    L9:
        r104 = false;
        goto L11
    L7:
        if (this.f172957h == true) goto L9;
        goto L9
    }

    public FilterCardSliceView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f172956g = new a(null);
        this.f172959j = 5;
    }

    public /* synthetic */ FilterCardSliceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
