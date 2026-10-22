package com.obric.autoaction.app.launcherpage.utils;

import com.obric.oui.sheet.OInsetSheet;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<j<T>> f24500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OInsetSheet.b f24503d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f24500a, r6.f24500a) == true) goto L12;
        return false;
    L12:
        if (this.f24501b == r6.f24501b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f24502c, r6.f24502c) == true) goto L18;
        return false;
    L18:
        if (this.f24503d == r6.f24503d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f24500a.hashCode() * 31) + Integer.hashCode(this.f24501b)) * 31) + this.f24502c.hashCode()) * 31) + this.f24503d.hashCode();
    }

    public String toString() {
        return "SelectionConfig(list=" + this.f24500a + ", lastSelectedIndex=" + this.f24501b + ", title=" + this.f24502c + ", width=" + this.f24503d + ')';
    }

    public i(List<j<T>> r3, int r4, String r5, OInsetSheet.b r6) {
        List<j<T>> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "list");
        d.h.b.o.e(r5, DBDefinition.TITLE);
        d.h.b.o.e(r6, "width");
        this.f24500a = r7;
        this.f24501b = r4;
        this.f24502c = r5;
        this.f24503d = r6;
    }

    public final List<j<T>> a() {
        return this.f24500a;
    }
}
