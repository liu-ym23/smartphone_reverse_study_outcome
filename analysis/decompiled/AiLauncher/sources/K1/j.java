package K1;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonFactory;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;

/* loaded from: classes.dex */
public final class j implements Comparable<j> {

    /* renamed from: a, reason: collision with root package name */
    public final L1.a f4038a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4039b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4040c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4041d;

    /* renamed from: e, reason: collision with root package name */
    public char[] f4042e;

    /* renamed from: f, reason: collision with root package name */
    public a f4043f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public t f4044a;

        /* renamed from: b, reason: collision with root package name */
        public Class<?> f4045b;

        public a(t tVar, Class<?> cls) {
            this.f4044a = tVar;
            this.f4045b = cls;
        }
    }

    public j(L1.a aVar) {
        boolean z10;
        this.f4038a = aVar;
        H1.b bVarE = aVar.e();
        if (bVarE != null) {
            z10 = false;
            for (SerializerFeature serializerFeature : bVarE.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    z10 = true;
                }
            }
            String strTrim = bVarE.format().trim();
            str = strTrim.length() != 0 ? strTrim : null;
            this.f4040c = SerializerFeature.of(bVarE.serialzeFeatures());
        } else {
            this.f4040c = 0;
            z10 = false;
        }
        this.f4039b = z10;
        this.f4041d = str;
        String str = aVar.f4261a;
        int length = str.length();
        this.f4042e = new char[length + 3];
        str.getChars(0, str.length(), this.f4042e, 1);
        char[] cArr = this.f4042e;
        cArr[0] = JsonFactory.DEFAULT_QUOTE_CHAR;
        cArr[length + 1] = JsonFactory.DEFAULT_QUOTE_CHAR;
        cArr[length + 2] = ':';
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(j jVar) {
        return this.f4038a.compareTo(jVar.f4038a);
    }

    public Object b(Object obj) throws Exception {
        try {
            return this.f4038a.c(obj);
        } catch (Exception e10) {
            L1.a aVar = this.f4038a;
            Member member = aVar.f4262b;
            if (member == null) {
                member = aVar.f4263c;
            }
            throw new JSONException("get property error。 " + (member.getDeclaringClass().getName() + "." + member.getName()), e10);
        }
    }

    public void c(m mVar) throws IOException {
        z zVar = mVar.f4048b;
        int i10 = zVar.f4092c;
        if ((SerializerFeature.QuoteFieldNames.mask & i10) == 0) {
            zVar.J(this.f4038a.f4261a, true);
        } else if ((i10 & SerializerFeature.UseSingleQuotes.mask) != 0) {
            zVar.J(this.f4038a.f4261a, true);
        } else {
            char[] cArr = this.f4042e;
            zVar.write(cArr, 0, cArr.length);
        }
    }

    public void e(m mVar, Object obj) throws Exception {
        String str = this.f4041d;
        if (str != null) {
            mVar.w(obj, str);
            return;
        }
        if (this.f4043f == null) {
            Class<?> cls = obj == null ? this.f4038a.f4267g : obj.getClass();
            this.f4043f = new a(mVar.f4047a.a(cls), cls);
        }
        a aVar = this.f4043f;
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2 == aVar.f4045b) {
                t tVar = aVar.f4044a;
                L1.a aVar2 = this.f4038a;
                tVar.a(mVar, obj, aVar2.f4261a, aVar2.f4268h);
                return;
            } else {
                t tVarA = mVar.f4047a.a(cls2);
                L1.a aVar3 = this.f4038a;
                tVarA.a(mVar, obj, aVar3.f4261a, aVar3.f4268h);
                return;
            }
        }
        if ((this.f4040c & SerializerFeature.WriteNullNumberAsZero.mask) != 0 && Number.class.isAssignableFrom(aVar.f4045b)) {
            mVar.f4048b.write(48);
            return;
        }
        int i10 = this.f4040c;
        if ((SerializerFeature.WriteNullBooleanAsFalse.mask & i10) != 0 && Boolean.class == aVar.f4045b) {
            mVar.f4048b.write("false");
        } else if ((i10 & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Collection.class.isAssignableFrom(aVar.f4045b)) {
            aVar.f4044a.a(mVar, null, this.f4038a.f4261a, aVar.f4045b);
        } else {
            mVar.f4048b.write("[]");
        }
    }
}
