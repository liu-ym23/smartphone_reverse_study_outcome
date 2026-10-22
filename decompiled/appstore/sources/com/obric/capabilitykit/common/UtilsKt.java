package com.obric.capabilitykit.common;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "dateToTimeStamp", "", "pattern", "date", "capabilitykitcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UtilsKt {

    @NotNull
    private static final Lazy gson$delegate = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11255a = null;

        static {
            f11255a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Gson invoke() {
            return a();
        }
    }

    static {
        gson$delegate = kotlin.b.b(a.f11255a);
    }

    @NotNull
    public static final String dateToTimeStamp(@NotNull String r10, @NotNull String r11) {
        kotlin.jvm.internal.q.g(r10, "pattern");
        kotlin.jvm.internal.q.g(r11, "date");
        Object r12 = null;
        Date r13 = new SimpleDateFormat(r10, Locale.getDefault()).parse(r11);     // Catch: Throwable -> L6
        if (r13 == null) goto L8;
        String r14 = Long.valueOf(r13.getTime()).toString();     // Catch: Throwable -> L6
    L9:
        Object r15 = Result.m35constructorimpl(r14);     // Catch: Throwable -> L6
    L13:
        if (Result.m41isFailureimpl(r15) == true) goto L16;
        r12 = r15;
    L16:
        String r16 = (String) r12;
        if (r16 != null) goto L22;
        return "";
    L22:
        return r16;
    L8:
        r14 = null;
    L6:
        th = move-exception;
        r15 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L13
    }

    public static final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }
}
