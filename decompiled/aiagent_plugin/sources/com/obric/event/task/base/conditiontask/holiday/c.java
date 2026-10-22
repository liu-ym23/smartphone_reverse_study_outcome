package com.obric.event.task.base.conditiontask.holiday;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.LocaleList;
import android.os.Looper;
import android.util.Xml;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDL;
import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: Holidays.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private static final String TAG = "Holidays";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<LocalDate, d> f32697b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f32698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<e> f32699d = null;

    /* JADX INFO: compiled from: Holidays.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32700a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f32701b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f32702d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f32703e = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f32704c;

        private static final /* synthetic */ a[] a() {
            return new a[]{f32700a, f32701b};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f32704c = r3;
        }

        static {
            f32700a = new a("TYPE_WORKING", 0, 1);
            f32701b = new a("TYPE_WORK_OFF", 1, 2);
            a[] r0 = a();
            f32702d = r0;
            f32703e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f32702d.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: Holidays.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f32705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f32706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f32707c;

        public b(String r2, String r3, a r4) {
            o.e(r4, "type");
            this.f32705a = r2;
            this.f32706b = r3;
            this.f32707c = r4;
        }

        public final a getType() {
            return this.f32707c;
        }
    }

    /* JADX INFO: renamed from: com.obric.event.task.base.conditiontask.holiday.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Holidays.kt */
    public static final class C0898c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f32708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<b> f32709b;

        /* JADX WARN: Multi-variable type inference failed */
        public C0898c() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public C0898c(String r3, List<b> r4) {
            List<b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f32708a = r3;
            this.f32709b = r5;
        }

        public /* synthetic */ C0898c(String r2, List r3, int r4, h r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = null;
        L8:
            this(r2, r6);
        }

        public final List<b> a() {
            return this.f32709b;
        }
    }

    /* JADX INFO: compiled from: Holidays.kt */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f32711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private LocalDate f32712c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private LocalDate f32713d;

        public d(String r2, a r3, LocalDate r4, LocalDate r5) {
            o.e(r2, "name");
            o.e(r3, "type");
            this.f32710a = r2;
            this.f32711b = r3;
            this.f32712c = r4;
            this.f32713d = r5;
        }

        public final a getType() {
            return this.f32711b;
        }
    }

    /* JADX INFO: compiled from: Holidays.kt */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f32714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<C0898c> f32715b;

        /* JADX WARN: Multi-variable type inference failed */
        public e() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public e(String r3, List<C0898c> r4) {
            List<C0898c> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            this.f32714a = r3;
            this.f32715b = r5;
        }

        public /* synthetic */ e(String r2, List r3, int r4, h r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = null;
        L8:
            this(r2, r6);
        }

        public final List<C0898c> a() {
            return this.f32715b;
        }
    }

    /* JADX INFO: compiled from: Holidays.kt */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private XmlPullParser f32716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private InputStream f32717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f32718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f32719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32720e;
        private LocalDate f;
        private LocalDate g;

        public f(Context r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
            o.e(r9, "context");
            this.f = LocalDate.now();
            this.g = LocalDate.now();
            LocaleList r0 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getConfiguration().getLocales();
            o.c(r0, "getLocales(...)");
            boolean r3 = false;
            if (r0.isEmpty() == false) goto L5;
            String r1 = Locale.CHINA.getCountry();
        L7:
            if (o.a(r1, Locale.CHINA.getCountry()) == false) goto L9;
            String r2 = "holidays.xml";
        L10:
            File r4 = new File(r9.getFilesDir().getPath() + File.separator + r2);
            if (r4.exists() == false) goto L19;
            this.f32716a = Xml.newPullParser();
            InputStream r5 = (InputStream) ZeusTransformUtils.preCheckCast(new FileInputStream(r4), InputStream.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L17
            this.f32717b = r5;     // Catch: Exception -> L17
            XmlPullParser r6 = this.f32716a;     // Catch: Exception -> L17
            if (r6 == null) goto L20;
            r6.setInput(r5, "UTF-8");     // Catch: Exception -> L17
        L20:
            if (r3 == true) goto L22;
            return;
        L22:
            if (o.a(r1, Locale.CHINA.getCountry()) == false) goto L35;
            int r7 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin"), "holidays", "xml", r9.getPackageName(), "com.obric.aiagent.plugin");     // Catch: Exception -> L27
            if (r7 == 0) goto L36;
            this.f32716a = (XmlPullParser) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getXml(r7), XmlPullParser.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
            return;
        L36:
            return;
        L27:
            e = move-exception;
            com.obric.event.task.base.b.b.f32684a.b(c.TAG, "HolidaysParser Error loading default xml", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return;
        L35:
            return;
        L17:
            e = move-exception;
            com.obric.event.task.base.b.b.f32684a.b(c.TAG, "HolidaysParser Error parsing custom holidays xml", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        L19:
            r3 = true;
            goto L20
        L9:
            r2 = "holidays-" + r1 + ".xml";
            goto L10
        L5:
            r1 = r0.get(0).getCountry();
            goto L7
        }

        public final XmlPullParser a() {
            return this.f32716a;
        }

        private final boolean a(String r5) {
            XmlPullParser r0 = this.f32716a;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L17;
            XmlPullParser r4 = this.f32716a;
            if (r4 == null) goto L12;
            String r6 = r4.getName();
        L14:
            if (o.a(r5, r6) == false) goto L17;
            return true;
        L12:
            r6 = null;
        L17:
            return false;
        L5:
            if (r0.getEventType() != 2) goto L7;
            r1 = true;
            goto L8
        }

        private final boolean b(String r5) {
            XmlPullParser r0 = this.f32716a;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L17;
            XmlPullParser r4 = this.f32716a;
            if (r4 == null) goto L12;
            String r6 = r4.getName();
        L14:
            if (o.a(r5, r6) == false) goto L17;
            return true;
        L12:
            r6 = null;
        L17:
            return false;
        L5:
            if (r0.getEventType() != 3) goto L7;
            r1 = true;
            goto L8
        }

        public final void b() {
            XmlPullParser r2 = this.f32716a;
            if (r2 != null) goto L5;
            return;
        L5:
            c.a().clear();
            int r3 = r2.getEventType();     // Catch: Throwable -> L24 Exception -> L26
        L8:
            if (r3 == 1) goto L21;
            if (a("holidays") == false) goto L18;
            this.f32718c = r2.getAttributeValue(null, "working_day_name");     // Catch: Throwable -> L24 Exception -> L26
            r2.nextTag();     // Catch: Throwable -> L24 Exception -> L26
        L13:
            if (b("holidays") == true) goto L18;
            if (a("year") == false) goto L17;
            c();     // Catch: Throwable -> L24 Exception -> L26
        L17:
            r2.next();     // Catch: Throwable -> L24 Exception -> L26
        L18:
            r3 = r2.next();     // Catch: Throwable -> L24 Exception -> L26
            goto L8
        L21:
            if (ZeusTransformUtils.instanceOf(r2, XmlResourceParser.class) == false) goto L23;
        L22:
            ((XmlResourceParser) ZeusTransformUtils.preCheckCast(r2, XmlResourceParser.class, "com.obric.aiagent.plugin")).close();
            return;
        L23:
            com.obric.event.task.base.conditiontask.holiday.a.f32693a.a((Closeable) ZeusTransformUtils.preCheckCast(this.f32717b, Closeable.class, "com.obric.aiagent.plugin"));
            return;
        L26:
            e = move-exception;
            com.obric.event.task.base.b.b.f32684a.b(c.TAG, "HolidaysParser Parse holiday data failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L24
            if (ZeusTransformUtils.instanceOf(r2, XmlResourceParser.class) == false) goto L23;
        L24:
            th = move-exception;
            if (ZeusTransformUtils.instanceOf(r2, XmlResourceParser.class) == false) goto L35;
            ((XmlResourceParser) ZeusTransformUtils.preCheckCast(r2, XmlResourceParser.class, "com.obric.aiagent.plugin")).close();
        L36:
            throw th;
        L35:
            com.obric.event.task.base.conditiontask.holiday.a.f32693a.a((Closeable) ZeusTransformUtils.preCheckCast(this.f32717b, Closeable.class, "com.obric.aiagent.plugin"));
            goto L36
        }

        private final void c() {
            XmlPullParser r0 = this.f32716a;
            if (r0 != null) goto L5;
            return;
        L5:
            String r1 = r0.getAttributeValue(null, "value");
            if (r1 == null) goto L8;
            this.f32719d = Integer.parseInt(r1);
        L8:
            int r2 = this.f32719d;
            if (r2 <= this.f32720e) goto L11;
            this.f32720e = r2;
        L11:
            e r3 = new e(r1, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
            c.a().add(r3);
        L13:
            if (b("year") == true) goto L20;
            if (a("group") == false) goto L19;
            List<C0898c> r4 = r3.a();
            if (r4 == null) goto L19;
            a(r4);
        L19:
            r0.next();
            goto L13
        }

        private final void a(List<C0898c> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            XmlPullParser r0 = this.f32716a;
            if (r0 != null) goto L5;
            return;
        L5:
            String r2 = r0.getAttributeValue(null, "name");
            C0898c r3 = new C0898c(r2, (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
        L7:
            if (b("group") == true) goto L14;
            if (a("days") == false) goto L13;
            List<b> r1 = r3.a();
            if (r1 == null) goto L13;
            a(r2, r1);
        L13:
            r0.next();
            goto L7
        L14:
            r8.add(r3);
        }

        private final void a(String r20, List<b> r21) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
            XmlPullParser r3 = this.f32716a;
            if (r3 != null) goto L5;
            return;
        L5:
            LocalDate r4 = null;
            if (o.a("working", r3.getAttributeValue(null, "type")) == false) goto L8;
            a r5 = a.f32700a;
        L9:
            String r6 = r3.getAttributeValue(null, "start");
            String r7 = r3.getAttributeValue(null, "end");
            r1.add(new b(r6, r7, r5));
            if (r6 == null) goto L14;
            this.f = c(r6);
            if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"/"}, false, 0, 6, null).size() <= 1) goto L14;
            LocalDate r12 = this.f;
        L15:
            if (r7 == null) goto L19;
            this.g = c(r7);
            if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"/"}, false, 0, 6, null).size() <= 1) goto L21;
            r4 = this.g;
        L21:
            if (r5 != a.f32700a) goto L23;
            String r2 = this.f32718c;
        L24:
            LocalDate r8 = this.f;
        L26:
            if (r8.compareTo((ChronoLocalDate) ZeusTransformUtils.preCheckCast(this.g, ChronoLocalDate.class, "com.obric.aiagent.plugin")) > 0) goto L28;
            c r9 = c.f32696a;
            o.a(r8);
            c.a(r9, r2, r5, r8, r12, r4);
            r8 = r8.plusDays(1);
            goto L26
        L28:
            return;
        L23:
            r2 = r20;
            goto L24
        L19:
            this.g = this.f;
        L14:
            r12 = null;
            goto L15
        L8:
            r5 = a.f32701b;
            goto L9
        }

        private final LocalDate c(String r9) {
            List r10 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"/"}, false, 0, 6, null);
            int r2 = 0;
            if (r10.size() != 3) goto L5;
            int r8 = Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.aiagent.plugin"));
            r2 = 1;
        L6:
            int r0 = r2 + 1;
            LocalDate r11 = LocalDate.of(r8, Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(r2), String.class, "com.obric.aiagent.plugin")), Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r10.get(r0), String.class, "com.obric.aiagent.plugin")));
            o.c(r11, "of(...)");
            return r11;
        L5:
            r8 = this.f32719d;
            goto L6
        }
    }

    /* JADX INFO: renamed from: lambda$FBZTr8lvM15k5BqvJHn9ss0-XUc, reason: not valid java name */
    public static /* synthetic */ boolean m940lambda$FBZTr8lvM15k5BqvJHn9ss0XUc() {
        return b();
    }

    public static /* synthetic */ void lambda$rOUwmkX9jAQFLPqgqmoIc9hI9UE(IFlowAppStateIDL r0) {
        a(r0);
    }

    private c() {
    }

    public static final /* synthetic */ List a() {
        return f32699d;
    }

    public static final /* synthetic */ void a(c r0, String r1, a r2, LocalDate r3, LocalDate r4, LocalDate r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    static {
        f32696a = new c();
        f32697b = new HashMap(200);
        f32699d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Looper.getMainLooper().getQueue().addIdleHandler($$Lambda$c$FBZTr8lvM15k5BqvJHn9ss0XUc.INSTANCE);
        s.a(aa.b(IFlowAppStateIDL.class), false, false, $$Lambda$c$rOUwmkX9jAQFLPqgqmoIc9hI9UE.INSTANCE, 3, null);
    }

    private static final boolean b() {
        com.obric.event.task.base.conditiontask.holiday.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return false;
    }

    private static final void a(IFlowAppStateIDL r3) {
        IFlowAppStateIDL r4 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        o.e(r4, "it");
        r4.registerAppStateListener((IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.preCheckCast(new Holidays$2$1(), IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin"));
    }

    private final synchronized void c(Context r3) {
        monitor-enter(this);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (f32698c == true) goto L6;
        new f(r4).b();     // Catch: Throwable -> L8
        f32698c = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final void a(String r3, a r4, LocalDate r5, LocalDate r6, LocalDate r7) {
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(f32697b, Map.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r2.put(r5, new d(r3, r4, r6, r7));
    }

    public static final synchronized d a(Context r3, LocalDate r4) {
        monitor-enter(c.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        o.e(r5, "context");     // Catch: Throwable -> L10
        o.e(r4, "date");     // Catch: Throwable -> L10
        if (f32698c == true) goto L7;
        f32696a.c(r5);     // Catch: Throwable -> L10
    L7:
        d r6 = (d) ZeusTransformUtils.preCheckCast(f32697b.get(r4), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r6;
    L10:
        th = move-exception;
        throw th;
    }

    public static final synchronized void a(Context r3) {
        monitor-enter(c.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        o.e(r4, "context");     // Catch: Throwable -> L11
        f r1 = new f(r4);     // Catch: Throwable -> L11
        if (r1.a() != null) goto L8;
        monitor-exit(c.class);
        return;
    L8:
        f32697b.clear();     // Catch: Throwable -> L11
        r1.b();     // Catch: Throwable -> L11
        monitor-exit(c.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static final boolean b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        LocaleList r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getConfiguration().getLocales();
        o.c(r4, "getLocales(...)");
        if (r4.isEmpty() == false) goto L5;
        return false;
    L5:
        if (o.a(r4.get(0).getCountry(), Locale.CHINA.getCountry()) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
