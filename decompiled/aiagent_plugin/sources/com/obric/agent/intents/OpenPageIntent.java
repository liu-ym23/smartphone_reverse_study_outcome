package com.obric.agent.intents;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemOpenPageIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemOpenPageParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OpenPageIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OpenPageIntent extends BaseSystemOpenPageIntent {
    public static final a Companion = null;
    private static final String DORA_PAGE_TYPE = "settings_ola_earphone";
    private static final String INTENT_URI_SCHEME_PREFIX = "intent:";
    private static final String SYSTEM_PARSE_PAGE_TYPE = "use_system_parse";
    private static final String TAG = "OpenPageIntent";

    /* JADX INFO: compiled from: OpenPageIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OpenPageIntent.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f14652d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f14653e;
        private final String f;
        private final String g;
        private final Integer h;
        private final Map<String, String> i;
        private final Map<String, Boolean> j;
        private final Map<String, Integer> k;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f14649a, r6.f14649a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f14650b, r6.f14650b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f14651c, r6.f14651c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f14652d, r6.f14652d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f14653e, r6.f14653e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (o.a(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (o.a(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (o.a(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (o.a(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14649a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14650b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f14651c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.f14652d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.f14653e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.f;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.g;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            Integer r22 = this.h;
            if (r22 == null) goto L35;
            r1 = r22.hashCode();
        L35:
            return ((((((r21 + r1) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("IntentUrl(scheme=").append(this.f14649a).append(", host=").append(this.f14650b).append(", path=").append(this.f14651c).append(", packageName=").append(this.f14652d).append(", action=").append(this.f14653e).append(", category=").append(this.f).append(", component=").append(this.g).append(", flags=").append(this.h).append(", extrasString=").append(this.i).append(", extrasBoolean=").append(this.j).append(", extrasInt=").append(this.k).append(')');
            return r0.toString();
        }

        public b(String r3, String r4, String r5, String r6, String r7, String r8, String r9, Integer r10, Map<String, String> r11, Map<String, Boolean> r12, Map<String, Integer> r13) {
            Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
            Map<String, Boolean> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
            Map<String, Integer> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
            o.e(r14, "extrasString");
            o.e(r15, "extrasBoolean");
            o.e(r16, "extrasInt");
            this.f14649a = r3;
            this.f14650b = r4;
            this.f14651c = r5;
            this.f14652d = r6;
            this.f14653e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r14;
            this.j = r15;
            this.k = r16;
        }

        public final String a() {
            return this.f14649a;
        }

        public final String b() {
            return this.f14650b;
        }

        public final String c() {
            return this.f14651c;
        }

        public final String d() {
            return this.f14652d;
        }

        public final String e() {
            return this.f14653e;
        }

        public final String f() {
            return this.g;
        }

        public final Map<String, String> g() {
            return this.i;
        }

        public final Map<String, Boolean> h() {
            return this.j;
        }

        public final Map<String, Integer> i() {
            return this.k;
        }
    }

    static {
        Companion = new a(null);
    }

    public OpenPageIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemOpenPageIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemOpenPageParams) ZeusTransformUtils.preCheckCast(r6, SystemOpenPageParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemOpenPageIntent
    public Object doAction(SystemOpenPageParams r34, DispatchContext r35, d<? super IntentResult<Empty>> r36) {
        d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r36, d.class, "com.obric.aiagent.plugin");
        b r3 = parseIntentUrl(r34.getUri());
        ILogDepend.Companion.i(TAG, "open page " + r3);
        x r9 = null;
        if (d.o.o.a(r34.getPageType(), DORA_PAGE_TYPE, false, 2, null) == false) goto L19;
        ILogDepend.Companion.i(TAG, "open dora page");
        n.a r4 = n.f38560a;     // Catch: Throwable -> L10
        OpenPageIntent r0 = (OpenPageIntent) ZeusTransformUtils.preCheckCast(this, OpenPageIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        IFlowAppIntentIDL r1 = r.a(aa.b(IFlowAppIntentIDL.class));     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        r1.jumpDoraPage();     // Catch: Throwable -> L10
        r9 = x.f38692a;     // Catch: Throwable -> L10
    L8:
        Object r5 = n.f(r9);     // Catch: Throwable -> L10
    L12:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L17;
        ILogDepend.Companion.i(TAG, "open dora page fail " + r6.getMessage());
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L17:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L10:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L12
    L19:
        if (d.o.o.a(r34.getPageType(), SYSTEM_PARSE_PAGE_TYPE, false, 2, null) == false) goto L23;
        return openWithSystemParse(r34.getUri(), r35);
    L23:
        if (r3 == null) goto L64;
        Intent r8 = new Intent();
        if (r3.d() == null) goto L28;
        r8.setPackage(r3.d());
    L28:
        if (r3.d() == null) goto L33;
        if (r3.f() == null) goto L33;
        r8.setComponent(new ComponentName(r3.d(), r3.f()));
    L33:
        if (r3.e() == null) goto L36;
        r8.setAction(r3.e());
    L36:
        if (r3.a() != null) goto L38;
    L43:
        Iterator<Map.Entry<String, String>> r10 = r3.g().entrySet().iterator();
    L45:
        if (r10.hasNext() == false) goto L47;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.putExtra((String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r11.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L45
    L47:
        Iterator<Map.Entry<String, Boolean>> r12 = r3.h().entrySet().iterator();
    L49:
        if (r12.hasNext() == false) goto L51;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.putExtra((String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r13.getValue(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        goto L49
    L51:
        Iterator<Map.Entry<String, Integer>> r14 = r3.i().entrySet().iterator();
    L53:
        if (r14.hasNext() == false) goto L55;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.putExtra((String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r15.getValue(), Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L53
    L55:
        r8.addFlags(268468224);
        n.a r16 = n.f38560a;     // Catch: Throwable -> L58
        OpenPageIntent r17 = (OpenPageIntent) ZeusTransformUtils.preCheckCast(this, OpenPageIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r35.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        Object r18 = n.f(x.f38692a);     // Catch: Throwable -> L58
    L61:
        if (n.a(r18) == false) goto L64;
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L58:
        th = move-exception;
        n.a r19 = n.f38560a;
        r18 = n.f(d.o.a(th));
        goto L61
    L38:
        if (r3.b() == null) goto L43;
        StringBuilder r20 = new StringBuilder().append(r3.a()).append("://").append(r3.b());
        String r21 = r3.c();
        if (r21 != null) goto L42;
        r21 = "";
    L42:
        r8.setData(Uri.parse(r20.append(r21).toString()));
    L64:
        ILogDepend.Companion.i(TAG, "open page failed " + r34.getPageType() + ' ' + r34.getUri());
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    private final IntentResult<Empty> openWithSystemParse(String r18, DispatchContext r19) {
        ILogDepend.Companion.i(TAG, "openWithSystemParse uri=" + r18);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        ILogDepend.Companion.e(TAG, "system parse uri is null or blank");
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L13:
        if (isIntentUri(r18) == false) goto L15;
        Intent r2 = parseIntentUri(r18);
    L16:
        if (r2 != null) goto L19;
        ILogDepend.Companion.e(TAG, "system parse failed: " + r18);
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L19:
        r2.addFlags(268435456);
        n.a r4 = n.f38560a;     // Catch: Throwable -> L22
        OpenPageIntent r5 = (OpenPageIntent) ZeusTransformUtils.preCheckCast(this, OpenPageIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r19.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        Object r3 = n.f(x.f38692a);     // Catch: Throwable -> L22
    L25:
        if (n.a(r3) == false) goto L28;
        ILogDepend.Companion.i(TAG, "openWithSystemParse success: " + r18);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L28:
        ILogDepend.Companion r6 = ILogDepend.Companion;
        StringBuilder r7 = new StringBuilder().append("openWithSystemParse failed: ").append(r18).append(", e=");
        Throwable r8 = n.c(r3);
        if (r8 == null) goto L31;
        String r9 = r8.getMessage();
    L32:
        r6.e(TAG, r7.append(r9).toString());
        return new IntentResult(102, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L31:
        r9 = null;
    L22:
        th = move-exception;
        n.a r10 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L25
    L15:
        r2 = parseDeepLink(r18);
        goto L16
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final boolean isIntentUri(String r2) {
        return d.o.o.b(r2, INTENT_URI_SCHEME_PREFIX, true);
    }

    private final Intent parseIntentUri(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        OpenPageIntent r2 = (OpenPageIntent) ZeusTransformUtils.preCheckCast(this, OpenPageIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(Intent.parseUri(r3, 1));     // Catch: Throwable -> L5
    L8:
        if (n.b(r4) == false) goto L11;
        r4 = null;
    L11:
        return (Intent) ZeusTransformUtils.preCheckCast(r4, Intent.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r5 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L8
    }

    private final Intent parseDeepLink(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        OpenPageIntent r2 = (OpenPageIntent) ZeusTransformUtils.preCheckCast(this, OpenPageIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(Uri.parse(r3));     // Catch: Throwable -> L5
    L8:
        if (n.b(r4) == false) goto L10;
        r4 = null;
    L10:
        Uri r5 = (Uri) ZeusTransformUtils.preCheckCast(r4, Uri.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L14;
        return null;
    L14:
        return new Intent("android.intent.action.VIEW", r5);
    L5:
        th = move-exception;
        n.a r6 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L8
    }

    private final b parseIntentUrl(String r27) {
        Object r1 = null;
        if (r27 != null) goto L5;
        return null;
    L5:
        int r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.aiagent.plugin"), "#Intent;", 0, false, 6, null);
        if (r2 != (-1)) goto L8;
        return null;
    L8:
        String r6 = r27.substring(0, r2);
        o.c(r6, "substring(...)");
        String r0 = r27.substring(r2 + 8);
        o.c(r0, "substring(...)");
        if (d.o.o.b(r6, "intent://", false, 2, null) == false) goto L11;
        r6 = d.o.o.a(r6, (CharSequence) ZeusTransformUtils.preCheckCast("intent://", CharSequence.class, "com.obric.aiagent.plugin"));
    L11:
        int r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), '/', 0, false, 6, null);
        if (r3 == (-1)) goto L14;
        String r9 = r6.substring(0, r3);
        o.c(r9, "substring(...)");
        String r12 = r9;
    L15:
        if (r3 == (-1)) goto L17;
        String r4 = r6.substring(r3);
        o.c(r4, "substring(...)");
        String r13 = r4;
    L18:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{';'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L20:
        if (r8.hasNext() == false) goto L25;
        Object r10 = r8.next();
        if ((!o.a((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin"), "end")) == false) goto L25;
        r7.add(r10);
    L25:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r17 = r11.iterator();
        String r18 = null;
        String r19 = null;
        String r110 = null;
        String r111 = null;
        String r112 = null;
        Integer r113 = null;
    L27:
        if (r17.hasNext() == false) goto L69;
        Object r20 = r17.next();
        o.c(r20, "next(...)");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.aiagent.plugin");
        if (d.o.o.b(r21, "scheme=", false, 2, r1) == true) goto L30;
        if (d.o.o.b(r21, "package=", false, 2, r1) == true) goto L33;
        if (d.o.o.b(r21, "action=", false, 2, r1) == true) goto L36;
        if (d.o.o.b(r21, "category=", false, 2, r1) == true) goto L39;
        if (d.o.o.b(r21, "component=", false, 2, r1) == true) goto L43;
        if (d.o.o.b(r21, "flags=", false, 2, r1) == true) goto L46;
        if (d.o.o.b(r21, "S.", false, 2, r1) == false) goto L54;
        List r22 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("S.", CharSequence.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'='}, false, 2, 2, null);
        if (r22.size() != 2) goto L52;
        r14.put(r22.get(0), r22.get(1));
    L52:
        boolean r114 = true;
    L67:
        r1 = null;
        goto L27
    L54:
        if (d.o.o.b(r21, "B.", false, 2, r1) == false) goto L59;
        List r23 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("B.", CharSequence.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'='}, false, 2, 2, null);
        if (r23.size() != 2) goto L52;
        r15.put(r23.get(0), Boolean.valueOf(Boolean.parseBoolean((String) ZeusTransformUtils.preCheckCast(r23.get(1), String.class, "com.obric.aiagent.plugin"))));
        goto L52
    L59:
        if (d.o.o.b(r21, "i.", false, 2, r1) == false) goto L52;
        List r24 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("i.", CharSequence.class, "com.obric.aiagent.plugin")), CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'='}, false, 2, 2, null);
        if (r24.size() != 2) goto L52;
        Object r25 = r24.get(0);
        r114 = true;
        Object r26 = r24.get(1);
        o.c(r26, "get(...)");
        Integer r28 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.aiagent.plugin"));
        if (r28 == null) goto L65;
        int r29 = r28.intValue();
    L66:
        r16.put(r25, Integer.valueOf(r29));
        goto L67
    L65:
        r29 = 0;
        goto L66
    L46:
        r113 = d.o.o.d(d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("flags=", CharSequence.class, "com.obric.aiagent.plugin")));
        goto L27
    L43:
        r112 = d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("component=", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L27
    L39:
        r111 = d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("category=", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L27
    L36:
        r110 = d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("action=", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L27
    L33:
        r19 = d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("package=", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L27
    L30:
        r18 = d.o.o.a(r21, (CharSequence) ZeusTransformUtils.preCheckCast("scheme=", CharSequence.class, "com.obric.aiagent.plugin"));
        goto L27
    L69:
        return new b(r18, r12, r13, r19, r110, r111, r112, r113, r14, r15, r16);
    L17:
        r13 = null;
        goto L18
    L14:
        r12 = r6;
        goto L15
    }
}
