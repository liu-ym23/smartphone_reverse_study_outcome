package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import com.bytedance.android.livesdk.log.filter.v;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f138204a = null;

    public c() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
    }

    static {
        f138204a = new c();
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (Intrinsics.areEqual(r100, "livesdk_audience_live_message") == false) goto L12;
        b r102 = MediaInteractCommentDataContext.Companion.a();
        if (r102 == null) goto L9;
        int r103 = 1;
        if (r102.a0() != true) goto L9;
    L10:
        r101.put("is_comment_interflow", String.valueOf(r103));
        return;
    L9:
        r103 = 0;
        goto L10
    }
}
