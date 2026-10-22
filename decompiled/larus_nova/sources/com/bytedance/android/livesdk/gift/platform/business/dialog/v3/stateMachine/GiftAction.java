package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.framework.base.TraceExclude;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftAction;", "Lcom/bytedance/android/anya/p;", "", "toString", "", "needListen", "Z", "getNeedListen", "()Z", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "createTs", "J", "getCreateTs", "()J", "<init>", "(ZLjava/lang/String;J)V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class GiftAction implements p {
    private final long createTs;

    @TraceExclude
    private final boolean needListen;

    @TraceExclude
    private final String tag;

    public final long getCreateTs() {
        return this.createTs;
    }

    public final boolean getNeedListen() {
        return this.needListen;
    }

    public final String getTag() {
        return this.tag;
    }

    public String toString() {
        return this.tag;
    }

    public GiftAction(boolean r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        this.needListen = r100;
        this.tag = r101;
        this.createTs = r102;
    }

    public /* synthetic */ GiftAction(boolean r100, String r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = System.currentTimeMillis();
    L8:
        this(r100, r101, r102);
    }
}
