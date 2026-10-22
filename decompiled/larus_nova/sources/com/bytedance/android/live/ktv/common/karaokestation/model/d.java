package com.bytedance.android.live.ktv.common.karaokestation.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, y> f69501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f69502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f69503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f69504d;

    public d() {
        this(0, 15);
    }

    public d(int r100, int r101) {
        String r102 = null;
        if ((r101 & 1) == 0) goto L5;
        LinkedHashMap r103 = new LinkedHashMap();
    L7:
        if ((r101 & 2) == 0) goto L9;
        int r104 = FirstLevelTab.Unknown.getValue();
    L11:
        if ((r101 & 4) == 0) goto L14;
        r102 = "";
    L14:
        if ((r101 & 8) == 0) goto L16;
        r100 = FirstLevelTab.Unknown.getValue();
    L16:
        Intrinsics.checkNotNullParameter(r103, "secondLevelTabDataMap");
        Intrinsics.checkNotNullParameter(r102, "defaultSecondLevelTab");
        this.f69501a = r103;
        this.f69502b = r104;
        this.f69503c = r102;
        this.f69504d = r100;
        return;
    L9:
        r104 = 0;
        goto L11
    L5:
        r103 = null;
        goto L7
    }
}
