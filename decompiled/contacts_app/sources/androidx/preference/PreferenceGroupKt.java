package androidx.preference;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: PreferenceGroup.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a3\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\bø\u0001\u0000\u001aH\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\bø\u0001\u0000\u001a&\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u0002*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\n¢\u0006\u0002\u0010\u001a\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002\u001a\r\u0010\u001b\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u001c\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001f\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010 \u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroidx/preference/Preference;", "Landroidx/preference/PreferenceGroup;", "getChildren", "(Landroidx/preference/PreferenceGroup;)Lkotlin/sequences/Sequence;", PerfConsts.PERF_DISK_FILE_SIZE, "", "getSize", "(Landroidx/preference/PreferenceGroup;)I", "contains", "", "preference", "forEach", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "", "(Landroidx/preference/PreferenceGroup;Ljava/lang/CharSequence;)Landroidx/preference/Preference;", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "preference-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PreferenceGroupKt {

    /* JADX INFO: renamed from: androidx.preference.PreferenceGroupKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreferenceGroup.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/preference/PreferenceGroupKt$iterator$1", "", "Landroidx/preference/Preference;", "index", "", "hasNext", "", "next", "remove", "", "preference-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Preference>, KMutableIterator {
        final /* synthetic */ PreferenceGroup $this_iterator;
        private int index;

        AnonymousClass1(PreferenceGroup r1) {
            this.$this_iterator = r1;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Preference next() {
            return next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.getPreferenceCount()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Preference next() {
            PreferenceGroup r0 = this.$this_iterator;
            int r1 = this.index;
            this.index = r1 + 1;
            Preference r3 = r0.getPreference(r1);
            Intrinsics.checkNotNullExpressionValue(r3, "getPreference(index++)");
            return r3;
        }

        @Override // java.util.Iterator
        public void remove() {
            PreferenceGroup r0 = this.$this_iterator;
            int r1 = this.index - 1;
            this.index = r1;
            r0.removePreference(r0.getPreference(r1));
        }
    }

    public static final <T extends Preference> T get(PreferenceGroup r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        return (T) r1.findPreference(r2);
    }

    public static final Preference get(PreferenceGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Preference r3 = r1.getPreference(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "getPreference(index)");
        return r3;
    }

    public static final boolean contains(PreferenceGroup r4, Preference r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "preference");
        int r0 = r4.getPreferenceCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int r3 = r2 + 1;
        if (Intrinsics.areEqual(r4.getPreference(r2), r5) == true) goto L6;
        r2 = r3;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final void plusAssign(PreferenceGroup r1, Preference r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "preference");
        r1.addPreference(r2);
    }

    public static final void minusAssign(PreferenceGroup r1, Preference r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "preference");
        r1.removePreference(r2);
    }

    public static final int getSize(PreferenceGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getPreferenceCount();
    }

    public static final void forEach(PreferenceGroup r3, Function1<? super Preference, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        int r0 = r3.getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r1 + 1;
        r4.invoke(get(r3, r1));
        r1 = r2;
        goto L3
    }

    public static final void forEachIndexed(PreferenceGroup r4, Function2<? super Integer, ? super Preference, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        int r0 = r4.getPreferenceCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r1 + 1;
        r5.invoke(Integer.valueOf(r1), get(r4, r1));
        r1 = r2;
        goto L3
    }

    public static final Iterator<Preference> iterator(PreferenceGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    public static final Sequence<Preference> getChildren(final PreferenceGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new PreferenceGroupKt$children$1(r1);
    }

    public static final boolean isEmpty(PreferenceGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getPreferenceCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(PreferenceGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getPreferenceCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
