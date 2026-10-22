package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaGrantingResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GRANTED", "REFUSED", "FAILED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoaGrantingResult extends Enum<MoaGrantingResult> {
    public static final MoaGrantingResult FAILED = null;
    public static final MoaGrantingResult GRANTED = null;
    public static final MoaGrantingResult REFUSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MoaGrantingResult[] f34795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f34796b = null;
    private final String value;

    public static EnumEntries<MoaGrantingResult> getEntries() {
        return f34796b;
    }

    static {
        MoaGrantingResult r100 = new MoaGrantingResult("GRANTED", 0, "granted");
        GRANTED = r100;
        MoaGrantingResult r101 = new MoaGrantingResult("REFUSED", 1, "refused");
        REFUSED = r101;
        MoaGrantingResult r102 = new MoaGrantingResult("FAILED", 2, "failed");
        FAILED = r102;
        MoaGrantingResult[] r103 = {r100, r101, r102};
        f34795a = r103;
        f34796b = EnumEntriesKt.enumEntries(r103);
    }

    public static MoaGrantingResult[] values() {
        return (MoaGrantingResult[]) f34795a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MoaGrantingResult valueOf(String r100) {
        return (MoaGrantingResult) r27.a.a(MoaGrantingResult.class, r100);
    }

    public MoaGrantingResult(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
