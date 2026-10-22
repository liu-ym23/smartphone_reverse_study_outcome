package an6;

import android.content.Context;
import com.bytedance.locallife.poi.newdetail.widget.trip.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.video.PoiAbstractVideoView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c extends PoiAbstractVideoView {
    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void a(o r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "vid");
        Intrinsics.checkNotNullParameter(r102, "videoUrl");
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void e() {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void f() {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void g() {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void h() {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void i() {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void j(o r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void k() {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final void l() {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public void setMute(boolean r100) {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public void setSurfaceVisibility(int r100) {
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final Boolean c() {
        return Boolean.FALSE;
    }

    @Override // com.ss.android.ugc.aweme.video.PoiAbstractVideoView
    public final Boolean d() {
        return Boolean.FALSE;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
