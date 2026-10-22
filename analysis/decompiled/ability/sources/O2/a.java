package O2;

import C5.f;
import D7.v;
import D7.w;
import F9.B;
import F9.N;
import F9.P;
import S7.k;
import V9.i;
import X8.H;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.protobuf.AbstractC0916a;
import com.google.protobuf.AbstractC0926c1;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InterfaceC0938f1;
import j9.AbstractC1607a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import org.yaml.snakeyaml.DumperOptions$Version;
import qa.InterfaceC1859k;
import u1.d;
import y8.C2147j;
import y8.C2149l;
import y8.C2150m;
import z8.C2193e;
import z8.r;
import z8.s;

/* loaded from: classes2.dex */
public class a implements InterfaceC0938f1, InterfaceC1859k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1032a;
    public Object b;
    public Object c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f1032a = i;
        this.b = obj;
        this.c = obj2;
    }

    public static H l(List list) {
        return list.isEmpty() ? H.c : new H(list);
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public Object a(GeneratedMessageV3 generatedMessageV3) {
        return GeneratedMessageV3.u((Method) ((f) this.c).f302a, generatedMessageV3, new Object[0]);
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public boolean b(GeneratedMessageV3 generatedMessageV3) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public Object c(AbstractC0926c1 abstractC0926c1) {
        return GeneratedMessageV3.u((Method) ((f) this.c).b, abstractC0926c1, new Object[0]);
    }

    @Override // qa.InterfaceC1859k
    public Object convert(Object obj) {
        Charset charsetA;
        P p = (P) obj;
        Gson gson = (Gson) this.b;
        N n = p.f634a;
        if (n == null) {
            i iVarF = p.f();
            B bC = p.c();
            if (bC == null || (charsetA = bC.a(AbstractC1607a.f4778a)) == null) {
                charsetA = AbstractC1607a.f4778a;
            }
            n = new N(iVarF, charsetA);
            p.f634a = n;
        }
        JsonReader jsonReaderNewJsonReader = gson.newJsonReader(n);
        try {
            Object obj2 = ((TypeAdapter) this.c).read2(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return obj2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            p.close();
        }
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public boolean d(AbstractC0926c1 abstractC0926c1) {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public void e(AbstractC0926c1 abstractC0926c1, Object obj) {
        GeneratedMessageV3.u((Method) ((f) this.c).h, abstractC0926c1, new Object[0]);
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            g(abstractC0926c1, it.next());
        }
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public AbstractC0916a f(AbstractC0926c1 abstractC0926c1) {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public void g(AbstractC0926c1 abstractC0926c1, Object obj) {
        GeneratedMessageV3.u((Method) ((f) this.c).e, abstractC0926c1, new Object[]{obj});
    }

    @Override // com.google.protobuf.InterfaceC0938f1
    public AbstractC0916a h() {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
    }

    public int i(String str) {
        int iValueOf;
        HashMap map = (HashMap) this.c;
        Integer num = (Integer) map.get(str);
        if (num == null) {
            try {
                iValueOf = Integer.valueOf(((Cursor) this.b).getColumnIndex(str));
            } catch (Throwable unused) {
                iValueOf = -1;
            }
            num = iValueOf;
            map.put(str, num);
        }
        return num.intValue();
    }

    public long j(String str) {
        try {
            return ((Cursor) this.b).getLong(i(str));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public String k(String str) {
        try {
            return ((Cursor) this.b).getString(i(str));
        } catch (Throwable unused) {
            return "";
        }
    }

    public void m(Canvas canvas) {
        Drawable drawable = (Drawable) this.c;
        View view = (View) this.b;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, view.getWidth(), view.getHeight());
        drawable.draw(canvas);
    }

    public void n(String str, String str2, k kVar) {
        LinkedHashMap linkedHashMap = ((v3.b) this.c).b;
        C2149l c2149l = new C2149l(this, str, str2);
        kVar.invoke(c2149l);
        String internalName = (String) this.b;
        ArrayList arrayList = c2149l.b;
        ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) ((Pair) it.next()).f4886a);
        }
        String ret = (String) c2149l.c.f4886a;
        kotlin.jvm.internal.k.f(ret, "ret");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('(');
        sb.append(v.I0(arrayList2, "", null, null, s.f6989a, 30));
        sb.append(')');
        if (ret.length() > 1) {
            ret = androidx.compose.foundation.b.m(';', "L", ret);
        }
        sb.append(ret);
        String jvmDescriptor = sb.toString();
        kotlin.jvm.internal.k.f(internalName, "internalName");
        kotlin.jvm.internal.k.f(jvmDescriptor, "jvmDescriptor");
        String str3 = internalName + '.' + jvmDescriptor;
        C2150m c2150m = (C2150m) c2149l.c.b;
        ArrayList arrayList3 = new ArrayList(w.c0(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add((C2150m) ((Pair) it2.next()).b);
        }
        linkedHashMap.put(str3, new C2147j(c2150m, arrayList3, c2149l.f6919a));
    }

    public int o(String str) {
        int andIncrement;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.b;
        kotlin.jvm.internal.k.f(concurrentHashMap, "<this>");
        Integer num = (Integer) concurrentHashMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        synchronized (concurrentHashMap) {
            try {
                Integer num2 = (Integer) concurrentHashMap.get(str);
                if (num2 != null) {
                    andIncrement = num2.intValue();
                } else {
                    andIncrement = ((AtomicInteger) this.c).getAndIncrement();
                    concurrentHashMap.putIfAbsent(str, Integer.valueOf(andIncrement));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return andIncrement;
    }

    public void p(Drawable drawable) {
        Drawable drawable2 = (Drawable) this.c;
        View view = (View) this.b;
        if (drawable2 == drawable) {
            drawable = drawable2;
        } else {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable.setCallback(view);
                drawable.setLayoutDirection(view.getLayoutDirection());
                if (drawable.isStateful()) {
                    drawable.setState(view.getDrawableState());
                }
                drawable.setVisible(view.getVisibility() == 0, true);
            }
            view.invalidate();
        }
        this.c = drawable;
    }

    public boolean q() {
        Drawable drawable = (Drawable) this.c;
        return drawable != null && drawable.isStateful() && drawable.setState(((View) this.b).getDrawableState());
    }

    public d r(G8.f name, String str) {
        kotlin.jvm.internal.k.f(name, "name");
        String strB = name.b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        return new d(this, new r(strB.concat(str)));
    }

    public String toString() {
        switch (this.f1032a) {
            case 7:
                return String.format("VersionTagsTuple<%s, %s>", (DumperOptions$Version) this.b, (HashMap) this.c);
            default:
                return super.toString();
        }
    }

    public a(View view) {
        this.f1032a = 1;
        this.b = view;
    }

    public a(k kVar) {
        this.f1032a = 5;
        this.b = kVar;
        this.c = new ConcurrentHashMap();
    }

    public a(int i) throws IOException {
        this.f1032a = i;
        switch (i) {
            case 3:
                return;
            case 4:
                this.b = new ConcurrentHashMap();
                this.c = new AtomicInteger(0);
                return;
            default:
                this.b = new TreeSet();
                try {
                    InputStream resourceAsStream = a.class.getClassLoader().getResourceAsStream("leap_second_dates.csv");
                    try {
                        Objects.requireNonNull(resourceAsStream, "leap_second_dates.csv was not found on the classpath");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line != null) {
                                    if (!line.isEmpty()) {
                                        ((TreeSet) this.b).add(YearMonth.parse(line));
                                    }
                                } else {
                                    bufferedReader.close();
                                    resourceAsStream.close();
                                    this.c = (YearMonth) ((TreeSet) this.b).last();
                                    return;
                                }
                            } finally {
                            }
                        }
                    } finally {
                    }
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
        }
    }

    public a(C2193e c2193e, HashMap map, HashMap map2) {
        this.f1032a = 12;
        this.b = c2193e;
        this.c = map;
    }

    public a(v3.b bVar, String className) {
        this.f1032a = 11;
        kotlin.jvm.internal.k.f(className, "className");
        this.c = bVar;
        this.b = className;
    }

    public a(String str, Class cls, Class cls2) {
        this.f1032a = 6;
        f fVar = new f();
        fVar.f302a = GeneratedMessageV3.t(cls, B7.a.m("get", str, "List"), new Class[0]);
        fVar.b = GeneratedMessageV3.t(cls2, B7.a.m("get", str, "List"), new Class[0]);
        String strK = B7.a.k("get", str);
        Class cls3 = Integer.TYPE;
        Method methodT = GeneratedMessageV3.t(cls, strK, new Class[]{cls3});
        fVar.c = methodT;
        fVar.d = GeneratedMessageV3.t(cls2, B7.a.k("get", str), new Class[]{cls3});
        Class<?> returnType = methodT.getReturnType();
        GeneratedMessageV3.t(cls2, B7.a.k("set", str), new Class[]{cls3, returnType});
        fVar.e = GeneratedMessageV3.t(cls2, B7.a.k("add", str), new Class[]{returnType});
        fVar.f = GeneratedMessageV3.t(cls, B7.a.m("get", str, "Count"), new Class[0]);
        fVar.g = GeneratedMessageV3.t(cls2, B7.a.m("get", str, "Count"), new Class[0]);
        fVar.h = GeneratedMessageV3.t(cls2, B7.a.k("clear", str), new Class[0]);
        this.b = ((Method) fVar.c).getReturnType();
        this.c = fVar;
    }
}
