package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.bytedance.android.shopping.anchorv4.dto.components.MediaScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/MultiCommentComponent;", "Ljava/io/Serializable;", "commentUser", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "commentDesc", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "commentMedias", "Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;)V", "getCommentDesc", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getCommentMedias", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "getCommentUser", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCommentComponent implements Serializable {

    @SerializedName("comment_desc")
    private final TextElement commentDesc;

    @SerializedName("comment_medias")
    private final MediaScrollBoxComponent commentMedias;

    @SerializedName("comment_user")
    private final TagsScrollBoxComponent commentUser;

    public MultiCommentComponent() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MultiCommentComponent copy$default(MultiCommentComponent r100, TagsScrollBoxComponent r101, TextElement r102, MediaScrollBoxComponent r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.commentUser;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.commentDesc;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.commentMedias;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final TagsScrollBoxComponent component1() {
        return this.commentUser;
    }

    public final TextElement component2() {
        return this.commentDesc;
    }

    public final MediaScrollBoxComponent component3() {
        return this.commentMedias;
    }

    public final MultiCommentComponent copy(TagsScrollBoxComponent r100, TextElement r101, MediaScrollBoxComponent r102) {
        return new MultiCommentComponent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MultiCommentComponent) == false) goto L12;
        MultiCommentComponent r101 = (MultiCommentComponent) r100;
        if (Intrinsics.areEqual(this.commentUser, r101.commentUser) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.commentDesc, r101.commentDesc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commentMedias, r101.commentMedias) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        TagsScrollBoxComponent r100 = this.commentUser;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextElement r104 = this.commentDesc;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        MediaScrollBoxComponent r107 = this.commentMedias;
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
        return "MultiCommentComponent(commentUser=" + this.commentUser + ", commentDesc=" + this.commentDesc + ", commentMedias=" + this.commentMedias + ")";
    }

    public final TextElement getCommentDesc() {
        return this.commentDesc;
    }

    public final MediaScrollBoxComponent getCommentMedias() {
        return this.commentMedias;
    }

    public final TagsScrollBoxComponent getCommentUser() {
        return this.commentUser;
    }

    public MultiCommentComponent(TagsScrollBoxComponent r100, TextElement r101, MediaScrollBoxComponent r102) {
        this.commentUser = r100;
        this.commentDesc = r101;
        this.commentMedias = r102;
    }

    public /* synthetic */ MultiCommentComponent(TagsScrollBoxComponent r100, TextElement r101, MediaScrollBoxComponent r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
