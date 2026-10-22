package ci1;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.config.tt;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ik1.d> {
    @Override // gs2.a
    public final String taskID() {
        return "VirtualContainerViewInitTask";
    }

    @Override // gs2.a
    public final void run() {
        ls2.d r100 = h();
        if (r100 != null) goto L5;
    L44:
        ls2.d r101 = h();
        if (r101 == null) goto L48;
        r101.f510527p = 0;
        return;
    L48:
        return;
    L5:
        if (r100.f510523l == null) goto L44;
        ik1.d r102 = g();
        Boolean r103 = null;
        if (r102 == null) goto L17;
        ik1.d r104 = g();
        if (r104 == null) goto L11;
        View r105 = r104.f490233i;
    L13:
        if ((r105 instanceof FrameLayout) == true) goto L15;
        r105 = null;
    L15:
        r102.f490234j = (FrameLayout) r105;
        goto L17
    L11:
        r105 = null;
    L17:
        if (tt.f121324a.getValue().booleanValue() == true) goto L23;
        ik1.d r106 = g();
        if (r106 == null) goto L23;
        FrameLayout r107 = r106.f490234j;
        if (r107 == null) goto L23;
        r107.setKeepScreenOn(true);
    L23:
        ls2.d r108 = h();
        if (r108 == null) goto L27;
        r103 = r108.f510520i;
    L27:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L33;
        ik1.d r109 = g();
        if (r109 == null) goto L44;
        FrameLayout r110 = r109.f490234j;
        if (r110 == null) goto L44;
        r110.setBackgroundColor(0);
        goto L44
    L33:
        ls2.d r111 = h();
        if (r111 == null) goto L44;
        Activity r112 = r111.f510523l;
        if (r112 == null) goto L44;
        Resources r113 = r112.getResources();
        if (r113 == null) goto L44;
        ik1.d r114 = g();
        if (r114 == null) goto L44;
        FrameLayout r115 = r114.f490234j;
        if (r115 == null) goto L44;
        r115.setBackgroundColor(r113.getColor(R.color.liveuikit_black));
        goto L44
    }

    public e() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
