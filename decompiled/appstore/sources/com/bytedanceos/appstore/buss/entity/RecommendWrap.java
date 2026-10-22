package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/RecommendWrap;", "", "topic", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "horizontal1", "horizontal2", ServerElements.BANNER, "vertical1", "(Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "getBanner", "()Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "getHorizontal1", "getHorizontal2", "getTopic", "getVertical1", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecommendWrap {

    @NotNull
    private final AppEntityWrap banner;

    @NotNull
    private final AppEntityWrap horizontal1;

    @NotNull
    private final AppEntityWrap horizontal2;

    @NotNull
    private final AppEntityWrap topic;

    @NotNull
    private final AppEntityWrap vertical1;

    public RecommendWrap(@NotNull AppEntityWrap r10, @NotNull AppEntityWrap r11, @NotNull AppEntityWrap r12, @NotNull AppEntityWrap r13, @NotNull AppEntityWrap r14) {
        q.g(r10, "topic");
        q.g(r11, "horizontal1");
        q.g(r12, "horizontal2");
        q.g(r13, ServerElements.BANNER);
        q.g(r14, "vertical1");
        this.topic = r10;
        this.horizontal1 = r11;
        this.horizontal2 = r12;
        this.banner = r13;
        this.vertical1 = r14;
    }

    public static /* synthetic */ RecommendWrap copy$default(RecommendWrap r10, AppEntityWrap r11, AppEntityWrap r12, AppEntityWrap r13, AppEntityWrap r14, AppEntityWrap r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.topic;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.horizontal1;
    L8:
        AppEntityWrap r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.horizontal2;
    L11:
        AppEntityWrap r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.banner;
    L14:
        AppEntityWrap r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.vertical1;
    L17:
        AppEntityWrap r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    @NotNull
    public final AppEntityWrap component1() {
        return this.topic;
    }

    @NotNull
    public final AppEntityWrap component2() {
        return this.horizontal1;
    }

    @NotNull
    public final AppEntityWrap component3() {
        return this.horizontal2;
    }

    @NotNull
    public final AppEntityWrap component4() {
        return this.banner;
    }

    @NotNull
    public final AppEntityWrap component5() {
        return this.vertical1;
    }

    @NotNull
    public final RecommendWrap copy(@NotNull AppEntityWrap r10, @NotNull AppEntityWrap r11, @NotNull AppEntityWrap r12, @NotNull AppEntityWrap r13, @NotNull AppEntityWrap r14) {
        q.g(r10, "topic");
        q.g(r11, "horizontal1");
        q.g(r12, "horizontal2");
        q.g(r13, ServerElements.BANNER);
        q.g(r14, "vertical1");
        return new RecommendWrap(r10, r11, r12, r13, r14);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof RecommendWrap) == true) goto L8;
        return false;
    L8:
        RecommendWrap r11 = (RecommendWrap) r10;
        if (q.b(this.topic, r11.topic) == true) goto L12;
        return false;
    L12:
        if (q.b(this.horizontal1, r11.horizontal1) == true) goto L15;
        return false;
    L15:
        if (q.b(this.horizontal2, r11.horizontal2) == true) goto L18;
        return false;
    L18:
        if (q.b(this.banner, r11.banner) == true) goto L21;
        return false;
    L21:
        if (q.b(this.vertical1, r11.vertical1) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @NotNull
    public final AppEntityWrap getBanner() {
        return this.banner;
    }

    @NotNull
    public final AppEntityWrap getHorizontal1() {
        return this.horizontal1;
    }

    @NotNull
    public final AppEntityWrap getHorizontal2() {
        return this.horizontal2;
    }

    @NotNull
    public final AppEntityWrap getTopic() {
        return this.topic;
    }

    @NotNull
    public final AppEntityWrap getVertical1() {
        return this.vertical1;
    }

    public int hashCode() {
        return (((((((this.topic.hashCode() * 31) + this.horizontal1.hashCode()) * 31) + this.horizontal2.hashCode()) * 31) + this.banner.hashCode()) * 31) + this.vertical1.hashCode();
    }

    @NotNull
    public String toString() {
        return "RecommendWrap(topic=" + this.topic + ", horizontal1=" + this.horizontal1 + ", horizontal2=" + this.horizontal2 + ", banner=" + this.banner + ", vertical1=" + this.vertical1 + ')';
    }
}
