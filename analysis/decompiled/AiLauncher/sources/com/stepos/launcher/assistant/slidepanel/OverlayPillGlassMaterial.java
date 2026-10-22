package com.stepos.launcher.assistant.slidepanel;

import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.stepos.launcher.assistant.slidepanel.PillGlassMaterialHelper;
import java.util.List;
import kotlin.Metadata;
import v9.C5685n;
import y7.E;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u0015\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u0010J\r\u0010\u001f\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010\u0010J\r\u0010 \u001a\u00020\u000e¢\u0006\u0004\b \u0010\u0010J\u0015\u0010#\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u000e¢\u0006\u0004\b%\u0010\u0010J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020&¢\u0006\u0004\b)\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00105\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010<R\u0014\u0010>\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010<¨\u0006@"}, d2 = {"Lcom/stepos/launcher/assistant/slidepanel/OverlayPillGlassMaterial;", "", "Landroid/view/View;", "host", "", "tag", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "", "effectiveCornerRadius", "()F", "Lcom/stepos/launcher/assistant/slidepanel/PillGlassMaterialHelper$Mode;", "currentMode", "()Lcom/stepos/launcher/assistant/slidepanel/PillGlassMaterialHelper$Mode;", "LY8/t;", "scheduleApplyMaterial", "()V", "scheduleRestGlassRefresh", "cancelRestGlassRefresh", "phase", "refreshBackdropAtOverlayRest", "(Ljava/lang/String;)V", "tryApplyMaterial", "applyMaterial", "releaseMaterial", "radiusPx", "setCornerRadiusPx", "(F)V", "progress", "setOverlayProgress", "attach", "detach", "onVisibilityChanged", "", "visibility", "onWindowVisibilityChanged", "(I)V", "onLayoutChanged", "", "hasActiveMaterial", "()Z", "shouldDrawFallbackBackground", "Landroid/view/View;", "Ljava/lang/String;", "Ly7/E;", "materialHandle", "Ly7/E;", "cornerRadiusPx", "F", "overlayProgress", "restGlassRefreshToken", "I", "scheduledRestGlassToken", "restGlassRefreshPending", "Z", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Ljava/lang/Runnable;", "applyMaterialRunnable", "Ljava/lang/Runnable;", "refreshRestGlassRunnable", "refreshRestGlassSecondRunnable", "Companion", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OverlayPillGlassMaterial {
    private static final int EXPECTED_GLASS_CAPABILITY_COUNT = 4;
    private final Runnable applyMaterialRunnable;
    private float cornerRadiusPx;
    private final View host;
    private E materialHandle;
    private float overlayProgress;
    private final ViewTreeObserver.OnPreDrawListener preDrawListener;
    private final Runnable refreshRestGlassRunnable;
    private final Runnable refreshRestGlassSecondRunnable;
    private boolean restGlassRefreshPending;
    private int restGlassRefreshToken;
    private int scheduledRestGlassToken;
    private final String tag;

    public OverlayPillGlassMaterial(View host, String tag) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(tag, "tag");
        this.host = host;
        this.tag = tag;
        this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.launcher.assistant.slidepanel.e
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return OverlayPillGlassMaterial.preDrawListener$lambda$0(this.f30140a);
            }
        };
        this.applyMaterialRunnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f30141a.tryApplyMaterial();
            }
        };
        this.refreshRestGlassRunnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.g
            @Override // java.lang.Runnable
            public final void run() {
                OverlayPillGlassMaterial.refreshRestGlassRunnable$lambda$0(this.f30142a);
            }
        };
        this.refreshRestGlassSecondRunnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.h
            @Override // java.lang.Runnable
            public final void run() {
                OverlayPillGlassMaterial.refreshRestGlassSecondRunnable$lambda$0(this.f30143a);
            }
        };
    }

    private final void applyMaterial() {
        PillGlassMaterialHelper pillGlassMaterialHelper = PillGlassMaterialHelper.INSTANCE;
        E eApplyGlass = pillGlassMaterialHelper.applyGlass(this.host, effectiveCornerRadius(), this.tag, 10.0f);
        if (eApplyGlass == null || eApplyGlass.c() == 0) {
            if (eApplyGlass != null) {
                eApplyGlass.g();
            }
            this.materialHandle = null;
            String str = this.tag;
            Integer numValueOf = eApplyGlass != null ? Integer.valueOf(eApplyGlass.c()) : null;
            List<String> listD = eApplyGlass != null ? eApplyGlass.d() : null;
            Log.w(str, "Overlay pill glass not applied: activeCount=" + numValueOf + ", activeIds=" + listD + ", progress=" + this.overlayProgress);
            return;
        }
        this.materialHandle = eApplyGlass;
        if (eApplyGlass.c() < 4) {
            Log.w(this.tag, "Overlay pill glass degraded: activeCount=" + eApplyGlass.c() + ", activeIds=" + eApplyGlass.d() + ", progress=" + this.overlayProgress);
        }
        pillGlassMaterialHelper.logGlassState(this.tag, "applied", this.overlayProgress, true, PillGlassMaterialHelper.Mode.GLASS, this.host, this.materialHandle);
    }

    private final void cancelRestGlassRefresh() {
        if (this.restGlassRefreshPending) {
            PillGlassMaterialHelper.logRestGlass$default(PillGlassMaterialHelper.INSTANCE, this.tag, "cancel", this.scheduledRestGlassToken, this.overlayProgress, null, null, 48, null);
        }
        this.restGlassRefreshPending = false;
        this.restGlassRefreshToken++;
        this.host.removeCallbacks(this.refreshRestGlassRunnable);
        this.host.removeCallbacks(this.refreshRestGlassSecondRunnable);
    }

    private final PillGlassMaterialHelper.Mode currentMode() {
        return PillGlassMaterialHelper.resolveMode$default(PillGlassMaterialHelper.INSTANCE, this.host, this.overlayProgress, true, false, 8, null);
    }

    private final float effectiveCornerRadius() {
        return this.host.getHeight() <= 0 ? this.cornerRadiusPx : Math.min(this.cornerRadiusPx, this.host.getHeight() / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean preDrawListener$lambda$0(OverlayPillGlassMaterial overlayPillGlassMaterial) {
        overlayPillGlassMaterial.tryApplyMaterial();
        return true;
    }

    private final void refreshBackdropAtOverlayRest(String phase) {
        if (!OverlayIndicatorState.isOverlayGlassRestProgress(this.overlayProgress)) {
            PillGlassMaterialHelper.logRestGlass$default(PillGlassMaterialHelper.INSTANCE, this.tag, "refresh-skip-not-rest", this.scheduledRestGlassToken, this.overlayProgress, phase, null, 32, null);
        } else if (hasActiveMaterial()) {
            this.host.invalidate();
            PillGlassMaterialHelper.INSTANCE.logRestGlass(this.tag, "soft-refresh", this.scheduledRestGlassToken, this.overlayProgress, phase, this.materialHandle);
        } else {
            applyMaterial();
            PillGlassMaterialHelper.INSTANCE.logRestGlass(this.tag, "apply-missing", this.scheduledRestGlassToken, this.overlayProgress, phase, this.materialHandle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRestGlassRunnable$lambda$0(OverlayPillGlassMaterial overlayPillGlassMaterial) {
        if (overlayPillGlassMaterial.scheduledRestGlassToken != overlayPillGlassMaterial.restGlassRefreshToken) {
            return;
        }
        overlayPillGlassMaterial.refreshBackdropAtOverlayRest(AMapLocationStaticsEntity.FIRST_LOCATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRestGlassSecondRunnable$lambda$0(OverlayPillGlassMaterial overlayPillGlassMaterial) {
        if (overlayPillGlassMaterial.scheduledRestGlassToken != overlayPillGlassMaterial.restGlassRefreshToken) {
            return;
        }
        overlayPillGlassMaterial.refreshBackdropAtOverlayRest("second");
        overlayPillGlassMaterial.restGlassRefreshPending = false;
    }

    private final void releaseMaterial() {
        E e10 = this.materialHandle;
        if (e10 == null) {
            return;
        }
        PillGlassMaterialHelper.INSTANCE.logGlassState(this.tag, "release", this.overlayProgress, true, PillGlassMaterialHelper.Mode.GLASS, this.host, e10);
        E e11 = this.materialHandle;
        if (e11 != null) {
            e11.g();
        }
        this.materialHandle = null;
        this.host.invalidate();
    }

    private final void scheduleApplyMaterial() {
        this.host.removeCallbacks(this.applyMaterialRunnable);
        if (!this.host.isAttachedToWindow() || this.host.getWidth() <= 0 || this.host.getHeight() <= 0) {
            this.host.post(this.applyMaterialRunnable);
        } else {
            tryApplyMaterial();
        }
    }

    private final void scheduleRestGlassRefresh() {
        if (this.restGlassRefreshPending) {
            PillGlassMaterialHelper.logRestGlass$default(PillGlassMaterialHelper.INSTANCE, this.tag, "skip-duplicate", this.scheduledRestGlassToken, this.overlayProgress, null, null, 48, null);
            return;
        }
        this.restGlassRefreshPending = true;
        int i10 = this.restGlassRefreshToken + 1;
        this.restGlassRefreshToken = i10;
        this.scheduledRestGlassToken = i10;
        PillGlassMaterialHelper.logRestGlass$default(PillGlassMaterialHelper.INSTANCE, this.tag, "schedule", i10, this.overlayProgress, "first@280ms,second@380ms", null, 32, null);
        this.host.removeCallbacks(this.refreshRestGlassRunnable);
        this.host.removeCallbacks(this.refreshRestGlassSecondRunnable);
        this.host.postDelayed(this.refreshRestGlassRunnable, 280L);
        this.host.postDelayed(this.refreshRestGlassSecondRunnable, 380L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryApplyMaterial() {
        PillGlassMaterialHelper.Mode modeCurrentMode = currentMode();
        PillGlassMaterialHelper pillGlassMaterialHelper = PillGlassMaterialHelper.INSTANCE;
        pillGlassMaterialHelper.logGlassState(this.tag, "tryApply", this.overlayProgress, true, modeCurrentMode, this.host, this.materialHandle);
        if (modeCurrentMode == PillGlassMaterialHelper.Mode.NONE) {
            if (hasActiveMaterial() && OverlayIndicatorState.isTransitionProgress(this.overlayProgress) && pillGlassMaterialHelper.isEffectivelyShown(this.host)) {
                return;
            }
            releaseMaterial();
            return;
        }
        if (!hasActiveMaterial()) {
            if (this.materialHandle != null) {
                releaseMaterial();
            }
            applyMaterial();
        } else {
            E e10 = this.materialHandle;
            if (e10 != null) {
                e10.b(effectiveCornerRadius());
            }
        }
    }

    public final void attach() {
        this.host.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        scheduleApplyMaterial();
    }

    public final void detach() {
        cancelRestGlassRefresh();
        this.host.removeCallbacks(this.applyMaterialRunnable);
        this.host.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
        releaseMaterial();
    }

    public final boolean hasActiveMaterial() {
        E e10 = this.materialHandle;
        return e10 != null && e10.c() > 0;
    }

    public final void onLayoutChanged() {
        E e10 = this.materialHandle;
        if (e10 != null) {
            e10.b(effectiveCornerRadius());
        }
        scheduleApplyMaterial();
    }

    public final void onVisibilityChanged() {
        scheduleApplyMaterial();
    }

    public final void onWindowVisibilityChanged(int visibility) {
        if (visibility == 0) {
            this.host.post(new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30139a.tryApplyMaterial();
                }
            });
        }
    }

    public final void setCornerRadiusPx(float radiusPx) {
        this.cornerRadiusPx = radiusPx;
        E e10 = this.materialHandle;
        if (e10 != null) {
            e10.b(effectiveCornerRadius());
        }
    }

    public final void setOverlayProgress(float progress) {
        float f10 = this.overlayProgress;
        float fM = C5685n.m(progress, 0.0f, 1.0f);
        this.overlayProgress = fM;
        if (f10 == fM) {
            return;
        }
        if (OverlayIndicatorState.isOverlayGlassRestProgress(fM) && f10 < 0.999f) {
            scheduleRestGlassRefresh();
            return;
        }
        if (OverlayIndicatorState.isTransitionProgress(this.overlayProgress)) {
            cancelRestGlassRefresh();
            tryApplyMaterial();
        } else if (OverlayIndicatorState.isOverlayGlassRestProgress(this.overlayProgress)) {
            tryApplyMaterial();
        } else {
            cancelRestGlassRefresh();
            releaseMaterial();
        }
    }

    public final boolean shouldDrawFallbackBackground() {
        return !hasActiveMaterial() && currentMode() == PillGlassMaterialHelper.Mode.NONE;
    }
}
