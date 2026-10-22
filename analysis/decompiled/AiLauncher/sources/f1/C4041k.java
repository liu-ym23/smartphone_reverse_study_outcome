package f1;

import com.autonavi.aps.amapapi.config.Const;
import i1.InterfaceC4162d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Li1/d;", "", "name", "", Const.INTENT_KEY_APIKEY, "(Li1/d;Ljava/lang/String;)I", Const.INTENT_KEY_PKGNAME, "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/util/SQLiteStatementUtil")
/* renamed from: f1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C4041k {
    public static final int a(InterfaceC4162d interfaceC4162d, String name) {
        p.i(interfaceC4162d, "<this>");
        p.i(name, "name");
        int iB = C4039i.b(interfaceC4162d, name);
        if (iB >= 0) {
            return iB;
        }
        int iB2 = C4039i.b(interfaceC4162d, '`' + name + '`');
        return iB2 >= 0 ? iB2 : b(interfaceC4162d, name);
    }

    public static final int b(InterfaceC4162d interfaceC4162d, String str) {
        return -1;
    }
}
