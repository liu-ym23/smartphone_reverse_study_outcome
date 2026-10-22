package com.android.contacts.quickcontact;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.util.Constants;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.PhoneCapabilityTester;
import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import obric.api.TelephonySmt;

/* JADX INFO: loaded from: classes2.dex */
public class ResolveCache {
    private static ResolveCache sInstance;
    private static final HashSet<String> sPreferResolve = null;
    private HashMap<String, Entry> mCache;
    private final Context mContext;
    private BroadcastReceiver mPackageIntentReceiver;
    private final PackageManager mPackageManager;

    private static class Entry {
        public ResolveInfo bestResolve;
        public Drawable icon;

        private Entry() {
        }

        /* synthetic */ Entry(AnonymousClass1 r1) {
            this();
        }
    }

    static /* synthetic */ void access$000() {
        flush();
    }

    static {
        sPreferResolve = Sets.newHashSet(new String[]{Constants.EMAIL_PACKAGE_NAME, "com.google.android.email", TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME, "com.google.android.apps.maps", "com.android.chrome", "com.google.android.browser", "com.android.browser"});
    }

    public static synchronized ResolveCache getInstance(Context r3) {
        monitor-enter(ResolveCache.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        Context r4 = r3.getApplicationContext();     // Catch: Throwable -> L10
        sInstance = new ResolveCache(r4);     // Catch: Throwable -> L10
        IntentFilter r1 = new IntentFilter("android.intent.action.PACKAGE_ADDED");     // Catch: Throwable -> L10
        r1.addAction("android.intent.action.PACKAGE_REPLACED");     // Catch: Throwable -> L10
        r1.addAction("android.intent.action.PACKAGE_REMOVED");     // Catch: Throwable -> L10
        r1.addAction("android.intent.action.PACKAGE_CHANGED");     // Catch: Throwable -> L10
        r1.addDataScheme("package");     // Catch: Throwable -> L10
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r4, sInstance.mPackageIntentReceiver, r1);     // Catch: Throwable -> L10
    L7:
        ResolveCache r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(ResolveCache.class);
        return r5;
    }

    private static synchronized void flush() {
        monitor-enter(ResolveCache.class);
        sInstance = null;     // Catch: Throwable -> L8
        monitor-exit(ResolveCache.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private ResolveCache(Context r2) {
        this.mPackageIntentReceiver = new AnonymousClass1(this);
        this.mCache = new HashMap();
        this.mContext = r2;
        this.mPackageManager = r2.getPackageManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Entry getEntry(Action r5) {
        String r0 = r5.getMimeType();
        Entry r1 = this.mCache.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        Intent r2 = null;
        Entry r3 = new Entry(0 == true ? 1 : 0);
        Intent r6 = r5.getIntent();
        if ("vnd.android.cursor.item/sip_address".equals(r0) == true) goto L8;
    L10:
        r2 = r6;
    L11:
        if (r2 == null) goto L13;
        this.mPackageManager.queryIntentActivities(r2, 65536);
    L13:
        this.mCache.put(r0, r3);
        return r3;
    L8:
        if (PhoneCapabilityTester.isSipPhone(this.mContext) == true) goto L10;
        goto L10
    }

    protected ResolveInfo getBestResolve(Intent r7, List<ResolveInfo> r8) {
        ResolveInfo r6 = this.mPackageManager.resolveActivity(r7, 65536);
        if ((r6.match & 268369920) != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L8;
        return r6;
    L8:
        Iterator<ResolveInfo> r10 = r8.iterator();
        ResolveInfo r11 = null;
    L10:
        if (r10.hasNext() == false) goto L21;
        ResolveInfo r2 = r10.next();
        if ((r2.activityInfo.applicationInfo.flags & 1) == 0) goto L14;
        boolean r3 = true;
    L16:
        if (sPreferResolve.contains(r2.activityInfo.applicationInfo.packageName) == true) goto L17;
        if (r3 == false) goto L10;
        if (r11 != null) goto L10;
        r11 = r2;
        goto L10
    L17:
        return r2;
    L14:
        r3 = false;
        goto L16
    L21:
        if (r11 == null) goto L24;
        return r11;
    L24:
        return r8.get(0);
    L5:
        r9 = false;
        goto L6
    }

    public boolean hasResolve(Action r1) {
        if (getEntry(r1).bestResolve == null) goto L5;
        return true;
    L5:
        return false;
    }

    public CharSequence getDescription(Action r7, String r8) {
        ResolveInfo r0 = getEntry(r7).bestResolve;
        if (r0 == null) goto L5;
        CharSequence r6 = r0.loadLabel(this.mPackageManager);
    L6:
        CharSequence r1 = r7.getSubtitle();
        if (TextUtils.isEmpty(r8) == false) goto L9;
    L11:
        CharSequence[] r9 = {r6, r7.getBody()};
    L12:
        String r10 = TextUtils.join(HanziToPinyin.Token.SEPARATOR, r9);
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return null;
    L15:
        return r10;
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L11;
        r9 = new CharSequence[]{r6, r8, r1};
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    public Drawable getIcon(Action r1) {
        return getEntry(r1).icon;
    }

    public void clear() {
        this.mCache.clear();
    }
}
