package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/o0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualState;", VoiceWakeupReceiver.EXTRA_STATE, "Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualEvent;", "event", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualState;Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualEvent;)Lcom/stepos/ailauncher/chat/voice/longpress/VoiceLongPressVisualState;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o0 {
    public static final o0 INSTANCE = new o0();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VoiceLongPressVisualEvent.values().length];
            try {
                iArr[VoiceLongPressVisualEvent.RECORDING_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VoiceLongPressVisualEvent.ENTER_FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VoiceLongPressVisualEvent.RELEASE_GRACE_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VoiceLongPressVisualEvent.RELEASE_GRACE_RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VoiceLongPressVisualEvent.FINALIZE_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VoiceLongPressVisualEvent.FINALIZE_FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[VoiceLongPressVisualEvent.CANCELLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[VoiceLongPressVisualEvent.EXIT_FINISHED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final VoiceLongPressVisualState a(VoiceLongPressVisualState state, VoiceLongPressVisualEvent event) {
        kotlin.jvm.internal.p.i(state, "state");
        kotlin.jvm.internal.p.i(event, "event");
        switch (a.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
                if (state == VoiceLongPressVisualState.IDLE) {
                    return VoiceLongPressVisualState.ENTERING;
                }
                return state;
            case 2:
                if (state == VoiceLongPressVisualState.ENTERING) {
                    return VoiceLongPressVisualState.LISTENING;
                }
                return state;
            case 3:
                if (state == VoiceLongPressVisualState.LISTENING || state == VoiceLongPressVisualState.ENTERING) {
                    return VoiceLongPressVisualState.RELEASE_GRACE;
                }
                return state;
            case 4:
                if (state == VoiceLongPressVisualState.RELEASE_GRACE) {
                    return VoiceLongPressVisualState.LISTENING;
                }
                return state;
            case 5:
                if (state == VoiceLongPressVisualState.ENTERING || state == VoiceLongPressVisualState.LISTENING || state == VoiceLongPressVisualState.RELEASE_GRACE) {
                    return VoiceLongPressVisualState.FINALIZING;
                }
                return state;
            case 6:
            case 7:
                if (state != VoiceLongPressVisualState.IDLE) {
                    return VoiceLongPressVisualState.EXITING;
                }
                return state;
            case 8:
                if (state == VoiceLongPressVisualState.EXITING) {
                    return VoiceLongPressVisualState.IDLE;
                }
                return state;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
