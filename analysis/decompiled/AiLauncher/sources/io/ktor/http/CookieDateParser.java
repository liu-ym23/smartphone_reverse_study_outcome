package io.ktor.http;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.core.AMapException;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5680i;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/http/CookieDateParser;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", "source", "name", "field", "LY8/t;", "checkFieldNotNull", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "", "requirement", "Lkotlin/Function0;", "msg", "checkRequirement", "(Ljava/lang/String;ZLp9/a;)V", "Lio/ktor/util/date/GMTDate;", M5.e.FAIL_PARSE, "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CookieDateParser {
    private final <T> void checkFieldNotNull(String source, String name, T field) {
        if (field != null) {
            return;
        }
        throw new InvalidCookieDateException(source, "Could not find " + name);
    }

    private final void checkRequirement(String source, boolean requirement, InterfaceC5063a<String> msg) {
        if (!requirement) {
            throw new InvalidCookieDateException(source, msg.invoke());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$5() {
        return "day-of-month not in [1,31]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$6() {
        return "year >= 1601";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$7() {
        return "hours > 23";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$8() {
        return "minutes > 59";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parse$lambda$9() {
        return "seconds > 59";
    }

    public final GMTDate parse(String source) throws NumberFormatException {
        kotlin.jvm.internal.p.i(source, "source");
        StringLexer stringLexer = new StringLexer(source);
        CookieDateBuilder cookieDateBuilder = new CookieDateBuilder();
        stringLexer.acceptWhile(new InterfaceC5074l() { // from class: io.ktor.http.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CookieUtilsKt.isDelimiter(((Character) obj).charValue()));
            }
        });
        while (stringLexer.getHasRemaining()) {
            if (stringLexer.test(new InterfaceC5074l() { // from class: io.ktor.http.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(CookieUtilsKt.isNonDelimiter(((Character) obj).charValue()));
                }
            })) {
                int index = stringLexer.getIndex();
                stringLexer.acceptWhile(new InterfaceC5074l() { // from class: io.ktor.http.i
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CookieUtilsKt.isNonDelimiter(((Character) obj).charValue()));
                    }
                });
                String strSubstring = stringLexer.getSource().substring(index, stringLexer.getIndex());
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                CookieUtilsKt.handleToken(cookieDateBuilder, strSubstring);
                stringLexer.acceptWhile(new InterfaceC5074l() { // from class: io.ktor.http.j
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CookieUtilsKt.isDelimiter(((Character) obj).charValue()));
                    }
                });
            }
        }
        Integer year = cookieDateBuilder.getYear();
        C5680i c5680i = new C5680i(70, 99);
        if (year == null || !c5680i.j(year.intValue())) {
            C5680i c5680i2 = new C5680i(0, 69);
            if (year != null && c5680i2.j(year.intValue())) {
                Integer year2 = cookieDateBuilder.getYear();
                kotlin.jvm.internal.p.f(year2);
                cookieDateBuilder.setYear(Integer.valueOf(year2.intValue() + 2000));
            }
        } else {
            Integer year3 = cookieDateBuilder.getYear();
            kotlin.jvm.internal.p.f(year3);
            cookieDateBuilder.setYear(Integer.valueOf(year3.intValue() + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR));
        }
        checkFieldNotNull(source, "day-of-month", cookieDateBuilder.getDayOfMonth());
        checkFieldNotNull(source, "month", cookieDateBuilder.getMonth());
        checkFieldNotNull(source, "year", cookieDateBuilder.getYear());
        checkFieldNotNull(source, "time", cookieDateBuilder.getHours());
        checkFieldNotNull(source, "time", cookieDateBuilder.getMinutes());
        checkFieldNotNull(source, "time", cookieDateBuilder.getSeconds());
        C5680i c5680i3 = new C5680i(1, 31);
        Integer dayOfMonth = cookieDateBuilder.getDayOfMonth();
        checkRequirement(source, dayOfMonth != null && c5680i3.j(dayOfMonth.intValue()), new InterfaceC5063a() { // from class: io.ktor.http.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CookieDateParser.parse$lambda$5();
            }
        });
        Integer year4 = cookieDateBuilder.getYear();
        kotlin.jvm.internal.p.f(year4);
        checkRequirement(source, year4.intValue() >= 1601, new InterfaceC5063a() { // from class: io.ktor.http.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CookieDateParser.parse$lambda$6();
            }
        });
        Integer hours = cookieDateBuilder.getHours();
        kotlin.jvm.internal.p.f(hours);
        checkRequirement(source, hours.intValue() <= 23, new InterfaceC5063a() { // from class: io.ktor.http.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CookieDateParser.parse$lambda$7();
            }
        });
        Integer minutes = cookieDateBuilder.getMinutes();
        kotlin.jvm.internal.p.f(minutes);
        checkRequirement(source, minutes.intValue() <= 59, new InterfaceC5063a() { // from class: io.ktor.http.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CookieDateParser.parse$lambda$8();
            }
        });
        Integer seconds = cookieDateBuilder.getSeconds();
        kotlin.jvm.internal.p.f(seconds);
        checkRequirement(source, seconds.intValue() <= 59, new InterfaceC5063a() { // from class: io.ktor.http.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CookieDateParser.parse$lambda$9();
            }
        });
        return cookieDateBuilder.build();
    }
}
