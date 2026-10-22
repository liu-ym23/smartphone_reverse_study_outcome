package H1;

import F1.A;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f737a;

    /* renamed from: b, reason: collision with root package name */
    public final Field f738b;

    /* renamed from: c, reason: collision with root package name */
    public final String f739c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f740d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f741e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f742f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Method f743g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f744h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ A f745i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ F1.n f746j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ TypeToken f747k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f748l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f749m;

    public o(String str, Field field, boolean z4, boolean z5, boolean z6, Method method, boolean z7, A a4, F1.n nVar, TypeToken typeToken, boolean z8, boolean z9) {
        this.f742f = z6;
        this.f743g = method;
        this.f744h = z7;
        this.f745i = a4;
        this.f746j = nVar;
        this.f747k = typeToken;
        this.f748l = z8;
        this.f749m = z9;
        this.f737a = str;
        this.f738b = field;
        this.f739c = field.getName();
        this.f740d = z4;
        this.f741e = z5;
    }

    public final void a(JsonWriter jsonWriter, Object obj) {
        Object objInvoke;
        if (this.f740d) {
            boolean z4 = this.f742f;
            Field field = this.f738b;
            Method method = this.f743g;
            if (z4) {
                if (method == null) {
                    s.b(obj, field);
                } else {
                    s.b(obj, method);
                }
            }
            if (method != null) {
                try {
                    objInvoke = method.invoke(obj, new Object[0]);
                } catch (InvocationTargetException e4) {
                    throw new F1.q(B0.g.n("Accessor ", J1.c.d(method, false), " threw exception"), 5, e4.getCause());
                }
            } else {
                objInvoke = field.get(obj);
            }
            if (objInvoke == obj) {
                return;
            }
            jsonWriter.name(this.f737a);
            boolean z5 = this.f744h;
            A uVar = this.f745i;
            if (!z5) {
                uVar = new u(this.f746j, uVar, this.f747k.getType());
            }
            uVar.c(jsonWriter, objInvoke);
        }
    }
}
