package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import java.io.IOException;
import kotlin.jvm.internal.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CallbackParser {
    public static final CallbackParser INSTANCE = new CallbackParser();

    private CallbackParser() {
    }

    public static /* synthetic */ Callback parserCallbackFromParcel$default(CallbackParser callbackParser, Parcel parcel, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return callbackParser.parserCallbackFromParcel(parcel, i10);
    }

    public static /* synthetic */ void writeCallbackIntoParcel$default(CallbackParser callbackParser, Callback callback, Parcel parcel, int i10, int i11, int i12, Object obj) throws IOException {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        callbackParser.writeCallbackIntoParcel(callback, parcel, i10, i11);
    }

    public final Callback parserCallbackFromParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        Callback callbackObtain = Callback.CREATOR.obtain();
        callbackObtain.setProtocolVersion(i10);
        callbackObtain.setTimeStamp(parcel.readLong());
        callbackObtain.setMethodWrapper(MethodWrapperParser.INSTANCE.parserMethodWrapperFromParcel(parcel));
        int i11 = parcel.readInt();
        if (i11 > 0) {
            ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                parameterWrapperArr[i12] = ParameterWrapperParser.INSTANCE.parserParameterWrapperFromParcel(parcel, i10);
            }
            callbackObtain.setParameterWrappers(parameterWrapperArr);
        }
        if (parcel.dataAvail() > 0) {
            callbackObtain.setOneway(parcel.readByte() == 0);
        }
        return callbackObtain;
    }

    public final void writeCallbackIntoParcel(Callback callback, Parcel parcel, int i10, int i11) throws IOException {
        g.f(callback, "callback");
        g.f(parcel, "parcel");
        parcel.writeLong(callback.getTimeStamp());
        MethodWrapper methodWrapper = callback.getMethodWrapper();
        if (methodWrapper != null) {
            MethodWrapperParser.INSTANCE.writeMethodWrapperIntoParcel(methodWrapper, parcel, i11);
        }
        ParameterWrapper[] parameterWrappers = callback.getParameterWrappers();
        int length = parameterWrappers != null ? parameterWrappers.length : 0;
        parcel.writeInt(length);
        if (length > 0 && parameterWrappers != null) {
            a aVarO = b1.O(parameterWrappers);
            while (aVarO.hasNext()) {
                ParameterWrapperParser.INSTANCE.writeParameterWrapperIntoParcel((ParameterWrapper) aVarO.next(), parcel, i10, i11);
            }
        }
        if (callback.isOneway()) {
            parcel.writeByte((byte) 0);
        }
        callback.setDataSize(parcel.dataSize());
    }
}
