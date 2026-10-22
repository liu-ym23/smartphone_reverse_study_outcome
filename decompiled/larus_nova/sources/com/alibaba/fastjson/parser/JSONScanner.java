package com.alibaba.fastjson.parser;

import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes28.dex */
public final class JSONScanner extends JSONLexerBase {
    private final int len;
    private final String text;

    public static boolean checkDate(char r100, char r101, char r102, char r103, char r104, char r105, int r106, int r110) {
        if (r100 >= '0') goto L5;
    L43:
        return false;
    L5:
        if (r100 > '9') goto L43;
        if (r101 < '0') goto L43;
        if (r101 > '9') goto L43;
        if (r102 < '0') goto L43;
        if (r102 > '9') goto L43;
        if (r103 < '0') goto L43;
        if (r103 > '9') goto L43;
        if (r104 != '0') goto L21;
        if (r105 < '1') goto L20;
        if (r105 > '9') goto L20;
    L26:
        if (r106 != 48) goto L30;
        if (r110 < 49) goto L29;
        if (r110 > 57) goto L29;
        return true;
    L29:
        return false;
    L30:
        if (r106 == 49) goto L38;
        if (r106 == 50) goto L38;
        if (r106 != 51) goto L37;
        if (r110 == 48) goto L44;
        if (r110 != 49) goto L37;
        return true;
    L44:
        return true;
    L37:
        return false;
    L38:
        if (r110 < 48) goto L43;
        if (r110 > 57) goto L43;
        return true;
    L20:
        return false;
    L21:
        if (r104 != '1') goto L43;
        if (r105 == '0') goto L26;
        if (r105 == '1') goto L26;
        if (r105 == '2') goto L26;
        return false;
    }

