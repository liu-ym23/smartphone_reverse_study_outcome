package com.bytedance.android.livesdk.schema.intercept;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/schema/intercept/RewriteSchemaVo;", "", "isIntercept", "", "rewriteUri", "Landroid/net/Uri;", "(ZLandroid/net/Uri;)V", "()Z", "setIntercept", "(Z)V", "getRewriteUri", "()Landroid/net/Uri;", "setRewriteUri", "(Landroid/net/Uri;)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RewriteSchemaVo {
    private boolean isIntercept;
    private Uri rewriteUri;

    /* JADX WARN: Multi-variable type inference failed */
    public RewriteSchemaVo() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public final Uri getRewriteUri() {
        return this.rewriteUri;
    }

    public final boolean isIntercept() {
        return this.isIntercept;
    }

    public final void setIntercept(boolean r100) {
        this.isIntercept = r100;
    }

    public final void setRewriteUri(Uri r100) {
        this.rewriteUri = r100;
    }

    public RewriteSchemaVo(boolean r100, Uri r101) {
        this.isIntercept = r100;
        this.rewriteUri = r101;
    }

    public /* synthetic */ RewriteSchemaVo(boolean r100, Uri r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
