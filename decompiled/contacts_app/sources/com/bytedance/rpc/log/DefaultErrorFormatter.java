package com.bytedance.rpc.log;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.bytedance.rpc.RpcService;
import com.bytedance.rpc.internal.RpcUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultErrorFormatter implements ErrorFormatter {
    private static final IReportFilter DEFAULT_FILTER = null;
    private static DefaultErrorFormatter sDefaultErrorFormat;
    private boolean mCheckActivityName;
    private boolean mEnsureMaxStackCount;
    private boolean mEnsurePackageStackCount;
    private String[] mExtraPackages;
    private TreeSet<String> mImpossiblePackages;
    private int mMaxStackCount;
    private int mMinPackageStackCount;
    private boolean mShowLineNumber;
    private IReportFilter mStackFilter;
    private int mSuggestStackCount;

    public interface IReportFilter {
        boolean acceptReportStack(String r1, String r2);

        String formatReportStack(String r1, Throwable r2, List<StackTraceElement> r3, boolean r4);
    }

    public static DefaultErrorFormatter get() {
        if (sDefaultErrorFormat != null) goto L15;
        monitor-enter(DefaultErrorFormatter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sDefaultErrorFormat != null) goto L9;
        sDefaultErrorFormat = new DefaultErrorFormatter(6, 18, 3, new String[0]);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DefaultErrorFormatter.class);     // Catch: Throwable -> L11
    L15:
        return sDefaultErrorFormat;
    }

    static {
        DEFAULT_FILTER = new AnonymousClass1();
    }

    public DefaultErrorFormatter(int r2, int r3, int r4, String... r5) {
        this.mImpossiblePackages = null;
        this.mExtraPackages = null;
        this.mStackFilter = null;
        this.mShowLineNumber = true;
        this.mEnsurePackageStackCount = true;
        this.mEnsureMaxStackCount = true;
        this.mCheckActivityName = true;
        this.mSuggestStackCount = r2;
        this.mMaxStackCount = r3;
        this.mMinPackageStackCount = r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.length <= 1) goto L9;
        setExtraPackages(r5);
        return;
    }

    public DefaultErrorFormatter setExtraPackages(String... r1) {
        this.mExtraPackages = r1;
        TreeSet<String> r2 = this.mImpossiblePackages;
        if (r2 == null) goto L5;
        r2.clear();
        this.mImpossiblePackages = null;
    L5:
        return this;
    }

    public DefaultErrorFormatter setMaxStackCount(int r1) {
        this.mMaxStackCount = r1;
        return this;
    }

    public DefaultErrorFormatter setMinPackageStackCount(int r1) {
        this.mMinPackageStackCount = r1;
        return this;
    }

    public DefaultErrorFormatter setSuggestStackCount(int r1) {
        this.mSuggestStackCount = r1;
        return this;
    }

    public DefaultErrorFormatter setShowLineNumber(boolean r1) {
        this.mShowLineNumber = r1;
        return this;
    }

    public DefaultErrorFormatter setStackCountConstraint(boolean r1, boolean r2, boolean r3) {
        this.mCheckActivityName = r1;
        this.mEnsurePackageStackCount = r2;
        this.mEnsureMaxStackCount = r3;
        return this;
    }

    public DefaultErrorFormatter setStackFilter(IReportFilter r1) {
        this.mStackFilter = r1;
        return this;
    }

    public static HashSet<String> getAllImpossiblePackage(Context r7, boolean r8) {
        HashSet<String> r0 = new HashSet();
        if (r7 != null) goto L30;
    L29:
        return r0;
    L30:
        String r1 = r7.getApplicationContext().getPackageName();     // Catch: PackageManager.NameNotFoundException -> L27
        if (RpcUtils.isVisible(r1) == false) goto L29;
        r0.add(r1);     // Catch: PackageManager.NameNotFoundException -> L27
        ActivityInfo[] r9 = r7.getApplicationContext().getPackageManager().getPackageInfo(r1, 15).activities;     // Catch: PackageManager.NameNotFoundException -> L27
        if (r9 == null) goto L29;
        if (r9.length <= 0) goto L29;
        int r2 = r9.length;     // Catch: PackageManager.NameNotFoundException -> L27
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L29;
        ActivityInfo r4 = r9[r3];     // Catch: PackageManager.NameNotFoundException -> L27
        if (r4 == null) goto L26;
        if (RpcUtils.isVisible(r4.packageName) == false) goto L26;
        r0.add(r4.packageName);     // Catch: PackageManager.NameNotFoundException -> L27
        if (r8 == false) goto L26;
        String r5 = r4.name;     // Catch: PackageManager.NameNotFoundException -> L27
        if (r5 != null) goto L21;
        int r6 = -1;
    L22:
        if (r6 <= 0) goto L26;
        String r10 = r5.substring(0, r6);     // Catch: PackageManager.NameNotFoundException -> L27
        int r11 = r10.lastIndexOf(46);     // Catch: PackageManager.NameNotFoundException -> L27
        if (r11 <= 0) goto L26;
        r0.add(r10.substring(0, r11));     // Catch: PackageManager.NameNotFoundException -> L27
        goto L26
    L21:
        r6 = r5.lastIndexOf(46);     // Catch: PackageManager.NameNotFoundException -> L27
    L26:
        r3 = r3 + 1;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    protected TreeSet<String> getImpossiblePackages() {
        if (this.mImpossiblePackages != null) goto L32;
        HashSet<String> r0 = getAllImpossiblePackage(RpcService.getRpcContext().getApplicationContext(), this.mCheckActivityName);
        String[] r1 = this.mExtraPackages;
        if (r1 != null) goto L7;
    L14:
        this.mImpossiblePackages = new TreeSet();
        Iterator<String> r2 = r0.iterator();
    L16:
        if (r2.hasNext() == false) goto L32;
        String r3 = r2.next();
        if (this.mImpossiblePackages.isEmpty() == true) goto L28;
        Iterator<String> r4 = this.mImpossiblePackages.iterator();
    L21:
        if (r4.hasNext() == false) goto L28;
        String r5 = r4.next();
        if (r3.startsWith(r5) == true) goto L24;
        if (r5.startsWith(r3) == false) goto L21;
        r4.remove();
        goto L21
    L24:
        boolean r6 = false;
    L29:
        if (r6 == false) goto L16;
        this.mImpossiblePackages.add(r3);
    L28:
        r6 = true;
        goto L29
    L7:
        if (r1.length <= 0) goto L14;
        int r7 = r1.length;
        int r8 = 0;
    L9:
        if (r8 >= r7) goto L14;
        String r9 = r1[r8];
        if (RpcUtils.isVisible(r9) == false) goto L13;
        r0.add(r9);
    L13:
        r8 = r8 + 1;
    L32:
        return this.mImpossiblePackages;
    }

    public static Throwable getLastCause(Throwable r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.getCause() == null) goto L9;
        r1 = r1.getCause();
        goto L4
    L9:
        return r1;
    }

    protected int[] getStackRangeOption(int r4) {
        int[] r0 = new int[3];
        int r1 = this.mMaxStackCount;
        if (r1 > 0) goto L5;
        r0[0] = r4;
    L6:
        int r5 = this.mSuggestStackCount;
        if (r5 > 0) goto L9;
        r0[1] = Math.min(r0[0], 5);
    L10:
        int r3 = this.mMinPackageStackCount;
        if (r3 >= 0) goto L13;
        r0[2] = Math.min(r0[1], 1);
    L14:
        return r0;
    L13:
        r0[2] = Math.min(r0[1], r3);
        goto L14
    L9:
        r0[1] = Math.min(r0[0], r5);
        goto L10
    L5:
        r0[0] = Math.min(r1, r4);
        goto L6
    }

    protected List<StackTraceElement> getBestStackTraceElement(StackTraceElement[] r14, IReportFilter r15) {
        int r0 = r14.length;
        int[] r1 = getStackRangeOption(r0);
        int r3 = r1[0];
        int r5 = r1[1];
        int r2 = r1[2];
        ArrayList r6 = new ArrayList(r5 + 1);
        int r7 = 0;
    L3:
        if (r7 >= r0) goto L26;
        StackTraceElement r8 = r14[r7];
        String r9 = r8.getClassName();
        String r10 = r8.getMethodName();
        if (RpcUtils.isVisible(r9) == false) goto L24;
        if (RpcUtils.isVisible(r10) == false) goto L24;
        if (r7 == 0) goto L12;
        if (r15 == null) goto L12;
        if (r15.acceptReportStack(r9, r10) == false) goto L24;
    L12:
        r5 = r5 - 1;
        r3 = r3 - 1;
        r6.add(r8);
        if (r2 <= 0) goto L20;
        Iterator<String> r11 = getImpossiblePackages().iterator();
    L16:
        if (r11.hasNext() == false) goto L20;
        if (r9.startsWith(r11.next()) == false) goto L16;
        r2 = r2 - 1;
    L20:
        if (r2 > 0) goto L22;
        if (r5 <= 0) goto L26;
    L22:
        if (r3 <= 0) goto L26;
    L24:
        r7 = r7 + 1;
    L26:
        if (this.mEnsurePackageStackCount == false) goto L80;
        if (r2 > 0) goto L29;
        return r6;
    L29:
        if (r7 >= (r0 - 1)) goto L82;
        ArrayList r4 = new ArrayList(r0 - r7);
        int r12 = r7 + 1;
        int r13 = -1;
    L31:
        if (r12 >= r0) goto L48;
        StackTraceElement r16 = r14[r12];
        String r17 = r16.getClassName();
        String r18 = r16.getMethodName();
        if (RpcUtils.isVisible(r17) == false) goto L47;
        if (RpcUtils.isVisible(r18) == false) goto L47;
        if (r15 != null) goto L38;
    L39:
        r4.add(r16);
        Iterator<String> r19 = getImpossiblePackages().iterator();
    L41:
        if (r19.hasNext() == false) goto L45;
        if (r17.startsWith(r19.next()) == false) goto L41;
        r2 = r2 - 1;
        r13 = r4.size();
        goto L41
    L45:
        if (r2 > 0) goto L47;
    L38:
        if (r15.acceptReportStack(r17, r18) == true) goto L39;
    L47:
        r12 = r12 + 1;
    L48:
        if (r13 == (-1)) goto L83;
        int r110 = r6.size();
        r6.addAll(r4.subList(0, r13));
        if (this.mEnsureMaxStackCount == false) goto L84;
        int r111 = r6.size();
        int r112 = (r6.size() - r110) + 1;
        if (r112 > 0) goto L54;
        return r6;
    L54:
        if (r112 < r6.size()) goto L56;
        return r6;
    L56:
        return r6.subList(r112, r111);
    L84:
        return r6;
    L83:
        return r6;
    L82:
        return r6;
    L80:
        return r6;
    }

    public String getDescription(Throwable r2) {
        Thread r0 = Thread.currentThread();
        if (r0 != null) goto L5;
        String r1 = null;
    L7:
        return formatError(r1, r2);
    L5:
        r1 = r0.getName();
        goto L7
    }

    @Override // com.bytedance.rpc.log.ErrorFormatter
    public String formatError(String r8, Throwable r9) {
        Throwable r0 = getLastCause(r9);
        if (r0 == null) goto L18;
        StackTraceElement[] r1 = r0.getStackTrace();
        List<StackTraceElement> r2 = Collections.emptyList();
        IReportFilter r3 = this.mStackFilter;
        if (r3 != null) goto L7;
        r3 = DEFAULT_FILTER;
    L7:
        if (r1 != null) goto L9;
    L15:
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        String r7 = r3.formatReportStack(r8, r9, r2, this.mShowLineNumber);
    L19:
        if (r7 != null) goto L22;
        return "";
    L22:
        return r7;
    L9:
        if (r1.length <= 0) goto L15;
        r2 = getBestStackTraceElement(r1, r3);
        if (r2.size() != 0) goto L13;
    L14:
        r2.add(0, r1[0]);
        goto L15
    L13:
        if (r2.get(0) == r1[0]) goto L15;
    L18:
        r7 = null;
        goto L19
    }
}
