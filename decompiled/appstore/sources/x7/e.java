package x7;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonRecyclerView f25537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonRecyclerView f25538b;

    public e(CommonRecyclerView r10, CommonRecyclerView r11) {
        this.f25537a = r10;
        this.f25538b = r11;
    }

    public static e a(View r10) {
        if (r10 == null) goto L6;
        CommonRecyclerView r11 = (CommonRecyclerView) r10;
        return new e(r11, r11);
    L6:
        throw new NullPointerException("rootView");
    }

    public CommonRecyclerView b() {
        return this.f25537a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
