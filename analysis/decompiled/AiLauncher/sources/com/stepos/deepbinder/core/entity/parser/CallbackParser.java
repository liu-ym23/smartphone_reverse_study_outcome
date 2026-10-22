package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C4851b;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/entity/parser/CallbackParser;", "", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "", "version", "Lcom/stepos/deepbinder/core/entity/Callback;", "parserCallbackFromParcel", "(Landroid/os/Parcel;I)Lcom/stepos/deepbinder/core/entity/Callback;", "callback", "flags", "LY8/t;", "writeCallbackIntoParcel", "(Lcom/stepos/deepbinder/core/entity/Callback;Landroid/os/Parcel;II)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public static /* synthetic */ void writeCallbackIntoParcel$default(CallbackParser callbackParser, Callback callback, Parcel parcel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        callbackParser.writeCallbackIntoParcel(callback, parcel, i10, i11);
    }

    public final Callback parserCallbackFromParcel(Parcel parcel, int version) {
        p.i(parcel, "parcel");
        Callback callbackObtain = Callback.INSTANCE.obtain();
        callbackObtain.setProtocolVersion(version);
        callbackObtain.setTimeStamp(parcel.readLong());
        callbackObtain.setMethodWrapper(MethodWrapperParser.INSTANCE.parserMethodWrapperFromParcel(parcel));
        int i10 = parcel.readInt();
        if (i10 > 0) {
            ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                parameterWrapperArr[i11] = ParameterWrapperParser.INSTANCE.parserParameterWrapperFromParcel(parcel, version);
            }
            callbackObtain.setParameterWrappers(parameterWrapperArr);
        }
        if (parcel.dataAvail() > 0) {
            callbackObtain.setOneway(parcel.readByte() == 0);
        }
        return callbackObtain;
    }

    public final void writeCallbackIntoParcel(Callback callback, Parcel parcel, int version, int flags) {
        p.i(callback, "callback");
        p.i(parcel, "parcel");
        parcel.writeLong(callback.getTimeStamp());
        MethodWrapper methodWrapper = callback.getMethodWrapper();
        if (methodWrapper != null) {
            MethodWrapperParser.INSTANCE.writeMethodWrapperIntoParcel(methodWrapper, parcel, flags);
        }
        ParameterWrapper[] parameterWrappers = callback.getParameterWrappers();
        int length = parameterWrappers != null ? parameterWrappers.length : 0;
        parcel.writeInt(length);
        if (length > 0 && parameterWrappers != null) {
            Iterator itA = C4851b.a(parameterWrappers);
            while (itA.hasNext()) {
                ParameterWrapperParser.INSTANCE.writeParameterWrapperIntoParcel((ParameterWrapper) itA.next(), parcel, version, flags);
            }
        }
        if (callback.getIsOneway()) {
            parcel.writeByte((byte) 0);
        }
        callback.setDataSize(parcel.dataSize());
    }
}
