package com.bytedance.android.livesdk.schema.event;

import android.content.DialogInterface;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/schema/event/OpenVsPanelEvent;", "", "uri", "Landroid/net/Uri;", "type", "", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "(Landroid/net/Uri;ILandroid/content/DialogInterface$OnDismissListener;)V", "getDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "getType", "()I", "getUri", "()Landroid/net/Uri;", "Companion", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenVsPanelEvent {
    public static final Companion Companion = null;
    public static final int TYPE_H5 = 0;
    public static final int TYPE_LYNX = 1;
    private final DialogInterface.OnDismissListener dismissListener;
    private final int type;
    private final Uri uri;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/schema/event/OpenVsPanelEvent$Companion;", "", "()V", "TYPE_H5", "", "TYPE_LYNX", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final DialogInterface.OnDismissListener getDismissListener() {
        return this.dismissListener;
    }

    public final int getType() {
        return this.type;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public OpenVsPanelEvent(Uri r100, int r101, DialogInterface.OnDismissListener r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.uri = r100;
        this.type = r101;
        this.dismissListener = r102;
    }

    public /* synthetic */ OpenVsPanelEvent(Uri r100, int r101, DialogInterface.OnDismissListener r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
