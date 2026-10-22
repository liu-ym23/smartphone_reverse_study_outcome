package com.bytedance.android.btm.impl.page.lifecycle;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/btm/impl/page/lifecycle/ResumeFuncOrigin;", "", "", "isManual", "System", "ManualForward", "ManualBack", "ManualNotSure", "UserVisibleHint", "HybridRegister", "BackInternal", "Background", "BackActivity", "BackProcess", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ResumeFuncOrigin extends Enum<ResumeFuncOrigin> {

    @Deprecated(message = "")
    public static final ResumeFuncOrigin BackActivity = null;
    public static final ResumeFuncOrigin BackInternal = null;

    @Deprecated(message = "")
    public static final ResumeFuncOrigin BackProcess = null;

    @Deprecated(message = "")
    public static final ResumeFuncOrigin Background = null;
    public static final ResumeFuncOrigin HybridRegister = null;
    public static final ResumeFuncOrigin ManualBack = null;
    public static final ResumeFuncOrigin ManualForward = null;
    public static final ResumeFuncOrigin ManualNotSure = null;
    public static final ResumeFuncOrigin System = null;
    public static final ResumeFuncOrigin UserVisibleHint = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResumeFuncOrigin[] f42262a = null;

    static {
        ResumeFuncOrigin r100 = new ResumeFuncOrigin("System", 0);
        System = r100;
        ResumeFuncOrigin r101 = new ResumeFuncOrigin("ManualForward", 1);
        ManualForward = r101;
        ResumeFuncOrigin r102 = new ResumeFuncOrigin("ManualBack", 2);
        ManualBack = r102;
        ResumeFuncOrigin r103 = new ResumeFuncOrigin("ManualNotSure", 3);
        ManualNotSure = r103;
        ResumeFuncOrigin r104 = new ResumeFuncOrigin("UserVisibleHint", 4);
        UserVisibleHint = r104;
        ResumeFuncOrigin r105 = new ResumeFuncOrigin("HybridRegister", 5);
        HybridRegister = r105;
        ResumeFuncOrigin r106 = new ResumeFuncOrigin("BackInternal", 6);
        BackInternal = r106;
        ResumeFuncOrigin r107 = new ResumeFuncOrigin("Background", 7);
        Background = r107;
        ResumeFuncOrigin r108 = new ResumeFuncOrigin("BackActivity", 8);
        BackActivity = r108;
        ResumeFuncOrigin r109 = new ResumeFuncOrigin("BackProcess", 9);
        BackProcess = r109;
        f42262a = new ResumeFuncOrigin[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static ResumeFuncOrigin valueOf(String r100) {
        return (ResumeFuncOrigin) a.a(ResumeFuncOrigin.class, r100);
    }

    public static ResumeFuncOrigin[] values() {
        return (ResumeFuncOrigin[]) f42262a.clone();
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

    public ResumeFuncOrigin(String r100, int r101) {
        super(r100, r101);
    }
}
