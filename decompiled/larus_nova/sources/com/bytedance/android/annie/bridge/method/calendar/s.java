package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import com.bytedance.android.annie.bridge.method.abs.ReadCalendarEventResultModel;
import com.bytedance.android.annie.bridge.method.permission.PermissionStatus;
import e7.q0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s implements q9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f38637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f38638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ContentResolver f38639c;

    @Override // q9.c
    public final void onResult(boolean r100, Map<String, ? extends PermissionStatus> r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        if (r100 == false) goto L5;
        this.f38637a.j(this.f38638b, this.f38639c);
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
        r r104 = this.f38637a;
        ReadCalendarEventResultModel r105 = new ReadCalendarEventResultModel();
        r105.b(ReadCalendarEventResultModel.Code.NoPermission);
        r105.e("user denied permission");
        r104.finishWithResult(r105);
        return;
    L14:
        r r106 = this.f38637a;
        ReadCalendarEventResultModel r107 = new ReadCalendarEventResultModel();
        r107.b(ReadCalendarEventResultModel.Code.NoPermission);
        r107.e("user rejected permission");
        r106.finishWithResult(r107);
        return;
    L11:
        r103 = false;
        goto L12
    }

    public s(r r100, q0 r101, ContentResolver r102) {
        this.f38637a = r100;
        this.f38638b = r101;
        this.f38639c = r102;
    }
}
