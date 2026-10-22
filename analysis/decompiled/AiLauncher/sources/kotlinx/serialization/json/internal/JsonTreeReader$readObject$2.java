package kotlinx.serialization.json.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {24}, m = "readObject")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36844a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36845b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36846c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36847d;

    /* renamed from: e, reason: collision with root package name */
    public int f36848e;

    /* renamed from: f, reason: collision with root package name */
    public int f36849f;

    /* renamed from: g, reason: collision with root package name */
    public byte f36850g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f36851h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ JsonTreeReader f36852i;

    /* renamed from: j, reason: collision with root package name */
    public int f36853j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, InterfaceC4014c<? super JsonTreeReader$readObject$2> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36852i = jsonTreeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f36851h = obj;
        this.f36853j |= Integer.MIN_VALUE;
        return this.f36852i.h(null, this);
    }
}
