package com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/livesdk/ktvapi/concert_stage/interfaces/IConcertUpdateStatusCallback$Code", "", "Lcom/bytedance/android/livesdk/ktvapi/concert_stage/interfaces/IConcertUpdateStatusCallback$Code;", "", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IConcertUpdateStatusCallback$Code extends Enum<IConcertUpdateStatusCallback$Code> {
    public static final IConcertUpdateStatusCallback$Code Failed = null;
    public static final IConcertUpdateStatusCallback$Code NOT_REGISTER = null;
    public static final IConcertUpdateStatusCallback$Code NO_PERMISSION = null;
    public static final IConcertUpdateStatusCallback$Code Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IConcertUpdateStatusCallback$Code[] f142296a = null;
    private final int value;

    static {
        IConcertUpdateStatusCallback$Code r100 = new IConcertUpdateStatusCallback$Code("Success", 0, 1);
        Success = r100;
        IConcertUpdateStatusCallback$Code r101 = new IConcertUpdateStatusCallback$Code("Failed", 1, 0);
        Failed = r101;
        IConcertUpdateStatusCallback$Code r102 = new IConcertUpdateStatusCallback$Code("NO_PERMISSION", 2, -1);
        NO_PERMISSION = r102;
        IConcertUpdateStatusCallback$Code r103 = new IConcertUpdateStatusCallback$Code("NOT_REGISTER", 3, -2);
        NOT_REGISTER = r103;
        f142296a = new IConcertUpdateStatusCallback$Code[]{r100, r101, r102, r103};
    }

    public static IConcertUpdateStatusCallback$Code valueOf(String r100) {
        return (IConcertUpdateStatusCallback$Code) a.a(IConcertUpdateStatusCallback$Code.class, r100);
    }

    public static IConcertUpdateStatusCallback$Code[] values() {
        return (IConcertUpdateStatusCallback$Code[]) f142296a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public IConcertUpdateStatusCallback$Code(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
