package com.android.server.location.contexthub;

import android.app.AppOpsManager;
import android.content.Context;
import android.hardware.contexthub.ContextHubMessage;
import android.hardware.contexthub.EndpointId;
import android.hardware.contexthub.EndpointInfo;
import android.hardware.contexthub.HubEndpointInfo;
import android.hardware.contexthub.HubMessage;
import android.hardware.contexthub.HubServiceInfo;
import android.hardware.contexthub.Message;
import android.hardware.contexthub.NanoappBinary;
import android.hardware.contexthub.NanoappInfo;
import android.hardware.contexthub.NanoappRpcService;
import android.hardware.contexthub.Service;
import android.hardware.contexthub.V1_0.ContextHubMsg;
import android.hardware.contexthub.V1_0.NanoAppBinary;
import android.hardware.contexthub.V1_2.HubAppInfo;
import android.hardware.location.ContextHubInfo;
import android.hardware.location.NanoAppMessage;
import android.hardware.location.NanoAppRpcService;
import android.hardware.location.NanoAppState;
import android.util.Log;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ContextHubServiceUtil {
    private static final String CONTEXT_HUB_PERMISSION = "android.permission.ACCESS_CONTEXT_HUB";
    private static final String DATE_FORMAT = "MM/dd HH:mm:ss.SSS";
    private static final DateTimeFormatter DATE_FORMATTER = null;
    private static final char HOST_ENDPOINT_BROADCAST = 65535;
    private static final String TAG = "ContextHubServiceUtil";

    ContextHubServiceUtil() {
    }

    static {
        DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT).withZone(ZoneId.systemDefault());
    }

    static HashMap<Integer, ContextHubInfo> createContextHubInfoMap(List<ContextHubInfo> hubList) {
        HashMap<Integer, ContextHubInfo> contextHubIdToInfoMap = new HashMap();
        Iterator<ContextHubInfo> r1 = hubList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ContextHubInfo contextHubInfo = r1.next();
        contextHubIdToInfoMap.put(Integer.valueOf(contextHubInfo.getId()), contextHubInfo);
        goto L4
    L6:
        return contextHubIdToInfoMap;
    }

    static void copyToByteArrayList(byte[] inputArray, ArrayList<Byte> outputArray) {
        outputArray.clear();
        outputArray.ensureCapacity(inputArray.length);
        int r0 = inputArray.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        byte element = inputArray[r1];
        outputArray.add(Byte.valueOf(element));
        r1 = r1 + 1;
        goto L3
    }

    static byte[] createPrimitiveByteArray(ArrayList<Byte> array) {
        byte[] primitiveArray = new byte[array.size()];
        int i = 0;
    L4:
        if (i >= array.size()) goto L7;
        primitiveArray[i] = array.get(i).byteValue();
        i = i + 1;
        goto L4
    L7:
        return primitiveArray;
    }

    static int[] createPrimitiveIntArray(Collection<Integer> collection) {
        int[] primitiveArray = new int[collection.size()];
        int i = 0;
        Iterator<Integer> r2 = collection.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        int contextHubId = r2.next().intValue();
        primitiveArray[i] = contextHubId;
        i = i + 1;
        goto L4
    L6:
        return primitiveArray;
    }

    static NanoAppBinary createHidlNanoAppBinary(android.hardware.location.NanoAppBinary nanoAppBinary) {
        NanoAppBinary hidlNanoAppBinary = new NanoAppBinary();
        hidlNanoAppBinary.appId = nanoAppBinary.getNanoAppId();
        hidlNanoAppBinary.appVersion = nanoAppBinary.getNanoAppVersion();
        hidlNanoAppBinary.flags = nanoAppBinary.getFlags();
        hidlNanoAppBinary.targetChreApiMajorVersion = nanoAppBinary.getTargetChreApiMajorVersion();
        hidlNanoAppBinary.targetChreApiMinorVersion = nanoAppBinary.getTargetChreApiMinorVersion();
        copyToByteArrayList(nanoAppBinary.getBinaryNoHeader(), hidlNanoAppBinary.customBinary);     // Catch: NullPointerException -> L5 IndexOutOfBoundsException -> L7
    L11:
        return hidlNanoAppBinary;
    L7:
        e = move-exception;
        Log.w(TAG, e.getMessage());
    L9:
        Log.w(TAG, "NanoApp binary was null");
        goto L11
    }

    static NanoappBinary createAidlNanoAppBinary(android.hardware.location.NanoAppBinary nanoAppBinary) {
        NanoappBinary aidlNanoAppBinary = new NanoappBinary();
        aidlNanoAppBinary.nanoappId = nanoAppBinary.getNanoAppId();
        aidlNanoAppBinary.nanoappVersion = nanoAppBinary.getNanoAppVersion();
        aidlNanoAppBinary.flags = nanoAppBinary.getFlags();
        aidlNanoAppBinary.targetChreApiMajorVersion = nanoAppBinary.getTargetChreApiMajorVersion();
        aidlNanoAppBinary.targetChreApiMinorVersion = nanoAppBinary.getTargetChreApiMinorVersion();
        aidlNanoAppBinary.customBinary = new byte[0];
        aidlNanoAppBinary.customBinary = nanoAppBinary.getBinaryNoHeader();     // Catch: NullPointerException -> L5 IndexOutOfBoundsException -> L7
    L11:
        return aidlNanoAppBinary;
    L7:
        e = move-exception;
        Log.w(TAG, e.getMessage());
    L9:
        Log.w(TAG, "NanoApp binary was null");
        goto L11
    }

    static List<NanoAppState> createNanoAppStateList(List<HubAppInfo> nanoAppInfoList) {
        ArrayList<NanoAppState> nanoAppStateList = new ArrayList();
        Iterator<HubAppInfo> r1 = nanoAppInfoList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        HubAppInfo appInfo = r1.next();
        nanoAppStateList.add(new NanoAppState(appInfo.info_1_0.appId, appInfo.info_1_0.version, appInfo.info_1_0.enabled, appInfo.permissions));
        goto L4
    L6:
        return nanoAppStateList;
    }

    static List<NanoAppState> createNanoAppStateList(NanoappInfo[] nanoAppInfoList) {
        ArrayList<NanoAppState> nanoAppStateList = new ArrayList();
        int r1 = nanoAppInfoList.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        NanoappInfo appInfo = nanoAppInfoList[r3];
        ArrayList<NanoAppRpcService> rpcServiceList = new ArrayList();
        NanoappRpcService[] r5 = appInfo.rpcServices;
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L7;
        NanoappRpcService service = r5[r7];
        rpcServiceList.add(new NanoAppRpcService(service.id, service.version));
        r7 = r7 + 1;
        goto L5
    L7:
        nanoAppStateList.add(new NanoAppState(appInfo.nanoappId, appInfo.nanoappVersion, appInfo.enabled, new ArrayList(Arrays.asList(appInfo.permissions)), rpcServiceList));
        r3 = r3 + 1;
        goto L3
    L8:
        return nanoAppStateList;
    }

    static ContextHubMsg createHidlContextHubMessage(short hostEndPoint, NanoAppMessage message) {
        ContextHubMsg hidlMessage = new ContextHubMsg();
        hidlMessage.appName = message.getNanoAppId();
        hidlMessage.hostEndPoint = hostEndPoint;
        hidlMessage.msgType = message.getMessageType();
        copyToByteArrayList(message.getMessageBody(), hidlMessage.msg);
        return hidlMessage;
    }

    static ContextHubMessage createAidlContextHubMessage(short hostEndPoint, NanoAppMessage message) {
        ContextHubMessage aidlMessage = new ContextHubMessage();
        aidlMessage.nanoappId = message.getNanoAppId();
        aidlMessage.hostEndPoint = (char) hostEndPoint;
        aidlMessage.messageType = message.getMessageType();
        aidlMessage.messageBody = message.getMessageBody();
        aidlMessage.permissions = new String[0];
        aidlMessage.isReliable = message.isReliable();
        aidlMessage.messageSequenceNumber = message.getMessageSequenceNumber();
        return aidlMessage;
    }

    static NanoAppMessage createNanoAppMessage(ContextHubMsg message) {
        byte[] messageArray = createPrimitiveByteArray(message.msg);
        long r1 = message.appName;
        int r3 = message.msgType;
        if (message.hostEndPoint != (-1)) goto L5;
        boolean r4 = true;
    L7:
        return NanoAppMessage.createMessageFromNanoApp(r1, r3, messageArray, r4);
    L5:
        r4 = false;
        goto L7
    }

    static NanoAppMessage createNanoAppMessage(ContextHubMessage message) {
        long r0 = message.nanoappId;
        int r2 = message.messageType;
        byte[] r3 = message.messageBody;
        if (message.hostEndPoint != 65535) goto L5;
        boolean r4 = true;
    L7:
        return NanoAppMessage.createMessageFromNanoApp(r0, r2, r3, r4, message.isReliable, message.messageSequenceNumber);
    L5:
        r4 = false;
        goto L7
    }

    static void checkPermissions(Context context) {
        context.enforceCallingOrSelfPermission(CONTEXT_HUB_PERMISSION, "ACCESS_CONTEXT_HUB permission required to use Context Hub");
    }

    static int toTransactionResult(int halResult) {
        switch(halResult) {
            case 0: goto L11;
            case 1: goto L3;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L3;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return 1;
    L5:
        return 4;
    L7:
        return 3;
    L9:
        return 2;
    L11:
        return 0;
    }

    static ArrayList<HubAppInfo> toHubAppInfo_1_2(ArrayList<android.hardware.contexthub.V1_0.HubAppInfo> oldInfoList) {
        ArrayList<HubAppInfo> r0 = new ArrayList();
        Iterator<android.hardware.contexthub.V1_0.HubAppInfo> r1 = oldInfoList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        android.hardware.contexthub.V1_0.HubAppInfo oldInfo = r1.next();
        HubAppInfo newInfo = new HubAppInfo();
        android.hardware.contexthub.V1_0.HubAppInfo r4 = newInfo.info_1_0;
        r4.appId = oldInfo.appId;
        android.hardware.contexthub.V1_0.HubAppInfo r5 = newInfo.info_1_0;
        r5.version = oldInfo.version;
        android.hardware.contexthub.V1_0.HubAppInfo r6 = newInfo.info_1_0;
        r6.memUsage = oldInfo.memUsage;
        android.hardware.contexthub.V1_0.HubAppInfo r7 = newInfo.info_1_0;
        r7.enabled = oldInfo.enabled;
        newInfo.permissions = new ArrayList();
        r0.add(newInfo);
        goto L4
    L6:
        return r0;
    }

    static int toContextHubEvent(int hidlEventType) {
        switch(hidlEventType) {
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        Log.e(TAG, "toContextHubEvent: Unknown event type: " + hidlEventType);
        return 0;
    L5:
        return 1;
    }

    static int toContextHubEventFromAidl(int aidlEventType) {
        switch(aidlEventType) {
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        Log.e(TAG, "toContextHubEventFromAidl: Unknown event type: " + aidlEventType);
        return 0;
    L5:
        return 1;
    }

    static String formatDateFromTimestamp(long timeStampInMs) {
        return DATE_FORMATTER.format(Instant.ofEpochMilli(timeStampInMs));
    }

    static EndpointInfo convertHalEndpointInfo(HubEndpointInfo info) {
        return createHalEndpointInfo(info, info.getIdentifier().getEndpoint(), info.getIdentifier().getHub());
    }

    static EndpointInfo createHalEndpointInfo(HubEndpointInfo info, long endpointId, long hubId) {
        EndpointInfo outputInfo = new EndpointInfo();
        outputInfo.id = new EndpointId();
        outputInfo.id.id = endpointId;
        outputInfo.id.hubId = hubId;
        outputInfo.name = info.getName();
        outputInfo.version = info.getVersion();
        outputInfo.tag = info.getTag();
        Collection<String> permissions = info.getRequiredPermissions();
        outputInfo.requiredPermissions = (String[]) permissions.toArray(new String[permissions.size()]);
        Collection<HubServiceInfo> services = info.getServiceInfoCollection();
        outputInfo.services = new Service[services.size()];
        int i = 0;
        Iterator<HubServiceInfo> r4 = services.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        HubServiceInfo service = r4.next();
        outputInfo.services[i] = new Service();
        Service r6 = outputInfo.services[i];
        r6.format = service.getFormat();
        Service r7 = outputInfo.services[i];
        r7.serviceDescriptor = service.getServiceDescriptor();
        Service r8 = outputInfo.services[i];
        r8.majorVersion = service.getMajorVersion();
        Service r9 = outputInfo.services[i];
        r9.minorVersion = service.getMinorVersion();
        i = i + 1;
        goto L4
    L6:
        return outputInfo;
    }

    static Message createHalMessage(HubMessage r2) {
        Message r0 = new Message();
        r0.flags = r2.isResponseRequired() ? 1 : 0;
        r0.permissions = new String[0];
        r0.sequenceNumber = r2.getMessageSequenceNumber();
        r0.type = r2.getMessageType();
        r0.content = r2.getMessageBody();
        return r0;
    }

    static HubMessage createHubMessage(Message message) {
        boolean isReliable = true;
        if ((message.flags & 1) != 0) goto L6;
        isReliable = false;
    L6:
        HubMessage outMessage = new HubMessage.Builder(message.type, message.content).setResponseRequired(isReliable).build();
        outMessage.setMessageSequenceNumber(message.sequenceNumber);
        return outMessage;
    }

    static int toAppHubEndpointReason(byte reason) {
        switch(reason) {
            case 0: goto L16;
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        Log.w(TAG, "toAppHubEndpointReason: invalid reason: " + reason);
        return 0;
    L6:
        return 9;
    L8:
        return 6;
    L10:
        return 5;
    L12:
        return 4;
    L14:
        return 3;
    L16:
        return 0;
    }

    static byte toHalReason(int reason) {
        switch(reason) {
            case 0: goto L16;
            case 1: goto L4;
            case 2: goto L4;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L6;
            default: goto L4;
        };
    L4:
        Log.w(TAG, "toHalReason: invalid reason: " + reason);
        return 0;
    L6:
        return 9;
    L8:
        return 6;
    L10:
        return 5;
    L12:
        return 4;
    L14:
        return 3;
    L16:
        return 0;
    }

    static boolean hasPermissions(Context context, int pid, int uid, Collection<String> permissions) {
        Iterator<String> r0 = permissions.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String permission = r0.next();
        if (context.checkPermission(permission, pid, uid) == 0) goto L4;
        Log.e(TAG, "no permission for " + permission);
        return false;
    L10:
        return true;
    }

    static boolean notePermissions(AppOpsManager appOpsManager, int uid, String packageName, String attributionTag, Collection<String> permissions, String noteMessage) {
        Iterator<String> r0 = permissions.iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        String permission = r0.next();
        int opCode = AppOpsManager.permissionToOpCode(permission);
        if (opCode == (-1)) goto L15;
        AppOpsManager appOpsManager2 = appOpsManager;
        int uid2 = uid;
        String packageName2 = packageName;
        String attributionTag2 = attributionTag;
        String noteMessage2 = noteMessage;
        if (appOpsManager2.noteOp(opCode, uid2, packageName2, attributionTag2, noteMessage2) == 0) goto L16;
        return false;
    L16:
        appOpsManager = appOpsManager2;
        uid = uid2;
        packageName = packageName2;
        attributionTag = attributionTag2;
        noteMessage = noteMessage2;
    L12:
        e = move-exception;
        Log.e(TAG, "SecurityException: noteOp for pkg " + packageName2 + " opcode " + opCode + ": " + e.getMessage());
        return false;
    L15:
        appOpsManager2 = appOpsManager;
        uid2 = uid;
        packageName2 = packageName;
        attributionTag2 = attributionTag;
        noteMessage2 = noteMessage;
        goto L16
    L18:
        return true;
    }
}
