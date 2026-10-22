package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n implements com.bytedance.android.shopping.anchorv4.bottom.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f166676a;

    @Override // com.bytedance.android.shopping.anchorv4.bottom.w
    public final CommonMeta a() {
        return this.f166676a.f166687f.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.w
    public final long getDuration() {
        return this.f166676a.f166687f.getDuration();
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.w
    public final LinkedTreeMap<String, Object> getTrackMeta() {
        return this.f166676a.f166687f.b();
    }

    public n(p r100) {
        this.f166676a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.bottom.w
    public final void n(String r100, Map<String, ? extends Object> r110, boolean r111, boolean r112, String r113, PageFinder r114) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f166676a.f166687f.n(r100, r110, r111, r112, r113, r114);
    }
}
