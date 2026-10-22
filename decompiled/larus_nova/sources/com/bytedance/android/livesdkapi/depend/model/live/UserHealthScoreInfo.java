package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomHealthScoreInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/UserHealthScoreInfo;", "", "()V", "_bubbleContent", "", "get_bubbleContent", "()Ljava/lang/String;", "set_bubbleContent", "(Ljava/lang/String;)V", "_score", "", "get_score", "()D", "set_score", "(D)V", "_url", "get_url", TeaEventTrack.ACTION_DRAMA_SET_URL, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserHealthScoreInfo implements h {

    @SerializedName("bubble_message")
    protected String _bubbleContent;

    @SerializedName(a.KEY_SCORE)
    protected double _score;

    @SerializedName("jump_url")
    protected String _url;

    public UserHealthScoreInfo() {
    }

    public final String get_bubbleContent() {
        return this._bubbleContent;
    }

    public final double get_score() {
        return this._score;
    }

    public final String get_url() {
        return this._url;
    }

    public UserHealthScoreInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this._score = Double.longBitsToDouble(r100.h());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._bubbleContent = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._url = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void set_bubbleContent(String r100) {
        this._bubbleContent = r100;
    }

    public final void set_score(double r100) {
        this._score = r100;
    }

    public final void set_url(String r100) {
        this._url = r100;
    }
}
