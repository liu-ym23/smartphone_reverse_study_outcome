package com.android.contacts.bytedanceosquickcontact;

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
import com.android.contacts.util.PhoneCapabilityTester;
import com.google.android.collect.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import obric.api.TelephonySmt;

/* JADX INFO: loaded from: classes.dex */
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
        sPreferResolve = Sets.newHashSet(new String[]{Constants.EMAIL_PACKAGE_NAME, "com.android.calendar", "com.android.contacts", "com.android.mms", TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME, "com.android.browser"});
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
    /* JADX WARN: Type inference failed for: r2v0, types: [com.android.contacts.bytedanceosquickcontact.ResolveCache$1] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    protected Entry getEntry(Action r7) {
        String r0 = r7.getMimeType();
        Entry r1 = this.mCache.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        ResolveInfo r2 = 0;
        r2 = 0;
        Entry r3 = new Entry(r2);
        Intent r8 = r7.getIntent();
        if ("vnd.android.cursor.item/sip_address".equals(r0) == true) goto L8;
    L10:
        if (r8 == null) goto L20;
        List<ResolveInfo> r4 = this.mPackageManager.queryIntentActivities(r8, 65536);
        if (r4 == null) goto L18;
        int r5 = r4.size();
        if (r5 != 1) goto L16;
        r2 = r4.get(0);
        goto L18
    L16:
        if (r5 <= 1) goto L18;
        r2 = getBestResolve(r8, r4);
    L18:
        if (r2 == 0) goto L20;
        Drawable r9 = r2.loadIcon(this.mPackageManager);
        r3.bestResolve = r2;
        r3.icon = r9;
    L20:
        this.mCache.put(r0, r3);
        return r3;
    L8:
        if (PhoneCapabilityTester.isSipPhone(this.mContext) == true) goto L10;
        r8 = null;
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

    public CharSequence getDescription(Action r2) {
        CharSequence r0 = r2.getSubtitle();
        ResolveInfo r3 = getEntry(r2).bestResolve;
        if (r3 == null) goto L7;
        return r3.loadLabel(this.mPackageManager);
    L7:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return null;
    }

    public Drawable getIcon(Action r1) {
        return getEntry(r1).icon;
    }

    public void clear() {
        this.mCache.clear();
    }
}
