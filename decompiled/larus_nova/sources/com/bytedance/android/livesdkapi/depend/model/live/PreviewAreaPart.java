package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewExtendAreaSyncData.Part")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR \u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewAreaPart;", "", "()V", CommodityText.BOLD, "", "getBold", "()Ljava/lang/Boolean;", "setBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "cuttable", "getCuttable", "()Z", "setCuttable", "(Z)V", "deleted", "getDeleted", "setDeleted", "fontColor", "", "getFontColor", "()Ljava/lang/String;", "setFontColor", "(Ljava/lang/String;)V", "fontSize", "", "getFontSize", "()Ljava/lang/Integer;", "setFontSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", VideoThumbInfo.KEY_INTERVAL, "getInterval", "setInterval", "text", "getText", "setText", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewAreaPart implements h {

    @SerializedName(CommodityText.BOLD)
    protected Boolean bold;

    @SerializedName("cuttable")
    protected boolean cuttable;

    @SerializedName("deleted")
    protected boolean deleted;

    @SerializedName("font_color")
    protected String fontColor;

    @SerializedName("fontSize")
    protected Integer fontSize;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    protected Integer interval;

    @SerializedName("text")
    protected String text;

    public PreviewAreaPart() {
        this.fontSize = 0;
        this.interval = 0;
        this.bold = Boolean.FALSE;
    }

    public final Boolean getBold() {
        return this.bold;
    }

    public final boolean getCuttable() {
        return this.cuttable;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    public final String getFontColor() {
        return this.fontColor;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final String getText() {
        return this.text;
    }

    public PreviewAreaPart(g r100) {
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
        this.bold = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        this.fontColor = am3.h.c(r100);
        goto L3
    L9:
        this.deleted = am3.h.a(r100);
        goto L3
    L10:
        this.cuttable = am3.h.a(r100);
        goto L3
    L11:
        this.text = am3.h.c(r100);
        goto L3
    L12:
        this.interval = Integer.valueOf(r100.i());
        goto L3
    L13:
        this.fontSize = Integer.valueOf(r100.i());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.fontSize != null) goto L18;
        this.fontSize = 0;
    L18:
        if (this.interval != null) goto L21;
        this.interval = 0;
    L21:
        if (this.bold != null) goto L42;
        this.bold = Boolean.FALSE;
        return;
    }

    public final void setBold(Boolean r100) {
        this.bold = r100;
    }

    public final void setCuttable(boolean r100) {
        this.cuttable = r100;
    }

    public final void setDeleted(boolean r100) {
        this.deleted = r100;
    }

    public final void setFontColor(String r100) {
        this.fontColor = r100;
    }

    public final void setFontSize(Integer r100) {
        this.fontSize = r100;
    }

    public final void setInterval(Integer r100) {
        this.interval = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
