package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import java.io.IOException;
import kotlin.jvm.internal.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CallParser {
    public static final CallParser INSTANCE = new CallParser();

    private CallParser() {
    }

    public static /* synthetic */ Call parserCallFromParcel$default(CallParser callParser, Parcel parcel, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return callParser.parserCallFromParcel(parcel, i10);
    }

    public static /* synthetic */ void writeCallIntoParcel$default(CallParser callParser, Call call, Parcel parcel, int i10, int i11, int i12, Object obj) throws IOException {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        callParser.writeCallIntoParcel(call, parcel, i10, i11);
    }

    public final Call parserCallFromParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        Call callObtain = Call.CREATOR.obtain();
        callObtain.setProtocolVersion(i10);
        callObtain.setServiceWrapper(ServiceWrapperParser.INSTANCE.parserServiceWrapperFromParcel(parcel, i10));
        callObtain.setMethodWrapper(MethodWrapperParser.INSTANCE.parserMethodWrapperFromParcel(parcel));
        int i11 = parcel.readInt();
        if (i11 > 0) {
            ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                parameterWrapperArr[i12] = ParameterWrapperParser.INSTANCE.parserParameterWrapperFromParcel(parcel, i10);
            }
            callObtain.setParameterWrappers(parameterWrapperArr);
        }
        return callObtain;
    }

    public final void writeCallIntoParcel(Call call, Parcel parcel, int i10, int i11) throws IOException {
        g.f(call, "call");
        g.f(parcel, "parcel");
        ServiceWrapperParser.INSTANCE.writeServiceWrapperIntoParcel(call.getServiceWrapper(), parcel, i10, i11);
        MethodWrapperParser.INSTANCE.writeMethodWrapperIntoParcel(call.getMethodWrapper(), parcel, i11);
        ParameterWrapper[] parameterWrappers = call.getParameterWrappers();
        int length = parameterWrappers != null ? parameterWrappers.length : 0;
        parcel.writeInt(length);
        if (length > 0 && parameterWrappers != null) {
            a aVarO = b1.O(parameterWrappers);
            while (aVarO.hasNext()) {
                ParameterWrapperParser.INSTANCE.writeParameterWrapperIntoParcel((ParameterWrapper) aVarO.next(), parcel, i10, i11);
            }
        }
        call.setDataSize(parcel.dataSize());
    }
}
