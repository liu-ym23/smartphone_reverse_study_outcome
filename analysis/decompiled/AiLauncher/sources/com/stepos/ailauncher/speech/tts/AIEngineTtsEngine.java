package com.stepos.ailauncher.speech.tts;

import La.D;
import La.H;
import La.K;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.tts.ITtsStreamSession;
import com.stepos.aiengine.algorithm.tts.ITtsStreaming;
import com.stepos.aiengine.algorithm.tts.TtsStreamListener;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.client.AlgorithmClient;
import com.stepos.aiengine.clients.AlgorithmClients;
import com.stepos.ailauncher.common.utils.I;
import com.stepos.ailauncher.common.utils.J;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import com.stepos.ailauncher.contract.api.speech.TtsStreamSession;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C0919o;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import o6.C5009a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0005*\u0002 \u0001\b\u0000\u0018\u0000 £\u00012\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001d\u0010\u0014J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\bJ)\u0010\"\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J)\u0010$\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b$\u0010#JA\u0010,\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010&\u001a\u00020%2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\u0014J\u000f\u0010/\u001a\u00020\rH\u0002¢\u0006\u0004\b/\u0010\u0014J\u0017\u00100\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b0\u00101J'\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\rH\u0002¢\u0006\u0004\b6\u0010\u0014J\u000f\u00107\u001a\u00020\rH\u0002¢\u0006\u0004\b7\u0010\u0014J\u001f\u00109\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u00108\u001a\u00020\tH\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\r2\u0006\u00108\u001a\u00020\tH\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b=\u0010\u0016J\u001f\u0010?\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\tH\u0002¢\u0006\u0004\b?\u0010:J\u000f\u0010@\u001a\u00020(H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\rH\u0002¢\u0006\u0004\bB\u0010\u0014J\u000f\u0010C\u001a\u00020(H\u0002¢\u0006\u0004\bC\u0010AJ(\u0010E\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u000e\b\u0002\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060'H\u0082@¢\u0006\u0004\bE\u0010FJ\u001f\u0010I\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020(H\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\tH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020(2\u0006\u0010M\u001a\u00020(H\u0002¢\u0006\u0004\bN\u0010OJ\u0018\u0010P\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0082@¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020(H\u0002¢\u0006\u0004\bR\u0010AJ\u000f\u0010S\u001a\u00020(H\u0002¢\u0006\u0004\bS\u0010AJ!\u0010U\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010T\u001a\u00020\u001fH\u0002¢\u0006\u0004\bU\u0010VJ\u0013\u0010W\u001a\u00020\t*\u00020\tH\u0002¢\u0006\u0004\bW\u00101J\u000f\u0010Y\u001a\u00020XH\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\tH\u0002¢\u0006\u0004\b[\u0010LJ\u000f\u0010\\\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u001fH\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010b\u001a\u00020`2\u0006\u0010a\u001a\u00020`H\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010e\u001a\u00020\u001f2\u0006\u0010d\u001a\u00020\u001fH\u0002¢\u0006\u0004\be\u0010fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010rR\u0014\u0010u\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010vR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010{\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010zR\u0014\u0010|\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010zR\u0014\u0010}\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010zR\u0014\u0010~\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010zR\u0014\u0010\u007f\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010zR\u0016\u0010\u0080\u0001\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010zR\u0016\u0010\u0081\u0001\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010vR\u0016\u0010\u0082\u0001\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010vR\u0016\u0010\u0083\u0001\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010vR\u0016\u0010\u0084\u0001\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010zR\u0016\u0010\u0085\u0001\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010zR\u0016\u0010\u0086\u0001\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010zR\u0016\u0010\u0087\u0001\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010vR\u0016\u0010\u0088\u0001\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010vR\u0016\u0010\u0089\u0001\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010vR\u0016\u0010\u008a\u0001\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010rR\u0016\u0010\u008b\u0001\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010rR\u0018\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R)\u0010\u0091\u0001\u001a\u0014\u0012\u0004\u0012\u00020\t0\u008f\u0001j\t\u0012\u0004\u0012\u00020\t`\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0097\u0001R\u0016\u0010\u009a\u0001\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010rR\u0016\u0010\u009b\u0001\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010zR\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001¨\u0006¤\u0001"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/AIEngineTtsEngine;", "Lcom/stepos/ailauncher/speech/tts/i;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "", "text", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "listener", "LY8/t;", "speak", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)V", "Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/api/speech/TtsListener;)Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", com.stepos.ailauncher.chat.trace.g.ACTION_STOP, "()V", "isSpeaking", "()Z", "pause", "resume", "", "gain", "c", "(F)V", "destroy", "x0", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "reason", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/contract/api/speech/TtsListener;ILjava/lang/String;)V", "r0", "Lcom/stepos/ailauncher/speech/tts/q;", "handler", "Lkotlin/Function0;", "", "sinceResumeMs", "Lkotlin/Function1;", "tryResume", "J0", "(ILcom/stepos/ailauncher/speech/tts/q;Lp9/a;Lp9/l;)V", "l0", "D0", "F0", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/aiengine/algorithm/tts/ITtsStreamSession;", "session", "q0", "(Lcom/stepos/aiengine/algorithm/tts/ITtsStreamSession;ILjava/lang/String;)Z", "A0", "B0", "from", "G0", "(ILjava/lang/String;)V", "k0", "(Ljava/lang/String;)V", "w0", "expectedGeneration", "s0", "o0", "()J", "y0", "n0", "stillValid", "Y0", "(ILp9/a;Le9/c;)Ljava/lang/Object;", "sequence", "gapMs", "C0", "(IJ)V", "H0", "()Ljava/lang/String;", "timestampMs", "p0", "(J)J", "X0", "(ILe9/c;)Ljava/lang/Object;", "j0", "I0", "edge", "V0", "(Ljava/lang/String;I)Ljava/lang/String;", "E0", "Landroid/os/Bundle;", "m0", "()Landroid/os/Bundle;", "u0", "v0", "()F", "t0", "()I", "", "data", "i0", "([B)[B", "encoding", "z0", "(I)I", "Landroid/content/Context;", "LUa/M;", "scope", "LUa/M;", "streamSession", "Lcom/stepos/aiengine/algorithm/tts/ITtsStreamSession;", "Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer;", "pcmPlayer", "Lcom/stepos/ailauncher/speech/tts/StreamingPcmPlayer;", "Ljava/util/concurrent/atomic/AtomicBoolean;", SpriteEventAction.AGENT_TTS_START, "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelled", "Ljava/util/concurrent/atomic/AtomicInteger;", "streamGeneration", "Ljava/util/concurrent/atomic/AtomicInteger;", "audioChunkSequence", "Ljava/util/concurrent/atomic/AtomicLong;", "lastAudioChunkAtMs", "Ljava/util/concurrent/atomic/AtomicLong;", "firstFeedAfterAudioMs", "streamStartedAtMs", "sessionOpenedAtMs", "firstFeedAtMs", "firstAudioAtMs", "maxAudioChunkGapMs", "maxAudioChunkGapSeq", "feedTextCount", "feedRejectedCount", "totalPcmBytesReceived", "totalFedChars", "learnedMsPerChar", "pcmSampleRate", "pcmChannelCount", "pcmBytesPerSample", "sessionOpened", "playStartedNotified", "", "feedLock", "Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "connFedBatches", "Ljava/util/ArrayList;", "textHandler", "Lcom/stepos/ailauncher/speech/tts/q;", "Lkotlinx/coroutines/g;", "finishStreamJob", "Lkotlinx/coroutines/g;", "stallWatchJob", "screenOffDisconnectJob", "screenOff", "screenOffAtMs", "activeStreamListener", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "finishHandledGeneration", "I", "com/stepos/ailauncher/speech/tts/AIEngineTtsEngine$b", "screenStateListener", "Lcom/stepos/ailauncher/speech/tts/AIEngineTtsEngine$b;", "Companion", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AIEngineTtsEngine implements i {
    private static final long AUDIO_CHUNK_GAP_WARN_MS = 500;
    private static final long AUDIO_WRITE_COST_WARN_MS = 200;
    private static final long COMPLETE_AFTER_CLOSE_TIMEOUT_MS = 30000;
    private static final int DEFAULT_PCM_BYTES_PER_SAMPLE = 2;
    private static final int DEFAULT_PCM_CHANNELS = 1;
    private static final int DEFAULT_PCM_SAMPLE_RATE = 24000;
    private static final float DEFAULT_SPEED = 1.0f;
    private static final String DEFAULT_VOICE_ID = "zhaoqixiaoduo";
    private static final float DEFAULT_VOLUME = 1.0f;
    private static final long FEED_TEXT_INTERVAL_MS = 100;
    private static final String KEY_FEEDBACK_VOLUME = "voice_setting_feedback_volume";
    private static final String KEY_FEEDBACK_VOLUME_SYNC_SYSTEM = "voice_setting_feedback_volume_sync_system";
    private static final String KEY_SELECTED_VOICE_ID = "voice_setting_selected_voice_id";
    private static final String LEGACY_KEY_TTS_VOICE_ID = "tts_voice_id";
    private static final int MAX_FEED_TEXT_CHARS = 80;
    private static final String PARAM_MODE = "tts.mode";
    private static final String PARAM_SPEED = "tts.speed";
    private static final String PARAM_TRACE_ID = "trace_id";
    private static final String PARAM_VOICE = "tts.voice";
    private static final String PARAM_VOLUME = "tts.volume";
    private static final long SCREEN_OFF_TTS_DISCONNECT_MS = 5000;
    private static final long STREAM_TAIL_QUIET_MS = 2000;
    private static final String TAG = "AIEngineTts";
    private static final String TTS_MODE_CONVERSATION = "conversation";
    private volatile TtsListener activeStreamListener;
    private final AtomicInteger audioChunkSequence;
    private final AtomicBoolean cancelled;
    private final ArrayList<String> connFedBatches;
    private final Context context;
    private final Object feedLock;
    private final AtomicInteger feedRejectedCount;
    private final AtomicInteger feedTextCount;
    private volatile int finishHandledGeneration;
    private kotlinx.coroutines.g finishStreamJob;
    private final AtomicLong firstAudioAtMs;
    private final AtomicLong firstFeedAfterAudioMs;
    private final AtomicLong firstFeedAtMs;
    private final AtomicLong lastAudioChunkAtMs;
    private final AtomicLong learnedMsPerChar;
    private final AtomicLong maxAudioChunkGapMs;
    private final AtomicInteger maxAudioChunkGapSeq;
    private final AtomicInteger pcmBytesPerSample;
    private final AtomicInteger pcmChannelCount;
    private final StreamingPcmPlayer pcmPlayer;
    private final AtomicInteger pcmSampleRate;
    private final AtomicBoolean playStartedNotified;
    private final M scope;
    private final AtomicBoolean screenOff;
    private final AtomicLong screenOffAtMs;
    private kotlinx.coroutines.g screenOffDisconnectJob;
    private final b screenStateListener;
    private final AtomicBoolean sessionOpened;
    private final AtomicLong sessionOpenedAtMs;
    private final AtomicBoolean speaking;
    private kotlinx.coroutines.g stallWatchJob;
    private final AtomicInteger streamGeneration;
    private ITtsStreamSession streamSession;
    private final AtomicLong streamStartedAtMs;
    private q textHandler;
    private final AtomicLong totalFedChars;
    private final AtomicLong totalPcmBytesReceived;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/speech/tts/AIEngineTtsEngine$b", "Lcom/stepos/ailauncher/common/utils/J$a;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements J.a {
        public b() {
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void a() {
            AIEngineTtsEngine.this.B0();
        }

        @Override // com.stepos.ailauncher.common.utils.J.a
        public void b() {
            AIEngineTtsEngine.this.A0();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/speech/tts/AIEngineTtsEngine$c", "Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", "", "text", "", "feedText", "(Ljava/lang/String;)I", "LY8/t;", "close", "()V", "cancel", "", "isOpen", "()Z", "isReadyToClose", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements TtsStreamSession {
        final /* synthetic */ Ref$ObjectRef<kotlinx.coroutines.g> $completeTimeoutJob;
        final /* synthetic */ int $generation;
        final /* synthetic */ q $handler;
        final /* synthetic */ AtomicBoolean $inputClosed;
        final /* synthetic */ Object $inputLock;
        final /* synthetic */ AtomicLong $lastSanitizeDropLogMs;
        final /* synthetic */ TtsListener $listener;
        final /* synthetic */ ITtsStreamSession $session;
        final /* synthetic */ AtomicBoolean $sessionBroken;
        final /* synthetic */ Ref$ObjectRef<ITtsStreamSession> $streamHandle;
        final /* synthetic */ j $tableStripper;
        final /* synthetic */ r $textSanitizer;
        final /* synthetic */ AIEngineTtsEngine this$0;

        public c(Object obj, AtomicBoolean atomicBoolean, AIEngineTtsEngine aIEngineTtsEngine, r rVar, j jVar, q qVar, AtomicLong atomicLong, int i10, ITtsStreamSession iTtsStreamSession, Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, TtsListener ttsListener, Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef2, AtomicBoolean atomicBoolean2) {
            this.$inputLock = obj;
            this.$inputClosed = atomicBoolean;
            this.this$0 = aIEngineTtsEngine;
            this.$textSanitizer = rVar;
            this.$tableStripper = jVar;
            this.$handler = qVar;
            this.$lastSanitizeDropLogMs = atomicLong;
            this.$generation = i10;
            this.$session = iTtsStreamSession;
            this.$completeTimeoutJob = ref$ObjectRef;
            this.$listener = ttsListener;
            this.$streamHandle = ref$ObjectRef2;
            this.$sessionBroken = atomicBoolean2;
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsStreamSession
        public void cancel() {
            Object obj = this.$inputLock;
            AtomicBoolean atomicBoolean = this.$inputClosed;
            AIEngineTtsEngine aIEngineTtsEngine = this.this$0;
            q qVar = this.$handler;
            synchronized (obj) {
                atomicBoolean.set(true);
                aIEngineTtsEngine.cancelled.set(true);
                qVar.c();
                t tVar = t.f7040a;
            }
            kotlinx.coroutines.g gVar = this.$completeTimeoutJob.f34820a;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.this$0.l0();
            this.this$0.textHandler = null;
            Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef = this.$streamHandle;
            ITtsStreamSession iTtsStreamSession = this.$session;
            try {
                Result.Companion companion = Result.INSTANCE;
                ITtsStreamSession iTtsStreamSession2 = ref$ObjectRef.f34820a;
                Result.b(Boolean.valueOf(iTtsStreamSession2 != null ? iTtsStreamSession2.cancel() : iTtsStreamSession.cancel()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            this.this$0.j(this.$listener, this.$generation, "clientCancel");
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsStreamSession
        public void close() {
            Object objB;
            Object obj = this.$inputLock;
            AtomicBoolean atomicBoolean = this.$inputClosed;
            r rVar = this.$textSanitizer;
            j jVar = this.$tableStripper;
            q qVar = this.$handler;
            synchronized (obj) {
                try {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        String str = rVar.a(jVar.d()) + rVar.l();
                        if (str.length() > 0) {
                            qVar.l(str);
                        }
                        qVar.k();
                        t tVar = t.f7040a;
                        int i10 = this.$generation;
                        ITtsStreamSession iTtsStreamSession = this.$session;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            objB = Result.b(Boolean.valueOf(iTtsStreamSession.isOpen()));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objB = Result.b(C4849c.a(th));
                        }
                        Boolean bool = Boolean.FALSE;
                        if (Result.g(objB)) {
                            objB = bool;
                        }
                        Log.i(AIEngineTtsEngine.TAG, "close stream scheduled generation=" + i10 + " isOpen=" + objB + " receivedChunks=" + this.this$0.audioChunkSequence.get() + " fedChars=" + this.this$0.totalFedChars.get() + " handlerPending=" + this.$handler.i() + " pcmUnderruns=" + this.this$0.pcmPlayer.D() + " maxAudioGapMs=" + this.this$0.maxAudioChunkGapMs.get() + " maxGapSeq=" + this.this$0.maxAudioChunkGapSeq.get());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsStreamSession
        public int feedText(String text) {
            kotlin.jvm.internal.p.i(text, "text");
            int length = 0;
            if (H.x0(text)) {
                return 0;
            }
            Object obj = this.$inputLock;
            AtomicBoolean atomicBoolean = this.$inputClosed;
            AIEngineTtsEngine aIEngineTtsEngine = this.this$0;
            r rVar = this.$textSanitizer;
            j jVar = this.$tableStripper;
            q qVar = this.$handler;
            AtomicLong atomicLong = this.$lastSanitizeDropLogMs;
            synchronized (obj) {
                try {
                    if (!atomicBoolean.get() && !aIEngineTtsEngine.cancelled.get()) {
                        String strA = rVar.a(H.G1(jVar.a(text), ' ', '\t'));
                        if (strA.length() > 0) {
                            qVar.l(strA);
                        } else if (text.length() >= 12) {
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            long j10 = atomicLong.get();
                            if (jElapsedRealtime - j10 >= 2000 && atomicLong.compareAndSet(j10, jElapsedRealtime)) {
                                Log.i(AIEngineTtsEngine.TAG, "tts sanitize dropped len=" + text.length() + " head=[" + aIEngineTtsEngine.E0(D.S(K.R1(text, 40), '\n', ' ', false, 4, null)) + "]");
                            }
                        }
                        length = text.length();
                    }
                } finally {
                }
            }
            return length;
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsStreamSession
        public boolean isOpen() {
            Object objB;
            if (this.$inputClosed.get() || this.this$0.cancelled.get()) {
                return false;
            }
            if (this.$sessionBroken.get()) {
                return true;
            }
            ITtsStreamSession iTtsStreamSession = this.$streamHandle.f34820a;
            if (iTtsStreamSession == null) {
                return false;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Boolean.valueOf(iTtsStreamSession.isOpen()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Boolean bool = Boolean.FALSE;
            if (Result.g(objB)) {
                objB = bool;
            }
            return ((Boolean) objB).booleanValue();
        }

        @Override // com.stepos.ailauncher.contract.api.speech.TtsStreamSession
        public boolean isReadyToClose() {
            if (this.$handler.f()) {
                return l.INSTANCE.g(this.this$0.n0(), (26 & 2) != 0 ? 2500L : 0L, (26 & 4) != 0 ? true : this.this$0.totalPcmBytesReceived.get() > 0, (26 & 8) != 0 ? Long.MAX_VALUE : 0L, (26 & 16) != 0 ? -1L : 0L);
            }
            return false;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d implements InterfaceC5063a {
        public static final d INSTANCE = new d();

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    public AIEngineTtsEngine(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
        M mA = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
        this.scope = mA;
        this.pcmPlayer = new StreamingPcmPlayer(mA, TAG);
        this.speaking = new AtomicBoolean(false);
        this.cancelled = new AtomicBoolean(false);
        this.streamGeneration = new AtomicInteger(0);
        this.audioChunkSequence = new AtomicInteger(0);
        this.lastAudioChunkAtMs = new AtomicLong(0L);
        this.firstFeedAfterAudioMs = new AtomicLong(0L);
        this.streamStartedAtMs = new AtomicLong(0L);
        this.sessionOpenedAtMs = new AtomicLong(0L);
        this.firstFeedAtMs = new AtomicLong(0L);
        this.firstAudioAtMs = new AtomicLong(0L);
        this.maxAudioChunkGapMs = new AtomicLong(0L);
        this.maxAudioChunkGapSeq = new AtomicInteger(0);
        this.feedTextCount = new AtomicInteger(0);
        this.feedRejectedCount = new AtomicInteger(0);
        this.totalPcmBytesReceived = new AtomicLong(0L);
        this.totalFedChars = new AtomicLong(0L);
        this.learnedMsPerChar = new AtomicLong(0L);
        this.pcmSampleRate = new AtomicInteger(DEFAULT_PCM_SAMPLE_RATE);
        this.pcmChannelCount = new AtomicInteger(1);
        this.pcmBytesPerSample = new AtomicInteger(2);
        this.sessionOpened = new AtomicBoolean(false);
        this.playStartedNotified = new AtomicBoolean(false);
        this.feedLock = new Object();
        this.connFedBatches = new ArrayList<>();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.screenOff = atomicBoolean;
        this.screenOffAtMs = new AtomicLong(0L);
        this.finishHandledGeneration = -1;
        b bVar = new b();
        this.screenStateListener = bVar;
        J j10 = J.INSTANCE;
        atomicBoolean.set(j10.f(applicationContext));
        J.c(j10, applicationContext, bVar, false, 4, null);
    }

    public static final void K0(AtomicBoolean atomicBoolean, int i10, AIEngineTtsEngine aIEngineTtsEngine, Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef, String str) {
        Object objB;
        t tVar;
        if (atomicBoolean.compareAndSet(false, true)) {
            Log.d(TAG, "session close issued generation=" + i10 + " reason=" + str);
            try {
                Result.Companion companion = Result.INSTANCE;
                ITtsStreamSession iTtsStreamSession = ref$ObjectRef.f34820a;
                if (iTtsStreamSession != null) {
                    iTtsStreamSession.close();
                    tVar = t.f7040a;
                } else {
                    tVar = null;
                }
                objB = Result.b(tVar);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                Log.e(TAG, "session.close failed generation=" + i10 + " reason=" + str, thE);
            }
        }
    }

    public static final long L0(AtomicLong atomicLong) {
        long j10 = atomicLong.get();
        if (j10 == 0) {
            return Long.MAX_VALUE;
        }
        return SystemClock.elapsedRealtime() - j10;
    }

    public static final boolean M0(Ref$ObjectRef ref$ObjectRef, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return ((Boolean) ((InterfaceC5074l) ref$ObjectRef.f34820a).invoke(it)).booleanValue();
    }

    public static final boolean N0(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return false;
    }

    public static final boolean O0(AIEngineTtsEngine aIEngineTtsEngine, AtomicBoolean atomicBoolean, int i10, Ref$ObjectRef ref$ObjectRef, AtomicBoolean atomicBoolean2, AtomicLong atomicLong, String text) {
        boolean z10;
        ITtsStreamSession iTtsStreamSession;
        kotlin.jvm.internal.p.i(text, "text");
        synchronized (aIEngineTtsEngine.feedLock) {
            z10 = false;
            if (!aIEngineTtsEngine.cancelled.get() && !atomicBoolean.get() && i10 == aIEngineTtsEngine.streamGeneration.get() && aIEngineTtsEngine.sessionOpened.get() && (iTtsStreamSession = (ITtsStreamSession) ref$ObjectRef.f34820a) != null) {
                boolean zQ0 = aIEngineTtsEngine.q0(iTtsStreamSession, i10, text);
                if (zQ0 && atomicBoolean2.compareAndSet(true, false)) {
                    atomicLong.set(SystemClock.elapsedRealtime() + 1500);
                }
                z10 = zQ0;
            }
        }
        return z10;
    }

    public static final t P0(int i10, AIEngineTtsEngine aIEngineTtsEngine, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, Ref$ObjectRef ref$ObjectRef) {
        Log.i(TAG, "endStreamingTxt generation=" + i10 + " fedChars=" + aIEngineTtsEngine.totalFedChars.get() + " leadMs=" + aIEngineTtsEngine.n0() + " pcmBytes=" + aIEngineTtsEngine.totalPcmBytesReceived.get());
        C1060i.d(aIEngineTtsEngine.scope, null, null, new AIEngineTtsEngine$startStream$handler$2$1(aIEngineTtsEngine, i10, atomicInteger.get(), atomicInteger, atomicBoolean, ref$ObjectRef, null), 3, null);
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int Q0(com.stepos.ailauncher.speech.tts.AIEngineTtsEngine r29, int r30, java.util.concurrent.atomic.AtomicLong r31, java.util.concurrent.atomic.AtomicLong r32, java.util.concurrent.atomic.AtomicBoolean r33) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.AIEngineTtsEngine.Q0(com.stepos.ailauncher.speech.tts.AIEngineTtsEngine, int, java.util.concurrent.atomic.AtomicLong, java.util.concurrent.atomic.AtomicLong, java.util.concurrent.atomic.AtomicBoolean):int");
    }

    public static final ITtsStreamSession R0(final AtomicInteger atomicInteger, ITtsStreaming iTtsStreaming, Bundle bundle, final AIEngineTtsEngine aIEngineTtsEngine, final int i10, final q qVar, final AtomicInteger atomicInteger2, final TtsListener ttsListener, final Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, final AtomicBoolean atomicBoolean, final Ref$ObjectRef<InterfaceC5074l<String, Boolean>> ref$ObjectRef2, final AtomicBoolean atomicBoolean2) {
        final int i11 = atomicInteger.get();
        return iTtsStreaming.openSession(AlgorithmToken.INSTANCE.submit(), bundle, new TtsStreamListener() { // from class: com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStream$openCloudSession$1
            @Override // com.stepos.aiengine.algorithm.tts.TtsStreamListener
            public void onAudioChunk(byte[] pcm, int sampleRate, int channelCount, int encoding) {
                long j10;
                int andSet;
                kotlin.jvm.internal.p.i(pcm, "pcm");
                if (this.this$0.cancelled.get() || i10 != this.this$0.streamGeneration.get() || AIEngineTtsEngine.S0(i11, atomicInteger)) {
                    return;
                }
                this.this$0.totalPcmBytesReceived.addAndGet(pcm.length);
                AtomicInteger atomicInteger3 = this.this$0.pcmSampleRate;
                Integer numValueOf = Integer.valueOf(sampleRate);
                int iIntValue = numValueOf.intValue();
                if (8000 > iIntValue || iIntValue >= 96001) {
                    numValueOf = null;
                }
                atomicInteger3.set(numValueOf != null ? numValueOf.intValue() : 24000);
                this.this$0.pcmChannelCount.set(C5685n.f(channelCount, 1));
                this.this$0.pcmBytesPerSample.set(this.this$0.z0(encoding) != 4 ? 2 : 4);
                if (this.this$0.playStartedNotified.compareAndSet(false, true)) {
                    C1060i.d(kotlinx.coroutines.d.a(Y.c()), null, null, new AIEngineTtsEngine$startStream$openCloudSession$1$onAudioChunk$2(ttsListener, null), 3, null);
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.this$0.firstAudioAtMs.compareAndSet(0L, jElapsedRealtime);
                long andSet2 = this.this$0.lastAudioChunkAtMs.getAndSet(jElapsedRealtime);
                this.this$0.firstFeedAfterAudioMs.set(0L);
                long j11 = andSet2 != 0 ? jElapsedRealtime - andSet2 : 0L;
                this.this$0.pcmPlayer.z(sampleRate, channelCount, this.this$0.z0(encoding));
                byte[] bArrI0 = this.this$0.i0(pcm);
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                boolean zG = this.this$0.pcmPlayer.g(bArrI0);
                long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                int iIncrementAndGet = this.this$0.audioChunkSequence.incrementAndGet();
                this.this$0.C0(iIncrementAndGet, j11);
                this.this$0.y0();
                l lVar = l.INSTANCE;
                long jM = lVar.m(this.this$0.totalPcmBytesReceived.get(), this.this$0.pcmSampleRate.get(), this.this$0.pcmChannelCount.get(), this.this$0.pcmBytesPerSample.get());
                if (atomicInteger2.get() > 0) {
                    j10 = jElapsedRealtime3;
                    if (lVar.q(this.this$0.totalFedChars.get(), jM) && (andSet = atomicInteger2.getAndSet(0)) > 0) {
                        Log.i("AIEngineTts", "tts resume budget restored generation=" + i10 + " after " + andSet);
                    }
                } else {
                    j10 = jElapsedRealtime3;
                }
                q.h(qVar, false, 1, null);
                if (iIncrementAndGet == 1) {
                    Log.i("AIEngineTts", "audioChunk#1 generation=" + i10 + " sampleRate=" + sampleRate);
                    return;
                }
                if (!zG || j10 >= 200) {
                    Log.w("AIEngineTts", "audioChunk#" + iIncrementAndGet + " enqueue=" + zG + " writeCostMs=" + j10);
                    return;
                }
                if (j11 >= 500) {
                    Log.w("AIEngineTts", "audioChunk#" + iIncrementAndGet + " gapMs=" + j11);
                }
            }

            @Override // com.stepos.aiengine.algorithm.tts.TtsStreamListener
            public void onCancelled(int code, String message) {
                kotlin.jvm.internal.p.i(message, "message");
                if (AIEngineTtsEngine.S0(i11, atomicInteger)) {
                    Log.i("AIEngineTts", "stale stream cancelled ignored code=" + code + " epoch=" + i11);
                    return;
                }
                Log.i("AIEngineTts", "stream tts cancelled code=" + code + ", message=" + message);
                kotlinx.coroutines.g gVar = ref$ObjectRef.f34820a;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                qVar.c();
                this.this$0.j(ttsListener, i10, "onCancelled(" + code + ")");
            }

            @Override // com.stepos.aiengine.algorithm.tts.TtsStreamListener
            public void onClosed() {
                if (AIEngineTtsEngine.S0(i11, atomicInteger)) {
                    return;
                }
                Log.i("AIEngineTts", "stream input closed generation=" + i10 + " receivedChunks=" + this.this$0.audioChunkSequence.get() + " fedChars=" + this.this$0.totalFedChars.get());
                AIEngineTtsEngine.T0(ref$ObjectRef, atomicInteger, this.this$0, i10, atomicBoolean, ref$ObjectRef2, ttsListener, "onClosed");
            }

            @Override // com.stepos.aiengine.algorithm.tts.TtsStreamListener
            public void onComplete() {
                if (AIEngineTtsEngine.S0(i11, atomicInteger)) {
                    return;
                }
                kotlinx.coroutines.g gVar = ref$ObjectRef.f34820a;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                l lVar = l.INSTANCE;
                long jM = lVar.m(this.this$0.totalPcmBytesReceived.get(), this.this$0.pcmSampleRate.get(), this.this$0.pcmChannelCount.get(), this.this$0.pcmBytesPerSample.get());
                if (lVar.f(this.this$0.totalFedChars.get(), jM, this.this$0.j0(), qVar.i() > 0)) {
                    Log.w("AIEngineTts", "onComplete looks truncated generation=" + i10 + " fedChars=" + this.this$0.totalFedChars.get() + " pcmMs=" + jM + " lastAudioAgeMs=" + this.this$0.j0() + " queued=" + qVar.i());
                    if (ref$ObjectRef2.f34820a.invoke("onComplete-truncated").booleanValue()) {
                        return;
                    }
                }
                this.this$0.r0(ttsListener, i10, "onComplete");
            }

            @Override // com.stepos.aiengine.algorithm.tts.TtsStreamListener
            public void onError(int errorCode, String message) {
                kotlin.jvm.internal.p.i(message, "message");
                if (AIEngineTtsEngine.S0(i11, atomicInteger)) {
                    Log.i("AIEngineTts", "stale stream error ignored code=" + errorCode + " epoch=" + i11);
                    return;
                }
                Log.e("AIEngineTts", "stream tts error code=" + errorCode + ", message=" + message + " chunks=" + this.this$0.audioChunkSequence.get() + " fedChars=" + this.this$0.totalFedChars.get() + " handlerPending=" + qVar.i());
                kotlinx.coroutines.g gVar = ref$ObjectRef.f34820a;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                if (ref$ObjectRef2.f34820a.invoke("onError(" + errorCode + ")").booleanValue()) {
                    return;
                }
                this.this$0.cancelled.set(true);
                atomicBoolean2.set(true);
                qVar.c();
                C1060i.d(this.this$0.scope, Y.c(), null, new AIEngineTtsEngine$startStream$openCloudSession$1$onError$1(ttsListener, errorCode, message, null), 2, null);
                if (this.this$0.audioChunkSequence.get() > 0) {
                    this.this$0.r0(ttsListener, i10, "onError(" + errorCode + ")");
                    return;
                }
                this.this$0.j(ttsListener, i10, "onError(" + errorCode + ")");
            }

            @Override // com.stepos.aiengine.algorithm.tts.TtsStreamListener
            public void onOpened() {
                if (AIEngineTtsEngine.S0(i11, atomicInteger)) {
                    return;
                }
                this.this$0.sessionOpenedAtMs.compareAndSet(0L, SystemClock.elapsedRealtime());
                int i12 = i10;
                int i13 = i11;
                AIEngineTtsEngine aIEngineTtsEngine2 = this.this$0;
                Log.i("AIEngineTts", "stream session opened generation=" + i12 + " epoch=" + i13 + " openDelayMs=" + aIEngineTtsEngine2.p0(aIEngineTtsEngine2.sessionOpenedAtMs.get()));
                this.this$0.sessionOpened.set(true);
                qVar.g(true);
            }

            @Override // com.stepos.aiengine.algorithm.tts.TtsStreamListener
            public void onRoutingDecision(String executionLocation, String reason) {
                kotlin.jvm.internal.p.i(executionLocation, "executionLocation");
                kotlin.jvm.internal.p.i(reason, "reason");
                Log.d("AIEngineTts", "stream tts route=" + executionLocation + ", reason=" + reason);
            }
        });
    }

    public static final boolean S0(int i10, AtomicInteger atomicInteger) {
        return i10 != atomicInteger.get();
    }

    /* JADX WARN: Type inference failed for: r14v3, types: [T, kotlinx.coroutines.g] */
    public static final void T0(Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, AtomicInteger atomicInteger, AIEngineTtsEngine aIEngineTtsEngine, int i10, AtomicBoolean atomicBoolean, Ref$ObjectRef<InterfaceC5074l<String, Boolean>> ref$ObjectRef2, TtsListener ttsListener, String str) {
        kotlinx.coroutines.g gVar = ref$ObjectRef.f34820a;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        ref$ObjectRef.f34820a = C1060i.d(aIEngineTtsEngine.scope, null, null, new AIEngineTtsEngine$startStream$scheduleCompleteTimeout$1(i10, aIEngineTtsEngine, atomicInteger.get(), atomicInteger, atomicBoolean, str, ref$ObjectRef2, ttsListener, null), 3, null);
    }

    public static final boolean U0(AIEngineTtsEngine aIEngineTtsEngine, int i10, AtomicInteger atomicInteger, q qVar, AtomicLong atomicLong, AtomicInteger atomicInteger2, Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicBoolean atomicBoolean3, Ref$ObjectRef<ITtsStreamSession> ref$ObjectRef2, TtsListener ttsListener, Ref$ObjectRef<InterfaceC5063a<ITtsStreamSession>> ref$ObjectRef3, String str) {
        String str2;
        String strE0;
        String strR1;
        String strE02;
        if (aIEngineTtsEngine.cancelled.get() || i10 != aIEngineTtsEngine.streamGeneration.get()) {
            return false;
        }
        if (aIEngineTtsEngine.finishHandledGeneration == i10) {
            return false;
        }
        if (atomicInteger.get() >= 3) {
            Log.w(TAG, "tts resume exhausted generation=" + i10 + " reason=" + str + " attempts=" + atomicInteger.get());
            return false;
        }
        if (!I.INSTANCE.b(aIEngineTtsEngine.context)) {
            Log.w(TAG, "tts resume skipped: network unusable generation=" + i10 + " reason=" + str);
            return false;
        }
        l lVar = l.INSTANCE;
        long jM = lVar.m(aIEngineTtsEngine.totalPcmBytesReceived.get(), aIEngineTtsEngine.pcmSampleRate.get(), aIEngineTtsEngine.pcmChannelCount.get(), aIEngineTtsEngine.pcmBytesPerSample.get());
        long j10 = aIEngineTtsEngine.totalFedChars.get();
        synchronized (aIEngineTtsEngine.feedLock) {
            str2 = (String) F.E0(aIEngineTtsEngine.connFedBatches);
        }
        boolean zI = str2 != null ? o.INSTANCE.i(str2) : true;
        if (qVar.i() == 0 && zI && lVar.q(j10, jM)) {
            long jO0 = aIEngineTtsEngine.o0();
            int length = str2 != null ? str2.length() : 0;
            boolean zI2 = str2 != null ? o.INSTANCE.i(str2) : false;
            if (str2 == null || (strE02 = aIEngineTtsEngine.E0(str2)) == null) {
                strE02 = "";
            }
            Log.i(TAG, "tts resume skipped: audio already covers text generation=" + i10 + " reason=" + str + " fedChars=" + j10 + " pcmMs=" + jM + " paceMs=" + jO0 + " lastLen=" + length + " lastCommit=" + zI2 + " last=[" + strE02 + "]");
            return false;
        }
        int iC = lVar.c(jM, aIEngineTtsEngine.o0());
        synchronized (aIEngineTtsEngine.feedLock) {
            try {
                ArrayList<String> arrayList = aIEngineTtsEngine.connFedBatches;
                ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Integer.valueOf(((String) it.next()).length()));
                }
                int iN = lVar.n(arrayList2, iC);
                ArrayList<String> arrayList3 = aIEngineTtsEngine.connFedBatches;
                List<String> listSubList = arrayList3.subList(iN, arrayList3.size());
                kotlin.jvm.internal.p.h(listSubList, "subList(...)");
                List<String> listM1 = F.m1(listSubList);
                if (listM1.isEmpty() && qVar.i() <= 0) {
                    Log.i(TAG, "tts resume not needed generation=" + i10 + " reason=" + str + ": nothing left to speak");
                    return false;
                }
                atomicBoolean3.set(true);
                aIEngineTtsEngine.sessionOpened.set(false);
                ITtsStreamSession iTtsStreamSession = ref$ObjectRef2.f34820a;
                ref$ObjectRef2.f34820a = null;
                t tVar = t.f7040a;
                int iIncrementAndGet = atomicInteger.incrementAndGet();
                atomicLong.set(SystemClock.elapsedRealtime());
                int iIncrementAndGet2 = atomicInteger2.incrementAndGet();
                kotlinx.coroutines.g gVar = ref$ObjectRef.f34820a;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                atomicBoolean.set(false);
                long j11 = aIEngineTtsEngine.totalFedChars.get();
                int size = listM1.size();
                Iterator<T> it2 = listM1.iterator();
                int length2 = 0;
                while (it2.hasNext()) {
                    length2 += ((String) it2.next()).length();
                }
                int i11 = qVar.i();
                boolean z10 = atomicBoolean2.get();
                boolean zE = qVar.getEndConsumed();
                String str3 = (String) F.s0(listM1);
                if (str3 == null || (strR1 = K.R1(str3, 40)) == null || (strE0 = aIEngineTtsEngine.E0(strR1)) == null) {
                    strE0 = "";
                }
                Log.w(TAG, "tts resume#" + iIncrementAndGet + " generation=" + i10 + " reason=" + str + " epoch=" + iIncrementAndGet2 + " fedChars=" + j11 + " pcmMs=" + jM + " spokenEst=" + iC + " replayBatches=" + size + " replayChars=" + length2 + " queued=" + i11 + " inputClosed=" + z10 + " endConsumed=" + zE + " replayHead=[" + strE0 + "]");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    ITtsStreamSession iTtsStreamSession2 = iTtsStreamSession;
                    Result.b(iTtsStreamSession2 != null ? Boolean.valueOf(iTtsStreamSession2.cancel()) : null);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                aIEngineTtsEngine.D0();
                qVar.n(listM1);
                if (qVar.getEndConsumed()) {
                    qVar.m();
                }
                C1060i.d(aIEngineTtsEngine.scope, null, null, new AIEngineTtsEngine$startStream$tryResume$5(aIEngineTtsEngine, i10, iIncrementAndGet2, atomicInteger2, iIncrementAndGet, ttsListener, qVar, ref$ObjectRef3, ref$ObjectRef2, atomicBoolean3, null), 3, null);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static /* synthetic */ String W0(AIEngineTtsEngine aIEngineTtsEngine, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 8;
        }
        return aIEngineTtsEngine.V0(str, i10);
    }

    public final void A0() {
        this.screenOff.set(true);
        this.screenOffAtMs.set(SystemClock.elapsedRealtime());
        int i10 = this.streamGeneration.get();
        Log.i(TAG, "screenOff observed generation=" + i10 + " speaking=" + this.speaking.get() + " receivedChunks=" + this.audioChunkSequence.get() + " fedChars=" + this.totalFedChars.get());
        G0(i10, "screenOff");
    }

    public final void B0() {
        long jElapsedRealtime;
        Long lValueOf = Long.valueOf(this.screenOffAtMs.get());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            jElapsedRealtime = SystemClock.elapsedRealtime() - lValueOf.longValue();
        } else {
            jElapsedRealtime = -1;
        }
        this.screenOff.set(false);
        this.screenOffAtMs.set(0L);
        Log.i(TAG, "screenOn observed offDurationMs=" + jElapsedRealtime + " generation=" + this.streamGeneration.get());
        k0("screenOn");
    }

    public final void C0(int sequence, long gapMs) {
        long j10;
        if (gapMs <= 0) {
            return;
        }
        do {
            j10 = this.maxAudioChunkGapMs.get();
            if (gapMs <= j10) {
                return;
            }
        } while (!this.maxAudioChunkGapMs.compareAndSet(j10, gapMs));
        this.maxAudioChunkGapSeq.set(sequence);
    }

    public final void D0() {
        synchronized (this.feedLock) {
            this.connFedBatches.clear();
            t tVar = t.f7040a;
        }
        this.totalFedChars.set(0L);
        this.totalPcmBytesReceived.set(0L);
        this.firstFeedAtMs.set(0L);
        this.firstAudioAtMs.set(0L);
        this.lastAudioChunkAtMs.set(0L);
        this.firstFeedAfterAudioMs.set(0L);
        this.sessionOpenedAtMs.set(0L);
    }

    public final String E0(String str) {
        return D.T(D.T(D.T(str, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null), "\"", "'", false, 4, null);
    }

    public final String F0(String text) {
        r rVar = new r();
        return rVar.a(j.INSTANCE.a(text)) + rVar.l();
    }

    public final void G0(int generation, String from) {
        if (this.screenOff.get()) {
            if (w0()) {
                kotlinx.coroutines.g gVar = this.screenOffDisconnectJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                this.screenOffDisconnectJob = C1060i.d(this.scope, null, null, new AIEngineTtsEngine$scheduleScreenOffDisconnect$1(this, generation, from, null), 3, null);
                Log.i(TAG, "screenOff disconnect scheduled generation=" + generation + " delayMs=5000 from=" + from);
                return;
            }
            boolean z10 = this.speaking.get();
            boolean z11 = this.streamSession != null;
            boolean z12 = this.textHandler != null;
            boolean z13 = this.finishStreamJob != null;
            Log.i(TAG, "screenOff disconnect skipped generation=" + generation + " from=" + from + " reason=noActiveTts speaking=" + z10 + " stream=" + z11 + " handler=" + z12 + " finishing=" + z13 + " pcmPlaying=" + this.pcmPlayer.j());
        }
    }

    public final String H0() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.streamStartedAtMs.get();
        long j11 = this.sessionOpenedAtMs.get();
        long j12 = this.firstFeedAtMs.get();
        long j13 = this.firstAudioAtMs.get();
        long j14 = -1;
        long j15 = j10 > 0 ? jElapsedRealtime - j10 : -1L;
        long j16 = (j10 <= 0 || j11 < j10) ? -1L : j11 - j10;
        long j17 = (j10 <= 0 || j12 < j10) ? -1L : j12 - j10;
        if (j10 > 0 && j13 >= j10) {
            j14 = j13 - j10;
        }
        return "durationMs=" + j15 + " openDelayMs=" + j16 + " firstFeedDelayMs=" + j17 + " firstAudioDelayMs=" + j14;
    }

    public final long I0() {
        long j10 = this.firstFeedAfterAudioMs.get();
        if (j10 == 0) {
            return Long.MAX_VALUE;
        }
        return C5685n.g(SystemClock.elapsedRealtime() - j10, 0L);
    }

    public final void J0(int generation, q handler, InterfaceC5063a<Long> sinceResumeMs, InterfaceC5074l<? super String, Boolean> tryResume) {
        kotlinx.coroutines.g gVar = this.stallWatchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.stallWatchJob = C1060i.d(this.scope, null, null, new AIEngineTtsEngine$startStallWatch$1(generation, this, handler, sinceResumeMs, tryResume, null), 3, null);
    }

    public final String V0(String text, int edge) {
        if (text.length() == 0) {
            return "head= tail=";
        }
        String strL = new Regex("\\s+").l(text, " ");
        String strR1 = K.R1(strL, edge);
        String strS1 = K.S1(strL, edge);
        return "head=" + E0(strR1) + " tail=" + E0(strS1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X0(int r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$waitForStreamAudioQuiet$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$waitForStreamAudioQuiet$1 r0 = (com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$waitForStreamAudioQuiet$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$waitForStreamAudioQuiet$1 r0 = new com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$waitForStreamAudioQuiet$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L28
            int r13 = r0.I$0
            goto L30
        L28:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L30:
            kotlin.C4849c.b(r14)
        L33:
            java.util.concurrent.atomic.AtomicInteger r14 = r12.streamGeneration
            int r14 = r14.get()
            if (r13 != r14) goto L6e
            java.util.concurrent.atomic.AtomicLong r14 = r12.lastAudioChunkAtMs
            long r4 = r14.get()
            r6 = 0
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 != 0) goto L4a
            Y8.t r12 = Y8.t.f7040a
            return r12
        L4a:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = r6 - r4
            r8 = 2000(0x7d0, double:9.88E-321)
            int r14 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r14 < 0) goto L58
            Y8.t r12 = Y8.t.f7040a
            return r12
        L58:
            long r8 = r8 - r6
            r10 = 50
            long r8 = v9.C5685n.g(r8, r10)
            r0.I$0 = r13
            r0.J$0 = r4
            r0.J$1 = r6
            r0.label = r3
            java.lang.Object r14 = Ua.U.a(r8, r0)
            if (r14 != r1) goto L33
            return r1
        L6e:
            Y8.t r12 = Y8.t.f7040a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.AIEngineTtsEngine.X0(int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01a5 -> B:41:0x01a8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y0(int r26, p9.InterfaceC5063a<java.lang.Boolean> r27, e9.InterfaceC4014c<? super Y8.t> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 435
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.AIEngineTtsEngine.Y0(int, p9.a, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public boolean a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        boolean zX0 = x0(context);
        Log.i(TAG, "isAvailable stream=" + zX0);
        return zX0;
    }

    /* JADX WARN: Type inference failed for: r0v49, types: [T, com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStream$2] */
    /* JADX WARN: Type inference failed for: r0v52, types: [T, com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$startStream$5] */
    /* JADX WARN: Type inference failed for: r0v56, types: [T, com.stepos.aiengine.algorithm.tts.ITtsStreamSession] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, com.stepos.ailauncher.speech.tts.a] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, com.stepos.ailauncher.speech.tts.AIEngineTtsEngine$d] */
    @Override // com.stepos.ailauncher.speech.tts.i
    public TtsStreamSession b(TtsListener listener) {
        final AIEngineTtsEngine aIEngineTtsEngine = this;
        TtsListener ttsListener = listener;
        if (!aIEngineTtsEngine.x0(aIEngineTtsEngine.context)) {
            if (ttsListener != null) {
                ttsListener.onPlayStopped();
            }
            return null;
        }
        aIEngineTtsEngine.stop();
        final int iIncrementAndGet = aIEngineTtsEngine.streamGeneration.incrementAndGet();
        aIEngineTtsEngine.speaking.set(true);
        aIEngineTtsEngine.cancelled.set(false);
        aIEngineTtsEngine.lastAudioChunkAtMs.set(0L);
        aIEngineTtsEngine.firstFeedAfterAudioMs.set(0L);
        aIEngineTtsEngine.streamStartedAtMs.set(SystemClock.elapsedRealtime());
        aIEngineTtsEngine.sessionOpenedAtMs.set(0L);
        aIEngineTtsEngine.firstFeedAtMs.set(0L);
        aIEngineTtsEngine.firstAudioAtMs.set(0L);
        aIEngineTtsEngine.maxAudioChunkGapMs.set(0L);
        aIEngineTtsEngine.maxAudioChunkGapSeq.set(0);
        aIEngineTtsEngine.feedTextCount.set(0);
        aIEngineTtsEngine.feedRejectedCount.set(0);
        aIEngineTtsEngine.audioChunkSequence.set(0);
        aIEngineTtsEngine.totalPcmBytesReceived.set(0L);
        aIEngineTtsEngine.totalFedChars.set(0L);
        aIEngineTtsEngine.learnedMsPerChar.set(0L);
        aIEngineTtsEngine.pcmSampleRate.set(DEFAULT_PCM_SAMPLE_RATE);
        aIEngineTtsEngine.pcmChannelCount.set(1);
        aIEngineTtsEngine.pcmBytesPerSample.set(2);
        aIEngineTtsEngine.sessionOpened.set(false);
        aIEngineTtsEngine.playStartedNotified.set(false);
        synchronized (aIEngineTtsEngine.feedLock) {
            aIEngineTtsEngine.connFedBatches.clear();
            t tVar = t.f7040a;
        }
        q qVar = aIEngineTtsEngine.textHandler;
        if (qVar != null) {
            qVar.c();
        }
        aIEngineTtsEngine.textHandler = null;
        kotlinx.coroutines.g gVar = aIEngineTtsEngine.finishStreamJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        aIEngineTtsEngine.finishStreamJob = null;
        aIEngineTtsEngine.finishHandledGeneration = -1;
        aIEngineTtsEngine.activeStreamListener = ttsListener;
        try {
            ITtsStreaming iTtsStreaming = (ITtsStreaming) AlgorithmClient.loadAlgorithm$default(AlgorithmClients.INSTANCE.getTtsStream(), aIEngineTtsEngine.context, null, 2, null);
            Bundle bundleM0 = aIEngineTtsEngine.m0();
            Log.i(TAG, "startStream generation=" + iIncrementAndGet + " voice=" + bundleM0.getString(PARAM_VOICE) + " speed=" + bundleM0.getFloat(PARAM_SPEED) + " volume=" + bundleM0.getFloat(PARAM_VOLUME) + " mode=" + bundleM0.getString(PARAM_MODE) + " trace_id=" + bundleM0.getString("trace_id"));
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            r rVar = new r();
            j jVar = new j();
            Object obj = new Object();
            try {
                AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                final AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
                final AtomicLong atomicLong = new AtomicLong(0L);
                final AtomicBoolean atomicBoolean4 = new AtomicBoolean(false);
                final AtomicLong atomicLong2 = new AtomicLong(0L);
                AtomicLong atomicLong3 = new AtomicLong(0L);
                final AtomicInteger atomicInteger = new AtomicInteger(0);
                AtomicInteger atomicInteger2 = new AtomicInteger(0);
                try {
                    final AtomicLong atomicLong4 = new AtomicLong(0L);
                    final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                    ref$ObjectRef3.f34820a = new InterfaceC5074l() { // from class: com.stepos.ailauncher.speech.tts.a
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(AIEngineTtsEngine.N0((String) obj2));
                        }
                    };
                    Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                    ref$ObjectRef4.f34820a = d.INSTANCE;
                    String str = TAG;
                    aIEngineTtsEngine = this;
                    try {
                        InterfaceC5074l interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.speech.tts.b
                            @Override // p9.InterfaceC5074l
                            public final Object invoke(Object obj2) {
                                return Boolean.valueOf(AIEngineTtsEngine.O0(this.f28331a, atomicBoolean, iIncrementAndGet, ref$ObjectRef, atomicBoolean4, atomicLong, (String) obj2));
                            }
                        };
                        try {
                            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.speech.tts.c
                                @Override // p9.InterfaceC5063a
                                public final Object invoke() {
                                    return AIEngineTtsEngine.P0(iIncrementAndGet, this, atomicInteger, atomicBoolean3, ref$ObjectRef);
                                }
                            };
                            iIncrementAndGet = iIncrementAndGet;
                            aIEngineTtsEngine = this;
                            q qVar2 = new q(str, 80, 100L, interfaceC5074l, interfaceC5063a, new InterfaceC5063a() { // from class: com.stepos.ailauncher.speech.tts.d
                                @Override // p9.InterfaceC5063a
                                public final Object invoke() {
                                    return Integer.valueOf(AIEngineTtsEngine.Q0(this.f28342a, iIncrementAndGet, atomicLong2, atomicLong, atomicBoolean4));
                                }
                            }, 0L, 0, 0L, 448, null);
                            qVar2.q();
                            aIEngineTtsEngine.textHandler = qVar2;
                            try {
                                ref$ObjectRef3.f34820a = new AIEngineTtsEngine$startStream$2(aIEngineTtsEngine, iIncrementAndGet, atomicInteger2, qVar2, atomicLong4, atomicInteger, ref$ObjectRef2, atomicBoolean3, atomicBoolean2, atomicBoolean, ref$ObjectRef, listener, ref$ObjectRef4);
                                aIEngineTtsEngine.J0(iIncrementAndGet, qVar2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.speech.tts.e
                                    @Override // p9.InterfaceC5063a
                                    public final Object invoke() {
                                        return Long.valueOf(AIEngineTtsEngine.L0(atomicLong4));
                                    }
                                }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.speech.tts.f
                                    @Override // p9.InterfaceC5074l
                                    public final Object invoke(Object obj2) {
                                        return Boolean.valueOf(AIEngineTtsEngine.M0(ref$ObjectRef3, (String) obj2));
                                    }
                                });
                                try {
                                    ?? aIEngineTtsEngine$startStream$5 = new AIEngineTtsEngine$startStream$5(atomicInteger, iTtsStreaming, bundleM0, this, iIncrementAndGet, qVar2, atomicInteger2, listener, ref$ObjectRef2, atomicBoolean3, ref$ObjectRef3, atomicBoolean);
                                    iIncrementAndGet = iIncrementAndGet;
                                    ref$ObjectRef4.f34820a = aIEngineTtsEngine$startStream$5;
                                    ttsListener = listener;
                                    try {
                                        ?? R02 = R0(atomicInteger, iTtsStreaming, bundleM0, this, iIncrementAndGet, qVar2, atomicInteger2, ttsListener, ref$ObjectRef2, atomicBoolean3, ref$ObjectRef3, atomicBoolean);
                                        ref$ObjectRef.f34820a = R02;
                                        ITtsStreamSession iTtsStreamSession = (ITtsStreamSession) R02;
                                        if (iTtsStreamSession == null) {
                                            qVar2.c();
                                            this.textHandler = null;
                                            r0(ttsListener, iIncrementAndGet, "openSessionNull");
                                            return null;
                                        }
                                        this.streamSession = iTtsStreamSession;
                                        if (this.screenOff.get()) {
                                            G0(iIncrementAndGet, "startStreamWhileScreenOff");
                                        }
                                        try {
                                            return new c(obj, atomicBoolean2, this, rVar, jVar, qVar2, atomicLong3, iIncrementAndGet, iTtsStreamSession, ref$ObjectRef2, ttsListener, ref$ObjectRef, atomicBoolean);
                                        } catch (Exception e10) {
                                            e = e10;
                                            aIEngineTtsEngine = this;
                                            iIncrementAndGet = iIncrementAndGet;
                                            ttsListener = ttsListener;
                                            Log.e(TAG, "startStream failed", e);
                                            aIEngineTtsEngine.r0(ttsListener, iIncrementAndGet, "startException");
                                            return null;
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        aIEngineTtsEngine = this;
                                        iIncrementAndGet = iIncrementAndGet;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    aIEngineTtsEngine = this;
                                    iIncrementAndGet = iIncrementAndGet;
                                    ttsListener = listener;
                                }
                            } catch (Exception e13) {
                                e = e13;
                                ttsListener = listener;
                            }
                        } catch (Exception e14) {
                            e = e14;
                            iIncrementAndGet = iIncrementAndGet;
                            aIEngineTtsEngine = this;
                            ttsListener = listener;
                            Log.e(TAG, "startStream failed", e);
                            aIEngineTtsEngine.r0(ttsListener, iIncrementAndGet, "startException");
                            return null;
                        }
                    } catch (Exception e15) {
                        e = e15;
                        ttsListener = listener;
                        iIncrementAndGet = iIncrementAndGet;
                    }
                } catch (Exception e16) {
                    e = e16;
                    aIEngineTtsEngine = this;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public void c(float gain) {
        this.pcmPlayer.x(gain);
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public void destroy() {
        stop();
        J.INSTANCE.h(this.screenStateListener);
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            AlgorithmClients.INSTANCE.getTtsStream().releaseAlgorithm(this.context, true);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public final byte[] i0(byte[] data) {
        float fM = C5685n.m(v0(), 0.0f, 1.0f);
        if (fM >= 0.99f) {
            return data;
        }
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        kotlin.jvm.internal.p.h(bArrCopyOf, "copyOf(...)");
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i11 >= bArrCopyOf.length) {
                return bArrCopyOf;
            }
            int iN = C5685n.n((int) (((short) ((bArrCopyOf[i11] << 8) | (bArrCopyOf[i10] & 255))) * fM), -32768, 32767);
            bArrCopyOf[i10] = (byte) (iN & 255);
            bArrCopyOf[i11] = (byte) ((iN >> 8) & 255);
            i10 += 2;
        }
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public boolean isSpeaking() {
        return this.speaking.get();
    }

    public final void j(TtsListener listener, int generation, String reason) {
        if (generation != this.streamGeneration.get()) {
            Log.i(TAG, "abortStream ignored reason=" + reason + " generation=" + generation);
            return;
        }
        this.speaking.set(false);
        this.streamSession = null;
        q qVar = this.textHandler;
        if (qVar != null) {
            qVar.c();
        }
        this.textHandler = null;
        kotlinx.coroutines.g gVar = this.finishStreamJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.finishStreamJob = null;
        l0();
        this.finishHandledGeneration = generation;
        this.activeStreamListener = null;
        k0("abortStream");
        this.pcmPlayer.A();
        try {
            Result.Companion companion = Result.INSTANCE;
            AlgorithmClients.INSTANCE.getTtsStream().releaseAlgorithm(this.context, false);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        Log.i(TAG, "abortStream reason=" + reason + " generation=" + generation);
        C1060i.d(this.scope, Y.c(), null, new AIEngineTtsEngine$abortStream$2(listener, null), 2, null);
    }

    public final long j0() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j10 = this.lastAudioChunkAtMs.get();
        if (j10 > 0) {
            return jElapsedRealtime - j10;
        }
        long j11 = this.firstFeedAtMs.get();
        if (j11 > 0) {
            return jElapsedRealtime - j11;
        }
        long j12 = this.sessionOpenedAtMs.get();
        if (j12 > 0) {
            return jElapsedRealtime - j12;
        }
        return -1L;
    }

    public final void k0(String from) {
        kotlinx.coroutines.g gVar = this.screenOffDisconnectJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.screenOffDisconnectJob = null;
        Log.d(TAG, "screenOff disconnect cancelled from=" + from);
    }

    public final void l0() {
        kotlinx.coroutines.g gVar = this.stallWatchJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.stallWatchJob = null;
    }

    public final Bundle m0() {
        Bundle bundle = new Bundle();
        String strF = C0919o.f();
        if (kotlin.jvm.internal.p.d(strF, O6.l.DATE_SEPARATOR)) {
            strF = null;
        }
        if (strF == null) {
            strF = "";
        }
        bundle.putString(PARAM_VOICE, u0());
        bundle.putFloat(PARAM_SPEED, 1.0f);
        bundle.putFloat(PARAM_VOLUME, v0());
        bundle.putString(PARAM_MODE, TTS_MODE_CONVERSATION);
        bundle.putString("trace_id", strF);
        return bundle;
    }

    public final long n0() {
        y0();
        return l.INSTANCE.b(this.totalFedChars.get(), this.totalPcmBytesReceived.get(), this.pcmSampleRate.get(), this.pcmChannelCount.get(), this.pcmBytesPerSample.get(), o0());
    }

    public final long o0() {
        Long lValueOf = Long.valueOf(this.learnedMsPerChar.get());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 180L;
    }

    public final long p0(long timestampMs) {
        long j10 = this.streamStartedAtMs.get();
        if (j10 <= 0 || timestampMs < j10) {
            return -1L;
        }
        return timestampMs - j10;
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public void pause() {
        this.pcmPlayer.h();
    }

    public final boolean q0(ITtsStreamSession session, int generation, String text) {
        Object objB;
        if (text.length() > 80) {
            Log.e(TAG, "unexpected oversize feedText=" + text.length() + " generation=" + generation + " max=80");
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(session.feedText(text)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(TAG, "feedText failed generation=" + generation + " length=" + text.length() + " hash=" + text.hashCode(), thE);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        boolean zBooleanValue = ((Boolean) objB).booleanValue();
        if (zBooleanValue) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.firstFeedAtMs.compareAndSet(0L, jElapsedRealtime);
            long j10 = this.lastAudioChunkAtMs.get();
            if (j10 > 0 && jElapsedRealtime >= j10) {
                this.firstFeedAfterAudioMs.compareAndSet(0L, jElapsedRealtime);
            }
            this.feedTextCount.incrementAndGet();
            this.connFedBatches.add(text);
            long jAddAndGet = this.totalFedChars.addAndGet(text.length());
            int length = text.length();
            o oVar = o.INSTANCE;
            Log.i(TAG, "feedText generation=" + generation + " len=" + length + " fedChars=" + jAddAndGet + " commitUnit=" + oVar.i(text) + " sentenceEnd=" + oVar.j(text) + " text=[" + E0(text) + "]");
        } else {
            this.feedRejectedCount.incrementAndGet();
            Log.w(TAG, "feedText rejected generation=" + generation + " length=" + text.length() + " hash=" + text.hashCode() + " " + W0(this, text, 0, 2, null));
        }
        return zBooleanValue;
    }

    public final void r0(TtsListener listener, int generation, String reason) {
        if (generation != this.streamGeneration.get()) {
            Log.i(TAG, "finishStream ignored reason=" + reason + " generation=" + generation);
            return;
        }
        synchronized (this) {
            if (this.finishHandledGeneration == generation) {
                Log.i(TAG, "finishStream duplicate ignored reason=" + reason + " generation=" + generation);
                return;
            }
            this.finishHandledGeneration = generation;
            t tVar = t.f7040a;
            this.speaking.set(false);
            Log.i(TAG, "finishStream start reason=" + reason + " generation=" + generation + " receivedChunks=" + this.audioChunkSequence.get() + " fedChars=" + this.totalFedChars.get() + " pcmBytes=" + this.totalPcmBytesReceived.get() + " lastAudioAgeMs=" + j0() + " maxAudioGapMs=" + this.maxAudioChunkGapMs.get() + " maxGapSeq=" + this.maxAudioChunkGapSeq.get());
            this.streamSession = null;
            l0();
            k0("finishStream");
            q qVar = this.textHandler;
            if (qVar != null) {
                qVar.c();
            }
            this.textHandler = null;
            kotlinx.coroutines.g gVar = this.finishStreamJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.finishStreamJob = C1060i.d(this.scope, null, null, new AIEngineTtsEngine$finishStream$2(this, generation, reason, listener, null), 3, null);
        }
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public void resume() {
        this.pcmPlayer.t();
    }

    public final void s0(int expectedGeneration, String from) {
        Object objB;
        if (!this.screenOff.get()) {
            Log.i(TAG, "screenOff timeout ignored: screen is on expectedGeneration=" + expectedGeneration + " from=" + from);
            return;
        }
        if (expectedGeneration != this.streamGeneration.get()) {
            Log.i(TAG, "screenOff timeout ignored: generation changed expected=" + expectedGeneration + " current=" + this.streamGeneration.get() + " from=" + from);
            return;
        }
        if (!w0()) {
            Log.i(TAG, "screenOff timeout no active tts generation=" + expectedGeneration + " from=" + from);
            return;
        }
        Long lValueOf = Long.valueOf(this.screenOffAtMs.get());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        long jElapsedRealtime = lValueOf != null ? SystemClock.elapsedRealtime() - lValueOf.longValue() : -1L;
        TtsListener ttsListener = this.activeStreamListener;
        Log.w(TAG, "screenOff timeout force disconnect generation=" + expectedGeneration + " from=" + from + " offDurationMs=" + jElapsedRealtime + " receivedChunks=" + this.audioChunkSequence.get() + " fedChars=" + this.totalFedChars.get() + " pcmBytes=" + this.totalPcmBytesReceived.get() + " pcmUnderruns=" + this.pcmPlayer.D() + " maxAudioGapMs=" + this.maxAudioChunkGapMs.get() + " maxGapSeq=" + this.maxAudioChunkGapSeq.get());
        this.cancelled.set(true);
        this.speaking.set(false);
        this.streamGeneration.incrementAndGet();
        q qVar = this.textHandler;
        if (qVar != null) {
            qVar.c();
        }
        this.textHandler = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            ITtsStreamSession iTtsStreamSession = this.streamSession;
            objB = Result.b(iTtsStreamSession != null ? Boolean.valueOf(iTtsStreamSession.cancel()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "screenOff timeout session.cancel failed", thE);
        }
        this.streamSession = null;
        kotlinx.coroutines.g gVar = this.finishStreamJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.finishStreamJob = null;
        l0();
        this.finishHandledGeneration = -1;
        this.activeStreamListener = null;
        this.screenOffDisconnectJob = null;
        this.pcmPlayer.A();
        try {
            AlgorithmClients.INSTANCE.getTtsStream().releaseAlgorithm(this.context, false);
            Result.b(t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
        C1060i.d(this.scope, Y.c(), null, new AIEngineTtsEngine$forceDisconnectForScreenOffTimeout$4(ttsListener, null), 2, null);
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public void speak(String text, TtsListener listener) {
        Object objB;
        kotlin.jvm.internal.p.i(text, "text");
        if (H.x0(F0(text))) {
            if (listener != null) {
                listener.onPlayStopped();
                return;
            }
            return;
        }
        TtsStreamSession ttsStreamSessionB = b(listener);
        if (ttsStreamSessionB == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ttsStreamSessionB.feedText(text);
            ttsStreamSessionB.close();
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.e(TAG, "speak via stream failed length=" + text.length(), thE);
            stop();
            C1060i.d(this.scope, Y.c(), null, new AIEngineTtsEngine$speak$2$1(listener, null), 2, null);
        }
    }

    @Override // com.stepos.ailauncher.speech.tts.i
    public void stop() {
        Log.i(TAG, "stop requested generation=" + this.streamGeneration.get() + " speaking=" + this.speaking.get() + " receivedChunks=" + this.audioChunkSequence.get());
        this.cancelled.set(true);
        this.speaking.set(false);
        this.streamGeneration.incrementAndGet();
        q qVar = this.textHandler;
        if (qVar != null) {
            qVar.c();
        }
        this.textHandler = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            ITtsStreamSession iTtsStreamSession = this.streamSession;
            Result.b(iTtsStreamSession != null ? Boolean.valueOf(iTtsStreamSession.cancel()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        this.streamSession = null;
        kotlinx.coroutines.g gVar = this.finishStreamJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.finishStreamJob = null;
        l0();
        this.finishHandledGeneration = -1;
        this.activeStreamListener = null;
        k0(com.stepos.ailauncher.chat.trace.g.ACTION_STOP);
        this.pcmPlayer.A();
        try {
            AlgorithmClients.INSTANCE.getTtsStream().releaseAlgorithm(this.context, false);
            Result.b(t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.b(C4849c.a(th2));
        }
    }

    public final int t0() {
        Object systemService = this.context.getSystemService("audio");
        if ((systemService instanceof AudioManager ? (AudioManager) systemService : null) == null) {
            return 100;
        }
        return C5685n.n((int) ((r4.getStreamVolume(3) * 100.0f) / C5685n.f(r4.getStreamMaxVolume(3), 1)), 0, 100);
    }

    public final String u0() {
        C5009a c5009a = C5009a.INSTANCE;
        String strT = C5009a.t(c5009a, "voice_setting_selected_voice_id", "", false, 4, null);
        if (strT != null && !H.x0(strT)) {
            return strT;
        }
        String strT2 = C5009a.t(c5009a, LEGACY_KEY_TTS_VOICE_ID, "", false, 4, null);
        return (strT2 == null || H.x0(strT2)) ? DEFAULT_VOICE_ID : strT2;
    }

    public final float v0() {
        return C5685n.m(C5685n.n(C5009a.g(C5009a.INSTANCE, "voice_setting_feedback_volume_sync_system", false, false, 4, null) ? t0() : C5009a.k(r0, "voice_setting_feedback_volume", 100, false, 4, null), 0, 100) / 100.0f, 0.0f, 1.0f);
    }

    public final boolean w0() {
        return (!this.speaking.get() && this.streamSession == null && this.textHandler == null && this.finishStreamJob == null && !this.pcmPlayer.j()) ? false : true;
    }

    public final boolean x0(Context context) {
        try {
            if (I.INSTANCE.b(context)) {
                return true;
            }
            AlgorithmClients algorithmClients = AlgorithmClients.INSTANCE;
            if (algorithmClients.getTtsStream().isSupported(context)) {
                return algorithmClients.getTtsStream().checkResources(context) == 1;
            }
            return false;
        } catch (Exception e10) {
            Log.w(TAG, "stream tts availability check failed", e10);
            return false;
        }
    }

    public final void y0() {
        if (this.learnedMsPerChar.get() > 0) {
            return;
        }
        l lVar = l.INSTANCE;
        long jM = lVar.m(this.totalPcmBytesReceived.get(), this.pcmSampleRate.get(), this.pcmChannelCount.get(), this.pcmBytesPerSample.get());
        long jI = lVar.i(this.totalFedChars.get(), jM, j0(), this.pcmPlayer.p(), (16 & 16) != 0 ? 0L : 0L);
        if (jI <= 0 || !this.learnedMsPerChar.compareAndSet(0L, jI)) {
            return;
        }
        Log.i(TAG, "tts pace learned msPerChar=" + jI + " generation=" + this.streamGeneration.get() + " fedChars=" + this.totalFedChars.get() + " pcmMs=" + jM + " idleMs=" + j0() + " playbackPendingMs=" + this.pcmPlayer.p());
    }

    public final int z0(int encoding) {
        if (encoding == 2 || encoding == 4) {
            return encoding;
        }
        return 2;
    }
}
