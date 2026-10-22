package com.stepos.stepclaw.memory.storage.index;

import c5.s;
import c5.v;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J-\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130 2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/Tokenizer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "segmentText", "(Ljava/lang/String;)Ljava/util/List;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "char", "Lcom/stepos/stepclaw/memory/storage/index/Tokenizer$SegmentType;", "getCharType", "(C)Lcom/stepos/stepclaw/memory/storage/index/Tokenizer$SegmentType;", "segment", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isChinese", "(Ljava/lang/String;)Z", "isEnglish", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "startPosition", "Lcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;", "config", "Lcom/stepos/stepclaw/memory/storage/index/Token;", "tokenizeChinese", "(Ljava/lang/String;ILcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;)Ljava/util/List;", "tokenizeEnglish", "tokenize", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;)Ljava/util/List;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "extractTerms", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;)Ljava/util/Set;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "termFrequency", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/storage/index/TokenizerConfig;)Ljava/util/Map;", "Lx5/l;", "CHINESE_RANGE", "Lx5/l;", "SegmentType", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Tokenizer {
    public static final Tokenizer INSTANCE = new Tokenizer();
    private static final x5.l CHINESE_RANGE = new x5.l("[\\u4e00-\\u9fa5]");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/Tokenizer$SegmentType;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "CHINESE", "ENGLISH", "OTHER", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SegmentType {
        private static final /* synthetic */ i5.a $ENTRIES;
        private static final /* synthetic */ SegmentType[] $VALUES;
        public static final SegmentType CHINESE = new SegmentType("CHINESE", 0);
        public static final SegmentType ENGLISH = new SegmentType("ENGLISH", 1);
        public static final SegmentType OTHER = new SegmentType("OTHER", 2);

        private static final /* synthetic */ SegmentType[] $values() {
            return new SegmentType[]{CHINESE, ENGLISH, OTHER};
        }

        static {
            SegmentType[] segmentTypeArr$values = $values();
            $VALUES = segmentTypeArr$values;
            $ENTRIES = a.a.F(segmentTypeArr$values);
        }

        private SegmentType(String str, int i8) {
        }

        public static i5.a getEntries() {
            return $ENTRIES;
        }

        public static SegmentType valueOf(String str) {
            return (SegmentType) Enum.valueOf(SegmentType.class, str);
        }

        public static SegmentType[] values() {
            return (SegmentType[]) $VALUES.clone();
        }
    }

    private Tokenizer() {
    }

    public static /* synthetic */ Set extractTerms$default(Tokenizer tokenizer, String str, TokenizerConfig tokenizerConfig, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            tokenizerConfig = new TokenizerConfig(null, 0, false, 7, null);
        }
        return tokenizer.extractTerms(str, tokenizerConfig);
    }

    private final SegmentType getCharType(char c3) {
        return CHINESE_RANGE.e(String.valueOf(c3)) ? SegmentType.CHINESE : Character.isLetterOrDigit(c3) ? SegmentType.ENGLISH : SegmentType.OTHER;
    }

    private final boolean isChinese(String segment) {
        if (segment.length() > 0) {
            return CHINESE_RANGE.e(String.valueOf(x5.n.m1(segment)));
        }
        return false;
    }

    private final boolean isEnglish(String segment) {
        return segment.length() > 0 && Character.isLetterOrDigit(x5.n.m1(segment));
    }

    private final List<String> segmentText(String text) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = text.length();
        SegmentType segmentType = null;
        int i8 = 0;
        while (i8 < length) {
            char cCharAt = text.charAt(i8);
            SegmentType charType = getCharType(cCharAt);
            if (charType != segmentType && sb.length() > 0) {
                String string = sb.toString();
                kotlin.jvm.internal.p.d(string, "toString(...)");
                arrayList.add(string);
                sb.setLength(0);
            }
            sb.append(cCharAt);
            i8++;
            segmentType = charType;
        }
        if (sb.length() > 0) {
            String string2 = sb.toString();
            kotlin.jvm.internal.p.d(string2, "toString(...)");
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static /* synthetic */ Map termFrequency$default(Tokenizer tokenizer, String str, TokenizerConfig tokenizerConfig, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            tokenizerConfig = new TokenizerConfig(null, 0, false, 7, null);
        }
        return tokenizer.termFrequency(str, tokenizerConfig);
    }

    public static /* synthetic */ List tokenize$default(Tokenizer tokenizer, String str, TokenizerConfig tokenizerConfig, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            tokenizerConfig = new TokenizerConfig(null, 0, false, 7, null);
        }
        return tokenizer.tokenize(str, tokenizerConfig);
    }

    private final List<Token> tokenizeChinese(String text, int startPosition, TokenizerConfig config) {
        ArrayList arrayList = new ArrayList();
        List listS1 = x5.n.S1(text);
        int i8 = 0;
        if (config.getLevels().contains(NgramLevel.UNIGRAM)) {
            int i9 = 0;
            for (Object obj : listS1) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    c5.n.m0();
                    throw null;
                }
                arrayList.add(new Token(String.valueOf(((Character) obj).charValue()), i9 + startPosition, NgramLevel.UNIGRAM));
                i9 = i10;
            }
        }
        if (config.getLevels().contains(NgramLevel.BIGRAM) && listS1.size() >= 2) {
            int size = listS1.size() - 1;
            int i11 = 0;
            while (i11 < size) {
                Object obj2 = listS1.get(i11);
                int i12 = i11 + 1;
                Object obj3 = listS1.get(i12);
                StringBuilder sb = new StringBuilder();
                sb.append(obj2);
                sb.append(obj3);
                arrayList.add(new Token(sb.toString(), i11 + startPosition, NgramLevel.BIGRAM));
                i11 = i12;
            }
        }
        if (config.getLevels().contains(NgramLevel.TRIGRAM) && listS1.size() >= 3) {
            int size2 = listS1.size() - 2;
            while (i8 < size2) {
                Object obj4 = listS1.get(i8);
                int i13 = i8 + 1;
                Object obj5 = listS1.get(i13);
                Object obj6 = listS1.get(i8 + 2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj4);
                sb2.append(obj5);
                sb2.append(obj6);
                arrayList.add(new Token(sb2.toString(), i8 + startPosition, NgramLevel.TRIGRAM));
                i8 = i13;
            }
        }
        return arrayList;
    }

    private final List<Token> tokenizeEnglish(String text, int startPosition, TokenizerConfig config) {
        ArrayList arrayList = new ArrayList();
        Set<NgramLevel> levels = config.getLevels();
        NgramLevel ngramLevel = NgramLevel.UNIGRAM;
        if (levels.contains(ngramLevel)) {
            arrayList.add(new Token(text, startPosition, ngramLevel));
        }
        List listS1 = x5.n.S1(text);
        int i8 = 0;
        if (config.getLevels().contains(NgramLevel.BIGRAM) && listS1.size() >= 2) {
            int size = listS1.size() - 1;
            int i9 = 0;
            while (i9 < size) {
                Object obj = listS1.get(i9);
                int i10 = i9 + 1;
                Object obj2 = listS1.get(i10);
                StringBuilder sb = new StringBuilder();
                sb.append(obj);
                sb.append(obj2);
                arrayList.add(new Token(sb.toString(), i9 + startPosition, NgramLevel.BIGRAM));
                i9 = i10;
            }
        }
        if (config.getLevels().contains(NgramLevel.TRIGRAM) && listS1.size() >= 3) {
            int size2 = listS1.size() - 2;
            while (i8 < size2) {
                Object obj3 = listS1.get(i8);
                int i11 = i8 + 1;
                Object obj4 = listS1.get(i11);
                Object obj5 = listS1.get(i8 + 2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj3);
                sb2.append(obj4);
                sb2.append(obj5);
                arrayList.add(new Token(sb2.toString(), i8 + startPosition, NgramLevel.TRIGRAM));
                i8 = i11;
            }
        }
        return arrayList;
    }

    public final Set<String> extractTerms(String text, TokenizerConfig config) {
        kotlin.jvm.internal.p.e(text, "text");
        kotlin.jvm.internal.p.e(config, "config");
        List<Token> list = tokenize(text, config);
        ArrayList arrayList = new ArrayList(c5.o.n0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Token) it.next()).getToken());
        }
        return c5.m.R0(arrayList);
    }

    public final Map<String, Integer> termFrequency(String text, TokenizerConfig config) {
        kotlin.jvm.internal.p.e(text, "text");
        kotlin.jvm.internal.p.e(config, "config");
        final List<Token> list = tokenize(text, config);
        v vVar = new v() { // from class: com.stepos.stepclaw.memory.storage.index.Tokenizer$termFrequency$$inlined$groupingBy$1
            @Override // c5.v
            public String keyOf(Token element) {
                return element.getToken();
            }

            @Override // c5.v
            public Iterator<Token> sourceIterator() {
                return list.iterator();
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itSourceIterator = vVar.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Object objKeyOf = vVar.keyOf(itSourceIterator.next());
            Object wVar = linkedHashMap.get(objKeyOf);
            if (wVar == null && !linkedHashMap.containsKey(objKeyOf)) {
                wVar = new w();
            }
            w wVar2 = (w) wVar;
            wVar2.f3684a++;
            linkedHashMap.put(objKeyOf, wVar2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.jvm.internal.p.c(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            if ((entry instanceof q5.a) && !(entry instanceof q5.d)) {
                d0.d(entry, "kotlin.collections.MutableMap.MutableEntry");
                throw null;
            }
            entry.setValue(Integer.valueOf(((w) entry.getValue()).f3684a));
        }
        if (!(linkedHashMap instanceof q5.a) || (linkedHashMap instanceof q5.e)) {
            return linkedHashMap;
        }
        d0.d(linkedHashMap, "kotlin.collections.MutableMap");
        throw null;
    }

    public final List<Token> tokenize(String text, TokenizerConfig config) {
        kotlin.jvm.internal.p.e(text, "text");
        kotlin.jvm.internal.p.e(config, "config");
        if (config.getLowercase()) {
            text = text.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.d(text, "toLowerCase(...)");
        }
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        int length = 0;
        for (String str : segmentText(text)) {
            arrayList.addAll(isChinese(str) ? tokenizeChinese(str, length, config) : isEnglish(str) ? tokenizeEnglish(str, length, config) : s.f1092a);
            length += str.length();
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            if (((Token) obj).getToken().length() >= config.getMinTokenLength()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
