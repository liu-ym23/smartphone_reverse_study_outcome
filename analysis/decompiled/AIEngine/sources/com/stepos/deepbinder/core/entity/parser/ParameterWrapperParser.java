package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import java.io.IOException;
import kotlin.jvm.internal.g;
import x9.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ParameterWrapperParser {
    public static final ParameterWrapperParser INSTANCE = new ParameterWrapperParser();

    private ParameterWrapperParser() {
    }

    public final ParameterWrapper parserParameterWrapperFromParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        ParameterWrapper parameterWrapperObtain = ParameterWrapper.Companion.obtain();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        parameterWrapperObtain.setName(string);
        parameterWrapperObtain.setFlowFlag(parcel.readByte());
        if (parcel.readByte() == 0) {
            parameterWrapperObtain.setHashCodeValue(parcel.readInt());
            parameterWrapperObtain.setTimeStamp(parcel.readLong());
            parameterWrapperObtain.setClientServiceBinder(parcel.readStrongBinder());
        }
        parameterWrapperObtain.setData(f.d(ParameterWrapperParser.class.getClassLoader(), parcel, i10));
        return parameterWrapperObtain;
    }

    public final void writeParameterWrapperIntoParcel(ParameterWrapper param, Parcel parcel, int i10, int i11) throws IOException {
        g.f(param, "param");
        g.f(parcel, "parcel");
        parcel.writeString(param.getName());
        parcel.writeByte((byte) param.getFlowFlag());
        if (param.getTimeStamp() == 0 && param.getClientServiceBinder() == null) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
            parcel.writeInt(param.getHashCodeValue());
            parcel.writeLong(param.getTimeStamp());
            parcel.writeStrongBinder(param.getClientServiceBinder());
        }
        f.e(parcel, param.getData(), i10, i11);
    }
}
