package com.bytedance.android.sdk.bdticketguard;

import android.util.Base64;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"base64Equals", "", "str1", "", "str2", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final class RequestContext$TicketAssociateInfo$hasAnomalies$1 extends Lambda implements Function2<String, String, Boolean> {
    public static final RequestContext$TicketAssociateInfo$hasAnomalies$1 INSTANCE = null;

    static {
        INSTANCE = new RequestContext$TicketAssociateInfo$hasAnomalies$1();
    }

    public RequestContext$TicketAssociateInfo$hasAnomalies$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(String r100, String r101) {
        byte[] r102 = Base64.decode(r100, 0);     // Catch: Exception -> L10
        byte[] r103 = Base64.decode(r101, 0);     // Catch: Exception -> L10
        if (r102 == null) goto L9;
        if (r103 == null) goto L9;
        return Arrays.equals(r102, r103);
    L9:
        return false;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(String r100, String r101) {
        return Boolean.valueOf(invoke2(r100, r101));
    }
}
