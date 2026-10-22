package cn.com.chinatelecom.account.api.external.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.e0;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.net.InetAddress;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class SwitchNetManagerExternal implements ISwitchNetExternal {
    public static int DELAY_CHECK = 2500;
    private static final int RT_ERROR = -1;
    private static final int RT_OK = 0;
    private static final int RT_TIMEOUT = -2;
    private static final String TAG = "SwitchNetManagerExternal";
    private static Handler handler;
    private Context context;
    private boolean isCallback;
    private ConnectivityManager.NetworkCallback myNetCallback;

    static {
        handler = new Handler(Looper.getMainLooper());
    }

    public SwitchNetManagerExternal(Context r100) {
        this.context = r100;
    }

    public SwitchNetManagerExternal(Context r100, int r101) {
        this.context = r100;
        DELAY_CHECK = r101;
    }

    public static /* synthetic */ boolean access$000(SwitchNetManagerExternal r100) {
        return r100.isCallback();
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void access$100(SwitchNetManagerExternal r100) {
        r100.setCallback();
    }

    public static /* synthetic */ int access$200(SwitchNetManagerExternal r100, String r101) {
        return r100.switchToMobileNetV4(r101);
    }

    public static /* synthetic */ Handler access$300() {
        return handler;
    }

    private void checkTimeOut(final SwitchCalllBackExternal r100) {
        handler.postDelayed(new AnonymousClass1(this, r100), DELAY_CHECK);
    }

    public static String extractAddressFromUrl(String r100) {
        int r101 = r100.indexOf("://");
        if (r101 <= 0) goto L5;
        r100 = r100.substring(r101 + 3);
    L5:
        int r102 = r100.indexOf(58);
        if (r102 < 0) goto L8;
        r100 = r100.substring(0, r102);
    L8:
        int r103 = r100.indexOf(47);
        if (r103 < 0) goto L11;
        r100 = r100.substring(0, r103);
    L11:
        int r104 = r100.indexOf(63);
        if (r104 >= 0) goto L14;
        return r100;
    L14:
        return r100.substring(0, r104);
    }

    private synchronized boolean isCallback() {
        monitor-enter(this);
        boolean r100 = this.isCallback;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public static int lookupHost(String r100) {
        byte[] r101 = InetAddress.getByName(r100).getAddress();
        int r102 = (((r101[3] & UByte.MAX_VALUE) << 24) | ((r101[2] & UByte.MAX_VALUE) << 16)) | ((r101[1] & UByte.MAX_VALUE) << 8);
        return (r101[0] & UByte.MAX_VALUE) | r102;
    L5:
        th = move-exception;
        CtAuth.warn(TAG, "When InetAddress.getByName(),throws exception", th);
        return -1;
    }

    private synchronized void setCallback() {
        monitor-enter(this);
        this.isCallback = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private int switchToMobileNetV4(String r110) {
        Class r100 = INVOKESTATIC_cn_com_chinatelecom_account_api_external_manager_SwitchNetManagerExternal_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.net.ConnectivityManager");     // Catch: Throwable -> L19
        ConnectivityManager r101 = (ConnectivityManager) this.context.getSystemService("connectivity");     // Catch: Throwable -> L19
        if (r101.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) goto L14;
        r100.getMethod("startUsingNetworkFeature", new Class[]{Integer.TYPE, String.class}).invoke(r101, new Object[]{0, "enableHIPRI"});     // Catch: Throwable -> L19
        int r102 = DELAY_CHECK / 500;     // Catch: Throwable -> L12
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L14;
        if (r101.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) goto L14;
        Thread.sleep(500);     // Catch: Throwable -> L12
        r103 = r103 + 1;
        goto L6
    L12:
        th = move-exception;
        CtAuth.warn(TAG, "STMN_V4", th);     // Catch: Throwable -> L19
    L14:
        int r111 = lookupHost(extractAddressFromUrl(r110));     // Catch: Throwable -> L19
        Class<?> r104 = Integer.TYPE;     // Catch: Throwable -> L19
        boolean r112 = ((Boolean) r100.getMethod("requestRouteToHost", new Class[]{r104, r104}).invoke(r101, new Object[]{5, Integer.valueOf(r111)})).booleanValue();     // Catch: Throwable -> L19
        CtAuth.info(TAG, "STMN_V4 ：" + r112);     // Catch: Throwable -> L19
        if (r112 == false) goto L17;
        return 0;
    L17:
        return -2;
    L19:
        th = move-exception;
        CtAuth.warn(TAG, "STMN_V4_T", th);
        return -1;
    }

    @Override // cn.com.chinatelecom.account.api.external.manager.ISwitchNetExternal
    public void switchToMobileNetV4(final SwitchCalllBackExternal r100, final String r101) {
        new e0().a(new AnonymousClass3(this, r101, r100));
    }

    @Override // cn.com.chinatelecom.account.api.external.manager.ISwitchNetExternal
    public void switchToMobileNetV5(final SwitchCalllBackExternal r100) {
        final long r101 = System.currentTimeMillis();
        checkTimeOut(r100);     // Catch: Throwable -> L5
        ConnectivityManager r102 = (ConnectivityManager) this.context.getSystemService("connectivity");     // Catch: Throwable -> L5
        NetworkRequest.Builder r103 = new NetworkRequest.Builder();     // Catch: Throwable -> L5
        r103.addCapability(12);     // Catch: Throwable -> L5
        r103.addTransportType(0);     // Catch: Throwable -> L5
        NetworkRequest r104 = r103.build();     // Catch: Throwable -> L5
        ConnectivityManager.NetworkCallback r105 = new AnonymousClass2(this, r100, r101);     // Catch: Throwable -> L5
        this.myNetCallback = r105;     // Catch: Throwable -> L5
        r102.requestNetwork(r104, r105);     // Catch: Throwable -> L5
        return;
    L6:
        if (isCallback() == true) goto L12;
        if (r100 == null) goto L13;
        r100.onSwitchError(System.currentTimeMillis() - r101);
        return;
    L13:
        return;
    }

    public void unregisterNetwork() {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.myNetCallback == null) goto L11;
        ((ConnectivityManager) this.context.getSystemService("connectivity")).unregisterNetworkCallback(this.myNetCallback);     // Catch: Throwable -> L6
        this.myNetCallback = null;     // Catch: Throwable -> L6
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_cn_com_chinatelecom_account_api_external_manager_SwitchNetManagerExternal_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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
}
