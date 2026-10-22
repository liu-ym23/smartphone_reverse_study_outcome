package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f72640a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f72641b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f72642c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f72643d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f72644e = null;

    static {
        if (((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).isBoe() == false) goto L9;
        if (a() == false) goto L7;
        String r100 = "2388856";
    L12:
        f72640a = r100;
        if (((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).isBoe() == false) goto L19;
        if (a() == false) goto L17;
        String r101 = "2388858";
    L22:
        f72641b = r101;
        if (((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).isBoe() == false) goto L29;
        if (a() == false) goto L27;
        String r102 = "2388860";
    L32:
        f72642c = r102;
        if (((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).isBoe() == false) goto L39;
        if (a() == false) goto L37;
        String r103 = "2388862";
    L42:
        f72643d = r103;
        if (((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).isBoe() == false) goto L49;
        if (a() == false) goto L47;
        String r104 = "2388864";
    L52:
        f72644e = r104;
        return;
    L47:
        r104 = "2388865";
        goto L52
    L49:
        if (a() == false) goto L51;
        r104 = "1235503";
        goto L52
    L51:
        r104 = "1235504";
        goto L52
    L37:
        r103 = "2388863";
        goto L42
    L39:
        if (a() == false) goto L41;
        r103 = "1209123";
        goto L42
    L41:
        r103 = "1209124";
        goto L42
    L27:
        r102 = "2388861";
        goto L32
    L29:
        if (a() == false) goto L31;
        r102 = "1120551";
        goto L32
    L31:
        r102 = "1120552";
        goto L32
    L17:
        r101 = "2388859";
        goto L22
    L19:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L21;
        r101 = "1120549";
        goto L22
    L21:
        r101 = "1120550";
        goto L22
    L7:
        r100 = "2388857";
        goto L12
    L9:
        if (a() == false) goto L11;
        r100 = "1120533";
        goto L12
    L11:
        r100 = "1120534";
        goto L12
    }

    public static boolean a() {
        return Intrinsics.areEqual("local_test", ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getChannel());
    }
}
