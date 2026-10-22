package com.stepos.ailauncher.sheet.nav;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/d;", "", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "k", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "", "fraction", Const.INTENT_KEY_UMID, "(F)V", "progress", "f", "", "visible", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Z)V", "keyboardVisible", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lkotlin/Function0;", "proceed", "l", "(Lp9/a;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "showsSheetDragHandle", "c", "supportsSheetHalfSettle", "e", "extendsContentToBottomEdge", "m", "hidesResidentInput", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface d {
    default boolean c() {
        return true;
    }

    default void d(float fraction) {
    }

    default boolean e() {
        return false;
    }

    default void f(float progress) {
    }

    default void g(boolean visible) {
    }

    default void h(boolean keyboardVisible) {
    }

    default boolean j() {
        return true;
    }

    default void k(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
    }

    default boolean l(InterfaceC5063a<t> proceed) {
        kotlin.jvm.internal.p.i(proceed, "proceed");
        return false;
    }

    default boolean m() {
        return false;
    }
}
