package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AppFunctionSpellSkillBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ag f18219a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f18220b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<String> f18221c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f18222d = null;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.aiagent.plugin")).d(), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.aiagent.plugin")).d(), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    private ag() {
    }

    static {
        f18219a = new ag();
        f18220b = new GsonBuilder().disableHtmlEscaping().create();
        f18221c = ax.a(new String[]{"null", "true", "false", "yes", "no", "on", "off", "y", "n"});
        f18222d = "## 使用 `app_function` 调用命令\n\n下方列出的是 Intent 命令，不是可直接调用的 Function。执行时必须调用 `app_function` Function：\n\n- `command` 必须原样使用下方已知命令名，禁止编造或猜测。\n- `args` 必须是对应 `parameters` 定义的参数对象，并满足必填项、类型和枚举约束。\n- 仅在已经确定具体命令及参数填法时调用；无法确定时不要调用 `app_function`，改走本技能规定的 GUI 或其他路径。\n- `metadata` 仅用于可选链路追踪，不改变执行行为，普通调用无需填写。\n\n```json\n{\n  \"command\": \"<下方已知命令名>\",\n  \"args\": {}\n}\n```";
    }

    public final aj a(ad r7, String r8) {
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r8, "appVersion");
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r9 = null;
    L6:
        if (r9 != null) goto L9;
        return null;
    L9:
        if (r7.b().isEmpty() == false) goto L11;
        return null;
    L11:
        ac r0 = r7.d();
        if (ZeusTransformUtils.instanceOf(r0, ac.a.class) == false) goto L20;
        String r1 = ab.f18205a.a(((ac.a) ZeusTransformUtils.preCheckCast(r0, ac.a.class, "com.obric.aiagent.plugin")).a(), r7.a());
        if (r1 != null) goto L16;
        return null;
    L16:
        String r10 = a(r1, r9);
        if (r10 != null) goto L25;
        return null;
    L25:
        return new aj(r7.a(), a(r10, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r7.b(), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin"))));
    L20:
        if (ZeusTransformUtils.instanceOf(r0, ac.b.class) == false) goto L27;
        r10 = a(r7.a(), r7.c(), r9, ((ac.b) ZeusTransformUtils.preCheckCast(r0, ac.b.class, "com.obric.aiagent.plugin")).a());
        if (r10 != null) goto L25;
        return null;
    L27:
        throw new d.k();
    }

    private final String a(String r7, String r8, String r9, c r10) {
        String r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10.c(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        String r11 = ab.f18205a.a(r7);
        if (r11 != null) goto L11;
        return null;
    L11:
        String r6 = c(r10.a());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L17;
        return null;
    L17:
        StringBuilder r12 = new StringBuilder();
        StringBuilder r2 = r12.append("---");
        d.h.b.o.c(r2, "append(...)");
        d.h.b.o.c(r2.append('\n'), "append(...)");
        ag r3 = f18219a;
        r3.a(r12, "name", r8);
        r3.a(r12, "description", r0);
        r3.a(r12, "version", r9);
        r3.a(r12, "display_name", r11);
        StringBuilder r13 = r12.append("---");
        d.h.b.o.c(r13, "append(...)");
        d.h.b.o.c(r13.append('\n'), "append(...)");
        d.h.b.o.c(r12.append('\n'), "append(...)");
        r12.append(r6);
        String r14 = r12.toString();
        d.h.b.o.c(r14, "toString(...)");
        return r14;
    }

    private final String a(String r13, String r14) {
        List r15 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.b(d.o.o.a(d.o.o.a(r13, "\r\n", "\n", false, 4, null), '\r', '\n', false, 4, null), new char[]{65279, '\n'}), CharSequence.class, "com.obric.aiagent.plugin")), Collection.class, "com.obric.aiagent.plugin"));
        String r0 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r15), String.class, "com.obric.aiagent.plugin");
        Object r2 = null;
        if (r0 == null) goto L5;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L7:
        if (d.h.b.o.a(r1, "---") == true) goto L9;
        return null;
    L9:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(1, r15.size()), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r3.hasNext() == false) goto L25;
        Object r5 = r3.next();
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
        Character r8 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r15.get(r7), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r8 != null) goto L15;
    L17:
        boolean r9 = false;
    L18:
        if (r9 == false) goto L20;
    L22:
        boolean r10 = false;
    L23:
        if (r10 == false) goto L11;
    L26:
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L48;
        int r6 = r4.intValue();
        String r12 = "version: " + a(r14);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(d.l.n.b(1, r6), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L30:
        if (r16.hasNext() == false) goto L42;
        Object r11 = r16.next();
        String r17 = (String) ZeusTransformUtils.preCheckCast(r15.get(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue()), String.class, "com.obric.aiagent.plugin");
        Character r18 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r18 != null) goto L34;
    L36:
        boolean r19 = false;
    L37:
        if (r19 == false) goto L39;
        boolean r20 = false;
    L40:
        if (r20 == false) goto L30;
        r2 = r11;
        goto L42
    L39:
        r20 = d.o.o.a(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a(r17, ':', ""), CharSequence.class, "com.obric.aiagent.plugin")).toString(), "version", true);
        goto L40
    L34:
        if (d.o.a.a(r18.charValue()) != true) goto L36;
        r19 = true;
    L42:
        Integer r110 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");
        if (r110 != null) goto L45;
        r15.add(r6, r12);
    L47:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L45:
        r15.set(r110.intValue(), r12);
        goto L47
    L48:
        return null;
    L20:
        if (d.h.b.o.a(d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r15.get(r7), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString(), "---") == false) goto L22;
        r10 = true;
        goto L23
    L15:
        if (d.o.a.a(r8.charValue()) != true) goto L17;
        r9 = true;
        goto L18
    L25:
        r5 = null;
        goto L26
    L5:
        r1 = null;
        goto L7
    }

    private final String a(String r6, List<m> r7) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        StringBuilder r8 = new StringBuilder();
        StringBuilder r9 = r8.append(d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString());
        d.h.b.o.c(r9, "append(...)");
        d.h.b.o.c(r9.append('\n'), "append(...)");
        d.h.b.o.c(r8.append('\n'), "append(...)");
        StringBuilder r10 = r8.append(f18222d);
        d.h.b.o.c(r10, "append(...)");
        d.h.b.o.c(r10.append('\n'), "append(...)");
        d.h.b.o.c(r8.append('\n'), "append(...)");
        StringBuilder r11 = r8.append("## 可用命令");
        d.h.b.o.c(r11, "append(...)");
        d.h.b.o.c(r11.append('\n'), "append(...)");
        StringBuilder r12 = r8.append("```yaml");
        d.h.b.o.c(r12, "append(...)");
        d.h.b.o.c(r12.append('\n'), "append(...)");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        m r14 = (m) ZeusTransformUtils.preCheckCast(r13.next(), m.class, "com.obric.aiagent.plugin");
        r8.append("- command: ");
        ag r3 = f18219a;
        StringBuilder r4 = r8.append(r3.b(r14.e()));
        d.h.b.o.c(r4, "append(...)");
        d.h.b.o.c(r4.append('\n'), "append(...)");
        r8.append("  description: ");
        String r15 = r14.f();
        if (r15 != null) goto L8;
        r15 = "";
    L8:
        StringBuilder r16 = r8.append(r3.b(r15));
        d.h.b.o.c(r16, "append(...)");
        d.h.b.o.c(r16.append('\n'), "append(...)");
        r8.append("  parameters:");
        JsonObject r17 = r14.g();
        if (r17 != null) goto L11;
        r17 = r3.a();
    L11:
        r3.a(r8, (JsonElement) ZeusTransformUtils.preCheckCast(r17, JsonElement.class, "com.obric.aiagent.plugin"), "    ");
        goto L4
    L12:
        StringBuilder r18 = r8.append("```");
        d.h.b.o.c(r18, "append(...)");
        d.h.b.o.c(r18.append('\n'), "append(...)");
        String r19 = r8.toString();
        d.h.b.o.c(r19, "toString(...)");
        return r19;
    }

    private final void a(StringBuilder r8, JsonElement r9, String r10) {
        if (r9.isJsonObject() == false) goto L12;
        Set<Map.Entry<String, JsonElement>> r0 = r9.getAsJsonObject().entrySet();
        d.h.b.o.c(r0, "entrySet(...)");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L12;
        d.h.b.o.c(r8.append('\n'), "append(...)");
        Set<Map.Entry<String, JsonElement>> r7 = r9.getAsJsonObject().entrySet();
        d.h.b.o.c(r7, "entrySet(...)");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r12);
        String r1 = (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r13 = (JsonElement) ZeusTransformUtils.preCheckCast(r12.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        r8.append(r10);
        ag r2 = f18219a;
        d.h.b.o.a(r1);
        r8.append(r2.b(r1));
        r8.append(':');
        d.h.b.o.a(r13);
        r2.a(r8, r13, r10 + "  ");
        goto L8
    L10:
        d.x r14 = d.x.f38692a;
        return;
    L12:
        if (r9.isJsonArray() == true) goto L14;
    L20:
        r8.append(' ');
        if (r9.isJsonPrimitive() == true) goto L23;
    L25:
        String r15 = f18220b.toJson(r9);
    L26:
        StringBuilder r16 = r8.append(r15);
        d.h.b.o.c(r16, "append(...)");
        d.h.b.o.c(r16.append('\n'), "append(...)");
        return;
    L23:
        if (r9.getAsJsonPrimitive().isString() == false) goto L25;
        String r17 = r9.getAsString();
        d.h.b.o.c(r17, "getAsString(...)");
        r15 = b(r17);
        goto L26
    L14:
        if (r9.getAsJsonArray().size() <= 0) goto L20;
        d.h.b.o.c(r8.append('\n'), "append(...)");
        JsonArray r18 = r9.getAsJsonArray();
        d.h.b.o.c(r18, "getAsJsonArray(...)");
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L17:
        if (r19.hasNext() == false) goto L19;
        JsonElement r20 = (JsonElement) ZeusTransformUtils.preCheckCast(r19.next(), JsonElement.class, "com.obric.aiagent.plugin");
        r8.append(r10);
        r8.append('-');
        ag r3 = f18219a;
        d.h.b.o.a(r20);
        r3.a(r8, r20, r10 + "  ");
        goto L17
    L19:
        d.x r21 = d.x.f38692a;
    }

    private final void a(StringBuilder r1, String r2, String r3) {
        r1.append(r2);
        r1.append(": ");
        StringBuilder r0 = r1.append(a(r3));
        d.h.b.o.c(r0, "append(...)");
        d.h.b.o.c(r0.append('\n'), "append(...)");
    }

    private final String a(String r1) {
        String r0 = f18220b.toJson(r1);
        d.h.b.o.c(r0, "toJson(...)");
        return r0;
    }

    private final String b(String r8) {
        Character r0 = d.o.o.i((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"));
        d.l.c r2 = new d.l.c('a', 'z');
        boolean r3 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L23;
        d.l.c r5 = new d.l.c('A', 'Z');
        if (r0 != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == true) goto L23;
        if (r0 != null) goto L20;
    L22:
        boolean r1 = false;
    L24:
        if (r1 == false) goto L56;
        Character r7 = d.o.o.k((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L28;
    L30:
        boolean r9 = false;
    L31:
        if (r9 == false) goto L56;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        int r11 = 0;
    L34:
        if (r11 >= r10.length()) goto L51;
        char r12 = r10.charAt(r11);
        if (r12 != ':') goto L38;
    L47:
        boolean r13 = true;
    L48:
        if (r13 == true) goto L49;
        r11 = r11 + 1;
        goto L34
    L49:
        boolean r14 = false;
    L52:
        if (r14 == false) goto L56;
        Set<String> r15 = f18221c;
        String r16 = r8.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r16, "toLowerCase(...)");
        if (r15.contains(r16) == true) goto L56;
    L57:
        if (r3 == false) goto L60;
        return r8;
    L60:
        return a(r8);
    L38:
        if (r12 == '#') goto L47;
        if (Character.isISOControl(r12) == true) goto L47;
        if (r12 == 8232) goto L47;
        if (r12 == 8233) goto L47;
        r13 = false;
        goto L48
    L51:
        r14 = true;
        goto L52
    L28:
        if (d.o.a.a(r7.charValue()) == true) goto L30;
        r9 = true;
    L56:
        r3 = false;
        goto L57
    L20:
        if (r0.charValue() != '_') goto L22;
    L12:
        if (r5.a(r0.charValue()) == false) goto L14;
        r6 = true;
    L23:
        r1 = true;
        goto L24
    L5:
        if (r2.a(r0.charValue()) == false) goto L7;
        r4 = true;
        goto L8
    }

    private final String c(String r11) {
        List<String> r10 = d.o.o.g((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"));
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r3 = r13.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r4 = 0;
        if (r14.hasNext() == true) goto L11;
        Comparable r15 = null;
    L33:
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r15, Integer.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L37;
        r4 = r16.intValue();
    L37:
        if (r4 == 0) goto L39;
        List r5 = d.a.p.a();
        String r6 = (String) ZeusTransformUtils.preCheckCast(d.a.p.l(r10), String.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L43;
        r5.add(r6);
    L43:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), 1), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L45:
        if (r17.hasNext() == false) goto L52;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L49;
        String r7 = "";
    L50:
        r5.add(r7);
        goto L45
    L49:
        r7 = d.o.o.c(r1, r4);
        goto L50
    L52:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a(r5), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L39:
        return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L11:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        int r9 = r8.length();
        int r18 = 0;
    L13:
        if (r18 >= r9) goto L18;
        if ((!d.o.a.a(r8.charAt(r18))) == true) goto L19;
        r18 = r18 + 1;
    L19:
        Comparable r19 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(d.l.n.c(r18, 0)), Comparable.class, "com.obric.aiagent.plugin");
    L21:
        if (r14.hasNext() == false) goto L32;
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        int r21 = r20.length();
        int r22 = 0;
    L23:
        if (r22 >= r21) goto L28;
        if ((!d.o.a.a(r20.charAt(r22))) == true) goto L29;
        r22 = r22 + 1;
    L29:
        Comparable r23 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(d.l.n.c(r22, 0)), Comparable.class, "com.obric.aiagent.plugin");
        if (r19.compareTo(r23) <= 0) goto L21;
        r19 = r23;
        goto L21
    L28:
        r22 = -1;
        goto L29
    L32:
        r15 = r19;
        goto L33
    L18:
        r18 = -1;
        goto L19
    }

    private final JsonObject a() {
        JsonObject r3 = new JsonObject();
        r3.addProperty("type", "object");
        r3.add("properties", (JsonElement) ZeusTransformUtils.preCheckCast(new JsonObject(), JsonElement.class, "com.obric.aiagent.plugin"));
        return r3;
    }
}
