package com.bytedanceos.common.toolbox;

import android.R;
import android.app.Activity;
import android.app.ActivityManagerNative;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.storage.StorageManager;
import android.text.Layout;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.AnimationEndCallBack;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$attr;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.core.install.GmsInstallService;
import com.bytedanceos.common.core.ui.AboutActivity;
import com.bytedanceos.common.core.ui.AppDetailActivity;
import com.bytedanceos.common.core.ui.CommentsActivity;
import com.bytedanceos.common.download.AppsDownloadService;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.MobileInfo;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.tracker.TrackerElement;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.bytedanceos.common.ui.BasicActivity;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.bytedanceos.common.ui.ConfirmLoginInfoActivity;
import com.bytedanceos.common.ui.ImageDetailActivity;
import com.bytedanceos.common.ui.widget.oui.OUIAppItemView;
import com.bytedanceos.common.utils.ReflectTool;
import com.obric.appstore.network.entity.template.ElementTextEntity;
import com.obric.oui.tag.OTextTag;
import java.io.File;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DecimalFormatSymbols f10019a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f10020b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10021c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f10022d;

    public class a implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f10023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f10024b;

        public a(AppInfo r10, CountDownLatch r11) {
            this.f10023a = r10;
            this.f10024b = r11;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
            j.n("request diff patch result:" + r12);
            this.f10024b.countDown();
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            j.n("request diff patch result:" + r12);
            c9.a.U(r10, this.f10023a, r12);
            this.f10024b.countDown();
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimationEndCallBack f10025a;

        public b(AnimationEndCallBack r10) {
            this.f10025a = r10;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
            AnimationEndCallBack r11 = this.f10025a;
            if (r11 == null) goto L6;
            r11.fetchData(new Object[0]);
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10028c;

        public c() {
        }
    }

    static {
    }

    public static synchronized int A() {
        monitor-enter(e.class);
        ConnectivityManager r10 = (ConnectivityManager) BaseApplication.c().getSystemService("connectivity");     // Catch: Throwable -> L20
        NetworkInfo.State r11 = r10.getNetworkInfo(1).getState();     // Catch: Throwable -> L20 Exception -> L22
        NetworkInfo.State r12 = NetworkInfo.State.CONNECTED;     // Catch: Throwable -> L20 Exception -> L22
        if (r11 != r12) goto L12;
        monitor-exit(e.class);
        return 2;
    L12:
        if (r10.getNetworkInfo(0).getState() != r12) goto L16;
        monitor-exit(e.class);
        return 1;
    L16:
        if (r10.getNetworkInfo(9).getState() != r12) goto L24;
        monitor-exit(e.class);
        return 2;
    L24:
        monitor-exit(e.class);
        return 0;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static boolean A0(Context r10) {
        NetworkInfo r11 = t();
        if (r11 != null) goto L7;
        j.a("no default network is currently active");
        return false;
    L7:
        return r11.isConnected();
    }

    public static void A1(TextView r10, int r11) {
        switch(r11) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L3;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        j.a("lable = " + r11);
        return;
    L4:
        r10.setText(R$string.label_tnt);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_first));
        r10.setBackgroundResource(R$drawable.tag_first_bg);
        return;
    L5:
        r10.setText(R$string.label_pre_download);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_game));
        r10.setBackgroundResource(R$drawable.tag_onestep_bg);
        return;
    L6:
        r10.setText(R$string.label_one_step);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_one_step));
        r10.setBackgroundResource(R$drawable.tag_onestep_bg);
        return;
    L7:
        r10.setText(R$string.label_promote);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_promote));
        r10.setBackgroundResource(R$drawable.tag_ads_bg);
        return;
    L8:
        r10.setText(R$string.label_gift);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_gift));
        r10.setBackgroundResource(R$drawable.tag_gift_bg);
        return;
    L9:
        r10.setText(R$string.label_selected);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_selected));
        r10.setBackgroundResource(R$drawable.tag_selected_bg);
        return;
    L10:
        r10.setText(R$string.label_game);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_game));
        r10.setBackgroundResource(R$drawable.tag_onestep_bg);
        return;
    L11:
        r10.setText(R$string.label_first);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_first));
        r10.setBackgroundResource(R$drawable.tag_first_bg);
        return;
    L12:
        r10.setText(R$string.label_ads);
        r10.setTextColor(r10.getContext().getResources().getColor(R$color.label_ad));
        r10.setBackgroundResource(R$drawable.tag_ad_bg);
    }

    public static String B(String r10, int r11) {
        return r10 + "@0o_0l_" + r11 + "w_100q";
    }

    public static boolean B0() {
        long r10 = Calendar.getInstance().get(11);
        h8.b r11 = h8.b.b();
        if (r10 >= r11.e()) goto L5;
    L7:
        return false;
    L5:
        if (r10 > r11.c()) goto L7;
        j.n("[AutoUpdate][AppStatus] night mode,hour:" + r10);
        return true;
    }

    public static String C(AppInfo r10, boolean r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.appPackageName);
        r12.append("_");
        r12.append(r10.appVersionCode);
        if (r11 == false) goto L5;
        r12.append("_bak.patch");
    L7:
        return r12.toString();
    L5:
        r12.append(".patch");
        goto L7
    }

    public static boolean C0() {
        DisplayMetrics r10 = new DisplayMetrics();
        ((DisplayManager) BaseApplication.c().getSystemService("display")).getDisplay(0).getRealMetrics(r10);
        int r11 = SystemProperties.getInt("ro.sf.lcd_density", 400);
        if (r10.densityDpi != r11) goto L6;
        return true;
    L6:
        return false;
    }

    public static String D() {
        return Environment.DIRECTORY_DOWNLOADS;
    }

    public static boolean D0() {
        return ((PowerManager) BaseApplication.c().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).isInteractive();
    }

    public static String E(CommonCache r10, AppInfo r11) {
        String r12 = null;
        if (r11 != null) goto L6;
        j.n("input param error");
        return null;
    L6:
        File r13 = new File(H(), v(r11, true));
        if (r13.exists() == true) goto L9;
        if (r10 == null) goto L16;
        AppInfo r14 = r10.t(r11.appPackageName);
        if (r14 == null) goto L16;
        if (TextUtils.isEmpty(r14.downloadFilePath) == true) goto L16;
        r12 = r14.downloadFilePath;
    L16:
        j.n("downloadFile:" + r12);
        return r12;
    L9:
        return r13.getAbsolutePath();
    }

    public static boolean E0(String r10) {
        if (j8.a.a().c(r10) == true) goto L5;
        return false;
    L5:
        if (i0(r10) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static String F() {
        if (BaseApplication.c().o() == false) goto L6;
        return "/obric/appstore/";
    L6:
        return "/obric/gamestore/";
    }

    public static boolean F0(AppInfo r10) {
        if (r10.isSystemApp() == true) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(r10.appPackageName) == true) goto L13;
        if (BaseApplication.c().getPackageManager().getLaunchIntentForPackage(r10.appPackageName) != null) goto L16;
        return true;
    L16:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static boolean G(int r10) {
        String r11 = b0.n().s("last_day", null, BaseApplication.c());     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r11) == true) goto L19;
        String[] r12 = r11.split(";");     // Catch: Exception -> L16
        if (r12.length < 3) goto L18;
        boolean r13 = DateUtils.isToday(c0.c(r12[0]));     // Catch: Exception -> L16
        boolean r14 = Boolean.parseBoolean(r12[2]);     // Catch: Exception -> L14
        boolean r15 = Boolean.parseBoolean(r12[1]);     // Catch: Exception -> L12
    L22:
        if (r10 != 0) goto L27;
        if (r13 == false) goto L35;
        if (r14 == true) goto L26;
        return false;
    L26:
        return true;
    L35:
        return false;
    L27:
        if (1 != r10) goto L29;
        return r15;
    L29:
        return false;
    L12:
        e = e;
    L20:
        e.printStackTrace();
    L21:
        r15 = true;
    L14:
        e = e;
        r14 = false;
        goto L20
    L18:
        j.a("data exception:" + r11);     // Catch: Exception -> L16
    L19:
        r13 = false;
        r14 = false;
    L16:
        e = e;
        r13 = false;
        r14 = false;
        goto L20
    }

    public static boolean G0() {
        if ((BaseApplication.c().getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static File H() {
        File r10 = new File(Environment.getExternalStoragePublicDirectory(D()), F());
        if (r10.exists() == false) goto L8;
        if (r10.isDirectory() == true) goto L8;
        r10.delete();
        j.e(r10.getAbsolutePath() + " already exists and is not a directory");
    L8:
        if (r10.exists() == true) goto L13;
        File r11 = r10.getParentFile();
        if (r11.exists() == true) goto L12;
        j.e(r11.getAbsolutePath() + " create parent file," + r11.mkdir());
    L12:
        j.e(r10.getAbsolutePath() + " create sub file," + r10.mkdirs());
    L13:
        return r10;
    }

    public static boolean H0(int r10) {
        if (r10 != 1) goto L5;
    L18:
        return true;
    L5:
        if (r10 == 2) goto L18;
        if (r10 == 4) goto L18;
        if (r10 == 5) goto L18;
        if (r10 == 6) goto L18;
        if (r10 == 7) goto L18;
        if (r10 == 9) goto L18;
        j.a("lable = " + r10);
        return false;
    }

    public static long I() {
        String r10 = Environment.getExternalStorageDirectory().getPath();     // Catch: Exception -> L9
        if (new File(r10).exists() == false) goto L8;
        StatFs r11 = new StatFs(r10);     // Catch: Exception -> L9
        long r12 = r11.getBlockSizeLong();     // Catch: Exception -> L9
        long r13 = r11.getAvailableBlocksLong();     // Catch: Exception -> L9
        return (r12 * r13) - StorageManager.from(BaseApplication.c()).getStorageLowBytes(Environment.getDataDirectory());
    L8:
        return 1;
    }

    public static boolean I0() {
        NetworkInfo r10 = t();
        if (r10 != null) goto L7;
        j.a("no default network is currently active");
        return false;
    L7:
        if (r10.getType() == 1) goto L11;
        j.a("network type:" + r10.getType());
        return false;
    L11:
        return r10.isConnected();
    }

    public static String J(long r10, long r11) {
        String r12 = "--";
        if (r10 <= 0) goto L5;
        String r13 = new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date(r10));
    L7:
        if (r11 <= 0) goto L10;
        r12 = new SimpleDateFormat("yyyy.MM.dd HH:mm").format(new Date(r11));
    L10:
        return BaseApplication.c().getString(R$string.gift_data, new Object[]{r13, r12});
    L5:
        r13 = "--";
        goto L7
    }

    public static void J0(Activity r10, String r11, boolean r12) {
        e0.e(R$string.login_not_supported_yet);
    }

    public static String K(PackageInfo r10) {
        j.n("getInstalledApkMd5 packageInfo:" + r10);
        return null;
    }

    public static boolean K0(Context r10, String r11) {
        if (r10 != null) goto L5;
    L17:
        j.b("Packagename is empty");
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L17;
        Intent r12 = r10.getPackageManager().getLaunchIntentForPackage(r11);     // Catch: Exception -> L11
        if (r12 != null) goto L13;
        j.b("can not get lanch intent:");     // Catch: Exception -> L11
        return false;
    L13:
        r12.setFlags(270532608);     // Catch: Exception -> L11
        r10.startActivity(r12);     // Catch: Exception -> L11
        j.n("launcher:" + r11);     // Catch: Exception -> L11
        return true;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static String L(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L11:
        return null;
    L5:
        if (r10.contains(AdConstant.Dsp.BYTEDANCE) == true) goto L11;
        return K(BaseApplication.c().getPackageManager().getPackageInfo(r10, 0));
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static void L0(Activity r10, Topic r11) {
        if (r10 == null) goto L12;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isAvaliable() == true) goto L8;
        return;
    L8:
        if (r11.isTopicCompat() == false) goto L10;
        y1(r10, r11);
        return;
    L10:
        x1(r10, r11);
        return;
    }

    public static AppInfo M(String r10) {
        AppInfo r11 = BaseApplication.c().b().D(r10);
        if (r11 != null) goto L10;
        ApplicationInfo r12 = BaseApplication.c().getPackageManager().getApplicationInfo(r10, 8192);     // Catch: PackageManager.NameNotFoundException -> L6
        AppInfo r13 = new AppInfo();     // Catch: PackageManager.NameNotFoundException -> L6
        r13.appVersionCode = r12.versionCode;     // Catch: PackageManager.NameNotFoundException -> L6
        r13.appPackageName = r10;     // Catch: PackageManager.NameNotFoundException -> L6
        return r13;
    L6:
        return null;
    L10:
        return r11;
    }

    public static boolean M0() {
        if (a("09:30", "12:30") == false) goto L5;
    L8:
        return true;
    L5:
        if (a("16:00", "20:00") == true) goto L8;
        return false;
    }

    public static String N(Context r10) {
        String r11 = "old";
        if (TextUtils.isEmpty(f10021c) == false) goto L5;
        String r12 = "";
        PackageInfo r13 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L20
        if (r13 == null) goto L28;
        Signature[] r14 = r13.signatures;     // Catch: PackageManager.NameNotFoundException -> L20
        if (r14 == null) goto L28;
        if (r14.length <= 0) goto L28;
        int r15 = r14[0].hashCode();     // Catch: PackageManager.NameNotFoundException -> L20
        if (r15 != (-1706120211)) goto L16;
        r12 = "old";
        goto L28
    L16:
        if (r15 != (-853932358)) goto L18;
        r12 = "odm";
        goto L28
    L18:
        if (r15 == 1710020004) goto L22;
        j.a("GoogleInstaller unknown key type!");     // Catch: PackageManager.NameNotFoundException -> L20
        goto L28
    L22:
        r12 = "formal";
    L28:
        if (TextUtils.isEmpty(r12) == true) goto L31;
        f10021c = r12;
        r11 = r12;
    L31:
        j.a("key type is : " + r11);
        return r11;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L5:
        return f10021c;
    }

    public static boolean N0(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        String r12 = w8.b.c(5, r11);
        if (TextUtils.isEmpty(r12) == false) goto L9;
        return false;
    L9:
        return r10.startsWith(r12);
    }

    public static c O(int r10) {
        c r11 = new c();
        switch(r10) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L4;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L4;
        };
    L4:
        j.a("label = " + r10);
    L14:
        return r11;
    L5:
        r11.f10026a = R$string.label_tnt;
        r11.f10027b = R$color.label_first;
        r11.f10028c = R$drawable.tag_first_bg;
        goto L14
    L6:
        r11.f10026a = R$string.label_pre_download;
        r11.f10027b = R$color.label_game;
        r11.f10028c = R$drawable.tag_onestep_bg;
        goto L14
    L7:
        r11.f10026a = R$string.label_one_step;
        r11.f10027b = R$color.label_one_step;
        r11.f10028c = R$drawable.tag_onestep_bg;
        goto L14
    L8:
        r11.f10026a = R$string.label_promote;
        r11.f10027b = R$color.label_promote;
        r11.f10028c = R$drawable.tag_ads_bg;
        goto L14
    L9:
        r11.f10026a = R$string.label_gift;
        r11.f10027b = R$color.label_gift;
        r11.f10028c = R$drawable.tag_gift_bg;
        goto L14
    L10:
        r11.f10026a = R$string.label_selected;
        r11.f10027b = R$color.label_selected;
        r11.f10028c = R$drawable.tag_selected_bg;
        goto L14
    L11:
        r11.f10026a = R$string.label_game;
        r11.f10027b = R$color.label_game;
        r11.f10028c = R$drawable.tag_onestep_bg;
        goto L14
    L12:
        r11.f10026a = R$string.label_first;
        r11.f10027b = R$color.label_first;
        r11.f10028c = R$drawable.tag_first_bg;
        goto L14
    L13:
        r11.f10026a = R$string.label_ads;
        r11.f10027b = R$color.label_ad;
        r11.f10028c = R$drawable.tag_ad_bg;
        goto L14
    }

    public static Double O0(String r10) {
        int r11 = r10.indexOf(LibrarianImpl.Constants.DOT);
        if (r11 < 0) goto L7;
        StringBuilder r12 = new StringBuilder();
        int r13 = r11 + 1;
        r12.append(r10.substring(0, r13));
        r12.append(r10.substring(r13).replace(LibrarianImpl.Constants.DOT, ""));
        return Double.valueOf(r12.toString());
    L7:
        return Double.valueOf(r10);
    }

    public static String P() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    public static void P0(String r10, boolean r11) {
        j.b("false | message:" + r10);
        if (r11 == false) goto L6;
        System.gc();
        return;
    }

    public static Bitmap Q(Bitmap r10, Bitmap r11) {
        int r12 = r11.getWidth() * r11.getHeight();
        int[] r13 = new int[r12];
        int[] r14 = new int[r12];
        r11.getPixels(r13, 0, r11.getWidth(), 0, 0, r11.getWidth(), r11.getHeight());
        Bitmap r15 = Bitmap.createScaledBitmap(r10, r11.getWidth(), r11.getHeight(), true);
        r15.getPixels(r14, 0, r15.getWidth(), 0, 0, r15.getWidth(), r15.getHeight());
        int r16 = r11.getWidth();
        int r17 = r11.getHeight();
        int r18 = 0;
    L3:
        if (r18 >= r17) goto L8;
        int r19 = 0;
    L5:
        if (r19 >= r16) goto L7;
        int r20 = (r18 * r16) + r19;
        r14[r20] = (r13[r20] & (-16777216)) + (r14[r20] & 16777215);
        r19 = r19 + 1;
        goto L5
    L7:
        r18 = r18 + 1;
        goto L3
    L8:
        r15.setPixels(r14, 0, r16, 0, 0, r16, r17);
        return r15;
    }

    public static synchronized void Q0(Context r12) {
        monitor-enter(e.class);
        long r10 = b0.n().p(ServerElements.LAST_UPDATE_TIME, null, r12);     // Catch: Throwable -> L12
        long r11 = System.currentTimeMillis() - r10;     // Catch: Throwable -> L12
        if (r11 >= 0) goto L7;
    L8:
        j.n("[AutoUpdate] set AUTO_UPDATE_LAST_TIME_KEY, registerAlarm4SyncUpdateApps");     // Catch: Throwable -> L12
        b0.n().F(ServerElements.LAST_UPDATE_TIME, System.currentTimeMillis(), null, r12);     // Catch: Throwable -> L12
        j(r12, 60000);     // Catch: Throwable -> L12
    L9:
        j.n("[AutoUpdate] check update lastTime[" + r10 + "],passTime[" + r11 + "]");     // Catch: Throwable -> L12
        monitor-exit(e.class);
        return;
    L7:
        if (r11 <= 10860000) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    public static int R() {
        NetworkInfo r10 = t();
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L9;
        return 5;
    L9:
        if (r10.getType() == 0) goto L11;
        return 5;
    L11:
        switch(r10.getSubtype()) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L21;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L21;
            case 11: goto L22;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L21;
            case 15: goto L21;
            default: goto L12;
        };
    L12:
        String r11 = r10.getSubtypeName();
        if (r11.equalsIgnoreCase("TD-SCDMA") == false) goto L15;
    L18:
        return 3;
    L15:
        if (r11.equalsIgnoreCase("WCDMA") == true) goto L18;
        if (r11.equalsIgnoreCase("CDMA2000") == true) goto L18;
        return 5;
    L19:
        return 4;
    L21:
        return 3;
    L22:
        return 2;
    L5:
        if (r10.getType() != 1) goto L7;
        return 1;
    }

    public static void R0(String r10, int r11, int r12) {
        y8.f.g().getCache().remove(r10);
        x8.b.c().remove(ImageLoader.j(r10, r11, r12));
        j.a("key:" + r10);
    }

    public static String S() {
        int r10 = R();
        if (r10 != 1) goto L5;
        return "wifi";
    L5:
        if (r10 != 2) goto L7;
        return "4G";
    L7:
        if (r10 != 3) goto L9;
        return "3G";
    L9:
        if (r10 == 4) goto L11;
        return "未知";
    L11:
        return "2G";
    }

    public static boolean S0(AppInfo r10) {
        String r11 = r10.downloadFilePath;
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.endsWith(".apk") == false) goto L12;
        if (r10.downloadFilePath.endsWith("_bak.apk") == true) goto L10;
        String r12 = r10.downloadFilePath.replace(".apk", "_bak.apk");
    L25:
        if (TextUtils.isEmpty(r12) == false) goto L28;
        j.n("renamePath is null,filePath = " + r10.downloadFilePath);
        return false;
    L28:
        File r13 = new File(r10.downloadFilePath);
        File r14 = new File(r12);
        if (r13.exists() == true) goto L37;
        if (r14.exists() == false) goto L34;
        r10.downloadFilePath = r12;
        j.n("file is exists,download_id=" + r10.downloadId + " /pkg=" + r10.appPackageName + " /path=" + r10.downloadFilePath);
        return true;
    L34:
        j.n("file is not exists,download_id=" + r10.downloadId + " /pkg=" + r10.appPackageName + " /path=" + r10.downloadFilePath);
        return false;
    L37:
        if (r14.exists() == true) goto L39;
    L43:
        r10.downloadFilePath = r12;
        int r15 = 3;
    L44:
        if (r15 <= 0) goto L49;
        if (r13.renameTo(r14) == true) goto L47;
        r15 = r15 - 1;
        goto L44
    L47:
        return true;
    L49:
        return false;
    L39:
        if (TextUtils.equals(r12, r10.downloadFilePath) == false) goto L42;
        j.n("reinstall,download_id=" + r10.downloadId + " /pkg=" + r10.appPackageName + " /path=" + r10.downloadFilePath);
        return true;
    L42:
        r14.delete();
        goto L43
    L10:
        r12 = r10.downloadFilePath;
        goto L25
    L12:
        if (r10.downloadFilePath.endsWith(".patch") == false) goto L18;
        if (r10.downloadFilePath.endsWith("_bak.patch") == true) goto L16;
        r12 = r10.downloadFilePath.replace(".patch", "_bak.patch");
        goto L25
    L16:
        r12 = r10.downloadFilePath;
        goto L25
    L18:
        if (r10.downloadFilePath.endsWith(".zip") == true) goto L20;
        r12 = "";
        goto L25
    L20:
        if (r10.downloadFilePath.endsWith("_bak.zip") == true) goto L22;
        r12 = r10.downloadFilePath.replace(".zip", "_bak.zip");
        goto L25
    L22:
        r12 = r10.downloadFilePath;
        goto L25
    }

    public static String T(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return "";
    L7:
        return new SimpleDateFormat("yyyy.MM.dd").format(new Date(d0.c(r10) * 1000)) + " " + BaseApplication.c().getString(R$string.open_beta);
    }

    public static void T0(Activity r10, AppInfo r11) {
        if (TextUtils.isEmpty(r11.mSourcePkgName) == true) goto L7;
        if ("com.obric.appstore".equals(r11.mSourcePkgName) == true) goto L7;
    L9:
        String r12 = AdReportParam.ClickPosType.SKIP;
        String r13 = "";
    L11:
        if (TextUtils.isEmpty(r11.mPageTitle) == true) goto L14;
        r13 = r11.mPageTitle;
    L14:
        String r14 = d9.a.a(d9.a.a(d9.a.a(d9.a.a(x(r11, r12, r13), "source_position", e0(r11.appDownloadUrl, "position")), ServerElements.TEST, AdReportParam.ClickPosType.SKIP), TrackerElement.CATEGORY_APP_TOP, ""), TrackerElement.CATEGORY_APP_SEC, "");
        d9.a.e().Q("9014", r14);
        return;
    L7:
        if ((r10 instanceof BasicActivity) == false) goto L9;
        BasicActivity r15 = (BasicActivity) r10;
        r12 = r15.getSourcePage();
        r13 = r15.getSourcePageName();
        goto L11
    }

    public static String U(boolean r10) {
        String r11 = SystemProperties.get("ro.os.ota.version");
        if (r10 == false) goto L5;
        return r11;
    L5:
        if (r11 == null) goto L13;
        String[] r12 = r11.split("-");
        if (r12 == null) goto L13;
        if (r12.length <= 0) goto L13;
        String r13 = r12[0];
        if (r13.contains("_") == false) goto L14;
        r13 = r13.split("_")[0];
    L14:
        if (r13 != null) goto L17;
        return "";
    L17:
        return r13;
    L13:
        r13 = null;
        goto L14
    }

    public static boolean U0(CommonCache r10, AppInfo r11, AppInfo r12) {
        if (r0(r11) == false) goto L6;
        r11.downloadStatus = 8;
        r10.b(r11);
        return false;
    L6:
        r11.downloadStatus = 1;
        r10.b(r11);
        AppInfo r13 = r10.G(r11.appPackageName);
        if (r13 != null) goto L9;
        j.n("no find updatable appinfo from cache");
    L27:
        return true;
    L9:
        String r14 = r13.mDiffDownloadUrl;
        if (r14 == null) goto L15;
        if (TextUtils.equals(r14, "no_diff_patch") == false) goto L15;
        j.n("no diff patch :" + r11.appPackageName);
    L15:
        if (TextUtils.isEmpty(r13.mDiffMD5) == false) goto L17;
    L26:
        e(r11, r12);
        goto L27
    L17:
        if (TextUtils.isEmpty(r13.mDiffDownloadUrl) == true) goto L26;
        if (TextUtils.equals(r13.mDiffDownloadUrl, "no_diff_patch") == true) goto L26;
        j.n("change the updateApp to info :" + r11.appPackageName);
        if (TextUtils.isEmpty(e0(r11.mDiffDownloadUrl, "position")) == false) goto L25;
        String r15 = e0(r11.appDownloadUrl, "position");
        if (TextUtils.isEmpty(r15) == true) goto L25;
        r13.mDiffDownloadUrl += "&position=" + r15;
    L25:
        r11.mDiffDownloadUrl = r13.mDiffDownloadUrl;
        r11.mDiffMD5 = r13.mDiffMD5;
        goto L27
    }

    public static PackageInfo V(Context r10, String r11, int r12) {
        PackageInfo r13 = null;
        if (r10 != null) goto L5;
    L23:
        return null;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L23;
        PowerManager.WakeLock r14 = ((PowerManager) r10.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, r11);
        r14.acquire();     // Catch: Throwable -> L12
        r13 = r10.getPackageManager().getPackageArchiveInfo(r11, r12);     // Catch: Throwable -> L12
        if (r14.isHeld() == false) goto L17;
    L11:
        r14.release();
    L17:
        return r13;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        if (r14.isHeld() == false) goto L17;
    L18:
        th = move-exception;
        if (r14.isHeld() == false) goto L22;
        r14.release();
    L22:
        throw th;
    }

    public static void V0(String r10, String r11) {
        if (TextUtils.equals("com.bytedanceos.game.store.sync.collection.apps", r10) == false) goto L5;
    L8:
        Intent r12 = new Intent(r10);
        r12.putExtra("apps", r11);
        BaseApplication.c().sendBroadcast(r12);
        return;
    L5:
        if (TextUtils.equals("com.bytedanceos.game.store.sync.my.apps", r10) == true) goto L8;
        if (TextUtils.equals("com.bytedanceos.game.store.sync.last.day", r10) == true) goto L8;
    }

    public static String W(int r10) {
        if (r10 != R$id.recommend_btn) goto L6;
        return "tab_featured";
    L6:
        if (r10 != R$id.ranking_btn) goto L10;
        return "tab_lists";
    L10:
        if (r10 != R$id.category_btn) goto L14;
        return "tab_categories";
    L14:
        if (r10 != R$id.game_recommend_btn) goto L18;
        return "tab_game";
    L18:
        if (r10 != R$id.myapp_btn) goto L21;
        return "tab_myapp";
    L21:
        return "tab_featured";
    }

    public static void W0(Context r10, int r11) {
        if (s.n(r10) == true) goto L11;
        if (r11 == 0) goto L11;
        return;
    L11:
        Uri r12 = Uri.parse("content://com.bytedanceos.launcher.badge");     // Catch: Exception -> L7
        Bundle r13 = new Bundle();     // Catch: Exception -> L7
        r13.putInt("badge_num", r11);     // Catch: Exception -> L7
        r10.getContentResolver().call(r12, "updateMessageBadge", null, r13);     // Catch: Exception -> L7
    L9:
        j.n("Send broadcast [" + r11 + "] to launcher.");
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static String X(String r10, String r11) {
        String r12 = "";
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L16:
        j.a("paramName  " + r12);
        return r12;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L16;
        String[] r13 = r10.split("&");
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L16;
        String r16 = r13[r15];
        if (r16.startsWith(r11) == false) goto L15;
        String[] r17 = r16.split("=");
        if (r17 == null) goto L15;
        if (r17.length <= 1) goto L15;
        r12 = r17[1];
    L15:
        r15 = r15 + 1;
        goto L7
    }

    public static void X0(int r10, TextView r11) {
        if (r10 != 0) goto L4;
    L7:
        int r12 = 10;
    L8:
        r11.setTextSize(1, r12);
        return;
    L4:
        if (r10 > 99) goto L7;
        r12 = 12;
        goto L8
    }

    public static Bitmap Y(Bitmap r10, float r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r12 = r10.getWidth();
        int r13 = r10.getHeight();
        Bitmap r14 = Bitmap.createBitmap(r12, r13, Bitmap.Config.ARGB_8888);
        Canvas r15 = new Canvas(r14);
        Paint r16 = new Paint();
        Rect r17 = new Rect(0, 0, r12, r13);
        RectF r18 = new RectF(r17);
        r16.setColor(-12434878);
        r16.setAntiAlias(true);
        r15.drawARGB(0, 0, 0, 0);
        r15.drawRoundRect(r18, r11, r11, r16);
        r16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r15.drawBitmap(r10, r17, r17, r16);
        return r14;
    }

    public static void Y0(boolean r10, boolean r11) {
        long r12 = System.currentTimeMillis();
        StringBuffer r13 = new StringBuffer();
        r13.append(r12);
        r13.append(";");
        r13.append(r10);
        r13.append(";");
        r13.append(r11);
        String r14 = r13.toString();
        if (BaseApplication.c().o() == false) goto L5;
        V0("com.bytedanceos.game.store.sync.last.day", r14);
    L6:
        b0.n().H("last_day", r14, null, BaseApplication.c());
        j.a("dateTime:" + r12 + "   isWifiDownload:" + r10 + "   isForbidDialogToday:" + r11);
        return;
    L5:
        V0("com.bytedanceos.app.store.sync.last.day", r14);
        goto L6
    }

    public static String Z(String r10, AppInfo r11, View r12) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        if (r11 != null) goto L8;
    L11:
        TextView r13 = (TextView) r12.findViewById(R$id.appName);
        if (r13 == null) goto L14;
        String r14 = r13.getText().toString();
    L16:
        return BaseApplication.c().getResources().getString(R$string.share_text_example, new Object[]{r14, r10 + "&source=share&version=2"});
    L14:
        r14 = AdConstant.Dsp.BYTEDANCE;
        goto L16
    L8:
        if (TextUtils.isEmpty(r11.appName) == true) goto L11;
        r14 = r11.appName;
        goto L16
    }

    public static void Z0(boolean r10, int r11) {
        if (r11 != 0) goto L5;
        j.a("not need to set today");
        return;
    L5:
        if (2 != r11) goto L7;
        Y0(r10, true);
        return;
    L7:
        if (1 != r11) goto L12;
        Y0(r10, false);
        return;
    }

    public static boolean a(String r10, String r11) {
        SimpleDateFormat r12 = new SimpleDateFormat("HH:mm");
        Date r13 = null;
        Date r14 = r12.parse(r12.format(new Date()));     // Catch: Exception -> L11
        Date r15 = r12.parse(r10);     // Catch: Exception -> L9
        r13 = r12.parse(r11);     // Catch: Exception -> L7
    L14:
        Calendar r16 = Calendar.getInstance();
        r16.setTime(r14);
        Calendar r17 = Calendar.getInstance();
        r17.setTime(r15);
        Calendar r18 = Calendar.getInstance();
        r18.setTime(r13);
        if (r16.after(r17) == true) goto L17;
        return false;
    L17:
        if (r16.before(r18) == false) goto L28;
        return true;
    L28:
        return false;
    L7:
        e = e;
    L13:
        e.printStackTrace();
    L9:
        e = e;
        r15 = null;
    L11:
        e = e;
        r15 = null;
        r14 = null;
        goto L13
    }

    public static byte[] a0(NetworkImageView r10) {
        byte[] r11 = null;
        if (r10 == null) goto L11;
        r10.setDrawingCacheEnabled(true);
        Bitmap r12 = r10.getDrawingCache();
        if (r12 != null) goto L8;
        String r13 = r10.getUrl();
        ImageLoader.l(d.f10012d);
        String r14 = ImageLoader.j(r13, r10.getWidth(), r10.getHeight());
        r12 = x8.b.c().getBitmap(r14);
    L8:
        if (r12 == null) goto L10;
        r11 = com.bytedanceos.common.utils.f.b(r12, false);
    L10:
        r10.setDrawingCacheEnabled(false);
    L11:
        return r11;
    }

    public static void a1(TextView r10, boolean r11) {
        b1(r10, r11, 12);
    }

    public static boolean b(String r10) {
        File r11 = H();
        if (r11 != null) goto L5;
    L9:
        e0.e(R$string.create_file_failed);
        j.n("create download dir failed:" + r10);
        return false;
    L5:
        if (r11.exists() == false) goto L9;
        return true;
    }

    public static int b0(Context r10, float r11, boolean r12) {
        return c0(r10, r11, r12, "");
    }

    public static void b1(TextView r10, boolean r11, int r12) {
        if (r11 == false) goto L5;
        r10.setTextColor(k(-11503143, -11503143, -11503143, -11503143));
        Drawable r13 = r10.getResources().getDrawable(R$drawable.developer_arrow);
        r10.setCompoundDrawablePadding(r12);
        r10.setCompoundDrawablesWithIntrinsicBounds(null, null, r13, null);
    L6:
        r10.setClickable(r11);
        return;
    L5:
        r10.setTextColor(k(-852414159, -852414159, -852414159, -852414159));
        r10.setCompoundDrawables(null, null, null, null);
        goto L6
    }

    public static synchronized void c() {
        monitor-enter(e.class);
        Intent r10 = new Intent();     // Catch: Throwable -> L7
        r10.setClass(BaseApplication.c(), AppsDownloadService.class);     // Catch: Throwable -> L7
        r10.setAction("appstore.intent.cancel.gms");     // Catch: Throwable -> L7
        r10.setPackage(BaseApplication.c().getPackageName());     // Catch: Throwable -> L7
        BaseApplication.c().startService(r10);     // Catch: Throwable -> L7
        j.n("Start service for cancel " + r10);     // Catch: Throwable -> L7
        monitor-exit(e.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static int c0(Context r10, float r11, boolean r12, String r13) {
        if (f10019a != null) goto L5;
        f10019a = new DecimalFormatSymbols(Locale.ENGLISH);
    L5:
        float r14 = Float.parseFloat(new DecimalFormat("0.0", f10019a).format(Math.min(r11, 5.0f)));
        int r15 = ((int) (10.0f * r14)) % 10;
        if (r15 < 0) goto L10;
        if (r15 > 2) goto L10;
        String r16 = String.valueOf((int) r14);
    L19:
        return r10.getResources().getIdentifier("yellow_rate_" + r16, "drawable", r10.getPackageName());
    L10:
        if (r15 <= 2) goto L13;
        if (r15 >= 8) goto L13;
        r16 = String.valueOf((int) r14) + "_5";
    L13:
        if (r15 >= 8) goto L15;
    L17:
        r16 = null;
        goto L19
    L15:
        if (r15 > 9) goto L17;
        r16 = String.valueOf((int) (r14 + 1.0f));
        goto L19
    }

    public static void c1() {
        Intent r10 = new Intent("com.bytedanceos.show.tab.bottom.update.count");
        z.a.b(BaseApplication.c()).d(r10);
    }

    public static boolean d(CommonCache r10, String r11) {
        AppInfo r12 = r10.t(r11);
        if (r12 != null) goto L5;
        return false;
    L5:
        int r13 = r12.downloadStatus;
        if (r13 != 1) goto L14;
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r12.downloadId)) == false) goto L11;
        j.n("app has been added into download queue:" + r12.appPackageName + " | " + r12.downloadId);
        return true;
    L11:
        j.n("download pendding app: " + r12.appPackageName);
        return false;
    L14:
        if (r13 != 2) goto L22;
        if (r12.downloadTime <= 0) goto L22;
        if ((System.currentTimeMillis() - r12.downloadTime) <= 86400000) goto L22;
        r10.p0(r12);
        j.n("app downloading is time out: " + r12.appPackageName + ",last update time = " + r12.downloadTime);
        return false;
    L22:
        if (r12.downloadStatus != 16) goto L25;
        j.n("app is failed:" + r12.appPackageName + ",status = " + r12.downloadStatus);
        return false;
    L25:
        j.n("app is downloading:" + r12.appPackageName + ",status = " + r12.downloadStatus);
        return true;
    }

    public static TransitionDrawable d0(int r10) {
        Bitmap r11 = BitmapFactory.decodeResource(BaseApplication.c().getResources(), r10);
        return new TransitionDrawable(new Drawable[]{new ColorDrawable(BaseApplication.c().getResources().getColor(R.color.transparent)), new BitmapDrawable(BaseApplication.c().getResources(), r11)});
    }

    public static void d1(Activity r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (p0() == false) goto L8;
        Intent r11 = new Intent(r10, AboutActivity.class);
        r10.startActivity(r11);
        r11.setPackage(r10.getPackageName());
        return;
    }

    public static void e(AppInfo r10, AppInfo r11) {
        CountDownLatch r12 = new CountDownLatch(1);
        CommonAPIHelper.A(r11, new a(r10, r12));     // Catch: Exception -> L5
        r12.await(10, TimeUnit.SECONDS);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.n("request diff patch result:" + e.getMessage());
        r12.countDown();
    }

    public static String e0(String r10, String r11) {
        return Uri.parse(r10).getQueryParameter(r11);
    L4:
        return null;
    }

    public static void e1(Activity r10, AppInfo r11, int r12, String r13) {
        f1(r10, r11, r12, r13, null, false);
    }

    public static int f(PackageManager r10, String r11, boolean r12) {
        if (r10.getApplicationInfo(r11, 0) != null) goto L6;
        if (r12 == true) goto L6;
        return 0;
    L6:
        return 2;
    L11:
        e = move-exception;
        j.b(e.getMessage());
        return 0;
    L9:
        e = move-exception;
        j.b(e.getMessage());
        return 0;
    L7:
        th = move-exception;
        throw th;
    }

    public static int f0() {
        MobileInfo r10 = BaseApplication.c().i();
        if (r10 == null) goto L13;
        int r11 = r10.mVersionCode;
        if (r11 <= 0) goto L13;
        return r11;
    L13:
        return BaseApplication.c().getPackageManager().getPackageInfo(BaseApplication.c().getPackageName(), 0).versionCode;
    L10:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static void f1(Activity r10, AppInfo r11, int r12, String r13, String r14, boolean r15) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (p0() == false) goto L28;
        Class<AppDetailActivity> r16 = com.bytedanceos.common.e.f9820a.getAppDetailActivityClass();
        if (r16 != null) goto L8;
        r16 = AppDetailActivity.class;
    L8:
        Intent r17 = new Intent(r10, r16);
        if (r11 == null) goto L11;
        r17.putExtra("original_data", r11);
        String r18 = r11.mSourcePkgName;
    L12:
        r17.putExtra("original_type", r12);
        if (TextUtils.isEmpty(r14) == true) goto L16;
        r17.putExtra("original_position", r14);
    L16:
        if (TextUtils.isEmpty(r13) == true) goto L18;
        r17.putExtra("original_back_info", r13);
    L18:
        r17.putExtra("original_do_install", r15);
        if (TextUtils.isEmpty(r18) == true) goto L23;
        r17.putExtra("from_package", r18);
        if (y0(r18) == false) goto L23;
        TextUtils.isEmpty(ReflectTool.getIntentSmtExtraName("get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID", new Class[0]));
    L23:
        r10.startActivity(r17);
        if (r11 == null) goto L29;
        AdsReportManager.h().q(r11);
        T0(r10, r11);
        return;
    L29:
        return;
    L11:
        r18 = "";
        goto L12
    }

    public static boolean g(Context r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        if (r10.getPackageManager().isSafeMode() == false) goto L9;
        e0.e(R$string.alert_safe_mode);
        return true;
    L9:
        return false;
    }

    public static void g0(View r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ((InputMethodManager) BaseApplication.c().getSystemService("input_method")).hideSoftInputFromWindow(r10.getWindowToken(), 2);
    }

    public static void g1(View r10) {
        i1(r10, null, false);
    }

    public static boolean h(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L16;
        return false;
    L16:
        String r11 = Uri.parse(r10).getScheme();     // Catch: Exception -> L15
        if (r11 == null) goto L14;
        if (r11.equals(HttpHost.DEFAULT_SCHEME_NAME) == true) goto L12;
        if (r11.equals("https") == false) goto L14;
        return true;
    L12:
        return true;
    L14:
        return false;
    }

    public static void h0() {
        if (BaseApplication.c().o() == false) goto L5;
        Intent r10 = new Intent("com.bytedanceos.check.install.app.list");
    L6:
        r10.setPackage(BaseApplication.c().getPackageName());
        BaseApplication.c().sendBroadcast(r10);
        return;
    L5:
        r10 = new Intent("com.bytedanceos.check.install.game.list");
        goto L6
    }

    public static void h1(View r10, String r11) {
        String r12 = c9.a.K(r11);
        if (TextUtils.isEmpty(r12) == false) goto L6;
        i1(r10, null, false);
        return;
    L6:
        i1(r10, r12, true);
    }

    public static synchronized void i(Context r11) {
        monitor-enter(e.class);
        j.n("create alarm to report all installed apps to tracker");     // Catch: Throwable -> L7
        Intent r10 = new Intent();     // Catch: Throwable -> L7
        r10.setAction("com.bytedanceos.appstore.auto_report_tracker_info");     // Catch: Throwable -> L7
        r10.setPackage(r11.getPackageName());     // Catch: Throwable -> L7
        PendingIntent r12 = PendingIntent.getBroadcast(r11, 0, r10, 167772160);     // Catch: Throwable -> L7
        AlarmManager r13 = (AlarmManager) r11.getSystemService(BatteryTypeInf.BATTERY_ALARM);     // Catch: Throwable -> L7
        r13.cancel(r12);     // Catch: Throwable -> L7
        r13.setRepeating(0, System.currentTimeMillis() + 60000, 86400000, r12);     // Catch: Throwable -> L7 Exception -> L9
    L11:
        monitor-exit(e.class);
        return;
    L9:
        e = move-exception;
        j.n("createAlarm4ReportToTracker setRepeating failed: " + e.getMessage());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean i0(String r10) {
        ApplicationInfo r11 = BaseApplication.c().getPackageManager().getApplicationInfo(r10, 0);     // Catch: Exception -> L5
        Field r12 = r11.getClass().getDeclaredField("primaryCpuAbi");     // Catch: Exception -> L5
        r12.setAccessible(true);     // Catch: Exception -> L5
        String r13 = (String) r12.get(r11);     // Catch: Exception -> L5
    L8:
        if (TextUtils.isEmpty(r13) == false) goto L11;
        return false;
    L11:
        if (Build.SUPPORTED_32_BIT_ABIS[0].equalsIgnoreCase(r13) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r13 = null;
        goto L8
    }

    public static void i1(View r10, String r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        AppInfo r13 = (AppInfo) r10.getTag(R$id.appinfo);
        if (r12 == true) goto L7;
    L9:
        if (r13 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r13.appDownloadUrl) == true) goto L38;
        r11 = r13.appDownloadUrl;
    L14:
        String r14 = Z(r11, r13, r10);
        int r15 = R$id.appIcon;
        View r16 = r10.findViewById(r15);
        Bitmap r17 = null;
        if (r16 != null) goto L17;
    L19:
        Drawable r18 = null;
    L21:
        if (r18 == null) goto L27;
        if ((r18 instanceof TransitionDrawable) == false) goto L25;
        r17 = ((BitmapDrawable) ((TransitionDrawable) r18).getDrawable(1)).getBitmap();
        goto L27
    L25:
        r17 = ((BitmapDrawable) r18).getBitmap();
    L27:
        if ((r10 instanceof OUIAppItemView) == false) goto L29;
        r17 = ((OUIAppItemView) r10).getIconBitmap();
    L29:
        if (r17 != null) goto L31;
        Bitmap r19 = BitmapFactory.decodeResource(BaseApplication.c().getResources(), R$drawable.storedrag_default);
    L33:
        if (TextUtils.isEmpty(r14) == true) goto L37;
        ReflectTool.dragLink(r10, BaseApplication.c(), r14, BitmapFactory.decodeResource(BaseApplication.c().getResources(), R$drawable.storedrag_big), r19);
        return;
    L37:
        return;
    L31:
        r19 = Bitmap.createScaledBitmap(r17, BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.dragview_width), BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.dragview_height), true);
        goto L33
    L17:
        if ((r16 instanceof ImageView) == false) goto L19;
        r18 = ((ImageView) r16.findViewById(r15)).getDrawable();
        goto L21
    L38:
        return;
    L7:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        goto L9
    }

    public static synchronized void j(Context r11, long r12) {
        monitor-enter(e.class);
        j.n("[AutoUpdate][Alarm] create alarm update apps trigger in [" + r12 + "] ms");     // Catch: Throwable -> L7
        Intent r10 = new Intent();     // Catch: Throwable -> L7
        if (BaseApplication.c().o() == false) goto L9;
        r10.setAction("com.bytedanceos.appstore.sync.update.apps");     // Catch: Throwable -> L7
    L10:
        r10.setPackage(r11.getPackageName());     // Catch: Throwable -> L7
        PendingIntent r13 = PendingIntent.getBroadcast(r11, 0, r10, 167772160);     // Catch: Throwable -> L7
        AlarmManager r14 = (AlarmManager) r11.getSystemService(BatteryTypeInf.BATTERY_ALARM);     // Catch: Throwable -> L7
        r14.cancel(r13);     // Catch: Throwable -> L7
        r14.setRepeating(0, System.currentTimeMillis() + r12, 10800000, r13);     // Catch: Throwable -> L7 Exception -> L13
    L15:
        monitor-exit(e.class);
        return;
    L13:
        e = move-exception;
        j.n("[AutoUpdate][Alarm] setRepeating failed: " + e.getMessage());     // Catch: Throwable -> L7
        goto L15
    L9:
        r10.setAction("com.bytedanceos.gamestore.sync.update.apps");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean j0(AppInfo r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        File r11 = new File(H(), v(r10, true));
        if (r11.isFile() == true) goto L10;
        r11.delete();
        return false;
    L10:
        if (r11.length() == r10.appBytes) goto L26;
        j.n("file size error:" + r11.getName());
        return false;
    L26:
        int r12 = u(r11.getName());     // Catch: Exception -> L20
        if (r12 >= 0) goto L16;
    L22:
        r11.delete();     // Catch: Exception -> L20
        j.n("file version error:" + r11.getName());     // Catch: Exception -> L20
        return false;
    L16:
        if (r12 < r10.appVersionCode) goto L22;
        r10.downloadFilePath = r11.getAbsolutePath().replace("_bak.apk", ".apk");
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void j1(int r10, AppInfo r11) {
        if (r11 != null) goto L5;
        j.a("showInfoImages is null");
        return;
    L5:
        Intent r12 = new Intent(BaseApplication.c(), ImageDetailActivity.class);
        r12.addFlags(268435456);
        r12.setAction("android.intent.action.VIEW");
        ArrayList r13 = new ArrayList();
        if (TextUtils.isEmpty(r11.mAppVideoUrl) == true) goto L8;
        r12.putExtra(CommonConfirmDialog.ARGS_DIALOG_APP, r11);
        r12.putExtra(ImageDetailActivity.EXTRA_IMAGE_INDEX, r10);
    L9:
        r13.addAll(r11.appScreenSnaps);
        r12.putExtra(ImageDetailActivity.EXTRA_IMAGE_URLS, (String[]) r13.toArray(new String[0]));
        BaseApplication.c().startActivity(r12);
        d9.a.e().S(false, r11.appPackageName);
        return;
    L8:
        r12.putExtra(ImageDetailActivity.EXTRA_IMAGE_INDEX, r10);
        goto L9
    }

    public static ColorStateList k(int r10, int r11, int r12, int r13) {
        int[] r14 = {r11, r12, r10, r12, r13, r10};
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, r14);
    }

    public static boolean k0(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        if (r10.startsWith("http://") == true) goto L9;
        if (r10.startsWith("https://") == true) goto L9;
        return false;
    L9:
        return r10.contains(".apk");
    }

    public static void k1(Activity r10, View r11) {
        int r12 = ((Integer) r11.getTag(R$id.image_index)).intValue();
        String[] r13 = new String[0];
        Object r14 = r11.getTag();
        if (r14 != null) goto L5;
    L16:
        j.a("showInfoImages is null");
        return;
    L5:
        if ((r14 instanceof AppInfo) == false) goto L16;
        AppInfo r15 = (AppInfo) r14;
        Intent r16 = new Intent(r10, ImageDetailActivity.class);
        r16.addFlags(268435456);
        r16.setAction("android.intent.action.VIEW");
        ArrayList r17 = new ArrayList();
        if (TextUtils.isEmpty(r15.mAppVideoUrl) == true) goto L13;
        String r18 = r15.mAppVideoImage;
        if (r18 != null) goto L12;
        r18 = "";
    L12:
        r17.add(r18);
        r16.putExtra(CommonConfirmDialog.ARGS_DIALOG_APP, r15);
        r16.putExtra(ImageDetailActivity.EXTRA_IMAGE_INDEX, r12);
    L14:
        r17.addAll(r15.appScreenSnaps);
        r16.putExtra(ImageDetailActivity.EXTRA_IMAGE_URLS, (String[]) r17.toArray(r13));
        r10.startActivity(r16);
        d9.a.e().S(false, r15.appPackageName);
        return;
    L13:
        r16.putExtra(ImageDetailActivity.EXTRA_IMAGE_INDEX, r12 - 1);
        goto L14
    }

    public static boolean l(Activity r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L12;
        return false;
    L12:
        Intent r12 = new Intent("android.intent.action.VIEW", Uri.parse(r11));     // Catch: Exception -> L11
        r12.addFlags(67108864);     // Catch: Exception -> L11
        r12.setFlags(268435456);     // Catch: Exception -> L11
        if (com.bytedanceos.common.toolbox.c.a(r10.getPackageManager().queryIntentActivities(r12, 0)) == true) goto L10;
        r10.startActivity(r12);     // Catch: Exception -> L11
        return true;
    L10:
        return false;
    }

    public static boolean l0() {
        if (s.g(BaseApplication.c()) == true) goto L7;
        j.n("[AutoUpdate] isAutoDownload allow = FALSE ! auto update, setting off.");
        return false;
    L7:
        if (2 == A()) goto L11;
        j.n("[AutoUpdate] isAutoDownload allow = FALSE ! auto update, wifi inactive.");
        return false;
    L11:
        if (m0() == true) goto L15;
        j.n("[AutoUpdate] isAutoDownload allow = FALSE ! battery not enough.");
        return false;
    L15:
        if (D0() == false) goto L18;
        j.n("[AutoUpdate] isAutoDownload allow = FALSE ! auto update, screen on");
        return false;
    L18:
        return true;
    }

    public static void l1(Activity r10, int r11) {
        Intent r12 = new Intent(r10, ConfirmLoginInfoActivity.class);
        r12.putExtra("type", 2);
        if (r11 <= 0) goto L5;
        r10.startActivityForResult(r12, r11);
    L6:
        r10.overridePendingTransition(R$anim.pop_up_in, R$anim.fake_anim);
        return;
    L5:
        r10.startActivity(r12);
        goto L6
    }

    public static void m(AppInfo r10, long r11) {
        Intent r12 = new Intent(BaseApplication.c(), GmsInstallService.class);
        r12.putExtra("message_what", 1004);
        r12.putExtra(DownloadInfoColumns.TABLE, r10);
        PendingIntent r13 = PendingIntent.getService(BaseApplication.c(), 2, r12, 335544320);
        AlarmManager r14 = (AlarmManager) BaseApplication.c().getSystemService(BatteryTypeInf.BATTERY_ALARM);
        r14.cancel(r13);
        r14.setExact(2, SystemClock.elapsedRealtime() + r11, r13);
    }

    public static boolean m0() {
        Intent r10 = BaseApplication.c().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r10 != null) goto L6;
        j.n("[AutoUpdate][AppStatus] isBatteryEnough false. get battery params error:");
        return false;
    L6:
        int r11 = r10.getIntExtra("level", 0);
        h8.b r12 = h8.b.b();
        if (r11 >= r12.a()) goto L10;
        j.n("[AutoUpdate][AppStatus] isBatteryEnough false. battery level:" + r11);
        return false;
    L10:
        int r13 = r10.getIntExtra("status", 0);
        if (B0() == false) goto L20;
        if (r13 != 2) goto L14;
    L18:
        return true;
    L14:
        if (r11 > r12.d()) goto L18;
        j.n("[AutoUpdate][AppStatus] isBatteryEnough false. night battery charging," + r13 + " |level = " + r11);
        return false;
    L20:
        if (r11 > r12.g()) goto L27;
        if (r13 == 2) goto L23;
    L25:
        j.n("[AutoUpdate][AppStatus] isBatteryEnough false. day battery charging," + r13 + " |level = " + r11);
        return false;
    L23:
        if (r11 <= r12.f()) goto L25;
    L27:
        return true;
    }

    public static void m1(Activity r10, AppInfo r11) {
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r10.startActivity(AppPermissionActivity.create(r10, r11.appPackageName, r11.appName, r11.appVersionName, r11.appIcon));
        r10.overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);
        d9.a.e().P("0064");
        return;
    L8:
        return;
    }

    public static void n(String r10) {
        Intent r11 = new Intent();
        r11.setAction("com.bytedance.start.install.service");
        r11.putExtra("message_what", 59);
        r11.putExtra("packageName", r10);
        r11.putExtra("dirName", H().getAbsolutePath());
        r11.setPackage(BaseApplication.c().getPackageName());
        BaseApplication.c().startService(r11);
    }

    public static boolean n0() {
        if (z() < 1.4f) goto L5;
        return true;
    L5:
        return false;
    }

    public static void n1(Context r10, String r11, int r12, String r13, int r14) {
        o1(r10, r11, r12, r13, r14, 0, null, null, null);
    }

    public static void o(Activity r10, String r11, String r12, byte[] r13) {
        if (r10 != null) goto L4;
    L18:
        e0.e(R$string.share_invalid);
        j.a("Bundle:" + r12);
        return;
    L4:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        if (TextUtils.isEmpty(r12) == true) goto L18;
        String r14 = r12 + "&source=share&version=2";
        String r15 = r10.getResources().getString(R$string.share_text_example, new Object[]{r11, r14});
        j.e("ShareContent >>>>>> " + r15);
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.OSCAR, DeviceType.M1, DeviceType.M1L, DeviceType.T1, DeviceType.T2, DeviceType.U1}) == false) goto L11;
        Intent r16 = new Intent("android.intent.action.SEND");
        r16.setType(HTTP.PLAIN_TEXT_TYPE);
        r16.putExtra("android.intent.extra.TEXT", r15);
        Intent r17 = Intent.createChooser(r16, r10.getResources().getString(R$string.share_title));
        r17.addFlags(268435456);
    L20:
        r10.startActivityForResult(r17, 1001);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        j.n("ERROR occur while starting share activity!" + e.getMessage());
        return;
    L11:
        r17 = com.bytedanceos.common.utils.t.b(r15, r11, r14, r13);
        goto L20
    }

    public static boolean o0() {
        if (BaseApplication.c() != null) goto L6;
        return false;
    L6:
        if (I0() == false) goto L8;
        return true;
    L8:
        BaseApplication r10 = BaseApplication.c();
        if (BaseApplication.c().o() == false) goto L11;
        String r11 = "com.bytedanceos.appstore.setting";
    L13:
        if (r10.getSharedPreferences(r11, 0).getBoolean("isShowImageOnlyWlan", false) == false) goto L15;
        return false;
    L15:
        return true;
    L11:
        r11 = "com.bytedanceos.gamestore.setting";
        goto L13
    }

    public static void o1(Context r10, String r11, int r12, String r13, int r14, int r15, String r16, String r17, Bundle r18) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (p0() == false) goto L33;
        Intent r19 = new Intent();     // Catch: Exception -> L8
        r19.setAction("com.bytedanceos.app.search.details");     // Catch: Exception -> L8
        r19.putExtra("original_extra", r11);     // Catch: Exception -> L8
        r19.putExtra("original_type", r12);     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r16) == true) goto L11;
        r19.putExtra("original_transition_name", r16);     // Catch: Exception -> L8
    L11:
        if (TextUtils.isEmpty(r17) == true) goto L13;
        r19.putExtra("isid", r17);     // Catch: Exception -> L8
    L13:
        r19.setFlags(r15);     // Catch: Exception -> L8
        r19.setPackage(r10.getPackageName());     // Catch: Exception -> L8
        if (r12 != 8) goto L17;
    L23:
        r19.putExtra("original_from", r13);     // Catch: Exception -> L8
        r10.startActivity(r19);     // Catch: Exception -> L8
    L25:
        if (TextUtils.isEmpty(r13) == true) goto L27;
        StringBuilder r20 = new StringBuilder();     // Catch: Exception -> L8
        d9.a.b(r20, "source_page", r13);     // Catch: Exception -> L8
        d9.a.b(r20, "type", String.valueOf(r14));     // Catch: Exception -> L8
        d9.a.e().Q("0067", r20.toString());     // Catch: Exception -> L8
        return;
    L27:
        j.e("App detail,unkown source.");     // Catch: Exception -> L8
        return;
    L17:
        if (r12 == 9) goto L23;
        if (r14 != 3) goto L22;
        r19.putExtra("original_from", r13);     // Catch: Exception -> L8
    L22:
        r10.startActivity(r19, r18);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e0.g(e.getMessage());
        return;
    }

    public static Bitmap p(Drawable r10) {
        Drawable r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof BitmapDrawable) == true) goto L8;
        Class<?> r12 = Class.forName("android.graphics.drawable.AdaptiveIconDrawable");     // Catch: Exception -> L13
        if (r12.isInstance(r10) == false) goto L15;
        r11 = new LayerDrawable(new Drawable[]{(Drawable) r12.getDeclaredMethod("getBackground", null).invoke(r10, null), (Drawable) r12.getDeclaredMethod("getForeground", null).invoke(r10, null)});     // Catch: Exception -> L13
    L15:
        if (r11 != null) goto L17;
        r11 = r10;
    L17:
        Bitmap r13 = Bitmap.createBitmap(r11.getIntrinsicWidth(), r11.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r14 = new Canvas(r13);
        r10.setBounds(0, 0, r14.getWidth(), r14.getHeight());
        r10.draw(r14);
        return r13;
    L13:
        e = move-exception;
        e.printStackTrace();
        j.e("drawable exception");
        goto L15
    L8:
        return ((BitmapDrawable) r10).getBitmap();
    }

    public static boolean p0() {
        return q0(500);
    }

    public static void p1(Context r10, String r11, int r12, String r13, int r14, String r15) {
        o1(r10, r11, r12, r13, r14, 0, null, r15, null);
    }

    public static List q(Map r10, Map r11) {
        ArrayList r12 = new ArrayList();
        if (r11 != null) goto L5;
    L16:
        return r12;
    L5:
        if (r11.isEmpty() == true) goto L16;
        Iterator r13 = r11.entrySet().iterator();     // Catch: Exception -> L14
    L9:
        if (r13.hasNext() == false) goto L16;
        String r14 = (String) ((Map.Entry) r13.next()).getKey();     // Catch: Exception -> L14
        if (r10.containsKey(r14) == true) goto L9;
        r12.add(r14);     // Catch: Exception -> L14
        r13.remove();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static boolean q0(int r10) {
        long r11 = System.currentTimeMillis();
        long r12 = f10022d;
        if (r12 != 0) goto L5;
    L13:
        f10022d = r11;
        return true;
    L5:
        if (r12 > r11) goto L13;
        long r13 = r11 - r12;
        if (r13 <= r10) goto L11;
        f10022d = r11;
        return true;
    L11:
        j.e("click setting btn after " + r13);
        return false;
    }

    public static void q1(View r10, View r11, AnimationEndCallBack r12) {
        if (r11 == null) goto L14;
        if (r10 == null) goto L15;
        r10.setVisibility(8);
        r11.setVisibility(0);
        r10.clearAnimation();     // Catch: Exception -> L8
        r11.clearAnimation();     // Catch: Exception -> L8
    L10:
        r10.startAnimation(AnimationUtils.loadAnimation(BaseApplication.c(), R$anim.slide_out_to_left));
        Animation r13 = AnimationUtils.loadAnimation(BaseApplication.c(), R$anim.slide_in_from_right);
        r13.setAnimationListener(new b(r12));
        r11.startAnimation(r13);
        return;
    L8:
        e = move-exception;
        e.getStackTrace();
        goto L10
    L15:
        return;
    }

    public static String r(String r10) {
        return new DecimalFormat("#,###").format(d0.c(r10));
    L4:
        e = move-exception;
        e.printStackTrace();
        return r10;
    }

    public static boolean r0(AppInfo r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        File r11 = new File(H(), C(r10, true));
        if (r11.isFile() == true) goto L9;
        return false;
    L9:
        if (r11.length() == r10.appBytes) goto L25;
        j.n("file size error:" + r11.getName());
        return false;
    L25:
        int r12 = u(r11.getName());     // Catch: Exception -> L19
        if (r12 >= 0) goto L15;
    L21:
        j.n("file version error:" + r11.getName());     // Catch: Exception -> L19
        return false;
    L15:
        if (r12 < r10.appVersionCode) goto L21;
        r10.downloadFilePath = r11.getAbsolutePath().replace("_bak.patch", ".patch");
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void r1(Activity r10, String r11, int r12, String r13, String r14) {
        s1(r10, r11, r12, r13, r14, null);
    }

    public static OTextTag s(int r10) {
        switch(r10) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L4;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L4;
        };
    L4:
        j.a("lable = " + r10);
        return null;
    L6:
        OTextTag r11 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Red_Light), null, R$attr.oui_radius);
        r11.setText(R$string.label_tnt);
        return r11;
    L7:
        OTextTag r12 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Green_Light), null, R$attr.oui_radius);
        r12.setText(R$string.label_pre_download);
        return r12;
    L8:
        OTextTag r13 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Green_Light), null, R$attr.oui_radius);
        r13.setText(R$string.label_one_step);
        return r13;
    L9:
        OTextTag r14 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Accent_Light), null, R$attr.oui_radius);
        r14.setText(R$string.label_promote);
        return r14;
    L10:
        OTextTag r15 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Salmon_Light), null, R$attr.oui_radius);
        r15.setText(R$string.label_gift);
        return r15;
    L11:
        OTextTag r16 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Accent_Light), null, R$attr.oui_radius);
        r16.setText(R$string.label_selected);
        return r16;
    L12:
        OTextTag r17 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Green_Light), null, R$attr.oui_radius);
        r17.setText(R$string.label_game);
        return r17;
    L13:
        OTextTag r18 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Red_Light), null, R$attr.oui_radius);
        r18.setText(R$string.label_first);
        return r18;
    L14:
        OTextTag r19 = new OTextTag(new ContextThemeWrapper(BaseApplication.c(), R$style.OTag_Text_Small_RoundedRectangle_Gray_Light), null, R$attr.oui_radius);
        r19.setText(R$string.label_ads);
        return r19;
    }

    public static boolean s0(TextView r10) {
        Layout r11 = r10.getLayout();
        if (r11 == null) goto L9;
        int r12 = r11.getLineCount();
        if (r12 > 0) goto L7;
        return false;
    L7:
        if (r11.getEllipsisCount(r12 - 1) <= 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    public static void s1(Activity r10, String r11, int r12, String r13, String r14, String r15) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (p0() == false) goto L8;
        Intent r16 = new Intent();
        r16.setAction("com.bytedanceos.app.category.group.list");
        r16.putExtra(ElementTextEntity.Key.CATEGORY_ID, r11);
        r16.putExtra("app_group_more_view_type", r12);
        r16.putExtra(ElementTextEntity.Key.CATEGORY_NAME, r13);
        r16.putExtra("original_back_info", r14);
        r16.putExtra("parent_category_id", r15);
        r16.setPackage(r10.getPackageName());
        r10.startActivity(r16);
        return;
    }

    public static NetworkInfo t() {
        if (BaseApplication.c() != null) goto L7;
        return null;
    L7:
        return ((ConnectivityManager) BaseApplication.c().getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean t0() {
        if (BaseApplication.c() != null) goto L16;
        return false;
    L16:
        NetworkInfo r10 = ((ConnectivityManager) BaseApplication.c().getSystemService("connectivity")).getNetworkInfo(9);     // Catch: Exception -> L11
        if (r10 == null) goto L13;
        if (r10.isConnected() == false) goto L18;
        return true;
    L18:
        return false;
    L13:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void t1(Activity r10, String r11, String r12, String r13) {
        r1(r10, r11, 10, r12, r13);
    }

    public static int u(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return -1;
    L15:
        String[] r11 = r10.split("_");     // Catch: Exception -> L9
        if (r11.length >= 2) goto L12;
        j.n("file format error:" + r10);     // Catch: Exception -> L9
        return -1;
    L12:
        return c0.b(r11[1]);
    L9:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static boolean u0() {
        if (2 == A()) goto L6;
        j.n("[AutoUpdate] isGameReserveAutoDownload allow = FALSE ! auto update,wifi is not active.");
        return false;
    L6:
        Intent r10 = BaseApplication.c().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r10 != null) goto L10;
        j.n("[AutoUpdate] isGameReserveAutoDownload allow = FALSE ! get battery params error:");
        return false;
    L10:
        int r11 = r10.getIntExtra("level", 0);
        if (r11 >= (h8.b.b().a() * 2)) goto L14;
        j.n("[AutoUpdate] isGameReserveAutoDownload allow = FALSE ! battery level:" + r11);
        return false;
    L14:
        return true;
    }

    public static void u1(Activity r10, AppInfo r11, int r12, int r13, int r14) {
        Intent r15 = new Intent(r10, CommentsActivity.class);
        r15.putExtra("original_data", r11);
        r15.putExtra("original_type", r12);
        r15.putExtra("original_from", r13);
        if (r14 <= 0) goto L5;
        r10.startActivityForResult(r15, r14);
        return;
    L5:
        r10.startActivity(r15);
    }

    public static String v(AppInfo r10, boolean r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.appPackageName);
        r12.append("_");
        r12.append(r10.appVersionCode);
        if (r11 == false) goto L5;
        r12.append("_bak.apk");
    L7:
        return r12.toString();
    L5:
        r12.append(".apk");
        goto L7
    }

    public static boolean v0(Context r10) {
        PackageManager r11 = r10.getPackageManager();
        r11.getApplicationInfo("com.google.android.gsf.login", 256);     // Catch: Throwable -> L6
        r11.getApplicationInfo("com.google.android.gsf", 256);     // Catch: Throwable -> L6
        return true;
    L6:
        return false;
    }

    public static void v1(Activity r10, AppInfo r11) {
        if (r10 == null) goto L6;
        if (r11 == null) goto L6;
        return;
    L6:
        j.a("imput params is null");
    }

    public static JSONObject w(AppInfo r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L8
        r11.put("package", r10.appPackageName);     // Catch: Exception -> L8
        r11.put("version_code", r10.appVersionCode);     // Catch: Exception -> L8
        if (r10.isSystemApp() == true) goto L12;
        if (TextUtils.isEmpty(r10.mBaseApkMd5) == false) goto L10;
        long r12 = System.currentTimeMillis();     // Catch: Exception -> L8
        r11.put("apk_md5", L(r10.appPackageName));     // Catch: Exception -> L8
        j.a("get update params " + r10.appPackageName + " | " + (System.currentTimeMillis() - r12));     // Catch: Exception -> L8
        goto L12
    L10:
        r11.put("apk_md5", r10.mBaseApkMd5);     // Catch: Exception -> L8
    L12:
        if (E0(r10.appPackageName) == false) goto L14;
        r11.put("is_32_bit", 1);     // Catch: Exception -> L8
    L14:
        return r11;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean w0(String r10, String r11) {
        if (O0(r11).doubleValue() < O0(r10).doubleValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void w1(Activity r10, String r11, String r12, String r13, String r14) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (p0() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L11;
        Intent r15 = new Intent();
        r15.setAction("com.bytedanceos.app.category");
        r15.putExtra(ElementTextEntity.Key.CATEGORY_ID, r11);
        r15.putExtra("sub_category_id", r12);
        r15.putExtra(ElementTextEntity.Key.CATEGORY_NAME, r13);
        r15.putExtra("original_back_info", r14);
        r15.setPackage(r10.getPackageName());
        r10.startActivity(r15);
        return;
    }

    public static String x(AppInfo r10, String r11, String r12) {
        if (r10 == null) goto L34;
        String r13 = d9.a.a(d9.a.a(d9.a.a("", "pkg_name", r10.appPackageName), "source_page", r11), "source_page_name", r12);
        AppInfo.From r14 = r10.appFrom;
        if (r14 == null) goto L33;
        if (r14.mark == null) goto L33;
        if (TextUtils.equals(r14.operative_type, "2") == false) goto L11;
        String r15 = d9.a.a(r13, "download_sign", "1");
    L12:
        String r16 = r10.appFrom.mark;
        if ("local".equals(r16) == false) goto L16;
        int r17 = 0;
    L28:
        if (r17 <= 0) goto L31;
        String r18 = d9.a.a(r15, DownloadInfoColumns.APP_SOURCE, "" + r17);
    L35:
        return r18;
    L31:
        r18 = d9.a.a(r15, DownloadInfoColumns.APP_SOURCE, AdReportParam.ClickPosType.SKIP);
        goto L35
    L16:
        if ("wdj".equals(r16) == false) goto L19;
        r17 = 1;
        goto L28
    L19:
        if ("yyb".equals(r16) == false) goto L22;
        r17 = 2;
        goto L28
    L22:
        if ("dev".equals(r16) == false) goto L25;
        r17 = 3;
        goto L28
    L25:
        if ("9game".equals(r16) == false) goto L27;
        r17 = 4;
        goto L28
    L27:
        r17 = -1;
        goto L28
    L11:
        r15 = d9.a.a(r13, "download_sign", AdReportParam.ClickPosType.SKIP);
    L33:
        return d9.a.a(d9.a.a(r13, DownloadInfoColumns.APP_SOURCE, AdReportParam.ClickPosType.SKIP), "download_sign", AdReportParam.ClickPosType.SKIP);
    L34:
        return "";
    }

    public static boolean x0(String r10) {
        if (M(r10) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void x1(Activity r10, Topic r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (p0() == false) goto L15;
        Intent r12 = new Intent();
        r12.setAction("com.bytedanceos.app.topic");
        r12.putExtra("topic_page", r11);
        r12.setPackage(r10.getPackageName());
        if (TextUtils.equals(r11.getTabSource(), "external_jump") == false) goto L10;
        String r13 = ReflectTool.getIntentSmtExtraName("get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID", new Class[0]);
        if (TextUtils.isEmpty(r13) == true) goto L10;
        r12.putExtra(r13, new int[]{R$anim.fake_anim, R$anim.slide_down_out});
    L10:
        r10.startActivity(r12);
        if (TextUtils.equals(r11.getTabSource(), "external_jump") == false) goto L16;
        r10.overridePendingTransition(R$anim.pop_up_in, R$anim.fake_anim);
        return;
    L16:
        return;
    }

    public static Bitmap y(Bitmap r10) {
        int r11 = r10.getWidth();
        Bitmap r12 = Bitmap.createBitmap(r11, r11, Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(r12);
        Paint r14 = new Paint();
        Rect r15 = new Rect(0, 0, r10.getWidth(), r10.getHeight());
        r14.setAntiAlias(true);
        r14.setColor(-12434878);
        float r16 = r11 / 2;
        r13.drawCircle(r16, r16, r16, r14);
        r14.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r13.drawBitmap(r10, r15, r15, r14);
        return r12;
    }

    public static boolean y0(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (BaseApplication.c().getPackageName().equals(r10) == true) goto L7;
        return true;
    }

    public static void y1(Activity r10, Topic r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (p0() == false) goto L15;
        Intent r12 = new Intent();
        r12.setAction("com.bytedanceos.app.topic.compat");
        r12.putExtra("topic_page", r11);
        r12.setPackage(r10.getPackageName());
        if (TextUtils.equals(r11.getTabSource(), "external_jump") == false) goto L10;
        String r13 = ReflectTool.getIntentSmtExtraName("get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID", new Class[0]);
        if (TextUtils.isEmpty(r13) == true) goto L10;
        r12.putExtra(r13, new int[]{R$anim.fake_anim, R$anim.slide_down_out});
    L10:
        r10.startActivity(r12);
        if (TextUtils.equals(r11.getTabSource(), "external_jump") == false) goto L16;
        r10.overridePendingTransition(R$anim.pop_up_in, R$anim.fake_anim);
        return;
    L16:
        return;
    }

    public static float z() {
        Configuration r10 = new Configuration();
        r10.updateFrom(ActivityManagerNative.getDefault().getConfiguration());     // Catch: RemoteException -> L6
    L5:
        return r10.fontScale;
    }

    public static boolean z0() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return true;
    L6:
        return false;
    }

    public static void z1(Subscriber r10) {
        if (r10 == null) goto L5;
        r10.unsubscribe();
        return;
    }
}
