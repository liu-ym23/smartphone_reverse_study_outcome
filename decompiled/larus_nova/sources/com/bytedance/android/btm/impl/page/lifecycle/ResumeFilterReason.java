package com.bytedance.android.btm.impl.page.lifecycle;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/btm/impl/page/lifecycle/ResumeFilterReason;", "", "PageStateDuplicate", "NativeStateError", "AppBackground", "NotTopActivity", "InfoStackNull", "ExecuteActivityResume", "IgnoreAShow", "FragmentNotAttach", "Invisible", "DialogNotShowing", "Other", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum ResumeFilterReason extends Enum<ResumeFilterReason> {
    public static final ResumeFilterReason AppBackground = null;
    public static final ResumeFilterReason DialogNotShowing = null;
    public static final ResumeFilterReason ExecuteActivityResume = null;
    public static final ResumeFilterReason FragmentNotAttach = null;
    public static final ResumeFilterReason IgnoreAShow = null;
    public static final ResumeFilterReason InfoStackNull = null;
    public static final ResumeFilterReason Invisible = null;
    public static final ResumeFilterReason NativeStateError = null;
    public static final ResumeFilterReason NotTopActivity = null;
    public static final ResumeFilterReason Other = null;
    public static final ResumeFilterReason PageStateDuplicate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResumeFilterReason[] f42261a = null;

    static {
        ResumeFilterReason r100 = new ResumeFilterReason("PageStateDuplicate", 0);
        PageStateDuplicate = r100;
        ResumeFilterReason r101 = new ResumeFilterReason("NativeStateError", 1);
        NativeStateError = r101;
        ResumeFilterReason r102 = new ResumeFilterReason("AppBackground", 2);
        AppBackground = r102;
        ResumeFilterReason r103 = new ResumeFilterReason("NotTopActivity", 3);
        NotTopActivity = r103;
        ResumeFilterReason r104 = new ResumeFilterReason("InfoStackNull", 4);
        InfoStackNull = r104;
        ResumeFilterReason r105 = new ResumeFilterReason("ExecuteActivityResume", 5);
        ExecuteActivityResume = r105;
        ResumeFilterReason r106 = new ResumeFilterReason("IgnoreAShow", 6);
        IgnoreAShow = r106;
        ResumeFilterReason r107 = new ResumeFilterReason("FragmentNotAttach", 7);
        FragmentNotAttach = r107;
        ResumeFilterReason r108 = new ResumeFilterReason("Invisible", 8);
        Invisible = r108;
        ResumeFilterReason r109 = new ResumeFilterReason("DialogNotShowing", 9);
        DialogNotShowing = r109;
        ResumeFilterReason r110 = new ResumeFilterReason("Other", 10);
        Other = r110;
        f42261a = new ResumeFilterReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public static ResumeFilterReason valueOf(String r100) {
        return (ResumeFilterReason) a.a(ResumeFilterReason.class, r100);
    }

    public static ResumeFilterReason[] values() {
        return (ResumeFilterReason[]) f42261a.clone();
    }

    public ResumeFilterReason(String r100, int r101) {
        super(r100, r101);
    }
}
