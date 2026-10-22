package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import s9.InterfaceC5453e;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00130\u001d2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b \u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010$R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010%R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050&j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "", "", "effect", "Lkotlin/Function2;", "", "LY8/t;", "onLive", "Lkotlin/Function0;", "onChanged", "<init>", "(Ljava/lang/String;Lp9/p;Lp9/a;)V", "", "defaults", "k", "(Ljava/util/Map;)V", "name", "f", "(Ljava/lang/String;)[F", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)F", "l", "()Ljava/util/Map;", "v", "", "pushLive", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;[FZ)V", "Ls9/e;", "e", "(Ljava/lang/String;)Ls9/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/lang/String;", "getEffect", "()Ljava/lang/String;", "Lp9/p;", "Lp9/a;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "values", "Ljava/util/LinkedHashMap;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3077q {
    private final String effect;
    private final InterfaceC5063a<Y8.t> onChanged;
    private final p9.p<String, float[], Y8.t> onLive;
    private final LinkedHashMap<String, float[]> values;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/voice/motionkit/q$a", "Ls9/e;", "", "", "thisRef", "Lw9/k;", "property", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Lw9/k;)Ljava/lang/Float;", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lw9/k;F)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.motionkit.q$a */
    public static final class a implements InterfaceC5453e<Object, Float> {
        final /* synthetic */ String $name;

        public a(String str) {
            this.$name = str;
        }

        @Override // s9.InterfaceC5453e, s9.InterfaceC5452d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float getValue(Object thisRef, InterfaceC5752k<?> property) {
            kotlin.jvm.internal.p.i(property, "property");
            return Float.valueOf(C3077q.this.g(this.$name));
        }

        public void b(Object thisRef, InterfaceC5752k<?> property, float value) {
            kotlin.jvm.internal.p.i(property, "property");
            C3077q.i(C3077q.this, this.$name, new float[]{value}, false, 4, null);
        }

        @Override // s9.InterfaceC5453e
        public /* bridge */ /* synthetic */ void setValue(Object obj, InterfaceC5752k interfaceC5752k, Float f10) {
            b(obj, interfaceC5752k, f10.floatValue());
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J&\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/voice/motionkit/q$b", "Ls9/e;", "", "", "thisRef", "Lw9/k;", "property", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Lw9/k;)[F", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Lw9/k;[F)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.motionkit.q$b */
    public static final class b implements InterfaceC5453e<Object, float[]> {
        final /* synthetic */ String $name;

        public b(String str) {
            this.$name = str;
        }

        @Override // s9.InterfaceC5453e, s9.InterfaceC5452d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] getValue(Object thisRef, InterfaceC5752k<?> property) {
            kotlin.jvm.internal.p.i(property, "property");
            float[] fArrF = C3077q.this.f(this.$name);
            return fArrF == null ? new float[]{1.0f, 1.0f, 1.0f} : fArrF;
        }

        @Override // s9.InterfaceC5453e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(Object thisRef, InterfaceC5752k<?> property, float[] value) {
            kotlin.jvm.internal.p.i(property, "property");
            kotlin.jvm.internal.p.i(value, "value");
            C3077q.i(C3077q.this, this.$name, value, false, 4, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3077q(String effect, p9.p<? super String, ? super float[], Y8.t> onLive, InterfaceC5063a<Y8.t> onChanged) {
        kotlin.jvm.internal.p.i(effect, "effect");
        kotlin.jvm.internal.p.i(onLive, "onLive");
        kotlin.jvm.internal.p.i(onChanged, "onChanged");
        this.effect = effect;
        this.onLive = onLive;
        this.onChanged = onChanged;
        this.values = new LinkedHashMap<>();
    }

    public static final Y8.t c(String str, float[] fArr) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(fArr, "<unused var>");
        return Y8.t.f7040a;
    }

    public static final Y8.t d() {
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void i(C3077q c3077q, String str, float[] fArr, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        c3077q.h(str, fArr, z10);
    }

    public final InterfaceC5453e<Object, Float> e(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return new a(name);
    }

    public final float[] f(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        float[] fArr = this.values.get(name);
        if (fArr == null) {
            return null;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.p.h(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    public final float g(String name) {
        Float fH0;
        kotlin.jvm.internal.p.i(name, "name");
        float[] fArr = this.values.get(name);
        if (fArr == null || (fH0 = Z8.r.h0(fArr, 0)) == null) {
            return 0.0f;
        }
        return fH0.floatValue();
    }

    public final void h(String name, float[] v10, boolean pushLive) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(v10, "v");
        LinkedHashMap<String, float[]> linkedHashMap = this.values;
        float[] fArrCopyOf = Arrays.copyOf(v10, v10.length);
        kotlin.jvm.internal.p.h(fArrCopyOf, "copyOf(...)");
        linkedHashMap.put(name, fArrCopyOf);
        if (pushLive) {
            this.onLive.invoke(name, v10);
            this.onChanged.invoke();
        }
    }

    public final InterfaceC5453e<Object, float[]> j(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        return new b(name);
    }

    public final void k(Map<String, float[]> defaults) {
        kotlin.jvm.internal.p.i(defaults, "defaults");
        this.values.clear();
        for (Map.Entry<String, float[]> entry : defaults.entrySet()) {
            String key = entry.getKey();
            float[] value = entry.getValue();
            LinkedHashMap<String, float[]> linkedHashMap = this.values;
            float[] fArrCopyOf = Arrays.copyOf(value, value.length);
            kotlin.jvm.internal.p.h(fArrCopyOf, "copyOf(...)");
            linkedHashMap.put(key, fArrCopyOf);
        }
    }

    public final Map<String, float[]> l() {
        LinkedHashMap<String, float[]> linkedHashMap = this.values;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Z8.Q.e(linkedHashMap.size()));
        Iterator<T> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            float[] fArr = (float[]) entry.getValue();
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            kotlin.jvm.internal.p.h(fArrCopyOf, "copyOf(...)");
            linkedHashMap2.put(key, fArrCopyOf);
        }
        return linkedHashMap2;
    }

    public /* synthetic */ C3077q(String str, p9.p pVar, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? new p9.p() { // from class: com.stepos.ailauncher.chat.voice.motionkit.o
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return C3077q.c((String) obj, (float[]) obj2);
            }
        } : pVar, (i10 & 4) != 0 ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.motionkit.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3077q.d();
            }
        } : interfaceC5063a);
    }
}
