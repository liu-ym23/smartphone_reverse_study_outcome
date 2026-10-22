package com.mdisdk.action;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J:\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/mdisdk/action/MoveAppArgs;", "", "packageName", "", "toDisplayId", "", "toTop", "", "androidUserId", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Integer;)V", "getPackageName", "()Ljava/lang/String;", "getToDisplayId", "()I", "getToTop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAndroidUserId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Integer;)Lcom/mdisdk/action/MoveAppArgs;", "equals", "other", "hashCode", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MoveAppArgs {
    private final Integer androidUserId;
    private final String packageName;
    private final int toDisplayId;
    private final Boolean toTop;

    public MoveAppArgs(String packageName, int i, Boolean bool, Integer num) {
        k.f(packageName, "packageName");
        this.packageName = packageName;
        this.toDisplayId = i;
        this.toTop = bool;
        this.androidUserId = num;
    }

    public static /* synthetic */ MoveAppArgs copy$default(MoveAppArgs moveAppArgs, String str, int i, Boolean bool, Integer num, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = moveAppArgs.packageName;
        }
        if ((i6 & 2) != 0) {
            i = moveAppArgs.toDisplayId;
        }
        if ((i6 & 4) != 0) {
            bool = moveAppArgs.toTop;
        }
        if ((i6 & 8) != 0) {
            num = moveAppArgs.androidUserId;
        }
        return moveAppArgs.copy(str, i, bool, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getToDisplayId() {
        return this.toDisplayId;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getToTop() {
        return this.toTop;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getAndroidUserId() {
        return this.androidUserId;
    }

    public final MoveAppArgs copy(String packageName, int toDisplayId, Boolean toTop, Integer androidUserId) {
        k.f(packageName, "packageName");
        return new MoveAppArgs(packageName, toDisplayId, toTop, androidUserId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoveAppArgs)) {
            return false;
        }
        MoveAppArgs moveAppArgs = (MoveAppArgs) other;
        return k.b(this.packageName, moveAppArgs.packageName) && this.toDisplayId == moveAppArgs.toDisplayId && k.b(this.toTop, moveAppArgs.toTop) && k.b(this.androidUserId, moveAppArgs.androidUserId);
    }

    public final Integer getAndroidUserId() {
        return this.androidUserId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getToDisplayId() {
        return this.toDisplayId;
    }

    public final Boolean getToTop() {
        return this.toTop;
    }

    public int hashCode() {
        int iA = a.a(this.toDisplayId, this.packageName.hashCode() * 31, 31);
        Boolean bool = this.toTop;
        int iHashCode = (iA + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.androidUserId;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "MoveAppArgs(packageName=" + this.packageName + ", toDisplayId=" + this.toDisplayId + ", toTop=" + this.toTop + ", androidUserId=" + this.androidUserId + ')';
    }
}
