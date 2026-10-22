package ah9;

import com.larus.im.bean.bot.IconItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IconItem f3442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3443e;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f3439a == r101.f3439a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3440b, r101.f3440b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3441c, r101.f3441c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3442d, r101.f3442d) == true) goto L21;
        return false;
    L21:
        if (this.f3443e == r101.f3443e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f3439a * 31;
        String r101 = this.f3440b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f3441c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        IconItem r108 = this.f3442d;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.f3443e == false) goto L17;
        int r110 = 1231;
    L19:
        return r109 + r110;
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateUgcVoiceItem(createState=" + this.f3439a + ", localVoiceId=" + this.f3440b + ", voiceName=" + this.f3441c + ", voiceIcon=" + this.f3442d + ", replaceVoice=" + this.f3443e + ')';
    }

    public /* synthetic */ a(int r100) {
        this(-1, "", "", null, false);
    }

    public a(int r100, String r101, String r102, IconItem r103, boolean r104) {
        this.f3439a = r100;
        this.f3440b = r101;
        this.f3441c = r102;
        this.f3442d = r103;
        this.f3443e = r104;
    }
}
