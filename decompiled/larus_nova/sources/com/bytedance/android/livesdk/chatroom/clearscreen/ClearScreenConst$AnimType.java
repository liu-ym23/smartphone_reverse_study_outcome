package com.bytedance.android.livesdk.chatroom.clearscreen;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/livesdk/chatroom/clearscreen/ClearScreenConst$AnimType", "", "Lcom/bytedance/android/livesdk/chatroom/clearscreen/ClearScreenConst$AnimType;", "", "id", "I", "getId", "()I", "TRANS", "ALPHA", "None", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClearScreenConst$AnimType extends Enum<ClearScreenConst$AnimType> {
    public static final ClearScreenConst$AnimType ALPHA = null;
    public static final ClearScreenConst$AnimType None = null;
    public static final ClearScreenConst$AnimType TRANS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClearScreenConst$AnimType[] f105590a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f105591id;

    static {
        ClearScreenConst$AnimType r100 = new ClearScreenConst$AnimType("TRANS", 0, 0);
        TRANS = r100;
        ClearScreenConst$AnimType r101 = new ClearScreenConst$AnimType("ALPHA", 1, 1);
        ALPHA = r101;
        ClearScreenConst$AnimType r102 = new ClearScreenConst$AnimType("None", 2, 2);
        None = r102;
        f105590a = new ClearScreenConst$AnimType[]{r100, r101, r102};
    }

    public static ClearScreenConst$AnimType valueOf(String r100) {
        return (ClearScreenConst$AnimType) a.a(ClearScreenConst$AnimType.class, r100);
    }

    public static ClearScreenConst$AnimType[] values() {
        return (ClearScreenConst$AnimType[]) f105590a.clone();
    }

    public final int getId() {
        return this.f105591id;
    }

    public ClearScreenConst$AnimType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f105591id = r102;
    }
}
