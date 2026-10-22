package com.bytedance.android.live.effect.avadjust.lens;

import android.widget.LinearLayout;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements LiveLensAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLensFragment f66879a;

    public b(LiveLensFragment r100) {
        this.f66879a = r100;
    }

    @Override // com.bytedance.android.live.effect.avadjust.lens.LiveLensAdapter.a
    public final void a(k90.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lensData");
        LiveLensFragment r101 = this.f66879a;
        r100.getClass();
        r101.f66871e = null;
        ((LinearLayout) r101.S90(R.id.tab_container)).removeAllViews();
        ((ArrayList) r101.f66874h).clear();
        r100.getClass();
        Collection r102 = (Collection) null;
        ((LinearLayout) r101.S90(R.id.tab_container)).setVisibility(4);
        r100.getClass();
        LiveLensFragment r103 = this.f66879a;
        r100.getClass();
        r103.T90("livesdk_sound_image_set_tab_color_detail_icon_click", "", new HashMap());
    }
}
