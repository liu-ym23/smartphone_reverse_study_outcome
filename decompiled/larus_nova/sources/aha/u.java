package aha;

import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricInteractionType f3669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3670d;

    public u() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f3667a, r101.f3667a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3668b, r101.f3668b) == true) goto L15;
        return false;
    L15:
        if (this.f3669c == r101.f3669c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3670d, r101.f3670d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f3667a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f3668b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f3669c.hashCode()) * 31;
        String r107 = this.f3670d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricTaskMetadata(botId=" + this.f3667a + ", conversationId=" + this.f3668b + ", interactionType=" + this.f3669c + ", interactionSessionId=" + this.f3670d + ')';
    }

    public /* synthetic */ u(String r100, int r101) {
        if ((r101 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 4) == 0) goto L8;
        ObricInteractionType r102 = ObricInteractionType.DefaultMode;
    L9:
        this(null, r100, r102, null);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public u(String r100, String r101, ObricInteractionType r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "interactionType");
        this.f3667a = r100;
        this.f3668b = r101;
        this.f3669c = r102;
        this.f3670d = r103;
    }
}
