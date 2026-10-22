package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/view/h9;", "", "<init>", "()V", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "", "overlayOverlapPx", "expandedSafeAreaPx", "minifiedSafeAreaPx", "chatBottomGapPx", "minifiedMaxOverlapPx", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/sheet/SheetSettleState;IIIII)I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.h9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2842h9 {
    public static final C2842h9 INSTANCE = new C2842h9();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.h9$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetSettleState.values().length];
            try {
                iArr[SheetSettleState.HALF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetSettleState.FULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final int a(SheetSettleState state, int overlayOverlapPx, int expandedSafeAreaPx, int minifiedSafeAreaPx, int chatBottomGapPx, int minifiedMaxOverlapPx) {
        kotlin.jvm.internal.p.i(state, "state");
        int i10 = expandedSafeAreaPx + overlayOverlapPx + chatBottomGapPx;
        int iJ = C5685n.j(overlayOverlapPx, minifiedMaxOverlapPx) + minifiedSafeAreaPx + chatBottomGapPx;
        int i11 = a.$EnumSwitchMapping$0[state.ordinal()];
        return (i11 == 1 || i11 == 2) ? i10 : iJ;
    }
}
