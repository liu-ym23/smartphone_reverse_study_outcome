package ak5;

import com.bytedance.ee.bear.net.RawServerResult;
import com.bytedance.ee.bear.net.ServerResult;
import com.bytedance.ee.bear.net.ServerResultException;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class d<T extends ServerResult> implements Function<T, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<y> f4007a;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) throws Exception {
        ServerResult r101 = (ServerResult) r100;
        int r102 = r101.getCode();
        if (r102 != 5) goto L11;
        List<y> r103 = this.f4007a;
        if (r103 == null) goto L11;
        Iterator<y> r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        r104.next().a();
    L11:
        if (r102 != 0) goto L13;
        return r101;
    L13:
        if ((r101 instanceof RawServerResult) == false) goto L17;
        String r105 = r101.getMsg();
        String r106 = r101.getData();
        RawServerResult r107 = (RawServerResult) r101;
        throw new ServerResultException(r102, r105, r106, r107.getJson(), r107.getLogId());
    L17:
        throw new ServerResultException(r102, r101.getMsg(), r101.getData(), "", "");
    }

    public d(String r100, List<y> r101) {
        this.f4007a = r101;
    }
}
