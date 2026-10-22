package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/IAudioSubtitleContent;", "Lvh7/c;", "", "getStatus", "()I", "setStatus", "(I)V", "status", "Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "getSubtitleStatus", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "setSubtitleStatus", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;)V", "subtitleStatus", "SwitchStatus", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAudioSubtitleContent extends vh7.c<IAudioSubtitleContent> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/IAudioSubtitleContent$SwitchStatus;", "", "", "value", "I", "getValue", "()I", "SWITCH_UNKNOWN", "SWITCH_ON", "SWITCH_OFF", "SWITCH_DISABLE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum SwitchStatus extends Enum<SwitchStatus> {
        public static final SwitchStatus SWITCH_DISABLE = null;
        public static final SwitchStatus SWITCH_OFF = null;
        public static final SwitchStatus SWITCH_ON = null;
        public static final SwitchStatus SWITCH_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SwitchStatus[] f106927a = null;
        private final int value;

        static {
            SwitchStatus r100 = new SwitchStatus("SWITCH_UNKNOWN", 0, 0);
            SWITCH_UNKNOWN = r100;
            SwitchStatus r101 = new SwitchStatus("SWITCH_ON", 1, 1);
            SWITCH_ON = r101;
            SwitchStatus r102 = new SwitchStatus("SWITCH_OFF", 2, 2);
            SWITCH_OFF = r102;
            SwitchStatus r103 = new SwitchStatus("SWITCH_DISABLE", 3, 3);
            SWITCH_DISABLE = r103;
            f106927a = new SwitchStatus[]{r100, r101, r102, r103};
        }

        public static SwitchStatus valueOf(String r100) {
            return (SwitchStatus) r27.a.a(SwitchStatus.class, r100);
        }

        public static SwitchStatus[] values() {
            return (SwitchStatus[]) f106927a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public SwitchStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    int getStatus();

    q2 getSubtitleStatus();

    void setStatus(int r100);

    void setSubtitleStatus(q2 r100);
}
