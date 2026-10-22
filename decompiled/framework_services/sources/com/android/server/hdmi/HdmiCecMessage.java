package com.android.server.hdmi;

import java.util.Arrays;
import java.util.Objects;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecMessage {
    public static final byte[] EMPTY_PARAM = null;
    private final int mDestination;
    private final int mOpcode;
    private final byte[] mParams;
    private final int mSource;
    private final int mValidationResult;

    static {
        EMPTY_PARAM = EmptyArray.BYTE;
    }

    protected HdmiCecMessage(int source, int destination, int opcode, byte[] params, int validationResult) {
        this.mSource = source;
        this.mDestination = destination;
        this.mOpcode = opcode & 255;
        this.mParams = Arrays.copyOf(params, params.length);
        this.mValidationResult = validationResult;
    }

    private HdmiCecMessage(int source, int destination, int opcode, byte[] params) {
        this(source, destination, opcode, params, HdmiCecMessageValidator.validate(source, destination, opcode & 255, params));
    }

    static HdmiCecMessage build(int source, int destination, int opcode, byte[] params) {
        switch((opcode & 255)) {
            case 115: goto L9;
            case 166: goto L7;
            default: goto L5;
        };
    L5:
        return new HdmiCecMessage(source, destination, opcode & 255, params);
    L7:
        return ReportFeaturesMessage.build(source, destination, params);
    L9:
        return SetAudioVolumeLevelMessage.build(source, destination, params);
    }

    static HdmiCecMessage build(int source, int destination, int opcode) {
        return new HdmiCecMessage(source, destination, opcode, EMPTY_PARAM);
    }

    public boolean equals(Object message) {
        if ((message instanceof HdmiCecMessage) == false) goto L17;
        HdmiCecMessage that = (HdmiCecMessage) message;
        if (this.mSource == that.getSource()) goto L7;
        return false;
    L7:
        if (this.mDestination == that.getDestination()) goto L9;
        return false;
    L9:
        if (this.mOpcode == that.getOpcode()) goto L11;
        return false;
    L11:
        if (Arrays.equals(this.mParams, that.getParams()) == true) goto L13;
        return false;
    L13:
        if (this.mValidationResult != that.getValidationResult()) goto L22;
        return true;
    L22:
        return false;
    L17:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mSource), Integer.valueOf(this.mDestination), Integer.valueOf(this.mOpcode), Integer.valueOf(Arrays.hashCode(this.mParams))});
    }

    public int getSource() {
        return this.mSource;
    }

    public int getDestination() {
        return this.mDestination;
    }

    public int getOpcode() {
        return this.mOpcode;
    }

    public byte[] getParams() {
        return this.mParams;
    }

    public int getValidationResult() {
        return this.mValidationResult;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("<%s> %X%X:%02X", new Object[]{opcodeToString(this.mOpcode), Integer.valueOf(this.mSource), Integer.valueOf(this.mDestination), Integer.valueOf(this.mOpcode)}));
        if (this.mParams.length <= 0) goto L15;
        if (filterMessageParameters(this.mOpcode) == false) goto L7;
        s.append(String.format(" <Redacted len=%d>", new Object[]{Integer.valueOf(this.mParams.length)}));
        goto L15
    L7:
        int r2 = 0;
        if (isUserControlPressedMessage(this.mOpcode) == false) goto L10;
        s.append(String.format(" <Keycode type = %s>", new Object[]{HdmiCecKeycode.getKeycodeType(this.mParams[0])}));
        goto L15
    L10:
        byte[] r1 = this.mParams;
        int r3 = r1.length;
    L12:
        if (r2 >= r3) goto L15;
        byte data = r1[r2];
        s.append(String.format(":%02X", new Object[]{Byte.valueOf(data)}));
        r2 = r2 + 1;
    L15:
        if (this.mValidationResult == 0) goto L18;
        s.append(String.format(" <Validation error: %s>", new Object[]{validationResultToString(this.mValidationResult)}));
    L18:
        return s.toString();
    }

    private static String validationResultToString(int validationResult) {
        switch(validationResult) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown error";
    L5:
        return "short parameters";
    L7:
        return "invalid parameters";
    L9:
        return "invalid destination";
    L11:
        return "invalid source";
    L13:
        return "ok";
    }

    private static String opcodeToString(int opcode) {
        switch(opcode) {
            case 0: goto L155;
            case 4: goto L153;
            case 5: goto L151;
            case 6: goto L149;
            case 7: goto L147;
            case 8: goto L145;
            case 9: goto L143;
            case 10: goto L141;
            case 11: goto L139;
            case 13: goto L137;
            case 15: goto L135;
            case 26: goto L133;
            case 27: goto L131;
            case 50: goto L129;
            case 51: goto L127;
            case 52: goto L125;
            case 53: goto L123;
            case 54: goto L121;
            case 65: goto L119;
            case 66: goto L117;
            case 67: goto L115;
            case 68: goto L113;
            case 69: goto L111;
            case 70: goto L109;
            case 71: goto L107;
            case 100: goto L105;
            case 103: goto L103;
            case 112: goto L101;
            case 113: goto L99;
            case 114: goto L97;
            case 115: goto L95;
            case 122: goto L93;
            case 125: goto L91;
            case 126: goto L89;
            case 128: goto L87;
            case 129: goto L85;
            case 130: goto L83;
            case 131: goto L81;
            case 132: goto L79;
            case 133: goto L77;
            case 134: goto L75;
            case 135: goto L73;
            case 137: goto L71;
            case 138: goto L69;
            case 139: goto L67;
            case 140: goto L65;
            case 141: goto L63;
            case 142: goto L61;
            case 143: goto L59;
            case 144: goto L57;
            case 145: goto L55;
            case 146: goto L53;
            case 147: goto L51;
            case 151: goto L49;
            case 153: goto L47;
            case 154: goto L45;
            case 157: goto L43;
            case 158: goto L41;
            case 159: goto L39;
            case 160: goto L37;
            case 161: goto L35;
            case 162: goto L33;
            case 163: goto L31;
            case 164: goto L29;
            case 165: goto L27;
            case 166: goto L25;
            case 167: goto L23;
            case 168: goto L21;
            case 192: goto L19;
            case 193: goto L17;
            case 194: goto L15;
            case 195: goto L13;
            case 196: goto L11;
            case 197: goto L9;
            case 248: goto L7;
            case 255: goto L5;
            default: goto L4;
        };
    L5:
        return "Abort";
    L7:
        return "Cdc Message";
    L9:
        return "Terminate ARC";
    L11:
        return "Request ARC Termination";
    L13:
        return "Request ARC Initiation";
    L15:
        return "Report ARC Terminated";
    L17:
        return "Report ARC Initiated";
    L19:
        return "Initiate ARC";
    L21:
        return "Report Current Latency";
    L23:
        return "Request Current Latency";
    L25:
        return "Report Features";
    L27:
        return "Give Features";
    L29:
        return "Request Short Audio Descriptor";
    L31:
        return "Report Short Audio Descriptor";
    L33:
        return "Set External Timer";
    L35:
        return "Clear External Timer";
    L37:
        return "Vendor Command With Id";
    L39:
        return "Get Cec Version";
    L41:
        return "Cec Version";
    L43:
        return "InActive Source";
    L45:
        return "Set Audio Rate";
    L47:
        return "Clear Digital Timer";
    L49:
        return "Set Digital Timer";
    L51:
        return "Select Digital Service";
    L53:
        return "Select Analog Service";
    L55:
        return "Get Menu Language";
    L57:
        return "Report Power Status";
    L59:
        return "Give Device Power Status";
    L61:
        return "Menu Status";
    L63:
        return "Menu Request";
    L65:
        return "Give Device Vendor Id";
    L67:
        return "Vendor Remote Button Up";
    L69:
        return "Vendor Remote Button Down";
    L71:
        return "Vendor Command";
    L73:
        return "Device Vendor Id";
    L75:
        return "Set Stream Path";
    L77:
        return "Request Active Source";
    L79:
        return "Report Physical Address";
    L81:
        return "Give Physical Address";
    L83:
        return "Active Source";
    L85:
        return "Routing Information";
    L87:
        return "Routing Change";
    L89:
        return "System Audio Mode Status";
    L91:
        return "Give System Audio Mode Status";
    L93:
        return "Report Audio Status";
    L95:
        return "Set Audio Volume Level";
    L97:
        return "Set System Audio Mode";
    L99:
        return "Give Audio Status";
    L101:
        return "System Audio Mode Request";
    L103:
        return "Set Timer Program Title";
    L105:
        return "Set Osd String";
    L107:
        return "Set Osd Name";
    L109:
        return "Give Osd Name";
    L111:
        return "User Control Release";
    L113:
        return "User Control Pressed";
    L115:
        return "Timer Cleared Status";
    L117:
        return "Deck Control";
    L119:
        return "Play";
    L121:
        return "Standby";
    L123:
        return "Timer Status";
    L125:
        return "Set Analog Timer";
    L127:
        return "Clear Analog Timer";
    L129:
        return "Set Menu Language";
    L131:
        return "Deck Status";
    L133:
        return "Give Deck Status";
    L135:
        return "Record Tv Screen";
    L137:
        return "Text View On";
    L139:
        return "Record Off";
    L141:
        return "Record Status";
    L143:
        return "Record On";
    L145:
        return "Give Tuner Device Status";
    L147:
        return "Tuner Device Status";
    L149:
        return "Tuner Step Decrement";
    L151:
        return "Tuner Step Increment";
    L153:
        return "Image View On";
    L155:
        return "Feature Abort";
    L4:
        return String.format("Opcode: %02X", new Object[]{Integer.valueOf(opcode)});
    }

    private static boolean filterMessageParameters(int opcode) {
        switch(opcode) {
            case 69: goto L5;
            case 71: goto L5;
            case 100: goto L5;
            case 137: goto L5;
            case 138: goto L5;
            case 139: goto L5;
            case 160: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    private static boolean isUserControlPressedMessage(int opcode) {
        if (68 != opcode) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isCecTransportMessage(int opcode) {
        switch(opcode) {
            case 167: goto L5;
            case 168: goto L5;
            case 248: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }
}
