package com.bytedanceos.common.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageParser;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$string;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.TrustManager;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectTool {
    private static final int IMSISTRLENGTH = 3;

    public ReflectTool() {
    }

    public static void addBackAnimsForOtherApp(Intent r10, String r11, String r12) {
        if (r10 != null) goto L5;
        com.bytedanceos.common.toolbox.j.e("input params error:");
        return;
    L5:
        int r13 = 0;
        String r14 = getIntentSmtExtraName("get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID", new Class[0]);
        if (TextUtils.isEmpty(r14) == false) goto L22;
        com.bytedanceos.common.toolbox.j.e("unkown EXTRA_BYTEDANCE_ANIM_RESOURCE_ID.");
        return;
    L22:
        if (TextUtils.isEmpty(r11) == true) goto L13;
        int r15 = BaseApplication.c().getResources().getIdentifier(r11, "anim", "bytedanceos");     // Catch: Exception -> L21
    L15:
        if (TextUtils.isEmpty(r12) == true) goto L17;
        r13 = BaseApplication.c().getResources().getIdentifier(r12, "anim", "bytedanceos");     // Catch: Exception -> L21
    L17:
        if (r15 != 0) goto L19;
        if (r13 != 0) goto L19;
        return;
    L19:
        r10.putExtra(r14, new int[]{r15, r13});     // Catch: Exception -> L21
        return;
    L13:
        r15 = 0;
    }

    public static void attachShareItems(Intent r10, boolean r11, String r12) {
        ArrayList<? extends Parcelable> r13 = new ArrayList();
        Class<?> r14 = Class.forName("bytedanceos.app.share.ShareItem");     // Catch: Exception -> L17
        if (r11 == false) goto L10;
        Class r15 = Integer.TYPE;     // Catch: Exception -> L17
        Object r16 = r14.getDeclaredMethod("createForCustom", new Class[]{String.class, r15, r15, String.class}).invoke(r14, new Object[]{BaseApplication.c().getPackageName(), Integer.valueOf(R$drawable.share_to_sesson), Integer.valueOf(R$string.share_to_wx_session), r12});     // Catch: Exception -> L17
        if (r16 == null) goto L10;
        if ((r16 instanceof Parcelable) == false) goto L10;
        r13.add((Parcelable) r16);     // Catch: Exception -> L17
    L10:
        Field r17 = r14.getDeclaredField("EXTRA_SHARE_ITEM_DATAS");     // Catch: Exception -> L17
        if (r17 != null) goto L13;
        return;
    L13:
        if (r17.get(null) == null) goto L21;
        r10.putParcelableArrayListExtra(r17.get(null).toString(), r13);     // Catch: Exception -> L17
        return;
    L21:
        return;
    }

    public static void collectCertificates(PackageParser r10, PackageParser.Package r11) throws Exception {
        if (r10 == null) goto L16;
        if (r11 == null) goto L18;
        Method r12 = r10.getClass().getDeclaredMethod("collectCertificates", new Class[]{PackageParser.Package.class, Integer.TYPE});     // Catch: NoSuchMethodException -> L8
        Object r13 = 0;     // Catch: NoSuchMethodException -> L8
    L10:
        if (Modifier.isStatic(r12.getModifiers()) == false) goto L12;
        r12.invoke(r10.getClass(), new Object[]{r11, r13});
        return;
    L12:
        r12.invoke(r10, new Object[]{r11, r13});
        return;
    L8:
        r12 = r10.getClass().getDeclaredMethod("collectCertificates", new Class[]{PackageParser.Package.class, Boolean.class});
        r13 = Boolean.FALSE;
        goto L10
    L18:
        return;
    }

    public static void dragLink(View r10, Context r11, CharSequence r12, Bitmap r13, Bitmap r14) {
        Class<?> r15 = Class.forName("bytedanceos.util.SidebarUtils");     // Catch: Exception -> L5
        r15.getDeclaredMethod("dragLink", new Class[]{View.class, Context.class, CharSequence.class, Bitmap.class, Bitmap.class}).invoke(r15, new Object[]{r10, r11, r12, r13, r14});     // Catch: Exception -> L5
        return;
    }

    public static StatusBarNotification[] getActiveNotifications(NotificationManager r10) {
        Object r11 = r10.getClass().getDeclaredMethod("getActiveNotifications", null).invoke(r10, null);     // Catch: Exception -> L10
        if (r11 == null) goto L9;
        if ((r11 instanceof StatusBarNotification[]) == false) goto L9;
        return (StatusBarNotification[]) r11;
    L9:
        return null;
    }

    public static Notification.Style getButtonStyle(Context r10) {
        Class<?> r11 = Class.forName("bytedanceos.api.NotificationSmt");     // Catch: Throwable -> L5
        return (Notification.Style) r11.getDeclaredMethod("new_ButtonStyle", null).invoke(r11, null);
    L5:
        return null;
    }

    public static String getBytedanceID() {
        String r10 = ne.a.a(BaseApplication.c());     // Catch: Throwable -> L8
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10;
    L12:
        return "";
    }

    public static String getCountryCode() {
        String r10 = "";
        Class<?> r11 = Class.forName("bytedanceos.util.Utils");     // Catch: Exception -> L15
        Object r12 = r11.getDeclaredMethod("getSubscriberID", null).invoke(r11, null);     // Catch: Exception -> L15
        if (r12 == null) goto L10;
        if ((r12 instanceof String) == false) goto L10;
        r10 = (String) r12;     // Catch: Exception -> L15
    L10:
        if (r10.length() >= 3) goto L14;
        return "460";
    L14:
        return r10.substring(0, 3);
    }

    public static Object getFiledNameFromClass(String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        Field r12 = Class.forName(r10).getDeclaredField(r11);     // Catch: Exception -> L15
        if (r12 == null) goto L14;
        if (r12.get(null) == null) goto L14;
        return r12.get(null);
    }

    public static String getIntentSmtExtraName(String r10, Class<?>... r11) {
        if (r10 != null) goto L20;
        return null;
    L20:
        Class<?> r12 = Class.forName("bytedanceos.api.IntentSmt");     // Catch: Exception -> L19
        if (r11 != null) goto L8;
    L11:
        Method r13 = r12.getMethod(r10, null);     // Catch: Exception -> L19
    L12:
        Object r14 = r13.invoke(r12, null);     // Catch: Exception -> L19
        if (r14 == null) goto L18;
        if ((r14 instanceof String) == false) goto L18;
        return String.valueOf(r14);
    L8:
        if (r11.length == 0) goto L11;
        r13 = r12.getMethod(r10, r11);     // Catch: Exception -> L19
    L18:
        return null;
    }

    public static TrustManager getTrustManagerInstance() {
        return (TrustManager) Class.forName("bytedanceos.util.GeoTrustManager").newInstance();
    L4:
        return null;
    }

    public static void goToCleanerSafely(Context r10, boolean r11) {
        Intent r12 = new Intent().setComponent(com.bytedanceos.common.toolbox.d.a.f10016b).putExtra("notification", true);
        boolean r13 = r10 instanceof Activity;
        if (r13 == true) goto L5;
        r12.setFlags(268468224);
    L5:
        if (r11 == false) goto L24;
        addBackAnimsForOtherApp(r12, "slide_in_from_left", "slide_out_to_right");
    L24:
        r10.startActivity(r12);     // Catch: Exception -> L13
        if (r11 == true) goto L10;
        return;
    L10:
        if ((r10 instanceof Activity) == false) goto L27;
        ((Activity) r10).overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);     // Catch: Exception -> L13
        return;
    L27:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        com.bytedanceos.common.toolbox.j.n("goto fallback cleaner");
        r10.startActivity(r12.setComponent(com.bytedanceos.common.toolbox.d.a.f10017c));     // Catch: Exception -> L17
    L18:
        if (r11 == false) goto L28;
        if (r13 == false) goto L29;
        ((Activity) r10).overridePendingTransition(R$anim.slide_in_from_right, R$anim.slide_out_to_left);
        return;
    L29:
        return;
    L28:
        return;
    L17:
        com.bytedanceos.common.toolbox.j.n("goto fallback cleaner failed");
        goto L18
    }

    public static Object initTracker() {
        Object r10 = null;
        Class<?> r11 = Class.forName("bytedanceos.app.tracker.Agent");     // Catch: Exception -> L5
        r10 = r11.getDeclaredMethod("getInstance", null).invoke(r11, null);     // Catch: Exception -> L5
        r10.getClass().getDeclaredMethod("init", new Class[]{Application.class}).invoke(r10, new Object[]{BaseApplication.c()});     // Catch: Exception -> L5
        return r10;
    L8:
        return r10;
    }

    public static boolean isAppActive(PackageManager r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L14;
        return true;
    L14:
        Class<?> r12 = Class.forName("bytedanceos.api.PackageManagerSmt");     // Catch: Exception -> L13
        Object r13 = r12.getDeclaredMethod("get_ACTIVE_STATE_NOT_ACTIVE", null).invoke(r12, null);     // Catch: Exception -> L13
        if (r13 != null) goto L8;
        return true;
    L8:
        Method r14 = r12.getDeclaredMethod("getPackageActiveState", new Class[]{PackageManager.class, String.class});     // Catch: Exception -> L13
        r14.setAccessible(true);     // Catch: Exception -> L13
        if (r13.equals(r14.invoke(r12.getDeclaredMethod("getInstance", null).invoke(r12, null), new Object[]{r10, r11})) == false) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean isAppInTop(String r10) {
        Iterator<ActivityManager.RecentTaskInfo> r11 = ((ActivityManager) BaseApplication.c().getSystemService("activity")).getRecentTasks(Channel.UNLIMITED, 0).iterator();     // Catch: Exception -> L14
    L5:
        if (r11.hasNext() == false) goto L13;
        ActivityManager.RecentTaskInfo r12 = r11.next();     // Catch: Exception -> L14
        boolean r13 = ((Boolean) Reflect.on(r12).get("isVisible", new Class[0])).booleanValue();     // Catch: Exception -> L14
        ComponentName r14 = r12.topActivity;     // Catch: Exception -> L14
        if (r13 == false) goto L5;
        if (TextUtils.equals(r14.getPackageName(), r10) == false) goto L5;
        com.bytedanceos.common.toolbox.j.a("[top pkg] " + r14.getPackageName());     // Catch: Exception -> L14
        return true;
    L13:
        return false;
    }

    public static boolean isMultiSimEnabled() {
        Class<?> r10 = Class.forName("bytedanceos.util.MultiSimAdapter");     // Catch: Exception -> L10
        Object r11 = r10.getDeclaredMethod("isMultiSimEnabled", null).invoke(r10, null);     // Catch: Exception -> L10
        if (r11 != null) goto L5;
        return false;
    L5:
        if ((r11 instanceof Boolean) == false) goto L13;
        return ((Boolean) r11).booleanValue();
    L13:
        return false;
    L14:
        return false;
    }

    public static boolean isSidebarShowing(Context r10) {
        Class<?> r11 = Class.forName("bytedanceos.util.SidebarUtils");     // Catch: Exception -> L10
        Object r12 = r11.getDeclaredMethod("isSidebarShowing", new Class[]{Context.class}).invoke(r11, new Object[]{r10});     // Catch: Exception -> L10
        if (r12 != null) goto L5;
        return false;
    L5:
        if ((r12 instanceof Boolean) == false) goto L13;
        return ((Boolean) r12).booleanValue();
    L13:
        return false;
    L14:
        return false;
    }

    public static boolean isWechatShare(String r10, Intent r11) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        Class<?> r12 = Class.forName("bytedanceos.app.share.ShareItem");     // Catch: Exception -> L27
        Field r13 = r12.getDeclaredField("EXTRA_SHARE_ITEM_RETURN_TARGET");     // Catch: Exception -> L27
        if (r13 == null) goto L26;
        if (r13.get(null) == null) goto L26;
        if (r10.equals(r11.getStringExtra(r13.get(null).toString())) == true) goto L14;
        return false;
    L14:
        Field r14 = r12.getDeclaredField("EXTRA_SHARE_ITEM_RETURN_TYPE");     // Catch: Exception -> L27
        if (r14 == null) goto L26;
        if (r14.get(null) == null) goto L26;
        Field r15 = r12.getDeclaredField("SHARE_ITEM_TYPE_CUSTOM");     // Catch: Exception -> L27
        int r16 = r11.getIntExtra(r14.get(null).toString(), -1);     // Catch: Exception -> L27
        if (r15 == null) goto L26;
        if (r15.getInt(null) != r16) goto L26;
        return true;
    L26:
        return false;
    }

    public static void onAgentOs(String r10, String r11, String r12) {
        Class<?> r13 = Class.forName("bytedanceos.app.tracker.AgentOs");     // Catch: Exception -> L5
        Object r14 = r13.getDeclaredMethod("getInstance", null).invoke(r13, null);     // Catch: Exception -> L5
        r13.getDeclaredMethod("init", new Class[]{Context.class}).invoke(r14, new Object[]{BaseApplication.c()});     // Catch: Exception -> L5
        r13.getDeclaredMethod(r10, new Class[]{String.class, String.class}).invoke(r14, new Object[]{r11, r12});     // Catch: Exception -> L5
        r13.getDeclaredMethod("flush", null).invoke(r14, null);     // Catch: Exception -> L5
        return;
    }

    public static void onTrackerEvent(Object r10, String r11, Object... r12) {
    }

    @TargetApi(19)
    public static void setAllowAutoStart(Context r11) {
        PackageInfo r10 = r11.getPackageManager().getPackageInfo(r11.getPackageName(), 0);     // Catch: Throwable -> L10
        Class<?> r12 = Class.forName("bytedanceos.api.SmtOpsManagerSmt");     // Catch: Throwable -> L10
        int r13 = r12.getDeclaredField("OP_BOOT_COMPLETED").getInt(null);     // Catch: Throwable -> L10
        Class r14 = Integer.TYPE;     // Catch: Throwable -> L10
        Method r15 = r12.getDeclaredMethod("checkOpNoThrow", new Class[]{Context.class, r14, r14, String.class});     // Catch: Throwable -> L10
        r15.setAccessible(true);     // Catch: Throwable -> L10
        Object r16 = r15.invoke(r12.getDeclaredMethod("getInstance", null).invoke(r12, null), new Object[]{r11, Integer.valueOf(r13), Integer.valueOf(r10.applicationInfo.uid), r10.packageName});     // Catch: Throwable -> L10
        Object r17 = r12.getDeclaredMethod("get_MODE_ALLOWED", null).invoke(r12, null);     // Catch: Throwable -> L10
        if (r17 != null) goto L6;
    L8:
        com.bytedanceos.common.toolbox.j.a("marshmallow allow auto start!");     // Catch: Throwable -> L10
    L11:
        return;
    L6:
        if (r17.equals(r16) == true) goto L8;
        r12.getDeclaredMethod("setMode", new Class[]{Integer.class, Integer.class, String.class}).invoke(r12.newInstance(), new Object[]{Integer.valueOf(r13), Integer.valueOf(r10.applicationInfo.uid), r10.packageName});     // Catch: Throwable -> L10
    }

    public static void setMaxTextSize(TextView r10, int r11) {
        int r12 = BaseApplication.c().getResources().getDimensionPixelSize(r11);     // Catch: Exception -> L8
        if (r10 == null) goto L11;
        if (r12 <= 0) goto L12;
        r10.getClass().getDeclaredMethod("setMaxTextSize", new Class[]{Float.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r12)});     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void setNeedGMS(DownloadManager.Request r10, boolean r11) {
        if (r11 == false) goto L10;
        if (r10 == null) goto L11;
        Method r12 = r10.getClass().getDeclaredMethod("setNeedGMS", new Class[]{Boolean.TYPE});     // Catch: Exception -> L7
        r12.setAccessible(true);     // Catch: Exception -> L7
        r12.invoke(r10, new Object[]{Boolean.valueOf(r11)});     // Catch: Exception -> L7
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void setToastWindowType(Toast r10, int r11) {
        if (r10 == null) goto L10;
        if (r11 <= 0) goto L11;
        r10.getClass().getDeclaredMethod("setToastWindowType", new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: Exception -> L7
        return;
    L12:
        return;
    L11:
        return;
    }
}
