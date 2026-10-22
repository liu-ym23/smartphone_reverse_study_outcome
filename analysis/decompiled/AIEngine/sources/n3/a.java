package n3;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializer;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final BeanPropertyWriter[] f10606i = new BeanPropertyWriter[0];

    /* renamed from: a, reason: collision with root package name */
    public final i3.d f10607a;

    /* renamed from: b, reason: collision with root package name */
    public SerializationConfig f10608b;

    /* renamed from: c, reason: collision with root package name */
    public List<BeanPropertyWriter> f10609c = Collections.EMPTY_LIST;

    /* renamed from: d, reason: collision with root package name */
    public BeanPropertyWriter[] f10610d;

    /* renamed from: e, reason: collision with root package name */
    public com.stepos.statsrpk.g f10611e;

    /* renamed from: f, reason: collision with root package name */
    public Object f10612f;

    /* renamed from: g, reason: collision with root package name */
    public AnnotatedMember f10613g;
    public o3.a h;

    public a(i3.d dVar) {
        this.f10607a = dVar;
    }

    public final BeanSerializer a() {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.f10613g != null && this.f10608b.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.f10613g.g(this.f10608b.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        com.stepos.statsrpk.g gVar = this.f10611e;
        if (gVar != null) {
            ((AnnotatedMember) gVar.f8088b).g(this.f10608b.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        List<BeanPropertyWriter> list = this.f10609c;
        if (list == null || list.isEmpty()) {
            if (this.f10611e == null && this.h == null) {
                return null;
            }
            beanPropertyWriterArr = f10606i;
        } else {
            List<BeanPropertyWriter> list2 = this.f10609c;
            beanPropertyWriterArr = (BeanPropertyWriter[]) list2.toArray(new BeanPropertyWriter[list2.size()]);
            if (this.f10608b.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                    beanPropertyWriter.f4294k.g(this.f10608b.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
            }
        }
        BeanPropertyWriter[] beanPropertyWriterArr2 = this.f10610d;
        if (beanPropertyWriterArr2 == null || beanPropertyWriterArr2.length == this.f10609c.size()) {
            return new BeanSerializer(this.f10607a.f3041a, this, beanPropertyWriterArr, this.f10610d);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.f10609c.size()), Integer.valueOf(this.f10610d.length)));
    }
}
