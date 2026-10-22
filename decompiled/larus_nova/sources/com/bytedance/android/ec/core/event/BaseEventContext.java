package com.bytedance.android.ec.core.event;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.ec.core.event.eventdumper.EventParamProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseEventContext {
    private final HashMap<String, String> extraParams;
    private final HashMap<String, b> paramsMap;

    public final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Field f43965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseEventContext f43966b;

        @Override // com.bytedance.android.ec.core.event.BaseEventContext.b
        public final Object getValue() {
            return this.f43965a.get(this.f43966b);
        }

        public a(BaseEventContext r100, Field r101) {
            Intrinsics.checkNotNullParameter(r101, "field");
            this.f43966b = r100;
            this.f43965a = r101;
            r101.setAccessible(true);
        }
    }

    public interface b {
        Object getValue();
    }

    public final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f43967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseEventContext f43968b;

        @Override // com.bytedance.android.ec.core.event.BaseEventContext.b
        public final Object getValue() {
            return this.f43967a.invoke(this.f43968b, new Object[0]);
        }

        public c(BaseEventContext r100, Method r101) {
            Intrinsics.checkNotNullParameter(r101, e.f25671s);
            this.f43968b = r100;
            this.f43967a = r101;
            r101.setAccessible(true);
        }
    }

    public BaseEventContext() {
        this.paramsMap = new HashMap();
        this.extraParams = new HashMap();
        Field[] r100 = getClass().getDeclaredFields();
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L11;
        Field r104 = r100[r103];
        Iterator r105 = ArrayIteratorKt.iterator(r104.getDeclaredAnnotations());
    L6:
        if (r105.hasNext() == false) goto L10;
        Annotation r106 = (Annotation) r105.next();
        if ((r106 instanceof EventParamProvider) == false) goto L6;
        this.paramsMap.put(((EventParamProvider) r106).value(), new a(this, r104));
        goto L6
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        Method[] r107 = getClass().getDeclaredMethods();
        int r108 = r107.length;
    L12:
        if (r102 >= r108) goto L20;
        Method r109 = r107[r102];
        Iterator r110 = ArrayIteratorKt.iterator(r109.getDeclaredAnnotations());
    L15:
        if (r110.hasNext() == false) goto L19;
        Annotation r111 = (Annotation) r110.next();
        if ((r111 instanceof EventParamProvider) == false) goto L15;
        this.paramsMap.put(((EventParamProvider) r111).value(), new c(this, r109));
        goto L15
    L19:
        r102 = r102 + 1;
        goto L12
    }

    public final HashMap<String, String> getExtraParams() {
        return this.extraParams;
    }

    public final HashMap<String, b> getParamsMap() {
        return this.paramsMap;
    }

    public final void post(final String r100, final Map<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        new AnonymousClass1(r101, r100, r100).with(new BaseEventContext[]{this}).post(null, null);
    }
}
