package com.obric.autogui.common.api.platform.packages.appinfo;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;

/* JADX INFO: compiled from: AppInfoEntry.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AppInfoEntry {
    private long antiFraudApkUpdateTime;
    private String appFirstSign;
    private Drawable appIconDrawable;
    private final ApplicationInfo appInfo;
    private CharSequence appLabel;
    private volatile String appMd5;
    private Intent launchIntent;
    private Collection<? extends LauncherEntryInfo> launcherEntries;
    private Collection<? extends LauncherShortcutInfo> launcherShortcuts;
    private final transient Object md5Lock;
    private final transient Object signLock;

    public static /* synthetic */ AppInfoEntry copy$default(AppInfoEntry r12, ApplicationInfo r13, Intent r14, CharSequence r15, Drawable r16, Collection r17, Collection r18, String r19, String r20, long r21, int r23, Object r24) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.aiagent.plugin");
        Collection<? extends LauncherEntryInfo> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r17, Collection.class, "com.obric.aiagent.plugin");
        Collection<? extends LauncherShortcutInfo> r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r18, Collection.class, "com.obric.aiagent.plugin");
        if ((r23 & 1) == 0) goto L5;
        ApplicationInfo r5 = r12.appInfo;
    L7:
        if ((r23 & 2) == 0) goto L9;
        Intent r6 = r12.launchIntent;
    L11:
        if ((r23 & 4) == 0) goto L14;
        r2 = r12.appLabel;
    L14:
        if ((r23 & 8) == 0) goto L16;
        Drawable r7 = r12.appIconDrawable;
    L18:
        if ((r23 & 16) == 0) goto L21;
        r4 = r12.launcherEntries;
    L21:
        if ((r23 & 32) == 0) goto L24;
        r3 = r12.launcherShortcuts;
    L24:
        if ((r23 & 64) == 0) goto L26;
        String r8 = r12.appFirstSign;
    L28:
        if ((r23 & 128) == 0) goto L30;
        String r9 = r12.appMd5;
    L32:
        if ((r23 & 256) == 0) goto L34;
        long r10 = r12.antiFraudApkUpdateTime;
    L36:
        return r12.copy(r5, r6, r2, r7, r4, r3, r8, r9, r10);
    L34:
        r10 = r21;
        goto L36
    L30:
        r9 = r20;
        goto L32
    L26:
        r8 = r19;
        goto L28
    L16:
        r7 = r16;
        goto L18
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final ApplicationInfo component1() {
        return this.appInfo;
    }

    public final Intent component2() {
        return this.launchIntent;
    }

    public final CharSequence component3() {
        return this.appLabel;
    }

    public final Drawable component4() {
        return this.appIconDrawable;
    }

    public final Collection<LauncherEntryInfo> component5() {
        return this.launcherEntries;
    }

    public final Collection<LauncherShortcutInfo> component6() {
        return this.launcherShortcuts;
    }

    public final String component7() {
        return this.appFirstSign;
    }

    public final String component8() {
        return this.appMd5;
    }

    public final long component9() {
        return this.antiFraudApkUpdateTime;
    }

    public final AppInfoEntry copy(ApplicationInfo r14, Intent r15, CharSequence r16, Drawable r17, Collection<? extends LauncherEntryInfo> r18, Collection<? extends LauncherShortcutInfo> r19, String r20, String r21, long r22) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r18, Collection.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r19, Collection.class, "com.obric.aiagent.plugin");
        o.e(r14, "appInfo");
        return new AppInfoEntry(r14, r15, r5, r17, r7, r8, r20, r21, r22);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, AppInfoEntry.class) == true) goto L8;
        return false;
    L8:
        AppInfoEntry r8 = (AppInfoEntry) ZeusTransformUtils.preCheckCast(r7, AppInfoEntry.class, "com.obric.aiagent.plugin");
        if (o.a(this.appInfo, r8.appInfo) == true) goto L12;
        return false;
    L12:
        if (o.a(this.launchIntent, r8.launchIntent) == true) goto L15;
        return false;
    L15:
        if (o.a(this.appLabel, r8.appLabel) == true) goto L18;
        return false;
    L18:
        if (o.a(this.appIconDrawable, r8.appIconDrawable) == true) goto L21;
        return false;
    L21:
        if (o.a(this.launcherEntries, r8.launcherEntries) == true) goto L24;
        return false;
    L24:
        if (o.a(this.launcherShortcuts, r8.launcherShortcuts) == true) goto L27;
        return false;
    L27:
        if (o.a(this.appFirstSign, r8.appFirstSign) == true) goto L30;
        return false;
    L30:
        if (o.a(this.appMd5, r8.appMd5) == true) goto L33;
        return false;
    L33:
        if (this.antiFraudApkUpdateTime == r8.antiFraudApkUpdateTime) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = this.appInfo.hashCode() * 31;
        Intent r1 = this.launchIntent;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        CharSequence r5 = this.appLabel;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Drawable r8 = this.appIconDrawable;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Collection<? extends LauncherEntryInfo> r11 = this.launcherEntries;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Collection<? extends LauncherShortcutInfo> r14 = this.launcherShortcuts;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.appFirstSign;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        if (this.appMd5 == null) goto L31;
        r2 = this.appMd5.hashCode();
    L31:
        return ((r19 + r2) * 31) + Long.hashCode(this.antiFraudApkUpdateTime);
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AppInfoEntry(appInfo=" + this.appInfo + ", launchIntent=" + this.launchIntent + ", appLabel=" + this.appLabel + ", appIconDrawable=" + this.appIconDrawable + ", launcherEntries=" + this.launcherEntries + ", launcherShortcuts=" + this.launcherShortcuts + ", appFirstSign=" + this.appFirstSign + ", appMd5=" + this.appMd5 + ", antiFraudApkUpdateTime=" + this.antiFraudApkUpdateTime + ')';
    }

    public AppInfoEntry(ApplicationInfo r3, Intent r4, CharSequence r5, Drawable r6, Collection<? extends LauncherEntryInfo> r7, Collection<? extends LauncherShortcutInfo> r8, String r9, String r10, long r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        Collection<? extends LauncherEntryInfo> r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r7, Collection.class, "com.obric.aiagent.plugin");
        Collection<? extends LauncherShortcutInfo> r14 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.aiagent.plugin");
        o.e(r3, "appInfo");
        this.appInfo = r3;
        this.launchIntent = r4;
        this.appLabel = r12;
        this.appIconDrawable = r6;
        this.launcherEntries = r13;
        this.launcherShortcuts = r14;
        this.appFirstSign = r9;
        this.appMd5 = r10;
        this.antiFraudApkUpdateTime = r11;
        this.signLock = new Object();
        this.md5Lock = new Object();
    }

    public /* synthetic */ AppInfoEntry(ApplicationInfo r11, Intent r12, CharSequence r13, Drawable r14, Collection r15, Collection r16, String r17, String r18, long r19, int r21, h r22) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r15, Collection.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.wrapperContextForParams(r16, Collection.class, "com.obric.aiagent.plugin");
        String r5 = null;
        if ((r21 & 2) == 0) goto L5;
        Intent r4 = null;
    L7:
        if ((r21 & 4) == 0) goto L10;
        r1 = null;
    L10:
        if ((r21 & 8) == 0) goto L12;
        Drawable r6 = null;
    L14:
        if ((r21 & 16) == 0) goto L17;
        r3 = null;
    L17:
        if ((r21 & 32) == 0) goto L20;
        r2 = null;
    L20:
        if ((r21 & 64) == 0) goto L22;
        String r7 = null;
    L24:
        if ((r21 & 128) != 0) goto L28;
        r5 = r18;
    L28:
        if ((r21 & 256) == 0) goto L30;
        long r8 = 0;
    L31:
        this(r11, r4, r1, r6, r3, r2, r7, r5, r8);
        return;
    L30:
        r8 = r19;
        goto L31
    L22:
        r7 = r17;
        goto L24
    L12:
        r6 = r14;
        goto L14
    L5:
        r4 = r12;
        goto L7
    }

    public final ApplicationInfo getAppInfo() {
        return this.appInfo;
    }

    public final Intent getLaunchIntent() {
        return this.launchIntent;
    }

    public final void setLaunchIntent(Intent r1) {
        this.launchIntent = r1;
    }

    public final CharSequence getAppLabel() {
        return this.appLabel;
    }

    public final void setAppLabel(CharSequence r3) {
        this.appLabel = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final Drawable getAppIconDrawable() {
        return this.appIconDrawable;
    }

    public final void setAppIconDrawable(Drawable r1) {
        this.appIconDrawable = r1;
    }

    public final Collection<LauncherEntryInfo> getLauncherEntries() {
        return this.launcherEntries;
    }

    public final void setLauncherEntries(Collection<? extends LauncherEntryInfo> r3) {
        this.launcherEntries = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
    }

    public final Collection<LauncherShortcutInfo> getLauncherShortcuts() {
        return this.launcherShortcuts;
    }

    public final void setLauncherShortcuts(Collection<? extends LauncherShortcutInfo> r3) {
        this.launcherShortcuts = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
    }

    public final String getAppFirstSign() {
        return this.appFirstSign;
    }

    public final void setAppFirstSign(String r1) {
        this.appFirstSign = r1;
    }

    public final String getAppMd5() {
        return this.appMd5;
    }

    public final void setAppMd5(String r1) {
        this.appMd5 = r1;
    }

    public final long getAntiFraudApkUpdateTime() {
        return this.antiFraudApkUpdateTime;
    }

    public final void setAntiFraudApkUpdateTime(long r1) {
        this.antiFraudApkUpdateTime = r1;
    }

    public final Object getSignLock() {
        return this.signLock;
    }

    public final Object getMd5Lock() {
        return this.md5Lock;
    }
}
