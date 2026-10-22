package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/textmessage/utils/ConfrontType;", "", "", "id", "I", "getId", "()I", "UnknownGroup", "MainGroup", "GuestGroup", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConfrontType extends Enum<ConfrontType> {
    public static final ConfrontType GuestGroup = null;
    public static final ConfrontType MainGroup = null;
    public static final ConfrontType UnknownGroup = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConfrontType[] f141219a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f141220id;

    static {
        ConfrontType r100 = new ConfrontType("UnknownGroup", 0, 0);
        UnknownGroup = r100;
        ConfrontType r101 = new ConfrontType("MainGroup", 1, 1);
        MainGroup = r101;
        ConfrontType r102 = new ConfrontType("GuestGroup", 2, 2);
        GuestGroup = r102;
        f141219a = new ConfrontType[]{r100, r101, r102};
    }

    public static ConfrontType valueOf(String r100) {
        return (ConfrontType) r27.a.a(ConfrontType.class, r100);
    }

    public static ConfrontType[] values() {
        return (ConfrontType[]) f141219a.clone();
    }

    public final int getId() {
        return this.f141220id;
    }

    public ConfrontType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f141220id = r102;
    }
}
