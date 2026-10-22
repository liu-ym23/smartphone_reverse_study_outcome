package com.bytedance.android.livesdkapi.depend.model;

import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/FloatWindowBusinessLine;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Ecom", EffectTypeConstants.TYPE_GAME, "Life", "Applet", "MoreAnchor", "PaidLive", "Windmill", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FloatWindowBusinessLine extends Enum<FloatWindowBusinessLine> {
    private static final /* synthetic */ FloatWindowBusinessLine[] $VALUES = null;
    public static final FloatWindowBusinessLine Applet = null;
    public static final FloatWindowBusinessLine Ecom = null;
    public static final FloatWindowBusinessLine Game = null;
    public static final FloatWindowBusinessLine Life = null;
    public static final FloatWindowBusinessLine MoreAnchor = null;
    public static final FloatWindowBusinessLine PaidLive = null;
    public static final FloatWindowBusinessLine Windmill = null;
    private final String value;

    static {
        FloatWindowBusinessLine r100 = new FloatWindowBusinessLine("Ecom", 0, "ecom");
        Ecom = r100;
        FloatWindowBusinessLine r101 = new FloatWindowBusinessLine(EffectTypeConstants.TYPE_GAME, 1, "game");
        Game = r101;
        FloatWindowBusinessLine r102 = new FloatWindowBusinessLine("Life", 2, "life");
        Life = r102;
        FloatWindowBusinessLine r103 = new FloatWindowBusinessLine("Applet", 3, "applet");
        Applet = r103;
        FloatWindowBusinessLine r104 = new FloatWindowBusinessLine("MoreAnchor", 4, "MoreAnchor");
        MoreAnchor = r104;
        FloatWindowBusinessLine r105 = new FloatWindowBusinessLine("PaidLive", 5, "Paidlive");
        PaidLive = r105;
        FloatWindowBusinessLine r106 = new FloatWindowBusinessLine("Windmill", 6, "Windmill");
        Windmill = r106;
        $VALUES = new FloatWindowBusinessLine[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static FloatWindowBusinessLine valueOf(String r100) {
        return (FloatWindowBusinessLine) a.a(FloatWindowBusinessLine.class, r100);
    }

    public static FloatWindowBusinessLine[] values() {
        return (FloatWindowBusinessLine[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    private FloatWindowBusinessLine(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
