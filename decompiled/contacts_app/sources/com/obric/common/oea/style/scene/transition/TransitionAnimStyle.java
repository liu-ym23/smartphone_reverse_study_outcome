package com.obric.common.oea.style.scene.transition;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: TransitionAnimHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/common/oea/style/scene/transition/TransitionAnimStyle;", "", "(Ljava/lang/String;I)V", "SubpageInOut", "SettingsInOut", "Standard", "Modal", "Search", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum TransitionAnimStyle extends Enum<TransitionAnimStyle> {
    private static final /* synthetic */ TransitionAnimStyle[] $VALUES = null;
    public static final TransitionAnimStyle Modal = null;
    public static final TransitionAnimStyle Search = null;

    @Deprecated(message = "请使用 Modal")
    public static final TransitionAnimStyle SettingsInOut = null;
    public static final TransitionAnimStyle Standard = null;

    @Deprecated(message = "请使用 Standard")
    public static final TransitionAnimStyle SubpageInOut = null;

    static {
        TransitionAnimStyle r1 = new TransitionAnimStyle("SubpageInOut", 0);
        SubpageInOut = r1;
        TransitionAnimStyle r2 = new TransitionAnimStyle("SettingsInOut", 1);
        SettingsInOut = r2;
        TransitionAnimStyle r3 = new TransitionAnimStyle("Standard", 2);
        Standard = r3;
        TransitionAnimStyle r4 = new TransitionAnimStyle("Modal", 3);
        Modal = r4;
        TransitionAnimStyle r5 = new TransitionAnimStyle("Search", 4);
        Search = r5;
        $VALUES = new TransitionAnimStyle[]{r1, r2, r3, r4, r5};
    }

    public static TransitionAnimStyle valueOf(String r1) {
        return (TransitionAnimStyle) Enum.valueOf(TransitionAnimStyle.class, r1);
    }

    public static TransitionAnimStyle[] values() {
        return (TransitionAnimStyle[]) $VALUES.clone();
    }

    private TransitionAnimStyle(String r1, int r2) {
        super(r1, r2);
    }
}
