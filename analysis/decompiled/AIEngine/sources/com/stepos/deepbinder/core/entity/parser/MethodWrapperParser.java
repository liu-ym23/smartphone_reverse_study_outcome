package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import android.os.Process;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MethodWrapperParser {
    public static final MethodWrapperParser INSTANCE = new MethodWrapperParser();

    private MethodWrapperParser() {
    }

    public final MethodWrapper parserMethodWrapperFromParcel(Parcel parcel) {
        g.f(parcel, "parcel");
        MethodWrapper methodWrapperObtain = MethodWrapper.Companion.obtain();
        String string = parcel.readString();
        if (string == null) {
            string = "";
        }
        methodWrapperObtain.setName(string);
        if (parcel.readByte() == 0) {
            methodWrapperObtain.withReturnType(parcel.readString());
        } else {
            methodWrapperObtain.withVoid(true);
        }
        methodWrapperObtain.withSync(parcel.readByte() == 1);
        methodWrapperObtain.setPid(parcel.readInt());
        if (methodWrapperObtain.getPid() > 0) {
            methodWrapperObtain.withOneway(true);
        }
        return methodWrapperObtain;
    }

    public final void writeMethodWrapperIntoParcel(MethodWrapper method, Parcel parcel, int i10) {
        g.f(method, "method");
        g.f(parcel, "parcel");
        parcel.writeString(method.getName());
        if (method.isVoid()) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
            parcel.writeString(method.getReturnType());
        }
        parcel.writeByte(method.isSync() ? (byte) 1 : (byte) 0);
        parcel.writeInt(method.isOneway() ? Process.myPid() : 0);
    }
}
