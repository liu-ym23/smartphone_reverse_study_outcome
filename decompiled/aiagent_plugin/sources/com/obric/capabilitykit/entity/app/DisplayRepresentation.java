package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class DisplayRepresentation {
    private final Uri image;
    private final String subtitle;
    private final long time;
    private final String title;

    public DisplayRepresentation(Uri r2, String r3, String r4, long r5) {
        o.e(r3, DBDefinition.TITLE);
        this.image = r2;
        this.title = r3;
        this.subtitle = r4;
        this.time = r5;
    }

    public /* synthetic */ DisplayRepresentation(Uri r8, String r9, String r10, long r11, int r13, h r14) {
        if ((r13 & 1) == 0) goto L5;
        Uri r2 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = null;
    L10:
        this(r2, r9, r4, r11);
        return;
    L9:
        r4 = r10;
        goto L10
    L5:
        r2 = r8;
        goto L7
    }

    public static /* synthetic */ DisplayRepresentation copy$default(DisplayRepresentation r3, Uri r4, String r5, String r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.image;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.title;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.subtitle;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.time;
    L14:
        Uri r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final Uri component1() {
        return this.image;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.subtitle;
    }

    public final long component4() {
        return this.time;
    }

    public final DisplayRepresentation copy(Uri r7, String r8, String r9, long r10) {
        o.e(r8, DBDefinition.TITLE);
        return new DisplayRepresentation(r7, r8, r9, r10);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, DisplayRepresentation.class) == true) goto L8;
        return false;
    L8:
        DisplayRepresentation r8 = (DisplayRepresentation) ZeusTransformUtils.preCheckCast(r7, DisplayRepresentation.class, "com.obric.aiagent.plugin");
        if (o.a(this.image, r8.image) == true) goto L12;
        return false;
    L12:
        if (o.a(this.title, r8.title) == true) goto L15;
        return false;
    L15:
        if (o.a(this.subtitle, r8.subtitle) == true) goto L18;
        return false;
    L18:
        if (this.time == r8.time) goto L20;
        return false;
    L20:
        return true;
    }

    public final Uri getImage() {
        return this.image;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Uri r0 = this.image;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.title.hashCode()) * 31;
        String r4 = this.subtitle;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + Long.hashCode(this.time);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DisplayRepresentation(image=" + this.image + ", title=" + this.title + ", subtitle=" + this.subtitle + ", time=" + this.time + ')';
    }
}
