package androidx.compose.ui.semantics;

import C7.d;
import T7.a;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f¢\u0006\u0004\b\u0010\u0010\u000fJ(\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0011H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0016\u001a\u00020\u0015\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u0019\u001a\u00020\u0018\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010!\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0000H\u0000¢\u0006\u0004\b#\u0010 J\r\u0010%\u001a\u00020\u0000¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/R,\u00101\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R*\u00106\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u00109\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b;\u0010\u001c\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010<\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010>R \u0010D\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010A8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "key", "get", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "Lkotlin/Function0;", "defaultValue", "getOrElse", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;LS7/a;)Ljava/lang/Object;", "getOrElseNullable", "", "iterator", "()Ljava/util/Iterator;", "value", "LC7/r;", "set", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "", "contains", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Z", "containsImportantForAccessibility$ui_release", "()Z", "containsImportantForAccessibility", "child", "mergeChild$ui_release", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "mergeChild", "peer", "collapsePeer$ui_release", "collapsePeer", "copy", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/collection/MutableScatterMap;", "props", "Landroidx/collection/MutableScatterMap;", "getProps$ui_release", "()Landroidx/collection/MutableScatterMap;", "", "mapWrapper", "Ljava/util/Map;", "Landroidx/collection/MutableScatterSet;", "_accessibilityExtraKeys", "Landroidx/collection/MutableScatterSet;", "isMergingSemanticsOfDescendants", "Z", "setMergingSemanticsOfDescendants", "(Z)V", "isClearingSemantics", "setClearingSemantics", "Landroidx/collection/ScatterSet;", "getAccessibilityExtraKeys$ui_release", "()Landroidx/collection/ScatterSet;", "accessibilityExtraKeys", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, a {
    public static final int $stable = 8;
    private MutableScatterSet<SemanticsPropertyKey<?>> _accessibilityExtraKeys;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    private Map<SemanticsPropertyKey<?>, ? extends Object> mapWrapper;
    private final MutableScatterMap<SemanticsPropertyKey<?>, Object> props = ScatterMapKt.mutableScatterMapOf();

    public final void collapsePeer$ui_release(SemanticsConfiguration peer) {
        int i;
        if (peer.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = true;
        }
        if (peer.isClearingSemantics) {
            this.isClearingSemantics = true;
        }
        MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap = peer.props;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j5 = jArr[i6];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8;
                int i11 = 8 - ((~(i6 - length)) >>> 31);
                int i12 = 0;
                while (i12 < i11) {
                    if ((255 & j5) < 128) {
                        int i13 = (i6 << 3) + i12;
                        Object obj = objArr[i13];
                        Object obj2 = objArr2[i13];
                        SemanticsPropertyKey<?> semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        if (!this.props.contains(semanticsPropertyKey)) {
                            this.props.set(semanticsPropertyKey, obj2);
                        } else if (obj2 instanceof AccessibilityAction) {
                            Object obj3 = this.props.get(semanticsPropertyKey);
                            k.d(obj3, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                            AccessibilityAction accessibilityAction = (AccessibilityAction) obj3;
                            MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap2 = this.props;
                            String label = accessibilityAction.getLabel();
                            if (label == null) {
                                label = ((AccessibilityAction) obj2).getLabel();
                            }
                            i = i10;
                            String str = label;
                            d action = accessibilityAction.getAction();
                            if (action == null) {
                                action = ((AccessibilityAction) obj2).getAction();
                            }
                            mutableScatterMap2.set(semanticsPropertyKey, new AccessibilityAction(str, action));
                        }
                        i = i10;
                    } else {
                        i = i10;
                    }
                    j5 >>= i;
                    i12++;
                    i10 = i;
                }
                if (i11 != i10) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final <T> boolean contains(SemanticsPropertyKey<T> key) {
        return this.props.containsKey(key);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsImportantForAccessibility$ui_release() {
        /*
            r14 = this;
            androidx.collection.MutableScatterMap<androidx.compose.ui.semantics.SemanticsPropertyKey<?>, java.lang.Object> r14 = r14.props
            java.lang.Object[] r0 = r14.keys
            java.lang.Object[] r1 = r14.values
            long[] r14 = r14.metadata
            int r2 = r14.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L50
            r4 = r3
        Lf:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L4b
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L29:
            if (r9 >= r7) goto L49
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L45
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r0[r10]
            r10 = r1[r10]
            androidx.compose.ui.semantics.SemanticsPropertyKey r11 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r11
            boolean r10 = r11.getIsImportantForAccessibility()
            if (r10 == 0) goto L45
            r14 = 1
            return r14
        L45:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L29
        L49:
            if (r7 != r8) goto L50
        L4b:
            if (r4 == r2) goto L50
            int r4 = r4 + 1
            goto Lf
        L50:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsConfiguration.containsImportantForAccessibility$ui_release():boolean");
    }

    public final SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        semanticsConfiguration.props.putAll(this.props);
        return semanticsConfiguration;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) other;
        return k.b(this.props, semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics;
    }

    public final <T> T get(SemanticsPropertyKey<T> key) {
        T t9 = (T) this.props.get(key);
        if (t9 != null) {
            return t9;
        }
        throw new IllegalStateException("Key not present: " + key + " - consider getOrElse or getOrNull");
    }

    public final ScatterSet<SemanticsPropertyKey<?>> getAccessibilityExtraKeys$ui_release() {
        return this._accessibilityExtraKeys;
    }

    public final <T> T getOrElse(SemanticsPropertyKey<T> key, S7.a defaultValue) {
        T t9 = (T) this.props.get(key);
        return t9 == null ? (T) defaultValue.invoke() : t9;
    }

    public final <T> T getOrElseNullable(SemanticsPropertyKey<T> key, S7.a defaultValue) {
        T t9 = (T) this.props.get(key);
        return t9 == null ? (T) defaultValue.invoke() : t9;
    }

    public final MutableScatterMap<SemanticsPropertyKey<?>, Object> getProps$ui_release() {
        return this.props;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isClearingSemantics) + androidx.appfunctions.metadata.a.d(this.props.hashCode() * 31, 31, this.isMergingSemanticsOfDescendants);
    }

    /* renamed from: isClearingSemantics, reason: from getter */
    public final boolean getIsClearingSemantics() {
        return this.isClearingSemantics;
    }

    /* renamed from: isMergingSemanticsOfDescendants, reason: from getter */
    public final boolean getIsMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        Map<SemanticsPropertyKey<?>, ? extends Object> mapAsMap = this.mapWrapper;
        if (mapAsMap == null) {
            mapAsMap = this.props.asMap();
            this.mapWrapper = mapAsMap;
        }
        return mapAsMap.entrySet().iterator();
    }

    public final void mergeChild$ui_release(SemanticsConfiguration child) {
        MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap = child.props;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        Object obj2 = objArr2[i11];
                        SemanticsPropertyKey<?> semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        Object obj3 = this.props.get(semanticsPropertyKey);
                        k.d(semanticsPropertyKey, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                        Object objMerge = semanticsPropertyKey.merge(obj3, obj2);
                        if (objMerge != null) {
                            this.props.set(semanticsPropertyKey, objMerge);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public <T> void set(SemanticsPropertyKey<T> key, T value) {
        if ((value instanceof AccessibilityAction) && contains(key)) {
            Object obj = this.props.get(key);
            k.d(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
            MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap = this.props;
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) value;
            String label = accessibilityAction2.getLabel();
            if (label == null) {
                label = accessibilityAction.getLabel();
            }
            d action = accessibilityAction2.getAction();
            if (action == null) {
                action = accessibilityAction.getAction();
            }
            mutableScatterMap.set(key, new AccessibilityAction(label, action));
        } else {
            this.props.set(key, value);
        }
        if (key.getAccessibilityExtraKey() != null) {
            if (this._accessibilityExtraKeys == null) {
                this._accessibilityExtraKeys = ScatterSetKt.mutableScatterSetOf();
            }
            MutableScatterSet<SemanticsPropertyKey<?>> mutableScatterSet = this._accessibilityExtraKeys;
            if (mutableScatterSet != null) {
                mutableScatterSet.add(key);
            }
        }
    }

    public final void setClearingSemantics(boolean z10) {
        this.isClearingSemantics = z10;
    }

    public final void setMergingSemanticsOfDescendants(boolean z10) {
        this.isMergingSemanticsOfDescendants = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0079 A[PHI: r2
      0x0079: PHI (r2v6 java.lang.String) = (r2v5 java.lang.String), (r2v7 java.lang.String) binds: [B:13:0x0040, B:20:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r19 = this;
            r0 = r19
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = r0.isMergingSemanticsOfDescendants
            java.lang.String r3 = ", "
            if (r2 == 0) goto L14
            java.lang.String r2 = "mergeDescendants=true"
            r1.append(r2)
            r2 = r3
            goto L16
        L14:
            java.lang.String r2 = ""
        L16:
            boolean r4 = r0.isClearingSemantics
            if (r4 == 0) goto L23
            r1.append(r2)
            java.lang.String r2 = "isClearingSemantics=true"
            r1.append(r2)
            r2 = r3
        L23:
            androidx.collection.MutableScatterMap<androidx.compose.ui.semantics.SemanticsPropertyKey<?>, java.lang.Object> r4 = r0.props
            java.lang.Object[] r5 = r4.keys
            java.lang.Object[] r6 = r4.values
            long[] r4 = r4.metadata
            int r7 = r4.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L7e
            r8 = 0
            r9 = r8
        L32:
            r10 = r4[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L79
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = r8
        L4c:
            if (r14 >= r12) goto L77
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L73
            int r15 = r9 << 3
            int r15 = r15 + r14
            r16 = r5[r15]
            r15 = r6[r15]
            androidx.compose.ui.semantics.SemanticsPropertyKey r16 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r16
            r1.append(r2)
            java.lang.String r2 = r16.getName()
            r1.append(r2)
            java.lang.String r2 = " : "
            r1.append(r2)
            r1.append(r15)
            r2 = r3
        L73:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L4c
        L77:
            if (r12 != r13) goto L7e
        L79:
            if (r9 == r7) goto L7e
            int r9 = r9 + 1
            goto L32
        L7e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            java.lang.String r0 = androidx.compose.ui.platform.JvmActuals_jvmKt.simpleIdentityToString(r0, r3)
            r2.append(r0)
            java.lang.String r0 = "{ "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = " }"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsConfiguration.toString():java.lang.String");
    }
}
