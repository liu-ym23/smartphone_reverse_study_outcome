package com.android.server.usb.descriptors.tree;

import com.android.server.usb.descriptors.UsbInterfaceDescriptor;
import com.android.server.usb.descriptors.report.ReportCanvas;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbDescriptorsInterfaceNode extends UsbDescriptorsTreeNode {
    private static final String TAG = "UsbDescriptorsInterfaceNode";
    private final ArrayList<UsbDescriptorsACInterfaceNode> mACInterfaceNodes;
    private final ArrayList<UsbDescriptorsEndpointNode> mEndpointNodes;
    private final UsbInterfaceDescriptor mInterfaceDescriptor;

    public UsbDescriptorsInterfaceNode(UsbInterfaceDescriptor interfaceDescriptor) {
        this.mEndpointNodes = new ArrayList();
        this.mACInterfaceNodes = new ArrayList();
        this.mInterfaceDescriptor = interfaceDescriptor;
    }

    public void addEndpointNode(UsbDescriptorsEndpointNode endpointNode) {
        this.mEndpointNodes.add(endpointNode);
    }

    public void addACInterfaceNode(UsbDescriptorsACInterfaceNode acInterfaceNode) {
        this.mACInterfaceNodes.add(acInterfaceNode);
    }

    @Override // com.android.server.usb.descriptors.tree.UsbDescriptorsTreeNode, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        this.mInterfaceDescriptor.report(canvas);
        if (this.mACInterfaceNodes.size() <= 0) goto L10;
        canvas.writeParagraph("Audio Class Interfaces", false);
        canvas.openList();
        Iterator<UsbDescriptorsACInterfaceNode> r0 = this.mACInterfaceNodes.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        UsbDescriptorsACInterfaceNode node = r0.next();
        node.report(canvas);
        goto L6
    L8:
        canvas.closeList();
    L10:
        if (this.mEndpointNodes.size() <= 0) goto L19;
        canvas.writeParagraph("Endpoints", false);
        canvas.openList();
        Iterator<UsbDescriptorsEndpointNode> r1 = this.mEndpointNodes.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        UsbDescriptorsEndpointNode node2 = r1.next();
        node2.report(canvas);
        goto L13
    L15:
        canvas.closeList();
        return;
    }
}
