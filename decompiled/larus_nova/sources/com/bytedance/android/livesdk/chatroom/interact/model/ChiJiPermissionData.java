package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/ChiJiPermissionData;", "", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "setStartTime", "(J)V", "duration", "getDuration", "setDuration", "Lcom/bytedance/android/livesdk/chatroom/interact/model/ChiJiPermissionData$PermissionFeatureType;", "type", "Lcom/bytedance/android/livesdk/chatroom/interact/model/ChiJiPermissionData$PermissionFeatureType;", "getType", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/ChiJiPermissionData$PermissionFeatureType;", "setType", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/ChiJiPermissionData$PermissionFeatureType;)V", "<init>", "()V", "PermissionFeatureType", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChiJiPermissionData {

    @SerializedName("duration")
    private long duration;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    @SerializedName("type")
    private PermissionFeatureType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/ChiJiPermissionData$PermissionFeatureType;", "", "UNDEFINED", "CHIJI", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PermissionFeatureType extends Enum<PermissionFeatureType> {

        @SerializedName("1")
        public static final PermissionFeatureType CHIJI = null;

        @SerializedName("0")
        public static final PermissionFeatureType UNDEFINED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PermissionFeatureType[] f106754a = null;

        static {
            PermissionFeatureType r100 = new PermissionFeatureType("UNDEFINED", 0);
            UNDEFINED = r100;
            PermissionFeatureType r101 = new PermissionFeatureType("CHIJI", 1);
            CHIJI = r101;
            f106754a = new PermissionFeatureType[]{r100, r101};
        }

        public static PermissionFeatureType valueOf(String r100) {
            return (PermissionFeatureType) r27.a.a(PermissionFeatureType.class, r100);
        }

        public static PermissionFeatureType[] values() {
            return (PermissionFeatureType[]) f106754a.clone();
        }

        public PermissionFeatureType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ChiJiPermissionData() {
    }

    public final PermissionFeatureType getType() {
        return this.type;
    }
}
