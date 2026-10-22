package com.baidu.platform.comapi.license;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapauto.auth.AuthCore;
import com.baidu.mapauto.auth.ILicenseAuthListener;
import com.baidu.mapauto.auth.LicenseAuth;
import com.baidu.mapauto.auth.base.BaseLicenseAuthDataStandardProcess;
import com.baidu.mapauto.auth.constant.ErrorCode;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class LicenseAuthManager implements ILicenseAuthManager {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<b, Map<String, Integer>> f8751a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<d<ILicenseAuthManagerListener>> f8752b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Integer, Integer> f8753c;

    /* renamed from: d, reason: collision with root package name */
    private final String f8754d;

    /* renamed from: e, reason: collision with root package name */
    private final String f8755e;

    /* renamed from: f, reason: collision with root package name */
    private final String f8756f;

    /* renamed from: g, reason: collision with root package name */
    private final String f8757g;

    /* renamed from: h, reason: collision with root package name */
    private final String f8758h;

    /* renamed from: i, reason: collision with root package name */
    private final String f8759i;

    /* renamed from: j, reason: collision with root package name */
    private final String f8760j;

    /* renamed from: k, reason: collision with root package name */
    private final String f8761k;

    /* renamed from: l, reason: collision with root package name */
    private final String f8762l;

    /* renamed from: m, reason: collision with root package name */
    private final int f8763m;

    /* renamed from: n, reason: collision with root package name */
    private final List<IExtraLicenseAuth> f8764n;

    /* renamed from: o, reason: collision with root package name */
    private ILicenseAuthListener f8765o;

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

        public Builder ak(String str) {
            this.mAk = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.mAppVersion = str;
            return this;
        }

        public ILicenseAuthManager build() {
            return new LicenseAuthManager(this.mAk, this.mChannel, this.mDeviceId, this.mCuid, this.mAppVersion, this.mOsVersion, this.mModel, this.mServiceName, this.mFunctionName, this.mType, this.mExtraLicenseAuths);
        }

        public Builder channel(String str) {
            this.mChannel = str;
            return this;
        }

        public Builder cuid(String str) {
            this.mCuid = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.mDeviceId = str;
            return this;
        }

        public Builder extraAuth(List<IExtraLicenseAuth> list) {
            this.mExtraLicenseAuths = list;
            return this;
        }

        public Builder functionName(String str) {
            this.mFunctionName = str;
            return this;
        }

        public Builder model(String str) {
            this.mModel = str;
            return this;
        }

        public Builder osVersion(String str) {
            this.mOsVersion = str;
            return this;
        }

        public Builder serviceName(String str) {
            this.mServiceName = str;
            return this;
        }

        public Builder type(int i4) {
            this.mType = i4;
            return this;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f8766a;

        /* renamed from: b, reason: collision with root package name */
        private final String f8767b;

        /* renamed from: c, reason: collision with root package name */
        private final String f8768c;

        public b(String str, String str2, int i4) {
            this.f8767b = str;
            this.f8768c = str2;
            this.f8766a = i4;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            String str = "" + this.f8767b + "" + this.f8768c + "" + this.f8766a;
            StringBuilder sb = new StringBuilder("");
            b bVar = (b) obj;
            sb.append(bVar.f8767b);
            sb.append("");
            sb.append(bVar.f8768c);
            sb.append("");
            sb.append(bVar.f8766a);
            return str.equals(sb.toString());
        }

        public int hashCode() {
            if (TextUtils.isEmpty(this.f8767b) && TextUtils.isEmpty(this.f8768c)) {
                return super.hashCode();
            }
            int iHashCode = this.f8766a;
            if (!TextUtils.isEmpty(this.f8767b)) {
                iHashCode = (iHashCode * 31) + this.f8767b.hashCode();
            }
            return !TextUtils.isEmpty(this.f8768c) ? (iHashCode * 31) + this.f8768c.hashCode() : iHashCode;
        }
    }

    public class c implements ILicenseAuthListener {

        /* renamed from: a, reason: collision with root package name */
        private final ILicenseAuthManagerListener f8769a;

        public c(ILicenseAuthManagerListener iLicenseAuthManagerListener) {
            this.f8769a = iLicenseAuthManagerListener;
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public void onError(int i4, String str) {
            int iA = LicenseAuthManager.this.a(i4);
            LicenseAuthManager.f8751a.remove(new b(LicenseAuthManager.this.f8761k, LicenseAuthManager.this.f8762l, LicenseAuthManager.this.f8763m));
            ILicenseAuthManagerListener iLicenseAuthManagerListener = this.f8769a;
            if (iLicenseAuthManagerListener != null) {
                iLicenseAuthManagerListener.onError(LicenseAuthManager.this.f8761k, LicenseAuthManager.this.f8762l, LicenseAuthManager.this.f8763m, iA, str);
            }
            LicenseAuthManager licenseAuthManager = LicenseAuthManager.this;
            licenseAuthManager.a(licenseAuthManager.f8761k, LicenseAuthManager.this.f8762l, LicenseAuthManager.this.f8763m, iA, str);
        }

        @Override // com.baidu.mapauto.auth.ILicenseAuthListener
        public void onSuccess(Map<String, Integer> map) {
            LicenseAuthManager.f8751a.put(new b(LicenseAuthManager.this.f8761k, LicenseAuthManager.this.f8762l, LicenseAuthManager.this.f8763m), map);
            ILicenseAuthManagerListener iLicenseAuthManagerListener = this.f8769a;
            if (iLicenseAuthManagerListener != null) {
                iLicenseAuthManagerListener.onSuccess(LicenseAuthManager.this.f8761k, LicenseAuthManager.this.f8762l, LicenseAuthManager.this.f8763m, map);
            }
            LicenseAuthManager licenseAuthManager = LicenseAuthManager.this;
            licenseAuthManager.a(licenseAuthManager.f8761k, LicenseAuthManager.this.f8762l, LicenseAuthManager.this.f8763m, map);
        }
    }

    public static class d<T> extends WeakReference<T> {
        public d(T t4) {
            super(t4);
        }

        public boolean equals(Object obj) {
            T t4 = get();
            return t4 != null ? t4.equals(obj) : super.equals(obj);
        }

        public int hashCode() {
            T t4 = get();
            return t4 != null ? t4.hashCode() : super.hashCode();
        }
    }

    static {
        HashMap map = new HashMap();
        f8753c = map;
        map.put(0, 0);
        map.put(Integer.valueOf(ErrorCode.CODE_INNER_ERROR), 1);
        map.put(Integer.valueOf(ErrorCode.CODE_PARAMETER_ERROR), 2);
        map.put(Integer.valueOf(ErrorCode.CODE_NET_WORK_ERROR), 100);
        map.put(Integer.valueOf(ErrorCode.CODE_NET_WORK_TIMEOUT), 101);
        map.put(Integer.valueOf(ErrorCode.CODE_SERVER_ERROR), 102);
        map.put(Integer.valueOf(ErrorCode.CODE_CHECK_SIGN_ERROR), Integer.valueOf(LicenseCode.CODE_LICENSE_SERVICE_LICENSE_SIGN_ERROR));
        map.put(Integer.valueOf(ErrorCode.CODE_UNKNOWN_ERROR), 1000);
    }

    public static void addLicenseAuthLicense(ILicenseAuthManagerListener iLicenseAuthManagerListener) {
        f8752b.add(new d<>(iLicenseAuthManagerListener));
    }

    public static void removeLicenseAuthLicense(ILicenseAuthManagerListener iLicenseAuthManagerListener) {
        Iterator<d<ILicenseAuthManagerListener>> it = f8752b.iterator();
        while (it.hasNext()) {
            ILicenseAuthManagerListener iLicenseAuthManagerListener2 = it.next().get();
            if (iLicenseAuthManagerListener2 == null) {
                it.remove();
            } else if (iLicenseAuthManagerListener2 == iLicenseAuthManagerListener) {
                it.remove();
            }
        }
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public boolean isEffective(String str, String str2) {
        if (("" + this.f8761k).equals("" + str)) {
            if (("" + this.f8762l).equals("" + str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public boolean isHaveAuthority() {
        Integer num;
        Map<String, Integer> map = f8751a.get(new b(this.f8761k, this.f8762l, this.f8763m));
        return (map == null || (num = map.get(this.f8762l)) == null || num.intValue() != 0) ? false : true;
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public void loadAuth(Context context, ILicenseAuthManagerListener iLicenseAuthManagerListener) {
        try {
            b();
            HashMap map = new HashMap();
            map.put(AuthCore.AuthParam.KEY_EXTRA_CUID, this.f8757g);
            map.put(AuthCore.AuthParam.KEY_EXTRA_APP_VERSION, this.f8758h);
            map.put(AuthCore.AuthParam.KEY_EXTRA_OS_VERSION, this.f8759i);
            map.put(AuthCore.AuthParam.KEY_EXTRA_MODEL, this.f8760j);
            this.f8765o = new c(iLicenseAuthManagerListener);
            LicenseAuth.getInstance().loadAuth(context, this.f8754d, this.f8755e, this.f8756f, this.f8761k, this.f8762l, this.f8763m, map, this.f8765o);
        } catch (BaseLicenseAuthDataStandardProcess.ProcessException e4) {
            int code = e4.getCode();
            String message = e4.getMessage();
            f8751a.remove(new b(this.f8761k, this.f8762l, this.f8763m));
            if (iLicenseAuthManagerListener != null) {
                iLicenseAuthManagerListener.onError(this.f8761k, this.f8762l, this.f8763m, code, message);
            }
            a(this.f8761k, this.f8762l, this.f8763m, code, message);
        }
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public Map<String, Integer> loadLocalAuth(Context context) throws BaseLicenseAuthDataStandardProcess.ProcessException {
        b();
        try {
            return LicenseAuth.getInstance().loadLocalAuth(context, this.f8754d, this.f8755e, this.f8756f, this.f8761k, this.f8762l, this.f8763m);
        } catch (BaseLicenseAuthDataStandardProcess.ProcessException e4) {
            throw new BaseLicenseAuthDataStandardProcess.ProcessException(this.a(e4.getCode()), e4.getMessage());
        }
    }

    private LicenseAuthManager(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i4, List<IExtraLicenseAuth> list) {
        this.f8754d = TextUtils.isEmpty(str) ? PermissionCheck.getApiKey() : str;
        CommonInfo commonInfo = Initializer.getCommonInfo();
        if (TextUtils.isEmpty(str2)) {
            this.f8755e = commonInfo == null ? "" : commonInfo.getChannel();
        } else {
            this.f8755e = str2;
        }
        if (TextUtils.isEmpty(str3)) {
            this.f8756f = commonInfo != null ? commonInfo.getShareDeviceId() : "";
        } else {
            this.f8756f = str3;
        }
        this.f8757g = TextUtils.isEmpty(str4) ? f.c() : str4;
        this.f8758h = TextUtils.isEmpty(str5) ? f.n() : str5;
        this.f8759i = TextUtils.isEmpty(str6) ? f.j() : str6;
        this.f8760j = TextUtils.isEmpty(str7) ? f.k() : str7;
        this.f8761k = str8;
        this.f8762l = str9;
        this.f8763m = i4;
        this.f8764n = list;
    }

    private void b() throws BaseLicenseAuthDataStandardProcess.ProcessException {
        List<IExtraLicenseAuth> list = this.f8764n;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<IExtraLicenseAuth> it = list.iterator();
        while (it.hasNext()) {
            it.next().check();
        }
    }

    @Override // com.baidu.platform.comapi.license.ILicenseAuthManager
    public boolean isHaveAuthority(Map<String, Integer> map) {
        Integer num;
        return (map == null || (num = map.get(this.f8762l)) == null || num.intValue() != 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i4, Map<String, Integer> map) {
        Iterator<d<ILicenseAuthManagerListener>> it = f8752b.iterator();
        while (it.hasNext()) {
            ILicenseAuthManagerListener iLicenseAuthManagerListener = it.next().get();
            if (iLicenseAuthManagerListener == null) {
                it.remove();
            } else {
                iLicenseAuthManagerListener.onSuccess(str, str2, i4, map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i4, int i5, String str3) {
        Iterator<d<ILicenseAuthManagerListener>> it = f8752b.iterator();
        while (it.hasNext()) {
            ILicenseAuthManagerListener iLicenseAuthManagerListener = it.next().get();
            if (iLicenseAuthManagerListener == null) {
                it.remove();
            } else {
                iLicenseAuthManagerListener.onError(str, str2, i4, i5, str3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i4) {
        Integer num = f8753c.get(Integer.valueOf(i4));
        return num == null ? i4 : num.intValue();
    }
}
