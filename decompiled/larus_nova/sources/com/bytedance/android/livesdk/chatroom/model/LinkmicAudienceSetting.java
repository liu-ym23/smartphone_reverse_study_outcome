package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSetting;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/ILinkmicAudienceSetting;", "()V", "key", "", "getKey", "()Ljava/lang/Integer;", "setKey", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "value", "Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSetting$LinkmicAudienceSettingValue;", "getValue", "()Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSetting$LinkmicAudienceSettingValue;", "setValue", "(Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSetting$LinkmicAudienceSettingValue;)V", "LinkmicAudienceSettingKey", "LinkmicAudienceSettingValue", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicAudienceSetting extends FlexModelBase<ILinkmicAudienceSetting> implements ILinkmicAudienceSetting, vh7.h {

    @SerializedName("key")
    protected Integer key;

    @SerializedName("value")
    protected LinkmicAudienceSettingValue value;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSetting$LinkmicAudienceSettingKey;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "UNKOWN", "ENABLE_DELEGATED_TO_FRIENDS", "ENABLE_DELEGATED_TO_FRIENDS_ACQUAINTANCE", "ENABLE_FASTMATCH_SHAKE", "LIVE_ROOM_FORBIDDEN_SHAKE", "ENABLE_MIC_DRESS_BUTTON", "ENABLE_KTV_MIDI", "ENABLE_CROSS_LINK_BACK_TO_VIDEO", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum LinkmicAudienceSettingKey extends Enum<LinkmicAudienceSettingKey> {
        public static final LinkmicAudienceSettingKey ENABLE_CROSS_LINK_BACK_TO_VIDEO = null;
        public static final LinkmicAudienceSettingKey ENABLE_DELEGATED_TO_FRIENDS = null;
        public static final LinkmicAudienceSettingKey ENABLE_DELEGATED_TO_FRIENDS_ACQUAINTANCE = null;
        public static final LinkmicAudienceSettingKey ENABLE_FASTMATCH_SHAKE = null;
        public static final LinkmicAudienceSettingKey ENABLE_KTV_MIDI = null;
        public static final LinkmicAudienceSettingKey ENABLE_MIC_DRESS_BUTTON = null;
        public static final LinkmicAudienceSettingKey LIVE_ROOM_FORBIDDEN_SHAKE = null;
        public static final LinkmicAudienceSettingKey UNKOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkmicAudienceSettingKey[] f106898a = null;
        private int value;

        public static LinkmicAudienceSettingKey valueOf(String r100) {
            return (LinkmicAudienceSettingKey) r27.a.a(LinkmicAudienceSettingKey.class, r100);
        }

        public static LinkmicAudienceSettingKey[] values() {
            return (LinkmicAudienceSettingKey[]) f106898a.clone();
        }

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
            LinkmicAudienceSettingKey r106 = new LinkmicAudienceSettingKey("ENABLE_KTV_MIDI", 6, 8);
            ENABLE_KTV_MIDI = r106;
            LinkmicAudienceSettingKey r107 = new LinkmicAudienceSettingKey("ENABLE_CROSS_LINK_BACK_TO_VIDEO", 7, 9);
            ENABLE_CROSS_LINK_BACK_TO_VIDEO = r107;
            f106898a = new LinkmicAudienceSettingKey[]{r100, r101, r102, r103, r104, r105, r106, r107};
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

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkmicAudienceSetting$LinkmicAudienceSettingValue;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/i1;", "", "linkmicAudienceSettingValue", "Ljava/lang/Integer;", "getLinkmicAudienceSettingValue", "()Ljava/lang/Integer;", "setLinkmicAudienceSettingValue", "(Ljava/lang/Integer;)V", "", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class LinkmicAudienceSettingValue extends FlexModelBase<i1> implements i1, vh7.h {

        @SerializedName("extra")
        protected String extra;

        @SerializedName("status")
        protected Integer linkmicAudienceSettingValue;

        public LinkmicAudienceSettingValue() {
            super(i1.class);
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.i1
        public String getExtra() {
            return this.extra;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.i1
        public Integer getLinkmicAudienceSettingValue() {
            return this.linkmicAudienceSettingValue;
        }

        public LinkmicAudienceSettingValue(am3.g r100) {
            super(i1.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.linkmicAudienceSettingValue = Integer.valueOf(r100.i());
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.extra = am3.h.c(r100);
            goto L3
        L9:
            am3.h.d(r103, r100);
            goto L3
        L12:
            r100.d(r101);
            setThreadSafe(true);
        }

        public void setExtra(String r100) {
            this.extra = r100;
        }

        public void setLinkmicAudienceSettingValue(Integer r100) {
            this.linkmicAudienceSettingValue = r100;
        }
    }

    public LinkmicAudienceSetting() {
        super(ILinkmicAudienceSetting.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting
    public /* bridge */ /* synthetic */ i1 getValue() {
        return getValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting
    public Integer getKey() {
        return this.key;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting
    public LinkmicAudienceSettingValue getValue() {
        return this.value;
    }

    public LinkmicAudienceSetting(am3.g r100) {
        super(ILinkmicAudienceSetting.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.key = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.value = new LinkmicAudienceSettingValue(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setKey(Integer r100) {
        this.key = r100;
    }

    public void setValue(LinkmicAudienceSettingValue r100) {
        this.value = r100;
    }
}
