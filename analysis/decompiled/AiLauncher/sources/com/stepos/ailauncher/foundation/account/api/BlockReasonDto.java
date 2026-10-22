package com.stepos.ailauncher.foundation.account.api;

import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/account/api/BlockReasonDto;", "", QueryAlgorithmBundle.KEY_CATEGORY, "", "riskText", "count", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCategory", "()Ljava/lang/String;", "getRiskText", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stepos/ailauncher/foundation/account/api/BlockReasonDto;", "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BlockReasonDto {
    private final String category;
    private final Integer count;
    private final String riskText;

    public BlockReasonDto() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ BlockReasonDto copy$default(BlockReasonDto blockReasonDto, String str, String str2, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = blockReasonDto.category;
        }
        if ((i10 & 2) != 0) {
            str2 = blockReasonDto.riskText;
        }
        if ((i10 & 4) != 0) {
            num = blockReasonDto.count;
        }
        return blockReasonDto.copy(str, str2, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRiskText() {
        return this.riskText;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    public final BlockReasonDto copy(String category, String riskText, Integer count) {
        return new BlockReasonDto(category, riskText, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockReasonDto)) {
            return false;
        }
        BlockReasonDto blockReasonDto = (BlockReasonDto) other;
        return p.d(this.category, blockReasonDto.category) && p.d(this.riskText, blockReasonDto.riskText) && p.d(this.count, blockReasonDto.count);
    }

    public final String getCategory() {
        return this.category;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getRiskText() {
        return this.riskText;
    }

    public int hashCode() {
        String str = this.category;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.riskText;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.count;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "BlockReasonDto(category=" + this.category + ", riskText=" + this.riskText + ", count=" + this.count + ")";
    }

    public BlockReasonDto(String str, String str2, Integer num) {
        this.category = str;
        this.riskText = str2;
        this.count = num;
    }

    public /* synthetic */ BlockReasonDto(String str, String str2, Integer num, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num);
    }
}
