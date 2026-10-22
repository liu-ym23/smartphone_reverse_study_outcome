package com.google.zxing.pdf417.encoder;

import com.android.contacts.list.ContactsRequest;
import com.android.contacts.util.Constants;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.monitor.util.ActivityThreadUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.v2.OSheetBaseKt;
import com.obric.oui.toast.OPopupNotice;
import com.obric.oui.utils.AnimTokens;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import obric.widget.ChipsView;

/* JADX INFO: loaded from: classes3.dex */
final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = null;

    static {
        EC_COEFFICIENTS = new int[][]{new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, EntityType.FILE, SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, ChipsView.LIGHT, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, 400, 672, 762, 283, 184, AbstractDialog.HORIZONTAL_MAX_WIDTH, 35, 519, 31, OPopupNotice.DUX_BOTTOM_NOTICE_SMALL_WINDOW_WIDTH_IN_DP, 594, 225, 535, 517, 352, 605, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, OSheetBaseKt.SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, AnimTokens.OUI_ANIMATION_DURATION_LONG_3, 86, EntityType.FILE, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, HttpStatus.SC_NO_CONTENT, 82, 586, 708, 250, 905, 786, 138, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, HttpStatus.SC_NO_CONTENT, 796, 605, 540, 913, EntityType.FILE, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, 177, 752, 607, 640, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, AnimTokens.OUI_ANIMATION_DURATION_LONG_3, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, ActivityThreadUtils.EXECUTE_TRANSACTION, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, HttpStatus.SC_MULTI_STATUS, 409, 574, 118, 498, 285, 380, AnimTokens.OUI_ANIMATION_DURATION_MEDIUM_3, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, Constants.BYTEDANCEOS_DISPLAY_PHOTO_DIM, 435, 543, 203, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, HttpStatus.SC_REQUEST_TIMEOUT, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, HttpStatus.SC_NO_CONTENT, 681, HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, 518, 794, 395, ViewUtils.EDGE_TO_EDGE_FLAGS, 848, 51, 610, 384, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 190, 826, 328, 596, 786, 303, 570, 381, 415, 641, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT, 237, ContactsRequest.ACTION_PICK_CALLLOG_NUM, 429, 531, HttpStatus.SC_MULTI_STATUS, 676, 710, 89, OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, OSheetBaseKt.SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, 327, 589, 777, 699, 688, 43, HttpStatus.SC_REQUEST_TIMEOUT, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, ActivityThreadUtils.EXECUTE_TRANSACTION, 672, 729, 624, 59, 193, 417, 158, 209, 563, 564, 343, 693, 109, 608, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, 441, HttpStatus.SC_MULTI_STATUS, 300, 892, 827, 141, 537, 381, 662, 513, 56, 252, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, 424, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, 164, 332, 899, 165, 726, 600, 325, 498, 655, 357, 752, ViewUtils.EDGE_TO_EDGE_FLAGS, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, 389, OSheetBaseKt.SHEET_LANDSCAPE_MAX_CONTENT_HEIGHT, 31, 121, 303, 263}};
    }

    private PDF417ErrorCorrection() {
    }

    static int getErrorCorrectionCodewordCount(int r1) {
        if (r1 < 0) goto L8;
        if (r1 > 8) goto L8;
        return 1 << (r1 + 1);
    L8:
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int r1) throws WriterException {
        if (r1 <= 0) goto L22;
        if (r1 > 40) goto L8;
        return 2;
    L8:
        if (r1 > 160) goto L12;
        return 3;
    L12:
        if (r1 > 320) goto L16;
        return 4;
    L16:
        if (r1 > 863) goto L20;
        return 5;
    L20:
        throw new WriterException("No recommendation possible");
    L22:
        throw new IllegalArgumentException("n must be > 0");
    }

    static String generateErrorCorrection(CharSequence r9, int r10) {
        int r0 = getErrorCorrectionCodewordCount(r10);
        char[] r1 = new char[r0];
        int r2 = r9.length();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        int r6 = r0 - 1;
        int r5 = (r9.charAt(r4) + r1[r6]) % PDF417Common.NUMBER_OF_CODEWORDS;
    L5:
        if (r6 <= 0) goto L7;
        r1[r6] = (char) ((r1[r6 - 1] + (929 - ((EC_COEFFICIENTS[r10][r6] * r5) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
        r6 = r6 - 1;
        goto L5
    L7:
        r1[0] = (char) ((929 - ((r5 * EC_COEFFICIENTS[r10][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        r4 = r4 + 1;
        goto L3
    L8:
        StringBuilder r11 = new StringBuilder(r0);
        int r3 = r0 - 1;
    L9:
        if (r3 < 0) goto L15;
        char r12 = r1[r3];
        if (r12 == 0) goto L13;
        r1[r3] = (char) (929 - r12);
    L13:
        r11.append(r1[r3]);
        r3 = r3 - 1;
        goto L9
    L15:
        return r11.toString();
    }
}
