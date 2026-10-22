package io.ktor.http;

import io.ktor.util.date.Month;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a%\u0010\u000b\u001a\u00020\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0011\u001a\u00020\t*\u00020\r2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000eH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0015\u001a\u00020\t*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\t*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016\u001a+\u0010\u0018\u001a\u00020\t*\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0013H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u001b\u0010\u001b\u001a\u00020\t*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"", "", "isDelimiter", "(C)Z", "isNonDelimiter", "isOctet", "isNonDigit", "isDigit", "Lkotlin/Function0;", "LY8/t;", "block", "otherwise", "(ZLp9/a;)V", "", "Lkotlin/Function3;", "", "success", "tryParseTime", "(Ljava/lang/String;Lp9/q;)V", "Lkotlin/Function1;", "Lio/ktor/util/date/Month;", "tryParseMonth", "(Ljava/lang/String;Lp9/l;)V", "tryParseDayOfMonth", "tryParseYear", "Lio/ktor/http/CookieDateBuilder;", M5.b.CREDENTIAL_TOKEN, "handleToken", "(Lio/ktor/http/CookieDateBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CookieUtilsKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseDayOfMonth$1, reason: invalid class name */
    public static final class AnonymousClass1 implements InterfaceC5074l<Character, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(CookieUtilsKt.isNonDigit(c10));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseDayOfMonth$2, reason: invalid class name */
    public static final class AnonymousClass2 implements InterfaceC5074l<Character, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(CookieUtilsKt.isOctet(c10));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42761 implements InterfaceC5074l<Character, Boolean> {
        public static final C42761 INSTANCE = new C42761();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(c10 == ':');
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$3, reason: invalid class name */
    public static final class AnonymousClass3 implements InterfaceC5074l<Character, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(c10 == ':');
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$5, reason: invalid class name */
    public static final class AnonymousClass5 implements InterfaceC5074l<Character, Boolean> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(CookieUtilsKt.isNonDigit(c10));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseTime$6, reason: invalid class name */
    public static final class AnonymousClass6 implements InterfaceC5074l<Character, Boolean> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(CookieUtilsKt.isOctet(c10));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseYear$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42771 implements InterfaceC5074l<Character, Boolean> {
        public static final C42771 INSTANCE = new C42771();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(CookieUtilsKt.isNonDigit(c10));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.http.CookieUtilsKt$tryParseYear$2, reason: invalid class name and case insensitive filesystem */
    public static final class C42782 implements InterfaceC5074l<Character, Boolean> {
        public static final C42782 INSTANCE = new C42782();

        public final Boolean invoke(char c10) {
            return Boolean.valueOf(CookieUtilsKt.isOctet(c10));
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
            return invoke(ch.charValue());
        }
    }

    public static final void handleToken(CookieDateBuilder cookieDateBuilder, String token) throws NumberFormatException {
        kotlin.jvm.internal.p.i(cookieDateBuilder, "<this>");
        kotlin.jvm.internal.p.i(token, "token");
        if (cookieDateBuilder.getHours() == null || cookieDateBuilder.getMinutes() == null || cookieDateBuilder.getSeconds() == null) {
            StringLexer stringLexer = new StringLexer(token);
            int index = stringLexer.getIndex();
            if (stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE)) {
                stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
                String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                int i10 = Integer.parseInt(strSubstring);
                if (stringLexer.accept(C42761.INSTANCE)) {
                    int index2 = stringLexer.getIndex();
                    if (stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE)) {
                        stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                        String strSubstring2 = stringLexer.getSource().substring(index2, stringLexer.getIndex());
                        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                        int i11 = Integer.parseInt(strSubstring2);
                        if (stringLexer.accept(AnonymousClass3.INSTANCE)) {
                            int index3 = stringLexer.getIndex();
                            if (stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE)) {
                                stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                                String strSubstring3 = stringLexer.getSource().substring(index3, stringLexer.getIndex());
                                kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                                int i12 = Integer.parseInt(strSubstring3);
                                if (stringLexer.accept(AnonymousClass5.INSTANCE)) {
                                    stringLexer.acceptWhile(AnonymousClass6.INSTANCE);
                                }
                                cookieDateBuilder.setHours(Integer.valueOf(i10));
                                cookieDateBuilder.setMinutes(Integer.valueOf(i11));
                                cookieDateBuilder.setSeconds(Integer.valueOf(i12));
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (cookieDateBuilder.getDayOfMonth() == null) {
            StringLexer stringLexer2 = new StringLexer(token);
            int index4 = stringLexer2.getIndex();
            if (stringLexer2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE)) {
                stringLexer2.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
                String strSubstring4 = stringLexer2.getSource().substring(index4, stringLexer2.getIndex());
                kotlin.jvm.internal.p.h(strSubstring4, "substring(...)");
                int i13 = Integer.parseInt(strSubstring4);
                if (stringLexer2.accept(AnonymousClass1.INSTANCE)) {
                    stringLexer2.acceptWhile(AnonymousClass2.INSTANCE);
                }
                cookieDateBuilder.setDayOfMonth(Integer.valueOf(i13));
                return;
            }
        }
        if (cookieDateBuilder.getMonth() == null && token.length() >= 3) {
            for (Month month : Month.getEntries()) {
                if (La.D.V(token, month.getValue(), true)) {
                    cookieDateBuilder.setMonth(month);
                    return;
                }
            }
        }
        if (cookieDateBuilder.getYear() == null) {
            StringLexer stringLexer3 = new StringLexer(token);
            int index5 = stringLexer3.getIndex();
            for (int i14 = 0; i14 < 2; i14++) {
                if (!stringLexer3.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE)) {
                    return;
                }
            }
            for (int i15 = 0; i15 < 2; i15++) {
                stringLexer3.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
            }
            String strSubstring5 = stringLexer3.getSource().substring(index5, stringLexer3.getIndex());
            kotlin.jvm.internal.p.h(strSubstring5, "substring(...)");
            int i16 = Integer.parseInt(strSubstring5);
            if (stringLexer3.accept(C42771.INSTANCE)) {
                stringLexer3.acceptWhile(C42782.INSTANCE);
            }
            cookieDateBuilder.setYear(Integer.valueOf(i16));
        }
    }

    public static final boolean isDelimiter(char c10) {
        if (c10 == '\t') {
            return true;
        }
        if (' ' <= c10 && c10 < '0') {
            return true;
        }
        if (';' <= c10 && c10 < 'A') {
            return true;
        }
        if ('[' > c10 || c10 >= 'a') {
            return '{' <= c10 && c10 < 127;
        }
        return true;
    }

    public static final boolean isDigit(char c10) {
        return '0' <= c10 && c10 < ':';
    }

    public static final boolean isNonDelimiter(char c10) {
        if (c10 >= 0 && c10 < '\t') {
            return true;
        }
        if ('\n' <= c10 && c10 < ' ') {
            return true;
        }
        if (('0' <= c10 && c10 < ':') || c10 == ':') {
            return true;
        }
        if ('a' <= c10 && c10 < '{') {
            return true;
        }
        if ('A' > c10 || c10 >= '[') {
            return 127 <= c10 && c10 < 256;
        }
        return true;
    }

    public static final boolean isNonDigit(char c10) {
        if (c10 < 0 || c10 >= '0') {
            return 'J' <= c10 && c10 < 256;
        }
        return true;
    }

    public static final boolean isOctet(char c10) {
        return c10 >= 0 && c10 < 256;
    }

    public static final void otherwise(boolean z10, InterfaceC5063a<Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        if (z10) {
            return;
        }
        block.invoke();
    }

    public static final void tryParseDayOfMonth(String str, InterfaceC5074l<? super Integer, Y8.t> success) throws NumberFormatException {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        if (stringLexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE)) {
            stringLexer.accept(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
            String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            int i10 = Integer.parseInt(strSubstring);
            if (stringLexer.accept(AnonymousClass1.INSTANCE)) {
                stringLexer.acceptWhile(AnonymousClass2.INSTANCE);
            }
            success.invoke(Integer.valueOf(i10));
        }
    }

    public static final void tryParseMonth(String str, InterfaceC5074l<? super Month, Y8.t> success) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(success, "success");
        if (str.length() < 3) {
            return;
        }
        for (Month month : Month.getEntries()) {
            if (La.D.V(str, month.getValue(), true)) {
                success.invoke(month);
                return;
            }
        }
    }

    public static final void tryParseTime(String str, p9.q<? super Integer, ? super Integer, ? super Integer, Y8.t> success) throws NumberFormatException {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        if (stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE)) {
            stringLexer.accept(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
            String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            int i10 = Integer.parseInt(strSubstring);
            if (stringLexer.accept(C42761.INSTANCE)) {
                int index2 = stringLexer.getIndex();
                if (stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE)) {
                    stringLexer.accept(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                    String strSubstring2 = stringLexer.getSource().substring(index2, stringLexer.getIndex());
                    kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                    int i11 = Integer.parseInt(strSubstring2);
                    if (stringLexer.accept(AnonymousClass3.INSTANCE)) {
                        int index3 = stringLexer.getIndex();
                        if (stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE)) {
                            stringLexer.accept(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                            String strSubstring3 = stringLexer.getSource().substring(index3, stringLexer.getIndex());
                            kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                            int i12 = Integer.parseInt(strSubstring3);
                            if (stringLexer.accept(AnonymousClass5.INSTANCE)) {
                                stringLexer.acceptWhile(AnonymousClass6.INSTANCE);
                            }
                            success.invoke(Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
                        }
                    }
                }
            }
        }
    }

    public static final void tryParseYear(String str, InterfaceC5074l<? super Integer, Y8.t> success) throws NumberFormatException {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(success, "success");
        StringLexer stringLexer = new StringLexer(str);
        int index = stringLexer.getIndex();
        for (int i10 = 0; i10 < 2; i10++) {
            if (!stringLexer.accept(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE)) {
                return;
            }
        }
        for (int i11 = 0; i11 < 2; i11++) {
            stringLexer.accept(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
        }
        String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        int i12 = Integer.parseInt(strSubstring);
        if (stringLexer.accept(C42771.INSTANCE)) {
            stringLexer.acceptWhile(C42782.INSTANCE);
        }
        success.invoke(Integer.valueOf(i12));
    }
}
