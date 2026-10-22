package com.stepos.ailauncher.speech.tts;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b.\n\u0002\u0010\u0006\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015Je\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010!\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J#\u0010&\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060#2\u0006\u0010%\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J-\u0010*\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0017¢\u0006\u0004\b*\u0010+JS\u0010.\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/JA\u00103\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b3\u00104J=\u00106\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b6\u00107J'\u00108\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J'\u0010:\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0017H\u0002¢\u0006\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010@\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010=R\u0014\u0010A\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010=R\u0014\u0010B\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010=R\u0014\u0010C\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010=R\u0014\u0010D\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010=R\u0014\u0010E\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010=R\u0014\u0010F\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u0010=R\u0014\u0010G\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010=R\u0014\u0010H\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010=R\u0014\u0010I\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010=R\u0014\u0010L\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010=R\u0014\u0010M\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010JR\u0014\u0010N\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010=R\u0014\u0010O\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010=R\u0014\u0010P\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u0010JR\u0014\u0010Q\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u0010JR\u0014\u0010S\u001a\u00020R8\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u0010=R\u0014\u0010V\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u0010=R\u0014\u0010W\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u0010=R\u0014\u0010X\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u0010=R\u0014\u0010Y\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010=R\u0014\u0010Z\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u0010=R\u0014\u0010[\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b[\u0010=R\u0014\u0010\\\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\\\u0010=R\u0014\u0010]\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b]\u0010=R\u0014\u0010^\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b^\u0010=R\u0014\u0010_\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b_\u0010=R\u0014\u0010`\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b`\u0010=R\u0014\u0010a\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\ba\u0010JR\u0014\u0010b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bb\u0010J¨\u0006c"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/l;", "", "<init>", "()V", "", "pcmBytes", "", "sampleRate", "channelCount", "bytesPerSample", "m", "(JIII)J", "fedChars", "pcmMs", "audioIdleMs", "playbackPendingMs", "alreadyLearned", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(JJJJJ)J", "msPerChar", Const.INTENT_KEY_PKGNAME, "(JJIIIJ)J", "leadMs", "", "hasPendingText", "maxLeadMs", "hasReceivedPcm", "rateLearned", "lastBatchEndsStrong", "k", "(JJZJJZJZZ)I", "c", "(JJ)I", "q", "(JJ)Z", "", "batchLengths", "spokenChars", "n", "(Ljava/util/List;I)I", "lastAudioIdleMs", "hasQueuedText", "f", "(JJJZ)Z", "sinceResumeMs", "sinceFeedAfterAudioMs", "p", "(JJJZJJJJ)Z", "budget", "idleMs", "hasPcm", "o", "(IJJZJJ)Z", "safeLeadMs", Const.INTENT_KEY_BACKGROUND_COMMAND, "(JJZJJ)Z", Const.INTENT_KEY_APIKEY, "(III)J", "e", "(JJZ)Z", "EST_MS_PER_CHAR", "J", "OBSERVED_RATE_MIN_PCM_MS", "LEARN_MIN_FED_CHARS", "LEARN_MIN_IDLE_MS", "LEARN_MAX_FED_CHARS", "MIN_LEARNED_MS_PER_CHAR", "MAX_LEARNED_MS_PER_CHAR", "PLAYBACK_CAUGHT_UP_MS", "MAX_FEED_LEAD_MS", "SAFE_CLOSE_LEAD_MS", "SAFE_CLOSE_WAIT_TIMEOUT_MS", "FEED_RETRY_MS", "MIN_FEED_CHARS", "I", "SENTENCE_CONTINUATION_FORCE_MS", "STALL_FORCE_FEED_IDLE_MS", "STALL_FORCE_FEED_CHARS", "STALL_FORCE_MAX_LEAD_MS", "RESUME_MS_PER_CHAR", "MAX_RESUME_ATTEMPTS", "RESUME_MIN_UNSPOKEN_CHARS", "", "RESUME_MIN_UNSPOKEN_RATIO", "D", "RESUME_MIN_AUDIO_IDLE_MS", "RESUME_STALL_IDLE_FAST_MS", "RESUME_STALL_IDLE_MS", "POST_FEED_RESUME_GRACE_MS", "FAST_RESUME_MAX_PCM_MS", "RESUME_HEALTHY_PCM_MS", "FOLLOW_UP_OVERSHOOT_MS", "SYNTHESIS_CAUGHT_UP_MS_PER_CHAR", "RESUME_COOLDOWN_MS", "RESUME_KEEP_PLAYING_MS", "RESUME_NO_AUDIO_IDLE_MS", "STALL_WATCH_TICK_MS", "MAX_PRE_AUDIO_CHARS", "MAX_PRE_AUDIO_HARD_CAP", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    public static final long EST_MS_PER_CHAR = 180;
    public static final long FAST_RESUME_MAX_PCM_MS = 4000;
    public static final long FEED_RETRY_MS = 80;
    public static final long FOLLOW_UP_OVERSHOOT_MS = 6000;
    public static final l INSTANCE = new l();
    public static final long LEARN_MAX_FED_CHARS = 200;
    public static final long LEARN_MIN_FED_CHARS = 20;
    public static final long LEARN_MIN_IDLE_MS = 1000;
    public static final long MAX_FEED_LEAD_MS = 7500;
    public static final long MAX_LEARNED_MS_PER_CHAR = 280;
    public static final int MAX_PRE_AUDIO_CHARS = 80;
    public static final int MAX_PRE_AUDIO_HARD_CAP = 120;
    public static final int MAX_RESUME_ATTEMPTS = 3;
    public static final int MIN_FEED_CHARS = 24;
    public static final long MIN_LEARNED_MS_PER_CHAR = 120;
    public static final long OBSERVED_RATE_MIN_PCM_MS = 800;
    public static final long PLAYBACK_CAUGHT_UP_MS = 800;
    public static final long POST_FEED_RESUME_GRACE_MS = 3000;
    public static final long RESUME_COOLDOWN_MS = 20000;
    public static final long RESUME_HEALTHY_PCM_MS = 15000;
    public static final long RESUME_KEEP_PLAYING_MS = 2000;
    public static final long RESUME_MIN_AUDIO_IDLE_MS = 2000;
    public static final int RESUME_MIN_UNSPOKEN_CHARS = 30;
    public static final double RESUME_MIN_UNSPOKEN_RATIO = 0.3d;
    public static final long RESUME_MS_PER_CHAR = 200;
    public static final long RESUME_NO_AUDIO_IDLE_MS = 15000;
    public static final long RESUME_STALL_IDLE_FAST_MS = 3000;
    public static final long RESUME_STALL_IDLE_MS = 8000;
    public static final long SAFE_CLOSE_LEAD_MS = 2500;
    public static final long SAFE_CLOSE_WAIT_TIMEOUT_MS = 90000;
    public static final long SENTENCE_CONTINUATION_FORCE_MS = 1200;
    public static final int STALL_FORCE_FEED_CHARS = 24;
    public static final long STALL_FORCE_FEED_IDLE_MS = 1500;
    public static final long STALL_FORCE_MAX_LEAD_MS = 8000;
    public static final long STALL_WATCH_TICK_MS = 500;
    public static final long SYNTHESIS_CAUGHT_UP_MS_PER_CHAR = 130;

    public static /* synthetic */ int d(l lVar, long j10, long j11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = 200;
        }
        return lVar.c(j10, j11);
    }

    public final long a(int sampleRate, int channelCount, int bytesPerSample) {
        return C5685n.g(((C5685n.n(sampleRate, 8000, 96000) * C5685n.f(channelCount, 1)) * C5685n.f(bytesPerSample, 1)) / 1000, 1L);
    }

    public final long b(long fedChars, long pcmBytes, int sampleRate, int channelCount, int bytesPerSample, long msPerChar) {
        if (fedChars <= 0) {
            return 0L;
        }
        return C5685n.g((fedChars * C5685n.o(msPerChar, 1L, 280L)) - m(pcmBytes, sampleRate, channelCount, bytesPerSample), 0L);
    }

    public final int c(long pcmMs, long msPerChar) {
        return (int) (C5685n.g(pcmMs, 0L) / C5685n.g(msPerChar, 1L));
    }

    public final boolean e(long fedChars, long pcmMs, boolean hasQueuedText) {
        if (hasQueuedText) {
            return true;
        }
        if (fedChars <= 0) {
            return false;
        }
        long jD = fedChars - d(this, pcmMs, 0L, 2, null);
        return jD >= 30 && ((double) jD) >= ((double) fedChars) * 0.3d;
    }

    public final boolean f(long fedChars, long pcmMs, long lastAudioIdleMs, boolean hasQueuedText) {
        if (fedChars <= 0) {
            return hasQueuedText;
        }
        if (hasQueuedText) {
            return true;
        }
        return !q(fedChars, pcmMs) && e(fedChars, pcmMs, false) && lastAudioIdleMs >= 2000;
    }

    public final boolean g(long leadMs, long safeLeadMs, boolean hasReceivedPcm, long playbackPendingMs, long audioIdleMs) {
        if (hasReceivedPcm && leadMs > safeLeadMs) {
            return 0 <= playbackPendingMs && playbackPendingMs < 801 && audioIdleMs >= 1000;
        }
        return true;
    }

    public final long i(long fedChars, long pcmMs, long audioIdleMs, long playbackPendingMs, long alreadyLearned) {
        if (alreadyLearned > 0) {
            return alreadyLearned;
        }
        if (fedChars < 20 || pcmMs < 800 || audioIdleMs < 1000) {
            return 0L;
        }
        boolean z10 = false;
        if (0 <= playbackPendingMs && playbackPendingMs < 801) {
            z10 = true;
        }
        long j10 = pcmMs / fedChars;
        if (j10 < 180 && !z10 && audioIdleMs < 8000) {
            return 0L;
        }
        if (fedChars > 200 && j10 < 120) {
            return 0L;
        }
        if (j10 >= 120) {
            return C5685n.o(j10, 120L, 280L);
        }
        if (!z10 || audioIdleMs < 8000) {
            return 0L;
        }
        return C5685n.o(j10, 50L, 280L);
    }

    public final int k(long leadMs, long audioIdleMs, boolean hasPendingText, long maxLeadMs, long fedChars, boolean hasReceivedPcm, long msPerChar, boolean rateLearned, boolean lastBatchEndsStrong) {
        if (!hasReceivedPcm) {
            if (fedChars >= 120) {
                return 0;
            }
            int i10 = (int) (80 - fedChars);
            return i10 >= 24 ? i10 : (lastBatchEndsStrong || !hasPendingText || fedChars <= 0) ? (!hasPendingText || audioIdleMs < 1500) ? 0 : 24 : (int) (120 - fedChars);
        }
        if (!rateLearned && fedChars >= 80) {
            return 0;
        }
        int iG = (int) (C5685n.g(maxLeadMs - leadMs, 0L) / C5685n.g(msPerChar, 1L));
        return iG > 0 ? iG : (!hasPendingText || audioIdleMs < 1500 || leadMs > 8000) ? 0 : 24;
    }

    public final long m(long pcmBytes, int sampleRate, int channelCount, int bytesPerSample) {
        if (pcmBytes <= 0) {
            return 0L;
        }
        return pcmBytes / a(sampleRate, channelCount, bytesPerSample);
    }

    public final int n(List<Integer> batchLengths, int spokenChars) {
        kotlin.jvm.internal.p.i(batchLengths, "batchLengths");
        int i10 = 0;
        int i11 = 0;
        for (Object obj : batchLengths) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            int iIntValue = ((Number) obj).intValue() + i11;
            if (iIntValue > spokenChars) {
                return (spokenChars <= i11 || i10 >= C1173v.o(batchLengths)) ? i10 : i12;
            }
            i11 = iIntValue;
            i10 = i12;
        }
        return batchLengths.size();
    }

    public final boolean o(int budget, long leadMs, long idleMs, boolean hasPcm, long fedChars, long pcmMs) {
        if (hasPcm && budget < 30 && idleMs >= 1500) {
            return q(fedChars, pcmMs) || leadMs < 14000;
        }
        return false;
    }

    public final boolean p(long fedChars, long pcmMs, long lastAudioIdleMs, boolean hasQueuedText, long leadMs, long playbackPendingMs, long sinceResumeMs, long sinceFeedAfterAudioMs) {
        if (lastAudioIdleMs < 0) {
            return false;
        }
        if (pcmMs <= 0) {
            return lastAudioIdleMs >= 15000 && (fedChars > 0 || hasQueuedText);
        }
        if (q(fedChars, pcmMs)) {
            return false;
        }
        if (playbackPendingMs != Long.MAX_VALUE && playbackPendingMs > 2000) {
            return false;
        }
        if ((pcmMs >= 4000 && sinceResumeMs < 20000) || leadMs < MAX_FEED_LEAD_MS || !e(fedChars, pcmMs, hasQueuedText)) {
            return false;
        }
        if (0 <= sinceFeedAfterAudioMs && sinceFeedAfterAudioMs < 3000) {
            return false;
        }
        if (pcmMs < 15000 || leadMs < 14000) {
            return (leadMs >= 16000 && lastAudioIdleMs >= 3000 && pcmMs < 4000) || lastAudioIdleMs >= 8000;
        }
        return false;
    }

    public final boolean q(long fedChars, long pcmMs) {
        return fedChars > 0 && pcmMs > 0 && pcmMs >= fedChars * 130;
    }
}
