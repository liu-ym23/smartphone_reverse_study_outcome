package com.android.server.usb.descriptors.tree;

import com.android.server.usb.descriptors.UsbConfigDescriptor;
import com.android.server.usb.descriptors.report.ReportCanvas;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbDescriptorsConfigNode extends UsbDescriptorsTreeNode {
    private static final String TAG = "UsbDescriptorsConfigNode";
    private final UsbConfigDescriptor mConfigDescriptor;
    private final ArrayList<UsbDescriptorsInterfaceNode> mInterfaceNodes;

    public UsbDescriptorsConfigNode(UsbConfigDescriptor configDescriptor) {
        this.mInterfaceNodes = new ArrayList();
        this.mConfigDescriptor = configDescriptor;
    }

    public void addInterfaceNode(UsbDescriptorsInterfaceNode interfaceNode) {
        this.mInterfaceNodes.add(interfaceNode);
    }

    @Override // com.android.server.usb.descriptors.tree.UsbDescriptorsTreeNode, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        this.mConfigDescriptor.report(canvas);
        canvas.openList();
        Iterator<UsbDescriptorsInterfaceNode> r0 = this.mInterfaceNodes.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UsbDescriptorsInterfaceNode node = r0.next();
        node.report(canvas);
        goto L4
    L6:
        canvas.closeList();
    }
}
