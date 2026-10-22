package D8;

import D7.w;
import H4.o;
import com.apm.insight.log.ILog;
import com.apm.insight.log.VLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.m;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public List f433a;

    public j(ProtoBuf$TypeTable typeTable) {
        kotlin.jvm.internal.k.f(typeTable, "typeTable");
        List list = typeTable.c;
        if ((typeTable.b & 1) == 1) {
            int i = typeTable.d;
            kotlin.jvm.internal.k.e(list, "getTypeList(...)");
            List list2 = list;
            ArrayList arrayList = new ArrayList(w.c0(list2, 10));
            int i6 = 0;
            for (Object obj : list2) {
                int i10 = i6 + 1;
                if (i6 < 0) {
                    o.X();
                    throw null;
                }
                ProtoBuf$Type protoBuf$TypeE = (ProtoBuf$Type) obj;
                if (i6 >= i) {
                    protoBuf$TypeE.getClass();
                    m mVarO = ProtoBuf$Type.o(protoBuf$TypeE);
                    mVarO.d |= 2;
                    mVarO.f = true;
                    protoBuf$TypeE = mVarO.e();
                    if (!protoBuf$TypeE.isInitialized()) {
                        throw new UninitializedMessageException();
                    }
                }
                arrayList.add(protoBuf$TypeE);
                i6 = i10;
            }
            list = arrayList;
        }
        kotlin.jvm.internal.k.e(list, "run(...)");
        this.f433a = list;
    }

    public List a(long j5, long j6, String str) throws InterruptedException {
        this.f433a = new ArrayList();
        if (j5 < j6) {
            if ("alog".equals(str)) {
                VLog.flush();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.f433a = VLog.getLogFiles(j5, j6);
            } else if ("apmplus".equals(str)) {
                ILog vLog = VLog.getInstance("APMPlus");
                if (vLog != null) {
                    vLog.syncFlush();
                    this.f433a = vLog.getFilesOfAllProcesses(j5, j6);
                }
            } else if ("alog_apmplus".equals(str)) {
                VLog.flush();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e6) {
                    e6.printStackTrace();
                }
                this.f433a.addAll(VLog.getLogFiles(j5, j6));
                ILog vLog2 = VLog.getInstance("APMPlus");
                if (vLog2 != null) {
                    vLog2.syncFlush();
                    this.f433a.addAll(vLog2.getFilesOfAllProcesses(j5, j6));
                }
            }
        }
        return this.f433a;
    }

    public ProtoBuf$Type b(int i) {
        return (ProtoBuf$Type) this.f433a.get(i);
    }
}
