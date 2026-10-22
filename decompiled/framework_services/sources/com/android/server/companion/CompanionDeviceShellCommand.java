package com.android.server.companion;

import android.companion.AssociationInfo;
import android.companion.ObservingDevicePresenceRequest;
import android.companion.datatransfer.PermissionSyncRequest;
import android.hardware.tv.mediaquality.ParameterName;
import android.net.MacAddress;
import android.os.Binder;
import android.os.ParcelUuid;
import android.os.ShellCommand;
import android.util.Base64;
import android.util.proto.ProtoOutputStream;
import com.android.server.companion.association.AssociationRequestsProcessor;
import com.android.server.companion.association.AssociationStore;
import com.android.server.companion.association.DisassociationProcessor;
import com.android.server.companion.datatransfer.SystemDataTransferProcessor;
import com.android.server.companion.datatransfer.contextsync.BitmapUtils;
import com.android.server.companion.datatransfer.contextsync.CrossDeviceSyncController;
import com.android.server.companion.devicepresence.DevicePresenceProcessor;
import com.android.server.companion.devicepresence.ObservableUuid;
import com.android.server.companion.transport.CompanionTransportManager;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class CompanionDeviceShellCommand extends ShellCommand {
    private static final String TAG = "CDM_CompanionDeviceShellCommand";
    private final AssociationRequestsProcessor mAssociationRequestsProcessor;
    private final AssociationStore mAssociationStore;
    private final BackupRestoreProcessor mBackupRestoreProcessor;
    private final DevicePresenceProcessor mDevicePresenceProcessor;
    private final DisassociationProcessor mDisassociationProcessor;
    private final CompanionDeviceManagerService mService;
    private final SystemDataTransferProcessor mSystemDataTransferProcessor;
    private final CompanionTransportManager mTransportManager;

    CompanionDeviceShellCommand(CompanionDeviceManagerService service, AssociationStore associationStore, DevicePresenceProcessor devicePresenceProcessor, CompanionTransportManager transportManager, SystemDataTransferProcessor systemDataTransferProcessor, AssociationRequestsProcessor associationRequestsProcessor, BackupRestoreProcessor backupRestoreProcessor, DisassociationProcessor disassociationProcessor) {
        this.mService = service;
        this.mAssociationStore = associationStore;
        this.mDevicePresenceProcessor = devicePresenceProcessor;
        this.mTransportManager = transportManager;
        this.mSystemDataTransferProcessor = systemDataTransferProcessor;
        this.mAssociationRequestsProcessor = associationRequestsProcessor;
        this.mBackupRestoreProcessor = backupRestoreProcessor;
        this.mDisassociationProcessor = disassociationProcessor;
    }

    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0393: MOVE (r13 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY] A[D('out' java.io.PrintWriter)]), block:B:157:0x0393 */
    public int onCommand(String cmd) {
        CompanionDeviceShellCommand r1 = this;
        PrintWriter out = r1.getOutPrintWriter();
    L229:
        e = th;
    L231:
        PrintWriter errOut = r1.getErrPrintWriter();
        errOut.println();
        errOut.println("Exception occurred while executing '" + cmd + "':");
        e.printStackTrace(errOut);
        return 1;
    L233:
        switch(cmd.hashCode()) {
            case -2027841817: goto L89;
            case -1993991071: goto L87;
            case -1905713190: goto L84;
            case -1860608114: goto L81;
            case -1855910485: goto L78;
            case -1224243197: goto L75;
            case -984232290: goto L72;
            case -757319323: goto L69;
            case -633878164: goto L66;
            case -632811356: goto L63;
            case -548306091: goto L60;
            case -517291495: goto L57;
            case -318851754: goto L54;
            case -191868716: goto L51;
            case 3322014: goto L48;
            case 330925715: goto L45;
            case 551574230: goto L42;
            case 665140760: goto L39;
            case 784321104: goto L36;
            case 791006133: goto L33;
            case 1069692606: goto L30;
            case 1415349776: goto L27;
            case 1527030451: goto L24;
            case 1586499358: goto L21;
            case 1912643190: goto L18;
            case 1981554624: goto L15;
            case 1996509815: goto L12;
            case 2001610978: goto L7;
            default: goto L92;
        };
    L89:
        if (cmd.equals("send-context-sync-call-message") == false) goto L92;
        byte r5 = ParameterName.BLUE_STRETCH;
    L93:
        String r17 = DisassociationProcessor.REASON_SHELL;
        Object r14 = "null";
        switch(r5) {
            case 0: goto L221;
            case 1: goto L220;
            case 2: goto L215;
            case 3: goto L210;
            case 4: goto L209;
            case 5: goto L208;
            case 6: goto L207;
            case 7: goto L206;
            case 8: goto L205;
            case 9: goto L200;
            case 10: goto L199;
            case 11: goto L195;
            case 12: goto L191;
            case 13: goto L239;
            case 14: goto L181;
            case 15: goto L180;
            case 16: goto L179;
            case 17: goto L178;
            case 18: goto L177;
            case 19: goto L176;
            case 20: goto L164;
            case 21: goto L241;
            case 22: goto L122;
            case 23: goto L121;
            case 24: goto L116;
            case 25: goto L107;
            case 26: goto L102;
            case 27: goto L97;
            default: goto L96;
        };
    L97:
        int associationId = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        PermissionSyncRequest request = r1.mSystemDataTransferProcessor.getPermissionSyncRequest(associationId);     // Catch: Throwable -> L9
        if (request == null) goto L101;
        r14 = Boolean.valueOf(request.isUserConsented());     // Catch: Throwable -> L9
    L101:
        out.print(r14);     // Catch: Throwable -> L9
        r1.mSystemDataTransferProcessor.disablePermissionsSync(associationId);     // Catch: Throwable -> L9
        PermissionSyncRequest request2 = r1.mSystemDataTransferProcessor.getPermissionSyncRequest(associationId);     // Catch: Throwable -> L9
        out.println(" -> " + request2.isUserConsented());     // Catch: Throwable -> L9
        return 0;
    L102:
        int associationId2 = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        PermissionSyncRequest request3 = r1.mSystemDataTransferProcessor.getPermissionSyncRequest(associationId2);     // Catch: Throwable -> L9
        if (request3 == null) goto L106;
        r14 = Boolean.valueOf(request3.isUserConsented());     // Catch: Throwable -> L9
    L106:
        out.print(r14);     // Catch: Throwable -> L9
        r1.mSystemDataTransferProcessor.enablePermissionsSync(associationId2);     // Catch: Throwable -> L9
        PermissionSyncRequest request4 = r1.mSystemDataTransferProcessor.getPermissionSyncRequest(associationId2);     // Catch: Throwable -> L9
        out.println(" -> " + request4.isUserConsented());     // Catch: Throwable -> L9
        return 0;
    L107:
        int associationId3 = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        PermissionSyncRequest request5 = r1.mSystemDataTransferProcessor.getPermissionSyncRequest(associationId3);     // Catch: Throwable -> L9
        if (request5 != null) goto L110;
        Object r7 = "null";
    L111:
        out.print(r7);     // Catch: Throwable -> L9
        r1.mSystemDataTransferProcessor.removePermissionSyncRequest(associationId3);     // Catch: Throwable -> L9
        PermissionSyncRequest request6 = r1.mSystemDataTransferProcessor.getPermissionSyncRequest(associationId3);     // Catch: Throwable -> L9
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L9
        r6.append(" -> ");     // Catch: Throwable -> L9
        if (request6 == null) goto L115;
        r14 = Boolean.valueOf(request6.isUserConsented());     // Catch: Throwable -> L9
    L115:
        r6.append(r14);     // Catch: Throwable -> L9
        out.println(r6.toString());     // Catch: Throwable -> L9
        return 0;
    L110:
        r7 = Boolean.valueOf(request5.isUserConsented());     // Catch: Throwable -> L9
        goto L111
    L116:
        int associationId4 = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        PermissionSyncRequest request7 = r1.mSystemDataTransferProcessor.getPermissionSyncRequest(associationId4);     // Catch: Throwable -> L9
        if (request7 == null) goto L120;
        r14 = Boolean.valueOf(request7.isUserConsented());     // Catch: Throwable -> L9
    L120:
        out.println(r14);     // Catch: Throwable -> L9
        return 0;
    L121:
        int associationId5 = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        int flag = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        r1.mAssociationRequestsProcessor.enableSystemDataSync(associationId5, flag);     // Catch: Throwable -> L9
        return 0;
    L122:
        int associationId6 = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        int flag2 = r1.getNextIntArgRequired();     // Catch: Throwable -> L9
        r1.mAssociationRequestsProcessor.disableSystemDataSync(associationId6, flag2);     // Catch: Throwable -> L9
        return 0;
    L164:
        int associationId7 = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        int numberOfFacilitators = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        String facilitatorName = r1.getNextArgRequired();     // Catch: Throwable -> L156
        String facilitatorId = r1.getNextArgRequired();     // Catch: Throwable -> L156
        ProtoOutputStream pos = new ProtoOutputStream();     // Catch: Throwable -> L156
        pos.write(1120986464257L, 1);     // Catch: Throwable -> L156
        long telecomToken = pos.start(1146756268036L);     // Catch: Throwable -> L156
        int i = 0;
    L165:
        if (i >= numberOfFacilitators) goto L175;
        long facilitatorsToken = pos.start(2246267895811L);     // Catch: Throwable -> L156
        if (numberOfFacilitators != 1) goto L169;
        String r11 = facilitatorName;
    L170:
        pos.write(1138166333441L, r11);     // Catch: Throwable -> L156
        if (numberOfFacilitators != 1) goto L173;
        String r12 = facilitatorId;
    L174:
        pos.write(1138166333442L, r12);     // Catch: Throwable -> L156
        pos.end(facilitatorsToken);     // Catch: Throwable -> L156
        i = i + 1;     // Catch: Throwable -> L156
        goto L165
    L173:
        r12 = facilitatorId + i;     // Catch: Throwable -> L156
        goto L174
    L169:
        r11 = facilitatorName + i;     // Catch: Throwable -> L156
        goto L170
    L175:
        pos.end(telecomToken);     // Catch: Throwable -> L156
        r1.mTransportManager.createEmulatedTransport(associationId7).processMessage(1667729539, 0, pos.getBytes());     // Catch: Throwable -> L156
        return 0;
    L176:
        int associationId8 = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        String callId = r1.getNextArgRequired();     // Catch: Throwable -> L156
        int control = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        r1.mTransportManager.createEmulatedTransport(associationId8).processMessage(1667729539, 0, CrossDeviceSyncController.createCallControlMessage(callId, control));     // Catch: Throwable -> L156
        return 0;
    L177:
        int associationId9 = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        String callId2 = r1.getNextArgRequired();     // Catch: Throwable -> L156
        String address = r1.getNextArgRequired();     // Catch: Throwable -> L156
        String facilitator = r1.getNextArgRequired();     // Catch: Throwable -> L156
        r1.mTransportManager.createEmulatedTransport(associationId9).processMessage(1667729539, 0, CrossDeviceSyncController.createCallCreateMessage(callId2, address, facilitator));     // Catch: Throwable -> L156
        return 0;
    L178:
        int associationId10 = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        r1.mTransportManager.createEmulatedTransport(associationId10).processMessage(1667729539, 0, CrossDeviceSyncController.createEmptyMessage());     // Catch: Throwable -> L156
        return 0;
    L179:
        int associationId11 = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        r1.mTransportManager.createEmulatedTransport(associationId11);     // Catch: Throwable -> L156
        return 0;
    L180:
        final CompanionDeviceManagerService r0 = r1.mService;     // Catch: Throwable -> L156
        r0.getClass();     // Catch: Throwable -> L156
        Binder.withCleanCallingIdentity(new CompanionDeviceShellCommand$$ExternalSyntheticLambda0(r0));     // Catch: Throwable -> L156
        return 0;
    L181:
        int userId = r1.getNextIntArgRequired();     // Catch: Throwable -> L156
        byte[] payload = Base64.decode(r1.getNextArgRequired(), 2);     // Catch: Throwable -> L156
        r1.mBackupRestoreProcessor.applyRestoredPayload(payload, userId);     // Catch: Throwable -> L156
        return 0;
    L191:
        int userId2 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        String packageName = r1.getNextArgRequired();     // Catch: Throwable -> L187
        String uuid = r1.getNextArgRequired();     // Catch: Throwable -> L187
        if ("null".equals(uuid) == false) goto L194;
        out.println("UUID can not be null.");     // Catch: Throwable -> L187
        return 0;
    L194:
        ParcelUuid parcelUuid = ParcelUuid.fromString(uuid);     // Catch: Throwable -> L187
        ObservingDevicePresenceRequest request8 = new ObservingDevicePresenceRequest.Builder().setUuid(parcelUuid).build();     // Catch: Throwable -> L187
        r1.mDevicePresenceProcessor.stopObservingDevicePresence(request8, packageName, userId2, false);     // Catch: Throwable -> L187
        return 0;
    L195:
        int userId3 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        String packageName2 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        String uuid2 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        if ("null".equals(uuid2) == false) goto L198;
        out.println("UUID can not be null.");     // Catch: Throwable -> L187
        return 0;
    L198:
        ParcelUuid parcelUuid2 = ParcelUuid.fromString(uuid2);     // Catch: Throwable -> L187
        ObservingDevicePresenceRequest request9 = new ObservingDevicePresenceRequest.Builder().setUuid(parcelUuid2).build();     // Catch: Throwable -> L187
        r1.mDevicePresenceProcessor.startObservingDevicePresence(request9, packageName2, userId3, false);     // Catch: Throwable -> L187
        return 0;
    L199:
        int userId4 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        r1.mDevicePresenceProcessor.simulateDeviceEventOnUserUnlocked(userId4);     // Catch: Throwable -> L187
        return 0;
    L200:
        int associationId12 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        int userId5 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        int event = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        String uuid3 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        if (uuid3.equals("null") == false) goto L203;
        ParcelUuid parcelUuid3 = null;
    L204:
        r1.mDevicePresenceProcessor.simulateDeviceEventOnDeviceLocked(associationId12, userId5, event, parcelUuid3);     // Catch: Throwable -> L187
        return 0;
    L203:
        parcelUuid3 = ParcelUuid.fromString(uuid3);     // Catch: Throwable -> L187
        goto L204
    L205:
        String uuid4 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        String packageName3 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        int userId6 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        int event2 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        ObservableUuid observableUuid = new ObservableUuid(userId6, ParcelUuid.fromString(uuid4), packageName3, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L187
        r1.mDevicePresenceProcessor.simulateDeviceEventByUuid(observableUuid, event2);     // Catch: Throwable -> L187
        return 0;
    L206:
        int associationId13 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        int event3 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        r1.mDevicePresenceProcessor.simulateDeviceEvent(associationId13, event3);     // Catch: Throwable -> L187
        return 0;
    L207:
        int associationId14 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        r1.mDevicePresenceProcessor.simulateDeviceEvent(associationId14, 1);     // Catch: Throwable -> L187
        return 0;
    L208:
        int associationId15 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        r1.mDevicePresenceProcessor.simulateDeviceEvent(associationId15, 0);     // Catch: Throwable -> L187
        return 0;
    L209:
        r1.mAssociationStore.refreshCache();     // Catch: Throwable -> L187
        return 0;
    L210:
        int userId7 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        List<AssociationInfo> userAssociations = r1.mAssociationStore.getAssociationsByUser(userId7);     // Catch: Throwable -> L187
        Iterator<AssociationInfo> r3 = userAssociations.iterator();     // Catch: Throwable -> L187
    L212:
        if (r3.hasNext() == false) goto L277;
        String r8 = r17;
        r1.mDisassociationProcessor.disassociate(r3.next().getId(), r8);     // Catch: Throwable -> L187
        r17 = r8;
        goto L212
    L277:
        return 0;
    L215:
        int userId8 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        String packageName4 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        String address2 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        AssociationInfo association = r1.mAssociationStore.getFirstAssociationByAddress(userId8, packageName4, address2);     // Catch: Throwable -> L187
        if (association != null) goto L218;
        out.println("Association doesn't exist.");     // Catch: Throwable -> L187
    L278:
        return 0;
    L218:
        r1.mDisassociationProcessor.disassociate(association.getId(), r17);     // Catch: Throwable -> L187
        goto L278
    L220:
        int userId9 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        String packageName5 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        String address3 = r1.getNextArgRequired();     // Catch: Throwable -> L187
        String deviceProfile = r1.getNextArg();     // Catch: Throwable -> L187
        boolean selfManaged = r1.getNextBooleanArg();     // Catch: Throwable -> L187
        MacAddress macAddress = MacAddress.fromString(address3);     // Catch: Throwable -> L187
        r1.mAssociationRequestsProcessor.createAssociation(userId9, packageName5, macAddress, deviceProfile, deviceProfile, null, selfManaged, null, null, null, false);     // Catch: Throwable -> L187
        return 0;
    L221:
        int userId10 = r1.getNextIntArgRequired();     // Catch: Throwable -> L187
        List<AssociationInfo> associationsForUser = r1.mAssociationStore.getActiveAssociationsByUser(userId10);     // Catch: Throwable -> L187
        int maxId = r1.mAssociationStore.getMaxId();     // Catch: Throwable -> L187
        out.println("Max ID: " + maxId);     // Catch: Throwable -> L187
        out.println("Association ID | Package Name | Mac Address");     // Catch: Throwable -> L187
        Iterator<AssociationInfo> r9 = associationsForUser.iterator();     // Catch: Throwable -> L187
    L223:
        if (r9.hasNext() == false) goto L280;
        AssociationInfo association2 = r9.next();     // Catch: Throwable -> L187
        out.println(association2.getId() + " | " + association2.getPackageName() + " | " + association2.getDeviceMacAddress());     // Catch: Throwable -> L187
        goto L223
    L280:
        return 0;
    L241:
        int associationId16 = r1.getNextIntArgRequired();     // Catch: Throwable -> L158
        String callId3 = r1.getNextArgRequired();     // Catch: Throwable -> L158
        String facilitatorId2 = r1.getNextArgRequired();     // Catch: Throwable -> L158
        int status = r1.getNextIntArgRequired();     // Catch: Throwable -> L158
        boolean acceptControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        boolean rejectControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        boolean silenceControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        boolean muteControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        boolean unmuteControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        boolean endControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        boolean holdControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        boolean unholdControl = r1.getNextBooleanArgRequired();     // Catch: Throwable -> L158
        ProtoOutputStream pos2 = new ProtoOutputStream();     // Catch: Throwable -> L158
        pos2.write(1120986464257L, 1);     // Catch: Throwable -> L158
        long telecomToken2 = pos2.start(1146756268036L);     // Catch: Throwable -> L158
        long callsToken = pos2.start(2246267895809L);     // Catch: Throwable -> L158
        pos2.write(1138166333441L, callId3);     // Catch: Throwable -> L158
        long originToken = pos2.start(1146756268034L);     // Catch: Throwable -> L158
        pos2.write(1138166333441L, "Caller Name");     // Catch: Throwable -> L162
        out = out;
        pos2.write(1151051235330L, BitmapUtils.renderDrawableToByteArray(r1.mService.getContext().getPackageManager().getApplicationIcon(facilitatorId2)));     // Catch: Throwable -> L158
        long facilitatorToken = pos2.start(1146756268035L);     // Catch: Throwable -> L158
        pos2.write(1138166333441L, "Test App Name");     // Catch: Throwable -> L160
        pos2.write(1138166333442L, facilitatorId2);     // Catch: Throwable -> L160
        pos2.end(facilitatorToken);     // Catch: Throwable -> L160
        pos2.end(originToken);     // Catch: Throwable -> L160
        pos2.write(1159641169923L, status);     // Catch: Throwable -> L160
        if (acceptControl == true) goto L243;
    L137:
        if (rejectControl == false) goto L139;
        pos2.write(2259152797700L, 2);     // Catch: Throwable -> L135
    L139:
        if (silenceControl == false) goto L141;
        pos2.write(2259152797700L, 3);     // Catch: Throwable -> L135
    L141:
        if (muteControl == false) goto L143;
        pos2.write(2259152797700L, 4);     // Catch: Throwable -> L135
    L143:
        if (unmuteControl == false) goto L145;
        pos2.write(2259152797700L, 5);     // Catch: Throwable -> L135
    L145:
        if (endControl == false) goto L147;
        pos2.write(2259152797700L, 6);     // Catch: Throwable -> L135
    L147:
        if (holdControl == false) goto L149;
        pos2.write(2259152797700L, 7);     // Catch: Throwable -> L135
    L149:
        if (unholdControl == false) goto L151;
        pos2.write(2259152797700L, 8);     // Catch: Throwable -> L135
    L135:
        e = th;
        r1 = this;
    L151:
        pos2.end(callsToken);     // Catch: Throwable -> L160
        pos2.end(telecomToken2);     // Catch: Throwable -> L160
        r1 = this;
        r1.mTransportManager.createEmulatedTransport(associationId16).processMessage(1667729539, 0, pos2.getBytes());     // Catch: Throwable -> L156
        return 0;
    L243:
        pos2.write(2259152797700L, 1);     // Catch: Throwable -> L135
    L160:
        e = th;
        r1 = this;
    L162:
        e = th;
    L158:
        e = th;
        goto L231
    L96:
        return handleDefaultCommands(cmd);
    L239:
        int userId11 = r1.getNextIntArgRequired();     // Catch: Throwable -> L189
        byte[] payload2 = r1.mBackupRestoreProcessor.getBackupPayload(userId11);     // Catch: Throwable -> L189
        out.println(Base64.encodeToString(payload2, 2));     // Catch: Throwable -> L187
        return 0;
    L189:
        e = th;
    L187:
        e = th;
    L156:
        e = th;
    L92:
        r5 = -1;
        goto L93
    L7:
        if (cmd.equals("simulate-device-appeared") == false) goto L92;
        r5 = 5;
        goto L93
    L12:
        if (cmd.equals("send-context-sync-call-control-message") == false) goto L92;
        r5 = ParameterName.FILM_MODE;
        goto L93
    L15:
        if (cmd.equals("simulate-device-event-device-locked") == false) goto L92;
        r5 = 9;
        goto L93
    L18:
        if (cmd.equals("simulate-device-uuid-event") == false) goto L92;
        r5 = 8;
        goto L93
    L21:
        if (cmd.equals("associate") == false) goto L92;
        r5 = 1;
        goto L93
    L24:
        if (cmd.equals("disable-perm-sync") == false) goto L92;
        r5 = ParameterName.LEVEL_RANGE;
        goto L93
    L27:
        if (cmd.equals("refresh-cache") == false) goto L92;
        r5 = 4;
        goto L93
    L30:
        if (cmd.equals("disable-context-sync") == false) goto L92;
        r5 = ParameterName.COLOR_TUNE;
        goto L93
    L33:
        if (cmd.equals("stop-observing-device-presence-uuid") == false) goto L92;
        r5 = 12;
        goto L93
    L36:
        if (cmd.equals("disassociate") == false) goto L92;
        r5 = 2;
        goto L93
    L39:
        if (cmd.equals("send-context-sync-empty-message") == false) goto L92;
        r5 = ParameterName.DE_CONTOUR;
        goto L93
    L42:
        if (cmd.equals("apply-restored-payload") == false) goto L92;
        r5 = 14;
        goto L93
    L45:
        if (cmd.equals("remove-perm-sync-state") == false) goto L92;
        r5 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L93
    L48:
        if (cmd.equals("list") == false) goto L92;
        r5 = 0;
        goto L93
    L51:
        if (cmd.equals("simulate-device-disappeared") == false) goto L92;
        r5 = 6;
        goto L93
    L54:
        if (cmd.equals("send-context-sync-call-create-message") == false) goto L92;
        r5 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L93
    L57:
        if (cmd.equals("simulate-device-event-device-unlocked") == false) goto L92;
        r5 = 10;
        goto L93
    L60:
        if (cmd.equals("start-observing-device-presence-uuid") == false) goto L92;
        r5 = 11;
        goto L93
    L63:
        if (cmd.equals("disassociate-all") == false) goto L92;
        r5 = 3;
        goto L93
    L66:
        if (cmd.equals("simulate-device-event") == false) goto L92;
        r5 = 7;
        goto L93
    L69:
        if (cmd.equals("get-perm-sync-state") == false) goto L92;
        r5 = ParameterName.GLOBE_DIMMING;
        goto L93
    L72:
        if (cmd.equals("create-emulated-transport") == false) goto L92;
        r5 = 16;
        goto L93
    L75:
        if (cmd.equals("enable-context-sync") == false) goto L92;
        r5 = ParameterName.COLOR_TEMPERATURE;
        goto L93
    L78:
        if (cmd.equals("remove-inactive-associations") == false) goto L92;
        r5 = 15;
        goto L93
    L81:
        if (cmd.equals("enable-perm-sync") == false) goto L92;
        r5 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L93
    L84:
        if (cmd.equals("get-backup-payload") == false) goto L92;
        r5 = 13;
        goto L93
    L87:
        if (cmd.equals("send-context-sync-call-facilitators-message") == false) goto L92;
        r5 = ParameterName.BLACK_STRETCH;
    L9:
        e = th;
        goto L231
    }

    private int getNextIntArgRequired() {
        return Integer.parseInt(getNextArgRequired());
    }

    private boolean getNextBooleanArgRequired() {
        String arg = getNextArgRequired();
        if ("true".equalsIgnoreCase(arg) == true) goto L10;
        if ("false".equalsIgnoreCase(arg) == true) goto L10;
        throw new IllegalArgumentException("Expected a boolean argument but was: " + arg);
    L10:
        return Boolean.parseBoolean(arg);
    }

    private boolean getNextBooleanArg() {
        String arg = getNextArg();
        if (arg != null) goto L5;
        return false;
    L5:
        if ("false".equalsIgnoreCase(arg) == false) goto L8;
        return false;
    L8:
        if ("true".equalsIgnoreCase(arg) == false) goto L12;
        return Boolean.parseBoolean(arg);
    L12:
        throw new IllegalArgumentException("Expected a boolean argument but was: " + arg);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Companion Device Manager (companiondevice) commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  list USER_ID");
        pw.println("      List all Associations for a user.");
        pw.println("  associate USER_ID PACKAGE MAC_ADDRESS [DEVICE_PROFILE] [SELF_MANAGED]");
        pw.println("      Create a new Association.");
        pw.println("  disassociate USER_ID PACKAGE MAC_ADDRESS");
        pw.println("      Remove an existing Association.");
        pw.println("  disassociate-all USER_ID");
        pw.println("      Remove all Associations for a user.");
        pw.println("  refresh-cache");
        pw.println("      Clear the in-memory association cache and reload all association ");
        pw.println("      information from disk. USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  simulate-device-appeared ASSOCIATION_ID");
        pw.println("      Make CDM act as if the given companion device has appeared.");
        pw.println("      I.e. bind the associated companion application's");
        pw.println("      CompanionDeviceService(s) and trigger onDeviceAppeared() callback.");
        pw.println("      The CDM will consider the devices as present for 60 seconds and then");
        pw.println("      will act as if device disappeared, unless 'simulate-device-disappeared'");
        pw.println("      or 'simulate-device-appeared' is called again before 60 seconds run out.");
        pw.println("      USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  simulate-device-disappeared ASSOCIATION_ID");
        pw.println("      Make CDM act as if the given companion device has disappeared.");
        pw.println("      I.e. unbind the associated companion application's");
        pw.println("      CompanionDeviceService(s) and trigger onDeviceDisappeared() callback.");
        pw.println("      NOTE: This will only have effect if 'simulate-device-appeared' was");
        pw.println("      invoked for the same device (same ASSOCIATION_ID) no longer than");
        pw.println("      60 seconds ago.");
        pw.println("  get-backup-payload USER_ID");
        pw.println("      Generate backup payload for the given user and print its content");
        pw.println("      encoded to a Base64 string.");
        pw.println("      USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  apply-restored-payload USER_ID PAYLOAD");
        pw.println("      Apply restored backup payload for the given user.");
        pw.println("      USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  simulate-device-event ASSOCIATION_ID EVENT");
        pw.println("  Simulate the companion device event changes:");
        pw.println("    Case(0): ");
        pw.println("      Make CDM act as if the given companion device has appeared.");
        pw.println("      I.e. bind the associated companion application's");
        pw.println("      CompanionDeviceService(s) and trigger onDeviceAppeared() callback.");
        pw.println("      The CDM will consider the devices as present for60 seconds and then");
        pw.println("      will act as if device disappeared, unless'simulate-device-disappeared'");
        pw.println("      or 'simulate-device-appeared' is called again before 60 secondsrun out.");
        pw.println("    Case(1): ");
        pw.println("      Make CDM act as if the given companion device has disappeared.");
        pw.println("      I.e. unbind the associated companion application's");
        pw.println("      CompanionDeviceService(s) and trigger onDeviceDisappeared()callback.");
        pw.println("      NOTE: This will only have effect if 'simulate-device-appeared' was");
        pw.println("      invoked for the same device (same ASSOCIATION_ID) no longer than");
        pw.println("      60 seconds ago.");
        pw.println("    Case(2): ");
        pw.println("      Make CDM act as if the given companion device is BT connected ");
        pw.println("    Case(3): ");
        pw.println("      Make CDM act as if the given companion device is BT disconnected ");
        pw.println("      USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  simulate-device-uuid-event UUID PACKAGE USERID EVENT");
        pw.println("  Simulate the companion device event changes:");
        pw.println("    Case(2): ");
        pw.println("      Make CDM act as if the given DEVICE is BT connected baseon the UUID");
        pw.println("    Case(3): ");
        pw.println("      Make CDM act as if the given DEVICE is BT disconnected baseon the UUID");
        pw.println("      USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  simulate-device-event-device-locked ASSOCIATION_ID USER_ID DEVICE_EVENT PARCEL_UUID");
        pw.println("  Simulate device event when the device is locked");
        pw.println("  USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  simulate-device-event-device-unlocked USER_ID");
        pw.println("  Simulate device unlocked for given user. This will send corresponding");
        pw.println("  callback after simulate-device-event-device-locked");
        pw.println("  command has been called.");
        pw.println("  USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  start-observing-device-presence-uuid USER_ID PACKAGE_NAME UUID");
        pw.println("  Start observing device presence base on the UUID.");
        pw.println("  USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  stop-observing-device-presence-uuid USER_ID PACKAGE_NAME UUID");
        pw.println("  Stop observing device presence base on the UUID.");
        pw.println("  USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  remove-inactive-associations");
        pw.println("      Remove self-managed associations that have not been active ");
        pw.println("      for a long time (90 days or as configured via ");
        pw.println("      \"debug.cdm.cdmservice.removal_time_window\" system property). ");
        pw.println("      USE FOR DEBUGGING AND/OR TESTING PURPOSES ONLY.");
        pw.println("  create-emulated-transport <ASSOCIATION_ID>");
        pw.println("      Create an EmulatedTransport for testing purposes only");
        pw.println("  enable-perm-sync <ASSOCIATION_ID>");
        pw.println("      Enable perm sync for the association.");
        pw.println("  disable-perm-sync <ASSOCIATION_ID>");
        pw.println("      Disable perm sync for the association.");
        pw.println("  get-perm-sync-state <ASSOCIATION_ID>");
        pw.println("      Get perm sync state for the association.");
        pw.println("  remove-perm-sync-state <ASSOCIATION_ID>");
        pw.println("      Remove perm sync state for the association.");
    }
}
