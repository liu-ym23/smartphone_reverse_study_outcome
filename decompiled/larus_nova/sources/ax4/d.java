package ax4;

import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    public static int a(Throwable r100) {
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L7;
        int r101 = ((NetService.ServerErrorException) r100).getCode();
        tt5.a.h("ServerErrorCode", "exceptionToCode(): code = " + r101);
        if (r101 == 0) goto L9;
        return r101;
    L9:
        return -1;
    L7:
        return -1;
    }

    public static boolean b(Throwable r100, int r101) {
        if ((r100 instanceof NetService.ServerErrorException) == false) goto L8;
        int r102 = ((NetService.ServerErrorException) r100).getCode();
        tt5.a.h("ServerErrorCode", "isErrorCodeEqual(): code = " + r102);
        if (r102 != r101) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }
}
