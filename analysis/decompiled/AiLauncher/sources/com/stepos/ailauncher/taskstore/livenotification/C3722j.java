package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.R$string;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/j;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Ljava/lang/String;", "text", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "fallback", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/text/Regex;", "RAW_SDK_FAILURE", "Lkotlin/text/Regex;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.j, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3722j {
    public static final C3722j INSTANCE = new C3722j();
    private static final Regex RAW_SDK_FAILURE = new Regex("(?i)ASL[E]?\\(\\d+\\)");

    public static /* synthetic */ String d(C3722j c3722j, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        return c3722j.c(str, str2);
    }

    public final String a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        String string = context.getString(R$string.taskstore_live_session_task_failed);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        return string;
    }

    public final boolean b(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        return !La.H.x0(text) && RAW_SDK_FAILURE.b(text);
    }

    public final String c(String text, String fallback) {
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(fallback, "fallback");
        return b(text) ? fallback : text;
    }
}
