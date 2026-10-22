package com.bumptech.glide.util;

import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bumptech/glide/util/GlideCacheUtils;", "", "<init>", "()V", "TAG", "", "TAG_ENOSPC", "isNoSpaceLeft", "", "isNoSpaceLeft$annotations", "()Z", "setNoSpaceLeft", "(Z)V", "onWriteCacheFailed", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideCacheUtils {
    public static final GlideCacheUtils INSTANCE = null;
    private static final String TAG = "GlideCacheUtils";
    private static final String TAG_ENOSPC = "No space left on device";
    private static boolean isNoSpaceLeft;

    static {
        INSTANCE = new GlideCacheUtils();
    }

    private GlideCacheUtils() {
    }

    @JvmStatic
    public static /* synthetic */ void isNoSpaceLeft$annotations() {
    }

    public static final boolean isNoSpaceLeft() {
        return isNoSpaceLeft;
    }

    @JvmStatic
    public static final void onWriteCacheFailed(Exception r100) {
        boolean r101 = false;
        if (r100 == null) goto L9;
        String r102 = r100.getMessage();
        if (r102 == null) goto L9;
        if (StringsKt.contains$default(r102, TAG_ENOSPC, false, 2, null) != true) goto L9;
        r101 = true;
    L9:
        if (r101 == false) goto L12;
        Log.e(TAG, "no space left on device");
        isNoSpaceLeft = true;
        return;
    }

    public static final void setNoSpaceLeft(boolean r100) {
        isNoSpaceLeft = r100;
    }
}
