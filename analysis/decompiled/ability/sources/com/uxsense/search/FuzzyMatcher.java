package com.uxsense.search;

import D7.A;
import D7.F;
import D7.N;
import D7.v;
import D7.w;
import H4.o;
import Y7.f;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.parse.b;
import j9.InterfaceC1616j;
import j9.l;
import j9.m;
import j9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nJT\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f0\r2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\b\b\u0002\u0010\t\u001a\u00020\nJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0015\u001a\u00020\u0007J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J\"\u0010\u001e\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001cJ\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007J*\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J*\u0010$\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u0007¨\u0006)"}, d2 = {"Lcom/uxsense/search/FuzzyMatcher;", "", AppAgent.CONSTRUCT, "()V", "calculateScore", "", "query", "", TypedValues.AttributesType.S_TARGET, "mode", "Lcom/uxsense/search/MatchMode;", "calculateWeightedScore", "Lkotlin/Pair;", "", "Lcom/uxsense/search/MatchedField;", "fields", "weights", "Lcom/uxsense/search/FuzzyMatcher$FieldWeight;", "calculateFuzzyScore", "keywordMatchScore", "extractKeywords", "text", "ngramSimilarity", "s1", "s2", "n", "", "getNgrams", "", "levenshteinDistance", "jaccardSimilarity", "set1", "set2", "normalize", "findMatchedPart", "Lkotlin/Triple;", "highlightMatch", "prefix", "suffix", "FieldWeight", "DefaultWeights", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FuzzyMatcher {
    public static final FuzzyMatcher INSTANCE = new FuzzyMatcher();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/uxsense/search/FuzzyMatcher$DefaultWeights;", "", AppAgent.CONSTRUCT, "()V", "CREATION", "", "Lcom/uxsense/search/FuzzyMatcher$FieldWeight;", "getCREATION", "()Ljava/util/List;", "COMMENT", "getCOMMENT", "USER", "getUSER", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultWeights {
        public static final DefaultWeights INSTANCE = new DefaultWeights();
        private static final List<FieldWeight> CREATION = o.N(new FieldWeight("title", 3.0f), new FieldWeight("authorNickname", 4.5f), new FieldWeight("tags", 1.0f), new FieldWeight("content", 2.0f));
        private static final List<FieldWeight> COMMENT = o.N(new FieldWeight("nickname", 9.0f), new FieldWeight("content", 1.0f));
        private static final List<FieldWeight> USER = o.N(new FieldWeight("nickname", 4.0f), new FieldWeight("uuid", 8.0f), new FieldWeight("bio", 1.0f));

        private DefaultWeights() {
        }

        public final List<FieldWeight> getCOMMENT() {
            return COMMENT;
        }

        public final List<FieldWeight> getCREATION() {
            return CREATION;
        }

        public final List<FieldWeight> getUSER() {
            return USER;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MatchMode.values().length];
            try {
                iArr[MatchMode.EXACT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MatchMode.PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MatchMode.CONTAINS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MatchMode.FUZZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FuzzyMatcher() {
    }

    private final float calculateFuzzyScore(String query, String target) {
        if (m.h0(target, query, false)) {
            return Math.min(1.0f, ((query.length() / target.length()) * 0.3f) + 0.7f);
        }
        float fNgramSimilarity = ngramSimilarity(query, target, 2);
        float fLevenshteinDistance = (query.length() > 10 || target.length() > 50) ? 0.0f : 1.0f - (levenshteinDistance(query, target) / Math.max(query.length(), target.length()));
        float fKeywordMatchScore = keywordMatchScore(query, target);
        return ((((fNgramSimilarity + fLevenshteinDistance) + fKeywordMatchScore) / 3.0f) * 0.3f) + (Math.max(fNgramSimilarity, Math.max(fLevenshteinDistance, fKeywordMatchScore)) * 0.7f);
    }

    public static /* synthetic */ float calculateScore$default(FuzzyMatcher fuzzyMatcher, String str, String str2, MatchMode matchMode, int i, Object obj) {
        if ((i & 4) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        return fuzzyMatcher.calculateScore(str, str2, matchMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Pair calculateWeightedScore$default(FuzzyMatcher fuzzyMatcher, String str, List list, List list2, MatchMode matchMode, int i, Object obj) {
        if ((i & 4) != 0) {
            list2 = EmptyList.f4893a;
        }
        if ((i & 8) != 0) {
            matchMode = MatchMode.FUZZY;
        }
        return fuzzyMatcher.calculateWeightedScore(str, list, list2, matchMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractKeywords$lambda$1(InterfaceC1616j it) {
        k.f(it, "it");
        String lowerCase = ((l) it).c().toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final Triple<String, Integer, Integer> findMatchedPart(String query, String target) {
        String strNormalize = normalize(query);
        String strNormalize2 = normalize(target);
        int iQ0 = m.q0(strNormalize2, strNormalize, 0, false, 6);
        if (iQ0 >= 0) {
            String strSubstring = target.substring(Math.max(0, iQ0 - 5), Math.min(target.length(), query.length() + iQ0 + 5));
            k.e(strSubstring, "substring(...)");
            return new Triple<>(strSubstring, Integer.valueOf(iQ0), Integer.valueOf(query.length() + iQ0));
        }
        for (String str : extractKeywords(query)) {
            int iQ02 = m.q0(strNormalize2, str, 0, false, 6);
            if (iQ02 >= 0) {
                String strSubstring2 = target.substring(Math.max(0, iQ02 - 10), Math.min(target.length(), str.length() + iQ02 + 10));
                k.e(strSubstring2, "substring(...)");
                return new Triple<>(strSubstring2, Integer.valueOf(iQ02), Integer.valueOf(str.length() + iQ02));
            }
        }
        return new Triple<>("", -1, -1);
    }

    private final Set<String> getNgrams(String text, int n) {
        if (text.length() < n) {
            return N.Q(text);
        }
        f fVar = new f(0, text.length() - n, 1);
        ArrayList arrayList = new ArrayList(w.c0(fVar, 10));
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            int iNextInt = ((F) it).nextInt();
            String strSubstring = text.substring(iNextInt, iNextInt + n);
            k.e(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
        }
        return v.j1(arrayList);
    }

    public static /* synthetic */ String highlightMatch$default(FuzzyMatcher fuzzyMatcher, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "【";
        }
        if ((i & 8) != 0) {
            str4 = "】";
        }
        return fuzzyMatcher.highlightMatch(str, str2, str3, str4);
    }

    private final float keywordMatchScore(String query, String target) {
        List<String> listExtractKeywords = extractKeywords(query);
        if (listExtractKeywords.isEmpty()) {
            return 0.0f;
        }
        Iterator<String> it = listExtractKeywords.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (m.h0(target, it.next(), false)) {
                i++;
            }
        }
        return i / listExtractKeywords.size();
    }

    public static /* synthetic */ float ngramSimilarity$default(FuzzyMatcher fuzzyMatcher, String str, String str2, int i, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 2;
        }
        return fuzzyMatcher.ngramSimilarity(str, str2, i);
    }

    public final float calculateScore(String query, String target, MatchMode mode) {
        k.f(query, "query");
        k.f(target, "target");
        k.f(mode, "mode");
        if (m.s0(query) || m.s0(target)) {
            return 0.0f;
        }
        String strNormalize = normalize(query);
        String strNormalize2 = normalize(target);
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return calculateFuzzyScore(strNormalize, strNormalize2);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (m.h0(strNormalize2, strNormalize, false)) {
                    return Math.min(1.0f, (strNormalize.length() / strNormalize2.length()) * 2);
                }
                return 0.0f;
            }
            if (!t.e0(strNormalize2, strNormalize, false)) {
                return 0.0f;
            }
        } else if (!k.b(strNormalize, strNormalize2)) {
            return 0.0f;
        }
        return 1.0f;
    }

    public final Pair<Float, List<MatchedField>> calculateWeightedScore(String query, List<Pair<String, String>> fields, List<FieldWeight> weights, MatchMode mode) {
        k.f(query, "query");
        k.f(fields, "fields");
        k.f(weights, "weights");
        k.f(mode, "mode");
        if (m.s0(query)) {
            return new Pair<>(Float.valueOf(0.0f), EmptyList.f4893a);
        }
        List<FieldWeight> list = weights;
        int iP = a.P(w.c0(list, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        for (Object obj : list) {
            linkedHashMap.put(((FieldWeight) obj).getFieldName(), obj);
        }
        ArrayList arrayList = new ArrayList();
        float f = 0.0f;
        float f7 = 0.0f;
        for (Pair<String, String> pair : fields) {
            String str = (String) pair.f4886a;
            String str2 = (String) pair.b;
            if (!m.s0(str2)) {
                FieldWeight fieldWeight = (FieldWeight) linkedHashMap.get(str);
                float weight = fieldWeight != null ? fieldWeight.getWeight() : 1.0f;
                float fCalculateScore = calculateScore(query, str2, mode);
                if (fCalculateScore > 0.0f) {
                    f7 += fCalculateScore * weight;
                    f += weight;
                    Triple<String, Integer, Integer> tripleFindMatchedPart = findMatchedPart(query, str2);
                    arrayList.add(new MatchedField(str, str2, (String) tripleFindMatchedPart.f4891a, ((Number) tripleFindMatchedPart.b).intValue(), ((Number) tripleFindMatchedPart.c).intValue()));
                }
            }
        }
        return new Pair<>(Float.valueOf(f > 0.0f ? f7 / f : 0.0f), arrayList);
    }

    public final List<String> extractKeywords(String text) {
        k.f(text, "text");
        ArrayList arrayList = new ArrayList();
        String strNormalize = normalize(text);
        A.f0(arrayList, kotlin.sequences.a.m0(Regex.c(new Regex("[a-zA-Z]+"), strNormalize), new b(6)));
        StringBuilder sb = new StringBuilder();
        int length = strNormalize.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = strNormalize.charAt(i);
            if (cCharAt > 19968 && cCharAt < 40959) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        if (string.length() >= 2) {
            int length2 = string.length() - 1;
            for (int i6 = 0; i6 < length2; i6++) {
                String strSubstring = string.substring(i6, i6 + 2);
                k.e(strSubstring, "substring(...)");
                arrayList.add(strSubstring);
            }
        }
        if (string.length() > 0) {
            ArrayList arrayList2 = new ArrayList(string.length());
            for (int i10 = 0; i10 < string.length(); i10++) {
                arrayList2.add(String.valueOf(string.charAt(i10)));
            }
            arrayList.addAll(arrayList2);
        }
        return v.v0(arrayList);
    }

    public final String highlightMatch(String text, String query, String prefix, String suffix) {
        k.f(text, "text");
        k.f(query, "query");
        k.f(prefix, "prefix");
        k.f(suffix, "suffix");
        int iQ0 = m.q0(normalize(text), normalize(query), 0, false, 6);
        if (iQ0 < 0) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = text.substring(0, iQ0);
        k.e(strSubstring, "substring(...)");
        sb.append(strSubstring);
        sb.append(prefix);
        String strSubstring2 = text.substring(iQ0, query.length() + iQ0);
        k.e(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        sb.append(suffix);
        if (query.length() + iQ0 < text.length()) {
            String strSubstring3 = text.substring(query.length() + iQ0);
            k.e(strSubstring3, "substring(...)");
            sb.append(strSubstring3);
        }
        return sb.toString();
    }

    public final float jaccardSimilarity(Set<String> set1, Set<String> set2) {
        k.f(set1, "set1");
        k.f(set2, "set2");
        if (set1.isEmpty() && set2.isEmpty()) {
            return 1.0f;
        }
        if (set1.isEmpty() || set2.isEmpty()) {
            return 0.0f;
        }
        Set<String> set = set1;
        Set<String> set3 = set2;
        return v.F0(set, set3).size() / v.k1(set, set3).size();
    }

    public final int levenshteinDistance(String s12, String s22) {
        k.f(s12, "s1");
        k.f(s22, "s2");
        if (s12.equals(s22)) {
            return 0;
        }
        if (s12.length() == 0) {
            return s22.length();
        }
        if (s22.length() == 0) {
            return s12.length();
        }
        if (s12.length() > 100) {
            s12 = m.N0(100, s12);
        }
        if (s22.length() > 100) {
            s22 = m.N0(100, s22);
        }
        int length = s12.length();
        int length2 = s22.length();
        int i = length2 + 1;
        int[] iArr = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            iArr[i6] = i6;
        }
        int[] iArr2 = new int[i];
        if (1 <= length) {
            iArr = iArr2;
            int[] iArr3 = iArr;
            int i10 = 1;
            while (true) {
                iArr[0] = i10;
                if (1 <= length2) {
                    int i11 = 1;
                    while (true) {
                        int i12 = i11 - 1;
                        iArr[i11] = Math.min(iArr3[i11] + 1, Math.min(iArr[i12] + 1, iArr3[i12] + (s12.charAt(i10 + (-1)) == s22.charAt(i12) ? 0 : 1)));
                        if (i11 == length2) {
                            break;
                        }
                        i11++;
                    }
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                int[] iArr4 = iArr;
                iArr = iArr3;
                iArr3 = iArr4;
            }
        }
        return iArr[length2];
    }

    public final float ngramSimilarity(String s12, String s22, int n) {
        k.f(s12, "s1");
        k.f(s22, "s2");
        if (m.s0(s12) || m.s0(s22)) {
            return 0.0f;
        }
        if (s12.length() < n || s22.length() < n) {
            return s12.equals(s22) ? 1.0f : 0.0f;
        }
        Set<String> ngrams = getNgrams(s12, n);
        Set<String> ngrams2 = getNgrams(s22, n);
        int size = v.F0(ngrams, ngrams2).size();
        int size2 = v.k1(ngrams, ngrams2).size();
        if (size2 > 0) {
            return size / size2;
        }
        return 0.0f;
    }

    public final String normalize(String text) {
        k.f(text, "text");
        String lowerCase = text.toLowerCase(Locale.ROOT);
        k.e(lowerCase, "toLowerCase(...)");
        return m.R0(new Regex("[^\\w\\u4e00-\\u9fff\\s]").f(new Regex("[\\s]+").f(lowerCase, " "), "")).toString();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/uxsense/search/FuzzyMatcher$FieldWeight;", "", "fieldName", "", "weight", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;F)V", "getFieldName", "()Ljava/lang/String;", "getWeight", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class FieldWeight {
        private final String fieldName;
        private final float weight;

        public FieldWeight(String fieldName, float f) {
            k.f(fieldName, "fieldName");
            this.fieldName = fieldName;
            this.weight = f;
        }

        public static /* synthetic */ FieldWeight copy$default(FieldWeight fieldWeight, String str, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fieldWeight.fieldName;
            }
            if ((i & 2) != 0) {
                f = fieldWeight.weight;
            }
            return fieldWeight.copy(str, f);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFieldName() {
            return this.fieldName;
        }

        /* renamed from: component2, reason: from getter */
        public final float getWeight() {
            return this.weight;
        }

        public final FieldWeight copy(String fieldName, float weight) {
            k.f(fieldName, "fieldName");
            return new FieldWeight(fieldName, weight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FieldWeight)) {
                return false;
            }
            FieldWeight fieldWeight = (FieldWeight) other;
            return k.b(this.fieldName, fieldWeight.fieldName) && Float.compare(this.weight, fieldWeight.weight) == 0;
        }

        public final String getFieldName() {
            return this.fieldName;
        }

        public final float getWeight() {
            return this.weight;
        }

        public int hashCode() {
            return Float.hashCode(this.weight) + (this.fieldName.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FieldWeight(fieldName=");
            sb.append(this.fieldName);
            sb.append(", weight=");
            return androidx.appfunctions.metadata.a.n(sb, this.weight, ')');
        }

        public /* synthetic */ FieldWeight(String str, float f, int i, e eVar) {
            this(str, (i & 2) != 0 ? 1.0f : f);
        }
    }
}
