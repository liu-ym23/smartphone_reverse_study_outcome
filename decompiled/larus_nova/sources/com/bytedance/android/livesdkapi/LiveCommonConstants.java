package com.bytedance.android.livesdkapi;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0003\b\u008f\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u009e\u0001\u001a\u00020\u00042\u0007\u0010\u009f\u0001\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008a\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0099\u0001\u001a\u00020\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009c\u0001\u001a\u00020\u0004X\u0086D¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009b\u0001¨\u0006 \u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/LiveCommonConstants;", "", "()V", "EXTRA_ENTER_LIVE_EXTRA", "", "EXTRA_LIVE_AD_TYPE", "IInteractionFragment_TAG", "LINK_CONSTANT_SEI_VERSION_PK", "", "LOG_EVENT_KEY_LIVECORE_API", "LOG_PARAM_EVENT_KEY", "LOG_PARAM_MSG", "LOG_PARAM_MULTI_LINK_SCENE", "LOG_PARAM_MULTI_LINK_UI_LAYOUT", "LOG_PARAM_REASON", "LOG_PARAM_STACK_TRACE", "PK_STREAM_HEIGHT_OLD_RATIO", "", "REASON_ADVANCE_LINK_MUTE", "REASON_ADVANCE_LINK_RESUME_RTC", "REASON_ADVANCE_LINK_RESUME_SERVER", "REASON_ADVENTURE_BACKGROUND_PAUSE", "REASON_ADVENTURE_BACKGROUND_RESUME", "REASON_ADVENTURE_JOIN_RTC", "REASON_ADVENTURE_JOIN_RTC_BACKGROUND", "REASON_ADVENTURE_LEAVE_ROOM", "REASON_AUDIENCE_BACKGROUND_BEFORE_START_ENGINE", "REASON_AUDIO_SCENE_BACKGROUND_PAUSE", "REASON_AUDIO_SCENE_BACKGROUND_RESUME", "REASON_AUDIO_SILENCE_OPT", "REASON_AVATAR_INIT", "REASON_AVATAR_PAUSE", "REASON_AVATAR_RELEASE", "REASON_AVATAR_RESUME", "REASON_BACK_FROM_PK", "REASON_BROADCAST_SENSITIVE_PERMISSION_EVENT", "REASON_COMMENT_HIGHLIGHT_RECORD_PREVIEW", "REASON_COMMENT_HIGHLIGHT_RECORD_PUBLISH", "REASON_ENTER_BACKGROUND", "REASON_ENTER_FOREGROUND", "REASON_FLOAT_WINDOW_BACKGROUND", "REASON_FLOAT_WINDOW_CHECK_AUDIENCE_LINKERS", "REASON_FLOAT_WINDOW_FOREGROUND", "REASON_FORCE_OPEN_ANCHOR_MIC", "REASON_FORCE_UN_SILENCE", "REASON_FRIEND_ROOM_CREATE", "REASON_GAME_LIVE_START_AUDIO", "REASON_GAME_LIVE_STOP_AUDIO", "REASON_GAM_LIVE_STATE_CHANGE", "REASON_HIGHLIGHT_PREVIEW", "REASON_INTERACT_AUDIENCE_CREATE", "REASON_INTERACT_AUDIENCE_START_RTC", "REASON_KICTOUT", "REASON_KTV_SINGER_STATE_CHANGED", "REASON_LINK_SECURITY", "REASON_LIVE_ADMIN_RECORD", "REASON_LIVE_END", "REASON_LIVE_PAUSE", "REASON_LIVE_PAUSE_FLOAT_WINDOW", "REASON_LIVE_PAUSE_FLOAT_WINDOW_RETURN", "REASON_LIVE_PAUSE_IN_PREVIEW", "REASON_LIVE_PREVIEW", "REASON_LIVE_PREVIEW_SAAS", "REASON_LIVE_RECORD", "REASON_LIVE_RESUME", "REASON_LIVE_RESUME_IN_PREVIEW", "REASON_LIVE_SENSITIVE_EVENT_END", "REASON_LIVE_SENSITIVE_EVENT_START", "REASON_LIVE_SHARE", "REASON_LIVE_STREAM_SENSITIVE_PERMISSION_EVENT", "REASON_MATCH_APPLY", "REASON_MEDIA_MANAGER_RELEASE", "REASON_MINI_APP_EVENT", "REASON_MINI_GAME_ENTER_BACKGROUND", "REASON_MINI_GAME_ENTER_FOREGROUND", "REASON_MINI_GAME_MOCK_START", "REASON_NORMAL", "REASON_NORMAL_START", "REASON_NOTIFICATION_CLOSE", "REASON_NOT_USE_BACKUP_STREAM", "REASON_ON_DEDTROY", "REASON_ON_PAUSE", "REASON_ON_RESUME", "REASON_OPEN_BEAUTY_DIALOG", "REASON_PARTICULAR_PAGE_CLOSE", "REASON_PARTICULAR_PAGE_SHOW", "REASON_PARTICULAR_WHITE_PAGE_CLOSE", "REASON_PARTICULAR_WHITE_PAGE_SHOW", "REASON_PERF_ON_FREEZE", "REASON_PHONE_STATE_CHANGE", "REASON_PK_AUDIENCE_OPEN_BEAUTY_DIALOG", "REASON_PK_SWITCH_NORMAL", "REASON_PREVIEW_BEFORE_START_LIVE", "REASON_PUSH_STREAM_DEMO", "REASON_PUSH_STREAM_PAUSE", "REASON_PUSH_STREAM_RESUME", "REASON_RADIO_BACKGROUND_PAUSE", "REASON_RADIO_BACKGROUND_RESUME", "REASON_RESET_LAST_SILENCE", "REASON_REVENUE_SILENCE", "REASON_ROOM_BATTLE_CROSS_SILENCE", "REASON_ROOM_BATTLE_CROSS_SILENCE_FLOAT_WINDOW", "REASON_ROOM_BATTLE_MCU", "REASON_ROOM_COVERED", "REASON_ROOM_UNCOVERED", "REASON_RTC_MANAGER_PAUSE", "REASON_RTC_MANAGER_RESUME", "REASON_RTS_AUDIO_MUTE", "REASON_RTS_KICK_OUT", "REASON_RTS_OTHER_USER_SILENCE_SELF", "REASON_RTS_USER_JOIN", "REASON_RTS_USER_LIST_CHANGED_VOICE", "REASON_RTS_VIDEO_MUTE", "REASON_SCREEN_LIVE_START_AUDIO", "REASON_SCREEN_LIVE_STOP_AUDIO", "REASON_SCREEN_LOCK", "REASON_SCREEN_ON", "REASON_SCREEN_RECORD_PREVIEW", "REASON_SELF_PANEL", "REASON_SILENCE", "REASON_SILENCE_MESSAGE", "REASON_SILENCE_SUCCESS", "REASON_SINGER_CUT_MUSIC", "REASON_SINGER_STATE_CHANGED", "REASON_START_LIVE_STREAM", "REASON_START_MULTI_LINK", "REASON_START_ON_BACKGROUND", "REASON_START_PREVIEW", "REASON_START_PUSH_STREAM", "REASON_SUBBROADCAST_AUDIO_STOP", "REASON_SWITCH_BACKUP_STREAM", "REASON_UNMUTE_WHEN_VIDEO_TALK_FINISH", "REASON_UNSILENCE", "REASON_UNSILENCE_SUCCESS", "REASON_USE_BACKUP_STREAM", "REASON_USE_ONLINE_LIST_CHANGED_VIDEO", "REASON_VIDEO_LINK", "REASON_VIDEO_LINK_RELEASE", "REASON_VIDEO_TALK_LINK", "REASON_VIDEO_TALK_LINK_INIT", "REASON_VIDEO_TALK_LINK_RELEASE", "REASON_VIDEO_TALK_ONDESTROY", "REASON_VIDEO_TALK_ONRESUME", "REASON_VIDEO_TALK_SENSITIVE_PERMISSION_EVENT", "REASON_VIRTUAL_LINK", "REASON_VIRTUAL_LINK_RELEASE", "REASON_VISIABLITY_STATE_CHANGE", "REASON_VOICE_CHAT_LINK", "REASON_VOICE_CHAT_LINK_RELEASE", "REASON_VOICE_CHAT_PRESTART_RTC", "REASON_VOICE_CHAT_UNMUTE_FALLBACK", "REASON_VOICE_ROOM_VIDEO_VIEW", "REASON_VS_LIVE_START_RECORD", "imageTosPath", "getImageTosPath", "()Ljava/lang/String;", "objectTosPath", "getObjectTosPath", "assembleTosObjectUrl", "path", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveCommonConstants {
    public static final String EXTRA_ENTER_LIVE_EXTRA = "live.intent.extra.ENTER_LIVE_EXTRA";
    public static final String EXTRA_LIVE_AD_TYPE = "live_ad_type";
    public static final String IInteractionFragment_TAG = "AbsInteractionFragment";
    public static final LiveCommonConstants INSTANCE = null;
    public static final int LINK_CONSTANT_SEI_VERSION_PK = 2;
    public static final String LOG_EVENT_KEY_LIVECORE_API = "livecore_api_call";
    public static final String LOG_PARAM_EVENT_KEY = "event_key";
    public static final String LOG_PARAM_MSG = "msg";
    public static final String LOG_PARAM_MULTI_LINK_SCENE = "multi_link_scene";
    public static final String LOG_PARAM_MULTI_LINK_UI_LAYOUT = "multi_link_ui_layout";
    public static final String LOG_PARAM_REASON = "reason";
    public static final String LOG_PARAM_STACK_TRACE = "stack_trace";
    public static final float PK_STREAM_HEIGHT_OLD_RATIO = 0.5f;
    public static final String REASON_ADVANCE_LINK_MUTE = "advance link mute";
    public static final String REASON_ADVANCE_LINK_RESUME_RTC = "advance link resume rtc";
    public static final String REASON_ADVANCE_LINK_RESUME_SERVER = "advance link resume rtc server";
    public static final String REASON_ADVENTURE_BACKGROUND_PAUSE = "adventure background pause";
    public static final String REASON_ADVENTURE_BACKGROUND_RESUME = "adventure background resume";
    public static final String REASON_ADVENTURE_JOIN_RTC = "adventure join rtc";
    public static final String REASON_ADVENTURE_JOIN_RTC_BACKGROUND = "adventure join rtc background";
    public static final String REASON_ADVENTURE_LEAVE_ROOM = "adventure leave rtc room";
    public static final String REASON_AUDIENCE_BACKGROUND_BEFORE_START_ENGINE = "audience background before start engine";
    public static final String REASON_AUDIO_SCENE_BACKGROUND_PAUSE = "audio scene background pause";
    public static final String REASON_AUDIO_SCENE_BACKGROUND_RESUME = "audio scene background resume";
    public static final String REASON_AUDIO_SILENCE_OPT = "audio silence opt";
    public static final String REASON_AVATAR_INIT = "avatar init";
    public static final String REASON_AVATAR_PAUSE = "avatar pause";
    public static final String REASON_AVATAR_RELEASE = "avatar release";
    public static final String REASON_AVATAR_RESUME = "avatar resume";
    public static final String REASON_BACK_FROM_PK = "back_from_pk";
    public static final String REASON_BROADCAST_SENSITIVE_PERMISSION_EVENT = "broadcast sensitive permission event";
    public static final String REASON_COMMENT_HIGHLIGHT_RECORD_PREVIEW = "live highlight record preview";
    public static final String REASON_COMMENT_HIGHLIGHT_RECORD_PUBLISH = "live highlight record publish";
    public static final String REASON_ENTER_BACKGROUND = "enter background";
    public static final String REASON_ENTER_FOREGROUND = "enter foreground";
    public static final String REASON_FLOAT_WINDOW_BACKGROUND = "linkFloatWindow onEnterBackground";
    public static final String REASON_FLOAT_WINDOW_CHECK_AUDIENCE_LINKERS = "linkFloatWindow check_audience_linkers";
    public static final String REASON_FLOAT_WINDOW_FOREGROUND = "linkFloatWindow onEnterForeground";
    public static final String REASON_FORCE_OPEN_ANCHOR_MIC = "force open video talk anchor mic";
    public static final String REASON_FORCE_UN_SILENCE = "force UnSilence";
    public static final String REASON_FRIEND_ROOM_CREATE = "friend room create";
    public static final String REASON_GAME_LIVE_START_AUDIO = "game live start audio";
    public static final String REASON_GAME_LIVE_STOP_AUDIO = "game live stop audio";
    public static final String REASON_GAM_LIVE_STATE_CHANGE = "game live state change";
    public static final String REASON_HIGHLIGHT_PREVIEW = "live highlight preview";
    public static final String REASON_INTERACT_AUDIENCE_CREATE = "interact audience create";
    public static final String REASON_INTERACT_AUDIENCE_START_RTC = "interact audience start rtc";
    public static final String REASON_KICTOUT = "kickout";
    public static final String REASON_KTV_SINGER_STATE_CHANGED = "ktv singer state changed";
    public static final String REASON_LINK_SECURITY = "link security";
    public static final String REASON_LIVE_ADMIN_RECORD = "live admin record";
    public static final String REASON_LIVE_END = "live end";
    public static final String REASON_LIVE_PAUSE = "live pause";
    public static final String REASON_LIVE_PAUSE_FLOAT_WINDOW = "float window live pause";
    public static final String REASON_LIVE_PAUSE_FLOAT_WINDOW_RETURN = "float window live pause return";
    public static final String REASON_LIVE_PAUSE_IN_PREVIEW = "live_pause_in_preview";
    public static final String REASON_LIVE_PREVIEW = "live preview";
    public static final String REASON_LIVE_PREVIEW_SAAS = "live_preview_saas";
    public static final String REASON_LIVE_RECORD = "live record";
    public static final String REASON_LIVE_RESUME = "live resume";
    public static final String REASON_LIVE_RESUME_IN_PREVIEW = "live_resume_in_preview";
    public static final String REASON_LIVE_SENSITIVE_EVENT_END = "sensitive_event_end";
    public static final String REASON_LIVE_SENSITIVE_EVENT_START = "sensitive_event_start";
    public static final String REASON_LIVE_SHARE = "live share";
    public static final String REASON_LIVE_STREAM_SENSITIVE_PERMISSION_EVENT = "live stream sensitive permission_event";
    public static final String REASON_MATCH_APPLY = "match apply";
    public static final String REASON_MEDIA_MANAGER_RELEASE = "media manager release";
    public static final String REASON_MINI_APP_EVENT = "mini app event";
    public static final String REASON_MINI_GAME_ENTER_BACKGROUND = "mini_game_enter_background";
    public static final String REASON_MINI_GAME_ENTER_FOREGROUND = "mini_game_enter_foreground";
    public static final String REASON_MINI_GAME_MOCK_START = "mini game mock start";
    public static final String REASON_NORMAL = "normal";
    public static final String REASON_NORMAL_START = "normal start";
    public static final String REASON_NOTIFICATION_CLOSE = "notification close";
    public static final String REASON_NOT_USE_BACKUP_STREAM = "not use backup stream";
    public static final String REASON_ON_DEDTROY = "onDestroy";
    public static final String REASON_ON_PAUSE = "onPause";
    public static final String REASON_ON_RESUME = "onResume";
    public static final String REASON_OPEN_BEAUTY_DIALOG = "open beauty dialog";
    public static final String REASON_PARTICULAR_PAGE_CLOSE = "on particular page close";
    public static final String REASON_PARTICULAR_PAGE_SHOW = "on particular page show";
    public static final String REASON_PARTICULAR_WHITE_PAGE_CLOSE = "on particular white page close";
    public static final String REASON_PARTICULAR_WHITE_PAGE_SHOW = "on particular white page show";
    public static final String REASON_PERF_ON_FREEZE = "perf on freeze";
    public static final String REASON_PHONE_STATE_CHANGE = "phone state change";
    public static final String REASON_PK_AUDIENCE_OPEN_BEAUTY_DIALOG = "pk audience open beauty dialog";
    public static final String REASON_PK_SWITCH_NORMAL = "pk switch normal";
    public static final String REASON_PREVIEW_BEFORE_START_LIVE = "preview before start live";
    public static final String REASON_PUSH_STREAM_DEMO = "push stream demo";
    public static final String REASON_PUSH_STREAM_PAUSE = "push stream pause";
    public static final String REASON_PUSH_STREAM_RESUME = "push stream resume";
    public static final String REASON_RADIO_BACKGROUND_PAUSE = "radio background pause";
    public static final String REASON_RADIO_BACKGROUND_RESUME = "radio background resume";
    public static final String REASON_RESET_LAST_SILENCE = "reset last silence";
    public static final String REASON_REVENUE_SILENCE = "revenue switch audio";
    public static final String REASON_ROOM_BATTLE_CROSS_SILENCE = "room battle cross silence";
    public static final String REASON_ROOM_BATTLE_CROSS_SILENCE_FLOAT_WINDOW = "room battle cross silence float window";
    public static final String REASON_ROOM_BATTLE_MCU = "room battle mcu";
    public static final String REASON_ROOM_COVERED = "room covered";
    public static final String REASON_ROOM_UNCOVERED = "room uncovered";
    public static final String REASON_RTC_MANAGER_PAUSE = "rtc manager pause";
    public static final String REASON_RTC_MANAGER_RESUME = "rtc manager resume";
    public static final String REASON_RTS_AUDIO_MUTE = "rts audio mute";
    public static final String REASON_RTS_KICK_OUT = "rts kick outf";
    public static final String REASON_RTS_OTHER_USER_SILENCE_SELF = "rts other user silence self";
    public static final String REASON_RTS_USER_JOIN = "rts unmute when user join";
    public static final String REASON_RTS_USER_LIST_CHANGED_VOICE = "rts user list changed voice";
    public static final String REASON_RTS_VIDEO_MUTE = "rts video mute";
    public static final String REASON_SCREEN_LIVE_START_AUDIO = "screen live start audio";
    public static final String REASON_SCREEN_LIVE_STOP_AUDIO = "screen live stop audio";
    public static final String REASON_SCREEN_LOCK = "screen lock";
    public static final String REASON_SCREEN_ON = "screen on";
    public static final String REASON_SCREEN_RECORD_PREVIEW = "live screen record preview";
    public static final String REASON_SELF_PANEL = "self_panel";
    public static final String REASON_SILENCE = "silence";
    public static final String REASON_SILENCE_MESSAGE = "silence message";
    public static final String REASON_SILENCE_SUCCESS = "silence success";
    public static final String REASON_SINGER_CUT_MUSIC = "singer cut music";
    public static final String REASON_SINGER_STATE_CHANGED = "singer state changed";
    public static final String REASON_START_LIVE_STREAM = "start live stream";
    public static final String REASON_START_MULTI_LINK = "start multi link";
    public static final String REASON_START_ON_BACKGROUND = "start on background";
    public static final String REASON_START_PREVIEW = "start live preview";
    public static final String REASON_START_PUSH_STREAM = "start push stream";
    public static final String REASON_SUBBROADCAST_AUDIO_STOP = "subbroadcast audio mute";
    public static final String REASON_SWITCH_BACKUP_STREAM = "swtich backup stream";
    public static final String REASON_UNMUTE_WHEN_VIDEO_TALK_FINISH = "unmute when video talk finish";
    public static final String REASON_UNSILENCE = "unsilence";
    public static final String REASON_UNSILENCE_SUCCESS = "unSilence success";
    public static final String REASON_USE_BACKUP_STREAM = "use backup stream";
    public static final String REASON_USE_ONLINE_LIST_CHANGED_VIDEO = "rts online list changed video";
    public static final String REASON_VIDEO_LINK = "video link view";
    public static final String REASON_VIDEO_LINK_RELEASE = "video link view release";
    public static final String REASON_VIDEO_TALK_LINK = "video talk link view";
    public static final String REASON_VIDEO_TALK_LINK_INIT = "video talk link view init";
    public static final String REASON_VIDEO_TALK_LINK_RELEASE = "video talk link view release";
    public static final String REASON_VIDEO_TALK_ONDESTROY = "video talk onDestroy";
    public static final String REASON_VIDEO_TALK_ONRESUME = "video talk onresume";
    public static final String REASON_VIDEO_TALK_SENSITIVE_PERMISSION_EVENT = "video_talk sensitive permission event";
    public static final String REASON_VIRTUAL_LINK = "virtual link view";
    public static final String REASON_VIRTUAL_LINK_RELEASE = "virtual link view release";
    public static final String REASON_VISIABLITY_STATE_CHANGE = "visiablity state change";
    public static final String REASON_VOICE_CHAT_LINK = "voice chat link view";
    public static final String REASON_VOICE_CHAT_LINK_RELEASE = "voice chat link view release";
    public static final String REASON_VOICE_CHAT_PRESTART_RTC = "voice chat pre start rtc";
    public static final String REASON_VOICE_CHAT_UNMUTE_FALLBACK = "voice chat unmute audio fallback";
    public static final String REASON_VOICE_ROOM_VIDEO_VIEW = "voice room video view";
    public static final String REASON_VS_LIVE_START_RECORD = "vslive start record";
    private static final String imageTosPath = null;
    private static final String objectTosPath = null;

    private LiveCommonConstants() {
    }

    static {
        INSTANCE = new LiveCommonConstants();
        imageTosPath = "p9-webcast.douyinpic.com";
        objectTosPath = "lf1-webcastcdn-tos.douyinstatic.com";
    }

    public final String getImageTosPath() {
        return imageTosPath;
    }

    public final String getObjectTosPath() {
        return objectTosPath;
    }

    @JvmStatic
    public static final String assembleTosObjectUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return "https://" + objectTosPath + '/' + r100;
    }
}
