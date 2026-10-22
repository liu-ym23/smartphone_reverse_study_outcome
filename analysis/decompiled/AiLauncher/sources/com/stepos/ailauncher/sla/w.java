package com.stepos.ailauncher.sla;

import La.C0953c;
import Z8.C1174w;
import Z8.Q;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJC\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR(\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\r0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/sla/w;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "Lcom/stepos/ailauncher/sla/w$a;", "actions", "", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/util/List;)Ljava/lang/String;", "function", "", "params", "table", "e", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;", M5.e.FAIL_TEMPLATE, "c", "(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;)Ljava/lang/Boolean;", "f", "(Landroid/content/Context;)Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "TAG", "Ljava/lang/String;", "ASSET_NAME", "OPEN_APP_BY_NAME", "JOINER", "Ljava/util/concurrent/atomic/AtomicReference;", "tableRef", "Ljava/util/concurrent/atomic/AtomicReference;", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    private static final String ASSET_NAME = "sla_offline_user_copy.json";
    private static final String JOINER = "，";
    public static final String OPEN_APP_BY_NAME = "open_app_by_name";
    private static final String TAG = "SLA";
    public static final w INSTANCE = new w();
    private static final AtomicReference<Map<String, String>> tableRef = new AtomicReference<>(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/sla/w$a;", "", "", "function", "", "params", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.sla.w$a, reason: from toString */
    public static final /* data */ class Action {
        private final String function;
        private final Map<String, String> params;

        public Action(String str, Map<String, String> params) {
            kotlin.jvm.internal.p.i(params, "params");
            this.function = str;
            this.params = params;
        }

        /* renamed from: a, reason: from getter */
        public final String getFunction() {
            return this.function;
        }

        public final Map<String, String> b() {
            return this.params;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Action)) {
                return false;
            }
            Action action = (Action) other;
            return kotlin.jvm.internal.p.d(this.function, action.function) && kotlin.jvm.internal.p.d(this.params, action.params);
        }

        public int hashCode() {
            String str = this.function;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.params.hashCode();
        }

        public String toString() {
            return "Action(function=" + this.function + ", params=" + this.params + ")";
        }
    }

    public final Map<String, String> a(Context context) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream inputStreamOpen = context.getAssets().open(ASSET_NAME);
            kotlin.jvm.internal.p.h(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, C0953c.UTF_8), com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
            try {
                JSONObject jSONObject = new JSONObject(l9.m.e(bufferedReader));
                Map mapC = Q.c();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObject.optString(next);
                    kotlin.jvm.internal.p.h(strOptString, "optString(...)");
                    String string = La.H.D1(strOptString).toString();
                    kotlin.jvm.internal.p.f(next);
                    if (!La.H.x0(next) && string.length() > 0) {
                        mapC.put(next, string);
                    }
                }
                Map mapB = Q.b(mapC);
                l9.b.a(bufferedReader, null);
                C4148a.k("SLA", "loaded sla_offline_user_copy.json entries=" + mapB.size(), false, 4, null);
                objB = Result.b(mapB);
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g("SLA", "load sla_offline_user_copy.json failed: " + thE.getMessage(), thE, false, 8, null);
            objB = kotlin.collections.a.i();
        }
        return (Map) objB;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        if (r3.equals("false") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
    
        if (r3.equals("close") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0086, code lost:
    
        if (r3.equals("true") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
    
        if (r3.equals("open") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
    
        if (r3.equals("yes") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
    
        if (r3.equals(W4.a.ENABLE_OFF) == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
    
        if (r3.equals(W4.a.ENABLE_ON) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b5, code lost:
    
        if (r3.equals("no") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00be, code lost:
    
        if (r3.equals("1") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c3, code lost:
    
        return java.lang.Boolean.TRUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ca, code lost:
    
        if (r3.equals("0") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00cf, code lost:
    
        return java.lang.Boolean.FALSE;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Boolean b(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r3 = this;
            java.lang.String r3 = "openState"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            r0 = 0
            java.lang.String r1 = "toLowerCase(...)"
            if (r3 == 0) goto L24
            java.lang.CharSequence r3 = La.H.D1(r3)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L24
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r2)
            kotlin.jvm.internal.p.h(r3, r1)
            if (r3 != 0) goto L65
        L24:
            java.lang.String r3 = "open_state"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L43
            java.lang.CharSequence r3 = La.H.D1(r3)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L43
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            kotlin.jvm.internal.p.h(r3, r1)
            goto L65
        L43:
            java.lang.String r3 = "enable"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L61
            java.lang.CharSequence r3 = La.H.D1(r3)
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L61
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toLowerCase(r4)
            kotlin.jvm.internal.p.h(r3, r1)
            goto L62
        L61:
            r3 = r0
        L62:
            if (r3 != 0) goto L65
            return r0
        L65:
            int r4 = r3.hashCode()
            switch(r4) {
                case 48: goto Lc4;
                case 49: goto Lb8;
                case 3521: goto Laf;
                case 3551: goto La6;
                case 109935: goto L9d;
                case 119527: goto L93;
                case 3417674: goto L89;
                case 3569038: goto L7f;
                case 94756344: goto L76;
                case 97196323: goto L6d;
                default: goto L6c;
            }
        L6c:
            goto Lcc
        L6d:
            java.lang.String r4 = "false"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lcd
            goto Lcc
        L76:
            java.lang.String r4 = "close"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lcd
            goto Lcc
        L7f:
            java.lang.String r4 = "true"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
            goto Lcc
        L89:
            java.lang.String r4 = "open"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
            goto Lcc
        L93:
            java.lang.String r4 = "yes"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
            goto Lcc
        L9d:
            java.lang.String r4 = "off"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lcd
            goto Lcc
        La6:
            java.lang.String r4 = "on"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto Lcc
            goto Lc1
        Laf:
            java.lang.String r4 = "no"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lcd
            goto Lcc
        Lb8:
            java.lang.String r4 = "1"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lc1
            goto Lcc
        Lc1:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            return r3
        Lc4:
            java.lang.String r4 = "0"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Lcd
        Lcc:
            return r0
        Lcd:
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.w.b(java.util.Map):java.lang.Boolean");
    }

    public final String c(String template, Map<String, String> params) {
        Boolean boolB;
        String str;
        kotlin.jvm.internal.p.i(template, "template");
        kotlin.jvm.internal.p.i(params, "params");
        String string = La.H.D1(template).toString();
        if (string.length() == 0) {
            return null;
        }
        if (!La.H.f0(string, '|', false, 2, null)) {
            return string;
        }
        List listA1 = La.H.a1(string, new char[]{'|'}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(C1174w.x(listA1, 10));
        Iterator it = listA1.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty() || (boolB = b(params)) == null) {
            return null;
        }
        return (boolB.booleanValue() || (str = (String) Z8.F.t0(arrayList2, 1)) == null) ? (String) Z8.F.s0(arrayList2) : str;
    }

    public final String d(Context context, List<Action> actions) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(actions, "actions");
        if (actions.isEmpty()) {
            C4148a.d("SLA", "offline user copy miss: empty actions", false, 4, null);
            return "";
        }
        Map<String, String> mapF = f(context);
        ArrayList arrayList = new ArrayList(actions.size());
        for (Action action : actions) {
            String strE = e(action.getFunction(), action.b(), mapF);
            if (strE == null || strE.length() == 0) {
                C4148a.d("SLA", "offline user copy miss ability=" + action.getFunction() + " params=" + action.b(), false, 4, null);
                return "";
            }
            arrayList.add(strE);
        }
        String strA0 = Z8.F.A0(arrayList, JOINER, null, null, 0, null, null, 62, null);
        List<Action> list = actions;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((Action) it.next()).getFunction());
        }
        C4148a.k("SLA", "offline user copy resolved \"" + strA0 + "\" from " + arrayList2, false, 4, null);
        return strA0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String e(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "params"
            kotlin.jvm.internal.p.i(r4, r0)
            java.lang.String r0 = "table"
            kotlin.jvm.internal.p.i(r5, r0)
            r0 = 0
            if (r3 == 0) goto L18
            java.lang.CharSequence r3 = La.H.D1(r3)
            java.lang.String r3 = r3.toString()
            goto L19
        L18:
            r3 = r0
        L19:
            if (r3 != 0) goto L1d
            java.lang.String r3 = ""
        L1d:
            int r1 = r3.length()
            if (r1 != 0) goto L24
            return r0
        L24:
            java.lang.String r1 = "open_app_by_name"
            boolean r1 = kotlin.jvm.internal.p.d(r3, r1)
            if (r1 == 0) goto La4
            java.lang.String r2 = "appName"
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L4b
            java.lang.CharSequence r2 = La.H.D1(r2)
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L4b
            int r3 = r2.length()
            if (r3 <= 0) goto L48
            goto L49
        L48:
            r2 = r0
        L49:
            if (r2 != 0) goto L88
        L4b:
            java.lang.String r2 = "app_name"
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L66
            java.lang.CharSequence r2 = La.H.D1(r2)
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L66
            int r3 = r2.length()
            if (r3 <= 0) goto L66
            goto L67
        L66:
            r2 = r0
        L67:
            if (r2 != 0) goto L88
            java.lang.String r2 = "app_label"
            java.lang.Object r2 = r4.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L84
            java.lang.CharSequence r2 = La.H.D1(r2)
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L84
            int r3 = r2.length()
            if (r3 <= 0) goto L84
            goto L85
        L84:
            r2 = r0
        L85:
            if (r2 != 0) goto L88
            return r0
        L88:
            r3 = 0
            r4 = 2
            java.lang.String r5 = "打开"
            boolean r3 = La.D.X(r2, r5, r3, r4, r0)
            if (r3 == 0) goto L94
            return r2
        L94:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            return r2
        La4:
            java.lang.Object r3 = r5.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto Lad
            return r0
        Lad:
            java.lang.String r2 = r2.c(r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.w.e(java.lang.String, java.util.Map, java.util.Map):java.lang.String");
    }

    public final Map<String, String> f(Context context) {
        AtomicReference<Map<String, String>> atomicReference = tableRef;
        Map<String, String> map = atomicReference.get();
        if (map != null) {
            return map;
        }
        synchronized (this) {
            Map<String, String> map2 = atomicReference.get();
            if (map2 != null) {
                return map2;
            }
            w wVar = INSTANCE;
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            Map<String, String> mapA = wVar.a(applicationContext);
            atomicReference.set(mapA);
            return mapA;
        }
    }
}
