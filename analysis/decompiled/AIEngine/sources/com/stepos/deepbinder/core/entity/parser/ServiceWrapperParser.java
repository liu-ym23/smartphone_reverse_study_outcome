package com.stepos.deepbinder.core.entity.parser;

import android.os.IBinder;
import android.os.Parcel;
import com.stepos.deepbinder.core.DeepBinderInternal;
import com.stepos.deepbinder.core.entity.wrapper.ServiceWrapper;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ServiceWrapperParser {
    public static final ServiceWrapperParser INSTANCE = new ServiceWrapperParser();

    private ServiceWrapperParser() {
    }

    public final ServiceWrapper parserServiceWrapperFromParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        ServiceWrapper serviceWrapperObtain = ServiceWrapper.Companion.obtain();
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
                g.e(strongBinder, "readStrongBinder(...)");
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

    public final void writeServiceWrapperIntoParcel(ServiceWrapper service, Parcel parcel, int i10, int i11) {
        g.f(service, "service");
        g.f(parcel, "parcel");
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
