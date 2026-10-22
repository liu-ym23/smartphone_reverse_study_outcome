package com.bytedance.android.livesdk.dslservice.util;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements yt1.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f122974a;

    @Override // yt1.h
    public final String a() {
        return "scheme";
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.Scheme;
    }

    public h(Context r100) {
        this.f122974a = r100;
    }

    @Override // yt1.h
    public final void b(Map r110, yt1.j r111) {
        if (r110 == null) goto L5;
        Object r100 = r110.get("scheme");
    L7:
        if ((r100 instanceof String) == true) goto L9;
        r100 = null;
    L9:
        String r101 = (String) r100;
        if (r101 == null) goto L29;
        Uri.Builder r102 = UriProtector.parse(r101).buildUpon();
        Iterator r112 = r110.entrySet().iterator();
    L13:
        if (r112.hasNext() == false) goto L20;
        Map.Entry r103 = (Map.Entry) r112.next();
        if (StringsKt.startsWith$default((String) r103.getKey(), "scheme_extra_", false, 2, null) == false) goto L13;
        String r104 = StringsKt.replace$default((String) r103.getKey(), "scheme_extra_", "", false, 4, null);
        Object r105 = r103.getValue();
        if ((r105 instanceof String) == true) goto L19;
        r105 = null;
    L19:
        r102.appendQueryParameter(r104, (String) r105);
        goto L13
    L20:
        String r113 = r102.toString();
        IBaseLiveActionHandler r114 = (IBaseLiveActionHandler) jc1.k.f(IBaseLiveActionHandler.class);
        if (r114 == null) goto L30;
        r114.handle(this.f122974a, r113);
        return;
    L30:
        return;
    L29:
        return;
    L5:
        r100 = null;
        goto L7
    }
}
