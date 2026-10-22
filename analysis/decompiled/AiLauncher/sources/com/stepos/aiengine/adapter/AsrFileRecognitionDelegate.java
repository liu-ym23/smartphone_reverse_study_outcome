package com.stepos.aiengine.adapter;

import La.C0953c;
import La.D;
import La.H;
import La.z;
import M5.b;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.M;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.stepos.aiengine.adapter.AsrFileRecognitionDelegate;
import com.stepos.aiengine.algorithm.asr.AsrAudioFile;
import com.stepos.aiengine.algorithm.asr.AsrFileRecognitionListener;
import com.stepos.aiengine.algorithm.asr.AsrFileRecognitionResult;
import com.stepos.aiengine.algorithm.asr.AsrSpeakerInfo;
import com.stepos.aiengine.algorithm.asr.AsrUtterance;
import com.stepos.aiengine.algorithm.asr.AsrWordInfo;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 D2\u00020\u0001:\u0002EDB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ5\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J9\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010$J%\u0010(\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\fH\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010,J'\u00100\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010-\u001a\u00020 2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002040\f2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b5\u00106J+\u0010:\u001a\u00020\u001d2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b:\u0010;J!\u0010?\u001a\u00020\"2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010C¨\u0006F"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrFileRecognitionDelegate;", "", "Lcom/stepos/core/AbilityHandle;", "handle", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "waitMsOverride", "<init>", "(Lcom/stepos/core/AbilityHandle;Lp9/l;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "files", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;", "listener", "args", "", "recognize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;Landroid/os/Bundle;)I", "audio", "f", "(Landroid/os/Bundle;)J", Const.INTENT_KEY_BACKGROUND_COMMAND, SingleFileBundle.KEY_FILE_DESCRIPTOR, "requestArgs", "Lcom/stepos/aiengine/adapter/AsrFileRecognitionDelegate$InferenceFileCallback;", "callback", "LY8/t;", "l", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;JLandroid/os/Bundle;Landroid/os/Bundle;Lcom/stepos/aiengine/adapter/AsrFileRecognitionDelegate$InferenceFileCallback;)V", "", "text", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Z", "Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;", "utterances", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;", Const.INTENT_KEY_UMID, "(JLjava/util/List;)Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;", "Lcom/stepos/core/data/AudioContent;", "c", "(Landroid/os/Bundle;)Lcom/stepos/core/data/AudioContent;", "json", "Ljava/util/concurrent/atomic/AtomicInteger;", "indexCounter", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(JLjava/lang/String;Ljava/util/concurrent/atomic/AtomicInteger;)Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;", "Lorg/json/JSONObject;", "uttObj", "Lcom/stepos/aiengine/algorithm/asr/AsrWordInfo;", "k", "(Lorg/json/JSONObject;)Ljava/util/List;", "Lcom/stepos/core/data/base/Content;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "audioBundle", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/core/data/base/Content;Landroid/os/Bundle;Landroid/os/Bundle;)V", "Lcom/stepos/core/data/ContentParams$Builder;", "builder", "bundle", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/core/data/ContentParams$Builder;Landroid/os/Bundle;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "Lp9/l;", "Companion", "InferenceFileCallback", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AsrFileRecognitionDelegate {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EVENT_DELTA = "asr.delta";
    public static final String EVENT_DONE = "asr.done";
    public static final String EVENT_RECOGNIZED = "asr.recognized";
    public static final String KEY_END_MS = "asr.segment.end_ms";
    public static final String KEY_EVENT_TYPE = "asr.event_type";
    public static final String KEY_SEGMENT_INDEX = "asr.segment.index";
    public static final String KEY_SPEAKER_ID = "asr.segment.speaker_id";
    public static final String KEY_START_MS = "asr.segment.start_ms";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<Bundle, Long> waitMsOverride;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eJ\u0018\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrFileRecognitionDelegate$Companion;", "", "<init>", "()V", "KEY_START_MS", "", "KEY_END_MS", "KEY_SPEAKER_ID", "KEY_EVENT_TYPE", "KEY_SEGMENT_INDEX", "EVENT_DELTA", "EVENT_RECOGNIZED", "EVENT_DONE", "BYTES_PER_MB", "", "SUBMIT_OVERHEAD_MS", "POLL_BASE_MS", "CLIENT_MARGIN_MS", "POLL_QUEUE_FACTOR", "POLL_CEILING_MS", "uploadMsFor", "sizeBytes", "pollMsFor", "segmentTimeMs", "params", "Lcom/stepos/core/data/ContentParams;", "primaryKey", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final long pollMsFor(long sizeBytes) {
            return Math.min(7200000L, Math.max(600000L, uploadMsFor(sizeBytes) * 2));
        }

        public final long segmentTimeMs(ContentParams params, String primaryKey) {
            p.i(primaryKey, "primaryKey");
            if (params == null) {
                return 0L;
            }
            long j10 = params.getLong(primaryKey, 0L);
            if (j10 > 0) {
                return j10;
            }
            return params.getLong(p.d(primaryKey, "asr.segment.start_ms") ? "start_time" : "end_time", 0L);
        }

        public final long uploadMsFor(long sizeBytes) {
            return 1000 * (sizeBytes <= 4194304 ? 30L : sizeBytes <= 8388608 ? 60L : sizeBytes <= 41943040 ? 300L : sizeBytes <= 83886080 ? 600L : sizeBytes <= 167772160 ? 1200L : sizeBytes <= 251658240 ? ReportUtil.BIGSHIFT_VALIDTIME : sizeBytes <= 377487360 ? 2700L : sizeBytes <= 503316480 ? 3600L : 4500L);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bb\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrFileRecognitionDelegate$InferenceFileCallback;", "", "Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;", "utterance", "LY8/t;", "onRecognizing", "(Lcom/stepos/aiengine/algorithm/asr/AsrUtterance;)V", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;", "result", "onRecognized", "(Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionResult;)V", "", "errorCode", "", "message", "onError", "(ILjava/lang/String;)V", "onCancelled", "()V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface InferenceFileCallback {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onRoutingDecision(InferenceFileCallback inferenceFileCallback, String executionLocation, String reason) {
                p.i(executionLocation, "executionLocation");
                p.i(reason, "reason");
            }
        }

        void onCancelled();

        void onError(int errorCode, String message);

        void onRecognized(AsrFileRecognitionResult result);

        void onRecognizing(AsrUtterance utterance);

        void onRoutingDecision(String executionLocation, String reason);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsrFileRecognitionDelegate(AbilityHandle handle, InterfaceC5074l<? super Bundle, Long> interfaceC5074l) {
        p.i(handle, "handle");
        this.handle = handle;
        this.waitMsOverride = interfaceC5074l;
    }

    public static final CharSequence e(AsrUtterance it) {
        p.i(it, "it");
        return it.getText();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(java.util.concurrent.atomic.AtomicInteger r27, java.lang.StringBuilder r28, kotlin.jvm.internal.Ref$LongRef r29, kotlin.jvm.internal.Ref$LongRef r30, kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r31, com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.InferenceFileCallback r32, long r33, java.util.List<com.stepos.aiengine.algorithm.asr.AsrUtterance> r35, java.lang.StringBuilder r36, com.stepos.core.data.TextContent r37) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.m(java.util.concurrent.atomic.AtomicInteger, java.lang.StringBuilder, kotlin.jvm.internal.Ref$LongRef, kotlin.jvm.internal.Ref$LongRef, kotlin.jvm.internal.Ref$ObjectRef, com.stepos.aiengine.adapter.AsrFileRecognitionDelegate$InferenceFileCallback, long, java.util.List, java.lang.StringBuilder, com.stepos.core.data.TextContent):void");
    }

    public static final AsrUtterance n(StringBuilder sb2, long j10, AtomicInteger atomicInteger, Ref$LongRef ref$LongRef, Ref$LongRef ref$LongRef2, Ref$ObjectRef<String> ref$ObjectRef) {
        if (sb2.length() == 0) {
            return null;
        }
        int andIncrement = atomicInteger.getAndIncrement();
        String string = sb2.toString();
        p.h(string, "toString(...)");
        AsrUtterance asrUtterance = new AsrUtterance(j10, andIncrement, string, ref$LongRef.f34819a, ref$LongRef2.f34819a, ref$ObjectRef.f34820a, null, 64, null);
        z.q(sb2);
        ref$LongRef.f34819a = 0L;
        ref$LongRef2.f34819a = 0L;
        ref$ObjectRef.f34820a = "";
        return asrUtterance;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(com.stepos.core.data.ContentParams.Builder r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r3 = "__trace_id"
            r0 = 0
            if (r5 == 0) goto L17
            java.lang.String r1 = "trace_id"
            java.lang.String r1 = r5.getString(r1)
            if (r1 == 0) goto L17
            boolean r2 = La.H.x0(r1)
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            if (r1 != 0) goto L2b
        L17:
            if (r5 == 0) goto L26
            java.lang.String r5 = r5.getString(r3)
            if (r5 == 0) goto L26
            boolean r1 = La.H.x0(r5)
            if (r1 != 0) goto L26
            r0 = r5
        L26:
            if (r0 != 0) goto L2a
            r3 = 0
            return r3
        L2a:
            r1 = r0
        L2b:
            r5 = 128(0x80, float:1.8E-43)
            java.lang.String r5 = La.K.R1(r1, r5)
            r4.putString(r3, r5)
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.b(com.stepos.core.data.ContentParams$Builder, android.os.Bundle):boolean");
    }

    public final AudioContent c(Bundle audio) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) audio.getParcelable(SingleFileBundle.KEY_FILE_DESCRIPTOR);
        byte[] byteArray = audio.getByteArray(SingleFileBundle.KEY_BYTES);
        String string = audio.getString("path");
        String string2 = audio.getString("audio_url");
        int i10 = audio.getInt("sample_rate", 16000);
        int i11 = audio.getInt("channel_count", 1);
        if (string2 != null) {
            return new AudioContent(new byte[0], i10, i11, 102, null, 16, null);
        }
        if (parcelFileDescriptor != null) {
            return new AudioContent(new byte[0], i10, i11, 101, parcelFileDescriptor);
        }
        if (byteArray != null) {
            return new AudioContent(byteArray, i10, i11, 2, null, 16, null);
        }
        if (string == null) {
            return null;
        }
        byte[] bytes = string.getBytes(C0953c.UTF_8);
        p.h(bytes, "getBytes(...)");
        return new AudioContent(bytes, i10, i11, 100, null, 16, null);
    }

    public final AsrFileRecognitionResult d(long fd, List<AsrUtterance> utterances) {
        Long l10;
        List<AsrUtterance> list = utterances;
        String strA0 = F.A0(list, "", null, null, 0, null, new InterfaceC5074l() { // from class: O4.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AsrFileRecognitionDelegate.e((AsrUtterance) obj);
            }
        }, 30, null);
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Long lValueOf = Long.valueOf(((AsrUtterance) it.next()).getEndTime());
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(((AsrUtterance) it.next()).getEndTime());
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
            l10 = lValueOf;
        } else {
            l10 = null;
        }
        long jLongValue = l10 != null ? l10.longValue() : 0L;
        return new AsrFileRecognitionResult(fd, jLongValue > 0 ? jLongValue / 1000.0f : 0.0f, strA0, utterances, C1173v.m(), null, 32, null);
    }

    public final long f(Bundle audio) {
        long jG = g(audio);
        Companion companion = INSTANCE;
        return companion.uploadMsFor(jG) + companion.pollMsFor(jG) + 60000;
    }

    public final long g(Bundle audio) {
        Object objB;
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) audio.getParcelable(SingleFileBundle.KEY_FILE_DESCRIPTOR);
        if (parcelFileDescriptor != null && parcelFileDescriptor.getStatSize() > 0) {
            return parcelFileDescriptor.getStatSize();
        }
        if (audio.getByteArray(SingleFileBundle.KEY_BYTES) != null) {
            return r4.length;
        }
        String string = audio.getString("path");
        if (string != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(Long.valueOf(new File(string).length()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            Long l10 = (Long) objB;
            if (l10 != null) {
                long jLongValue = l10.longValue();
                if (jLongValue > 0) {
                    return jLongValue;
                }
            }
        }
        return 0L;
    }

    public final boolean h(String text) {
        Object objB;
        String string = H.D1(text).toString();
        boolean z10 = false;
        if (string.length() < 2 || !D.X(string, Const.STR_MART_JSON_BEGIN, false, 2, null)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("duration") && jSONObject.has("result")) {
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
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

    public final void i(Content content, Bundle audioBundle, Bundle requestArgs) {
        boolean z10;
        ContentParams.Builder builder = new ContentParams.Builder();
        ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
        boolean z11 = true;
        if (companion.hasExecutionParams(audioBundle)) {
            companion.fromBundle(audioBundle).applyTo(builder);
            z10 = true;
        } else {
            z10 = false;
        }
        String string = audioBundle.getString("audio_url");
        String string2 = audioBundle.getString(SingleFileBundle.KEY_CLOUD_BIZ_CODE);
        String string3 = audioBundle.getString(SingleFileBundle.KEY_CLOUD_SOURCE_TYPE);
        if (string != null) {
            builder.putString("audio_url", string);
            z10 = true;
        }
        if (string2 != null) {
            builder.putString(SingleFileBundle.KEY_CLOUD_BIZ_CODE, string2);
            z10 = true;
        }
        if (string3 != null) {
            builder.putString(SingleFileBundle.KEY_CLOUD_SOURCE_TYPE, string3);
            z10 = true;
        }
        if (b(builder, requestArgs) || b(builder, audioBundle)) {
            z10 = true;
        }
        TaskPriorityArg taskPriorityArg = TaskPriorityArg.INSTANCE;
        if (!taskPriorityArg.applyTo(builder, requestArgs) && !taskPriorityArg.applyTo(builder, audioBundle)) {
            z11 = z10;
        }
        if (z11) {
            content.setParams(builder.build());
        }
    }

    public final AsrFileRecognitionResult j(long fd, String json, AtomicInteger indexCounter) throws JSONException {
        String str;
        JSONArray jSONArray;
        int i10;
        float[] fArr;
        String strOptString;
        String str2 = "text";
        try {
            JSONObject jSONObject = new JSONObject(json);
            float fOptDouble = (float) jSONObject.optDouble("duration", 0.0d);
            String strOptString2 = jSONObject.optString("text", json);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0);
                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("utterances");
                if (jSONArrayOptJSONArray2 != null) {
                    int length = jSONArrayOptJSONArray2.length();
                    int i11 = 0;
                    while (i11 < length) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i11);
                        p.f(jSONObject3);
                        List<AsrWordInfo> listK = k(jSONObject3);
                        int andIncrement = indexCounter.getAndIncrement();
                        String strOptString3 = jSONObject3.optString(str2, "");
                        p.h(strOptString3, "optString(...)");
                        String str3 = str2;
                        long jOptLong = jSONObject3.optLong("start_time", 0L);
                        long jOptLong2 = jSONObject3.optLong("end_time", 0L);
                        JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("speaker");
                        arrayList.add(new AsrUtterance(fd, andIncrement, strOptString3, jOptLong, jOptLong2, (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.optString("id", "")) == null) ? "" : strOptString, listK));
                        i11++;
                        str2 = str3;
                    }
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("speakers");
                if (jSONArrayOptJSONArray3 != null) {
                    int length2 = jSONArrayOptJSONArray3.length();
                    int i12 = 0;
                    while (i12 < length2) {
                        JSONObject jSONObject4 = jSONArrayOptJSONArray3.getJSONObject(i12);
                        JSONArray jSONArrayOptJSONArray4 = jSONObject4.optJSONArray("embedding");
                        if (jSONArrayOptJSONArray4 != null) {
                            int length3 = jSONArrayOptJSONArray4.length();
                            fArr = new float[length3];
                            int i13 = 0;
                            while (i13 < length3) {
                                float[] fArr2 = fArr;
                                fArr2[i13] = (float) jSONArrayOptJSONArray4.optDouble(i13, 0.0d);
                                i13++;
                                jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                                length2 = length2;
                                length3 = length3;
                                fArr = fArr2;
                            }
                            jSONArray = jSONArrayOptJSONArray3;
                            i10 = length2;
                        } else {
                            jSONArray = jSONArrayOptJSONArray3;
                            i10 = length2;
                            fArr = null;
                        }
                        String strOptString4 = jSONObject4.optString("id", "");
                        p.h(strOptString4, "optString(...)");
                        arrayList2.add(new AsrSpeakerInfo(strOptString4, fArr));
                        i12++;
                        jSONArrayOptJSONArray3 = jSONArray;
                        length2 = i10;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                str = strOptString2;
                int andIncrement2 = indexCounter.getAndIncrement();
                p.f(str);
                arrayList.add(new AsrUtterance(fd, andIncrement2, str, 0L, 0L, null, null, 96, null));
            } else {
                str = strOptString2;
            }
            p.f(str);
            return new AsrFileRecognitionResult(fd, fOptDouble, str, arrayList, arrayList2, null, 32, null);
        } catch (Exception unused) {
            return new AsrFileRecognitionResult(fd, 0.0f, json, C1172u.e(new AsrUtterance(fd, indexCounter.getAndIncrement(), json, 0L, 0L, null, null, 96, null)), null, null, 50, null);
        }
    }

    public final List<AsrWordInfo> k(JSONObject uttObj) throws JSONException {
        JSONArray jSONArrayOptJSONArray = uttObj.optJSONArray("words");
        if (jSONArrayOptJSONArray == null) {
            return C1173v.m();
        }
        C5680i c5680iS = C5685n.s(0, jSONArrayOptJSONArray.length());
        ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(((M) it).nextInt());
            String strOptString = jSONObject.optString("text", "");
            p.h(strOptString, "optString(...)");
            arrayList.add(new AsrWordInfo(strOptString, jSONObject.optLong("start_time", 0L), jSONObject.optLong("end_time", 0L)));
        }
        return arrayList;
    }

    public final void l(AlgorithmToken token, final long fd, Bundle audio, Bundle requestArgs, final InferenceFileCallback callback) {
        AudioContent audioContentC = c(audio);
        if (audioContentC == null) {
            callback.onError(AIEngineError.INPUT_DATA_INVALID, "audio Bundle missing 'fd', 'bytes' or 'path' key");
            return;
        }
        i(audioContentC, audio, requestArgs);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final ArrayList arrayList = new ArrayList();
        final StringBuilder sb2 = new StringBuilder();
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.f34820a = "";
        final StringBuilder sb3 = new StringBuilder();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        this.handle.infer(String.valueOf(token.getIdentity()), (String) audioContentC, (InferenceCallback) new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.AsrFileRecognitionDelegate$recognizeInternal$1
            /* JADX WARN: Type inference failed for: r13v32, types: [T, java.lang.String] */
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) throws JSONException {
                AsrFileRecognitionResult asrFileRecognitionResult;
                p.i(inferId, "inferId");
                p.i(result, "result");
                if (result instanceof InferResult.Result) {
                    Content value = ((InferResult.Result) result).getValue();
                    TextContent textContent = value instanceof TextContent ? (TextContent) value : null;
                    if (textContent == null) {
                        return;
                    }
                    String text = textContent.getText();
                    if (this.f23500a.h(text)) {
                        ref$ObjectRef.f34820a = H.D1(text).toString();
                        return;
                    }
                    ContentParams params = textContent.getParams();
                    if (params != null && params.containsKey("asr.event_type")) {
                        AsrFileRecognitionDelegate.m(atomicInteger, sb2, ref$LongRef, ref$LongRef2, ref$ObjectRef2, callback, fd, arrayList, sb3, textContent);
                        return;
                    } else {
                        if (text.length() > 0) {
                            sb3.append(text);
                            return;
                        }
                        return;
                    }
                }
                if (result instanceof InferResult.Error) {
                    InferResult.Error error = (InferResult.Error) result;
                    callback.onError(error.getErrorCode(), error.getMessage());
                    return;
                }
                if (!p.d(result, InferResult.Complete.INSTANCE)) {
                    if (result instanceof InferResult.Cancelled) {
                        callback.onCancelled();
                        return;
                    } else {
                        if (result instanceof InferResult.Progress) {
                            return;
                        }
                        if (!(result instanceof InferResult.RoutingDecision)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        InferResult.RoutingDecision routingDecision = (InferResult.RoutingDecision) result;
                        callback.onRoutingDecision(routingDecision.getExecutionLocation(), routingDecision.getReason());
                        return;
                    }
                }
                AsrUtterance asrUtteranceN = AsrFileRecognitionDelegate.n(sb2, fd, atomicInteger, ref$LongRef, ref$LongRef2, ref$ObjectRef2);
                if (asrUtteranceN != null) {
                    List<AsrUtterance> list = arrayList;
                    AsrFileRecognitionDelegate.InferenceFileCallback inferenceFileCallback = callback;
                    list.add(asrUtteranceN);
                    inferenceFileCallback.onRecognizing(asrUtteranceN);
                }
                String str = ref$ObjectRef.f34820a;
                if (str != null) {
                    AsrFileRecognitionDelegate asrFileRecognitionDelegate = this.f23500a;
                    long j10 = fd;
                    p.f(str);
                    asrFileRecognitionResult = asrFileRecognitionDelegate.j(j10, str, atomicInteger);
                    List<AsrUtterance> utterances = asrFileRecognitionResult.getUtterances();
                    AsrFileRecognitionDelegate.InferenceFileCallback inferenceFileCallback2 = callback;
                    Iterator<T> it = utterances.iterator();
                    while (it.hasNext()) {
                        inferenceFileCallback2.onRecognizing((AsrUtterance) it.next());
                    }
                } else if (!arrayList.isEmpty()) {
                    asrFileRecognitionResult = this.f23500a.d(fd, arrayList);
                } else if (sb3.length() > 0) {
                    AsrFileRecognitionDelegate asrFileRecognitionDelegate2 = this.f23500a;
                    long j11 = fd;
                    String string = sb3.toString();
                    p.h(string, "toString(...)");
                    asrFileRecognitionResult = asrFileRecognitionDelegate2.j(j11, string, atomicInteger);
                    List<AsrUtterance> utterances2 = asrFileRecognitionResult.getUtterances();
                    AsrFileRecognitionDelegate.InferenceFileCallback inferenceFileCallback3 = callback;
                    Iterator<T> it2 = utterances2.iterator();
                    while (it2.hasNext()) {
                        inferenceFileCallback3.onRecognizing((AsrUtterance) it2.next());
                    }
                } else {
                    asrFileRecognitionResult = new AsrFileRecognitionResult(fd, 0.0f, "", C1173v.m(), null, null, 50, null);
                }
                callback.onRecognized(asrFileRecognitionResult);
            }
        });
    }

    public final int recognize(AlgorithmToken token, final List<AsrAudioFile> files, final AsrFileRecognitionListener listener, Bundle args) {
        p.i(token, "token");
        p.i(files, "files");
        p.i(listener, "listener");
        int i10 = 0;
        for (Object obj : files) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            final AsrAudioFile asrAudioFile = (AsrAudioFile) obj;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            InterfaceC5074l<Bundle, Long> interfaceC5074l = this.waitMsOverride;
            long jLongValue = interfaceC5074l != null ? interfaceC5074l.invoke(asrAudioFile.getAudio()).longValue() : f(asrAudioFile.getAudio());
            listener.onSpeechStart(asrAudioFile.getFd(), i10);
            long j10 = jLongValue;
            l(token, asrAudioFile.getFd(), asrAudioFile.getAudio(), args, new InferenceFileCallback() { // from class: com.stepos.aiengine.adapter.AsrFileRecognitionDelegate$recognize$1$1
                @Override // com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.InferenceFileCallback
                public void onCancelled() {
                    listener.onCancelled();
                    countDownLatch.countDown();
                }

                @Override // com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.InferenceFileCallback
                public void onError(int errorCode, String message) {
                    p.i(message, "message");
                    listener.onFileError(asrAudioFile.getFd(), errorCode, message);
                    if (files.size() == 1) {
                        listener.onError(errorCode, message);
                    }
                    countDownLatch.countDown();
                }

                @Override // com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.InferenceFileCallback
                public void onRecognized(AsrFileRecognitionResult result) {
                    p.i(result, "result");
                    listener.onRecognized(result);
                    countDownLatch.countDown();
                }

                @Override // com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.InferenceFileCallback
                public void onRecognizing(AsrUtterance utterance) {
                    p.i(utterance, "utterance");
                    listener.onRecognizing(utterance);
                }

                @Override // com.stepos.aiengine.adapter.AsrFileRecognitionDelegate.InferenceFileCallback
                public void onRoutingDecision(String executionLocation, String reason) {
                    p.i(executionLocation, "executionLocation");
                    p.i(reason, "reason");
                    listener.onRoutingDecision(executionLocation, reason);
                }
            });
            if (!countDownLatch.await(j10, TimeUnit.MILLISECONDS)) {
                this.handle.cancel(String.valueOf(token.getIdentity()));
                String str = "client wait timeout after " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE;
                listener.onFileError(asrAudioFile.getFd(), AIEngineError.TIMEOUT, str);
                if (files.size() == 1) {
                    listener.onError(AIEngineError.TIMEOUT, str);
                }
            }
            i10 = i11;
        }
        listener.onComplete();
        return 0;
    }

    public /* synthetic */ AsrFileRecognitionDelegate(AbilityHandle abilityHandle, InterfaceC5074l interfaceC5074l, int i10, i iVar) {
        this(abilityHandle, (i10 & 2) != 0 ? null : interfaceC5074l);
    }
}
