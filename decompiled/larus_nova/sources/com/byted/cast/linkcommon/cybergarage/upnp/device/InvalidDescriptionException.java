package com.byted.cast.linkcommon.cybergarage.upnp.device;

import java.io.File;

/* JADX INFO: loaded from: classes28.dex */
public class InvalidDescriptionException extends Exception {
    public InvalidDescriptionException() {
    }

    public InvalidDescriptionException(Exception r100) {
        super(r100.getMessage());
    }

    public InvalidDescriptionException(String r100) {
        super(r100);
    }

    public InvalidDescriptionException(String r100, File r101) {
        super(r100 + " (" + r101.toString() + ")");
    }
}
