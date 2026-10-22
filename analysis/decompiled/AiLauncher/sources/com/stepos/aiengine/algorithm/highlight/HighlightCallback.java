package com.stepos.aiengine.algorithm.highlight;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/aiengine/algorithm/highlight/HighlightCallback;", "", "<init>", "()V", "KEY_TOKEN_NEXT", "", "KEY_DONE", "KEY_EXCEPTION", "KEY_ERROR_CODE", "ARG_VIDEO_FILTER_FPS", "ARG_MAX_TOKENS", "DEFAULT_VIDEO_FILTER_FPS", "", "DEFAULT_MAX_TOKENS", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HighlightCallback {
    public static final String ARG_MAX_TOKENS = "max_new_tokens";
    public static final String ARG_VIDEO_FILTER_FPS = "video_filter_fps";
    public static final int DEFAULT_MAX_TOKENS = 256;
    public static final int DEFAULT_VIDEO_FILTER_FPS = 2;
    public static final HighlightCallback INSTANCE = new HighlightCallback();
    public static final String KEY_DONE = "done";
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_EXCEPTION = "exception";
    public static final String KEY_TOKEN_NEXT = "token_next";
}
