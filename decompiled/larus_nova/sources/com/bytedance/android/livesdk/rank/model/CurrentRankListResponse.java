package com.bytedance.android.livesdk.rank.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.ranklist.RanklistRoomResponse.ResponseData")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0015\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\"\u0010,\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/rank/model/CurrentRankListResponse;", "", "", "getUserCountStr", "", "Lcom/bytedance/android/livesdk/rank/model/a;", "_ranks", "Ljava/util/List;", "get_ranks", "()Ljava/util/List;", "set_ranks", "(Ljava/util/List;)V", "_seats", "get_seats", "set_seats", "", "_hasMore", "Z", "get_hasMore", "()Z", "set_hasMore", "(Z)V", "_musicWave", "Ljava/lang/String;", "get_musicWave", "()Ljava/lang/String;", "set_musicWave", "(Ljava/lang/String;)V", "", "_total", "J", "get_total", "()J", "set_total", "(J)V", "_currency", "get_currency", "set_currency", "_rulesUrl", "get_rulesUrl", "set_rulesUrl", "_userCountStr", "get_userCountStr", "set_userCountStr", "_isFake", "get_isFake", "set_isFake", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CurrentRankListResponse implements vh7.h {

    @SerializedName("currency")
    protected String _currency;

    @SerializedName("has_more")
    protected boolean _hasMore;
    private boolean _isFake;

    @SerializedName("music_wave")
    protected String _musicWave;

    @SerializedName("ranks")
    protected List<a> _ranks;

    @SerializedName("rules_url")
    protected String _rulesUrl;

    @SerializedName("seats")
    protected List<a> _seats;

    @SerializedName("total")
    protected long _total;

    @SerializedName("user_count_desc")
    protected String _userCountStr;

    public CurrentRankListResponse() {
    }

    public final String getUserCountStr() {
        return this._userCountStr;
    }

    public final String get_currency() {
        return this._currency;
    }

    public final boolean get_hasMore() {
        return this._hasMore;
    }

    public final boolean get_isFake() {
        return this._isFake;
    }

    public final String get_musicWave() {
        return this._musicWave;
    }

    public final List<a> get_ranks() {
        return this._ranks;
    }

    public final String get_rulesUrl() {
        return this._rulesUrl;
    }

    public final List<a> get_seats() {
        return this._seats;
    }

    public final long get_total() {
        return this._total;
    }

    public final String get_userCountStr() {
        return this._userCountStr;
    }

    public CurrentRankListResponse(am3.g r100) {
        this._ranks = new ArrayList();
        this._seats = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L6;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L6;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this._userCountStr = am3.h.c(r100);
        goto L3
    L8:
        this._rulesUrl = am3.h.c(r100);
        goto L3
    L9:
        this._currency = am3.h.c(r100);
        goto L3
    L10:
        this._total = r100.j();
        goto L3
    L11:
        this._musicWave = am3.h.c(r100);
        goto L3
    L12:
        this._hasMore = am3.h.a(r100);
        goto L3
    L13:
        List<a> r103 = this._seats;
        a r104 = new a(r100);
    L15:
        r103.add(r104);
        goto L3
    L14:
        r103 = this._ranks;
        r104 = new a(r100);
        goto L15
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void set_currency(String r100) {
        this._currency = r100;
    }

    public final void set_hasMore(boolean r100) {
        this._hasMore = r100;
    }

    public final void set_isFake(boolean r100) {
        this._isFake = r100;
    }

    public final void set_musicWave(String r100) {
        this._musicWave = r100;
    }

    public final void set_ranks(List<a> r100) {
        this._ranks = r100;
    }

    public final void set_rulesUrl(String r100) {
        this._rulesUrl = r100;
    }

    public final void set_seats(List<a> r100) {
        this._seats = r100;
    }

    public final void set_total(long r100) {
        this._total = r100;
    }

    public final void set_userCountStr(String r100) {
        this._userCountStr = r100;
    }
}
