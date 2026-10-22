package com.byted.cast.render.parser;

import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.byted.cast.render.utils.Logger;
import com.byted.cast.render.utils.NALBitstream;

/* JADX INFO: loaded from: classes43.dex */
public class golomb {
    private static final String TAG = "golomb";
    public int nStartBit;

    /* JADX INFO: renamed from: com.byted.cast.render.parser.golomb$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId = null;

        static {
            int[] r100 = new int[CodecId.values().length];
            $SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId = r100;
            r100[CodecId.H264.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId[CodecId.H265.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public golomb() {
        this.nStartBit = 0;
    }

    public SPS ParseH264(byte[] r110) {
        int r100 = 0;
        this.nStartBit = 0;
        SPS r101 = new SPS();
        skip_bits(32);
        skip_bits(1);
        skip_bits(2);
        if (read_u(5, r110) != 7) goto L95;
        r101.profile_idc = read_u(8, r110);
        skip_bits(8);
        r101.level_idc = read_u(8, r110);
        read_ue(r110);
        int r102 = r101.profile_idc;
        if (r102 != 100) goto L7;
    L28:
        int r103 = read_ue(r110);
        r101.chroma_format_idc = r103;
        if (r103 != 3) goto L31;
        skip_bits(1);
    L34:
        read_ue(r110);
        read_ue(r110);
        skip_bits(1);
        if (read_u(1, r110) == 1) goto L37;
    L57:
        read_ue(r110);
        int r104 = read_ue(r110);
        r101.pic_order_cnt_type = r104;
        if (r104 != 0) goto L60;
        read_ue(r110);
    L68:
        read_ue(r110);
        skip_bits(1);
        r101.mb_width = read_ue(r110) + 1;
        r101.mb_height = read_ue(r110) + 1;
        r101.frame_mbs_only_flag = read_u(1, r110);
        Logger.d(TAG, " mb_width=" + r101.mb_width + "  mb_height=" + r101.mb_height);
        if (r101.frame_mbs_only_flag != 0) goto L71;
        skip_bits(1);
    L71:
        skip_bits(1);
        int r105 = read_u(1, r110);
        r101.crop = r105;
        if (r105 == 0) goto L94;
        int r106 = read_ue(r110);
        int r107 = read_ue(r110);
        int r108 = read_ue(r110);
        int r111 = read_ue(r110);
        int r109 = r101.mb_width * 16;
        int r112 = r101.mb_height * 16;
        int r113 = r101.chroma_format_idc;
        if (r113 != 1) goto L76;
        int r114 = 1;
    L77:
        if (r113 == 1) goto L79;
        if (r113 == 2) goto L79;
    L80:
        int r115 = 1 << r100;
        int r116 = (2 - r101.frame_mbs_only_flag) << r114;
        int r117 = 536870911 / r115;
        if (r106 > r117) goto L92;
        if (r107 > r117) goto L92;
        int r118 = 536870911 / r116;
        if (r108 > r118) goto L92;
        if (r111 > r118) goto L92;
        if (((r106 + r107) * r115) >= r109) goto L92;
        if (((r108 + r111) * r116) >= r112) goto L92;
        r101.crop_left = r106 * r115;
        r101.crop_right = r107 * r115;
        r101.crop_top = r108 * r116;
        r101.crop_bottom = r111 * r116;
    L96:
        r101.width = ((r101.mb_width * 16) - r101.crop_left) - r101.crop_right;
        r101.height = ((r101.mb_height * 16) - r101.crop_top) - r101.crop_bottom;
        r101.bVaild = true;
        Logger.i(TAG, " w=" + r101.width + " h=" + r101.height);
        return r101;
    L92:
        Logger.e(TAG, " overrun crop");
        return r101;
    L79:
        r100 = 1;
        goto L80
    L76:
        r114 = 0;
        goto L77
    L94:
        r101.crop_left = 0;
        r101.crop_right = 0;
        r101.crop_top = 0;
        r101.crop_bottom = 0;
        goto L96
    L60:
        if (r104 != 1) goto L65;
        Integer r119 = Integer.valueOf(read_ue(r110));
        int r120 = 0;
    L63:
        if (r120 >= r119.intValue()) goto L68;
        read_se(r110);
        r120 = r120 + 1;
        goto L63
    L65:
        if (r104 == 2) goto L68;
        Logger.e(TAG, " pic_order_cnt_type=" + r101.pic_order_cnt_type);
        return r101;
    L37:
        if (r101.chroma_format_idc == 3) goto L39;
        int r121 = 8;
    L40:
        int r122 = 0;
    L41:
        if (r122 >= r121) goto L57;
        if (read_u(1, r110) != 1) goto L56;
        int r123 = 0;
        int r124 = 8;
        int r125 = 8;
    L46:
        if (r122 >= 6) goto L48;
        int r126 = 16;
    L49:
        if (r123 >= r126) goto L56;
        if (r124 == 0) goto L52;
        r124 = ((read_se(r110) + r125) + 256) % 256;
    L52:
        if (r124 == 0) goto L55;
        r125 = r124;
    L55:
        r123 = r123 + 1;
        goto L46
    L48:
        r126 = 64;
    L56:
        r122 = r122 + 1;
        goto L41
    L39:
        r121 = 12;
        goto L40
    L31:
        if (r103 <= 3) goto L34;
        Logger.e(TAG, " chroma_format_idc=" + r101.chroma_format_idc);
        return r101;
    L7:
        if (r102 == 110) goto L28;
        if (r102 == 122) goto L28;
        if (r102 == 244) goto L28;
        if (r102 == 44) goto L28;
        if (r102 == 83) goto L28;
        if (r102 == 86) goto L28;
        if (r102 == 118) goto L28;
        if (r102 == 128) goto L28;
        if (r102 == 138) goto L28;
        if (r102 == 144) goto L28;
        r101.chroma_format_idc = 1;
        r101.bit_depth_chroma = 8;
        r101.bit_depth_luma = 8;
        goto L57
    L95:
        Logger.e(TAG, " ......369");
        goto L96
    }

    public int read_se(byte[] r100) {
        int r101 = read_ue(r100);
        if ((r101 & 1) == 0) goto L6;
        return (r101 + 1) / 2;
    L6:
        return -(r101 / 2);
    }

    public int read_ue(byte[] r100) {
        int r101 = 0;
    L3:
        int r102 = this.nStartBit;
        if (r102 >= (r100.length * 8)) goto L9;
        if ((r100[r102 / 8] & (128 >> (r102 % 8))) != 0) goto L9;
        r101 = r101 + 1;
        this.nStartBit = r102 + 1;
    L9:
        this.nStartBit = r102 + 1;
        return ((1 << r101) - 1) + read_u(r101, r100);
    }

    public void skip_bits(int r100) {
        this.nStartBit += r100;
    }

    public SPS Parse(byte[] r100, CodecId r101) {
        int r102 = AnonymousClass1.$SwitchMap$com$byted$cast$mediacommon$render$parameters$CodecId[r101.ordinal()];
        int r103 = 4;
        int r104 = 0;
        if (r102 == 1) goto L47;
        if (r102 != 2) goto L64;
        if (((r100[4] & 126) >> 1) != 32) goto L64;
    L11:
        if (r103 >= r100.length) goto L22;
        if (r100[r103 + 0] != 0) goto L21;
        if (r100[r103 + 1] != 0) goto L21;
        if (r100[r103 + 2] != 0) goto L21;
        if (r100[r103 + 3] != 1) goto L21;
    L23:
        if (r103 == 0) goto L64;
        int r105 = r103 + 4;
        if (((r100[r105] & 126) >> 1) != 33) goto L64;
        int r106 = r105;
    L30:
        if (r106 >= r100.length) goto L41;
        if (r100[r106 + 0] != 0) goto L40;
        if (r100[r106 + 1] != 0) goto L40;
        if (r100[r106 + 2] != 0) goto L40;
        if (r100[r106 + 3] != 1) goto L40;
        r104 = r106;
    L40:
        r106 = r106 + 1;
    L41:
        if (r104 != 0) goto L45;
        if ((r100[r105] & 126) != 33) goto L64;
    L45:
        return ParseSequenceParameterSet(r100, r103);
    L21:
        r103 = r103 + 1;
        goto L11
    L22:
        r103 = 0;
    L64:
        return new SPS();
    L47:
        if ((r100[4] & 31) != 7) goto L64;
    L49:
        if (r103 >= r100.length) goto L60;
        if (r100[r103 + 0] != 0) goto L59;
        if (r100[r103 + 1] != 0) goto L59;
        if (r100[r103 + 2] != 0) goto L59;
        if (r100[r103 + 3] != 1) goto L59;
        r104 = r103;
    L59:
        r103 = r103 + 1;
    L60:
        if (r104 == 0) goto L64;
        return ParseH264(r100);
    }

    public SPS ParseSequenceParameterSet(byte[] r110, int r111) {
        SPS r100 = new SPS();
        if (r110.length >= 20) goto L6;
        Logger.e(TAG, "ParseSequenceParameterSet data.length<20");
        return r100;
    L6:
        NALBitstream r101 = new NALBitstream(r110, r111);
        r101.GetWord(32);
        r101.GetWord(16);
        r101.GetWord(4);
        int r102 = r101.GetWord(3);
        if (r102 <= 6) goto L10;
        Logger.e(TAG, "sps_max_sub_layers_minus1>6");
        return r100;
    L10:
        r101.GetWord(1);
        int r103 = 2;
        r101.GetWord(2);
        r101.GetWord(1);
        r100.profile_idc = r101.GetWord(5);
        r101.GetWord(32);
        r101.GetWord(1);
        r101.GetWord(1);
        r101.GetWord(1);
        r101.GetWord(1);
        r101.GetWord(44);
        r100.level_idc = r101.GetWord(8);
        byte[] r112 = new byte[6];
        byte[] r104 = new byte[6];
        int r113 = 0;
        int r114 = 0;
    L11:
        if (r114 >= r102) goto L13;
        r112[r114] = (byte) r101.GetWord(1);
        r104[r114] = (byte) r101.GetWord(1);
        r114 = r114 + 1;
        goto L11
    L13:
        if (r102 <= 0) goto L17;
        int r115 = r102;
    L15:
        if (r115 >= 8) goto L17;
        r101.GetWord(2);
        r115 = r115 + 1;
    L17:
        if (r113 >= r102) goto L26;
        if (r112[r113] == 0) goto L22;
        r101.GetWord(2);
        r101.GetWord(1);
        r101.GetWord(5);
        r101.GetWord(32);
        r101.GetWord(1);
        r101.GetWord(1);
        r101.GetWord(1);
        r101.GetWord(1);
        r101.GetWord(44);
    L22:
        if (r104[r113] == 0) goto L24;
        r101.GetWord(8);
    L24:
        r113 = r113 + 1;
        goto L17
    L26:
        if (r101.GetUE() <= 15) goto L29;
        Logger.e(TAG, "sps_seq_parameter_set_id>15");
        return r100;
    L29:
        int r105 = r101.GetUE();
        if (r105 <= 3) goto L33;
        Logger.e(TAG, "chroma_format_idc>3   " + r105);
        return r100;
    L33:
        if (r105 != 3) goto L35;
        r101.GetWord(1);
    L35:
        r100.width = r101.GetUE();
        r100.height = r101.GetUE();
        Logger.i(TAG, "width=" + r100.width + " height=" + r100.height);
        int r106 = r101.GetWord(1);
        Logger.i(TAG, "width=" + r100.width + " height=" + r100.height + " flag=" + r106);
        if (r106 == 0) goto L48;
        int r107 = r101.GetUE();
        int r108 = r101.GetUE();
        int r109 = r101.GetUE();
        int r116 = r101.GetUE();
        if (r105 == 1) goto L42;
        if (r105 == 2) goto L42;
        int r117 = 1;
    L43:
        if (r105 == 1) goto L46;
        r103 = 1;
    L46:
        r100.width -= (r107 + r108) * r117;
        r100.height -= (r109 + r116) * r103;
        Logger.i(TAG, "modify width=" + r100.width + " height=" + r100.height + " factor:" + r117 + "&" + r103);
    L42:
        r117 = 2;
    L48:
        if (r101.GetUE() == r101.GetUE()) goto L51;
        Logger.e(TAG, "bit_depth_luma_minus8 != bit_depth_chroma_minus8");
        return r100;
    L51:
        r100.bVaild = true;
        return r100;
    }

    public int read_u(int r100, byte[] r101) {
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r100) goto L8;
        r103 = r103 << 1;
        int r104 = this.nStartBit;
        if ((r101[r104 / 8] & (128 >> (r104 % 8))) == 0) goto L7;
        r103 = r103 + 1;
    L7:
        this.nStartBit = r104 + 1;
        r102 = r102 + 1;
        goto L3
    L8:
        return r103;
    }
}
