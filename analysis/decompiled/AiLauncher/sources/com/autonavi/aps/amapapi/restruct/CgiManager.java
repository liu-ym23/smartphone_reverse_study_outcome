package com.autonavi.aps.amapapi.restruct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.col.jmsl.V1;
import com.amap.location.support.bean.cell.AmapCell;
import com.amap.location.support.bean.cell.AmapCellCdma;
import com.amap.location.support.bean.cell.AmapCellGsm;
import com.amap.location.support.bean.cell.AmapCellLte;
import com.amap.location.support.bean.cell.AmapCellWcdma;
import com.autonavi.aps.amapapi.ICollectionManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Utils;
import com.stepos.ailauncher.chat.trace.g;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class CgiManager {
    public static final String HAS_FINE_LOC_PERM = "hasFineLocPerm";
    public static final String HAS_NO_FINE_LOC_PERM = "hasNoFineLocPerm";
    public static final String HAS_NO_READ_PHONESTATE_PERM = "hasNoReadPhoneStatePerm";
    public static final String HAS_READ_PHONESTATE_PERM = "hasReadPhoneStatePerm";
    public static final int MASK_NEW_VERSION_INDICATOR = 4;
    public static final int MASK_OPERATOR_INDICATOR = 8;
    public static final int MASK_V1_CELL_TYPE = 3;

    /* renamed from: a, reason: collision with root package name */
    private Context f18286a;

    /* renamed from: g, reason: collision with root package name */
    TelephonyManager f18292g;

    /* renamed from: h, reason: collision with root package name */
    private CellAgeEstimator f18293h;

    /* renamed from: k, reason: collision with root package name */
    SignalStrength f18296k;

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback f18298m;

    /* renamed from: w, reason: collision with root package name */
    private ICollectionManager f18308w;

    /* renamed from: b, reason: collision with root package name */
    private boolean f18287b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18288c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<Cgi> f18289d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private String f18290e = null;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Cgi> f18291f = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private long f18294i = 0;

    /* renamed from: j, reason: collision with root package name */
    PhoneStateListener f18295j = null;

    /* renamed from: l, reason: collision with root package name */
    private Object f18297l = new Object();

    /* renamed from: n, reason: collision with root package name */
    private boolean f18299n = false;

    /* renamed from: o, reason: collision with root package name */
    boolean f18300o = false;

    /* renamed from: p, reason: collision with root package name */
    StringBuilder f18301p = null;

    /* renamed from: q, reason: collision with root package name */
    private String f18302q = null;

    /* renamed from: r, reason: collision with root package name */
    private String f18303r = null;

    /* renamed from: s, reason: collision with root package name */
    String f18304s = null;

    /* renamed from: t, reason: collision with root package name */
    private volatile boolean f18305t = true;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f18306u = true;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f18307v = false;

    @SuppressLint({"NewApi"})
    public class CellInfoCallBack extends TelephonyManager.CellInfoCallback {
        public CellInfoCallBack() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            try {
                DebugUtils.writeCat("CgiManager", "CellInfoCallBack onCellInfo");
                DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f18306u + " isStartLocation:" + CgiManager.this.f18305t);
                if ((CgiManager.this.f18306u || CgiManager.this.f18305t) && Utils.getTimeBoot() - CgiManager.this.f18294i >= 500) {
                    CgiManager.this.f18299n = true;
                    CgiManager.this.a(CgiManager.this.e());
                    CgiManager.this.a(list);
                    CgiManager.this.f18294i = Utils.getTimeBoot();
                }
            } catch (SecurityException e10) {
                CgiManager.this.f18304s = e10.getMessage();
            } catch (Throwable th) {
                CoreUtil.reportError(th, "Cgi", "cellInfo");
            }
        }
    }

    public class CgiPhoneListener extends PhoneStateListener {
        public CgiPhoneListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            try {
                DebugUtils.writeCat("CgiManager", "CgiPhoneListener onCellInfoChanged");
                DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f18306u + " isStartLocation:" + CgiManager.this.f18305t);
                if (CgiManager.this.f18306u || CgiManager.this.f18305t) {
                    if (CgiManager.this.f18308w != null) {
                        CgiManager.this.f18308w.updateCell();
                    }
                    if (Utils.getTimeBoot() - CgiManager.this.f18294i < 500) {
                        return;
                    }
                    CgiManager.this.a(CgiManager.this.e());
                    CgiManager.this.a(list);
                    CgiManager.this.f18294i = Utils.getTimeBoot();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onCellLocationChanged");
            DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f18306u + " isStartLocation:" + CgiManager.this.f18305t);
            if ((CgiManager.this.f18306u || CgiManager.this.f18305t) && Utils.getTimeBoot() - CgiManager.this.f18294i >= 500) {
                try {
                    CgiManager.this.a(cellLocation);
                    CgiManager.this.a(CgiManager.this.d());
                    CgiManager.this.f18294i = Utils.getTimeBoot();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i10) {
            super.onDataConnectionStateChanged(i10);
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onDataConnectionStateChanged");
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            try {
                DebugUtils.writeCat("CgiManager", "CgiPhoneListener onServiceStateChanged");
                DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f18306u + " isStartLocation:" + CgiManager.this.f18305t);
                if (CgiManager.this.f18306u || CgiManager.this.f18305t) {
                    int state = serviceState.getState();
                    if (state == 0) {
                        CgiManager.this.updateCgi(false, false);
                    } else {
                        if (state != 1) {
                            return;
                        }
                        CgiManager.this.h();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthChanged(int i10) {
            super.onSignalStrengthChanged(i10);
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onSignalStrengthChanged");
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            DebugUtils.writeCat("CgiManager", "CgiPhoneListener onSignalStrengthsChanged");
            DebugUtils.writeCat("CgiManager", "noLocReqCgiEnable:" + CgiManager.this.f18306u + " isStartLocation:" + CgiManager.this.f18305t);
            if (signalStrength == null) {
                return;
            }
            CgiManager cgiManager = CgiManager.this;
            cgiManager.f18296k = signalStrength;
            if (cgiManager.f18306u || CgiManager.this.f18305t) {
                try {
                    if (CgiManager.this.f18308w != null) {
                        CgiManager.this.f18308w.updateCell();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public CgiManager(Context context, Handler handler) {
        this.f18292g = null;
        this.f18293h = null;
        DebugUtils.writeCat("CgiManager", "==================CgiManager Constructor===================");
        this.f18286a = context;
        if (this.f18292g == null) {
            this.f18292g = (TelephonyManager) Utils.getServ(context, "phone");
        }
        f();
        CellAgeEstimator cellAgeEstimator = new CellAgeEstimator(context, "cellAge", handler);
        this.f18293h = cellAgeEstimator;
        cellAgeEstimator.start();
    }

    private void g() {
        int i10;
        try {
            if (this.f18295j == null) {
                this.f18295j = new CgiPhoneListener();
            }
            int iCheckSelfPermission = this.f18286a.checkSelfPermission(PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION);
            String str = HAS_NO_FINE_LOC_PERM;
            if (iCheckSelfPermission == 0) {
                this.f18303r = HAS_FINE_LOC_PERM;
                DebugUtils.writeCat("CgiManager | event LCL SUC1", false);
                i10 = 336;
            } else {
                this.f18303r = HAS_NO_FINE_LOC_PERM;
                DebugUtils.writeCat("CgiManager | LCL: NO FINE Loc Perm，failed", false);
                i10 = 320;
            }
            boolean z10 = this.f18286a.checkSelfPermission(PolicySdkPermissionManifestUtils.READ_PHONE_STATE) == 0;
            boolean z11 = this.f18286a.checkSelfPermission(PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0;
            if (z10 && z11) {
                i10 |= 1024;
                DebugUtils.writeCat("CgiManager | event LCI SUC3", false);
            } else {
                DebugUtils.writeCat("CgiManager | LCI: NO rps Perm or NO fl Perm，failed", false);
            }
            this.f18302q = z10 ? HAS_READ_PHONESTATE_PERM : HAS_NO_READ_PHONESTATE_PERM;
            if (z11) {
                str = HAS_FINE_LOC_PERM;
            }
            this.f18303r = str;
            DebugUtils.writeCat("CgiManager | mLFLPerm = " + this.f18303r + ";mLRPSPerm = " + this.f18302q, false);
            PhoneStateListener phoneStateListener = this.f18295j;
            if (phoneStateListener != null) {
                this.f18292g.listen(phoneStateListener, i10);
                this.f18307v = true;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static boolean isValidCgiFlag(int i10) {
        return i10 >= 1 && i10 <= 15;
    }

    public void destroy(boolean z10) {
        this.f18293h.destroy(z10);
        this.f18294i = 0L;
        synchronized (this.f18297l) {
        }
        b();
        this.f18296k = null;
        this.f18292g = null;
    }

    public List<AmapCell> getAmapCells() {
        ArrayList arrayList = new ArrayList();
        List<CellInfo> listC = c();
        if (listC != null) {
            for (CellInfo cellInfo : listC) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    AmapCellCdma amapCellCdma = new AmapCellCdma(cellInfo.isRegistered(), true);
                    amapCellCdma.f18072n = cellIdentity.getLatitude();
                    amapCellCdma.f18073o = cellIdentity.getLongitude();
                    amapCellCdma.f18069k = cellIdentity.getSystemId();
                    amapCellCdma.f18070l = cellIdentity.getNetworkId();
                    amapCellCdma.f18071m = cellIdentity.getBasestationId();
                    amapCellCdma.f18063e = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    amapCellCdma.f18062d = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(amapCellCdma);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    AmapCellGsm amapCellGsm = new AmapCellGsm(cellInfo.isRegistered(), true);
                    amapCellGsm.f18060b = String.valueOf(cellIdentity2.getMcc());
                    amapCellGsm.f18061c = String.valueOf(cellIdentity2.getMnc());
                    amapCellGsm.f18074k = cellIdentity2.getLac();
                    amapCellGsm.f18075l = cellIdentity2.getCid();
                    amapCellGsm.f18062d = cellInfoGsm.getCellSignalStrength().getDbm();
                    amapCellGsm.f18063e = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    amapCellGsm.f18077n = cellIdentity2.getArfcn();
                    amapCellGsm.f18078o = cellIdentity2.getBsic();
                    arrayList.add(amapCellGsm);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    AmapCellLte amapCellLte = new AmapCellLte(cellInfo.isRegistered());
                    amapCellLte.f18060b = String.valueOf(cellIdentity3.getMcc());
                    amapCellLte.f18061c = String.valueOf(cellIdentity3.getMnc());
                    amapCellLte.f18082m = cellIdentity3.getPci();
                    amapCellLte.f18063e = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    amapCellLte.f18081l = cellIdentity3.getCi();
                    amapCellLte.f18080k = cellIdentity3.getTac();
                    amapCellLte.f18084o = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    amapCellLte.f18062d = cellInfoLte.getCellSignalStrength().getDbm();
                    amapCellLte.f18083n = cellIdentity3.getEarfcn();
                    arrayList.add(amapCellLte);
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                    AmapCellWcdma amapCellWcdma = new AmapCellWcdma(cellInfo.isRegistered(), true);
                    amapCellWcdma.f18060b = String.valueOf(cellIdentity4.getMcc());
                    amapCellWcdma.f18061c = String.valueOf(cellIdentity4.getMnc());
                    amapCellWcdma.f18088k = cellIdentity4.getLac();
                    amapCellWcdma.f18089l = cellIdentity4.getCid();
                    amapCellWcdma.f18090m = cellIdentity4.getPsc();
                    amapCellWcdma.f18063e = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                    amapCellWcdma.f18062d = cellInfoWcdma.getCellSignalStrength().getDbm();
                    amapCellWcdma.f18091n = cellIdentity4.getUarfcn();
                    arrayList.add(amapCellWcdma);
                }
            }
        }
        return arrayList;
    }

    public int getCgiFlag() {
        return getMainCgiType() | (this.f18287b ? 4 : 0) | (this.f18288c ? 8 : 0);
    }

    public synchronized String getCgiParam() {
        try {
            if (this.f18300o) {
                h();
            }
            StringBuilder sb2 = this.f18301p;
            if (sb2 == null) {
                this.f18301p = new StringBuilder();
            } else {
                sb2.delete(0, sb2.length());
            }
            if (getMainCgiTypeMasked() == 1) {
                for (int i10 = 1; i10 < this.f18289d.size(); i10++) {
                    StringBuilder sb3 = this.f18301p;
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(this.f18289d.get(i10).mnc);
                    StringBuilder sb4 = this.f18301p;
                    sb4.append("|");
                    sb4.append(this.f18289d.get(i10).lac);
                    StringBuilder sb5 = this.f18301p;
                    sb5.append("|");
                    sb5.append(this.f18289d.get(i10).cid);
                }
            }
            for (int i11 = 1; i11 < this.f18291f.size(); i11++) {
                Cgi cgi = this.f18291f.get(i11);
                int i12 = cgi.type;
                if (i12 == 1 || i12 == 3 || i12 == 4 || i12 == 5) {
                    StringBuilder sb6 = this.f18301p;
                    sb6.append(Const.STR_MART_WELL);
                    sb6.append(cgi.type);
                    StringBuilder sb7 = this.f18301p;
                    sb7.append("|");
                    sb7.append(cgi.mcc);
                    StringBuilder sb8 = this.f18301p;
                    sb8.append("|");
                    sb8.append(cgi.mnc);
                    StringBuilder sb9 = this.f18301p;
                    sb9.append("|");
                    sb9.append(cgi.lac);
                    StringBuilder sb10 = this.f18301p;
                    sb10.append("|");
                    sb10.append(cgi.getCid());
                } else if (i12 == 2) {
                    StringBuilder sb11 = this.f18301p;
                    sb11.append(Const.STR_MART_WELL);
                    sb11.append(cgi.type);
                    StringBuilder sb12 = this.f18301p;
                    sb12.append("|");
                    sb12.append(cgi.mcc);
                    StringBuilder sb13 = this.f18301p;
                    sb13.append("|");
                    sb13.append(cgi.sid);
                    StringBuilder sb14 = this.f18301p;
                    sb14.append("|");
                    sb14.append(cgi.nid);
                    StringBuilder sb15 = this.f18301p;
                    sb15.append("|");
                    sb15.append(cgi.bid);
                }
            }
            if (this.f18301p.length() > 0) {
                this.f18301p.deleteCharAt(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18301p.toString();
    }

    public synchronized ArrayList<Cgi> getDetectedCgiList() {
        ArrayList<Cgi> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Cgi> arrayList2 = this.f18289d;
        if (arrayList2 != null) {
            Iterator<Cgi> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m43clone());
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<Cgi> getDetectedCgiV2List() {
        ArrayList<Cgi> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<Cgi> arrayList2 = this.f18291f;
        if (arrayList2 != null) {
            Iterator<Cgi> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m43clone());
            }
        }
        return arrayList;
    }

    public synchronized Cgi getMainCgi() {
        if (this.f18300o) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f18289d;
        if (arrayList.size() < 1) {
            return null;
        }
        return arrayList.get(0).m43clone();
    }

    public int getMainCgiType() {
        Cgi mainCgi = getMainCgi();
        if (mainCgi != null) {
            return mainCgi.type;
        }
        return 0;
    }

    public int getMainCgiTypeMasked() {
        return getMainCgiType() & 3;
    }

    public synchronized Cgi getMainCgiV2() {
        if (this.f18300o) {
            return null;
        }
        ArrayList<Cgi> arrayList = this.f18291f;
        if (arrayList.size() < 1) {
            return null;
        }
        Iterator<Cgi> it = arrayList.iterator();
        while (it.hasNext()) {
            Cgi next = it.next();
            if (next.isMain) {
                return next.m43clone();
            }
        }
        return arrayList.get(0).m43clone();
    }

    public String getRawOperatorStr() {
        return this.f18290e;
    }

    public String getSecurityException() {
        return this.f18304s;
    }

    public TelephonyManager getTelephonyManagerInstance() {
        return this.f18292g;
    }

    public synchronized void h() {
        this.f18304s = null;
        this.f18289d.clear();
        this.f18291f.clear();
        this.f18287b = false;
        this.f18288c = false;
    }

    public boolean isSimValid() {
        try {
            TelephonyManager telephonyManager = this.f18292g;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.f18292g.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int netT = Utils.getNetT(Utils.getNetWorkInfo(this.f18286a));
            return netT == 0 || netT == 4 || netT == 2 || netT == 5 || netT == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public void notifyLocationStatus(boolean z10) {
        this.f18305t = z10;
        if (this.f18306u) {
            return;
        }
        if (z10 && !this.f18307v) {
            g();
        } else {
            if (z10 || !this.f18307v) {
                return;
            }
            b();
        }
    }

    public void reInitIfNeed() {
        try {
            String str = this.f18286a.checkSelfPermission(PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0 ? HAS_FINE_LOC_PERM : HAS_NO_FINE_LOC_PERM;
            String str2 = this.f18286a.checkSelfPermission(PolicySdkPermissionManifestUtils.READ_PHONE_STATE) == 0 ? HAS_READ_PHONESTATE_PERM : HAS_NO_READ_PHONESTATE_PERM;
            boolean z10 = true;
            boolean z11 = (TextUtils.isEmpty(this.f18303r) || this.f18303r.equals(str)) ? false : true;
            if (TextUtils.isEmpty(this.f18302q) || this.f18302q.equals(str2)) {
                z10 = z11;
            }
            if (z10) {
                DebugUtils.writeCat("CgiManager | reInitPSL", false);
                g();
            }
        } catch (Throwable unused) {
            DebugUtils.writeCat("CgiManager | reInit e", false);
        }
    }

    public void setCollectionManager(ICollectionManager iCollectionManager) {
        this.f18308w = iCollectionManager;
    }

    public void setNoLocReqCgiEnable(boolean z10) {
        this.f18306u = z10;
    }

    public void updateCgi(boolean z10, boolean z11) {
        try {
            this.f18300o = Utils.airPlaneModeOn(this.f18286a);
            if (a()) {
                a(z10, z11);
                a(e());
                a(d());
            }
            if (this.f18300o) {
                h();
            }
        } catch (SecurityException e10) {
            this.f18304s = e10.getMessage();
        } catch (Throwable th) {
            CoreUtil.reportError(th, "CgiManager", g.ACTION_REFRESH);
        }
    }

    private void b() {
        PhoneStateListener phoneStateListener;
        TelephonyManager telephonyManager = this.f18292g;
        if (telephonyManager != null && (phoneStateListener = this.f18295j) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
                this.f18307v = false;
            } catch (Throwable th) {
                CoreUtil.reportError(th, "CgiManager", "destroy");
            }
        }
        this.f18295j = null;
    }

    private List<CellInfo> c() {
        TelephonyManager telephonyManager = this.f18292g;
        if (telephonyManager == null) {
            return null;
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        DebugUtils.writeCat("CgiManager", "getAllCellInfo");
        return allCellInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public List<CellInfo> d() {
        List<CellInfo> listC;
        try {
            if (Utils.getSdk() < 18 || this.f18292g == null) {
                return null;
            }
            try {
                listC = c();
                try {
                    this.f18304s = null;
                    return listC;
                } catch (SecurityException e10) {
                    e = e10;
                    this.f18304s = e.getMessage();
                    return listC;
                }
            } catch (SecurityException e11) {
                e = e11;
                listC = null;
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Cgi", "getNewCells");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation e() {
        TelephonyManager telephonyManager = this.f18292g;
        if (telephonyManager == null) {
            return null;
        }
        try {
            CellLocation cellLocation = telephonyManager.getCellLocation();
            DebugUtils.writeCat("CgiManager", "getCellLocation");
            this.f18304s = null;
            return cellLocation;
        } catch (SecurityException e10) {
            this.f18304s = e10.getMessage();
            return null;
        } catch (Throwable th) {
            this.f18304s = null;
            CoreUtil.reportError(th, "CgiManager", "getCellLocation");
            return null;
        }
    }

    private void f() {
        if (this.f18292g == null) {
            return;
        }
        g();
    }

    public boolean a() {
        return !this.f18300o && Utils.getTimeBoot() - this.f18294i >= Const.L_MIN_CGI_REFRESH;
    }

    @SuppressLint({"NewApi"})
    private void a(boolean z10, boolean z11) {
        if (!this.f18300o && this.f18292g != null && this.f18286a.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.f18298m == null) {
                this.f18298m = new CellInfoCallBack();
            }
            try {
                this.f18292g.requestCellInfoUpdate(V1.h().a(), this.f18298m);
            } catch (Throwable th) {
                CoreUtil.reportError(th, "Cgi", "refreshCgi");
            }
            if (z11 || z10) {
                for (int i10 = 0; !this.f18299n && i10 < 20; i10++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.f18288c = false;
        TelephonyManager telephonyManager = this.f18292g;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.f18290e = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.f18288c = true;
            }
        }
        this.f18294i = Utils.getTimeBoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(CellLocation cellLocation) {
        try {
            String[] mccMnc = Utils.getMccMnc(this.f18292g);
            this.f18289d.clear();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                Cgi cgi = new Cgi(1, true);
                cgi.mcc = Utils.parseInt(mccMnc[0]);
                cgi.mnc = Utils.parseInt(mccMnc[1]);
                cgi.lac = gsmCellLocation.getLac();
                cgi.cid = gsmCellLocation.getCid();
                SignalStrength signalStrength = this.f18296k;
                if (signalStrength != null) {
                    int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                    cgi.signalStrength = gsmSignalStrength == 99 ? Integer.MAX_VALUE : (gsmSignalStrength * 2) + Const.I_DEF_CGI_SIG;
                }
                cgi.newApi = false;
                this.f18293h.update((CellAgeEstimator) cgi);
                this.f18289d.add(cgi);
            } else if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                Cgi cgi2 = new Cgi(2, true);
                cgi2.mcc = Integer.parseInt(mccMnc[0]);
                cgi2.mnc = Integer.parseInt(mccMnc[1]);
                cgi2.lat = cdmaCellLocation.getBaseStationLatitude();
                cgi2.lon = cdmaCellLocation.getBaseStationLongitude();
                cgi2.sid = cdmaCellLocation.getSystemId();
                cgi2.nid = cdmaCellLocation.getNetworkId();
                cgi2.bid = cdmaCellLocation.getBaseStationId();
                SignalStrength signalStrength2 = this.f18296k;
                if (signalStrength2 != null) {
                    cgi2.signalStrength = signalStrength2.getCdmaDbm();
                }
                cgi2.newApi = false;
                this.f18293h.update((CellAgeEstimator) cgi2);
                this.f18289d.add(cgi2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0273 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x022e A[Catch: all -> 0x000d, TryCatch #5 {all -> 0x000d, blocks: (B:4:0x0005, B:6:0x0009, B:10:0x0012, B:14:0x001c, B:16:0x0023, B:93:0x0273, B:19:0x002e, B:92:0x0252, B:84:0x0220, B:86:0x022e, B:90:0x023a, B:88:0x0233, B:89:0x0238, B:103:0x028c, B:94:0x0278, B:96:0x027f, B:98:0x0285), top: B:116:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0252 A[Catch: all -> 0x000d, TryCatch #5 {all -> 0x000d, blocks: (B:4:0x0005, B:6:0x0009, B:10:0x0012, B:14:0x001c, B:16:0x0023, B:93:0x0273, B:19:0x002e, B:92:0x0252, B:84:0x0220, B:86:0x022e, B:90:0x023a, B:88:0x0233, B:89:0x0238, B:103:0x028c, B:94:0x0278, B:96:0x027f, B:98:0x0285), top: B:116:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(java.util.List<android.telephony.CellInfo> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.CgiManager.a(java.util.List):void");
    }

    public Cgi a(int i10, boolean z10, int i11, int i12, int i13, int i14, int i15) {
        Cgi cgi = new Cgi(i10, z10);
        cgi.mcc = i11;
        cgi.mnc = i12;
        cgi.lac = i13;
        cgi.cid = i14;
        cgi.sig = i15;
        return cgi;
    }
}
