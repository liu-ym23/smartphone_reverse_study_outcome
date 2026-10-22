package com.android.server.usb.descriptors.tree;

import com.android.server.usb.descriptors.UsbDeviceDescriptor;
import com.android.server.usb.descriptors.report.ReportCanvas;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbDescriptorsDeviceNode extends UsbDescriptorsTreeNode {
    private static final String TAG = "UsbDescriptorsDeviceNode";
    private final ArrayList<UsbDescriptorsConfigNode> mConfigNodes;
    private final UsbDeviceDescriptor mDeviceDescriptor;

    public UsbDescriptorsDeviceNode(UsbDeviceDescriptor deviceDescriptor) {
        this.mConfigNodes = new ArrayList();
        this.mDeviceDescriptor = deviceDescriptor;
    }

    public void addConfigDescriptorNode(UsbDescriptorsConfigNode configNode) {
        this.mConfigNodes.add(configNode);
    }

    @Override // com.android.server.usb.descriptors.tree.UsbDescriptorsTreeNode, com.android.server.usb.descriptors.report.Reporting
    public void report(ReportCanvas canvas) {
        this.mDeviceDescriptor.report(canvas);
        Iterator<UsbDescriptorsConfigNode> r0 = this.mConfigNodes.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UsbDescriptorsConfigNode node = r0.next();
        node.report(canvas);
        goto L4
    }
}
