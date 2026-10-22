package androidx.lifecycle;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0002,-B\u001f\b\u0017\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0017¢\u0006\u0004\b\u0005\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0011\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0087\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J)\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u0016J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u0002H\u0014H\u0002¢\u0006\u0002\u0010\u0019J)\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001b\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u001cJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00140\u001e\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u0002H\u0014H\u0007¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0007J\u001e\u0010\"\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010#J&\u0010$\u001a\u00020%\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u0001H\u0014H\u0087\u0002¢\u0006\u0002\u0010'J\u001d\u0010(\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010#J\u0018\u0010)\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u000eH\u0007J\u0010\u0010+\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "initialState", "", "", "<init>", "(Ljava/util/Map;)V", "()V", "liveDatas", "", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "impl", "Landroidx/lifecycle/internal/SavedStateHandleImpl;", "savedStateProvider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "contains", "", "key", "getLiveData", "Landroidx/lifecycle/MutableLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "hasInitialValue", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "getMutableStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "keys", "", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/String;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "setSavedStateProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "clearSavedStateProvider", "SavingStateLiveData", "Companion", "lifecycle-viewmodel-savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandle {
    public static final Companion Companion = null;
    private SavedStateHandleImpl impl;
    private final Map<String, SavingStateLiveData<?>> liveDatas;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u000e\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "<init>", "()V", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "defaultState", "validateValue", "", "value", "lifecycle-viewmodel-savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean validateValue(Object r100) {
            return SavedStateHandleImpl_androidKt.isAcceptableType(r100);
        }

        @JvmStatic
        public final SavedStateHandle createHandle(Bundle r100, Bundle r101) {
            if (r100 != null) goto L4;
            r100 = r101;
        L4:
            if (r100 == null) goto L6;
            ClassLoader r102 = SavedStateHandle.class.getClassLoader();
            Intrinsics.checkNotNull(r102);
            r100.setClassLoader(r102);
            return new SavedStateHandle(SavedStateReader.m7912toMapimpl(SavedStateReader.m7831constructorimpl(r100)));
        L6:
            return new SavedStateHandle();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "key", "", "value", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "setValue", "", "(Ljava/lang/Object;)V", "detach", "lifecycle-viewmodel-savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        public final void detach() {
            this.handle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T r100) {
            SavedStateHandle r101 = this.handle;
            if (r101 == null) goto L7;
            SavedStateHandleImpl r102 = SavedStateHandle.access$getImpl$p(r101);
            if (r102 == null) goto L7;
            r102.set(this.key, r100);
        L7:
            super.setValue(r100);
        }

        public SavingStateLiveData(SavedStateHandle r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "key");
            this.key = r101;
            this.handle = r100;
        }

        public SavingStateLiveData(SavedStateHandle r100, String r101, T r102) {
            Intrinsics.checkNotNullParameter(r101, "key");
            super(r102);
            this.key = r101;
            this.handle = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final SavedStateHandle createHandle(Bundle r100, Bundle r101) {
        return Companion.createHandle(r100, r101);
    }

    public final Set<String> keys() {
        return SetsKt.plus(this.impl.keys(), this.liveDatas.keySet());
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.impl.getSavedStateProvider();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SavedStateHandle() {
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(null, 1, 0 == true ? 1 : 0);
    }

    public SavedStateHandle(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        this.liveDatas = new LinkedHashMap();
        this.impl = new SavedStateHandleImpl(r100);
    }

    public static final /* synthetic */ SavedStateHandleImpl access$getImpl$p(SavedStateHandle r100) {
        return r100.impl;
    }

    public final void clearSavedStateProvider(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.impl.clearSavedStateProvider(r100);
    }

    public final boolean contains(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.impl.contains(r100);
    }

    public final <T> T get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) this.impl.get(r100);
    }

    public final <T> MutableLiveData<T> getLiveData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        MutableLiveData<T> r101 = getLiveDataInternal(r100, false, null);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return r101;
    }

    public final <T> T remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) this.impl.remove(r100);
        SavingStateLiveData<?> r102 = this.liveDatas.remove(r100);
        if (r102 == null) goto L5;
        r102.detach();
    L5:
        return r101;
    }

    public final <T> MutableLiveData<T> getLiveData(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getLiveDataInternal(r100, true, r101);
    }

    public final <T> z0<T> getMutableStateFlow(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if ((!this.liveDatas.containsKey(r100)) == false) goto L7;
        return this.impl.getMutableStateFlow(r100, r101);
    L7:
        throw new IllegalArgumentException(SavedStateHandle_androidKt.access$createMutuallyExclusiveErrorMessage(r100).toString());
    }

    public final <T> i1<T> getStateFlow(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.impl.getMutableFlows().containsKey(r100) == false) goto L6;
        return kotlinx.coroutines.flow.e.b(this.impl.getMutableStateFlow(r100, r101));
    L6:
        return this.impl.getStateFlow(r100, r101);
    }

    public final <T> void set(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (Companion.validateValue(r101) == false) goto L12;
        SavingStateLiveData<?> r102 = this.liveDatas.get(r100);
        if ((r102 instanceof MutableLiveData) == false) goto L7;
        SavingStateLiveData<?> r103 = r102;
    L8:
        if (r103 == null) goto L10;
        r103.setValue(r101);
    L10:
        this.impl.set(r100, r101);
        return;
    L7:
        r103 = null;
        goto L8
    L12:
        StringBuilder r104 = new StringBuilder("Can't put value with type ");
        Intrinsics.checkNotNull(r101);
        r104.append(r101.getClass());
        r104.append(" into saved state");
        throw new IllegalArgumentException(r104.toString().toString());
    }

    public final void setSavedStateProvider(String r100, SavedStateRegistry.SavedStateProvider r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.impl.setSavedStateProvider(r100, r101);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String r100, boolean r101, T r102) {
        if ((!this.impl.getMutableFlows().containsKey(r100)) == false) goto L17;
        Map<String, SavingStateLiveData<?>> r103 = this.liveDatas;
        SavingStateLiveData<?> r104 = r103.get(r100);
        if (r104 != null) goto L15;
        if (this.impl.getRegular().containsKey(r100) == false) goto L10;
        SavingStateLiveData<?> r105 = new SavingStateLiveData(this, r100, this.impl.getRegular().get(r100));
    L9:
        r104 = r105;
        r103.put(r100, r104);
        goto L15
    L10:
        if (r101 == false) goto L12;
        this.impl.getRegular().put(r100, r102);
        r105 = new SavingStateLiveData(this, r100, r102);
        goto L9
    L12:
        r105 = new SavingStateLiveData(this, r100);
    L15:
        return r104;
    L17:
        throw new IllegalArgumentException(SavedStateHandle_androidKt.access$createMutuallyExclusiveErrorMessage(r100).toString());
    }
}
