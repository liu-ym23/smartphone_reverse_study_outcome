package f1;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import i1.InterfaceC4162d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Li1/d;", "stmt", "", "name", "", Const.INTENT_KEY_PKGNAME, "(Li1/d;Ljava/lang/String;)I", Const.INTENT_KEY_APIKEY, "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/util/SQLiteStatementUtil")
/* renamed from: f1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C4040j {
    public static final int a(InterfaceC4162d interfaceC4162d, String name) {
        p.i(interfaceC4162d, "<this>");
        p.i(name, "name");
        if (interfaceC4162d instanceof C4036f) {
            return ((C4036f) interfaceC4162d).getColumnIndex(name);
        }
        int columnCount = interfaceC4162d.getColumnCount();
        for (int i10 = 0; i10 < columnCount; i10++) {
            if (p.d(name, interfaceC4162d.getColumnName(i10))) {
                return i10;
            }
        }
        return -1;
    }

    public static final int b(InterfaceC4162d stmt, String name) {
        p.i(stmt, "stmt");
        p.i(name, "name");
        int iA = C4039i.a(stmt, name);
        if (iA >= 0) {
            return iA;
        }
        int columnCount = stmt.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i10 = 0; i10 < columnCount; i10++) {
            arrayList.add(stmt.getColumnName(i10));
        }
        throw new IllegalArgumentException("Column '" + name + "' does not exist. Available columns: [" + F.A0(arrayList, null, null, null, 0, null, null, 63, null) + ']');
    }
}
