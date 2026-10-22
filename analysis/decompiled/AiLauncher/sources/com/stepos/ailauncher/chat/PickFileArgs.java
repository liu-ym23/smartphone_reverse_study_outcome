package com.stepos.ailauncher.chat;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/d;", "", "Lcom/stepos/ailauncher/chat/PickFileType;", "type", "Landroid/net/Uri;", "uri", "", "maxImageCount", "<init>", "(Lcom/stepos/ailauncher/chat/PickFileType;Landroid/net/Uri;I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/chat/PickFileType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/chat/PickFileType;", "Landroid/net/Uri;", "c", "()Landroid/net/Uri;", "I", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.d, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PickFileArgs {
    private final int maxImageCount;
    private final PickFileType type;
    private final Uri uri;

    public PickFileArgs(PickFileType type, Uri uri, int i10) {
        kotlin.jvm.internal.p.i(type, "type");
        this.type = type;
        this.uri = uri;
        this.maxImageCount = i10;
    }

    /* renamed from: a, reason: from getter */
    public final int getMaxImageCount() {
        return this.maxImageCount;
    }

    /* renamed from: b, reason: from getter */
    public final PickFileType getType() {
        return this.type;
    }

    /* renamed from: c, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickFileArgs)) {
            return false;
        }
        PickFileArgs pickFileArgs = (PickFileArgs) other;
        return this.type == pickFileArgs.type && kotlin.jvm.internal.p.d(this.uri, pickFileArgs.uri) && this.maxImageCount == pickFileArgs.maxImageCount;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        Uri uri = this.uri;
        return ((iHashCode + (uri == null ? 0 : uri.hashCode())) * 31) + Integer.hashCode(this.maxImageCount);
    }

    public String toString() {
        return "PickFileArgs(type=" + this.type + ", uri=" + this.uri + ", maxImageCount=" + this.maxImageCount + ")";
    }

    public /* synthetic */ PickFileArgs(PickFileType pickFileType, Uri uri, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(pickFileType, (i11 & 2) != 0 ? null : uri, (i11 & 4) != 0 ? 10 : i10);
    }
}
