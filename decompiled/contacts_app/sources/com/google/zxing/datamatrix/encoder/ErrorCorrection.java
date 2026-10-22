package com.google.zxing.datamatrix.encoder;

import com.android.contacts.list.ContactsRequest;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.monitor.util.ActivityThreadUtils;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.v2.OSheetBaseKt;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import obric.widget.ChipsView;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorCorrection {
    private static final int[] ALOG = null;
    private static final int[][] FACTORS = null;
    private static final int[] FACTOR_SETS = null;
    private static final int[] LOG = null;
    private static final int MODULO_VALUE = 301;

    static {
        FACTOR_SETS = new int[]{5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
        int r3 = 0;
        FACTORS = new int[][]{new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, HttpStatus.SC_RESET_CONTENT, 12, 194, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, OSheetBaseKt.SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT, 9, 233, 71, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, HttpStatus.SC_RESET_CONTENT, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, ContactsRequest.ACTION_PICK_CALLLOG_NUM, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, ContactsRequest.ACTION_PICK_CALLLOG_NUM, 233, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 93, 255}, new int[]{245, WorkQueueKt.MASK, 242, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, HttpStatus.SC_RESET_CONTENT, 188, 237, 87, 191, 106, 16, ChipsView.LIGHT, 118, 23, 37, 90, 170, HttpStatus.SC_RESET_CONTENT, 131, 88, 120, 100, 66, 138, 186, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, 82, 44, 176, 87, 187, ChipsView.LIGHT, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, ActivityThreadUtils.EXECUTE_TRANSACTION, 36, 223, 38, 200, SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF, 54, 228, ChipsView.RECOMMENDED, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, HttpStatus.SC_MULTI_STATUS, 164, 13, 137, 245, WorkQueueKt.MASK, 67, 247, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, 108, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, 250, 106, 185, 221, 175, 64, 114, 71, 161, 44, ChipsView.LIGHT, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, HttpStatus.SC_NO_CONTENT}, new int[]{220, 228, 173, 89, 251, 149, ActivityThreadUtils.EXECUTE_TRANSACTION, 56, 89, 33, ChipsView.LIGHT, OSheetBaseKt.SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT, 154, 36, 73, WorkQueueKt.MASK, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF, 63, 96, 103, 82, 186}};
        LOG = new int[256];
        ALOG = new int[255];
        int r2 = 1;
    L3:
        if (r3 >= 255) goto L8;
        ALOG[r3] = r2;
        LOG[r2] = r3;
        r2 = r2 << 1;
        if (r2 < 256) goto L7;
        r2 = r2 ^ 301;
    L7:
        r3 = r3 + 1;
        goto L3
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String r11, SymbolInfo r12) {
        if (r11.length() != r12.getDataCapacity()) goto L27;
        StringBuilder r0 = new StringBuilder(r12.getDataCapacity() + r12.getErrorCodewords());
        r0.append(r11);
        int r1 = r12.getInterleavedBlockCount();
        if (r1 != 1) goto L7;
        r0.append(createECCBlock(r11, r12.getErrorCodewords()));
    L25:
        return r0.toString();
    L7:
        r0.setLength(r0.capacity());
        int[] r2 = new int[r1];
        int[] r3 = new int[r1];
        int[] r4 = new int[r1];
        int r6 = 0;
    L8:
        if (r6 >= r1) goto L13;
        int r7 = r6 + 1;
        r2[r6] = r12.getDataLengthForInterleavedBlock(r7);
        r3[r6] = r12.getErrorLengthForInterleavedBlock(r7);
        r4[r6] = 0;
        if (r6 <= 0) goto L12;
        r4[r6] = r4[r6 - 1] + r2[r6];
    L12:
        r6 = r7;
        goto L8
    L13:
        int r5 = 0;
    L14:
        if (r5 >= r1) goto L25;
        StringBuilder r8 = new StringBuilder(r2[r5]);
        int r9 = r5;
    L17:
        if (r9 >= r12.getDataCapacity()) goto L19;
        r8.append(r11.charAt(r9));
        r9 = r9 + r1;
        goto L17
    L19:
        String r10 = createECCBlock(r8.toString(), r3[r5]);
        int r13 = r5;
        int r14 = 0;
    L21:
        if (r13 >= (r3[r5] * r1)) goto L23;
        r0.setCharAt(r12.getDataCapacity() + r13, r10.charAt(r14));
        r13 = r13 + r1;
        r14 = r14 + 1;
        goto L21
    L23:
        r5 = r5 + 1;
        goto L14
    L27:
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String createECCBlock(CharSequence r2, int r3) {
        return createECCBlock(r2, 0, r2.length(), r3);
    }

    private static String createECCBlock(CharSequence r11, int r12, int r13, int r14) {
        int r0 = 0;
        int r1 = 0;
    L3:
        int[] r2 = FACTOR_SETS;
        if (r1 >= r2.length) goto L9;
        if (r2[r1] == r14) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L37;
        int[] r3 = FACTORS[r1];
        char[] r4 = new char[r14];
        int r5 = 0;
    L12:
        if (r5 >= r14) goto L14;
        r4[r5] = 0;
        r5 = r5 + 1;
        goto L12
    L14:
        int r6 = r12;
    L16:
        if (r6 >= (r12 + r13)) goto L31;
        int r7 = r14 - 1;
        int r8 = r4[r7] ^ r11.charAt(r6);
    L18:
        if (r7 <= 0) goto L25;
        if (r8 == 0) goto L23;
        int r9 = r3[r7];
        if (r9 == 0) goto L23;
        char r10 = r4[r7 - 1];
        int[] r15 = ALOG;
        int[] r16 = LOG;
        r4[r7] = (char) (r15[(r16[r8] + r16[r9]) % 255] ^ r10);
    L24:
        r7 = r7 - 1;
    L23:
        r4[r7] = r4[r7 - 1];
        goto L24
    L25:
        if (r8 == 0) goto L29;
        int r17 = r3[0];
        if (r17 == 0) goto L29;
        int[] r18 = ALOG;
        int[] r19 = LOG;
        r4[0] = (char) r18[(r19[r8] + r19[r17]) % 255];
    L30:
        r6 = r6 + 1;
    L29:
        r4[0] = 0;
        goto L30
    L31:
        char[] r110 = new char[r14];
    L32:
        if (r0 >= r14) goto L35;
        r110[r0] = r4[(r14 - r0) - 1];
        r0 = r0 + 1;
        goto L32
    L35:
        return String.valueOf(r110);
    L37:
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + r14);
    L9:
        r1 = -1;
        goto L10
    }
}
