package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.SendCMDResultCallback;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Response;
import hc.b;
import io.reactivex.MaybeEmitter;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.r0;
import kotlin.collections.s;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11931a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet f11933c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static List f11934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HashSet f11935e;

    static {
        f11931a = new a();
        f11932b = 35;
        f11933c = r0.f(new Integer[]{Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())});
        f11934d = s.e(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        f11935e = new HashSet();
    }

    public a() {
    }

    public static final /* synthetic */ void a(a r10, int r11, MaybeEmitter r12, SendCMDResultCallback r13, int r14, String r15) {
        r10.b(r11, r12, r13, r14, r15);
    }

    public final void b(int r10, MaybeEmitter r11, SendCMDResultCallback r12, int r13, String r14) {
        String r15 = null;
        b.b("CmdManager", "handleBinderCallFail, errorCode: " + r13 + ", errorMsg: " + r14, null, 4, null);
        Response r16 = new Response.a().i(Integer.valueOf(r13)).e(r14).c();
        gc.a r17 = gc.a.f20041a;
        Context r18 = ac.a.f80a.c();
        if (r18 == null) goto L5;
        r15 = r18.getPackageName();
    L5:
        if (r15 != null) goto L7;
        String r19 = "";
    L8:
        q.f(r16, "response");
        r17.a(r10, 1, r19, r16, null);
        if (r11 == null) goto L11;
        r11.onSuccess(new Pair(Integer.valueOf(r10), r16));
    L11:
        if (r12 == null) goto L14;
        r12.onResult(r10, r16);
        return;
    L14:
        return;
    L7:
        r19 = r15;
        goto L8
    }
}
