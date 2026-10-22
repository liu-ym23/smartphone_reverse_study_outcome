package c88;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22743f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f22738a, r101.f22738a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22739b, r101.f22739b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22740c, r101.f22740c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f22741d, r101.f22741d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f22742e, r101.f22742e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f22743f, r101.f22743f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f22738a.hashCode() * 31) + this.f22739b.hashCode()) * 31) + this.f22740c.hashCode()) * 31;
        String r101 = this.f22741d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f22742e.hashCode()) * 31) + this.f22743f.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AudioSteamData(appletId=" + this.f22738a + ", title=" + this.f22739b + ", artist=" + this.f22740c + ", coverUrl=" + this.f22741d + ", url=" + this.f22742e + ", uuid=" + this.f22743f + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "artist");
        Intrinsics.checkNotNullParameter(r104, "url");
        Intrinsics.checkNotNullParameter(r105, ST.UUID_DEVICE);
        this.f22738a = r100;
        this.f22739b = r101;
        this.f22740c = r102;
        this.f22741d = r103;
        this.f22742e = r104;
        this.f22743f = r105;
    }
}
