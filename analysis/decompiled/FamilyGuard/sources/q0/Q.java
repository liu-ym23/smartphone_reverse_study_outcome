package q0;

import java.io.File;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.InterfaceC0890c;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class Q implements U, p0.t {

    /* renamed from: c, reason: collision with root package name */
    private static Method f19718c;

    /* renamed from: b, reason: collision with root package name */
    public static final Q f19717b = new Q();

    /* renamed from: d, reason: collision with root package name */
    private static boolean f19719d = false;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f19716a = "true".equals(u0.g.h("fastjson.deserializer.fileRelativePathSupport"));

    private static String f(Node node) throws TransformerException {
        try {
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            DOMSource dOMSource = new DOMSource(node);
            StringWriter stringWriter = new StringWriter();
            transformerNewTransformer.transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e6) {
            throw new l0.d("xml node to string error", e6);
        }
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws TransformerException {
        String strF;
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.Y();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            strF = ((SimpleDateFormat) obj).toPattern();
            if (e0Var.v(f0.WriteClassName) && obj.getClass() != type) {
                e0Var.write(123);
                e0Var.D(AbstractC0822a.f18018c);
                c0946i.H(obj.getClass().getName());
                e0Var.N(',', "val", strF);
                e0Var.write(125);
                return;
            }
        } else if (cls == Class.class) {
            strF = ((Class) obj).getName();
        } else {
            if (cls == InetSocketAddress.class) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetAddress address = inetSocketAddress.getAddress();
                e0Var.write(123);
                if (address != null) {
                    e0Var.D("address");
                    c0946i.G(address);
                    e0Var.write(44);
                }
                e0Var.D("port");
                e0Var.V(inetSocketAddress.getPort());
                e0Var.write(125);
                return;
            }
            if (obj instanceof File) {
                strF = ((File) obj).getPath();
            } else if (obj instanceof InetAddress) {
                strF = ((InetAddress) obj).getHostAddress();
            } else if (obj instanceof TimeZone) {
                strF = ((TimeZone) obj).getID();
            } else if (obj instanceof Currency) {
                strF = ((Currency) obj).getCurrencyCode();
            } else {
                if (obj instanceof l0.j) {
                    ((l0.j) obj).h(e0Var);
                    return;
                }
                if (obj instanceof Iterator) {
                    g(c0946i, e0Var, (Iterator) obj);
                    return;
                }
                if (obj instanceof Iterable) {
                    g(c0946i, e0Var, ((Iterable) obj).iterator());
                    return;
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key instanceof String) {
                        String str = (String) key;
                        if (value instanceof String) {
                            e0Var.S('{', str, (String) value);
                        } else {
                            e0Var.write(123);
                            e0Var.D(str);
                            c0946i.G(value);
                        }
                    } else {
                        e0Var.write(123);
                        c0946i.G(key);
                        e0Var.write(58);
                        c0946i.G(value);
                    }
                    e0Var.write(125);
                    return;
                }
                if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
                    e0Var.Y();
                    return;
                } else {
                    if (!(obj instanceof Node)) {
                        throw new l0.d("not support class : " + cls);
                    }
                    strF = f((Node) obj);
                }
            }
        }
        e0Var.h0(strF);
    }

    @Override // p0.t
    public int d() {
        return 4;
    }

    /* JADX WARN: Type inference failed for: r8v35, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        Object objS;
        String str;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int i5 = 0;
        InetAddress inetAddress = null;
        if (type != InetSocketAddress.class) {
            if (c0888a.f18953k == 2) {
                c0888a.f18953k = 0;
                c0888a.a(16);
                if (interfaceC0890c.U() != 4) {
                    throw new l0.d("syntax error");
                }
                if (!"val".equals(interfaceC0890c.N())) {
                    throw new l0.d("syntax error");
                }
                interfaceC0890c.nextToken();
                c0888a.a(17);
                objS = c0888a.S();
                c0888a.a(13);
            } else {
                objS = c0888a.S();
            }
            if (objS == null) {
                str = null;
            } else {
                if (!(objS instanceof String)) {
                    if (!(objS instanceof l0.e)) {
                        throw new l0.d("expect string");
                    }
                    l0.e eVar = (l0.e) objS;
                    if (type == Currency.class) {
                        String strR = eVar.R("currency");
                        if (strR != null) {
                            return (T) Currency.getInstance(strR);
                        }
                        String strR2 = eVar.R("currencyCode");
                        if (strR2 != null) {
                            return (T) Currency.getInstance(strR2);
                        }
                    }
                    return type == Map.Entry.class ? (T) eVar.entrySet().iterator().next() : (T) eVar.K(type);
                }
                str = (String) objS;
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e6) {
                    throw new l0.d("create url error", e6);
                }
            }
            if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            }
            if (type == Locale.class) {
                return (T) u0.o.N0(str);
            }
            if (type == SimpleDateFormat.class) {
                ?? r8 = (T) new SimpleDateFormat(str, interfaceC0890c.s0());
                r8.setTimeZone(interfaceC0890c.O());
                return r8;
            }
            if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                try {
                    return (T) InetAddress.getByName(str);
                } catch (UnknownHostException e7) {
                    throw new l0.d("deserialize inet adress error", e7);
                }
            }
            if (type == File.class) {
                if (str.indexOf("..") < 0 || f19716a) {
                    return (T) new File(str);
                }
                throw new l0.d("file relative path not support.");
            }
            if (type == TimeZone.class) {
                return (T) TimeZone.getTimeZone(str);
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            }
            if (type == Class.class) {
                return (T) u0.o.B0(str, c0888a.u().m(), false);
            }
            if (type == Charset.class) {
                return (T) Charset.forName(str);
            }
            if (type == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (type == l0.g.class) {
                return (T) new l0.g(str);
            }
            if (!(type instanceof Class)) {
                throw new l0.d("MiscCodec not support " + type.toString());
            }
            String name = ((Class) type).getName();
            if (name.equals("java.nio.file.Path")) {
                try {
                    if (f19718c == null && !f19719d) {
                        f19718c = u0.o.z0("java.nio.file.Paths").getMethod("get", String.class, String[].class);
                    }
                    Method method = f19718c;
                    if (method != null) {
                        return (T) method.invoke(null, str, new String[0]);
                    }
                    throw new l0.d("Path deserialize erorr");
                } catch (IllegalAccessException e8) {
                    throw new l0.d("Path deserialize erorr", e8);
                } catch (NoSuchMethodException unused) {
                    f19719d = true;
                } catch (InvocationTargetException e9) {
                    throw new l0.d("Path deserialize erorr", e9);
                }
            }
            throw new l0.d("MiscCodec not support " + name);
        }
        if (interfaceC0890c.U() == 8) {
            interfaceC0890c.nextToken();
            return null;
        }
        c0888a.a(12);
        while (true) {
            String strN = interfaceC0890c.N();
            interfaceC0890c.A(17);
            if (strN.equals("address")) {
                c0888a.a(17);
                inetAddress = (InetAddress) c0888a.h0(InetAddress.class);
            } else if (strN.equals("port")) {
                c0888a.a(17);
                if (interfaceC0890c.U() != 2) {
                    throw new l0.d("port is not int");
                }
                int iV = interfaceC0890c.v();
                interfaceC0890c.nextToken();
                i5 = iV;
            } else {
                c0888a.a(17);
                c0888a.S();
            }
            if (interfaceC0890c.U() != 16) {
                c0888a.a(13);
                return (T) new InetSocketAddress(inetAddress, i5);
            }
            interfaceC0890c.nextToken();
        }
    }

    protected void g(C0946I c0946i, e0 e0Var, Iterator<?> it) {
        e0Var.write(91);
        int i5 = 0;
        while (it.hasNext()) {
            if (i5 != 0) {
                e0Var.write(44);
            }
            c0946i.G(it.next());
            i5++;
        }
        e0Var.write(93);
    }
}
