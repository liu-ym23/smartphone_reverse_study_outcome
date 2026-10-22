package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.InsetsState;
import android.view.SurfaceControl;
import android.view.SurfaceControlViewHost;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class TrustedOverlayHost {
    final ArrayList<SurfaceControlViewHost.SurfacePackage> mOverlays;
    SurfaceControl mSurfaceControl;
    final WindowManagerService mWmService;

    TrustedOverlayHost(WindowManagerService wms) {
        this.mOverlays = new ArrayList();
        this.mWmService = wms;
    }

    void requireOverlaySurfaceControl() {
        if (this.mSurfaceControl != null) goto L6;
        SurfaceControl.Builder b = this.mWmService.makeSurfaceBuilder().setContainerLayer().setHidden(true).setCallsite("TrustedOverlayHost.requireOverlaySurfaceControl").setName("Overlay Host Leash");
        this.mSurfaceControl = b.build();
        SurfaceControl.Transaction t = this.mWmService.mTransactionFactory.get();
        t.setTrustedOverlay(this.mSurfaceControl, true).apply();
        return;
    }

    void setParent(SurfaceControl.Transaction t, SurfaceControl newParent) {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        t.reparent(this.mSurfaceControl, newParent);
        if (newParent == null) goto L8;
        t.show(this.mSurfaceControl);
        return;
    L8:
        t.hide(this.mSurfaceControl);
    }

    void setLayer(SurfaceControl.Transaction t, int layer) {
        if (this.mSurfaceControl == null) goto L6;
        t.setLayer(this.mSurfaceControl, layer);
        return;
    }

    void setVisibility(SurfaceControl.Transaction t, boolean visible) {
        if (this.mSurfaceControl == null) goto L6;
        t.setVisibility(this.mSurfaceControl, visible);
        return;
    }

    void addOverlay(SurfaceControlViewHost.SurfacePackage p, SurfaceControl currentParent) {
        requireOverlaySurfaceControl();
        boolean hasExistingOverlay = false;
        int i = this.mOverlays.size() - 1;
    L3:
        if (i < 0) goto L9;
        SurfaceControlViewHost.SurfacePackage l = this.mOverlays.get(i);
        if (l.getSurfaceControl().isSameSurface(p.getSurfaceControl()) == false) goto L7;
        hasExistingOverlay = true;
    L7:
        i = i - 1;
        goto L3
    L9:
        if (hasExistingOverlay == true) goto L11;
        this.mOverlays.add(p);
    L11:
        SurfaceControl.Transaction t = this.mWmService.mTransactionFactory.get();
        t.reparent(p.getSurfaceControl(), this.mSurfaceControl).show(p.getSurfaceControl());
        setParent(t, currentParent);
        t.apply();
    }

    boolean removeOverlay(SurfaceControlViewHost.SurfacePackage p) {
        SurfaceControl.Transaction t = this.mWmService.mTransactionFactory.get();
        int i = this.mOverlays.size() - 1;
    L3:
        if (i < 0) goto L11;
        SurfaceControlViewHost.SurfacePackage l = this.mOverlays.get(i);
        SurfaceControl overlaySurfaceControl = l.getSurfaceControl();
        if (overlaySurfaceControl != null) goto L8;
        this.mOverlays.remove(i);
    L10:
        i = i - 1;
        goto L3
    L8:
        if (overlaySurfaceControl.isSameSurface(p.getSurfaceControl()) == false) goto L10;
        this.mOverlays.remove(i);
        t.reparent(l.getSurfaceControl(), null);
        l.release();
        goto L10
    L11:
        t.apply();
        if (this.mOverlays.size() > 0) goto L20;
        return false;
    L20:
        return true;
    }

    void dispatchConfigurationChanged(Configuration c) {
        int i = this.mOverlays.size() - 1;
    L3:
        if (i < 0) goto L11;
        SurfaceControlViewHost.SurfacePackage l = this.mOverlays.get(i);
        l.getRemoteInterface().onConfigurationChanged(c);     // Catch: Exception -> L7
    L9:
        i = i - 1;
    L8:
        removeOverlay(l);
        goto L9
    }

    private void dispatchDetachedFromWindow() {
        int i = this.mOverlays.size() - 1;
    L3:
        if (i < 0) goto L10;
        SurfaceControlViewHost.SurfacePackage l = this.mOverlays.get(i);
        l.getRemoteInterface().onDispatchDetachedFromWindow();     // Catch: Exception -> L7
    L8:
        l.release();
        i = i - 1;
        goto L3
    }

    void dispatchInsetsChanged(InsetsState s, Rect insetFrame) {
        int i = this.mOverlays.size() - 1;
    L3:
        if (i < 0) goto L10;
        SurfaceControlViewHost.SurfacePackage l = this.mOverlays.get(i);
        l.getRemoteInterface().onInsetsChanged(s, insetFrame);     // Catch: Exception -> L7
    L8:
        i = i - 1;
        goto L3
    }

    void release() {
        dispatchDetachedFromWindow();
        this.mOverlays.clear();
        SurfaceControl.Transaction t = this.mWmService.mTransactionFactory.get();
        t.remove(this.mSurfaceControl).apply();
        this.mSurfaceControl = null;
    }
}
