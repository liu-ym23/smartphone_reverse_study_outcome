package a04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<n, o> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f1265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f1266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f1267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f1268i;

    public static final class a extends com.bytedance.awemeopen.apps.framework.utils.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f1269d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((n) this.f1269d.f195897b).f1277a.b(Unit.INSTANCE);
        }

        public a(i r100) {
            this.f1269d = r100;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.f1266g = (LinearLayout) b().findViewById(R.id.digg_view_layout);
        this.f1267h = (ImageView) b().findViewById(R.id.digg);
        this.f1268i = (TextView) b().findViewById(R.id.digg_count);
        LinearLayout r100 = this.f1266g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("diggContainer");
        r100 = null;
    L5:
        r100.setOnClickListener(new a(this));
        o r101 = (o) this.f195898c;
        Observer<Boolean> r102 = new f();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        r101.f1278a.a(r102);
        o r103 = (o) this.f195898c;
        Observer<Boolean> r104 = new g(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f1280c.a(r104);
        o r105 = (o) this.f195898c;
        Observer<Long> r106 = new h(this);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "observer");
        r105.f1279b.a(r106);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_common_feed_layout_video_digg_no_animation, r100, false);
    }

    public i(Context r100, n r101, o r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f1264e = r103;
        this.f1265f = r104;
    }
}
