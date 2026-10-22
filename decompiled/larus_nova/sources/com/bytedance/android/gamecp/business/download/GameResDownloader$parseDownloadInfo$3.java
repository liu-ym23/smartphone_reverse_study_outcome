package com.bytedance.android.gamecp.business.download;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"optLong", "", "Lcom/google/gson/JsonObject;", "key", "", "default", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class GameResDownloader$parseDownloadInfo$3 extends Lambda implements Function3<JsonObject, String, Long, Long> {
    public static final GameResDownloader$parseDownloadInfo$3 INSTANCE = null;

    static {
        INSTANCE = new GameResDownloader$parseDownloadInfo$3();
    }

    public GameResDownloader$parseDownloadInfo$3() {
        super(3);
    }

    public final long invoke(JsonObject r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$optLong");
        Intrinsics.checkNotNullParameter(r101, "key");
        JsonElement r103 = r100.get(r101);
        if (r103 != null) goto L5;
        return r102;
    L5:
        return r103.getAsLong();
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Long invoke(JsonObject r100, String r101, Long r102) {
        return Long.valueOf(invoke(r100, r101, r102.longValue()));
    }

    public static /* synthetic */ long invoke$default(GameResDownloader$parseDownloadInfo$3 r100, JsonObject r101, String r102, long r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r103 = 0;
    L6:
        return r100.invoke(r101, r102, r103);
    }
}
