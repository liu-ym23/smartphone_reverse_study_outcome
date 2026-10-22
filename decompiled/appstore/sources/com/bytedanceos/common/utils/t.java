package com.bytedanceos.common.utils;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Parcelable;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.ui.WxShareActivity;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f10224a;

    public static /* synthetic */ class a {
    }

    public static class b extends BroadcastReceiver {
        public b() {
        }

        public static String a() {
            return BaseApplication.c().getPackageName() + ".ACTION_CHOSEN_COMPONENT";
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (a().equals(r11.getAction()) == true) goto L5;
            return;
        L5:
            if (ReflectTool.isWechatShare("target_wechat_session", r11) == false) goto L9;
            r10.startActivity(r11.setClass(r10, WxShareActivity.class).addFlags(268435456));
            return;
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public t() {
    }

    public static void a(Intent r10, String r11, String r12, byte[] r13) {
        Intent r14 = new Intent(b.a()).putExtra("app_name", r11).putExtra(DownloadInfoColumns.APP_URL, r12).putExtra("app_thumb_bitmap_byte_arry", r13);
        r10.putExtra("android.intent.extra.CHOSEN_COMPONENT_INTENT_SENDER", PendingIntent.getBroadcast(BaseApplication.c(), 0, r14, 167772160).getIntentSender());
    }

    public static Intent b(String r15, String r16, String r17, byte[] r18) {
        Intent r10 = new Intent("android.intent.action.SEND").setType(HTTP.PLAIN_TEXT_TYPE);
        BaseApplication r11 = BaseApplication.c();
        List<ResolveInfo> r12 = r11.getPackageManager().queryIntentActivities(r10, 0);
        if (r12.isEmpty() == true) goto L35;
        ArrayList r13 = new ArrayList();
        Iterator<ResolveInfo> r14 = r12.iterator();
        boolean r19 = false;
    L6:
        if (r14.hasNext() == false) goto L19;
        ResolveInfo r20 = r14.next();
        ActivityInfo r110 = r20.activityInfo;
        if (r110 == null) goto L6;
        ComponentName r111 = com.bytedanceos.common.toolbox.d.a.f10018d;
        if (r111.getPackageName().equals(r110.packageName) == false) goto L15;
        if (r111.getClassName().equals(r110.name) == false) goto L15;
        r19 = true;
    L15:
        if (r110.exported == false) goto L6;
        r13.add(new LabeledIntent(new Intent("android.intent.action.SEND").setType(HTTP.PLAIN_TEXT_TYPE).putExtra("android.intent.extra.TEXT", r15).setComponent(new ComponentName(r110.packageName, r110.name)), r110.packageName, r20.loadLabel(r11.getPackageManager()), r20.icon));
        goto L6
    L19:
        Intent r21 = Intent.createChooser((Intent) r13.remove(0), r11.getString(R$string.share_title));
        if (r21 != null) goto L22;
        return null;
    L22:
        r21.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) r13.toArray(new Parcelable[0]));
        r21.setFlags(Ints.MAX_POWER_OF_TWO);
        r21.putExtra("sort_initial_intents", true);
        ReflectTool.attachShareItems(r21, r19, "target_wechat_session");
        a(r21, r16, r17, r18);
        return r21;
    L35:
        return null;
    }

    public void c() {
        if (this.f10224a != null) goto L9;
        this.f10224a = new b(null);
        IntentFilter r10 = new IntentFilter(b.a());
        if (Build.VERSION.SDK_INT < 33) goto L7;
        BaseApplication.c().registerReceiver(this.f10224a, r10, 4);
        return;
    L7:
        BaseApplication.c().registerReceiver(this.f10224a, r10);
        return;
    }
}
