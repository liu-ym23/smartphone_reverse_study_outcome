package com.bytedance.android.livesdk.interactivity.interactive;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/VSMessageBoardCommentLikeResponseData;", "", "()V", "thumbUpList", "", "", "", "getThumbUpList", "()Ljava/util/Map;", "setThumbUpList", "(Ljava/util/Map;)V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMessageBoardCommentLikeResponseData implements vh7.h {

    @SerializedName("thumbup_list")
    protected Map<Long, Boolean> thumbUpList;

    public VSMessageBoardCommentLikeResponseData() {
    }

    public final Map<Long, Boolean> getThumbUpList() {
        return this.thumbUpList;
    }

    public VSMessageBoardCommentLikeResponseData(am3.g r110) {
        this.thumbUpList = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        if (r101 != 1) goto L7;
        long r102 = r110.c();
        Long r103 = null;
        Boolean r104 = null;
    L9:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = Long.valueOf(r110.j());
        goto L9
    L13:
        if (r105 != 2) goto L14;
        r104 = Boolean.valueOf(am3.h.a(r110));
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r102);
        Map<Long, Boolean> r106 = this.thumbUpList;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r110);
        goto L3
    L25:
        r110.d(r100);
    }

    public final void setThumbUpList(Map<Long, Boolean> r100) {
        this.thumbUpList = r100;
    }
}
