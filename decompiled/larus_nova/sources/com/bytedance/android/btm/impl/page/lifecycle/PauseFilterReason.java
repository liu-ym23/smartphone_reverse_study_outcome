package com.bytedance.android.btm.impl.page.lifecycle;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/btm/impl/page/lifecycle/PauseFilterReason;", "", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final enum PauseFilterReason extends Enum<PauseFilterReason> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PauseFilterReason[] f42259a = null;

    static {
        f42259a = new PauseFilterReason[0];
    }

    public static PauseFilterReason valueOf(String r100) {
        return (PauseFilterReason) a.a(PauseFilterReason.class, r100);
    }

    public static PauseFilterReason[] values() {
        return (PauseFilterReason[]) f42259a.clone();
    }
}
