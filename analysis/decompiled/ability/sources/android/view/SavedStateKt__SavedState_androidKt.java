package android.view;

import C7.r;
import S7.k;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\n\u001a\u00060\bj\u0002`\t2\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a9\u0010\n\u001a\u00060\bj\u0002`\t2\n\u0010\u0003\u001a\u00060\bj\u0002`\t2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\f*\n\u0010\r\"\u00020\b2\u00020\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"", "", "", "initialState", "Lkotlin/Function1;", "Landroidx/savedstate/SavedStateWriter;", "LC7/r;", "builderAction", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "savedState", "(Ljava/util/Map;LS7/k;)Landroid/os/Bundle;", "(Landroid/os/Bundle;LS7/k;)Landroid/os/Bundle;", "SavedState", "savedstate_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/savedstate/SavedStateKt")
/* loaded from: classes2.dex */
final /* synthetic */ class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Map<String, ? extends Object> initialState, k builderAction) {
        Pair[] pairArr;
        kotlin.jvm.internal.k.f(initialState, "initialState");
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        if (initialState.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(initialState.size());
            for (Map.Entry<String, ? extends Object> entry : initialState.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        builderAction.invoke(SavedStateWriter.m7261boximpl(SavedStateWriter.m7263constructorimpl(bundleBundleOf)));
        return bundleBundleOf;
    }

    public static /* synthetic */ Bundle savedState$default(Bundle initialState, k builderAction, int i, Object obj) {
        if ((i & 2) != 0) {
            builderAction = new k() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.3
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m7175invokexApjlu4(((SavedStateWriter) obj2).getSource());
                    return r.f317a;
                }

                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m7175invokexApjlu4(Bundle bundle) {
                    kotlin.jvm.internal.k.f(bundle, "<this>");
                }
            };
        }
        kotlin.jvm.internal.k.f(initialState, "initialState");
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        Bundle bundle = new Bundle(initialState);
        builderAction.invoke(SavedStateWriter.m7261boximpl(SavedStateWriter.m7263constructorimpl(bundle)));
        return bundle;
    }

    public static Bundle savedState$default(Map initialState, k builderAction, int i, Object obj) {
        Pair[] pairArr;
        if ((i & 1) != 0) {
            initialState = a.M();
        }
        if ((i & 2) != 0) {
            builderAction = new k() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt.savedState.1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m7174invokexApjlu4(((SavedStateWriter) obj2).getSource());
                    return r.f317a;
                }

                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m7174invokexApjlu4(Bundle bundle) {
                    kotlin.jvm.internal.k.f(bundle, "<this>");
                }
            };
        }
        kotlin.jvm.internal.k.f(initialState, "initialState");
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        if (initialState.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(initialState.size());
            for (Map.Entry entry : initialState.entrySet()) {
                arrayList.add(new Pair((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        builderAction.invoke(SavedStateWriter.m7261boximpl(SavedStateWriter.m7263constructorimpl(bundleBundleOf)));
        return bundleBundleOf;
    }

    public static final Bundle savedState(Bundle initialState, k builderAction) {
        kotlin.jvm.internal.k.f(initialState, "initialState");
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        Bundle bundle = new Bundle(initialState);
        builderAction.invoke(SavedStateWriter.m7261boximpl(SavedStateWriter.m7263constructorimpl(bundle)));
        return bundle;
    }
}
