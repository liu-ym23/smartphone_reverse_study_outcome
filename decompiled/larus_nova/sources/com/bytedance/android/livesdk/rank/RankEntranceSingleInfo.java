package com.bytedance.android.livesdk.rank;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.RankEnterInfo.RankInfo")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.J\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\b\u0010\t\u001a\u00020\bH\u0016R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R$\u0010*\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/rank/RankEntranceSingleInfo;", "", "", "Lcom/bytedance/android/livesdk/rank/RankEntrancePage;", "getPages", "pages", "", "setPages", "", "toString", "_pages", "Ljava/util/List;", "get_pages", "()Ljava/util/List;", "set_pages", "(Ljava/util/List;)V", "", "_position", "I", "get_position", "()I", "set_position", "(I)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_rankType", "get_rankType", "set_rankType", "_title", "Ljava/lang/String;", "get_title", "()Ljava/lang/String;", "set_title", "(Ljava/lang/String;)V", "_rank_extra", "get_rank_extra", "set_rank_extra", "_entrance_extra", "get_entrance_extra", "set_entrance_extra", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankEntranceSingleInfo implements vh7.h {
    public static final a Companion = null;
    public static final int PositionGlobal = 0;
    public static final int PositionVertical = 1;

    @SerializedName("entrance_extra")
    protected String _entrance_extra;

    @SerializedName("icon")
    protected ImageModel _icon;

    @SerializedName("pages")
    protected List<RankEntrancePage> _pages;

    @SerializedName("position")
    protected int _position;

    @SerializedName("rank_type")
    protected int _rankType;

    @SerializedName("rank_extra")
    protected String _rank_extra;

    @SerializedName("title")
    protected String _title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RankEntranceSingleInfo() {
    }

    public String toString() {
        return "RankEntranceSingleInfo{pages=" + this._pages + ", position=" + this._position + '}';
    }

    public final List<RankEntrancePage> getPages() {
        return this._pages;
    }

    public final String get_entrance_extra() {
        return this._entrance_extra;
    }

    public final ImageModel get_icon() {
        return this._icon;
    }

    public final List<RankEntrancePage> get_pages() {
        return this._pages;
    }

    public final int get_position() {
        return this._position;
    }

    public final int get_rankType() {
        return this._rankType;
    }

    public final String get_rank_extra() {
        return this._rank_extra;
    }

    public final String get_title() {
        return this._title;
    }

    public RankEntranceSingleInfo(am3.g r100) {
        this._pages = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this._entrance_extra = am3.h.c(r100);
        goto L3
    L8:
        this._rank_extra = am3.h.c(r100);
        goto L3
    L9:
        this._title = am3.h.c(r100);
        goto L3
    L10:
        this._rankType = r100.i();
        goto L3
    L11:
        this._position = r100.i();
        goto L3
    L12:
        this._icon = x.a(r100);
        goto L3
    L13:
        this._pages.add(new RankEntrancePage(r100));
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }

    public final void setPages(List<RankEntrancePage> r100) {
        this._pages = r100;
    }

    public final void set_entrance_extra(String r100) {
        this._entrance_extra = r100;
    }

    public final void set_icon(ImageModel r100) {
        this._icon = r100;
    }

    public final void set_pages(List<RankEntrancePage> r100) {
        this._pages = r100;
    }

    public final void set_position(int r100) {
        this._position = r100;
    }

    public final void set_rankType(int r100) {
        this._rankType = r100;
    }

    public final void set_rank_extra(String r100) {
        this._rank_extra = r100;
    }

    public final void set_title(String r100) {
        this._title = r100;
    }
}
