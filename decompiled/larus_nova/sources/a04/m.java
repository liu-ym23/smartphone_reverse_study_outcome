package a04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.base.view.digg.DiggAnimationLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<n, o> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f1273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DiggAnimationLayout f1274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f1275g;

    public static final class a extends com.bytedance.awemeopen.apps.framework.utils.o {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m f1276d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((n) this.f1276d.f195897b).f1277a.b(Unit.INSTANCE);
        }

        public a(m r100) {
            this.f1276d = r100;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.f1273e = (LinearLayout) b().findViewById(R.id.digg_view_layout);
        this.f1274f = (DiggAnimationLayout) b().findViewById(R.id.digg);
        this.f1275g = (TextView) b().findViewById(R.id.digg_count);
        DiggAnimationLayout r100 = this.f1274f;
        LinearLayout r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("diggAnimationLayout");
        r100 = null;
    L6:
        if (r100.f193238a.containsKey(r100.getType()) == true) goto L11;
        String r102 = r100.getType();
        if (r102 != null) goto L10;
        r102 = "common";
    L10:
        r100.a(r102);
    L11:
        Iterator<Map.Entry<String, View>> r103 = r100.f193238a.entrySet().iterator();
        boolean r104 = false;
    L13:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<String, View> r105 = r103.next();
        if (Intrinsics.areEqual(r105.getKey(), r100.getType()) == true) goto L16;
        r105.getValue().setVisibility(8);
        goto L13
    L16:
        r105.getValue().setVisibility(0);
        r105.getValue().setSelected(r100.isSelected());
        r104 = true;
        goto L13
    L18:
        if (r104 == true) goto L24;
        r100.f193238a.size();
        r100.a("common");
        View r106 = r100.f193238a.get("common");
        if (r106 == null) goto L24;
        r106.setVisibility(0);
    L24:
        LinearLayout r107 = this.f1273e;
        if (r107 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("diggContainer");
    L28:
        r101.setOnClickListener(new a(this));
        o r108 = (o) this.f195898c;
        Observer<Boolean> r109 = new j(this);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "observer");
        r108.f1278a.a(r109);
        o r110 = (o) this.f195898c;
        Observer<Boolean> r111 = new k(this);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "observer");
        r110.f1280c.a(r111);
        o r112 = (o) this.f195898c;
        Observer<Long> r113 = new l(this);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "observer");
        r112.f1279b.a(r113);
        return;
    L27:
        r101 = r107;
        goto L28
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_common_feed_layout_video_digg, r100, false);
    }

    public m(Context r100, n r101, o r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
    }
}
