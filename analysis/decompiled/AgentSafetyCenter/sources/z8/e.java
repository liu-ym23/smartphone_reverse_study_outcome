package z8;

import android.content.res.Resources;
import com.stepos.agentsafetycenter.R;
import hc.h;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jb.i;
import kb.s;
import org.json.JSONArray;
import org.json.JSONObject;
import s8.g1;
import s8.q1;
import s8.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final List f16503a = ac.a.F("undo_revoked_at", "undo_revoked_time", "revoked_at");

    /* renamed from: b, reason: collision with root package name */
    public static final DateTimeFormatter f16504b;

    static {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateTimeFormatterOfPattern.getClass();
        f16504b = dateTimeFormatterOfPattern;
    }

    public static t a(Resources resources) throws Resources.NotFoundException {
        ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
        LocalDate localDateNow = LocalDate.now(zoneIdSystemDefault);
        localDateNow.getClass();
        zoneIdSystemDefault.getClass();
        String string = resources.getString(R.string.chart_day_today);
        string.getClass();
        String string2 = resources.getString(R.string.chart_day_yesterday);
        string2.getClass();
        return g1.s(q1.a(localDateNow, zoneIdSystemDefault, s.f7404c, string, string2, false, 0, null, null, null));
    }

    public static String b(String str, ZoneId zoneId) {
        Object objL;
        Object obj = "--:--";
        if (h.g0(str)) {
            return "--:--";
        }
        try {
            LocalTime localTime = Instant.parse(str).atZone(zoneId).toLocalTime();
            objL = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(localTime.getHour()), Integer.valueOf(localTime.getMinute())}, 2));
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        if (i.b(objL) == null) {
            obj = objL;
        } else {
            String strT0 = h.t0(5, str);
            if (!h.X(strT0, ":", false)) {
                strT0 = null;
            }
            if (strT0 != null) {
                obj = strT0;
            }
        }
        return (String) obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0564 A[PHI: r0
      0x0564: PHI (r0v59 java.lang.String) = (r0v52 java.lang.String), (r0v55 java.lang.String) binds: [B:262:0x0562, B:268:0x057a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x05ec  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0627  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0638  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0641  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x064a  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x071d  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0739 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0796  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x07b2  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x07b6  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x07e8  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0865  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x086e  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0881  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x08f8  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x096d  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0974  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x09d9  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x09f6  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x09f9  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0a09  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0a0e  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x0a11  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0a2e A[LOOP:3: B:518:0x0a28->B:520:0x0a2e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0a45  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x0a63  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0a72  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0aea  */
    /* JADX WARN: Removed duplicated region for block: B:560:0x0b1d  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0b4f  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x0b60  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0b6e  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0bc7  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x0be9  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x0bf1  */
    /* JADX WARN: Removed duplicated region for block: B:621:0x0bf6  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0bfd  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0c36  */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0c4f  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0afd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:653:0x0be3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0190  */
    /* JADX WARN: Type inference failed for: r0v51, types: [jb.h] */
    /* JADX WARN: Type inference failed for: r37v0, types: [java.util.List, kb.s] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static z8.d c(org.json.JSONObject r44, java.time.ZoneId r45) {
        /*
            Method dump skipped, instructions count: 3242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.e.c(org.json.JSONObject, java.time.ZoneId):z8.d");
    }

    /* JADX WARN: Removed duplicated region for block: B:232:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x05c3 A[PHI: r0
      0x05c3: PHI (r0v39 java.lang.String) = (r0v38 java.lang.String), (r0v137 java.lang.String), (r0v138 java.lang.String) binds: [B:294:0x05a3, B:296:0x05ad, B:298:0x05b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0837  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0848 A[PHI: r0
      0x0848: PHI (r0v68 java.lang.String) = (r0v67 java.lang.String), (r0v115 java.lang.String) binds: [B:407:0x0835, B:412:0x0843] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0858  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x08a0  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x08e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s8.t d(java.lang.String r55, android.content.res.Resources r56) {
        /*
            Method dump skipped, instructions count: 2823
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z8.e.d(java.lang.String, android.content.res.Resources):s8.t");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [jb.h] */
    public static String e(JSONObject jSONObject, ZoneId zoneId) {
        String strL;
        String strP = k0.a.p("when", jSONObject);
        if (!h.g0(strP)) {
            return strP;
        }
        String strP2 = k0.a.p("create_time_str", jSONObject);
        if (!h.g0(strP2)) {
            try {
                strL = LocalDateTime.parse(strP2, f16504b).atZone(zoneId).toInstant().toString();
            } catch (Throwable th) {
                strL = id.c.l(th);
            }
            if (i.b(strL) == null) {
                strP2 = strL;
            }
            return strP2;
        }
        if (!jSONObject.has("create_time")) {
            return "";
        }
        long jOptLong = jSONObject.optLong("create_time");
        if (jOptLong <= 0) {
            return "";
        }
        String string = Instant.ofEpochSecond(jOptLong).toString();
        string.getClass();
        return string;
    }

    public static ArrayList f(JSONArray jSONArray) {
        ec.g gVarO = p5.f.O(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        ec.a it = gVarO.iterator();
        while (it.f3752h) {
            String strOptString = jSONArray.optString(it.nextInt());
            strOptString.getClass();
            if (h.g0(strOptString)) {
                strOptString = null;
            }
            if (strOptString != null) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }
}
