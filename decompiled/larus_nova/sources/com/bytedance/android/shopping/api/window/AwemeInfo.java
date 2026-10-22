package com.bytedance.android.shopping.api.window;

import com.google.gson.JsonObject;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class AwemeInfo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f170680c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f170681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f170682b;

    public static final class a {
    }

    static {
    }

    public final String a() {
        return (String) this.f170681a.getValue();
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public AwemeInfo(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        this.f170682b = r100;
        this.f170681a = LazyKt.lazy(new AwemeInfo$awemeId$2(this));
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(AwemeInfo.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if ((!Intrinsics.areEqual(a(), ((AwemeInfo) r100).a())) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.api.window.AwemeInfo");
    L8:
        r101 = null;
        goto L10
    }
}
