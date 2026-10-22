package com.byted.cast.common.utils;

import android.text.TextUtils;
import com.byted.cast.common.Constants;
import com.byted.cast.common.Logger;
import com.byted.cast.common.source.ServiceInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class ServiceInfoUtils {
    private static final String SEPARATOR = ",";
    private static final String TAG = "ServiceInfoUtils";

    public ServiceInfoUtils() {
    }

    public static String getDeviceName(List<ServiceInfo> r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isEmpty() == true) goto L25;
        StringBuilder r101 = new StringBuilder();
        Iterator<ServiceInfo> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        ServiceInfo r103 = r102.next();
        if (r103 == null) goto L8;
        String r104 = r103.name;
        if (r104 == null) goto L8;
        r101.append(r104);
        r101.append(",");
        goto L8
    L15:
        return removeLastSeparator(r101.toString());
    L25:
        return "";
    }

    public static String getManufacture(List<ServiceInfo> r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isEmpty() == true) goto L25;
        StringBuilder r101 = new StringBuilder();
        Iterator<ServiceInfo> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        ServiceInfo r103 = r102.next();
        if (r103 == null) goto L8;
        String r104 = r103.manufacture;
        if (r104 == null) goto L8;
        r101.append(r104);
        r101.append(",");
        goto L8
    L15:
        return removeLastSeparator(r101.toString());
    L25:
        return "";
    }

    public static boolean hasBdLinkServiceInfo(List<ServiceInfo> r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L14;
        Iterator<ServiceInfo> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        if (isSupportBdLink(r101.next()) == false) goto L9;
        return true;
    }

    public static boolean hasByteLinkServiceInfo(List<ServiceInfo> r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L14;
        Iterator<ServiceInfo> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        if (isSupportByteLink(r101.next()) == false) goto L9;
        return true;
    }

    public static boolean isSupportBdLink(ServiceInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Map<String, String> r101 = r100.deviceParams;
        if (r101 != null) goto L8;
    L16:
        Logger.w(TAG, "isSupportBdLink , deviceParams is empty");
        return false;
    L8:
        if (r101.isEmpty() == true) goto L16;
        String r102 = r101.get(Constants.SOURCE_BDLINK_HAS_DEVICE_INFO);
        if (TextUtils.isEmpty(r102) == false) goto L14;
        Logger.w(TAG, "isSupportBdLink , hasDeviceInfo is empty");
        return false;
    L14:
        Logger.d(TAG, "isSupportBdLink return :" + Boolean.parseBoolean(r102));
        return Boolean.parseBoolean(r102);
    }

    public static boolean isSupportByteLink(ServiceInfo r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.portMirror <= 0) goto L6;
        return true;
    }

    private static String removeLastSeparator(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        int r101 = r100.lastIndexOf(",");
        if (r101 >= 0) goto L9;
        return r100;
    L9:
        return r100.substring(0, r101);
    }
}
