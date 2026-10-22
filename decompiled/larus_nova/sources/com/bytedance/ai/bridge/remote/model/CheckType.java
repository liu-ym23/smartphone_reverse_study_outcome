package com.bytedance.ai.bridge.remote.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/remote/model/CheckType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHECK_TYPE_UNKNOWN", "CHECK_TYPE_PRIVACY", "CHECK_TYPE_LOGIN_STATUS", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CheckType extends Enum<CheckType> {
    public static final CheckType CHECK_TYPE_LOGIN_STATUS = null;
    public static final CheckType CHECK_TYPE_PRIVACY = null;
    public static final CheckType CHECK_TYPE_UNKNOWN = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CheckType[] f36083a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36084b = null;
    private final int value;

    public static EnumEntries<CheckType> getEntries() {
        return f36084b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.bridge.remote.model.CheckType$a] */
    static {
        CheckType r100 = new CheckType("CHECK_TYPE_UNKNOWN", 0, 0);
        CHECK_TYPE_UNKNOWN = r100;
        CheckType r101 = new CheckType("CHECK_TYPE_PRIVACY", 1, 1);
        CHECK_TYPE_PRIVACY = r101;
        CheckType r102 = new CheckType("CHECK_TYPE_LOGIN_STATUS", 2, 2);
        CHECK_TYPE_LOGIN_STATUS = r102;
        CheckType[] r103 = {r100, r101, r102};
        f36083a = r103;
        f36084b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static CheckType[] values() {
        return (CheckType[]) f36083a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CheckType valueOf(String r100) {
        return (CheckType) r27.a.a(CheckType.class, r100);
    }

    public CheckType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
