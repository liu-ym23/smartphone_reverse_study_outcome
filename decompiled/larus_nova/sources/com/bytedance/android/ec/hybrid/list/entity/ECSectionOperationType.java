package com.bytedance.android.ec.hybrid.list.entity;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/ECSectionOperationType;", "", "Ljava/io/Serializable;", "", "type", "I", "getType", "()I", UserProfileEvent.POSITION_NONE, "INSERT_SECTION", "DELETE_SECTION", "APPEND_ITEM", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECSectionOperationType extends Enum<ECSectionOperationType> implements Serializable {

    @SerializedName("3")
    public static final ECSectionOperationType APPEND_ITEM = null;

    @SerializedName("2")
    public static final ECSectionOperationType DELETE_SECTION = null;

    @SerializedName("1")
    public static final ECSectionOperationType INSERT_SECTION = null;

    @SerializedName("0")
    public static final ECSectionOperationType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECSectionOperationType[] f47063a = null;
    private final int type;

    static {
        ECSectionOperationType r100 = new ECSectionOperationType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ECSectionOperationType r101 = new ECSectionOperationType("INSERT_SECTION", 1, 1);
        INSERT_SECTION = r101;
        ECSectionOperationType r102 = new ECSectionOperationType("DELETE_SECTION", 2, 2);
        DELETE_SECTION = r102;
        ECSectionOperationType r103 = new ECSectionOperationType("APPEND_ITEM", 3, 3);
        APPEND_ITEM = r103;
        f47063a = new ECSectionOperationType[]{r100, r101, r102, r103};
    }

    public static ECSectionOperationType valueOf(String r100) {
        return (ECSectionOperationType) r27.a.a(ECSectionOperationType.class, r100);
    }

    public static ECSectionOperationType[] values() {
        return (ECSectionOperationType[]) f47063a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ECSectionOperationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
