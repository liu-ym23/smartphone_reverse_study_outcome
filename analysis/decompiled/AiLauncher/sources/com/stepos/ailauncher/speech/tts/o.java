package com.stepos.ailauncher.speech.tts;

import La.H;
import La.K;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001?B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0016J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J!\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010&J\u001f\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010&J\u001f\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010-J'\u00100\u001a\u0004\u0018\u00010\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100.2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b2\u0010\u0016J)\u00104\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040.\u0012\u0004\u0012\u00020\u0004032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u0010-J\u001f\u00107\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u0010-R\u0014\u00108\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010;\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010<\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/o;", "", "<init>", "()V", "", "text", "", "maxChars", "", "endOfStream", "Lcom/stepos/ailauncher/speech/tts/h;", "r", "(Ljava/lang/String;IZ)Lcom/stepos/ailauncher/speech/tts/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lcom/stepos/ailauncher/speech/tts/o$a;", "part", "limit", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/speech/tts/o$a;I)Lcom/stepos/ailauncher/speech/tts/h;", "l", "(Ljava/lang/String;)Ljava/lang/String;", "", "chars", "index", "m", "([CI)Z", "sent", "consumed", "u", "(Ljava/lang/String;I)Lcom/stepos/ailauncher/speech/tts/h;", "w", "", "c", "q", "(C)Z", "strong", "(Ljava/lang/String;I)Ljava/lang/String;", "max", "e", "strongLimit", "k", "(Ljava/lang/String;I)I", "p", "(Ljava/lang/String;I)Z", "", "parts", "s", "(Ljava/util/List;I)Lcom/stepos/ailauncher/speech/tts/h;", "t", "Lkotlin/Pair;", "v", "(Ljava/lang/String;)Lkotlin/Pair;", "o", "n", "COMMIT_GATE_MIN_CHARS", "I", "FEED_HARD_MAX_CHARS", "SENTENCE_FINISH_OVERSHOOT_CHARS", "GATE_STOPS", "[C", "STRONG_STOPS", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o {
    public static final int COMMIT_GATE_MIN_CHARS = 30;
    public static final int FEED_HARD_MAX_CHARS = 80;
    public static final int SENTENCE_FINISH_OVERSHOOT_CHARS = 24;
    public static final o INSTANCE = new o();
    private static final char[] GATE_STOPS = {12290, 65281, 65311, 65307, 65292, 12289, 65306, '\n', '.', '!', '?', ';', ',', ':'};
    private static final char[] STRONG_STOPS = {12290, 65281, 65311, 65307, '\n', '.', '!', ';'};

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/o$a;", "", "", "sent", "", "consumed", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.speech.tts.o$a, reason: from toString */
    public static final /* data */ class Part {
        private final int consumed;
        private final String sent;

        public Part(String sent, int i10) {
            kotlin.jvm.internal.p.i(sent, "sent");
            this.sent = sent;
            this.consumed = i10;
        }

        /* renamed from: a, reason: from getter */
        public final int getConsumed() {
            return this.consumed;
        }

        /* renamed from: b, reason: from getter */
        public final String getSent() {
            return this.sent;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Part)) {
                return false;
            }
            Part part = (Part) other;
            return kotlin.jvm.internal.p.d(this.sent, part.sent) && this.consumed == part.consumed;
        }

        public int hashCode() {
            return (this.sent.hashCode() * 31) + Integer.hashCode(this.consumed);
        }

        public String toString() {
            return "Part(sent=" + this.sent + ", consumed=" + this.consumed + ")";
        }
    }

    public static final boolean f(ArrayList<Character> arrayList, InterfaceC5074l<? super Character, Boolean> interfaceC5074l) {
        for (int size = arrayList.size() - 2; size >= 0; size--) {
            Character ch = arrayList.get(size);
            kotlin.jvm.internal.p.h(ch, "get(...)");
            if (interfaceC5074l.invoke(ch).booleanValue()) {
                arrayList.remove(size);
                return true;
            }
        }
        return false;
    }

    public static final boolean g(char c10) {
        return c10 == ' ';
    }

    public static final boolean h(char c10) {
        return c10 == 65292 || c10 == 65306 || c10 == 12289 || c10 == ',' || c10 == ':' || c10 == 65307 || c10 == ';';
    }

    public final String c(String text, int strong) {
        int i10 = strong + 1;
        int length = text.length() - i10;
        if (length > 0 && length < 30) {
            String strSubstring = text.substring(i10);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            for (int i11 = 0; i11 < strSubstring.length(); i11++) {
                if (!INSTANCE.q(strSubstring.charAt(i11))) {
                    String strE = e(H.S0(text, strong, i10).toString(), 80);
                    if (strE.length() > 80 || strE.length() < 30) {
                        return null;
                    }
                    return strE;
                }
            }
        }
        return null;
    }

    public final FeedSlice d(Part part, int limit) {
        if (part.getSent().length() <= limit) {
            return u(part.getSent(), part.getConsumed());
        }
        int iJ = C5685n.j(limit, part.getSent().length());
        int i10 = -1;
        for (int i11 = 0; i11 < iJ; i11++) {
            if (o(part.getSent(), i11) && i11 + 1 >= 30) {
                i10 = i11;
            }
        }
        int iF = i10 >= 0 ? i10 + 1 : C5685n.f(iJ, 1);
        String strSubstring = part.getSent().substring(0, iF);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return u(strSubstring, C5685n.f(C5685n.j(iF, part.getConsumed()), 1));
    }

    public final String e(String text, int max) {
        if (text.length() <= max) {
            return text;
        }
        ArrayList arrayList = new ArrayList(text.length());
        for (int i10 = 0; i10 < text.length(); i10++) {
            arrayList.add(Character.valueOf(text.charAt(i10)));
        }
        while (arrayList.size() > max && (f(arrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.speech.tts.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(o.g(((Character) obj).charValue()));
            }
        }) || f(arrayList, new InterfaceC5074l() { // from class: com.stepos.ailauncher.speech.tts.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(o.h(((Character) obj).charValue()));
            }
        }))) {
        }
        return F.A0(arrayList, "", null, null, 0, null, null, 62, null);
    }

    public final boolean i(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (text.length() < 30) {
            return false;
        }
        return o(text, H.n0(text));
    }

    public final boolean j(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        if (text.length() == 0) {
            return false;
        }
        char cP1 = K.P1(text);
        if (Z8.r.O(STRONG_STOPS, cP1)) {
            return (cP1 == '.' && n(text, H.n0(text))) ? false : true;
        }
        return false;
    }

    public final int k(String text, int strongLimit) {
        int iMin = Math.min(text.length(), C5685n.f(strongLimit, 1)) - 1;
        if (iMin < 29) {
            return -1;
        }
        for (int i10 = 29; i10 <= iMin; i10++) {
            if (p(text, i10)) {
                return i10;
            }
        }
        return -1;
    }

    public final String l(String text) {
        if (text.length() < 2) {
            return text;
        }
        char[] charArray = text.toCharArray();
        kotlin.jvm.internal.p.h(charArray, "toCharArray(...)");
        for (int iB0 = Z8.r.b0(charArray) - 1; iB0 >= 0; iB0--) {
            char c10 = charArray[iB0];
            if (c10 == 65292 || c10 == 12289 || c10 == ',') {
                int i10 = iB0 + 1;
                while (i10 < charArray.length && !m(charArray, i10)) {
                    i10++;
                }
                if (i10 < charArray.length && i10 - iB0 < 30) {
                    charArray[iB0] = ' ';
                }
            }
        }
        return new String(charArray);
    }

    public final boolean m(char[] chars, int index) {
        char c10 = chars[index];
        if (c10 == '.' && index > 0 && index < Z8.r.b0(chars) && Character.isDigit(chars[index - 1]) && Character.isDigit(chars[index + 1])) {
            return false;
        }
        return c10 == 12290 || c10 == 65281 || c10 == 65311 || c10 == 65307 || c10 == 65292 || c10 == 12289 || c10 == ',' || c10 == '.' || c10 == '!' || c10 == '?' || c10 == ';';
    }

    public final boolean n(String text, int index) {
        return index > 0 && index < H.n0(text) && Character.isDigit(text.charAt(index + (-1))) && Character.isDigit(text.charAt(index + 1));
    }

    public final boolean o(String text, int index) {
        if (index < 0 || index > H.n0(text)) {
            return false;
        }
        char cCharAt = text.charAt(index);
        if (cCharAt == '.' && n(text, index)) {
            return false;
        }
        return Z8.r.O(GATE_STOPS, cCharAt);
    }

    public final boolean p(String text, int index) {
        if (index < 0 || index > H.n0(text)) {
            return false;
        }
        char cCharAt = text.charAt(index);
        if ((cCharAt == '.' && n(text, index)) || cCharAt == '?') {
            return false;
        }
        return Z8.r.O(STRONG_STOPS, cCharAt);
    }

    public final boolean q(char c10) {
        return c10 == '\'' || c10 == '\"' || c10 == 8217 || c10 == 8221 || c10 == 12301 || c10 == 12303 || c10 == 65289 || c10 == ')' || c10 == 12305 || c10 == ']' || c10 == 12299 || c10 == 12297 || c10 == '>';
    }

    public final FeedSlice r(String text, int maxChars, boolean endOfStream) {
        List<Part> listT0;
        String strC;
        kotlin.jvm.internal.p.i(text, "text");
        if (text.length() == 0) {
            return null;
        }
        int iF = C5685n.f(maxChars, 1);
        int iK = k(text, 80);
        if (iK >= 0 && (endOfStream || iK < iF + 24)) {
            if (endOfStream && (strC = c(text, iK)) != null) {
                return u(strC, text.length());
            }
            int i10 = iK + 1;
            String strSubstring = text.substring(0, i10);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return u(strSubstring, i10);
        }
        Pair<List<String>, String> pairV = v(text);
        List<String> listA = pairV.a();
        String strB = pairV.b();
        if (!endOfStream) {
            List listI0 = listA.size() >= 2 ? F.i0(listA, 1) : C1173v.m();
            if (listI0.isEmpty()) {
                return null;
            }
            List<String> list = listI0;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (String str : list) {
                arrayList.add(new Part(str, str.length()));
            }
            return s(arrayList, iF);
        }
        if (listA.isEmpty()) {
            listT0 = C1172u.e(new Part(strB, strB.length()));
        } else if (strB.length() == 0) {
            List<String> list2 = listA;
            listT0 = new ArrayList<>(C1174w.x(list2, 10));
            for (String str2 : list2) {
                listT0.add(new Part(str2, str2.length()));
            }
        } else {
            String str3 = F.C0(listA) + strB;
            List<String> listI02 = F.i0(listA, 1);
            ArrayList arrayList2 = new ArrayList(C1174w.x(listI02, 10));
            for (String str4 : listI02) {
                arrayList2.add(new Part(str4, str4.length()));
            }
            listT0 = F.T0(arrayList2, new Part(t(str3), str3.length()));
        }
        FeedSlice feedSliceS = s(listT0, iF);
        if (feedSliceS != null) {
            return feedSliceS;
        }
        Part part = (Part) F.s0(listT0);
        if (part != null) {
            return part.getSent().length() <= 80 ? INSTANCE.u(part.getSent(), part.getConsumed()) : INSTANCE.d(part, 80);
        }
        return null;
    }

    public final FeedSlice s(List<Part> parts, int limit) {
        if (parts.isEmpty() || ((Part) F.q0(parts)).getSent().length() > limit) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        int consumed = 0;
        for (Part part : parts) {
            if (sb2.length() > 0 && sb2.length() + part.getSent().length() > limit) {
                break;
            }
            sb2.append(part.getSent());
            consumed += part.getConsumed();
        }
        if (sb2.length() == 0) {
            return null;
        }
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return u(string, consumed);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String t(java.lang.String r8) {
        /*
            r7 = this;
            int r7 = r8.length()
            int r7 = r7 + 1
            r0 = 0
            r1 = r0
        L8:
            java.lang.String r2 = "。"
            if (r1 >= r7) goto L7a
            com.stepos.ailauncher.speech.tts.o r3 = com.stepos.ailauncher.speech.tts.o.INSTANCE
            kotlin.Pair r4 = r3.v(r8)
            java.lang.Object r5 = r4.a()
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r4 = r4.b()
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.length()
            if (r6 != 0) goto L26
            return r8
        L26:
            boolean r5 = r5.isEmpty()
            r6 = 30
            if (r5 == 0) goto L35
            int r5 = r4.length()
            if (r5 >= r6) goto L35
            goto L82
        L35:
            int r5 = r4.length()
            if (r5 < r6) goto L4b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            return r7
        L4b:
            int r5 = r8.length()
            int r4 = r4.length()
            int r5 = r5 - r4
            int r4 = r5 + (-1)
            if (r4 < 0) goto L6a
            boolean r3 = r3.o(r8, r4)
            if (r3 != 0) goto L5f
            goto L6a
        L5f:
            java.lang.CharSequence r8 = La.H.S0(r8, r4, r5)
            java.lang.String r8 = r8.toString()
            int r1 = r1 + 1
            goto L8
        L6a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            return r7
        L7a:
            r7 = 2
            r1 = 0
            boolean r7 = La.D.K(r8, r2, r0, r7, r1)
            if (r7 == 0) goto L83
        L82:
            return r8
        L83:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r8)
            r7.append(r2)
            java.lang.String r7 = r7.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.o.t(java.lang.String):java.lang.String");
    }

    public final FeedSlice u(String sent, int consumed) {
        return new FeedSlice(w(l(sent)), consumed);
    }

    public final Pair<List<String>, String> v(String text) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < text.length()) {
            int i11 = i10;
            while (true) {
                if (i11 >= text.length()) {
                    i11 = -1;
                    break;
                }
                if (o(text, i11) && (i11 - i10) + 1 >= 30) {
                    break;
                }
                i11++;
            }
            if (i11 < 0) {
                String strSubstring = text.substring(i10);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                return Y8.j.a(arrayList, strSubstring);
            }
            int i12 = i11 + 1;
            String strSubstring2 = text.substring(i10, i12);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            arrayList.add(strSubstring2);
            i10 = i12;
        }
        return Y8.j.a(arrayList, "");
    }

    public final String w(String text) {
        char cCharAt;
        if (text.length() >= 2) {
            int length = text.length();
            while (length > 1 && q(text.charAt(length - 1))) {
                length--;
            }
            if (length != text.length() && ((cCharAt = text.charAt(length - 1)) == '!' || cCharAt == '.' || cCharAt == '?' || cCharAt == 12290 || cCharAt == 65281 || cCharAt == 65307 || cCharAt == 65311)) {
                String strSubstring = text.substring(0, length);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                return strSubstring;
            }
        }
        return text;
    }
}
