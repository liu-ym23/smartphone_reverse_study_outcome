package s5;

import android.database.Cursor;
import androidx.activity.b;
import androidx.room.x;
import androidx.work.impl.WorkDatabase_Impl;
import g5.u;
import java.util.ArrayList;
import p5.g;
import p5.i;
import p5.j;
import p5.l;
import p5.p;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11407a = u.f("DiagnosticsWrkr");

    public static final String a(l lVar, p5.u uVar, i iVar, ArrayList arrayList) {
        String str;
        StringBuilder sb2 = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            p pVar = (p) obj;
            j jVarR = h.r(pVar);
            String str2 = pVar.f9764a;
            g gVarW = iVar.w(jVarR);
            Integer numValueOf = gVarW != null ? Integer.valueOf(gVarW.f9728c) : null;
            lVar.getClass();
            x xVarD = x.d(1, "SELECT name FROM workname WHERE work_spec_id=?");
            xVarD.h(1, str2);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) lVar.f9738c;
            workDatabase_Impl.b();
            Cursor cursorD = h.D(workDatabase_Impl, xVarD, false);
            try {
                ArrayList arrayList2 = new ArrayList(cursorD.getCount());
                while (cursorD.moveToNext()) {
                    arrayList2.add(cursorD.getString(0));
                }
                cursorD.close();
                xVarD.e();
                String strB0 = kb.l.B0(arrayList2, ",", null, null, null, 62);
                String strB02 = kb.l.B0(uVar.d(str2), ",", null, null, null, 62);
                StringBuilder sbO = b.o("\n", str2, "\t ");
                sbO.append(pVar.f9766c);
                sbO.append("\t ");
                sbO.append(numValueOf);
                sbO.append("\t ");
                switch (pVar.f9765b) {
                    case 1:
                        str = "ENQUEUED";
                        break;
                    case 2:
                        str = "RUNNING";
                        break;
                    case 3:
                        str = "SUCCEEDED";
                        break;
                    case 4:
                        str = "FAILED";
                        break;
                    case 5:
                        str = "BLOCKED";
                        break;
                    case 6:
                        str = "CANCELLED";
                        break;
                    default:
                        throw null;
                }
                sbO.append(str);
                sbO.append("\t ");
                sbO.append(strB0);
                sbO.append("\t ");
                sbO.append(strB02);
                sbO.append('\t');
                sb2.append(sbO.toString());
            } catch (Throwable th) {
                cursorD.close();
                xVarD.e();
                throw th;
            }
        }
        return sb2.toString();
    }
}
