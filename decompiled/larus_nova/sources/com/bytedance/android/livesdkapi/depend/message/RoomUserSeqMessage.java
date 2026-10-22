package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.RoomUserSeqMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b'\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\"\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0015\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/RoomUserSeqMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "getUserCountStr", "getTotalUserStr", "", "_mTotal", "J", "get_mTotal", "()J", "set_mTotal", "(J)V", "", "Lcom/bytedance/android/livesdkapi/depend/message/Contributor;", "_mContributors", "Ljava/util/List;", "get_mContributors", "()Ljava/util/List;", "set_mContributors", "(Ljava/util/List;)V", "_popStr", "Ljava/lang/String;", "get_popStr", "()Ljava/lang/String;", "set_popStr", "(Ljava/lang/String;)V", "_seats", "get_seats", "set_seats", "_mPopularity", "get_mPopularity", "set_mPopularity", "_totalUser", "get_totalUser", "set_totalUser", "_totalUserStr", "get_totalUserStr", "set_totalUserStr", "_userCountStr", "get_userCountStr", "set_userCountStr", "_exactUserCountStr", "get_exactUserCountStr", "set_exactUserCountStr", "_exactTotalUserStr", "get_exactTotalUserStr", "set_exactTotalUserStr", "_topRightStrComplete", "get_topRightStrComplete", "set_topRightStrComplete", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomUserSeqMessage extends o0 implements h {

    @SerializedName("total_pv_for_anchor")
    protected String _exactTotalUserStr;

    @SerializedName("online_user_for_anchor")
    protected String _exactUserCountStr;

    @SerializedName("ranks")
    protected List<Contributor> _mContributors;

    @SerializedName("popularity")
    protected long _mPopularity;

    @SerializedName("total")
    protected long _mTotal;

    @SerializedName("pop_str")
    protected String _popStr;

    @SerializedName("seats")
    protected List<Contributor> _seats;

    @SerializedName("up_right_stats_str_complete")
    protected String _topRightStrComplete;

    @SerializedName("total_user")
    protected long _totalUser;

    @SerializedName("total_user_str")
    protected String _totalUserStr;

    @SerializedName("total_str")
    protected String _userCountStr;

    public RoomUserSeqMessage() {
        setType(MessageType.USER_SEQ);
    }

    public final String getTotalUserStr() {
        return this._totalUserStr;
    }

    public final String getUserCountStr() {
        return this._userCountStr;
    }

    public final String get_exactTotalUserStr() {
        return this._exactTotalUserStr;
    }

    public final String get_exactUserCountStr() {
        return this._exactUserCountStr;
    }

    public final List<Contributor> get_mContributors() {
        return this._mContributors;
    }

    public final long get_mPopularity() {
        return this._mPopularity;
    }

    public final long get_mTotal() {
        return this._mTotal;
    }

    public final String get_popStr() {
        return this._popStr;
    }

    public final List<Contributor> get_seats() {
        return this._seats;
    }

    public final String get_topRightStrComplete() {
        return this._topRightStrComplete;
    }

    public final long get_totalUser() {
        return this._totalUser;
    }

    public final String get_totalUserStr() {
        return this._totalUserStr;
    }

    public final String get_userCountStr() {
        return this._userCountStr;
    }

    public RoomUserSeqMessage(g r100) {
        this._mContributors = new ArrayList();
        this._seats = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        switch(r102) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L6;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this._topRightStrComplete = am3.h.c(r100);
        goto L3
    L8:
        this._exactTotalUserStr = am3.h.c(r100);
        goto L3
    L9:
        this._exactUserCountStr = am3.h.c(r100);
        goto L3
    L10:
        this._userCountStr = am3.h.c(r100);
        goto L3
    L11:
        this._totalUserStr = am3.h.c(r100);
        goto L3
    L12:
        this._totalUser = r100.j();
        goto L3
    L13:
        this._mPopularity = r100.j();
        goto L3
    L14:
        List<Contributor> r103 = this._seats;
        Contributor r104 = new Contributor(r100);
    L18:
        r103.add(r104);
        goto L3
    L15:
        this._popStr = am3.h.c(r100);
        goto L3
    L16:
        this._mTotal = r100.j();
        goto L3
    L17:
        r103 = this._mContributors;
        r104 = new Contributor(r100);
        goto L18
    L19:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        setType(MessageType.USER_SEQ);
    }

    public final void set_exactTotalUserStr(String r100) {
        this._exactTotalUserStr = r100;
    }

    public final void set_exactUserCountStr(String r100) {
        this._exactUserCountStr = r100;
    }

    public final void set_mContributors(List<Contributor> r100) {
        this._mContributors = r100;
    }

    public final void set_mPopularity(long r100) {
        this._mPopularity = r100;
    }

    public final void set_mTotal(long r100) {
        this._mTotal = r100;
    }

    public final void set_popStr(String r100) {
        this._popStr = r100;
    }

    public final void set_seats(List<Contributor> r100) {
        this._seats = r100;
    }

    public final void set_topRightStrComplete(String r100) {
        this._topRightStrComplete = r100;
    }

    public final void set_totalUser(long r100) {
        this._totalUser = r100;
    }

    public final void set_totalUserStr(String r100) {
        this._totalUserStr = r100;
    }

    public final void set_userCountStr(String r100) {
        this._userCountStr = r100;
    }
}
