package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/FastMatchV2Tag;", "", "", "tagType", "I", "", "tagText", "Ljava/lang/String;", "Lpy/k;", "tagImage", "Lpy/k;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FastMatchV2Tag implements h {

    @SerializedName("tag_image")
    public k tagImage;

    @SerializedName("tag_text")
    public String tagText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    public int tagType;

    public FastMatchV2Tag() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public FastMatchV2Tag(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.tagType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.tagText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.tagImage = f.a(r100, k.class);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
