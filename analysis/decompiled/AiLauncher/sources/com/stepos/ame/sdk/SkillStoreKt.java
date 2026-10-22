package com.stepos.ame.sdk;

import Y8.j;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import b9.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a<\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00010\u0004*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010*\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001b\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a\"\u0014\u0010\u001c\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a\"\u0014\u0010\u001d\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001a\"\u0014\u0010\u001e\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a\"\u0014\u0010\u001f\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001a\"\u0014\u0010 \u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001a\"\u0014\u0010!\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001a\"\u0014\u0010\"\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001a\"\u0014\u0010#\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001a\"\u0014\u0010$\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001a\"\u0014\u0010%\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u001a\"\u0014\u0010&\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u001a\" \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(\"\u0014\u0010*\u001a\u00020)8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020)8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+\"\u0014\u0010-\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineSession;", "", "Lcom/stepos/ame/sdk/SkillEntry;", "entries", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "insertSkills", "(Lcom/stepos/ame/sdk/AMEngineSession;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "queryVector", "", "topK", "overfetchRatio", "Lcom/stepos/ame/sdk/SkillHit;", "querySkills", "(Lcom/stepos/ame/sdk/AMEngineSession;[FIILe9/c;)Ljava/lang/Object;", "", "", "", "toMetadataMap", "(Lcom/stepos/ame/sdk/SkillEntry;)Ljava/util/Map;", "Lcom/stepos/ame/sdk/SearchResult;", "rawResults", "aggregateSkillHits", "(Ljava/util/List;I)Ljava/util/List;", "SKILL_DOC_TYPE_ROOT", "Ljava/lang/String;", "SKILL_DOC_TYPE_REFERENCE", "SKILL_DOC_TYPE_CONTENT", "SKILL_SOURCE_TYPE", "META_SOURCE_TYPE", "META_IS_DELETED", "META_CATEGORY", "META_DOC_TYPE", "META_FILE_PATH", "META_CONTENT", "META_VERSION", "META_CREATE_TIME", "FIELD_TYPE_STRING", "SKILL_CUSTOM_FIELDS", "Ljava/util/Map;", "", "SKILL_ROOT_BOOST", "F", "REFERENCE_PENALTY", "DEFAULT_OVERFETCH_RATIO", "I", "vector_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SkillStoreKt {
    private static final int DEFAULT_OVERFETCH_RATIO = 4;
    private static final String META_CATEGORY = "category";
    private static final String META_CONTENT = "content";
    private static final String META_CREATE_TIME = "create_time";
    private static final String META_IS_DELETED = "is_deleted";
    private static final String META_SOURCE_TYPE = "source_type";
    private static final String META_VERSION = "version";
    private static final float REFERENCE_PENALTY = 0.85f;
    public static final String SKILL_DOC_TYPE_CONTENT = "content";
    public static final String SKILL_DOC_TYPE_REFERENCE = "reference";
    public static final String SKILL_DOC_TYPE_ROOT = "skill_root";
    private static final float SKILL_ROOT_BOOST = 1.1f;
    private static final String SKILL_SOURCE_TYPE = "skill";
    private static final String META_DOC_TYPE = "doc_type";
    private static final String FIELD_TYPE_STRING = "STRING";
    private static final String META_FILE_PATH = "file_path";
    private static final Map<String, String> SKILL_CUSTOM_FIELDS = a.m(j.a(META_DOC_TYPE, FIELD_TYPE_STRING), j.a(META_FILE_PATH, FIELD_TYPE_STRING), j.a("content", FIELD_TYPE_STRING));

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006$"}, d2 = {"com/stepos/ame/sdk/SkillStoreKt$aggregateSkillHits$Candidate", "", "vectorId", "", "skillId", "", "adjustedScore", "", "filePath", "docType", "content", "<init>", "(JLjava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVectorId", "()J", "getSkillId", "()Ljava/lang/String;", "getAdjustedScore", "()F", "getFilePath", "getDocType", "getContent", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "(JLjava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ame/sdk/SkillStoreKt$aggregateSkillHits$Candidate;", "equals", "", "other", "hashCode", "", "toString", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Candidate {
        private final float adjustedScore;
        private final String content;
        private final String docType;
        private final String filePath;
        private final String skillId;
        private final long vectorId;

        public Candidate(long j10, String skillId, float f10, String filePath, String docType, String content) {
            p.i(skillId, "skillId");
            p.i(filePath, "filePath");
            p.i(docType, "docType");
            p.i(content, "content");
            this.vectorId = j10;
            this.skillId = skillId;
            this.adjustedScore = f10;
            this.filePath = filePath;
            this.docType = docType;
            this.content = content;
        }

        public static /* synthetic */ Candidate copy$default(Candidate candidate, long j10, String str, float f10, String str2, String str3, String str4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = candidate.vectorId;
            }
            long j11 = j10;
            if ((i10 & 2) != 0) {
                str = candidate.skillId;
            }
            String str5 = str;
            if ((i10 & 4) != 0) {
                f10 = candidate.adjustedScore;
            }
            float f11 = f10;
            if ((i10 & 8) != 0) {
                str2 = candidate.filePath;
            }
            String str6 = str2;
            if ((i10 & 16) != 0) {
                str3 = candidate.docType;
            }
            String str7 = str3;
            if ((i10 & 32) != 0) {
                str4 = candidate.content;
            }
            return candidate.copy(j11, str5, f11, str6, str7, str4);
        }

        /* renamed from: component1, reason: from getter */
        public final long getVectorId() {
            return this.vectorId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSkillId() {
            return this.skillId;
        }

        /* renamed from: component3, reason: from getter */
        public final float getAdjustedScore() {
            return this.adjustedScore;
        }

        /* renamed from: component4, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        /* renamed from: component5, reason: from getter */
        public final String getDocType() {
            return this.docType;
        }

        /* renamed from: component6, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public final Candidate copy(long vectorId, String skillId, float adjustedScore, String filePath, String docType, String content) {
            p.i(skillId, "skillId");
            p.i(filePath, "filePath");
            p.i(docType, "docType");
            p.i(content, "content");
            return new Candidate(vectorId, skillId, adjustedScore, filePath, docType, content);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Candidate)) {
                return false;
            }
            Candidate candidate = (Candidate) other;
            return this.vectorId == candidate.vectorId && p.d(this.skillId, candidate.skillId) && Float.compare(this.adjustedScore, candidate.adjustedScore) == 0 && p.d(this.filePath, candidate.filePath) && p.d(this.docType, candidate.docType) && p.d(this.content, candidate.content);
        }

        public final float getAdjustedScore() {
            return this.adjustedScore;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getDocType() {
            return this.docType;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final String getSkillId() {
            return this.skillId;
        }

        public final long getVectorId() {
            return this.vectorId;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.vectorId) * 31) + this.skillId.hashCode()) * 31) + Float.hashCode(this.adjustedScore)) * 31) + this.filePath.hashCode()) * 31) + this.docType.hashCode()) * 31) + this.content.hashCode();
        }

        public String toString() {
            return "Candidate(vectorId=" + this.vectorId + ", skillId=" + this.skillId + ", adjustedScore=" + this.adjustedScore + ", filePath=" + this.filePath + ", docType=" + this.docType + ", content=" + this.content + ")";
        }
    }

    @InterfaceC4112d(c = "com.stepos.ame.sdk.SkillStoreKt", f = "SkillStore.kt", l = {DidiCardView.FINISHED_SUMMARY_WIDTH_DP, 182}, m = "insertSkills")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.ame.sdk.SkillStoreKt$insertSkills$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SkillStoreKt.insertSkills(null, null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ame.sdk.SkillStoreKt", f = "SkillStore.kt", l = {238}, m = "querySkills")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.ame.sdk.SkillStoreKt$querySkills$1, reason: invalid class name and case insensitive filesystem */
    public static final class C38091 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C38091(InterfaceC4014c<? super C38091> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SkillStoreKt.querySkills(null, null, 0, 0, this);
        }
    }

    private static final List<SkillHit> aggregateSkillHits(List<SearchResult> list, int i10) {
        float score;
        float score2;
        float f10;
        float f11;
        Candidate candidate;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SearchResult searchResult : list) {
            Map<String, Object> metadata = searchResult.getMetadata();
            if (metadata != null) {
                Object obj = metadata.get("category");
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    Object obj2 = metadata.get(META_DOC_TYPE);
                    String str2 = obj2 instanceof String ? (String) obj2 : null;
                    String str3 = str2 == null ? "content" : str2;
                    Object obj3 = metadata.get(META_FILE_PATH);
                    String str4 = obj3 instanceof String ? (String) obj3 : null;
                    String str5 = str4 == null ? "" : str4;
                    Object obj4 = metadata.get("content");
                    String str6 = obj4 instanceof String ? (String) obj4 : null;
                    String str7 = str6 == null ? "" : str6;
                    if (p.d(str3, SKILL_DOC_TYPE_ROOT)) {
                        score2 = searchResult.getScore();
                        f10 = 1.1f;
                    } else if (p.d(str3, SKILL_DOC_TYPE_REFERENCE)) {
                        score2 = searchResult.getScore();
                        f10 = 0.85f;
                    } else {
                        score = searchResult.getScore();
                        f11 = score;
                        candidate = (Candidate) linkedHashMap.get(str);
                        if (candidate != null || f11 > candidate.getAdjustedScore()) {
                            linkedHashMap.put(str, new Candidate(searchResult.getId(), str, f11, str5, str3, str7));
                        }
                    }
                    score = score2 * f10;
                    f11 = score;
                    candidate = (Candidate) linkedHashMap.get(str);
                    if (candidate != null) {
                    }
                    linkedHashMap.put(str, new Candidate(searchResult.getId(), str, f11, str5, str3, str7));
                }
            }
        }
        Collection collectionValues = linkedHashMap.values();
        p.h(collectionValues, "<get-values>(...)");
        List listF1 = F.f1(F.c1(collectionValues, new Comparator() { // from class: com.stepos.ame.sdk.SkillStoreKt$aggregateSkillHits$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b.d(Float.valueOf(((SkillStoreKt.Candidate) t11).getAdjustedScore()), Float.valueOf(((SkillStoreKt.Candidate) t10).getAdjustedScore()));
            }
        }), i10);
        ArrayList arrayList = new ArrayList(C1174w.x(listF1, 10));
        int i11 = 0;
        for (Object obj5 : listF1) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            Candidate candidate2 = (Candidate) obj5;
            arrayList.add(new SkillHit(i12, candidate2.getVectorId(), candidate2.getSkillId(), candidate2.getAdjustedScore(), candidate2.getFilePath(), candidate2.getDocType(), candidate2.getContent()));
            i11 = i12;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0156, code lost:
    
        if (r15 != r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0107 A[LOOP:0: B:41:0x0101->B:43:0x0107, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128 A[LOOP:1: B:45:0x0122->B:47:0x0128, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00ac -> B:17:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0156 -> B:13:0x003d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object insertSkills(com.stepos.ame.sdk.AMEngineSession r13, java.util.List<com.stepos.ame.sdk.SkillEntry> r14, e9.InterfaceC4014c<? super com.stepos.ame.sdk.AMEngineResult<long[]>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ame.sdk.SkillStoreKt.insertSkills(com.stepos.ame.sdk.AMEngineSession, java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object querySkills(com.stepos.ame.sdk.AMEngineSession r10, float[] r11, int r12, int r13, e9.InterfaceC4014c<? super com.stepos.ame.sdk.AMEngineResult<? extends java.util.List<com.stepos.ame.sdk.SkillHit>>> r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof com.stepos.ame.sdk.SkillStoreKt.C38091
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ame.sdk.SkillStoreKt$querySkills$1 r0 = (com.stepos.ame.sdk.SkillStoreKt.C38091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ame.sdk.SkillStoreKt$querySkills$1 r0 = new com.stepos.ame.sdk.SkillStoreKt$querySkills$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r12 = r0.I$0
            kotlin.C4849c.b(r14)
            goto Lad
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            kotlin.C4849c.b(r14)
            int r14 = r11.length
            if (r14 != 0) goto L49
            com.stepos.ame.sdk.AMEngineResult$Companion r4 = com.stepos.ame.sdk.AMEngineResult.INSTANCE
            com.stepos.ame.sdk.AMEError r5 = com.stepos.ame.sdk.AMEError.ARGS_EMPTY_INPUT
            r8 = 4
            r9 = 0
            java.lang.String r6 = "queryVector 不能为空"
            r7 = 0
            com.stepos.ame.sdk.AMEngineResult r10 = com.stepos.ame.sdk.AMEngineResult.Companion.failure$default(r4, r5, r6, r7, r8, r9)
            return r10
        L49:
            if (r12 > 0) goto L5b
            com.stepos.ame.sdk.AMEngineResult$Companion r0 = com.stepos.ame.sdk.AMEngineResult.INSTANCE
            com.stepos.ame.sdk.AMEError r1 = com.stepos.ame.sdk.AMEError.ARGS_INVALID_TOPK
            java.lang.String r2 = r1.getDesc()
            r4 = 4
            r5 = 0
            r3 = 0
            com.stepos.ame.sdk.AMEngineResult r10 = com.stepos.ame.sdk.AMEngineResult.Companion.failure$default(r0, r1, r2, r3, r4, r5)
            return r10
        L5b:
            F6.a$a r14 = F6.a.INSTANCE
            F6.b$f r2 = new F6.b$f
            java.lang.String r4 = "skill"
            r2.<init>(r4)
            java.lang.String r4 = "source_type"
            F6.a r2 = r14.b(r4, r2)
            F6.b$a r4 = new F6.b$a
            r5 = 0
            r4.<init>(r5)
            java.lang.String r5 = "is_deleted"
            F6.a r4 = r14.b(r5, r4)
            F6.a[] r2 = new F6.a[]{r2, r4}
            F6.a r14 = r14.a(r2)
            com.stepos.ame.sdk.SearchArgs$Companion r2 = com.stepos.ame.sdk.SearchArgs.INSTANCE
            int r4 = r12 * r13
            int r4 = java.lang.Math.max(r4, r12)
            com.stepos.ame.sdk.SearchArgs$Builder r11 = r2.builder(r11, r4)
            com.stepos.ame.sdk.SearchArgs$Builder r11 = r11.filterCondition(r14)
            com.stepos.ame.api.FilterStrategy r14 = com.stepos.ame.api.FilterStrategy.POST_FILTER
            com.stepos.ame.sdk.SearchArgs$Builder r11 = r11.filterStrategy(r14)
            com.stepos.ame.sdk.SearchArgs$Builder r11 = r11.overfetchRatio(r13)
            com.stepos.ame.sdk.SearchArgs$Builder r11 = r11.withMetadata(r3)
            com.stepos.ame.sdk.SearchArgs r11 = r11.build()
            r0.I$0 = r12
            r0.label = r3
            java.lang.Object r14 = r10.search(r11, r0)
            if (r14 != r1) goto Lad
            return r1
        Lad:
            com.stepos.ame.sdk.AMEngineResult r14 = (com.stepos.ame.sdk.AMEngineResult) r14
            boolean r10 = r14 instanceof com.stepos.ame.sdk.AMEngineResult.Failure
            if (r10 == 0) goto Lb4
            return r14
        Lb4:
            boolean r10 = r14 instanceof com.stepos.ame.sdk.AMEngineResult.Success
            if (r10 == 0) goto Lcb
            com.stepos.ame.sdk.AMEngineResult$Companion r10 = com.stepos.ame.sdk.AMEngineResult.INSTANCE
            com.stepos.ame.sdk.AMEngineResult$Success r14 = (com.stepos.ame.sdk.AMEngineResult.Success) r14
            java.lang.Object r11 = r14.getValue()
            java.util.List r11 = (java.util.List) r11
            java.util.List r11 = aggregateSkillHits(r11, r12)
            com.stepos.ame.sdk.AMEngineResult r10 = r10.ok(r11)
            return r10
        Lcb:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ame.sdk.SkillStoreKt.querySkills(com.stepos.ame.sdk.AMEngineSession, float[], int, int, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object querySkills$default(AMEngineSession aMEngineSession, float[] fArr, int i10, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 5;
        }
        if ((i12 & 4) != 0) {
            i11 = 4;
        }
        return querySkills(aMEngineSession, fArr, i10, i11, interfaceC4014c);
    }

    private static final Map<String, Object> toMetadataMap(SkillEntry skillEntry) {
        Map mapC = Q.c();
        mapC.put(META_CREATE_TIME, Long.valueOf(System.currentTimeMillis()));
        mapC.put(META_IS_DELETED, Boolean.FALSE);
        mapC.put("version", 1L);
        mapC.put(META_SOURCE_TYPE, "skill");
        mapC.put("category", skillEntry.getSkillId());
        mapC.put(META_DOC_TYPE, skillEntry.getDocType());
        mapC.put(META_FILE_PATH, skillEntry.getFilePath());
        if (skillEntry.getContent().length() > 0) {
            mapC.put("content", skillEntry.getContent());
        }
        return Q.b(mapC);
    }
}
