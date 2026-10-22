package com.bytedance.android.livehostapi.platform.depend.im;

import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/im/IMEmoji;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "", CommonConstant.KEY_DISPLAY_NAME, "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "Lpy/k;", "staticUrl", "Lpy/k;", "getStaticUrl", "()Lpy/k;", "setStaticUrl", "(Lpy/k;)V", "<init>", "()V", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMEmoji {
    private String displayName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f102941id;
    private k staticUrl;

    public IMEmoji() {
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getId() {
        return this.f102941id;
    }

    public final k getStaticUrl() {
        return this.staticUrl;
    }

    public final void setDisplayName(String r100) {
        this.displayName = r100;
    }

    public final void setId(long r100) {
        this.f102941id = r100;
    }

    public final void setStaticUrl(k r100) {
        this.staticUrl = r100;
    }
}
