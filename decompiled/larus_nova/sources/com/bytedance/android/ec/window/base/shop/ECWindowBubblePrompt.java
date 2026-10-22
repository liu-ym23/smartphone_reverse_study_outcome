package com.bytedance.android.ec.window.base.shop;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.window.base.common.bubble.WindowBubbleShowStrategy;
import com.bytedance.android.ec.window.base.common.bubble.t;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECWindowBubblePrompt extends PopupWindow implements View.OnClickListener, com.bytedance.android.ec.window.base.common.bubble.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f49572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WindowFansClubBubbleConfig f49573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f49574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f49575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f49576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f49577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Activity f49578g;

    @Override // com.bytedance.android.ec.window.base.common.bubble.e
    public final void onShow() {
        a(this.f49577f);
        Function0<Unit> r100 = this.f49576e;
        if (r100 == null) goto L6;
        Unit r101 = r100.invoke();
        return;
    }

    public ECWindowBubblePrompt(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100);
        this.f49578g = r100;
    }

    public final void a(View r100) {
        if (r100 == null) goto L4;
        IBinder r101 = r100.getApplicationWindowToken();
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        int r102 = com.bytedance.android.shopping.extensions.b.b(11);
        OverlaySource r103 = PopupWindowLancet.resolveSource(r100);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r100, r103) == true) goto L11;
        showAsDropDown(r100, 0, r102, GravityCompat.END);
        PopupWindowLancet.trackAfterShow(this, r103, r100);
    L11:
        final FragmentActivity r104 = l0.c(this.f49578g);
        if (r104 != null) goto L14;
        return;
    L14:
        com.bytedance.android.ec.window.base.common.bubble.d r105 = com.bytedance.android.ec.window.base.common.bubble.f.f49123b.a(r104);
        if (((ArrayList) r105.f49120b).isEmpty() == false) goto L17;
    L24:
        final Function0<Unit> r106 = new ECWindowBubblePrompt$popup$1(r104);
        Function0<Unit> r107 = new ECWindowBubblePrompt$onDismiss$dispose$1(this, r106);
        final Disposable r108 = Observable.timer(3000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r107), d.f49639a, e.f49640a);
        FragmentActivity r109 = l0.c(this.f49578g);
        if (r109 == null) goto L28;
        r109.getLifecycle().addObserver(new ECWindowBubblePrompt$onDismiss$$inlined$let$lambda$1(r108));
        return;
    L28:
        return;
    L17:
        if (r105.f49119a == WindowBubbleShowStrategy.ALL_ONCE) goto L24;
        Pair r110 = (Pair) CollectionsKt.firstOrNull(r105.f49120b);
        List<Pair<t, com.bytedance.android.ec.window.base.common.bubble.e>> r111 = r105.f49120b;
        if (r111 == null) goto L23;
        TypeIntrinsics.asMutableCollection(r111).remove(r110);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = rp.a.f538829a;
        if (rp.a.a(r100.getId()) == false) goto L5;
        return;
    L5:
        String r102 = this.f49572a;
        if (r102 == null) goto L8;
        com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f49578g, r102);
    L8:
        Function0<Unit> r103 = this.f49575d;
        if (r103 == null) goto L11;
        Unit r104 = r103.invoke();
    L11:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        dismiss();
    }

    public final void b(String r110, WindowFansClubBubbleConfig r111, View r112, Function0 r113) {
        this.f49572a = r110;
        this.f49573b = r111;
        this.f49577f = r112;
        boolean r114 = true;
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable());
        Context r115 = th.a.e(this.f49578g, true);
        View r116 = th.a.d(r115, R.layout.ec_window_join_fans_group_bubble, null, 4);
        WindowFansClubBubbleConfig r100 = this.f49573b;
        if (r100 == null) goto L9;
        String r101 = r100.getBubbleColor();
        if (r101 == null) goto L9;
        GradientDrawable r102 = new GradientDrawable();
        com.bytedance.android.ec.window.base.utils.c.f(r102, GradientDrawable.Orientation.TL_BR);
        r102.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(8));
        setElevation(com.bytedance.android.ec.core.utils.q.a(8));
        int r103 = (int) 3862510404L;
        com.bytedance.android.ec.window.base.utils.c.e(r102, new int[]{s.a(r101, r103), s.a(r101, r103)});
        com.bytedance.android.ec.window.base.utils.c.d(r116.findViewById(R.id.fans_group_bubble_wrappar), r102);
        GradientDrawable r104 = new GradientDrawable();
        r104.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(4));
        setElevation(com.bytedance.android.ec.core.utils.q.a(4));
        com.bytedance.android.ec.window.base.utils.c.e(r104, new int[]{s.a(r101, r103), s.a(r101, r103)});
        CardView r105 = (CardView) r116.findViewById(R.id.fans_group_bubble_triangle);
        com.bytedance.android.ec.window.base.utils.c.d(r105, r104);
        r105.setRotation(45.0f);
        View r106 = this.f49577f;
        if (r106 == null) goto L9;
        r106.post(new f(r105, r116, this, r115));
    L9:
        WindowFansClubBubbleConfig r117 = this.f49573b;
        if (r117 == null) goto L23;
        String r118 = r117.getPromptText();
        if (r118 == null) goto L23;
        TextView r107 = (TextView) r116.findViewById(R.id.fans_group_bubble_prompt_text);
        r107.setText(r118);
        WindowFansClubBubbleConfig r119 = this.f49573b;
        if (r119 == null) goto L23;
        String r120 = r119.getPromptTextColor();
        if (r120 == null) goto L23;
        if (a2.b(r120) == true) goto L21;
        r120 = null;
    L21:
        if (r120 == null) goto L23;
        r107.setTextColor(s.a(r120, 16777215));
    L23:
        WindowFansClubBubbleConfig r121 = this.f49573b;
        if (r121 == null) goto L26;
        String r122 = r121.getJumpText();
    L27:
        if (r122 == null) goto L33;
        if (StringsKt.isBlank(r122) == true) goto L33;
        r114 = false;
    L33:
        if (r114 == false) goto L35;
        r116.findViewById(R.id.fans_group_bubble_separator).setVisibility(8);
        r116.findViewById(R.id.fans_group_bubble_read_more_text).setVisibility(8);
        r116.findViewById(R.id.fans_group_bubble_more_arrow).setVisibility(8);
    L45:
        r116.setOnClickListener(this);
        Unit r123 = Unit.INSTANCE;
        this.f49574c = r116;
        setContentView(r116);
        this.f49576e = null;
        this.f49575d = r113;
        return;
    L35:
        TextView r124 = (TextView) r116.findViewById(R.id.fans_group_bubble_read_more_text);
        r124.setText(r122);
        WindowFansClubBubbleConfig r125 = this.f49573b;
        if (r125 == null) goto L45;
        String r126 = r125.getJumpTextColor();
        if (r126 == null) goto L45;
        if (a2.b(r126) == true) goto L43;
        r126 = null;
    L43:
        if (r126 == null) goto L45;
        r124.setTextColor(s.a(r126, 16436757));
        goto L45
    L26:
        r122 = null;
        goto L27
    }
}
