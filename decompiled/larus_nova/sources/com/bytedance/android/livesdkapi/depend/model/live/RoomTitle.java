package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSTitleIcon;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomTitle")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020\nR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomTitle;", "", "()V", "introduction", "", "getIntroduction", "()Ljava/lang/String;", "setIntroduction", "(Ljava/lang/String;)V", "landscapeShow", "", "getLandscapeShow", "()Z", "setLandscapeShow", "(Z)V", "leftIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSTitleIcon;", "getLeftIcon", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSTitleIcon;", "setLeftIcon", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSTitleIcon;)V", "leftPeriod", "getLeftPeriod", "setLeftPeriod", "leftTag", "", "getLeftTag", "()J", "setLeftTag", "(J)V", "leftToast", "getLeftToast", "setLeftToast", "portraitShow", "getPortraitShow", "setPortraitShow", "title", "getTitle", d.f25925o, "uiType", "", "getUiType", "()I", "setUiType", "(I)V", "isGameUIStyle", "RoomTitleTag", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomTitle implements h {

    @SerializedName("introduction")
    protected String introduction;

    @SerializedName("landscape_show")
    protected boolean landscapeShow;

    @SerializedName("left_icon")
    protected VSTitleIcon leftIcon;

    @SerializedName("left_period")
    protected String leftPeriod;

    @SerializedName("left_tag")
    protected long leftTag;

    @SerializedName("left_toast")
    protected String leftToast;

    @SerializedName("portrait_show")
    protected boolean portraitShow;

    @SerializedName("title")
    protected String title;

    @SerializedName("ui_type")
    protected int uiType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomTitle$RoomTitleTag;", "", "type", "", "(Ljava/lang/String;IJ)V", "getType", "()J", "RoomTitleTagDefault", "RoomTitleTagVSPremiere", "RoomTitleTagVSLive", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RoomTitleTag extends Enum<RoomTitleTag> {
        private static final /* synthetic */ RoomTitleTag[] $VALUES = null;
        public static final RoomTitleTag RoomTitleTagDefault = null;
        public static final RoomTitleTag RoomTitleTagVSLive = null;
        public static final RoomTitleTag RoomTitleTagVSPremiere = null;
        private final long type;

        static {
            RoomTitleTag r100 = new RoomTitleTag("RoomTitleTagDefault", 0, 0);
            RoomTitleTagDefault = r100;
            RoomTitleTag r101 = new RoomTitleTag("RoomTitleTagVSPremiere", 1, 1);
            RoomTitleTagVSPremiere = r101;
            RoomTitleTag r102 = new RoomTitleTag("RoomTitleTagVSLive", 2, 2);
            RoomTitleTagVSLive = r102;
            $VALUES = new RoomTitleTag[]{r100, r101, r102};
        }

        public static RoomTitleTag valueOf(String r100) {
            return (RoomTitleTag) a.a(RoomTitleTag.class, r100);
        }

        public static RoomTitleTag[] values() {
            return (RoomTitleTag[]) $VALUES.clone();
        }

        public final long getType() {
            return this.type;
        }

        private RoomTitleTag(String r100, int r101, long r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public RoomTitle() {
    }

    public final boolean isGameUIStyle() {
        if (this.uiType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String getIntroduction() {
        return this.introduction;
    }

    public final boolean getLandscapeShow() {
        return this.landscapeShow;
    }

    public final VSTitleIcon getLeftIcon() {
        return this.leftIcon;
    }

    public final String getLeftPeriod() {
        return this.leftPeriod;
    }

    public final long getLeftTag() {
        return this.leftTag;
    }

    public final String getLeftToast() {
        return this.leftToast;
    }

    public final boolean getPortraitShow() {
        return this.portraitShow;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public RoomTitle(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.landscapeShow = am3.h.a(r100);
        goto L3
    L8:
        this.portraitShow = am3.h.a(r100);
        goto L3
    L9:
        this.uiType = r100.i();
        goto L3
    L10:
        this.leftIcon = new VSTitleIcon(r100);
        goto L3
    L11:
        this.leftToast = am3.h.c(r100);
        goto L3
    L12:
        this.leftPeriod = am3.h.c(r100);
        goto L3
    L13:
        this.leftTag = r100.j();
        goto L3
    L14:
        this.introduction = am3.h.c(r100);
        goto L3
    L15:
        this.title = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }

    public final void setIntroduction(String r100) {
        this.introduction = r100;
    }

    public final void setLandscapeShow(boolean r100) {
        this.landscapeShow = r100;
    }

    public final void setLeftIcon(VSTitleIcon r100) {
        this.leftIcon = r100;
    }

    public final void setLeftPeriod(String r100) {
        this.leftPeriod = r100;
    }

    public final void setLeftTag(long r100) {
        this.leftTag = r100;
    }

    public final void setLeftToast(String r100) {
        this.leftToast = r100;
    }

    public final void setPortraitShow(boolean r100) {
        this.portraitShow = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUiType(int r100) {
        this.uiType = r100;
    }
}
