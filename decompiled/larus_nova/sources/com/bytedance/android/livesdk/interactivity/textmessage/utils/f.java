package com.bytedance.android.livesdk.interactivity.textmessage.utils;

import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, List<String>> f141230a = null;

    public interface a {
        void onFailure();

        void onSuccess();
    }

    static {
        HashMap<String, List<String>> r100 = new HashMap();
        f141230a = r100;
        r100.put("models", CollectionsKt.arrayListOf(new String[]{"tt_matting"}));
    }
}
