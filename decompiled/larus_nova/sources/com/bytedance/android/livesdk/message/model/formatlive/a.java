package com.bytedance.android.livesdk.message.model.formatlive;

import com.bytedance.android.livesdkapi.message.ExternalMessageType;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f153640a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f153641b = 0;

    static {
        ExternalMessageType r100 = ExternalMessageType.EXTERNAL_FORMAT_LIVE;
        f153640a = r100.getMin();
        f153641b = r100.getMin() + 1;
    }
}
