package aq;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f15876a = 0;

    static {
    }

    @JvmStatic
    public static final int b(Object r100) {
        if ((r100 instanceof List) == false) goto L6;
        return ((List) r100).size();
    L6:
        if ((r100 instanceof Object[]) == false) goto L9;
        return ((Object[]) r100).length;
    L9:
        if ((r100 instanceof Map) == false) goto L12;
        return ((Map) r100).size();
    L12:
        if ((r100 instanceof String) == true) goto L19;
        return 0;
    L19:
        return ((String) r100).length();
    }

    @JvmStatic
    public static final boolean c(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Boolean) == false) goto L9;
        return ((Boolean) r100).booleanValue();
    L9:
        if ((r100 instanceof String) == false) goto L14;
        if (((String) r100).length() <= 0) goto L36;
    L12:
        return true;
    L36:
        return false;
    L14:
        if ((r100 instanceof Number) == false) goto L21;
        double r101 = ((Number) r100).doubleValue();
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        return false;
    L18:
        if (Double.isNaN(r101) == false) goto L12;
        return false;
    L21:
        if ((r100 instanceof Map) == false) goto L26;
        if (((Map) r100).size() > 0) goto L12;
        return false;
    L26:
        if ((r100 instanceof List) == false) goto L31;
        if (((List) r100).size() > 0) goto L12;
        return false;
    L31:
        if ((r100 instanceof Object[]) == false) goto L12;
        if (((Object[]) r100).length > 0) goto L12;
        return false;
    }

    @JvmStatic
    public static final float a(String r110, String r111, String r112) {
        if (StringsKt.contains$default(r110, "-", false, 2, null) == false) goto L34;
        List r113 = StringsKt.split$default(r110, new String[]{"-"}, false, 0, 6, null);
        ArrayList r100 = new ArrayList();
        Iterator r114 = r113.iterator();
    L6:
        if (r114.hasNext() == false) goto L11;
        Object r101 = r114.next();
        if ((true ^ StringsKt.isBlank((String) r101)) == false) goto L6;
        r100.add(r101);
        goto L6
    L11:
        if (r100.size() != 2) goto L32;
        float r115 = CastFloatProtector.parseFloat((String) ListProtector.get(r100, 0));
        String r116 = (String) ListProtector.get(r100, 1);
        int r117 = r116.hashCode();
        if (r117 == (-1378088671)) goto L26;
        if (r117 == 3633) goto L23;
        if (r117 == 92909918) goto L20;
    L28:
        float r118 = -0.75f;
    L30:
        return r115 + r118;
    L20:
        if (r116.equals("alpha") == false) goto L28;
        r118 = -0.5f;
        goto L30
    L23:
        if (r116.equals("rc") == false) goto L28;
        r118 = -0.25f;
        goto L30
    L26:
        if (r116.equals(DownloadSettingKeys.BUG_FIX) == false) goto L28;
        r118 = 0.25f;
        goto L30
    L32:
        throw new IllegalArgumentException("the version format is illegal,params:" + r111 + ',' + r112);
    L34:
        throw new IllegalArgumentException("params is string but don't  include '-',params:" + r111 + ',' + r112);
    }
}
