package com.bytedance.applet.impl;

import com.bytedance.ai.applet.components.input.AppletChatActionBarCapability;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.business.floatchat.api.AIChatActionBarCapability;
import com.larus.business.floatchat.api.AIChatActionBarItemLocation;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191933a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f191934b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f191935c = null;

        static {
            int[] r100 = new int[FloatChatWindowState.values().length];
            r100[FloatChatWindowState.Collapsed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[FloatChatWindowState.Preview.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L37:
            r100[FloatChatWindowState.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            f191933a = r100;
            int[] r101 = new int[AIChatActionBarItemLocation.values().length];
            r101[AIChatActionBarItemLocation.PRIMARY_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L31:
            r101[AIChatActionBarItemLocation.DETAIL_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L11:
            f191934b = r101;
            int[] r102 = new int[AppletChatActionBarCapability.values().length];
            r102[AppletChatActionBarCapability.OPEN_CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L33:
            r102[AppletChatActionBarCapability.MUSIC_GENERATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L25:
            r102[AppletChatActionBarCapability.IMAGE_GENERATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L15:
            f191935c = r102;
        }
    }

    public static final dw8.b a(r2.a r100) {
        if ((r100 instanceof r2.a.c) == false) goto L6;
        return new dw8.b.c(((r2.a.c) r100).f535692a);
    L6:
        if ((r100 instanceof r2.a.b) == false) goto L9;
        return new dw8.b.C5717b(((r2.a.b) r100).f535691a);
    L9:
        if ((r100 instanceof r2.a.C7424a) == false) goto L24;
        AppletChatActionBarCapability r101 = ((r2.a.C7424a) r100).f535690a;
        int r102 = a.f191935c[r101.ordinal()];
        if (r102 != 1) goto L13;
        AIChatActionBarCapability r103 = AIChatActionBarCapability.OPEN_CAMERA;
    L22:
        return new dw8.b.a(r103);
    L13:
        if (r102 != 2) goto L15;
        r103 = AIChatActionBarCapability.MUSIC_GENERATION;
        goto L22
    L15:
        if (r102 != 3) goto L18;
        r103 = AIChatActionBarCapability.IMAGE_GENERATION;
        goto L22
    L18:
        throw new NoWhenBranchMatchedException();
    L24:
        throw new NoWhenBranchMatchedException();
    }
}
