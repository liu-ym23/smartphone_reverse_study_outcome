package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0002HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowFollowCommitDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "component1", "Lcom/bytedance/android/ec/window/base/repository/dto/s;", "component2", "followSuccessMsg", "hybridComponentDTO", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getFollowSuccessMsg", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/window/base/repository/dto/s;", "getHybridComponentDTO", "()Lcom/bytedance/android/ec/window/base/repository/dto/s;", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/ec/window/base/repository/dto/s;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowFollowCommitDTO extends CommerceBaseResponse {

    @SerializedName("follow_success_msg")
    private final String followSuccessMsg;

    @SerializedName("display_module")
    private final com.bytedance.android.ec.window.base.repository.dto.s hybridComponentDTO;

    /* JADX WARN: Multi-variable type inference failed */
    public WindowFollowCommitDTO() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WindowFollowCommitDTO copy$default(WindowFollowCommitDTO r100, String r101, com.bytedance.android.ec.window.base.repository.dto.s r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.followSuccessMsg;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hybridComponentDTO;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.followSuccessMsg;
    }

    public final com.bytedance.android.ec.window.base.repository.dto.s component2() {
        return this.hybridComponentDTO;
    }

    public final WindowFollowCommitDTO copy(String r100, com.bytedance.android.ec.window.base.repository.dto.s r101) {
        return new WindowFollowCommitDTO(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowFollowCommitDTO) == false) goto L10;
        WindowFollowCommitDTO r101 = (WindowFollowCommitDTO) r100;
        if (Intrinsics.areEqual(this.followSuccessMsg, r101.followSuccessMsg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hybridComponentDTO, r101.hybridComponentDTO) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.followSuccessMsg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.ec.window.base.repository.dto.s r104 = this.hybridComponentDTO;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "WindowFollowCommitDTO(followSuccessMsg=" + this.followSuccessMsg + ", hybridComponentDTO=" + this.hybridComponentDTO + ")";
    }

    public final String getFollowSuccessMsg() {
        return this.followSuccessMsg;
    }

    public final com.bytedance.android.ec.window.base.repository.dto.s getHybridComponentDTO() {
        return this.hybridComponentDTO;
    }

    public WindowFollowCommitDTO(String r100, com.bytedance.android.ec.window.base.repository.dto.s r101) {
        this.followSuccessMsg = r100;
        this.hybridComponentDTO = r101;
    }

    public /* synthetic */ WindowFollowCommitDTO(String r100, com.bytedance.android.ec.window.base.repository.dto.s r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
