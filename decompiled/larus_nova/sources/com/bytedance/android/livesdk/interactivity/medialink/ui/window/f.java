package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f138425a;

    public f(String r100) {
        this.f138425a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((String) r100, "it");
        String r101 = this.f138425a;
        if (r101 == null) goto L6;
        LiveSeiUtil.f71508i.getClass();
        return LiveSeiUtil.c(r101);
    L6:
        return new JSONObject(this.f138425a);
    }
}
