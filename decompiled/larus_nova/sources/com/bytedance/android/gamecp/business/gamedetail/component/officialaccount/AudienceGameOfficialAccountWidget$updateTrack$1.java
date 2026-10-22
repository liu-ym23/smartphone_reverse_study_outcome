package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AudienceGameOfficialAccountWidget$updateTrack$1 extends MutablePropertyReference0Impl {
    public AudienceGameOfficialAccountWidget$updateTrack$1(AudienceGameOfficialAccountWidget r100) {
        super(r100, AudienceGameOfficialAccountWidget.class, "followStrategy", "getFollowStrategy()Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/AudienceGameOfficialAccountWidget$FollowTrackStrategy;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        AudienceGameOfficialAccountWidget.a r100 = ((AudienceGameOfficialAccountWidget) this.receiver).f54695t;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("followStrategy");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        AudienceGameOfficialAccountWidget.a r101 = (AudienceGameOfficialAccountWidget.a) r100;
        ((AudienceGameOfficialAccountWidget) this.receiver).f54695t = r101;
    }
}
