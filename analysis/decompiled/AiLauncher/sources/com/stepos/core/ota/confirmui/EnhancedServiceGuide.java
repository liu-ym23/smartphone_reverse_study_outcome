package com.stepos.core.ota.confirmui;

import android.content.Context;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R6\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0007\u0010\b\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/core/ota/confirmui/EnhancedServiceGuide;", "", "<init>", "()V", "Lkotlin/Function1;", "Landroid/content/Context;", "", "launcher", "Lp9/l;", "getLauncher", "()Lp9/l;", "setLauncher", "(Lp9/l;)V", "getLauncher$annotations", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EnhancedServiceGuide {
    public static final EnhancedServiceGuide INSTANCE = new EnhancedServiceGuide();
    private static volatile InterfaceC5074l<? super Context, Integer> launcher;

    private EnhancedServiceGuide() {
    }

    public static final InterfaceC5074l<Context, Integer> getLauncher() {
        return launcher;
    }

    public static /* synthetic */ void getLauncher$annotations() {
    }

    public static final void setLauncher(InterfaceC5074l<? super Context, Integer> interfaceC5074l) {
        launcher = interfaceC5074l;
    }
}
