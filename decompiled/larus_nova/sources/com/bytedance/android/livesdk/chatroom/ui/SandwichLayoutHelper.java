package com.bytedance.android.livesdk.chatroom.ui;

import com.ss.android.lark.url.card.UrlCardProperty;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class SandwichLayoutHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f112528b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f9 f112529a;

    public static final class a {
    }

    public SandwichLayoutHelper() {
    }

    public static String a(int r100) {
        if (r100 != 1) goto L5;
        return "enter_room";
    L5:
        if (r100 != 2) goto L7;
        return "on_configuration_changed";
    L7:
        if (r100 == 3) goto L9;
        return "unknown";
    L9:
        return UrlCardProperty.URL_PREVIEW_BUSINESS_HOST;
    }

    static {
        f112528b = LazyKt.lazy(SandwichLayoutHelper$Companion$enable$2.INSTANCE);
    }
}
