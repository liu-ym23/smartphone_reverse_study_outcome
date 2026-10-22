package com.bytedance.android.annie.bridge.method.permission;

import com.bytedance.android.annie.bridge.method.abs.RequestPermissionResultModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d implements q9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestPermissionMethod f38779a;

    public d(RequestPermissionMethod r100) {
        this.f38779a = r100;
    }

    @Override // q9.c
    public final void onResult(boolean r100, Map<String, ? extends PermissionStatus> r101) {
        Intrinsics.checkNotNullParameter(r101, "result");
        RequestPermissionMethod r102 = this.f38779a;
        RequestPermissionResultModel r103 = new RequestPermissionResultModel();
        r103.a(RequestPermissionResultModel.Code.Success);
        if (r100 == false) goto L5;
        String r104 = RequestPermissionResultModel.Status.Permitted.toString();
    L15:
        r103.c(r104);
        r103.b("Request Permission Success !");
        r102.finishWithResult(r103);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r101, "result");
        Iterator r105 = ((LinkedHashMap) r101).values().iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        if (((PermissionStatus) r105.next()) != PermissionStatus.UNDETERMINED) goto L7;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L14;
        r104 = RequestPermissionResultModel.Status.Undetermined.toString();
        goto L15
    L14:
        r104 = RequestPermissionResultModel.Status.Denied.toString();
        goto L15
    L11:
        r106 = false;
        goto L12
    }
}
