package androidx.compose.runtime.saveable;

import androidx.compose.runtime.RememberObserver;
import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003BG\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0004\b\u000e\u0010\u000fJK\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u000fJ\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u001f\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0010\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r¢\u0006\u0002\u0010\u001fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/runtime/saveable/SaveableHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/saveable/SaverScope;", "Landroidx/compose/runtime/RememberObserver;", "saver", "Landroidx/compose/runtime/saveable/Saver;", "", "registry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "key", "", "value", "inputs", "", "<init>", "(Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "Ljava/lang/Object;", "[Ljava/lang/Object;", "entry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "Lkotlin/Function0;", "update", "", MiPushClient.COMMAND_REGISTER, "canBeSaved", "", "onRemembered", "onForgotten", "onAbandoned", "getValueIfInputsDidntChange", "([Ljava/lang/Object;)Ljava/lang/Object;", "runtime-saveable"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SaveableHolder<T> implements SaverScope, RememberObserver {
    private SaveableStateRegistry.Entry entry;
    private Object[] inputs;
    private String key;
    private SaveableStateRegistry registry;
    private Saver<T, Object> saver;
    private T value;
    private final Function0<Object> valueProvider;

    public static /* synthetic */ Object a(SaveableHolder r100) {
        return valueProvider$lambda$2(r100);
    }

    private final void register() {
        SaveableStateRegistry r100 = this.registry;
        if (this.entry != null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L11;
        if (r100 == null) goto L12;
        RememberSaveableKt.access$requireCanBeSaved(r100, this.valueProvider.invoke());
        this.entry = r100.registerProvider(this.key, this.valueProvider);
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException(("entry(" + this.entry + ") is not null").toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        SaveableStateRegistry.Entry r100 = this.entry;
        if (r100 == null) goto L6;
        r100.unregister();
        return;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        SaveableStateRegistry.Entry r100 = this.entry;
        if (r100 == null) goto L6;
        r100.unregister();
        return;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        register();
    }

    private static final Object valueProvider$lambda$2(SaveableHolder r100) {
        Saver<T, Object> r101 = r100.saver;
        T r102 = r100.value;
        if (r102 == null) goto L7;
        return r101.save(r100, r102);
    L7:
        throw new IllegalArgumentException("Value should be initialized".toString());
    }

    @Override // androidx.compose.runtime.saveable.SaverScope
    public boolean canBeSaved(Object r100) {
        SaveableStateRegistry r101 = this.registry;
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101.canBeSaved(r100) == true) goto L8;
        return false;
    }

    public final T getValueIfInputsDidntChange(Object[] r100) {
        if (Arrays.equals(r100, this.inputs) == true) goto L7;
        return null;
    L7:
        return this.value;
    }

    public SaveableHolder(Saver<T, Object> r100, SaveableStateRegistry r101, String r102, T r103, Object[] r104) {
        this.saver = r100;
        this.registry = r101;
        this.key = r102;
        this.value = r103;
        this.inputs = r104;
        this.valueProvider = new f(this);
    }

    public final void update(Saver<T, Object> r100, SaveableStateRegistry r101, String r102, T r103, Object[] r104) {
        boolean r105 = true;
        if (this.registry == r101) goto L5;
        this.registry = r101;
        boolean r106 = true;
    L7:
        if (Intrinsics.areEqual(this.key, r102) == true) goto L9;
        this.key = r102;
    L10:
        this.saver = r100;
        this.value = r103;
        this.inputs = r104;
        SaveableStateRegistry.Entry r107 = this.entry;
        if (r107 == null) goto L17;
        if (r105 == false) goto L18;
        if (r107 == null) goto L15;
        r107.unregister();
    L15:
        this.entry = null;
        register();
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r105 = r106;
        goto L10
    L5:
        r106 = false;
        goto L7
    }
}
