package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.TouchPositionMeta")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/im;", "", "", "id", "J", "meta_id", ThumbGlideUrl.SOURCE_TEMPLATE, "duration", "priority", "", "position", "I", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class im implements vh7.h {

    @SerializedName("duration")
    public long duration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f153657id;

    @SerializedName("meta_id")
    public long meta_id;

    @SerializedName("position")
    public int position;

    @SerializedName("priority")
    public long priority;

    @SerializedName(ThumbGlideUrl.SOURCE_TEMPLATE)
    public long template;

    public im() {
    }

    public im(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.f153657id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.meta_id = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.position = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.template = r100.j();
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.duration = r100.j();
        goto L3
    L16:
        if (r102 != 8) goto L17;
        this.priority = r100.j();
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
    }
}
