package com.bytedance.android.live.base.model.moreliveentrance;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/moreliveentrance/DefaultTabPriority;", "", "", "value", "I", "getValue", "()I", "DEFAULT", "RED_POINT", "MORE_LIVE", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DefaultTabPriority extends Enum<DefaultTabPriority> {
    public static final DefaultTabPriority DEFAULT = null;
    public static final DefaultTabPriority MORE_LIVE = null;
    public static final DefaultTabPriority RED_POINT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefaultTabPriority[] f58901a = null;
    private final int value;

    static {
        DefaultTabPriority r100 = new DefaultTabPriority("DEFAULT", 0, 0);
        DEFAULT = r100;
        DefaultTabPriority r101 = new DefaultTabPriority("RED_POINT", 1, 1);
        RED_POINT = r101;
        DefaultTabPriority r102 = new DefaultTabPriority("MORE_LIVE", 2, 2);
        MORE_LIVE = r102;
        f58901a = new DefaultTabPriority[]{r100, r101, r102};
    }

    public static DefaultTabPriority valueOf(String r100) {
        return (DefaultTabPriority) r27.a.a(DefaultTabPriority.class, r100);
    }

    public static DefaultTabPriority[] values() {
        return (DefaultTabPriority[]) f58901a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DefaultTabPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
