package com.bytedance.android.btm.impl.page.lifecycle;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/btm/impl/page/lifecycle/PauseFuncOrigin;", "", "", "isManual", "System", "ManualForward", "ManualBack", "ManualNotSure", "PausePre", "EnterBackground", "HybridJump", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum PauseFuncOrigin extends Enum<PauseFuncOrigin> {
    public static final PauseFuncOrigin EnterBackground = null;
    public static final PauseFuncOrigin HybridJump = null;
    public static final PauseFuncOrigin ManualBack = null;
    public static final PauseFuncOrigin ManualForward = null;
    public static final PauseFuncOrigin ManualNotSure = null;
    public static final PauseFuncOrigin PausePre = null;
    public static final PauseFuncOrigin System = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PauseFuncOrigin[] f42260a = null;

    static {
        PauseFuncOrigin r100 = new PauseFuncOrigin("System", 0);
        System = r100;
        PauseFuncOrigin r101 = new PauseFuncOrigin("ManualForward", 1);
        ManualForward = r101;
        PauseFuncOrigin r102 = new PauseFuncOrigin("ManualBack", 2);
        ManualBack = r102;
        PauseFuncOrigin r103 = new PauseFuncOrigin("ManualNotSure", 3);
        ManualNotSure = r103;
        PauseFuncOrigin r104 = new PauseFuncOrigin("PausePre", 4);
        PausePre = r104;
        PauseFuncOrigin r105 = new PauseFuncOrigin("EnterBackground", 5);
        EnterBackground = r105;
        PauseFuncOrigin r106 = new PauseFuncOrigin("HybridJump", 6);
        HybridJump = r106;
        f42260a = new PauseFuncOrigin[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static PauseFuncOrigin valueOf(String r100) {
        return (PauseFuncOrigin) a.a(PauseFuncOrigin.class, r100);
    }

    public static PauseFuncOrigin[] values() {
        return (PauseFuncOrigin[]) f42260a.clone();
    }

    public final boolean isManual() {
        if (ordinal() != ManualForward.ordinal()) goto L5;
    L10:
        return true;
    L5:
        if (ordinal() == ManualBack.ordinal()) goto L10;
        if (ordinal() == ManualNotSure.ordinal()) goto L10;
        return false;
    }

    public PauseFuncOrigin(String r100, int r101) {
        super(r100, r101);
    }
}
