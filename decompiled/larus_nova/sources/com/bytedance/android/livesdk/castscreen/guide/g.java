package com.bytedance.android.livesdk.castscreen.guide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f104494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f104495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f104496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f104497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f104498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f104499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f104500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f104501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f104502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f104503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f104504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f104505l;

    @Override // com.bytedance.android.livesdk.castscreen.guide.d
    public final void release() {
        this.f104505l.clear();
    }

    public g() {
        PadAndPcPlayGuide$dismissDialogAction$1 r100 = PadAndPcPlayGuide$dismissDialogAction$1.INSTANCE;
        this.f104505l = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.castscreen.guide.d
    public final boolean canShowGuide() {
        return !LivePadAndPcPlayUtil.h();
    }

    @Override // com.bytedance.android.livesdk.castscreen.guide.d
    public final void a(ViewGroup r100) {
        if (r100 == null) goto L21;
        r100.removeAllViews();
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_layout_pad_and_pc_play_guide, r100, true);
        if (r101 == null) goto L14;
        this.f104494a = (LinearLayout) r101.findViewById(R.id.llGuideContent);
        this.f104495b = r101.findViewById(R.id.llPadGuideContainer);
        this.f104496c = r101.findViewById(R.id.flPadTitle);
        this.f104497d = r101.findViewById(R.id.ivPadArrow);
        this.f104498e = r101.findViewById(R.id.dividerPad);
        this.f104499f = r101.findViewById(R.id.svPad);
        this.f104500g = r101.findViewById(R.id.llPcGuideContainer);
        this.f104501h = r101.findViewById(R.id.flPcTitle);
        this.f104502i = r101.findViewById(R.id.ivPcArrow);
        this.f104503j = r101.findViewById(R.id.dividerPc);
        this.f104504k = r101.findViewById(R.id.svPc);
        LinearLayout r102 = this.f104494a;
        int r103 = c.f104485a;
        if (r102 != null) goto L8;
        Disposable r104 = Disposables.empty();
    L9:
        RxUtilKt.c(r104, this.f104505l);
        int r105 = c.f104485a;
        LinearLayout r106 = this.f104494a;
        if (r106 != null) goto L12;
        Disposable r107 = Disposables.empty();
    L13:
        RxUtilKt.c(r107, this.f104505l);
        goto L14
    L12:
        CompositeDisposable r108 = new CompositeDisposable();
        r106.post(new b(r106, r108));
        r107 = r108;
        goto L13
    L8:
        CompositeDisposable r109 = new CompositeDisposable();
        r102.post(new a(r102, r109));
        r104 = r109;
    L14:
        View r110 = this.f104496c;
        if (r110 == null) goto L17;
        r110.setOnClickListener(new e(this));
    L17:
        View r111 = this.f104501h;
        if (r111 == null) goto L22;
        r111.setOnClickListener(new f(this));
        return;
    L22:
        return;
    }

    public static final void b(g r100, View r101, View r102, View r103, View r104) {
        r100.getClass();
        if (r101 == null) goto L54;
        if (r102 != null) goto L6;
    L9:
        boolean r105 = true;
    L10:
        LinearLayout r106 = r100.f104494a;
        if (r106 == null) goto L31;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof LinearLayout.LayoutParams) == true) goto L15;
        r107 = null;
    L15:
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107;
        if (r108 == null) goto L21;
        if (r105 == false) goto L19;
        int r109 = 48;
    L20:
        r108.gravity = r109;
        goto L21
    L19:
        r109 = 80;
    L21:
        Iterator<View> r110 = UtilityKotlinExtentionsKt.g(r106).iterator();
    L23:
        if (r110.hasNext() == false) goto L31;
        View r111 = r110.next();
        if (r105 == true) goto L27;
        UtilityKotlinExtentionsKt.w(r111);
        goto L23
    L27:
        if (Intrinsics.areEqual(r111, r101) == true) goto L28;
        UtilityKotlinExtentionsKt.t(r111);
        goto L23
    L28:
        UtilityKotlinExtentionsKt.w(r111);
    L31:
        if (r105 == false) goto L38;
        if (r102 == null) goto L34;
        UtilityKotlinExtentionsKt.w(r102);
    L34:
        if (r103 == null) goto L36;
        UtilityKotlinExtentionsKt.t(r103);
    L36:
        if (r104 == null) goto L55;
        r104.setRotation(180.0f);
        return;
    L55:
        return;
    L38:
        if (r102 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r102);
    L40:
        if (r103 == null) goto L42;
        UtilityKotlinExtentionsKt.w(r103);
    L42:
        if (r104 == null) goto L57;
        r104.setRotation(0.0f);
        return;
    L57:
        return;
    L6:
        if (r102.getVisibility() != 0) goto L9;
        r105 = false;
        goto L10
    }
}
