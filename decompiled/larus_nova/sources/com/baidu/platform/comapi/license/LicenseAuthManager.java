package com.baidu.platform.comapi.license;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.ILicenseAuthListener;
import com.baidu.mapauto.auth.LicenseAuth;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class LicenseAuthManager implements ILicenseAuthManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<b, Map<String, Integer>> f32890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<d<ILicenseAuthManagerListener>> f32891b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Integer, Integer> f32892c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f32894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f32895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f32896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f32897h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f32898i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f32899j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f32900k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f32901l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f32902m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final List<IExtraLicenseAuth> f32903n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ILicenseAuthListener f32904o;

    public static class Builder {
        private String mAk;
        private String mAppVersion;
        private String mChannel;
        private String mCuid;
        private String mDeviceId;
        private List<IExtraLicenseAuth> mExtraLicenseAuths;
        private String mFunctionName;
        private String mModel;
        private String mOsVersion;
        private String mServiceName;
        private int mType;

        public ILicenseAuthManager build() {
            return new LicenseAuthManager(this.mAk, this.mChannel, this.mDeviceId, this.mCuid, this.mAppVersion, this.mOsVersion, this.mModel, this.mServiceName, this.mFunctionName, this.mType, this.mExtraLicenseAuths, null);
        }

        public Builder() {
        }

        public Builder ak(String r100) {
            this.mAk = r100;
            return this;
        }

        public Builder appVersion(String r100) {
            this.mAppVersion = r100;
            return this;
        }

        public Builder channel(String r100) {
            this.mChannel = r100;
            return this;
        }

        public Builder cuid(String r100) {
            this.mCuid = r100;
            return this;
        }

        public Builder deviceId(String r100) {
            this.mDeviceId = r100;
            return this;
        }

        public Builder extraAuth(List<IExtraLicenseAuth> r100) {
            this.mExtraLicenseAuths = r100;
            return this;
        }

        public Builder functionName(String r100) {
            this.mFunctionName = r100;
            return this;
        }

        public Builder model(String r100) {
            this.mModel = r100;
            return this;
        }

        public Builder osVersion(String r100) {
            this.mOsVersion = r100;
            return this;
        }

        public Builder serviceName(String r100) {
            this.mServiceName = r100;
            return this;
        }

        public Builder type(int r100) {
            this.mType = r100;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f32905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f32906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f32907c;

        public int hashCode() {
            if (TextUtils.isEmpty(this.f32906b) == true) goto L5;
        L8:
            int r100 = this.f32905a;
            if (TextUtils.isEmpty(this.f32906b) == true) goto L12;
            r100 = (r100 * 31) + this.f32906b.hashCode();
        L12:
            if (TextUtils.isEmpty(this.f32907c) == false) goto L14;
            return r100;
        L14:
            return (r100 * 31) + this.f32907c.hashCode();
        L5:
            if (TextUtils.isEmpty(this.f32907c) == false) goto L8;
            return super.hashCode();
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            String r101 = "" + this.f32906b + "" + this.f32907c + "" + this.f32905a;
            StringBuilder r102 = new StringBuilder("");
            b r103 = (b) r100;
            r102.append(r103.f32906b);
            r102.append("");
            r102.append(r103.f32907c);
            r102.append("");
            r102.append(r103.f32905a);
            return r101.equals(r102.toString());
        }

        public b(String r100, String r101, int r102) {
            this.f32906b = r100;
            this.f32907c = r101;
            this.f32905a = r102;
        }
    }

    public class c implements ILicenseAuthListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ILicenseAuthManagerListener f32908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LicenseAuthManager f32909b;

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public void onSuccess(Map<String, Integer> r100) {
            LicenseAuthManager.a().put(new b(LicenseAuthManager.a(this.f32909b), LicenseAuthManager.b(this.f32909b), LicenseAuthManager.c(this.f32909b)), r100);
            ILicenseAuthManagerListener r101 = this.f32908a;
            if (r101 == null) goto L5;
            r101.onSuccess(LicenseAuthManager.a(this.f32909b), LicenseAuthManager.b(this.f32909b), LicenseAuthManager.c(this.f32909b), r100);
        L5:
            LicenseAuthManager r102 = this.f32909b;
            LicenseAuthManager.a(r102, LicenseAuthManager.a(r102), LicenseAuthManager.b(this.f32909b), LicenseAuthManager.c(this.f32909b), r100);
        }

        public c(LicenseAuthManager r100, ILicenseAuthManagerListener r101) {
            this.f32909b = r100;
            this.f32908a = r101;
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public void onError(int r100, String r101, Exception r102) {
            int r103 = LicenseAuthManager.a(this.f32909b, r100);
            LicenseAuthManager.a().remove(new b(LicenseAuthManager.a(this.f32909b), LicenseAuthManager.b(this.f32909b), LicenseAuthManager.c(this.f32909b)));
            ILicenseAuthManagerListener r104 = this.f32908a;
            if (r104 == null) goto L5;
            r104.onError(LicenseAuthManager.a(this.f32909b), LicenseAuthManager.b(this.f32909b), LicenseAuthManager.c(this.f32909b), r103, r101);
        L5:
            LicenseAuthManager r105 = this.f32909b;
            LicenseAuthManager.a(r105, LicenseAuthManager.a(r105), LicenseAuthManager.b(this.f32909b), LicenseAuthManager.c(this.f32909b), r103, r101);
        }
    }

    public static class d<T> extends WeakReference<T> {
        public int hashCode() {
            T r100 = get();
            if (r100 == null) goto L7;
            return r100.hashCode();
        L7:
            return super.hashCode();
        }

        public d(T r100) {
            super(r100);
        }

        public boolean equals(Object r100) {
            T r101 = get();
            if (r101 == null) goto L7;
            return r101.equals(r100);
        L7:
            return super.equals(r100);
        }
    }

    static {
        f32890a = new HashMap();
        f32891b = new HashSet();
        HashMap r100 = new HashMap();
        f32892c = r100;
        r100.put(0, 0);
        r100.put(-1001, 1);
        r100.put(-1002, 2);
        r100.put(-1003, 100);
        r100.put(-1004, 101);
        r100.put(-1005, 102);
        r100.put(-1006, 202);
        r100.put(-1000, 1000);
    }

    private void b() throws BaseLicenseAuthDataStandardProcess.ProcessException {
        List<IExtraLicenseAuth> r100 = this.f32903n;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L13;
        Iterator<IExtraLicenseAuth> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        r101.next().check();
        goto L9
    L14:
        return;
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public boolean isHaveAuthority() {
        Map<String, Integer> r100 = f32890a.get(new b(this.f32900k, this.f32901l, this.f32902m));
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = r100.get(this.f32901l);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static /* synthetic */ Map a() {
        return f32890a;
    }

    private int a(int r100) {
        Integer r101 = f32892c.get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        return r100;
    L6:
        return r101.intValue();
    }

    public static void addLicenseAuthLicense(ILicenseAuthManagerListener r100) {
        f32891b.add(new d(r100));
    }

    public static /* synthetic */ String b(LicenseAuthManager r100) {
        return r100.f32901l;
    }

    public static /* synthetic */ int c(LicenseAuthManager r100) {
        return r100.f32902m;
    }

    public static void removeLicenseAuthLicense(ILicenseAuthManagerListener r100) {
        Iterator<d<ILicenseAuthManagerListener>> r101 = f32891b.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        ILicenseAuthManagerListener r102 = r101.next().get();
        if (r102 == null) goto L7;
        if (r102 != r100) goto L4;
        r101.remove();
        goto L4
    L7:
        r101.remove();
        goto L4
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public boolean isHaveAuthority(Map<String, Integer> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = r100.get(this.f32901l);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public Map<String, Integer> loadLocalAuth(Context r100) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        b();
        return LicenseAuth.getInstance().loadLocalAuth(r100, this.f32893d, this.f32894e, this.f32895f, this.f32900k, this.f32901l, this.f32902m);
    L5:
        e = move-exception;
        throw new BaseLicenseAuthDataStandardProcess.ProcessException(a(e.getCode()), e.getMessage());
    }

    public static /* synthetic */ String a(LicenseAuthManager r100) {
        return r100.f32900k;
    }

    public static /* synthetic */ int a(LicenseAuthManager r100, int r101) {
        return r100.a(r101);
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public boolean isEffective(String r100, String r101) {
        if (("" + this.f32900k).equals("" + r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (("" + this.f32901l).equals("" + r101) == false) goto L7;
        return true;
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public void loadAuth(Context r110, ILicenseAuthManagerListener r111) {
        b();     // Catch: BaseLicenseAuthDataStandardProcess.ProcessException -> L5
        HashMap r100 = new HashMap();
        r100.put(AuthCore.AuthParam.KEY_EXTRA_CUID, this.f32896g);
        r100.put(AuthCore.AuthParam.KEY_EXTRA_APP_VERSION, this.f32897h);
        r100.put(AuthCore.AuthParam.KEY_EXTRA_OS_VERSION, this.f32898i);
        r100.put(AuthCore.AuthParam.KEY_EXTRA_MODEL, this.f32899j);
        this.f32904o = new c(this, r111);
        LicenseAuth.getInstance().loadAuth(r110, this.f32893d, this.f32894e, this.f32895f, this.f32900k, this.f32901l, this.f32902m, r100, this.f32904o);
        return;
    L5:
        e = move-exception;
        int r101 = e.getCode();
        String r112 = e.getMessage();
        f32890a.remove(new b(this.f32900k, this.f32901l, this.f32902m));
        if (r111 == null) goto L9;
        r111.onError(this.f32900k, this.f32901l, this.f32902m, r101, r112);
    L9:
        a(this.f32900k, this.f32901l, this.f32902m, r101, r112);
    }

    private void a(String r100, String r101, int r102, Map<String, Integer> r103) {
        Iterator<d<ILicenseAuthManagerListener>> r104 = f32891b.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        ILicenseAuthManagerListener r105 = r104.next().get();
        if (r105 == null) goto L7;
        r105.onSuccess(r100, r101, r102, r103);
        goto L4
    L7:
        r104.remove();
        goto L4
    }

    private void a(String r100, String r110, int r111, int r112, String r113) {
        Iterator<d<ILicenseAuthManagerListener>> r101 = f32891b.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        ILicenseAuthManagerListener r102 = r101.next().get();
        if (r102 == null) goto L7;
        r102.onError(r100, r110, r111, r112, r113);
        goto L4
    L7:
        r101.remove();
        goto L4
    }

    public static /* synthetic */ void a(LicenseAuthManager r100, String r101, String r102, int r103, Map r104) {
        r100.a(r101, r102, r103, r104);
    }

    public static /* synthetic */ void a(LicenseAuthManager r100, String r101, String r102, int r103, int r104, String r105) {
        r100.a(r101, r102, r103, r104, r105);
    }

    private LicenseAuthManager(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, int r112, List<IExtraLicenseAuth> r113) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = PermissionCheck.getApiKey();
    L5:
        this.f32893d = r100;
        CommonInfo r107 = Initializer.getCommonInfo();
        String r108 = "";
        if (TextUtils.isEmpty(r101) == true) goto L8;
        this.f32894e = r101;
    L13:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        this.f32895f = r102;
    L20:
        if (TextUtils.isEmpty(r103) == false) goto L22;
        r103 = g.c();
    L22:
        this.f32896g = r103;
        if (TextUtils.isEmpty(r104) == false) goto L25;
        r104 = g.o();
    L25:
        this.f32897h = r104;
        if (TextUtils.isEmpty(r105) == false) goto L28;
        r105 = g.k();
    L28:
        this.f32898i = r105;
        if (TextUtils.isEmpty(r106) == false) goto L31;
        r106 = g.l();
    L31:
        this.f32899j = r106;
        this.f32900k = r110;
        this.f32901l = r111;
        this.f32902m = r112;
        this.f32903n = r113;
        return;
    L15:
        if (r107 == null) goto L18;
        r108 = r107.getShareDeviceId();
    L18:
        this.f32895f = r108;
        goto L20
    L8:
        if (r107 != null) goto L10;
        String r109 = "";
    L11:
        this.f32894e = r109;
        goto L13
    L10:
        r109 = r107.getChannel();
        goto L11
    }

    public /* synthetic */ LicenseAuthManager(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, int r110, List r111, a r112) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111);
    }
}
