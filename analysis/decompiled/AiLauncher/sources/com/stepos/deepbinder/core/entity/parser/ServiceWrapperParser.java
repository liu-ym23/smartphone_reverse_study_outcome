package com.stepos.deepbinder.core.entity.parser;

import android.os.IBinder;
import android.os.Parcel;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/deepbinder/core/entity/parser/ServiceWrapperParser;", "", "<init>", "()V", "Landroid/os/Parcel;", "parcel", "", "version", "Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "parserServiceWrapperFromParcel", "(Landroid/os/Parcel;I)Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;", "service", "flags", "LY8/t;", "writeServiceWrapperIntoParcel", "(Lcom/stepos/deepbinder/core/entity/wrapper/ServiceWrapper;Landroid/os/Parcel;II)V", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ServiceWrapperParser {
    public static final ServiceWrapperParser INSTANCE = new ServiceWrapperParser();

    private ServiceWrapperParser() {
    }

    public final ServiceWrapper parserServiceWrapperFromParcel(Parcel parcel, int version) {
        p.i(parcel, "parcel");
        ServiceWrapper serviceWrapperObtain = ServiceWrapper.INSTANCE.obtain();
        byte b10 = parcel.readByte();
        serviceWrapperObtain.setType(b10);
        if (b10 == 4) {
            String string = parcel.readString();
            if (string == null) {
                string = "";
            }
            serviceWrapperObtain.setName(string);
        } else {
            serviceWrapperObtain.setTimeStamp(parcel.readLong());
        }
        if (b10 == 0 || b10 == 1) {
            String string2 = parcel.readString();
            if (string2 == null) {
                string2 = "";
            }
            serviceWrapperObtain.setName(string2);
            if (parcel.readByte() == 0) {
                String string3 = parcel.readString();
                if (string3 == null) {
                    string3 = "";
                }
                serviceWrapperObtain.setCallerPackageName(string3);
                parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                p.h(strongBinder, "readStrongBinder(...)");
                serviceWrapperObtain.withProxyStateBinder(strongBinder);
            } else {
                serviceWrapperObtain.setCallerPackageName(DeepBinderInternal.getContext().getPackageName());
            }
        }
        if (b10 != 0 && b10 != 1 && b10 != 4) {
            return serviceWrapperObtain;
        }
        String string4 = parcel.readString();
        serviceWrapperObtain.setCallerProcessName(string4 != null ? string4 : "");
        return serviceWrapperObtain;
    }

    public final void writeServiceWrapperIntoParcel(ServiceWrapper service, Parcel parcel, int version, int flags) {
        p.i(service, "service");
        p.i(parcel, "parcel");
        parcel.writeByte((byte) service.getType());
        if (service.getType() == 4) {
            parcel.writeString(service.getName());
        } else {
            parcel.writeLong(service.getTimeStamp());
        }
        if (service.getType() == 1 || service.getType() == 0) {
            parcel.writeString(service.getName());
            parcel.writeByte((byte) 0);
            parcel.writeString(service.getCallerPackageName());
            parcel.writeString("1.0.0");
            parcel.writeStrongBinder(service.getProxyStateBinder());
        }
        if (service.getType() == 4 || service.getType() == 1 || service.getType() == 0) {
            parcel.writeString(service.getCallerProcessName());
        }
    }
}
