package com.bytedance.android.live.base.model.moreliveentrance;

import am3.g;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.MoreLiveEntrance")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b*\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bD\u0010ER$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\"\u0010;\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001e\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\bR$\u0010A\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\b¨\u0006F"}, d2 = {"Lcom/bytedance/android/live/base/model/moreliveentrance/b;", "", "", "name", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "s", "(Ljava/lang/String;)V", "", "tabType", "J", "l", "()J", "x", "(J)V", "validTime", "o", "y", "priority", "f", "t", "extra", "c", "q", "eventExtra", "b", "p", "", "tabItemId", "I", ce.f26395j, "()I", BaseSwitches.V, "(I)V", "tabItemName", ce.f26396k, "w", "tabItemEvent", RXScreenCaptureService.KEY_INDEX, "u", "guideType", "d", "r", "entranceType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEntranceType", "shortTopicId", "h", "setShortTopicId", "shortTopicContent", ce.f26391f, "setShortTopicContent", "topicId", OfficeSDKRequestTag.KEY_NEW_USER, "setTopicId", "topicContent", "m", "setTopicContent", "contentType", "getContentType", "setContentType", "feUrl", "getFeUrl", "setFeUrl", "feDynamicParam", "getFeDynamicParam", "setFeDynamicParam", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("content_type")
    protected int contentType;

    @SerializedName(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE)
    protected int entranceType;

    @SerializedName("event_extra")
    protected String eventExtra;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("fe_dynamic_param")
    protected String feDynamicParam;

    @SerializedName("fe_url")
    protected String feUrl;

    @SerializedName("guide_type")
    protected String guideType;

    @SerializedName("name")
    protected String name;

    @SerializedName("priority")
    protected long priority;

    @SerializedName("short_topic_content")
    protected String shortTopicContent;

    @SerializedName("short_topic_id")
    protected long shortTopicId;

    @SerializedName("tab_item_event")
    protected String tabItemEvent;

    @SerializedName("tab_item_id")
    protected int tabItemId;

    @SerializedName("tab_item_name")
    protected String tabItemName;

    @SerializedName("tab_type")
    protected long tabType;

    @SerializedName("topic_content")
    protected String topicContent;

    @SerializedName("topic_id")
    protected long topicId;

    @SerializedName("valid_time")
    protected long validTime;

    public final void v() {
        this.tabItemId = 1;
    }

    public final void u() {
        this.tabItemEvent = "";
    }

    public b() {
        DefaultTabPriority r100 = DefaultTabPriority.DEFAULT;
        this.tabType = -1;
        this.validTime = -1;
        this.priority = -1;
        this.tabItemId = -1;
        this.entranceType = -1;
        this.shortTopicId = -1;
        this.topicId = -1;
    }

    public final void w() {
        this.tabItemName = "精选";
    }

    public final int a() {
        return this.entranceType;
    }

    public final String b() {
        return this.eventExtra;
    }

    public final String c() {
        return this.extra;
    }

    public final String d() {
        return this.guideType;
    }

    public final String e() {
        return this.name;
    }

    public final long f() {
        return this.priority;
    }

    public final String g() {
        return this.shortTopicContent;
    }

    public final long h() {
        return this.shortTopicId;
    }

    public final String i() {
        return this.tabItemEvent;
    }

    public final int j() {
        return this.tabItemId;
    }

    public final String k() {
        return this.tabItemName;
    }

    public final long l() {
        return this.tabType;
    }

    public final String m() {
        return this.topicContent;
    }

    public final long n() {
        return this.topicId;
    }

    public final long o() {
        return this.validTime;
    }

    public b(g r100) {
        DefaultTabPriority r101 = DefaultTabPriority.DEFAULT;
        long r102 = r100.c();
        int r103 = 0;
    L3:
        int r104 = r100.f();
        if (r104 == (-1)) goto L25;
        switch(r104) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            default: goto L6;
        };
    L7:
        this.feDynamicParam = am3.h.c(r100);
        goto L3
    L8:
        this.feUrl = am3.h.c(r100);
        goto L3
    L9:
        this.contentType = r100.i();
        goto L3
    L10:
        this.topicContent = am3.h.c(r100);
        goto L3
    L11:
        this.topicId = r100.j();
        r103 = r103 | 64;
        goto L3
    L12:
        this.shortTopicContent = am3.h.c(r100);
        goto L3
    L13:
        this.shortTopicId = r100.j();
        r103 = r103 | 32;
        goto L3
    L14:
        this.entranceType = r100.i();
        r103 = r103 | 16;
        goto L3
    L15:
        this.guideType = am3.h.c(r100);
        goto L3
    L16:
        this.tabItemEvent = am3.h.c(r100);
        goto L3
    L17:
        this.tabItemName = am3.h.c(r100);
        goto L3
    L18:
        this.tabItemId = (int) r100.j();
        r103 = r103 | 8;
        goto L3
    L19:
        this.eventExtra = am3.h.c(r100);
        goto L3
    L20:
        this.extra = am3.h.c(r100);
        goto L3
    L21:
        this.priority = r100.j();
        r103 = r103 | 4;
        goto L3
    L22:
        this.validTime = r100.j();
        r103 = r103 | 2;
        goto L3
    L23:
        this.tabType = r100.j();
        r103 = r103 | 1;
        goto L3
    L24:
        this.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L25:
        r100.d(r102);
        if ((r103 & 1) != 0) goto L29;
        this.tabType = -1;
    L29:
        if ((r103 & 2) != 0) goto L32;
        this.validTime = -1;
    L32:
        if ((r103 & 4) != 0) goto L35;
        this.priority = -1;
    L35:
        if ((r103 & 8) != 0) goto L38;
        this.tabItemId = -1;
    L38:
        if ((r103 & 16) != 0) goto L41;
        this.entranceType = -1;
    L41:
        if ((r103 & 32) != 0) goto L44;
        this.shortTopicId = -1;
    L44:
        if ((r103 & 64) != 0) goto L87;
        this.topicId = -1;
        return;
    }

    public final void p(String r100) {
        this.eventExtra = r100;
    }

    public final void q(String r100) {
        this.extra = r100;
    }

    public final void r(String r100) {
        this.guideType = r100;
    }

    public final void s(String r100) {
        this.name = r100;
    }

    public final void t(long r100) {
        this.priority = r100;
    }

    public final void x(long r100) {
        this.tabType = r100;
    }

    public final void y(long r100) {
        this.validTime = r100;
    }
}
