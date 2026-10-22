package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MidiSkinDressPageItem;", "", "Lcom/bytedance/android/livesdkapi/depend/message/DressPageItemCommon;", "common", "Lcom/bytedance/android/livesdkapi/depend/message/DressPageItemCommon;", "Lpy/k;", DocCallbackImpl.KEY_THUMBNAIL, "Lpy/k;", "topRightImage", "", "ownerDegree", "Ljava/lang/Integer;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MidiSkinDressPageItem implements h {

    @SerializedName("common")
    public DressPageItemCommon common;

    @SerializedName("owner_degree")
    public Integer ownerDegree;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    public k thumbnail;

    @SerializedName("top_right_image")
    public k topRightImage;

    public MidiSkinDressPageItem() {
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public MidiSkinDressPageItem(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.common = new DressPageItemCommon(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.thumbnail = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.topRightImage = f.a(r100, k.class);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.ownerDegree = Integer.valueOf(r100.i());
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
