package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.livesdk.config.ac0;
import com.bytedance.android.livesdk.config.zj0;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f76654a = 0;

    static {
    }

    public static boolean a(int r100) {
        if (r100 != 0) goto L6;
        return ac0.f119778a.getValue().booleanValue();
    L6:
        if (r100 != 5) goto L8;
    L12:
        return false;
    L8:
        if (zj0.f121771a.getValue().booleanValue() == false) goto L12;
        if (ac0.f119778a.getValue().booleanValue() == false) goto L12;
        return true;
    }
}
