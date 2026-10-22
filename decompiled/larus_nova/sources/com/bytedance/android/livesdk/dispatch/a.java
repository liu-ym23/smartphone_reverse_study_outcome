package com.bytedance.android.livesdk.dispatch;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f122249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f122250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f122251c;

    public final void a() {
        String r100 = this.f122251c.getPath();
        if (r100 == null) goto L13;
        List r101 = StringsKt.split$default(r100, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if (r101 == null) goto L13;
        if (r101.size() < 3) goto L11;
        this.f122249a = (String) ListProtector.get(r101, 1);
        this.f122250b = (String) ListProtector.get(r101, 2);
        return;
    L11:
        throw new Exception("schema error!!! schema is " + this.f122251c.toString());
    L13:
        throw new Exception("schema error!!! schema is " + this.f122251c.toString());
    }

    public a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f122251c = r100;
        this.f122249a = "";
        this.f122250b = "";
    }
}
