package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\r\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicAudienceSetting;", "Lvh7/c;", "", "getKey", "()Ljava/lang/Integer;", "getKey$annotations", "()V", "key", "Lcom/bytedance/android/livesdk/chatroom/model/i1;", "getValue", "()Lcom/bytedance/android/livesdk/chatroom/model/i1;", "getValue$annotations", "value", "LinkmicAudienceSettingKey", "LinkmicSettingStatus", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicAudienceSetting extends vh7.c<ILinkmicAudienceSetting> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicAudienceSetting$LinkmicAudienceSettingKey;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "UNKOWN", "ENABLE_DELEGATED_TO_FRIENDS", "ENABLE_DELEGATED_TO_FRIENDS_ACQUAINTANCE", "ENABLE_FASTMATCH_SHAKE", "LIVE_ROOM_FORBIDDEN_SHAKE", "ENABLE_MIC_DRESS_BUTTON", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicAudienceSettingKey extends Enum<LinkmicAudienceSettingKey> {
        public static final LinkmicAudienceSettingKey ENABLE_DELEGATED_TO_FRIENDS = null;
        public static final LinkmicAudienceSettingKey ENABLE_DELEGATED_TO_FRIENDS_ACQUAINTANCE = null;
        public static final LinkmicAudienceSettingKey ENABLE_FASTMATCH_SHAKE = null;
        public static final LinkmicAudienceSettingKey ENABLE_MIC_DRESS_BUTTON = null;
        public static final LinkmicAudienceSettingKey LIVE_ROOM_FORBIDDEN_SHAKE = null;
        public static final LinkmicAudienceSettingKey UNKOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkmicAudienceSettingKey[] f106892a = null;
        private int value;

        static {
            LinkmicAudienceSettingKey r100 = new LinkmicAudienceSettingKey("UNKOWN", 0, 0);
            UNKOWN = r100;
            LinkmicAudienceSettingKey r101 = new LinkmicAudienceSettingKey("ENABLE_DELEGATED_TO_FRIENDS", 1, 1);
            ENABLE_DELEGATED_TO_FRIENDS = r101;
            LinkmicAudienceSettingKey r102 = new LinkmicAudienceSettingKey("ENABLE_DELEGATED_TO_FRIENDS_ACQUAINTANCE", 2, 2);
            ENABLE_DELEGATED_TO_FRIENDS_ACQUAINTANCE = r102;
            LinkmicAudienceSettingKey r103 = new LinkmicAudienceSettingKey("ENABLE_FASTMATCH_SHAKE", 3, 3);
            ENABLE_FASTMATCH_SHAKE = r103;
            LinkmicAudienceSettingKey r104 = new LinkmicAudienceSettingKey("LIVE_ROOM_FORBIDDEN_SHAKE", 4, 4);
            LIVE_ROOM_FORBIDDEN_SHAKE = r104;
            LinkmicAudienceSettingKey r105 = new LinkmicAudienceSettingKey("ENABLE_MIC_DRESS_BUTTON", 5, 7);
            ENABLE_MIC_DRESS_BUTTON = r105;
            f106892a = new LinkmicAudienceSettingKey[]{r100, r101, r102, r103, r104, r105};
        }

        public static LinkmicAudienceSettingKey valueOf(String r100) {
            return (LinkmicAudienceSettingKey) r27.a.a(LinkmicAudienceSettingKey.class, r100);
        }

        public static LinkmicAudienceSettingKey[] values() {
            return (LinkmicAudienceSettingKey[]) f106892a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public LinkmicAudienceSettingKey(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicAudienceSetting$LinkmicSettingStatus;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "SETTING_UNSET", "SETTING_OPEN", "SETTING_OFF", "SETTING_DELEGATED_TO_EVERYONE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicSettingStatus extends Enum<LinkmicSettingStatus> {
        public static final LinkmicSettingStatus SETTING_DELEGATED_TO_EVERYONE = null;
        public static final LinkmicSettingStatus SETTING_OFF = null;
        public static final LinkmicSettingStatus SETTING_OPEN = null;
        public static final LinkmicSettingStatus SETTING_UNSET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkmicSettingStatus[] f106893a = null;
        private int value;

        static {
            LinkmicSettingStatus r100 = new LinkmicSettingStatus("SETTING_UNSET", 0, 0);
            SETTING_UNSET = r100;
            LinkmicSettingStatus r101 = new LinkmicSettingStatus("SETTING_OPEN", 1, 1);
            SETTING_OPEN = r101;
            LinkmicSettingStatus r102 = new LinkmicSettingStatus("SETTING_OFF", 2, 2);
            SETTING_OFF = r102;
            LinkmicSettingStatus r103 = new LinkmicSettingStatus("SETTING_DELEGATED_TO_EVERYONE", 3, 50);
            SETTING_DELEGATED_TO_EVERYONE = r103;
            f106893a = new LinkmicSettingStatus[]{r100, r101, r102, r103};
        }

        public static LinkmicSettingStatus valueOf(String r100) {
            return (LinkmicSettingStatus) r27.a.a(LinkmicSettingStatus.class, r100);
        }

        public static LinkmicSettingStatus[] values() {
            return (LinkmicSettingStatus[]) f106893a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int r100) {
            this.value = r100;
        }

        public LinkmicSettingStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "key")
    Integer getKey();

    @FieldName(name = "value")
    i1 getValue();
}
