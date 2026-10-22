package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ul;", "", "", "pkWinCount", "J", "getPkWinCount", "()J", "setPkWinCount", "(J)V", "roomLikeCount", "getRoomLikeCount", "setRoomLikeCount", "", "customizedGiftCount", "Ljava/util/Map;", "getCustomizedGiftCount", "()Ljava/util/Map;", "setCustomizedGiftCount", "(Ljava/util/Map;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ul implements vh7.h {

    @SerializedName("customized_gift_count")
    protected Map<Long, Long> customizedGiftCount;

    @SerializedName("pk_win_count")
    protected long pkWinCount;

    @SerializedName("room_like_count")
    protected long roomLikeCount;

    public ul() {
    }

    public ul(am3.g r110) {
        this.customizedGiftCount = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        if (r101 != 1) goto L8;
        this.pkWinCount = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.roomLikeCount = r110.j();
        goto L3
    L10:
        if (r101 != 3) goto L11;
        long r102 = r110.c();
        Long r103 = null;
        Long r104 = null;
    L13:
        int r105 = r110.f();
        if (r105 == (-1)) goto L20;
        if (r105 != 1) goto L16;
        r103 = Long.valueOf(r110.j());
        goto L13
    L16:
        if (r105 != 2) goto L17;
        r104 = Long.valueOf(r110.j());
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r102);
        Map<Long, Long> r106 = this.customizedGiftCount;
        if (r103 == null) goto L27;
        if (r104 == null) goto L25;
        r106.put(r103, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
    }
}
