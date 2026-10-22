package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: loaded from: classes17.dex */
public class WebSettingsAdapter {
    private final WebSettingsBoundaryInterface mBoundaryInterface;

    public int getDisabledActionModeMenuItems() {
        return this.mBoundaryInterface.getDisabledActionModeMenuItems();
    }

    public boolean getEnterpriseAuthenticationAppLinkPolicyEnabled() {
        return this.mBoundaryInterface.getEnterpriseAuthenticationAppLinkPolicyEnabled();
    }

    public int getForceDark() {
        return this.mBoundaryInterface.getForceDark();
    }

    public int getForceDarkStrategy() {
        return this.mBoundaryInterface.getForceDarkBehavior();
    }

    public boolean getOffscreenPreRaster() {
        return this.mBoundaryInterface.getOffscreenPreRaster();
    }

    public int getRequestedWithHeaderMode() {
        return this.mBoundaryInterface.getRequestedWithHeaderMode();
    }

    public boolean getSafeBrowsingEnabled() {
        return this.mBoundaryInterface.getSafeBrowsingEnabled();
    }

    public boolean isAlgorithmicDarkeningAllowed() {
        return this.mBoundaryInterface.isAlgorithmicDarkeningAllowed();
    }

    public boolean willSuppressErrorPage() {
        return this.mBoundaryInterface.getWillSuppressErrorPage();
    }

    public WebSettingsAdapter(WebSettingsBoundaryInterface r100) {
        this.mBoundaryInterface = r100;
    }

    public void setAlgorithmicDarkeningAllowed(boolean r100) {
        this.mBoundaryInterface.setAlgorithmicDarkeningAllowed(r100);
    }

    public void setDisabledActionModeMenuItems(int r100) {
        this.mBoundaryInterface.setDisabledActionModeMenuItems(r100);
    }

    public void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean r100) {
        this.mBoundaryInterface.setEnterpriseAuthenticationAppLinkPolicyEnabled(r100);
    }

    public void setForceDark(int r100) {
        this.mBoundaryInterface.setForceDark(r100);
    }

    public void setForceDarkStrategy(int r100) {
        this.mBoundaryInterface.setForceDarkBehavior(r100);
    }

    public void setOffscreenPreRaster(boolean r100) {
        this.mBoundaryInterface.setOffscreenPreRaster(r100);
    }

    public void setRequestedWithHeaderMode(int r100) {
        this.mBoundaryInterface.setRequestedWithHeaderMode(r100);
    }

    public void setSafeBrowsingEnabled(boolean r100) {
        this.mBoundaryInterface.setSafeBrowsingEnabled(r100);
    }

    public void setWillSuppressErrorPage(boolean r100) {
        this.mBoundaryInterface.setWillSuppressErrorPage(r100);
    }
}
