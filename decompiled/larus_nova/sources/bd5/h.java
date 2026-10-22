package bd5;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.list.homepage.title.HomeSubTitleView;
import com.bytedance.ee.bear.widgets.t;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HomeSubTitleView f18666c;

    public h(HomeSubTitleView r100) {
        this.f18666c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        HomeSubTitleView r101 = this.f18666c;
        r101.f228373h = !r101.f228373h;
        AppCompatImageView r102 = r101.f228371f;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mIvSwitch");
        r102 = null;
    L6:
        if (this.f18666c.f228373h == false) goto L8;
        int r103 = R.drawable.ud_icon_disorder_list_outlined;
    L9:
        r102.setImageResource(r103);
        HomeSubTitleView r104 = this.f18666c;
        wc5.f.a r105 = r104.f228367b;
        if (r105 == null) goto L13;
        r105.WU(r104.f228373h);
        return;
    L13:
        return;
    L8:
        r103 = R.drawable.ud_icon_borders_outlined;
        goto L9
    }
}
