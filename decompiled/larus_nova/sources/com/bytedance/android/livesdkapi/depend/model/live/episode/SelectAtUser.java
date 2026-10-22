package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SelectAtUser;", "", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "fromIndex", "", "endIndex", "atUserName", "", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;IILjava/lang/String;)V", "getAtUserName", "()Ljava/lang/String;", "setAtUserName", "(Ljava/lang/String;)V", "getEndIndex", "()I", "setEndIndex", "(I)V", "getFromIndex", "setFromIndex", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectAtUser {
    private String atUserName;
    private int endIndex;
    private int fromIndex;
    private final IBaseUser user;

    public static /* synthetic */ SelectAtUser copy$default(SelectAtUser r100, IBaseUser r101, int r102, int r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.user;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.fromIndex;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.endIndex;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.atUserName;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final IBaseUser component1() {
        return this.user;
    }

    public final int component2() {
        return this.fromIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final String component4() {
        return this.atUserName;
    }

    public final SelectAtUser copy(IBaseUser r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r103, "atUserName");
        return new SelectAtUser(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SelectAtUser) == false) goto L14;
        SelectAtUser r101 = (SelectAtUser) r100;
        if (Intrinsics.areEqual(this.user, r101.user) == true) goto L8;
        return false;
    L8:
        if (this.fromIndex == r101.fromIndex) goto L10;
        return false;
    L10:
        if (this.endIndex == r101.endIndex) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.atUserName, r101.atUserName) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        IBaseUser r100 = this.user;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.fromIndex) * 31) + this.endIndex) * 31;
        String r104 = this.atUserName;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SelectAtUser(user=" + this.user + ", fromIndex=" + this.fromIndex + ", endIndex=" + this.endIndex + ", atUserName=" + this.atUserName + ")";
    }

    public final String getAtUserName() {
        return this.atUserName;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getFromIndex() {
        return this.fromIndex;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    public final void setAtUserName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.atUserName = r100;
    }

    public final void setEndIndex(int r100) {
        this.endIndex = r100;
    }

    public final void setFromIndex(int r100) {
        this.fromIndex = r100;
    }

    public SelectAtUser(IBaseUser r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r103, "atUserName");
        this.user = r100;
        this.fromIndex = r101;
        this.endIndex = r102;
        this.atUserName = r103;
    }
}
