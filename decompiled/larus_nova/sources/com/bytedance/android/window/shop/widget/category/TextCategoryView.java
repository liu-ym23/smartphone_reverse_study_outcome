package com.bytedance.android.window.shop.widget.category;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.shopping.extensions.f;
import com.bytedance.android.window.shop.repository.tab.entity.WindowProductCategoryVODeprecated;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011R\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/widget/category/TextCategoryView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/window/shop/widget/category/a;", "", "c", "Z", "getLastChosen", "()Z", "setLastChosen", "(Z)V", "lastChosen", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$d;", "d", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$d;", "getCategory", "()Lcom/bytedance/android/window/shop/repository/tab/entity/WindowProductCategoryVODeprecated$d;", "category", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextCategoryView extends AppCompatTextView implements com.bytedance.android.window.shop.widget.category.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f189979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f189980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f189981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowProductCategoryVODeprecated.d f189982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3<WindowProductCategoryVODeprecated.a, Integer, Integer, Unit> f189983e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f189984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f189985b;

        public a(float r100, Integer r101) {
            this.f189984a = r100;
            this.f189985b = r101;
        }
    }

    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void u() {
        setTextColor(this.f189979a);
        f.e(this, 500);
    }

    @Override // com.bytedance.android.window.shop.widget.category.a
    public final void w() {
        setTextColor(this.f189980b);
        f.e(this, 400);
    }

    public /* bridge */ /* synthetic */ WindowProductCategoryVODeprecated.a getCategory() {
        return m8292getCategory();
    }

    public boolean getLastChosen() {
        return this.f189981c;
    }

    /* JADX INFO: renamed from: getCategory, reason: collision with other method in class */
    public WindowProductCategoryVODeprecated.d m8292getCategory() {
        return this.f189982d;
    }

    public void setLastChosen(boolean r100) {
        this.f189981c = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextCategoryView(WindowProductCategoryVODeprecated.d r100, Context r101, Function3<? super WindowProductCategoryVODeprecated.a, ? super Integer, ? super Integer, Unit> r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "config");
        super(r101);
        this.f189982d = r100;
        this.f189983e = r102;
        Integer r104 = m8292getCategory().f189518e;
        if (r104 == null) goto L5;
        int r105 = r104.intValue();
    L6:
        this.f189979a = r105;
        Integer r106 = m8292getCategory().f189519f;
        if (r106 == null) goto L9;
        int r107 = r106.intValue();
    L10:
        this.f189980b = r107;
        setGravity(17);
        Resources r108 = r101.getResources();
        Integer r109 = r103.f189985b;
        if (r109 == null) goto L13;
        setBackgroundDrawable(r108.getDrawable(r109.intValue()));
    L13:
        setText(m8292getCategory().f189513b);
        setTextSize(1, r103.f189984a);
        setTypeface(Typeface.defaultFromStyle(1));
        return;
    L9:
        r107 = (int) 2568362019L;
        goto L10
    L5:
        r105 = (int) 4279638051L;
        goto L6
    }
}
