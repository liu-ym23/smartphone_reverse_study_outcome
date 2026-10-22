package com.stepos.deepbinder.core.entity.parser;

import C7.i;
import android.os.Parcel;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/entity/parser/CallParser;", "", AppAgent.CONSTRUCT, "()V", "Landroid/os/Parcel;", "parcel", "", "version", "Lcom/stepos/deepbinder/core/entity/Call;", "parserCallFromParcel", "(Landroid/os/Parcel;I)Lcom/stepos/deepbinder/core/entity/Call;", "call", "flags", "LC7/r;", "writeCallIntoParcel", "(Lcom/stepos/deepbinder/core/entity/Call;Landroid/os/Parcel;II)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallParser {
    public static final CallParser INSTANCE = new CallParser();

    private CallParser() {
    }

    public static /* synthetic */ Call parserCallFromParcel$default(CallParser callParser, Parcel parcel, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return callParser.parserCallFromParcel(parcel, i);
    }

    public static /* synthetic */ void writeCallIntoParcel$default(CallParser callParser, Call call, Parcel parcel, int i, int i6, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i = 0;
        }
        callParser.writeCallIntoParcel(call, parcel, i, i6);
    }

    public final Call parserCallFromParcel(Parcel parcel, int version) {
        k.f(parcel, "parcel");
        Call callObtain = Call.INSTANCE.obtain();
        callObtain.setProtocolVersion(version);
        callObtain.setServiceWrapper(ServiceWrapperParser.INSTANCE.parserServiceWrapperFromParcel(parcel, version));
        callObtain.setMethodWrapper(MethodWrapperParser.INSTANCE.parserMethodWrapperFromParcel(parcel));
        int i = parcel.readInt();
        if (i > 0) {
            ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[i];
            for (int i6 = 0; i6 < i; i6++) {
                parameterWrapperArr[i6] = ParameterWrapperParser.INSTANCE.parserParameterWrapperFromParcel(parcel, version);
            }
            callObtain.setParameterWrappers(parameterWrapperArr);
        }
        return callObtain;
    }

    public final void writeCallIntoParcel(Call call, Parcel parcel, int version, int flags) {
        k.f(call, "call");
        k.f(parcel, "parcel");
        ServiceWrapperParser.INSTANCE.writeServiceWrapperIntoParcel(call.getServiceWrapper(), parcel, version, flags);
        MethodWrapperParser.INSTANCE.writeMethodWrapperIntoParcel(call.getMethodWrapper(), parcel, flags);
        ParameterWrapper[] parameterWrappers = call.getParameterWrappers();
        int length = parameterWrappers != null ? parameterWrappers.length : 0;
        parcel.writeInt(length);
        if (length > 0 && parameterWrappers != null) {
            i iVarJ = k.j(parameterWrappers);
            while (iVarJ.hasNext()) {
                ParameterWrapperParser.INSTANCE.writeParameterWrapperIntoParcel((ParameterWrapper) iVarJ.next(), parcel, version, flags);
            }
        }
        call.setDataSize(parcel.dataSize());
    }
}
