package com.android.server.usb.descriptors.tree;

import com.android.server.usb.descriptors.UsbACInterface;
import com.android.server.usb.descriptors.UsbConfigDescriptor;
import com.android.server.usb.descriptors.UsbDescriptor;
import com.android.server.usb.descriptors.UsbDescriptorParser;
import com.android.server.usb.descriptors.UsbDeviceDescriptor;
import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import com.android.server.usb.descriptors.UsbInterfaceDescriptor;
import com.android.server.usb.descriptors.report.ReportCanvas;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbDescriptorsTree {
    private static final String TAG = "UsbDescriptorsTree";
    private UsbDescriptorsConfigNode mConfigNode;
    private UsbDescriptorsDeviceNode mDeviceNode;
    private UsbDescriptorsInterfaceNode mInterfaceNode;

    public UsbDescriptorsTree() {
    }

    private void addDeviceDescriptor(UsbDeviceDescriptor deviceDescriptor) {
        this.mDeviceNode = new UsbDescriptorsDeviceNode(deviceDescriptor);
    }

    private void addConfigDescriptor(UsbConfigDescriptor configDescriptor) {
        this.mConfigNode = new UsbDescriptorsConfigNode(configDescriptor);
        this.mDeviceNode.addConfigDescriptorNode(this.mConfigNode);
    }

    private void addInterfaceDescriptor(UsbInterfaceDescriptor interfaceDescriptor) {
        this.mInterfaceNode = new UsbDescriptorsInterfaceNode(interfaceDescriptor);
        this.mConfigNode.addInterfaceNode(this.mInterfaceNode);
    }

    private void addEndpointDescriptor(UsbEndpointDescriptor endpointDescriptor) {
        this.mInterfaceNode.addEndpointNode(new UsbDescriptorsEndpointNode(endpointDescriptor));
    }

    private void addACInterface(UsbACInterface acInterface) {
        this.mInterfaceNode.addACInterfaceNode(new UsbDescriptorsACInterfaceNode(acInterface));
    }

    public void parse(UsbDescriptorParser parser) {
        ArrayList<UsbDescriptor> descriptors = parser.getDescriptors();
        int descrIndex = 0;
    L4:
        if (descrIndex >= descriptors.size()) goto L15;
        UsbDescriptor descriptor = descriptors.get(descrIndex);
        switch(descriptor.getType()) {
            case 1: goto L12;
            case 2: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 36: goto L13;
            default: goto L13;
        };
    L9:
        addEndpointDescriptor((UsbEndpointDescriptor) descriptor);
        goto L13
    L10:
        addInterfaceDescriptor((UsbInterfaceDescriptor) descriptor);
        goto L13
    L11:
        addConfigDescriptor((UsbConfigDescriptor) descriptor);
        goto L13
    L12:
        addDeviceDescriptor((UsbDeviceDescriptor) descriptor);
    L13:
        descrIndex = descrIndex + 1;
        goto L4
    }

    public void report(ReportCanvas canvas) {
        this.mDeviceNode.report(canvas);
    }
}
