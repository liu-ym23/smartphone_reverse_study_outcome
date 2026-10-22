package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class AppEventUtilsKt {
    private static final Gson eventGson = null;

    static {
        Gson r0 = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).registerTypeAdapter(AppEvent.class, new AppEventTypeAdapter()).create();
        o.a(r0);
        eventGson = r0;
    }
}
