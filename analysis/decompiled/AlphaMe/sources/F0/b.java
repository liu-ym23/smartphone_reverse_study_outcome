package F0;

import B0.f;
import B0.g;
import B0.h;
import B0.i;
import B0.m;
import B0.p;
import B0.r;
import B0.w;
import android.database.Cursor;
import android.support.v4.media.session.c;
import androidx.room.A;
import androidx.room.E;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s0.t;
import t0.J;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f430a;

    static {
        String strF = t.f("DiagnosticsWrkr");
        Intrinsics.checkNotNullExpressionValue(strF, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f430a = strF;
    }

    public static final String a(m mVar, w wVar, i iVar, ArrayList arrayList) {
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            h hVarB = ((p) iVar).b(f.v(rVar));
            Integer numValueOf = hVarB != null ? Integer.valueOf(hVarB.f147c) : null;
            mVar.getClass();
            E eD = E.d(1, "SELECT name FROM workname WHERE work_spec_id=?");
            String str = rVar.f167a;
            if (str == null) {
                eD.bindNull(1);
            } else {
                eD.bindString(1, str);
            }
            ((A) mVar.f155b).assertNotSuspendingTransaction();
            Cursor cursorH = J.H((A) mVar.f155b, eD);
            try {
                ArrayList arrayList2 = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    arrayList2.add(cursorH.isNull(0) ? null : cursorH.getString(0));
                }
                cursorH.close();
                eD.e();
                String strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
                String strJoinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(((c) wVar).t(str), ",", null, null, 0, null, null, 62, null);
                StringBuilder sbW = g.w("\n", str, "\t ");
                sbW.append(rVar.f169c);
                sbW.append("\t ");
                sbW.append(numValueOf);
                sbW.append("\t ");
                sbW.append(rVar.f168b.name());
                sbW.append("\t ");
                sbW.append(strJoinToString$default);
                sbW.append("\t ");
                sbW.append(strJoinToString$default2);
                sbW.append('\t');
                sb.append(sbW.toString());
            } catch (Throwable th) {
                cursorH.close();
                eD.e();
                throw th;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
