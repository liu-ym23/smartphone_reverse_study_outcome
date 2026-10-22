package com.bytedance.android.livesdk.interactivity.api.quickcomment;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/quickcomment/a;", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "", "id", "J", "Lpy/k;", "content", "Lpy/k;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends BaseEmoji implements vh7.h {

    @SerializedName("content")
    public k content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f133748id;

    public a() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.f133748id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.content = vh7.f.a(r100, k.class);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
