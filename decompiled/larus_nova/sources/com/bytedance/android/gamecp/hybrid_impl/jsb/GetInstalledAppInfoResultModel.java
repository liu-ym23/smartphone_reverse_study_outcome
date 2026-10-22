package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003\u0019\u0007\u000eB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel;", "Le7/k0;", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$Code;", "code", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$Code;)V", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$a;", "data", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$a;", "getData", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$a;", "b", "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetInstalledAppInfoResultModel implements e7.k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements e7.j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f57473a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r102;
            Code r103 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r103;
            f57473a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f57473a.clone();
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$a;", "", "", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$b;", "packageInfos", "Ljava/util/List;", "getPackageInfos", "()Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/util/List;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("packageInfos")
        private List<b> packageInfos;

        public a() {
        }

        public final void a(List<b> r100) {
            this.packageInfos = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GetInstalledAppInfoResultModel$b;", "", "", "packageName", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "appName", "getAppName", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "versionName", "getVersionName", ce.f26391f, RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "f", "installTime", "getInstallTime", "c", "icon", "getIcon", "b", UserInfo.UPDATE_TIME, "getUpdateTime", "e", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("appName")
        private String appName;

        @SerializedName("icon")
        private String icon;

        @SerializedName("installTime")
        private String installTime;

        @SerializedName("packageName")
        private String packageName;

        @SerializedName(UserInfo.UPDATE_TIME)
        private String updateTime;

        @SerializedName(RuleConditionBean.VERSION_CODE_KEY)
        private String versionCode;

        @SerializedName("versionName")
        private String versionName;

        public b() {
        }

        public final void a(String r100) {
            this.appName = r100;
        }

        public final void b(String r100) {
            this.icon = r100;
        }

        public final void c(String r100) {
            this.installTime = r100;
        }

        public final void d(String r100) {
            this.packageName = r100;
        }

        public final void e(String r100) {
            this.updateTime = r100;
        }

        public final void f(String r100) {
            this.versionCode = r100;
        }

        public final void g(String r100) {
            this.versionName = r100;
        }
    }

    public GetInstalledAppInfoResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(a r100) {
        this.data = r100;
    }
}
