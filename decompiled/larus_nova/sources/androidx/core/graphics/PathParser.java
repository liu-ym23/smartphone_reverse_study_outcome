package androidx.core.graphics;

import android.graphics.Path;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        public ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public PathDataNode(PathDataNode r100) {
            this.mType = r100.mType;
            float[] r101 = r100.mParams;
            this.mParams = PathParser.copyOfRange(r101, 0, r101.length);
        }

        public static /* synthetic */ char access$000(PathDataNode r100) {
            return r100.mType;
        }

        public static /* synthetic */ float[] access$100(PathDataNode r100) {
            return r100.mParams;
        }

        public PathDataNode(char r100, float[] r101) {
            this.mType = r100;
            this.mParams = r101;
        }

        public static /* synthetic */ char access$002(PathDataNode r100, char r101) {
            r100.mType = r101;
            return r101;
        }

        public static void nodesToPath(PathDataNode[] r100, Path r101) {
            PathParser.nodesToPath(r100, r101);
        }

        public void interpolatePathDataNode(PathDataNode r100, PathDataNode r101, float r102) {
            this.mType = r100.mType;
            int r103 = 0;
        L3:
            float[] r104 = r100.mParams;
            if (r103 >= r104.length) goto L6;
            this.mParams[r103] = (r104[r103] * (1.0f - r102)) + (r101.mParams[r103] * r102);
            r103 = r103 + 1;
            goto L3
        }

        public static /* synthetic */ void access$200(Path r100, float[] r101, char r102, char r103, float[] r104) {
            addCommand(r100, r101, r102, r103, r104);
        }

        private static void addCommand(Path r210, float[] r211, char r212, char r213, float[] r214) {
            char r110 = r213;
            float r100 = r211[0];
            float r101 = r211[1];
            float r102 = r211[2];
            float r103 = r211[3];
            float r104 = r211[4];
            float r105 = r211[5];
            switch(r110) {
                case 65: goto L9;
                case 67: goto L8;
                case 72: goto L7;
                case 76: goto L4;
                case 77: goto L4;
                case 81: goto L6;
                case 83: goto L6;
                case 84: goto L4;
                case 86: goto L7;
                case 90: goto L5;
                case 97: goto L9;
                case 99: goto L8;
                case 104: goto L7;
                case 108: goto L4;
                case 109: goto L4;
                case 113: goto L6;
                case 115: goto L6;
                case 116: goto L4;
                case 118: goto L7;
                case 122: goto L5;
                default: goto L4;
            };
        L4:
            int r111 = 2;
        L10:
            float r106 = r100;
            float r107 = r101;
            float r215 = r104;
            float r216 = r105;
            int r108 = 0;
            char r109 = r212;
        L12:
            if (r108 >= r214.length) goto L122;
            if (r110 != 'A') goto L16;
            int r217 = r108;
            float r112 = r107;
            float r113 = r106;
            int r114 = r217 + 5;
            float r115 = r214[r114];
            int r116 = r217 + 6;
            float r117 = r214[r116];
            float r118 = r214[r217 + 0];
            float r119 = r214[r217 + 1];
            float r120 = r214[r217 + 2];
            if (r214[r217 + 3] == 0.0f) goto L114;
            boolean r121 = true;
        L116:
            if (r214[r217 + 4] == 0.0f) goto L118;
            boolean r122 = true;
        L119:
            drawArc(r210, r113, r112, r115, r117, r118, r119, r120, r121, r122);
            r106 = r214[r114];
            r107 = r214[r116];
        L120:
            r103 = r107;
            r102 = r106;
        L121:
            r108 = r217 + r111;
            r109 = r213;
            r110 = r109;
            goto L12
        L118:
            r122 = false;
            goto L119
        L114:
            r121 = false;
            goto L116
        L16:
            if (r110 != 'C') goto L18;
            r217 = r108;
            float r123 = r214[r217 + 0];
            float r124 = r214[r217 + 1];
            int r125 = r217 + 2;
            int r126 = r217 + 3;
            int r127 = r217 + 4;
            int r128 = r217 + 5;
            r210.cubicTo(r123, r124, r214[r125], r214[r126], r214[r127], r214[r128]);
            r106 = r214[r127];
            float r129 = r214[r128];
            float r130 = r214[r125];
            float r131 = r214[r126];
            r107 = r129;
            r103 = r131;
            r102 = r130;
            goto L121
        L18:
            if (r110 != 'H') goto L20;
            r217 = r108;
            int r132 = r217 + 0;
            float r133 = r214[r132];
            r210.lineTo(r133, r107);
            r106 = r214[r132];
            goto L121
        L20:
            if (r110 != 'Q') goto L22;
            r217 = r108;
            int r134 = r217 + 0;
            int r135 = r217 + 1;
            int r136 = r217 + 2;
            int r137 = r217 + 3;
            r210.quadTo(r214[r134], r214[r135], r214[r136], r214[r137]);
            float r138 = r214[r134];
            float r139 = r214[r135];
            r106 = r214[r136];
            r107 = r214[r137];
            r102 = r138;
            r103 = r139;
            goto L121
        L22:
            if (r110 != 'V') goto L24;
            r217 = r108;
            int r140 = r217 + 0;
            r210.lineTo(r106, r214[r140]);
            r107 = r214[r140];
            goto L121
        L24:
            if (r110 != 'a') goto L26;
            int r141 = r108 + 5;
            float r142 = r214[r141] + r106;
            int r143 = r108 + 6;
            float r144 = r214[r143] + r107;
            float r145 = r214[r108 + 0];
            float r146 = r214[r108 + 1];
            float r147 = r214[r108 + 2];
            if (r214[r108 + 3] == 0.0f) goto L101;
            boolean r218 = true;
        L103:
            if (r214[r108 + 4] == 0.0f) goto L105;
            boolean r219 = true;
        L106:
            r217 = r108;
            float r148 = r107;
            float r149 = r106;
            drawArc(r210, r106, r107, r142, r144, r145, r146, r147, r218, r219);
            r106 = r149 + r214[r141];
            r107 = r148 + r214[r143];
            goto L120
        L105:
            r219 = false;
            goto L106
        L101:
            r218 = false;
            goto L103
        L26:
            if (r110 != 'c') goto L28;
            int r150 = r108 + 2;
            int r151 = r108 + 3;
            int r152 = r108 + 4;
            int r220 = r108 + 5;
            r210.rCubicTo(r214[r108 + 0], r214[r108 + 1], r214[r150], r214[r151], r214[r152], r214[r220]);
            float r153 = r214[r150] + r106;
            float r154 = r214[r151] + r107;
            r106 = r106 + r214[r152];
            float r155 = r214[r220];
        L96:
            r107 = r107 + r155;
        L97:
            r102 = r153;
            r103 = r154;
        L47:
            r217 = r108;
            goto L121
        L28:
            if (r110 != 'h') goto L30;
            int r156 = r108 + 0;
            r210.rLineTo(r214[r156], 0.0f);
            r106 = r106 + r214[r156];
            goto L47
        L30:
            if (r110 != 'q') goto L32;
            int r157 = r108 + 0;
            int r158 = r108 + 1;
            int r159 = r108 + 2;
            int r160 = r108 + 3;
            r210.rQuadTo(r214[r157], r214[r158], r214[r159], r214[r160]);
            r153 = r214[r157] + r106;
            r154 = r214[r158] + r107;
            r106 = r106 + r214[r159];
            r155 = r214[r160];
            goto L96
        L32:
            if (r110 != 'v') goto L34;
            int r161 = r108 + 0;
            r210.rLineTo(0.0f, r214[r161]);
            float r162 = r214[r161];
        L71:
            r107 = r107 + r162;
            goto L47
        L34:
            if (r110 != 'L') goto L36;
            int r163 = r108 + 0;
            int r164 = r108 + 1;
            r210.lineTo(r214[r163], r214[r164]);
            r106 = r214[r163];
            r107 = r214[r164];
            goto L47
        L36:
            if (r110 != 'M') goto L38;
            r106 = r214[r108 + 0];
            r107 = r214[r108 + 1];
            if (r108 <= 0) goto L89;
            r210.lineTo(r106, r107);
            goto L47
        L89:
            r210.moveTo(r106, r107);
        L90:
            r217 = r108;
            r216 = r107;
            r215 = r106;
            goto L121
        L38:
            if (r110 != 'S') goto L40;
            if (r109 == 'c') goto L84;
            if (r109 == 's') goto L84;
            if (r109 == 'C') goto L84;
            if (r109 == 'S') goto L84;
        L85:
            float r165 = r107;
            int r166 = r108 + 0;
            int r167 = r108 + 1;
            int r168 = r108 + 2;
            int r169 = r108 + 3;
            r210.cubicTo(r106, r165, r214[r166], r214[r167], r214[r168], r214[r169]);
            r153 = r214[r166];
            r154 = r214[r167];
            r106 = r214[r168];
            r107 = r214[r169];
        L84:
            r106 = (r106 * 2.0f) - r102;
            r107 = (r107 * 2.0f) - r103;
            goto L85
        L40:
            if (r110 != 'T') goto L42;
            if (r109 == 'q') goto L76;
            if (r109 == 't') goto L76;
            if (r109 == 'Q') goto L76;
            if (r109 == 'T') goto L76;
        L77:
            int r170 = r108 + 0;
            int r171 = r108 + 1;
            r210.quadTo(r106, r107, r214[r170], r214[r171]);
            float r172 = r214[r170];
            float r173 = r214[r171];
            r217 = r108;
            r103 = r107;
            r102 = r106;
            r106 = r172;
            r107 = r173;
        L76:
            r106 = (r106 * 2.0f) - r102;
            r107 = (r107 * 2.0f) - r103;
            goto L77
        L42:
            if (r110 != 'l') goto L44;
            int r174 = r108 + 0;
            int r175 = r108 + 1;
            r210.rLineTo(r214[r174], r214[r175]);
            r106 = r106 + r214[r174];
            r162 = r214[r175];
            goto L71
        L44:
            if (r110 == 'm') goto L66;
            if (r110 == 's') goto L56;
            if (r110 != 't') goto L47;
            if (r109 == 'q') goto L54;
            if (r109 == 't') goto L54;
            if (r109 == 'Q') goto L54;
            if (r109 == 'T') goto L54;
            float r176 = 0.0f;
            float r177 = 0.0f;
        L55:
            int r178 = r108 + 0;
            int r179 = r108 + 1;
            r210.rQuadTo(r177, r176, r214[r178], r214[r179]);
            float r180 = r177 + r106;
            float r181 = r176 + r107;
            r106 = r106 + r214[r178];
            r107 = r107 + r214[r179];
            r103 = r181;
            r102 = r180;
        L54:
            r177 = r106 - r102;
            r176 = r107 - r103;
            goto L55
        L56:
            if (r109 == 'c') goto L64;
            if (r109 == 's') goto L64;
            if (r109 == 'C') goto L64;
            if (r109 == 'S') goto L64;
            float r182 = 0.0f;
            float r183 = 0.0f;
        L65:
            int r184 = r108 + 0;
            int r185 = r108 + 1;
            int r186 = r108 + 2;
            int r221 = r108 + 3;
            r210.rCubicTo(r182, r183, r214[r184], r214[r185], r214[r186], r214[r221]);
            r153 = r214[r184] + r106;
            r154 = r214[r185] + r107;
            r106 = r106 + r214[r186];
            r155 = r214[r221];
        L64:
            float r187 = r106 - r102;
            r183 = r107 - r103;
            r182 = r187;
            goto L65
        L66:
            float r188 = r214[r108 + 0];
            r106 = r106 + r188;
            float r189 = r214[r108 + 1];
            r107 = r107 + r189;
            if (r108 <= 0) goto L69;
            r210.rLineTo(r188, r189);
            goto L47
        L69:
            r210.rMoveTo(r188, r189);
            goto L90
        L122:
            r211[0] = r106;
            r211[1] = r107;
            r211[2] = r102;
            r211[3] = r103;
            r211[4] = r215;
            r211[5] = r216;
            return;
        L5:
            r210.close();
            r210.moveTo(r104, r105);
            r100 = r104;
            r102 = r100;
            r101 = r105;
            r103 = r101;
            goto L4
        L6:
            r111 = 4;
            goto L10
        L7:
            r111 = 1;
            goto L10
        L8:
            r111 = 6;
            goto L10
        L9:
            r111 = 7;
            goto L10
        }

        private static void arcToBezier(Path r410, double r510, double r511, double r512, double r513, double r514, double r610, double r611, double r612, double r613) {
            double r100 = r512;
            int r101 = (int) Math.ceil(Math.abs((r613 * 4.0d) / 3.141592653589793d));
            double r102 = Math.cos(r611);
            double r103 = Math.sin(r611);
            double r104 = Math.cos(r612);
            double r110 = Math.sin(r612);
            double r111 = -r100;
            double r112 = r111 * r102;
            double r113 = r513 * r103;
            double r114 = (r112 * r110) - (r113 * r104);
            double r115 = r111 * r103;
            double r210 = r513 * r102;
            double r116 = (r110 * r115) + (r104 * r210);
            double r105 = r613 / ((double) r101);
            double r211 = r612;
            double r212 = r116;
            double r213 = r114;
            int r106 = 0;
            double r117 = r514;
            double r118 = r610;
        L3:
            if (r106 >= r101) goto L5;
            double r310 = r211 + r105;
            double r311 = Math.sin(r310);
            double r312 = Math.cos(r310);
            double r107 = (r510 + ((r100 * r102) * r312)) - (r113 * r311);
            double r108 = (r511 + ((r100 * r103) * r312)) + (r210 * r311);
            double r313 = (r112 * r311) - (r113 * r312);
            double r314 = (r311 * r115) + (r312 * r210);
            double r214 = r310 - r211;
            double r315 = Math.tan(r214 / 2.0d);
            double r215 = (Math.sin(r214) * (Math.sqrt(((r315 * 3.0d) * r315) + 4.0d) - 1.0d)) / 3.0d;
            double r119 = r117 + (r213 * r215);
            double r216 = r102;
            double r109 = r118 + (r212 * r215);
            double r614 = r103;
            double r120 = r107 - (r215 * r313);
            double r515 = r105;
            r410.rLineTo(0.0f, 0.0f);
            r410.cubicTo((float) r119, (float) r109, (float) r120, (float) (r108 - (r215 * r314)), (float) r107, (float) r108);
            r106 = r106 + 1;
            r105 = r515;
            r103 = r614;
            r117 = r107;
            r115 = r115;
            r102 = r216;
            r211 = r310;
            r212 = r314;
            r213 = r313;
            r101 = r101;
            r118 = r108;
            r100 = r512;
            goto L3
        }

        private static void drawArc(Path r410, float r411, float r412, float r413, float r414, float r415, float r416, float r417, boolean r418, boolean r510) {
            double r110 = Math.toRadians(r417);
            double r100 = Math.cos(r110);
            double r111 = Math.sin(r110);
            double r112 = r411;
            double r113 = r112 * r100;
            double r114 = r412;
            double r101 = r415;
            double r115 = (r113 + (r114 * r111)) / r101;
            double r102 = (((double) (-r411)) * r111) + (r114 * r100);
            double r116 = r416;
            double r103 = r102 / r116;
            double r104 = r414;
            double r105 = ((((double) r413) * r100) + (r104 * r111)) / r101;
            double r106 = ((((double) (-r413)) * r111) + (r104 * r100)) / r116;
            double r107 = r115 - r105;
            double r210 = r103 - r106;
            double r211 = (r115 + r105) / 2.0d;
            double r310 = (r103 + r106) / 2.0d;
            double r311 = (r107 * r107) + (r210 * r210);
            if (r311 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
            return;
        L5:
            double r312 = (1.0d / r311) - 0.25d;
            if (r312 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
            float r108 = (float) (Math.sqrt(r311) / 1.99999d);
            drawArc(r410, r411, r412, r413, r414, r415 * r108, r416 * r108, r417, r418, r510);
            return;
        L9:
            double r313 = Math.sqrt(r312);
            double r109 = r107 * r313;
            double r314 = r313 * r210;
            if (r418 != r510) goto L12;
            double r212 = r211 - r314;
            double r315 = r310 + r109;
        L13:
            double r213 = Math.atan2(r103 - r315, r115 - r212);
            double r117 = Math.atan2(r106 - r315, r105 - r212) - r213;
            if (r117 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
            boolean r118 = true;
        L17:
            if (r510 != r118) goto L19;
        L22:
            double r214 = r212 * r101;
            double r316 = r315 * r116;
            arcToBezier(r410, (r214 * r100) - (r316 * r111), (r214 * r111) + (r316 * r100), r101, r116, r112, r114, r110, r213, r117);
            return;
        L19:
            if (r117 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
            r117 = r117 - 6.283185307179586d;
            goto L22
        L21:
            r117 = r117 + 6.283185307179586d;
            goto L22
        L16:
            r118 = false;
            goto L17
        L12:
            r212 = r211 + r314;
            r315 = r310 - r109;
            goto L13
        }
    }

    private PathParser() {
    }

    public static PathDataNode[] createNodesFromPathData(String r100) {
        ArrayList r101 = new ArrayList();
        int r102 = 1;
        int r103 = 0;
    L4:
        if (r102 >= r100.length()) goto L10;
        int r104 = nextStart(r100, r102);
        String r105 = r100.substring(r103, r104).trim();
        if (r105.isEmpty() == true) goto L8;
        float[] r106 = getFloats(r105);
        addNode(r101, r105.charAt(0), r106);
    L8:
        r103 = r104;
        r102 = r104 + 1;
        goto L4
    L10:
        if ((r102 - r103) != 1) goto L15;
        if (r103 >= r100.length()) goto L15;
        addNode(r101, r100.charAt(r103), new float[0]);
    L15:
        return (PathDataNode[]) r101.toArray(new PathDataNode[0]);
    }

    public static Path createPathFromPathData(String r100) {
        Path r101 = new Path();
        PathDataNode.nodesToPath(createNodesFromPathData(r100), r101);     // Catch: RuntimeException -> L5
        return r101;
    L5:
        e = move-exception;
        throw new RuntimeException("Error in parsing " + r100, e);
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] r100) {
        PathDataNode[] r101 = new PathDataNode[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = new PathDataNode(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    private static float[] getFloats(String r100) {
        if (r100.charAt(0) == 'z') goto L22;
        if (r100.charAt(0) == 'Z') goto L22;
        float[] r101 = new float[r100.length()];     // Catch: NumberFormatException -> L18
        ExtractFloatResult r102 = new ExtractFloatResult();     // Catch: NumberFormatException -> L18
        int r103 = r100.length();     // Catch: NumberFormatException -> L18
        int r104 = 1;
        int r105 = 0;
    L8:
        if (r104 >= r103) goto L16;
        extract(r100, r104, r102);     // Catch: NumberFormatException -> L18
        int r106 = r102.mEndPosition;     // Catch: NumberFormatException -> L18
        if (r104 >= r106) goto L13;
        r101[r105] = CastFloatProtector.parseFloat(r100.substring(r104, r106));     // Catch: NumberFormatException -> L18
        r105 = r105 + 1;     // Catch: NumberFormatException -> L18
    L13:
        if (r102.mEndWithNegOrDot == true) goto L14;
        r104 = r106 + 1;     // Catch: NumberFormatException -> L18
        goto L8
    L14:
        r104 = r106;
        goto L8
    L16:
        return copyOfRange(r101, 0, r105);
    L18:
        e = move-exception;
        throw new RuntimeException("error in parsing \"" + r100 + "\"", e);
    L22:
        return new float[0];
    }

    public static boolean canMorph(PathDataNode[] r100, PathDataNode[] r101) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        if (r100.length == r101.length) goto L9;
        return false;
    L9:
        int r102 = 0;
    L11:
        if (r102 >= r100.length) goto L19;
        if (PathDataNode.access$000(r100[r102]) != PathDataNode.access$000(r101[r102])) goto L18;
        if (PathDataNode.access$100(r100[r102]).length != PathDataNode.access$100(r101[r102]).length) goto L18;
        r102 = r102 + 1;
    L18:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    private static int nextStart(String r100, int r101) {
    L3:
        if (r101 >= r100.length()) goto L14;
        char r102 = r100.charAt(r101);
        if (((r102 - 'A') * (r102 - 'Z')) <= 0) goto L9;
        if (((r102 - 'a') * (r102 - 'z')) <= 0) goto L9;
    L13:
        r101 = r101 + 1;
    L9:
        if (r102 == 'e') goto L13;
        if (r102 == 'E') goto L13;
        return r101;
    L14:
        return r101;
    }

    public static void nodesToPath(PathDataNode[] r100, Path r101) {
        float[] r102 = new float[6];
        int r103 = r100.length;
        char r104 = 'm';
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        PathDataNode r106 = r100[r105];
        PathDataNode.access$200(r101, r102, r104, PathDataNode.access$000(r106), PathDataNode.access$100(r106));
        r104 = PathDataNode.access$000(r106);
        r105 = r105 + 1;
        goto L3
    }

    public static void updateNodes(PathDataNode[] r100, PathDataNode[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L10;
        PathDataNode.access$002(r100[r102], PathDataNode.access$000(r101[r102]));
        int r103 = 0;
    L7:
        if (r103 >= PathDataNode.access$100(r101[r102]).length) goto L9;
        PathDataNode.access$100(r100[r102])[r103] = PathDataNode.access$100(r101[r102])[r103];
        r103 = r103 + 1;
        goto L7
    L9:
        r102 = r102 + 1;
        goto L4
    }

    private static void addNode(ArrayList<PathDataNode> r100, char r101, float[] r102) {
        r100.add(new PathDataNode(r101, r102));
    }

    public static float[] copyOfRange(float[] r100, int r101, int r102) {
        if (r101 > r102) goto L11;
        int r103 = r100.length;
        if (r101 < 0) goto L9;
        if (r101 > r103) goto L9;
        int r104 = r102 - r101;
        int r105 = Math.min(r104, r103 - r101);
        float[] r106 = new float[r104];
        System.arraycopy(r100, r101, r106, 0, r105);
        return r106;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException();
    }

    private static void extract(String r100, int r101, ExtractFloatResult r110) {
        r110.mEndWithNegOrDot = false;
        int r102 = r101;
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
    L4:
        if (r102 >= r100.length()) goto L25;
        char r106 = r100.charAt(r102);
        if (r106 != ' ') goto L8;
    L21:
        r103 = false;
        r105 = true;
    L22:
        if (r105 == true) goto L25;
        r102 = r102 + 1;
        goto L4
    L8:
        if (r106 != 'E') goto L10;
    L20:
        r103 = true;
        goto L22
    L10:
        if (r106 == 'e') goto L20;
        switch(r106) {
            case 44: goto L21;
            case 45: goto L16;
            case 46: goto L13;
            default: goto L19;
        };
    L13:
        if (r104 == true) goto L15;
        r103 = false;
        r104 = true;
        goto L22
    L15:
        r110.mEndWithNegOrDot = true;
        goto L21
    L16:
        if (r102 == r101) goto L19;
        if (r103 == true) goto L19;
        r110.mEndWithNegOrDot = true;
    L19:
        r103 = false;
    L25:
        r110.mEndPosition = r102;
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] r100, PathDataNode[] r101, PathDataNode[] r102, float r103) {
        if (r100.length != r101.length) goto L15;
        if (r101.length != r102.length) goto L15;
        int r104 = 0;
        if (canMorph(r101, r102) == true) goto L10;
        return false;
    L10:
        if (r104 >= r100.length) goto L12;
        r100[r104].interpolatePathDataNode(r101[r104], r102[r104], r103);
        r104 = r104 + 1;
        goto L10
    L12:
        return true;
    L15:
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }

    public static void interpolatePathDataNodes(PathDataNode[] r100, float r101, PathDataNode[] r102, PathDataNode[] r103) {
        if (interpolatePathDataNodes(r100, r102, r103, r101) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
