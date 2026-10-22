package bs8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f20308b;

    public h() {
        this("", null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f20307a, r101.f20307a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20308b, r101.f20308b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f20307a.hashCode() * 31;
        a r101 = this.f20308b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PcLocalConversationState(conversationId=" + this.f20307a + ", agentTaskParam=" + this.f20308b + ')';
    }

    public final boolean a() {
        a r100 = this.f20308b;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public h(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f20307a = r100;
        this.f20308b = r101;
    }
}
