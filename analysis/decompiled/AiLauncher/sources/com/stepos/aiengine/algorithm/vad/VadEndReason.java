package com.stepos.aiengine.algorithm.vad;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/algorithm/vad/VadEndReason;", "", "<init>", "()V", "SILENCE", "", "NO_SPEECH", "MAX_DURATION", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VadEndReason {
    public static final VadEndReason INSTANCE = new VadEndReason();
    public static final String MAX_DURATION = "max_duration";
    public static final String NO_SPEECH = "no_speech";
    public static final String SILENCE = "silence";
}
