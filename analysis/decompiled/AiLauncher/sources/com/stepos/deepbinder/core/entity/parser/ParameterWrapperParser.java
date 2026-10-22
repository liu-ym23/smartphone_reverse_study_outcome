package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.utils.SerializeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/entity/parser/ParameterWrapperParser;", "", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "", "version", "Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "parserParameterWrapperFromParcel", "(Landroid/os/Parcel;I)Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;", "param", "flags", "LY8/t;", "writeParameterWrapperIntoParcel", "(Lcom/stepos/deepbinder/core/entity/wrapper/ParameterWrapper;Landroid/os/Parcel;II)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ParameterWrapperParser {
    public static final ParameterWrapperParser INSTANCE = new ParameterWrapperParser();

    private ParameterWrapperParser() {
    }

    public final ParameterWrapper parserParameterWrapperFromParcel(Parcel parcel, int version) {
        p.i(parcel, "parcel");
        ParameterWrapper parameterWrapperObtain = ParameterWrapper.INSTANCE.obtain();
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
        parameterWrapperObtain.setData(SerializeUtils.INSTANCE.readFromParcel(ParameterWrapperParser.class.getClassLoader(), parcel, version));
        return parameterWrapperObtain;
    }

    public final void writeParameterWrapperIntoParcel(ParameterWrapper param, Parcel parcel, int version, int flags) {
        p.i(param, "param");
        p.i(parcel, "parcel");
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
        SerializeUtils.INSTANCE.writeToParcel(parcel, param.getData(), version, flags, true);
    }
}
