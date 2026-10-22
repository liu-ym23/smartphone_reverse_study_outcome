package com.obric.common.oea.style.scene.transition;

import kotlin.Deprecated;
import kotlin.Metadata;

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
        TransitionAnimStyle r10 = new TransitionAnimStyle("SubpageInOut", 0);
        SubpageInOut = r10;
        TransitionAnimStyle r11 = new TransitionAnimStyle("SettingsInOut", 1);
        SettingsInOut = r11;
        TransitionAnimStyle r12 = new TransitionAnimStyle("Standard", 2);
        Standard = r12;
        TransitionAnimStyle r13 = new TransitionAnimStyle("Modal", 3);
        Modal = r13;
        TransitionAnimStyle r14 = new TransitionAnimStyle("Search", 4);
        Search = r14;
        $VALUES = new TransitionAnimStyle[]{r10, r11, r12, r13, r14};
    }

    private TransitionAnimStyle(String r10, int r11) {
        super(r10, r11);
    }

    public static TransitionAnimStyle valueOf(String r10) {
        return (TransitionAnimStyle) Enum.valueOf(TransitionAnimStyle.class, r10);
    }

    public static TransitionAnimStyle[] values() {
        return (TransitionAnimStyle[]) $VALUES.clone();
    }
}