    private boolean checkTime(char r100, char r101, char r102, char r103, char r104, char r110) {
        if (r100 != '0') goto L8;
        if (r101 < '0') goto L6;
        if (r101 > '9') goto L6;
    L19:
        if (r102 < '0') goto L24;
        if (r102 > '5') goto L24;
        if (r103 < '0') goto L23;
        if (r103 > '9') goto L23;
    L27:
        if (r104 < '0') goto L32;
        if (r104 > '5') goto L32;
        if (r110 < '0') goto L31;
        if (r110 > '9') goto L31;
        return true;
    L31:
        return false;
    L32:
        if (r104 != '6') goto L37;
        if (r110 == '0') goto L38;
        return false;
    L38:
        return true;
    L37:
        return false;
    L23:
        return false;
    L24:
        if (r102 != '6') goto L37;
        if (r103 == '0') goto L27;
        return false;
    L6:
        return false;
    L8:
        if (r100 != '1') goto L13;
        if (r101 < '0') goto L11;
        if (r101 <= '9') goto L19;
    L11:
        return false;
    L13:
        if (r100 != '2') goto L37;
        if (r101 < '0') goto L37;
        if (r101 <= '4') goto L19;
        goto L37
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        skipObject(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        int r100 = 0;
        if (this.token != 26) goto L21;
        int r101 = this.f24935np + 1;
        int r102 = this.f24936sp;
        if ((r102 % 2) != 0) goto L19;
        int r103 = r102 / 2;
        byte[] r104 = new byte[r103];
    L7:
        if (r100 >= r103) goto L17;
        int r105 = (r100 * 2) + r101;
        char r106 = this.text.charAt(r105);
        char r107 = this.text.charAt(r105 + 1);
        char r108 = '0';
        if (r106 > '9') goto L11;
        char r109 = '0';
    L12:
        int r110 = r106 - r109;
        if (r107 <= '9') goto L16;
        r108 = '7';
    L16:
        r104[r100] = (byte) ((r110 << 4) | (r107 - r108));
        r100 = r100 + 1;
        goto L7
    L11:
        r109 = '7';
        goto L12
    L17:
        return r104;
    L19:
        throw new JSONException("illegal state. " + r102);
    L21:
        if (this.hasSpecial == true) goto L25;
        return IOUtils.decodeBase64(this.text, this.f24935np + 1, this.f24936sp);
    L25:
        return IOUtils.decodeBase64(new String(this.sbuf, 0, this.f24936sp));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final BigDecimal decimalValue() {
        char r100 = charAt((this.f24935np + this.f24936sp) - 1);
        int r101 = this.f24936sp;
        if (r100 != 'L') goto L5;
    L12:
        r101 = r101 - 1;
    L14:
        if (r101 > 65535) goto L22;
        int r102 = this.f24935np;
        char[] r103 = this.sbuf;
        if (r101 >= r103.length) goto L19;
        this.text.getChars(r102, r102 + r101, r103, 0);
        return new BigDecimal(this.sbuf, 0, r101, MathContext.UNLIMITED);
    L19:
        char[] r104 = new char[r101];
        this.text.getChars(r102, r102 + r101, r104, 0);
        return new BigDecimal(r104, 0, r101, MathContext.UNLIMITED);
    L22:
        throw new JSONException("decimal overflow");
    L5:
        if (r100 == 'S') goto L12;
        if (r100 == 'B') goto L12;
        if (r100 == 'F') goto L12;
        if (r100 != 'D') goto L14;
        goto L12
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String info() {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
        int r102 = 1;
        int r103 = 1;
    L4:
        if (r101 >= this.f24933bp) goto L9;
        if (this.text.charAt(r101) != '\n') goto L8;
        r102 = r102 + 1;
        r103 = 1;
    L8:
        r101 = r101 + 1;
        r103 = r103 + 1;
        goto L4
    L9:
        r100.append("pos ");
        r100.append(this.f24933bp);
        r100.append(", line ");
        r100.append(r102);
        r100.append(", column ");
        r100.append(r103);
        if (this.text.length() >= 65535) goto L12;
        r100.append(this.text);
    L14:
        return r100.toString();
    L12:
        r100.append(this.text.substring(0, 65535));
        goto L14
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        int r100 = this.f24933bp;
        int r101 = this.len;
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (this.f24934ch == 26) goto L7;
    L9:
        return false;
    L7:
        if ((r100 + 1) < r101) goto L9;
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int r100 = this.f24933bp + 1;
        this.f24933bp = r100;
        if (r100 < this.len) goto L5;
        char r101 = JSONLexer.EOI;
    L6:
        this.f24934ch = r101;
        return r101;
    L5:
        r101 = this.text.charAt(r100);
        goto L6
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String numberString() {
        char r100 = charAt((this.f24935np + this.f24936sp) - 1);
        int r101 = this.f24936sp;
        if (r100 != 'L') goto L5;
    L12:
        r101 = r101 - 1;
    L14:
        return subString(this.f24935np, r101);
    L5:
        if (r100 == 'S') goto L12;
        if (r100 == 'B') goto L12;
        if (r100 == 'F') goto L12;
        if (r100 != 'D') goto L14;
        goto L12
    }

    public final void skipString() {
        if (this.f24934ch != '\"') goto L18;
        int r100 = this.f24933bp;
    L5:
        r100 = r100 + 1;
        if (r100 >= this.text.length()) goto L16;
        char r101 = this.text.charAt(r100);
        if (r101 == '\\') goto L10;
        if (r101 != '\"') goto L5;
        String r102 = this.text;
        int r103 = r100 + 1;
        this.f24933bp = r103;
        this.f24934ch = r102.charAt(r103);
        return;
    L10:
        if (r100 >= (this.len - 1)) goto L5;
        r100 = r100 + 1;
        goto L5
    L16:
        throw new JSONException("unclosed str");
    L18:
        throw new UnsupportedOperationException();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final String stringVal() {
        if (this.hasSpecial == true) goto L7;
        return subString(this.f24935np + 1, this.f24936sp);
    L7:
        return new String(this.sbuf, 0, this.f24936sp);
    }

    public JSONScanner(String r100) {
        this(r100, JSON.DEFAULT_PARSER_FEATURE);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] r100) {
        return charArrayCompare(this.text, this.f24933bp, r100);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int r100) {
        if (r100 < this.len) goto L7;
        return JSONLexer.EOI;
    L7:
        return this.text.charAt(r100);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] r100) {
    L3:
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L6;
        next();
        goto L3
    L6:
        if (charArrayCompare(r100) == true) goto L9;
        this.matchStat = -2;
        return false;
    L9:
        int r101 = this.f24933bp + r100.length;
        int r102 = r101 + 1;
        char r103 = this.text.charAt(r101);
    L11:
        if (JSONLexerBase.isWhitespace(r103) == false) goto L14;
        r103 = this.text.charAt(r102);
        r102 = r102 + 1;
        goto L11
    L14:
        if (r103 != ':') goto L17;
        this.f24933bp = r102;
        this.f24934ch = charAt(r102);
        return true;
    L17:
        this.matchStat = -2;
        return false;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanDate(char r110) {
        boolean r100 = false;
        this.matchStat = 0;
        int r101 = this.f24933bp;
        char r102 = this.f24934ch;
        int r103 = r101 + 1;
        char r104 = charAt(r101);
        if (r104 != '\"') goto L22;
        int r105 = indexOf(Typography.quote, r103);
        if (r105 == (-1)) goto L21;
        this.f24933bp = r103;
        if (scanISO8601DateIfMatch(false, r105 - r103) == false) goto L18;
        Date r106 = this.calendar.getTime();
        char r107 = charAt(r105 + 1);
        this.f24933bp = r101;
    L9:
        if (r107 == ',') goto L17;
        if (r107 == ']') goto L17;
        if (JSONLexerBase.isWhitespace(r107) == false) goto L15;
        r105 = r105 + 1;
        r107 = charAt(r105 + 1);
        goto L9
    L15:
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L17:
        this.f24933bp = r105 + 1;
        this.f24934ch = r107;
    L59:
        if (r107 != ',') goto L62;
        int r108 = this.f24933bp + 1;
        this.f24933bp = r108;
        this.f24934ch = charAt(r108);
        this.matchStat = 3;
        return r106;
    L62:
        int r109 = this.f24933bp + 1;
        this.f24933bp = r109;
        char r111 = charAt(r109);
        if (r111 != ',') goto L65;
        this.token = 16;
        int r112 = this.f24933bp + 1;
        this.f24933bp = r112;
        this.f24934ch = charAt(r112);
    L73:
        this.matchStat = 4;
        return r106;
    L65:
        if (r111 != ']') goto L68;
        this.token = 15;
        int r113 = this.f24933bp + 1;
        this.f24933bp = r113;
        this.f24934ch = charAt(r113);
        goto L73
    L68:
        if (r111 != '}') goto L71;
        this.token = 13;
        int r114 = this.f24933bp + 1;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        goto L73
    L71:
        if (r111 != 26) goto L75;
        this.f24934ch = JSONLexer.EOI;
        this.token = 20;
        goto L73
    L75:
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L18:
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L21:
        throw new JSONException("unclosed str");
    L22:
        char r115 = '9';
        if (r104 == '-') goto L38;
        if (r104 < '0') goto L28;
        if (r104 <= '9') goto L38;
    L28:
        if (r104 != 'n') goto L36;
        int r116 = r103 + 1;
        if (charAt(r103) != 'u') goto L36;
        int r117 = r116 + 1;
        if (charAt(r116) != 'l') goto L36;
        int r118 = r117 + 1;
        if (charAt(r117) != 'l') goto L36;
        r107 = charAt(r118);
        this.f24933bp = r118;
        r106 = null;
    L36:
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L38:
        if (r104 != '-') goto L41;
        r104 = charAt(r103);
        r103 = r103 + 1;
        r100 = true;
    L41:
        if (r104 < '0') goto L51;
        if (r104 > '9') goto L51;
        long r119 = r104 - '0';
    L44:
        int r120 = r103 + 1;
        r107 = charAt(r103);
        if (r107 < '0') goto L48;
        if (r107 > r115) goto L48;
        r119 = (r119 * 10) + ((long) (r107 - '0'));
        r103 = r120;
        r115 = '9';
    L48:
        if (r107 == ',') goto L50;
        if (r107 == ']') goto L50;
    L53:
        if (r119 >= 0) goto L56;
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L56:
        if (r100 == false) goto L58;
        r119 = -r119;
    L58:
        r106 = new Date(r119);
    L50:
        this.f24933bp = r120 - 1;
    L51:
        r107 = r104;
        r119 = 0;
        goto L53
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00c4 -> B:52:0x00b4). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char r210) {
        this.matchStat = 0;
        int r100 = this.f24933bp;
        int r101 = r100 + 1;
        char r102 = charAt(r100);
        if (r102 != '\"') goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        int r104 = r101 + 1;
        char r105 = charAt(r101);
        r101 = r104;
        r102 = r105;
    L9:
        if (r102 != '-') goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L15;
        int r107 = r101 + 1;
        char r108 = charAt(r101);
        r101 = r107;
        r102 = r108;
    L15:
        if (r102 < '0') goto L79;
        char r110 = '9';
        if (r102 > '9') goto L79;
        long r109 = r102 - '0';
    L19:
        int r111 = r101 + 1;
        char r112 = charAt(r101);
        if (r112 < '0') goto L24;
        if (r112 > '9') goto L24;
        r109 = (r109 * 10) + ((long) (r112 - '0'));
        r101 = r111;
    L24:
        if (r112 != '.') goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L39;
        int r114 = r111 + 1;
        char r115 = charAt(r111);
        if (r115 < '0') goto L37;
        if (r115 > '9') goto L37;
        r109 = (r109 * 10) + ((long) (r115 - '0'));
        long r116 = 10;
    L32:
        int r117 = r114 + 1;
        r112 = charAt(r114);
        if (r112 < '0') goto L36;
        if (r112 > r110) goto L36;
        r109 = (r109 * 10) + ((long) (r112 - '0'));
        r116 = r116 * 10;
        r114 = r117;
        r110 = '9';
    L36:
        r111 = r117;
    L41:
        if (r112 != 'e') goto L43;
    L46:
        boolean r118 = true;
    L47:
        if (r118 == false) goto L58;
        int r119 = r111 + 1;
        char r120 = charAt(r111);
        if (r120 == '+') goto L53;
        if (r120 == '-') goto L53;
    L52:
        r111 = r119;
        r112 = r120;
    L54:
        if (r112 < '0') goto L58;
        if (r112 > '9') goto L58;
        r119 = r111 + 1;
        r120 = charAt(r111);
    L53:
        int r121 = r119 + 1;
        r112 = charAt(r119);
        r111 = r121;
    L58:
        if (r103 == true) goto L60;
        int r122 = this.f24933bp;
        int r123 = (r111 - r122) - 1;
    L65:
        if (r118 == false) goto L67;
    L71:
        double r124 = CastDoubleProtector.parseDouble(subString(r122, r123));
    L73:
        if (r112 != r210) goto L76;
        this.f24933bp = r111;
        this.f24934ch = charAt(r111);
        this.matchStat = 3;
        this.token = 16;
        return r124;
    L76:
        this.matchStat = -1;
        return r124;
    L67:
        if (r123 >= 18) goto L71;
        r124 = r109 / r116;
        if (r106 == false) goto L73;
        r124 = -r124;
        goto L73
    L60:
        if (r112 == '\"') goto L63;
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L63:
        int r125 = r111 + 1;
        char r126 = charAt(r111);
        r122 = this.f24933bp + 1;
        r123 = (r125 - r122) - 2;
        r111 = r125;
        r112 = r126;
        goto L65
    L43:
        if (r112 == 'E') goto L46;
        r118 = false;
    L37:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L39:
        r116 = 1;
        goto L41
    L26:
        r113 = false;
    L79:
        if (r102 != 'n') goto L105;
        int r127 = r101 + 1;
        if (charAt(r101) != 'u') goto L105;
        int r128 = r127 + 1;
        if (charAt(r127) != 'l') goto L105;
        int r129 = r128 + 1;
        if (charAt(r128) != 'l') goto L105;
        this.matchStat = 5;
        int r130 = r129 + 1;
        char r131 = charAt(r129);
        if (r103 == false) goto L93;
        if (r131 != '\"') goto L93;
        int r132 = r130 + 1;
        char r133 = charAt(r130);
        r130 = r132;
        r131 = r133;
    L93:
        if (r131 == ',') goto L94;
        if (r131 == ']') goto L98;
        if (JSONLexerBase.isWhitespace(r131) == false) goto L103;
        int r134 = r130 + 1;
        char r135 = charAt(r130);
        r130 = r134;
        r131 = r135;
        goto L93
    L103:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L98:
        this.f24933bp = r130;
        this.f24934ch = charAt(r130);
        this.matchStat = 5;
        this.token = 15;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L94:
        this.f24933bp = r130;
        this.f24934ch = charAt(r130);
        this.matchStat = 5;
        this.token = 16;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L105:
        this.matchStat = -1;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L11:
        r106 = false;
        goto L12
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] r110) {
        this.matchStat = 0;
        if (charArrayCompare(this.text, this.f24933bp, r110) == true) goto L6;
        this.matchStat = -2;
        return false;
    L6:
        int r100 = this.f24933bp;
        int r111 = r110.length + r100;
        int r101 = r111 + 1;
        char r112 = charAt(r111);
        if (r112 != '\"') goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        int r113 = r101 + 1;
        char r103 = charAt(r101);
        r101 = r113;
        r112 = r103;
    L13:
        if (r112 != 't') goto L34;
        int r114 = r101 + 1;
        if (charAt(r101) == 'r') goto L18;
        this.matchStat = -1;
        return false;
    L18:
        int r104 = r114 + 1;
        if (charAt(r114) == 'u') goto L22;
        this.matchStat = -1;
        return false;
    L22:
        int r115 = r104 + 1;
        if (charAt(r104) == 'e') goto L26;
        this.matchStat = -1;
        return false;
    L26:
        if (r102 == false) goto L32;
        int r105 = r115 + 1;
        if (charAt(r115) == '\"') goto L31;
        this.matchStat = -1;
        return false;
    L31:
        r115 = r105;
    L32:
        this.f24933bp = r115;
        char r116 = charAt(r115);
    L67:
        boolean r106 = true;
    L79:
        if (r116 == ',') goto L80;
        if (r116 == '}') goto L83;
        if (JSONLexerBase.isWhitespace(r116) == false) goto L104;
        int r117 = this.f24933bp + 1;
        this.f24933bp = r117;
        r116 = charAt(r117);
        goto L79
    L104:
        this.f24933bp = r100;
        charAt(r100);
        this.matchStat = -1;
        return false;
    L83:
        int r118 = this.f24933bp + 1;
        this.f24933bp = r118;
        char r119 = charAt(r118);
    L84:
        if (r119 == ',') goto L85;
        if (r119 == ']') goto L88;
        if (r119 == '}') goto L90;
        if (r119 == 26) goto L93;
        if (JSONLexerBase.isWhitespace(r119) == false) goto L99;
        int r120 = this.f24933bp + 1;
        this.f24933bp = r120;
        r119 = charAt(r120);
        goto L84
    L99:
        this.matchStat = -1;
        return false;
    L93:
        this.token = 20;
    L94:
        this.matchStat = 4;
    L95:
        return r106;
    L90:
        this.token = 13;
        int r121 = this.f24933bp + 1;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
        goto L94
    L88:
        this.token = 15;
        int r122 = this.f24933bp + 1;
        this.f24933bp = r122;
        this.f24934ch = charAt(r122);
        goto L94
    L85:
        this.token = 16;
        int r123 = this.f24933bp + 1;
        this.f24933bp = r123;
        this.f24934ch = charAt(r123);
        goto L94
    L80:
        int r124 = this.f24933bp + 1;
        this.f24933bp = r124;
        this.f24934ch = charAt(r124);
        this.matchStat = 3;
        this.token = 16;
        goto L95
    L34:
        if (r112 != 'f') goto L59;
        int r125 = r101 + 1;
        if (charAt(r101) == 'a') goto L39;
        this.matchStat = -1;
        return false;
    L39:
        int r107 = r125 + 1;
        if (charAt(r125) == 'l') goto L43;
        this.matchStat = -1;
        return false;
    L43:
        int r126 = r107 + 1;
        if (charAt(r107) == 's') goto L47;
        this.matchStat = -1;
        return false;
    L47:
        int r108 = r126 + 1;
        if (charAt(r126) == 'e') goto L51;
        this.matchStat = -1;
        return false;
    L51:
        if (r102 == false) goto L57;
        int r127 = r108 + 1;
        if (charAt(r108) == '\"') goto L56;
        this.matchStat = -1;
        return false;
    L56:
        r108 = r127;
    L57:
        this.f24933bp = r108;
        r116 = charAt(r108);
    L77:
        r106 = false;
        goto L79
    L59:
        if (r112 != '1') goto L69;
        if (r102 == false) goto L66;
        int r128 = r101 + 1;
        if (charAt(r101) == '\"') goto L65;
        this.matchStat = -1;
        return false;
    L65:
        r101 = r128;
    L66:
        this.f24933bp = r101;
        r116 = charAt(r101);
        goto L67
    L69:
        if (r112 != '0') goto L106;
        if (r102 == false) goto L76;
        int r129 = r101 + 1;
        if (charAt(r101) == '\"') goto L75;
        this.matchStat = -1;
        return false;
    L75:
        r101 = r129;
    L76:
        this.f24933bp = r101;
        r116 = charAt(r101);
        goto L77
    L106:
        this.matchStat = -1;
        return false;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Date scanFieldDate(char[] r210) {
        boolean r100 = false;
        this.matchStat = 0;
        int r101 = this.f24933bp;
        char r102 = this.f24934ch;
        if (charArrayCompare(this.text, r101, r210) == true) goto L6;
        this.matchStat = -2;
        return null;
    L6:
        int r103 = this.f24933bp + r210.length;
        int r104 = r103 + 1;
        char r105 = charAt(r103);
        if (r105 != '\"') goto L26;
        int r106 = indexOf(Typography.quote, r104);
        if (r106 == (-1)) goto L25;
        this.f24933bp = r104;
        if (scanISO8601DateIfMatch(false, r106 - r104) == false) goto L22;
        Date r107 = this.calendar.getTime();
        char r108 = charAt(r106 + 1);
        this.f24933bp = r101;
    L13:
        if (r108 == ',') goto L21;
        if (r108 == '}') goto L21;
        if (JSONLexerBase.isWhitespace(r108) == false) goto L19;
        r106 = r106 + 1;
        r108 = charAt(r106 + 1);
        goto L13
    L19:
        this.matchStat = -1;
        return null;
    L21:
        this.f24933bp = r106 + 1;
        this.f24934ch = r108;
    L55:
        if (r108 != ',') goto L58;
        int r109 = this.f24933bp + 1;
        this.f24933bp = r109;
        this.f24934ch = charAt(r109);
        this.matchStat = 3;
        this.token = 16;
        return r107;
    L58:
        int r110 = this.f24933bp + 1;
        this.f24933bp = r110;
        char r111 = charAt(r110);
        if (r111 != ',') goto L62;
        this.token = 16;
        int r112 = this.f24933bp + 1;
        this.f24933bp = r112;
        this.f24934ch = charAt(r112);
    L69:
        this.matchStat = 4;
        return r107;
    L62:
        if (r111 != ']') goto L64;
        this.token = 15;
        int r113 = this.f24933bp + 1;
        this.f24933bp = r113;
        this.f24934ch = charAt(r113);
        goto L69
    L64:
        if (r111 != '}') goto L67;
        this.token = 13;
        int r114 = this.f24933bp + 1;
        this.f24933bp = r114;
        this.f24934ch = charAt(r114);
        goto L69
    L67:
        if (r111 != 26) goto L71;
        this.token = 20;
        goto L69
    L71:
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L22:
        this.f24933bp = r101;
        this.matchStat = -1;
        return null;
    L25:
        throw new JSONException("unclosed str");
    L26:
        char r115 = '9';
        char r116 = '0';
        if (r105 == '-') goto L33;
        if (r105 < '0') goto L31;
        if (r105 <= '9') goto L33;
    L31:
        this.matchStat = -1;
        return null;
    L33:
        if (r105 != '-') goto L36;
        r105 = charAt(r104);
        r104 = r104 + 1;
        r100 = true;
    L36:
        if (r105 < '0') goto L46;
        if (r105 > '9') goto L46;
        long r117 = r105 - '0';
    L39:
        int r118 = r104 + 1;
        char r119 = charAt(r104);
        if (r119 < r116) goto L43;
        if (r119 > r115) goto L43;
        r117 = (r117 * 10) + ((long) (r119 - '0'));
        r104 = r118;
        r115 = '9';
        r116 = '0';
    L43:
        if (r119 == ',') goto L45;
        if (r119 == '}') goto L45;
    L48:
        if (r117 >= 0) goto L51;
        this.matchStat = -1;
        return null;
    L51:
        if (r100 == false) goto L53;
        r117 = -r117;
    L53:
        r108 = r119;
        r107 = new Date(r117);
    L45:
        this.f24933bp = r118 - 1;
    L46:
        r119 = r105;
        r117 = 0;
        goto L48
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] r110) {
        this.matchStat = 0;
        int r100 = this.f24933bp;
        char r101 = this.f24934ch;
        if (charArrayCompare(this.text, r100, r110) == true) goto L6;
        this.matchStat = -2;
        return 0;
    L6:
        int r102 = this.f24933bp + r110.length;
        int r111 = r102 + 1;
        char r103 = charAt(r102);
        if (r103 != '\"') goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        r103 = charAt(r111);
        r111 = r111 + 1;
    L13:
        if (r103 != '-') goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L19;
        r103 = charAt(r111);
        r111 = r111 + 1;
    L19:
        if (r103 >= '0') goto L21;
    L80:
        this.matchStat = -1;
        return 0;
    L21:
        if (r103 > '9') goto L80;
        int r106 = r103 - '0';
    L23:
        int r112 = r111 + 1;
        char r113 = charAt(r111);
        if (r113 < '0') goto L32;
        if (r113 > '9') goto L32;
        int r114 = r106 * 10;
        if (r114 < r106) goto L28;
        r106 = r114 + (r113 - '0');
        r111 = r112;
        goto L23
    L28:
        this.matchStat = -1;
        return 0;
    L32:
        if (r113 != '.') goto L35;
        this.matchStat = -1;
        return 0;
    L35:
        if (r106 >= 0) goto L38;
        this.matchStat = -1;
        return 0;
    L38:
        if (r104 == false) goto L45;
        if (r113 == '\"') goto L42;
        this.matchStat = -1;
        return 0;
    L42:
        int r115 = r112 + 1;
        char r107 = charAt(r112);
        r112 = r115;
        r113 = r107;
    L45:
        if (r113 == ',') goto L53;
        if (r113 == '}') goto L53;
        if (JSONLexerBase.isWhitespace(r113) == false) goto L51;
        int r116 = r112 + 1;
        char r108 = charAt(r112);
        r112 = r116;
        r113 = r108;
        goto L45
    L51:
        this.matchStat = -1;
        return 0;
    L53:
        int r117 = r112 - 1;
        this.f24933bp = r117;
        if (r113 != ',') goto L59;
        int r118 = r117 + 1;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
        this.matchStat = 3;
        this.token = 16;
        if (r105 == true) goto L58;
        return r106;
    L58:
        return -r106;
    L59:
        if (r113 != '}') goto L77;
        int r119 = r117 + 1;
        this.f24933bp = r119;
        char r120 = charAt(r119);
    L61:
        if (r120 == ',') goto L62;
        if (r120 == ']') goto L65;
        if (r120 == '}') goto L67;
        if (r120 == 26) goto L70;
        if (JSONLexerBase.isWhitespace(r120) == false) goto L75;
        int r121 = this.f24933bp + 1;
        this.f24933bp = r121;
        r120 = charAt(r121);
        goto L61
    L75:
        this.f24933bp = r100;
        this.f24934ch = r101;
        this.matchStat = -1;
        return 0;
    L70:
        this.token = 20;
    L71:
        this.matchStat = 4;
        goto L77
    L67:
        this.token = 13;
        int r122 = this.f24933bp + 1;
        this.f24933bp = r122;
        this.f24934ch = charAt(r122);
        goto L71
    L65:
        this.token = 15;
        int r123 = this.f24933bp + 1;
        this.f24933bp = r123;
        this.f24934ch = charAt(r123);
        goto L71
    L62:
        this.token = 16;
        int r124 = this.f24933bp + 1;
        this.f24933bp = r124;
        this.f24934ch = charAt(r124);
    L77:
        if (r105 == true) goto L79;
        return r106;
    L79:
        return -r106;
    L15:
        r105 = false;
        goto L16
    L9:
        r104 = false;
        goto L10
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] r210) {
        this.matchStat = 0;
        int r100 = this.f24933bp;
        char r101 = this.f24934ch;
        if (charArrayCompare(this.text, r100, r210) == true) goto L6;
        this.matchStat = -2;
        return 0;
    L6:
        int r102 = this.f24933bp + r210.length;
        int r103 = r102 + 1;
        char r104 = charAt(r102);
        if (r104 != '\"') goto L9;
        boolean r110 = true;
    L10:
        if (r110 == false) goto L13;
        r104 = charAt(r103);
        r103 = r103 + 1;
    L13:
        if (r104 != '-') goto L15;
        boolean r111 = true;
        r104 = charAt(r103);
        r103 = r103 + 1;
    L17:
        if (r104 < '0') goto L82;
        char r112 = '9';
        if (r104 > '9') goto L82;
        long r105 = r104 - '0';
    L21:
        int r106 = r103 + 1;
        char r107 = charAt(r103);
        if (r107 < '0') goto L26;
        if (r107 > r112) goto L26;
        r105 = (r105 * 10) + ((long) (r107 - '0'));
        r103 = r106;
        r112 = '9';
    L26:
        if (r107 != '.') goto L29;
        this.matchStat = -1;
        return 0;
    L29:
        if (r110 == false) goto L35;
        if (r107 == '\"') goto L33;
        this.matchStat = -1;
        return 0;
    L33:
        int r108 = r106 + 1;
        char r109 = charAt(r106);
        r106 = r108;
        r107 = r109;
    L35:
        if (r107 == ',') goto L37;
        if (r107 == '}') goto L37;
    L39:
        if (r105 < 0) goto L41;
    L45:
        boolean r113 = true;
    L46:
        if (r113 == true) goto L51;
        this.f24933bp = r100;
        this.f24934ch = r101;
        this.matchStat = -1;
        return 0;
    L51:
        if (r107 == ',') goto L52;
        if (r107 == '}') goto L57;
        if (JSONLexerBase.isWhitespace(r107) == false) goto L80;
        this.f24933bp = r106;
        int r114 = r106 + 1;
        char r115 = charAt(r106);
        r106 = r114;
        r107 = r115;
        goto L51
    L80:
        this.matchStat = -1;
        return 0;
    L57:
        int r116 = this.f24933bp + 1;
        this.f24933bp = r116;
        char r117 = charAt(r116);
    L58:
        if (r117 == ',') goto L59;
        if (r117 == ']') goto L62;
        if (r117 == '}') goto L64;
        if (r117 == 26) goto L67;
        if (JSONLexerBase.isWhitespace(r117) == false) goto L75;
        int r118 = this.f24933bp + 1;
        this.f24933bp = r118;
        r117 = charAt(r118);
        goto L58
    L75:
        this.f24933bp = r100;
        this.f24934ch = r101;
        this.matchStat = -1;
        return 0;
    L67:
        this.token = 20;
    L68:
        this.matchStat = 4;
        if (r111 == true) goto L71;
        return r105;
    L71:
        return -r105;
    L64:
        this.token = 13;
        int r119 = this.f24933bp + 1;
        this.f24933bp = r119;
        this.f24934ch = charAt(r119);
        goto L68
    L62:
        this.token = 15;
        int r120 = this.f24933bp + 1;
        this.f24933bp = r120;
        this.f24934ch = charAt(r120);
        goto L68
    L59:
        this.token = 16;
        int r121 = this.f24933bp + 1;
        this.f24933bp = r121;
        this.f24934ch = charAt(r121);
        goto L68
    L52:
        int r122 = this.f24933bp + 1;
        this.f24933bp = r122;
        this.f24934ch = charAt(r122);
        this.matchStat = 3;
        this.token = 16;
        if (r111 == true) goto L55;
        return r105;
    L55:
        return -r105;
    L41:
        if (r105 != Long.MIN_VALUE) goto L44;
        if (r111 == true) goto L45;
    L44:
        r113 = false;
    L37:
        this.f24933bp = r106 - 1;
    L82:
        this.f24933bp = r100;
        this.f24934ch = r101;
        this.matchStat = -1;
        return 0;
    L15:
        r111 = false;
        goto L17
    L9:
        r110 = false;
        goto L10
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String scanFieldString(char[] r110) {
        this.matchStat = 0;
        int r100 = this.f24933bp;
        char r101 = this.f24934ch;
    L4:
        if (charArrayCompare(this.text, this.f24933bp, r110) == true) goto L13;
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L11;
        next();
    L9:
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L4;
        next();
        goto L9
    L11:
        this.matchStat = -2;
        return stringDefaultValue();
    L13:
        int r102 = this.f24933bp + r110.length;
        int r103 = r102 + 1;
        char r104 = charAt(r102);
        int r105 = 0;
        if (r104 != '\"') goto L16;
    L21:
        int r106 = indexOf(Typography.quote, r103);
        if (r106 == (-1)) goto L67;
        String r107 = subString(r103, r106 - r103);
        if (r107.indexOf(92) == (-1)) goto L35;
    L25:
        int r108 = r106 - 1;
        int r109 = 0;
    L26:
        if (r108 < 0) goto L31;
        if (charAt(r108) != '\\') goto L31;
        r109 = r109 + 1;
        r108 = r108 - 1;
    L31:
        if ((r109 % 2) == 0) goto L32;
        r106 = indexOf(Typography.quote, r106 + 1);
        goto L25
    L32:
        int r111 = this.f24933bp;
        int r112 = r106 - (((r110.length + r111) + 1) + r105);
        r107 = JSONLexerBase.readString(sub_chars(((r111 + r110.length) + 1) + r105, r112), r112);
    L35:
        if ((this.features & Feature.TrimStringFieldValue.mask) == 0) goto L37;
        r107 = r107.trim();
    L37:
        char r113 = charAt(r106 + 1);
    L39:
        if (r113 == ',') goto L47;
        if (r113 == '}') goto L47;
        if (JSONLexerBase.isWhitespace(r113) == false) goto L45;
        r106 = r106 + 1;
        r113 = charAt(r106 + 1);
        goto L39
    L45:
        this.matchStat = -1;
        return stringDefaultValue();
    L47:
        int r114 = r106 + 1;
        this.f24933bp = r114;
        this.f24934ch = r113;
        if (r113 != ',') goto L51;
        int r115 = r114 + 1;
        this.f24933bp = r115;
        this.f24934ch = charAt(r115);
        this.matchStat = 3;
        return r107;
    L51:
        int r116 = r114 + 1;
        this.f24933bp = r116;
        char r117 = charAt(r116);
        if (r117 != ',') goto L55;
        this.token = 16;
        int r118 = this.f24933bp + 1;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
    L62:
        this.matchStat = 4;
        return r107;
    L55:
        if (r117 != ']') goto L57;
        this.token = 15;
        int r119 = this.f24933bp + 1;
        this.f24933bp = r119;
        this.f24934ch = charAt(r119);
        goto L62
    L57:
        if (r117 != '}') goto L60;
        this.token = 13;
        int r120 = this.f24933bp + 1;
        this.f24933bp = r120;
        this.f24934ch = charAt(r120);
        goto L62
    L60:
        if (r117 != 26) goto L64;
        this.token = 20;
        goto L62
    L64:
        this.f24933bp = r100;
        this.f24934ch = r101;
        this.matchStat = -1;
        return stringDefaultValue();
    L67:
        throw new JSONException("unclosed str");
    L16:
        if (JSONLexerBase.isWhitespace(r104) == false) goto L18;
        r105 = r105 + 1;
        int r121 = r103 + 1;
        char r122 = charAt(r103);
        r103 = r121;
        r104 = r122;
        goto L16
    L18:
        if (r104 == '\"') goto L21;
        this.matchStat = -1;
        return stringDefaultValue();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] r110) {
        this.matchStat = 0;
    L4:
        if (charArrayCompare(this.text, this.f24933bp, r110) == true) goto L13;
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L11;
        next();
    L9:
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L4;
        next();
        goto L9
    L11:
        this.matchStat = -2;
        return 0;
    L13:
        int r100 = this.f24933bp + r110.length;
        int r111 = r100 + 1;
        char r101 = charAt(r100);
        if (r101 != '\"') goto L16;
    L21:
        long r102 = TypeUtils.fnv1a_64_magic_hashcode;
    L22:
        int r103 = r111 + 1;
        char r112 = charAt(r111);
        if (r112 == '\"') goto L24;
        if (r103 > this.len) goto L53;
        r102 = (r102 ^ ((long) r112)) * TypeUtils.fnv1a_64_magic_prime;
        r111 = r103;
        goto L22
    L53:
        this.matchStat = -1;
        return 0;
    L24:
        this.f24933bp = r103;
        char r113 = charAt(r103);
        this.f24934ch = r113;
    L26:
        if (r113 == ',') goto L27;
        if (r113 == '}') goto L31;
        if (JSONLexerBase.isWhitespace(r113) == false) goto L49;
        int r114 = this.f24933bp + 1;
        this.f24933bp = r114;
        r113 = charAt(r114);
        goto L26
    L49:
        this.matchStat = -1;
        return 0;
    L31:
        next();
        skipWhitespace();
        char r115 = getCurrent();
        if (r115 != ',') goto L35;
        this.token = 16;
        int r116 = this.f24933bp + 1;
        this.f24933bp = r116;
        this.f24934ch = charAt(r116);
    L42:
        this.matchStat = 4;
        return r102;
    L35:
        if (r115 != ']') goto L37;
        this.token = 15;
        int r117 = this.f24933bp + 1;
        this.f24933bp = r117;
        this.f24934ch = charAt(r117);
        goto L42
    L37:
        if (r115 != '}') goto L40;
        this.token = 13;
        int r118 = this.f24933bp + 1;
        this.f24933bp = r118;
        this.f24934ch = charAt(r118);
        goto L42
    L40:
        if (r115 != 26) goto L44;
        this.token = 20;
        goto L42
    L44:
        this.matchStat = -1;
        return 0;
    L27:
        int r119 = this.f24933bp + 1;
        this.f24933bp = r119;
        this.f24934ch = charAt(r119);
        this.matchStat = 3;
        return r102;
    L16:
        if (JSONLexerBase.isWhitespace(r101) == false) goto L18;
        int r104 = r111 + 1;
        r101 = charAt(r111);
        r111 = r104;
        goto L16
    L18:
        if (r101 == '\"') goto L21;
        this.matchStat = -1;
        return 0;
    }

    public boolean scanISO8601DateIfMatch(boolean r100) {
        return scanISO8601DateIfMatch(r100, this.len - this.f24933bp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char r110) {
        this.matchStat = 0;
        int r100 = this.f24933bp;
        int r101 = r100 + 1;
        char r102 = charAt(r100);
    L4:
        if (JSONLexerBase.isWhitespace(r102) == false) goto L7;
        r102 = charAt(r101);
        r101 = r101 + 1;
        goto L4
    L7:
        if (r102 != '\"') goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r102 = charAt(r101);
        r101 = r101 + 1;
    L13:
        if (r102 != '-') goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L19;
        r102 = charAt(r101);
        r101 = r101 + 1;
    L19:
        if (r102 < '0') goto L57;
        if (r102 > '9') goto L57;
        int r105 = r102 - '0';
    L23:
        int r111 = r101 + 1;
        char r106 = charAt(r101);
        if (r106 < '0') goto L32;
        if (r106 > '9') goto L32;
        int r112 = r105 * 10;
        if (r112 < r105) goto L30;
        r105 = r112 + (r106 - '0');
        r101 = r111;
        goto L23
    L30:
        throw new JSONException("parseInt error : " + subString(r100, r111 - 1));
    L32:
        if (r106 != '.') goto L35;
        this.matchStat = -1;
        return 0;
    L35:
        if (r103 == false) goto L40;
        if (r106 == '\"') goto L39;
        this.matchStat = -1;
        return 0;
    L39:
        r106 = charAt(r111);
        r111 = r111 + 1;
    L40:
        if (r105 >= 0) goto L44;
        this.matchStat = -1;
        return 0;
    L44:
        if (r106 == r110) goto L45;
        if (JSONLexerBase.isWhitespace(r106) == false) goto L52;
        r106 = charAt(r111);
        r111 = r111 + 1;
        goto L44
    L52:
        this.matchStat = -1;
        if (r104 == true) goto L55;
        return r105;
    L55:
        return -r105;
    L45:
        this.f24933bp = r111;
        this.f24934ch = charAt(r111);
        this.matchStat = 3;
        this.token = 16;
        if (r104 == true) goto L48;
        return r105;
    L48:
        return -r105;
    L57:
        if (r102 != 'n') goto L82;
        int r107 = r101 + 1;
        if (charAt(r101) != 'u') goto L82;
        int r108 = r107 + 1;
        if (charAt(r107) != 'l') goto L82;
        int r109 = r108 + 1;
        if (charAt(r108) != 'l') goto L82;
        this.matchStat = 5;
        int r113 = r109 + 1;
        char r114 = charAt(r109);
        if (r103 == false) goto L70;
        if (r114 != '\"') goto L70;
        int r115 = r113 + 1;
        char r116 = charAt(r113);
        r113 = r115;
        r114 = r116;
    L70:
        if (r114 == ',') goto L71;
        if (r114 == ']') goto L75;
        if (JSONLexerBase.isWhitespace(r114) == false) goto L80;
        int r117 = r113 + 1;
        char r118 = charAt(r113);
        r113 = r117;
        r114 = r118;
        goto L70
    L80:
        this.matchStat = -1;
        return 0;
    L75:
        this.f24933bp = r113;
        this.f24934ch = charAt(r113);
        this.matchStat = 5;
        this.token = 15;
        return 0;
    L71:
        this.f24933bp = r113;
        this.f24934ch = charAt(r113);
        this.matchStat = 5;
        this.token = 16;
        return 0;
    L82:
        this.matchStat = -1;
        return 0;
    L15:
        r104 = false;
        goto L16
    L9:
        r103 = false;
        goto L10
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char r210) {
        boolean r100 = false;
        this.matchStat = 0;
        int r101 = this.f24933bp;
        int r102 = r101 + 1;
        char r103 = charAt(r101);
        if (r103 != '\"') goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        int r105 = r102 + 1;
        char r106 = charAt(r102);
        r102 = r105;
        r103 = r106;
    L9:
        if (r103 != '-') goto L11;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        int r108 = r102 + 1;
        char r109 = charAt(r102);
        r102 = r108;
        r103 = r109;
    L14:
        char r110 = '0';
        if (r103 < '0') goto L53;
        if (r103 > '9') goto L53;
        long r111 = r103 - '0';
    L19:
        int r112 = r102 + 1;
        char r113 = charAt(r102);
        if (r113 < r110) goto L24;
        if (r113 > '9') goto L24;
        r111 = (r111 * 10) + ((long) (r113 - '0'));
        r102 = r112;
        r110 = '0';
    L24:
        if (r113 != '.') goto L27;
        this.matchStat = -1;
        return 0;
    L27:
        if (r104 == false) goto L33;
        if (r113 == '\"') goto L31;
        this.matchStat = -1;
        return 0;
    L31:
        r113 = charAt(r112);
        r112 = r112 + 1;
    L33:
        if (r111 < 0) goto L35;
    L37:
        r100 = true;
    L38:
        if (r100 == true) goto L42;
        this.matchStat = -1;
        return 0;
    L42:
        if (r113 == r210) goto L43;
        if (JSONLexerBase.isWhitespace(r113) == false) goto L50;
        r113 = charAt(r112);
        r112 = r112 + 1;
        goto L42
    L50:
        this.matchStat = -1;
        return r111;
    L43:
        this.f24933bp = r112;
        this.f24934ch = charAt(r112);
        this.matchStat = 3;
        this.token = 16;
        if (r107 == true) goto L46;
        return r111;
    L46:
        return -r111;
    L35:
        if (r111 != Long.MIN_VALUE) goto L38;
        if (r107 == false) goto L38;
    L53:
        if (r103 != 'n') goto L78;
        int r114 = r102 + 1;
        if (charAt(r102) != 'u') goto L78;
        int r115 = r114 + 1;
        if (charAt(r114) != 'l') goto L78;
        int r116 = r115 + 1;
        if (charAt(r115) != 'l') goto L78;
        this.matchStat = 5;
        int r117 = r116 + 1;
        char r118 = charAt(r116);
        if (r104 == false) goto L66;
        if (r118 != '\"') goto L66;
        int r119 = r117 + 1;
        char r120 = charAt(r117);
        r117 = r119;
        r118 = r120;
    L66:
        if (r118 == ',') goto L67;
        if (r118 == ']') goto L71;
        if (JSONLexerBase.isWhitespace(r118) == false) goto L76;
        int r121 = r117 + 1;
        char r122 = charAt(r117);
        r117 = r121;
        r118 = r122;
        goto L66
    L76:
        this.matchStat = -1;
        return 0;
    L71:
        this.f24933bp = r117;
        this.f24934ch = charAt(r117);
        this.matchStat = 5;
        this.token = 15;
        return 0;
    L67:
        this.f24933bp = r117;
        this.f24934ch = charAt(r117);
        this.matchStat = 5;
        this.token = 16;
        return 0;
    L78:
        this.matchStat = -1;
        return 0;
    L11:
        r107 = false;
        goto L12
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public String scanTypeName(SymbolTable r100) {
        if (this.text.startsWith("\"@type\":\"", this.f24933bp) == false) goto L16;
        int r101 = this.text.indexOf(34, this.f24933bp + 9);
        if (r101 == (-1)) goto L16;
        int r102 = this.f24933bp + 9;
        this.f24933bp = r102;
        int r103 = 0;
    L7:
        if (r102 >= r101) goto L9;
        r103 = (r103 * 31) + this.text.charAt(r102);
        r102 = r102 + 1;
        goto L7
    L9:
        int r104 = this.f24933bp;
        String r105 = addSymbol(r104, r101 - r104, r103, r100);
        char r106 = this.text.charAt(r101 + 1);
        if (r106 != ',') goto L12;
    L14:
        int r107 = r101 + 2;
        this.f24933bp = r107;
        this.f24934ch = this.text.charAt(r107);
        return r105;
    L12:
        if (r106 == ']') goto L14;
        return null;
    L16:
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int r110) {
        if (r110 < 0) goto L59;
        int r100 = this.token;
        if (r100 != 20) goto L7;
        return false;
    L7:
        if (r100 != 14) goto L57;
        int r101 = 0;
    L9:
        boolean r102 = true;
        if (r101 >= r110) goto L54;
        skipWhitespace();
        char r103 = this.f24934ch;
        if (r103 != '\"') goto L14;
    L45:
        skipString();
        char r104 = this.f24934ch;
        if (r104 != ',') goto L49;
        next();
    L48:
        r101 = r101 + 1;
        goto L9
    L49:
        if (r104 != ']') goto L53;
        next();
        nextToken(16);
        return false;
    L53:
        throw new JSONException("illegal json.");
    L14:
        if (r103 == '\'') goto L45;
        if (r103 != '{') goto L20;
        next();
        this.token = 12;
        skipObject(false);
    L22:
        int r105 = this.token;
        if (r105 == 16) goto L48;
        if (r105 != 15) goto L29;
        return false;
    L29:
        throw new UnsupportedOperationException();
    L20:
        if (r103 != '[') goto L30;
        next();
        this.token = 14;
        skipArray(false);
        goto L22
    L30:
        int r106 = this.f24933bp + 1;
    L32:
        if (r106 >= this.text.length()) goto L40;
        char r107 = this.text.charAt(r106);
        if (r107 == ',') goto L35;
        if (r107 == ']') goto L37;
        r106 = r106 + 1;
        goto L32
    L37:
        int r108 = r106 + 1;
        this.f24933bp = r108;
        this.f24934ch = charAt(r108);
        nextToken();
        return false;
    L35:
        int r109 = r106 + 1;
        this.f24933bp = r109;
        this.f24934ch = charAt(r109);
    L41:
        if (r102 == true) goto L48;
        throw new JSONException("illegal json.");
    L40:
        r102 = false;
        goto L41
    L54:
        nextToken();
        return true;
    L57:
        throw new UnsupportedOperationException();
    L59:
        throw new IllegalArgumentException("index must > 0, but " + r110);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] r110) {
        int r100 = this.token;
        if (r100 == 12) goto L8;
        if (r100 == 16) goto L8;
        throw new UnsupportedOperationException();
    L8:
        char r101 = this.f24934ch;
        if (r101 == '}') goto L10;
        char r102 = JSONLexer.EOI;
        if (r101 == 26) goto L14;
        if (r101 == '\"') goto L20;
        skipWhitespace();
    L20:
        if (this.f24934ch != '\"') goto L176;
        int r103 = this.f24933bp + 1;
        long r104 = TypeUtils.fnv1a_64_magic_hashcode;
    L23:
        if (r103 >= this.text.length()) goto L38;
        char r105 = this.text.charAt(r103);
        if (r105 != '\\') goto L31;
        r103 = r103 + 1;
        if (r103 == this.text.length()) goto L30;
        r105 = this.text.charAt(r103);
        goto L31
    L30:
        throw new JSONException("unclosed str, " + info());
    L31:
        if (r105 == '\"') goto L32;
        r104 = (r104 ^ ((long) r105)) * TypeUtils.fnv1a_64_magic_prime;
        r103 = r103 + 1;
        goto L23
    L32:
        int r106 = r103 + 1;
        this.f24933bp = r106;
        if (r106 < this.text.length()) goto L35;
        char r107 = JSONLexer.EOI;
    L36:
        this.f24934ch = r107;
        goto L38
    L35:
        r107 = this.text.charAt(this.f24933bp);
    L38:
        int r108 = 0;
    L40:
        if (r108 >= r110.length) goto L45;
        if (r104 == r110[r108]) goto L47;
        r108 = r108 + 1;
    L47:
        if (r108 != (-1)) goto L49;
        if (this.f24934ch == ':') goto L87;
        skipWhitespace();
    L87:
        if (this.f24934ch != ':') goto L174;
        int r109 = this.f24933bp + 1;
        this.f24933bp = r109;
        if (r109 < this.text.length()) goto L91;
        char r111 = JSONLexer.EOI;
    L92:
        this.f24934ch = r111;
        if (r111 != '\"') goto L95;
    L119:
        char r112 = this.f24934ch;
        if (r112 == '-') goto L143;
        if (r112 == '+') goto L143;
        if (r112 < '0') goto L125;
        if (r112 <= '9') goto L143;
    L125:
        if (r112 == '\"') goto L126;
        if (r112 == '{') goto L134;
        if (r112 != '[') goto L142;
        next();
        skipArray(false);
        goto L8
    L142:
        throw new UnsupportedOperationException();
    L134:
        int r113 = this.f24933bp + 1;
        this.f24933bp = r113;
        if (r113 >= this.text.length()) goto L138;
        r102 = this.text.charAt(r113);
    L138:
        this.f24934ch = r102;
        skipObject(false);
        goto L8
    L126:
        skipString();
        char r114 = this.f24934ch;
        if (r114 == ',') goto L131;
        if (r114 == '}') goto L131;
        skipWhitespace();
    L131:
        if (this.f24934ch != ',') goto L8;
        next();
    L143:
        next();
    L144:
        char r115 = this.f24934ch;
        if (r115 < '0') goto L149;
        if (r115 > '9') goto L149;
        next();
    L149:
        if (r115 != '.') goto L155;
        next();
    L151:
        char r116 = this.f24934ch;
        if (r116 < '0') goto L155;
        if (r116 > '9') goto L155;
        next();
    L155:
        char r117 = this.f24934ch;
        if (r117 != 'E') goto L158;
    L159:
        next();
        char r118 = this.f24934ch;
        if (r118 == '-') goto L162;
        if (r118 == '+') goto L162;
    L163:
        char r119 = this.f24934ch;
        if (r119 < '0') goto L168;
        if (r119 > '9') goto L168;
        next();
    L168:
        if (this.f24934ch == ',') goto L171;
        skipWhitespace();
    L171:
        if (this.f24934ch != ',') goto L8;
        next();
    L162:
        next();
        goto L163
    L158:
        if (r117 != 'e') goto L168;
    L95:
        if (r111 == '\'') goto L119;
        if (r111 == '{') goto L119;
        if (r111 == '[') goto L119;
        if (r111 == '0') goto L119;
        if (r111 == '1') goto L119;
        if (r111 == '2') goto L119;
        if (r111 == '3') goto L119;
        if (r111 == '4') goto L119;
        if (r111 == '5') goto L119;
        if (r111 == '6') goto L119;
        if (r111 == '7') goto L119;
        if (r111 == '8') goto L119;
        if (r111 == '9') goto L119;
        if (r111 == '+') goto L119;
        if (r111 == '-') goto L119;
        skipWhitespace();
        goto L119
    L91:
        r111 = this.text.charAt(r109);
        goto L92
    L174:
        throw new JSONException("illegal json, " + info());
    L49:
        if (this.f24934ch == ':') goto L52;
        skipWhitespace();
    L52:
        if (this.f24934ch != ':') goto L81;
        int r120 = this.f24933bp + 1;
        this.f24933bp = r120;
        if (r120 < this.text.length()) goto L56;
        char r121 = JSONLexer.EOI;
    L57:
        this.f24934ch = r121;
        if (r121 != ',') goto L65;
        int r122 = this.f24933bp + 1;
        this.f24933bp = r122;
        if (r122 >= this.text.length()) goto L63;
        r102 = this.text.charAt(r122);
    L63:
        this.f24934ch = r102;
        this.token = 16;
        goto L81
    L65:
        if (r121 != ']') goto L71;
        int r123 = this.f24933bp + 1;
        this.f24933bp = r123;
        if (r123 >= this.text.length()) goto L70;
        r102 = this.text.charAt(r123);
    L70:
        this.f24934ch = r102;
        this.token = 15;
        goto L81
    L71:
        if (r121 != '}') goto L77;
        int r124 = this.f24933bp + 1;
        this.f24933bp = r124;
        if (r124 >= this.text.length()) goto L76;
        r102 = this.text.charAt(r124);
    L76:
        this.f24934ch = r102;
        this.token = 13;
        goto L81
    L77:
        if (r121 < '0') goto L80;
        if (r121 > '9') goto L80;
        this.f24936sp = 0;
        this.pos = this.f24933bp;
        scanNumber();
    L80:
        nextToken(2);
        goto L81
    L56:
        r121 = this.text.charAt(r120);
    L81:
        this.matchStat = 3;
        return r108;
    L45:
        r108 = -1;
        goto L47
    L176:
        throw new UnsupportedOperationException();
    L14:
        this.matchStat = -1;
        return -1;
    L10:
        next();
        nextToken();
        this.matchStat = -1;
        return -1;
    }

    public final void skipArray(boolean r100) {
        int r101 = this.f24933bp;
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r101 >= this.text.length()) goto L42;
        char r104 = this.text.charAt(r101);
        if (r104 != '\\') goto L13;
        if (r101 >= (this.len - 1)) goto L10;
        r101 = r101 + 1;
    L40:
        r101 = r101 + 1;
        goto L4
    L10:
        this.f24934ch = r104;
        this.f24933bp = r101;
        throw new JSONException("illegal str, " + info());
    L13:
        if (r104 != '\"') goto L16;
        r102 = !r102;
        goto L40
    L16:
        if (r104 != '[') goto L20;
        if (r102 == true) goto L40;
        r103 = r103 + 1;
        goto L40
    L20:
        char r105 = JSONLexer.EOI;
        if (r104 != '{') goto L29;
        if (r100 == false) goto L29;
        int r106 = this.f24933bp + 1;
        this.f24933bp = r106;
        if (r106 >= this.text.length()) goto L27;
        r105 = this.text.charAt(r106);
    L27:
        this.f24934ch = r105;
        skipObject(r100);
    L29:
        if (r104 != ']') goto L40;
        if (r102 == true) goto L40;
        r103 = r103 - 1;
        if (r103 != (-1)) goto L40;
        int r107 = r101 + 1;
        this.f24933bp = r107;
        if (r107 != this.text.length()) goto L38;
        this.f24934ch = JSONLexer.EOI;
        this.token = 20;
        return;
    L38:
        this.f24934ch = this.text.charAt(this.f24933bp);
        nextToken(16);
        return;
    L42:
        if (r101 == this.text.length()) goto L45;
        return;
    L45:
        throw new JSONException("illegal str, " + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean r100) {
        int r101 = this.f24933bp;
        int r102 = 0;
        boolean r103 = false;
        int r104 = 0;
    L4:
        if (r101 >= this.text.length()) goto L49;
        char r105 = this.text.charAt(r101);
        if (r105 != '\\') goto L13;
        if (r101 >= (this.len - 1)) goto L10;
        r101 = r101 + 1;
    L47:
        r101 = r101 + 1;
        goto L4
    L10:
        this.f24934ch = r105;
        this.f24933bp = r101;
        throw new JSONException("illegal str, " + info());
    L13:
        if (r105 != '\"') goto L16;
        r103 = !r103;
        goto L47
    L16:
        if (r105 != '{') goto L21;
        if (r103 == true) goto L47;
        r104 = r104 + 1;
        goto L47
    L21:
        if (r105 != '}') goto L47;
        if (r103 == true) goto L47;
        r104 = r104 - 1;
        if (r104 != (-1)) goto L47;
        int r106 = r101 + 1;
        this.f24933bp = r106;
        int r107 = this.text.length();
        char r108 = JSONLexer.EOI;
        if (r106 != r107) goto L30;
        this.f24934ch = JSONLexer.EOI;
        this.token = 20;
        return;
    L30:
        char r109 = this.text.charAt(this.f24933bp);
        this.f24934ch = r109;
        if (r109 != ',') goto L38;
        this.token = 16;
        int r110 = this.f24933bp + 1;
        this.f24933bp = r110;
        if (r110 >= this.text.length()) goto L36;
        r108 = this.text.charAt(r110);
    L36:
        this.f24934ch = r108;
        return;
    L38:
        if (r109 != '}') goto L42;
        this.token = 13;
        next();
        return;
    L42:
        if (r109 != ']') goto L45;
        this.token = 15;
        next();
        return;
    L45:
        nextToken(16);
        return;
    L49:
        if (r102 >= this.f24933bp) goto L57;
        if (r102 >= this.text.length()) goto L55;
        if (this.text.charAt(r102) != ' ') goto L55;
        r101 = r101 + 1;
    L55:
        r102 = r102 + 1;
        goto L49
    L57:
        if (r101 == this.text.length()) goto L60;
        return;
    L60:
        throw new JSONException("illegal str, " + info());
    }

    public JSONScanner(String r100, int r101) {
        super(r101);
        this.text = r100;
        this.len = r100.length();
        this.f24933bp = -1;
        next();
        if (this.f24934ch != 65279) goto L6;
        next();
        return;
    }

    private boolean scanISO8601DateIfMatch(boolean r310, int r311) {
        if (r311 >= 8) goto L5;
        return false;
    L5:
        char r110 = charAt(this.f24933bp);
        char r111 = charAt(this.f24933bp + 1);
        char r100 = charAt(this.f24933bp + 2);
        int r112 = 3;
        char r101 = charAt(this.f24933bp + 3);
        char r102 = charAt(this.f24933bp + 4);
        char r103 = charAt(this.f24933bp + 5);
        char r104 = charAt(this.f24933bp + 6);
        char r105 = charAt(this.f24933bp + 7);
        if (r310 == true) goto L42;
        if (r311 <= 13) goto L42;
        char r106 = charAt((this.f24933bp + r311) - 1);
        char r113 = charAt((this.f24933bp + r311) - 2);
        if (r110 != '/') goto L42;
        if (r111 != 'D') goto L42;
        if (r100 != 'a') goto L42;
        if (r101 != 't') goto L42;
        if (r102 != 'e') goto L42;
        if (r103 != '(') goto L42;
        if (r106 != '/') goto L42;
        if (r113 != ')') goto L42;
        int r107 = -1;
        int r108 = 6;
    L26:
        if (r108 >= r311) goto L35;
        char r109 = charAt(this.f24933bp + r108);
        if (r109 != '+') goto L30;
        r107 = r108;
    L33:
        r108 = r108 + 1;
        goto L26
    L30:
        if (r109 < '0') goto L35;
        if (r109 <= '9') goto L33;
    L35:
        if (r107 != (-1)) goto L37;
        return false;
    L37:
        int r114 = this.f24933bp;
        int r115 = r114 + 6;
        long r116 = CastLongProtector.parseLong(subString(r115, (r114 + r107) - r115));
        Calendar r117 = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = r117;
        r117.setTimeInMillis(r116);
        this.token = 5;
        return true;
    L42:
        if (r311 == 8) goto L322;
        if (r311 == 14) goto L322;
        if (r311 != 16) goto L50;
        char r118 = charAt(this.f24933bp + 10);
        if (r118 == 'T') goto L322;
        if (r118 == ' ') goto L322;
    L50:
        if (r311 != 17) goto L55;
        if (charAt(this.f24933bp + 6) != '-') goto L322;
    L55:
        if (r311 >= 9) goto L58;
        return false;
    L58:
        char r119 = charAt(this.f24933bp + 8);
        char r120 = charAt(this.f24933bp + 9);
        if (r102 != '-') goto L64;
        if (r105 != '-') goto L64;
    L68:
        if (r120 != ' ') goto L72;
        char r121 = '0';
        int r122 = 9;
    L70:
        r111 = r119;
        r103 = r104;
    L71:
        r100 = r100;
    L134:
        if (checkDate(r110, r111, r100, r101, r103, r103, r121, r111) == true) goto L137;
        return false;
    L137:
        setCalendar(r110, r111, r100, r101, r103, r103, r121, r111);
        char r123 = charAt(this.f24933bp + r122);
        char r124 = OthersPermission.STICKY;
        if (r123 == 'T') goto L140;
    L156:
        if (r123 == r124) goto L193;
        if (r123 != ' ') goto L162;
        if (r310 == false) goto L193;
    L162:
        if (r123 != '\"') goto L164;
    L191:
        this.calendar.set(11, 0);
        this.calendar.set(12, 0);
        this.calendar.set(13, 0);
        this.calendar.set(14, 0);
        int r125 = this.f24933bp + r122;
        this.f24933bp = r125;
        this.f24934ch = charAt(r125);
        this.token = 5;
        return true;
    L164:
        if (r123 == 26) goto L191;
        if (r123 == 26085) goto L191;
        if (r123 == 51068) goto L191;
        if (r123 == '+') goto L177;
        if (r123 == '-') goto L177;
        return false;
    L177:
        if (this.len == (r122 + 6)) goto L179;
        return false;
    L179:
        if (charAt((this.f24933bp + r122) + 3) == ':') goto L181;
        return false;
    L181:
        if (charAt((this.f24933bp + r122) + 4) == '0') goto L183;
        return false;
    L183:
        if (charAt((this.f24933bp + r122) + 5) != '0') goto L408;
        setTime('0', '0', '0', '0', '0', '0');
        this.calendar.set(14, 0);
        setTimeZone(r123, charAt((this.f24933bp + r122) + 1), charAt((this.f24933bp + r122) + 2));
        return true;
    L408:
        return false;
    L193:
        if (r311 >= (r122 + 9)) goto L197;
        return false;
    L197:
        if (charAt((this.f24933bp + r122) + 3) == ':') goto L200;
        return false;
    L200:
        if (charAt((this.f24933bp + r122) + 6) == ':') goto L202;
        return false;
    L202:
        char r126 = charAt((this.f24933bp + r122) + 1);
        char r127 = charAt((this.f24933bp + r122) + 2);
        char r128 = charAt((this.f24933bp + r122) + 4);
        char r129 = charAt((this.f24933bp + r122) + 5);
        char r210 = charAt((this.f24933bp + r122) + 7);
        char r130 = charAt((this.f24933bp + r122) + 8);
        if (checkTime(r126, r127, r128, r129, r210, r130) == true) goto L206;
        return false;
    L206:
        setTime(r126, r127, r128, r129, r210, r130);
        if (charAt((this.f24933bp + r122) + 9) != '.') goto L233;
        int r131 = r122 + 11;
        if (r311 >= r131) goto L212;
        return false;
    L212:
        char r132 = charAt((this.f24933bp + r122) + 10);
        if (r132 >= '0') goto L215;
        return false;
    L215:
        if (r132 > '9') goto L409;
        int r133 = r132 - '0';
        if (r311 <= r131) goto L223;
        char r134 = charAt((this.f24933bp + r122) + 11);
        if (r134 < '0') goto L223;
        if (r134 > '9') goto L223;
        r133 = (r133 * 10) + (r134 - '0');
        int r135 = 2;
    L224:
        if (r135 != 2) goto L230;
        char r136 = charAt((this.f24933bp + r122) + 12);
        if (r136 < '0') goto L230;
        if (r136 > '9') goto L230;
        int r137 = r136 - '0';
        int r138 = r137 + (r133 * 10);
        r135 = 3;
    L234:
        this.calendar.set(14, r138);
        char r139 = charAt(((this.f24933bp + r122) + 10) + r135);
        if (r139 != ' ') goto L237;
        r135 = r135 + 1;
        r139 = charAt(((this.f24933bp + r122) + 10) + r135);
    L237:
        char r140 = r139;
        if (r140 != '+') goto L240;
    L251:
        char r141 = charAt((((this.f24933bp + r122) + 10) + r135) + 1);
        if (r141 >= '0') goto L254;
        return false;
    L254:
        if (r141 > '1') goto L412;
        char r142 = charAt((((this.f24933bp + r122) + 10) + r135) + 2);
        if (r142 >= '0') goto L259;
        return false;
    L259:
        if (r142 > '9') goto L411;
        char r143 = charAt((((this.f24933bp + r122) + 10) + r135) + 3);
        char r144 = '3';
        if (r143 != ':') goto L290;
        char r145 = charAt((((this.f24933bp + r122) + 10) + r135) + 4);
        char r146 = charAt((((this.f24933bp + r122) + 10) + r135) + 5);
        if (r145 != '4') goto L283;
        if (r146 != '5') goto L283;
        if (r141 != '1') goto L274;
        if (r142 == '2') goto L288;
        if (r142 != '3') goto L274;
    L288:
        r144 = r145;
        r112 = 6;
    L309:
        setTimeZone(r140, r141, r142, r144, r146);
    L310:
        int r147 = ((r122 + 10) + r135) + r112;
        char r148 = charAt(this.f24933bp + r147);
        if (r148 != 26) goto L313;
    L316:
        int r149 = this.f24933bp + r147;
        this.f24933bp = r149;
        this.f24934ch = charAt(r149);
        this.token = 5;
        return true;
    L313:
        if (r148 == '\"') goto L316;
        return false;
    L274:
        if (r141 == '0') goto L276;
        return false;
    L276:
        if (r142 == '5') goto L288;
        if (r142 == '8') goto L288;
        return false;
    L283:
        if (r145 == '0') goto L286;
        if (r145 == '3') goto L286;
        return false;
    L286:
        if (r146 == '0') goto L288;
        return false;
    L290:
        if (r143 != '0') goto L299;
        char r150 = charAt((((this.f24933bp + r122) + 10) + r135) + 4);
        if (r150 == '0') goto L296;
        if (r150 == '3') goto L296;
        return false;
    L296:
        r144 = r150;
    L297:
        r146 = '0';
    L298:
        r112 = 5;
        goto L309
    L299:
        if (r143 != '3') goto L304;
        if (charAt((((this.f24933bp + r122) + 10) + r135) + 4) == '0') goto L297;
    L304:
        if (r143 == '4') goto L306;
    L308:
        r144 = '0';
        r146 = '0';
        goto L309
    L306:
        if (charAt((((this.f24933bp + r122) + 10) + r135) + 4) != '5') goto L308;
        r144 = '4';
        r146 = '5';
        goto L298
    L411:
        return false;
    L412:
        return false;
    L240:
        if (r140 == '-') goto L251;
        if (r140 == 'Z') goto L245;
        r112 = 0;
        goto L310
    L245:
        if (this.calendar.getTimeZone().getRawOffset() == 0) goto L249;
        String[] r151 = TimeZone.getAvailableIDs(0);
        if (r151.length <= 0) goto L249;
        TimeZone r152 = TimeZone.getTimeZone(r151[0]);
        this.calendar.setTimeZone(r152);
    L249:
        r112 = 1;
    L230:
        r138 = r133;
    L223:
        r135 = 1;
        goto L224
    L409:
        return false;
    L233:
        r135 = -1;
        r138 = 0;
        goto L234
    L140:
        if (r311 == 16) goto L142;
    L155:
        r124 = OthersPermission.STICKY;
        goto L156
    L142:
        if (r122 != 8) goto L155;
        if (charAt(this.f24933bp + 15) != 'Z') goto L155;
        char r153 = charAt((this.f24933bp + r122) + 1);
        char r154 = charAt((this.f24933bp + r122) + 2);
        char r155 = charAt((this.f24933bp + r122) + 3);
        char r156 = charAt((this.f24933bp + r122) + 4);
        char r157 = charAt((this.f24933bp + r122) + 5);
        char r158 = charAt((this.f24933bp + r122) + 6);
        if (checkTime(r153, r154, r155, r156, r157, r158) == true) goto L149;
        return false;
    L149:
        setTime(r153, r154, r155, r156, r157, r158);
        this.calendar.set(14, 0);
        if (this.calendar.getTimeZone().getRawOffset() == 0) goto L154;
        String[] r159 = TimeZone.getAvailableIDs(0);
        if (r159.length <= 0) goto L154;
        TimeZone r160 = TimeZone.getTimeZone(r159[0]);
        this.calendar.setTimeZone(r160);
    L154:
        this.token = 5;
        return true;
    L72:
        r122 = 10;
    L73:
        r121 = r119;
        r103 = r104;
        r100 = r100;
        r103 = r103;
        r111 = r111;
        r111 = r120;
    L64:
        if (r102 != '/') goto L75;
        if (r105 == '/') goto L68;
    L75:
        if (r102 != '-') goto L83;
        if (r104 != '-') goto L83;
        if (r119 != ' ') goto L80;
        r103 = '0';
        r122 = 8;
    L79:
        r111 = r105;
        r101 = r101;
        r121 = '0';
        goto L134
    L80:
        r103 = '0';
        r122 = 9;
    L81:
        r103 = r103;
        r111 = r111;
        r111 = r119;
        r121 = r105;
        r101 = r101;
    L83:
        if (r100 == '.') goto L85;
    L86:
        if (r100 != '-') goto L90;
        if (r103 != '-') goto L90;
    L88:
        r111 = r105;
        r101 = r120;
        r103 = r101;
        r121 = r110;
        r122 = 10;
        r103 = r102;
        r110 = r104;
        r100 = r119;
    L90:
        if (r119 != 'T') goto L93;
        r103 = r102;
        r103 = r103;
        r110 = r110;
        r111 = r111;
        r122 = 8;
        r111 = r105;
        r101 = r101;
        r121 = r104;
        goto L71
    L93:
        if (r102 == 24180) goto L100;
        if (r102 == 45380) goto L100;
        return false;
    L100:
        if (r105 != 26376) goto L102;
    L121:
        if (r120 == 26085) goto L132;
        if (r120 == 51068) goto L132;
        if (charAt(this.f24933bp + 10) != 26085) goto L127;
    L131:
        r122 = 11;
        goto L73
    L127:
        if (charAt(this.f24933bp + 10) == 51068) goto L131;
        return false;
    L132:
        r121 = '0';
        r122 = 10;
        goto L70
    L102:
        if (r105 == 50900) goto L121;
        if (r104 == 26376) goto L112;
        if (r104 == 50900) goto L112;
        return false;
    L112:
        if (r119 == 26085) goto L120;
        if (r119 == 51068) goto L120;
        if (r120 == 26085) goto L119;
        if (r120 == 51068) goto L119;
        return false;
    L119:
        r103 = '0';
        r122 = 10;
    L120:
        r103 = '0';
        r122 = 10;
        goto L79
    L85:
        if (r103 == '.') goto L88;
    L322:
        if (r310 == false) goto L324;
        return false;
    L324:
        char r161 = charAt(this.f24933bp + 8);
        if (r102 != '-') goto L328;
        if (r105 != '-') goto L328;
        boolean r162 = true;
    L329:
        if (r162 == true) goto L331;
    L333:
        boolean r163 = false;
    L334:
        if (r162 == true) goto L336;
    L338:
        boolean r164 = false;
    L339:
        if (r164 == true) goto L347;
        if (r163 == true) goto L347;
        if (r102 != '-') goto L346;
        if (r104 != '-') goto L346;
        char r211 = r103;
        char r212 = r105;
        char r165 = '0';
        char r213 = '0';
    L349:
        if (checkDate(r110, r111, r100, r101, r165, r211, r213, r212) == true) goto L352;
        return false;
    L352:
        setCalendar(r110, r111, r100, r101, r165, r211, r213, r212);
        if (r311 == 8) goto L396;
        char r166 = charAt(this.f24933bp + 9);
        char r167 = charAt(this.f24933bp + 10);
        char r168 = charAt(this.f24933bp + 11);
        char r169 = charAt(this.f24933bp + 12);
        char r170 = charAt(this.f24933bp + 13);
        if (r164 == true) goto L357;
    L361:
        if (r163 == true) goto L363;
    L368:
        char r171 = r166;
        char r172 = r167;
        char r173 = r168;
        char r174 = r170;
        char r175 = r161;
        char r176 = r169;
    L370:
        if (checkTime(r175, r171, r172, r173, r176, r174) == true) goto L374;
        return false;
    L374:
        if (r311 != 17) goto L394;
        if (r164 == true) goto L394;
        char r177 = charAt(this.f24933bp + 14);
        char r178 = charAt(this.f24933bp + 15);
        char r179 = charAt(this.f24933bp + 16);
        if (r177 >= '0') goto L379;
        return false;
    L379:
        if (r177 > '9') goto L415;
        if (r178 < '0') goto L390;
        if (r178 > '9') goto L414;
        if (r179 < '0') goto L388;
        if (r179 > '9') goto L413;
        int r180 = (((r177 - '0') * 100) + ((r178 - '0') * 10)) + (r179 - '0');
    L395:
        int r181 = ((r176 - '0') * 10) + (r174 - '0');
        int r182 = ((r175 - '0') * 10) + (r171 - '0');
        int r183 = r180;
        int r184 = ((r172 - '0') * 10) + (r173 - '0');
    L397:
        this.calendar.set(11, r182);
        this.calendar.set(12, r184);
        this.calendar.set(13, r181);
        this.calendar.set(14, r183);
        this.token = 5;
        return true;
    L413:
        return false;
    L388:
        return false;
    L414:
        return false;
    L390:
        return false;
    L415:
        return false;
    L394:
        r180 = 0;
        goto L395
    L363:
        if (r167 != ' ') goto L365;
    L366:
        if (r170 != ':') goto L368;
    L367:
        char r185 = charAt(this.f24933bp + 14);
        r173 = charAt(this.f24933bp + 15);
        r172 = r185;
        r175 = r168;
        r171 = r169;
        r176 = '0';
        r174 = '0';
        goto L370
    L365:
        if (r167 != 'T') goto L368;
    L357:
        if (r167 != 'T') goto L361;
        if (r170 != ':') goto L361;
        if (charAt(this.f24933bp + 16) == 'Z') goto L367;
    L396:
        r184 = 0;
        r181 = 0;
        r183 = 0;
        r182 = 0;
    L346:
        r165 = r102;
        r211 = r103;
        r213 = r104;
        r212 = r105;
    L347:
        r212 = charAt(this.f24933bp + 9);
        r165 = r103;
        r211 = r104;
        r213 = r161;
        goto L349
    L336:
        if (r311 != 17) goto L338;
        r164 = true;
        goto L339
    L331:
        if (r311 != 16) goto L333;
        r163 = true;
    L328:
        r162 = false;
        goto L329
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char r100, int r101) {
        return this.text.indexOf(r100, r101);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public Collection<String> scanFieldStringArray(char[] r110, Class<?> r111) {
        this.matchStat = 0;
    L3:
        char r100 = this.f24934ch;
        if (r100 != '\n') goto L6;
    L87:
        int r101 = this.f24933bp + 1;
        this.f24933bp = r101;
        if (r101 < this.len) goto L90;
        char r102 = JSONLexer.EOI;
    L91:
        this.f24934ch = r102;
        goto L3
    L90:
        r102 = this.text.charAt(r101);
        goto L91
    L6:
        if (r100 == ' ') goto L87;
        if (charArrayCompare(this.text, this.f24933bp, r110) == true) goto L12;
        this.matchStat = -2;
        return null;
    L12:
        Collection<String> r103 = newCollectionByType(r111);
        int r104 = this.f24933bp;
        char r105 = this.f24934ch;
        int r106 = r110.length + r104;
        int r107 = r106 + 1;
        int r112 = -1;
        if (charAt(r106) != '[') goto L55;
        int r108 = r107 + 1;
        char r109 = charAt(r107);
    L16:
        if (r109 != '\"') goto L34;
        int r113 = indexOf(Typography.quote, r108);
        if (r113 == r112) goto L32;
        String r114 = subString(r108, r113 - r108);
        if (r114.indexOf(92) == r112) goto L30;
    L21:
        int r115 = r113 - 1;
        int r116 = 0;
    L22:
        if (r115 < 0) goto L27;
        if (charAt(r115) != '\\') goto L27;
        r116 = r116 + 1;
        r115 = r115 - 1;
    L27:
        if ((r116 % 2) == 0) goto L28;
        r113 = indexOf(Typography.quote, r113 + 1);
        goto L21
    L28:
        int r117 = r113 - r108;
        r114 = JSONLexerBase.readString(sub_chars(r108, r117), r117);
    L30:
        int r118 = r113 + 1;
        int r119 = r118 + 1;
        char r120 = charAt(r118);
        r103.add(r114);
    L38:
        if (r120 != ',') goto L40;
        r109 = charAt(r119);
        r108 = r119 + 1;
        r112 = -1;
        goto L16
    L40:
        if (r120 != ']') goto L45;
        int r121 = r119 + 1;
        char r122 = charAt(r119);
    L43:
        if (JSONLexerBase.isWhitespace(r122) == false) goto L51;
        int r123 = r121 + 1;
        char r124 = charAt(r121);
        r121 = r123;
        r122 = r124;
    L51:
        Collection<String> r125 = r103;
        char r126 = r122;
        int r127 = 3;
    L57:
        this.f24933bp = r121;
        if (r126 != ',') goto L62;
        this.f24934ch = charAt(r121);
        this.matchStat = r127;
        return r125;
    L62:
        if (r126 != '}') goto L83;
        char r128 = charAt(r121);
    L64:
        if (r128 == ',') goto L65;
        if (r128 == ']') goto L67;
        if (r128 == '}') goto L69;
        if (r128 == 26) goto L72;
        boolean r129 = false;
    L77:
        if (JSONLexerBase.isWhitespace(r128) == false) goto L79;
        int r130 = r121 + 1;
        char r131 = charAt(r121);
        this.f24933bp = r130;
        r129 = true;
        r128 = r131;
        r121 = r130;
        goto L77
    L79:
        if (r129 == true) goto L64;
        this.matchStat = -1;
        return null;
    L72:
        this.token = 20;
        this.f24934ch = r128;
    L73:
        this.matchStat = 4;
        return r125;
    L69:
        this.token = 13;
        int r132 = this.f24933bp + 1;
        this.f24933bp = r132;
        this.f24934ch = charAt(r132);
        goto L73
    L67:
        this.token = 15;
        int r133 = this.f24933bp + 1;
        this.f24933bp = r133;
        this.f24934ch = charAt(r133);
        goto L73
    L65:
        this.token = 16;
        int r134 = this.f24933bp + 1;
        this.f24933bp = r134;
        this.f24934ch = charAt(r134);
        goto L73
    L83:
        this.f24934ch = r105;
        this.f24933bp = r104;
        this.matchStat = -1;
        return null;
    L45:
        this.matchStat = -1;
        return null;
    L32:
        throw new JSONException("unclosed str");
    L34:
        if (r109 != 'n') goto L47;
        if (this.text.startsWith("ull", r108) == false) goto L47;
        int r135 = r108 + 3;
        r120 = charAt(r135);
        r103.add(null);
        r119 = r135 + 1;
    L47:
        if (r109 == ']') goto L49;
    L52:
        this.matchStat = -1;
        return null;
    L49:
        if (r103.size() != 0) goto L52;
        r121 = r108 + 1;
        r122 = charAt(r108);
        goto L51
    L55:
        if (this.text.startsWith("ull", r107) == false) goto L85;
        r127 = 3;
        int r136 = r107 + 3;
        r121 = r136 + 1;
        r126 = charAt(r136);
        r125 = null;
        goto L57
    L85:
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long r110, boolean r210) {
        int r100 = this.token;
        int r101 = -1;
        if (r100 != 20) goto L6;
        return -1;
    L6:
        if (r100 == 13) goto L240;
        int r102 = 15;
        if (r100 == 15) goto L240;
        int r103 = 16;
        if (r100 == 12) goto L16;
        if (r100 == 16) goto L16;
        throw new UnsupportedOperationException(JSONToken.name(this.token));
    L16:
        char r104 = this.f24934ch;
        if (r104 == '}') goto L18;
        if (r104 == 26) goto L22;
        if (r104 == '\"') goto L27;
        skipWhitespace();
    L27:
        if (this.f24934ch != '\"') goto L239;
        int r105 = this.f24933bp + 1;
        long r111 = TypeUtils.fnv1a_64_magic_hashcode;
    L30:
        if (r105 >= this.text.length()) goto L46;
        char r112 = this.text.charAt(r105);
        if (r112 != '\\') goto L38;
        r105 = r105 + 1;
        if (r105 == this.text.length()) goto L37;
        r112 = this.text.charAt(r105);
        goto L38
    L37:
        throw new JSONException("unclosed str, " + info());
    L38:
        if (r112 == '\"') goto L39;
        r111 = (r111 ^ ((long) r112)) * TypeUtils.fnv1a_64_magic_prime;
        r105 = r105 + 1;
        goto L30
    L39:
        int r106 = r105 + 1;
        this.f24933bp = r106;
        if (r106 < this.text.length()) goto L42;
        char r107 = JSONLexer.EOI;
    L43:
        this.f24934ch = r107;
        goto L46
    L42:
        r107 = this.text.charAt(this.f24933bp);
    L46:
        if (r111 == r110) goto L48;
        if (this.f24934ch == ':') goto L86;
        skipWhitespace();
    L86:
        if (this.f24934ch != ':') goto L237;
        int r113 = this.f24933bp + 1;
        this.f24933bp = r113;
        if (r113 < this.text.length()) goto L90;
        char r114 = JSONLexer.EOI;
    L91:
        this.f24934ch = r114;
        if (r114 != '\"') goto L94;
    L118:
        char r108 = this.f24934ch;
        if (r108 == '-') goto L206;
        if (r108 == '+') goto L206;
        if (r108 < '0') goto L124;
        if (r108 <= '9') goto L206;
    L124:
        if (r108 != '\"') goto L133;
        skipString();
        char r109 = this.f24934ch;
        if (r109 == ',') goto L130;
        if (r109 == '}') goto L130;
        skipWhitespace();
    L130:
        if (this.f24934ch != ',') goto L235;
        next();
    L235:
        r101 = -1;
        r102 = 15;
        r103 = 16;
        goto L16
    L133:
        if (r108 != 't') goto L149;
        next();
        if (this.f24934ch != 'r') goto L141;
        next();
        if (this.f24934ch != 'u') goto L141;
        next();
        if (this.f24934ch != 'e') goto L141;
        next();
    L141:
        char r115 = this.f24934ch;
        if (r115 == ',') goto L146;
        if (r115 == '}') goto L146;
        skipWhitespace();
    L146:
        if (this.f24934ch != ',') goto L235;
        next();
        goto L235
    L149:
        if (r108 != 'n') goto L165;
        next();
        if (this.f24934ch != 'u') goto L157;
        next();
        if (this.f24934ch != 'l') goto L157;
        next();
        if (this.f24934ch != 'l') goto L157;
        next();
    L157:
        char r116 = this.f24934ch;
        if (r116 == ',') goto L162;
        if (r116 == '}') goto L162;
        skipWhitespace();
    L162:
        if (this.f24934ch != ',') goto L235;
        next();
        goto L235
    L165:
        if (r108 != 'f') goto L182;
        next();
        if (this.f24934ch != 'a') goto L175;
        next();
        if (this.f24934ch != 'l') goto L175;
        next();
        if (this.f24934ch != 's') goto L175;
        next();
        if (this.f24934ch != 'e') goto L175;
        next();
    L175:
        char r117 = this.f24934ch;
        if (r117 == ',') goto L180;
        if (r117 == '}') goto L180;
        skipWhitespace();
    L180:
        if (this.f24934ch != ',') goto L235;
        next();
        goto L235
    L182:
        if (r108 != '{') goto L196;
        int r118 = this.f24933bp + 1;
        this.f24933bp = r118;
        if (r118 < this.text.length()) goto L186;
        char r119 = JSONLexer.EOI;
    L187:
        this.f24934ch = r119;
        if (r210 == true) goto L189;
        skipObject(false);
        if (this.token != 13) goto L235;
        return -1;
    L189:
        this.token = 12;
        return 1;
    L186:
        r119 = this.text.charAt(r118);
        goto L187
    L196:
        if (r108 != '[') goto L205;
        next();
        if (r210 == true) goto L199;
        skipArray(false);
        if (this.token != 13) goto L235;
        return -1;
    L199:
        this.token = 14;
        return 2;
    L205:
        throw new UnsupportedOperationException();
    L206:
        next();
    L207:
        char r120 = this.f24934ch;
        if (r120 < '0') goto L212;
        if (r120 > '9') goto L212;
        next();
    L212:
        if (r120 != '.') goto L218;
        next();
    L214:
        char r121 = this.f24934ch;
        if (r121 < '0') goto L218;
        if (r121 > '9') goto L218;
        next();
    L218:
        char r122 = this.f24934ch;
        if (r122 == 'E') goto L221;
        if (r122 == 'e') goto L221;
    L230:
        if (this.f24934ch == ',') goto L233;
        skipWhitespace();
    L233:
        if (this.f24934ch != ',') goto L235;
        next();
    L221:
        next();
        char r123 = this.f24934ch;
        if (r123 == '-') goto L224;
        if (r123 == '+') goto L224;
    L225:
        char r124 = this.f24934ch;
        if (r124 < '0') goto L230;
        if (r124 > '9') goto L230;
        next();
    L224:
        next();
        goto L225
    L94:
        if (r114 == '\'') goto L118;
        if (r114 == '{') goto L118;
        if (r114 == '[') goto L118;
        if (r114 == '0') goto L118;
        if (r114 == '1') goto L118;
        if (r114 == '2') goto L118;
        if (r114 == '3') goto L118;
        if (r114 == '4') goto L118;
        if (r114 == '5') goto L118;
        if (r114 == '6') goto L118;
        if (r114 == '7') goto L118;
        if (r114 == '8') goto L118;
        if (r114 == '9') goto L118;
        if (r114 == '+') goto L118;
        if (r114 == '-') goto L118;
        skipWhitespace();
        goto L118
    L90:
        r114 = this.text.charAt(r113);
        goto L91
    L237:
        throw new JSONException("illegal json, " + info());
    L48:
        if (this.f24934ch == ':') goto L51;
        skipWhitespace();
    L51:
        if (this.f24934ch != ':') goto L275;
        int r125 = this.f24933bp + 1;
        this.f24933bp = r125;
        if (r125 < this.text.length()) goto L55;
        char r126 = JSONLexer.EOI;
    L56:
        this.f24934ch = r126;
        if (r126 != ',') goto L64;
        int r127 = this.f24933bp + 1;
        this.f24933bp = r127;
        if (r127 < this.text.length()) goto L61;
        char r128 = JSONLexer.EOI;
    L62:
        this.f24934ch = r128;
        this.token = r103;
        return 3;
    L61:
        r128 = this.text.charAt(r127);
        goto L62
    L64:
        if (r126 != ']') goto L70;
        int r129 = this.f24933bp + 1;
        this.f24933bp = r129;
        if (r129 < this.text.length()) goto L68;
        char r130 = JSONLexer.EOI;
    L69:
        this.f24934ch = r130;
        this.token = r102;
        return 3;
    L68:
        r130 = this.text.charAt(r129);
        goto L69
    L70:
        if (r126 != '}') goto L76;
        int r131 = this.f24933bp + 1;
        this.f24933bp = r131;
        if (r131 < this.text.length()) goto L74;
        char r132 = JSONLexer.EOI;
    L75:
        this.f24934ch = r132;
        this.token = 13;
        return 3;
    L74:
        r132 = this.text.charAt(r131);
        goto L75
    L76:
        if (r126 < '0') goto L79;
        if (r126 > '9') goto L79;
        this.f24936sp = 0;
        this.pos = this.f24933bp;
        scanNumber();
        return 3;
    L79:
        nextToken(2);
        return 3;
    L55:
        r126 = this.text.charAt(r125);
        goto L56
    L275:
        return 3;
    L239:
        throw new UnsupportedOperationException();
    L22:
        return r101;
    L18:
        next();
        nextToken();
        return r101;
    L240:
        nextToken();
        return -1;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String subString(int r100, int r101) {
        if (ASMUtils.IS_ANDROID == false) goto L11;
        char[] r102 = this.sbuf;
        if (r101 >= r102.length) goto L8;
        this.text.getChars(r100, r100 + r101, r102, 0);
        return new String(this.sbuf, 0, r101);
    L8:
        char[] r103 = new char[r101];
        this.text.getChars(r100, r101 + r100, r103, 0);
        return new String(r103);
    L11:
        return this.text.substring(r100, r101 + r100);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int r100, int r101) {
        if (ASMUtils.IS_ANDROID == false) goto L8;
        char[] r102 = this.sbuf;
        if (r101 >= r102.length) goto L8;
        this.text.getChars(r100, r101 + r100, r102, 0);
        return this.sbuf;
    L8:
        char[] r103 = new char[r101];
        this.text.getChars(r100, r101 + r100, r103, 0);
        return r103;
    }

    public JSONScanner(char[] r100, int r101) {
        this(r100, r101, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] r100, int r101, int r102) {
        this(new String(r100, 0, r101), r102);
    }

    public static boolean charArrayCompare(String r100, int r101, char[] r102) {
        int r103 = r102.length;
        if ((r103 + r101) <= r100.length()) goto L5;
        return false;
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        if (r102[r104] != r100.charAt(r101 + r104)) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void copyTo(int r100, int r101, char[] r102) {
        this.text.getChars(r100, r101 + r100, r102, 0);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public String[] scanFieldStringArray(char[] r100, int r110, SymbolTable r111) {
        int r101 = this.f24933bp;
        char r102 = this.f24934ch;
    L4:
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L7;
        next();
        goto L4
    L7:
        if (r100 == null) goto L24;
        this.matchStat = 0;
        if (charArrayCompare(r100) == true) goto L12;
        this.matchStat = -2;
        return null;
    L12:
        int r103 = this.f24933bp + r100.length;
        int r104 = r103 + 1;
        char r105 = this.text.charAt(r103);
    L14:
        if (JSONLexerBase.isWhitespace(r105) == false) goto L17;
        r105 = this.text.charAt(r104);
        r104 = r104 + 1;
        goto L14
    L17:
        if (r105 != ':') goto L22;
        int r106 = r104 + 1;
        char r107 = this.text.charAt(r104);
    L20:
        if (JSONLexerBase.isWhitespace(r107) == false) goto L26;
        r107 = this.text.charAt(r106);
        r106 = r106 + 1;
    L26:
        if (r107 != '[') goto L62;
        this.f24933bp = r106;
        this.f24934ch = this.text.charAt(r106);
        if (r110 < 0) goto L30;
        String[] r108 = new String[r110];
    L31:
        int r112 = 0;
    L33:
        if (JSONLexerBase.isWhitespace(this.f24934ch) == true) goto L34;
        if (this.f24934ch != '\"') goto L37;
        String r109 = scanSymbol(r111, Typography.quote);
        if (r112 != r108.length) goto L42;
        String[] r113 = new String[(r108.length + (r108.length >> 1)) + 1];
        System.arraycopy(r108, 0, r113, 0, r108.length);
        r108 = r113;
    L42:
        int r114 = r112 + 1;
        r108[r112] = r109;
    L44:
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L47;
        next();
        goto L44
    L47:
        if (this.f24934ch != ',') goto L50;
        next();
        r112 = r114;
        goto L33
    L50:
        if (r108.length == r114) goto L53;
        String[] r115 = new String[r114];
        System.arraycopy(r108, 0, r115, 0, r114);
        r108 = r115;
    L53:
        if (JSONLexerBase.isWhitespace(this.f24934ch) == false) goto L56;
        next();
        goto L53
    L56:
        if (this.f24934ch != ']') goto L59;
        next();
        return r108;
    L59:
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L37:
        this.f24933bp = r101;
        this.f24934ch = r102;
        this.matchStat = -1;
        return null;
    L34:
        next();
        goto L33
    L30:
        r108 = new String[4];
        goto L31
    L62:
        if (r107 == 'n') goto L64;
    L67:
        this.matchStat = -1;
        return null;
    L64:
        if (this.text.startsWith("ull", this.f24933bp + 1) == false) goto L67;
        int r116 = this.f24933bp + 4;
        this.f24933bp = r116;
        this.f24934ch = this.text.charAt(r116);
        return null;
    L22:
        this.matchStat = -1;
        return null;
    L24:
        r106 = this.f24933bp + 1;
        r107 = this.f24934ch;
        goto L26
    }

    public void setTimeZone(char r100, char r101, char r102) {
        setTimeZone(r100, r101, r102, '0', '0');
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final String addSymbol(int r100, int r101, int r102, SymbolTable r103) {
        return r103.addSymbol(this.text, r100, r101, r102);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void arrayCopy(int r100, char[] r101, int r102, int r103) {
        this.text.getChars(r100, r103 + r100, r101, r102);
    }

    public void setTimeZone(char r100, char r101, char r102, char r103, char r104) {
        int r105 = (((((r101 - '0') * 10) + (r102 - '0')) * AnnouncementViewModel.HOUR_DURATION) * 1000) + (((((r103 - '0') * 10) + (r104 - '0')) * 60) * 1000);
        if (r100 != '-') goto L6;
        r105 = -r105;
    L6:
        if (this.calendar.getTimeZone().getRawOffset() == r105) goto L9;
        this.calendar.setTimeZone(new SimpleTimeZone(r105, Integer.toString(r105)));
        return;
    }

    public void setTime(char r100, char r101, char r102, char r103, char r104, char r105) {
        this.calendar.set(11, ((r100 - '0') * 10) + (r101 - '0'));
        this.calendar.set(12, ((r102 - '0') * 10) + (r103 - '0'));
        this.calendar.set(13, ((r104 - '0') * 10) + (r105 - '0'));
    }

    private void setCalendar(char r100, char r101, char r102, char r103, char r104, char r105, char r106, char r110) {
        Calendar r107 = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = r107;
        r107.set(1, ((((r100 - '0') * 1000) + ((r101 - '0') * 100)) + ((r102 - '0') * 10)) + (r103 - '0'));
        this.calendar.set(2, (((r104 - '0') * 10) + (r105 - '0')) - 1);
        this.calendar.set(5, ((r106 - '0') * 10) + (r110 - '0'));
    }
}
