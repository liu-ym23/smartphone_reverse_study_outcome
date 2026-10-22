package com.stepos.ailauncher.migu.play;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.migu.play.MiguInstallState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u000f\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/migu/play/c;", "", "<init>", "()V", "", "installed", "Lcom/stepos/ailauncher/migu/play/MiguInstallState$Phase;", "installPhase", "loggedIn", "Lcom/stepos/ailauncher/migu/play/MiguBindPhase;", "bindPhase", "sdkAuthorized", "Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "lastKnown", "ipcReady", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Boolean;Lcom/stepos/ailauncher/migu/play/MiguInstallState$Phase;Ljava/lang/Boolean;Lcom/stepos/ailauncher/migu/play/MiguBindPhase;ZLcom/stepos/ailauncher/migu/play/MiguCardSurface;Z)Lcom/stepos/ailauncher/migu/play/MiguCardSurface;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.migu.play.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3355c {
    public static final C3355c INSTANCE = new C3355c();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.migu.play.c$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MiguInstallState.Phase.values().length];
            try {
                iArr[MiguInstallState.Phase.INSTALLING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MiguInstallState.Phase.AWAITING_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MiguBindPhase.values().length];
            try {
                iArr2[MiguBindPhase.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MiguBindPhase.BOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MiguBindPhase.IDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MiguBindPhase.BINDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final MiguCardSurface a(Boolean installed, MiguInstallState.Phase installPhase, Boolean loggedIn, MiguBindPhase bindPhase, boolean sdkAuthorized, MiguCardSurface lastKnown, boolean ipcReady) {
        int i10;
        kotlin.jvm.internal.p.i(installPhase, "installPhase");
        kotlin.jvm.internal.p.i(bindPhase, "bindPhase");
        int i11 = a.$EnumSwitchMapping$0[installPhase.ordinal()];
        if (i11 == 1) {
            return MiguCardSurface.DOWNLOADING;
        }
        if (i11 == 2) {
            return MiguCardSurface.DONE;
        }
        Boolean bool = Boolean.FALSE;
        if (kotlin.jvm.internal.p.d(installed, bool)) {
            return MiguCardSurface.INSTALL;
        }
        if (kotlin.jvm.internal.p.d(loggedIn, bool)) {
            return MiguCardSurface.LOGIN;
        }
        if (kotlin.jvm.internal.p.d(loggedIn, Boolean.TRUE)) {
            return MiguCardSurface.PLAYLIST;
        }
        if (bindPhase == MiguBindPhase.BOUND && !ipcReady) {
            bindPhase = MiguBindPhase.BINDING;
        }
        MiguCardSurface miguCardSurface = lastKnown == null ? MiguCardSurface.PLAYLIST : lastKnown;
        if (!sdkAuthorized || (i10 = a.$EnumSwitchMapping$1[bindPhase.ordinal()]) == 1 || i10 == 2) {
            return miguCardSurface;
        }
        if (i10 == 3 || i10 == 4) {
            return lastKnown == null ? MiguCardSurface.HIDDEN : lastKnown;
        }
        throw new NoWhenBranchMatchedException();
    }
}
