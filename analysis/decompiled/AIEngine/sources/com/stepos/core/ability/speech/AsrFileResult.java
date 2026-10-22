package com.stepos.core.ability.speech;

import com.stepos.core.ability.factory.AIEngineAbilityId;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.EmptyList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFileResult {
    public static final Companion Companion = new Companion(null);
    private final double duration;
    private final List<Speaker> speakers;
    private final String text;
    private final List<Utterance> utterances;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final AsrFileResult fromJson(JSONObject json) {
            JSONArray jSONArray;
            StringBuilder sb2;
            int i10;
            double d8;
            int i11;
            long j10;
            float[] fArr;
            JSONArray jSONArray2;
            int i12;
            ArrayList arrayList;
            StringBuilder sb3;
            int i13;
            int i14;
            int i15;
            double d10;
            ArrayList arrayList2;
            int i16;
            JSONArray jSONArray3;
            ArrayList arrayList3;
            int i17;
            kotlin.jvm.internal.g.f(json, "json");
            long j11 = 0;
            double dOptDouble = json.optDouble("duration", 0.0d);
            JSONArray jSONArrayOptJSONArray = json.optJSONArray("result");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            StringBuilder sb4 = new StringBuilder();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            int i18 = 0;
            while (i18 < length) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i18);
                if (jSONObjectOptJSONObject == null) {
                    jSONArray = jSONArrayOptJSONArray;
                    sb2 = sb4;
                    i10 = length;
                    d8 = dOptDouble;
                    i11 = i18;
                    j10 = j11;
                } else {
                    sb4.append(jSONObjectOptJSONObject.optString("text", ""));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("utterances");
                    if (jSONArrayOptJSONArray2 != null) {
                        int length2 = jSONArrayOptJSONArray2.length();
                        int i19 = 0;
                        while (i19 < length2) {
                            JSONArray jSONArray4 = jSONArrayOptJSONArray;
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i19);
                            if (jSONObjectOptJSONObject2 == null) {
                                sb3 = sb4;
                                i13 = length2;
                                i14 = i19;
                                i15 = length;
                                d10 = dOptDouble;
                                arrayList2 = arrayList5;
                                i16 = i18;
                            } else {
                                sb3 = sb4;
                                ArrayList arrayList6 = new ArrayList();
                                i13 = length2;
                                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray("words");
                                i14 = i19;
                                i15 = length;
                                d10 = dOptDouble;
                                if (jSONArrayOptJSONArray3 != null) {
                                    int length3 = jSONArrayOptJSONArray3.length();
                                    int i20 = 0;
                                    while (i20 < length3) {
                                        int i21 = length3;
                                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i20);
                                        if (jSONObjectOptJSONObject3 == null) {
                                            jSONArray3 = jSONArrayOptJSONArray3;
                                            arrayList3 = arrayList5;
                                            i17 = i18;
                                        } else {
                                            jSONArray3 = jSONArrayOptJSONArray3;
                                            String strOptString = jSONObjectOptJSONObject3.optString("text", "");
                                            kotlin.jvm.internal.g.e(strOptString, "optString(...)");
                                            arrayList3 = arrayList5;
                                            i17 = i18;
                                            arrayList6.add(new Word(strOptString, jSONObjectOptJSONObject3.optLong("start_time", 0L), jSONObjectOptJSONObject3.optLong("end_time", 0L)));
                                        }
                                        i20++;
                                        length3 = i21;
                                        jSONArrayOptJSONArray3 = jSONArray3;
                                        arrayList5 = arrayList3;
                                        i18 = i17;
                                    }
                                }
                                arrayList2 = arrayList5;
                                i16 = i18;
                                String strOptString2 = jSONObjectOptJSONObject2.optString("text", "");
                                kotlin.jvm.internal.g.e(strOptString2, "optString(...)");
                                long jOptLong = jSONObjectOptJSONObject2.optLong("start_time", 0L);
                                long jOptLong2 = jSONObjectOptJSONObject2.optLong("end_time", 0L);
                                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("speaker");
                                arrayList4.add(new Utterance(strOptString2, jOptLong, jOptLong2, jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString(ModelDownloadNotifier.EXTRA_NOTIF_ID) : null, arrayList6));
                            }
                            i19 = i14 + 1;
                            jSONArrayOptJSONArray = jSONArray4;
                            sb4 = sb3;
                            length2 = i13;
                            length = i15;
                            dOptDouble = d10;
                            arrayList5 = arrayList2;
                            i18 = i16;
                        }
                    }
                    jSONArray = jSONArrayOptJSONArray;
                    sb2 = sb4;
                    i10 = length;
                    d8 = dOptDouble;
                    ArrayList arrayList7 = arrayList5;
                    i11 = i18;
                    JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("speakers");
                    if (jSONArrayOptJSONArray4 != null) {
                        int length4 = jSONArrayOptJSONArray4.length();
                        int i22 = 0;
                        while (i22 < length4) {
                            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray4.optJSONObject(i22);
                            if (jSONObjectOptJSONObject5 == null) {
                                jSONArray2 = jSONArrayOptJSONArray4;
                                i12 = length4;
                                arrayList = arrayList7;
                            } else {
                                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject5.optJSONArray(AIEngineAbilityId.EMBEDDING);
                                if (jSONArrayOptJSONArray5 != null) {
                                    int length5 = jSONArrayOptJSONArray5.length();
                                    fArr = new float[length5];
                                    int i23 = 0;
                                    while (true) {
                                        jSONArray2 = jSONArrayOptJSONArray4;
                                        i12 = length4;
                                        if (i23 >= length5) {
                                            break;
                                        }
                                        fArr[i23] = (float) jSONArrayOptJSONArray5.optDouble(i23, 0.0d);
                                        i23++;
                                        jSONArrayOptJSONArray4 = jSONArray2;
                                        length4 = i12;
                                    }
                                } else {
                                    fArr = null;
                                    jSONArray2 = jSONArrayOptJSONArray4;
                                    i12 = length4;
                                }
                                String strOptString3 = jSONObjectOptJSONObject5.optString(ModelDownloadNotifier.EXTRA_NOTIF_ID, "");
                                kotlin.jvm.internal.g.e(strOptString3, "optString(...)");
                                arrayList = arrayList7;
                                arrayList.add(new Speaker(strOptString3, fArr));
                            }
                            i22++;
                            arrayList7 = arrayList;
                            jSONArrayOptJSONArray4 = jSONArray2;
                            length4 = i12;
                        }
                    }
                    arrayList5 = arrayList7;
                    j10 = 0;
                }
                j11 = j10;
                sb4 = sb2;
                length = i10;
                dOptDouble = d8;
                i18 = i11 + 1;
                jSONArrayOptJSONArray = jSONArray;
            }
            String string = sb4.toString();
            kotlin.jvm.internal.g.e(string, "toString(...)");
            return new AsrFileResult(dOptDouble, string, arrayList4, arrayList5);
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Word {
        private final long endTime;
        private final long startTime;
        private final String text;

        public Word(String text, long j10, long j11) {
            kotlin.jvm.internal.g.f(text, "text");
            this.text = text;
            this.startTime = j10;
            this.endTime = j11;
        }

        public static /* synthetic */ Word copy$default(Word word, String str, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = word.text;
            }
            if ((i10 & 2) != 0) {
                j10 = word.startTime;
            }
            if ((i10 & 4) != 0) {
                j11 = word.endTime;
            }
            return word.copy(str, j10, j11);
        }

        public final String component1() {
            return this.text;
        }

        public final long component2() {
            return this.startTime;
        }

        public final long component3() {
            return this.endTime;
        }

        public final Word copy(String text, long j10, long j11) {
            kotlin.jvm.internal.g.f(text, "text");
            return new Word(text, j10, j11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Word)) {
                return false;
            }
            Word word = (Word) obj;
            return kotlin.jvm.internal.g.b(this.text, word.text) && this.startTime == word.startTime && this.endTime == word.endTime;
        }

        public final long getEndTime() {
            return this.endTime;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return Long.hashCode(this.endTime) + a0.a.c(this.text.hashCode() * 31, this.startTime, 31);
        }

        public String toString() {
            String str = this.text;
            return a0.a.d(this.endTime, ", endTime=", ")", com.stepos.core.ota.d.l("Word(text=", this.startTime, str, ", startTime="));
        }
    }

    public AsrFileResult(double d8, String text, List<Utterance> utterances, List<Speaker> speakers) {
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(utterances, "utterances");
        kotlin.jvm.internal.g.f(speakers, "speakers");
        this.duration = d8;
        this.text = text;
        this.utterances = utterances;
        this.speakers = speakers;
    }

    public static /* synthetic */ AsrFileResult copy$default(AsrFileResult asrFileResult, double d8, String str, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d8 = asrFileResult.duration;
        }
        double d10 = d8;
        if ((i10 & 2) != 0) {
            str = asrFileResult.text;
        }
        String str2 = str;
        if ((i10 & 4) != 0) {
            list = asrFileResult.utterances;
        }
        List list3 = list;
        if ((i10 & 8) != 0) {
            list2 = asrFileResult.speakers;
        }
        return asrFileResult.copy(d10, str2, list3, list2);
    }

    public final double component1() {
        return this.duration;
    }

    public final String component2() {
        return this.text;
    }

    public final List<Utterance> component3() {
        return this.utterances;
    }

    public final List<Speaker> component4() {
        return this.speakers;
    }

    public final AsrFileResult copy(double d8, String text, List<Utterance> utterances, List<Speaker> speakers) {
        kotlin.jvm.internal.g.f(text, "text");
        kotlin.jvm.internal.g.f(utterances, "utterances");
        kotlin.jvm.internal.g.f(speakers, "speakers");
        return new AsrFileResult(d8, text, utterances, speakers);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrFileResult)) {
            return false;
        }
        AsrFileResult asrFileResult = (AsrFileResult) obj;
        return Double.compare(this.duration, asrFileResult.duration) == 0 && kotlin.jvm.internal.g.b(this.text, asrFileResult.text) && kotlin.jvm.internal.g.b(this.utterances, asrFileResult.utterances) && kotlin.jvm.internal.g.b(this.speakers, asrFileResult.speakers);
    }

    public final double getDuration() {
        return this.duration;
    }

    public final List<Speaker> getSpeakers() {
        return this.speakers;
    }

    public final String getText() {
        return this.text;
    }

    public final List<Utterance> getUtterances() {
        return this.utterances;
    }

    public int hashCode() {
        return this.speakers.hashCode() + h0.e.b(this.utterances, v1.d.a(Double.hashCode(this.duration) * 31, 31, this.text), 31);
    }

    public final JSONObject toResponseJson() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Utterance utterance : this.utterances) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("text", utterance.getText());
            jSONObject.put("start_time", utterance.getStartTime());
            jSONObject.put("end_time", utterance.getEndTime());
            String speakerId = utterance.getSpeakerId();
            if (speakerId != null) {
                if (speakerId.length() <= 0) {
                    speakerId = null;
                }
                if (speakerId != null) {
                    jSONObject.put("speaker", new JSONObject().put(ModelDownloadNotifier.EXTRA_NOTIF_ID, speakerId));
                }
            }
            if (!utterance.getWords().isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (Word word : utterance.getWords()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("text", word.getText());
                    jSONObject2.put("start_time", word.getStartTime());
                    jSONObject2.put("end_time", word.getEndTime());
                    jSONArray2.put(jSONObject2);
                }
                lb.n nVar = lb.n.f10413a;
                jSONObject.put("words", jSONArray2);
            }
            jSONArray.put(jSONObject);
        }
        JSONArray jSONArray3 = new JSONArray();
        for (Speaker speaker : this.speakers) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(ModelDownloadNotifier.EXTRA_NOTIF_ID, speaker.getId());
            float[] embedding = speaker.getEmbedding();
            if (embedding != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (float f8 : embedding) {
                    jSONArray4.put(f8);
                }
                lb.n nVar2 = lb.n.f10413a;
                jSONObject3.put(AIEngineAbilityId.EMBEDDING, jSONArray4);
            }
            jSONArray3.put(jSONObject3);
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("text", this.text);
        jSONObject4.put("utterances", jSONArray);
        jSONObject4.put("speakers", jSONArray3);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("duration", this.duration);
        jSONObject5.put("text", this.text);
        jSONObject5.put("result", new JSONArray().put(jSONObject4));
        return jSONObject5;
    }

    public String toString() {
        return "AsrFileResult(duration=" + this.duration + ", text=" + this.text + ", utterances=" + this.utterances + ", speakers=" + this.speakers + ")";
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Utterance {
        private final long endTime;
        private final String speakerId;
        private final long startTime;
        private final String text;
        private final List<Word> words;

        public Utterance(String str, long j10, long j11, String str2, List list, int i10, kotlin.jvm.internal.e eVar) {
            this(str, j10, j11, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? EmptyList.f10001a : list);
        }

        public static /* synthetic */ Utterance copy$default(Utterance utterance, String str, long j10, long j11, String str2, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = utterance.text;
            }
            if ((i10 & 2) != 0) {
                j10 = utterance.startTime;
            }
            if ((i10 & 4) != 0) {
                j11 = utterance.endTime;
            }
            if ((i10 & 8) != 0) {
                str2 = utterance.speakerId;
            }
            if ((i10 & 16) != 0) {
                list = utterance.words;
            }
            long j12 = j11;
            return utterance.copy(str, j10, j12, str2, list);
        }

        public final String component1() {
            return this.text;
        }

        public final long component2() {
            return this.startTime;
        }

        public final long component3() {
            return this.endTime;
        }

        public final String component4() {
            return this.speakerId;
        }

        public final List<Word> component5() {
            return this.words;
        }

        public final Utterance copy(String text, long j10, long j11, String str, List<Word> words) {
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(words, "words");
            return new Utterance(text, j10, j11, str, words);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Utterance)) {
                return false;
            }
            Utterance utterance = (Utterance) obj;
            return kotlin.jvm.internal.g.b(this.text, utterance.text) && this.startTime == utterance.startTime && this.endTime == utterance.endTime && kotlin.jvm.internal.g.b(this.speakerId, utterance.speakerId) && kotlin.jvm.internal.g.b(this.words, utterance.words);
        }

        public final long getEndTime() {
            return this.endTime;
        }

        public final String getSpeakerId() {
            return this.speakerId;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final String getText() {
            return this.text;
        }

        public final List<Word> getWords() {
            return this.words;
        }

        public int hashCode() {
            int iC = a0.a.c(a0.a.c(this.text.hashCode() * 31, this.startTime, 31), this.endTime, 31);
            String str = this.speakerId;
            return this.words.hashCode() + ((iC + (str == null ? 0 : str.hashCode())) * 31);
        }

        public String toString() {
            String str = this.text;
            long j10 = this.startTime;
            long j11 = this.endTime;
            String str2 = this.speakerId;
            List<Word> list = this.words;
            StringBuilder sbL = com.stepos.core.ota.d.l("Utterance(text=", j10, str, ", startTime=");
            a0.a.s(j11, ", endTime=", ", speakerId=", sbL);
            sbL.append(str2);
            sbL.append(", words=");
            sbL.append(list);
            sbL.append(")");
            return sbL.toString();
        }

        public Utterance(String text, long j10, long j11, String str, List<Word> words) {
            kotlin.jvm.internal.g.f(text, "text");
            kotlin.jvm.internal.g.f(words, "words");
            this.text = text;
            this.startTime = j10;
            this.endTime = j11;
            this.speakerId = str;
            this.words = words;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Speaker {
        private final float[] embedding;

        /* renamed from: id, reason: collision with root package name */
        private final String f7233id;

        public Speaker(String id2, float[] fArr) {
            kotlin.jvm.internal.g.f(id2, "id");
            this.f7233id = id2;
            this.embedding = fArr;
        }

        public static /* synthetic */ Speaker copy$default(Speaker speaker, String str, float[] fArr, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = speaker.f7233id;
            }
            if ((i10 & 2) != 0) {
                fArr = speaker.embedding;
            }
            return speaker.copy(str, fArr);
        }

        public final String component1() {
            return this.f7233id;
        }

        public final float[] component2() {
            return this.embedding;
        }

        public final Speaker copy(String id2, float[] fArr) {
            kotlin.jvm.internal.g.f(id2, "id");
            return new Speaker(id2, fArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Speaker)) {
                return false;
            }
            Speaker speaker = (Speaker) obj;
            return kotlin.jvm.internal.g.b(this.f7233id, speaker.f7233id) && kotlin.jvm.internal.g.b(this.embedding, speaker.embedding);
        }

        public final float[] getEmbedding() {
            return this.embedding;
        }

        public final String getId() {
            return this.f7233id;
        }

        public int hashCode() {
            int iHashCode = this.f7233id.hashCode() * 31;
            float[] fArr = this.embedding;
            return iHashCode + (fArr == null ? 0 : Arrays.hashCode(fArr));
        }

        public String toString() {
            return h0.e.c("Speaker(id=", this.f7233id, ", embedding=", Arrays.toString(this.embedding), ")");
        }

        public /* synthetic */ Speaker(String str, float[] fArr, int i10, kotlin.jvm.internal.e eVar) {
            this(str, (i10 & 2) != 0 ? null : fArr);
        }
    }

    public AsrFileResult(double d8, String str, List list, List list2, int i10, kotlin.jvm.internal.e eVar) {
        this(d8, str, (i10 & 4) != 0 ? EmptyList.f10001a : list, (i10 & 8) != 0 ? EmptyList.f10001a : list2);
    }
}
