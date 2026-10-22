package com.amap.api.maps;

import com.amap.api.col.jmsl.H1;

/* loaded from: classes.dex */
public final class UiSettings {
    private final H1 uiSettingsDelegate;

    public UiSettings(H1 h12) {
        this.uiSettingsDelegate = h12;
    }

    public boolean isGestureScaleByMapCenter() {
        try {
            return this.uiSettingsDelegate.c();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.b();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.a();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.e();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.uiSettingsDelegate.g();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public void setAllGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.k(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setGestureScaleByMapCenter(boolean z10) {
        try {
            this.uiSettingsDelegate.b(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRotateGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.c(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setScrollGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.l(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTiltGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.i(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZoomGesturesEnabled(boolean z10) {
        try {
            this.uiSettingsDelegate.j(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZoomInByScreenCenter(boolean z10) {
        try {
            this.uiSettingsDelegate.a(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
