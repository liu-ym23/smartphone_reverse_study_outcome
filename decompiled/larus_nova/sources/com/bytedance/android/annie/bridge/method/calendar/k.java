package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import com.bytedance.android.annie.bridge.method.abs.CreateCalendarEventResultModel;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import e7.f0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k implements q9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f38609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f38610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f38611c;

    @Override // q9.c
    public final void onResult(boolean r100, Map<String, ? extends PermissionStatus> r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r100 == false) goto L5;
        this.f38609a.j(this.f38610b, this.f38611c);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r101, "result");
        Iterator r102 = ((LinkedHashMap) r101).values().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        if (((PermissionStatus) r102.next()) != PermissionStatus.DENIED) goto L7;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        g r104 = this.f38609a;
        CreateCalendarEventResultModel r105 = new CreateCalendarEventResultModel();
        r105.a(CreateCalendarEventResultModel.Code.NoPermission);
        r105.b("user denied permission");
        r104.finishWithResult(r105);
        return;
    L14:
        g r106 = this.f38609a;
        CreateCalendarEventResultModel r107 = new CreateCalendarEventResultModel();
        r107.a(CreateCalendarEventResultModel.Code.NoPermission);
        r107.b("user rejected permission");
        r106.finishWithResult(r107);
        return;
    L11:
        r103 = false;
        goto L12
    }

    public k(g r100, f0 r101, ContentResolver r102) {
        this.f38609a = r100;
        this.f38610b = r101;
        this.f38611c = r102;
    }
}
