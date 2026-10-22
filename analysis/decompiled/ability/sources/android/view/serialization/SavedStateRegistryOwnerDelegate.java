package android.view.serialization;

import S7.a;
import V7.c;
import Z7.t;
import android.os.Bundle;
import android.view.SavedStateRegistry;
import android.view.internal.C0814CanonicalName_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import x9.b;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00028\u00000\u0003B=\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001a\u001a\u00028\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ.\u0010\u001d\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010#R\u0016\u0010\u001c\u001a\u00028\u00008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010$¨\u0006%"}, d2 = {"Landroidx/savedstate/serialization/SavedStateRegistryOwnerDelegate;", "", ExifInterface.GPS_DIRECTION_TRUE, "LV7/c;", "Landroidx/savedstate/SavedStateRegistry;", "registry", "Lx9/b;", "serializer", "", "key", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "configuration", "Lkotlin/Function0;", "init", AppAgent.CONSTRUCT, "(Landroidx/savedstate/SavedStateRegistry;Lx9/b;Ljava/lang/String;Landroidx/savedstate/serialization/SavedStateConfiguration;LS7/a;)V", "loadValue", "(Ljava/lang/String;)Ljava/lang/Object;", "LC7/r;", "registerSave", "(Ljava/lang/String;)V", "thisRef", "LZ7/t;", "property", "createDefaultKey", "(Ljava/lang/Object;LZ7/t;)Ljava/lang/String;", "getValue", "(Ljava/lang/Object;LZ7/t;)Ljava/lang/Object;", "value", "setValue", "(Ljava/lang/Object;LZ7/t;Ljava/lang/Object;)V", "Landroidx/savedstate/SavedStateRegistry;", "Lx9/b;", "Ljava/lang/String;", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "LS7/a;", "Ljava/lang/Object;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SavedStateRegistryOwnerDelegate<T> implements c {
    private final SavedStateConfiguration configuration;
    private final a init;
    private final String key;
    private final SavedStateRegistry registry;
    private final b serializer;
    private T value;

    public SavedStateRegistryOwnerDelegate(SavedStateRegistry registry, b serializer, String str, SavedStateConfiguration configuration, a init) {
        k.f(registry, "registry");
        k.f(serializer, "serializer");
        k.f(configuration, "configuration");
        k.f(init, "init");
        this.registry = registry;
        this.serializer = serializer;
        this.key = str;
        this.configuration = configuration;
        this.init = init;
    }

    private final String createDefaultKey(Object thisRef, t property) {
        String str;
        if (thisRef != null) {
            str = C0814CanonicalName_jvmKt.getCanonicalName(m.f4928a.b(thisRef.getClass())) + '.';
        } else {
            str = "";
        }
        StringBuilder sbV = androidx.compose.foundation.b.v(str);
        sbV.append(property.getName());
        return sbV.toString();
    }

    private final T loadValue(String key) {
        Bundle bundleConsumeRestoredStateForKey = this.registry.consumeRestoredStateForKey(key);
        if (bundleConsumeRestoredStateForKey != null) {
            return (T) SavedStateDecoderKt.decodeFromSavedState(this.serializer, bundleConsumeRestoredStateForKey, this.configuration);
        }
        return null;
    }

    private final void registerSave(String key) {
        this.registry.registerSavedStateProvider(key, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.savedstate.serialization.a
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return SavedStateRegistryOwnerDelegate.registerSave$lambda$1(this.f2003a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle registerSave$lambda$1(SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate) {
        b bVar = savedStateRegistryOwnerDelegate.serializer;
        T t9 = savedStateRegistryOwnerDelegate.value;
        if (t9 != null) {
            return SavedStateEncoderKt.encodeToSavedState(bVar, t9, savedStateRegistryOwnerDelegate.configuration);
        }
        k.n("value");
        throw null;
    }

    @Override // V7.b
    public T getValue(Object thisRef, t property) {
        k.f(property, "property");
        if (this.value == null) {
            String strCreateDefaultKey = this.key;
            if (strCreateDefaultKey == null) {
                strCreateDefaultKey = createDefaultKey(thisRef, property);
            }
            registerSave(strCreateDefaultKey);
            T tLoadValue = loadValue(strCreateDefaultKey);
            if (tLoadValue == null) {
                tLoadValue = (T) this.init.invoke();
            }
            this.value = tLoadValue;
        }
        T t9 = this.value;
        if (t9 != null) {
            return t9;
        }
        k.n("value");
        throw null;
    }

    public void setValue(Object thisRef, t property, T value) {
        k.f(property, "property");
        k.f(value, "value");
        if (this.value == null) {
            String strCreateDefaultKey = this.key;
            if (strCreateDefaultKey == null) {
                strCreateDefaultKey = createDefaultKey(thisRef, property);
            }
            registerSave(strCreateDefaultKey);
        }
        this.value = value;
    }
}
