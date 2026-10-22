package com.bytedance.android.livesdkapi.feed;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/LoadMoreRetryConfig;", "", "source", "Lcom/bytedance/android/livesdkapi/feed/SOURCE;", "errorCode", "", "(Lcom/bytedance/android/livesdkapi/feed/SOURCE;I)V", "getErrorCode", "()I", "getSource", "()Lcom/bytedance/android/livesdkapi/feed/SOURCE;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreRetryConfig {
    private final int errorCode;
    private final SOURCE source;

    /* JADX WARN: Multi-variable type inference failed */
    public LoadMoreRetryConfig() {
        SOURCE r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LoadMoreRetryConfig copy$default(LoadMoreRetryConfig r100, SOURCE r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.source;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.errorCode;
    L9:
        return r100.copy(r101, r102);
    }

    public final SOURCE component1() {
        return this.source;
    }

    public final int component2() {
        return this.errorCode;
    }

    public final LoadMoreRetryConfig copy(SOURCE r100, int r101) {
        return new LoadMoreRetryConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LoadMoreRetryConfig) == false) goto L10;
        LoadMoreRetryConfig r101 = (LoadMoreRetryConfig) r100;
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L8;
        return false;
    L8:
        if (this.errorCode == r101.errorCode) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        SOURCE r100 = this.source;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.errorCode;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "LoadMoreRetryConfig(source=" + this.source + ", errorCode=" + this.errorCode + ")";
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final SOURCE getSource() {
        return this.source;
    }

    public LoadMoreRetryConfig(SOURCE r100, int r101) {
        this.source = r100;
        this.errorCode = r101;
    }

    public /* synthetic */ LoadMoreRetryConfig(SOURCE r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
