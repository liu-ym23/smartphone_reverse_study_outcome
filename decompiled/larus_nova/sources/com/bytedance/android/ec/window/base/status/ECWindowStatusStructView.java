package com.bytedance.android.ec.window.base.status;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/window/base/status/ECWindowStatusStructView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECWindowStatusStructView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49687a;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowStatusStructView f49688a;

        public a(ECWindowStatusStructView r100) {
            this.f49688a = r100;
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
            if (this.f49688a.getWidth() <= 0) goto L34;
            ECWindowStatusStructView r100 = this.f49688a;
            if (r100.f49687a == r100.getWidth()) goto L35;
            this.f49688a.removeAllViews();
            ECWindowStatusStructView r101 = this.f49688a;
            int r102 = r101.getWidth();
            com.bytedance.android.ec.window.base.status.b[][] r103 = r101.a();
            boolean r104 = true;
            if (r103 != null) goto L10;
        L16:
            if (r104 == true) goto L28;
            int r105 = r102 / r103.length;
            int r106 = r103.length;
            int r107 = 0;
        L19:
            if (r107 >= r106) goto L28;
            com.bytedance.android.ec.window.base.status.b[] r108 = r103[r107];
            b r109 = new b(r101.getContext());
            r109.setLayoutParams(new LinearLayout.LayoutParams(r105, -1));
            int r110 = r108.length;
            int r111 = 0;
        L21:
            if (r111 >= r110) goto L27;
            com.bytedance.android.ec.window.base.status.b r112 = r108[r111];
            Intrinsics.checkNotNullParameter(r112, "structInfo");
            Intrinsics.checkNotNullParameter(r112, "structInfo");
            ImageView r113 = new ImageView(r109.getContext());
            Drawable r114 = ResourcesCompat.getDrawable(r113.getResources(), r112.getType().getDrawableRes(), null);
            if (r114 == null) goto L26;
            r113.setImageDrawable(r114);
            r113.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.android.ec.window.base.status.a r115 = r112.f49700b;
            int r116 = r115.f49695a + r115.f49697c;
            com.bytedance.android.ec.window.base.status.a r117 = r112.f49701c;
            int r118 = r105 - ((r116 + r117.f49695a) + r117.f49697c);
            LinearLayout.LayoutParams r119 = new LinearLayout.LayoutParams(r118, (r114.getIntrinsicHeight() * r118) / r114.getIntrinsicWidth());
            com.bytedance.android.ec.window.base.status.a r120 = r112.f49701c;
            r119.setMargins(r120.f49695a, r120.f49696b, r120.f49697c, r120.f49698d);
            Unit r121 = Unit.INSTANCE;
            r113.setLayoutParams(r119);
        L26:
            r109.addView(r113);
            r111 = r111 + 1;
            goto L21
        L27:
            Unit r122 = Unit.INSTANCE;
            r101.addView(r109);
            r107 = r107 + 1;
        L28:
            ECWindowStatusStructView r123 = this.f49688a;
            r123.f49687a = r123.getWidth();
            return;
        L10:
            if (r103.length != 0) goto L12;
            boolean r124 = true;
        L13:
            if (r124 == true) goto L16;
            r104 = false;
            goto L16
        L12:
            r124 = false;
            goto L13
        L35:
            return;
        }
    }

    public static final class b extends LinearLayout {
        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            setOrientation(1);
        }
    }

    public abstract com.bytedance.android.ec.window.base.status.b[][] a();

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (getVisibility() != 0) goto L6;
        return true;
    L6:
        return super.onTouchEvent(r100);
    }

    public ECWindowStatusStructView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }
}
