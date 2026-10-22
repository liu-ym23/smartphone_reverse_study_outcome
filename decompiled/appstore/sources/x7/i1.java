package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.VideoView;
import com.bytedanceos.appstore.buss.widget.app.item.ItemHorizontalView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoView f25612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemHorizontalView f25613c;

    public i1(LinearLayout r10, VideoView r11, ItemHorizontalView r12) {
        this.f25611a = r10;
        this.f25612b = r11;
        this.f25613c = r12;
    }

    public static i1 a(View r10) {
        int r11 = R.id.iv_video;
        VideoView r12 = (VideoView) i0.a.a(r10, R.id.iv_video);
        if (r12 == null) goto L9;
        r11 = R.id.tv_item_horizontal_view;
        ItemHorizontalView r13 = (ItemHorizontalView) i0.a.a(r10, R.id.tv_item_horizontal_view);
        if (r13 == null) goto L9;
        return new i1((LinearLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static i1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_video, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25611a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
