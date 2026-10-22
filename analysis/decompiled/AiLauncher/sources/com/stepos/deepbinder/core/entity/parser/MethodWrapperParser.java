package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import android.os.Process;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/deepbinder/core/entity/parser/MethodWrapperParser;", "", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "parserMethodWrapperFromParcel", "(Landroid/os/Parcel;)Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;", "method", "", "flags", "LY8/t;", "writeMethodWrapperIntoParcel", "(Lcom/stepos/deepbinder/core/entity/wrapper/MethodWrapper;Landroid/os/Parcel;I)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MethodWrapperParser {
    public static final MethodWrapperParser INSTANCE = new MethodWrapperParser();

    private MethodWrapperParser() {
    }

    public final MethodWrapper parserMethodWrapperFromParcel(Parcel parcel) {
        p.i(parcel, "parcel");
        MethodWrapper methodWrapperObtain = MethodWrapper.INSTANCE.obtain();
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

    public final void writeMethodWrapperIntoParcel(MethodWrapper method, Parcel parcel, int flags) {
        p.i(method, "method");
        p.i(parcel, "parcel");
        parcel.writeString(method.getName());
        if (method.getIsVoid()) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
            parcel.writeString(method.getReturnType());
        }
        parcel.writeByte(method.getIsSync() ? (byte) 1 : (byte) 0);
        parcel.writeInt(method.getIsOneway() ? Process.myPid() : 0);
    }
}
