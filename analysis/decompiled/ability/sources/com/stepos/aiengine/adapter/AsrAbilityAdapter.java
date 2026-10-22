package com.stepos.aiengine.adapter;

import D7.w;
import H4.o;
import Q4.a;
import Y7.e;
import Y7.f;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.asr.AsrFileRecognitionResult;
import com.stepos.aiengine.algorithm.asr.AsrSpeakerInfo;
import com.stepos.aiengine.algorithm.asr.AsrUtterance;
import com.stepos.aiengine.algorithm.asr.AsrWordInfo;
import com.stepos.aiengine.algorithm.asr.IAsrRecognition;
import com.stepos.aiengine.algorithm.asr.IAsrStreamingRecognizer;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.core.c;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/aiengine/adapter/AsrAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/asr/IAsrRecognition;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "", "Lcom/stepos/aiengine/algorithm/asr/AsrAudioFile;", "files", "Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;", "listener", "", "recognize", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Lcom/stepos/aiengine/algorithm/asr/AsrFileRecognitionListener;)I", "Landroid/os/Bundle;", "params", "Lcom/stepos/aiengine/algorithm/asr/IAsrStreamingRecognizer;", "recognizeStreaming", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;)Lcom/stepos/aiengine/algorithm/asr/IAsrStreamingRecognizer;", "", "identity", "", "cancel", "(J)Z", "Q4/b", "Q4/a", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsrAbilityAdapter implements IAsrRecognition {

    /* renamed from: a, reason: collision with root package name */
    public final c f3453a;

    public AsrAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3453a = handle;
    }

    public static List a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("words");
        if (jSONArrayOptJSONArray == null) {
            return EmptyList.f4893a;
        }
        f fVarX = AbstractC1451a.X(0, jSONArrayOptJSONArray.length());
        ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
        e it = fVarX.iterator();
        while (it.c) {
            JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(it.nextInt());
            String strOptString = jSONObject2.optString("text", "");
            k.e(strOptString, "optString(...)");
            arrayList.add(new AsrWordInfo(strOptString, jSONObject2.optLong("start_time", 0L), jSONObject2.optLong("end_time", 0L)));
        }
        return arrayList;
    }

    public static final AsrFileRecognitionResult access$parseFileResult(AsrAbilityAdapter asrAbilityAdapter, long j5, String str, AtomicInteger atomicInteger) {
        String str2;
        JSONArray jSONArray;
        int i;
        float[] fArr;
        String strOptString;
        asrAbilityAdapter.getClass();
        try {
            JSONObject jSONObject = new JSONObject(str);
            float fOptDouble = (float) jSONObject.optDouble(TypedValues.TransitionType.S_DURATION, 0.0d);
            String strOptString2 = jSONObject.optString("text", str);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("result");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0);
                JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray("utterances");
                if (jSONArrayOptJSONArray2 != null) {
                    int length = jSONArrayOptJSONArray2.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i6);
                        k.c(jSONObject3);
                        List listA = a(jSONObject3);
                        int andIncrement = atomicInteger.getAndIncrement();
                        String strOptString3 = jSONObject3.optString("text", "");
                        k.e(strOptString3, "optString(...)");
                        long jOptLong = jSONObject3.optLong("start_time", 0L);
                        long jOptLong2 = jSONObject3.optLong("end_time", 0L);
                        JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("speaker");
                        arrayList.add(new AsrUtterance(j5, andIncrement, strOptString3, jOptLong, jOptLong2, (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.optString("id", "")) == null) ? "" : strOptString, listA));
                    }
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("speakers");
                if (jSONArrayOptJSONArray3 != null) {
                    int length2 = jSONArrayOptJSONArray3.length();
                    int i10 = 0;
                    while (i10 < length2) {
                        JSONObject jSONObject4 = jSONArrayOptJSONArray3.getJSONObject(i10);
                        JSONArray jSONArrayOptJSONArray4 = jSONObject4.optJSONArray("embedding");
                        if (jSONArrayOptJSONArray4 != null) {
                            int length3 = jSONArrayOptJSONArray4.length();
                            fArr = new float[length3];
                            int i11 = 0;
                            while (i11 < length3) {
                                float[] fArr2 = fArr;
                                fArr2[i11] = (float) jSONArrayOptJSONArray4.optDouble(i11, 0.0d);
                                i11++;
                                jSONArrayOptJSONArray3 = jSONArrayOptJSONArray3;
                                length2 = length2;
                                length3 = length3;
                                fArr = fArr2;
                            }
                            jSONArray = jSONArrayOptJSONArray3;
                            i = length2;
                        } else {
                            jSONArray = jSONArrayOptJSONArray3;
                            i = length2;
                            fArr = null;
                        }
                        String strOptString4 = jSONObject4.optString("id", "");
                        k.e(strOptString4, "optString(...)");
                        arrayList2.add(new AsrSpeakerInfo(strOptString4, fArr));
                        i10++;
                        jSONArrayOptJSONArray3 = jSONArray;
                        length2 = i;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                str2 = strOptString2;
                int andIncrement2 = atomicInteger.getAndIncrement();
                k.c(str2);
                arrayList.add(new AsrUtterance(j5, andIncrement2, str2, 0L, 0L, null, null, 96, null));
            } else {
                str2 = strOptString2;
            }
            k.c(str2);
            return new AsrFileRecognitionResult(j5, fOptDouble, str2, arrayList, arrayList2, null, 32, null);
        } catch (Exception unused) {
            return new AsrFileRecognitionResult(j5, 0.0f, str, o.M(new AsrUtterance(j5, atomicInteger.getAndIncrement(), str, 0L, 0L, null, null, 96, null)), null, null, 50, null);
        }
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRecognition
    public boolean cancel(long identity) {
        return this.f3453a.a(String.valueOf(identity));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /* JADX WARN: Type inference failed for: r10v0, types: [Q4.b, com.stepos.aiengine.adapter.AsrAbilityAdapter$recognize$1] */
    @Override // com.stepos.aiengine.algorithm.asr.IAsrRecognition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int recognize(com.stepos.aiengine.api.task.AlgorithmToken r31, final java.util.List<com.stepos.aiengine.algorithm.asr.AsrAudioFile> r32, final com.stepos.aiengine.algorithm.asr.AsrFileRecognitionListener r33) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.adapter.AsrAbilityAdapter.recognize(com.stepos.aiengine.api.task.AlgorithmToken, java.util.List, com.stepos.aiengine.algorithm.asr.AsrFileRecognitionListener):int");
    }

    @Override // com.stepos.aiengine.algorithm.asr.IAsrRecognition
    public IAsrStreamingRecognizer recognizeStreaming(AlgorithmToken token, Bundle params) {
        k.f(token, "token");
        return new a(this.f3453a, params);
    }
}
