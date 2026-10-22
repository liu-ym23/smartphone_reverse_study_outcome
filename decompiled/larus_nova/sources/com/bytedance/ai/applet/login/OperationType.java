package com.bytedance.ai.applet.login;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/applet/login/OperationType;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVACY", "LOGIN", "PHONE_NUM", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OperationType extends Enum<OperationType> {
    public static final OperationType LOGIN = null;
    public static final OperationType PHONE_NUM = null;
    public static final OperationType PRIVACY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperationType[] f34734a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34735b = null;

    public static EnumEntries<OperationType> getEntries() {
        return f34735b;
    }

    static {
        OperationType r100 = new OperationType("PRIVACY", 0);
        PRIVACY = r100;
        OperationType r101 = new OperationType("LOGIN", 1);
        LOGIN = r101;
        OperationType r102 = new OperationType("PHONE_NUM", 2);
        PHONE_NUM = r102;
        OperationType[] r103 = {r100, r101, r102};
        f34734a = r103;
        f34735b = EnumEntriesKt.enumEntries(r103);
    }

    public static OperationType[] values() {
        return (OperationType[]) f34734a.clone();
    }

    public static OperationType valueOf(String r100) {
        return (OperationType) r27.a.a(OperationType.class, r100);
    }

    public OperationType(String r100, int r101) {
        super(r100, r101);
    }
}
