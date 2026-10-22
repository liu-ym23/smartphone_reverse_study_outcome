package com.stepos.ailauncher.foundation.account.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0080\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/foundation/account/api/BlockStatusDto;", "", "windowSeconds", "", "threshold", "count", "exceeded", "", "muteSuggestSeconds", "muteStartAt", "", "muteEndAt", "systemTime", "reasons", "", "Lcom/stepos/ailauncher/foundation/account/api/BlockReasonDto;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)V", "getWindowSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getThreshold", "getCount", "getExceeded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMuteSuggestSeconds", "getMuteStartAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMuteEndAt", "getSystemTime", "getReasons", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;)Lcom/stepos/ailauncher/foundation/account/api/BlockStatusDto;", "equals", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BlockStatusDto {
    private final Integer count;
    private final Boolean exceeded;
    private final Long muteEndAt;
    private final Long muteStartAt;
    private final Integer muteSuggestSeconds;
    private final List<BlockReasonDto> reasons;
    private final Long systemTime;
    private final Integer threshold;
    private final Integer windowSeconds;

    public BlockStatusDto() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ BlockStatusDto copy$default(BlockStatusDto blockStatusDto, Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, Long l10, Long l11, Long l12, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = blockStatusDto.windowSeconds;
        }
        if ((i10 & 2) != 0) {
            num2 = blockStatusDto.threshold;
        }
        if ((i10 & 4) != 0) {
            num3 = blockStatusDto.count;
        }
        if ((i10 & 8) != 0) {
            bool = blockStatusDto.exceeded;
        }
        if ((i10 & 16) != 0) {
            num4 = blockStatusDto.muteSuggestSeconds;
        }
        if ((i10 & 32) != 0) {
            l10 = blockStatusDto.muteStartAt;
        }
        if ((i10 & 64) != 0) {
            l11 = blockStatusDto.muteEndAt;
        }
        if ((i10 & 128) != 0) {
            l12 = blockStatusDto.systemTime;
        }
        if ((i10 & 256) != 0) {
            list = blockStatusDto.reasons;
        }
        Long l13 = l12;
        List list2 = list;
        Long l14 = l10;
        Long l15 = l11;
        Integer num5 = num4;
        Integer num6 = num3;
        return blockStatusDto.copy(num, num2, num6, bool, num5, l14, l15, l13, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getWindowSeconds() {
        return this.windowSeconds;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getThreshold() {
        return this.threshold;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getExceeded() {
        return this.exceeded;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getMuteSuggestSeconds() {
        return this.muteSuggestSeconds;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getMuteStartAt() {
        return this.muteStartAt;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getMuteEndAt() {
        return this.muteEndAt;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getSystemTime() {
        return this.systemTime;
    }

    public final List<BlockReasonDto> component9() {
        return this.reasons;
    }

    public final BlockStatusDto copy(Integer windowSeconds, Integer threshold, Integer count, Boolean exceeded, Integer muteSuggestSeconds, Long muteStartAt, Long muteEndAt, Long systemTime, List<BlockReasonDto> reasons) {
        return new BlockStatusDto(windowSeconds, threshold, count, exceeded, muteSuggestSeconds, muteStartAt, muteEndAt, systemTime, reasons);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlockStatusDto)) {
            return false;
        }
        BlockStatusDto blockStatusDto = (BlockStatusDto) other;
        return p.d(this.windowSeconds, blockStatusDto.windowSeconds) && p.d(this.threshold, blockStatusDto.threshold) && p.d(this.count, blockStatusDto.count) && p.d(this.exceeded, blockStatusDto.exceeded) && p.d(this.muteSuggestSeconds, blockStatusDto.muteSuggestSeconds) && p.d(this.muteStartAt, blockStatusDto.muteStartAt) && p.d(this.muteEndAt, blockStatusDto.muteEndAt) && p.d(this.systemTime, blockStatusDto.systemTime) && p.d(this.reasons, blockStatusDto.reasons);
    }

    public final Integer getCount() {
        return this.count;
    }

    public final Boolean getExceeded() {
        return this.exceeded;
    }

    public final Long getMuteEndAt() {
        return this.muteEndAt;
    }

    public final Long getMuteStartAt() {
        return this.muteStartAt;
    }

    public final Integer getMuteSuggestSeconds() {
        return this.muteSuggestSeconds;
    }

    public final List<BlockReasonDto> getReasons() {
        return this.reasons;
    }

    public final Long getSystemTime() {
        return this.systemTime;
    }

    public final Integer getThreshold() {
        return this.threshold;
    }

    public final Integer getWindowSeconds() {
        return this.windowSeconds;
    }

    public int hashCode() {
        Integer num = this.windowSeconds;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.threshold;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.count;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.exceeded;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num4 = this.muteSuggestSeconds;
        int iHashCode5 = (iHashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Long l10 = this.muteStartAt;
        int iHashCode6 = (iHashCode5 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.muteEndAt;
        int iHashCode7 = (iHashCode6 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.systemTime;
        int iHashCode8 = (iHashCode7 + (l12 == null ? 0 : l12.hashCode())) * 31;
        List<BlockReasonDto> list = this.reasons;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "BlockStatusDto(windowSeconds=" + this.windowSeconds + ", threshold=" + this.threshold + ", count=" + this.count + ", exceeded=" + this.exceeded + ", muteSuggestSeconds=" + this.muteSuggestSeconds + ", muteStartAt=" + this.muteStartAt + ", muteEndAt=" + this.muteEndAt + ", systemTime=" + this.systemTime + ", reasons=" + this.reasons + ")";
    }

    public BlockStatusDto(Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, Long l10, Long l11, Long l12, List<BlockReasonDto> list) {
        this.windowSeconds = num;
        this.threshold = num2;
        this.count = num3;
        this.exceeded = bool;
        this.muteSuggestSeconds = num4;
        this.muteStartAt = l10;
        this.muteEndAt = l11;
        this.systemTime = l12;
        this.reasons = list;
    }

    public /* synthetic */ BlockStatusDto(Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, Long l10, Long l11, Long l12, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : bool, (i10 & 16) != 0 ? null : num4, (i10 & 32) != 0 ? null : l10, (i10 & 64) != 0 ? null : l11, (i10 & 128) != 0 ? null : l12, (i10 & 256) != 0 ? null : list);
    }
}
