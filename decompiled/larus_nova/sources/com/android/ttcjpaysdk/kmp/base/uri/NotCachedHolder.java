package com.android.ttcjpaysdk.kmp.base.uri;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/NotCachedHolder;", "", "<init>", "()V", "NotCached", "", "getNotCached", "()Ljava/lang/String;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotCachedHolder {
    public static final int $stable = 0;
    public static final NotCachedHolder INSTANCE = null;
    private static final String NotCached = null;

    private NotCachedHolder() {
    }

    static {
        INSTANCE = new NotCachedHolder();
        NotCached = StringsKt.concatToString(new char[]{'N', 'O', OthersPermission.STICKY, ' ', 'C', 'A', 'C', 'H', 'E', 'D'});
    }

    public final String getNotCached() {
        return NotCached;
    }
}
