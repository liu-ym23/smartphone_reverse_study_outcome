package b04;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<i, j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.base.view.e f16870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f16871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AoImageView f16872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AoImageView f16873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f16874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ValueAnimator f16876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f16877l;

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        KeyEvent.Callback r100 = b().findViewById(R.id.notes_layout);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.base.view.IPeriscopeView");
        this.f16870e = (com.bytedance.awemeopen.apps.framework.base.view.e) r100;
        this.f16871f = (FrameLayout) b().findViewById(R.id.music_cover_container);
        this.f16872g = (AoImageView) b().findViewById(R.id.origin_music_cover);
        this.f16873h = (AoImageView) b().findViewById(R.id.origin_music_cover_owner);
        j r101 = (j) this.f195898c;
        Observer<e24.b> r102 = new c(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        r101.f16880c.a(r102);
        j r103 = (j) this.f195898c;
        Observer<Boolean> r104 = new d(this);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "observer");
        r103.f16878a.a(r104);
        j r105 = (j) this.f195898c;
        Observer<Boolean> r106 = new e(this);
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "observer");
        r105.f16879b.a(r106);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.aos_common_feed_element_video_cover_music, r100, false);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [b04.f] */
    public h(Context r100, i r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        super(r100, r101, r102);
        this.f16874i = 64;
        this.f16877l = new f(this);
    }
}
