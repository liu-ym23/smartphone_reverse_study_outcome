package com.bytedance.android.livesdk.interactivity.service.emoji.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/emoji/model/EmojiUriNode;", "", "emojiUri", "Lcom/bytedance/android/livesdk/interactivity/service/emoji/model/EmojiUriModel;", "startIndex", "", "endIndex", "(Lcom/bytedance/android/livesdk/interactivity/service/emoji/model/EmojiUriModel;II)V", "getEmojiUri", "()Lcom/bytedance/android/livesdk/interactivity/service/emoji/model/EmojiUriModel;", "getEndIndex", "()I", "getStartIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmojiUriNode {
    private final EmojiUriModel emojiUri;
    private final int endIndex;
    private final int startIndex;

    public static /* synthetic */ EmojiUriNode copy$default(EmojiUriNode r100, EmojiUriModel r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.emojiUri;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.startIndex;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.endIndex;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final EmojiUriModel component1() {
        return this.emojiUri;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final EmojiUriNode copy(EmojiUriModel r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "emojiUri");
        return new EmojiUriNode(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof EmojiUriNode) == false) goto L12;
        EmojiUriNode r101 = (EmojiUriNode) r100;
        if (Intrinsics.areEqual(this.emojiUri, r101.emojiUri) == true) goto L8;
        return false;
    L8:
        if (this.startIndex == r101.startIndex) goto L10;
        return false;
    L10:
        if (this.endIndex == r101.endIndex) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        EmojiUriModel r100 = this.emojiUri;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.startIndex) * 31) + this.endIndex;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "EmojiUriNode(emojiUri=" + this.emojiUri + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ")";
    }

    public final EmojiUriModel getEmojiUri() {
        return this.emojiUri;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public EmojiUriNode(EmojiUriModel r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "emojiUri");
        this.emojiUri = r100;
        this.startIndex = r101;
        this.endIndex = r102;
    }
}
