package com.obric.aiagent.assistant_card.provider_core.a;

import android.net.Uri;

/* JADX INFO: compiled from: CardConstants.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f16332b = null;

    private a() {
    }

    public final Uri a() {
        return f16332b;
    }

    static {
        f16331a = new a();
        f16332b = Uri.parse("content://com.obric.assistant.remote_card_container.cardhost.CardHostCP");
    }
}
