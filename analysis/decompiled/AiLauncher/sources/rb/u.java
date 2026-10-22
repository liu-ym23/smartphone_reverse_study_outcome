package rb;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.JsonException;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import p9.InterfaceC5063a;
import qb.AbstractC5171a;
import rb.C5266p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a#\u0010\u0012\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0015\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001a-\u0010\u0019\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001b\u0010\u001b\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\",\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"&\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b$\u0010!¨\u0006&"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lqb/a;", "json", "", "", "", Const.INTENT_KEY_PKGNAME, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lqb/a;)Ljava/util/Map;", "descriptor", "e", "(Lqb/a;Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lqb/a;I)Ljava/lang/String;", "Lqb/z;", "n", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lqb/a;)Lqb/z;", "name", "l", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lqb/a;Ljava/lang/String;)I", "", Const.INTENT_KEY_UMID, "(Lqb/a;Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "suffix", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lqb/a;Ljava/lang/String;Ljava/lang/String;)I", "m", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lqb/a;)Z", "Lrb/p$a;", Const.INTENT_KEY_APIKEY, "Lrb/p$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lrb/p$a;", "JsonDeserializationNamesKey", "", "getJsonSerializationNamesKey", "JsonSerializationNamesKey", "kotlinx-serialization-json"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final C5266p.a<Map<String, Integer>> f39000a = new C5266p.a<>();

    /* renamed from: b, reason: collision with root package name */
    public static final C5266p.a<String[]> f39001b = new C5266p.a<>();

    public static final Map<String, Integer> b(SerialDescriptor serialDescriptor, AbstractC5171a abstractC5171a) {
        String lowerCase;
        String[] strArrNames;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean zD = d(abstractC5171a, serialDescriptor);
        n(serialDescriptor, abstractC5171a);
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i10 = 0; i10 < elementsCount; i10++) {
            List<Annotation> listF = serialDescriptor.f(i10);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF) {
                if (obj instanceof qb.y) {
                    arrayList.add(obj);
                }
            }
            qb.y yVar = (qb.y) Z8.F.Z0(arrayList);
            if (yVar != null && (strArrNames = yVar.names()) != null) {
                for (String lowerCase2 : strArrNames) {
                    if (zD) {
                        lowerCase2 = lowerCase2.toLowerCase(Locale.ROOT);
                        kotlin.jvm.internal.p.h(lowerCase2, "toLowerCase(...)");
                    }
                    c(linkedHashMap, serialDescriptor, lowerCase2, i10);
                }
            }
            if (zD) {
                lowerCase = serialDescriptor.e(i10).toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                c(linkedHashMap, serialDescriptor, lowerCase, i10);
            }
        }
        return linkedHashMap.isEmpty() ? kotlin.collections.a.i() : linkedHashMap;
    }

    public static final void c(Map<String, Integer> map, SerialDescriptor serialDescriptor, String str, int i10) {
        String str2 = kotlin.jvm.internal.p.d(serialDescriptor.getKind(), AbstractC4959l.b.f37292a) ? "enum value" : "property";
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i10));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for " + str2 + ' ' + serialDescriptor.e(i10) + " is already one of the names for " + str2 + ' ' + serialDescriptor.e(((Number) kotlin.collections.a.j(map, str)).intValue()) + " in " + serialDescriptor);
    }

    public static final boolean d(AbstractC5171a abstractC5171a, SerialDescriptor serialDescriptor) {
        return abstractC5171a.getConfiguration().getDecodeEnumsCaseInsensitive() && kotlin.jvm.internal.p.d(serialDescriptor.getKind(), AbstractC4959l.b.f37292a);
    }

    public static final Map<String, Integer> e(final AbstractC5171a abstractC5171a, final SerialDescriptor descriptor) {
        kotlin.jvm.internal.p.i(abstractC5171a, "<this>");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return (Map) qb.H.a(abstractC5171a).b(descriptor, f39000a, new InterfaceC5063a() { // from class: rb.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return u.f(descriptor, abstractC5171a);
            }
        });
    }

    public static final Map f(SerialDescriptor serialDescriptor, AbstractC5171a abstractC5171a) {
        return b(serialDescriptor, abstractC5171a);
    }

    public static final C5266p.a<Map<String, Integer>> g() {
        return f39000a;
    }

    public static final String h(SerialDescriptor serialDescriptor, AbstractC5171a json, int i10) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(json, "json");
        n(serialDescriptor, json);
        return serialDescriptor.e(i10);
    }

    public static final int i(SerialDescriptor serialDescriptor, AbstractC5171a json, String name) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(name, "name");
        if (d(json, serialDescriptor)) {
            String lowerCase = name.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            return l(serialDescriptor, json, lowerCase);
        }
        n(serialDescriptor, json);
        int iC = serialDescriptor.c(name);
        return (iC == -3 && json.getConfiguration().getUseAlternativeNames()) ? l(serialDescriptor, json, name) : iC;
    }

    public static final int j(SerialDescriptor serialDescriptor, AbstractC5171a json, String name, String suffix) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(json, "json");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(suffix, "suffix");
        int i10 = i(serialDescriptor, json, name);
        if (i10 != -3) {
            return i10;
        }
        throw new SerializationException(serialDescriptor.getSerialName() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static /* synthetic */ int k(SerialDescriptor serialDescriptor, AbstractC5171a abstractC5171a, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return j(serialDescriptor, abstractC5171a, str, str2);
    }

    public static final int l(SerialDescriptor serialDescriptor, AbstractC5171a abstractC5171a, String str) {
        Integer num = e(abstractC5171a, serialDescriptor).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final boolean m(SerialDescriptor serialDescriptor, AbstractC5171a json) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(json, "json");
        if (json.getConfiguration().getIgnoreUnknownKeys()) {
            return true;
        }
        List<Annotation> annotations = serialDescriptor.getAnnotations();
        if ((annotations instanceof Collection) && annotations.isEmpty()) {
            return false;
        }
        Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            if (((Annotation) it.next()) instanceof qb.t) {
                return true;
            }
        }
        return false;
    }

    public static final qb.z n(SerialDescriptor serialDescriptor, AbstractC5171a json) {
        kotlin.jvm.internal.p.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.p.i(json, "json");
        if (kotlin.jvm.internal.p.d(serialDescriptor.getKind(), AbstractC4960m.a.f37293a)) {
            json.getConfiguration().l();
        }
        return null;
    }
}
