package com.uxsense.core.base.parse;

import A9.d;
import B9.C0177d;
import B9.d0;
import B9.h0;
import C7.f;
import H4.o;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.a;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0087\b\u0018\u0000 j2\u00020\u0001:\u0002kjB×\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cBÇ\u0001\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001b\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"J'\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100#¢\u0006\u0004\b%\u0010&J#\u0010'\u001a\u0004\u0018\u00010\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100#¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b/\u0010\"J\u0012\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b0\u0010\"J\u0012\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b3\u0010\"J\u0012\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b4\u0010\"J\u0012\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b5\u0010\"J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eHÆ\u0003¢\u0006\u0004\b6\u0010*J\u0010\u00107\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b9\u00108J\u0010\u0010:\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b:\u00108J\u0010\u0010;\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b;\u00108J\u0010\u0010<\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b<\u00108J\u0010\u0010=\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b=\u00108J\u0010\u0010>\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b>\u00108J\u0010\u0010?\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b?\u0010,J\u0010\u0010@\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b@\u0010,J\u0010\u0010A\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\bA\u0010,Jà\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bD\u0010,J\u001a\u0010F\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bF\u0010GJ'\u0010P\u001a\u00020M2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010J\u001a\u00020I2\u0006\u0010L\u001a\u00020KH\u0001¢\u0006\u0004\bN\u0010OR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010Q\u001a\u0004\bR\u0010,R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010S\u001a\u0004\bT\u0010.R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010U\u001a\u0004\bV\u0010\"R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010U\u001a\u0004\bW\u0010\"R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010X\u001a\u0004\bY\u00102R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010U\u001a\u0004\bZ\u0010\"R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010U\u001a\u0004\b[\u0010\"R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010U\u001a\u0004\b\\\u0010\"R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010]\u001a\u0004\b^\u0010*R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010_\u001a\u0004\b`\u00108R\u0017\u0010\u0012\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010_\u001a\u0004\ba\u00108R\u0017\u0010\u0013\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010_\u001a\u0004\bb\u00108R\u0017\u0010\u0014\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0014\u0010_\u001a\u0004\bc\u00108R\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u0010_\u001a\u0004\bd\u00108R\u0017\u0010\u0016\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0016\u0010_\u001a\u0004\be\u00108R\u0017\u0010\u0017\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0017\u0010_\u001a\u0004\bf\u00108R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010Q\u001a\u0004\bg\u0010,R\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010Q\u001a\u0004\bh\u0010,R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010Q\u001a\u0004\bi\u0010,¨\u0006l"}, d2 = {"Lcom/uxsense/core/base/parse/KViewNode;", "", "", "index", "", "nodeId", "", "className", "viewId", "Lcom/uxsense/core/base/parse/KRect;", "bounds", "description", "text", "hint", "", "children", "", "clickable", "longClickable", "touchable", "horizontalScrollable", "verticalScrollable", "checkable", "checked", "progress", "progressMax", "progressMin", AppAgent.CONSTRUCT, "(IJLjava/lang/String;Ljava/lang/String;Lcom/uxsense/core/base/parse/KRect;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZZZZZIII)V", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IIJLjava/lang/String;Ljava/lang/String;Lcom/uxsense/core/base/parse/KRect;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZZZZZIIILB9/d0;)V", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "predicate", "findAll", "(LS7/k;)Ljava/util/List;", "findFirst", "(LS7/k;)Lcom/uxsense/core/base/parse/KViewNode;", "flatten", "()Ljava/util/List;", "component1", "()I", "component2", "()J", "component3", "component4", "component5", "()Lcom/uxsense/core/base/parse/KRect;", "component6", "component7", "component8", "component9", "component10", "()Z", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(IJLjava/lang/String;Ljava/lang/String;Lcom/uxsense/core/base/parse/KRect;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZZZZZIII)Lcom/uxsense/core/base/parse/KViewNode;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/core/base/parse/KViewNode;LA9/d;Lz9/g;)V", "write$Self", "I", "getIndex", "J", "getNodeId", "Ljava/lang/String;", "getClassName", "getViewId", "Lcom/uxsense/core/base/parse/KRect;", "getBounds", "getDescription", "getText", "getHint", "Ljava/util/List;", "getChildren", "Z", "getClickable", "getLongClickable", "getTouchable", "getHorizontalScrollable", "getVerticalScrollable", "getCheckable", "getChecked", "getProgress", "getProgressMax", "getProgressMin", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class KViewNode {
    private final KRect bounds;
    private final boolean checkable;
    private final boolean checked;
    private final List<KViewNode> children;
    private final String className;
    private final boolean clickable;
    private final String description;
    private final String hint;
    private final boolean horizontalScrollable;
    private final int index;
    private final boolean longClickable;
    private final long nodeId;
    private final int progress;
    private final int progressMax;
    private final int progressMin;
    private final String text;
    private final boolean touchable;
    private final boolean verticalScrollable;
    private final String viewId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final f[] $childSerializers = {null, null, null, null, null, null, null, null, a.b(LazyThreadSafetyMode.b, new Ba.a(28)), null, null, null, null, null, null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/core/base/parse/KViewNode$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/core/base/parse/KViewNode;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return KViewNode$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    public KViewNode() {
        this(0, 0L, (String) null, (String) null, (KRect) null, (String) null, (String) null, (String) null, (List) null, false, false, false, false, false, false, false, 0, 0, 0, 524287, (e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return new C0177d(KViewNode$$serializer.INSTANCE);
    }

    public static /* synthetic */ KViewNode copy$default(KViewNode kViewNode, int i, long j5, String str, String str2, KRect kRect, String str3, String str4, String str5, List list, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i6, int i10, int i11, int i12, Object obj) {
        int i13;
        int i14;
        int i15 = (i12 & 1) != 0 ? kViewNode.index : i;
        long j6 = (i12 & 2) != 0 ? kViewNode.nodeId : j5;
        String str6 = (i12 & 4) != 0 ? kViewNode.className : str;
        String str7 = (i12 & 8) != 0 ? kViewNode.viewId : str2;
        KRect kRect2 = (i12 & 16) != 0 ? kViewNode.bounds : kRect;
        String str8 = (i12 & 32) != 0 ? kViewNode.description : str3;
        String str9 = (i12 & 64) != 0 ? kViewNode.text : str4;
        String str10 = (i12 & 128) != 0 ? kViewNode.hint : str5;
        List list2 = (i12 & 256) != 0 ? kViewNode.children : list;
        boolean z17 = (i12 & 512) != 0 ? kViewNode.clickable : z10;
        boolean z18 = (i12 & 1024) != 0 ? kViewNode.longClickable : z11;
        boolean z19 = (i12 & 2048) != 0 ? kViewNode.touchable : z12;
        boolean z20 = (i12 & 4096) != 0 ? kViewNode.horizontalScrollable : z13;
        int i16 = i15;
        boolean z21 = (i12 & 8192) != 0 ? kViewNode.verticalScrollable : z14;
        boolean z22 = (i12 & 16384) != 0 ? kViewNode.checkable : z15;
        boolean z23 = (i12 & 32768) != 0 ? kViewNode.checked : z16;
        int i17 = (i12 & 65536) != 0 ? kViewNode.progress : i6;
        int i18 = (i12 & 131072) != 0 ? kViewNode.progressMax : i10;
        if ((i12 & 262144) != 0) {
            i14 = i18;
            i13 = kViewNode.progressMin;
        } else {
            i13 = i11;
            i14 = i18;
        }
        return kViewNode.copy(i16, j6, str6, str7, kRect2, str8, str9, str10, list2, z17, z18, z19, z20, z21, z22, z23, i17, i14, i13);
    }

    public static final void write$Self$uxsense_release(KViewNode self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.index != 0) {
            output.encodeIntElement(serialDesc, 0, self.index);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.nodeId != 0) {
            output.encodeLongElement(serialDesc, 1, self.nodeId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.className != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, h0.f242a, self.className);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.viewId != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, h0.f242a, self.viewId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.bounds != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, KRect$$serializer.INSTANCE, self.bounds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.description != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, h0.f242a, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.text != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, h0.f242a, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.hint != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, h0.f242a, self.hint);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !k.b(self.children, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 8, (x9.f) fVarArr[8].getF4884a(), self.children);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.clickable) {
            output.encodeBooleanElement(serialDesc, 9, self.clickable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.longClickable) {
            output.encodeBooleanElement(serialDesc, 10, self.longClickable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.touchable) {
            output.encodeBooleanElement(serialDesc, 11, self.touchable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.horizontalScrollable) {
            output.encodeBooleanElement(serialDesc, 12, self.horizontalScrollable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.verticalScrollable) {
            output.encodeBooleanElement(serialDesc, 13, self.verticalScrollable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.checkable) {
            output.encodeBooleanElement(serialDesc, 14, self.checkable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.checked) {
            output.encodeBooleanElement(serialDesc, 15, self.checked);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.progress != 0) {
            output.encodeIntElement(serialDesc, 16, self.progress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.progressMax != 0) {
            output.encodeIntElement(serialDesc, 17, self.progressMax);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18) && self.progressMin == 0) {
            return;
        }
        output.encodeIntElement(serialDesc, 18, self.progressMin);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getClickable() {
        return this.clickable;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getLongClickable() {
        return this.longClickable;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getTouchable() {
        return this.touchable;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getHorizontalScrollable() {
        return this.horizontalScrollable;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getVerticalScrollable() {
        return this.verticalScrollable;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getCheckable() {
        return this.checkable;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* renamed from: component17, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: component18, reason: from getter */
    public final int getProgressMax() {
        return this.progressMax;
    }

    /* renamed from: component19, reason: from getter */
    public final int getProgressMin() {
        return this.progressMin;
    }

    /* renamed from: component2, reason: from getter */
    public final long getNodeId() {
        return this.nodeId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component4, reason: from getter */
    public final String getViewId() {
        return this.viewId;
    }

    /* renamed from: component5, reason: from getter */
    public final KRect getBounds() {
        return this.bounds;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component8, reason: from getter */
    public final String getHint() {
        return this.hint;
    }

    public final List<KViewNode> component9() {
        return this.children;
    }

    public final KViewNode copy(int index, long nodeId, String className, String viewId, KRect bounds, String description, String text, String hint, List<KViewNode> children, boolean clickable, boolean longClickable, boolean touchable, boolean horizontalScrollable, boolean verticalScrollable, boolean checkable, boolean checked, int progress, int progressMax, int progressMin) {
        k.f(children, "children");
        return new KViewNode(index, nodeId, className, viewId, bounds, description, text, hint, children, clickable, longClickable, touchable, horizontalScrollable, verticalScrollable, checkable, checked, progress, progressMax, progressMin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KViewNode)) {
            return false;
        }
        KViewNode kViewNode = (KViewNode) other;
        return this.index == kViewNode.index && this.nodeId == kViewNode.nodeId && k.b(this.className, kViewNode.className) && k.b(this.viewId, kViewNode.viewId) && k.b(this.bounds, kViewNode.bounds) && k.b(this.description, kViewNode.description) && k.b(this.text, kViewNode.text) && k.b(this.hint, kViewNode.hint) && k.b(this.children, kViewNode.children) && this.clickable == kViewNode.clickable && this.longClickable == kViewNode.longClickable && this.touchable == kViewNode.touchable && this.horizontalScrollable == kViewNode.horizontalScrollable && this.verticalScrollable == kViewNode.verticalScrollable && this.checkable == kViewNode.checkable && this.checked == kViewNode.checked && this.progress == kViewNode.progress && this.progressMax == kViewNode.progressMax && this.progressMin == kViewNode.progressMin;
    }

    public final List<KViewNode> findAll(S7.k predicate) {
        k.f(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        if (((Boolean) predicate.invoke(this)).booleanValue()) {
            arrayList.add(this);
        }
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((KViewNode) it.next()).findAll(predicate));
        }
        return arrayList;
    }

    public final KViewNode findFirst(S7.k predicate) {
        k.f(predicate, "predicate");
        if (((Boolean) predicate.invoke(this)).booleanValue()) {
            return this;
        }
        Iterator<KViewNode> it = this.children.iterator();
        while (it.hasNext()) {
            KViewNode kViewNodeFindFirst = it.next().findFirst(predicate);
            if (kViewNodeFindFirst != null) {
                return kViewNodeFindFirst;
            }
        }
        return null;
    }

    public final List<KViewNode> flatten() {
        ArrayList arrayListQ = o.Q(this);
        Iterator<T> it = this.children.iterator();
        while (it.hasNext()) {
            arrayListQ.addAll(((KViewNode) it.next()).flatten());
        }
        return arrayListQ;
    }

    public final KRect getBounds() {
        return this.bounds;
    }

    public final boolean getCheckable() {
        return this.checkable;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final List<KViewNode> getChildren() {
        return this.children;
    }

    public final String getClassName() {
        return this.className;
    }

    public final boolean getClickable() {
        return this.clickable;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHint() {
        return this.hint;
    }

    public final boolean getHorizontalScrollable() {
        return this.horizontalScrollable;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean getLongClickable() {
        return this.longClickable;
    }

    public final long getNodeId() {
        return this.nodeId;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getProgressMax() {
        return this.progressMax;
    }

    public final int getProgressMin() {
        return this.progressMin;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean getTouchable() {
        return this.touchable;
    }

    public final boolean getVerticalScrollable() {
        return this.verticalScrollable;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c(Integer.hashCode(this.index) * 31, 31, this.nodeId);
        String str = this.className;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.viewId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        KRect kRect = this.bounds;
        int iHashCode3 = (iHashCode2 + (kRect == null ? 0 : kRect.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.text;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.hint;
        return Integer.hashCode(this.progressMin) + androidx.constraintlayout.core.dsl.a.a(this.progressMax, androidx.constraintlayout.core.dsl.a.a(this.progress, androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.e(this.children, (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31, 31), 31, this.clickable), 31, this.longClickable), 31, this.touchable), 31, this.horizontalScrollable), 31, this.verticalScrollable), 31, this.checkable), 31, this.checked), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KVNode:{");
        sb.append(this.className);
        sb.append(", ");
        sb.append(this.description);
        sb.append(", ");
        return B7.a.g('}', this.text, sb);
    }

    public KViewNode(int i, int i6, long j5, String str, String str2, KRect kRect, String str3, String str4, String str5, List list, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i10, int i11, int i12, d0 d0Var) {
        if ((i & 1) == 0) {
            this.index = 0;
        } else {
            this.index = i6;
        }
        if ((i & 2) == 0) {
            this.nodeId = 0L;
        } else {
            this.nodeId = j5;
        }
        if ((i & 4) == 0) {
            this.className = null;
        } else {
            this.className = str;
        }
        if ((i & 8) == 0) {
            this.viewId = null;
        } else {
            this.viewId = str2;
        }
        if ((i & 16) == 0) {
            this.bounds = null;
        } else {
            this.bounds = kRect;
        }
        if ((i & 32) == 0) {
            this.description = null;
        } else {
            this.description = str3;
        }
        if ((i & 64) == 0) {
            this.text = null;
        } else {
            this.text = str4;
        }
        if ((i & 128) == 0) {
            this.hint = null;
        } else {
            this.hint = str5;
        }
        if ((i & 256) == 0) {
            this.children = EmptyList.f4893a;
        } else {
            this.children = list;
        }
        if ((i & 512) == 0) {
            this.clickable = false;
        } else {
            this.clickable = z10;
        }
        if ((i & 1024) == 0) {
            this.longClickable = false;
        } else {
            this.longClickable = z11;
        }
        if ((i & 2048) == 0) {
            this.touchable = false;
        } else {
            this.touchable = z12;
        }
        if ((i & 4096) == 0) {
            this.horizontalScrollable = false;
        } else {
            this.horizontalScrollable = z13;
        }
        if ((i & 8192) == 0) {
            this.verticalScrollable = false;
        } else {
            this.verticalScrollable = z14;
        }
        if ((i & 16384) == 0) {
            this.checkable = false;
        } else {
            this.checkable = z15;
        }
        if ((32768 & i) == 0) {
            this.checked = false;
        } else {
            this.checked = z16;
        }
        if ((65536 & i) == 0) {
            this.progress = 0;
        } else {
            this.progress = i10;
        }
        if ((131072 & i) == 0) {
            this.progressMax = 0;
        } else {
            this.progressMax = i11;
        }
        if ((i & 262144) == 0) {
            this.progressMin = 0;
        } else {
            this.progressMin = i12;
        }
    }

    public KViewNode(int i, long j5, String str, String str2, KRect kRect, String str3, String str4, String str5, List<KViewNode> children, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i6, int i10, int i11) {
        k.f(children, "children");
        this.index = i;
        this.nodeId = j5;
        this.className = str;
        this.viewId = str2;
        this.bounds = kRect;
        this.description = str3;
        this.text = str4;
        this.hint = str5;
        this.children = children;
        this.clickable = z10;
        this.longClickable = z11;
        this.touchable = z12;
        this.horizontalScrollable = z13;
        this.verticalScrollable = z14;
        this.checkable = z15;
        this.checked = z16;
        this.progress = i6;
        this.progressMax = i10;
        this.progressMin = i11;
    }

    public KViewNode(int i, long j5, String str, String str2, KRect kRect, String str3, String str4, String str5, List list, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, int i6, int i10, int i11, int i12, e eVar) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0L : j5, (i12 & 4) != 0 ? null : str, (i12 & 8) != 0 ? null : str2, (i12 & 16) != 0 ? null : kRect, (i12 & 32) != 0 ? null : str3, (i12 & 64) != 0 ? null : str4, (i12 & 128) == 0 ? str5 : null, (i12 & 256) != 0 ? EmptyList.f4893a : list, (i12 & 512) != 0 ? false : z10, (i12 & 1024) != 0 ? false : z11, (i12 & 2048) != 0 ? false : z12, (i12 & 4096) != 0 ? false : z13, (i12 & 8192) != 0 ? false : z14, (i12 & 16384) != 0 ? false : z15, (i12 & 32768) != 0 ? false : z16, (i12 & 65536) != 0 ? 0 : i6, (i12 & 131072) != 0 ? 0 : i10, (i12 & 262144) != 0 ? 0 : i11);
    }
}
