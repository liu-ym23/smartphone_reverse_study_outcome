package com.bytedance.android.live.liveinteract.animation.universalwidget.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f71375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f71376b = null;

    static {
        f71375a = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        f71376b = new Gson();
    }
}
