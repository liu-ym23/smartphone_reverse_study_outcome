package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f144116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f144117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f144118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f144119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f144120e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f144116a == r101.f144116a) goto L8;
        return false;
    L8:
        if (this.f144117b == r101.f144117b) goto L10;
        return false;
    L10:
        if (this.f144118c == r101.f144118c) goto L12;
        return false;
    L12:
        if (this.f144119d == r101.f144119d) goto L14;
        return false;
    L14:
        if (this.f144120e == r101.f144120e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r100 = this.f144116a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f144117b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f144118c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f144119d;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f144120e;
        if (r113 == true) goto L19;
        r101 = r113;
    L19:
        return r112 + r101;
    }

    public final String toString() {
        return "KSongSettingKey(openAudienceAddSongSwitch=" + this.f144116a + ", openAudienceMultiChorusSwitch=" + this.f144117b + ", canAutoTurnOnSingChallenge=" + this.f144118c + ", hideLyricsWhenSubtitleOpenSwitch=" + this.f144119d + ", openRealtimeChorusSwitch=" + this.f144120e + ")";
    }

    public /* synthetic */ d(int r100) {
        this(false, false, false, false, false);
    }

    public d(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f144116a = r100;
        this.f144117b = r101;
        this.f144118c = r102;
        this.f144119d = r103;
        this.f144120e = r104;
    }

    public static d a(d r100, boolean r101, boolean r102, boolean r103, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f144116a;
    L5:
        boolean r104 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f144117b;
    L8:
        boolean r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        boolean r106 = r100.f144118c;
    L13:
        if ((r111 & 8) == 0) goto L15;
        r103 = r100.f144119d;
    L15:
        boolean r107 = r103;
        if ((r111 & 16) == 0) goto L18;
        r110 = r100.f144120e;
    L18:
        r100.getClass();
        return new d(r104, r105, r106, r107, r110);
    L11:
        r106 = false;
        goto L13
    }
}
