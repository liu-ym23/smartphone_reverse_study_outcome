package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceRedPackageConfig;", "", "enterFromType", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isLinkPage", "", "callback", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;", "logParams", "", "", "(ILandroid/content/Context;ZLcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;Ljava/util/Map;)V", "getCallback", "()Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;", "getContext", "()Landroid/content/Context;", "getEnterFromType", "()I", "()Z", "getLogParams", "()Ljava/util/Map;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceRedPackageConfig {
    private final AnnounceCommandCallback callback;
    private final Context context;
    private final int enterFromType;
    private final boolean isLinkPage;
    private final Map<String, String> logParams;

    public final AnnounceCommandCallback getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getEnterFromType() {
        return this.enterFromType;
    }

    public final Map<String, String> getLogParams() {
        return this.logParams;
    }

    public final boolean isLinkPage() {
        return this.isLinkPage;
    }

    public OpenAnnounceRedPackageConfig(int r100, Context r101, boolean r102, AnnounceCommandCallback r103, Map<String, String> r104) {
        this.enterFromType = r100;
        this.context = r101;
        this.isLinkPage = r102;
        this.callback = r103;
        this.logParams = r104;
    }

    public /* synthetic */ OpenAnnounceRedPackageConfig(int r100, Context r101, boolean r102, AnnounceCommandCallback r110, Map r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
