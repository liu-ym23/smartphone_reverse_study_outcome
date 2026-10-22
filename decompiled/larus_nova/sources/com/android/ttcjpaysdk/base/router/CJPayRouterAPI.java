package com.android.ttcjpaysdk.base.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayActivityUtils;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayRouterAPI {
    private static final String TAG = "CJPayRouterAPI";
    private static CJPayRouterAPI instance;

    public static class Builder {
        private int addFlags;
        private Bundle bundle;
        private Class clazz;
        private int enterAnim;
        private int exitAnim;
        private String packageName;
        private int setFlags;

        public Builder(Class r100) {
            this.bundle = new Bundle();
            this.enterAnim = 0;
            this.exitAnim = 0;
            this.setFlags = -1;
            this.addFlags = -1;
            this.clazz = r100;
        }

        public Builder addFlags(int r100) {
            this.addFlags = r100;
            return this;
        }

        public Object navigation(Context r100) {
            return navigation(r100, -1);
        }

        public Builder setFlags(int r100) {
            this.setFlags = r100;
            return this;
        }

        public Builder setPackage(String r100) {
            this.packageName = r100;
            return this;
        }

        public Builder withAnimationType(int r100) {
            if (1 != r100) goto L6;
            int[] r101 = CJPayActivityUtils.getAddOrRemoveAnimRes();
            this.enterAnim = r101[0];
            this.exitAnim = r101[1];
        L8:
            return this;
        L6:
            if (3 != r100) goto L8;
            int[] r102 = CJPayActivityUtils.getFadeInOrOutAnimRes();
            this.enterAnim = r102[0];
            this.exitAnim = r102[1];
            goto L8
        }

        public Object navigation(Context r100, int r101) {
        L34:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayRouterAPI#navigation", e);
            CJLogger.b(CJPayRouterAPI.TAG, "navigation: e=" + e);
        L36:
            return null;
        L4:
            if (Activity.class.isAssignableFrom(this.clazz) == false) goto L31;
            Intent r102 = new Intent(r100, this.clazz);     // Catch: Exception -> L34
            int r103 = this.setFlags;     // Catch: Exception -> L34
            if (r103 == (-1)) goto L8;
            r102.setFlags(r103);     // Catch: Exception -> L34
        L8:
            int r104 = this.addFlags;     // Catch: Exception -> L34
            if (r104 == (-1)) goto L12;
            r102.addFlags(r104);     // Catch: Exception -> L34
        L12:
            if (TextUtils.isEmpty(this.packageName) == true) goto L14;
            r102.setPackage(this.packageName);     // Catch: Exception -> L34
        L14:
            r102.putExtras(this.bundle);     // Catch: Exception -> L34
            if ((r100 instanceof Activity) == true) goto L17;
            r102.setFlags(268435456);     // Catch: Exception -> L34
        L17:
            if (r101 > 0) goto L19;
        L21:
            r100.startActivity(r102);     // Catch: Exception -> L34
        L22:
            int r105 = this.exitAnim;     // Catch: Exception -> L34
            if (r105 != 0) goto L27;
            if (this.enterAnim != 0) goto L27;
        L29:
            return null;
        L27:
            if ((r100 instanceof Activity) == false) goto L29;
            ((Activity) r100).overridePendingTransition(this.enterAnim, r105);     // Catch: Exception -> L34
            goto L29
        L19:
            if ((r100 instanceof Activity) == false) goto L21;
            ((Activity) r100).startActivityForResult(r102, r101);     // Catch: Exception -> L34
            goto L22
        L31:
            if (Fragment.class.isAssignableFrom(this.clazz) == false) goto L36;
            Fragment r106 = (Fragment) this.clazz.newInstance();     // Catch: Exception -> L34
            r106.setArguments(this.bundle);     // Catch: Exception -> L34
            return r106;
        }

        public Builder withBoolean(String r100, boolean r101) {
            this.bundle.putBoolean(r100, r101);
            return this;
        }

        public Builder withBundle(String r100, Bundle r101) {
            this.bundle.putBundle(r100, r101);
            return this;
        }

        public Builder withInt(String r100, int r101) {
            this.bundle.putInt(r100, r101);
            return this;
        }

        public Builder withLong(String r100, long r101) {
            this.bundle.putLong(r100, r101);
            return this;
        }

        public Builder withParcelable(String r100, Parcelable r101) {
            this.bundle.putParcelable(r100, r101);
            return this;
        }

        public Builder withSerializable(String r100, Serializable r101) {
            this.bundle.putSerializable(r100, r101);
            return this;
        }

        public Builder withString(String r100, String r101) {
            this.bundle.putString(r100, r101);
            return this;
        }
    }

    private CJPayRouterAPI() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static CJPayRouterAPI getInstance() {
        if (instance != null) goto L15;
        monitor-enter(CJPayRouterAPI.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new CJPayRouterAPI();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CJPayRouterAPI.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_android_ttcjpaysdk_base_router_CJPayRouterAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public Builder build(String r100) {
        return new Builder(INVOKESTATIC_com_android_ttcjpaysdk_base_router_CJPayRouterAPI_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100));
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayRouterAPI#build", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayRouterAPI#build", e);
        CJReporter r101 = CJReporter.f202294a;
        CJReporter.m(null, "rooter_exception", 2, e);
        return null;
    }

    public <T extends Fragment> Builder buildF(Class<T> r100) {
        return new Builder(r100);
    }

    public <T extends AppCompatActivity> Builder build(Class<T> r100) {
        return new Builder(r100);
    }
}
