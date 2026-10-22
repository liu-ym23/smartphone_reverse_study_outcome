package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import com.bytedance.android.annie.bridge.method.abs.DeleteCalendarEventResultModel;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import e7.g0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements q9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f38626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g0 f38627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f38628c;

    @Override // q9.c
    public final void onResult(boolean r100, Map<String, ? extends PermissionStatus> r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r100 == false) goto L5;
        this.f38626a.j(this.f38627b, this.f38628c);
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
        o r104 = this.f38626a;
        DeleteCalendarEventResultModel r105 = new DeleteCalendarEventResultModel();
        r105.a(DeleteCalendarEventResultModel.Code.NoPermission);
        r105.b("user denied permission");
        r104.finishWithResult(r105);
        return;
    L14:
        o r106 = this.f38626a;
        DeleteCalendarEventResultModel r107 = new DeleteCalendarEventResultModel();
        r107.a(DeleteCalendarEventResultModel.Code.NoPermission);
        r107.b("user rejected permission");
        r106.finishWithResult(r107);
        return;
    L11:
        r103 = false;
        goto L12
    }

    public p(o r100, g0 r101, ContentResolver r102) {
        this.f38626a = r100;
        this.f38627b = r101;
        this.f38628c = r102;
    }
}
