package m4;

import b0.b2;
import b0.z2;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.stepos.account.oauth.OAuthConstants;
import fi.iki.elonen.NanoHTTPD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.UnaryOperator;
import o4.h1;
import o4.t1;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class q0 implements a6.o {

    /* renamed from: l, reason: collision with root package name */
    public static final List f6311l = d7.s.u0(new c7.j("read", "Read file contents"), new c7.j("write", "Create or overwrite files"), new c7.j("edit", "Make precise edits to files"), new c7.j("apply_patch", "Apply multi-file patches"), new c7.j("grep", "Search file contents for patterns"), new c7.j("find", "Find files by glob pattern"), new c7.j("ls", "List directory contents"), new c7.j("exec", "Run shell commands (pty available for TTY-required CLIs)"), new c7.j("process", "Manage background exec sessions"), new c7.j("web_search", "Search the web (provider from config)"), new c7.j("web_fetch", "Fetch and extract readable content from a URL"), new c7.j("browser", "Launch and control a local Chromium-based browser (PC/desktop only)"), new c7.j("canvas", "Present/eval/snapshot the Canvas"), new c7.j("nodes", "Invoke phone capabilities (ability.call via invokeParamsJson)"), new c7.j("cron", "OpenClaw cron and wake jobs (reminders/scheduled tasks)"), new c7.j(OAuthConstants.FACTOR_RESULT_MESSAGE, "Send messages and channel actions"), new c7.j("gateway", "Restart, apply config, or run updates on the running OpenClaw process"), new c7.j("agents_list", "List OpenClaw agent ids allowed for sessions_spawn"), new c7.j("sessions_list", "List other sessions (incl. sub-agents) with filters/last"), new c7.j("sessions_history", "Fetch history for another session/sub-agent"), new c7.j("sessions_send", "Send a message to another session/sub-agent"), new c7.j("sessions_spawn", "Spawn an isolated sub-agent or ACP coding session"), new c7.j("subagents", "List, steer, or kill sub-agent runs for this requester session"), new c7.j("session_status", "Show usage/time/model state"), new c7.j("image", "Analyze an image with the configured image model"));

    /* renamed from: a, reason: collision with root package name */
    public final u0 f6312a;

    /* renamed from: b, reason: collision with root package name */
    public final f5.f f6313b;

    /* renamed from: c, reason: collision with root package name */
    public final k5.a f6314c;

    /* renamed from: d, reason: collision with root package name */
    public final k5.t f6315d;

    /* renamed from: e, reason: collision with root package name */
    public final r0 f6316e;

    /* renamed from: f, reason: collision with root package name */
    public final o4.d0 f6317f;

    /* renamed from: g, reason: collision with root package name */
    public final p7.a f6318g;

    /* renamed from: h, reason: collision with root package name */
    public final p7.a f6319h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicLong f6320i;

    /* renamed from: j, reason: collision with root package name */
    public final la.j0 f6321j;

    /* renamed from: k, reason: collision with root package name */
    public final la.e0 f6322k;

    public q0(u0 u0Var, f5.f fVar, k5.a aVar, k5.g gVar, o4.d0 d0Var, v4.a aVar2, v4.a aVar3) {
        r0 r0Var = new r0();
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        this.f6312a = u0Var;
        this.f6313b = fVar;
        this.f6314c = aVar;
        this.f6315d = gVar;
        this.f6316e = r0Var;
        this.f6317f = d0Var;
        this.f6318g = aVar2;
        this.f6319h = aVar3;
        this.f6320i = new AtomicLong(0L);
        la.j0 j0VarB = la.k0.b(0, 64, 5);
        this.f6321j = j0VarB;
        this.f6322k = new la.e0(j0VarB);
    }

    public static final a6.m I(q0 q0Var, a6.d dVar) {
        Object objN;
        q0Var.getClass();
        try {
            q0Var.f6316e.a((File) q0Var.f6312a.f6347g, new b2(5, q0Var, dVar));
            objN = new a6.m(true, dVar.f295a, null, null, null, 28);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), d7.a0.f2944f, 2);
        }
        return (a6.m) objN;
    }

    public static final List J(q0 q0Var, ArrayList arrayList) {
        Object obj = q0Var.f6316e.b((File) q0Var.f6312a.f6342b).get("skills");
        Map map = obj instanceof Map ? (Map) obj : null;
        Object obj2 = map != null ? map.get("entries") : null;
        Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (map2 == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a6.z zVar = (a6.z) it.next();
            Object obj3 = map2.get(zVar.f389a);
            Map map3 = obj3 instanceof Map ? (Map) obj3 : null;
            Object obj4 = map3 != null ? map3.get("enabled") : null;
            Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
            arrayList2.add(a6.z.a(zVar, bool != null ? bool.booleanValue() : zVar.f394f, null, 991));
        }
        return arrayList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List K(m4.q0 r7, java.util.List r8, a6.y r9) {
        /*
            if (r9 == 0) goto Lc7
            boolean r7 = r9.a()
            if (r7 == 0) goto La
            goto Lc7
        La:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r8.iterator()
        L13:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto Lc6
            java.lang.Object r0 = r8.next()
            r1 = r0
            a6.z r1 = (a6.z) r1
            java.util.Set r2 = r9.f383a
            r3 = 1
            if (r2 == 0) goto L2c
            a6.i r4 = r1.f396h
            boolean r2 = r2.contains(r4)
            goto L2d
        L2c:
            r2 = r3
        L2d:
            r4 = 0
            if (r2 == 0) goto Lbe
            java.util.Set r2 = r9.f384b
            if (r2 == 0) goto L48
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r5 = r1.f393e
            java.util.Set r5 = d7.r.q1(r5)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Set r2 = d7.r.R0(r2, r5)
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r3
            goto L49
        L48:
            r2 = r3
        L49:
            if (r2 == 0) goto Lbe
            java.util.Set r2 = r9.f385c
            if (r2 == 0) goto L79
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r5 = r2 instanceof java.util.Collection
            if (r5 == 0) goto L5f
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L5f
            goto L79
        L5f:
            java.util.Iterator r2 = r2.iterator()
        L63:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L79
            java.lang.Object r5 = r2.next()
            java.lang.String r5 = (java.lang.String) r5
            java.util.List r6 = r1.f393e
            boolean r5 = r6.contains(r5)
            if (r5 != 0) goto L63
            r2 = r4
            goto L7a
        L79:
            r2 = r3
        L7a:
            if (r2 == 0) goto Lbe
            java.lang.Boolean r2 = r9.f386d
            if (r2 == 0) goto L8b
            boolean r2 = r2.booleanValue()
            boolean r5 = r1.f394f
            if (r2 != r5) goto L89
            goto L8b
        L89:
            r2 = r4
            goto L8c
        L8b:
            r2 = r3
        L8c:
            if (r2 == 0) goto Lbe
            java.lang.Boolean r2 = r9.f387e
            if (r2 == 0) goto L9d
            boolean r2 = r2.booleanValue()
            boolean r5 = r1.f395g
            if (r2 != r5) goto L9b
            goto L9d
        L9b:
            r2 = r4
            goto L9e
        L9d:
            r2 = r3
        L9e:
            if (r2 == 0) goto Lbe
            java.lang.Long r2 = r9.f388f
            if (r2 == 0) goto Lba
            long r5 = r2.longValue()
            java.lang.Long r1 = r1.f397i
            if (r1 == 0) goto Lb1
            long r1 = r1.longValue()
            goto Lb3
        Lb1:
            r1 = 0
        Lb3:
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 < 0) goto Lb8
            goto Lba
        Lb8:
            r1 = r4
            goto Lbb
        Lba:
            r1 = r3
        Lbb:
            if (r1 == 0) goto Lbe
            goto Lbf
        Lbe:
            r3 = r4
        Lbf:
            if (r3 == 0) goto L13
            r7.add(r0)
            goto L13
        Lc6:
            return r7
        Lc7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.K(m4.q0, java.util.List, a6.y):java.util.List");
    }

    public static final a6.m L(q0 q0Var, a6.h hVar) {
        Object objN;
        u0 u0Var = q0Var.f6312a;
        f5.f fVar = q0Var.f6313b;
        String str = hVar.f321c;
        String str2 = hVar.f319a;
        File fileD = fVar.d(str);
        d7.a0 a0Var = d7.a0.f2944f;
        if (fileD == null) {
            return new a6.m(false, null, "BLOB_NOT_FOUND", a1.a.j("blob ", hVar.f321c, " not in cache"), a0Var, 2);
        }
        try {
            a.a.L(fileD, u0Var.k(str2));
            q0Var.f6316e.a(n7.l.O(u0Var.k(str2), ".skill-meta.json"), new a5.a(14, hVar));
            q0Var.g0(str2, hVar.f320b, true);
            objN = new a6.m(true, str2, null, null, null, 28);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            k5.s.warn$default(q0Var.f6315d, "OpenClawBackend", a1.a.k("installSkillLocal ", str2, " failed: ", thA.getMessage()), null, 4, null);
            objN = new a6.m(false, null, "INSTALL_FAILED", thA.getMessage(), a0Var, 2);
        }
        return (a6.m) objN;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.ArrayList M(m4.q0 r26, a6.a0 r27) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.M(m4.q0, a6.a0):java.util.ArrayList");
    }

    public static final List N(q0 q0Var, JSONObject jSONObject) {
        q0Var.getClass();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("channels");
        if (jSONObjectOptJSONObject == null) {
            return d7.z.f2978f;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        q7.k.d(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject2 != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("accounts");
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("accounts");
                if (jSONArrayOptJSONArray != null) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject4 != null) {
                            String strOptString = jSONObjectOptJSONObject4.optString("id");
                            if (strOptString.length() == 0) {
                                strOptString = jSONObjectOptJSONObject4.optString("name");
                                if (strOptString.length() == 0) {
                                    strOptString = next + "-" + i2;
                                }
                            }
                            q7.k.b(next);
                            q7.k.b(strOptString);
                            arrayList.add(c0(next, strOptString, jSONObjectOptJSONObject4));
                        }
                    }
                } else if (jSONObjectOptJSONObject3 != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject3.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject3.optJSONObject(next2);
                        if (jSONObjectOptJSONObject5 != null) {
                            q7.k.b(next);
                            q7.k.b(next2);
                            arrayList.add(c0(next, next2, jSONObjectOptJSONObject5));
                        }
                    }
                } else {
                    String strOptString2 = jSONObjectOptJSONObject2.optString("id");
                    if (strOptString2.length() == 0) {
                        strOptString2 = jSONObjectOptJSONObject2.optString("name", next);
                    }
                    q7.k.b(next);
                    q7.k.b(strOptString2);
                    arrayList.add(c0(next, strOptString2, jSONObjectOptJSONObject2));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a6.k O(m4.q0 r10, org.json.JSONObject r11) {
        /*
            r10.getClass()
            java.lang.String r10 = "agents"
            org.json.JSONObject r10 = r11.optJSONObject(r10)
            java.lang.String r0 = ""
            r1 = 0
            if (r10 == 0) goto L1d
            java.lang.String r2 = "defaults"
            org.json.JSONObject r10 = r10.optJSONObject(r2)
            if (r10 == 0) goto L1d
            java.lang.String r2 = "model"
            java.lang.String r10 = r10.optString(r2, r0)
            goto L1e
        L1d:
            r10 = r1
        L1e:
            if (r10 != 0) goto L21
            r10 = r0
        L21:
            java.lang.String r2 = "/"
            r3 = 0
            boolean r4 = ga.k.k0(r10, r2, r3)
            if (r4 == 0) goto L42
            java.lang.String[] r2 = new java.lang.String[]{r2}
            r4 = 2
            java.util.List r10 = ga.k.D0(r10, r2, r4)
            java.lang.Object r2 = r10.get(r3)
            r3 = 1
            java.lang.Object r10 = r10.get(r3)
            c7.j r3 = new c7.j
            r3.<init>(r2, r10)
            goto L47
        L42:
            c7.j r3 = new c7.j
            r3.<init>(r0, r10)
        L47:
            java.lang.Object r10 = r3.f1973f
            r5 = r10
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r10 = r3.f1974g
            r6 = r10
            java.lang.String r6 = (java.lang.String) r6
            boolean r10 = ga.k.t0(r5)
            if (r10 != 0) goto L6c
            java.lang.String r10 = "models"
            org.json.JSONObject r10 = r11.optJSONObject(r10)
            if (r10 == 0) goto L6c
            java.lang.String r11 = "providers"
            org.json.JSONObject r10 = r10.optJSONObject(r11)
            if (r10 == 0) goto L6c
            org.json.JSONObject r10 = r10.optJSONObject(r5)
            goto L6d
        L6c:
            r10 = r1
        L6d:
            if (r10 == 0) goto L7f
            java.lang.String r11 = "baseUrl"
            java.lang.String r11 = r10.optString(r11, r0)
            if (r11 == 0) goto L7f
            boolean r0 = ga.k.t0(r11)
            if (r0 != 0) goto L7f
            r7 = r11
            goto L80
        L7f:
            r7 = r1
        L80:
            if (r10 == 0) goto L9c
            java.lang.String r11 = "api"
            boolean r0 = r10.has(r11)
            if (r0 == 0) goto L8b
            goto L8c
        L8b:
            r10 = r1
        L8c:
            if (r10 == 0) goto L9c
            java.lang.String r10 = r10.optString(r11)
            if (r10 == 0) goto L9c
            boolean r11 = ga.k.t0(r10)
            if (r11 != 0) goto L9c
            r8 = r10
            goto L9d
        L9c:
            r8 = r1
        L9d:
            a6.k r4 = new a6.k
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.O(m4.q0, org.json.JSONObject):a6.k");
    }

    public static final String P(q0 q0Var, a6.c cVar) {
        Object objN;
        File fileG = q0Var.f6312a.g(cVar);
        if (!fileG.exists()) {
            k5.t tVar = q0Var.f6315d;
            String absolutePath = fileG.getAbsolutePath();
            File parentFile = fileG.getParentFile();
            k5.s.warn$default(tVar, "OpenClawBackend", "readCoreFile[" + cVar + "]: NOT FOUND path=" + absolutePath + " parent=" + (parentFile != null ? Boolean.valueOf(parentFile.exists()) : null), null, 4, null);
            return "";
        }
        if (!fileG.canRead()) {
            k5.s.warn$default(q0Var.f6315d, "OpenClawBackend", "readCoreFile[" + cVar + "]: PERMISSION DENIED path=" + fileG.getAbsolutePath() + " size=" + fileG.length(), null, 4, null);
            return "";
        }
        try {
            objN = n7.l.N(fileG);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            k5.s.warn$default(q0Var.f6315d, "OpenClawBackend", "readCoreFile[" + cVar + "]: readText threw " + q7.w.f8821a.b(thA.getClass()).t() + ": " + thA.getMessage(), null, 4, null);
            return "";
        }
        String str = (String) objN;
        k5.s.info$default(q0Var.f6315d, "OpenClawBackend", "readCoreFile[" + cVar + "]: ok len=" + str.length() + " path=" + fileG.getAbsolutePath(), null, 4, null);
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    public static final List Q(q0 q0Var, int i2, String str) {
        ?? W0;
        File[] fileArrListFiles;
        Object objN;
        u0 u0Var = q0Var.f6312a;
        d7.z zVar = d7.z.f2978f;
        if (str != null) {
            u0Var.getClass();
            List listS = a.a.S(n7.l.O((File) u0Var.f6348h, str.concat(".jsonl")));
            W0 = new ArrayList();
            for (Object obj : listS) {
                if (((File) obj).exists()) {
                    W0.add(obj);
                }
            }
        } else {
            File file = (File) u0Var.f6348h;
            if (!file.isDirectory()) {
                file = null;
            }
            W0 = (file == null || (fileArrListFiles = file.listFiles(new y(0))) == null) ? zVar : d7.n.w0(fileArrListFiles);
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : W0) {
            try {
                JsonAdapter jsonAdapterAdapter = new Moshi.Builder().build().adapter(Types.newParameterizedType(Map.class, String.class, Object.class));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2), ga.a.f4005a), NanoHTTPD.HTTPSession.BUFSIZE);
                try {
                    objN = fa.l.v0(fa.l.u0(new fa.f(new fa.a(new d7.q(4, bufferedReader)), true, new c6.d(23)), new b2(q0Var, file2, jsonAdapterAdapter)));
                    bufferedReader.close();
                } finally {
                }
            } catch (Throwable th) {
                objN = w7.e0.n(th);
            }
            if (c7.m.a(objN) != null) {
                objN = zVar;
            }
            d7.x.D0(arrayList, (List) objN);
        }
        return d7.r.k1(d7.r.j1(arrayList, new i0(0)), i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:69)|(1:(2:12|13)(2:17|18))(10:19|(3:21|22|(1:24))|65|48|(1:50)(1:51)|(1:53)(1:57)|59|(1:62)|63|64)|25|28|(1:30)|31|(1:33)|34|(7:67|36|(1:38)|42|(1:44)|45|(1:71))|65|48|(0)(0)|(0)(0)|59|(0)|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c9, code lost:
    
        r9 = w7.e0.n(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ba A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #0 {all -> 0x00c4, blocks: (B:48:0x00aa, B:53:0x00ba), top: B:65:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object R(m4.q0 r8, i7.c r9) {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.R(m4.q0, i7.c):java.lang.Object");
    }

    public static final a6.m S(q0 q0Var, String str) {
        Object objN;
        d7.a0 a0Var = d7.a0.f2944f;
        u0 u0Var = q0Var.f6312a;
        try {
            r0 r0Var = q0Var.f6316e;
            File file = (File) u0Var.f6347g;
            r0Var.getClass();
            q7.k.e(file, "file");
            Map mapB = r0Var.b(file);
            Object obj = mapB.get("jobs");
            List list = q7.z.e(obj) ? (List) obj : null;
            boolean zE0 = list == null ? false : d7.x.E0(list, new a(str, 2));
            r0Var.c(file, mapB);
            if (zE0) {
                q7.k.e(str, "jobId");
                n7.l.O((File) u0Var.f6348h, str.concat(".jsonl")).delete();
                objN = new a6.m(true, str, null, null, null, 28);
            } else {
                objN = new a6.m(false, null, "NOT_FOUND", "job " + str, a0Var, 2);
            }
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), a0Var, 2);
        }
        return (a6.m) objN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bf A[PHI: r0
      0x00bf: PHI (r0v61 java.lang.String) = (r0v10 java.lang.String), (r0v12 java.lang.String), (r0v62 java.lang.String) binds: [B:109:0x01bb, B:129:0x0253, B:53:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c2  */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v10, types: [int] */
    /* JADX WARN: Type inference failed for: r15v11, types: [int] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v3, types: [int] */
    /* JADX WARN: Type inference failed for: r15v4, types: [int] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6, types: [int] */
    /* JADX WARN: Type inference failed for: r15v7, types: [int] */
    /* JADX WARN: Type inference failed for: r15v8, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List T(m4.q0 r25, java.io.File r26, a6.i r27) {
        /*
            Method dump skipped, instructions count: 819
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.T(m4.q0, java.io.File, a6.i):java.util.List");
    }

    public static final a6.m U(q0 q0Var, String str, final String str2, final String str3, final boolean z4) {
        Object objN;
        q0Var.getClass();
        d7.a0 a0Var = d7.a0.f2944f;
        final q7.r rVar = new q7.r();
        try {
            q0Var.f6316e.a((File) q0Var.f6312a.f6342b, new p7.k() { // from class: m4.b0
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r15v1 */
                /* JADX WARN: Type inference failed for: r15v10 */
                /* JADX WARN: Type inference failed for: r15v2 */
                /* JADX WARN: Type inference failed for: r15v3, types: [java.lang.String] */
                /* JADX WARN: Type inference failed for: r15v8 */
                @Override // p7.k
                public final Object invoke(Object obj) throws Throwable {
                    Map map = (Map) obj;
                    q7.k.e(map, "cfg");
                    Object obj2 = map.get("channels");
                    Throwable th = null;
                    Map map2 = q7.z.f(obj2) ? (Map) obj2 : null;
                    if (map2 != null) {
                        String str4 = str2;
                        Object obj3 = map2.get(str4);
                        Map map3 = q7.z.f(obj3) ? (Map) obj3 : null;
                        if (map3 != null) {
                            Object obj4 = map3.get("accounts");
                            boolean zE = q7.z.e(obj4);
                            String str5 = str3;
                            boolean z10 = z4;
                            q7.r rVar2 = rVar;
                            if (zE) {
                                q7.k.c(obj4, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.collections.Map<kotlin.String, kotlin.Any?>>");
                                if ((obj4 instanceof r7.a) && !(obj4 instanceof r7.c)) {
                                    q7.z.g(obj4, "kotlin.collections.MutableList");
                                    throw null;
                                }
                                try {
                                    List list = (List) obj4;
                                    int i2 = 0;
                                    for (Object obj5 : list) {
                                        int i10 = i2 + 1;
                                        if (i2 < 0) {
                                            Throwable th2 = th;
                                            d7.s.z0();
                                            throw th2;
                                        }
                                        Map map4 = (Map) obj5;
                                        Object obj6 = map4.get("id");
                                        Throwable th3 = th;
                                        ?? r15 = obj6 instanceof String ? (String) obj6 : th3;
                                        if (r15 == 0) {
                                            r15 = "";
                                        }
                                        int length = r15.length();
                                        Object obj7 = r15;
                                        if (length == 0) {
                                            Object obj8 = map4.get("name");
                                            Object obj9 = obj8 instanceof String ? (String) obj8 : th3;
                                            if (obj9 == null) {
                                                obj9 = str4 + "-" + i2;
                                            }
                                            obj7 = obj9;
                                        }
                                        if (q7.k.a(obj7, str5)) {
                                            LinkedHashMap linkedHashMapB0 = d7.e0.b0(map4);
                                            linkedHashMapB0.put("enabled", Boolean.valueOf(z10));
                                            list.set(i2, linkedHashMapB0);
                                            rVar2.f8816f = true;
                                        }
                                        th = th3;
                                        i2 = i10;
                                    }
                                } catch (ClassCastException e10) {
                                    q7.k.i(e10, q7.z.class.getName());
                                    throw e10;
                                }
                            } else if (q7.z.f(obj4)) {
                                q7.k.c(obj4, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
                                Map mapA = q7.z.a(obj4);
                                if (mapA.containsKey(str5)) {
                                    Object obj10 = mapA.get(str5);
                                    Map linkedHashMap = q7.z.f(obj10) ? (Map) obj10 : null;
                                    if (linkedHashMap == null) {
                                        linkedHashMap = new LinkedHashMap();
                                        mapA.put(str5, linkedHashMap);
                                    }
                                    linkedHashMap.put("enabled", Boolean.valueOf(z10));
                                    rVar2.f8816f = true;
                                }
                            } else {
                                Object obj11 = map3.get("id");
                                String str6 = obj11 instanceof String ? (String) obj11 : null;
                                String str7 = str6 != null ? str6 : "";
                                if (str7.length() == 0) {
                                    Object obj12 = map3.get("name");
                                    String str8 = obj12 instanceof String ? (String) obj12 : null;
                                    if (str8 != null) {
                                        str4 = str8;
                                    }
                                    str7 = str4;
                                }
                                if (q7.k.a(str5, str7)) {
                                    map3.put("enabled", Boolean.valueOf(z10));
                                    rVar2.f8816f = true;
                                }
                            }
                        }
                    }
                    return c7.r.f1986a;
                }
            });
            if (rVar.f8816f) {
                objN = new a6.m(true, str, null, null, null, 28);
            } else {
                objN = new a6.m(false, null, "NOT_FOUND", "channel " + str + " not in config", a0Var, 2);
            }
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "SET_ENABLE_FAILED", thA.getMessage(), a0Var, 2);
        }
        return (a6.m) objN;
    }

    public static final a6.m V(q0 q0Var, final String str, final boolean z4) {
        Object objN;
        q0Var.getClass();
        d7.a0 a0Var = d7.a0.f2944f;
        final q7.r rVar = new q7.r();
        try {
            r0 r0Var = q0Var.f6316e;
            File file = (File) q0Var.f6312a.f6347g;
            r0Var.getClass();
            q7.k.e(file, "file");
            Map mapB = r0Var.b(file);
            Object obj = mapB.get("jobs");
            List list = q7.z.e(obj) ? (List) obj : null;
            if (list != null) {
                list.replaceAll(new UnaryOperator() { // from class: m4.z
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        Map map = (Map) obj2;
                        q7.k.e(map, "it");
                        Object obj3 = map.get("jobId");
                        if (!q7.k.a(obj3 instanceof String ? (String) obj3 : null, str)) {
                            return map;
                        }
                        rVar.f8816f = true;
                        LinkedHashMap linkedHashMapB0 = d7.e0.b0(map);
                        linkedHashMapB0.put("isEnabled", Boolean.valueOf(z4));
                        return linkedHashMapB0;
                    }
                });
            }
            r0Var.c(file, mapB);
            if (rVar.f8816f) {
                objN = new a6.m(true, str, null, null, null, 28);
            } else {
                objN = new a6.m(false, null, "NOT_FOUND", "job " + str, a0Var, 2);
            }
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "SET_ENABLE_FAILED", thA.getMessage(), a0Var, 2);
        }
        return (a6.m) objN;
    }

    public static final a6.m W(q0 q0Var, a6.l lVar) {
        Object objN;
        u0 u0Var = q0Var.f6312a;
        r0 r0Var = q0Var.f6316e;
        try {
            String str = lVar.f341a;
            String str2 = (str == null || ga.k.t0(str)) ? null : str;
            String str3 = lVar.f342b;
            String str4 = (str3 == null || ga.k.t0(str3)) ? null : str3;
            String str5 = lVar.f343c;
            String str6 = (str5 == null || ga.k.t0(str5)) ? null : str5;
            String str7 = lVar.f344d;
            String str8 = (str7 == null || ga.k.t0(str7)) ? null : str7;
            String str9 = lVar.f345e;
            if (str9 == null || ga.k.t0(str9)) {
                str9 = null;
            }
            r0Var.a((File) u0Var.f6342b, new a0(str2, str6, str8, str4, 0));
            if (str9 != null) {
                File file = (File) u0Var.f6344d;
                q7.k.e(file, "file");
                Map mapB = r0Var.b(file);
                Object obj = mapB.get("default");
                Map linkedHashMap = q7.z.f(obj) ? (Map) obj : null;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    mapB.put("default", linkedHashMap);
                }
                linkedHashMap.put("apiKey", str9);
                r0Var.c(file, mapB);
            }
            objN = new a6.m(true, null, null, null, null, 28);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            k5.s.warn$default(q0Var.f6315d, "OpenClawBackend", a1.a.w("setModelConfigLocal failed: ", thA.getMessage()), null, 4, null);
            objN = new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), d7.a0.f2944f, 2);
        }
        return (a6.m) objN;
    }

    public static final a6.m X(q0 q0Var, String str, boolean z4) {
        Object objN;
        q0Var.getClass();
        try {
            q0Var.f6316e.a((File) q0Var.f6312a.f6342b, new b(str, 1, z4));
            objN = new a6.m(true, str, null, null, null, 28);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "SET_ENABLE_FAILED", thA.getMessage(), d7.a0.f2944f, 2);
        }
        return (a6.m) objN;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7 A[PHI: r11
      0x00b7: PHI (r11v30 java.lang.String) = (r11v29 java.lang.String), (r11v77 java.lang.String) binds: [B:55:0x00a9, B:58:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00dc A[PHI: r11
      0x00dc: PHI (r11v35 java.lang.String) = (r11v34 java.lang.String), (r11v72 java.lang.String) binds: [B:65:0x00c8, B:70:0x00d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ed A[PHI: r11
      0x00ed: PHI (r11v66 java.lang.Boolean) = (r11v39 java.lang.Boolean), (r11v43 java.lang.Boolean) binds: [B:77:0x00eb, B:84:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a6.d Y(m4.q0 r11, java.util.Map r12) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.Y(m4.q0, java.util.Map):a6.d");
    }

    public static final a6.m Z(q0 q0Var, String str) {
        Object objN;
        u0 u0Var = q0Var.f6312a;
        File fileC = u0Var.c(str);
        boolean zExists = fileC.exists();
        d7.a0 a0Var = d7.a0.f2944f;
        if (!zExists) {
            return new a6.m(false, null, "NOT_FOUND", "channel ".concat(str), a0Var, 2);
        }
        try {
            n7.l.K(fileC);
            r0 r0Var = q0Var.f6316e;
            File file = (File) u0Var.f6342b;
            r0Var.getClass();
            q7.k.e(file, "file");
            Map mapB = r0Var.b(file);
            Object obj = mapB.get("channels");
            Map map = q7.z.f(obj) ? (Map) obj : null;
            if (map != null) {
                map.remove(str);
            }
            r0Var.c(file, mapB);
            objN = new a6.m(true, str, null, null, null, 28);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), a0Var, 2);
        }
        return (a6.m) objN;
    }

    public static final a6.m a0(q0 q0Var, String str) {
        Object objN;
        u0 u0Var = q0Var.f6312a;
        File fileK = u0Var.k(str);
        boolean zExists = fileK.exists();
        d7.a0 a0Var = d7.a0.f2944f;
        if (!zExists) {
            return new a6.m(false, null, "NOT_FOUND", "skill ".concat(str), a0Var, 2);
        }
        try {
            n7.l.K(fileK);
            r0 r0Var = q0Var.f6316e;
            File file = (File) u0Var.f6342b;
            r0Var.getClass();
            q7.k.e(file, "file");
            Map mapB = r0Var.b(file);
            Object obj = mapB.get("skills");
            Map map = q7.z.f(obj) ? (Map) obj : null;
            if (map != null) {
                Object obj2 = map.get("entries");
                Map map2 = q7.z.f(obj2) ? (Map) obj2 : null;
                if (map2 != null) {
                    map2.remove(str);
                }
            }
            r0Var.c(file, mapB);
            objN = new a6.m(true, str, null, null, null, 28);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "STEPCLAW_TRANSPORT_ERROR", thA.getMessage(), a0Var, 2);
        }
        return (a6.m) objN;
    }

    public static final a6.m b0(q0 q0Var, a6.d0 d0Var) {
        Object objN;
        f5.f fVar = q0Var.f6313b;
        String str = d0Var.f304b;
        String str2 = d0Var.f303a;
        File fileD = fVar.d(str);
        d7.a0 a0Var = d7.a0.f2944f;
        if (fileD == null) {
            return new a6.m(false, null, "BLOB_NOT_FOUND", a1.a.j("blob ", d0Var.f304b, " not in cache"), a0Var, 2);
        }
        File fileK = q0Var.f6312a.k(str2);
        if (!fileK.exists()) {
            return new a6.m(false, null, "NOT_FOUND", a1.a.j("skill ", str2, " not installed"), a0Var, 2);
        }
        try {
            a.a.L(fileD, fileK);
            objN = new a6.m(true, str2, null, null, null, 28);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            objN = new a6.m(false, null, "UPDATE_FAILED", thA.getMessage(), a0Var, 2);
        }
        return (a6.m) objN;
    }

    public static a6.b c0(String str, String str2, JSONObject jSONObject) {
        boolean zOptBoolean = jSONObject.optBoolean("enabled", true);
        String str3 = zOptBoolean ? "configured" : "disabled";
        String strX = a1.a.x(str, ":", str2);
        String strOptString = jSONObject.optString("version");
        q7.k.b(strOptString);
        if (strOptString.length() <= 0) {
            strOptString = null;
        }
        return new a6.b(strX, strX, str2, str3, strOptString, (List) null, zOptBoolean, (String) null, 416);
    }

    public static a6.i f0(String str) {
        String lowerCase;
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            q7.k.d(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            return a6.i.LOCAL;
        }
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -934610874) {
            if (iHashCode != 103145323) {
                if (iHashCode == 235331618 && lowerCase.equals("bundled")) {
                    return a6.i.BUNDLED;
                }
            } else if (lowerCase.equals("local")) {
                return a6.i.LOCAL;
            }
        } else if (lowerCase.equals("remote")) {
            return a6.i.REMOTE;
        }
        return a6.i.UNKNOWN;
    }

    @Override // a6.o
    public final Object A(String str, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new e0(this, str, null, 0), dVar);
    }

    @Override // a6.o
    public final Object B(String str, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new k0(0, wVar, null, str, this), dVar);
    }

    @Override // a6.o
    public final Object C(a6.h hVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new f0(this, hVar, null, 1), dVar);
    }

    @Override // a6.o
    public final Object D(String str, Map map, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new c6.g(this, str, map, (g7.d) null, 1), dVar);
    }

    @Override // a6.o
    public final Object E(String str, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new g0(this, wVar, str, null, 3), dVar);
    }

    @Override // a6.o
    public final Object F(int i2, String str, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new h0(i2, wVar, null, str, this), dVar);
    }

    @Override // a6.o
    public final Object G(a6.y yVar, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new g0(this, wVar, yVar, null, 0), dVar);
    }

    @Override // a6.o
    public final Object H(a6.c cVar, String str, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new p0(this, cVar, wVar, str, null), dVar);
    }

    @Override // a6.o
    public final Object a(String str, boolean z4, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new o0(this, str, wVar, z4, null, 0), dVar);
    }

    @Override // a6.o
    public final Object b(a6.d dVar, a6.w wVar, g7.d dVar2) {
        return ia.d0.B(this.f6314c.f5616a, new z2(this, dVar, wVar, null, 2), dVar2);
    }

    @Override // a6.o
    public final Object c(a6.d0 d0Var, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new z2(this, d0Var, wVar, null, 6), dVar);
    }

    @Override // a6.o
    public final Object d(String str, boolean z4, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new n0(this, str, wVar, z4, (g7.d) null), dVar);
    }

    public final t1 d0() {
        t1 t1Var = (t1) this.f6319h.c();
        if (t1Var != null && t1Var.f7596x.f7345b.getValue() == h1.ONLINE) {
            return t1Var;
        }
        return null;
    }

    @Override // a6.o
    public final Object e(String str, boolean z4, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new n0(str, this, wVar, z4, (g7.d) null), dVar);
    }

    public final void e0(String str, String str2, String str3) {
        this.f6321j.M(new a6.s(str, str2, str3, this.f6320i.incrementAndGet()));
    }

    @Override // a6.o
    public final Object f(a6.c cVar, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new g0(this, wVar, cVar, null, 2), dVar);
    }

    @Override // a6.o
    public final Object g(a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new z2(this, wVar, null, 4), dVar);
    }

    public final void g0(String str, String str2, boolean z4) throws IOException {
        this.f6316e.a((File) this.f6312a.f6342b, new c(z4, str2, str));
    }

    @Override // a6.o
    public final Object h(a6.h hVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new f0(this, hVar, null, 0), dVar);
    }

    @Override // a6.o
    public final Object i(String str, String str2, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new c6.g(this, str, str2, (g7.d) null, 2), dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
    
        if (r0.Q(r2) != r3) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // a6.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(a6.w r18, g7.d r19) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.j(a6.w, g7.d):java.lang.Object");
    }

    @Override // a6.o
    public final Object k(String str, boolean z4, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new o0(this, str, wVar, z4, null, 1), dVar);
    }

    @Override // a6.o
    public final Object l(g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new g3.b(this, null, 1), dVar);
    }

    @Override // a6.o
    public final Set m() {
        return a6.n.getSupportedNamespaces(this);
    }

    @Override // a6.o
    public final Object n(String str, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new k0(1, wVar, null, str, this), dVar);
    }

    @Override // a6.o
    public final Object o(String str, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new e0(this, str, null, 2), dVar);
    }

    @Override // a6.o
    public final Object p(a6.l lVar, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new z2(this, wVar, lVar, null, 5), dVar);
    }

    @Override // a6.o
    public final Object q(a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new d0(this, wVar, null, 0), dVar);
    }

    @Override // a6.o
    public final Object r(String str, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new e0(this, str, null, 1), dVar);
    }

    @Override // a6.o
    public final Object s(a6.d0 d0Var, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new d5.b(this, d0Var, null, 2), dVar);
    }

    @Override // a6.o
    public final Object t(Set set, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new d5.b(set, this, null, 1), dVar);
    }

    @Override // a6.o
    public final Object u(a6.a0 a0Var, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new g0(this, wVar, a0Var, null, 1), dVar);
    }

    @Override // a6.o
    public final la.e0 v() {
        return this.f6322k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0109, code lost:
    
        if (r0 != r1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079 A[PHI: r0 r13
      0x0079: PHI (r0v12 java.lang.Object) = (r0v7 java.lang.Object), (r0v3 java.lang.Object) binds: [B:47:0x00e1, B:19:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r13v4 'this' m4.q0) = (r13v2 'this' m4.q0), (r13v23 'this' m4.q0) binds: [B:47:0x00e1, B:19:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // a6.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(a6.w r14, g7.d r15) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.q0.w(a6.w, g7.d):java.lang.Object");
    }

    @Override // a6.o
    public final Object x(a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new d0(this, wVar, null, 1), dVar);
    }

    @Override // a6.o
    public final Object y(String str, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new k0(2, wVar, null, str, this), dVar);
    }

    @Override // a6.o
    public final Object z(a6.h hVar, a6.w wVar, g7.d dVar) {
        return ia.d0.B(this.f6314c.f5616a, new z2(this, hVar, wVar, null, 3), dVar);
    }
}
