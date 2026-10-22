package org.brotli.dec;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.usb.descriptors.UsbDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class Transform {
    private static final int IDENTITY = 0;
    static final int NUM_RFC_TRANSFORMS = 121;
    private static final int OMIT_FIRST_BASE = 11;
    private static final int OMIT_FIRST_LAST_LIMIT = 9;
    private static final int OMIT_LAST_BASE = 0;
    private static final String PREFIX_SUFFIX_SRC = "# #s #, #e #.# the #.com/#Â # of # and # in # to #\"#\">#\n#]# for # a # that #. # with #'# from # by #. The # on # as # is #ing #\n\t#:#ed #(# at #ly #=\"# of the #. This #,# not #er #al #='#ful #ive #less #est #ize #ous #";
    static final Transforms RFC_TRANSFORMS = null;
    private static final int SHIFT_ALL = 22;
    private static final int SHIFT_FIRST = 21;
    private static final String TRANSFORMS_SRC = "     !! ! ,  *!  &!  \" !  ) *   * -  ! # !  #!*!  +  ,$ !  -  %  .  / #   0  1 .  \"   2  3!*   4%  ! # /   5  6  7  8 0  1 &   $   9 +   :  ;  < '  !=  >  ?! 4  @ 4  2  &   A *# (   B  C& ) %  ) !*# *-% A +! *.  D! %'  & E *6  F  G% ! *A *%  H! D  I!+!  J!+   K +- *4! A  L!*4  M  N +6  O!*% +.! K *G  P +%(  ! G *D +D  Q +# *K!*G!+D!+# +G +A +4!+% +K!+4!*D!+K!*K";
    private static final int UPPERCASE_ALL = 11;
    private static final int UPPERCASE_FIRST = 10;

    static final class Transforms {
        final int numTransforms;
        final short[] params;
        final int[] prefixSuffixHeads;
        final byte[] prefixSuffixStorage;
        final int[] triplets;

        Transforms(int numTransforms, int prefixSuffixLen, int prefixSuffixCount) {
            this.numTransforms = numTransforms;
            this.triplets = new int[numTransforms * 3];
            this.params = new short[numTransforms];
            this.prefixSuffixStorage = new byte[prefixSuffixLen];
            this.prefixSuffixHeads = new int[prefixSuffixCount + 1];
        }
    }

    Transform() {
    }

    static {
        RFC_TRANSFORMS = new Transforms(121, 167, 50);
        unpackTransforms(RFC_TRANSFORMS.prefixSuffixStorage, RFC_TRANSFORMS.prefixSuffixHeads, RFC_TRANSFORMS.triplets, PREFIX_SUFFIX_SRC, TRANSFORMS_SRC);
    }

    private static void unpackTransforms(byte[] prefixSuffix, int[] prefixSuffixHeads, int[] transforms, String prefixSuffixSrc, String transformsSrc) {
        int n = prefixSuffixSrc.length();
        int index = 1;
        int j = 0;
        int i = 0;
    L3:
        if (i >= n) goto L9;
        char c = prefixSuffixSrc.charAt(i);
        if (c != '#') goto L7;
        prefixSuffixHeads[index] = j;
        index = index + 1;
    L8:
        i = i + 1;
        goto L3
    L7:
        int index2 = j + 1;
        prefixSuffix[j] = (byte) c;
        j = index2;
        goto L8
    L9:
        int i2 = 0;
    L11:
        if (i2 >= 363) goto L14;
        transforms[i2] = transformsSrc.charAt(i2) - ' ';
        i2 = i2 + 1;
        goto L11
    }

    static int transformDictionaryWord(byte[] dst, int dstOffset, ByteBuffer src, int srcOffset, int len, Transforms transforms, int transformIndex) {
        int[] triplets = transforms.triplets;
        byte[] prefixSuffixStorage = transforms.prefixSuffixStorage;
        int[] prefixSuffixHeads = transforms.prefixSuffixHeads;
        int transformOffset = transformIndex * 3;
        int prefixIdx = triplets[transformOffset];
        int transformType = triplets[transformOffset + 1];
        int suffixIdx = triplets[transformOffset + 2];
        int prefix = prefixSuffixHeads[prefixIdx];
        int prefixEnd = prefixSuffixHeads[prefixIdx + 1];
        int suffix = prefixSuffixHeads[suffixIdx];
        int suffixEnd = prefixSuffixHeads[suffixIdx + 1];
        int omitFirst = transformType - 11;
        int omitLast = transformType + 0;
        int offset = dstOffset;
        if (omitFirst >= 1) goto L5;
    L6:
        omitFirst = 0;
    L8:
        if (omitLast >= 1) goto L10;
    L13:
        omitLast = 0;
    L14:
        if (prefix == prefixEnd) goto L16;
        dst[offset] = prefixSuffixStorage[prefix];
        offset = offset + 1;
        prefix = prefix + 1;
        goto L14
    L16:
        if (omitFirst <= len) goto L18;
        omitFirst = len;
    L18:
        int len2 = (len - omitFirst) - omitLast;
        int i = len2;
        int len3 = srcOffset + omitFirst;
    L19:
        if (i <= 0) goto L21;
        int srcOffset2 = len3 + 1;
        dst[offset] = src.get(len3);
        i = i - 1;
        offset = offset + 1;
        len3 = srcOffset2;
        goto L19
    L21:
        int offset2 = offset;
        if (transformType == 10) goto L65;
        if (transformType == 11) goto L65;
        if (transformType != 21) goto L29;
    L32:
        int shiftOffset = offset2 - len2;
        short param = transforms.params[transformIndex];
        int shiftOffset2 = param & Short.MAX_VALUE;
        int shiftOffset3 = shiftOffset;
        int scalar = shiftOffset2 + (16777216 - (param & Short.MIN_VALUE));
        int len4 = len2;
    L33:
        if (len4 <= 0) goto L63;
        int step = 1;
        int c0 = dst[shiftOffset3] & CecDeviceType.INACTIVE;
        short param2 = param;
        if (c0 >= 128) goto L38;
        scalar = scalar + c0;
        dst[shiftOffset3] = (byte) (scalar & 127);
        int len5 = len4;
        int[] triplets2 = triplets;
        byte[] prefixSuffixStorage2 = prefixSuffixStorage;
        int[] prefixSuffixHeads2 = prefixSuffixHeads;
    L59:
        shiftOffset3 = shiftOffset3 + step;
        len4 = len5 - step;
        if (transformType != 21) goto L62;
        len4 = 0;
    L62:
        param = param2;
        prefixSuffixStorage = prefixSuffixStorage2;
        triplets = triplets2;
        prefixSuffixHeads = prefixSuffixHeads2;
        goto L33
    L38:
        if (c0 >= 192) goto L41;
        len5 = len4;
        triplets2 = triplets;
        prefixSuffixStorage2 = prefixSuffixStorage;
        prefixSuffixHeads2 = prefixSuffixHeads;
        goto L59
    L41:
        if (c0 < 224) goto L43;
        triplets2 = triplets;
        prefixSuffixStorage2 = prefixSuffixStorage;
        if (c0 < 240) goto L49;
        prefixSuffixHeads2 = prefixSuffixHeads;
        if (c0 < 248) goto L55;
        len5 = len4;
        goto L59
    L55:
        if (len4 < 4) goto L57;
        byte c1 = dst[shiftOffset3 + 1];
        byte c2 = dst[shiftOffset3 + 2];
        byte c3 = dst[shiftOffset3 + 3];
        scalar = scalar + ((((c3 & ParameterName.COLOR_TUNER_HUE_YELLOW) | ((c2 & ParameterName.COLOR_TUNER_HUE_YELLOW) << 6)) | ((c1 & ParameterName.COLOR_TUNER_HUE_YELLOW) << 12)) | ((c0 & 7) << 18));
        len5 = len4;
        dst[shiftOffset3] = (byte) (((scalar >> 18) & 7) | FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED);
        dst[shiftOffset3 + 1] = (byte) ((c1 & 192) | ((scalar >> 12) & 63));
        dst[shiftOffset3 + 2] = (byte) ((c2 & 192) | ((scalar >> 6) & 63));
        dst[shiftOffset3 + 3] = (byte) ((c3 & 192) | (scalar & 63));
        step = 4;
        goto L59
    L57:
        len5 = len4;
        step = len5;
        goto L59
    L49:
        if (len4 < 3) goto L51;
        byte c4 = dst[shiftOffset3 + 1];
        byte c5 = dst[shiftOffset3 + 2];
        scalar = scalar + (((c5 & ParameterName.COLOR_TUNER_HUE_YELLOW) | ((c4 & ParameterName.COLOR_TUNER_HUE_YELLOW) << 6)) | ((c0 & 15) << 12));
        prefixSuffixHeads2 = prefixSuffixHeads;
        dst[shiftOffset3] = (byte) (((scalar >> 12) & 15) | UsbDescriptor.CLASSID_WIRELESS);
        dst[shiftOffset3 + 1] = (byte) ((c4 & 192) | ((scalar >> 6) & 63));
        dst[shiftOffset3 + 2] = (byte) ((c5 & 192) | (scalar & 63));
        step = 3;
        len5 = len4;
        goto L59
    L51:
        prefixSuffixHeads2 = prefixSuffixHeads;
        step = len4;
        len5 = len4;
        goto L59
    L43:
        if (len4 < 2) goto L45;
        byte c6 = dst[shiftOffset3 + 1];
        scalar = scalar + ((c6 & ParameterName.COLOR_TUNER_HUE_YELLOW) | ((c0 & 31) << 6));
        triplets2 = triplets;
        prefixSuffixStorage2 = prefixSuffixStorage;
        dst[shiftOffset3] = (byte) (((scalar >> 6) & 31) | 192);
        dst[shiftOffset3 + 1] = (byte) ((c6 & 192) | (scalar & 63));
        step = 2;
        len5 = len4;
        prefixSuffixHeads2 = prefixSuffixHeads;
        goto L59
    L45:
        triplets2 = triplets;
        prefixSuffixStorage2 = prefixSuffixStorage;
        step = len4;
        len5 = len4;
        prefixSuffixHeads2 = prefixSuffixHeads;
        goto L59
    L63:
        prefixSuffixStorage = prefixSuffixStorage;
    L84:
        if (suffix == suffixEnd) goto L87;
        dst[offset2] = prefixSuffixStorage[suffix];
        offset2 = offset2 + 1;
        suffix = suffix + 1;
        goto L84
    L87:
        return offset2 - dstOffset;
    L29:
        if (transformType == 22) goto L32;
        prefixSuffixStorage = prefixSuffixStorage;
    L65:
        int uppercaseOffset = offset2 - len2;
        if (transformType != 10) goto L68;
        int len6 = 1;
    L69:
        if (len6 <= 0) goto L84;
        int c7 = dst[uppercaseOffset] & 255;
        if (c7 < 192) goto L73;
        if (c7 < 224) goto L80;
        int r3 = uppercaseOffset + 2;
        dst[r3] = (byte) (dst[r3] ^ 5);
        uppercaseOffset = uppercaseOffset + 3;
        len6 = len6 - 3;
        goto L69
    L80:
        int r4 = uppercaseOffset + 1;
        dst[r4] = (byte) (dst[r4] ^ ParameterName.CVRR);
        uppercaseOffset = uppercaseOffset + 2;
        len6 = len6 - 2;
        goto L69
    L73:
        if (c7 >= 97) goto L75;
    L77:
        uppercaseOffset = uppercaseOffset + 1;
        len6 = len6 - 1;
        goto L69
    L75:
        if (c7 > 122) goto L77;
        dst[uppercaseOffset] = (byte) (dst[uppercaseOffset] ^ ParameterName.CVRR);
        goto L77
    L68:
        len6 = len2;
        goto L69
    L10:
        if (omitLast <= 9) goto L14;
    L5:
        if (omitFirst <= 9) goto L8;
        goto L6
    }
}
