package com.bytedance.android.gamecp.business.download;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"optString", "", "Lcom/google/gson/JsonObject;", "key", "default", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class GameResDownloader$parseDownloadInfo$1 extends Lambda implements Function3<JsonObject, String, String, String> {
    public static final GameResDownloader$parseDownloadInfo$1 INSTANCE = null;

    static {
        INSTANCE = new GameResDownloader$parseDownloadInfo$1();
    }

    public GameResDownloader$parseDownloadInfo$1() {
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(JsonObject r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$optString");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "default");
        JsonElement r103 = r100.get(r101);
        if (r103 == null) goto L9;
        String r104 = r103.getAsString();
        if (r104 != null) goto L8;
        return r102;
    L8:
        return r104;
    L9:
        return r102;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(JsonObject r100, String r101, String r102) {
        return invoke2(r100, r101, r102);
    }

    public static /* synthetic */ String invoke$default(GameResDownloader$parseDownloadInfo$1 r100, JsonObject r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r103 = "";
    L6:
        return r100.invoke2(r101, r102, r103);
    }
}
