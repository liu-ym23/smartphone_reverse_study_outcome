package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/match/utils/HotMsgType;", "", "", "id", "I", "getId", "()I", "UnknownMsg", "ConfrontMsg", "AggregateMsg", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HotMsgType extends Enum<HotMsgType> {
    public static final HotMsgType AggregateMsg = null;
    public static final HotMsgType ConfrontMsg = null;
    public static final HotMsgType UnknownMsg = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HotMsgType[] f140145a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f140146id;

    static {
        HotMsgType r100 = new HotMsgType("UnknownMsg", 0, 0);
        UnknownMsg = r100;
        HotMsgType r101 = new HotMsgType("ConfrontMsg", 1, 1);
        ConfrontMsg = r101;
        HotMsgType r102 = new HotMsgType("AggregateMsg", 2, 2);
        AggregateMsg = r102;
        f140145a = new HotMsgType[]{r100, r101, r102};
    }

    public static HotMsgType valueOf(String r100) {
        return (HotMsgType) r27.a.a(HotMsgType.class, r100);
    }

    public static HotMsgType[] values() {
        return (HotMsgType[]) f140145a.clone();
    }

    public final int getId() {
        return this.f140146id;
    }

    public HotMsgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f140146id = r102;
    }
}
