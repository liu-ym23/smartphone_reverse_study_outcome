package com.bytedance.android.livesdk.rank;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.RankEnterInfo.Page")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/rank/RankEntrancePage;", "", "", "getContent", "content", "", "setContent", "toString", "", "getRankType", "rankType", "setRankType", "_content", "Ljava/lang/String;", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "_contentType", "I", "get_contentType", "()I", "set_contentType", "(I)V", "_rankType", "get_rankType", "set_rankType", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankEntrancePage implements vh7.h {
    public static final a Companion = null;
    public static final int DefaultContent = 0;
    public static final int GapContent = 2;
    public static final int RankContent = 1;

    @SerializedName("content")
    protected String _content;

    @SerializedName("content_type")
    protected int _contentType;

    @SerializedName("jump_rank_type")
    protected int _rankType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "RankEntrancePage{content='" + this._content + "', contentType='" + this._contentType + "'}";
    }

    public RankEntrancePage() {
        this._content = "";
    }

    public final String getContent() {
        return this._content;
    }

    public final int getRankType() {
        return this._rankType;
    }

    public final String get_content() {
        return this._content;
    }

    public final int get_contentType() {
        return this._contentType;
    }

    public final int get_rankType() {
        return this._rankType;
    }

    public RankEntrancePage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this._rankType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._content = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._contentType = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this._content != null) goto L31;
        this._content = "";
        return;
    }

    public final void setContent(String r100) {
        this._content = r100;
    }

    public final void setRankType(int r100) {
        this._rankType = r100;
    }

    public final void set_content(String r100) {
        this._content = r100;
    }

    public final void set_contentType(int r100) {
        this._contentType = r100;
    }

    public final void set_rankType(int r100) {
        this._rankType = r100;
    }
}
