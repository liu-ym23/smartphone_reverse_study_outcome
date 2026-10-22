package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameOfficialAccountWidget f54710a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 4;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getClickTempExtraAttrs() {
        AudienceGameOfficialAccountWidget.a r100 = this.f54710a.f54695t;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("followStrategy");
    L6:
        return r100.getClickTempExtraAttrs();
    }

    public b(AudienceGameOfficialAccountWidget r100) {
        this.f54710a = r100;
    }
}
