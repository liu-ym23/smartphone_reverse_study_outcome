package org.tukaani.xz;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class XZFormatException extends XZIOException {
    private static final long serialVersionUID = 3;

    public XZFormatException() {
        super("Input is not in the XZ format");
    }
}
