package c64;

import android.widget.ImageView;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements d {
    public a() {
    }

    @Override // c64.d
    public final b a(int r100, int r101, int r102, int r103) {
        return new b(f.a(r100, r101, r102, r103), ImageView.ScaleType.FIT_CENTER, VideoScaleModel.FIT);
    }
}
