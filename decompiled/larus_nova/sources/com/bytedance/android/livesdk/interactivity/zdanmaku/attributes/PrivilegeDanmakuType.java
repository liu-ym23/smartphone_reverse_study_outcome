package com.bytedance.android.livesdk.interactivity.zdanmaku.attributes;

import kotlin.Metadata;
import nf6.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/attributes/PrivilegeDanmakuType;", "", "Lnf6/a;", "MultiLine", "SingleLine", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PrivilegeDanmakuType extends Enum<PrivilegeDanmakuType> implements a {
    public static final PrivilegeDanmakuType MultiLine = null;
    public static final PrivilegeDanmakuType SingleLine = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrivilegeDanmakuType[] f141446a = null;

    static {
        PrivilegeDanmakuType r100 = new PrivilegeDanmakuType("MultiLine", 0);
        MultiLine = r100;
        PrivilegeDanmakuType r101 = new PrivilegeDanmakuType("SingleLine", 1);
        SingleLine = r101;
        f141446a = new PrivilegeDanmakuType[]{r100, r101};
    }

    public static PrivilegeDanmakuType valueOf(String r100) {
        return (PrivilegeDanmakuType) r27.a.a(PrivilegeDanmakuType.class, r100);
    }

    public static PrivilegeDanmakuType[] values() {
        return (PrivilegeDanmakuType[]) f141446a.clone();
    }

    public PrivilegeDanmakuType(String r100, int r101) {
        super(r100, r101);
    }
}
