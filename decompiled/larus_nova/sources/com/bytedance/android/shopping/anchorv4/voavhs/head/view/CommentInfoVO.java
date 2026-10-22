package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/CommentInfoVO;", "Ljava/io/Serializable;", "userName", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "userAvatar", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "rank", "", "content", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "photo", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;ILcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;)V", "getContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPhoto", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getRank", "()I", "getUserAvatar", "getUserName", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentInfoVO implements Serializable {

    @SerializedName("content")
    private final TextElement content;

    @SerializedName("photo")
    private final ImageModel photo;

    @SerializedName("rank")
    private final int rank;

    @SerializedName("user_avatar")
    private final ImageModel userAvatar;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final TextWithOneIconElement userName;

    public CommentInfoVO() {
        this(null, null, 0, null, null, 31, null);
    }

    public static /* synthetic */ CommentInfoVO copy$default(CommentInfoVO r100, TextWithOneIconElement r101, ImageModel r102, int r103, TextElement r104, ImageModel r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.userName;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.userAvatar;
    L8:
        ImageModel r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.rank;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.content;
    L14:
        TextElement r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.photo;
    L17:
        TextWithOneIconElement r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final TextWithOneIconElement component1() {
        return this.userName;
    }

    public final ImageModel component2() {
        return this.userAvatar;
    }

    public final int component3() {
        return this.rank;
    }

    public final TextElement component4() {
        return this.content;
    }

    public final ImageModel component5() {
        return this.photo;
    }

    public final CommentInfoVO copy(TextWithOneIconElement r100, ImageModel r101, int r110, TextElement r111, ImageModel r112) {
        return new CommentInfoVO(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommentInfoVO) == false) goto L16;
        CommentInfoVO r101 = (CommentInfoVO) r100;
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userAvatar, r101.userAvatar) == true) goto L10;
        return false;
    L10:
        if (this.rank == r101.rank) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.photo, r101.photo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r100 = this.userName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ImageModel r104 = this.userAvatar;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.rank) * 31;
        TextElement r107 = this.content;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ImageModel r110 = this.photo;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CommentInfoVO(userName=" + this.userName + ", userAvatar=" + this.userAvatar + ", rank=" + this.rank + ", content=" + this.content + ", photo=" + this.photo + ")";
    }

    public final TextElement getContent() {
        return this.content;
    }

    public final ImageModel getPhoto() {
        return this.photo;
    }

    public final int getRank() {
        return this.rank;
    }

    public final ImageModel getUserAvatar() {
        return this.userAvatar;
    }

    public final TextWithOneIconElement getUserName() {
        return this.userName;
    }

    public CommentInfoVO(TextWithOneIconElement r100, ImageModel r101, int r102, TextElement r103, ImageModel r104) {
        this.userName = r100;
        this.userAvatar = r101;
        this.rank = r102;
        this.content = r103;
        this.photo = r104;
    }

    public /* synthetic */ CommentInfoVO(TextWithOneIconElement r100, ImageModel r101, int r102, TextElement r103, ImageModel r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        TextWithOneIconElement r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        ImageModel r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r110 & 8) == 0) goto L17;
        TextElement r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        ImageModel r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
