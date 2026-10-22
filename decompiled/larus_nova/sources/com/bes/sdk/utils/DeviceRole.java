package com.bes.sdk.utils;

import android.text.TextUtils;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.tencent.connect.common.Constants;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum DeviceRole extends Enum<DeviceRole> {
    public static final DeviceRole MASTER = null;
    public static final DeviceRole NORMAL = null;
    public static final DeviceRole SLAVE = null;
    public static final DeviceRole TWS_MASTER = null;
    public static final DeviceRole TWS_SLAVE = null;
    public static final DeviceRole UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceRole[] f33669a = null;
    private String mName;
    private int mValue;

    static {
        DeviceRole r100 = new DeviceRole("UNKNOWN", 0, -1, "Unknown");
        UNKNOWN = r100;
        DeviceRole r101 = new DeviceRole(EffectConstants.NORMAL, 1, 0, "Normal");
        NORMAL = r101;
        DeviceRole r102 = new DeviceRole("MASTER", 2, 1, "Master");
        MASTER = r102;
        DeviceRole r103 = new DeviceRole("SLAVE", 3, 2, "Slave");
        SLAVE = r103;
        DeviceRole r104 = new DeviceRole("TWS_MASTER", 4, 101, "TWS_MASTER");
        TWS_MASTER = r104;
        DeviceRole r105 = new DeviceRole("TWS_SLAVE", 5, 102, "TWS_SLAVE");
        TWS_SLAVE = r105;
        f33669a = new DeviceRole[]{r100, r101, r102, r103, r104, r105};
    }

    public static DeviceRole[] values() {
        return (DeviceRole[]) f33669a.clone();
    }

    public String getName() {
        return this.mName;
    }

    public int getValue() {
        return this.mValue;
    }

    public static DeviceRole getRole(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 48: goto L34;
            case 49: goto L30;
            case 50: goto L26;
            case 1536: goto L22;
            case 1537: goto L18;
            case 1538: goto L14;
            case 1567: goto L10;
            default: goto L37;
        };
    L37:
        switch(r101) {
            case 0: goto L45;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L41;
            case 6: goto L41;
            default: goto L39;
        };
    L39:
        return NORMAL;
    L41:
        return SLAVE;
    L43:
        return MASTER;
    L45:
        return NORMAL;
    L10:
        if (r100.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) == false) goto L37;
        r101 = 6;
        goto L37
    L14:
        if (r100.equals("02") == false) goto L37;
        r101 = 5;
        goto L37
    L18:
        if (r100.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01) == false) goto L37;
        r101 = 4;
        goto L37
    L22:
        if (r100.equals(CustomAlbumViewModel.DEFAULT_TAB_ID) == false) goto L37;
        r101 = 3;
        goto L37
    L26:
        if (r100.equals("2") == false) goto L37;
        r101 = 2;
        goto L37
    L30:
        if (r100.equals("1") == false) goto L37;
        r101 = 1;
        goto L37
    L34:
        if (r100.equals("0") == false) goto L37;
        r101 = 0;
        goto L37
    L5:
        return UNKNOWN;
    }

    public static DeviceRole valueOf(String r100) {
        return (DeviceRole) a.a(DeviceRole.class, r100);
    }

    public static DeviceRole getRole(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 101) goto L16;
        if (r100 == 102) goto L14;
        return UNKNOWN;
    L14:
        return TWS_SLAVE;
    L16:
        return TWS_MASTER;
    L18:
        return SLAVE;
    L20:
        return MASTER;
    L22:
        return NORMAL;
    }

    public DeviceRole(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.mValue = r102;
        this.mName = r103;
    }
}
