package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdkapi.depend.model.broadcast.AnchorVideoSticker;
import com.bytedance.android.livesdkapi.depend.model.broadcast.RoomClipStickerData;
import io.reactivex.functions.Function;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f108052a;

    public e(String r100) {
        this.f108052a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        StringBuilder r102 = new StringBuilder("resp = ");
        AnchorVideoSticker r103 = ((RoomClipStickerData) r101.data).getAnchorVideoSticker();
        if (r103 == null) goto L5;
        Long r104 = r103.getStickerTypeId();
    L6:
        r102.append(r104);
        r102.append(' ');
        AnchorVideoSticker r105 = ((RoomClipStickerData) r101.data).getAnchorVideoSticker();
        if (r105 == null) goto L9;
        String r106 = r105.getStickerId();
    L10:
        r102.append(r106);
        r102.append(' ');
        AnchorVideoSticker r107 = ((RoomClipStickerData) r101.data).getAnchorVideoSticker();
        if (r107 == null) goto L13;
        String r108 = r107.getTitle();
    L14:
        r102.append(r108);
        r102.append(' ');
        AnchorVideoSticker r109 = ((RoomClipStickerData) r101.data).getAnchorVideoSticker();
        if (r109 == null) goto L17;
        String r110 = r109.getMetaData();
    L18:
        r102.append(r110);
        ALogger.i("FileMetadataUtils", r102.toString());
        AnchorVideoSticker r111 = ((RoomClipStickerData) r101.data).getAnchorVideoSticker();
        String r112 = "";
        if (r111 == null) goto L35;
        String r113 = r111.getMetaData();
        if (r113 != null) goto L23;
        return "";
    L23:
        if (r113.length() <= 0) goto L25;
        boolean r114 = true;
    L26:
        if (r114 != true) goto L37;
        Pair[] r115 = new Pair[1];
        AnchorVideoSticker r116 = ((RoomClipStickerData) r101.data).getAnchorVideoSticker();
        if (r116 == null) goto L33;
        String r117 = r116.getMetaData();
        if (r117 == null) goto L33;
        r112 = r117;
    L33:
        r115[0] = TuplesKt.to("LvMetaInfo", r112);
        HashMap r118 = MapsKt.hashMapOf(r115);
        int r119 = d.f108051a;
        return d.a.a(this.f108052a, r118, null);
    L37:
        return "";
    L25:
        r114 = false;
        goto L26
    L35:
        return "";
    L17:
        r110 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
