package com.bytedance.android.livehostapi.business.castscreen.bean;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR:\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nj\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastDanmakuSetting;", "", "()V", "danmakuArea", "", "getDanmakuArea", "()I", "setDanmakuArea", "(I)V", "extras", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExtras", "()Ljava/util/HashMap;", "setExtras", "(Ljava/util/HashMap;)V", "fontAlpha", "", "getFontAlpha", "()F", "setFontAlpha", "(F)V", "fontSize", "getFontSize", "setFontSize", "toString", "Companion", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastDanmakuSetting {
    public static final Companion Companion = null;
    public static final int DANMAKU_AREA_ALL = 3;
    public static final int DANMAKU_AREA_CLOSE = 0;
    public static final int DANMAKU_AREA_HALF = 2;
    public static final int DANMAKU_AREA_TOP = 1;
    public static final int DANMAKU_FONT_BIG = 0;
    public static final int DANMAKU_FONT_MIDDLE = 1;
    public static final int DANMAKU_FONT_SMALL = 2;
    private int danmakuArea;
    private HashMap<String, Object> extras;
    private float fontAlpha;
    private int fontSize;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastDanmakuSetting$Companion;", "", "()V", "DANMAKU_AREA_ALL", "", "DANMAKU_AREA_CLOSE", "DANMAKU_AREA_HALF", "DANMAKU_AREA_TOP", "DANMAKU_FONT_BIG", "DANMAKU_FONT_MIDDLE", "DANMAKU_FONT_SMALL", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public String toString() {
        return "LiveCastDanmakuSetting(danmakuArea=" + this.danmakuArea + ", fontSize=" + this.fontSize + ", fontAlpha=" + this.fontAlpha + ", extras=" + this.extras + ')';
    }

    public LiveCastDanmakuSetting() {
        this.fontAlpha = 100.0f;
        this.extras = new HashMap();
    }

    public final int getDanmakuArea() {
        return this.danmakuArea;
    }

    public final HashMap<String, Object> getExtras() {
        return this.extras;
    }

    public final float getFontAlpha() {
        return this.fontAlpha;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final void setDanmakuArea(int r100) {
        this.danmakuArea = r100;
    }

    public final void setExtras(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extras = r100;
    }

    public final void setFontAlpha(float r100) {
        this.fontAlpha = r100;
    }

    public final void setFontSize(int r100) {
        this.fontSize = r100;
    }
}
