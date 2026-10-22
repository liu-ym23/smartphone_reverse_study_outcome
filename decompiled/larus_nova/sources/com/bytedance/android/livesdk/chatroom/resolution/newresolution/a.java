package com.bytedance.android.livesdk.chatroom.resolution.newresolution;

import com.bytedance.android.livesdk.config.zl;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f110474a = 0;

    static {
    }

    public static String a(IBaseStreamUrl r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$streamDefaultQualitySdkKey");
        if (zl.f121774a.getValue().booleanValue() == false) goto L6;
        return r100.getCompoundStreamDefaultQualitySdkKey();
    L6:
        return r100.getMultiStreamDefaultQualitySdkKey();
    }
}
