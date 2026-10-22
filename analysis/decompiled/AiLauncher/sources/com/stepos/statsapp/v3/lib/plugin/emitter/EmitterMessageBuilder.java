package com.stepos.statsapp.v3.lib.plugin.emitter;

import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class EmitterMessageBuilder {
    protected static String fieldSeparate;
    protected static byte[] separate01;
    protected static byte[] separate00 = {0};
    protected static byte[] separate02 = {2};
    protected static byte[] separate03 = {3};
    protected static String elementSeparate = new String(separate02);
    protected static String mapSeparate = new String(separate03);
    protected static String newlineSeparate = new String("\n");

    static {
        byte[] bArr = {1};
        separate01 = bArr;
        fieldSeparate = new String(bArr);
    }

    public static int booleanToInt(boolean z10) {
        return z10 ? 1 : 0;
    }

    public static String buildEvents(List<TrackerPayload> list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(UxipConstants.EVENT_UPLOAD_MAJOR_VERSION);
        sb2.append(UxipConstants.EVENT_UPLOAD_MIN_VERSION);
        Iterator<TrackerPayload> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(parcelOneEvent(it.next()));
        }
        return sb2.toString();
    }

    public static void parceIDIdentify(TrackerPayload trackerPayload, StringBuilder sb2) {
        Object obj = trackerPayload.getHeaderMap().get(Parameters.UDID);
        if (obj instanceof String) {
            sb2.append(obj);
        }
        sb2.append(fieldSeparate);
        Object obj2 = trackerPayload.getHeaderMap().get(Parameters.OAID);
        if (obj2 instanceof String) {
            sb2.append(obj2);
        }
        sb2.append(fieldSeparate);
        Object obj3 = trackerPayload.getHeaderMap().get(Parameters.VAID);
        if (obj3 instanceof String) {
            sb2.append(obj3);
        }
        sb2.append(fieldSeparate);
        Object obj4 = trackerPayload.getHeaderMap().get(Parameters.AAID);
        if (obj4 instanceof String) {
            sb2.append(obj4);
        }
        sb2.append(fieldSeparate);
        Object obj5 = trackerPayload.getHeaderMap().get(Parameters.RIMEI);
        if (obj5 instanceof String) {
            sb2.append(obj5);
        }
        sb2.append(fieldSeparate);
        Object obj6 = trackerPayload.getHeaderMap().get(Parameters.SN1);
        if (obj6 instanceof String) {
            sb2.append(obj6);
        }
        sb2.append(fieldSeparate);
        Object obj7 = trackerPayload.getHeaderMap().get(Parameters.SN2);
        if (obj7 instanceof String) {
            sb2.append(obj7);
        }
    }

    public static void parcelApp(TrackerPayload trackerPayload, StringBuilder sb2) {
        Object obj = trackerPayload.getHeaderMap().get(Parameters.PKG_KEY);
        if (obj instanceof String) {
            sb2.append(obj);
        }
        sb2.append(fieldSeparate);
        Object obj2 = trackerPayload.getHeaderMap().get(Parameters.PKG_TYPE);
        if (obj2 instanceof Integer) {
            sb2.append(obj2);
        }
        sb2.append(fieldSeparate);
        Object obj3 = trackerPayload.getHeaderMap().get(Parameters.PKG_NAME);
        if (obj3 instanceof String) {
            sb2.append(obj3);
        }
        sb2.append(fieldSeparate);
        Object obj4 = trackerPayload.getHeaderMap().get(Parameters.PKG_VER);
        if (obj4 instanceof String) {
            sb2.append(obj4);
        }
        sb2.append(fieldSeparate);
        Object obj5 = trackerPayload.getHeaderMap().get(Parameters.PKG_VER_CODE);
        if (obj5 instanceof Integer) {
            sb2.append(obj5);
        }
        sb2.append(fieldSeparate);
        Object obj6 = trackerPayload.getHeaderMap().get(Parameters.SDK_VER);
        if (obj6 instanceof String) {
            sb2.append(obj6);
        }
        sb2.append(fieldSeparate);
        Object obj7 = trackerPayload.getHeaderMap().get(Parameters.CHANNEL_ID);
        if (obj7 instanceof String) {
            sb2.append(obj7);
        }
        sb2.append(fieldSeparate);
    }

    public static void parcelDevice(TrackerPayload trackerPayload, StringBuilder sb2) {
        Object obj = trackerPayload.getHeaderMap().get(Parameters.BRAND);
        if (obj instanceof String) {
            sb2.append(obj);
        }
        sb2.append(fieldSeparate);
        Object obj2 = trackerPayload.getHeaderMap().get(Parameters.DEVICE);
        if (obj2 instanceof String) {
            sb2.append(obj2);
        }
        sb2.append(fieldSeparate);
        Object obj3 = trackerPayload.getHeaderMap().get(Parameters.PRODUCT_MODEL);
        if (obj3 instanceof String) {
            sb2.append(obj3);
        }
        sb2.append(fieldSeparate);
        Object obj4 = trackerPayload.getHeaderMap().get(Parameters.OS_TYPE);
        if (obj4 instanceof String) {
            sb2.append(obj4);
        }
        sb2.append(fieldSeparate);
        Object obj5 = trackerPayload.getHeaderMap().get(Parameters.OS_VERSION);
        if (obj5 instanceof String) {
            sb2.append(obj5);
        }
        sb2.append(fieldSeparate);
        Object obj6 = trackerPayload.getHeaderMap().get(Parameters.OS);
        if (obj6 instanceof String) {
            sb2.append(obj6);
        }
        sb2.append(fieldSeparate);
        Object obj7 = trackerPayload.getHeaderMap().get(Parameters.STEPOS_VER);
        if (obj7 instanceof String) {
            sb2.append(obj7);
        }
        sb2.append(fieldSeparate);
        Object obj8 = trackerPayload.getHeaderMap().get(Parameters.BUILD_MASK);
        if (obj8 instanceof String) {
            sb2.append(obj8);
        }
        sb2.append(fieldSeparate);
        Object obj9 = trackerPayload.getHeaderMap().get("umid");
        if (obj9 instanceof String) {
            sb2.append(obj9);
        }
        sb2.append(fieldSeparate);
        Object obj10 = trackerPayload.getHeaderMap().get(Parameters.IMEI);
        if (obj10 instanceof String) {
            sb2.append(obj10);
        }
        sb2.append(fieldSeparate);
        Object obj11 = trackerPayload.getHeaderMap().get(Parameters.MAC_ADDRESS);
        if (obj11 instanceof String) {
            sb2.append(obj11);
        }
        sb2.append(fieldSeparate);
        Object obj12 = trackerPayload.getHeaderMap().get(Parameters.SN);
        if (obj12 instanceof String) {
            sb2.append(obj12);
        }
        sb2.append(fieldSeparate);
        Object obj13 = trackerPayload.getHeaderMap().get(Parameters.ANDROID_ID);
        if (obj13 instanceof String) {
            sb2.append(obj13);
        }
        sb2.append(fieldSeparate);
        Object obj14 = trackerPayload.getHeaderMap().get(Parameters.ANDROID_AD_ID);
        if (obj14 instanceof String) {
            sb2.append(obj14);
        }
        sb2.append(fieldSeparate);
        Object obj15 = trackerPayload.getHeaderMap().get(Parameters.IMSI1);
        if (obj15 instanceof String) {
            sb2.append(obj15);
        }
        sb2.append(fieldSeparate);
        Object obj16 = trackerPayload.getHeaderMap().get(Parameters.IMSI2);
        if (obj16 instanceof String) {
            sb2.append(obj16);
        }
        sb2.append(fieldSeparate);
        Object obj17 = trackerPayload.getHeaderMap().get(Parameters.TER_TYPE);
        if (obj17 instanceof Integer) {
            sb2.append(obj17);
        }
        sb2.append(fieldSeparate);
        Object obj18 = trackerPayload.getHeaderMap().get(Parameters.SRE);
        if (obj18 instanceof String) {
            sb2.append(obj18);
        }
        sb2.append(fieldSeparate);
        Object obj19 = trackerPayload.getHeaderMap().get(Parameters.LLA);
        if (obj19 instanceof String) {
            sb2.append(obj19);
        }
        sb2.append(fieldSeparate);
        Object obj20 = trackerPayload.getHeaderMap().get(Parameters.ROOT);
        if (obj20 instanceof Boolean) {
            sb2.append(booleanToInt(((Boolean) obj20).booleanValue()));
        }
        sb2.append(fieldSeparate);
        Object obj21 = trackerPayload.getHeaderMap().get(Parameters.STEPOS_UID);
        if (obj21 instanceof String) {
            sb2.append(obj21);
        }
        sb2.append(fieldSeparate);
        Object obj22 = trackerPayload.getHeaderMap().get("country");
        if (obj22 instanceof String) {
            sb2.append(obj22);
        }
        sb2.append(fieldSeparate);
        Object obj23 = trackerPayload.getHeaderMap().get(Parameters.OPERATOR);
        if (obj23 instanceof String) {
            sb2.append(obj23);
        }
        sb2.append(fieldSeparate);
        Object obj24 = trackerPayload.getHeaderMap().get(Parameters.INTERNATIONAL);
        if (obj24 instanceof Boolean) {
            sb2.append(booleanToInt(((Boolean) obj24).booleanValue()));
        }
        sb2.append(fieldSeparate);
    }

    public static void parcelEvent(TrackerPayload trackerPayload, StringBuilder sb2) {
        Object obj = trackerPayload.getHeaderMap().get("source");
        if (obj instanceof String) {
            sb2.append(obj);
        }
        sb2.append(fieldSeparate);
        Object obj2 = trackerPayload.getHeaderMap().get(Parameters.SESSION_ID);
        if (obj2 instanceof String) {
            sb2.append(obj2);
        }
        sb2.append(fieldSeparate);
        Object obj3 = trackerPayload.getHeaderMap().get("network");
        if (obj3 instanceof String) {
            sb2.append(obj3);
        }
        sb2.append(fieldSeparate);
        Object obj4 = trackerPayload.getHeaderMap().get(Parameters.LONGITUDE);
        if (obj4 instanceof Double) {
            sb2.append(obj4);
        }
        sb2.append(fieldSeparate);
        Object obj5 = trackerPayload.getHeaderMap().get(Parameters.LATITUDE);
        if (obj5 instanceof Double) {
            sb2.append(obj5);
        }
        sb2.append(fieldSeparate);
        Object obj6 = trackerPayload.getHeaderMap().get("page");
        if (obj6 instanceof String) {
            sb2.append(obj6);
        }
        sb2.append(fieldSeparate);
        Object obj7 = trackerPayload.getHeaderMap().get(Parameters.LAUNCH);
        if (obj7 instanceof String) {
            sb2.append(obj7);
        }
        sb2.append(fieldSeparate);
        Object obj8 = trackerPayload.getHeaderMap().get("type");
        if (obj8 instanceof String) {
            sb2.append(obj8);
        }
        sb2.append(fieldSeparate);
        Object obj9 = trackerPayload.getHeaderMap().get("name");
        if (obj9 instanceof String) {
            sb2.append(obj9);
        }
        sb2.append(fieldSeparate);
        boolean z10 = true;
        boolean z11 = true;
        for (Map.Entry<String, String> entry : trackerPayload.getValueMap().entrySet()) {
            if (z11) {
                z11 = false;
            } else {
                sb2.append(elementSeparate);
            }
            if (entry.getKey() != null) {
                sb2.append(entry.getKey());
            }
            sb2.append(mapSeparate);
            if (entry.getValue() != null) {
                sb2.append(entry.getValue());
            }
        }
        sb2.append(fieldSeparate);
        Object obj10 = trackerPayload.getHeaderMap().get(Parameters.EVENT_ATTRIB);
        if (obj10 instanceof Map) {
            for (Map.Entry entry2 : ((Map) obj10).entrySet()) {
                if (z10) {
                    z10 = false;
                } else {
                    sb2.append(elementSeparate);
                }
                if (entry2.getKey() != null) {
                    sb2.append((String) entry2.getKey());
                }
                sb2.append(mapSeparate);
                if (entry2.getValue() != null) {
                    sb2.append((String) entry2.getValue());
                }
            }
        }
        sb2.append(fieldSeparate);
        Object obj11 = trackerPayload.getHeaderMap().get("terminate");
        if (obj11 instanceof String) {
            sb2.append(obj11);
        }
        sb2.append(fieldSeparate);
        Object obj12 = trackerPayload.getHeaderMap().get("time");
        if (obj12 instanceof Long) {
            sb2.append(obj12);
        }
        sb2.append(fieldSeparate);
        Object obj13 = trackerPayload.getHeaderMap().get(Parameters.CSEQ);
        if (obj13 instanceof Long) {
            sb2.append(obj13);
        }
        sb2.append(fieldSeparate);
        Object obj14 = trackerPayload.getHeaderMap().get(Parameters.DEBUG);
        if (obj14 instanceof Boolean) {
            sb2.append(booleanToInt(((Boolean) obj14).booleanValue()));
        }
        sb2.append(fieldSeparate);
        Object obj15 = trackerPayload.getHeaderMap().get(Parameters.LOC_TIME);
        if (obj15 instanceof Long) {
            sb2.append(obj15);
        }
        sb2.append(fieldSeparate);
    }

    public static String parcelOneEvent(TrackerPayload trackerPayload) {
        Logger.d("TrackerPayload", trackerPayload.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(newlineSeparate);
        sb2.append("0");
        parcelDevice(trackerPayload, sb2);
        parcelApp(trackerPayload, sb2);
        parcelEvent(trackerPayload, sb2);
        parceIDIdentify(trackerPayload, sb2);
        return sb2.toString();
    }
}
