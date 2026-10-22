package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import com.google.android.material.tabs.TabLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameTabWidget f55084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f55085b;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 4;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getClickTempExtraAttrs() {
        GameTabWidget r100 = this.f55084a;
        TabLayout r101 = r100.f55036o;
        if (r101 != null) goto L5;
    L9:
        LinkedHashMap r102 = new LinkedHashMap();
        if (this.f55084a.f55044w == false) goto L12;
        String r103 = "1";
    L13:
        r102.put("is_back_to_top", r103);
        return r102;
    L12:
        r103 = "0";
        goto L13
    L5:
        if (r100.f55043v != r101.getSelectedTabPosition()) goto L7;
        boolean r104 = true;
    L8:
        r100.f55044w = r104;
        GameTabWidget r105 = this.f55084a;
        r105.f55043v = r101.getSelectedTabPosition();
        goto L9
    L7:
        r104 = false;
        goto L8
    }

    public j(GameTabWidget r100, List r101) {
        this.f55084a = r100;
        this.f55085b = r101;
    }
}
