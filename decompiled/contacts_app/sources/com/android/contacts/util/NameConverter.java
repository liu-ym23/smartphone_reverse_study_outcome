package com.android.contacts.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class NameConverter {
    private static String[] COMPOUND_SURNAMES = null;
    public static final String[] FULL_STRUCTURED_NAME_FIELDS = null;
    public static final String NUMBER_REGEX = "\\d";
    public static final String[] STRUCTURED_NAME_FIELDS = null;
    private static char[] SURNAMES = null;
    public static String TAG = "NameConverter";

    public static class NameHolder {
        public String display;
        public String family;
        public String given;
        public Long id;
        public String middle;
        public String prefix;
        public String suffix;

        public NameHolder() {
            this.display = null;
            this.prefix = null;
            this.given = null;
            this.middle = null;
            this.family = null;
            this.suffix = null;
            this.id = -1L;
        }

        public void setNameByTag(String r2, String r3) {
            if (TextUtils.equals("data4", r2) == false) goto L6;
            this.prefix = r3;
            return;
        L6:
            if (TextUtils.equals(DBHelper.COL_DATA2, r2) == false) goto L9;
            this.given = r3;
            return;
        L9:
            if (TextUtils.equals("data5", r2) == false) goto L12;
            this.middle = r3;
            return;
        L12:
            if (TextUtils.equals(DBHelper.COL_DATA3, r2) == false) goto L15;
            this.family = r3;
            return;
        L15:
            if (TextUtils.equals("data6", r2) == false) goto L17;
            this.suffix = r3;
            return;
        L17:
            this.display = r3;
        }

        public boolean isAvailable() {
            if (this.id.longValue() > 0) goto L5;
        L17:
            return false;
        L5:
            if (this.display == null) goto L7;
        L16:
            return true;
        L7:
            if (this.prefix != null) goto L16;
            if (this.given != null) goto L16;
            if (this.middle != null) goto L16;
            if (this.family != null) goto L16;
            if (this.suffix == null) goto L17;
            goto L16
        }

        public String getNameByTag(String r2) {
            if (TextUtils.equals("data4", r2) == false) goto L7;
            return this.prefix;
        L7:
            if (TextUtils.equals(DBHelper.COL_DATA2, r2) == false) goto L11;
            return this.given;
        L11:
            if (TextUtils.equals("data5", r2) == false) goto L15;
            return this.middle;
        L15:
            if (TextUtils.equals(DBHelper.COL_DATA3, r2) == false) goto L19;
            return this.family;
        L19:
            if (TextUtils.equals("data6", r2) == false) goto L23;
            return this.suffix;
        L23:
            return this.display;
        }

        public String toString() {
            return "display:" + this.display + " prefix :" + this.prefix + " given:" + this.given + " middle:" + this.middle + " family:" + this.family + " suffix:" + this.suffix;
        }
    }

    public NameConverter() {
    }

    static {
        STRUCTURED_NAME_FIELDS = new String[]{"data4", DBHelper.COL_DATA2, "data5", DBHelper.COL_DATA3, "data6"};
        FULL_STRUCTURED_NAME_FIELDS = new String[]{"data1", "data4", DBHelper.COL_DATA2, "data5", DBHelper.COL_DATA3, "data6"};
        COMPOUND_SURNAMES = new String[]{"万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "尉迟", "公羊", "澹台", "公冶", "宗政", "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "亓官", "司寇", "仉督", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "乐正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "榖梁", "段干", "百里", "东郭", "南门", "呼延", "羊舌", "梁丘", "左丘", "东门", "西门", "第五", "南宫", "司馬", "歐陽", "諸葛", "聞人", "東方", "赫連", "尉遲", "澹臺", "濮陽", "單于", "公孫", "仲孫", "軒轅", "锺離", "長孫", "鮮于", "閭丘", "子車", "顓孫", "巫馬", "樂正", "壤駟", "拓拔", "夾谷", "穀粱", "東郭", "南門", "微生", "東門", "西門", "南宮"};
        SURNAMES = new char[]{36213, 38065, 23385, 26446, 21608, 21556, 37073, 29579, 20911, 38472, 35098, 21355, 33931, 27784, 38889, 26472, 26417, 31206, 23588, 35768, 20309, 21525, 26045, 24352, 23380, 26361, 20005, 21326, 37329, 39759, 38518, 23004, 25114, 35874, 37049, 21947, 26575, 27700, 31398, 31456, 20113, 33487, 28504, 33883, 22874, 33539, 24429, 37070, 40065, 38886, 26124, 39532, 33495, 20964, 33457, 26041, 20446, 20219, 34945, 26611, 37190, 40077, 21490, 21776, 36153, 24265, 23697, 34203, 38647, 36154, 20522, 27748, 28373, 27575, 32599, 27605, 37085, 37036, 23433, 24120, 20048, 20110, 26102, 20613, 30382, 21342, 40784, 24247, 20313, 20803, 21340, 39038, 23391, 24179, 40644, 21644, 31302, 33831, 23609, 23002, 37045, 28251, 27754, 31041, 27611, 31161, 29380, 31859, 36125, 26126, 33255, 35745, 20239, 25104, 25140, 35848, 23435, 33541, 24222, 29066, 32426, 33298, 23624, 39033, 31069, 33891, 26753, 26460, 38446, 34013, 38389, 24109, 23395, 40635, 24378, 36158, 36335, 23044, 21361, 27743, 31461, 39068, 37101, 26757, 30427, 26519, 20993, 38047, 24464, 37041, 39558, 39640, 22799, 34081, 30000, 27146, 32993, 20940, 34398, 25903, 26607, 26141, 31649, 21346, 33707, 32463, 25151, 35032, 32554, 24178, 35299, 24212, 23447, 19969, 23459, 36146, 37011, 37057, 21333, 26477, 27946, 21253, 35832, 24038, 30707, 23828, 21513, 38062, 40858, 31243, 23879, 37026, 28369, 35060, 38470, 33635, 32705, 33600, 32650, 26044, 24800, 29956, 26354, 23478, 23553, 33454, 32703, 20648, 38771, 27762, 37044, 31964, 26494, 20117, 27573, 23500, 24043, 20044, 28966, 24052, 24339, 29287, 38551, 23665, 35895, 36710, 20399, 23443, 34028, 20840, 37079, 29677, 20208, 31179, 20210, 20234, 23467, 23425, 20167, 26686, 26292, 29976, 38061, 21385, 25102, 31062, 27494, 31526, 21016, 26223, 35449, 26463, 40857, 21494, 24184, 21496, 38902, 37084, 40654, 34015, 34180, 21360, 23487, 30333, 24576, 33970, 37040, 20174, 37122, 32034, 21688, 31821, 36182, 21331, 34106, 23648, 33945, 27744, 20052, 38452, 39729, 32997, 33021, 33485, 21452, 38395, 33688, 20826, 32735, 35885, 36129, 21171, 36868, 23020, 30003, 25206, 22581, 20873, 23472, 37094, 38605, 37092, 29865, 26705, 26690, 28654, 29275, 23551, 36890, 36793, 25160, 29141, 20864, 37071, 28006, 23578, 20892, 28201, 21035, 24196, 26191, 26612, 30655, 38414, 20805, 24917, 36830, 33593, 20064, 23462, 33406, 40060, 23481, 21521, 21476, 26131, 24910, 25096, 24278, 24254, 32456, 26280, 23621, 34913, 27493, 37117, 32831, 28385, 24344, 21281, 22269, 25991, 23495, 24191, 31108, 38425, 19996, 27431, 27571, 27779, 21033, 34074, 36234, 22804, 38534, 24072, 24041, 21389, 32834, 26177, 21246, 25942, 34701, 20919, 35390, 36763, 38426, 37027, 31616, 39286, 31354, 26366, 27597, 27801, 20060, 20859, 38816, 39035, 20016, 24034, 20851, 33967, 30456, 26597, 21518, 33606, 32418, 28216, 31482, 26435, 36911, 30422, 30410, 26707, 20844, 21830, 29279, 20312, 20340, 20271, 36175, 22696, 21704, 35887, 31530, 24180, 29233, 38451, 20319, 35328, 31119, 26187, 26970, 38379, 27861, 27741, 37154, 28034, 38054, 24402, 28023, 24494, 29983, 23731, 24069, 32529, 20130, 20917, 21518, 29748, 26377, 36249, 37666, 23403, 21555, 37165, 39342, 38515, 34907, 34083, 38867, 26954, 35377, 21570, 24373, 22196, 33775, 35613, 37138, 26658, 31431, 38642, 34311, 39791, 38859, 39340, 40179, 39825, 36027, 36032, 28271, 32645, 30050, 37140, 27138, 26178, 40778, 20237, 39015, 40643, 34157, 35997, 35336, 35527, 40848, 32000, 38917, 34253, 38292, 24375, 36040, 23105, 38991, 38202, 39409, 38669, 33836, 21646, 30439, 32147, 32326, 25033, 36033, 37159, 21934, 35576, 37397, 40852, 38520, 27054, 40628, 20786, 28879, 36554, 23470, 29999, 27410, 37380, 21426, 21129, 40845, 33865, 34186, 25079, 24478, 36084, 34298, 21932, 38512, 33980, 38617, 32862, 35674, 36002, 21214, 37192, 22781, 37002, 37087, 36786, 28331, 21029, 33674, 38331, 36899, 32722, 39770, 24218, 32066, 28415, 22283, 24291, 31103, 38357, 26481, 27590, 24107, 38799, 21401, 32886, 38366, 31777, 39250, 27595, 39178, 38920, 35920, 38364, 24460, 33610, 32005, 36938, 27402, 33995, 26185, 38278, 27453, 27512, 24101, 32241, 36062, 35673, 24859, 38525};
    }

    public static String structuredNameToDisplayName(Context r6, Map<String, String> r7) {
        Uri.Builder r0 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        String[] r1 = STRUCTURED_NAME_FIELDS;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        String r4 = r1[r3];
        if (r7.containsKey(r4) == false) goto L7;
        appendQueryParameter(r0, r4, r7.get(r4));
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        return fetchDisplayName(r6, r0.build());
    }

    public static String structuredNameToDisplayName(Context r6, ContentValues r7) {
        Uri.Builder r0 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        String[] r1 = STRUCTURED_NAME_FIELDS;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L9;
        String r4 = r1[r3];
        if (r7.containsKey(r4) == false) goto L7;
        appendQueryParameter(r0, r4, r7.getAsString(r4));
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        return fetchDisplayName(r6, r0.build());
    }

    private static String fetchDisplayName(Context r6, Uri r7) {
        Cursor r8 = r6.getContentResolver().query(r7, new String[]{"data1"}, null, null, null);
    L10:
        th = move-exception;
        r8.close();
        throw th;
    L4:
        if (r8.moveToFirst() == false) goto L7;
        String r9 = r8.getString(0);     // Catch: Throwable -> L10
    L8:
        r8.close();
        return r9;
    L7:
        r9 = null;
        goto L8
    }

    public static Map<String, String> displayNameToStructuredName(Context r9, String r10) {
        if (ContactsUtils.isChinese(r10) == true) goto L25;
        if (containsNumber(r10) == true) goto L25;
        TreeMap r0 = new TreeMap();
        Uri.Builder r1 = ContactsContract.AUTHORITY_URI.buildUpon().appendPath("complete_name");
        appendQueryParameter(r1, "data1", r10);
        Cursor r11 = r9.getContentResolver().query(r1.build(), STRUCTURED_NAME_FIELDS, null, null, null);
    L21:
        th = move-exception;
        r11.close();
        throw th;
    L9:
        if (r11.moveToFirst() == false) goto L19;
        int r12 = 0;
    L11:
        String[] r2 = STRUCTURED_NAME_FIELDS;     // Catch: Throwable -> L21
        if (r12 >= r2.length) goto L19;
        if (r11.getString(r12) != null) goto L16;
        String r3 = "";
    L17:
        r0.put(r2[r12], r3);     // Catch: Throwable -> L21
        r12 = r12 + 1;
        goto L11
    L16:
        r3 = r11.getString(r12);     // Catch: Throwable -> L21
    L19:
        r11.close();
        return r0;
    L25:
        return chineseDisplayNameToStructureName(r10);
    }

    public static boolean containsNumber(String r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return Pattern.compile(NUMBER_REGEX).matcher(r1).find();
    }

    public static ContentValues displayNameToStructuredName(Context r2, String r3, ContentValues r4) {
        if (r4 != null) goto L4;
        r4 = new ContentValues();
    L4:
        Map<String, String> r5 = displayNameToStructuredName(r2, r3);
        Iterator<String> r6 = r5.keySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        String r0 = r6.next();
        r4.put(r0, r5.get(r0));
        goto L6
    L8:
        return r4;
    }

    private static void appendQueryParameter(Uri.Builder r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.appendQueryParameter(r2, r3);
        return;
    }

    public static Map<String, String> chineseDisplayNameToStructureName(String r8) {
        int r0 = r8.length();
        TreeMap r1 = new TreeMap();
        int r3 = 0;
    L3:
        String[] r4 = STRUCTURED_NAME_FIELDS;
        if (r3 >= r4.length) goto L7;
        r1.put(r4[r3], "");
        r3 = r3 + 1;
        goto L3
    L7:
        if (r0 != 1) goto L11;
        r1.put(r4[1], r8);
        return r1;
    L11:
        if (r0 == 2) goto L13;
        if (r0 > 2) goto L19;
    L28:
        r1.put(r4[1], r8);
        return r1;
    L19:
        if (r0 >= 6) goto L28;
        if (hasCompoundSurname(r8) == false) goto L24;
        r1.put(r4[3], r8.substring(0, 2));
        r1.put(r4[1], r8.substring(2));
    L27:
        return r1;
    L24:
        if (hasSurname(r8) == false) goto L26;
        r1.put(r4[3], r8.substring(0, 1));
        r1.put(r4[1], r8.substring(1));
        goto L27
    L26:
        r1.put(r4[1], r8);
        goto L27
    L13:
        if (hasSurname(r8) == false) goto L15;
        r1.put(r4[3], r8.substring(0, 1));
        r1.put(r4[1], r8.substring(1));
    L16:
        return r1;
    L15:
        r1.put(r4[1], r8);
        goto L16
    }

    private static boolean hasCompoundSurname(String r5) {
        if (r5.length() >= 3) goto L5;
    L14:
        return false;
    L5:
        if (r5.length() > 6) goto L14;
        String r6 = r5.substring(0, 2);
        String[] r0 = COMPOUND_SURNAMES;
        int r1 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L14;
        if (r0[r3].equals(r6) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    }

    private static boolean hasSurname(String r5) {
        if (r5.length() >= 2) goto L5;
    L14:
        return false;
    L5:
        if (r5.length() > 6) goto L14;
        char r6 = r5.charAt(0);
        char[] r0 = SURNAMES;
        int r1 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L14;
        if (r0[r3] == r6) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    }
}
