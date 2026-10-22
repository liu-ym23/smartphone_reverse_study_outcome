package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECStructView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "c", "StructType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECStructView extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f189840b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f189841c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f189842d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f189843a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECStructView$StructType;", "", "", "drawableRes", "I", "getDrawableRes", "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "INNER_FLOW_PRODUCT_CARD", "INNER_FLOW_VIDEO_CARD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StructType extends Enum<StructType> {
        public static final StructType A = null;
        public static final StructType B = null;
        public static final StructType C = null;
        public static final StructType D = null;
        public static final StructType E = null;
        public static final StructType INNER_FLOW_PRODUCT_CARD = null;
        public static final StructType INNER_FLOW_VIDEO_CARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StructType[] f189844a = null;
        private final int drawableRes;

        static {
            StructType r100 = new StructType(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, 0, R.drawable.ec_shopping_placeholder_struct_view_svg_double_product);
            A = r100;
            StructType r101 = new StructType("B", 1, R.drawable.ec_shopping_placeholder_struct_view_svg_b);
            B = r101;
            StructType r102 = new StructType("C", 2, R.drawable.ec_shopping_placeholder_struct_view_svg_c);
            C = r102;
            StructType r103 = new StructType("D", 3, R.drawable.ec_shopping_placeholder_struct_view_svg_product_fullspan);
            D = r103;
            StructType r104 = new StructType(ExifInterface.LONGITUDE_EAST, 4, R.drawable.ec_window_coupon_skelton);
            E = r104;
            StructType r105 = new StructType("INNER_FLOW_PRODUCT_CARD", 5, R.drawable.ec_shop_struct_view_inner_flow_product_card_svg);
            INNER_FLOW_PRODUCT_CARD = r105;
            StructType r106 = new StructType("INNER_FLOW_VIDEO_CARD", 6, R.drawable.ec_shop_struct_view_inner_flow_video_card_svg);
            INNER_FLOW_VIDEO_CARD = r106;
            f189844a = new StructType[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static StructType valueOf(String r100) {
            return (StructType) r27.a.a(StructType.class, r100);
        }

        public static StructType[] values() {
            return (StructType[]) f189844a.clone();
        }

        public final int getDrawableRes() {
            return this.drawableRes;
        }

        public StructType(String r100, int r101, int r102) {
            super(r100, r101);
            this.drawableRes = r102;
        }
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECStructView f189845a;

        public a(ECStructView r100) {
            this.f189845a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.f189845a.getWidth() <= 0) goto L38;
            ECStructView r100 = this.f189845a;
            if (r100.f189843a == r100.getWidth()) goto L39;
            this.f189845a.removeAllViews();
            ECStructView r101 = this.f189845a;
            int r102 = r101.getWidth();
            StructType[][] r103 = r101.a();
            boolean r104 = true;
            if (r103 != null) goto L10;
        L16:
            if (r104 == true) goto L32;
            int r105 = r102 / r103.length;
            int r106 = r103.length;
            int r107 = 0;
        L19:
            if (r107 >= r106) goto L32;
            StructType[] r108 = r103[r107];
            c r109 = new c(r101.getContext(), r107, r103.length);
            r109.setLayoutParams(new LinearLayout.LayoutParams(r105, -1));
            int r110 = r108.length;
            int r111 = 0;
        L21:
            if (r111 >= r110) goto L31;
            StructType r112 = r108[r111];
            int r113 = r103.length;
            Intrinsics.checkNotNullParameter(r112, "type");
            Intrinsics.checkNotNullParameter(r112, "type");
            ImageView r114 = new ImageView(r109.getContext());
            Drawable r115 = ResourcesCompat.getDrawable(r114.getResources(), r112.getDrawableRes(), null);
            if (r115 == null) goto L30;
            r114.setImageDrawable(r115);
            if (r113 != 2) goto L28;
            int r116 = r105 - ECStructView.f189840b;
            int r117 = ECStructView.f189841c / 2;
        L29:
            int r118 = r116 - r117;
            LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(r118, (r115.getIntrinsicHeight() * r118) / r115.getIntrinsicWidth());
            r119.setMargins(0, 0, 0, ECStructView.f189842d);
            Unit r120 = Unit.INSTANCE;
            r114.setLayoutParams(r119);
            goto L30
        L28:
            r117 = ECStructView.f189840b * 2;
            r116 = r105;
        L30:
            r109.addView(r114);
            r111 = r111 + 1;
            goto L21
        L31:
            Unit r121 = Unit.INSTANCE;
            r101.addView(r109);
            r107 = r107 + 1;
        L32:
            ECStructView r122 = this.f189845a;
            r122.f189843a = r122.getWidth();
            return;
        L10:
            if (r103.length != 0) goto L12;
            boolean r123 = true;
        L13:
            if (r123 == true) goto L16;
            r104 = false;
            goto L16
        L12:
            r123 = false;
            goto L13
        L39:
            return;
        }
    }

    public static final class b {
    }

    public static final class c extends LinearLayout {
        public c(Context r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            setOrientation(1);
            if (r102 != 1) goto L5;
            int r103 = ECStructView.f189840b;
            setPadding(r103, 0, r103, 0);
            return;
        L5:
            if (r101 != 0) goto L7;
            setPadding(ECStructView.f189840b, 0, ECStructView.f189841c / 2, 0);
            return;
        L7:
            setPadding(ECStructView.f189841c / 2, 0, ECStructView.f189840b, 0);
        }
    }

    public abstract StructType[][] a();

    static {
        f189840b = com.bytedance.android.shopping.extensions.b.b(12);
        f189841c = com.bytedance.android.shopping.extensions.b.b(9);
        f189842d = com.bytedance.android.shopping.extensions.b.b(9);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (getVisibility() != 0) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r100);
    }

    public ECStructView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }
}
