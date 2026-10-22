package bi2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryItemDecoration;
import com.bytedance.android.livesdk.livecommerce.iron.category.CategoryNoBorderItemDecoration;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19090a = null;

    /* JADX INFO: renamed from: bi2.a$a, reason: collision with other inner class name */
    public static final class C0306a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19094d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C0306a) == false) goto L14;
            C0306a r101 = (C0306a) r100;
            if (this.f19091a == r101.f19091a) goto L8;
            return false;
        L8:
            if (this.f19092b == r101.f19092b) goto L10;
            return false;
        L10:
            if (this.f19093c == r101.f19093c) goto L12;
            return false;
        L12:
            if (this.f19094d == r101.f19094d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f19091a * 31) + this.f19092b) * 31) + this.f19093c) * 31) + this.f19094d;
        }

        public final String toString() {
            return "ItemPadding(left=" + this.f19091a + ", top=" + this.f19092b + ", right=" + this.f19093c + ", bottom=" + this.f19094d + ")";
        }

        public C0306a(int r100, int r101) {
            this.f19091a = r100;
            this.f19092b = 0;
            this.f19093c = r101;
            this.f19094d = 0;
        }
    }

    public a() {
    }

    public static int a(int r100, boolean r101, boolean r102) {
        if (r101 == true) goto L9;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L20;
        if (r100 == 3) goto L8;
        return R.drawable.shopping_bg_top_category_disabled_view;
    L8:
        return R.drawable.shopping_bg_top_category_round_rect_disabled_view;
    L20:
        return R.drawable.ec_bg_transparent;
    L9:
        if (r102 == false) goto L15;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L20;
        if (r100 == 3) goto L14;
        return R.drawable.shopping_bg_top_category_selected_view;
    L14:
        return R.drawable.shopping_bg_top_category_round_rect_selected_view;
    L15:
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L20;
        if (r100 == 3) goto L19;
        return R.drawable.shopping_bg_top_category_unselected_view;
    L19:
        return R.drawable.shopping_bg_top_category_round_rect_unselected_view;
    }

    static {
        f19090a = new a();
    }

    public static Drawable c(String r100, int r101) {
        GradientDrawable r102 = new GradientDrawable();
        Integer r103 = s.b(r100);
        if (r103 == null) goto L5;
        r102.setColor(r103.intValue());
    L5:
        r102.setCornerRadius(UtilityKotlinExtentionsKt.c(Integer.valueOf(r101)));
        return r102;
    }

    public static RecyclerView.ItemDecoration b(int r210, boolean r211, boolean r212, int r213, int r214) {
        if (r210 == 2) goto L19;
        if (r210 == 3) goto L11;
        if (r210 == 4) goto L21;
        return new CategoryItemDecoration(r213, r214, null, null, null, null, null, null, 252);
    L21:
        return new CategoryNoBorderItemDecoration((int) 10.0f);
    L11:
        if (r211 == false) goto L14;
        CategoryItemDecoration r110 = new CategoryItemDecoration(r213, UtilityKotlinExtentionsKt.d(8), null, null, Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(0.0f))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(12.0f))), 0, Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(8.0f))), 12);
    L22:
        return r110;
    L14:
        if (r211 == true) goto L23;
        if (r212 == false) goto L23;
        r110 = new CategoryItemDecoration(r213, UtilityKotlinExtentionsKt.d(8), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(0.0f))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(50.0f))), null, null, null, null, 240);
    L23:
        return new CategoryItemDecoration(r213, UtilityKotlinExtentionsKt.d(8), null, null, null, null, null, null, 252);
    L19:
        return new CategoryNoBorderItemDecoration(2);
    }
}
