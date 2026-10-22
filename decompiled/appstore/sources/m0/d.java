package m0;

import androidx.work.i;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.f;
import androidx.work.impl.model.o;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.b0;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22018a = null;

    static {
        String r10 = i.i("DiagnosticsWrkr");
        q.f(r10, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f22018a = r10;
    }

    public static final /* synthetic */ String a() {
        return f22018a;
    }

    public static final /* synthetic */ String b(WorkNameDao r10, WorkTagDao r11, SystemIdInfoDao r12, List r13) {
        return d(r10, r11, r12, r13);
    }

    public static final String c(o r10, String r11, Integer r12, String r13) {
        return '\n' + r10.f5670a + "\t " + r10.f5672c + "\t " + r12 + "\t " + r10.f5671b.name() + "\t " + r11 + "\t " + r13 + '\t';
    }

    public static final String d(WorkNameDao r18, WorkTagDao r19, SystemIdInfoDao r20, List r21) {
        StringBuilder r10 = new StringBuilder();
        r10.append("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator r11 = r21.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        o r12 = (o) r11.next();
        f r13 = r20.getSystemIdInfo(androidx.work.impl.model.q.a(r12));
        if (r13 == null) goto L8;
        Integer r14 = Integer.valueOf(r13.f5643c);
    L9:
        r10.append(c(r12, b0.h0(r18.getNamesForWorkSpecId(r12.f5670a), ",", null, null, 0, null, null, 62, null), r14, b0.h0(r19.getTagsForWorkSpecId(r12.f5670a), ",", null, null, 0, null, null, 62, null)));
        goto L4
    L8:
        r14 = null;
        goto L9
    L10:
        String r15 = r10.toString();
        q.f(r15, "StringBuilder().apply(builderAction).toString()");
        return r15;
    }
}
