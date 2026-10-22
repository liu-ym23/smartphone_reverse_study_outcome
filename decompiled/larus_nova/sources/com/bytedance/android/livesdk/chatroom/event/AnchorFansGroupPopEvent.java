package com.bytedance.android.livesdk.chatroom.event;

import android.text.Spannable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/event/AnchorFansGroupPopEvent;", "", "content", "Landroid/text/Spannable;", "schema", "", "extra", "", "(Landroid/text/Spannable;Ljava/lang/String;Ljava/util/Map;)V", "getContent", "()Landroid/text/Spannable;", "getExtra", "()Ljava/util/Map;", "getSchema", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorFansGroupPopEvent {
    private final Spannable content;
    private final Map<String, String> extra;
    private final String schema;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorFansGroupPopEvent copy$default(AnchorFansGroupPopEvent r100, Spannable r101, String r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.schema;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Spannable component1() {
        return this.content;
    }

    public final String component2() {
        return this.schema;
    }

    public final Map<String, String> component3() {
        return this.extra;
    }

    public final AnchorFansGroupPopEvent copy(Spannable r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return new AnchorFansGroupPopEvent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorFansGroupPopEvent) == false) goto L12;
        AnchorFansGroupPopEvent r101 = (AnchorFansGroupPopEvent) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Spannable r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.schema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.extra;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorFansGroupPopEvent(content=" + this.content + ", schema=" + this.schema + ", extra=" + this.extra + ")";
    }

    public final Spannable getContent() {
        return this.content;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getSchema() {
        return this.schema;
    }

    public AnchorFansGroupPopEvent(Spannable r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.content = r100;
        this.schema = r101;
        this.extra = r102;
    }
}
