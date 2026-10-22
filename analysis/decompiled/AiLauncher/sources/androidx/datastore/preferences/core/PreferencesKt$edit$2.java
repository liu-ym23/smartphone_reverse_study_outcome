package androidx.datastore.preferences.core;

import M0.a;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LM0/a;", "it", "<anonymous>", "(LM0/a;)LM0/a;"}, k = 3, mv = {1, 5, 1})
@InterfaceC4112d(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PreferencesKt$edit$2 extends SuspendLambda implements p<a, InterfaceC4014c<? super a>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f13401a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13402b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p<MutablePreferences, InterfaceC4014c<? super t>, Object> f13403c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PreferencesKt$edit$2(p<? super MutablePreferences, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super PreferencesKt$edit$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f13403c = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PreferencesKt$edit$2 preferencesKt$edit$2 = new PreferencesKt$edit$2(this.f13403c, interfaceC4014c);
        preferencesKt$edit$2.f13402b = obj;
        return preferencesKt$edit$2;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(a aVar, InterfaceC4014c<? super a> interfaceC4014c) {
        return ((PreferencesKt$edit$2) create(aVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f13401a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutablePreferences mutablePreferences = (MutablePreferences) this.f13402b;
            C4849c.b(obj);
            return mutablePreferences;
        }
        C4849c.b(obj);
        MutablePreferences mutablePreferencesC = ((a) this.f13402b).c();
        p<MutablePreferences, InterfaceC4014c<? super t>, Object> pVar = this.f13403c;
        this.f13402b = mutablePreferencesC;
        this.f13401a = 1;
        return pVar.invoke(mutablePreferencesC, this) == objG ? objG : mutablePreferencesC;
    }
}
