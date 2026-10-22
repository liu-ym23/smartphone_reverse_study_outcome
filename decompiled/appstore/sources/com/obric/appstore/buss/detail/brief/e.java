package com.obric.appstore.buss.detail.brief;

import com.obric.oui.time.ClockFormat;
import com.obric.oui.time.TimeStyle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Result;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f10654b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f10655c = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f10653a = new a(null);
        f10654b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        f10655c = new SimpleDateFormat("M/d HH:mm");
    }

    public e() {
    }

    public final String a(String r10) {
        q.g(r10, "date");
        Date r11 = b(r10);
        if (r11 == null) goto L8;
        Calendar r12 = Calendar.getInstance();
        r12.setTime(r11);
        if (r12.get(1) != Calendar.getInstance().get(1)) goto L7;
        String r13 = f10655c.format(r11);
    L9:
        if (r13 != null) goto L12;
        return r10;
    L12:
        return r13;
    L7:
        r13 = rd.b.a(TimeStyle.BRIEF_YMDHM, r11, ClockFormat.H24, false);
        goto L9
    L8:
        r13 = null;
        goto L9
    }

    public final Date b(String r10) {
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L4
        Object r12 = Result.m35constructorimpl(f10654b.parse(r10));     // Catch: Throwable -> L4
    L7:
        if (Result.m41isFailureimpl(r12) == false) goto L10;
        r12 = null;
    L10:
        return (Date) r12;
    L4:
        th = move-exception;
        Result.a r13 = Result.Companion;
        r12 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L7
    }
}
