package com.obric.agent.omnimodel;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OmniModelServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OmniModelServiceImpl implements IOmniModelService {

    @Deprecated
    public static final String CURRENT_MODEL_CHAT = "chat";
    private static final a Companion = null;

    @Deprecated
    public static final String TAG = "OmniModelServiceImpl";
    private final Gson gson;
    private volatile List<IOmniModelService.c> overriddenEntries;
    private final List<IOmniModelService.c> stubEntries;

    /* JADX INFO: compiled from: OmniModelServiceImpl.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniModelServiceImpl.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("models")
        private final List<IOmniModelService.c> f15390a;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15390a, r6.f15390a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            List<IOmniModelService.c> r0 = this.f15390a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "ModelListResponse(models=" + this.f15390a + ')';
        }

        public b(List<IOmniModelService.c> r3) {
            this.f15390a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ b(List r2, int r3, h r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = null;
        L5:
            this(r5);
        }

        public final List<IOmniModelService.c> a() {
            return this.f15390a;
        }
    }

    static {
        Companion = new a(null);
    }

    public OmniModelServiceImpl() {
        this.gson = new Gson();
        this.stubEntries = p.b(new IOmniModelService.c[]{new IOmniModelService.c("Seed 2.1 Lite", IOmniModelService.MODEL_LITE), new IOmniModelService.c("Seed 2.1 Turbo", IOmniModelService.MODEL_TURBO)});
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c parseEntryFromJson(String r1) {
        return IOmniModelService.b.a(this, r1);
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public String toExtValue(IOmniModelService.c r1) {
        return IOmniModelService.b.a(this, r1);
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public synchronized List<IOmniModelService.c> availableEntries() {
        monitor-enter(this);
        List<IOmniModelService.c> r0 = this.overriddenEntries;     // Catch: Throwable -> L58
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        Object r1 = null;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L41
        OmniModelServiceImpl r3 = (OmniModelServiceImpl) ZeusTransformUtils.preCheckCast(this, OmniModelServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        IFlowUiIDL r4 = aw.a(aa.b(IFlowUiIDL.class));     // Catch: Throwable -> L41
        if (r4 == null) goto L11;
        String r5 = r4.getTaskSkillModelJson();     // Catch: Throwable -> L41
    L12:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == true) goto L38;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r3.gson.fromJson(r5, b.class), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r8 == null) goto L38;
        List<IOmniModelService.c> r9 = r8.a();     // Catch: Throwable -> L41
        if (r9 == null) goto L38;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L41
    L26:
        if (r12.hasNext() == false) goto L35;
        Object r13 = r12.next();     // Catch: Throwable -> L41
        IOmniModelService.c r14 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r13, IOmniModelService.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14.a(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L30;
    L32:
        boolean r15 = false;
    L33:
        if (r15 == false) goto L26;
        r11.add(r13);     // Catch: Throwable -> L41
        goto L26
    L30:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14.b(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L32;
        r15 = true;
        goto L33
    L35:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L38;
    L39:
        Object r17 = n.f(r16);     // Catch: Throwable -> L41
    L43:
        Throwable r18 = n.c(r17);     // Catch: Throwable -> L58
        if (r18 == null) goto L47;
        ILogDepend.Companion.e(TAG, "parse task skill model list from IPC failed", r18);     // Catch: Throwable -> L58
    L47:
        if (n.b(r17) == true) goto L50;
        r1 = r17;
    L50:
        List<IOmniModelService.c> r19 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L58
        if (r19 == null) goto L55;
        this.overriddenEntries = r19;     // Catch: Throwable -> L58
        monitor-exit(this);
        return r19;
    L55:
        List<IOmniModelService.c> r20 = this.stubEntries;     // Catch: Throwable -> L58
        monitor-exit(this);
        return r20;
    L38:
        r16 = null;
        goto L39
    L15:
        if (d.o.o.d(r6) == true) goto L18;
        r7 = false;
        goto L19
    L11:
        r5 = null;
    L41:
        th = move-exception;
        n.a r21 = n.f38560a;     // Catch: Throwable -> L58
        r17 = n.f(d.o.a(th));     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public String defaultDisplayModel() {
        IOmniModelService.c r0 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(p.l(availableEntries()), IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        String r1 = r0.a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return ((IOmniModelService.c) ZeusTransformUtils.preCheckCast(p.k(this.stubEntries), IOmniModelService.c.class, "com.obric.aiagent.plugin")).a();
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c defaultEntry() {
        IOmniModelService.c r0 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(p.l(availableEntries()), IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (IOmniModelService.c) ZeusTransformUtils.preCheckCast(p.k(this.stubEntries), IOmniModelService.c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c getEntryByDisplayModel(String r7) {
        String r8 = IOmniModelService.Companion.a(r7);
        Object r2 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r8 = null;
    L6:
        if (r8 == null) goto L8;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(availableEntries(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        Object r3 = r0.next();
        if (o.a(IOmniModelService.Companion.a(((IOmniModelService.c) ZeusTransformUtils.preCheckCast(r3, IOmniModelService.c.class, "com.obric.aiagent.plugin")).a()), r8) == false) goto L11;
        r2 = r3;
    L15:
        IOmniModelService.c r9 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r2, IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L18;
        return r9;
    L18:
        return defaultEntry();
    L8:
        return defaultEntry();
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c getEntryByModel(String r6) {
        if (r6 == null) goto L20;
        Object r2 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L20;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(availableEntries(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        Object r3 = r0.next();
        if (o.a(((IOmniModelService.c) ZeusTransformUtils.preCheckCast(r3, IOmniModelService.c.class, "com.obric.aiagent.plugin")).b(), r6) == false) goto L11;
        r2 = r3;
    L15:
        IOmniModelService.c r7 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r2, IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L18;
        return r7;
    L18:
        return defaultEntry();
    L20:
        return defaultEntry();
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public String eventTaskDefaultDisplayModel() {
        Object r2 = null;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L9
        OmniModelServiceImpl r4 = (OmniModelServiceImpl) ZeusTransformUtils.preCheckCast(this, OmniModelServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        IFlowUiIDL r5 = aw.a(aa.b(IFlowUiIDL.class));     // Catch: Throwable -> L9
        if (r5 == null) goto L6;
        String r6 = r5.getCurrentDisplayModel();     // Catch: Throwable -> L9
    L7:
        Object r7 = n.f(r6);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L15;
        ILogDepend.Companion.e(TAG, "get current display model from IPC failed", r8);
    L15:
        if (n.b(r7) == false) goto L17;
        r7 = null;
    L17:
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r11 = false;
        if (r10 != null) goto L20;
    L23:
        boolean r12 = true;
    L24:
        if (r12 == false) goto L26;
    L78:
        n.a r13 = n.f38560a;     // Catch: Throwable -> L45
        OmniModelServiceImpl r0 = (OmniModelServiceImpl) ZeusTransformUtils.preCheckCast(this, OmniModelServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        IFlowSettingsIDL r14 = at.a(aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L45
        if (r14 == null) goto L32;
        String r15 = r14.getAutoGuiFastModeUseSettings();     // Catch: Throwable -> L45
    L33:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        if (r16 != null) goto L36;
    L39:
        boolean r17 = true;
    L40:
        if (r17 == true) goto L42;
        IOmniModelService.c r1 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r0.gson.fromJson(r15, IOmniModelService.c.class), IOmniModelService.c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
    L43:
        Object r18 = n.f(r1);     // Catch: Throwable -> L45
    L47:
        Throwable r19 = n.c(r18);
        if (r19 == null) goto L51;
        ILogDepend.Companion.e(TAG, "parse fast mode setting from IPC failed", r19);
    L51:
        if (n.b(r18) == false) goto L53;
        r18 = null;
    L53:
        IOmniModelService.c r20 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r18, IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L56;
        String r21 = r20.b();
    L57:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin");
        if (r22 != null) goto L60;
    L61:
        r11 = true;
    L62:
        if (r11 == true) goto L75;
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(availableEntries(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L65:
        if (r23.hasNext() == false) goto L69;
        Object r24 = r23.next();
        if (o.a(((IOmniModelService.c) ZeusTransformUtils.preCheckCast(r24, IOmniModelService.c.class, "com.obric.aiagent.plugin")).b(), r21) == false) goto L65;
        r2 = r24;
    L69:
        IOmniModelService.c r25 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r2, IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L84;
        String r26 = r25.a();
        if (r26 == null) goto L84;
        return r26;
    L84:
        return defaultDisplayModel();
    L75:
        return defaultDisplayModel();
    L60:
        if (d.o.o.d(r22) == false) goto L62;
    L56:
        r21 = null;
        goto L57
    L42:
        r1 = null;
        goto L43
    L36:
        if (d.o.o.d(r16) == true) goto L39;
        r17 = false;
        goto L40
    L32:
        r15 = null;
    L45:
        th = move-exception;
        n.a r27 = n.f38560a;
        r18 = n.f(d.o.a(th));
        goto L47
    L26:
        if (o.a(r9, CURRENT_MODEL_CHAT) == true) goto L78;
        return getEntryByDisplayModel(r9).a();
    L20:
        if (d.o.o.d(r10) == true) goto L23;
        r12 = false;
        goto L24
    L6:
        r6 = null;
    L9:
        th = move-exception;
        n.a r28 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L11
    }
}
