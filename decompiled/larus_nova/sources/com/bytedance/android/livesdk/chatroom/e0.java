package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f105889a = 0;

    static {
    }

    public static String a(IRoom r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter("", "default");
        if (r100 == null) goto L11;
        Map<String, String> r102 = r100.getAnchorABMap();
        if (r102 == null) goto L12;
        String r103 = r102.get(r101);
        if (r103 != null) goto L10;
        return "";
    L10:
        return r103;
    L12:
        return "";
    L11:
        return "";
    }
}
