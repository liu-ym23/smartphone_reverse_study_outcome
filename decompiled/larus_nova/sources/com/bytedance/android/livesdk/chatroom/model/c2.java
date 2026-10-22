package com.bytedance.android.livesdk.chatroom.model;

/* JADX INFO: loaded from: classes7.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f106911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f106912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f106913c;

    public c2() {
        this(0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c2) == false) goto L12;
        c2 r101 = (c2) r100;
        if (this.f106911a == r101.f106911a) goto L8;
        return false;
    L8:
        if (this.f106912b == r101.f106912b) goto L10;
        return false;
    L10:
        if (this.f106913c == r101.f106913c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f106911a * 31) + this.f106912b) * 31) + this.f106913c;
    }

    public final String toString() {
        return "LiveLinkConfigurationData(liveLinkTargetScene=" + this.f106911a + ", liveLinkTargetUiLayout=" + this.f106912b + ", liveLinkTargetPlayMode=" + this.f106913c + ")";
    }

    public /* synthetic */ c2(int r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100, 0, 0);
    }

    public c2(int r100, int r101, int r102) {
        this.f106911a = r100;
        this.f106912b = r101;
        this.f106913c = r102;
    }
}
