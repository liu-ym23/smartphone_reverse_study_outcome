package com.android.server.location.contexthub;

import android.hardware.contexthub.EndpointId;
import android.hardware.contexthub.EndpointInfo;
import android.hardware.contexthub.HubEndpointInfo;
import android.hardware.contexthub.HubMessage;
import android.hardware.contexthub.IEndpointCallback;
import android.hardware.contexthub.Message;
import android.hardware.contexthub.MessageDeliveryStatus;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class ContextHubHalEndpointCallback extends IEndpointCallback.Stub {
    private final IEndpointLifecycleCallback mEndpointLifecycleCallback;
    private final IEndpointSessionCallback mEndpointSessionCallback;

    public interface IEndpointLifecycleCallback {
        void onEndpointStarted(HubEndpointInfo[] r1);

        void onEndpointStopped(HubEndpointInfo.HubEndpointIdentifier[] r1, byte r2);
    }

    public interface IEndpointSessionCallback {
        void onCloseEndpointSession(int r1, byte r2);

        void onEndpointSessionOpenComplete(int r1);

        void onEndpointSessionOpenRequest(int r1, HubEndpointInfo.HubEndpointIdentifier r2, HubEndpointInfo.HubEndpointIdentifier r3, String r4);

        void onMessageDeliveryStatusReceived(int r1, int r2, byte r3);

        void onMessageReceived(int r1, HubMessage r2);
    }

    ContextHubHalEndpointCallback(IEndpointLifecycleCallback endpointLifecycleCallback, IEndpointSessionCallback endpointSessionCallback) {
        this.mEndpointLifecycleCallback = endpointLifecycleCallback;
        this.mEndpointSessionCallback = endpointSessionCallback;
    }

    public void onEndpointStarted(EndpointInfo[] halEndpointInfos) throws RemoteException {
        if (halEndpointInfos.length != 0) goto L5;
        return;
    L5:
        HubEndpointInfo[] endpointInfos = new HubEndpointInfo[halEndpointInfos.length];
        int i = 0;
    L7:
        if (i >= halEndpointInfos.length) goto L9;
        endpointInfos[i] = new HubEndpointInfo(halEndpointInfos[i]);
        i = i + 1;
        goto L7
    L9:
        this.mEndpointLifecycleCallback.onEndpointStarted(endpointInfos);
    }

    public void onEndpointStopped(EndpointId[] halEndpointIds, byte reason) throws RemoteException {
        HubEndpointInfo.HubEndpointIdentifier[] endpointIds = new HubEndpointInfo.HubEndpointIdentifier[halEndpointIds.length];
        int i = 0;
    L4:
        if (i >= halEndpointIds.length) goto L6;
        endpointIds[i] = new HubEndpointInfo.HubEndpointIdentifier(halEndpointIds[i]);
        i = i + 1;
        goto L4
    L6:
        this.mEndpointLifecycleCallback.onEndpointStopped(endpointIds, reason);
    }

    public void onEndpointSessionOpenRequest(int sessionId, EndpointId destination, EndpointId initiator, String serviceDescriptor) throws RemoteException {
        HubEndpointInfo.HubEndpointIdentifier destinationId = new HubEndpointInfo.HubEndpointIdentifier(destination.hubId, destination.id);
        HubEndpointInfo.HubEndpointIdentifier initiatorId = new HubEndpointInfo.HubEndpointIdentifier(initiator.hubId, initiator.id);
        this.mEndpointSessionCallback.onEndpointSessionOpenRequest(sessionId, destinationId, initiatorId, serviceDescriptor);
    }

    public void onCloseEndpointSession(int sessionId, byte reason) throws RemoteException {
        this.mEndpointSessionCallback.onCloseEndpointSession(sessionId, reason);
    }

    public void onEndpointSessionOpenComplete(int sessionId) throws RemoteException {
        this.mEndpointSessionCallback.onEndpointSessionOpenComplete(sessionId);
    }

    public void onMessageReceived(int sessionId, Message message) throws RemoteException {
        HubMessage hubMessage = ContextHubServiceUtil.createHubMessage(message);
        this.mEndpointSessionCallback.onMessageReceived(sessionId, hubMessage);
    }

    public void onMessageDeliveryStatusReceived(int sessionId, MessageDeliveryStatus messageDeliveryStatus) throws RemoteException {
        this.mEndpointSessionCallback.onMessageDeliveryStatusReceived(sessionId, messageDeliveryStatus.messageSequenceNumber, messageDeliveryStatus.errorCode);
    }

    public int getInterfaceVersion() throws RemoteException {
        return 4;
    }

    public String getInterfaceHash() throws RemoteException {
        return "df80fdbb6f95a8a2988bc72b7f08f891847b80eb";
    }
}
