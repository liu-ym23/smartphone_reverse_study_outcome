package com.bytedance.ai.applet.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/permission/StorageScope;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVATE", "APPLET", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StorageScope extends Enum<StorageScope> {
    public static final StorageScope APPLET = null;
    public static final StorageScope PRIVATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StorageScope[] f34932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34933b = null;

    public static EnumEntries<StorageScope> getEntries() {
        return f34933b;
    }

    static {
        StorageScope r100 = new StorageScope("PRIVATE", 0);
        PRIVATE = r100;
        StorageScope r101 = new StorageScope("APPLET", 1);
        APPLET = r101;
        StorageScope[] r102 = {r100, r101};
        f34932a = r102;
        f34933b = EnumEntriesKt.enumEntries(r102);
    }

    public static StorageScope[] values() {
        return (StorageScope[]) f34932a.clone();
    }

    public static StorageScope valueOf(String r100) {
        return (StorageScope) r27.a.a(StorageScope.class, r100);
    }

    public StorageScope(String r100, int r101) {
        super(r100, r101);
    }
}
