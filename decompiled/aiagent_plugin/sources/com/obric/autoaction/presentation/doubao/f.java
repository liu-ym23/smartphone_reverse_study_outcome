package com.obric.autoaction.presentation.doubao;

import android.net.Uri;
import com.obric.autogui.common.api.presentation.WidgetState;
import d.h.b.o;

/* JADX INFO: compiled from: AssistWidgetUri.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f24886a = null;

    static {
        f24886a = new f();
    }

    private f() {
    }

    public final Uri a(WidgetState r2) {
        o.e(r2, "state");
        return a(r2.getSessionInfo().getSessionKey().toString());
    }

    public final Uri a(String r2) {
        o.e(r2, "sessionKey");
        Uri r1 = new Uri.Builder().scheme("assistant_card").authority("com.larus.nova").path("oauto_task_status_card").appendQueryParameter("card_id", r2).appendQueryParameter("card_service_name", "com.obric.aiagent.assistant_card.CardProviderService").build();
        o.c(r1, "build(...)");
        return r1;
    }
}
