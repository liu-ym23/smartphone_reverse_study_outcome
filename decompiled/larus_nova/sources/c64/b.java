package c64;

import android.util.Size;
import android.widget.ImageView;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Size f22588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView.ScaleType f22589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VideoScaleModel f22590c;

    public b(Size r100, ImageView.ScaleType r101, VideoScaleModel r102) {
        Intrinsics.checkNotNullParameter(r100, "size");
        Intrinsics.checkNotNullParameter(r101, "coverScaleType");
        Intrinsics.checkNotNullParameter(r102, "videoScaleModel");
        this.f22588a = r100;
        this.f22589b = r101;
        this.f22590c = r102;
    }
}
