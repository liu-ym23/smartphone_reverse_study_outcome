package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECControllerViewGroup;", "Landroid/widget/LinearLayout;", "", "Lcom/bytedance/android/window/shop/innerflow/widget/ControllerType;", "getChildControllers", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECControllerViewGroup extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f189198a = 0;

    public static final class a {
    }

    public static final class b extends AppCompatImageView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ControllerState f189199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<ControllerState, Integer> f189200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ControllerType f189201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<Boolean> f189202d;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f189203a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function1 f189204b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function1 f189205c;

            public a(b r100, Function1 r101, Function1 r102) {
                this.f189203a = r100;
                this.f189204b = r101;
                this.f189205c = r102;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                int r101 = rp.a.f538829a;
                if (rp.a.a(this.f189203a.getId()) == false) goto L6;
                return;
            L6:
                if (this.f189203a.f189202d.invoke().booleanValue() == true) goto L8;
                return;
            L8:
                b r102 = this.f189203a;
                ControllerState r103 = (ControllerState) this.f189204b.invoke(r102.f189199a);
                Intrinsics.checkNotNullParameter(r103, "state");
                r102.f189199a = r103;
                Integer r104 = r102.f189200b.get(r103);
                if (r104 == null) goto L11;
                r102.setImageResource(r104.intValue());
            L11:
                this.f189205c.invoke(this.f189203a.f189199a);
            }
        }

        public b(Context r100, ControllerState r101, Function1<? super ControllerState, ? extends ControllerState> r102, Function1<? super ControllerState, Unit> r103, Map<ControllerState, Integer> r104, ControllerType r105, Function0<Boolean> r106) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "initState");
            Intrinsics.checkNotNullParameter(r102, "stateTransformer");
            Intrinsics.checkNotNullParameter(r103, "stateChangedCallback");
            Intrinsics.checkNotNullParameter(r104, "statedResIds");
            Intrinsics.checkNotNullParameter(r105, "controllerType");
            Intrinsics.checkNotNullParameter(r106, "canClick");
            super(r100);
            this.f189200b = r104;
            this.f189201c = r105;
            this.f189202d = r106;
            this.f189199a = r101;
            setOnClickListener(new a(this, r102, r103));
        }
    }

    static {
        f189198a = com.bytedance.android.shopping.extensions.b.b(24);
    }

    private final List<ControllerType> getChildControllers() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = com.bytedance.commerce.base.view.b.a(this).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        View r102 = (View) r101.next();
        if ((r102 instanceof b) == true) goto L8;
        r102 = null;
    L8:
        b r103 = (b) r102;
        if (r103 == null) goto L4;
        ControllerType r104 = r103.f189201c;
        if (r104 == null) goto L4;
        r100.add(r104);
        goto L4
    L13:
        return r100;
    }

    public final boolean b(List<? extends ControllerType> r100) {
        Intrinsics.checkNotNullParameter(r100, "controllerTypes");
        return Intrinsics.areEqual(CollectionsKt.sorted(r100), CollectionsKt.sorted(getChildControllers()));
    }

    public ECControllerViewGroup(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
    }

    public final void c(ControllerType r100, ControllerState r101) {
        Intrinsics.checkNotNullParameter(r100, "controllerType");
        Intrinsics.checkNotNullParameter(r101, "state");
        Iterator<T> r102 = com.bytedance.commerce.base.view.b.a(this).iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        View r103 = (View) r102.next();
        ControllerType r104 = null;
        if ((r103 instanceof b) == true) goto L8;
        View r105 = null;
    L9:
        b r106 = (b) r105;
        if (r106 == null) goto L12;
        r104 = r106.f189201c;
    L12:
        if (r104 != r100) goto L4;
        b r107 = (b) r103;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r101, "state");
        r107.f189199a = r101;
        Integer r108 = r107.f189200b.get(r101);
        if (r108 == null) goto L4;
        r107.setImageResource(r108.intValue());
        goto L4
    L8:
        r105 = r103;
        goto L9
    }

    public final void a(ControllerType r110, Map<ControllerState, Integer> r111, ControllerState r112, Function1<? super ControllerState, ? extends ControllerState> r113, Function1<? super ControllerState, Unit> r114, Function0<Boolean> r115) {
        Intrinsics.checkNotNullParameter(r110, "controllerType");
        Intrinsics.checkNotNullParameter(r111, "statedResIds");
        Intrinsics.checkNotNullParameter(r112, "initState");
        Intrinsics.checkNotNullParameter(r113, "stateTransformer");
        Intrinsics.checkNotNullParameter(r114, "stateChangedCallback");
        Intrinsics.checkNotNullParameter(r115, "canClick");
        b r100 = new b(getContext(), r112, r113, r114, r111, r110, r115);
        int r116 = com.bytedance.android.shopping.extensions.b.b(4);
        r100.setPadding(r116, r116, r116, r116);
        Integer r117 = r111.get(r112);
        if (r117 == null) goto L6;
        r100.setImageResource(r117.intValue());
    L6:
        if (getChildCount() <= 0) goto L8;
        ImageView r118 = new ImageView(getContext());
        r118.setImageResource(R.drawable.ec_shop_ic_separater);
        Unit r119 = Unit.INSTANCE;
        LinearLayout.LayoutParams r120 = generateDefaultLayoutParams();
        r120.width = com.bytedance.android.shopping.extensions.b.b(1);
        r120.height = com.bytedance.android.shopping.extensions.b.b(12);
        r120.setMargins(com.bytedance.android.shopping.extensions.b.b(4), 0, com.bytedance.android.shopping.extensions.b.b(4), 0);
        addView(r118, r120);
    L8:
        LinearLayout.LayoutParams r121 = generateDefaultLayoutParams();
        int r122 = f189198a;
        r121.width = r122;
        r121.height = r122;
        Unit r123 = Unit.INSTANCE;
        addView(r100, r121);
    }
}
