package q0;

import com.stepos.minor.Minor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Type;
import l0.AbstractC0822a;
import o0.C0888a;
import o0.C0895h;
import o0.InterfaceC0890c;

/* renamed from: q0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0962i implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0962i f19853a = new C0962i();

    private Object j(C0888a c0888a, Object obj) {
        InterfaceC0890c interfaceC0890cG = c0888a.G();
        interfaceC0890cG.L(4);
        String strN = interfaceC0890cG.N();
        c0888a.u0(c0888a.v(), obj);
        c0888a.m(new C0888a.C0227a(c0888a.v(), strN));
        c0888a.p0();
        c0888a.C0(1);
        interfaceC0890cG.A(13);
        c0888a.a(13);
        return null;
    }

    public static boolean k(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.Y();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            e0Var.I(l(e0Var, Point.class, '{'), "x", point.x);
            e0Var.I(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            e0Var.N(l(e0Var, Font.class, '{'), Minor.COLUMN_NAME, font.getName());
            e0Var.I(',', "style", font.getStyle());
            e0Var.I(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            e0Var.I(l(e0Var, Rectangle.class, '{'), "x", rectangle.x);
            e0Var.I(',', "y", rectangle.y);
            e0Var.I(',', "width", rectangle.width);
            e0Var.I(',', "height", rectangle.height);
        } else {
            if (!(obj instanceof Color)) {
                throw new l0.d("not support awt class : " + obj.getClass().getName());
            }
            Color color = (Color) obj;
            e0Var.I(l(e0Var, Color.class, '{'), "r", color.getRed());
            e0Var.I(',', "g", color.getGreen());
            e0Var.I(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                e0Var.I(',', "alpha", color.getAlpha());
            }
        }
        e0Var.write(125);
    }

    @Override // p0.t
    public int d() {
        return 12;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        T t5;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        if (interfaceC0890c.U() == 8) {
            interfaceC0890c.A(16);
            return null;
        }
        if (interfaceC0890c.U() != 12 && interfaceC0890c.U() != 16) {
            throw new l0.d("syntax error");
        }
        interfaceC0890c.nextToken();
        if (type == Point.class) {
            t5 = (T) h(c0888a, obj);
        } else if (type == Rectangle.class) {
            t5 = (T) i(c0888a);
        } else if (type == Color.class) {
            t5 = (T) f(c0888a);
        } else {
            if (type != Font.class) {
                throw new l0.d("not support awt class : " + type);
            }
            t5 = (T) g(c0888a);
        }
        C0895h c0895hV = c0888a.v();
        c0888a.u0(t5, obj);
        c0888a.z0(c0895hV);
        return t5;
    }

    protected Color f(C0888a c0888a) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (interfaceC0890c.U() != 13) {
            if (interfaceC0890c.U() != 4) {
                throw new l0.d("syntax error");
            }
            String strN = interfaceC0890c.N();
            interfaceC0890c.L(2);
            if (interfaceC0890c.U() != 2) {
                throw new l0.d("syntax error");
            }
            int iV = interfaceC0890c.v();
            interfaceC0890c.nextToken();
            if (strN.equalsIgnoreCase("r")) {
                i5 = iV;
            } else if (strN.equalsIgnoreCase("g")) {
                i6 = iV;
            } else if (strN.equalsIgnoreCase("b")) {
                i7 = iV;
            } else {
                if (!strN.equalsIgnoreCase("alpha")) {
                    throw new l0.d("syntax error, " + strN);
                }
                i8 = iV;
            }
            if (interfaceC0890c.U() == 16) {
                interfaceC0890c.A(4);
            }
        }
        interfaceC0890c.nextToken();
        return new Color(i5, i6, i7, i8);
    }

    protected Font g(C0888a c0888a) {
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int iV = 0;
        String strN = null;
        int iV2 = 0;
        while (interfaceC0890c.U() != 13) {
            if (interfaceC0890c.U() != 4) {
                throw new l0.d("syntax error");
            }
            String strN2 = interfaceC0890c.N();
            interfaceC0890c.L(2);
            if (strN2.equalsIgnoreCase(Minor.COLUMN_NAME)) {
                if (interfaceC0890c.U() != 4) {
                    throw new l0.d("syntax error");
                }
                strN = interfaceC0890c.N();
                interfaceC0890c.nextToken();
            } else if (strN2.equalsIgnoreCase("style")) {
                if (interfaceC0890c.U() != 2) {
                    throw new l0.d("syntax error");
                }
                iV = interfaceC0890c.v();
                interfaceC0890c.nextToken();
            } else {
                if (!strN2.equalsIgnoreCase("size")) {
                    throw new l0.d("syntax error, " + strN2);
                }
                if (interfaceC0890c.U() != 2) {
                    throw new l0.d("syntax error");
                }
                iV2 = interfaceC0890c.v();
                interfaceC0890c.nextToken();
            }
            if (interfaceC0890c.U() == 16) {
                interfaceC0890c.A(4);
            }
        }
        interfaceC0890c.nextToken();
        return new Font(strN, iV, iV2);
    }

    protected Point h(C0888a c0888a, Object obj) {
        int iT;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int i5 = 0;
        int i6 = 0;
        while (interfaceC0890c.U() != 13) {
            if (interfaceC0890c.U() != 4) {
                throw new l0.d("syntax error");
            }
            String strN = interfaceC0890c.N();
            if (AbstractC0822a.f18018c.equals(strN)) {
                c0888a.c("java.awt.Point");
            } else {
                if ("$ref".equals(strN)) {
                    return (Point) j(c0888a, obj);
                }
                interfaceC0890c.L(2);
                int iU = interfaceC0890c.U();
                if (iU == 2) {
                    iT = interfaceC0890c.v();
                    interfaceC0890c.nextToken();
                } else {
                    if (iU != 3) {
                        throw new l0.d("syntax error : " + interfaceC0890c.o0());
                    }
                    iT = (int) interfaceC0890c.T();
                    interfaceC0890c.nextToken();
                }
                if (strN.equalsIgnoreCase("x")) {
                    i5 = iT;
                } else {
                    if (!strN.equalsIgnoreCase("y")) {
                        throw new l0.d("syntax error, " + strN);
                    }
                    i6 = iT;
                }
                if (interfaceC0890c.U() == 16) {
                    interfaceC0890c.A(4);
                }
            }
        }
        interfaceC0890c.nextToken();
        return new Point(i5, i6);
    }

    protected Rectangle i(C0888a c0888a) {
        int iT;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (interfaceC0890c.U() != 13) {
            if (interfaceC0890c.U() != 4) {
                throw new l0.d("syntax error");
            }
            String strN = interfaceC0890c.N();
            interfaceC0890c.L(2);
            int iU = interfaceC0890c.U();
            if (iU == 2) {
                iT = interfaceC0890c.v();
                interfaceC0890c.nextToken();
            } else {
                if (iU != 3) {
                    throw new l0.d("syntax error");
                }
                iT = (int) interfaceC0890c.T();
                interfaceC0890c.nextToken();
            }
            if (strN.equalsIgnoreCase("x")) {
                i5 = iT;
            } else if (strN.equalsIgnoreCase("y")) {
                i6 = iT;
            } else if (strN.equalsIgnoreCase("width")) {
                i7 = iT;
            } else {
                if (!strN.equalsIgnoreCase("height")) {
                    throw new l0.d("syntax error, " + strN);
                }
                i8 = iT;
            }
            if (interfaceC0890c.U() == 16) {
                interfaceC0890c.A(4);
            }
        }
        interfaceC0890c.nextToken();
        return new Rectangle(i5, i6, i7, i8);
    }

    protected char l(e0 e0Var, Class<?> cls, char c6) {
        if (!e0Var.v(f0.WriteClassName)) {
            return c6;
        }
        e0Var.write(123);
        e0Var.D(AbstractC0822a.f18018c);
        e0Var.h0(cls.getName());
        return ',';
    }
}
