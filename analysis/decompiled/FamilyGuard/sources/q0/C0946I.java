package q0;

import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import l0.AbstractC0822a;

/* renamed from: q0.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0946I extends d0 {

    /* renamed from: j, reason: collision with root package name */
    protected final b0 f19675j;

    /* renamed from: k, reason: collision with root package name */
    public final e0 f19676k;

    /* renamed from: l, reason: collision with root package name */
    private int f19677l;

    /* renamed from: m, reason: collision with root package name */
    private String f19678m;

    /* renamed from: n, reason: collision with root package name */
    private String f19679n;

    /* renamed from: o, reason: collision with root package name */
    private DateFormat f19680o;

    /* renamed from: p, reason: collision with root package name */
    private String f19681p;

    /* renamed from: q, reason: collision with root package name */
    protected IdentityHashMap<Object, Z> f19682q;

    /* renamed from: r, reason: collision with root package name */
    protected Z f19683r;

    /* renamed from: s, reason: collision with root package name */
    protected TimeZone f19684s;

    /* renamed from: t, reason: collision with root package name */
    protected Locale f19685t;

    public C0946I() {
        this(new e0(), b0.g());
    }

    private DateFormat t(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, this.f19685t);
        simpleDateFormat.setTimeZone(this.f19684s);
        return simpleDateFormat;
    }

    public boolean A(f0 f0Var) {
        return this.f19676k.v(f0Var);
    }

    public final boolean B(Type type, Object obj) {
        if (!this.f19676k.v(f0.WriteClassName)) {
            return false;
        }
        if (type != null || !this.f19676k.v(f0.NotWriteRootClassName)) {
            return true;
        }
        Z z5 = this.f19683r;
        return (z5 == null || z5.f19723a == null) ? false : true;
    }

    public void C() {
        this.f19676k.write(10);
        for (int i5 = 0; i5 < this.f19677l; i5++) {
            this.f19676k.write(this.f19678m);
        }
    }

    public void D(Z z5, Object obj, Object obj2, int i5) {
        E(z5, obj, obj2, i5, 0);
    }

    public void E(Z z5, Object obj, Object obj2, int i5, int i6) {
        if (this.f19676k.f19803h) {
            return;
        }
        this.f19683r = new Z(z5, obj, obj2, i5, i6);
        if (this.f19682q == null) {
            this.f19682q = new IdentityHashMap<>();
        }
        this.f19682q.put(obj, this.f19683r);
    }

    public void F(String str) {
        this.f19679n = str;
        if (this.f19680o != null) {
            this.f19680o = null;
        }
    }

    public final void G(Object obj) {
        if (obj == null) {
            this.f19676k.Y();
            return;
        }
        try {
            x(obj.getClass()).b(this, obj, null, null, 0);
        } catch (IOException e6) {
            throw new l0.d(e6.getMessage(), e6);
        }
    }

    public final void H(String str) {
        g0.f19851a.g(this, str);
    }

    public void I() {
        this.f19676k.Y();
    }

    public void J(Object obj) {
        Z z5 = this.f19683r;
        if (obj == z5.f19724b) {
            this.f19676k.write("{\"$ref\":\"@\"}");
            return;
        }
        Z z6 = z5.f19723a;
        if (z6 != null && obj == z6.f19724b) {
            this.f19676k.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            Z z7 = z5.f19723a;
            if (z7 == null) {
                break;
            } else {
                z5 = z7;
            }
        }
        if (obj == z5.f19724b) {
            this.f19676k.write("{\"$ref\":\"$\"}");
            return;
        }
        this.f19676k.write("{\"$ref\":\"");
        this.f19676k.write(this.f19682q.get(obj).toString());
        this.f19676k.write("\"}");
    }

    public final void K(Object obj, Object obj2) {
        L(obj, obj2, null, 0);
    }

    public final void L(Object obj, Object obj2, Type type, int i5) {
        try {
            if (obj == null) {
                this.f19676k.Y();
            } else {
                x(obj.getClass()).b(this, obj, obj2, type, i5);
            }
        } catch (IOException e6) {
            throw new l0.d(e6.getMessage(), e6);
        }
    }

    public final void M(Object obj, String str) throws IOException {
        if (obj instanceof Date) {
            if ("unixtime".equals(str)) {
                this.f19676k.V((int) (((Date) obj).getTime() / 1000));
                return;
            }
            if ("millis".equals(str)) {
                this.f19676k.X(((Date) obj).getTime());
                return;
            }
            DateFormat dateFormatU = u();
            if (dateFormatU == null) {
                if (str != null) {
                    try {
                        dateFormatU = t(str);
                    } catch (IllegalArgumentException unused) {
                        dateFormatU = t(str.replaceAll(ExifInterface.GPS_DIRECTION_TRUE, "'T'"));
                    }
                } else {
                    String str2 = this.f19681p;
                    dateFormatU = str2 != null ? t(str2) : t(AbstractC0822a.f18020e);
                }
            }
            this.f19676k.h0(dateFormatU.format((Date) obj));
            return;
        }
        if (!(obj instanceof byte[])) {
            if (!(obj instanceof Collection)) {
                G(obj);
                return;
            }
            Collection collection = (Collection) obj;
            Iterator it = collection.iterator();
            this.f19676k.write(91);
            for (int i5 = 0; i5 < collection.size(); i5++) {
                Object next = it.next();
                if (i5 != 0) {
                    this.f19676k.write(44);
                }
                M(next, str);
            }
            this.f19676k.write(93);
            return;
        }
        byte[] bArr = (byte[]) obj;
        if (!"gzip".equals(str) && !"gzip,base64".equals(str)) {
            if ("hex".equals(str)) {
                this.f19676k.U(bArr);
                return;
            } else {
                this.f19676k.x(bArr);
                return;
            }
        }
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPOutputStream = bArr.length < 512 ? new GZIPOutputStream(byteArrayOutputStream, bArr.length) : new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                this.f19676k.x(byteArrayOutputStream.toByteArray());
                u0.g.a(gZIPOutputStream);
            } catch (IOException e6) {
                throw new l0.d("write gzipBytes error", e6);
            }
        } catch (Throwable th) {
            u0.g.a(gZIPOutputStream);
            throw th;
        }
    }

    public void q(f0 f0Var, boolean z5) {
        this.f19676k.o(f0Var, z5);
    }

    public boolean r(Object obj) {
        Z z5;
        IdentityHashMap<Object, Z> identityHashMap = this.f19682q;
        if (identityHashMap == null || (z5 = identityHashMap.get(obj)) == null || obj == Collections.EMPTY_MAP) {
            return false;
        }
        Object obj2 = z5.f19725c;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public void s() {
        this.f19677l--;
    }

    public String toString() {
        return this.f19676k.toString();
    }

    public DateFormat u() {
        String str;
        if (this.f19680o == null && (str = this.f19679n) != null) {
            this.f19680o = t(str);
        }
        return this.f19680o;
    }

    public String v() {
        DateFormat dateFormat = this.f19680o;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.f19679n;
    }

    public String w() {
        return this.f19681p;
    }

    public U x(Class<?> cls) {
        return this.f19675j.h(cls);
    }

    public e0 y() {
        return this.f19676k;
    }

    public void z() {
        this.f19677l++;
    }

    public C0946I(e0 e0Var) {
        this(e0Var, b0.g());
    }

    public C0946I(e0 e0Var, b0 b0Var) {
        this.f19677l = 0;
        this.f19678m = "\t";
        this.f19682q = null;
        this.f19684s = AbstractC0822a.f18016a;
        this.f19685t = AbstractC0822a.f18017b;
        this.f19676k = e0Var;
        this.f19675j = b0Var;
    }
}
