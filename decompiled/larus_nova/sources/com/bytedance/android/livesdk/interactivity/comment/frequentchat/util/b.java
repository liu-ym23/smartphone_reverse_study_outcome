package com.bytedance.android.livesdk.interactivity.comment.frequentchat.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.live.network.response.Response;
import ga2.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f134926a = 0;

    static {
    }

    public static void b(String r100, Response r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "response");
        RequestError r102 = r101.error;
        if (r102 == null) goto L5;
        String r103 = r102.prompts;
    L6:
        f2.c(r103, 0);
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        r104.append(" status code error, ");
        RequestError r105 = r101.error;
        if (r105 == null) goto L10;
        String r106 = r105.prompts;
        if (r106 == null) goto L10;
    L11:
        r104.append(r106);
        r104.append(", log id: ");
        r104.append(r101.logId);
        ALogger.e("FrequentChatApi", r104.toString());
        return;
    L10:
        r106 = "";
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public static void a(Throwable r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "defaultPrompt");
        if (r100 == null) goto L8;
        String r103 = e.a(r100);
        if (r103 == null) goto L8;
        r102 = r103;
    L8:
        f2.c(r102, 0);
        ALogger.e("FrequentChatApi", r101 + " Api Error: " + r102);
    }
}
