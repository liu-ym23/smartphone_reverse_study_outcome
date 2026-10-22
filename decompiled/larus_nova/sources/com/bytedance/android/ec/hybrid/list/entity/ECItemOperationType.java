package com.bytedance.android.ec.hybrid.list.entity;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/ECItemOperationType;", "", "Ljava/io/Serializable;", "", "type", "I", "getType", "()I", UserProfileEvent.POSITION_NONE, "INSERT", "DELETE", "UPDATE", "PATH_UPDATE", "INSERT_AFTER_POSITION", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECItemOperationType extends Enum<ECItemOperationType> implements Serializable {

    @SerializedName("2")
    public static final ECItemOperationType DELETE = null;

    @SerializedName("1")
    public static final ECItemOperationType INSERT = null;

    @SerializedName("5")
    public static final ECItemOperationType INSERT_AFTER_POSITION = null;

    @SerializedName("0")
    public static final ECItemOperationType NONE = null;

    @SerializedName("4")
    public static final ECItemOperationType PATH_UPDATE = null;

    @SerializedName("3")
    public static final ECItemOperationType UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECItemOperationType[] f47062a = null;
    private final int type;

    static {
        ECItemOperationType r100 = new ECItemOperationType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ECItemOperationType r101 = new ECItemOperationType("INSERT", 1, 1);
        INSERT = r101;
        ECItemOperationType r102 = new ECItemOperationType("DELETE", 2, 2);
        DELETE = r102;
        ECItemOperationType r103 = new ECItemOperationType("UPDATE", 3, 3);
        UPDATE = r103;
        ECItemOperationType r104 = new ECItemOperationType("PATH_UPDATE", 4, 4);
        PATH_UPDATE = r104;
        ECItemOperationType r105 = new ECItemOperationType("INSERT_AFTER_POSITION", 5, 5);
        INSERT_AFTER_POSITION = r105;
        f47062a = new ECItemOperationType[]{r100, r101, r102, r103, r104, r105};
    }

    public static ECItemOperationType valueOf(String r100) {
        return (ECItemOperationType) r27.a.a(ECItemOperationType.class, r100);
    }

    public static ECItemOperationType[] values() {
        return (ECItemOperationType[]) f47062a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ECItemOperationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
