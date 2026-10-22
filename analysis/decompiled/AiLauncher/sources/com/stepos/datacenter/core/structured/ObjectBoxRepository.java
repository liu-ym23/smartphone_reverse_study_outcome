package com.stepos.datacenter.core.structured;

import Ua.C1056g;
import Ua.Y;
import Y8.h;
import Y8.t;
import Z6.a;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.core.structured.ObjectBoxRepository;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.objectbox.BoxStore;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o9.C5013a;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u000f\u0010\rJ\u001e\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/datacenter/core/structured/ObjectBoxRepository;", "", ExifInterface.GPS_DIRECTION_TRUE, "LZ6/a;", "Lio/objectbox/BoxStore;", "boxStore", "Lw9/d;", "entityClass", "<init>", "(Lio/objectbox/BoxStore;Lw9/d;)V", Const.LBS_FAIL_BD_ENTITY, "", "c", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "", Const.INTENT_KEY_APIKEY, "", "entities", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "Lio/objectbox/BoxStore;", "Lw9/d;", "LQ8/a;", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LQ8/a;", "box", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ObjectBoxRepository<T> implements a<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final BoxStore boxStore;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5745d<T> entityClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h box;

    public ObjectBoxRepository(BoxStore boxStore, InterfaceC5745d<T> entityClass) {
        p.i(boxStore, "boxStore");
        p.i(entityClass, "entityClass");
        this.boxStore = boxStore;
        this.entityClass = entityClass;
        this.box = C4848b.b(new InterfaceC5063a() { // from class: Z6.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ObjectBoxRepository.e(this.f7294a);
            }
        });
    }

    public static final Q8.a e(ObjectBoxRepository objectBoxRepository) {
        return objectBoxRepository.boxStore.i(C5013a.b(objectBoxRepository.entityClass));
    }

    public static /* synthetic */ <T> Object f(ObjectBoxRepository<T> objectBoxRepository, T t10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new ObjectBoxRepository$delete$2(objectBoxRepository, t10, null), interfaceC4014c);
    }

    public static /* synthetic */ <T> Object g(ObjectBoxRepository<T> objectBoxRepository, List<? extends T> list, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new ObjectBoxRepository$deleteAll$2(objectBoxRepository, list, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    public static /* synthetic */ <T> Object i(ObjectBoxRepository<T> objectBoxRepository, T t10, InterfaceC4014c<? super Long> interfaceC4014c) {
        return C1056g.j(Y.b(), new ObjectBoxRepository$save$2(objectBoxRepository, t10, null), interfaceC4014c);
    }

    @Override // Z6.a
    public Object a(T t10, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return f(this, t10, interfaceC4014c);
    }

    @Override // Z6.a
    public Object b(List<? extends T> list, InterfaceC4014c<? super t> interfaceC4014c) {
        return g(this, list, interfaceC4014c);
    }

    @Override // Z6.a
    public Object c(T t10, InterfaceC4014c<? super Long> interfaceC4014c) {
        return i(this, t10, interfaceC4014c);
    }

    public final Q8.a<T> h() {
        Object value = this.box.getValue();
        p.h(value, "getValue(...)");
        return (Q8.a) value;
    }
}
