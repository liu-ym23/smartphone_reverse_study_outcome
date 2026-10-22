package x7;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.appstore.buss.widget.recyclerview.CommonRecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommonRecyclerView f25514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommonRecyclerView f25515b;

    public d(CommonRecyclerView r10, CommonRecyclerView r11) {
        this.f25514a = r10;
        this.f25515b = r11;
    }

    public static d a(View r10) {
        if (r10 == null) goto L6;
        CommonRecyclerView r11 = (CommonRecyclerView) r10;
        return new d(r11, r11);
    L6:
        throw new NullPointerException("rootView");
    }

    public CommonRecyclerView b() {
        return this.f25514a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
