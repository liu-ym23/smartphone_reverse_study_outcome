package org.tukaani.xz;

import android.hardware.tv.mediaquality.ParameterName;

/* JADX INFO: loaded from: classes3.dex */
public class XZ {
    public static final int CHECK_CRC32 = 1;
    public static final int CHECK_CRC64 = 4;
    public static final int CHECK_NONE = 0;
    public static final int CHECK_SHA256 = 10;
    public static final byte[] FOOTER_MAGIC = null;
    public static final byte[] HEADER_MAGIC = null;

    static {
        HEADER_MAGIC = new byte[]{-3, 55, 122, 88, ParameterName.DOLBY_AUDIO_PROCESSING, 0};
        FOOTER_MAGIC = new byte[]{ParameterName.DTS_DRC, ParameterName.DOLBY_AUDIO_PROCESSING};
    }

    private XZ() {
    }
}
