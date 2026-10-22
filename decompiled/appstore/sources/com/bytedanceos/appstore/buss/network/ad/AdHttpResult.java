package com.bytedanceos.appstore.buss.network.ad;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bHÆ\u0003J7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedanceos/appstore/buss/network/ad/AdHttpResult;", "T", "", ServerElements.CODE, "", "errinfo", "", "ad", "", "(ILjava/lang/String;Ljava/util/List;)V", "getAd", "()Ljava/util/List;", "getCode", "()I", "getErrinfo", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AdHttpResult<T> {

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    @Nullable
    private final List<T> f8785ad;
    private final int code;

    @Nullable
    private final String errinfo;

    /* JADX WARN: Multi-variable type inference failed */
    public AdHttpResult(int r10, @Nullable String r11, @Nullable List<? extends T> r12) {
        this.code = r10;
        this.errinfo = r11;
        this.f8785ad = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdHttpResult copy$default(AdHttpResult r10, int r11, String r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.code;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.errinfo;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.f8785ad;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.errinfo;
    }

    @Nullable
    public final List<T> component3() {
        return this.f8785ad;
    }

    @NotNull
    public final AdHttpResult<T> copy(int r10, @Nullable String r11, @Nullable List<? extends T> r12) {
        return new AdHttpResult(r10, r11, r12);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AdHttpResult) == true) goto L8;
        return false;
    L8:
        AdHttpResult r11 = (AdHttpResult) r10;
        if (this.code == r11.code) goto L12;
        return false;
    L12:
        if (q.b(this.errinfo, r11.errinfo) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f8785ad, r11.f8785ad) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final List<T> getAd() {
        return this.f8785ad;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getErrinfo() {
        return this.errinfo;
    }

    public int hashCode() {
        int r10 = Integer.hashCode(this.code) * 31;
        String r11 = this.errinfo;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        List<T> r15 = this.f8785ad;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "AdHttpResult(code=" + this.code + ", errinfo=" + this.errinfo + ", ad=" + this.f8785ad + ')';
    }
}
