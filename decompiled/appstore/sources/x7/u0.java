package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.VideoView;
import com.bytedanceos.appstore.buss.widget.app.item.ItemSubView;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoView f25766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f25767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ItemSubView f25768d;

    public u0(LinearLayout r10, VideoView r11, LinearLayout r12, ItemSubView r13) {
        this.f25765a = r10;
        this.f25766b = r11;
        this.f25767c = r12;
        this.f25768d = r13;
    }

    public static u0 a(View r10) {
        int r11 = R.id.iv_video;
        VideoView r12 = (VideoView) i0.a.a(r10, R.id.iv_video);
        if (r12 == null) goto L10;
        LinearLayout r13 = (LinearLayout) r10;
        ItemSubView r14 = (ItemSubView) i0.a.a(r10, R.id.tv_sub_view_in_video);
        if (r14 != null) goto L7;
        r11 = R.id.tv_sub_view_in_video;
        goto L10
    L7:
        return new u0(r13, r12, r13, r14);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static u0 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_app_sub_video, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25765a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
