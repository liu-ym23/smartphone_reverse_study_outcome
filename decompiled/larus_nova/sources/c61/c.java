package c61;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f22533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22534b;

    public c() {
        this(0L, "");
    }

    public final int hashCode() {
        String r100 = this.f22534b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f22533a;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final Long getType() {
        return this.f22533a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(c.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        c r102 = (c) r100;
        if ((!Intrinsics.areEqual(this.f22533a, r102.f22533a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f22534b, r102.f22534b)) == false) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.draggablecomponent.DraggableScene");
    L8:
        r101 = null;
        goto L10
    }

    public c(Long r100, String r101) {
        this.f22533a = r100;
        this.f22534b = r101;
    }
}
