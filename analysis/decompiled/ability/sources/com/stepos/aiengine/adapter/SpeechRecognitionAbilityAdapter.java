package com.stepos.aiengine.adapter;

import A4.b;
import A4.h;
import D7.q;
import D7.w;
import H4.o;
import Q4.l;
import Y7.e;
import Y7.f;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.algorithm.voice.ISpeechRecognition;
import com.stepos.aiengine.algorithm.voice.ISpeechStreamingRecognizor;
import com.stepos.aiengine.algorithm.voice.SpeechRecognitionCallback;
import com.stepos.aiengine.algorithm.voice.SpeechRecognitionSegment;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.aiengine.args.MultiFilesBundle;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.core.c;
import com.stepos.core.callback.a;
import com.stepos.core.d;
import com.stepos.core.data.AudioContent;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.MixedContent;
import g1.AbstractC1451a;
import j9.AbstractC1607a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/adapter/SpeechRecognitionAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/voice/ISpeechRecognition;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", BffConstant.Type.Audio, "Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionCallback;", "callback", "", "recognize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Lcom/stepos/aiengine/algorithm/voice/SpeechRecognitionCallback;)I", "Lcom/stepos/aiengine/algorithm/voice/ISpeechStreamingRecognizor;", "recognizeStreaming", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;)Lcom/stepos/aiengine/algorithm/voice/ISpeechStreamingRecognizor;", "", "identity", "", "cancel", "(J)Z", "Q4/l", "Q4/k", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpeechRecognitionAbilityAdapter implements ISpeechRecognition {

    /* renamed from: a, reason: collision with root package name */
    public final c f3474a;
    public final ExecutorService b;

    public SpeechRecognitionAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3474a = handle;
        this.b = Executors.newSingleThreadExecutor(new b(3));
    }

    public static l a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("language", "");
            String strOptString2 = jSONObject.optString("emotion", "");
            String strOptString3 = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, "");
            boolean zOptBoolean = jSONObject.optBoolean("withitn", false);
            String strOptString4 = jSONObject.optString("text", str);
            List listB = b(jSONObject);
            if (listB == null) {
                k.c(strOptString4);
                listB = o.M(new SpeechRecognitionSegment(0L, 0L, strOptString4, null, 8, null));
            }
            k.c(strOptString);
            k.c(strOptString2);
            k.c(strOptString3);
            return new l(strOptString, strOptString2, strOptString3, zOptBoolean, listB);
        } catch (Exception unused) {
            return new l("", "", "", false, o.M(new SpeechRecognitionSegment(0L, 0L, str, null, 8, null)));
        }
    }

    public static final void access$dispatchMultiFilesJson(SpeechRecognitionAbilityAdapter speechRecognitionAbilityAdapter, String str, SpeechRecognitionCallback speechRecognitionCallback) {
        String str2;
        speechRecognitionAbilityAdapter.getClass();
        try {
            str2 = str;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String strOptString = jSONObject.optString(MultiFilesBundle.KEY_MULTI_FILES_EVENT_JSON, "");
                if (strOptString != null) {
                    int iHashCode = strOptString.hashCode();
                    if (iHashCode != 97436022) {
                        if (iHashCode != 2008149056) {
                            if (iHashCode == 2131369349) {
                                try {
                                    if (strOptString.equals(MultiFilesBundle.EVENT_FILE_ERROR)) {
                                        int i = jSONObject.getInt(MultiFilesBundle.KEY_MULTI_FILES_INDEX_JSON);
                                        String strOptString2 = jSONObject.optString("error", "multi-file ASR failed");
                                        k.e(strOptString2, "optString(...)");
                                        speechRecognitionCallback.onFileError(i, 220001, strOptString2);
                                        return;
                                    }
                                } catch (Exception unused) {
                                    l lVarA = a(str2);
                                    speechRecognitionCallback.onFinalResult(lVarA.f1115a, lVarA.b, lVarA.c, lVarA.d, lVarA.e);
                                    return;
                                }
                            }
                        } else if (strOptString.equals(MultiFilesBundle.EVENT_FILE_RESULT)) {
                            int i6 = jSONObject.getInt(MultiFilesBundle.KEY_MULTI_FILES_INDEX_JSON);
                            List<SpeechRecognitionSegment> listB = b(jSONObject);
                            if (listB == null) {
                                String strOptString3 = jSONObject.optString("text", "");
                                k.e(strOptString3, "optString(...)");
                                listB = o.M(new SpeechRecognitionSegment(0L, 0L, strOptString3, null, 8, null));
                            }
                            List<SpeechRecognitionSegment> list = listB;
                            String strOptString4 = jSONObject.optString("language", "");
                            k.e(strOptString4, "optString(...)");
                            String strOptString5 = jSONObject.optString("emotion", "");
                            k.e(strOptString5, "optString(...)");
                            String strOptString6 = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, "");
                            k.e(strOptString6, "optString(...)");
                            speechRecognitionCallback.onFileResult(i6, strOptString4, strOptString5, strOptString6, jSONObject.optBoolean("withitn", true), list);
                            return;
                        }
                    } else if (strOptString.equals(MultiFilesBundle.EVENT_FINAL)) {
                        l lVarA2 = a(str2);
                        speechRecognitionCallback.onFinalResult(lVarA2.f1115a, lVarA2.b, lVarA2.c, lVarA2.d, lVarA2.e);
                        return;
                    }
                }
                l lVarA3 = a(str2);
                speechRecognitionCallback.onFinalResult(lVarA3.f1115a, lVarA3.b, lVarA3.c, lVarA3.d, lVarA3.e);
            } catch (Exception unused2) {
            }
        } catch (Exception unused3) {
            str2 = str;
        }
    }

    public static final /* synthetic */ l access$parseAsrJson(SpeechRecognitionAbilityAdapter speechRecognitionAbilityAdapter, String str) {
        speechRecognitionAbilityAdapter.getClass();
        return a(str);
    }

    public static ArrayList b(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("segments");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        f fVarX = AbstractC1451a.X(0, jSONArrayOptJSONArray.length());
        ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
        e it = fVarX.iterator();
        while (it.c) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(it.nextInt());
            long jOptLong = jSONObject2.optLong("start", 0L);
            long jOptLong2 = jSONObject2.optLong("end", 0L);
            String strOptString = jSONObject2.optString("sentence", "");
            k.e(strOptString, "optString(...)");
            String strOptString2 = jSONObject2.optString("speaker_id", "");
            k.e(strOptString2, "optString(...)");
            arrayList.add(new SpeechRecognitionSegment(jOptLong, jOptLong2, strOptString, strOptString2));
        }
        return arrayList;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechRecognition
    public boolean cancel(long identity) {
        return this.f3474a.a(String.valueOf(identity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v6, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r13v7, types: [java.util.ArrayList] */
    @Override // com.stepos.aiengine.algorithm.voice.ISpeechRecognition
    public int recognize(AlgorithmToken token, Bundle audio, final SpeechRecognitionCallback callback) throws InterruptedException {
        AudioContent audioContent;
        ?? arrayList;
        k.f(token, "token");
        k.f(audio, "audio");
        k.f(callback, "callback");
        if (!MultiFilesBundle.INSTANCE.isMultiFilesMode(audio)) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) audio.getParcelable(SingleFileBundle.KEY_FILE_DESCRIPTOR);
            byte[] byteArray = audio.getByteArray(SingleFileBundle.KEY_BYTES);
            String string = audio.getString(SingleFileBundle.KEY_PATH);
            int i = audio.getInt("sample_rate", 16000);
            int i6 = audio.getInt("channel_count", 1);
            if (parcelFileDescriptor != null) {
                audioContent = new AudioContent(new byte[0], i, i6, 101, parcelFileDescriptor);
            } else if (byteArray != null) {
                audioContent = new AudioContent(byteArray, i, i6, 2, null, 16, null);
            } else {
                if (string == null) {
                    callback.onError(260002, "audio Bundle missing 'fd', 'bytes' or 'path' key");
                    return 260002;
                }
                byte[] bytes = string.getBytes(AbstractC1607a.f4778a);
                k.e(bytes, "getBytes(...)");
                audioContent = new AudioContent(bytes, i, i6, 100, null, 16, null);
            }
            ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
            if (companion.hasExecutionParams(audio)) {
                d5.b bVar = new d5.b();
                companion.fromBundle(audio).applyTo(bVar);
                audioContent.setParams(bVar.a());
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final StringBuilder sb = new StringBuilder();
            this.f3474a.g(String.valueOf(token.getIdentity()), audioContent, new d() { // from class: com.stepos.aiengine.adapter.SpeechRecognitionAbilityAdapter.recognize.1
                @Override // com.stepos.core.d
                public void onNext(String inferId, com.stepos.core.callback.c result) {
                    k.f(inferId, "inferId");
                    k.f(result, "result");
                    boolean z10 = result instanceof com.stepos.core.callback.b;
                    SpeechRecognitionCallback speechRecognitionCallback = callback;
                    CountDownLatch countDownLatch2 = countDownLatch;
                    if (z10) {
                        com.stepos.core.callback.b bVar2 = (com.stepos.core.callback.b) result;
                        speechRecognitionCallback.onError(bVar2.f3827a, bVar2.b);
                        countDownLatch2.countDown();
                    } else {
                        if (!result.equals(a.f3826a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        String string2 = sb.toString();
                        k.e(string2, "toString(...)");
                        l lVarAccess$parseAsrJson = SpeechRecognitionAbilityAdapter.access$parseAsrJson(this, string2);
                        speechRecognitionCallback.onFinalResult(lVarAccess$parseAsrJson.f1115a, lVarAccess$parseAsrJson.b, lVarAccess$parseAsrJson.c, lVarAccess$parseAsrJson.d, lVarAccess$parseAsrJson.e);
                        countDownLatch2.countDown();
                    }
                }
            });
            countDownLatch.await(60L, TimeUnit.SECONDS);
            return 0;
        }
        int i10 = audio.getInt(MultiFilesBundle.KEY_MULTI_FILES_COUNT, 0);
        ArrayList<Parcelable> parcelableArrayList = audio.getParcelableArrayList(MultiFilesBundle.KEY_MULTI_FILES_FDS);
        if (parcelableArrayList != null) {
            arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArrayList) {
                ParcelFileDescriptor parcelFileDescriptor2 = parcelable instanceof ParcelFileDescriptor ? (ParcelFileDescriptor) parcelable : null;
                if (parcelFileDescriptor2 != null) {
                    arrayList.add(parcelFileDescriptor2);
                }
            }
        } else {
            arrayList = 0;
        }
        if (arrayList == 0) {
            arrayList = EmptyList.f4893a;
        }
        if (i10 <= 0 || arrayList.size() != i10) {
            callback.onError(260002, androidx.compose.foundation.b.n(i10, arrayList.size(), "multi_files_fds count mismatch: expected=", " actual="));
            return 260002;
        }
        if (audio.containsKey(SingleFileBundle.KEY_FILE_DESCRIPTOR) || audio.containsKey(SingleFileBundle.KEY_BYTES) || audio.containsKey(SingleFileBundle.KEY_PATH)) {
            callback.onError(260002, "multi_files_mode is mutually exclusive with single-file fd/bytes/path");
            return 260002;
        }
        long[] longArray = audio.getLongArray(MultiFilesBundle.KEY_MULTI_FILES_TIME_OFFSETS_MS);
        Iterable iterable = (Iterable) arrayList;
        ArrayList arrayList2 = new ArrayList(w.c0(iterable, 10));
        int i11 = 0;
        for (Object obj : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                o.X();
                throw null;
            }
            arrayList2.add(new FileContent(B7.a.h(i11, "multi_file_"), "audio/*", (ParcelFileDescriptor) obj));
            i11 = i12;
        }
        d5.b bVar2 = new d5.b();
        bVar2.b(MultiFilesBundle.KEY_MULTI_FILES_MODE, true);
        bVar2.d(MultiFilesBundle.KEY_MULTI_FILES_COUNT, i10);
        if (longArray != null) {
            bVar2.e(MultiFilesBundle.KEY_MULTI_FILES_TIME_OFFSETS_CSV, q.w0(longArray, 62));
        }
        ExecutionBundle.INSTANCE.fromBundle(audio).applyTo(bVar2);
        MixedContent mixedContent = new MixedContent(arrayList2);
        mixedContent.setParams(bVar2.a());
        this.b.execute(new h(this, token, mixedContent, callback, 1));
        return 0;
    }

    @Override // com.stepos.aiengine.algorithm.voice.ISpeechRecognition
    public ISpeechStreamingRecognizor recognizeStreaming(AlgorithmToken token) {
        k.f(token, "token");
        return new Q4.k(this.f3474a);
    }
}
