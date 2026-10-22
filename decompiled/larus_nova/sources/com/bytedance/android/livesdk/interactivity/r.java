package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f140572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f140573b = null;

    static {
        int[] r100 = new int[PanelItemShowArea.values().length];
        f140572a = r100;
        r100[PanelItemShowArea.TOP.ordinal()] = 1;
        r100[PanelItemShowArea.MIDDLE.ordinal()] = 2;
        r100[PanelItemShowArea.BOTTOM.ordinal()] = 3;
        int[] r101 = new int[PanelItemSymbol.values().length];
        f140573b = r101;
        r101[PanelItemSymbol.PIN_COMMENT_SYMBOL.ordinal()] = 1;
        r101[PanelItemSymbol.OPEN_PROFILE_SYMBOL.ordinal()] = 2;
        r101[PanelItemSymbol.SECRET_CHAT.ordinal()] = 3;
        r101[PanelItemSymbol.REPLY.ordinal()] = 4;
        r101[PanelItemSymbol.REPLY_AND_PIN_SYMBOL.ordinal()] = 5;
        r101[PanelItemSymbol.OPEN_VIDEO_SYMBOL.ordinal()] = 6;
        r101[PanelItemSymbol.OPEN_MICROAPP_SYMBOL.ordinal()] = 7;
        r101[PanelItemSymbol.LINK_MIC.ordinal()] = 8;
        r101[PanelItemSymbol.PIN_ROOMMESSAGE.ordinal()] = 9;
        r101[PanelItemSymbol.MARK_USER.ordinal()] = 10;
        r101[PanelItemSymbol.PUBLIC_SCREEN_STYLE_SYMBOL.ordinal()] = 11;
        r101[PanelItemSymbol.COMMENT_CONTROL_MODE.ordinal()] = 12;
        r101[PanelItemSymbol.CREATE_CHAT_CHANNEL.ordinal()] = 13;
        r101[PanelItemSymbol.PUBLIC_SCREEN_HELPER.ordinal()] = 14;
    }
}
