package com.bytedance.android.livehostapi.business.depend.share;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
public class LiveQrCodeConfig {
    public static final int DEFAULT = 0;
    public static final int PIC_SHARE_WITH_QR_CODE = 4;
    public static final int POSTER_PREVIEW = 2;
    public static final int SHARE_POSTER = 1;
    public static final int SHARE_WITH_MARQUEE = 3;
    private String desc;
    private Map<String, String> downgradeQrCode;
    private int panelType;
    private List<? extends k> prePoster;
    private IQrCodeShareHelper qrCodeShareHelper;
    private List<? extends k> savePoster;

    public String toString() {
        return "LiveQrCodeConfig{panelType=" + this.panelType + ", desc='" + this.desc + "', prePoster=" + this.prePoster + ", savePoster=" + this.savePoster + '}';
    }

    public LiveQrCodeConfig() {
        this.panelType = 0;
        this.desc = "";
        this.prePoster = new ArrayList();
        this.savePoster = new ArrayList();
    }

    public String getDesc() {
        return this.desc;
    }

    public int getPanelType() {
        return this.panelType;
    }

    public List<? extends k> getPrePoster() {
        return this.prePoster;
    }

    public IQrCodeShareHelper getQrCodeShareHelper() {
        return this.qrCodeShareHelper;
    }

    public List<? extends k> getSavePoster() {
        return this.savePoster;
    }

    public void setDesc(String r100) {
        this.desc = r100;
    }

    public void setDowngradeQrCode(Map<String, String> r100) {
        this.downgradeQrCode = r100;
    }

    public void setPanelType(int r100) {
        this.panelType = r100;
    }

    public void setPrePoster(List<? extends k> r100) {
        this.prePoster = r100;
    }

    public void setQrCodeShareHelper(IQrCodeShareHelper r100) {
        this.qrCodeShareHelper = r100;
    }

    public void setSavePoster(List<? extends k> r100) {
        this.savePoster = r100;
    }

    public LiveQrCodeConfig(String r100, List<k> r101, List<k> r102) {
        this(0, r100, r101, r102);
    }

    public LiveQrCodeConfig(int r100, String r101, List<k> r102, List<k> r103) {
        this.panelType = 0;
        this.desc = "";
        this.prePoster = new ArrayList();
        new ArrayList();
        this.panelType = r100;
        this.desc = r101;
        this.prePoster = r102;
        this.savePoster = r103;
    }
}
