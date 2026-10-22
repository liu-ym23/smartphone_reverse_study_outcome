package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.z;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/RemoveMessageDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RemoveMessageDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f140201a;

    public interface a {
    }

    public RemoveMessageDecoration(z r100) {
        Intrinsics.checkNotNullParameter(r100, "removedMsgHandler");
        this.f140201a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        super.onDrawOver(r100, r101, r102);
        if (r101.getChildCount() > 0) goto L5;
        return;
    L5:
        View r103 = r101.getChildAt(r101.getChildCount() - 1);
        if (r103 != null) goto L8;
        return;
    L8:
        int r104 = u42.g.f548686a;
        Intrinsics.checkNotNullParameter(r103, "view");
        Object r105 = r103.getTag(R.id.ttlive_public_screen_pin_handler);
        if ((r105 instanceof u42.b) == true) goto L11;
        r105 = null;
    L11:
        u42.b r106 = (u42.b) r105;
        if ((r106 instanceof y92.a) == false) goto L18;
        a r107 = this.f140201a;
        long r108 = ((y92.a) r106).f566965d;
        TextMessageWidget r109 = ((z) r107).f140515a;
        if (r109.f140449f.hasMessages(5) == true) goto L19;
        r109.f140449f.sendEmptyMessageDelayed(5, r108);
        return;
    L19:
        return;
    }
}
