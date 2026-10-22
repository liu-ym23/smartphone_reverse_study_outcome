package o6;

import com.stepos.backend.qnn.dump.QnnDumpProvider;
import com.stepos.core.ability.config.cloud.AbilityConfigDiff;
import com.stepos.core.common.loadguard.PreheatAbortedException;
import com.stepos.core.data.ContentParams;
import com.stepos.cpuset.b;
import com.stepos.cpuset.c;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g;
import lb.n;
import uc.j;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10770a;

    public /* synthetic */ a(int i10) {
        this.f10770a = i10;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        switch (this.f10770a) {
            case 0:
                return QnnDumpProvider.dumpStats$lambda$3((Map.Entry) obj);
            case 1:
                return AbilityConfigDiff.sha8$lambda$6(((Byte) obj).byteValue());
            case 2:
                return Call.pool$lambda$10((Call) obj);
            case 3:
                return Callback.pool$lambda$9((Callback) obj);
            case 4:
                return Reply.pool$lambda$8((Reply) obj);
            case 5:
                return MethodWrapper.pool$lambda$6((MethodWrapper) obj);
            case 6:
                return ParameterWrapper.pool$lambda$7((ParameterWrapper) obj);
            case 7:
                return ServiceWrapper.pool$lambda$7((ServiceWrapper) obj);
            case 8:
                return PreheatAbortedException.Companion.isCause$lambda$0((Throwable) obj);
            case 9:
                rc.a buildSerialDescriptor = (rc.a) obj;
                g.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                rc.a.a(buildSerialDescriptor, "JsonPrimitive", new j(new c(17)));
                rc.a.a(buildSerialDescriptor, "JsonNull", new j(new b(15)));
                rc.a.a(buildSerialDescriptor, "JsonLiteral", new j(new c(18)));
                rc.a.a(buildSerialDescriptor, "JsonObject", new j(new b(16)));
                rc.a.a(buildSerialDescriptor, "JsonArray", new j(new c(19)));
                return n.f10413a;
            case 10:
                g.f((List) obj, "it");
                return null;
            case 11:
                Class it = (Class) obj;
                g.f(it, "it");
                return it.getSimpleName();
            case 12:
                Class it2 = (Class) obj;
                g.f(it2, "it");
                return it2.getSimpleName();
            default:
                return ContentParams.toString$lambda$2((Map.Entry) obj);
        }
    }
}
