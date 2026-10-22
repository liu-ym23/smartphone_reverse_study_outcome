package com.bytedance.android.livesdk.wrds.syncdata.openplatform;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ShelfCardSupplementSyncData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/openplatform/c;", "", "", "roomId", "J", "explainCardId", "", "", "Lcom/bytedance/android/livesdk/wrds/syncdata/openplatform/a;", "explainCardSupplementMap", "Ljava/util/Map;", "", "shelfCardSupplementMapStr", "Ljava/lang/String;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("card_id")
    public long explainCardId;

    @SerializedName("supplement_map")
    public Map<Integer, a> explainCardSupplementMap;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("supplement_card_map_str")
    public String shelfCardSupplementMapStr;

    public c() {
    }

    public c(g r110) {
        this.explainCardSupplementMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.roomId = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.explainCardId = r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        long r102 = r110.c();
        Integer r103 = null;
        a r104 = null;
    L16:
        int r105 = r110.f();
        if (r105 == (-1)) goto L23;
        if (r105 != 1) goto L19;
        r103 = Integer.valueOf(r110.i());
        goto L16
    L19:
        if (r105 != 2) goto L20;
        r104 = new a(r110);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r102);
        Map<Integer, a> r106 = this.explainCardSupplementMap;
        if (r103 == null) goto L30;
        if (r104 == null) goto L28;
        r106.put(r103, r104);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 4) goto L13;
        this.shelfCardSupplementMapStr = am3.h.c(r110);
        goto L3
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }
}
