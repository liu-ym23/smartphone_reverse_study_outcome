package com.bytedance.android.gamecp.business.floatwindow.installguide;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.gamecp.business.floatwindow.installguide.banner.DotsView;
import com.bytedance.android.gamecp.business.floatwindow.installguide.banner.GuidePagerAdapter;
import com.bytedance.android.gamecp.business.floatwindow.installguide.banner.GuideViewPager;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wu.s;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/floatwindow/installguide/InstallGuideView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InstallGuideView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GuideViewPager f53181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GuidePagerAdapter f53182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DotsView f53183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f53184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f53185e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InstallGuideView f53186a;

        public a(InstallGuideView r100) {
            this.f53186a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            InstallGuideView r102 = this.f53186a;
            GuideViewPager r103 = r102.f53181a;
            if (r103 != null) goto L5;
            return;
        L5:
            if (r102.f53182b == null) goto L17;
            Intrinsics.checkNotNull(r103);
            int r104 = r103.getCurrentItem();
            GuidePagerAdapter r105 = this.f53186a.f53182b;
            Intrinsics.checkNotNull(r105);
            if (r104 >= (r105.getCount() - 1)) goto L11;
            GuideViewPager r106 = this.f53186a.f53181a;
            Intrinsics.checkNotNull(r106);
            GuideViewPager r107 = this.f53186a.f53181a;
            Intrinsics.checkNotNull(r107);
            r106.setCurrentItem(r107.getCurrentItem() + 1);
            return;
        L11:
            if (s.f561383a.getValue().g() == false) goto L16;
            GuideViewPager r108 = this.f53186a.f53181a;
            Intrinsics.checkNotNull(r108);
            r108.setCurrentItem(0);
            return;
        L16:
            return;
        }
    }

    public final void R5() {
        Disposable r100 = this.f53184d;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f53184d = Observable.timer(s.f561383a.getValue().a(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
    }

    @Override // android.view.ViewGroup
    public final void detachViewFromParent(int r100) {
        super.detachViewFromParent(r100);
        Disposable r101 = this.f53184d;
        if (r101 == null) goto L6;
        r101.dispose();
        return;
    }

    public InstallGuideView(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f53185e = r101;
        View.inflate(r100, R.layout.gamecp_install_guide_float_view, this);
        setBackgroundResource(R.drawable.gamecp_install_guide_float_view);
        List<n> r102 = InstallGuideFloatWindowManager.f53177g.e();
        if (r102 != null) goto L5;
    L21:
        ((ImageView) findViewById(R.id.iv_close)).setOnClickListener(new m(this));
        return;
    L5:
        if ((!r102.isEmpty()) != true) goto L21;
        View r103 = findViewById(R.id.vp_install_guide);
        if (r103 == null) goto L20;
        GuideViewPager r104 = (GuideViewPager) r103;
        this.f53181a = r104;
        r104.setPageMargin(y0.b(12.0f));
        View r105 = findViewById(R.id.dotsview_install_guide);
        if (r105 == null) goto L18;
        DotsView r106 = (DotsView) r105;
        this.f53183c = r106;
        r106.f53199c = R.drawable.gamecp_install_guide_dot_selected;
        r106.f53200d = R.drawable.gamecp_install_guide_dot_unselected;
        r106.setNumberOfPage(r102.size());
        GuidePagerAdapter r107 = new GuidePagerAdapter(r102);
        this.f53182b = r107;
        GuideViewPager r108 = this.f53181a;
        if (r108 == null) goto L13;
        r108.setAdapter(r107);
    L13:
        GuideViewPager r109 = this.f53181a;
        if (r109 == null) goto L16;
        r109.setOnPageChangeListener(new InstallGuideView$initView$1(this));
    L16:
        R5();
        goto L21
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.business.floatwindow.installguide.banner.DotsView");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.business.floatwindow.installguide.banner.GuideViewPager");
    }
}
