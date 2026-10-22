package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/api/ToastIconType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "SUCCESS", "FAILURE", "WARNING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToastIconType extends Enum<ToastIconType> {
    public static final ToastIconType DEFAULT = null;
    public static final ToastIconType FAILURE = null;
    public static final ToastIconType SUCCESS = null;
    public static final ToastIconType WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToastIconType[] f33983a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f33984b = null;

    public static EnumEntries<ToastIconType> getEntries() {
        return f33984b;
    }

    static {
        ToastIconType r100 = new ToastIconType("DEFAULT", 0);
        DEFAULT = r100;
        ToastIconType r101 = new ToastIconType("SUCCESS", 1);
        SUCCESS = r101;
        ToastIconType r102 = new ToastIconType("FAILURE", 2);
        FAILURE = r102;
        ToastIconType r103 = new ToastIconType("WARNING", 3);
        WARNING = r103;
        ToastIconType[] r104 = {r100, r101, r102, r103};
        f33983a = r104;
        f33984b = EnumEntriesKt.enumEntries(r104);
    }

    public static ToastIconType[] values() {
        return (ToastIconType[]) f33983a.clone();
    }

    public static ToastIconType valueOf(String r100) {
        return (ToastIconType) r27.a.a(ToastIconType.class, r100);
    }

    public ToastIconType(String r100, int r101) {
        super(r100, r101);
    }
}
