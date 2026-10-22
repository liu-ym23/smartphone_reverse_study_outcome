package com.bytedance.ai.datamanager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/datamanager/StorageScope;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVATE", "APPLET", "APPGROUP", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StorageScope extends Enum<StorageScope> {
    public static final StorageScope APPGROUP = null;
    public static final StorageScope APPLET = null;
    public static final StorageScope PRIVATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StorageScope[] f36179a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36180b = null;

    public static EnumEntries<StorageScope> getEntries() {
        return f36180b;
    }

    static {
        StorageScope r100 = new StorageScope("PRIVATE", 0);
        PRIVATE = r100;
        StorageScope r101 = new StorageScope("APPLET", 1);
        APPLET = r101;
        StorageScope r102 = new StorageScope("APPGROUP", 2);
        APPGROUP = r102;
        StorageScope[] r103 = {r100, r101, r102};
        f36179a = r103;
        f36180b = EnumEntriesKt.enumEntries(r103);
    }

    public static StorageScope[] values() {
        return (StorageScope[]) f36179a.clone();
    }

    public static StorageScope valueOf(String r100) {
        return (StorageScope) a.a(StorageScope.class, r100);
    }

    public StorageScope(String r100, int r101) {
        super(r100, r101);
    }
}
