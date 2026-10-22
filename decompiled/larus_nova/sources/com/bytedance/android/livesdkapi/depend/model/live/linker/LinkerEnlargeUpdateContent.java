package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerEnlargeUpdateContent")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerEnlargeUpdateContent;", "", "", "", "enlargeUids", "Ljava/util/List;", "getEnlargeUids", "()Ljava/util/List;", "setEnlargeUids", "(Ljava/util/List;)V", "_fromUserId", "Ljava/lang/Long;", "get_fromUserId", "()Ljava/lang/Long;", "set_fromUserId", "(Ljava/lang/Long;)V", "", "_fromOpenId", "Ljava/lang/String;", "get_fromOpenId", "()Ljava/lang/String;", "set_fromOpenId", "(Ljava/lang/String;)V", "Lpy/k;", "uiImage", "Lpy/k;", "getUiImage", "()Lpy/k;", "setUiImage", "(Lpy/k;)V", "", "targetEnlargeGuestType", "Ljava/lang/Integer;", "getTargetEnlargeGuestType", "()Ljava/lang/Integer;", "setTargetEnlargeGuestType", "(Ljava/lang/Integer;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerEnlargeUpdateContent implements h {

    @SerializedName("from_openid")
    protected String _fromOpenId;

    @SerializedName("from_user_id")
    protected Long _fromUserId;

    @SerializedName("enlarge_user_ids")
    protected List<Long> enlargeUids;

    @SerializedName("target_enlarge_guest_type")
    protected Integer targetEnlargeGuestType;

    @SerializedName("ui_image")
    protected k uiImage;

    public LinkerEnlargeUpdateContent() {
    }

    public final List<Long> getEnlargeUids() {
        return this.enlargeUids;
    }

    public final Integer getTargetEnlargeGuestType() {
        return this.targetEnlargeGuestType;
    }

    public final k getUiImage() {
        return this.uiImage;
    }

    public final String get_fromOpenId() {
        return this._fromOpenId;
    }

    public final Long get_fromUserId() {
        return this._fromUserId;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public LinkerEnlargeUpdateContent(g r100) {
        this.enlargeUids = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.enlargeUids.add(Long.valueOf(r100.j()));
        goto L3
    L8:
        if (r102 != 5001) goto L10;
        this._fromOpenId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.targetEnlargeGuestType = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._fromUserId = Long.valueOf(r100.j());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.uiImage = f.a(r100, k.class);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setEnlargeUids(List<Long> r100) {
        this.enlargeUids = r100;
    }

    public final void setTargetEnlargeGuestType(Integer r100) {
        this.targetEnlargeGuestType = r100;
    }

    public final void setUiImage(k r100) {
        this.uiImage = r100;
    }

    public final void set_fromOpenId(String r100) {
        this._fromOpenId = r100;
    }

    public final void set_fromUserId(Long r100) {
        this._fromUserId = r100;
    }
}
