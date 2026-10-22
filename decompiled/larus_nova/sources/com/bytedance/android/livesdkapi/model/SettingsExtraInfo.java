package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SettingsExtraInfo;", "", "enterFrom", "", "isPreview", "", "(Ljava/lang/String;Z)V", "getEnterFrom", "()Ljava/lang/String;", "()Z", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsExtraInfo {
    private final String enterFrom;
    private final boolean isPreview;

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    public SettingsExtraInfo(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        this.enterFrom = r100;
        this.isPreview = r101;
    }
}
