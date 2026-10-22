package com.android.server.hdmi;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.HexDump;
import com.android.internal.util.IndentingPrintWriter;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.voiceinteraction.DatabaseHelper;
import com.google.android.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiUtils {
    private static final Map<Integer, List<Integer>> ADDRESS_TO_TYPE = null;
    private static final String[] DEFAULT_NAMES = null;
    private static final String TAG = "HdmiUtils";
    static final int TARGET_NOT_UNDER_LOCAL_DEVICE = -1;
    static final int TARGET_SAME_PHYSICAL_ADDRESS = 0;

    public static class CodecSad {
        public final int audioCodec;
        public final byte[] sad;

        public CodecSad(int audioCodec, byte[] sad) {
            this.audioCodec = audioCodec;
            this.sad = sad;
        }

        public CodecSad(int audioCodec, String sad) {
            this.audioCodec = audioCodec;
            this.sad = HexDump.hexStringToByteArray(sad);
        }

        public boolean equals(Object obj) {
            if ((obj instanceof CodecSad) == false) goto L11;
            CodecSad that = (CodecSad) obj;
            if (that.audioCodec == this.audioCodec) goto L7;
            return false;
        L7:
            if (Arrays.equals(that.sad, this.sad) == false) goto L13;
            return true;
        L13:
            return false;
        L11:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.audioCodec), Integer.valueOf(Arrays.hashCode(this.sad))});
        }
    }

    public static class DeviceConfig {
        public final String name;
        public final List<CodecSad> supportedCodecs;

        public DeviceConfig(String name, List<CodecSad> supportedCodecs) {
            this.name = name;
            this.supportedCodecs = supportedCodecs;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof DeviceConfig) == false) goto L11;
            DeviceConfig that = (DeviceConfig) obj;
            if (that.name.equals(this.name) == true) goto L7;
            return false;
        L7:
            if (that.supportedCodecs.equals(this.supportedCodecs) == false) goto L13;
            return true;
        L13:
            return false;
        L11:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.name, Integer.valueOf(this.supportedCodecs.hashCode())});
        }
    }

    public static class ShortAudioDescriptorXmlParser {
        private static final String NS = null;

        public ShortAudioDescriptorXmlParser() {
        }

        static {
            NS = null;
        }

        public static List<DeviceConfig> parse(InputStream in) throws XmlPullParserException, IOException {
            TypedXmlPullParser parser = Xml.resolvePullParser(in);
            parser.nextTag();
            return readDevices(parser);
        }

        private static void skip(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
            if (parser.getEventType() != 2) goto L14;
            int depth = 1;
        L5:
            if (depth == 0) goto L12;
            switch(parser.next()) {
                case 2: goto L10;
                case 3: goto L9;
                default: goto L5;
            };
        L9:
            depth = depth - 1;
            goto L5
        L10:
            depth = depth + 1;
            goto L5
        L12:
            return;
        L14:
            throw new IllegalStateException();
        }

        private static List<DeviceConfig> readDevices(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
            List<DeviceConfig> devices = new ArrayList();
            parser.require(2, NS, "config");
        L4:
            if (parser.next() == 3) goto L18;
            if (parser.getEventType() != 2) goto L4;
            String name = parser.getName();
            if (name.equals("device") == true) goto L10;
            skip(parser);
            goto L4
        L10:
            String deviceType = parser.getAttributeValue(null, DatabaseHelper.SoundModelContract.KEY_TYPE);
            DeviceConfig config = null;
            if (deviceType == null) goto L13;
            config = readDeviceConfig(parser, deviceType);
        L13:
            if (config == null) goto L4;
            devices.add(config);
            goto L4
        L18:
            return devices;
        }

        private static DeviceConfig readDeviceConfig(TypedXmlPullParser parser, String deviceType) throws XmlPullParserException, IOException {
            List<CodecSad> codecSads = new ArrayList();
            parser.require(2, NS, "device");
        L4:
            if (parser.next() == 3) goto L22;
            if (parser.getEventType() != 2) goto L4;
            String tagName = parser.getName();
            if (tagName.equals("supportedFormat") == true) goto L10;
            skip(parser);
            goto L4
        L10:
            String codecAttriValue = parser.getAttributeValue(null, "format");
            String sadAttriValue = parser.getAttributeValue(null, "descriptor");
            if (codecAttriValue != null) goto L13;
            int format = 0;
        L14:
            byte[] descriptor = readSad(sadAttriValue);
            if (format == 0) goto L18;
            if (descriptor == null) goto L18;
            codecSads.add(new CodecSad(format, descriptor));
        L18:
            parser.nextTag();
            parser.require(3, NS, "supportedFormat");
            goto L4
        L13:
            format = formatNameToNum(codecAttriValue);
            goto L14
        L22:
            if (codecSads.size() != 0) goto L25;
            return null;
        L25:
            return new DeviceConfig(deviceType, codecSads);
        }

        private static byte[] readSad(String sad) {
            if (sad != null) goto L5;
        L12:
            return null;
        L5:
            if (sad.length() == 0) goto L12;
            byte[] sadBytes = HexDump.hexStringToByteArray(sad);
            if (sadBytes.length == 3) goto L11;
            Slog.w(HdmiUtils.TAG, "SAD byte array length is not 3. Length = " + sadBytes.length);
            return null;
        L11:
            return sadBytes;
        }

        private static int formatNameToNum(String codecAttriValue) {
            switch(codecAttriValue.hashCode()) {
                case -2131742975: goto L51;
                case -1197237630: goto L48;
                case -1194465888: goto L45;
                case -1186286867: goto L42;
                case -1186286866: goto L39;
                case -358943216: goto L36;
                case -282810364: goto L33;
                case -282807375: goto L30;
                case -282806906: goto L27;
                case -282806876: goto L24;
                case -282798811: goto L21;
                case -282798383: goto L18;
                case -176844499: goto L15;
                case -176785545: goto L12;
                case 129424511: goto L9;
                case 2082539401: goto L6;
                default: goto L53;
            };
        L53:
            byte r1 = -1;
        L54:
            switch(r1) {
                case 0: goto L71;
                case 1: goto L70;
                case 2: goto L69;
                case 3: goto L68;
                case 4: goto L67;
                case 5: goto L66;
                case 6: goto L65;
                case 7: goto L64;
                case 8: goto L63;
                case 9: goto L62;
                case 10: goto L61;
                case 11: goto L60;
                case 12: goto L59;
                case 13: goto L58;
                case 14: goto L57;
                case 15: goto L56;
                default: goto L55;
            };
        L55:
            return 0;
        L56:
            return 15;
        L57:
            return 14;
        L58:
            return 13;
        L59:
            return 12;
        L60:
            return 11;
        L61:
            return 10;
        L62:
            return 9;
        L63:
            return 8;
        L64:
            return 7;
        L65:
            return 6;
        L66:
            return 5;
        L67:
            return 4;
        L68:
            return 3;
        L69:
            return 2;
        L70:
            return 1;
        L71:
            return 0;
        L6:
            if (codecAttriValue.equals("AUDIO_FORMAT_TRUEHD") == false) goto L53;
            r1 = 12;
            goto L54
        L9:
            if (codecAttriValue.equals("AUDIO_FORMAT_DD") == false) goto L53;
            r1 = 2;
            goto L54
        L12:
            if (codecAttriValue.equals("AUDIO_FORMAT_NONE") == false) goto L53;
            r1 = 0;
            goto L54
        L15:
            if (codecAttriValue.equals("AUDIO_FORMAT_LPCM") == false) goto L53;
            r1 = 1;
            goto L54
        L18:
            if (codecAttriValue.equals("AUDIO_FORMAT_MP3") == false) goto L53;
            r1 = 4;
            goto L54
        L21:
            if (codecAttriValue.equals("AUDIO_FORMAT_MAX") == false) goto L53;
            r1 = 15;
            goto L54
        L24:
            if (codecAttriValue.equals("AUDIO_FORMAT_DTS") == false) goto L53;
            r1 = 7;
            goto L54
        L27:
            if (codecAttriValue.equals("AUDIO_FORMAT_DST") == false) goto L53;
            r1 = 13;
            goto L54
        L30:
            if (codecAttriValue.equals("AUDIO_FORMAT_DDP") == false) goto L53;
            r1 = 10;
            goto L54
        L33:
            if (codecAttriValue.equals("AUDIO_FORMAT_AAC") == false) goto L53;
            r1 = 6;
            goto L54
        L36:
            if (codecAttriValue.equals("AUDIO_FORMAT_ONEBITAUDIO") == false) goto L53;
            r1 = 9;
            goto L54
        L39:
            if (codecAttriValue.equals("AUDIO_FORMAT_MPEG2") == false) goto L53;
            r1 = 5;
            goto L54
        L42:
            if (codecAttriValue.equals("AUDIO_FORMAT_MPEG1") == false) goto L53;
            r1 = 3;
            goto L54
        L45:
            if (codecAttriValue.equals("AUDIO_FORMAT_DTSHD") == false) goto L53;
            r1 = 11;
            goto L54
        L48:
            if (codecAttriValue.equals("AUDIO_FORMAT_ATRAC") == false) goto L53;
            r1 = 8;
            goto L54
        L51:
            if (codecAttriValue.equals("AUDIO_FORMAT_WMAPRO") == false) goto L53;
            r1 = 14;
            goto L54
        }
    }

    static {
        ADDRESS_TO_TYPE = Map.ofEntries(new Map.Entry[]{Map.entry(0, Lists.newArrayList(new Integer[]{0})), Map.entry(1, Lists.newArrayList(new Integer[]{1})), Map.entry(2, Lists.newArrayList(new Integer[]{1})), Map.entry(3, Lists.newArrayList(new Integer[]{3})), Map.entry(4, Lists.newArrayList(new Integer[]{4})), Map.entry(5, Lists.newArrayList(new Integer[]{5})), Map.entry(6, Lists.newArrayList(new Integer[]{3})), Map.entry(7, Lists.newArrayList(new Integer[]{3})), Map.entry(8, Lists.newArrayList(new Integer[]{4})), Map.entry(9, Lists.newArrayList(new Integer[]{1})), Map.entry(10, Lists.newArrayList(new Integer[]{3})), Map.entry(11, Lists.newArrayList(new Integer[]{4})), Map.entry(12, Lists.newArrayList(new Integer[]{4, 1, 3, 7})), Map.entry(13, Lists.newArrayList(new Integer[]{4, 1, 3, 7})), Map.entry(14, Lists.newArrayList(new Integer[]{0})), Map.entry(15, Collections.emptyList())});
        DEFAULT_NAMES = new String[]{"TV", "Recorder_1", "Recorder_2", "Tuner_1", "Playback_1", "AudioSystem", "Tuner_2", "Tuner_3", "Playback_2", "Recorder_3", "Tuner_4", "Playback_3", "Backup_1", "Backup_2", "Secondary_TV"};
    }

    private HdmiUtils() {
    }

    static boolean isValidAddress(int address) {
        if (address >= 0) goto L4;
    L6:
        return false;
    L4:
        if (address > 14) goto L6;
        return true;
    }

    static boolean isEligibleAddressForDevice(int deviceType, int logicalAddress) {
        if (isValidAddress(logicalAddress) == true) goto L5;
    L7:
        return false;
    L5:
        if (ADDRESS_TO_TYPE.get(Integer.valueOf(logicalAddress)).contains(Integer.valueOf(deviceType)) == false) goto L7;
        return true;
    }

    static boolean isEligibleAddressForCecVersion(int cecVersion, int logicalAddress) {
        if (isValidAddress(logicalAddress) == true) goto L5;
        return false;
    L5:
        if (logicalAddress == 12) goto L11;
        if (logicalAddress == 13) goto L11;
        return true;
    L11:
        if (cecVersion >= 6) goto L13;
        return false;
    L13:
        return true;
    }

    static List<Integer> getTypeFromAddress(int logicalAddress) {
        if (isValidAddress(logicalAddress) == false) goto L7;
        return ADDRESS_TO_TYPE.get(Integer.valueOf(logicalAddress));
    L7:
        return Lists.newArrayList(new Integer[]{-1});
    }

    static String getDefaultDeviceName(int address) {
        if (isValidAddress(address) == true) goto L5;
        return "";
    L5:
        return DEFAULT_NAMES[address];
    }

    static boolean verifyAddressType(int logicalAddress, int deviceType) {
        List<Integer> actualDeviceTypes = getTypeFromAddress(logicalAddress);
        if (actualDeviceTypes.contains(Integer.valueOf(deviceType)) == true) goto L6;
        Slog.w(TAG, "Device type mismatch:[Expected:" + deviceType + ", Actual:" + actualDeviceTypes + "]");
        return false;
    L6:
        return true;
    }

    static boolean checkCommandSource(HdmiCecMessage cmd, int expectedAddress, String tag) {
        int src = cmd.getSource();
        if (src == expectedAddress) goto L6;
        Slog.w(tag, "Invalid source [Expected:" + expectedAddress + ", Actual:" + src + "]");
        return false;
    L6:
        return true;
    }

    static boolean parseCommandParamSystemAudioStatus(HdmiCecMessage cmd) {
        if (cmd.getParams()[0] == 1) goto L5;
        return false;
    L5:
        return true;
    }

    static boolean isAudioStatusMute(HdmiCecMessage cmd) {
        byte[] params = cmd.getParams();
        if ((params[0] & 128) != 128) goto L6;
        return true;
    L6:
        return false;
    }

    static int getAudioStatusVolume(HdmiCecMessage cmd) {
        byte[] params = cmd.getParams();
        int volume = params[0] & 127;
        if (volume >= 0) goto L5;
    L6:
        return -1;
    L5:
        if (100 < volume) goto L6;
        return volume;
    }

    static List<Integer> asImmutableList(int[] is) {
        ArrayList<Integer> list = new ArrayList(is.length);
        int r1 = is.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        int type = is[r2];
        list.add(Integer.valueOf(type));
        r2 = r2 + 1;
        goto L3
    L6:
        return Collections.unmodifiableList(list);
    }

    static int twoBytesToInt(byte[] data) {
        return ((data[0] & CecDeviceType.INACTIVE) << 8) | (data[1] & CecDeviceType.INACTIVE);
    }

    static int twoBytesToInt(byte[] data, int offset) {
        return ((data[offset] & CecDeviceType.INACTIVE) << 8) | (data[offset + 1] & CecDeviceType.INACTIVE);
    }

    static int threeBytesToInt(byte[] data) {
        return (((data[0] & CecDeviceType.INACTIVE) << 16) | ((data[1] & CecDeviceType.INACTIVE) << 8)) | (data[2] & CecDeviceType.INACTIVE);
    }

    static <T> List<T> sparseArrayToList(SparseArray<T> array) {
        ArrayList<T> list = new ArrayList();
        int i = 0;
    L4:
        if (i >= array.size()) goto L7;
        list.add(array.valueAt(i));
        i = i + 1;
        goto L4
    L7:
        return list;
    }

    static <T> List<T> mergeToUnmodifiableList(List<T> a, List<T> b) {
        if (a.isEmpty() == false) goto L9;
        if (b.isEmpty() == false) goto L9;
        return Collections.emptyList();
    L9:
        if (a.isEmpty() == false) goto L13;
        return Collections.unmodifiableList(b);
    L13:
        if (b.isEmpty() == true) goto L15;
        List<T> newList = new ArrayList();
        newList.addAll(a);
        newList.addAll(b);
        return Collections.unmodifiableList(newList);
    L15:
        return Collections.unmodifiableList(a);
    }

    static boolean isAffectingActiveRoutingPath(int activePath, int newPath) {
        int i = 0;
    L4:
        if (i > 12) goto L9;
        int nibble = (newPath >> i) & 15;
        if (nibble != 0) goto L7;
        i = i + 4;
        goto L4
    L7:
        int mask = 65520 << i;
        newPath = newPath & mask;
    L9:
        if (newPath != 0) goto L13;
        return true;
    L13:
        return isInActiveRoutingPath(activePath, newPath);
    }

    static boolean isInActiveRoutingPath(int activePath, int newPath) {
        int pathRelationship = pathRelationship(newPath, activePath);
        if (pathRelationship != 2) goto L5;
    L10:
        return true;
    L5:
        if (pathRelationship == 3) goto L10;
        if (pathRelationship == 5) goto L10;
        return false;
    }

    static int pathRelationship(int firstPath, int secondPath) {
        if (firstPath == 65535) goto L28;
        if (secondPath == 65535) goto L34;
        int nibbleIndex = 0;
    L8:
        if (nibbleIndex > 3) goto L26;
        int shift = 12 - (nibbleIndex * 4);
        int firstPathNibble = (firstPath >> shift) & 15;
        int secondPathNibble = (secondPath >> shift) & 15;
        if (firstPathNibble != secondPathNibble) goto L11;
        nibbleIndex = nibbleIndex + 1;
        goto L8
    L11:
        int firstPathNextNibble = (firstPath >> (shift - 4)) & 15;
        int secondPathNextNibble = (secondPath >> (shift - 4)) & 15;
        if (firstPathNibble != 0) goto L15;
        return 2;
    L15:
        if (secondPathNibble != 0) goto L17;
        return 3;
    L17:
        if (nibbleIndex == 3) goto L23;
        if (firstPathNextNibble != 0) goto L21;
        if (secondPathNextNibble == 0) goto L33;
        return 1;
    L33:
        return 4;
    L21:
        return 1;
    L23:
        return 4;
    L26:
        return 5;
    L34:
        return 0;
    L28:
        return 0;
    }

    static <T> void dumpSparseArray(IndentingPrintWriter pw, String name, SparseArray<T> sparseArray) {
        printWithTrailingColon(pw, name);
        pw.increaseIndent();
        int size = sparseArray.size();
        int i = 0;
    L3:
        if (i >= size) goto L5;
        int key = sparseArray.keyAt(i);
        T value = sparseArray.get(key);
        pw.printPair(Integer.toString(key), value);
        pw.println();
        i = i + 1;
        goto L3
    L5:
        pw.decreaseIndent();
    }

    private static void printWithTrailingColon(IndentingPrintWriter pw, String name) {
        if (name.endsWith(":") == false) goto L5;
        String r0 = name;
    L6:
        pw.println(r0);
        return;
    L5:
        r0 = name.concat(":");
        goto L6
    }

    static <K, V> void dumpMap(IndentingPrintWriter pw, String name, Map<K, V> map) {
        printWithTrailingColon(pw, name);
        pw.increaseIndent();
        Iterator<Map.Entry<K, V>> r0 = map.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<K, V> entry = r0.next();
        pw.printPair(entry.getKey().toString(), entry.getValue());
        pw.println();
        goto L4
    L6:
        pw.decreaseIndent();
    }

    static <T> void dumpIterable(IndentingPrintWriter pw, String name, Iterable<T> values) {
        printWithTrailingColon(pw, name);
        pw.increaseIndent();
        Iterator<T> r0 = values.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        T value = r0.next();
        pw.println(value);
        goto L4
    L6:
        pw.decreaseIndent();
    }

    public static int getLocalPortFromPhysicalAddress(int targetPhysicalAddress, int myPhysicalAddress) {
        if (myPhysicalAddress != targetPhysicalAddress) goto L5;
        return 0;
    L5:
        int mask = 61440;
        int finalMask = 61440;
        int maskedAddress = myPhysicalAddress;
    L6:
        if (maskedAddress == 0) goto L8;
        maskedAddress = myPhysicalAddress & mask;
        finalMask = finalMask | mask;
        mask = mask >> 4;
        goto L6
    L8:
        int portAddress = targetPhysicalAddress & finalMask;
        if (((finalMask << 4) & portAddress) == myPhysicalAddress) goto L12;
        return -1;
    L12:
        int port = portAddress & (mask << 4);
    L14:
        if ((port >> 4) == 0) goto L16;
        port = port >> 4;
        goto L14
    L16:
        return port;
    }

    static int getAbortFeatureOpcode(HdmiCecMessage cmd) {
        return cmd.getParams()[0] & CecDeviceType.INACTIVE;
    }

    static int getAbortReason(HdmiCecMessage cmd) {
        return cmd.getParams()[1];
    }

    public static HdmiCecMessage buildMessage(String message) {
        String[] parts = message.split(":");
        if (parts.length < 2) goto L18;
        int r1 = parts.length;
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L11;
        String part = parts[r4];
        if (part.length() != 2) goto L10;
        r4 = r4 + 1;
        goto L5
    L10:
        throw new IllegalArgumentException("Malformatted CEC message: " + message);
    L11:
        int src = Integer.parseInt(parts[0].substring(0, 1), 16);
        int dest = Integer.parseInt(parts[0].substring(1, 2), 16);
        int opcode = Integer.parseInt(parts[1], 16);
        byte[] params = new byte[parts.length - 2];
        int i = 0;
    L13:
        if (i >= params.length) goto L16;
        params[i] = (byte) Integer.parseInt(parts[i + 2], 16);
        i = i + 1;
        goto L13
    L16:
        return HdmiCecMessage.build(src, dest, opcode, params);
    L18:
        throw new IllegalArgumentException("Message is too short");
    }

    public static int getEndOfSequence(byte[] params, int offset) {
        if (offset >= 0) goto L6;
        return -1;
    L6:
        if (offset >= params.length) goto L11;
        if (((params[offset] >> 7) & 1) != 1) goto L11;
        offset = offset + 1;
    L11:
        if (offset < params.length) goto L13;
        return -1;
    L13:
        return offset;
    }
}
