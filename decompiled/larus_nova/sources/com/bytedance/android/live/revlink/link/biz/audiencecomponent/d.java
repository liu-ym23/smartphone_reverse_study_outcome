package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevSeiFrame f97761a;

    public d(RevSeiFrame r100) {
        this.f97761a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        String r101 = this.f97761a.C;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        return new JSONObject(r101);
    }
}
