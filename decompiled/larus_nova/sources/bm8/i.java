package bm8;

import com.larus.bmhome.chat.layout.widget.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f19652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f19653c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f19651a, r101.f19651a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19652b, r101.f19652b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19653c, r101.f19653c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f19651a.hashCode() * 31;
        a r101 = this.f19652b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f19653c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownAppletContainerInput(appletUIConfig=" + this.f19651a + ", containerUIConfig=" + this.f19652b + ", widgetRenderData=" + this.f19653c + ')';
    }

    public i(b r100, a r101, u r102) {
        Intrinsics.checkNotNullParameter(r100, "appletUIConfig");
        Intrinsics.checkNotNullParameter(r102, "widgetRenderData");
        this.f19651a = r100;
        this.f19652b = r101;
        this.f19653c = r102;
    }
}
