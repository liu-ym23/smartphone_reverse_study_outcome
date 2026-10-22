package com.stepos.launcher.assistant.slidepanel;

import A7.C0743k;
import A7.C0746n;
import A7.L;
import A7.Z;
import Z8.F;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import y7.B;
import y7.E;
import y7.G;
import y7.H;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJG\u0010!\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b!\u0010\"JE\u0010&\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010)R\u0014\u0010.\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00102\u001a\u00020-8\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010/R\u0014\u00103\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020#8\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/stepos/launcher/assistant/slidepanel/PillGlassMaterialHelper;", "", "<init>", "()V", "", "debugEnabled", "()Z", "Landroid/view/View;", "host", "allowHidden", "isHostReady", "(Landroid/view/View;Z)Z", "", "progress", "restAtFullyOpen", "Lcom/stepos/launcher/assistant/slidepanel/PillGlassMaterialHelper$Mode;", "resolveMode", "(Landroid/view/View;FZZ)Lcom/stepos/launcher/assistant/slidepanel/PillGlassMaterialHelper$Mode;", "isEffectivelyShown", "(Landroid/view/View;)Z", "cornerRadiusPx", "", "logTag", "innerShadowRadiusDp", "Ly7/E;", "applyGlass", "(Landroid/view/View;FLjava/lang/String;F)Ly7/E;", "LY8/t;", "softRefreshBackdrop", "(Landroid/view/View;)V", "action", "mode", "handle", "logGlassState", "(Ljava/lang/String;Ljava/lang/String;FZLcom/stepos/launcher/assistant/slidepanel/PillGlassMaterialHelper$Mode;Landroid/view/View;Ly7/E;)V", "", M5.b.CREDENTIAL_TOKEN, "phase", "logRestGlass", "(Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;Ly7/E;)V", "TAG", "Ljava/lang/String;", "DEBUG", "Z", "DEBUG_PROPERTY", "", "REST_GLASS_REFRESH_DELAY_MS", "J", "REST_GLASS_SECOND_REFRESH_DELAY_MS", "INDICATOR_REVEAL_FADE_MS", "DEFER_REVEAL_TIMEOUT_MS", "DESKTOP_PILL_INNER_SHADOW_RADIUS_DP", "F", "DESKTOP_PILL_BLEND0_INTENSITY_PCT", "I", "Mode", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PillGlassMaterialHelper {
    public static final boolean DEBUG = false;
    private static final String DEBUG_PROPERTY = "persist.sys.launcher.pill_glass_log";
    public static final long DEFER_REVEAL_TIMEOUT_MS = 400;
    public static final int DESKTOP_PILL_BLEND0_INTENSITY_PCT = 6;
    public static final float DESKTOP_PILL_INNER_SHADOW_RADIUS_DP = 10.0f;
    public static final long INDICATOR_REVEAL_FADE_MS = 180;
    public static final PillGlassMaterialHelper INSTANCE = new PillGlassMaterialHelper();
    public static final long REST_GLASS_REFRESH_DELAY_MS = 280;
    public static final long REST_GLASS_SECOND_REFRESH_DELAY_MS = 380;
    private static final String TAG = "PillGlassDbg";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/launcher/assistant/slidepanel/PillGlassMaterialHelper$Mode;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "GLASS", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode NONE = new Mode(ModelFlowMeta.PLAN_NONE, 0);
        public static final Mode GLASS = new Mode("GLASS", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{NONE, GLASS};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = kotlin.enums.a.a(modeArr$values);
        }

        private Mode(String str, int i10) {
        }

        public static InterfaceC4149a<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    private PillGlassMaterialHelper() {
    }

    public static /* synthetic */ E applyGlass$default(PillGlassMaterialHelper pillGlassMaterialHelper, View view, float f10, String str, float f11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            f11 = -1.0f;
        }
        return pillGlassMaterialHelper.applyGlass(view, f10, str, f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyGlass$lambda$0(C0746n c0746n, C0746n apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.n(c0746n.getRadius());
        apply.o(c0746n.getTintColor());
        apply.l(c0746n.getFrost());
        apply.m(c0746n.getOverlay());
        apply.k(c0746n.getBlendColor());
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyGlass$lambda$1(Z z10, Z apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.B(true);
        apply.J(z10.getWidth());
        apply.w(z10.getColor());
        apply.H(z10.getSoftness());
        apply.C(z10.getIntensity());
        apply.I(z10.getSpread());
        apply.D(z10.getLight0X());
        apply.E(z10.getLight0Y());
        apply.F(z10.getLight1X());
        apply.G(z10.getLight1Y());
        apply.u(z10.getAmbient());
        apply.v(z10.getAnisotropicRim());
        apply.z(z10.getEdgeColor());
        apply.x(z10.getDarkColor());
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyGlass$lambda$2(L l10, L apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.l(true);
        apply.k(l10.getColor());
        apply.p(l10.getRadius());
        apply.n(l10.getOffsetX());
        apply.o(l10.getOffsetY());
        apply.m(l10.getIntensity());
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t applyGlass$lambda$3(List list, C0743k apply) {
        kotlin.jvm.internal.p.i(apply, "$this$apply");
        apply.f(list);
        return Y8.t.f7040a;
    }

    private final boolean debugEnabled() {
        return SystemProperties.getBoolean(DEBUG_PROPERTY, false);
    }

    public static /* synthetic */ boolean isHostReady$default(PillGlassMaterialHelper pillGlassMaterialHelper, View view, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return pillGlassMaterialHelper.isHostReady(view, z10);
    }

    public static /* synthetic */ void logRestGlass$default(PillGlassMaterialHelper pillGlassMaterialHelper, String str, String str2, int i10, float f10, String str3, E e10, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str3 = null;
        }
        if ((i11 & 32) != 0) {
            e10 = null;
        }
        pillGlassMaterialHelper.logRestGlass(str, str2, i10, f10, str3, e10);
    }

    public static /* synthetic */ Mode resolveMode$default(PillGlassMaterialHelper pillGlassMaterialHelper, View view, float f10, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return pillGlassMaterialHelper.resolveMode(view, f10, z10, z11);
    }

    public final E applyGlass(View host, float cornerRadiusPx, String logTag, float innerShadowRadiusDp) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(logTag, "logTag");
        float f10 = host.getResources().getDisplayMetrics().density;
        y7.o oVarI = y7.o.INSTANCE.i();
        final C0746n c0746nD = oVarI.D(f10);
        final Z zG = oVarI.G(f10);
        final L lE = oVarI.E(f10);
        if (innerShadowRadiusDp >= 0.0f) {
            lE.p(innerShadowRadiusDp * f10);
        }
        C0743k c0743kC = oVarI.C(f10);
        B bW = H.a(s7.p.f40121a, host).x(true).w(cornerRadiusPx);
        G g10 = G.f43879a;
        B bJ = bW.j(g10.b(), new InterfaceC5074l() { // from class: com.stepos.launcher.assistant.slidepanel.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PillGlassMaterialHelper.applyGlass$lambda$0(c0746nD, (C0746n) obj);
            }
        });
        if (zG.getX5.d.EXTRA_ENABLED java.lang.String()) {
            bJ = bJ.j(g10.f(), new InterfaceC5074l() { // from class: com.stepos.launcher.assistant.slidepanel.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return PillGlassMaterialHelper.applyGlass$lambda$1(zG, (Z) obj);
                }
            });
        }
        if (lE.getX5.d.EXTRA_ENABLED java.lang.String()) {
            bJ = bJ.j(g10.d(), new InterfaceC5074l() { // from class: com.stepos.launcher.assistant.slidepanel.n
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return PillGlassMaterialHelper.applyGlass$lambda$2(lE, (L) obj);
                }
            });
        }
        final List listP1 = F.p1(c0743kC.e());
        if (!listP1.isEmpty()) {
            Pair pair = (Pair) listP1.get(0);
            listP1.set(0, Pair.d(pair, null, Integer.valueOf((((Number) pair.f()).intValue() & 16777215) | 251658240), 1, null));
            bJ = bJ.j(g10.a(), new InterfaceC5074l() { // from class: com.stepos.launcher.assistant.slidepanel.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return PillGlassMaterialHelper.applyGlass$lambda$3(listP1, (C0743k) obj);
                }
            });
        }
        E eU = bJ.u();
        if (debugEnabled()) {
            Log.d(TAG, logTag + " applyGlass activeCount=" + (eU != null ? Integer.valueOf(eU.c()) : null) + " ids=" + (eU != null ? eU.d() : null) + " corner=" + cornerRadiusPx + " host=" + host);
        }
        return eU;
    }

    public final boolean isEffectivelyShown(View host) {
        kotlin.jvm.internal.p.i(host, "host");
        while (host != null) {
            if (host.getVisibility() != 0 || host.getAlpha() <= 0.0f) {
                return false;
            }
            Object parent = host.getParent();
            host = parent instanceof View ? (View) parent : null;
        }
        return true;
    }

    public final boolean isHostReady(View host, boolean allowHidden) {
        kotlin.jvm.internal.p.i(host, "host");
        if (!host.isAttachedToWindow() || host.getVisibility() != 0 || host.getWidth() <= 0 || host.getHeight() <= 0) {
            return false;
        }
        return allowHidden || host.getAlpha() > 0.0f;
    }

    public final void logGlassState(String logTag, String action, float progress, boolean restAtFullyOpen, Mode mode, View host, E handle) {
        kotlin.jvm.internal.p.i(logTag, "logTag");
        kotlin.jvm.internal.p.i(action, "action");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(host, "host");
        if (debugEnabled()) {
            Log.d(TAG, logTag + " " + action + " progress=" + progress + " restAtFullyOpen=" + restAtFullyOpen + " mode=" + mode + " visible=" + host.getVisibility() + " alpha=" + host.getAlpha() + " activeCount=" + (handle != null ? Integer.valueOf(handle.c()) : null) + " ids=" + (handle != null ? handle.d() : null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void logRestGlass(java.lang.String r4, java.lang.String r5, int r6, float r7, java.lang.String r8, y7.E r9) {
        /*
            r3 = this;
            java.lang.String r0 = "logTag"
            kotlin.jvm.internal.p.i(r4, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.p.i(r5, r0)
            boolean r3 = r3.debugEnabled()
            if (r3 != 0) goto L11
            return
        L11:
            java.lang.String r3 = ""
            if (r8 == 0) goto L28
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " phase="
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            if (r8 != 0) goto L29
        L28:
            r8 = r3
        L29:
            if (r9 == 0) goto L50
            int r0 = r9.c()
            java.util.List r9 = r9.d()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " activeCount="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " ids="
            r1.append(r0)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            if (r9 != 0) goto L4f
            goto L50
        L4f:
            r3 = r9
        L50:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            java.lang.String r4 = " restGlass "
            r9.append(r4)
            r9.append(r5)
            java.lang.String r4 = " token="
            r9.append(r4)
            r9.append(r6)
            java.lang.String r4 = " progress="
            r9.append(r4)
            r9.append(r7)
            r9.append(r8)
            r9.append(r3)
            java.lang.String r3 = r9.toString()
            java.lang.String r4 = "PillGlassDbg"
            android.util.Log.d(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.launcher.assistant.slidepanel.PillGlassMaterialHelper.logRestGlass(java.lang.String, java.lang.String, int, float, java.lang.String, y7.E):void");
    }

    public final Mode resolveMode(View host, float progress, boolean restAtFullyOpen, boolean allowHidden) {
        kotlin.jvm.internal.p.i(host, "host");
        return !isHostReady(host, allowHidden) ? Mode.NONE : restAtFullyOpen ? OverlayIndicatorState.isOverlayGlassRestProgress(progress) ? Mode.GLASS : (OverlayIndicatorState.isTransitionProgress(progress) && OverlayIndicatorState.isOverlayPillHandoffOwner(progress)) ? Mode.GLASS : Mode.NONE : OverlayIndicatorState.isLauncherGlassRestProgress(progress) ? Mode.GLASS : (OverlayIndicatorState.isTransitionProgress(progress) && OverlayIndicatorState.isLauncherPillHandoffOwner(progress)) ? Mode.GLASS : Mode.NONE;
    }

    public final void softRefreshBackdrop(View host) {
        kotlin.jvm.internal.p.i(host, "host");
        host.invalidate();
    }
}
