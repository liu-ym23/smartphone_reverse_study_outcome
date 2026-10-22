package com.stepos.ailauncher.chat.view;

import La.C0951a;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h9.InterfaceC4149a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\r\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy;", "", "<init>", "()V", "", "text", "", "trainedWordIds", "", "voiceWakeupEnabled", "c", "(Ljava/lang/String;Ljava/util/Set;Z)Z", "Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/Set;Z)Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a;", "Lkotlin/text/Regex;", "e", "(Ljava/util/Set;)Lkotlin/text/Regex;", "ids", Const.INTENT_KEY_UMID, "(Ljava/util/Set;)Ljava/util/Set;", "wake", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lkotlin/text/Regex;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lkotlin/text/Regex;)Z", "f", "(Ljava/lang/String;)Ljava/lang/String;", "GAP", "Ljava/lang/String;", "EDGE_PUNCT", "Phrase", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ListenRewakePolicy {
    private static final String EDGE_PUNCT = ",，.。、!！?？~～:：;；\"'“”‘’()（）-—…";
    private static final String GAP = "[\\s,，.。、!！?？~～\\-]*";
    public static final ListenRewakePolicy INSTANCE = new ListenRewakePolicy();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$Phrase;", "", "id", "", "fragment", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getFragment", "AMOO_AMOO", "AMOO_CHULAI", "AZAI_AZAI", "AZAI_CHULAI", "body", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Phrase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phrase[] $VALUES;
        public static final Phrase AMOO_AMOO = new Phrase("AMOO_AMOO", 0, "amoo_amoo", DidiCardProvider.MARKET_SOURCE);
        public static final Phrase AMOO_CHULAI = new Phrase("AMOO_CHULAI", 1, "amoo_chulai", DidiCardProvider.MARKET_SOURCE);
        public static final Phrase AZAI_AZAI = new Phrase("AZAI_AZAI", 2, "azai_azai", "a仔");
        public static final Phrase AZAI_CHULAI = new Phrase("AZAI_CHULAI", 3, "azai_chulai", "a仔");
        private final String fragment;
        private final String id;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Phrase.values().length];
                try {
                    iArr[Phrase.AMOO_AMOO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Phrase.AMOO_CHULAI.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Phrase.AZAI_AZAI.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Phrase.AZAI_CHULAI.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ Phrase[] $values() {
            return new Phrase[]{AMOO_AMOO, AMOO_CHULAI, AZAI_AZAI, AZAI_CHULAI};
        }

        static {
            Phrase[] phraseArr$values = $values();
            $VALUES = phraseArr$values;
            $ENTRIES = kotlin.enums.a.a(phraseArr$values);
        }

        private Phrase(String str, int i10, String str2, String str3) {
            this.id = str2;
            this.fragment = str3;
        }

        public static InterfaceC4149a<Phrase> getEntries() {
            return $ENTRIES;
        }

        public static Phrase valueOf(String str) {
            return (Phrase) Enum.valueOf(Phrase.class, str);
        }

        public static Phrase[] values() {
            return (Phrase[]) $VALUES.clone();
        }

        public final String body() {
            int i10 = a.$EnumSwitchMapping$0[ordinal()];
            if (i10 == 1) {
                return "amoo[\\s,，.。、!！?？~～\\-]*amoo";
            }
            if (i10 == 2) {
                return "amoo[\\s,，.。、!！?？~～\\-]*出来";
            }
            if (i10 == 3) {
                return "a[\\s,，.。、!！?？~～\\-]*仔[\\s,，.。、!！?？~～\\-]*a[\\s,，.。、!！?？~～\\-]*仔";
            }
            if (i10 == 4) {
                return "a[\\s,，.。、!！?？~～\\-]*仔[\\s,，.。、!！?？~～\\-]*出来";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String getFragment() {
            return this.fragment;
        }

        public final String getId() {
            return this.id;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a$a;", "Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a$b;", "Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a$c;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class a {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a$a;", "Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.view.ListenRewakePolicy$a$a, reason: collision with other inner class name */
        public static final /* data */ class C0297a extends a {
            public static final C0297a INSTANCE = new C0297a();

            public C0297a() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof C0297a);
            }

            public int hashCode() {
                return -740309405;
            }

            public String toString() {
                return "DropAndRestart";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a$b;", "Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class b extends a {
            public static final b INSTANCE = new b();

            public b() {
                super(null);
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof b);
            }

            public int hashCode() {
                return 2012607406;
            }

            public String toString() {
                return "NotRewake";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a$c;", "Lcom/stepos/ailauncher/chat/view/ListenRewakePolicy$a;", "", "command", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.view.ListenRewakePolicy$a$c, reason: from toString */
        public static final /* data */ class SendRemainder extends a {
            private final String command;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SendRemainder(String command) {
                super(null);
                kotlin.jvm.internal.p.i(command, "command");
                this.command = command;
            }

            /* renamed from: a, reason: from getter */
            public final String getCommand() {
                return this.command;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SendRemainder) && kotlin.jvm.internal.p.d(this.command, ((SendRemainder) other).command);
            }

            public int hashCode() {
                return this.command.hashCode();
            }

            public String toString() {
                return "SendRemainder(command=" + this.command + ")";
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public final a a(String text, Set<String> trainedWordIds, boolean voiceWakeupEnabled) {
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(trainedWordIds, "trainedWordIds");
        if (!voiceWakeupEnabled) {
            return a.b.INSTANCE;
        }
        String string = La.H.D1(text).toString();
        Regex regexE = e(trainedWordIds);
        if (regexE == null) {
            return a.b.INSTANCE;
        }
        if (string.length() == 0 || !regexE.b(string)) {
            return a.b.INSTANCE;
        }
        String strG = g(string, regexE);
        if (kotlin.jvm.internal.p.d(strG, string)) {
            return b(string, regexE) ? a.C0297a.INSTANCE : a.b.INSTANCE;
        }
        String strF = f(strG);
        return strF.length() == 0 ? a.C0297a.INSTANCE : new a.SendRemainder(strF);
    }

    public final boolean b(String text, Regex wake) {
        La.m mVar = (La.m) SequencesKt___SequencesKt.Q(Regex.f(wake, text, 0, 2, null));
        if (mVar == null) {
            return false;
        }
        String strSubstring = text.substring(mVar.a().getLast() + 1);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        if (f(strSubstring).length() > 0) {
            return false;
        }
        String strSubstring2 = text.substring(0, mVar.a().getFirst());
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        return f(strSubstring2).length() > 0;
    }

    public final boolean c(String text, Set<String> trainedWordIds, boolean voiceWakeupEnabled) throws IOException {
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(trainedWordIds, "trainedWordIds");
        if (!voiceWakeupEnabled) {
            return false;
        }
        String lowerCase = f(text).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < lowerCase.length(); i10++) {
            char cCharAt = lowerCase.charAt(i10);
            if (!C0951a.c(cCharAt)) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        if (string.length() == 0) {
            return false;
        }
        Set<String> setD = d(trainedWordIds);
        InterfaceC4149a<Phrase> entries = Phrase.getEntries();
        if (entries != null && entries.isEmpty()) {
            return false;
        }
        for (Phrase phrase : entries) {
            if (setD.contains(phrase.getId()) && kotlin.jvm.internal.p.d(string, phrase.getFragment())) {
                return true;
            }
        }
        return false;
    }

    public final Set<String> d(Set<String> ids) {
        HashSet hashSet = new HashSet(ids.size());
        Iterator<T> it = ids.iterator();
        while (it.hasNext()) {
            String lowerCase = La.H.D1((String) it.next()).toString().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            hashSet.add(lowerCase);
        }
        return hashSet;
    }

    public final Regex e(Set<String> trainedWordIds) {
        Set<String> setD = d(trainedWordIds);
        InterfaceC4149a<Phrase> entries = Phrase.getEntries();
        ArrayList arrayList = new ArrayList();
        for (Phrase phrase : entries) {
            if (setD.contains(phrase.getId())) {
                arrayList.add(phrase);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Phrase) it.next()).body());
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return new Regex("(?i)(?<![a-z])(?:" + Z8.F.A0(arrayList2, "|", null, null, 0, null, null, 62, null) + ")(?![a-z])");
    }

    public final String f(String text) {
        int length = text.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            char cCharAt = text.charAt(!z10 ? i10 : length);
            boolean z11 = C0951a.c(cCharAt) || La.H.f0(EDGE_PUNCT, cCharAt, false, 2, null);
            if (z10) {
                if (!z11) {
                    break;
                }
                length--;
            } else if (z11) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return text.subSequence(i10, length + 1).toString();
    }

    public final String g(String text, Regex wake) {
        String string = La.H.D1(text).toString();
        boolean z10 = false;
        while (true) {
            La.m mVarD = Regex.d(wake, string, 0, 2, null);
            if (mVarD == null) {
                break;
            }
            String strSubstring = string.substring(0, mVarD.a().getFirst());
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            if (f(strSubstring).length() > 0) {
                break;
            }
            String strSubstring2 = string.substring(mVarD.a().getLast() + 1);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            string = La.H.D1(strSubstring2).toString();
            z10 = true;
        }
        return z10 ? string : text;
    }
}
