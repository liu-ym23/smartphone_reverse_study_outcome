package com.bytedance.android.live.profile.profilecontext;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.profile.customview.ProfileNestedScrollView;
import com.bytedance.android.live.profile.ui.base.m;
import com.bytedance.android.live.profile.ui.base.n;
import com.bytedance.android.live.profile.ui.base.o;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f86126a;

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final int e() {
        View r100 = this.f86126a;
        if (r100 == null) goto L7;
        View r101 = r100.findViewById(R.id.new_profile_content_white_bg);
        if (r101 == null) goto L7;
        return r101.getHeight();
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer b() {
        ProfileNestedScrollView r100 = (ProfileNestedScrollView) f(R.id.new_profile_max_border_layout_scroll_container);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getScrolledHeight());
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final Integer c() {
        ProfileNestedScrollView r100 = (ProfileNestedScrollView) f(R.id.new_profile_max_border_layout_scroll_container);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getMaxScrollHeight());
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void a(ProfileNestedScrollView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ProfileNestedScrollView r101 = (ProfileNestedScrollView) f(R.id.new_profile_max_border_layout_scroll_container);
        if (r101 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<ProfileNestedScrollView.b> r102 = r101.f85983b;
        if (r102 == null) goto L9;
        ((ArrayList) r102).remove(r100);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final void d(ProfileNestedScrollView.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ProfileNestedScrollView r101 = (ProfileNestedScrollView) f(R.id.new_profile_max_border_layout_scroll_container);
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (r101.f85983b != null) goto L7;
        r101.f85983b = new ArrayList();
    L7:
        List<ProfileNestedScrollView.b> r102 = r101.f85983b;
        if (r102 == null) goto L12;
        ((ArrayList) r102).add(r100);
        return;
    L12:
        return;
    }

    public final <T extends View> T f(int r100) {
        View r101 = this.f86126a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.findViewById(r100);
    }

    @Override // com.bytedance.android.live.profile.ui.base.m
    public final n findView(int r100) {
        View r101 = f(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new o(r101);
    }

    public b(Fragment r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        this.f86126a = r101;
    }
}
